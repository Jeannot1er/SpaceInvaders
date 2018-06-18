/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hs731277
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of effetCollision method, of class Joueur.
     */
    @Test
    public void testEffetCollision() {
        Jeu jeu = new SpaceInvaders();
        System.out.println("effetCollision");
        ObjetTouchable o = new TirEnnemi(jeu, "Tir Ennemi", 100, 10);
        Joueur instance = new Joueur(jeu, "Joueur", 618, 650);
        instance.effetCollision(o);
    }

    /**
     * Test of getTypeObjet method, of class Joueur.
     */
    @Test
    public void testGetTypeObjet() {
        Jeu jeu = new SpaceInvaders();
        System.out.println("getTypeObjet");
        Joueur instance = new Joueur(jeu, "Joueur", 618, 650);
        String expResult = "Joueur";
        String result = instance.getTypeObjet();
        assertEquals(expResult, result);
        if(expResult != result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of evoluer method, of class Joueur.
     */
    @Test
    public void testEvoluer() {
        Jeu jeu = new SpaceInvaders();
        System.out.println("evoluer");
        long dt = 200L;
        Joueur instance = new Joueur(jeu, "Joueur", 618, 650);
        instance.evoluer(dt);
    }

    /**
     * Test of keyPressed method, of class Joueur.
     */
    /*
    @Test
    public void testKeyPressed() {
        Jeu jeu = new SpaceInvaders();
        System.out.println("keyPressed");
        Joueur instance = new Joueur(jeu, "Joueur", 618, 650);
        KeyEvent key = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
         e.getKeyCode() = KeyEvent.VK_RIGHT;
        
        instance.keyPressed(e);
        if(instance.posDroite()<618){
            fail("The test case is a prototype.");
        }
    } 
    */


}
