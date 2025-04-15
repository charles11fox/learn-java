package rpg;

public class ExitCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        System.out.println("你選擇離開遊戲。");
        // 讓玩家「死亡」以跳出 while 迴圈
        p.takeDamage(p.getHp()); // 把HP歸零
    }
}