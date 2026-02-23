public class LibraryOrganization {
    private String title ;
    private String author ;
    private String isbn ;
    private int copies ;
    
    public LibraryOrganization(String title, String author, String isbn, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
    }

    public String getTitle(){
     return this.title;
    }
     public String getAuthor(){
     return this.author;
    }
     public String getIsbn(){
     return this.isbn;
    }
     public int getCopies(){
     return this.copies;
    }

    @Override
    public String toString() {
        
        return String.format("%-30s %-20s %-15s %5d", title, author, isbn, copies);
    }
    
    //Implement Structured Text input 
    public String toFileFormat() {
        return title + ":" + author + ":" + isbn + ":" + copies;
    }
}