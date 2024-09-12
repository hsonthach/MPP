package dataaccess;

import java.util.HashMap;

import business.Author;
import business.Book;
import business.CheckoutRecord;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public void saveNewMember(LibraryMember member);

	void saveNewBook(Book book);
	
	public HashMap<String, CheckoutRecord> readAllCheckoutRecords();
	
	public void saveAllCheckoutRecords(HashMap<String, CheckoutRecord> items);
}
