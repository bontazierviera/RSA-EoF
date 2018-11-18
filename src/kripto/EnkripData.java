/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang.StringUtils;

public class EnkripData {

    private String filename,
                  directory,
                  publicFile,
                  fileNameEncrypt,
                  extension;
    
    private BigInteger n;
    private Integer e;
    
    /**
     * untuk seting file yang akan di enkripsi.
     * @param fileName
     */

    public void setFile(String directory, String filename, String extens) {
        
        this.fileNameEncrypt = directory + "/" + "en." + filename+ "." + extens;
            System.out.println("fileNameEncrypt="+fileNameEncrypt);//D:/Lat/en.Sistem Berjalan.doc
     }
 /**
     * untuk mengambil nilai n dan e
     * yang di ambil dari file kunci public
     */
    public void setPublicKey(String filePublic) throws IOException {
         BufferedReader br = null;
        try {
            int batas = 0;
            String current;
            br = new BufferedReader(new FileReader(filePublic));//mebaca file PublicKey
           
            while ((current = br.readLine()) != null) {
                if (batas == 1) {
                    // set nilai modulo dari file kunci publik
                    this.n = new BigInteger(current);
                    Session.setN(current);
                } else if (batas == 2) {
                    // set nilai eksponen e dari file kunci publik
                    this.e = new Integer(current);
                    Session.setE(current);
                }else{
                    Session.setId(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {br.close();}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("nilai n : " + this.n);
        System.out.println("nilai e : " + this.e);
        System.out.println("id : " + Session.getId());
    }
    
     /**
     * untuk melakukan penulisan file
     * yang telah dienkripsi
     * @param dataEncrypt 
     */
    
    public void encrypt(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path); //membaca semua bytes yang ada di object
                       
        // mengubah byte[] data array ke string
        String[] data1 = new String[data.length];
        for(int i=0; i < data.length; i++) {
            data1[i] = String.valueOf(data[i] & 0xff); //unsigned integer
         }
        
        //proses enkripsi RSA
        BigInteger[] data2 = new BigInteger[data1.length];
        for (int i = 0; i < data1.length; i++) {
             data2[i] = (new BigInteger(data1[i])).pow(this.e);
             data2[i] = data2[i].mod(this.n);           
           }
       
        //mengubah value chipertetxt ke string
        String[] x = new String[data2.length];
        for(int i = 0; i < data2.length; i++) {
            x[i] = String.valueOf(data2[i]);                        
        }
        
        // data5 adalah nilai yang akan di masukan kedalam file
        String data5 = StringUtils.join(x, " ");//menggabungkan file dengan spasi
                
        // penyimpanan file enkripsi
        this.saveEncryption(data5);
    }
    
    public void saveEncryption(String dataEncrypt) {
        try {
             String content = dataEncrypt;
           
           //HUFFMAN !!!!content
           File file = new File(this.fileNameEncrypt);////D:/Lat/en.Sistem Berjalan.doc
           System.out.println(this.fileNameEncrypt);
           if (!file.exists()) {
               file.createNewFile();
           }          
           
           // pemanggilan huffman
           huffman.playHuffman x=new huffman.playHuffman(); 
           x.compressHuff(content,file);                     
           
           System.out.println("File Berhasil di enkripsi ! lihat di : "+this.fileNameEncrypt);
                      
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
            
    public String getFileNameEncrypt() {
        return fileNameEncrypt;
    }

    public static void main(String[] args) throws IOException {
    }
}
