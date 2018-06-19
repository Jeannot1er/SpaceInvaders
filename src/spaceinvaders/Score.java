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
 * @author mathi
 */
public class Score extends iut.Objet {
    
    public Score(Jeu g, int chiffre, int xPlus) {
        super(g, String.valueOf(chiffre), 1200+xPlus, 740);
    }
    
  
    @Override
    public boolean testerCollision(Objet o) {
        return false;    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return"Score";
    }

    @Override
    public void evoluer(long dt) {
    }
}

