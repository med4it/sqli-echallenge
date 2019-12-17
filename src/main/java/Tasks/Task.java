package Tasks;

public class Task {
    public static final String OPEN = "open";
    public static final String IN_PROGRESS = "in progress";
    public static final String DONE = "done";

    private String name;
    private String roleType;
    private String state;

    public Task(String name, String roleType) {
        this.name = name;
        this.roleType = roleType;
        state = OPEN;
    }

    public String getName() {
        return name;
    }

    public String getRoleType() {
        return roleType;
    }

    public String getState() {
        return state;
    }

    public void updateState(String newState) {
        this.state = newState;
    }
}
