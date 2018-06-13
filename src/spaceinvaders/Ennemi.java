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
 * @author jr202109
 */
public class Ennemi extends iut.ObjetTouchable{

    public Ennemi(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effetCollision(Objet o) {
        if(o.getTypeObjet().equals("Tir")) {
            this.leJeu().supprimer(this);
        }
    }

    @Override
    public String getTypeObjet() {
        return "Ennemi";
    }

    @Override
    public void evoluer(long dt) {
        if(this.posGauche()>10) {
            this.deplacerXY(-5,0);
        } else {
            this.deplacerXY(1200, 80);
        }
    }
    
}
