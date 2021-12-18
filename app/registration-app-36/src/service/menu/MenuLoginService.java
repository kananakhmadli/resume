package service.menu;

import bean.Config;
import java.util.Scanner;
import service.inter.menu.MenuLoginServiceInter;

public class MenuLoginService implements MenuLoginServiceInter {

    @Override
    public void processLogic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("username:");
        String username = sc.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("password:");
        String password = sc2.nextLine();
        if (!(username.equals("user") && password.equals("11111"))) {
            throw new IllegalArgumentException("username or password i wrong");

        }
        Config.setLoggedIn(true);

    }

}
