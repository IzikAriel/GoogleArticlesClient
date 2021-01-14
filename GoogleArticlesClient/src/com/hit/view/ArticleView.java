package com.hit.view;
import resources.Scoop;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ArticleView  extends JFrame {

    private HashMap<String, String> article;
    private JLabel title,author,subject,publish,popular,nameauthor,namesubject,datepublish,countofview,background;
    private TextArea textf;
    private ImageIcon bgImg ;

    public ArticleView(  HashMap<String, String> article){

        this.article = article;
        initialization();
    }

    public void initialization()
    {
        bgImg = new ImageIcon(Scoop.rec("bgart.jpg"));
        background=new JLabel(bgImg);
        title = new JLabel(article.get("title"));
        author = new JLabel(article.get("author"));
        subject = new JLabel(article.get("subject"));
        publish = new JLabel(article.get("publish"));
        popular = new JLabel(article.get("popular"));
        nameauthor= new JLabel("Author:");
        namesubject= new JLabel("Subject:");
        datepublish= new JLabel("Publish:");
        countofview = new JLabel("Count of View:");
        textf = new TextArea();

        //split the text ,to view nice in textarea
        String str = article.get("content");
        String[] arrOfStr = str.split(" ");
        textf.setText(textf.getText() +" "+arrOfStr[0] );
        for (int i=1 ; i< arrOfStr.length ; i++)
        {
            if (i % 8 == 0 )
            {
                textf.setText(textf.getText() +arrOfStr[i]  +"\n");
            }
            else {textf.setText(textf.getText() +" "+arrOfStr[i] );}
        }

        title.setFont(new Font("Arial", Font.BOLD, 24));
        nameauthor.setFont(new Font("Arial", Font.BOLD, 14));
        author.setFont(new Font("Arial", Font.BOLD, 14));
        subject.setFont(new Font("Arial", Font.BOLD, 14));
        namesubject.setFont(new Font("Arial", Font.BOLD, 14));
        publish.setFont(new Font("Arial", Font.BOLD, 14));
        datepublish.setFont(new Font("Arial", Font.BOLD, 14));
        popular.setFont(new Font("Arial", Font.BOLD, 15));
        countofview.setFont(new Font("Arial", Font.BOLD, 14));
        textf.setFont(new Font("Arial", Font.BOLD, 14));

        title.setForeground(Color.BLACK);
        author.setForeground(Color.BLACK);
        nameauthor.setForeground(Color.BLACK);
        subject.setForeground(Color.BLACK);
        namesubject.setForeground(Color.BLACK);
        publish.setForeground(Color.BLACK);
        datepublish.setForeground(Color.BLACK);
        popular.setForeground(Color.BLACK);
        countofview.setForeground(Color.BLACK);
        textf.setBackground(Color.WHITE);

        title.setBounds(75, 35, 500, 67);
        author.setBounds(80, 120, 500, 37);
        nameauthor.setBounds(20, 120, 70, 37);
        subject.setBounds(80, 150, 500, 37);
        namesubject.setBounds(20, 150, 70, 37);
        publish.setBounds(80, 180, 500, 37);
        datepublish.setBounds(20, 180, 70, 37);
        popular.setBounds(520, 600, 50, 37);
        countofview.setBounds(420, 600, 150, 37);
        textf.setBounds(30,250,500,250);
        background.setBounds(0,-75,600,800);

        textf.setEditable(false);
        background.setVisible(true);

        add(author);
        add(nameauthor);
        add(textf);
        add(title);
        add(publish);
        add(datepublish);
        add(subject);
        add(namesubject);
        add(popular);
        add(countofview);
        add(background);

        setSize(600, 800);
        setTitle("GoogleArticle");
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
}



