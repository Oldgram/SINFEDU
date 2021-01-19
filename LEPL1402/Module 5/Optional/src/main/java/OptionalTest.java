import java.util.Optional;

public class OptionalTest {

    /**
     * Returns an Optional<TeamLeader> object from teamLeader
     */
    public Optional<TeamLeader> createOptionalTeamLeader(TeamLeader teamLeader) {
        return Optional.ofNullable(teamLeader);
    }

    /**
     * Increments the age of teamLeader by one
     */
    public void incAge(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.ifPresent(teamLeader -> teamLeader.setAge(teamLeader.getAge() + 1));
    }

    /**
     * Increments the age of teamLeader by one only if its age is > 15
     */
    public void incAgeIfMoreThanFifteen(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.filter(teamLeader -> teamLeader.getAge() > 15).ifPresent(teamLeader -> incAge(optionalTeamLeader));
    }

    /**
     * Returns the name of the teamLeader or "No team leader"
     */
    public String getName(Optional<TeamLeader> optionalTeamLeader) {
        // Using ternary operator :
        // return (optionalTeamLeader.isPresent() ? optionalTeamLeader.get().getName() : "No team leader");
        //  Using map :
        return optionalTeamLeader.map(TeamLeader::getName).orElse("No team leader");
    }

    /**
     * Returns the name of the teamLeader of the team of the person or "No team leader"
     */
    public String getNameOfTeamLeader(Optional<Person> optionalPerson) {
        // Using ternary operator :
        // return (optionalPerson.isPresent() ? optionalPerson.get().getTeam().isPresent() ? getName(optionalPerson.get().getTeam().get().teamLeader) : "No team leader" : "No team leader");
        // Using map and flatMap :
        return optionalPerson.flatMap(Person::getTeam).flatMap(Team::getTeamLeader).map(TeamLeader::getName).orElse("No team leader");
    }
}
