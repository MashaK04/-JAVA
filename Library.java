public class Library extends Building {
    private int books;
    private boolean anyBooksForSale;
    public Library(String name, String address, String architectName, int yearBuilt, int floors, boolean isCulturalMonument,
                   int books,boolean anyBooksForSale) {
        super(name,address,architectName,yearBuilt,floors,isCulturalMonument);
        this.books=books;
        this.anyBooksForSale=anyBooksForSale;
    }
    public Library(){}

    @Override
    void work() {
        System.out.println("Library is open!");
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int numberOfBooks) {
        this.books = numberOfBooks;
    }

    public boolean isAnyBooksForSale() {
        return anyBooksForSale;
    }

    public void setAnyBooksForSale(boolean anyBooksForSale) {
        this.anyBooksForSale = anyBooksForSale;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Books in the library: "+getBooks()+", Is there any books for sale: "+isAnyBooksForSale()+".";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Books in the library: "+getBooks()+", Is there any books for sale: "+isAnyBooksForSale()+".");
    }
}