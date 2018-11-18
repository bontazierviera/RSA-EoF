package img;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bgEncrypt extends JPanel {
    private Image image;//buat variable image

    public bgEncrypt(){
        image = new ImageIcon(getClass().getResource("/img/enkrip.jpg")).getImage();
    }//memanggil gambar

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics gd = (Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), this);//menggabar image
        gd.dispose();
    }
}
