package rpg;
public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player, GameContext context) {
        System.out.println("你往 " + direction + " 方向移動了！");
    }
}
