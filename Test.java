public class Test {
    public static void main(String[] args) {
        LivingHouse ct = new library2(10, 15, 2, 7);
        System.out.println(ct);
        System.out.println("Площадь библио = " + ct.getSquareArea());
        System.out.println("Кабинетов на этаже=" + ct.getAverageRoomsOnFloor());
    }
}