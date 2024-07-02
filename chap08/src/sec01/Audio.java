package sec01;


// implements로 구성된 interface안의 모든 추상 메소드들은 반드시 class 에서 구현해야 한다.
public class Audio implements RemoteControl{
	private int volume;		// 필드(멤버 변수)
	
	public void turnOn() {	// RemoteControl에 있는 turnOn() 메소드
		System.out.println("Audio를 킵니다.");
	}
	public void turnOff() {	// RemoteControl에 있는 turnOff() 메소드
		System.out.println("Audio를 끕니다.");
	}
	public void setVolume(int volume) {	// RemoteControl에 있는 setVolume() 메소드
		if(volume>RemoteControl.MAX_VOLUME) {
		 this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
		 this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}

}
