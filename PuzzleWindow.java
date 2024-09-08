package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Yashili Thotakura (yashili)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    
    /**
     * A factor in which the width of the disks are multiplied by
     */
    
    public static final int WIDTH_FACTOR = 15;
    
    /**
     * The vertical gap between each disk on the tower
     */
    
    public static final int DISK_GAP = 0;
    
    /**
     * The height of each disk on the tower
     */
    
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g the game to create a view for
     */
    
    public PuzzleWindow(HanoiSolver g) {
        this.game = g;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        int x = window.getGraphPanelWidth();
        int y = window.getGraphPanelHeight() / 2;
        
        left = new Shape(x / 6, y, 3, 90, Color.BLACK);
        middle = new Shape(x / 2, y, 3, 90, Color.BLACK);
        right = new Shape((x * 5) / 6, y, 3, 90, Color.BLACK);
        
        for (int i = game.disks(); i >= 1; i--) {
            Disk disk = new Disk(i * 6);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solveButton = new Button("Solve");
        solveButton.onClick(this, "clickedSolve");
        window.addButton(solveButton, WindowSide.SOUTH); 
    }
    
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = left;
        
        if (position == Position.LEFT) {
            currentPole = left;
        }
        
        if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        
        if (position == Position.RIGHT) {
            currentPole = right;
        }
        
        int x = currentPole.getX() + currentPole.getWidth() / 2
                - currentDisk.getWidth() / 2;
        int y = currentPole.getY() + currentPole.getHeight() -
                game.getTower(position).size() * (DISK_GAP + DISK_HEIGHT);
        currentDisk.moveTo(x, y);
    }
    
    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */

    @Override
    public void update(Observable o, Object arg) { 
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        } 
    }
    
    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    private void sleep() {
        try {
            Thread.sleep(500);
        } 
        
        catch (Exception e) {
            //empty
        }
    }
}