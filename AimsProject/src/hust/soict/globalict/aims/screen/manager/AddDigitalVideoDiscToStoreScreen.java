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
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private Store store;
	
public AddDigitalVideoDiscToStoreScreen(Store store) {
		
	String response;
	response=JOptionPane.showInputDialog("Enter title:");
	String title=response;
	response=JOptionPane.showInputDialog("Enter category:");
	String category=response;
	response=JOptionPane.showInputDialog("Enter cost:");
	float cost=Float.parseFloat(response);
	response=JOptionPane.showInputDialog("Enter length:");
	int length=Integer.parseInt(response);
	response=JOptionPane.showInputDialog("Enter director:");
	String director=response;
	DigitalVideoDisc dvd=new DigitalVideoDisc(title,category,cost,length,director);
	store.addmedia(dvd);
	int input = JOptionPane.showConfirmDialog(null, 
            "DVD added to store!", "Add DVD", JOptionPane.DEFAULT_OPTION);
    // 0=ok
    if(input==0) {
    	new StoreManagerScreen(store);
    }
	}
}
