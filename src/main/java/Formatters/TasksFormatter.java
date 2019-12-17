package Formatters;

import Tasks.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TasksFormatter implements ITasksFormatter {
    @Override
    //Formatted task example : "task:frontend"
    public Task parse(String formattedTask) {
        String[] taskThenType = formattedTask.split(":");
        return new Task(taskThenType[0], taskThenType[1]);
    }

    @Override
    //Formatted tasks example : "task1:frontend->open,task2:backend->open"
    public String format(List<Task> tasks) {
        return tasks.stream()
                .map(task -> task.getName()+":"+task.getRoleType()+"->"+task.getState())
                .collect(Collectors.joining(","));
    }
}
