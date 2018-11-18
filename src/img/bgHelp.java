package img;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bgHelp extends JPanel {
    private Image image;//buat variable image

    public bgHelp(){
        image = new ImageIcon(getClass().getResource("/img/helpbg.jpg")).getImage();
    }//memanggil gambar

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics gd = (Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), this);//menggabar image
        gd.dispose();
    }
}
