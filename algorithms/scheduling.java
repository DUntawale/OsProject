package algorithms;

public class scheduling {
	 
	public static void main(String args[]) {  
        
		// Process id's  
    int processes[] = {1, 2, 3, 4};  
    int n = processes.length;  
  
    // Burst time of all processes  
    int burst_time[] = {10, 4, 6, 2};  
   
    // Arrival time of all processes  
    int arrival_time[] = {0, 3, 5, 7};  
    

    
    System.out.print("HHRN" +"\n");
   HRRN.findavgTime(n, processes, burst_time, arrival_time); 
   System.out.print("Multilevel Feedback" +"\n");
    MultilevelFeedback.findavgTime(n, processes, burst_time, arrival_time);
    }  
	
	
	
	
	
}
