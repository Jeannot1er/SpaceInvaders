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
public class Joueur extends iut.ObjetTouchable implements KeyListener {

    private int timerTir = 0;
    private boolean peutTirer = true;
    private int tempsEntreTirs = 500;
    private int tempsAffichageFinJeu = 200;
    private int vie;
    private Vie objVie;

    public Joueur(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        vie = 3;
        objVie = new Vie(g, String.valueOf(vie) + "vie", 10, 700);
        this.leJeu().ajouter(objVie);
    }

    @Override
    public void effetCollision(Objet o) {
        if (("TirEnnemi".equals(o.getTypeObjet()))) { //|| ("Ennemi".equals(o.getTypeObjet()))
            this.leJeu().supprimer(o);
            if (vie >= 1) {
                vie -= 1;
                System.out.println(vie);

                this.leJeu().supprimer(objVie);
                objVie = new Vie(this.leJeu(), String.valueOf(vie) + "vie", 10, 700);
                this.leJeu().ajouter(objVie);

            }
            if (vie == 0) {
                this.leJeu().mourir();
            }
        } else if ("Bonus".equals(o.getTypeObjet())) {
            if (tempsEntreTirs > 200) {
                tempsEntreTirs -= 50;
            }
            // this.leJeu().supprimer(o);
        }

    }

    @Override
    public String getTypeObjet() {
        return "Joueur";
    }

    @Override
    public void evoluer(long dt) {
        if (!peutTirer) {
            timerTir += dt;
            if (timerTir > tempsEntreTirs) {
                peutTirer = true;
                timerTir = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (this.posDroite() < super.leJeu().largeur()) {
                    this.deplacerXY(15, 0);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (this.posGauche() > 0) {
                    this.deplacerXY(-15, 0);
                }
                break;
            case KeyEvent.VK_SPACE:
                if (peutTirer) {
                    TirJoueur t = new TirJoueur(this.leJeu(), "tirJoueur", this.milieuX(), this.posHaute());
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
