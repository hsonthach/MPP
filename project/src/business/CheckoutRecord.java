package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final public class CheckoutRecord implements Serializable {
	private static final long serialVersionUID = 2L;

	private LibraryMember member;
	private List<CheckoutEntry> entries = new ArrayList<CheckoutEntry>();
	
	public CheckoutRecord(LibraryMember member) {
		this.member = member;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	
	public void addEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy) {
		entries.add(new CheckoutEntry(checkoutDate, dueDate, bookCopy));
	}
	
	public Iterable<CheckoutEntry> getEntries(){
		return entries;
	}
}
