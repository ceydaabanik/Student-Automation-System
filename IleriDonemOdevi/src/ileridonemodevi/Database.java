/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileridonemodevi;


import java.io.*;
import java.util.*;
/**
 *
 * @author yigido
 */
public class Database {
    
    final static String
        LINE_SEP = System.getProperty("line.separator");
    Map<String, Course> crs = new LinkedHashMap<>();
    Map<Integer, Student> std = new LinkedHashMap<>();
    
    public Database() { 
    
        try {//C:\Users\yigido\Documents\NetBeansProjects\ileriOdev3\src\query
            for (String line : readLiness()) { 
                Course c = new Course(line);
                crs.put(c.name, c);
            }
            for (String line : readLines()) { 
                Student s = new Student(line);
                std.put(s.id, s);
            }
        } catch (IOException x) {
            System.out.println(x);
        }
    }
    
   String[] readLines() throws IOException {
          //  System.out.printf("%s %s bytes %n", f, f.length());
            InputStream in = getClass().getResourceAsStream("Students.txt");
            
            byte[] ba = new byte[in.available()];
            in.read(ba); in.close(); 
            String str = new String(ba, "Cp1254");
            String[] sa = str.split(LINE_SEP);
          //  System.out.printf("%s satir okundu %n", sa.length);
            return sa;
    }
   
   String[] readLiness() throws IOException {
          //  System.out.printf("%s %s bytes %n", f, f.length());
            InputStream in = getClass().getResourceAsStream("Courses.txt");

            byte[] ba = new byte[in.available()];
            in.read(ba); in.close(); 
            String str = new String(ba, "Cp1254");
            String[] sa = str.split(LINE_SEP);
          //  System.out.printf("%s satir okundu %n", sa.length);
            return sa;
    }
   
    public Course findCourse(String s) {
        return crs.get(s.toUpperCase());
    }
    public Student findStudent(int k) {
        return std.get(k); 
    }
    
}
