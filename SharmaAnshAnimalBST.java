public class SharmaAnshAnimalBST {
    public class Node
    {
        String val;
        Node right;
        Node left;
        Node parent;
        public Node ()
        {

        }
        public Node (String a)
        {
            val = a;
        }
    }
    private Node root;
    public SharmaAnshAnimalBST()
    {
        root = new Node();
    }
    public void insert (String a)
    {
        insertTraverse(root, a);
    }
    public void insertTraverse(Node node, String a)
    {
        if (node.right == null && node.left == null)
        {
            if (node.val.compareTo(a) < 0) {
                node.right = new Node(a);
            }
            else if (node.val.compareTo(a) > 0) {
                node.left = new Node(a);
            }
        }
        else if (node.left == null)
        {
            if (a.compareTo(node.val) < 0) {
                node.left = new Node(a);
            }
            else if (a.compareTo(node.val) > 0)
                insertTraverse(node.right, a);
        }
        else if (node.right == null)
        {
            if (a.compareTo(node.val) < 0)
                insertTraverse(node.left, a);
            else if (a.compareTo(node.val) > 0)
                node.right = new Node(a);
        }
        else
        {
            if (a.compareTo(node.val) < 0)
                insertTraverse(node.left, a);
            else if (a.compareTo(node.val) > 0)
                insertTraverse(node.right, a);
        }
    }
    public void delete(String n)
    {
        deleteTraverse(root, n);
    }

    static void deleteTraverse(Node node, String n)
    {
        if (!node.val.equals(n))
        {
            if (node.right != null)
                deleteTraverse(node.right, n);
            if (node.left != null)
                deleteTraverse(node.right, n);
        }
        else
        {
            Node temp;
            if (node.right == null && node.left == null) {
                node = null;
                return;
            }
            else if (node.right == null)
                temp = node.left;
            else if (node.left == null)
                temp = node.right;
            else
                temp = left(node.right);
            node.val = temp.val;
            if (temp.right != null)
                node.right = temp;
            temp = null;
        }

    }

    static Node left (Node node)
    {
        if (node.left == null)
            return node;
        else
            return left(node.left);
    }
    public void toStringg()
    {
        tsTraverse(root);
    }
    public void tsTraverse(Node node)
    {
        if (node.left != null)
            tsTraverse(node.left);
        System.out.println(node.val);
        if (node.right != null)
            tsTraverse(node.right);
    }
}
