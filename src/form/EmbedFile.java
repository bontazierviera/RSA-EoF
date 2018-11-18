/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import stegano.AlgoritmaEOF;
import stegano.jenisFile;



/**
 *
 * @author Zierviera
 */
public class EmbedFile extends javax.swing.JFrame {
    Dimension UM = Toolkit.getDefaultToolkit().getScreenSize();
    private JFileChooser fileChooser,fileChooserDoc;						
    private File CoverF,SecretF,StegoF,StegoFix;
    private int	hasil,hasil1;
    private String extension;
    
    final String[] EXT = {".jpg",".jpeg",".png",".bmp",".gif"};
    final String[] EXT_DOC = {".docx",".xlsx",".pptx",".pdf",".txt",".doc",".xls",".ppt",".mp3"};
	
    NumberFormat n;
    
    public EmbedFile() {
        initComponents();
        n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        
        //Instalasi fileChooser
        fileChooser = new JFileChooser("D:\\");
        fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new jenisFile(EXT));	

        //Instalasi fileChooserDoc
        fileChooserDoc = new JFileChooser("D:\\");
        fileChooserDoc.setFileSelectionMode(fileChooser.FILES_ONLY);
        fileChooserDoc.setAcceptAllFileFilterUsed(false);
        fileChooserDoc.addChoosableFileFilter(new jenisFile(EXT_DOC));

        
        this.setTitle("Embed File Form");
        setLocation(UM.width/2-getWidth()/2,UM.height/2-getHeight()/2);
        show();
        Awal();
        tampilkanImage();
        }

//Method Untuk Memanggil Image/gambar
 public static BufferedImage loadImage(String ref) {
 BufferedImage bimg = null;
 try {
 bimg = ImageIO.read(new File(ref));
 } catch (Exception e) {
 e.printStackTrace();
 }
 return bimg;
 }
 
 //Method untuk Resize Image
 public static BufferedImage resize(BufferedImage img, int
 newW, int newH) {    
 int w = img.getWidth();
 int h = img.getHeight();
 BufferedImage dimg = dimg = new BufferedImage(newW, newH,
 img.getType());
 Graphics2D g = dimg.createGraphics();
 g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
 RenderingHints.VALUE_INTERPOLATION_BILINEAR);
 g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
 g.dispose();
 return dimg;
 }
 
