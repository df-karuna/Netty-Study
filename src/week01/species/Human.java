package week01.species;

public class Human extends Mammel {
	public Human(){
		pregnencyDue = 10;
	}
	
	@Override
	public void growl() {
		System.out.println("끄아아아 야근 ㅠㅠ");
	}

	@Override
	public void walk() {
		System.out.println("뚜벅뚜벅 두발로 걷습니다.");
	}
	
	@Override
	public void pregnent() {
		super.pregnent();
	}

	@Override
	public void marryWith(Mammel spouse) {
		if(this.getClass().isInstance(spouse) ){
			if(this.spouse != null) return;	
			this.spouse = (Human)spouse;
			spouse.marryWith(this);
		} else {
			System.out.println("성적 취향은 존중합니다만...");
		}
	}
	

}
