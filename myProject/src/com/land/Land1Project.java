package com.land;

import java.util.Scanner;

public class Land1Project {
	public static void main(String[] args) {
		System.out.println("지번 찾기 프로그램 시작");
		
		Land1Service landService = new Land1Service();
		Scanner scanner = new Scanner(System.in); 
			
		while(true) {
			if (landService.getInsertLogin()) {
				System.out.println("           <원하시는 목록을 선택해주세요>");
				System.out.println("1.지번등록 2.지번목록 3.상세보기 4.수정 5.삭제 6.종료");
			} else {
				System.out.println("           <1번을 눌러 로그인을 하십시오>         \n\t아이디가 없으시다면 2번을 눌러 회원가입을 하십시오.\n\t3번을 누르시면 종료됩니다.");
				int menuNumber1 = 0;
				try {
					menuNumber1 = Integer.parseInt(scanner.nextLine());
				} catch(Exception e) {
					System.out.println("잘못된 값을 입력하셨습니다.");
					continue;
				}
				
				switch(menuNumber1) {
				case 1:
					System.out.println("로그인");
					
					landService.insertlogin();
					break;
				case 2:
					System.out.println("회원 가입");
					
					landService.createId();
					break;
				}
				if(menuNumber1 == 3) {
					System.out.print("종료");
					break;
				}
				//System.out.println("로그인");
				continue;
			}
			
			
			int menuNumber = 0;
			try {
				menuNumber = Integer.parseInt(scanner.nextLine());
			} catch(Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				continue;
			}
			System.out.println("선택한 번호: " + menuNumber);	
			
			if(menuNumber < 1 || menuNumber > 6) {
				System.out.println("1~6번의 번호만 눌러주세요");
				continue;
			}
			
			switch(menuNumber) {
				case 1:
					System.out.println("지번 등록");
					
					landService.insertBoard();
					break;
				case 2:
					System.out.println("지번 목록");
					
					landService.allBoard();
					break;
				case 3:
					System.out.println("상세보기");
					
					landService.oneBoard();
					break;
				case 4:
					System.out.println("지번 수정");
					
					landService.updateBoard();
					break;
				case 5:
					System.out.println("지번 삭제");
					
					landService.deleteBoard();
					break;
				}
			if(menuNumber == 6) {
				System.out.print("종료");
				break;
			}
		}
		// 프로그램 종료 표시
		System.out.println("지번 찾기 프로그램 종료");
	}
}

