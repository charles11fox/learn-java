package rpg;

public class UsePotionCommand implements Command {
    @Override
    public void execute(Player p, GameContext c) {
        Room room = c.getCurrentRoom();
        if (room.hasPotion()) {
            p.heal(30); // 恢復 30 點 HP
            room.removePotion();
            System.out.println("你使用了藥水，恢復了 30 點生命。當前 HP：" + p.getHp());
        } else {
            System.out.println("這裡沒有藥水可用。");
        }
    }
}
