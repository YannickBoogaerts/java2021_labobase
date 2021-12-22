package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public interface MenuNode {

    String getName();

    Callable getAction();
}
