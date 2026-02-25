public class multiThreadedMain {
       public static void main(String[] args)  {

        String logFile = "errors.log";
        try {
            
            if (args.length < 2) {
                throw new IllegalArgumentException("Missing arguments");
            }
            
        MultiThreadedLibrary1 parmeter1 = new MultiThreadedLibrary1(args[0]);
        MultiThreadedLibrary2 parmeter2 = new MultiThreadedLibrary2(args[0], args[1]);


        Thread thread1 = new Thread(parmeter1);
        Thread thread2 = new Thread(parmeter2);
            System.out.println("Starting Thread 1...");
            thread1.start();
            thread1.join(); 
            System.out.println("Thread 1 finished.");

            System.out.println("Starting Thread 2...");
            thread2.start();
            thread2.join(); 
            System.out.println("Thread 2 finished.");

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
            
        }catch (Exception e) {
            LibraryBookTracker.logError(logFile, "Missing Arg", e);
            System.out.println("An error occurred in main thread: " + e.getMessage());

        } finally {
            System.out.println("\n--- Statistics ---");
            System.out.println("Valid records processed: " + LibraryBookTracker.getValidRecords());
            System.out.println("Search results found: " + LibraryBookTracker.getSearchResults());
            System.out.println("Books added: " + LibraryBookTracker.getBooksAdded());
            System.out.println("Errors encountered: " + LibraryBookTracker.getErrorCount());
            System.out.println("Thank you for using The Library book Tracker");
        }
        
        
    }
    } 


