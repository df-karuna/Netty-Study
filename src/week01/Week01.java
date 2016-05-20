package week01;

import week01.species.Human;

public class Week01 {

	public static void main(String[] args) {
		Human man = new Human();
		Human woman = new Human();
		
		System.out.println("남자와 여자가 결혼합니다. 딴딴따단~ 딴딴따단~");
		man.marryWith(woman);
		woman.pregnent();
	}

}
