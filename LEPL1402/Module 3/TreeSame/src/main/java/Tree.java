public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Tree) {
            Tree other = (Tree) o;
            if (this.root == null && other.root == null) {
                return true;
            }
            if (this.root == null && other.root != null || this.root != null && other.root == null) {
                return false;
            }
            if (this.root.equals(other.root)) {
                Tree thisLeftTree = new Tree(this.root.left);
                Tree thisRightTree = new Tree(this.root.right);
                Tree otherLeftTree = new Tree(other.root.left);
                Tree otherRightTree = new Tree(other.root.right);
                return (thisLeftTree.equals(otherLeftTree) && thisRightTree.equals(otherRightTree));
            }
        }
        return false;
    }

}