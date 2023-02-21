public class IsenhartOwenAnimalBST{
    private Node root;
    public class Node{
        String name;
        Node left, right;
        public Node(String val){
            name = val;
            left = right = null;
        }
        @Override
        public String toString(){
            return this.name;
        }
    }
    public IsenhartOwenAnimalBST(){
        root = null;
    }
    
    public void insert(String s){
        if (!contains(s))
            root = insert(root, s);
    }
    public Node insert(Node node, String s){
        if (node == null){
            node = new Node(s);
            return node;
        }
        else if (node.name.compareTo(s) < 0){
            node.left = insert(node.left, s);
        }
        else if (node.name.compareTo(s) > 0){
            node.right = insert(node.right, s);
        }
        return node;
    }
    
    public String getMin(){
        return getMin(root);
    }
    public String getMin(Node node){
        if (node.left == null)
            return node.name;
        else
            return getMin(node.left);

    }
    public String getMax(){
        return getMax(root);
    }
    public String getMax(Node node){
        if (node.right == null)
            return node.name;
        else
            return getMax(node.right);
    }
    
    public boolean contains(String s){
        return contains(root, s);
    }

    public boolean contains(Node node, String s){
        if (node == null) 
            return false;
        if (node.name.equals(s)) 
            return true;
        else if (node.name.compareTo(s) < 0){ 
            return contains(node.left, s);
        }
        else{ 
            return contains(node.right, s);
        }
    }
    public void delete(String s){
        if (contains(s)){
            delete(root, root, s);
        }
    }
    public void delete(Node node, Node prev, String s){
        if (node == null)
            return;
        if (node.name.equals(s)){
            if (node.left == null && node.right == null){ //leaf
                if (prev.left == node)
                    prev.left = null;
                else
                    prev.right = null;
            }
            if (node.left == null && node.right != null){ //right sub
                if (prev.left == node){
                    prev.left = node.right;
                }
                else{
                    prev.right = node.right;
                }
            }
            if (node.left != null && node.right == null){ //left sub
                if (prev.left == node){
                    prev.left = node.left;
                }
                else{
                    prev.right = node.left;
                }
            }
            else{ //two subs
                String temp = getMin(node.right); 
                delete(node.right.name);
                node.name = temp;
            }
        }
        else{
            if (node.name.compareTo(s) < 0){
                delete(node.left, node, s);
            }
            else{
                delete(node.right, node, s);
            }
        }
    }
    public void print(){ //i couldn't call it to string because of error
        print(root);
    }
    public void print(Node node){
        if (node != null){
            print(node.left);
            System.out.print (node.name + " ");
            print(node.right);
        }
        
    }
}
