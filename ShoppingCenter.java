public class ShoppingCenter extends Building {
    private int shops;
    private boolean mallHaveFoodCourt;

    public ShoppingCenter(String name, String address, String architectName,
                          int yearBuilt, int floors, boolean isCulturalMonument, int shops, boolean mallHaveFoodCourt) {
        super(name, address, architectName, yearBuilt, floors, isCulturalMonument);
        this.shops=shops;
        this.mallHaveFoodCourt=mallHaveFoodCourt;
    }

    public ShoppingCenter() {
    }

    @Override
    void work() {
        System.out.println("Shopping center is open!");
    }

    public int getShops() {
        return shops;
    }

    public void setShops(int numberOfShops) {
        this.shops = numberOfShops;
    }

    public boolean isMallHaveFoodCourt() {
        return mallHaveFoodCourt;
    }

    public void setMallHaveFoodCourt(boolean mallHaveFoodCourt) {
        this.mallHaveFoodCourt = mallHaveFoodCourt;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There are: "+getShops()+" shops, Is this mall have food court: "+isMallHaveFoodCourt()+".";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There are: "+getShops()+" shops, Is this mall have food court: "+isMallHaveFoodCourt()+".");
    }
}