package rpg;

public class FireballSkill implements Skill {

    @Override
    public String getName() {
        return "fireball";
    }

    @Override
    public void use(Player p, Monster m) {
        // 若沒有怪物或怪物已經死亡，就不能使用技能
        if (m == null || !m.isAlive()) {
            System.out.println("這裡沒有活著的怪物可以攻擊。");
            return;
        }

        // 技能造成的傷害（你可以未來做成等級、機率等機制）
        int fireballDamage = 25;

        // 對怪物造成傷害
        m.takeDamage(fireballDamage);

        // 記錄玩家總輸出
        p.addDamage(fireballDamage);

        System.out.println("你施放了火球術，造成 " + fireballDamage + " 點傷害！");
        System.out.println("怪物 " + m.getName() + " 剩餘 HP：" + m.getHp());

        // 如果怪物死了，加 kill count
        if (!m.isAlive()) {
            System.out.println("你擊敗了怪物 " + m.getName() + "！");
            p.addKill();
        }
    }
}
