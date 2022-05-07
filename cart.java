public class cart {
public static final int MAX_NUMBERS_ORDERED = 20;
private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
int qtyOrdered=0;
float price=0;
int i;
public void addDigitalVideoDisc(DigitalVideoDisc disc)
{
	
	if(qtyOrdered<= MAX_NUMBERS_ORDERED)
	{
		qtyOrdered +=1;
		itemsOrdered[qtyOrdered]=disc;
		System.out.printf("Add disk "+qtyOrdered+" successfully!\n");
	}
	else {
		System.out.printf("Cart full!");
	}
}
public void removeDigitalVideoDisc(DigitalVideoDisc disc)
{
	for(i=1;i<=qtyOrdered;i++)
	{
	if(disc==itemsOrdered[i])
	{
		qtyOrdered -=1;
		System.out.printf("Remove disk "+i+" successfully!\n");
	}
	}
}
public float totalCost()
{
	for(i=1;i<=qtyOrdered;i++)
	{
		price+=itemsOrdered[i].getCost();
	}
	return price;
}
}
