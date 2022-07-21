package modules;

public class Match {
    Team teamA;
    Team teamB;
    String score;
    public Match(String teamAname, String teamBname) {
        teamA = new Team(teamAname);
        teamB = new Team(teamBname);
        score = Integer.toString(teamA.getGoals()) + " - " + Integer.toString(teamB.getGoals());
    }

    public void updateScore(String team) {
        score = Integer.toString(teamA.getGoals()) + " - " + Integer.toString(teamB.getGoals());
    }



}
