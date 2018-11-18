package huffman;
public class Huffman{
    public Huffman(){}
    static void init(){
        if(udahInit){return;} 
        else{
            udahInit = true;
            cc[32] = "1011";//A 10111100 01111001 10
            cc[33] = "1100011";//B =
            cc[34] = "1100110";//C    ABC =10000001 11000000 11110000=24
            cc[39] = "1100100";
            cc[40] = "11111010";
            cc[41] = "11111011";
            cc[44] = "1100001";
            cc[45] = "1100101";
            cc[46] = "1100000";
            cc[47] = "1111011";
            cc[48] = "1110000";
            cc[49] = "1110001";
            cc[50] = "1110010";
            cc[51] = "1110011";
            cc[52] = "1110100";
            cc[53] = "1110101";
            cc[54] = "1110110";
            cc[55] = "1110111";
            cc[56] = "1111000";
            cc[57] = "1111001";
            cc[58] = "1111100";
            cc[63] = "1100010";
            cc[64] = "1111010";
            cc[65] = "1000000";
            cc[66] = "10000101";
            cc[67] = "1001101";
            cc[68] = "10001011";
            cc[69] = "1100111";
            cc[70] = "10011001";
            cc[71] = "10010101";
            cc[72] = "1001000";
            cc[73] = "1000001";
            cc[74] = "100110001001";
            cc[75] = "1001100011";
            cc[76] = "1001001";
            cc[77] = "10010100";
            cc[78] = "1000110";
            cc[79] = "1000100";
            cc[80] = "10010110";
            cc[81] = "1001100010000";
            cc[82] = "1000111";
            cc[83] = "1000011";
            cc[84] = "100111";
            cc[85] = "10010111";
            cc[86] = "1000101001";
            cc[87] = "1000101000";
            cc[88] = "10011000101";
            cc[89] = "10000100";
            cc[90] = "1001100010001";
            cc[97] = "00000";
            cc[98] = "000101";
            cc[99] = "01101";
            cc[100] = "001011";
            cc[101] = "1010";
            cc[102] = "011001";
            cc[103] = "010101";
            cc[104] = "01000";
            cc[105] = "00001";
            cc[106] = "0110001001";
            cc[107] = "01100011";
            cc[108] = "01001";
            cc[109] = "010100";
            cc[110] = "00110";
            cc[111] = "00100";
            cc[112] = "010110";
            cc[113] = "01100010000";
            cc[114] = "00111";
            cc[115] = "00011";
            cc[116] = "0111";
            cc[117] = "010111";
            cc[118] = "00101001";
            cc[119] = "00101000";
            cc[120] = "011000101";
            cc[121] = "000100";
            cc[122] = "01100010001";
            return;
        }
    }

    static String huffmanSisanya(char kar){
        String s = Integer.toBinaryString(kar);
        s = "0000000000000000".substring(0, 16 - s.length()) + s;
        return ccSISANYA + s;
    }

    static byte[] stringKeByteA(String st){
        int lenAsli = st.length();
        st = st + "11111111";
        byte hs[] = new byte[(lenAsli + 7) / 8];
        for(int i = 0; i < lenAsli; i += 8){
            String sebyte = st.substring(i, i + 8);
            byte b = (byte)Integer.parseInt(sebyte, 2);
            hs[i / 8] = b;
        }
        return hs;
    }

    public static byte[] huffman(String st){
        init();
        String jadi = "";
        for(int i = 0; i < st.length(); i++){
            char kar = st.charAt(i);
            if(kar >= '\200')
                jadi = jadi + huffmanSisanya(kar);
            else
            if(cc[kar] != null)
                jadi = jadi + cc[kar];
            else
                jadi = jadi + huffmanSisanya(kar);
        }
        return stringKeByteA(jadi);
    }

    static int cariKar(String buf){
        if(buf.length() > 23)
            return -2;
        if(buf.length() == 23 && buf.substring(0, 7).equals(ccSISANYA))
            return Integer.parseInt(buf.substring(7), 2);
        for(int i = 0; i < 128; i++)
            if(cc[i] != null && cc[i].equals(buf))
                return i;

        return -1;
    }

    static String byteAKeString(byte ba[]){
        String hs = "";
        for(int i = 0; i < ba.length; i++){
            int b = ba[i];
            if(b < 0)
                b += 256;
            String tp = Integer.toBinaryString(b);
            tp = "00000000".substring(0, 8 - tp.length()) + tp;
            hs = hs + tp;
        }
        return hs;
    }
    
    static String byteAKeStrings(String ba){
        String hs = "";
        char[]kr=ba.toCharArray();
        for(int i = 0; i < ba.length(); i++){
            int b = (int) kr[i];
            if(b < 0){b =b+ 256;}
            else if(b >= 256){b = b % 256;}
         //   //System.out.println(i+"===>"+b+"==>"+ba.substring(i,i+1));//karakter ZIP
            
            String tp = Integer.toBinaryString(b);
            tp = "00000000".substring(0, 8 - tp.length()) + tp;
            hs = hs + tp;
        }
        //System.out.println("hs="+hs);
        return hs;
    }
    public static String[] stringKeString(String st){
    	//System.out.println("ST=>"+st);
        int lenAsli = st.length();
        st = st + "11111111";
        byte hs[] = new byte[(lenAsli + 7) / 8];
        String [] ht=new String[(lenAsli + 7) / 8];
        for(int i = 0; i < lenAsli; i += 8){
            String sebyte = st.substring(i, i + 8);
            byte b = (byte)Integer.parseInt(sebyte, 2);
            int aa=i/8;
            hs[i / 8] = b;
            ht[i / 8] = String.valueOf((char)b);
        }
        return ht;
}
 
    public static String dehuffman(String ba){
        init();
        String gab= byteAKeStrings(ba);
        String hs = "";
        String buf = "";

        char[]kr=gab.toCharArray();
        for(int i = 0; i < gab.length(); i++){
            char kar = kr[i];
            buf = buf + kar;
            int c = cariKar(buf);
            if(c >= 0){
                buf = "";
                hs = hs + (char)c;
            } else
            if(c == -2)
                buf = "";
        }
        return hs;
    }
 
public static  String[] myhuffman(String st){
        init();
        String jadi = "";
        for(int i = 0; i < st.length(); i++)
        {
            char kar = st.charAt(i);
            if(kar >= '\200')
                jadi = jadi + huffmanSisanya(kar);
            else
            if(cc[kar] != null)
                jadi = jadi + cc[kar];
            else
                jadi = jadi + huffmanSisanya(kar);
        }

return stringKeString(jadi);
}
static String cc[] = new String[128];
static String ccSISANYA = "1111110";
static String ccDIPESAN = "1111111";
static boolean udahInit = false;

public static void main(String args[]){
        String pesan="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String []dat=myhuffman(pesan);
    	String gab="";
    	for(int j=0;j<dat.length;j++){
    		gab=gab+dat[j];
    	}
    	System.out.println("PESAN:"+pesan +" ="+pesan.length());
    	System.out.println("ZIP:"+gab +" ="+gab.length());
    	//====================================================
    	String pesanmasuk=gab;
	String x=dehuffman(pesanmasuk);
    	System.out.println("DEZIP:"+x +" ="+x.length());

}

}