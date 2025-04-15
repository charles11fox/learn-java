package rpg;

public class LookCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room current = c.getCurrentRoom();

        System.out.println("你目前在：" + current.getName());
        System.out.println(current.getDescription());

        if (current.getMonster() != null && current.getMonster().isAlive()) {
            System.out.println("你看到一隻怪物：" + current.getMonster().getName() +
                               " (HP: " + current.getMonster().getHp() + ")");
        } else {
            System.out.println("這裡沒有怪物。");
        }

        if (current.hasPotion()) {
            System.out.println("地上有一瓶藥水。");
        }

        System.out.println("出口方向：" + current.getExitString());
    }
}
