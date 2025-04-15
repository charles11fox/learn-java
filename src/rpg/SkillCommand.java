
package rpg;

public class SkillCommand implements Command {
    private String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public void execute(Player player, GameContext context) {
        Skill skill = null;

        // 根據名稱選擇技能（未來可以放到 Map<String, Skill>）
        if (skillName.equals("fireball")) {
            skill = new FireballSkill();
        }

        if (skill != null) {
            skill.use(player, context.getCurrentRoom().getMonster());
        } else {
            System.out.println("未知的技能：" + skillName);
        }
    }
}