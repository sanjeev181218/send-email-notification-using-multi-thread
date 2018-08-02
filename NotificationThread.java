package notification;

import java.util.List;

public class NotificationThread implements Runnable {
	List<String> emailList;
	int maxEmailToBeSend = 500;
	int waitingTime = 1000;
	Object object = new Object();

	public NotificationThread(List<String> emailLs) {
		this.emailList = emailLs;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Start. Record id = " + emailList.toString());
		sendEmail(emailList);
		System.out.println(Thread.currentThread().getName() + "End.");
	}

	private void sendEmail(List<String> emailList) {
		try {
			System.out.println(" Start sent mail time " + System.currentTimeMillis());
			int sendCount = 0;
			for (String email : emailList) {
				System.out.println("message sent successfully..." + email);
				sendCount++;
				if (sendCount % this.maxEmailToBeSend == 0) {
					System.out.println(" Now going to sleep " + System.currentTimeMillis());
					Thread.sleep(this.waitingTime);
					System.out.println(" Start sent mail time " + System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}