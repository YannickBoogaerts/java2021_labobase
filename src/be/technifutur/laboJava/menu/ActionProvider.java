package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public interface ActionProvider {

    Callable getAction(String name);
}
