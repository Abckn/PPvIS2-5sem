import logic.Manager;
import logic.ManagerMatch;
import logic.Player;
import logic.Team;
import ui.MainMenu;
import ui.ManagerWidget;
import ui.PlayerWidget;

public class RoleCreator {
//injector main
        public void ManagerCreater(){
            ManagerWidget managerWidget = new ManagerWidget();
            Manager manager = new Manager();
            managerWidget.setCurrManager(manager);
            Team team = new Team();
            ManagerMatch managerMatch = new ManagerMatch();
        }

    public void PlayerCreater(){
            PlayerWidget playerWidget = new PlayerWidget();
        Player player = new Player();
        playerWidget.setCurrPlayer(player);
        ManagerMatch managerMatch = new ManagerMatch();
    }

    public static void main(String[] args){
            RoleCreator roleCreator = new RoleCreator();
            roleCreator.ManagerCreater();
            roleCreator.PlayerCreater();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }


}


