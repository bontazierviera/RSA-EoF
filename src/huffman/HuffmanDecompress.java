package huffman;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;


// Decompresses an input file that was compressed with HuffmanCompress, to an output file.
public final class HuffmanDecompress {
	
public static void main(String[] args) throws IOException {
        String s =System.getProperty("user.dir");
        System.out.println("Current relative path is: " + s);

		File inputFile = new File(s+"\\out.txt");
		File outputFile = new File(s+"\\dekompress.txt");

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
