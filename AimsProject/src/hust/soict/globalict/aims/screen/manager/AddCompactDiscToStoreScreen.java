package hust.soict.globalict.aims.screen.manager;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStore{
	
	private StoreManagerScreen sms;
	
	public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen sms) {
		super(store, sms);
		addMediaContent(new JLabel("ADD CD"),new JLabel[]{new JLabel("Title: "), new JLabel("Category: "), new JLabel("Cost: "), new JLabel("Artist: "), new JLabel("Number of tracks: ")});
	}
}
