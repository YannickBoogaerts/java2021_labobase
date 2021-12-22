package be.technifutur.laboJava.menu;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class MenuModelStatic implements MenuModel {

    private ArrayList<MenuNode> menuNodeList = new ArrayList<>();
    private String name;

    public MenuModelStatic(String name){
        this.name = name;
    }

    public void addNode(MenuNode menuNode) {
         if(menuNode != null) {
            this.menuNodeList.add(menuNode);
        }
    }

    public MenuNode getNode(int pos) {
        MenuNode result = null;
        if (pos >= 0 && pos < menuNodeList.size()) {
            result = menuNodeList.get(pos);
        }
        return result;
    }

    @Override
    public String getNodeName(int position) {
        return getNode(position).getName();
    }

    @Override
    public Callable getNodeAction(int position) {
        return getNode(position).getAction();
    }

    @Override
    public int size() {
        return this.menuNodeList.size();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
