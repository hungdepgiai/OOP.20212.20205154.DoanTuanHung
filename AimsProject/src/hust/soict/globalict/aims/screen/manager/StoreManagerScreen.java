package hust.soict.globalict.aims.screen.manager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalice.aims.playable.Playable;
import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.media.Media;

public class StoreManagerScreen extends JFrame {
private Store store;
JMenuItem i1,i2,i3,i;
JPanel createNorth() {
	JPanel north=new JPanel();
	north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
	north.add(createMenuBar());
	north.add(createHeader());
	return north;
}
JMenuBar createMenuBar() {
	JMenu menu=new JMenu("Options");
	i=new JMenuItem("View store");
	menu.add(i);
	i.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            store.sortbytitle();
        	new StoreManagerScreen(store);
            dispose();
        }
    });
	JMenu smUpdateStore=new JMenu("Update Store");
	
	i1=new JMenuItem("Add Book");
	smUpdateStore.add(i1);
	i1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            new AddBookToStoreScreen(store);
            dispose();
        }
    });
	i2=new JMenuItem("Add CD");
	smUpdateStore.add(i2);
	i2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        }
    });
	i3=new JMenuItem("Add DVD");
	smUpdateStore.add(i3);
	i3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        }
    });
	menu.add(smUpdateStore);
	JMenuBar menuBar=new JMenuBar();
	menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	menuBar.add(menu);
	return menuBar;
}
JPanel createHeader() {
	JPanel header=new JPanel();
	header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
	JLabel title=new JLabel("AIMS");
	title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
	title.setForeground(Color.CYAN);
	header.add(Box.createRigidArea(new Dimension(10,10)));
	header.add(title);
	header.add(Box.createHorizontalGlue());
	header.add(Box.createRigidArea(new Dimension(10,10)));
	return header;
}
JPanel createCenter() {
JPanel center=new JPanel();
center.setLayout(new GridLayout(3,3,2,2));
ArrayList<Media> mediaInStore=store.getItemsInStore();

for(int i=0;i<9;i++) {
	MediaStore cell=new MediaStore(mediaInStore.get(i));
	center.add(cell);
}
return center;
}

public StoreManagerScreen(Store store) {
	this.store=store;
	Container cp=getContentPane();
	cp.setLayout(new BorderLayout());
	cp.add(createNorth(),BorderLayout.NORTH);
	cp.add(createCenter(),BorderLayout.CENTER);
	setTitle("Store");
	setSize(1024,768);
	setLocationRelativeTo(null);
	setVisible(true);
	
}
public class MediaStore extends JPanel{
	
	private Media media;
	public MediaStore(Media media) {
		this.media=media;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel title=new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost=new JLabel(""+media.getCost()+"$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		JPanel container=new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);
			playButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
		    			JOptionPane.showMessageDialog(container, "Playing media: "+media.toString());
		    			}
			});
		}
	this.add(Box.createVerticalGlue());
	this.add(title);
	this.add(cost);
	this.add(Box.createVerticalGlue());
	this.add(container);
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}


}
