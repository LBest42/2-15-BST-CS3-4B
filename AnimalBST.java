
public class AnimalBST {
	private Animal root;
	public class Animal{
		private String Name;
		
		AnimalBST left, right;
	}
	public class Animal(Animal name) {
		this.Name = name;
		left = null;
		right = null;
		
	}
	
	public static void insert(Animal name)
	{
		if (root == null) {
			name = root;
		}
		if (name.compareTo(root) == 0)
		{
			break;
		}
		if(name.compareTo(root) < 0)
		{
			while(root.left() != null)
			{
				insert(root.left());
			}
		}
		if(name.comareTo(root) > 0)
		{
			while(root.right() != null)
			{
				insert(root.right());
			}
		}
		
		
	}
	
	public static void delete(Animal name)
	{
		if(root.compareTo(null) == 0) {
			name = root;
		}
		if (name.compareTo(root) > 0) {
			root.right() = delete(root.right);
		}
		if (name.compareTo(root) < 0) {
			root.left() = delete(root.left);
		}
		else {
			if (root.right == null && root.left == null) {
				root = null;
			}
		if(root.right.compareTo(name)) {
			{
				root = root.right;
			}
		
        }
        return root;
    }
    
		
	}
	//lnr
	public String toString(Animal root2)
	{
		
		Animal root = root2;
		if (root.left == null)
		{
			while(root.left = null)
			{
				root.left(toString);
			}
		}
		
	}
}



	

