import java.io.File;
import java.util.Scanner;

public class ScanClass {
    public static void scanMethod()
    {
        Scanner scan = null;
        try
        {
            File f = new File( "./text.txt" );
            scan = new Scanner( f );
            int maxTaste = 0;
            int totalFoods = 0;
            int maxEats = 0;
            String food = "";
            for ( ;scan.hasNext(); )
            {
                StringBuilder current = new StringBuilder(scan.next());
                while ( !scan.hasNextInt()  )
                {
                    current.append( " " + scan.next() );
                }
                int timesEaten = scan.nextInt();
                totalFoods += timesEaten;
                int currentTaste = scan.nextInt();
                if ( currentTaste > maxTaste )
                {
                    maxTaste = currentTaste;
                    food = current.toString();
                    maxEats = timesEaten;
                }
            }
            
            double percentEaten = ( (double) maxEats/totalFoods ) * 100;
            System.out.print( "You like " + food + " the most. You ate it " + percentEaten + " of the time." );
            
        }
        catch( Exception e)
        {
            
        }
        finally
        {
            if (scan != null) {
                scan.close();
            }
        }
    }
    public static void main(String[] args)
    {
        scanMethod();
    }

}

/*
Write code to read this file and determine which food you like the most and the percentage of your 
meals that used that food. The most liked food will be the food with the highest rating. The percent 
will be the number of times you ate it divided by the number of times you ate anything (based only on the file).

Output example: You like Duck Donuts Sundaes the most. You ate it 4.3% of the time.
*/