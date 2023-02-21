import java.util.*;
public class AdriaenssensJackAnimalBST
{
    Node root;
    int count;
    private class Node{
        String val;
        Node left, right;
        public Node(String val){
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString(){
            return "" + this.val;
        }
    }
    public void insert(String s)
    {
         insert(root, s);
    }
    public Node insert(Node root, String s) {
        if(contains(root, s) != true)
        {
            if (root == null) 
            { 
                root = new Node(s);
                return root;
            }
            else if (root.val.compareTo(s) > 0) 
            { 
                root.left = insert(root.left, s);
            }   
            else 
            {
                root.right = insert(root.right, s);
            }
        }
        return root;
    }
    public boolean contains(Node root, String s){
        if (root == null) 
            return false;
        if (root.val == s)
            return true;
        else if (root.val.compareTo(s) > 0)
        { 
            return contains(root.left, s);
        }
        else
        {
            return contains(root.right, s);
        }
    }
    public void delete(String s)
    {
        delete(root, root, s);
    }
    public void delete(Node root, Node parent, String s)
    {
        if(root.val.equals(s) )
        {
            
                root = null;
            //hehe
        }
        if (root.val.compareTo(s) > 0){
                if (root.left.val.equals(s))
                    parent = root;
                if (parent == null)
                    delete(root.left, parent, s);
                else
                    delete(root.left, parent, s);
            }
            else{
                if (root.right.val.equals(s))
                    parent = root;
                if (parent == null)
                    delete(root.right, parent, s);
                else
                    delete(root.right, parent, s);
            }
    }
    public String toString()
    {
        return toString(root, "");
    }
    public String toString(Node root, String s)
    {
        if(root == null)
        {
            return "";
        }
        if(root.left != null && root.right != null)
        {
            return(root.val + toString(root.left, s) + toString(root.right, s)); 
        }
        if(root.left != null)
        {
            return(root.val + toString(root.left, s)); 
        }
        if(root.right != null)
        {
            return(root.val + toString(root.right, s)); 
        }
        return "";
    }
}
