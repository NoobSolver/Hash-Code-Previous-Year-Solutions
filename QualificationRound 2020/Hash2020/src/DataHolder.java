import java.util.ArrayList;
import java.util.List;

public class DataHolder {

	List<Library> libraries;
	public List<Library> getLibraries() {
		return libraries;
	}
	public void setLibraries(List<Library> libraries) {
		this.libraries = libraries;
	}
	public void addLibraries(Library library) {
		this.libraries = this.libraries == null ? new ArrayList<Library>() : this.libraries;
		this.libraries.add(library);
	}
	
	List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void addBooks(Book book) {
		this.books = this.books == null ? new ArrayList<Book>() : this.books;
		this.books.add(book);
	}
	
	@Override
	public String toString() {
		return "DataHolder [libraries=" + libraries + ", books=" + books + ", noOfDays=" + noOfDays + "]";
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	int noOfDays;
	
}
