package be.technifutur.laboJava.menu;

import java.util.concurrent.Callable;

public class MenuControler implements MenuNode {
    private MenuVue vue;
    private MenuModel model;

    public void setVue(MenuVue vue) {
        this.vue = vue;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return model.getName();
    }

    @Override
    public Callable getAction() {
        Callable result = null;
        boolean saisieOK = false;
        vue.setError(null);
        do {
            String input = vue.saisirMenu(model);
            try {
                int choix = Integer.parseInt(input) - 1;
                if (choix >= 0 && choix < model.size()) {
                    saisieOK = true;
                    result = model.getNodeAction(choix);
                } else {
                    vue.setError("Il n'y a pas d'option :" + (choix + 1));
                }
            } catch (NumberFormatException e) {
                vue.setError(input + " n'est pas numérique");
            }
        } while (saisieOK == false);
        vue.setError(null);
        return result;
    }
}
