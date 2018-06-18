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
 * @author HP
 */
public class TirEnnemi extends iut.ObjetTouchable{

    public TirEnnemi(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return "TirEnnemi";
    }

    @Override
    public void evoluer(long dt) {        
        if(this.posBasse()<this.leJeu().hauteur()-64) {
            this.deplacerXY(0, 2);
        } else {
            this.leJeu().supprimer(this);
        }
    }
    
}
