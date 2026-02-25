import java.io.*;

public class MultiThreadedLibrary1 implements Runnable {
     LibraryBookTracker bookTracker = new LibraryBookTracker();
     String fileName;
     String logFile = "errors.log";

    public MultiThreadedLibrary1(String fileName) {
        this.bookTracker = new LibraryBookTracker();
        this.fileName = fileName;
    }

    @Override
    public void run() {
            try {
                FileReader(new String[]{fileName});
            } catch (IOException e) {
                System.out.println("File System Error: " + e.getMessage());
            }
    }

public void FileReader (String[] args) throws IOException{
          
    try {
        if (args.length < 1 || args[0] == null) {
            throw new InsufficientArgumentsException("Missing file name argument.");
        }

        String fileName = args[0]; //file name
        if (!fileName.endsWith(".txt")) {
                throw new InvalidFileNameException("File must end with .txt");
            }
            File file = new File(fileName); // if no file exist
             if (file.getParent() != null) {
                logFile = file.getParent() + "/errors.log"; // if the parent folder exist java will build the file inside it 
            } else {
               logFile = "errors.log"; //else java will add the file at the same folder we work in it 
            }

        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
      
    }catch (InsufficientArgumentsException |InvalidFileNameException e) {
        LibraryBookTracker.logError(logFile, "Missing Arg", e);
        System.out.println("Input Error: " + e.getMessage());
    } catch (IOException e) {
        LibraryBookTracker.logError(logFile, "FileReader", e);
        System.out.println("File System Error: " + e.getMessage());
    }
   }

}        
            

