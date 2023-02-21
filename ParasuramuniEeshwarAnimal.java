public class ParasuramuniEeshwarAnimal { //class name too long! should be shorter

    animalNode root; //this is supposed to be private >:( >:( >:( >:(

    public ParasuramuniEeshwarAnimal(String name, animalNode right, animalNode left){
        root = new animalNode(name);
        root.right = right;
        root.left = left;
    }

    public class animalNode{
        String name;
        animalNode right; //you can combine these two into one line brO!
        animalNode left;
        public animalNode(String name){
            this.name = name;
            right = null;
            left = null;
        }
    }

    public void insert (String name, animalNode node) {

        if(name == node.name){
            return;
        }
        if(name.compareTo(node.name) < 0){
            if(node.left == null){
                node.left = new animalNode (name);
            }else{
                insert(name, node.left);
            }

        }
        else if(name.compareTo(node.name) > 0 ){
            if(node.right== null){
                node.right = new animalNode(name);
            }else{
                insert(name, node.right);
            }
        }
    }

    // also the delete does not work at all
    public void delete(animalNode node, animalNode previousNode, boolean right , String n){ //you have a bit too many paramteres, you can cut down!!!Q
        animalNode successor = null;
        if(n == node.name){

            if(node.left == null && node.right == null){
                node = null;
            }
            if(node.left != null && node.right != null){
                if(node.right!= null) {
                    successor = getSuccessor(node);
                }
                if(right)
                    previousNode.right = successor;
                else
                    previousNode.left = successor;

                successor.right = node.right;
                successor.left = node.left;
            }


            if(node.right == null && node.left!= null){
                if(right)
                    previousNode.right = node.left;
                else
                    previousNode.left = node.left;
            }
            else if(node.left == null && node.right!= null){
                if(right)
                    previousNode.right = node.right;
                else
                    previousNode.left = node.right;
            }

        }
        else{

            if(node.right == null && node.left == null){
                return;
            }

            if(node.right!= null){
                delete(node.right, node, true, n);

            }
            if(node.left!= null){
                delete(node.left, node, false, n);
            }
        }
    }

    public animalNode getSuccessor(animalNode node){ //successor is too long of a name, make it prev
        if(node.right == null && node.left == null){
            return node;
        }
        if(node.left != null){
            return  getSuccessor(node.left);

        }
        return null;
    }

    public void toString(animalNode currNode){ //currNode is too confusing, just make it current
        if(currNode.left != null){
           toString(currNode.left);
        }
        System.out.println(currNode.name);
        if(currNode.right != null){
            toString(currNode.right);
        }
    }

//>:(
}

