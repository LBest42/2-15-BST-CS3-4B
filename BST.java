public class BST {
    private Animal root;

    public BST(){
        root = null;
    }
    public BST(Animal r){
        root = r;
    }
//-------------------------------------------------------------
    public void insert(String s){
        insert(root, s);
    }

    public void insert(Animal n, String s){
        if(n.name.compareTo(s) > 0){
            if(n.left != null) {
                insert(n.left, s);
            }
            else{
                n.left = new Animal(s);
            }
        }
        else if (n.name.compareTo(s) < 0){
            if(n.right != null) {
                insert(n.right, s);
            }
            else{
                n.right = new Animal(s);
            }
        }

    }
//-------------------------------------------------------------
    public void delete(String s){
        Animal a = root;
        while(1 == 1){
            if(a.name.compareTo(s) > 0){
                if(a.left != null){
                    a = a.left;
                }
                else{
                    break;
                }
            } else if(a.name.compareTo(s) < 0){
                if(a.right != null){
                    a = a.right;
                }
                else{
                    break;
                }
            } else{
                a = a.left;
                a.left = null;
            }
            if(a.left == null & a.right == null){
                break;
            }
        }
    }

    public String printInorder(Animal a) {
        //Animal a = root;
        String s = "";       // there is no case where it will deal with it if the root is there but it is null
        if (a != null){
            s += printInorder(a.left);
        }
        return s; // not sure if this is important but I belive there will be no spaces between the nodes on the toString return for s
        //No.
    }







    public class Animal{
        String name;
        Animal left, right;

        public Animal(String n) {
            name = n;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + name;
        }
    }
}
