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
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import njit_hack.WeaponHolder;
import njit_hack.PlayerStats;
import njit_hack.EnemeyStats;

/**
 *
 * @author Gavin O'Hanlon, ilitchfield64, jkpuzon
 */
public class NJIT_Hack extends JPanel implements KeyListener {

    final int SCREEN_WIDTH = 1200;
    final int SCREEN_HEIGHT = 650;
    //declarations
    Rectangle backDrop;
    Rectangle ground;
    Rectangle playerRect;
    Rectangle playerTimeBar;
    Rectangle buildings[];
    Rectangle timerBar[];
    Rectangle enemyRect;
    Rectangle enemyTimeBar;
    Rectangle enemyTimeBars[];
    long kingCrimson = 0;
    long actualClock = 0;

    boolean hardMode = false;

    boolean turnTake = false;

    Image buildingImgs[];
    Image playerRun[];

    Image backDropImg;

    Image groundImg;

    int buildingX = 0;

    Image timeBar;
    Image timeBarImg;
    Image ChefBoi;

    int amountPotions = 3;
    
    int enemeyReduce = 1;
    int playerReduce = 1;

    boolean freeze = false;

    int timer = 0;
    int timer2 = 1000;
    int timer3 = 0;
    int timer4 = 0;
    int timer5 = 0;

    String text = "";

    public Random gen = new Random();

    public PlayerStats player = new PlayerStats();
    public EnemeyStats enemey = new EnemeyStats();
    public Sword1 sword1 = new Sword1();
    tempWeapon tempWeapon = new tempWeapon();

    public NJIT_Hack() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        // initialization
        boolean fail = true;
        while (fail) {
            Scanner reader = new Scanner(System.in);
            print("Please choose a class between Rogue or Knight");
            String choice = reader.nextLine();

            if (choice.equalsIgnoreCase("knight")) {
                player.setHealth(100);
                player.setAttack(8);
                player.setSpeed(40);
                player.setDefense(5);
                player.setCriticalChance(8);
                fail = false;
            }
            if (choice.equalsIgnoreCase("rogue")) {
                player.setHealth(100);
                player.setAttack(5);
                player.setSpeed(2);
                player.setDefense(65);
                player.setCriticalChance(2);
                fail = false;
            }
            if (fail) {
                print("please enter the correct paremeters!");
            }
        }

        enemey.randomizeStats(hardMode);

        ground = new Rectangle(0, (SCREEN_HEIGHT / 3) * 2, SCREEN_WIDTH, (SCREEN_HEIGHT / 3) + 2);
        backDrop = new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        playerRect = new Rectangle((int) (SCREEN_WIDTH / (double) (4.8)), (int) (SCREEN_HEIGHT / (double) (2.6)), (SCREEN_WIDTH / 18), (SCREEN_HEIGHT / 3) + ((SCREEN_HEIGHT / 3) / 8));

        enemyRect = new Rectangle(1400, playerRect.y, playerRect.width, playerRect.height);

        playerTimeBar = new Rectangle(playerRect.x - SCREEN_HEIGHT / 16, playerRect.y - (SCREEN_HEIGHT / (26 / 3)), (SCREEN_WIDTH / 8) + 2, 50);
        
        enemyTimeBar = new Rectangle(enemyRect.x + SCREEN_HEIGHT / 20, playerRect.y - (SCREEN_HEIGHT / (26 / 3)), (SCREEN_WIDTH / 9) + 2, 50);
        
