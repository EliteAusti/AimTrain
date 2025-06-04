package aimtrain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class aimtrain extends JFrame{
    Random rand = new Random();
    int score=0;
    double starttime=(double)System.nanoTime();
    private JFrame frame;
    private JButton button;
    private JLabel label;
    public aimtrain(int size1){
        
        int size=size1;
        frame = new JFrame("Button Click Example");
        button=new JButton("hit");
        label=new JLabel("");
        label.setBounds(200,200,800,200);
        frame.setLayout(null);
        frame.setSize(1000, 600);
        
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
        button.setBounds(500,300,size,size);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                button.setBounds(rand.nextInt(size,1000-size),rand.nextInt(size,600-size),size,size);
                double timeElap=((double)System.nanoTime()-starttime)/1000000000.0;
                score+=1;
                String temp=String.valueOf("Average Score per minute: "+(score/timeElap)*60);
                label.setText(temp.substring(0,33));
            }
        });
    }   
    public static void main(String[] args) {
        new aimtrain(40);
    }
}
