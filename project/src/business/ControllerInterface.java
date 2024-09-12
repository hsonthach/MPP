package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();

	void saveBook(String isbn, String title, int maxCheckoutLength, int copyNum, List<Author> authors);
	public void checkoutBook(String memberId, String isbn) throws CheckoutException;
	public Iterable<CheckoutEntry> getCheckoutEntry(String memberId);
}
