package dispatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GeneralFunctions {
	   private String CreateColor(String PID) { //Procesesin id sine g?re benzersiz renk ?retiliyor.
          	return "\u001B[38;5;"+PID+1+"m "+"    ";
		   }
	public Queue ReadFile(String filePath) throws IOException //Txt den okunan procesesler genel bir kuyru?a at?l?yor.
	{
		Queue ProcessListFromText = new Queue();
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		String line;
		int number=-1;
		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) //Her bir sat?r i?in bilgiler parse edilip proses s?n?f?n?n i?i dolduruluyor.
		{	
			line =line.replaceAll("\\s", "");
			number++;
			String[] parsedProcess = line.split(",");
			Process T = new Process();
			T.ArrivalTime=Integer.valueOf(parsedProcess[0]);
			T.Priority=Integer.valueOf(parsedProcess[1]);
			T.BurstTime=Integer.valueOf(parsedProcess[2]);
			T.PID=String.valueOf(number);
			T.Color=CreateColor(T.PID);
			ProcessListFromText.ekle(T);
		}
		br.close();
		
		return ProcessListFromText;	
	}
	  public static void bubbleSortWithArrivalTime(Queue queue) 
	  //Kuyru?un i?erisindeki proseslerin var?? zamanlar?na g?re s?ralayan fonksiyon.
	  {  
	        int n = queue.getSize();  
	        Process temp = null;  
	         for(int i=0; i < n; i++)
	         {  
	                 for(int j=1; j < (n-i); j++)
	                 {  
	                          if(queue.getir(j-1).ArrivalTime > queue.getir(j).ArrivalTime)
	                          {  
	                                 //swap elements  
	                                 temp = queue.getir(j-1);  
	                                 queue.degistir(j-1, queue.getir(j));
	                                 queue.degistir(j, temp);
	                         }  
	                          
	                 }  
	         }  
	  
	    }
	  public static void bubbleSortWithPriority(Queue queue) 
	  //OPT?M?ZASYON ?RNE??D?R VARI? ZAMANLARI AYNI OLUP PRIORITY E GORE SIRALAMA YAPILARAK ISLEM
	  //SURESI KISALTILMASI HEDEFLENMISTIR.
	  {  
	        int n = queue.getSize();  
	        Process temp = null;  
	         for(int i=0; i < n; i++)
	         {  
	                 for(int j=1; j < (n-i); j++)
	                 {  
	                	 if(queue.getir(j-1).ArrivalTime==queue.getir(j).ArrivalTime && queue.getir(j-1).Priority > queue.getir(j).Priority)
	                	 {
 
	                                 //swap elements  
	                                 temp = queue.getir(j-1);  
	                                 queue.degistir(j-1, queue.getir(j));
	                                 queue.degistir(j, temp); 
	                	 }                                            
	                 }  
	         }  	  
	   }	  
}
