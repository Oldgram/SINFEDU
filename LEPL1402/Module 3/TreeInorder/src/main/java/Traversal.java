import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root.left != null) {
            recursiveInorder(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            recursiveInorder(root.right, res);
        }
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        Node current = root;
        Stack<Node> history = new Stack<>();

        while (true) {
            if (current.left != null) {
                history.push(current);
                current = current.left;
            } else {
                res.add(current.val);
                if (!history.empty()) {
                    current = history.pop();
                    res.add(current.val);
                }
                while (current.right == null && !history.empty()) {
                    current = history.pop();
                    res.add(current.val);
                }
                if (current.right == null && history.empty()) {
                    return;
                }
                if (current.right != null) {
                    current = current.right;
                }
            }
        }
    }

}
