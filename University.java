public class University extends Building {
    private int classrooms;
    private int numberOfActiveStudents;
    public University(String name, String address, String architectName, int yearBuilt,
                      int floors, boolean isCulturalMonument, int classrooms, int numberOfActiveStudents) {
        super(name, address, architectName, yearBuilt, floors, isCulturalMonument);
        this.classrooms=classrooms;
        this.numberOfActiveStudents=numberOfActiveStudents;
    }

    public University() {
    }

    @Override
    void work() {
        System.out.println("University is open!");
    }

    public int getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(int numberOfClassrooms) {
        this.classrooms = numberOfClassrooms;
    }

    public int getNumberOfActiveStudents() {
        return numberOfActiveStudents;
    }

    public void setNumberOfActiveStudents(int numberOfActiveStudents) {
        this.numberOfActiveStudents = numberOfActiveStudents;
    }

    @Override
    public String toString() {
        return "Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There: "+getClassrooms()+" classrooms, Also here: "+getNumberOfActiveStudents()+" active students now.";
    }

    @Override
    void display() {
        System.out.println("Name of building: "+super.getName()+", Address of building: "+
                super.getAddress()+", Architect name: "+super.getArchitectName()+", Year built: "+
                super.getYearBuilt()+", Number of floors: "+super.getFloors()+", Is it cultural monument: "+super.isCulturalMonument()+
                ", There: "+getClassrooms()+" classrooms, Also here: "+getNumberOfActiveStudents()+" active students now.");
    }
}