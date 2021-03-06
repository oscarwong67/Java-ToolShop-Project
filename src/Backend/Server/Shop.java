package Backend.Server;

import java.util.ArrayList;

/**
 * Class to manage the Tool Shop Backend. 
 * @author M. Moshirpour, Oscar Wong, Jeremy Olea.
 * @version 2.0
 * @since April 3rd, 2019
 */
public class Shop {
	/**
	 * The Shop's Inventory.
	 */
	private Inventory theInventory;
	/**
	 * The Shop's list of Suppliers.
	 */
	private ArrayList <Supplier> supplierList;
	
	/**
	 * Constructs a new Shop.
	 * @param inventory Inventory for the Shop.
	 * @param suppliers Suppliers to the Shop.
	 */
	public Shop (Inventory inventory, ArrayList <Supplier> suppliers) {		
		theInventory = inventory;
		supplierList = suppliers;		
	}
	
	/**
	 * Return the Shop's Inventory.
	 * @return The Shop's Inventory.
	 */
	public Inventory getTheInventory () {
		return theInventory;
	}

	/**
	 * Set the Shop's inventory.
	 * @param inventory The Shop's incoming Inventory.
	 */
	public void setTheInventory (Inventory inventory) {
		theInventory = inventory;
	}
	
	/**
	 * Return the Shop's list of Suppliers.
	 * @return The Shop's list of Suppliers.
	 */
	public ArrayList<Supplier> getSupplierList (){
		return supplierList;
	}

	/**
	 * Set the Shop's list of Suppliers.
	 * @param suppliers The Shop's incoming list of Suppliers.
	 */
	public void setSupplierList (ArrayList <Supplier> suppliers){
		supplierList = suppliers;
	}
	
	/**
	 * List all items in the Shop.
	 */
	public void listAllItems() {
		System.out.println(theInventory);		
	}

	/**
	 * Decrease quantity of an item in the Shop.
	 * @param name Name of item to decrease.
	 * @return String containing info about whether or not the transaction succeeded.
	 */
	public String decreaseItem (String name) {
		if (theInventory.manageItem(name) == null)
			return "Couldn't not decrease item quantity!\n";
		else
			return "Item quantity was decreased!\n";
	}

	/**
	 * List every Supplier to the Shop.
	 */
	public void listAllSuppliers() {
		for (Supplier s: supplierList) {
			System.out.println(s);
		}
		
	}

	/**
	 * Return an Item as a String, based on its name.
	 * @param name Name of Item to get.
	 * @return Item in question.
	 */
	public String getItem(String name) {
		Item theItem = theInventory.searchForItem(name);
		if (theItem == null)
		     return "Item " + name + " could not be found!";
		else
			 return outputItem (theItem);
			
	}

	/**
	 * Return an Item as a String, based on its ID.
	 * @param id ID of Item to get.
	 * @return Item in question.
	 */
	public String getItem(int id) {
		Item theItem = theInventory.searchForItem(id);
		if (theItem == null)
		     return "Item number " + id + " could not be found!";
		else
			return outputItem (theItem);	 
	}
	
	/**
	 * Output an Item as a String.
	 * @param theItem Item to output.
	 * @return The Item as a String.
	 */
	private String outputItem (Item theItem){
		return "The item information is as follows: \n" + theItem;
	}

	/**
	 * Return the quantity of a particular Item. 
	 * @param name Name of Item to return the quantity of.
	 * @return Quantity of Item with given name.
	 */
	public String getItemQuantity(String name) {
		int quantity = theInventory.getItemQuantity(name);
		if (quantity < 0)
		    return "Item " + name + " could not be found!";
		else
			return "The quantity of Item " + name + " is: " + quantity + "\n";
	}

	/**
	 * Return the Order currently held by the Shop's Inventory.
	 * @return The Order in the Inventory, as a String.
	 */
	public String printOrder() {		
		return theInventory.printOrder();
	}

	

}
