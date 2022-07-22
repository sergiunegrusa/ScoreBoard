package modules;
import java.util.*;
import java.util.Objects;

public class Match {
    public Team teamA;
    public Team teamB;
    public String score;
    public ReadData data;

    public void playMatch(Team teamA, Team teamB) {
        long start = System.currentTimeMillis();
        long end = start + 60*1000; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end)
        {
            // run
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose team to score");
            String name = sc.next();
            if (Objects.equals(teamA.getName(), name)) {
                teamA.Score();
                updateScore(teamA.getName());
            }
            if (Objects.equals(teamB.getName(), name)) {
                teamB.Score();
                updateScore(teamB.getName());
            }
            System.out.println(score);
            int time = (int) (end - System.currentTimeMillis());
            System.out.println("time left: " + Integer.toString(time/1000));
        }
    }

    public Match(String teamAname, String teamBname) {
        setTeamA(new Team(teamAname));
        setTeamB(new Team(teamBname));
        score = teamA.getName() + " " + Integer.toString(teamA.getGoals()) + " - " + Integer.toString(teamB.getGoals()) + " " + teamB.getName();
        System.out.println(score);
    }


    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public String getScore() {
        return score;
    }
    public void updateScore(String team) {
        score = teamA.getName() + " " + Integer.toString(teamA.getGoals()) + " - " + Integer.toString(teamB.getGoals()) + " " + teamB.getName();
    }
}
