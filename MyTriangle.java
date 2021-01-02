public class MyTriangle implements Comparable <MyTriangle>, MyShape<MyTriangle, MyRectangle> {
    public static double area (MyPoint A, MyPoint B, MyPoint C){
        return Math.abs((A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX() * (A.getY() - B.getY())) / 2.0D);
    }
    private String name;
    private MyPoint A, B, C;
    public MyTriangle () { }
    public MyTriangle (String name){ this.name = name; }
    public MyTriangle (MyTriangle t){
        name = t.name;
        A = t.A;
        B = t.B;
        C = t.C;
    }
    public MyTriangle (MyPoint A, MyPoint B, MyPoint C){
        name = "Triangle";
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public MyTriangle (String name, MyPoint A, MyPoint B, MyPoint C){
        this.name = name;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public MyPoint getA() { return A; }
    public void setA(MyPoint A) { this.A = A; }
    public MyPoint getB() { return B; }
    public void setB(MyPoint B) { this.B = B; }
    public MyPoint getC() { return C; }
    public void setC(MyPoint C) { this.C = C; }
    public void move(MyPoint A, MyPoint B, MyPoint C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    @Override
    public double area () {
        return Math.abs((A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX() * (A.getY() - B.getY())) / 2.0D);
    }
    @Override
    public MyTriangle intersection (MyTriangle t){
        if(contains(t.getA()) && contains(t.getB()) && contains(t.getC()))
            return t;
        if(t.contains(A) && t.contains(B) && t.contains(C))
            return this;
        if(new MyRectangle(new MyPoint (Math.min(A.getX(), Math.min(B.getX(), C.getX())),
        Math.min(A.getY(), Math.min(B.getY(), C.getY()))),
        new MyPoint(Math.max(A.getX(), Math.max(B.getX(), C.getX())),
        Math.max(A.getY(), Math.max(B.getY(), C.getY())))).intersection(new MyRectangle(
        new MyPoint(Math.min(t.getA().getX(), Math.min(t.getB().getX(), t.getC().getX())),
        Math.min(t.getA().getY(), Math.min(t.getB().getY(), t.getC().getY()))),
        new MyPoint(Math.max(t.getA().getX(), Math.max(t.getB().getX(), t.getC().getX())),
        Math.max(t.getA().getY(), Math.max(t.getB().getY(), t.getC().getY()))))) != null){
            
            return this;
        }
        return null;
    }
    @Override
    public boolean contains (MyPoint p){
        return (MyTriangle.area (A, B, C) == MyTriangle.area (p, B, C) + MyTriangle.area (A, p, C) + MyTriangle.area (A, B, p));
    }
    
    @Override
    public int quadrant() {
        return A.quadrant();
    }
    @Override
    public int compare(MyRectangle r) {
        return Double.valueOf(area()).compareTo(Double.valueOf(r.area()));
    }
    @Override
    public int compareTo(MyTriangle another) {
        return Double.valueOf(area()).compareTo(Double.valueOf(another.area()));
    }
    @Override
    public String toString() {
        return String.format("%s: [%s, %s, %s]", name, A, B, C);
    }
}
