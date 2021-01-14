package com.hit.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MainActionListener extends Observable implements ActionListener{

    private JTextField key;
    private JCheckBox kmp,naive,rabinKarp;
    private View view;
    private Observer observer;
    private Choice searchBy;

    public MainActionListener(JTextField key,JCheckBox kmp,JCheckBox naive,JCheckBox rabinKarp,Choice searchBy,View view)
    {
        this.kmp=kmp;
        this.naive=naive;
        this.rabinKarp=rabinKarp;
        this.key = key;
        this.view=view;
        this.searchBy = searchBy;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(IsValid()){
            observer= new Observer(key.getText(),WhoCheck(), searchBy.getSelectedItem());
            setChanged();
            notifyObservers(observer);
        }
    }

    private boolean IsValid()//check if enter valid details
    {
        if(key.getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Please Enter a String to Search", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!(kmp.isSelected()||rabinKarp.isSelected()||naive.isSelected())) {
            JOptionPane.showMessageDialog(view, "Please Choose Algoritm To Serach", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if((kmp.isSelected()&&rabinKarp.isSelected())||(kmp.isSelected()&&naive.isSelected())||(naive.isSelected()&&rabinKarp.isSelected()))
        {
            JOptionPane.showMessageDialog(view, "Please Choose Only One  Algoritm To Serach", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;


    }

    private String WhoCheck()//check which algorithm choose
    {
        if(kmp.isSelected())
            return "kmp";
        if(naive.isSelected())
            return "naive";
        else return "rabinkarp";
    }


}
