
/**
 * Write a description of class SriramTarunAnimalBST here.
 *
 * @author (your name) Tarun 
 * @version (a version number or a date) 1.0
 */
public class SriramTarunAnimalBST
{
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
        }if(data.compareTo(treeNode.data) > 0){
            treeNode.right = insertR(treeNode.right, data); 
        }else if(data.compareTo(treeNode.data) < 0){
            treeNode.left = insertR(treeNode.left, data);
        }
        return treeNode;
    }
    
    private boolean contains(BSTNode treeNode, String data){
        if(treeNode == null){ 
            return false;
        }
        int comparisonVal = treeNode.data.compareTo(data);
        if(comparisonVal == 0){
            return true;
        }else if(comparisonVal > 0 && treeNode.right != null)
            return contains(treeNode.right, data);
        }else if(comparisonVal < 0 && treeNode.left != null){
            return contains(treeNode.left, data);
        }
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
    
    
    private BSTNode deleteR(BSTNode treeNode, String data){
        if(treeNode == null)
               return null;
        if(data.compareTo(treeNode.data) < 0){
            treeNode.left = deleteR(treeNode.left, data);
        }else if(data.compareTo(treeNode.data) > 0){
            treeNode.right = deleteR(treeNode.right, data);
        }else{
            if(treeNode.left == null)
                return treeNode.right;
            else if(treeNode.right == null){
                return treeNode.left;
            }
            
            treeNode.data = getLowestString(treeNode.data);
            
            treeNode.right = deleteR(treeNode.right, treeNode.data);
        }
        return treeNode;
    }

    private String getLowestString(BSTNode treeNode){
        if(treeNode == null){
            return null;
        }
        
        String lowStr = treeNode.data;
        while(treeNode.left != null){
            lowStr = treeNode.left.data;
            treeNode = treeNode.left;
        }
        return lowStr;
        
    }
    
    
    

    

    
}
