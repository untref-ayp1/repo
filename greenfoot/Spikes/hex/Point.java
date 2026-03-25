class Point
{
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public final double x;
    public final double y;
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}