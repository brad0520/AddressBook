package addressBook;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AddressDao dao = new AddressDao();
		WebView wv = new WebView();
		Scanner sc = new Scanner(System.in);
		// 주소록 프로세스

		while (true) {
			System.out.println("메뉴를 입력해주세요 :");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {
				ArrayList<Address> Addresses = dao.selectAddress();
				wv.printArticles(Addresses);
			} 
			else if (cmd.equals("listByName")) {
				ArrayList<Address> Addresses = dao.selectAddressByName();
				wv.printArticles(Addresses);
			} 
			else if (cmd.equals("add")) {
				dao.insertArticle();
			} 
			else if (cmd.equals("modify")) {
				dao.modifyAddress();
			} 
			else if (cmd.equals("delete")) {
				dao.deleteAddress();
			}
		}

	}

}
