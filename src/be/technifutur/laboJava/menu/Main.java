package be.technifutur.laboJava.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        //decouverteMenuDynamique();
        decouverteMenuComposite();
    }

    private static void decouverteMenuDynamique() throws Exception {
        //création menu
        MenuFactory factory = new MenuFactory();
        List<String> listItem = new ArrayList<>();
        MenuModelDynamic model = getDynamicModel(listItem);
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

    private static void decouverteMenuComposite() throws Exception {
        //création menu
        MenuFactory factory = new MenuFactory();

        // création d'un premier model (dynamique)
        List<String> listItem = new ArrayList<>();
        MenuModelDynamic model = getDynamicModel(listItem);

        // création d'un deuxième model (statique)
        MenuModelStatic model2 = new MenuModelStatic("name");
        model2.addNode(factory.createItem("static 1",new MyCallable()));
        model2.addNode(factory.createItem("static 2",new MyCallable()));

        // création d'un model composition des deux précedents
        MenuModelComposite menu_composite = new MenuModelComposite("Menu Composite", model2, model);
        MenuControler menu = factory.createMenu(menu_composite);


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

    private static MenuModelDynamic getDynamicModel(List<String> listItem) {
        ActionProvider provider = new MyProvider();
        MenuModelDynamic model = new MenuModelDynamic(listItem, provider, "Menu Dynamique");
        return model;
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

class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("MyCallable.call");
        return null;
    }
}
