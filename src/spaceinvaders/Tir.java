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
public class Tir extends iut.ObjetTouchable{

    public Tir(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return "Tir";
    }

    @Override
    public void evoluer(long dt) {
        if(this.posBasse()>0) {
            this.deplacerXY(0, -20);
        } else {
            this.leJeu().supprimer(this);
        }
    }
    
}
