public class Bird extends Animal{

    private String area;
    private Boolean winterFly;

    public Bird() {
        super();
        super.type = "Птица";
        super.isFly = true;
        this.area = "NoArea";
        this.winterFly = false;
    }

    public String getArea() {
        return area;
    }
    public String isWinterFly() {
        return "Улетает зимовать: "  + (winterFly ? "Нет." : "Да.");
    }

    public void setArea(String area) {
        this.area = area;
    }
    public void setWinterFly(Boolean winterFly) {
        this.winterFly = winterFly;
    }
    public void setName (String name) {
        super.name = name;
    }

    public void chirik_chirik(){
        System.out.println("chirik_chirik");
    }
    @Override
    public void display() {
        System.out.printf("I'm %s My name is %s My area live %s. I fly winter on the south? This is - %s\n", super.type, super.name, this.area, this.winterFly);
    }
}