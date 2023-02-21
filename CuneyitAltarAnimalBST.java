public class CuneyitAltarAnimalBST {
    private class BSTNode {
        String animalName;
        BSTNode left, right;

        public BSTNode(String animalName) {
            this.animalName = animalName;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + this.animalName; //don't know if you need this accessor since your String variable is already public
        }
    }
    private BSTNode root;

    public CuneyitAltarAnimalBST(){
        root = new BSTNode("");
    }

    public void insert (BSTNode node, String animalName){
        if (root == null){}
        else{
            if (animalName.compareToIgnoreCase(node.animalName) > 0){
                if (node.right == null){
                    BSTNode newLeaf = new BSTNode(animalName);
                    node.right = newLeaf;
                }
                else if (node.right != null){
                    insert(node.right, animalName);
                }
            }
            else if (animalName.compareToIgnoreCase(node.animalName) == 0){}
            else{
                if (node.left == null){
                    BSTNode newLeaf = new BSTNode(animalName);
                    node.left = newLeaf;
                }
                else if (node.left != null){
                    insert(node.left, animalName);
                }
            }
        }
    }

    public String toString(BSTNode node){
        if (node.left == null && node.right == null){
            System.out.println(node.animalName);
        } 
        else{
            if (node.left != null){
                toString(node.left);
                System.out.println(node.animalName);
            }
            else if (node.right != null){
                toString(node.right);
                System.out.println(node.animalName);
            }
        }
        return ""; //it looks like you're combining print statements with a String-type class. I would either make this class return void and remove this statement or keep it as string and save the String in one large string, then return that
    }

    public void delete(BSTNode helperNode, String name){ //i like how compact this method is!
        if (helperNode.left == null && helperNode.right == null){}
        else{
            if (helperNode.animalName.compareToIgnoreCase(helperNode.right.animalName) > 0){
                delete(helperNode.left, name);
            }
            else if (helperNode.animalName.compareToIgnoreCase(name) < 0){
                delete(helperNode.right, name);
            }
            else if (helperNode.animalName.compareToIgnoreCase(name) == 0 && helperNode.left != null){
                helperNode.animalName = helperNode.left.animalName;
            } //you need something here that says what to do if the left node is null. currently, if you're trying to remove a leaf, it won't remove anything at all.
        }
    }
}
