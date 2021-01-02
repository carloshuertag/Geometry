public class MyRectangle implements Comparable<MyRectangle>, MyShape<MyRectangle, MyTriangle> {
    private String name;
    private MyPoint A, B;
    public MyRectangle (String name){ this.name = name; }
    public MyRectangle (MyRectangle r){
        name = r.name;
        A = r.A;
        B = r.B;
    }
    public MyRectangle (MyPoint A, MyPoint B){
        name = "Rectangle";
        this.A = A;
        this.B = B;
    }
    public MyRectangle (String name, MyPoint A, MyPoint B){
        this.name = name;
        this.A = A;
        this.B = B;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public MyPoint getA() { return A; }
    public void setA(MyPoint A) { this.A = A; }
    public MyPoint getB() { return B; }
    public void setB(MyPoint B) { this.B = B; }
    public MyRectangle union (MyRectangle r){
        return new MyRectangle(new MyPoint(Math.min(A.getX(), r.A.getX()), Math.min(A.getY(), r.A.getY())), new MyPoint(Math.max(B.getX(), r.B.getX()), Math.max(B.getY(), r.B.getY())));
    }
    public void move(MyPoint A, MyPoint B) {
        this.A = A;
        this.B = B;
    }
    @Override
    public double area (){
        return Math.abs((B.getX() - A.getX()) * (B.getY() - A.getY()));
    }
    @Override
    public MyRectangle intersection (MyRectangle r){
        int xMin = Math.max(A.getX(), r.A.getX());
        int xMax = Math.min(B.getX(), r.B.getX());
        if (xMax > xMin){
            int yMin = Math.max(A.getY(), r.A.getY());
            int yMax = Math.min(B.getY(), r.B.getY());
            if (yMax > yMin)
                return new MyRectangle(new MyPoint(xMin, yMin), new MyPoint(xMax, yMax));
        }
        return null;
    }
    @Override
    public boolean contains (MyPoint p){
        return A.getX() <= p.getX() && p.getX() <= B.getX() && A.getY() <= p.getY() && p.getY() <= B.getY();
    }
    @Override
    public int quadrant() {
        return new MyPoint(A.getX(), B.getY()).quadrant();
    }
    @Override
    public int compare(MyTriangle t) {
        return Double.valueOf(area()).compareTo(Double.valueOf(t.area()));
    }
    @Override
    public int compareTo(MyRectangle another) {
        return Double.valueOf(area()).compareTo(Double.valueOf(another.area()));
    }
    @Override
    public String toString() {
        return String.format("%s: [%s, %s]", name, A, B);
    }
}
