public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree combineWith(Tree o){
        if (o == null) return new Tree(copy(this.root));
        return new Tree(combine(this.root, o.root));
    }

    public Node combine(Node mine, Node other){
	    if (mine == null) return copy(other);
	    if (other == null) return copy(mine);
	    Node newNode = new Node(mine.val += other.val);
	    if (other.left != null) {
	        if (mine.left == null) newNode.left = copy(other.left);
	        else newNode.left = combine(mine.left, other.left);
	    } else if (mine.left != null){
	        newNode.left = copy(mine.left);
	    }
	    if (other.right != null) {
	        if (mine.right == null) newNode.right = copy(other.right);
	        else newNode.right = combine(mine.right, other.right);
	    } else if (mine.right != null) {
	        newNode.right = copy(mine.right);
	    }
	    return newNode;
	}

	public Node copy(Node n) {
	    if (n == null) return null;
	    Node newNode = new Node(n.val);
	    if (n.left != null) {
	        newNode.left = copy(n.left);
	    }
	    if (n.right != null) {
	        newNode.right = copy(n.right);
	    }
	    return newNode;
	}

}