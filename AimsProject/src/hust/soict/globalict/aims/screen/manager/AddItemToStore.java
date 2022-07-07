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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;



public class AddItemToStore extends JPanel{
	
	private static Store store;
	private JPanel fieldPanel;
	private JPanel buttonPanel;
	private JButton addButton;
	private JComponent titleTrackLabel;
	private JLabel titleTrack;
	private JLabel lengthTrack;
	private static StoreManagerScreen sms;
	private JPanel addTrackMainPanel;
	
	public AddItemToStore(Store store, StoreManagerScreen sms) {
		this.store = store;
		this.sms = sms;
        setLayout(new GridBagLayout());
	}
	
	public void addMediaContent(JLabel titleLabel, JLabel[] labels) {
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 10, 5, 10);  // top, left, bottom, right padding
        
        JTextField[] textFields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
        	c.gridx = 0;
        	c.gridy = i;
        	fieldPanel.add(labels[i], c);
        	c.gridx = 1;
        	c.gridy = i;
        	textFields[i] = new JTextField(15);
        	fieldPanel.add(textFields[i], c);
        }
        
        c.gridx=0;
        c.gridy=5;
        c.gridwidth = 2;
        c.insets = new Insets(25, 10, 25, 10);
        buttonPanel = new JPanel(new GridBagLayout());
        
		addButton = addButton("Add this media");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, 
                        "Do you want to add this media?", "Confirmation dialog",
                        JOptionPane.YES_NO_OPTION);
                if (output == JOptionPane.YES_OPTION) {
                	if (checkMediaType() == 0){
                    	addToStore(new Book(textFields[0].getText(), textFields[1].getText(), Float.parseFloat(textFields[2].getText()), null));
                    	JOptionPane.showMessageDialog(null, "The Book [" + textFields[0].getText()+ "] has been successfully added to the store");  
                    	System.out.println("Book ne");
                	}
                	else if (checkMediaType() == 1) {
                		CompactDisc addedCD = new CompactDisc(textFields[0].getText(), textFields[1].getText(), Float.parseFloat(textFields[2].getText()), textFields[3].getText());
                    	addToStore(addedCD);
                    	int cdOutput = JOptionPane.showConfirmDialog(null, 
                                "The CD [" + textFields[0].getText()+ "] has been successfully added to the store" + "\nDo you want to add the tracks?", "Confirmation dialog",
                                JOptionPane.YES_NO_OPTION);
                    	if (cdOutput == JOptionPane.YES_OPTION) {
                    		 addTrackPanel(addedCD, Integer.parseInt(textFields[4].getText()));
                    	}
                    	 else if (output == JOptionPane.NO_OPTION) {
                         }
                    	System.out.println("CD ne");
                	}
                	else if (checkMediaType() == 2) {
                    	addToStore(new DigitalVideoDisc(textFields[0].getText(), textFields[1].getText(), Float.parseFloat(textFields[4].getText()), Integer.parseInt(textFields[3].getText()),textFields[2].getText()));
                    	JOptionPane.showMessageDialog(null, "The DVD [" + textFields[0].getText()+ "] has been successfully added to the store");  
                    	System.out.println("DVD ne");
                    }
                	System.out.println("Yes selected");
                } else if (output == JOptionPane.NO_OPTION) {
                	System.out.println("No selected");
                }
			}
		});
		
		buttonPanel.add(addButton, new GridBagConstraints());
		fieldPanel.add(buttonPanel, c);
		
        Font font = new Font("MS Sans Serif", Font.BOLD, 50);
        titleLabel.setFont(font);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(35, 10, 35, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;	
        add(titleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(fieldPanel, gbc);
	}
	
	public int checkMediaType() {
		if (this instanceof AddBookToStoreScreen) {
			return 0;
		}
		else if (this instanceof AddCompactDiscToStoreScreen) {
			return 1;
		}
		else if (this instanceof AddDigitalVideoDiscToStoreScreen) {
			return 2;
		}
		else {
			return -1;
		}
	}
	
	public void addToStore(Media media) {
		store.addmedia(media);
	}
	
	public JButton addButton(String title) {
		JButton addButton = new JButton(title);
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		return addButton;
	}
	
	public JPanel addTrackPanel(CompactDisc cd, int numberOfTracks) {
		
		addTrackMainPanel = new JPanel();
		addTrackMainPanel.setLayout(new GridBagLayout());
		GridBagConstraints maingbc = new GridBagConstraints();
		
		JPanel north = new JPanel();
		Font font = new Font("MS Sans Serif", Font.BOLD, 50);
        titleTrackLabel = new JLabel("ADD TRACKS TO CD");
        titleTrackLabel.setFont(font);
        titleTrackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        north.add(titleTrackLabel);
        
		JPanel center = new JPanel();
		center.setLayout(new GridLayout((int) numberOfTracks/4+1, 4, 2, 2));
		
		JTextField[] textFields = new JTextField[numberOfTracks*2];
        JLabel[] labels = new JLabel[numberOfTracks];
        
		for (int i = 0; i < labels.length; i++) {
			JPanel trackPanel = new JPanel(new GridBagLayout());
			GridBagConstraints trackgbc = new GridBagConstraints();
			trackgbc.fill = GridBagConstraints.HORIZONTAL;
			trackgbc.insets = new Insets(5, 10, 5, 10);
			
			titleTrack = new JLabel("Title: ");
            lengthTrack = new JLabel("Length: ");
            
	      	labels[i] = new JLabel("Track " + (i+1) + ":");
	      	trackgbc.gridx = 0;
	      	trackgbc.gridy = 0;
	      	trackPanel.add(labels[i], trackgbc);
	      	
	      	trackgbc.gridx = 0;
	      	trackgbc.gridy = 1;
	      	trackgbc.weightx = 0;
	      	trackPanel.add(titleTrack, trackgbc);
	      	
	      	trackgbc.gridx = 1;
	      	trackgbc.gridy = 1;
	      	trackgbc.weightx = 1;
	      	textFields[2*i] = new JTextField(65);
	      	trackPanel.add(textFields[2*i], trackgbc);
	      	
	      	trackgbc.gridx = 0;
	      	trackgbc.gridy = 2;
	      	trackgbc.weightx = 0;
	      	trackPanel.add(lengthTrack, trackgbc);
	      	
	      	trackgbc.gridx = 1;
	      	trackgbc.gridy = 2;
	      	trackgbc.weightx = 1;
	      	textFields[2*i+1] = new JTextField(65);
	      	trackPanel.add(textFields[2*i+1], trackgbc);
	      	
	      	center.add(trackPanel);
		}
		
		
		JPanel south = new JPanel();
		addButton = addButton("Add these tracks to the CD");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, 
                        "Do you want to add these tracks to the CD", "Confirmation dialog",
                        JOptionPane.YES_NO_OPTION);
                if (output == JOptionPane.YES_OPTION) {
                	for (int i = 0; i < numberOfTracks; i++) {
                		cd.addTrack(new Track(textFields[2*i].getText(), Integer.parseInt(textFields[2*i+1].getText())));
                	}
                	JOptionPane.showMessageDialog(null, "The tracks have been successfully added to the CD"); 
                } else if (output == JOptionPane.NO_OPTION) {
                	System.out.println("No selected");
                }
			}
		});
		
		south.add(addButton, new GridBagConstraints());
		
		maingbc.fill = GridBagConstraints.HORIZONTAL;
		maingbc.insets = new Insets(25, 10, 25, 10);
		
		maingbc.gridx = 0;
		maingbc.gridy = 0;
		addTrackMainPanel.add(north, maingbc);
		
		maingbc.gridx = 0;
		maingbc.gridy = 1;
		addTrackMainPanel.add(center, maingbc);
		
		maingbc.insets = new Insets(5, 10, 5, 10);
		maingbc.gridx = 0;
		maingbc.gridy = 2;
		addTrackMainPanel.add(south, maingbc);
		
		return addTrackMainPanel;
	}
public static void main(String[]args) {
	new AddBookToStoreScreen(store,sms);
}
}