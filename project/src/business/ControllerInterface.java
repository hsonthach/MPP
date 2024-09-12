package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void checkoutBook(String memberId, String isbn) throws CheckoutException;
	public List<CheckoutEntry> getCheckoutEntry(String memberId);
}
