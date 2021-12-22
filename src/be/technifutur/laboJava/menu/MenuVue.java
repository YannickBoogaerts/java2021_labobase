package be.technifutur.laboJava.menu;


import java.util.Scanner;

public class MenuVue {

    private Scanner input =  new Scanner(System.in);
    private String error = null;

    public void setError(String message){
        this.error = message;
    }

    public String saisirMenu(MenuModel model ){

        String choix;


        String nameMenu = model.getName();
        System.out.println(nameMenu);
        System.out.println("-".repeat(nameMenu.length()));

        for(int i =0; i < model.size(); i++){
            String name = model.getNodeName(i);
            System.out.printf("(%2d) %s%n", i+1 , name);
        }

        if(this.error != null){
            System.out.printf("Erreur : %s%n",error);
        }
        System.out.print("choix : ");
        choix = input.nextLine();

        return choix;
    }
}
