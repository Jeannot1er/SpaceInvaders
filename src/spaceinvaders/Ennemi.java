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
    private int xBase;
    private int yBase;
    private boolean gauche = true;
    private int timer = 0;

    public Ennemi(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.xBase = x;
        this.yBase = y;
    }

    @Override
    public void effetCollision(Objet o) {
        if(o.getTypeObjet().equals("TirJoueur")) {
            this.leJeu().supprimer(this);
            this.leJeu().supprimer(o);
            if(Math.random()<0.2) {
                Bonus b = new Bonus(this.leJeu(), "bonus", this.milieuX(), this.posBasse());
                this.leJeu().ajouter(b);
            }
        }
    }

    @Override
    public String getTypeObjet() {
        return "Ennemi";
    }

    @Override
    public void evoluer(long dt) {
        
        if(this.posBasse()>this.leJeu().hauteur()){
            this.leJeu().mourir();
        }

        if(this.posGauche()>xBase-180 && gauche) {
            this.deplacerXY(-1,0);
        } else if(this.posGauche()<=xBase-180) {
            this.deplacerXY(1, 50);
            this.gauche = false;
        } else if(this.posDroite()<xBase+244 && !gauche){
            this.deplacerXY(1,0);
        } else if(this.posDroite()>=xBase+244) {
            this.deplacerXY(-1,50);
            this.gauche = true;
        }
        
        
        if(timer>1000) {
            if(Math.random()<0.10) {
                TirEnnemi tir = new TirEnnemi(this.leJeu(),"tirEnnemi",this.milieuX(),this.posBasse());
                this.leJeu().ajouter(tir);       
            }
            timer = 0;
        } else {
            timer += dt;
        }
    }
    
}
