package logic;

import data.NationalTeam;

public class Player {

    private String  name;
    private Integer pointsOfPower;
    private Integer pointsOfProtection;
    private Integer energy;
    private Integer numOfGames;
    private Integer numOfWins;
    private NationalTeam nationalTeam;
    private Integer money;
    private Team team;  //чтобы оставить переопределение в матчах
    private PlayerMatch result;
    private PlayerMarket market;

    public Player(){
        name = "defoltPlayer";
        pointsOfPower = 23;
        pointsOfProtection = 23;
        energy = 100;
        numOfGames = 0;
        numOfWins = 0;
        nationalTeam = new NationalTeam();
        money = 0;
    }

    public void setTeam(Team t){
        //чтобы оставить переопределение в матчах
       team = t;
    }

    public void askForTransfer() {
        //сам генерит команду в предложку и меняет ???поле команда???
        team = new Team();
        setTeam(team);
    }

    public void train() {
    //добавляет Павер снижает энергию
        pointsOfPower+=5;
        energy -=5;
    }

    public void rest() {
        //увеличивает энергию
        energy +=10;
    }

    public boolean playMatch() {
        //вызывает PlayerMatch.getResult(team)
       if (energy >=50) {
           numOfGames++;
           team.setAveragePlayer(this);
           energy-= 50;
           if(result.getResult(team)) {money+=1000; numOfWins++;}
           return result.getResult(team);
       }
       else return false;
    }

    public int finishCareer(){
        //выводит бюджет ...
        return money;
    }

    public void  changeNationalTeam(){
        //меняет сборную если очков хватает и добавляет н к атаке
        NationalTeam newNationalTeam = new NationalTeam();
        if (this.pointsOfPower >= newNationalTeam.pointsToJoin) {
            this.nationalTeam = newNationalTeam;
            this.pointsOfPower += newNationalTeam.powerPoints;
        }

    }

    public void distributePoints(int p1, int p2){
       if (p1 != 0)
        pointsOfPower = p1;
       if (p2!=0)
        pointsOfProtection = p2;
    }


    public void setNumOfGames(Integer numOfGames) {
        this.numOfGames = numOfGames;
    }

    public Integer getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfWins(Integer numOfWins) {
        this.numOfWins = numOfWins;
    }

    public Integer getNumOfWins() {
        return numOfWins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPointsOfPower(Integer pointsOfPower) {
        this.pointsOfPower = pointsOfPower;
    }

    public void setPointsOfProtection(Integer pointsOfProtection) {
        this.pointsOfProtection = pointsOfProtection;
    }

    public Integer getPointsOfPower() {
        return pointsOfPower;
    }

    public Integer getPointsOfProtection() {
        return pointsOfProtection;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Team getTeam() {
        return team;
    }

    public void setResult(PlayerMatch result) {
        this.result = result;
    }

    public void setMarket(PlayerMarket market) {
        this.market = market;
    }

}


