package dispatcher;

public enum ProcessSituation { //Proses statelerinin tan�mland��� enum
	READY, //Haz�r
	RUNNING, //�al���yor
	INTERRUPTED, //Kesilde(20 saniyeden fazla �al��t��� durumlar)
	TERMINATED //Sonland�r�ld�
}
