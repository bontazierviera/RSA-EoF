package huffman;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


// Decompresses an input file that was compressed with HuffmanCompress, to an output file.
public final class playDeHuffman {
String fileNameDecrypt="";	

public void deHuffman(String filename,String outs,Integer d,BigInteger n) throws IOException {
    this.fileNameDecrypt=outs;
		File inputFile = new File(filename);
		File outputFile = new File(outs);
                 System.out.println("filename="+filename);
                 System.out.println("outs"+outs);
                 
                //String pesanDesE="                                                                                                                                                                                                                                            ðþèÀ¾:2£·’Ô¹á34'%{.h¶À";
		//BitInputStream in = new BitInputStream(new BufferedInputStream(new FileInputStream(inputFile)));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
                FileInputStream filedibaca = new FileInputStream(inputFile);
                BitInputStream in = new BitInputStream(new BufferedInputStream(filedibaca));

		try {
			CanonicalCode canonCode = readCode(in);
			CodeTree code = canonCode.toCodeTree();
			decompress(code, in, out);
		} finally {
			out.close();
			in.close();
		}
                
                
String current;
String data = "";            
          int s;
          BufferedReader be = be = new BufferedReader(new FileReader(outs));
            while ((current = be.readLine()) != null) {
                // menyimpan data file ke variable string 'data'
                data +=  current;
            }
       
            //=============================================================
            String[] data1 = data.split(" ");
            //Proses dekripsi RSA
            BigInteger[] data2 = new BigInteger[data1.length];
            for (int i=0; i < data1.length; i++){
                data2[i] = (new BigInteger(String.valueOf(data1[i]))).pow(d);
                data2[i] = data2[i].mod(n);
             }
                
            byte[] data3 = new byte[data2.length];
             for (int i=0; i < data2.length; i++){
                data3[i] = (byte) (data2[i].byteValue());             
            }
             
//            System.out.println("Data   : " + data);
//            System.out.println("Data 1 : " + Arrays.toString(data1));
//            System.out.println("Data 2 : " + Arrays.toString(data2));
//            System.out.println("Data 3 : " + Arrays.toString(data3));
            
            this.saveDecryption(data3);
            
	}
	  private void saveDecryption(byte[] dataDecrypt) throws IOException {
       Path path = Paths.get(this.fileNameDecrypt);
        //System.out.println(path);
       Files.write(path, dataDecrypt); //creates, overwrites
       System.out.println("File Berhasil di dekripsi ! lihat di : " + this.fileNameDecrypt);
                 
     }
	
	static CanonicalCode readCode(BitInputStream in) throws IOException {
		int[] codeLengths = new int[257];
		for (int i = 0; i < codeLengths.length; i++) {
			// For this file format, we read 8 bits in big endian
			int val = 0;
			for (int j = 0; j < 8; j++) 
				val = val << 1 | in.readNoEof();
			codeLengths[i] = val;
		}
		return new CanonicalCode(codeLengths);
	}
	
        static void decompress(CodeTree code, BitInputStream in, OutputStream out) throws IOException {
		HuffmanDecoder dec = new HuffmanDecoder(in);
		dec.codeTree = code;
		while (true) {
			int symbol = dec.read();
			if (symbol == 256)  // EOF symbol
				break;
			out.write(symbol);
		}
	}
}
