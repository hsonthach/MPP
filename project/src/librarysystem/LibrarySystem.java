package librarysystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import business.ControllerInterface;
import business.SystemController;
import dataaccess.Auth;
import dataaccess.User;

public class LibrarySystem extends JFrame implements LibWindow {
	ControllerInterface ci = new SystemController();
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JMenuBar menuBar;
	JMenu options;
	JMenuItem login, allBookIds, allMemberIds, checkoutABook, addBookWindow, addBookCopy, addMemberWindow;
	String pathToImage;
	private boolean isInitialized = false;

	private static LibWindow[] allWindows = {
			LibrarySystem.INSTANCE,
			LoginWindow.INSTANCE,
			AllMemberIdsWindow.INSTANCE,
			AllBookIdsWindow.INSTANCE,
			CheckoutABook.INSTANCE,
			AddBookWindow.INSTANCE,
			AddLibraryMemberWindow.INSTANCE
	};

	public static void hideAllWindows() {
		for(LibWindow frame: allWindows) {
			frame.setVisible(false);
		}
	}

	private LibrarySystem() {}

	public void init() {
		formatContentPane();
		setPathToImage();
		insertSplashImage();
		createMenus();
		setSize(660,500);
		isInitialized = true;
	}

	private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,1));
		getContentPane().add(mainPanel);
	}

	private void setPathToImage() {
		String currDirectory = System.getProperty("user.dir");
		pathToImage = currDirectory + "\\src\\librarysystem\\library.jpg";
	}

	private void insertSplashImage() {
		ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));
	}

	private void createMenus() {
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addMenuItems();
		setJMenuBar(menuBar);
	}

	private void addMenuItems() {
		options = new JMenu("Options");
		menuBar.add(options);

		login = new JMenuItem("Login");
		login.addActionListener(new LoginListener());
		options.add(login);

		allBookIds = new JMenuItem("All Book Ids");
		allBookIds.setEnabled(false);  // Initially disabled
		allBookIds.addActionListener(new AllBookIdsListener());
		options.add(allBookIds);

		allMemberIds = new JMenuItem("All Member Ids");
		allMemberIds.setEnabled(false);  // Initially disabled
		allMemberIds.addActionListener(new AllMemberIdsListener());
		options.add(allMemberIds);
		
		addMemberWindow = new JMenuItem("Add Library Member");
		addMemberWindow.setEnabled(false);  // Initially disabled
		addMemberWindow.addActionListener(new SwitchScreenListener<>(AddLibraryMemberWindow.INSTANCE));
		options.add(addMemberWindow);

		checkoutABook = new JMenuItem("Checkout a book");
		checkoutABook.setEnabled(false);  // Initially disabled
		checkoutABook.addActionListener(new SwitchScreenListener<>(CheckoutABook.INSTANCE));
		options.add(checkoutABook);

		addBookWindow = new JMenuItem("Add Book");
		addBookWindow.setEnabled(false);  // Initially disabled
		addBookWindow.addActionListener(new SwitchScreenListener<>(AddBookWindow.INSTANCE));
		options.add(addBookWindow);

		addBookCopy = new JMenuItem("Add Book Copy");
		addBookCopy.setEnabled(false);  // Initially disabled
		addBookCopy.addActionListener(new SwitchScreenListener<>(AddCopyToBook.INSTANCE));
		options.add(addBookCopy);
	}

	// Method to enable menu items based on user permissions
	public void enableMenuItemsForUser(User user) {
		Auth role = user.getAuthorization();
		allBookIds.setEnabled(false);
		checkoutABook.setEnabled(false);
		allMemberIds.setEnabled(false);
		addBookCopy.setEnabled(false);
		addBookWindow.setEnabled(false);
		addMemberWindow.setEnabled(false);

		if (role == Auth.LIBRARIAN || role == Auth.BOTH) {
			allBookIds.setEnabled(true);
			checkoutABook.setEnabled(true);
		}

		if (role == Auth.ADMIN || role == Auth.BOTH) {
			allMemberIds.setEnabled(true);
			addBookCopy.setEnabled(true);
			addBookWindow.setEnabled(true);
			addMemberWindow.setEnabled(true);
		}
	}

	public static void showUp(JFrame instance) {
		for(LibWindow frame: allWindows) {
			if (frame == instance) {
				frame.setVisible(true);
			}
			else {
				frame.setVisible(false);
			}
		}
	}

	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			LoginWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
			LoginWindow.INSTANCE.setVisible(true);
		}
	}

	class AllBookIdsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();
			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			AllBookIdsWindow.INSTANCE.setData(sb.toString());
			AllBookIdsWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
			AllBookIdsWindow.INSTANCE.setVisible(true);
		}
	}

	class AllMemberIdsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllMemberIdsWindow.INSTANCE.init();
			List<String> ids = ci.allMemberIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			AllMemberIdsWindow.INSTANCE.setData(sb.toString());
			AllMemberIdsWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
			AllMemberIdsWindow.INSTANCE.setVisible(true);
		}
	}

	class SwitchScreenListener<T extends JFrame & LibWindow> implements ActionListener {
		private T instance;
		SwitchScreenListener(T instance) {
			this.instance = instance;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			showUp(instance);
			instance.init();
			Util.centerFrameOnDesktop(instance);
		}
	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
}
