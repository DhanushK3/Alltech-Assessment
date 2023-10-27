package pkg_prob2;

public class Iteam {
	
	private int itemId;
    private String itemName;

    public Iteam(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId + ", Item Name: " + itemName);
    }
    
    
}
