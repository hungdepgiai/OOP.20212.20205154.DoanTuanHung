package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.exception.MediaException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;

public class AddCompactDiscToStoreScreen extends JFrame{
	
	private Store store;
	private JTextField category;
	private JTextField title;
	private JTextField length;
	private JTextField cost;
	private JTextField director;
	private JTextField artist;
	private Container cp;
	public AddCompactDiscToStoreScreen(Store store) {
		this.store=store;
		cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(fillpanel(),BorderLayout.CENTER);
		cp.add(createMenuBar(),BorderLayout.NORTH);
		JButton ENTER=new JButton("Enter");
		ENTER.addActionListener(new EnterListener());
		cp.add(ENTER,BorderLayout.SOUTH);
		setSize(300,150);
	}
	JPanel fillpanel() {
		JPanel cp=new JPanel();
		cp.setLayout(new GridLayout(4,2));
		cp.add(new JLabel("category: "));
		category=new JTextField(10);
		cp.add(category);
		cp.add(new JLabel("title: "));
		title=new JTextField(10);
		cp.add(title);
		
		cp.add(new JLabel("cost: "));
		cost=new JTextField(10);
		cp.add(cost);
		cp.add(new JLabel("artist: "));
		artist=new JTextField(10);
		cp.add(artist);
		return cp;
	}
	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		JMenuItem viewStore = new JMenuItem("View store");
		viewStore.addActionListener(new ViewStoreListener());
		menu.add(viewStore);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		
		
		addBook.addActionListener(new AddBookListener());
		addCD.addActionListener(new AddCDListener());
		addDVD.addActionListener(new AddDVDListener());
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	private class ViewStoreListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			dispose();
			try {
				new StoreManagerScreen(store);
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private class AddDVDListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			dispose();
			new AddDigitalVideoDiscToStoreScreen(store);
		}
	}
	private class AddBookListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			dispose();
			new AddBookToStoreScreen(store);
		}
	}
	private class AddCDListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			dispose();
			new AddCompactDiscToStoreScreen(store);
		}
	}
	private class EnterListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			String cat=category.getText();
			String ntitle=title.getText();
			
			float ncost=Float.parseFloat(cost.getText());
				String ndir=artist.getText();
				try {
					CompactDisc dvd=new CompactDisc(ntitle,cat,ncost,ndir);
					store.addmedia(dvd);
				} catch (MediaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		}
	}
}
