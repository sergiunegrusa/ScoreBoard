package modules;

import java.util.*;
import java.util.List;

public class ScoreBoard {
    public List<Match> matchList = new ArrayList<Match>();

    public ScoreBoard() {
        matchList = addToMatchList();
        Team teamA = matchList.get(0).getTeamA();
        Team teamB = matchList.get(0).getTeamB();
        matchList.get(0).playMatch(teamA, teamB);
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public List<Match> addToMatchList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce first team: ");
        String teamA = sc.next();
        System.out.println("Introduce second team: ");
        String teamB = sc.next();
        Match match = new Match(teamA, teamB);
        System.out.println(match);
        matchList.add(match);
        return matchList;
    }
}
