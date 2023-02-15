import java.util.*;
public class PHamGavinAnimalBST
{
    private AnimalNode root;
    private class AnimalNode
    {
        String name;
        AnimalNode left, right;
        
        public AnimalNode(String name)
        {
            this.name = name.toLowerCase();
            left = null;
            right = null;
        }
        public String toString()
        {
            return "" + name;
        }
    }
    
    public void insert(String n,AnimalNode hold, AnimalNode previous)
    {
        if(hold.left == null && hold.right == null)
        {
            hold = new AnimalNode(n);
            return;
        }
        else
        {
            if(n.compareTo(hold.name) < 0)//if the string is less than the hold name, go left
            {
                if(hold.left == null)//if hold.left is null set it to a new node
                {
                    hold.left = new AnimalNode(n);
                    return;
                }
                else
                {
                    insert(n, hold.left, hold);
                }
            }
            else if(n.compareTo(hold.name) > 0)//if the string is more than the hold, go right
            {
                if(hold.right == null)
                {
                    hold.right = new AnimalNode(n);
                    return;
                }
                else
                {
                    insert(n, hold.right, hold);
                }
            }
        }
    }
    
    public void delete(AnimalNode del, AnimalNode hold, AnimalNode prev)
    {
        if(hold.left == null && hold.right == null)
        {
            return;
        }
        else
        {
            if(hold.name.equalsIgnoreCase(del.name))//if it finds the node to delete
            {
                hold = null;
                //nice
            }
            else
            {
                if(del.name.compareTo(hold.name) < 0)//if its smaller
                {
                    if(hold.left != null)
                    {
                        delete(del, hold.left, hold);
                    }
                    else
                    {
                        return;
                    }
                }
                else if(del.name.compareTo(hold.name) > 0)//if its larger
                {
                    if(hold.right != null)
                    {
                        delete(del, hold.right, hold);
                    }
                    else
                    {
                        return;
                    }
                }
            }
            //delete method does not seem to account for if the node being deleted has two children
        }
    }
    
    public String toString(String build)
    {
        return "hi"; //your attempt at a toString does not produce any valid animal names <--- whoever wrote this is factually wrong
    }
    
    public static void main(String[] args)
    {
        PHamGavinAnimalBST bst = new PHamGavinAnimalBST();
        
    }
}
