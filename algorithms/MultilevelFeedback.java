package algorithms;

public class MultilevelFeedback {


public static void findavgTime(int n, int processes[], int burst_time[], int arrival_time[]) {	
	Process[] p;    
    p = new Process[n];
    
    for(int i=0; i < n; i++) {
    	p[i] = new Process(processes[i], burst_time[i], arrival_time[i]); //creates and array of process objects
    }
	int time = 0; //sets time to 0
	
	int Quant = 10; //sets time quantum for RR
	
	//round robin x2
	for(int j = 0; j < 2; j++) {
		for (int i = 0 ; i < n; i++) { 
			boolean check = p[i].getAt() <= time;
			boolean check2 = p[i].getCom() == 0;
			if(check2 && check) { //checks that the process can run. 
				if(p[i].getTl() > Quant){ //adjusts time for processes with burst time > the time quantum
					p[i].adgTl(Quant);
					time = time + Quant; 
				}
				else { //adjusts time for processes with burst time < the time quantum and sets them to complete
					time = time + p[i].getTl();
					p[i].setCom();
					p[i].setCt(time);
					p[i].setTt();	
					p[i].setWt();	
					
					System.out.print(p[i].getNum() + " ");
					System.out.print(p[i].getWt() + " ");
					System.out.print(p[i].getTt() + "\n");
				}				
			}
		}		
	}
	//first come first serve
	for (int i = 0 ; i < n; i++) { 
		if(p[i].getCom() == 0) {
			time = time + p[i].getTl();
			p[i].setCom();
			p[i].setCt(time);
			p[i].setTt();	
			p[i].setWt();
			System.out.print(p[i].getNum() + " ");
			System.out.print(p[i].getWt() + " ");
			System.out.print(p[i].getTt() + "\n");
		}
	}
	float awt = awt(p,n);
	float att = att(p,n);
	
	System.out.print("The average turn around time is " + att + "\n");
	System.out.print( "The average wait time is " + awt + "\n");
	
	
}
private static float awt(Process[] p, int n){
	float twt = 0;
	float ret = 0;
	for(int i = 0; i < n; i++) {
		twt = twt + p[i].getWt();
	}	
	ret = twt /n;
	
	return ret;
	
}
private static float att(Process[] p, int n){
	float ttt = 0;
	float ret = 0;
	for(int i = 0; i < n; i++) {
		ttt = ttt + p[i].getTt();
	}
	ret = ttt /n;
	return ret;
	
}	
}