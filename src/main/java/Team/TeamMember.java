package Team;

public class TeamMember {
    private String name;
    private RoleEnum role;

    public TeamMember(String name, RoleEnum role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public RoleEnum getRole() {
        return role;
    }
}
