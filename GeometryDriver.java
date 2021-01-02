public class GeometryDriver {
    public static void setPoints(MyPoint p1, MyPoint p2, MyPoint p3, MyPoint p4, int a, int b, int c, int d, int e, int f, int g, int h){
        p1.setX(a);
        p1.setY(b);
        p2.setX(c);
        p2.setY(d);
        p3.setX(e);
        p3.setY(f);
        p4.setX(g);
        p4.setY(h);
    }
    public static void printPart1(MyRectangle r1, MyRectangle r2, MyPoint X, boolean end){
        if(!end){
            System.out.println(String.format("\n%s está en el cuadrante %d\n%s está en el cuadrante %d", r1, r1.quadrant(), r2, r2.quadrant()));
            System.out.println(String.format("La unión de R1 con R2 es %s", r1.union(r2)));
            System.out.println(String.format("La intersección de R1 con R2 es %s", r1.intersection(r2)));
            switch(r1.compareTo(r2)){
                case -1:
                    System.out.println("R1 es menor que R2");
                    break;
                case 0:
                    System.out.println("R1 es igual que R2");
                    break;
                case 1:
                    System.out.println("R1 es mayor que R2");
                    break;
            }
            System.out.println(X);
            if(r1.contains(X))
                System.out.println(String.format("El punto %s está adentro de %s", X, r1));
            else
                System.out.println(String.format("El punto %s está fuera de %s", X, r1));
        } else {
            System.out.println(String.format("\n%s está en el cuadrante %d", r1, r1.quadrant()));
        }
    }
    public static void printPart2(MyTriangle t1, MyTriangle t2, MyPoint X, boolean end){
        if(!end){
            System.out.println(String.format("\n%s está en el cuadrante %d\n%s está en el cuadrante %d", t1, t1.quadrant(), t2, t2.quadrant()));
            System.out.println(String.format("La intersección de ABC con DEF es %s", t1.intersection(t2)));
            switch(t1.compareTo(t2)){
                case -1:
                    System.out.println("R1 es menor que R2");
                    break;
                case 0:
                    System.out.println("R1 es igual que R2");
                    break;
                case 1:
                    System.out.println("R1 es mayor que R2");
                    break;
            }
            System.out.println(X);
            if(t1.contains(X))
                System.out.println(String.format("El punto %s está adentro de %s", X, t1));
            else
                System.out.println(String.format("El punto %s está fuera de %s", X, t1));
        } else {
            System.out.println(String.format("\n%s está en el cuadrante %d", t1, t1.quadrant()));
        }
    }
    public static void main(String[] args) {
        //Eg
        MyPoint Q = new MyPoint('Q',3,2), M = new MyPoint('M',7,4), 
        P = new MyPoint('P',5,3), N = new MyPoint('N',10,7), 
        X = new MyPoint(4,3), p = new MyPoint(),
        p1 = new MyPoint(-9,2), p2 = new MyPoint(-3, 8), 
        p3 = new MyPoint('A', -7, 4), p4 = new MyPoint(),
        p5 = new MyPoint('E', -4, 4), p6 = new MyPoint('F', -3, 2);
        MyRectangle R1 = new MyRectangle(Q,M), R2 = new MyRectangle(P,N), 
        r1 = new MyRectangle(new MyRectangle(p1, p2)), r2 = new MyRectangle("R2");
        printPart1(R1, R2, X, false);
        //Imp
        p4.setName('B');
        p4.setX(-4);
        p4.setY(6);
        r2.setA(p3);
        r2.setB(p4);
        r1.setName("R1");
        printPart1(r1, r2, X, false);
        setPoints(p1, p2, p3, p4, 3, 2, 7, 4, 5, 3, 10, 7);
        printPart1(r1, r2, X, false);
        setPoints(p1, p2, p3, p4, -7, -5, -3, -2, -6, -7, -4, -3);
        printPart1(r1, r2, X, false);
        setPoints(p1, p2, p3, p4, 2, -6, 5, -3, 4, -8, 8, -4);
        printPart1(r1, r2, X, false);
        r1 = new MyRectangle("REC", p1, p4);
        printPart1(r1, r2, X, true);
        System.out.println("Se mueve REC");
        r1.move(p3, p2);
        printPart1(r1, r2, X, true);
        p1.setName('A');
        p2.setName('B');
        p3.setName('C');
        p4.setName('D');
        setPoints(p1, p2, p3, p, -7, 1, -4, 5, -1, 1, 0, 0);
        p4.setX(-5);
        p4.setY(2);
        MyTriangle t1 = new MyTriangle(new MyTriangle(p1, p2, p3)), t2 = new MyTriangle("DEF");
        t1.setName("ABC");
        t2.setA(p4);
        t2.setB(p5);
        t2.setC(p6);
        printPart2(t1, t2, X, false);
        setPoints(p1, p2, p3, p, 1, 1, 4, 5, 7, 1, 0, 0);
        setPoints(p4, p5, p6, p, 1, 1, 2, 3, 3, 1, 0, 0);
        printPart2(t1, t2, X, false);
        setPoints(p1, p2, p3, p, 1, -3, 3, -1, 4, -3, 0, 0);
        setPoints(p4, p5, p6, p, 1, -5, 4, -1, 7, -5, 0, 0);
        printPart2(t1, t2, X, false);
        setPoints(p1, p2, p3, p, -7, -5, -4, -1, -1, -5, 0, 0);
        setPoints(p4, p5, p6, p, -5, -6, -4, -4, -3, -6, 0, 0);
        printPart2(t1, t2, X, false);
        switch(t1.compare(R1)){
            case -1:
                System.out.println("ABC es menor que R1");
                break;
            case 0:
                System.out.println("ABC es igual que R1");
                break;
            case 1:
                System.out.println("ABC es mayor que R1");
                break;
        }
        switch(R1.compare(t2)){
            case -1:
                System.out.println("R1 es menor que DEF");
                break;
            case 0:
                System.out.println("R1 es igual que DEF");
                break;
            case 1:
                System.out.println("R1 es mayor que DEF");
                break;
        }
        switch(t2.compare(R2)){
            case -1:
                System.out.println("DEF es menor que R2");
                break;
            case 0:
                System.out.println("DEF es igual que R2");
                break;
            case 1:
                System.out.println("DEF es mayor que R2");
                break;
        }
        switch(R1.compare(t2)){
            case -1:
                System.out.println("R1 es menor que DEF");
                break;
            case 0:
                System.out.println("R1 es igual que DEF");
                break;
            case 1:
                System.out.println("R1 es mayor que DEF");
                break;
        }
        t1 = new MyTriangle("t1", p1, p2, p3);
        printPart2(t1, t2, X, true);
        System.out.println("Se mueve t1");
        t1.move(p6, p5, p6);
        printPart2(t1, t2, X, true);
    }
}
