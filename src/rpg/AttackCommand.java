package rpg;

public class AttackCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room current = c.getCurrentRoom();
        Monster monster = current.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以攻擊的怪物。");
            return;
        }

        // 玩家攻擊怪物
        monster.takeDamage(p.getAttack());
        System.out.println("你攻擊了 " + monster.getName() + "，造成 " + p.getAttack() + " 點傷害！");

        // 檢查怪物是否死亡
        if (!monster.isAlive()) {
            System.out.println(monster.getName() + " 被擊敗了！");
            return;
        }

        // 怪物反擊
        p.takeDamage(monster.getAttack());
        System.out.println(monster.getName() + " 反擊了你，造成 " + monster.getAttack() + " 點傷害！");
        System.out.println("你的剩餘 HP：" + p.getHp());

        // 玩家死亡會在 GameEngine 的 while 判斷中處理
    }
}
