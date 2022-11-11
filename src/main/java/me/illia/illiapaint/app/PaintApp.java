package me.illia.illiapaint.app;

import me.illia.illiapaint.listener.PaintAppActionListener;
import me.illia.illiapaint.PaintArea;

import javax.swing.*;
import java.awt.*;

import static me.illia.illiapaint.app.AppConsts.*;

public class PaintApp {
    public static final JPanel PANEL = new JPanel();
    public static JFrame FRAME;
    public static JButton CLEAR_BTN, COLOR_BTN;
    public static PaintArea AREA;
    public PaintApp(int windowWidth, int windowHeight, CharSequence title) {
        init(windowWidth, windowHeight, title);
    }
    public void init(int windowWidth, int windowHeight, CharSequence title) {
        WINDOW_WIDTH = windowWidth;
        WINDOW_HEIGHT = windowHeight;
        FRAME = new JFrame((String)title);
        CLEAR_BTN = new JButton("Clear drawing");
        COLOR_BTN = new JButton("Choose color");
        AREA = new PaintArea();

        runApp();
    }
    public void runApp() {
        render();

        applyActionListeners();

//        loop();
    }
    public void render() {
        FRAME.add(PANEL);
        FRAME.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        FRAME.pack();
        FRAME.setVisible(true);

        PANEL.add(CLEAR_BTN);
        PANEL.add(COLOR_BTN);

        PANEL.setLayout(new BorderLayout());
        PANEL.add(AREA, BorderLayout.CENTER);

        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
/*    public void loop() {
          while (FRAME.isVisible()) {
              AREA.setBounds(FRAME.getX(), FRAME.getY(), FRAME.getWidth(), FRAME.getHeight());
              PaintAppActionListener.update();
              loop();
          }
    }
*/
    public void applyActionListeners() {
        CLEAR_BTN.addActionListener(new PaintAppActionListener());
        COLOR_BTN.addActionListener(new PaintAppActionListener());
    }
}
