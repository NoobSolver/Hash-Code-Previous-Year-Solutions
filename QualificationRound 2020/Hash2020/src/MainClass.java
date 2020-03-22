import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) throws Exception {

		String fileName = "a_example";
		
		DataHolder dataHolder = initialize(fileName);
		
		System.out.println("Data Read Done");
		
		int noOfDaysLeft = dataHolder.getNoOfDays();
		
		long totalScore = 0;
		long libCount = 0;
		
		String p1="",p2="",p3="";
		while(true) {
			
			for(Library lib :dataHolder.getLibraries()) {
				
				if(lib.getSignUpTimeInDays() <= noOfDaysLeft) {
					libCount++;
					for(int i=0;i<lib.getSignUpTimeInDays();i++) {
						--noOfDaysLeft;
					}
					
					int maxBookThatCanBeScanned = lib.getNoOfBookscanBeScanned()*noOfDaysLeft;
					int noOFBookScanned = 0;
					p3="";
					for(int j =0;j<lib.getBooks().size();j++) {
						Book book = lib.getBooks().get(j);
						if(!book.isIsRead()) {
							book.setIsRead(Boolean.TRUE);
							book.setReadByLib(lib);
							noOFBookScanned++;
							totalScore += book.getScore();
							p3 = p3 + book.getId() +" ";
						}
						if(noOFBookScanned >= maxBookThatCanBeScanned) {
							break;
						}
					}
					System.out.println();
					p2 = p2 + lib.getId() +" "+noOFBookScanned +"\n"+p3.trim()+"\n";
				}
			}
			break;
		}
		p1 = p1 + libCount+"\n"+p2.trim();
		
		System.out.println(p1.trim());
		
		output(fileName, p1.trim());
			
		System.out.println("##### DONE ###### -- "+totalScore);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void output(String fileName,String outputString) throws Exception {
		try (PrintWriter output = new PrintWriter("/Users/krishna/eclipse-workspace/Hash2020/src/out/" + fileName + ".out", "UTF-8")) {
            output.print(outputString);
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static DataHolder initialize(String fileName) throws Exception {

		BufferedReader fr = new BufferedReader(
				new FileReader("/Users/krishna/eclipse-workspace/Hash2020/src/in/"+fileName+".txt"));

		String line;
		DataHolder dataHolder = new DataHolder();
		line = fr.readLine();

		String[] vars;
		vars = line.split(" ");

		int bookCount = Integer.valueOf(vars[0]);
		int libCount = Integer.valueOf(vars[1]);
		int scanningTime = Integer.valueOf(vars[2]);
		
		dataHolder.setNoOfDays(scanningTime);
		
		line = fr.readLine();
		
		vars = line.split(" ");
		
		for(int i=0;i<bookCount;i++) {
			Book book = new Book(i, Integer.valueOf(vars[i]));
			dataHolder.addBooks(book);
		}
		int minTimeToSignup = Integer.MAX_VALUE;
		for(int i=0;i<libCount;i++) {
			line = fr.readLine();
			vars = line.split(" ");
			int localBookCount = Integer.valueOf(vars[0]);
			int timeToSignUp = Integer.valueOf(vars[1]);
			if(timeToSignUp < minTimeToSignup) {
				minTimeToSignup = timeToSignUp;
			}
			Library library = new Library(i,timeToSignUp , Integer.valueOf(vars[2]));
			
			line = fr.readLine();
			vars = line.split(" ");
			for(int j=0;j<localBookCount;j++) {
				int bookIndex = Integer.valueOf(vars[j]);
				Book book = dataHolder.getBooks().get(bookIndex);
				library.addBooks(book);
				book.addLibraries(library);
			}
			Collections.sort(library.getBooks());
			dataHolder.addLibraries(library);
		}
		
		for(Library lib : dataHolder.getLibraries()) {
			lib.calculateRank(minTimeToSignup);
		}
		
		Collections.sort(dataHolder.getLibraries());

		fr.close();
		return dataHolder;
	}
	
	
	
	
	
	
	
	
	
}
