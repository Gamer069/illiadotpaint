package me.illia.illiapaint;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintArea extends JComponent {
    protected Image img;
    protected static Graphics2D graphs;
    protected static int mouseX, mouseY, oldMouseX, oldMouseY;

    public PaintArea() {
        setDoubleBuffered(false);
        addMouseListener(new PaintAreaMouseStuff());
        addMouseMotionListener(new PaintAreaMouseStuff());
    }
    // This is only for instance stuff, ok?
    protected PaintArea(int hello) {
    }

    @Override
    protected void paintComponent(@NotNull Graphics graphs) {
        soutOneTime(graphs.getClass().getSimpleName());
        PaintArea.graphs = (Graphics2D) graphs;

        if (img == null) {
            img = createImage(getSize().width, getSize().height);
            PaintArea.graphs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            clearArea();
        }
        graphs.drawImage(img, 0, 0, null);
    }
    public void clearArea() {
        graphs.setPaint(Color.white);
        graphs.fillRect(0, 0, getSize().width, getSize().height);
        graphs.setPaint(Color.black);
        repaint();
    }
    public void soutOneTime(String whatToSout) {
        int times = 1;
        while (times == 1) {
            System.out.println(whatToSout);
            times--;
        }
        while (times < 1) {
            System.out.print("");
        }
    }
    public void setColor(Color col) {
        int times = 1;
        if (graphs != null) {
            graphs.setPaint(col);
        } else {
            while (times == 1) {
                System.out.println("graphs = null");
                times -= 1;
            }
            while (times < 1) {
                System.out.print("");
            }
        }
    }

    private static class PaintAreaMouseStuff implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            PaintArea.oldMouseX = e.getX();
            PaintArea.oldMouseY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            PaintArea.mouseX = e.getX();
            PaintArea.mouseY = e.getY();

            if (PaintArea.graphs != null) {
                PaintArea.graphs.drawLine(oldMouseX, oldMouseY, PaintArea.mouseX, PaintArea.mouseY);
                PaintArea INSTANCE = new PaintArea(1);
                INSTANCE.repaint();
                oldMouseX = mouseX;
                oldMouseY = mouseY;
            } else {
                System.out.println("PaintArea.graphs is null");
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
