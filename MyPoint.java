public class MyPoint{
    private char name;
    private int x, y;
    public MyPoint(){ x = y = 0; }
    public MyPoint (char name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public MyPoint(int x, int y){
        name = 'P';
        this.x = x;
        this.y = y;
    }
    public char getName(){ return name; }
    public void setName(char name){ this.name = name; }
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }
    public int getY() { return y; }
    public void setY(int y){ this.y = y; }
    public int quadrant() {
        if(x > 0){
            if(y > 0)
                return 1;
            if(y < 0)
                return 4;
        }
        if(x < 0){
            if(y > 0)
                return 2;
            if(y < 0)
                return 3;
        }
        return 0;
    }
    public double distance(){
        return Math.sqrt(Math.pow((double)(x), 2.0) + Math.pow((double)(y), 2.0D));
    }
    public double distance(MyPoint p){
        return Math.sqrt(Math.pow((double)(p.x - x), 2.0) + Math.pow((double)(p.y - y), 2.0D));
    }
    @Override
    public String toString() {
        return String.format("%c(%d, %d)", name, x, y);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyPoint){
            MyPoint p = (MyPoint) obj;
            if(p.name == name && p.x == x && p.y == y)
                return true;
        }
        return false;
    }
}