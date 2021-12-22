package be.technifutur.laboJava.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        decouverteMenuDynamique();
    }

    private static void decouverteMenuDynamique() throws Exception {
        //création menu
        MenuFactory factory = new MenuFactory();
        List<String> listItem = new ArrayList<>();
        ActionProvider provider = new MyProvider();
        MenuModelDynamic model = new MenuModelDynamic(listItem, provider, "Menu Dynamique");
        MenuControler menu = factory.createMenu(model);

        //ajout d'items au menu
        listItem.add("retour");
        listItem.add("item 1");
        // test
        Callable action = menu.getAction();
        int cpt = 1;
        while(action != null){
            action.call();
            cpt++;
            listItem.add("item "+ cpt);
            action = menu.getAction();
        }
    }
}

class MyProvider implements ActionProvider {

    @Override
    public Callable getAction(String name) {
        Callable c = null;
        if (!"retour".equalsIgnoreCase(name)) {
            c = new MyCallableWithName(name);
        }
        return c;
    }
}

class MyCallableWithName implements Callable {

    private String name;

    public MyCallableWithName(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(" vous avez sélectionné : " + name);
        return null;
    }
}
