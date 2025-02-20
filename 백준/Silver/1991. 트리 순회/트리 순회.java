import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Bst tree = new Bst();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			char rootValue = input[0].charAt(0);
			char value1 = input[1].charAt(0);
			char value2 = input[2].charAt(0);
			tree.insert(rootValue, value1, value2);
		}

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);

		System.out.print(sb);
	}

}

class Bst {
	Node root;

	Bst() {
		root = null;
	}

	void insert(char rootValue, char value1, char value2) {
		if (root == null) {
			root = new Node(rootValue);
		}
		
		insertNode(root, rootValue, value1, value2);
	}

	void insertNode(Node current, char rootValue, char value1, char value2) {
		if (current == null) return;
		
		if (current.value == rootValue) {
			current.left = (value1 == '.') ? null : new Node(value1);
			current.right = (value2 == '.') ? null : new Node(value2);
		} else {
			insertNode(current.left, rootValue, value1, value2);
			insertNode(current.right, rootValue, value1, value2);
		}
	}

	void preorder(Node root) {
		if (root != null) {
			System.out.print(root.value);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.value);
			inorder(root.right);
		}
	}
	
	void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.value);
		}
	}
}

class Node {
	char value;
	Node left, right;

	Node(char value) {
		this.value = value;
		this.left = this.right = null;
	}
}