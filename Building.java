public abstract class Building {
    private String name;
    private String address;
    private String architectName;
    private int yearBuilt;
    private int floors;
    private boolean isCulturalMonument;
    public Building(String name, String address, String architectName, int yearBuilt, int floors, boolean isCulturalMonument) {
        this.name=name;
        this.address=address;
        this.architectName=architectName;
        this.yearBuilt=yearBuilt;
        this.floors=floors;
        this.isCulturalMonument=isCulturalMonument;
    }
    public Building(){}


    {
        name="No name";
        address="No address";
        yearBuilt=0;
        architectName="No name";
        isCulturalMonument=false;
        floors=1;
    }
    abstract void work();
    abstract void display();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArchitectName() {
        return architectName;
    }

    public void setArchitectName(String architectName) {
        this.architectName = architectName;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isCulturalMonument() {
        return isCulturalMonument;
    }

    public void setCulturalMonument(boolean culturalMonument) {
        isCulturalMonument = culturalMonument;
    }
}