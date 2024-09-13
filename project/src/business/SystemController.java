package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	@Override
	public void saveBook(String isbn, String title, int maxCheckoutLength, int copyNum, List<Author> authors) {
		DataAccess da = new DataAccessFacade();
		Book book = new Book(isbn, title, maxCheckoutLength, copyNum, authors);
		da.saveNewBook(book);
	}
	
	@Override
	public void checkoutBook(String memberId, String isbn, LocalDate checkoutDate) throws CheckoutException {
		if (memberId == null || memberId.equals("")) throw new CheckoutException("Please input the Member ID");
		if (isbn == null || isbn.equals("")) throw new CheckoutException("Please input the ISBN");
		
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		if (!membersMap.containsKey(memberId)) {
			throw new CheckoutException("Member ID " + memberId + " not found");
		}
		LibraryMember member = membersMap.get(memberId);
		
		HashMap<String, Book> booksMap = da.readBooksMap();
		if (!booksMap.containsKey(isbn)) {
			throw new CheckoutException("ISBN " + isbn + " not found");
		}
		else {
			Book book = booksMap.get(isbn);
			BookCopy bookCopy = book.getNextAvailableCopy();
			if (bookCopy == null) {
				throw new CheckoutException("This book does not available at the moment. Please come back later.");
			}
			else {
				bookCopy.changeAvailability();
				da.saveBooksMap(booksMap);
				HashMap<String, CheckoutRecord> checkoutRecords = da.readAllCheckoutRecords();
				CheckoutRecord checkoutRecord;
				if (checkoutRecords.containsKey(memberId)) {
					checkoutRecord = checkoutRecords.get(memberId);
				}
				else {
					checkoutRecord = new CheckoutRecord(member);
					checkoutRecords.put(memberId, checkoutRecord);
				}
				LocalDate dueDate = checkoutDate.plusDays(book.getMaxCheckoutLength());
				checkoutRecord.addEntry(checkoutDate, dueDate, bookCopy);
				da.saveAllCheckoutRecords(checkoutRecords);
			}
		}
	}

	@Override
	public Iterable<CheckoutEntry> getCheckoutEntry(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, CheckoutRecord> memberCheckoutMap = da.readAllCheckoutRecords();
		if (memberCheckoutMap.containsKey(memberId)) {
			CheckoutRecord checkoutRecord = memberCheckoutMap.get(memberId);
			return checkoutRecord.getEntries();
		}
		
		return new ArrayList<CheckoutEntry>();
	}

	@Override
	public boolean findBookId(String text) {
		DataAccess da = new DataAccessFacade();
		return da.readBooksMap().containsKey(text);
	}

	@Override
	public void addBookCopy(String isbnStr) {
		DataAccess da = new DataAccessFacade();
		Book book = da.readBooksMap().get(isbnStr);
		book.addCopy();
		da.saveNewBook(book);
	}
}
