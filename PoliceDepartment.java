public class PoliceDepartment extends Building {
    private int chambers;
    private boolean areTheresFreeChambers;

    public PoliceDepartment(String name, String address, String architectName, int yearBuilt,
                            int floors, boolean isCulturalMonument, int chambers, boolean areTheresFreeChambers) {
        super(name, address, architectName, yearBuilt, floors, isCulturalMonument);
        this.chambers=chambers;
        this.areTheresFreeChambers=areTheresFreeChambers;
    }

    public PoliceDepartment() {
    }

    @Override
    void work() {
        System.out.println("Police department is open!");
    }

    public int getChambers() {
        return chambers;
    }

    public void setChambers(int numberOfChambers) {
        this.chambers = numberOfChambers;
    }

    public boolean isAreTheresFreeChambers() {
        return areTheresFreeChambers;
    }

    public void setAreTheresFreeChambers(boolean areTheresFreeChambers) {
        this.areTheresFreeChambers = areTheresFreeChambers;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There: "+getChambers()+" chambers, Are there has any free chamber: "+isAreTheresFreeChambers()+".";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There: "+getChambers()+" chambers, Are there has any free chamber: "+isAreTheresFreeChambers()+".");
    }
}