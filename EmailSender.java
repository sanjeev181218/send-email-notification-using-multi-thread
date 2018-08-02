package notification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailSender {

	public static void mailSender(List<String> emailLs) throws SQLException {
		ExecutorService executor = Executors.newFixedThreadPool(50);
		Runnable worker = new NotificationThread(emailLs);
		executor.execute(worker);
		while (!executor.isTerminated()) {
		}
	}

	/* Main method */

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<String> emailList = new ArrayList<String>();
		for (int i = 0; i < 5000; i++) {
			emailList.add("aa" + i);
		}
		mailSender(emailList);
	}
}