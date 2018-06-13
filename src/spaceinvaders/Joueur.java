/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import iut.Jeu;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jr202109
 */
public class Joueur extends iut.ObjetTouchable implements KeyListener{
    
    private int timerTir = 0;
    private boolean peutTirer = true;

    public Joueur(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return "Joueur";
    }

    @Override
    public void evoluer(long dt) {
        if(!peutTirer){
            timerTir += dt;
            if(timerTir>500) {
                peutTirer=true;
                timerTir = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT :
                if(this.posDroite()<super.leJeu().largeur()) {
                    this.deplacerXY(15, 0);
                }
                break;
            case KeyEvent.VK_LEFT :
                if(this.posGauche()>0) {
                    this.deplacerXY(-15,0);
                }
                break;
            case KeyEvent.VK_SPACE :
                if(peutTirer) {
                    Tir t = new Tir(this.leJeu(), "torpedo", this.milieuX(), this.posHaute()+2); 
                    this.leJeu().ajouter(t);
                    peutTirer = false;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
