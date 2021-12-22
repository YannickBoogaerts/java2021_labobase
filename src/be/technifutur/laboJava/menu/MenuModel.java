package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public interface MenuModel {

    String getNodeName(int position);

    Callable getNodeAction(int position);

    int size();

    String getName();
}
