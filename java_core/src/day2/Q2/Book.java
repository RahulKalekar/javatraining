package day2.Q2;

class Book {
    private String bookTitle;
    private String author;
    private String ISBN;
    private int numberOfCopies;
    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return ISBN;
    }

    public int getNumOfCopies() {
        return numberOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    Book(String bookTitle, String author, String ISBN, int numberOfCopies) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
        this.numberOfCopies = numberOfCopies;
    }

    public void display() {
        System.out.println(this.bookTitle + "--" + this.author + "--" + this.ISBN + "--" + this.numberOfCopies);
    }
}
