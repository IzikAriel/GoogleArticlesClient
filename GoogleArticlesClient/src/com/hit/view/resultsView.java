package com.hit.view;
import resources.Scoop;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class resultsView extends JPanel{
    private JLabel title,background, time;
    private JLabel secondtitle;
    private JButton prev;
    private ArrayList<JButton> links;
    private ResultsActionListener listener;
    private ImageIcon bgImg;
    private long Time;

    public ResultsActionListener getListener() {return listener;}

    public resultsView(ArrayList<String> list, String order, long time)
    {
        Time = time;
        start(list);
        initialization(order);
    }

    public void start(ArrayList<String> list)//insert the result to list of buttons
    {
        listener = new ResultsActionListener();
        links=new ArrayList<>();
        int j=0;
        for(int i=list.size()-1;i>=0;i--)
        {
            links.add(new JButton(list.get(i)));
            links.get(j).addActionListener(listener);
            j++;
        }
    }

    public void initialization( String order){

        bgImg=new ImageIcon(Scoop.rec("t.jpg"));
        background=new JLabel(bgImg);
        time = new JLabel("time in NaNo sec:"+Time);
        title = new JLabel("RESULTS");
        secondtitle= new JLabel("Founded Articles:");
        prev = new JButton("Back");

        title.setFont(new Font("Arial", Font.BOLD, 28));
        time.setFont(new Font("Arial", Font.BOLD, 18));
        secondtitle.setFont(new Font("Arial", Font.BOLD, 16));
        prev.setFont(new Font("Arial", Font.BOLD, 14));

        prev.setForeground(Color.WHITE);
        secondtitle.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        time.setForeground(Color.WHITE);
        prev.setBackground(Color.darkGray);

        background.setVisible(true);
        title.setVisible(true);
        time.setVisible(true);
        secondtitle.setVisible(true);
        prev.setVisible(true);

        background.setBounds(-100,-100,900,600);
        title.setBounds(325, 47, 406, 67);
        time.setBounds(25, 350, 406, 67);
        secondtitle.setBounds(100, 100, 406, 67);
        prev.setBounds(25, 25, 100, 37);

        if((order.equals("searchByMostMentions")))
            secondtitle.setText("sorted by Most mentions:");
        else if (order.equals("searchByMostPopular"))
            secondtitle.setText("sorted by Most popular:");

        int x=300;
        int y=150;
        for(int i=0;i<links.size();i++){

            links.get(i).setFont(new Font("Arial", Font.BOLD, 10));
            links.get(i).setBounds(x, y, 250, 37);
            links.get(i).setForeground(Color.BLACK);
            links.get(i).setVisible(true);
            links.get(i).setBackground(Color.green);
            add(links.get(i));
            y+=70;
        }

        prev.addActionListener(listener);
        add(title);
        add(secondtitle);
        add(prev);
        add(time);
        add(background);
        setLayout(null);
    }

    public ResultsActionListener getlistener(){return listener;}
}
