package testCases;

import baseClass.DriverInstance;
import pages.addToCartPage;

public class AddToCartItems_TC3 extends DriverInstance
{
 
	public void AddItems() throws Exception 
	{
		addToCartPage acp = new addToCartPage(driver);
		acp.Finditems();
		acp.AddingToCart();
		acp.NextLinktoDresses();
		acp.AddingToCart();
	}
}
