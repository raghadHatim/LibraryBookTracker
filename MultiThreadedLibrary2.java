import java.io.*;

public class MultiThreadedLibrary2 implements Runnable {


    private String fileName;
    private String operation;

    public MultiThreadedLibrary2(String fileName, String operation) {

        this.fileName = fileName;
        this.operation = operation;
    }
 
public void run() {
          try {
            OperationAnalyzer(new String[]{fileName, operation});
            } catch (IOException e) {
                System.out.println("File System Error: " + e.getMessage());
            }
    }

public void OperationAnalyzer(String[] args)throws IOException {
File file = new File(args[0]);
        String logFile = "errors.log";
        String userInput = args[1];

        try {
         
            if (LibraryBookTracker.isNumeric(userInput) || userInput.length() == 13) {
                if (userInput.length() == 13 && LibraryBookTracker.isNumeric(userInput)) {
                    LibraryBookTracker.searchBooks(file, userInput, true, logFile);
                } else {
                    throw new InvalidISBNException("ISBN must be 13 digits and numeric: " + userInput);
                }
            } else if (userInput.contains(":")) {
                LibraryBookTracker.addBook(file, userInput, logFile);
            } else {
                LibraryBookTracker.searchBooks(file, userInput, false, logFile);
            }
        }catch(BookCatalogException e) {
             String errorData = "No Argument";
            if (args.length > 1) {
                errorData = args[1]; //if error with ISBN
            }
            LibraryBookTracker.logError(logFile, errorData, e);
            System.out.println("Error: " + e.getMessage());
        }catch (IOException e) {
            LibraryBookTracker.logError(logFile, userInput, e);
        }
    }
}

