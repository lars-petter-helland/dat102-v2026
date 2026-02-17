package no.hvl.dat102.waitline;
/** 
   A driver that demonstrates the class WaitLine.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver 
{
	public static void main(String[] args) 
	{
		WaitLine customerLine = new WaitLine();
		customerLine.simulate(20, 0.5, 5); 
		customerLine.displayResults();

		System.out.println("\n\nDone.");
	}  // end main
}  // end Driver

// NOTE: Because this application depends on random numbers, your output likely
// will differ from the following results.
/*
 Customer 1 enters line at time 0. Transaction time is 5
 Customer 1 begins service at time 0. Time waited is 0
 Customer 2 enters line at time 3. Transaction time is 2
 Customer 3 enters line at time 5. Transaction time is 2
 Customer 2 begins service at time 5. Time waited is 2
 Customer 3 begins service at time 7. Time waited is 2
 Customer 4 enters line at time 9. Transaction time is 5
 Customer 4 begins service at time 9. Time waited is 0
 Customer 5 enters line at time 12. Transaction time is 3
 Customer 6 enters line at time 13. Transaction time is 4
 Customer 5 begins service at time 14. Time waited is 2
 Customer 7 enters line at time 15. Transaction time is 2
 Customer 8 enters line at time 16. Transaction time is 1
 Customer 6 begins service at time 17. Time waited is 4
 Customer 9 enters line at time 19. Transaction time is 2
 
 Number served = 6
 Total time waited = 10
 Average time waited = 1.6666666666666667
 Number left in line = 3
 
 
 Done.
*/
