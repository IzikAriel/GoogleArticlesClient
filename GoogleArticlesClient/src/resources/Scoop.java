package resources;
import java.io.*;

public class Scoop {
    public static String rec(String p)
    {
        String temp= "src//resources//"+p;
        return  new File(temp).getAbsolutePath();
    }
}

