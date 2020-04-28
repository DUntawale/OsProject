package algorithms;

import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class rectangle extends Applet {
	int apw1[];
	int p[];
	int i=0,n,n1;
	Graphics g= getGraphics();

	public void init(){
		try{
			BufferedReader obj=new BufferedReader(new InputStreamReader (System.in));
			System.out.println("ENTER no. of processes:");
			n=Integer.parseInt(obj.readLine());
			int ch;
			int bt[]=new int[n];
			
			do {
				System.out.println("MENU FOR CPU SCHEDULING");
				System.out.println("5.HRRN method");
				System.out.println("6.Multi-level Feedback method");
				System.out.println("3.EXIT");
				System.out.println("ENTER YOUR CHOICE");

			ch=Integer.parseInt(obj.readLine());

			switch(ch) {
				case 5:{
					//new variables to keep track of process number and arrival time
					int at[]=new int[n]; 
					int p[]=new int[n];
					
					//inputs arrival time
					for( i=0; i<n; i++){
						System.out.println("ENTER arrival time for each process in order of arival: p"+ (i+1));
						at[i]=Integer.parseInt(obj.readLine());
					}
					for( i=0; i<n; i++){
						System.out.println("ENTER burst time for each process: p"+ (i+1));
						bt[i]=Integer.parseInt(obj.readLine());
					}
					
					//creates an array for the process numbers
					for( i=0; i<n; i++){
						p[i]= i + 1;
					}
					
					//finds the tt and wt for each process using HRRN
					Process Pross[] = HRRN.findavgTime(n, p, bt, at);
					
					//finds average wait time
					float twt = 0;
					for(int i = 0; i < n; i++) {
						twt = twt + Pross[i].getWt();
					}	
					float awt = twt /n;
					
					//finds average turn around time. 
					float ttt = 0;
					for(int i = 0; i < n; i++) {
						ttt = ttt + Pross[i].getTt();
					}
					float  att = ttt /n;
					
					//prints wait and turn around times for each process
					for(i=0;i<n;i++)
						System.out.println(" waiting time for p"+(i+1)+"is:"+Pross[i].getWt());					
					for(i=0;i<n;i++)
						System.out.println(" Turn around time for p"+(i+1)+"is:"+Pross[i].getTt());
					
					//prints average turn around and wait times
					System.out.println(" Average turn around time is:"+ att);
					System.out.println(" Average wait time is:"+ awt);
					
				
					break;
				}


		case 6: {
			//new variables to keep track of process number and arrival time
			int at[]=new int[n]; 
			int p[]=new int[n];
			
			//inputs arrival time
			for( i=0; i<n; i++){
				System.out.println("ENTER arrival time for each process in order of arival: p"+ (i+1));
				at[i]=Integer.parseInt(obj.readLine());
			}
			for( i=0; i<n; i++){
				System.out.println("ENTER burst time for each process: p"+ (i+1));
				bt[i]=Integer.parseInt(obj.readLine());
			}
			
			//creates an array for the process numbers
			for( i=0; i<n; i++){
				p[i]= i + 1;
			}
			
			Process Pross[] = MultilevelFeedback.findavgTime(n, p, bt, at);
			
			float twt = 0;
			for(int i = 0; i < n; i++) {
				twt = twt + Pross[i].getWt();
			}	
			float awt = twt /n;
			
			//finds average turn around time. 
			float ttt = 0;
			for(int i = 0; i < n; i++) {
				ttt = ttt + Pross[i].getTt();
			}
			float  att = ttt /n;
			
			//prints wait and turn around times for each process
			for(i=0;i<n;i++)
				System.out.println(" waiting time for p"+(i+1)+" is: "+Pross[i].getWt());					
			for(i=0;i<n;i++)
				System.out.println(" Turn around time for p"+(i+1)+" is: "+Pross[i].getTt());
			
			//prints average turn around and wait times
			System.out.println(" Average turn around time is: "+ att);
			System.out.println(" Average wait time is: "+ awt);
			}
			
			break;
		}

	} while(ch!=3);

}

	catch (Exception e){
	
	}

}

	public void paint(Graphics g) {
		for(int j=1;j<=n1;j++) {
			g.drawRect(50,50,(apw1[j]*20),30);
			g.drawString("p"+p[j-1],(55+(apw1[j-1]*20)),70);
			g.drawString(""+apw1[j-1],50+(apw1[j-1]*20),100);
		}
		g.drawString(""+apw1[n1],50+(apw1[n1]*20),100);

	}

}


