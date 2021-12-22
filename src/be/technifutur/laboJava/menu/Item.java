package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public class Item implements MenuNode {
    private String name;
    private Callable action;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Callable getAction() {
        return action;
    }

    public void setAction(Callable action) {
        this.action = action;
    }
}
