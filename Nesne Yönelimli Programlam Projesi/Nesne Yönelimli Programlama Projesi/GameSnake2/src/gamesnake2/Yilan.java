/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesnake2;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author PC
 */
public class Yilan extends JPanel implements ActionListener {

    JButton btn = new JButton("Yeni Oyun");
    JLabel skor = new JLabel();
    JLabel bos = new JLabel("                               ");
    private int skr = 0;
    private final int b_yukseklik = 300;
    private final int b_genislik = 300;
    private final int parca_size = 10;
    private final int b_butun = 900;
    private final int rand_pos = 29;
    private final int delay = 100;
    private final int x[] = new int[b_butun];
    private final int y[] = new int[b_butun];

    private int parcalar;
    private int yem_x;
    private int yem_y;

    private boolean solaDon = false;
    private boolean sagaDon = true;
    private boolean yukarıDon = false;
    private boolean asagıDon = false;
    private boolean oyun = true;

    private Timer timer;
    private Image parca;
    private Image yem;
    private Image bas;

    public Yilan() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(500, b_yukseklik));
        add(bos);
        add(skor);
        add(btn , BorderLayout.CENTER);
        btn.addActionListener(this);
        btn.setBackground(Color.blue);
        skor.setForeground(Color.white);
        

        resimYukle();
        oyunaBasla();

    }
    
/*
    class btnBas implements ActionListener {
        
        public btnBas(Yilan aThis) {
        }
        
        public void actionPerformed(ActionEvent e) {
            if (!oyun) {
                oyunaBasla();
                btn.setEnabled(true);
                if (oyun) {
                    btn.setEnabled(true);
                }
            }
            if (oyun) {
                btn.setVisible(false);
            }   
            repaint();

        }


    } */

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_A)) && (!sagaDon)) {
                solaDon = true;
                yukarıDon = false;
                asagıDon = false;
            }

            if (((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)) && (!solaDon)) {
                sagaDon = true;
                yukarıDon = false;
                asagıDon = false;
            }

            if (((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_W)) && (!asagıDon)) {
                yukarıDon = true;
                sagaDon = false;
                solaDon = false;
            }

            if (((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_S)) && (!yukarıDon)) {
                asagıDon = true;
                sagaDon = false;
                solaDon = false;
            }
        }
    }

    private void resimYukle() {
        ImageIcon iis = new ImageIcon("C:\\Users\\PC\\Desktop\\GameSnake2\\snake.png");
        parca = iis.getImage();
        ImageIcon iiy = new ImageIcon("C:\\Users\\PC\\Desktop\\GameSnake2\\dots.png");
        yem = iiy.getImage();
        ImageIcon iih = new ImageIcon("C:\\Users\\PC\\Desktop\\GameSnake2\\head.png");
        bas = iih.getImage();
    }

    public void oyunaBasla() {
        parcalar = 3;
        skr = 0;
        oyun = true;
        btn.setVisible(false);
        for (int z = 0; z < 3; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        yem_olustur();
        timer = new Timer(delay, this);
        timer.start();
    }

    private void yem_olustur() {
        int r = (int) (Math.random() * rand_pos);
        yem_x = (r * parca_size);
        yem_y = (r * parca_size);
    }

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 300, 300);
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(2));
        g2.draw(rect);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (oyun) {

            g.drawImage(yem, yem_x, yem_y, this);

            for (int z = 0; z < parcalar; z++) {
                if (z == 0) {
                    g.drawImage(bas, x[z], y[z], this);
                } else {
                    g.drawImage(parca, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            oyunBitti(g);
        }
    }

    public void oyunBitti(Graphics g) {
        btn.setVisible(true);
        String msj = "Oyun Bitti";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msj, (b_genislik - metr.stringWidth(msj)) / 2, b_yukseklik / 2);

    }

    private void sartlar() {
        for (int z = parcalar; z > 3; z--) {

            if ((z > 0) && (x[0] == x[z]) && (y[0] == y[z])) {
                oyun = false;

            }
        }
        if (x[0] < 0) {
            x[0] += b_genislik;
        }
        if (y[0] < 0) {
            y[0] += b_yukseklik;
        }

        if (y[0] >= b_yukseklik) {
            y[0] = 0;
        }

        if (x[0] >= b_genislik) {
            x[0] = 0;
        }

        if (!oyun) {
            timer.stop();
        }
    }

    private void hareket() {
        for (int z = parcalar; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        } 

        if (solaDon) {
            x[0] -= parca_size;
        }

        if (sagaDon) {
            x[0] += parca_size;
        }

        if (yukarıDon) {
            y[0] -= parca_size;
        }

        if (asagıDon) {
            y[0] += parca_size;
        }
    }

    private void buyu() {
        if ((x[0] == yem_x) && (y[0] == yem_y)) {

            parcalar++;
            yem_olustur();
            skr += 5;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btn){
             if (!oyun) {
                oyunaBasla();
                btn.setEnabled(true);
                if (oyun) {
                    btn.setEnabled(true);
                }
            }
            if (oyun) {
                btn.setVisible(false);
            }           
        }

        if (oyun) {

            buyu();
            sartlar();
            hareket();
            skor.setText("                                            " + "                                    Skor:  " + skr);
        }
        updateUI();
    }

}
