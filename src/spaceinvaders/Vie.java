/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import iut.Jeu;
import iut.Objet;

/**
 *
 * @author ml541006
 */
public class Vie extends iut.Objet {

    public Vie(Jeu g, String nom, double _x, double _y) {
        super(g, nom, _x, _y);
    }

    @Override
    public boolean testerCollision(Objet o) {
        return false;
    }

    @Override
    public void effetCollision(Objet o) {
    }

    @Override
    public String getTypeObjet() {
        return "";
    }

    @Override
    public void evoluer(long dt) {
    }

}
