package hust.soict.globalict.aims.thread;
import java.lang.Runnable;
public class MemoryDaemon {
long memoryUsed;
	public void run() {
		Runtime rt=Runtime.getRuntime();
		long used;
		while(true) {
			used=rt.totalMemory()-rt.freeMemory();
		if(used!=memoryUsed) {
			System.out.println("\tMemory used="+used);
			memoryUsed=used;
		}
		}
	}

}
