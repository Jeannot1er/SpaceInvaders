/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author jr202109
 */
public class SpaceInvaders extends iut.Jeu{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpaceInvaders jeu = new SpaceInvaders();
        jeu.jouer();
    }

    public SpaceInvaders() {
        super(1280, 720, "Space invaders");
    }

    @Override
    protected void creeObjets() {
        Joueur j = new Joueur(this, "vaisseau", 618, 650);
        this.ajouteEcouteurClavier(j);
        this.ajouter(j);
        for(int i=0; i<30;i++) {
            Ennemi e = new Ennemi(this, "ennemi", 185+94*(i%10), -160+79*(i/10));
            this.ajouter(e);    
        }
    }

    @Override
    protected void dessinerArrierePlan(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, largeur(), hauteur());
    }

    @Override
    protected void perdu() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu");
    }

    @Override
    protected void gagne() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné");
    }

    @Override
    protected boolean aGagne() {
        return false;
    }

    @Override
    protected boolean aPerdu() {
        return false;
    }
    
}
