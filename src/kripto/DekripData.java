/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DekripData {

    private String filename,
                   directory,
                   publicFile,
                   fileNameDecrypt,
                   extension;
    private BigInteger n;
    private Integer d;
    
    
  /**
     * digunakan untuk seting file enkrip untuk di dekrip
     * mengambil sebagian daripada sebuah directory dan nama file dekripsi.
     * 
     * @param fileName 
     */

    public void setFile(String directory, String filename, String extens) {

           
        this.fileNameDecrypt = directory + "/" + "dec." + filename+ "." + extens;
     
    }
 /**
     * yang mana digunakan untuk mengatur sebagian nilai
     * nilai pada tiap kunci private, akan di ambil dari pada
     * isi sebuah file private modulo n dan eksponen d, nilai
     * tersebut akan di tanam pada tiap-tiap variabel BigInteger d dan n.
     * 
     * @param filePrivate
     */
    public void setPrivateKey(String filePrivate) {
        BufferedReader br = null;
        try {
            int batas = 0;
            String current;
            br = new BufferedReader(new FileReader(filePrivate));
            while ((current = br.readLine()) != null) {
                if (batas == 1) {
                    // set nilai modulo dari file kunci publik
                    this.n = new BigInteger(current);
                    Session.setN(current);
                } else if (batas == 2) {
                    // set nilai eksponen e dari file kunci publik
                    this.d = new Integer(current);
                    Session.setD(current);
                } else {
                    Session.setId(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("nilai n : " + this.n);
        System.out.println("nilai d : " + this.d);
        System.out.println("id : " + Session.getId());
    }

    public void decrypt(String fileName)  {  //////D:/Lat/en-Sistem Berjalan.doc //this.setFile(fileName);
        BufferedReader be = null;
        try {

            huffman.playDeHuffman x=new huffman.playDeHuffman();
            x.deHuffman(fileName, this.fileNameDecrypt,this.d,this.n);
                        
        } catch (IOException e) {
       } finally {
            try {
                if (be != null) {be.close();}
            } catch (IOException ex) {
           }
                    
        }
                   
    }

    private void saveDecryption(byte[] dataDecrypt) throws IOException {
       Path path = Paths.get(this.fileNameDecrypt);
        //System.out.println(path);
       Files.write(path, dataDecrypt); //creates, overwrites
       System.out.println("File Berhasil di dekripsi ! lihat di : " + this.fileNameDecrypt);
       
    }

    public String getFileNameDecrypt() {
        return fileNameDecrypt;
    }

    public static void main(String[] args) {
    }
}