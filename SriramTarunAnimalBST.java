
/**
 * Write a description of class SriramTarunAnimalBST here.
 *
 * @author (your name) Tarun 
 * @version (a version number or a date) 1.0
 */
public class SriramTarunAnimalBST
{
    // instance variables - replace the example below with your own
    private BSTNode overallRoot;
    private String output;
    private static int COUNT = 4;
    
    private class BSTNode{
        private String data;
        BSTNode left, right;
        
        
        public BSTNode(String data){
            this.data = data;
            left = right = null;
        }
        
        public String toString(){
            return "" + data;
        }
    
    
    }
    
    
    public SriramTarunAnimalBST(String data){
        overallRoot = new BSTNode(data);
        
    }
    
    public void insert(String data){
        if(!contains(overallRoot, data)){
            overallRoot = insertR(overallRoot, data);
        }
        
    }
    
    private BSTNode insertR(BSTNode treeNode, String data){
        if(treeNode == null){
            treeNode = new BSTNode(data);
            return treeNode;
        }else if(data.compareTo(treeNode.data) >= 0){
            return insertR(treeNode.right, data);
        }else if(data.compareTo(treeNode.data) < 0){
            return insertR(treeNode.left, data);
        }else{
            return treeNode;
        }
    }
    
    private boolean contains(BSTNode treeNode, String data){
        if(treeNode == null){
            return false;
        }
        if(treeNode.data.equals(data)){
            return true;
        }else if(data.compareTo(treeNode.data) >= 0){
            return contains(treeNode.right, data);
        }else if(data.compareTo(treeNode.data) < 0){
            return contains(treeNode.left, data);
        }else
            return false;
    }
    
    public String toString(){
        output = "";
        output = toStringR(overallRoot, 0);
        return output;
    
    }
    
    private String toStringR(BSTNode treeNode, int numSpaces){
        if(treeNode == null){
            return output;
        }
        
        //Adds the spaces to 
        numSpaces += COUNT;
        
        if(treeNode.left != null){
            return toStringR(treeNode.left, numSpaces);
        }
        
        
        for(int i = COUNT; i < numSpaces; i++){
            output += " ";
        }
        
        output += "" + treeNode.data;
        
        
        if(treeNode.right != null){
            return toStringR(treeNode.right, numSpaces);
        }
        
        return "";
    
    }
    
    
    public void delete(String data){
        overallRoot = deleteR(overallRoot, data);
    }
    
    //delete is not done, I'm sorry :(((((((((((((
    private BSTNode deleteR(BSTNode treeNode, String data){
        if(treeNode == null){
            return treeNode;
        }else if(treeNode.data.equals(data)){
            if(treeNode.left == null && treeNode.right == null){
                treeNode = null;
                return treeNode;
            }else if(treeNode.left != null){
                BSTNode newNode = new BSTNode(treeNode.left.data);
                treeNode.left = null;
                
            }
        }
    }
    
    
    

    

    
}
