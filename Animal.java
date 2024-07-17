public class Animal {
    String type, name;
    int age;
    double weight;
    boolean isFly, isWalk, isSwim;
    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }
    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public Animal(String type, String name, int age, double weight, boolean isFly, boolean isWalk, boolean isSwim) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isFly = isFly;
        this.isWalk = isWalk;
        this.isSwim = isSwim;
    }
    public Animal() {

    }


    public void setAge(int age) {
        this.age = age;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean setSwimm(boolean swimm) {
        return swimm;
    }
    public boolean setWalk(boolean walk) {
        return walk;
    }
    public boolean setFly(boolean fly) {
        return fly;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public String getType() {
        return type;
    }
    public boolean isSwimm() {
        return isSwim;
    }
    public boolean isWalk() {
        return isWalk;
    }
    public boolean isFly() {
        return isFly;
    }
    public void display(){
        System.out.println("Тип: " + type + ", Имя: " + name + ", Возраст: " +  age + ", Вес: " + weight +
                ", Умеет летать: " + (isFly ? "Да" : "Нет") + ", Умеет ходить: " + (isWalk ? "Да" : "Нет") + ", Умеет плавать: " + (isSwim ? "Да" : "Нет"));
    }
    public void rename(String name){
        this.name = name;
    }


    public void holiday() {
        this.weight += 0.1;
    }
    public void holiday(double m) {
        this.weight += m;
    }
    public void holiday(double m, int n) {
        for (int i = 0; i < n; i++) {
            this.weight += m;
        }

    }
}
