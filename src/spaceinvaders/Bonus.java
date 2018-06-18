/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

/**
 *
 * @author Hérine SERVAN
 */
public class Bonus extends ObjetTouchable{
    
        public Bonus(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return "Bonus";
    }

    @Override
    public void evoluer(long dt) {
        if(this.posHaute()<this.leJeu().hauteur()) {
            this.deplacerXY(0, 2);
        } else {
            this.leJeu().supprimer(this);
        }
    }
    
    
}
