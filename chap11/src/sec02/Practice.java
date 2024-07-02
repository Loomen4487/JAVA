package sec02;

import java.util.*;
import java.text.*;

public class Practice {

	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}

}
