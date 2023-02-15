public class MySteve
{
    private Node root;
    private class Node
    {
        String val;
        Node left, right;

        public Node(String val)
        {
            this.val = val;
            left = right = null;
        }

        public String toString()
        {
            return "" + this.val;
        }
    }

    public MySteve()
    {
        root = new Node("");
    }

    public void insert(String str)
    {
        if (contains(str))
        {
            return;
        }
        this.root = insert(root, str);
    }

    public Node insert(Node node, String str)
    {
        if (node == null)
        {
            node = new Node(str);
            return node;
        }
        else if (node.val.compareTo(str) == 1)
        {
            node.left = insert(node.left, str);
        }
        else
        {
            node.right = insert(node.right, str);
        }
        return node;
    }

    public boolean contains(String str)
    {
        return contains(root, str);
    }

    public boolean contains(Node node, String str)
    {
        if (node == null)
        {
            return false;
        }
        if (node.val.equals(str))
        {
            return true;
        }
        else if (node.val.compareTo(str) == 1)
        {
            return contains(node.left, str);
        }
        else
        {
            return contains(node.right, str);
        }
    }

    public void delete(String n)
    {
        if (root == null)
        {
            return;
        }
        if (!contains(n))
        {
            return;
        }
        delete(root, null, n);
    }
    public void delete(Node node, Node prev, String n)
    {
        if (node.val.equals(n))
        {
            if (node.right == null && node.left == null)// if its a leaf
            {
                if (prev.right == node)
                {
                    prev.right = null;
                }
                if (prev.left == node)
                {
                    prev.left = null;
                }
            }
            else if (node.right == null) //if has one child on left
            {
                if (prev != null)
                {
                    if (prev.right == node)
                    {
                        prev.right = node.left;
                        node = null;
                        return;
                    }
                    if (prev.left == node)
                    {
                        prev.left = node.left;
                        node = null;
                        return;
                    }
                }
                else
                {
                    root = node.left;
                    node = null;
                    return;
                }
            }
            else if (node.left == null) //if has one child on right
            {
                if (prev != null)
                {
                    if (prev.right == node)
                    {
                        prev.right = node.right;
                        node = null;
                        return;
                    }
                    if (prev.left == node)
                    {
                        prev.left = node.right;
                        node = null;
                        return;
                    }
                }
                else
                {
                    root = node.right;
                    node = null;
                    return;
                }
            }
            else if (node.left != null && node.right != null)
            {
                if (node.left.val.compareTo(node.right.val) == 1)
                {
                    prev.right = node.left;
                    prev.left = node.left;
                    node = null;
                    return;
                }
                else if (node.right.val.compareTo(node.right.val) == 1)
                {
                    prev.right = node.right;
                    prev.left = node.right;
                    node = null;
                    return;
                }
            }
        }
        else
        {
            prev = node;
            if (node.val.compareTo(n) == 1) //if greater
            {
                delete(node.left, prev, n);
            }
            else if (node.val.compareTo(n) == -1) //if lower
            {
                delete(node.right, prev, n);
            }

        }
    }

    public void print()
    {
        print(root);
    }

    public void print(Node node)
    {
        if (node.left != null && node.right != null)
        {
            print(node.left);
            System.out.println(node.val);
            print(node.right);
        }
        if (node.left == null && node.right != null)
        {
            System.out.println(node.val);
            print(node.right);
        }
        if (node.right == null && node.left != null)
        {
            System.out.println(node.val);
            print(node.left);
        }
        if (node.left == null && node.right == null)
        {
            System.out.println(node.val);
        }
    }

    public static void main(String[] args)
    {
        MySteve a = new MySteve();
        a.insert("elephant");
        a.insert("cougar");
        a.insert("velociraptor");
        a.print();
        System.out.println();
        a.delete("cougar");
        a.insert("elephant");
        a.print();
    }

}
