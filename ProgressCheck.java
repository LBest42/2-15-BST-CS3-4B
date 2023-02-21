public class ProgressCheck
{
   private Node root;
   
   class Node
   {
       Node right;
       Node left;
       String name;
       
       public Node(String n)
       {
           name =n;
           right = null;
           left = null;
       }
   }
   
   public ProgressCheck()
   {
       root = null;
   }
   
   public Node insert(Node animal)
   {
       if (root == null)
       {
           root = animal;
           return null;
       }
       else
       {
           return insert(root, animal.name);
       }
   }
   
   public Node insert(Node temp, String name)
   {
       if (temp == null)
       {
            temp = new Node(name);
            return temp;
       }
       if (temp.name.compareTo(name) > 0)
       {
           temp.left = insert(temp.left, name);
       }
       else if (temp.name.compareTo(name) < 0)
       {
           temp.right = insert(temp.right, name);
       }
       return temp;
   }
   
   public void delete(String n)
   {
       if (root == null)
       {
           return;
       }
       else
       {
           delete(root, null, n);
       }
   }
   
   public void delete(Node temp, Node prev, String n)
   {
       if (temp.name == n)
        {
            if (temp.right == null && temp.left == null)
            {
                temp = null;
                return;
            }
            else if (temp.right == null)
            {
                if (prev != null)
                {
                    if (prev.right == temp)
                    {
                        prev.right = temp.left;
                        temp = null;
                        return;
                    }
                    else
                    {
                        prev.left = temp.left;
                        temp = null;
                        return;
                    }
                }
                else
                {
                    root = temp.left;
                    temp = null;
                    return;
                }
            }
            else if (temp.left == null)
            {
                if (prev != null)
                {
                    if (prev.right == temp)
                    {
                        prev.right = temp.right;
                        temp = null;
                        return;
                    }
                    else
                    {
                        prev.left = temp.right;
                        temp = null;
                        return;
                    }
                }
                else //i dont think this works
                {
                    String t = getMin(temp.right);
                    delete(temp.right.name);
                    temp.name = t;
                }
            }
        }
        
        prev = temp;
        
       if (temp.name.compareTo(n) > 0)
       {
            delete(temp.left, prev, n);
       }
       else if (temp.name.compareTo(n) < 0)
       {
            delete(temp.right, prev, n);
       }
   }
   
   public String getMin()
    {
        if (root == null)
        {
            return null;
        }
        return getMin(root);
    }
   
   public int getMin(Node temp)
    {
        if (temp.left == null)
        {
            return temp.name;
        }
        return getMin(temp.left);
    }
   
   public void toString(Node temp)
   {
       if (root != null)
       {
           toString(temp.left);
           System.out.print(temp.name + " ");
           toString(temp.right);
       }
   }
}
