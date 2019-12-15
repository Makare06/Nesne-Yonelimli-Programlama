/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesnake2;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.applet.Applet;

/**
 *
 * @author PC
 */
public class GameSnake2 extends JFrame {
    
    
    public GameSnake2(){        
       
        add(new Yilan());             
        setResizable(false);
        pack();      
        setTitle("GameSnake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
    }
    
    public static void main(String[] args) {   
        JFrame ex = new GameSnake2();
        ex.setLayout(new FlowLayout());  
        ex.setVisible(true);  
              
    }
    
}
