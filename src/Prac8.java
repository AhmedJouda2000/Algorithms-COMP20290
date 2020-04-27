/**
 * The {@code Prac8} class constructs a trie and allows search through it.
 *
 * @author Ahmed Jouda
 */
public class Prac8 {
	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26;

	// class for Trie node
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

	// If not key present, inserts into trie
	// If the key is prefix of Trie node,
	// marks leaf node
	static void insert(String key) {

		int level;
		int wordLength = key.length();
		int letterIndex;

		// set current node as a root node
		TrieNode tNode = root;

		for (level = 0; level < wordLength; level++) {
			// set the current letter as the first letter of the word
			letterIndex = key.charAt(level) - 'a';
			// If the current node has already an existing reference to the current letter
			// (through one of the elements in the “children” field), then set current node
			// to that referenced node. Otherwise, create a new node, set the letter equal
			// to the current letter, and also initialize current node to this new node
			if (tNode.children[letterIndex] == null)
				tNode.children[letterIndex] = new TrieNode();

			tNode = tNode.children[letterIndex];
		}

		// mark last node as leaf
		tNode.isEndOfWord = true;

	}

	// Returns true if key presents in trie, else false
	static boolean search(String key) {

		int level;
		int wordLength = key.length();
		int letterIndex;
		TrieNode tNode = root;

		// get children of the root & iterate through each char of the string
		for (level = 0; level < wordLength; level++) {
			letterIndex = key.charAt(level) - 'a';

			// Check whether that character is already a part of a sub-trie. If it isn't
			// present anywhere in the trie, then stop the search and return false
			if (tNode.children[letterIndex] == null)
				return false;

			tNode = tNode.children[letterIndex];
		}

		return (tNode != null && tNode.isEndOfWord);

	}

	//Simple test
	public static void simpleTest() {
		// Input keys (use only 'a' through 'z' and lower case)
				String keys[] = {"red", "blue", "yellow"};
				root = new TrieNode();

				// Construct trie
				int i;
				for (i = 0; i < keys.length; i++) {
					insert(keys[i]);
				}

				// Search for different keys
				
				//should be present
				if (search("blue") == true) {
					System.out.println("blue = Present in trie");
				} else
					System.out.println("blue = Not present in trie");
				
				//shouldn't be present
				if (search("filter") == true) {
					System.out.println("filter = Present in trie");
				} else
					System.out.println("filter = Not present in trie");
	}
	
	// Driver
	public static void main(String args[]) {

		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		// Construct trie
		long starttime = System.nanoTime();
		int i;
		for (i = 0; i < keys.length; i++) {
			insert(keys[i]);
		}
		long endtime = System.nanoTime();
		long total = endtime - starttime;
		System.out.println("time to insert keys:  " + total);

		// Search for different keys
		
		//should be present
		if (search("simple") == true) {
			System.out.println("simple = " + output[1]);
		} else
			System.out.println("simple = " + output[0]);
		
		//should be present
		if (search("filter") == true) {
			System.out.println("filter = " + output[1]);
		} else
			System.out.println("filter = " + output[0]);

		//shouldn't be present
		if (search("test") == true) {
			System.out.println("test = " + output[1]);
		} else
			System.out.println("test = " + output[0]);

		//shouldn't be present
		if (search("available") == true) {
			System.out.println("available = " + output[1]);
		} else
			System.out.println("available = " + output[0]);

	}

}
