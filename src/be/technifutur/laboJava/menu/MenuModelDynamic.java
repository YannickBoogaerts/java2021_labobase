package be.technifutur.laboJava.menu;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class MenuModelDynamic implements MenuModel {
    private List<String> list;
    private ActionProvider provider;
    private String name;

    public MenuModelDynamic(List<String> list, ActionProvider provider, String name) {
        this.list = list;
        this.provider = provider;
        this.name = name;
    }


    @Override
    public String getNodeName(int position) {
        return list.get(position);
    }


    @Override
    public Callable getNodeAction(int position) {
        String name = list.get(position);
        return provider.getAction(name);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String getName() {
        return name;
    }
}
