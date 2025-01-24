package day2.Q2;

class BookStore {
    private Book[] books;
    private String storeName;
    private int size;

    public BookStore(String storeName,int size){
        this.size=size;
        this.storeName=storeName;
        this.books=new Book[this.size];
        rackFill();
    }
    private void rackFill(){
        books[0]=new Book("Secret of Nagas","Amish","23900",5);
        books[1]=new Book("Tenali Rama","Tenali","80090",4);
        books[2]=new Book("pointer in c", "YK", "94545A12", 8);
        books[3]=new Book("head first core java", "foo", "50545A12", 20);
        books[4]=new Book("spring in action", "bar", "14545A12", 10);
    }
    public void sell(String bookTitle,int numberOfCopies){
        boolean found=false;
        for(int i=0;i<size;i++){
            if(books[i].getBookTitle().equals(bookTitle)){
                books[i].setNumOfCopies(books[i].getNumOfCopies()-numberOfCopies);
                found=true;
            }
        }
        if(found) System.out.println("book selled!!");
        else System.out.println("book not selled");
    }
    public void order(String ISBN,int numberOfCopies){
        boolean found=false;
        for(int i=0;i<size;i++){

            if(books[i].getIsbn().equals(ISBN)) {
                books[i].setNumOfCopies(books[i].getNumOfCopies() + numberOfCopies);
                found = true;
            }
        }
        if(found) System.out.println("Books ordered");
        else System.out.println("Order failed");

    }

    public void display(){
       for(Book book:books){
           if(book!=null)   book.display();
       }
    }
}
