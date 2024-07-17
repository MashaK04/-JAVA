public class Fish extends Animal{
    private String squama;
    private boolean upStreamSwim;
    public Fish() {
        super();
        super.type = "Fish";
        super.isSwim = true;
        this.squama = "NoSquama";
        this.upStreamSwim = false;
    }
    public void setName(String name) {
        super.name = name;
    }

    public void setSquama(String squama) {
        this.squama = squama;
    }
    public void setUpStreamSwim (boolean upStreamSwim) {
        this.upStreamSwim = upStreamSwim;
    }

    public String getSquama() {
        return squama;
    }
    public String isUpStreamSwim() {
        return "Умеет плавать против течения: " +  (upStreamSwim ? "Да." : "Нет.");
    }
    public void bul_bul() {
        System.out.println("bul_bul");
    }

    @Override
    public void display() {
        System.out.printf("Im %s My name is %s Im a %s fish. I swimming up stream? This is - %s\n", super.type, super.name, this.squama, this.upStreamSwim);
    }
}