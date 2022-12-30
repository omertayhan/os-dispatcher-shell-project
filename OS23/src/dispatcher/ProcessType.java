package dispatcher;

public enum ProcessType { //Proses önceliklerinin tanýmlandýðý enum
	REALTIME,   //Gerçek zamanlý (öncelik = 0)
	USERBASED1,	//Kullanýcý tabanlý (öncelik = 1)
	USERBASED2,	//Kullanýcý tabanlý (öncelik = 2)
	USERBASED3	//Kullanýcý tabanlý (öncelik = 3)
}
