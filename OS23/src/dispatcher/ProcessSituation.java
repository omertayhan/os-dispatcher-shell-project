package dispatcher;

public enum ProcessSituation { //Proses statelerinin tanımlandığı enum
	READY, //Hazır
	RUNNING, //Çalışıyor
	INTERRUPTED, //Kesilde(20 saniyeden fazla çalıştığı durumlar)
	TERMINATED //Sonlandırıldı
}
