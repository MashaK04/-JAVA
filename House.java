public class House extends Building {
    private int apartPerFloor;
    private int apartments;

    public House(String name, String address, String architectName,
                 int yearBuilt, int floors, boolean isCulturalMonument, int apartments, int apartPerFloor) {
        super(name, address, architectName, yearBuilt, floors, isCulturalMonument);
        this.apartPerFloor=apartPerFloor;
        this.apartments=apartments;
    }
    public House(){}

    @Override
    void work() {
        System.out.println("House is closed!");
    }

    public int getApartPerFloor() {
        return apartPerFloor;
    }

    public void setApartPerFloor(int apartPerFloor) {
        this.apartPerFloor = apartPerFloor;
    }

    public int getApartments() {
        return apartments;
    }

    public void setApartments(int numberOfApartments) {
        this.apartments = numberOfApartments;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Apartments per floor: "+getApartPerFloor()+", There: "+getApartments()+" apartments.";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Apartments per floor: "+getApartPerFloor()+", There: "+getApartments()+" apartments.");

    }
}