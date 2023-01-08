package dispatcher;

public class InterruptedProcess {
	public InterruptedProcess(String pID, int interruptedTime, ProcessType type ) {
		super();
		PID = pID;
		InterruptedTime = interruptedTime;
		this.type = type;
	}
	public String PID;
	public int InterruptedTime;
	public ProcessType type;
}
