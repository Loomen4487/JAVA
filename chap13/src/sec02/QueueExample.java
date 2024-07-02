package sec02;

import java.util.*;

public class QueueExample {

	public static void main(String[] args) {
		// queue는 인터페이스
		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendkakaotalk", "홍두께"));
		
		while(!messageQueue.isEmpty()) {		//큐 안의 객체들이 비어있을 때까지
			Message message = messageQueue.poll();		//큐 안의 제일 먼저 들어간 객체를 가져옴
			
			switch(message.command) {
			case "sendMail":		// first 제일 먼저 실행
				System.out.println(message.to + "님에게 메일을 보낸다.");
				break;
			case "sendSMS":			// second
				System.out.println(message.to + "님에게 SMS을 보낸다.");
				break;
			case "sendkakaotalk":	// third 자리르 바꿔서 넣어도 카카오가 세번째로 나옴
				System.out.println(message.to + "님에게 카카오톡을 보낸다.");
				break;
			}
		}

	}

}
