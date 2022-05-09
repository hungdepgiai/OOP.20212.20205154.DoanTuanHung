public class cart {
public static final int MAX_NUMBERS_ORDERED = 20;
private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
private DigitalVideoDisc itemsRemoved[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
int qtyOrdered=0;
int qty=0;
float price=0;
int i;
public void addDigitalVideoDisc(DigitalVideoDisc disc)
{
	
	if(qtyOrdered<= MAX_NUMBERS_ORDERED)
	{
		
		itemsOrdered[qtyOrdered]=disc;
		qtyOrdered +=1;
		System.out.printf("Add disk "+qtyOrdered+" successfully!\n");
	}
	else {
		System.out.printf("Cart full!");
	}
}
public void addDigitalVideoDisc2(DigitalVideoDisc disc1, DigitalVideoDisc disc2)
{
	
	if(qtyOrdered<= MAX_NUMBERS_ORDERED)
	{
		itemsOrdered[qtyOrdered]=disc1;
		qtyOrdered +=1;
		itemsOrdered[qtyOrdered]=disc2;
		qtyOrdered +=1;
		System.out.printf("Add disk successfully!\n");
	}
	else {
		System.out.printf("Cart full!");
	}
}

public void removeDigitalVideoDisc(DigitalVideoDisc disc)
{
	if(qtyOrdered>0)
	{
	for(i=0;i<qtyOrdered;i++)
	{
	if(itemsOrdered[i].getTitle().equals(disc.getTitle()))
	{
		System.arraycopy(itemsOrdered,i+1,itemsOrdered,i,qtyOrdered-i);
		qtyOrdered -=1;
		System.out.println("Remove disk "+(i+1)+" successfully!");
		break;
	}
	}
	}
	else System.out.println("Cart empty");
}
public float totalCost()
{
	for(i=0;i<qtyOrdered;i++)
	{
		price+=itemsOrdered[i].getCost();
	}
	return price;
}
}
