package logic;

import data.VolleyballPlayer;

import java.util.*;

public class Manager {

    private Integer budget;
    private Integer numOfGames;
    private Integer numOfWins;
    public Team team;
    public ManagerMatch result;
    public Market market;

    public Manager(){
        budget = 10000;
        numOfGames = 0;
        numOfWins = 0;
        team = new Team();
        market = new Market();
    }

    public void buyPlayer(VolleyballPlayer player) {
        //вызывает метод из рынка, сам используется в команде при добавлении
    budget-=market.buyPlayer(player);
    team.addPlayer(player);
    }

    public List <VolleyballPlayer> viewTeam() {
    //вызывает получить игроков из команды
        return team.getCurrentCast();
    }

    public VolleyballPlayer getPlayerByName(String name){
        List<VolleyballPlayer> temp = this.viewTeam();
        for (int i =0; i < this.viewTeam().size(); i++)
            if (temp.get(i).name ==name)
        return temp.get(i);
           return temp.get(0);
    }

    public void sellPlayer(String name) {
        //вызывает метод из рынка, сам используется в команде при удалении
        VolleyballPlayer player1 = this.getPlayerByName(name);
        budget+=market.sellPlayer(player1);
        team.delete(player1);
    }

    public void changePlayers(VolleyballPlayer player1, VolleyballPlayer player2){
        team.changeCurrentCast(player1, player2);
        //вызывает Команда.поменятьТекущийСостав
    }

    public boolean playMatch(){
        //вызывает ManagerMatch.getResult
        numOfGames++;
        if(result.getResult(team)) {numOfWins++; budget+=1000;}
    return result.getResult(team);
    }

    public List <Integer> finishCareer(){
        //выводит бюджет ...
        List <Integer> temp = new ArrayList<Integer>();
        temp.add(numOfGames);
        temp.add(numOfWins);
        temp.add(budget);
        return temp;
    }


    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
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
}


