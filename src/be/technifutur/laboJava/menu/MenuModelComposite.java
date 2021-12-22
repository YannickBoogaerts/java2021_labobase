package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public class MenuModelComposite implements MenuModel {
    private MenuModel[] composant;
    private String name;

    public MenuModelComposite(String name, MenuModel... composant) {
        this.composant = composant;
        this.name = name;
    }

    @Override
    public String getNodeName(int position) {
        CompositePosition pos = getCompositePosition(position);

        return composant[pos.menuNum].getNodeName(pos.position);
    }

    @Override
    public Callable getNodeAction(int position) {
        CompositePosition pos = getCompositePosition(position);

        return composant[pos.menuNum].getNodeAction(pos.position);
    }

    @Override
    public int size() {
        int size = 0;
        for(MenuModel m :composant){
            size+= m.size();
        }
        return size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private CompositePosition getCompositePosition(int position){
        CompositePosition pos = new CompositePosition();
        while(position >= composant[pos.menuNum].size()){
            position -= composant[pos.menuNum].size();
            pos.menuNum++;
        }
        pos.position = position;
        return pos;
    }

    private class CompositePosition{
        int menuNum;
        int position;
    }
}
