import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Graphic3 {
    static int width = 1000, height = 1000;//задаем размеры формы
    static JFrame frame = new JFrame();//создаем форму

    public static class RunPlanet extends Thread {//класс для запуска движения планеты в паралелльном потоке
        private int sleep;//время задержки для таймера
        CreatePlanet planet;//созданная планета, для которой осуществляем движение
        public RunPlanet(CreatePlanet planet,int sleep) {//конструктор
            this.planet = planet;
            this.sleep = sleep;
        }
        @Override
        public void run() {
            for (int t = 0; t < 360;) {//идем по кругу
                try {//сперва работает таймер
                    Thread.sleep(sleep);
                    planet.l.setBounds((int) (planet.r*Math.cos(t*Math.PI/180))+planet.dX, (int) (planet.r*Math.sin(t*Math.PI/180))+planet.dY, planet.w, planet.h);//перемещаем картинку в нужную точку, которую вычисляем по формуле параметрических уравнений линий, приводя градусы t к радианам
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                t=t==359?0:t+1;//этой формулой обеспечиваем постоянный цикл и обнуление t при 359
            }
        }
    }

    public static class CreatePlanet{//класс для создания планеты
        private String path;//имя файла с картинкой
        public int w, h;//длина и ширина картинки
        public int r;//радиус от солнца
        public int dX,dY;//константы для смещения картинки (т.к. координаты - это ее верхний левый угол, а не центр)
        public JLabel l;
        public CreatePlanet(String path, int r) throws IOException {//конструктор
            this.path = path;
            this.r=r;
            BufferedImage im = ImageIO.read(new File("src\\planet\\"+path));//открываем картинку
            w = im.getWidth();
            h = im.getHeight();
            l = new JLabel(new ImageIcon(im));//создаем объект с картинкой, который будем размещать и двигать
            if (r==0) l.setBounds(width / 2 - w / 2, height / 2 - h / 2, w, h);//если это Солнце, то выставляем ему начальные координаты
            dX=width/2-w/2;
            dY=height/2-h/2;
            frame.add(l);//добавляем картинку на форму
        }
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//способ выхода из формы
        frame.setTitle("Солнечная система");//заголовок формы
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);//выставляем размеры окна
        frame.getContentPane().setLayout(null);//выравнивание, чтобы координаты объектов в дальнейшем считались от верхнего левого угла
        frame.getContentPane().setBackground(Color.black);//фон окна
        new CreatePlanet("sun.png",0);//создаем солнце
        frame.setVisible(true);//делаем форму видимой
        String[][] planets = new String[][]{new String []{"mercury","140","5"},{"venus","160","10"},{"earth","190","15"},{"mars","220","20"},
                {"jupiter","270","30"},{"saturn","340","40"},{"uranus","410","60"},{"neptune","450","100"}};//заносим в массив названия планет, радиус от солнца и тайм-аут при движении
        for (int i = 0; i < planets.length; i++)//в цикле запускаем планеты
            new RunPlanet(new CreatePlanet(i+"_"+planets[i][0]+".png",Integer.valueOf(planets[i][1])),Integer.valueOf(planets[i][2])).start();
    }
}