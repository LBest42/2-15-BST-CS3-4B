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
        if(head.name.equals(name))
            head = null;
        deleteRecursion(head, name);
    }
    public AnimalNode left(AnimalNode node) {
        if(node.left!=null)
            return left(node.left);
        return node;
    }
    public void deleteRecursion(AnimalNode node, String name) {
        if(node.left==null && node.right==null)
            return;
        if(node.left!= null && node.left.name.compareTo(name)==0) {
            if(node.left.right != null) {
                AnimalNode x = left(node.left.right);
                node.left.name = x.name;
                x = null;
            }
            else if(node.left.left!= null) {
                node.left = node.left.left;
            }
            else
                node.left = null;
        }
        else if(node.right!= null && node.right.name.compareTo(name)==0) {
            if(node.right.right != null) {
                AnimalNode x = left(node.right.right);
                node.right.name = x.name;
                x = null;
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
// Reflection - The feedback given was nice but did not identify any shortcomings. While reviewing other's code
// I realized I forgot to implement the correct approach for the delete method regarding which node
// to replace to the TO-BE-DELETED node with. I gained some insight during this progress chech for 
// which I was grateful
