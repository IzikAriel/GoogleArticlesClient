package com.hit.view;
import resources.Scoop;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame{

    private resultsView resView ;
    private JButton searchBtn ;
    private JLabel algorithm,title,By,background,error;
    private JTextField searchbar;
    private JCheckBox kmp,naive,rabinKarp;
    private MainActionListener listener;
    private Choice searchBy;
    private ImageIcon bgImg;

    public View(){

        super();
        initialization();
    }

    public resultsView getResView() {
        return resView;
    }

    public MainActionListener getListener() {
        return listener;
    }

    public void initialization(){

        bgImg = new ImageIcon(Scoop.rec("n.jpg"));
        background=new JLabel(bgImg);
        searchBtn = new JButton("Search");
        searchbar = new JTextField("");
        title = new JLabel("WELCOME TO GoogleArticles");
        algorithm = new JLabel("Choose Algorithm to search:");
        kmp=new JCheckBox("KMP",true);
        naive=new JCheckBox("Naive");
        rabinKarp = new JCheckBox("RabinKarp");
        searchBy = new Choice();
        By = new JLabel("Search By (optional)");
        error = new JLabel("Not Found Results");

        searchBy.add("ALL");
        searchBy.add("Most popular");
        searchBy.add("Most mentions");

        kmp.setContentAreaFilled(false);
        naive.setContentAreaFilled(false);
        rabinKarp.setContentAreaFilled(false);

        algorithm.setBackground(Color.darkGray);
        searchBtn.setBackground(Color.darkGray);

        searchBtn.setForeground(Color.WHITE);
        algorithm.setForeground(Color.black);
        searchBy.setForeground(Color.black);
        title.setForeground(Color.BLACK);

        By.setFont(new Font("Arial", Font.BOLD, 14));
        searchBtn.setFont(new Font("Arial", Font.BOLD, 14));
        searchbar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        algorithm.setFont(new Font("Arial", Font.BOLD, 16));
        title.setFont(new Font("Arial", Font.BOLD, 28));
        searchBy.setFont(new Font("Arial", Font.BOLD, 16));
        error.setFont(new Font("Tahoma", Font.BOLD, 18));

        background.setBounds(0,0,800,500);
        searchBy.setBounds(250, 260, 200, 37);
        By.setBounds(60, 250, 200, 37);
        rabinKarp.setBounds(420,200,100,37);
        kmp.setBounds(260, 200, 70, 37);
        searchBtn.setBounds(470, 150, 100, 37);
        searchbar.setBounds(250, 150, 205, 37);
        naive.setBounds(340,200,70,37);
        title.setBounds(200, 57, 406, 67);
        algorithm.setBounds(30, 200, 235, 37);
        error.setBounds(275, 330, 205, 37);

        listener = new MainActionListener(searchbar,kmp,naive,rabinKarp,searchBy,this);
        searchBtn.addActionListener(listener);
        background.setVisible(true);
        error.setVisible(false);

        add(error);
        add(searchBy);
        add(By);
        add(title);
        add(searchbar);
        add(searchBtn);
        add(algorithm);
        add(kmp);
        add(rabinKarp);
        add(naive);
        add(background);

        setSize(800, 500);
        setTitle("GoogleArticles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public void moveToResultsView(ArrayList<String> list , String order , long time){//move to results page

        resView = new resultsView(list ,order, time);
        this.setContentPane(resView);
        resView.setVisible(true);
        this.repaint();
        this.revalidate();
    }


    public void error(){//show message when not founded results

        error.setVisible(true);
        searchbar.setText("");
    }
    public void serverNotConnected()
    {
        JOptionPane.showMessageDialog(this, "server Not Connected", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
}





