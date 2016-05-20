package week01.species;

public abstract class Mammel {
	protected int pregnencyDue = 0;
	protected Mammel spouse;
	
	public abstract void growl();
	public abstract void walk();
	public abstract void marryWith(Mammel spouse);
	
	
	public void pregnent(){
		final int month = pregnencyDue;
		Runnable pregnentDue = () -> { pregnenting(month); };
		new Thread(pregnentDue).start();
	}
	
	private void pregnenting(int due){
		int i = 0;
		try {
			while(i < due){
				System.out.println("임신 " + (i+1) + "개월째");
				Thread.sleep(100);
				i++;
			} 
			System.out.println("축하합니다! 아기가 태어났습니다.");
		}catch(InterruptedException ex){
			System.out.println("유산하였습니다 ㅠㅠ");
		}; 
	}
}
