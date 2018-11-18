package huffman;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public final class HuffmanCompress {
	
public static void main(String[] args) throws IOException {
    String s =System.getProperty("user.dir");
    System.out.println("Current relative path is: " + s);
		File outputFile = new File(s+"\\out.txt");
                String pesanDes="pesan huffman kompress";

                FrequencyTable freq = getFrequencies(pesanDes);
		freq.increment(256);  // EOF symbol gets a frequency of 1
		CodeTree code = freq.buildCodeTree();
		CanonicalCode canonCode = new CanonicalCode(code, 257);
		code = canonCode.toCodeTree();  // Replace code tree with canonical one. For each symbol, the code value may change but the code length stays the same.

		// Read input file again, compress with Huffman coding, and write output file
		//InputStream in = new BufferedInputStream(new FileInputStream(inputFile));
		BitOutputStream out = new BitOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
		try {
			writeCode(out, canonCode);
                        compress(code, pesanDes, out);
		} finally {
			out.close();
			//in.close();
		}

	}

        private static FrequencyTable getFrequencies(String file) throws IOException {
		FrequencyTable freq = new FrequencyTable(new int[257]);

                 int x=0;
                char[]ar=file.toCharArray();
                for(int i=0;i<file.length();i++){
                    int b=(int)ar[i];
                     //System.out.println(x+"="+ar[i]+"="+b);//38=j=106
                     x++;
			freq.increment(b);
                }
		return freq;
	}
        
	
//	private static FrequencyTable getFrequencies(File file) throws IOException {
//		FrequencyTable freq = new FrequencyTable(new int[257]);
//		InputStream input = new BufferedInputStream(new FileInputStream(file));
//		try {
//			while (true) {
//				int b = input.read();
//				if (b == -1)
//					break;
//				freq.increment(b);
//			}
//		} finally {
//			input.close();
//		}
//		return freq;
//	}
	
	
	static void writeCode(BitOutputStream out, CanonicalCode canonCode) throws IOException {
		for (int i = 0; i < canonCode.getSymbolLimit(); i++) {
			int val = canonCode.getCodeLength(i);
			// For this file format, we only support codes up to 255 bits long
			if (val >= 256)
				throw new RuntimeException("The code for a symbol is too long");
			
			// Write value as 8 bits in big endian
			for (int j = 7; j >= 0; j--)
				out.write((val >>> j) & 1);
		}
	}
	

        static void compress(CodeTree code, String in, BitOutputStream out) throws IOException {
		HuffmanEncoder enc = new HuffmanEncoder(out);
		enc.codeTree = code;
                int x=0;
                char[]ar=in.toCharArray();
                for(int i=0;i<in.length();i++){
                    int b=(int)ar[i];
                  //   System.out.println(x+"="+ar[i]+"="+b);
                     x++;
			enc.write(b);//dataIn tulis ke output
                }
		enc.write(256);  // EOF
	}
        
//	static void compress(CodeTree code, InputStream in, BitOutputStream out) throws IOException {
//		HuffmanEncoder enc = new HuffmanEncoder(out);
//		enc.codeTree = code;
//                int x=0;
//		while (true) {
//			int b = in.read();//dataIn
//                        System.out.println(x+"="+b+"="+(char)b);x++;
//			if (b == -1)
//				break;
//			enc.write(b);//dataIn tulis ke output
//		}
//		enc.write(256);  // EOF
//	}
	
}
