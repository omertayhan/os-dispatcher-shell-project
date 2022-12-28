package dispatcher;


public class Queue { //Kuyruk sýnýfý tanýmlanýyor
	int ilk; 
    int son; 
    int kapasite; 
    Process dizi[]; 
    int prosesSayisi;
        
    public Queue(){
        this.ilk = 0;
        this.son=-1;
        this.dizi = new Process[1];
        this.kapasite = 0;   
        this.prosesSayisi=0;
        genislet(5);
    }
     
    public Process getir(int index) //kuruktan index ile veri elde etme kabiliyeti kazandýrýlýyor.
    {
    	return dizi[index];
    }
    public int getSize() { //Kuyruðun içerisindeki veri sayýsýna eriþiliyor.
    	return prosesSayisi;
    }
    public void ekle(Process nesne){  //Kuyrða veri ekleme kabiliyeti kazandýrýlýyor.
        if(son==kapasite-1){ //Kapasiteyi aþma durumu konrol ediliyor, öyle bir durumda kapasite geniþletiliyor.
            genislet(kapasite);
        }
         son++;
         prosesSayisi++;
         dizi[son]=nesne;
       }   
    private void genislet(int boyut) { //Geniþletme Fonksþyonu(Kapasite arttýrma)
		// TODO Auto-generated method stub
		Process[] yeniDizi =new Process [boyut+kapasite];
		int yeniIndex=0;
	    for(int i=ilk;i<=son;i++)
	    {
	    	yeniDizi[yeniIndex] = dizi[i];   //Veriler yeni kapasite deðerine göre oluþutulmuþ diziye kopyalanýyor.
	         yeniIndex++;        
	    }
		son=prosesSayisi-1;
		ilk=0;
		dizi=yeniDizi;
		kapasite+=boyut;
	}

	public void degistir(int index,Process nesne){  //Veri güncelleme fonksiyonu
 
           dizi[index]=nesne;
    }
    
    public void cikar(){ //Veri çýkarma fonksiyonu
        if(prosesSayisi!=0){
        	ilk++;
        	prosesSayisi--;
        }
    }
       
}
