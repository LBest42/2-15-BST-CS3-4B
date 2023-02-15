public class AggarwalDevAnimalBST {
    private AnimalNode head;
    public class AnimalNode {
        String name;
        AnimalNode left;
        AnimalNode right;
        public AnimalNode(String n) {
            this(n, null, null);
        }
        public AnimalNode(String n, AnimalNode x, AnimalNode y) {
            name = n;
            left=x;
            right=y;
        }
    }
    public AggarwalDevAnimalBST() {
//nothing in your construdcotr, why isnt there anything uiny yourn cobsturcotor youj nedd ote stablish root iun your cibstryctir
    }
    public void insert(String name) {
        if(head==null) {
            head = new AnimalNode(name);
            return;
        }
        insertRecursion(head, name);
    }
    public void insertRecursion(AnimalNode node, String name) {
        if(node.name.compareTo(name)==0)
            return;
        if(node.left==null && node.name.compareTo(name)<0) {
            node.left = new AnimalNode(name);
            return;
        }
        else if(node.right==null && node.name.compareTo(name)>0) {
            node.right = new AnimalNode(name);
            return;
        }
        if(node.name.compareTo(name) <0) {
            insertRecursion(node.left, name);
        }
        else if(node.name.compareTo((name))>0) {
            insertRecursion(node.right, name);
        }

    }
    public void delete(String name) {
        if(head==null) {
            return;
        }
        deleteRecursion(head, name);
    }
    public void deleteRecursion(AnimalNode node, String name) {
        if(node.left==null && node.right==null)
            return;
        if(node.left!= null && node.left.name.compareTo(name)==0) {
            if(node.left.right != null) {
                node.left = node.left.right;
            }
            else if(node.left.left!= null) {
                node.left = node.left.left;
            }
            else
                node.left = null;
        }
        else if(node.right!= null && node.right.name.compareTo(name)==0) {
            if(node.right.right != null) {
                node.right = node.right.right;
            }
            else if(node.right.left!= null) {
                node.right = node.right.left;
            }
            else
                node.right = null;
        }
        if(node.name.compareTo(name) <0) {
            deleteRecursion(node.left, name);
        }
        else if(node.name.compareTo((name))>0) {
            deleteRecursion(node.right, name);
        }

    }
    public void toString() {
        if(head==null) {
            return;
        }
        printRecurse(head);
    }
    public void printRecurse(AnimalNode node) {
        if(node.left!=null)
            printRecurse(node.left);
        System.out.print(node.name + " ");
        if(node.right!=null)
            printRecurse(node.right);

    }
}
