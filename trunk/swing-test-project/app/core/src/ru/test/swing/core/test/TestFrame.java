package ru.test.swing.core.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TestFrame extends JFrame{

	public TestFrame() throws HeadlessException {
		super();
		init();
	}

	public TestFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public TestFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	public TestFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	private void init() {
		setSize(600, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		setLocation(windowX, windowY);  // Don't use "f." inside constructor.

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
	}
	
	@Override
	public Component add(Component comp) {
		Container contentPane = getContentPane();
		contentPane.add(comp,BorderLayout.CENTER);
		return comp;
	}
	
	

}
