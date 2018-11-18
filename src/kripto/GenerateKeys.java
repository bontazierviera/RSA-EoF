/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;


public class GenerateKeys {

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private final int BITLENGTH = 6;
    private final int BLOCKSIZE = 256; //blocksize in byte 
    private String direc;
    private String directory;
    private String id;
    private String[] log = new String[6];
    private Random r;

    public GenerateKeys() {
        r = new Random();
        p = BigInteger.probablePrime(BITLENGTH, r);
        q = BigInteger.probablePrime(BITLENGTH, r);
        N = p.multiply(q);
        System.out.println(r.nextInt());
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(BITLENGTH / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
        
        // set nilai log
        log[0] = "p : " + String.valueOf(p);
        log[1] = "q : " + String.valueOf(q);
        log[2] = "n : " + String.valueOf(N);
        log[3] = "phi : " + String.valueOf(phi);
        log[4] = "e : " + String.valueOf(e);
        log[5] = "d : " + String.valueOf(d);

        getLog();
    }
 /**
     * seting direktori tempat menyimpan 
     * sebuah file kunci nantinya.
     * @param directory 
     * @param direc
     */
    public void setDir(String directorypubik) {
        this.directory = directorypubik; //dir untuk save publik key
    }

    public void setDirec(String directoryprivate) {
        this.direc = directoryprivate; //set directory untuk save private key
    }

    public void setId(String id) {
        this.id = id;
    }

    public void createpublic() throws IOException {
        try {
            String fileNamePublik = this.id + ".PublicKey";
            File filePublic = new File(this.directory + fileNamePublik);
            if (!filePublic.exists()) {
                filePublic.createNewFile();
            }
            FileWriter fwPublic = new FileWriter(filePublic.getAbsoluteFile());
            BufferedWriter bwPublic = new BufferedWriter(fwPublic);

            //tulis kunci
            bwPublic.write(id);
            bwPublic.write("\n");
            bwPublic.write(String.valueOf(this.N));
            bwPublic.write("\n");
            bwPublic.write(String.valueOf(this.e));
            Session.setN(String.valueOf(this.N));
            Session.setE(String.valueOf(this.e));

            bwPublic.close();
            System.out.println("Sukses membuat kunci public!, cek di : " + this.directory + fileNamePublik);
        } catch (IOException e) {
        }
    }

    public void createprivite() {
        try {
            String fileNamePrivate = this.id + ".PrivateKey";
            File filePrivate = new File(this.direc + fileNamePrivate);
            if (!filePrivate.exists()) {
                filePrivate.createNewFile();
            }
            FileWriter fwPrivate = new FileWriter(filePrivate.getAbsoluteFile());
            BufferedWriter bwPrivate = new BufferedWriter(fwPrivate);

            // menulis kunci private
            bwPrivate.write(id);
            bwPrivate.write("\n");
            bwPrivate.write(String.valueOf(this.N));// ini yang akan di enkrip
            bwPrivate.write("\n");
            bwPrivate.write(String.valueOf(this.d));// ini yang akan di enkrip

            bwPrivate.close();
            Session.setD(String.valueOf(this.d));
            System.out.println("Sukses membuat kunci private!, cek di : " + this.direc + fileNamePrivate);
        } catch (IOException e) {
        }

    }

    public void createKeys() throws Exception {
        this.createpublic();
        this.createprivite();
    }

    public void getLog() {
        System.out.println(Arrays.toString(log));
    }
}
