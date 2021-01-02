public interface MyShape<T, V> {
    public double area();
    public boolean contains (MyPoint p);
    public int quadrant ();
    public T intersection (T o);
    public int compare(V o);
}
