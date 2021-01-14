package com.hit.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ResultsActionListener extends Observable implements ActionListener {

    public ResultsActionListener(){ }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getActionCommand().equals("Back")){
            setChanged();
            notifyObservers("close");
        }
        else{
            setChanged();
            notifyObservers(e.getActionCommand());
        }
    }
}
