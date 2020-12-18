package logic;

import data.NationalTeam;

import java.util.List;

public class PlayerMarket {

    private List<NationalTeam> nationalTeam;

    public int addNationalTeam(NationalTeam nationalTeam) {
       //возвращает добавочные очкиСилы, будем считать*
        return nationalTeam.powerPoints;
    }

    public void setNationalTeam(List<NationalTeam> nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public List<NationalTeam> getNationalTeam() {
        return nationalTeam;
    }
}
