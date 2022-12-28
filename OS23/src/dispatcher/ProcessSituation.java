package dispatcher;

public enum ProcessSituation { //Proses statelerinin tanýmlandýðý enum
	READY, //Hazýr
	RUNNING, //Çalýþýyor
	INTERRUPTED, //Kesilde(20 saniyeden fazla çalýþtýðý durumlar)
	TERMINATED //Sonlandýrýldý
}
