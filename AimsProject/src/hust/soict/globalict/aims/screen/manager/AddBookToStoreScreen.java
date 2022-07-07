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

public class AddBookToStoreScreen extends AddItemToStore{

	private StoreManagerScreen sms;
	
	public AddBookToStoreScreen(Store store, StoreManagerScreen sms) {
		super(store, sms);
		addMediaContent(new JLabel("ADD BOOK"),new JLabel[]{new JLabel("Title: "), new JLabel("Category: "), new JLabel("Cost: ")});
	}
	
}
