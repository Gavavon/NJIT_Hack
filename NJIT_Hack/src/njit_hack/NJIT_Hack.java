/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njit_hack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import njit_hack.WeaponHolder;
import njit_hack.PlayerStats;
import njit_hack.EnemeyStats;

/**
 *
 * @author Gavav, ilitchfield64, jkpuzon
 */
public class NJIT_Hack extends JPanel implements KeyListener {

    final int SCREEN_WIDTH = 1200;
    final int SCREEN_HEIGHT = 650;
    
    Rectangle backDrop;
    Rectangle ground;
    Rectangle playerRect;
    Rectangle playerTimeBar;
    
    Image timeBar;
    
    String text = "";
    
    public Random gen = new Random();
    
    public PlayerStats player = new PlayerStats();
    public EnemeyStats enemey = new EnemeyStats();
    public Sword1 sword1 = new Sword1();
    
    
    public NJIT_Hack(){
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        
        player.setHealth(0);
        player.setAttack(0);
        player.setSpeed(0);
        player.setDefense(0);
        player.setCriticalChance(0);
        
        ground = new Rectangle(0,(SCREEN_HEIGHT /3)*2,SCREEN_WIDTH,(SCREEN_HEIGHT/3)+2);
        backDrop = new Rectangle(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        playerRect = new Rectangle((int) (SCREEN_WIDTH / (double) (4.8)), (int)(SCREEN_HEIGHT / (double) (2.6)),(SCREEN_WIDTH / 8),(SCREEN_HEIGHT/3) + ((SCREEN_HEIGHT/3) / 8));
        
        playerTimeBar = new Rectangle(playerRect.x, playerRect.y - (SCREEN_HEIGHT/(26/3)), playerRect.width, 50);
        try{
            
            timeBar = ImageIO.read(new File("src/njit_hack/Time Scale.png"));

        } catch (IOException e) {

        }
        
        /*
        Rogue class:
        attack = 6
        speed = 40
        defense = 10
        critical = 8
        Knight class:
        attack = 4
        speed = 5
        defense = 60
        critical = 2
        Assassin class:
        attack = 10
        speed = 0
        defense = 0
        critical = 100
        */
      
    }
    public void update(){
        //update stuff here
    }
    public void paint(Graphics g) {
        super.paint(g);
        update();
        g.setColor(Color.RED);
        g.fillRect(backDrop.x,backDrop.y,backDrop.width,backDrop.height);
        g.setColor(Color.GRAY);
        g.fillRect(ground.x, ground.y, ground.width, ground.height);
        g.setColor(Color.BLACK);
        g.fillRect(playerRect.x, playerRect.y,playerRect.width , playerRect.height);
        
        g.drawImage(timeBar, playerTimeBar.x, playerTimeBar.y, playerTimeBar.width, playerTimeBar.height, null);
        
        g.drawString("" + text, 0 , 0);
        
        repaint();
    }
    public void playerAttack(){
        int multiplier = 1;
        
        if(criticalHit(player.getCriticalChance())){
            multiplier = 2;
        }
        
        int enemeyHealth = enemey.getHealth();
        
    }
    public void playerEvade(){
        
    }
    public void playerDefend(){
        
    }
    public void playerUsePotion(){
        
    }
    public Object isEquiped(){
        if(sword1.equipped){
            return sword1;
        }
        
        return null;
    }
    public boolean criticalHit(int cChance){
        int temp = gen.nextInt(100)+1;
        if(cChance <= temp){
            return true;
        }
        return false;
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
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            playerUsePotion();
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerAttack();
        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
            playerEvade();
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            playerDefend();
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            
        }
        if (e.getKeyCode() == KeyEvent.VK_Y) {
            
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            //yes
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            //no
        }
    }
    
}
