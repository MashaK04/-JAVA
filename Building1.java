public abstract class Building1 {
    public String name;
    public String address;
    public int year;
    public String architectName;
    public boolean monument;
    public Building1(String name, String address, int year, String architectName, boolean monument){
        this.name = name;
        this.address = address;
        this.year = year;
        this.architectName = architectName;
        this.monument = monument;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getArchitect() {
        return architectName;
    }

    public int getYear() {
        return year;
    }

    public boolean isCulturalMonument() {
        return monument;
    }
    public abstract String toString();
}