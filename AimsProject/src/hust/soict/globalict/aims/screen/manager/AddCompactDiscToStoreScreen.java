package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends JFrame{
private Store store;

public AddCompactDiscToStoreScreen(Store store) {
	String response;
	response=JOptionPane.showInputDialog("Enter title:");
	String title=response;
	response=JOptionPane.showInputDialog("Enter category:");
	String category=response;
	response=JOptionPane.showInputDialog("Enter cost:");
	float cost=Float.parseFloat(response);
	response=JOptionPane.showInputDialog("Enter artist:");
	String artist=response;
	
	CompactDisc cd=new CompactDisc(title,category,cost,artist);
	store.addmedia(cd);
	int input = JOptionPane.showConfirmDialog(null, 
            "CD added to store!", "Add CD", JOptionPane.DEFAULT_OPTION);
    // 0=ok
    if(input==0) {
    	new StoreManagerScreen(store);
    }
}

}
