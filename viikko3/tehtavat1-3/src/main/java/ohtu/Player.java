
package ohtu;

public class Player {
    private String name;
    private int goals;
    private int assists;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
