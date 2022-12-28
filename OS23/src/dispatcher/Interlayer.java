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
		//Txt üzerinden okunup genel bir kuyruða atýlan prosesler önceliklerine göre ayrý kuyruklara ayrýþtýrýlýyor.
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
		//Her bir kuyruk sort algoritmalarýna tabi tutularak kuyruk içindeki proseslerin,
		//varýþ zamaný ve önceliklerine göre kuyruðu teþkil etmeleri saðlanýyor.
		GeneralFunctions.bubbleSortWithArrivalTime(RealTimeProcess);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess1);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess1);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess2);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess2);
		GeneralFunctions.bubbleSortWithArrivalTime(UserBasedProcess3);
		GeneralFunctions.bubbleSortWithPriority(UserBasedProcess3);

		//Dispatcher baþlatýlýyor ve kuyuklar parametre olarak geçiliyor.
		ProcessDispatcher a = new ProcessDispatcher();
		a.RunDispatcher(RealTimeProcess,UserBasedProcess1,UserBasedProcess2,UserBasedProcess3);
	} 	
}
