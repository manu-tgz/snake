package logic;

public class Coord {
public int x;
public int y;

public Coord(int x, int y) {
	this.x =x;
	this.y =y;
}
@Override
public boolean equals(Object o) {

    // If the object is compared with itself then return true  
    if (o == this) {
        return true;
    }

    /* Check if o is an instance of Complex or not
      "null instanceof [type]" also returns false */
    if (!(o instanceof Coord)) {
        return false;
    }
     
    // typecast o to Coord so that we can compare data members 
    Coord c = (Coord) o;
     
    // Compare the data members and return accordingly 
    return c.x == this.x && c.y == this.y;
}
}
