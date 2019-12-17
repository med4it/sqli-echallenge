package Team;

import Formatters.IMembersFormatter;
import Formatters.ITasksFormatter;
import Formatters.MembersFormatter;
import Formatters.TasksFormatter;
import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class DevTeam {
    private List<TeamMember> members;
    private List<Task> tasks;

    private IMembersFormatter membersFormatter;
    private ITasksFormatter tasksFormatter;

    public DevTeam() {
        members = new ArrayList<TeamMember>();
        tasks = new ArrayList<Task>();

        //external compliant-SRP formatter (SINGLE RESPONSIBILITY PRINCIPLE)
        membersFormatter = new MembersFormatter();
        tasksFormatter = new TasksFormatter();
    }

    public DevTeam(String formattedDevs) {
        this();
        this.members = membersFormatter.parse(formattedDevs);
    }

    public void add(String oneFormattedMember) {
        List<TeamMember> result = membersFormatter.parse(oneFormattedMember);
        if (result.isEmpty()) return;
        members.add(result.get(0));
    }

    public String members() {
        return membersFormatter.format(members);
    }

    //Formatted task example : "task:frontend"
    //returns "task assigned" on availability
    //returns "there is no available profile to work on this task"
    //Team can not work on task due to a missing_profile
    public String assignTask(String formattedTask) {
        Task task = tasksFormatter.parse(formattedTask);
        TeamMember toMember = members.stream()
                .filter(member -> member.getRole().toString().equals(task.getRoleType()))
                .findFirst()
                .orElse(null);

        if (toMember == null) return "there is no available profile to work on this task";


        //Check if there is an assigned task to the member
        String memberRole = toMember.getRole().toString();

        Task memberTask = tasks.stream()
                .filter(taskItem -> taskItem.getRoleType().toString().equals(memberRole))
                .findFirst()
                .orElse(null);

        if (memberTask != null) {
            if (memberTask.getState().equals(Task.OPEN) || memberTask.getState().equals(Task.IN_PROGRESS))
                return "there is no available profile to work on this task";
        }

        tasks.add(task);
        return "task assigned";
    }

    //Formatted tasks example : "task1:frontend->open,task2:backend->open"
    public String tasksStatus() {
        return tasksFormatter.format(tasks);
    }

    //A task dispatcher method that updates task state
    public void taskDispatcher(String taskName, String taskState){
        Task taskToStart = tasks.stream()
                .filter(task -> task.getName().equals(taskName))
                .findFirst()
                .orElse(null);

        if (taskToStart != null) taskToStart.updateState(taskState);
    }

    //Start task via task name
    public void startTask(String taskName) {
        taskDispatcher(taskName, Task.IN_PROGRESS);
    }

    //mark task as done via task name
    public void finishTask(String taskName) {
        taskDispatcher(taskName, Task.DONE);
    }
}
