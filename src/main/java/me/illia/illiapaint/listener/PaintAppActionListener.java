package me.illia.illiapaint.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static me.illia.illiapaint.app.PaintApp.*;

public class PaintAppActionListener implements ActionListener {
    public static Color COLOR = Color.black;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CLEAR_BTN) {
            AREA.clearArea();
            update();
        } else if (e.getSource() == COLOR_BTN) {
            COLOR = JColorChooser.showDialog(PANEL, "Select a color", Color.black);
            
            update();
        }
    }
    public static void update() {
        AREA.setColor(COLOR);
        
        PANEL.updateUI();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
