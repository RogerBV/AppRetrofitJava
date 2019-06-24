package com.prueba.roger.appretrofitjava.data.model;

import java.util.ArrayList;
import java.util.List;

public class AbilityFeed {
    private List<Form> forms = new ArrayList<Form>();
    private List<Ability> abilities = new ArrayList<Ability>();

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
