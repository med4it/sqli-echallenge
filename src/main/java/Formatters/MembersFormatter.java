package Formatters;

import Team.BackendDeveloper;
import Team.FrontendDeveloper;
import Team.TeamMember;
import Team.Tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MembersFormatter implements IMembersFormatter {
    private final String BACKEND = "backend";
    private final String FRONTEND = "frontend";
    private final String TESTER = "tester";

    @Override
    public List<TeamMember> parse(String formattedDevs) {
        List<TeamMember> teamMembers = new ArrayList<TeamMember>();

        String[] formattedDevsArray = formattedDevs.split(",");
        List<String> formattedDevsList = Arrays.asList(formattedDevsArray);
        formattedDevsList.forEach(member -> {
            String[] nameThenType = member.split(":");
            switch (nameThenType[1]){
                case BACKEND: teamMembers.add(new BackendDeveloper(nameThenType[0])); break;
                case FRONTEND: teamMembers.add(new FrontendDeveloper(nameThenType[0])); break;
                case TESTER: teamMembers.add(new Tester(nameThenType[0]));
            }
        });

        return teamMembers;
    }

    @Override
    public String format(List<TeamMember> members) {
        return members.stream()
                .map(member -> format(member))
                .collect(Collectors.joining(","));
    }

    @Override
    public String format(TeamMember member) {
        return member.getRole().toString() + ":" + member.getName();
    }
}
