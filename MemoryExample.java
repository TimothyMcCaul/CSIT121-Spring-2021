/*
 * Copyright (C) 2021 Timothy McCaul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Timothy McCaul
 */
public class MemoryExample {
    public static void main(String[] args) {
        Point a;
        
        // Here a, b, c and d are null
        
        a = new Point();
        Point b = new Point(3, 4);
        
         // Here a, b are objects in the heap and c is still null
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("----------------");
        
        Point c = a; // Shallow copy, c is just an alias of a
        
        // Modifying a will modify c, as they are the same object in memory
        a.add(b);
        a.add(3, 2);
        
        System.out.println("a: " + a);
        System.out.println("c: " + c);
        System.out.println("----------------");
        
        
        Point d = b.clone(); // Deep copy, d is a new object with the values copied from b
        d.add(1, 1); // Modifying d will leave b unaffected as they have two different memory locations
        System.out.println("b: " + b);
        System.out.println("d: " + d);
        
        // Takeaway: Understanding the difference between shallow and deep copy
        // Shallow copies are stored in the same memory location, they are aliases to the same object
        // Deep copies are different memory locations, so after creation operations on one will not affect the other
    }
}

class Point implements Cloneable {
    private int x;
    private int y;
    
    public Point() {
        x = y = 0;
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void add(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    public void add(Point other) {
        this.x += other.x;
        this.y += other.y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public Point clone() {
        return new Point(x, y);
    }
}
