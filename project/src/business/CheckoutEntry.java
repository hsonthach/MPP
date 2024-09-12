package business;

import java.io.Serializable;
import java.time.LocalDate;

public final class CheckoutEntry implements Serializable {
	private static final long serialVersionUID = 3L;
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	
	CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.bookCopy = bookCopy;
	}
	
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
}
