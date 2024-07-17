class library2 implements LivingHouse {

    double widthArea;
    double heightArea;
    int rooms;
    double floors;

    @Override
    public String toString() {
        return "Бибио{" +
                "widthArea=" + widthArea +
                ", heightArea=" + heightArea +
                ", rooms=" + rooms +
                ", floors=" + floors +
                '}';
    }

    public library2(double widthArea, double heightArea, double floors, int rooms) {
        this.widthArea = widthArea;
        this.heightArea = heightArea;
        this.rooms = rooms;
        this.floors = floors;
    }

    @Override
    public double getSquareArea() {
        return widthArea * heightArea;
    }

    @Override
    public double getAverageRoomsOnFloor() {
        return Math.floor(rooms / floors);
    }
}