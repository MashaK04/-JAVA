
public class Insect extends Animal {
    private int wingCount;
    private boolean likeJesus;

    public Insect() {
        super();
        super.type = "Насекомое";
        super.isWalk = true;
        this.wingCount = 0;
        this.likeJesus = false;
    }
    public void setName (String name) {
        super.name = name;
    }

    public void setWingCount(int wingCount) {
        this.wingCount = wingCount;
    }
    public void setLikeJesus(boolean likeJesus) {
        this.likeJesus = likeJesus;
    }

    public int getWingCount() {
        return wingCount;
    }
    public String isLikeJesus() {
        return "Умеет ли ходить по воде: " + (likeJesus ? "Да." : "Нет.");
    }
    public void ggggg () {
        System.out.println("ggggg");
    }

    @Override
    public void display() {
        System.out.printf("I'm %s My name is %s and I have %s wing and like Jesus i walk water and this %s\n", super.type, super.name, this.wingCount, this.likeJesus);
    }
}