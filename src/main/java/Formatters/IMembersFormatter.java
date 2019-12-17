package Formatters;

import Team.TeamMember;

import java.util.List;

//THE FORMATTER INTERFACE & IMPLEMENTATION
// Created to create a compliant-SRP solution
// SRP = Single Responsibility Principle
public interface IMembersFormatter {

    //Parse a formatted string of team members
    // returns list of members from the formatted value
    //example : "Rida:backend,Ahmed:frontend"
    public List<TeamMember> parse(String formattedDevs);

    //Format a string value from list of team members
    //example of expected result : "backend:Rida,frontend:Ahmed,tester:Nora"
    public String format(List<TeamMember> members);

    //Format a string value from one team member arg
    //example of expected restult "tester:Nora"
    public String format(TeamMember members);
}
