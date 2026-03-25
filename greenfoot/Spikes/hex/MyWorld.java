import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    Layout l;
    
    public Layout getLayout() {
        return this.l;
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.       
        super(1200, 800, 1); 
        
        int width = getWidth();
        int height = getHeight();
                
        int hexWidth = 64;
        
        Point hexSize = new Point(hexWidth, hexWidth);
        Point origin = new Point(hexWidth, hexWidth);
        Orientation o = Layout.flat;
        l = new Layout(o, hexSize, origin);
        
        int cols = (int)(0.7 * (width / hexWidth));
        int rows = (int)(0.666 * (height / hexWidth));
        
        for(int i= 0; i < cols; i++)
            for(int j = 0; j < rows; j++)
                draw(new Hex(i, j-i/2));
        
    }
    
    public void act() {
             MouseInfo mouse =  Greenfoot.getMouseInfo();  
            if(mouse!=null){  
                int button = mouse.getButton() ; 
                if(button == 1 && Greenfoot.mouseClicked(null)) 
                {
                    System.out.println(l.pixelToHex(new Point(mouse.getX(), mouse.getY())).hexRound());
                }
            }
    }
    
    public void draw(Hex h) {
        getBackground().setColor(Color.LIGHT_GRAY);
        ArrayList<Point> points = l.polygonCorners(h);
        for (int i = 0; i < points.size(); i++) {
            Point a = points.get(i);
            Point b = points.get((i+1)%points.size());
            
            getBackground().drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
            
        }
        //getBackground().drawPolygon(_xPoints_, _yPoints_, _nPoints_);
        getBackground().setColor(Color.BLACK);
        Point pos = l.hexToPixel(h);
        getBackground().drawString(h.toString(),(int)pos.x, (int)pos.y);
    }
}
