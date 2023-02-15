public class IyerSanahAnimalBST
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
        
        @Override
        public String toString()
        {
            return "" + this.val;
        }
    }
    
    public IyerSanahAnimalBST()
    {
        root = null;
    }
    
    public void insert(String n)
    {
        if (root == null)
        {
            root = new Node(n);
        }
        else
        {
            insert(n, root);
        }
    }
    
    private void insert(String word, Node node)
    {
        if (word.compareTo(node.val) == 0)
        {
            return;
        }
        else if (word.compareTo(node.val) < 0)
        {
            if (node.left != null)
            {
                insert(word, node.left);
            }
            else
            {
                node.left = new Node(word);
            }
        }
        else if (word.compareTo(node.val) > 0)
        {
            if (node.right != null)
            {
                insert(word, node.right);
            }
            else
            {
                node.right = new Node(word);
            }
        }
    }
    
    public void delete(String word)
    {
        if (root == null)
        {
            return;
        }
        
        root = delete(word, root);
    }
    
    private Node delete(String word, Node node)
    {
        if (word.compareTo(node.val) < 0)
        {
            node.left = delete(word, node.left);
        }
        else if (word.compareTo(node.val) > 0)
        {
            node.right = delete(word, node.right);
        }
        else if (node.val.equals(word))
        {
            if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            else
            {
                node.val = getMax(node.left);
                node.left = delete(node.val, node.left);
            }
        }
        
        return node;
    }
    
    private String getMax(Node node)
    {
        if (node.right == null)
        {
            return node.left.val;
        }
        else
        {
            return getMax(node.right);
        }
    }
    
    public void printString()
    {
        inOrder(root);
    }
    
    private void inOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
}
