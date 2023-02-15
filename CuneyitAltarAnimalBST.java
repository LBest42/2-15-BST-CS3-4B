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
            return "" + this.animalName;
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
        return "";
    }

    public void delete(BSTNode helperNode, String name){
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
            }
        }
    }
}
