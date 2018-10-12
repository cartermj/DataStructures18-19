import java.io.File;
import java.util.Scanner;

public class ScanClass {
    public void scanMethod()
    {
        Scanner scan = null;
        try
        {
            File f = new File( "./src/text.txt" );
            scan = new Scanner( f );
            int maxTaste = 0;
            int totalFoods = 0;
            for ( ;scan.hasNext(); )
            {
                totalFoods += scan.nextInt();
                int currentTaste = scan.nextInt();
                if ( currentTaste > maxTaste )
                {
                    maxTaste = currentTaste;
                }
            }
        }
        catch( Exception e)
        {
            
        }
        finally
        {
            
        }
    }
    public static void main(String[] args) {

    }

}

/*
Write code to read this file and determine which food you like the most and the percentage of your 
meals that used that food. The most liked food will be the food with the highest rating. The percent 
will be the number of times you ate it divided by the number of times you ate anything (based only on the file).

Output example: You like Duck Donuts Sundaes the most. You ate it 4.3% of the time.
*/