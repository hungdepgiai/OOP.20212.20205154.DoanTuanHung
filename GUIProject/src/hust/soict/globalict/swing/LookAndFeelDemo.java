package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class LookAndFeelDemo extends JFrame {
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		setVisible(true);
	}
	void addDemoComponents() {
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	void addLookAndFeelComboBox() {
		Container cp=getContentPane();
		cp.add(new JLabel("Change Look and Feel Here:"));
		LookAndFeelInfo[]lafInfos=UIManager.getInstalledLookAndFeels();
		String []lafNames=new String [lafInfos.length];
		for(int i=0;i<lafInfos.length;i++) {
			lafNames[i]=lafInfos[i].getName();
		}
		lafNames[lafInfos.length]="Java";
		lafNames[lafInfos.length+1]="System";
		JComboBox cbLookAndFeel=new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		JFrame frame=this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index=cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafInfos[index].getClassName());
				} catch(Exception e) {
					try {
						if(index==lafInfos.length) UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
							if(index==lafInfos.length+1) UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					catch(ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();					}
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafInfos[index].getName()+" Look And Feel");
			}
		});
	}
	public static void main(String[]args) {
	new LookAndFeelDemo();
	
}
}
