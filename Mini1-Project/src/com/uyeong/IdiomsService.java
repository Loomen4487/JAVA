package com.uyeong;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.io.*;

public class IdiomsService {
	
	Scanner scanner = new Scanner(System.in);
	private int counter = 0;
	private List<Idioms> listIdioms = new ArrayList<>();
	List<String> list1 = new LinkedList<>();
	List<String> list2 = new LinkedList<>(list1);
	
	
	
	
	// 메뉴를 보여주는 메소드
	public void showMenu() throws Exception{
		while(true) {
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			System.out.println("1. 등록    |    2. 사자성어    |    3. 뜻    |    4.수정하기    |    5.삭제하기    |    6.목록    |     7.파일 저장    |   8.종료|");
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			System.out.println("선택: ");
				
			// 키보드를 입력받는 코드
		String selectIdioms = scanner.nextLine();
		switch(selectIdioms) {
		case "1":		// 등록
			registerIdioms();
			break;
		case "2":		// 사자성어
			showIdioms();
			break;
		case "3":		// 뜻
			showMeaning();
			break;
		case "4":		// 수정
			showRe();
			break;
		case "5":		// 삭제
			showDel();
			break;
		case "6":		// 목록
			showIdiomslist();
			break;
		case "7":		// 저장
			showIdiomsFile();
			break;
		case "8":		// 종료
			return;
				}
			}
		}
	
		public void showIdioms() {
		}
	
		public void showMeaning() {
		}
		public void showRe() {
			
		}	
		public void showDel() {		
			}
		
		public void registerIdioms() {
			try {
				Idioms idioms = new Idioms();
				idioms.setPno(++counter);				
		
				System.out.print("사자성어: ");
				idioms.setIdioms(scanner.nextLine());	
				
				System.out.print("뜻: ");
				idioms.setMeaning(scanner.nextLine());	
				
				System.out.print("수정하기: ");
				idioms.setMeaning(scanner.nextLine());
				
				System.out.print("삭제하기: ");
				idioms.setMeaning(scanner.nextLine());
				for(int i = 0; i < listIdioms.size(); i++) {
					Idioms str = listIdioms.get(i);
					System.out.println("수정되었습니다: " + str);
					
		}
		
		listIdioms.add(idioms);
	 } catch(Exception e) {
		System.out.println("등록 에러: " + e.getMessage());
	 		}
		}

		public void showIdiomslist() {
			for(Idioms  p : listIdioms) {
				System.out.println(p.getPno() + "\t" +p.getIdioms() + "\t" +
								p.getMeaning());
			}
		}
	
		public void showIdiomsFile() throws Exception {
			
			FileOutputStream fos = new FileOutputStream("./text1.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listIdioms);
			oos.flush();
			oos.close();
		}				
		
		public static List<Idioms> readlist() throws Exception{
			
			FileInputStream fis = new FileInputStream("./text1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Idioms> list = (List<Idioms>) ois.readObject();
			return list;
			}
		}