//Method Untuk Menampilkan Gambar Pada JLabel
public void tampilkanImage(){
String urlGambar = "src/img/logo.png";
BufferedImage loadImg = loadImage(urlGambar);
ImageIcon imageIcon = new ImageIcon(resize(loadImg,
lblGambar.getWidth(), lblGambar.getHeight()));
lblGambar.setIcon(imageIcon);
}    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bgEncrypt1 = new img.bgEncrypt();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        bExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bMaster = new javax.swing.JButton();
        bSaveAs = new javax.swing.JButton();
        Stego = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Secret = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblCover = new javax.swing.JLabel();
        bChooseFile = new javax.swing.JButton();
        btnEmbed = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        LSizeStego = new javax.swing.JLabel();
        LSizeCover = new javax.swing.JLabel();
        LSizeSecret = new javax.swing.JLabel();
        LCover = new javax.swing.JTextField();
        LStego = new javax.swing.JTextField();
        LSecret = new javax.swing.JTextField();
        Cover = new javax.swing.JTextField();
        lblGambar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Copyright 2015 By Bonta Zirviera Cirgon");

        bExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit2.png"))); // NOI18N
        bExit.setToolTipText("Back");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose Cover ");

        bMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/browse2.png"))); // NOI18N
        bMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasterActionPerformed(evt);
            }
        });

        bSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/browse2.png"))); // NOI18N
        bSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveAsActionPerformed(evt);
            }
        });

        Stego.setEditable(false);
        Stego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StegoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Save As");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Choose File");

        Secret.setEditable(false);
        Secret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecretActionPerformed(evt);
            }
        });
        Secret.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SecretKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        lblCover.setBackground(new java.awt.Color(255, 255, 255));
        lblCover.setFont(lblCover.getFont());
        lblCover.setForeground(new java.awt.Color(255, 255, 255));
        lblCover.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCover, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCover, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bChooseFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/browse2.png"))); // NOI18N
        bChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChooseFileActionPerformed(evt);
            }
        });

        btnEmbed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEmbed.setForeground(new java.awt.Color(51, 51, 51));
        btnEmbed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/process.jpg"))); // NOI18N
        btnEmbed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmbedActionPerformed(evt);
            }
        });

        bCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.jpg"))); // NOI18N
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Embed File");

        LSizeStego.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LSizeStego.setForeground(new java.awt.Color(240, 240, 240));
        LSizeStego.setText("Size :");

        LSizeCover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LSizeCover.setForeground(new java.awt.Color(240, 240, 240));
        LSizeCover.setText("Size :");

        LSizeSecret.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LSizeSecret.setForeground(new java.awt.Color(240, 240, 240));
        LSizeSecret.setText("Size :");

        LCover.setEditable(false);

        LStego.setEditable(false);

        LSecret.setEditable(false);

        Cover.setEditable(false);
        Cover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoverActionPerformed(evt);
            }
        });
        Cover.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CoverKeyPressed(evt);
            }
        });

        lblGambar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblGambar.setForeground(new java.awt.Color(255, 255, 255));
        lblGambar.setText(" ");

        javax.swing.GroupLayout bgEncrypt1Layout = new javax.swing.GroupLayout(bgEncrypt1);
        bgEncrypt1.setLayout(bgEncrypt1Layout);
        bgEncrypt1Layout.setHorizontalGroup(
            bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgEncrypt1Layout.createSequentialGroup()
                .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgEncrypt1Layout.createSequentialGroup()
                            .addGap(155, 155, 155)
                            .addComponent(jLabel11)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                    .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                                    .addComponent(Cover, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(bMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgEncrypt1Layout.createSequentialGroup()
                                                    .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Secret, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Stego, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                                    .addComponent(btnEmbed, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(12, 12, 12)
                                    .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                            .addComponent(LSizeCover)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(LCover, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                            .addComponent(LSizeSecret)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(LSecret, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                            .addComponent(LSizeStego)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(LStego, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgEncrypt1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(66, 66, 66))
        );
        bgEncrypt1Layout.setVerticalGroup(
            bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgEncrypt1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LSizeCover)
                            .addComponent(LCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(Cover, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(4, 4, 4)
                .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Secret, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(bgEncrypt1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Stego, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LSecret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LSizeSecret)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LSizeStego)
                                .addComponent(LStego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgEncrypt1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgEncrypt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEmbed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgEncrypt1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgEncrypt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        Awal();
    }//GEN-LAST:event_bCancelActionPerformed

    private void btnEmbedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmbedActionPerformed
if (Secret.getText().equals("") || Stego.getText().equals("") || Cover.getText().equals("")) {
JOptionPane.showMessageDialog(this, "Fullfil the form, Please!", "Warning", JOptionPane.ERROR_MESSAGE);
} else {
    Object embed = evt.getSource();
    if(embed==btnEmbed)
    {
        //Jika klik button EMBED akan mengecek nama File Stego sudah ada atau belum dalam directory yang sama
        if(getStego().exists())
        {
            int hasil1= JOptionPane.showConfirmDialog(null, "The file "+ getStego().getName()+ " does exist!\nDo you want to overwrite?", "Warning", JOptionPane.YES_NO_OPTION);
            if(!(hasil1== JOptionPane.YES_OPTION))
            if(!fileChooserStego())
            return;
        }
               
        //Kondisi memanggil Method EmbedFile pada Class AlgoritmaEOF
        if(AlgoritmaEOF.EmbedFile(getCover(), getStego(),getSecret()))
        {            
            JOptionPane.showMessageDialog(this, AlgoritmaEOF.getMessage(), "Operation Successfully", JOptionPane.INFORMATION_MESSAGE);
            Awal();                     
        }else{
            JOptionPane.showMessageDialog(this, AlgoritmaEOF.getMessage(), "Operation Failed", JOptionPane.ERROR_MESSAGE);
        }
        
        }

}

    }//GEN-LAST:event_btnEmbedActionPerformed

    private void bChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChooseFileActionPerformed
        fileChooserSecret();
    }//GEN-LAST:event_bChooseFileActionPerformed

    private void SecretKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SecretKeyPressed

    }//GEN-LAST:event_SecretKeyPressed

    private void SecretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecretActionPerformed

    private void StegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StegoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StegoActionPerformed

    private void bSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveAsActionPerformed
       if(CoverF  != null && SecretF  != null)
        {
            fileChooserStego();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Choose Cover or File First,Please!", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bSaveAsActionPerformed
 

    private void bMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasterActionPerformed
    JFileChooser datafile = new JFileChooser("D:\\");
    FileNameExtensionFilter Image = new FileNameExtensionFilter("File Images", "jpg","png","bmp");
    datafile.setFileFilter(Image);

    JFileChooser chooser = new JFileChooser("./");
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    int returnVal = datafile.showOpenDialog(null);

    if(returnVal == JFileChooser.APPROVE_OPTION) {
        CoverF = datafile.getSelectedFile();
        String dir = CoverF.getAbsolutePath();
        try {
              Cover.setText(CoverF.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon((ImageIO.read(new File(Cover.getText())))); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(lblCover.getWidth(), lblCover.getHeight(), java.awt.Image.SCALE_SMOOTH); // agar gambar sesuai label
            imageIcon = new ImageIcon(newimg);  // transform it back
           
            
            //mengambil size cover
            Long Size = (getCover().length())/1024;
            if(Size > 1024) {
                LCover.setText(String.valueOf(n.format(Size/1024.0))+" MB");
            }else{
                LCover.setText(String.valueOf(n.format(Size))+" KB");
            }
            lblCover.setIcon(imageIcon);

        } catch (Exception except) {
            //msg if opening fails
            JOptionPane.showMessageDialog(this, "The Image cannot be opened!",
                "Error!", JOptionPane.INFORMATION_MESSAGE);
            Cover.setText("");
            lblCover.setIcon(null);
        }

    }
    }//GEN-LAST:event_bMasterActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bExitActionPerformed

    private void CoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CoverActionPerformed

    private void CoverKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CoverKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CoverKeyPressed
public boolean fileChooserSecret()
{
 hasil = fileChooserDoc.showDialog(null, "File Secret");
     if(hasil == fileChooserDoc.APPROVE_OPTION){
        SecretF = fileChooserDoc.getSelectedFile();
        String dir = SecretF.getAbsolutePath();
        Secret.setText(dir);

        if(getSecret().length()/1024 > 1024){
            LSecret.setText(n.format(getSecret().length()/1024.0/1024.0)+" MB");
        }else {
            LSecret.setText(getSecret().length()/1024+" KB");
        }
        LSecret.setForeground(Color.BLUE);
    }
    return true;
}

public boolean fileChooserStego() {
String value = CoverF.getName();
String extension = value.substring(value.length()-4, value.length());

if(extension.substring(0,1).equals("."))
{
extension = value.substring(value.length()-3, value.length());
}

File FileSebelumnya = fileChooser.getSelectedFile();
hasil = fileChooser.showDialog(null, "Output File Stego");

if(hasil == fileChooser.APPROVE_OPTION)
{
StegoF = fileChooser.getSelectedFile();
StegoFix = new File(StegoF.getAbsolutePath()+"."+extension);
String dir = StegoFix.getAbsolutePath();
Stego.setText(dir);

Long Size = (getCover().length()+getSecret().length())/1024;
if(Size > 1024)
{
LStego.setText(String.valueOf(n.format(Size/1024.0))+" MB");
}
else
{
LStego.setText(String.valueOf(n.format(Size))+" KB");
}
LStego.setForeground(Color.RED);

if(StegoFix.exists())
{
hasil1 = JOptionPane.showConfirmDialog(null, "File "+StegoFix.getName()+" does exist, try different name!","Warning", JOptionPane.YES_NO_OPTION);
if(hasil1 == JOptionPane.NO_OPTION)
{
if(FileSebelumnya != null)
{
fileChooser.setSelectedFile(FileSebelumnya);
}
}
else
return fileChooserStego();
}
}
return true;
}

public boolean fileChooserCover()
{   
hasil = fileChooser.showDialog(null, "File Cover");
if(hasil == fileChooser.APPROVE_OPTION){
    CoverF = fileChooser.getSelectedFile();
    String dir = CoverF.getAbsolutePath();
    Cover.setText(dir);

    if(getCover().length()/1024 > 1024) {
        LCover.setText(n.format(getCover().length()/1024.0/1024.0)+" MB");
    }else {
        LCover.setText(getCover().length()/1024+" KB");
    }
    LCover.setForeground(Color.BLUE);
}
return true;
}   
    
    String tambah;public void Awal(){
        bChooseFile.setEnabled(true);
        bMaster.setEnabled(true);
        bSaveAs.setEnabled(true);
        Secret.setText("");
        Cover.setText("");
        Stego.setText("");
        LCover.setText("");
        LStego.setText("");
        LSecret.setText("");
        lblCover.setText("");
        CoverF = null;
        SecretF = null;
        StegoF = null;
}
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmbedFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmbedFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmbedFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmbedFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmbedFile().setVisible(true);
            }
        });
    }
    
public File getCover() 
	{
		return CoverF;
	}
	public File getSecret() 
	{
		return SecretF;
	}
	public File getStego() 
	{
		return StegoFix;
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cover;
    private javax.swing.JTextField LCover;
    private javax.swing.JTextField LSecret;
    private javax.swing.JLabel LSizeCover;
    private javax.swing.JLabel LSizeSecret;
    private javax.swing.JLabel LSizeStego;
    private javax.swing.JTextField LStego;
    private javax.swing.JTextField Secret;
    private javax.swing.JTextField Stego;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bChooseFile;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bMaster;
    private javax.swing.JButton bSaveAs;
    private img.bgEncrypt bgEncrypt1;
    private javax.swing.JButton btnEmbed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCover;
    private javax.swing.JLabel lblGambar;
    // End of variables declaration//GEN-END:variables
}