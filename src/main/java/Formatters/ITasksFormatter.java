package Formatters;

import Tasks.Task;

import java.util.List;

//THE FORMATTER INTERFACE & IMPLEMENTATION
// Created to create a compliant-SRP solution
// SRP = Single Responsibility Principle
public interface ITasksFormatter {

    //Parse a formatted task string value
    //return a corresponding task
    //example : "task2:backend"
    public Task parse(String formattedTask);

    //Format list of tasks to a formatted pattern
    //example "task1:frontend->open,task2:backend->open"
    public String format(List<Task> tasks);
}
