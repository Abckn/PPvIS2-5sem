package data;


public class NationalTeam {
    public String name;
    public Integer pointsToJoin;
    public Integer powerPoints;
    public NationalTeam() {
        name = "newNationalTeam";
        pointsToJoin = Math.toIntExact(Math.round(150 * Math.random()));
        powerPoints = Math.toIntExact(Math.round(15 * Math.random()));
    }
}
