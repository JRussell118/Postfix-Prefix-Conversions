/*Jaden Russell
  Project 1
  3/24/23
  This program creates a GUI for the user to do postfix and prefix conversions.
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project1_jaden_russell;

/**
 *
 * @author jaden
 */
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){

        JFrame f = new JFrame("Expression Converter");
        JPanel p = new JPanel();
        JLabel l1 = new JLabel("Enter Expression");
        JLabel l2 = new JLabel("Result");
        JTextField t1 = new JTextField(30);
        JTextField t2 = new JTextField(30);
        JButton b1 = new JButton("Prefix to Postfix");
        JButton b2 = new JButton("Postfix to Prefix");
    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(l1);
        p.add(t1);
        f.add(p);
        p.add(b1);
        p.add(b2);
        p.add(l2);
        p.add(t2);
        
        b1.addActionListener((ActionEvent e) -> {
            try{
                PreConversion postS = new PreConversion();
                t2.setText(postS.preCon(t1.getText()));
            }
            catch(EmptyStackException ex){
                if(t1.getText().length() > 0){
                    JOptionPane.showMessageDialog(null, "This expression is already in postfix format.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You have not entered an expression.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PostConversion preS = new PostConversion();
                    t2.setText(preS.postCon(t1.getText()));
                }
                catch(EmptyStackException ex){
                    if(t1.getText().length() > 0){
                        JOptionPane.showMessageDialog(null, "This expression is already in prefix format.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You have not entered an expression.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            }
        });   
        
        f.setSize(300,170);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