        buildingImgs = new Image[6];
        buildings = new Rectangle[10];
        playerRun = new Image[8];

        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = new Rectangle(SCREEN_WIDTH + 200 + gen.nextInt(1000), ground.y - ((SCREEN_HEIGHT / 8) + (i * 25)), (SCREEN_WIDTH / 12), (SCREEN_HEIGHT / 8) + (i * 25));
        }
        timerBar = new Rectangle[10];
        for (int i = 0; i < timerBar.length; i++) {
            timerBar[i] = new Rectangle(playerTimeBar.x + 8 + (i * 14), playerTimeBar.y + 5, 10, 40);
        }    
        
        enemyTimeBars = new Rectangle[10];
        for (int i = 0; i <  enemyTimeBars.length; i++) {
            enemyTimeBars[i] = new Rectangle(enemyTimeBar.x + 8 + (i * 14), enemyTimeBar.y + 5, 10, 40);
            
        }
        try {

            timeBar = ImageIO.read(new File("src/njit_hack/Time Scale.png"));
            buildingImgs[0] = ImageIO.read(new File("src/njit_hack/building (1).png"));
            buildingImgs[1] = ImageIO.read(new File("src/njit_hack/building (2).png"));
            buildingImgs[2] = ImageIO.read(new File("src/njit_hack/building (3).png"));
            buildingImgs[3] = ImageIO.read(new File("src/njit_hack/building (4).png"));
            buildingImgs[4] = ImageIO.read(new File("src/njit_hack/building (5).png"));
            buildingImgs[5] = ImageIO.read(new File("src/njit_hack/building (6).png"));
            backDropImg = ImageIO.read(new File("src/njit_hack/sunset.png"));
            groundImg = ImageIO.read(new File("src/njit_hack/Ground.png"));
            timeBarImg = ImageIO.read(new File("src/njit_hack/timebar.png"));
            ChefBoi = ImageIO.read(new File("src/njit_hack/ChefBoi.png"));

            playerRun[0] = ImageIO.read(new File("src/njit_hack/running chef (0).png"));
            playerRun[1] = ImageIO.read(new File("src/njit_hack/running chef (1).png"));
            playerRun[2] = ImageIO.read(new File("src/njit_hack/running chef (2).png"));
            playerRun[3] = ImageIO.read(new File("src/njit_hack/running chef (3).png"));
            playerRun[4] = ImageIO.read(new File("src/njit_hack/running chef (4).png"));
            playerRun[5] = ImageIO.read(new File("src/njit_hack/running chef (5).png"));
            playerRun[6] = ImageIO.read(new File("src/njit_hack/running chef (6).png"));
            playerRun[7] = ImageIO.read(new File("src/njit_hack/running chef (7).png"));
        } catch (IOException e) {

        }

        /*
        Rogue class:
        health = 100;
        attack = 6
        speed = 40
        defense = 5
        critical = 8
        Knight class:
        health = 125;
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

    public void update() {
        //update stuff here

        for (int i = 0; i < buildings.length; i++) {
            freezeBuilding(buildings[i], buildings[i].x, freeze);

        }
        if (enemyRect.x != SCREEN_WIDTH / 2 /* && after a certian amount of time*/) {
            enemyRect.x--;

        } else {
            if (enemyRect.x == SCREEN_WIDTH / 2) {
                freeze = true;
            }
        }

        long kingCrimson = System.currentTimeMillis();
        long actualClock = kingCrimson - System.currentTimeMillis();

    }

    public void paint(Graphics g) {
        super.paint(g);
        update();
        // graphics
        g.drawImage(backDropImg, backDrop.x, backDrop.y, backDrop.width, backDrop.height, null);

        for (int i = 0; i < buildings.length; i++) {
            int temp = 0;
            if (i < buildingImgs.length) {
                temp = i;
            } else {
                temp = i - buildingImgs.length;
            }

            g.drawImage(buildingImgs[temp], buildings[i].x, buildings[i].y, buildings[i].width, buildings[i].height, null);
        }

        g.drawImage(groundImg, ground.x, ground.y, ground.width, ground.height, null);
        
        if (freeze) {
            
            for (int i = 0; i <= player.getHealth(); i++) {
                g.setColor(Color.RED);
                g.fillRect((playerRect.x - 60) + (i * 2), (playerRect.y + playerRect.height) + 7, 2, 5);
            }
            
            g.drawImage(ChefBoi, playerRect.x, playerRect.y, playerRect.width, playerRect.height, null);
            g.drawImage(timeBar, playerTimeBar.x, playerTimeBar.y, playerTimeBar.width, playerTimeBar.height, null);
            
            g.drawImage(timeBar, enemyTimeBar.x, enemyTimeBar.y, enemyTimeBar.width, enemyTimeBar.height, null);

            if (turnTake == true) {
                timer2 --;
                if(timer2 == 0){
                    turnTake = false;
                    timer2 = 1000;
                }
                if (timer2 >= 100) {
                    g.drawImage(timeBarImg, timerBar[0].x, timerBar[0].y, timerBar[0].width, timerBar[0].height, null);
                    if (timer2 >= 200) {
                        g.drawImage(timeBarImg, timerBar[1].x, timerBar[1].y, timerBar[1].width, timerBar[1].height, null);
                        if (timer2 >= 300) {
                            g.drawImage(timeBarImg, timerBar[2].x, timerBar[2].y, timerBar[2].width, timerBar[2].height, null);
                            if (timer2 >= 400) {
                                g.drawImage(timeBarImg, timerBar[3].x, timerBar[3].y, timerBar[3].width, timerBar[3].height, null);
                                if (timer2 >= 500) {
                                    g.drawImage(timeBarImg, timerBar[4].x, timerBar[4].y, timerBar[4].width, timerBar[4].height, null);
                                    if (timer2 >= 600) {
                                        g.drawImage(timeBarImg, timerBar[5].x, timerBar[5].y, timerBar[5].width, timerBar[5].height, null);
                                        if (timer2 >= 700) {
                                            g.drawImage(timeBarImg, timerBar[6].x, timerBar[6].y, timerBar[6].width, timerBar[6].height, null);
                                            if (timer2 >= 800) {
                                                g.drawImage(timeBarImg, timerBar[7].x, timerBar[7].y, timerBar[7].width, timerBar[7].height, null);
                                                if (timer2 >= 900) {
                                                    g.drawImage(timeBarImg, timerBar[8].x, timerBar[8].y, timerBar[8].width, timerBar[8].height, null);
                                                    if (timer2 >= 1000) {
                                                        g.drawImage(timeBarImg, timerBar[9].x, timerBar[9].y, timerBar[9].width, timerBar[9].height, null);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            }

        }

        g.drawString("" + text, 50, 50);

        g.setColor(Color.BLUE);
        g.fillRect(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height);

        if (!freeze) {
            timer++;
            if (timer <= 25 && timer > 0) {
                g.drawImage(playerRun[0], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 50 && timer > 25) {
                g.drawImage(playerRun[1], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 75 && timer > 50) {
                g.drawImage(playerRun[2], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 100 && timer > 75) {
                g.drawImage(playerRun[3], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 125 && timer > 100) {
                g.drawImage(playerRun[4], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 150 && timer > 125) {
                g.drawImage(playerRun[5], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 175 && timer > 150) {
                g.drawImage(playerRun[6], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer <= 200 && timer > 175) {
                g.drawImage(playerRun[7], playerRect.x, playerRect.y, playerRect.width + 50, playerRect.height, null);
            }
            if (timer > 200) {
                timer = 0;
            }
        }

        repaint();
    }

    public void buildMove(Rectangle build, int x) {
        build.x -= 1;
        if (build.x == -200) {
            build.x += SCREEN_WIDTH + 200 + gen.nextInt(1000);
        }

    }

    public void freezeBuilding(Rectangle build, int x, boolean freeze) {
        if (!freeze) {
            buildMove(build, x);
        }

    }

    public void playerAttack() {
        int multiplier = 1;

        if (criticalHit(player.getCriticalChance())) {
            multiplier = 2;
        }

        int enemeyHealth = enemey.getHealth();

        enemeyHealth -= ((player.getAttack() + tempWeapon.getAttackDamage()) * multiplier) * enemeyReduce;

        enemey.setHealth(enemeyHealth);
        
        enemeyReduce = 1;
        
        turnTake = true;

    }

    public void playerEvade() {

        int temp = gen.nextInt(100) + 1;
        if (player.getSpeed() < temp) {
            
        } else {
            enemeyAttack();
        }
        turnTake = true;

    }

    public void playerDefend() {

        int temp = gen.nextInt(100) + 1;
        if (player.getDefense() < temp) {
            //you you shield
        }
        turnTake = true;
    }

    public void playerUsePotion() {
        if (amountPotions > 0) {
            amountPotions -= 1;
            player.setHealth(player.getHealth() + 50);
            if (player.getHealth() > 100) {
                int temp = 100 - player.getHealth();
                player.setHealth(player.getHealth() - temp);
            }
        }

    }

    public void enemeyAttack() {
        int multiplier = 1;

        if (criticalHit(player.getCriticalChance())) {
            multiplier = 2;
        }

    }

    public void enemeyEvade() {

    }

    public void enemeyDefend() {

    }

    public void enemeyUsePotion() {
        if (amountPotions > 0) {
            amountPotions -= 1;
            player.setHealth(player.getHealth() + 50);
            if (player.getHealth() > 100) {
                int temp = 100 - player.getHealth();
                player.setHealth(player.getHealth() - temp);
            }
        }

    }

    public Object isEquipped() {
        if (sword1.getEquipped()) {
            tempWeapon.setAttackDamage(sword1.getAttackDamage());
        }

        return null;
    }

    public boolean criticalHit(int cChance) {
        int temp = gen.nextInt(100) + 1;
        if (cChance <= temp) {
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
        if (freeze && !turnTake) {
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
        if (e.getKeyCode() == KeyEvent.VK_P) {
            System.exit(0);
        }
    }

}
