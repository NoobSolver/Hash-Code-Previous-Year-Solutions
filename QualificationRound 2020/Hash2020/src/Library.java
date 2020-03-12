import java.util.ArrayList;
import java.util.List;

public class Library implements Comparable<Library> {

	public int getId() {
		return id;
	}
	public Library(int id, int timeInDays, int noOfBookscanBeScanned) {
		this.id = id;
		this.timeInDays = timeInDays;
		this.noOfBookscanBeScanned = noOfBookscanBeScanned;
	}
	@Override
	public String toString() {
		return "Library [id=" + id + ", books=" + books + ", timeInDays=" + timeInDays + ", noOfBookscanBeScanned="
				+ noOfBookscanBeScanned + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getSignUpTimeInDays() {
		return timeInDays;
	}
	public void setTimeInDays(int timeInDays) {
		this.timeInDays = timeInDays;
	}
	public int getNoOfBookscanBeScanned() {
		return noOfBookscanBeScanned;
	}
	public void setNoOfBookscanBeScanned(int noOfBookscanBeScanned) {
		this.noOfBookscanBeScanned = noOfBookscanBeScanned;
	}
	int id;
	List<Book> books;
	int timeInDays;
	int noOfBookscanBeScanned;
	
	int rank;

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void calculateRank(int minDays) {
		int tempDays = getSignUpTimeInDays() - minDays;
		int noOfBooks = books.size();
		this.rank = noOfBooks-tempDays+noOfBookscanBeScanned;
	}
	@Override
	public int compareTo(Library that) {
		if(this.rank > that.rank) {
			return -1;
		}
		else if(this.rank < that.rank) {
			return 1;
		}
		return 0;
	}
}
