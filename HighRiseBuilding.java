public class HighRiseBuilding extends Building {
    private double width;
    private boolean isThisHighRiseResidential;

    public HighRiseBuilding(String name, String address, String architectName,
                            int yearBuilt, int floors, boolean isCulturalMonument, double width, boolean isThisHighRiseResidential) {
        super(name, address, architectName, yearBuilt, floors, isCulturalMonument);
        this.width=width;
        this.isThisHighRiseResidential=isThisHighRiseResidential;
    }

    public HighRiseBuilding() {
    }

    @Override
    void work() {
        System.out.println("High rise building is open!");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean isThisHighRiseResidential() {
        return isThisHighRiseResidential;
    }

    public void setThisHighRiseResidential(boolean thisHighRiseResidential) {
        isThisHighRiseResidential = thisHighRiseResidential;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Width of this highrise building: "+getWidth()+", Is this highrise have a residential apartments: "+isThisHighRiseResidential()+".";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", Width of this highrise building: "+getWidth()+", Is this highrise have a residential apartments: "+isThisHighRiseResidential()+".");
    }
}