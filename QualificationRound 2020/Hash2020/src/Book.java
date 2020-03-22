import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {
	

	public Book(int id, int score) {
		this.id = id;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", score=" + score + ", libaries=" + libaries.size() + ", IsRead=" + IsRead + ", readByLib="
				+ IsRead + "]";
	}
	int id;
	int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	List<Library> libaries;
	
	boolean IsRead;
	
	Library readByLib;
	public List<Library> getLibaries() {
		return libaries;
	}
	public void setLibaries(List<Library> libaries) {
		this.libaries = libaries;
	}
	public void addLibraries(Library library) {
		this.libaries = this.libaries == null ? new ArrayList<Library>() : this.libaries;
		this.libaries.add(library);
	}
	public boolean isIsRead() {
		return IsRead;
	}
	public void setIsRead(boolean isRead) {
		IsRead = isRead;
	}
	public Library getReadByLib() {
		return readByLib;
	}
	public void setReadByLib(Library readByLib) {
		this.readByLib = readByLib;
	}
	@Override
	public int compareTo(Book that) {
		if(this.score > that.score) {
			return -1;
		}
		else if (this.score == that.score) {
			return 0;
		}
		return 1;
	}
}
