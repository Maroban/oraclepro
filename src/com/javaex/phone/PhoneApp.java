package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		// 사전준비
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		System.out.println("******************************************************");
		System.out.println("*               전화번호 관리 프로그램               *");
		System.out.println("******************************************************");

		while (flag) {
			System.out.println("1. 리스트  2. 등록  3. 수정  4. 삭제  5. 검색  6. 종료  ");
			System.out.println("--------------------------------------------------------");
			System.out.print("> 메뉴 번호: ");
			int menu = sc.nextInt();

			switch (menu) {
			// 전화번호부 출력
			case 1:
				System.out.println();
				System.out.println("< 1. 리스트 >");

				// SELECT 쿼리문 실행
				personList = phoneDao.getPersonList();
				printList(personList);
				System.out.println();
				break;

			// 전화번호 등록
			case 2:
				System.out.println();
				System.out.println("< 2. 등록 >");

				// 스캐너 버그
				sc.nextLine();

				// 이름
				System.out.print("이름 > ");
				String iName = sc.nextLine();

				// 휴대번호
				System.out.print("휴대번호 > ");
				String iHp = sc.nextLine();

				// 회사번호
				System.out.print("회사번호 > ");
				String iCompany = sc.nextLine();
				System.out.println();

				// INSERT 쿼리문 실행
				PersonVo pInsert = new PersonVo(iName, iHp, iCompany);
				phoneDao.insert(pInsert);

				break;

			// 전화번호 수정
			case 3:
				System.out.println();
				System.out.println("< 3. 수정 >");

				// ID 번호
				System.out.print("번호 > ");
				int u_id_num = sc.nextInt();

				// 스캐너 버그
				sc.nextLine();

				// 이름
				System.out.print("이름 > ");
				String uName = sc.nextLine();

				// 휴대번호
				System.out.print("휴대번호 > ");
				String uHp = sc.nextLine();

				// 회사번호
				System.out.print("회사번호 > ");
				String uCompany = sc.nextLine();
				System.out.println();

				// UPDATE 쿼리문 실행
				PersonVo pUpdate = new PersonVo(u_id_num, uName, uHp, uCompany);
				phoneDao.update(pUpdate);

				break;

			// 전화번호 삭제
			case 4:
				// ID 번호
				System.out.print("번호 > ");
				int d_id_num = sc.nextInt();

				// DELETE 쿼리문 실행
				phoneDao.delete(d_id_num);

				break;

			// 키워드 검색
			case 5:

				// 스캐너 버그
				sc.nextLine();

				// 키워드 검색
				System.out.print("검색어 > ");
				String keyword = sc.nextLine();

				printList(phoneDao.search(keyword));
				System.out.println();
				break;

			// 종료
			case 6:
				System.out.println();
				System.out.println("*******************************************************");
				System.out.println("*                     감사합니다.                     *");
				System.out.println("*******************************************************");
				flag = false;
				break;

			default:
				System.out.println();
				System.out.println("[다시 입력해주세요.]");
				System.out.println();
				break;
			}
		}

		sc.close();

	}

	public static void printList(List<PersonVo> personList) {
		for (int i = 0; i < personList.size(); i++) {

			PersonVo personVo = personList.get(i);

			int person_id = personVo.getPerson_id();
			String name = personVo.getName();
			String hp = personVo.getHp();
			String company = personVo.getCompany();

			System.out.println(person_id + ".    " + name + "    " + hp + "    " + company);
		}
	}
}
