/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njit_hack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Gavav, ilitchfield64,
 */
public class NJIT_Hack extends JPanel implements KeyListener {

    final int SCREEN_WIDTH = 1200;
    final int SCREEN_HEIGHT = 650;
    //delcare here
    Rectangle test1;
    Rectangle worldEnv;
    Rectangle groundSpace;
    int groundHeightPosition;
    int groundHeight;
    Rectangle player;
    int playerHeight;
    int playerWidth;
    int playerPositionX;
    int playerPositionY;
    
    public NJIT_Hack(){
        //initialize here
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        //How Ground height is calculated being 1/3 of the screen and the world is created.
        groundHeight =(SCREEN_HEIGHT /3);
        groundHeightPosition = ((groundHeight)*2);
        groundSpace = new Rectangle(0,(groundHeightPosition),SCREEN_WIDTH,(groundHeight)+2);
        worldEnv = new Rectangle(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        //How the player is created and posistioned on the screen.
        playerHeight = groundHeight + (groundHeight / 8);
        playerWidth = (SCREEN_WIDTH / 8);
        playerPositionX = (int) (SCREEN_HEIGHT / 3);
        playerPositionY = (int) (SCREEN_WIDTH / 8);
        
        print(playerPositionX);
        print(playerPositionY);        
               

        player = new Rectangle(playerPositionX,playerPositionY,playerWidth,playerHeight);

        player = new Rectangle(200,250,playerWidth,playerHeight);
        
      
    }
    public void update(){
        //update stuff here
    }
    public void paint(Graphics g) {
        super.paint(g);
        update();
        //graphics
        g.setColor(Color.RED);
        g.fillRect(worldEnv.x,worldEnv.y,worldEnv.width,worldEnv.height);
        g.setColor(Color.GRAY);
        g.fillRect(groundSpace.x, groundSpace.y, groundSpace.width, groundSpace.height);
        g.setColor(Color.BLACK);
        g.fillRect(player.x, player.y,player.width , player.height);
        
        
        repaint();
    }
    
    
    public final void print(Object b) {
        System.out.println(b);
        //this makes printing easier
    }
    public static void main(String[] args) {
        NJIT_Hack game = new NJIT_Hack();
        JFrame frame = new JFrame();
        frame.setTitle("PizzaChopper");
        frame.add(game);
        frame.pack();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
}
