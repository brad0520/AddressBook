package addressBook;

import java.util.ArrayList;

// 웹브라우저에 데이터 출력
public class WebView {
	
	public void printArticles(ArrayList<Address> Addresses) {
		System.out.println("=== 웹 출력 ===");
		for(int i = 0; i < Addresses.size(); i++) {
			System.out.println("이름 : " + Addresses.get(i).getName());
			System.out.println("주소 : " + Addresses.get(i).getAddress());
			System.out.println("전화번호 : " + Addresses.get(i).getPhoneNumber());
		}
	}
}
