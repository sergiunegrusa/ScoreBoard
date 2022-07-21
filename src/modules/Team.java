package modules;

class Team {
    public String name;
    public int goals;

    public Team(String sname) {
        name = sname;
        goals = 0;
    }

    public int getGoals() {
        return goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void Score() {
        goals++;
    }
}