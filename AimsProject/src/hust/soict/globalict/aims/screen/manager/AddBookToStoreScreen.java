package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.media.Book;

public class AddBookToStoreScreen extends JFrame {
	private Store store;
	
	public AddBookToStoreScreen(Store store) {
		String response;
		response=JOptionPane.showInputDialog("Enter title:");
		String title=response;
		response=JOptionPane.showInputDialog("Enter category:");
		String category=response;
		response=JOptionPane.showInputDialog("Enter cost:");
		float cost=Float.parseFloat(response);
		response=JOptionPane.showInputDialog("Authors name,split by comma");
		String authors=response;
		List<String>b1=new ArrayList<>(Arrays.asList(authors.split(",")));
		Book book=new Book(title,category,cost,b1);
		store.addmedia(book);
		int input = JOptionPane.showConfirmDialog(null, 
                "Book added to store!", "Add book", JOptionPane.DEFAULT_OPTION);
        // 0=ok
        if(input==0) {
        	new StoreManagerScreen(store);
        }
	}
	
}
