/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kripto;

public class Session {
    
private static String username,
                      Password,
                      alamat,
                      nama,
                      nohp,
                      id,
                      e,
                      d,
                      n;

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Session.nama = nama;
    }

    public static String getNohp() {
        return nohp;
    }

    public static void setNohp(String nohp) {
        Session.nohp = nohp;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        Session.alamat = alamat;
    }
    
    public static String getN() {
        return n;
    }

    public static void setN(String n) {
        Session.n = n;
    }
    
    public static String getE() {
        return e;
    }

    public static void setE(String e) {
        Session.e = e;
    }

    public static String getD() {
        return d;
    }
    
    public static void setD(String d) {
        Session.d = d;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Session.id = id;
    }
    
    public static String getUsername() {
        return username;
    }

    public static void setUser(String user) {
        username = user;
    }    

   public static String getPass() {
        return Password;
    }

    public static void setPass(String password) {
        Password = password;
    }
}
