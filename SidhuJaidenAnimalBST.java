
/**
 * Write a description of class SidhuJaidenAnimalBST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SidhuJaidenAnimalBST //your class name gives me a stroke reading it!
{
    private Node root;
    public class Node {
        Node left; //you can combine this into one line, dont have to establish these on separate line
        Node right;
        String name;
        public Node(String str) {
            name = str;
        }
    }
    public SidhuJaidenAnimalBST () {
        root = null;
    }
    
    public void insert(String str) {
        if (root == null) { root = new Node(str); return; }
        insertRecursion(str, root);
    }
    public void insertRecursion(String str, Node n) {
        if (n.name.compareTo(str) == 0) {
            return;
        }
        if (n.name.compareTo(str) > 0) {
            if (n.left == null) {
                n.left = new Node(str);
                return;
            }
            else {
                insertRecursion(str, n.left);
            }
        }
        if (n.name.compareTo(str) < 0) {
            if (n.right == null) {
                n.right = new Node(str);
                return;
            }
            else {
                insertRecursion(str, n.right);
            }
        }
    }
    
    public void delete(String str) {
        if (root == null) { return; }
        deleteRecursion(root, str);
    }
    public void deleteRecursion(Node n, String str) { // great job i dont know if it works but it looks like it does :)
        
        if (n.name.equals(str)) {
            if (n.right != null && n.left != null) {
                Node successor = getMinRecursion(n.right); //the name successor is kinda've convulated, could have been shorter use prev next time
                if (successor.right == null && successor.left == null) {
                    n.name = successor.name;
                    successor = null;
                }
                else if (successor.right != null) {
                    n.name = successor.name;
                    n.right = successor.right;
                    successor = null;
                }
                else if (successor.left != null) {
                    n.name = successor.name;
                    n.left = successor.left;
                    successor = null;
                }
                else {
                    n = successor;
                }
            }
            else if (n.right.right != null) {
                n = n.right;
            }
            else if (n.right.left != null) {
                n = n.left;
            }
            else {
                n = null;
            }
            return;
        }
        if (n.right != null && n.right.name.equals(str)) {
            if (n.right.right != null && n.right.left != null) {
                Node successor = getMinRecursion(n.right.right);
                if (successor.right == null && successor.left == null) {
                    n.right.name = successor.name;
                    successor = null;
                }
                else if (successor.right != null) {
                    n.right.name = successor.name;
                    n.right.right = successor.right;
                    successor = null;
                }
                else if (successor.left != null) {
                    n.right.name = successor.name;
                    n.right.left = successor.left;
                    successor = null;
                }
                else {
                    n.right = successor;
                }
            }
            else if (n.right.right != null) {
                n.right = n.right.right;
            }
            else if (n.right.left != null) {
                n.right = n.right.left;
            }
            else {
                n.right = null;
            }
            return;
        }
        if (n.left != null && n.left.name.equals(str)) {
            if (n.left.right != null && n.left.left != null) {
                Node successor = getMinRecursion(n.left.right);
                if (successor.right == null && successor.left == null) {
                    n.left.name = successor.name;
                    successor = null;
                }
                else if (successor.right != null) {
                    n.left.name = successor.name;
                    n.left.right = successor.right;
                    successor = null;
                }
                else if (successor.left != null) {
                    n.left.name = successor.name;
                    n.left.left = successor.left;
                    successor = null;
                }
                else {
                    n.left = successor;
                }
            }
            else if (n.left.right != null) {
                n.left = n.left.right;
            }
            else if (n.left.left != null) {
                n.left = n.left.left;
            }
            else {
                n.left = null;
            }
            return;
        }
        if (n.right != null) {
            deleteRecursion(n.right, str);
        }
        if (n.left != null) {
            deleteRecursion(n.left, str);
        }
    }
    
    public Node getMaxRecursion(Node n) {
        if (n.right == null) { return n; }
        return getMaxRecursion(n.right);
    }
    public Node getMinRecursion(Node n) {
        if (n.left == null) { return n; }
        return getMaxRecursion(n.left);
    }
    
    public String toString() {
        if (root == null) { return null; }
        return toStringRecursion(root, "");
    }
    public String toStringRecursion(Node n, String str) {
        if (n.left != null) {
            str += toStringRecursion(n.left, "");
        }
        str += n.name + " ";
        if (n.right != null) {
            str += toStringRecursion(n.right, "");
        }
        
        return str;
    }
}
