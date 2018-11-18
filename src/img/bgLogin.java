/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package img;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Zierviera
 */
public class bgLogin extends JPanel{
    private Image image;//buat variable image
    
    public bgLogin(){
        image = new ImageIcon(getClass().getResource("/img/bgLogin.png")).getImage();
    }//memanggil gambar

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics gd = (Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), this);//menggabar image
        gd.dispose();
    }
}
