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
    private int score ;
    // affichage 
    private Score affichage;


    public Score(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        score=0;
       
    }
    
  
    @Override
    public boolean testerCollision(Objet o) {
        return false;    }

    @Override
    public void effetCollision(Objet o) {
        
    }

    @Override
    public String getTypeObjet() {
        return"";    }

    @Override
    public void evoluer(long dt) {
    }
    
    public int getScore(){
        return score;
    }  
 
    public void augmenterScore(){
        score+=1;
    }
    
    public void diminuerScore(){
        score-=1;
    }
    
    
    public void  effetCollisionSurScore(){
            this.augmenterScore();
            System.out.println(score);
            
            this.leJeu().supprimer(affichage);
            System.out.println("est supprimer");
         
            if (score<10){
                affichage = new Score(this.leJeu(), Integer.toString(this.getScore()),1155,32);
                this.leJeu().ajouter(affichage);
          }
            else {
             affichage = new Score(this.leJeu(), Integer.toString(this.getScore()%10),1187,32);
             this.leJeu().ajouter(affichage);
             
            affichage = new Score(this.leJeu(), Integer.toString(this.getScore()/10),1155,32);
            this.leJeu().ajouter(affichage);
            }
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "score : "+score;
    }
  
}
