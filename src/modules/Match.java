package modules;
import java.io.File;
import java.util.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Match {
    public Team teamA;
    public Team teamB;
    public String score;
    public File file;
    public ReadData readData;

    public void playMatch(File file) {
        long start = System.currentTimeMillis();
        long end = start + 60*1000; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end)
        {
            int time = (int) (end - System.currentTimeMillis());
            HashMap<Integer, HashMap<Integer, Integer>> scoring = readData.getScoringChart();
//            System.out.println(scoring);
            for (int i = scoring.size(); i >= 1; i--){
                HashMap<Integer, Integer> summary = scoring.get(i);
                if (summary.get(1) != null) {
//                    System.out.println(time/1000);
//                    System.out.println(summary.get(1));
                    if (time/1000 - summary.get(1) == 0) {
                        teamA.Score();
                        updateScore(teamA.getName());
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("time left: " + Integer.toString(time/1000));
                    }
                } else if (summary.get(2) != null) {
                    if (time/1000 - summary.get(2) == 0) {
                        teamB.Score();
                        updateScore(teamB.getName());
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("time left: " + Integer.toString(time/1000));
                    }
                }
//                System.out.println(summary.get(0));
            }
            // run
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Choose team to score");
//            String name = sc.next();
//            if (Objects.equals(teamA.getName(), name)) {
//
//            }
//            if (Objects.equals(teamB.getName(), name)) {
//
//            }
//            System.out.println(score);


        }
    }

    public Match(File file) {

        setData(file);
        ReadData data = getReadData();
        setTeamA(new Team(data.getTeamAname()));
        setTeamB(new Team(data.getTeamBname()));
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
        System.out.println(score);
    }

    public void setData(File file) {
        this.readData = new ReadData(file);
    }

    public ReadData getReadData() {
        return readData;
    }
}
