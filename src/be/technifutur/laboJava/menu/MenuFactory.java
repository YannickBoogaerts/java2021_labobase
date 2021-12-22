package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public class MenuFactory {

     public MenuControler createMenu(MenuModel model){
        MenuControler menu = new MenuControler();
        menu.setVue(new MenuVue());
        menu.setModel(model);
        return menu;
    }

   public MenuNode createItem(String name, Callable action){
        Item item = new Item();
        item.setAction(action);
        item.setName(name);
        return item;

    }
}
