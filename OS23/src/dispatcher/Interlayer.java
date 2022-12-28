package dispatcher;


public class Interlayer {
	private static Queue RealTimeProcess=null;
	private static Queue UserBasedProcess1=null;
	private static Queue UserBasedProcess2=null;
	private static Queue UserBasedProcess3=null;

	
	public static void Decomposition(Queue ProcessList){
		RealTimeProcess = new Queue();
		UserBasedProcess1=new Queue();
		UserBasedProcess2=new Queue();
		UserBasedProcess3=new Queue();

		for(int i =0;i<ProcessList.getSize();i++) 
		//Txt �zerinden okunup genel bir kuyru�a at�lan prosesler �nceliklerine g�re ayr� kuyruklara ayr��t�r�l�yor.
		{

			if(ProcessList.getir(i).Priority==0) 
			{
				RealTimeProcess.ekle(ProcessList.getir(i));
				
			}
			else if(ProcessList.getir(i).Priority==1)
			{
				UserBasedProcess1.ekle(ProcessList.getir(i));			
			}
			else if(ProcessList.getir(i).Priority==2)
			{
				UserBasedProcess2.ekle(ProcessList.getir(i));			
			}
			else
			{
				UserBasedProcess3.ekle(ProcessList.getir(i));			
			}


		}
		//Her bir kuyruk sort algoritmalar�na tabi tutularak kuyruk i�indeki proseslerin,
		//var�� zaman� ve �nceliklerine g�re kuyru�u te�kil etmeleri sa�lan�yor.
		GeneralFunctions.bubbleSortWithArrivalTime(RealTimeProcess);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess1);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess1);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess2);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess2);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess3);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess3);

		//Dispatcher ba�lat�l�yor ve kuyuklar parametre olarak ge�iliyor.
		ProcessDispatcher a = new ProcessDispatcher();
		a.RunDispatcher(RealTimeProcess,UserBasedProcess1,UserBasedProcess2,UserBasedProcess3);
	} 	
}
