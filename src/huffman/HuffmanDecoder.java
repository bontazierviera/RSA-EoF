package huffman;

import java.io.IOException;


public final class HuffmanDecoder {
	
	private BitInputStream input;
	
	// Must be initialized before calling read().
	// The code tree can be changed after each symbol decoded, as long as the encoder and decoder have the same code tree at the same time.
	public CodeTree codeTree;
	
	
	
	public HuffmanDecoder(BitInputStream in) {
		if (in == null)
			throw new NullPointerException("Argument is null");
		input = in;
	}
	
	
	
	public int read() throws IOException {
		if (codeTree == null)
			throw new NullPointerException("Code tree is null");
		
		InternalNode currentNode = codeTree.root;
                  //System.out.println("input="+input);

		while (true) {
			int temp = input.readNoEof();
                     //   System.out.println("temp="+temp);
//input=Huffman.BitInputStream@1dc696e
//temp=1
//temp=1
//temp=1
//temp=1
//temp=1
//temp=0    
			Node nextNode;
			if      (temp == 0) nextNode = currentNode.leftChild;
			else if (temp == 1) nextNode = currentNode.rightChild;
			else throw new AssertionError();
			
			if (nextNode instanceof Leaf)
				return ((Leaf)nextNode).symbol;
			else if (nextNode instanceof InternalNode)
				currentNode = (InternalNode)nextNode;
			else
				throw new AssertionError();
		}
	}
	
}
