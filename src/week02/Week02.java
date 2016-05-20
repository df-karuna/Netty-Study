package week02;

import java.io.IOException;
import java.util.List;

import week02.db.DBConnectionPool;
import week02.db.exception.ConnectionFailureException;
import week02.db.exception.ConnectionTimeOutException;

public class Week02 {
	
	/**
	 * 시나리오
	 * 1. 2대의 데이터베이스 서버가 존재한다.
	 * 2. 1번 서버에 연결을 했는데 네트워크 장애로 인해 서버 연결이 지연되어 Timeout이 발생한다.
	 * 3. 그래서 2번 서버에 연결을 했으나 비밀번호가 틀렸다고 나온다.
	 * 4. 다시 1번 서버에 재시도를 한다.
	 * 5. 성공한다.
	 * 6. 사용자 정보 리스트를 데이터베이스로부터 불러온다.
	 * 7. 데이터베이스로부터 불러온 정보가 없는 상황
	 * 8. 다시 2번 서버에 연결을 했는데 마침 관리자가 계정정보를 1번과 일치하게 바꾸었다.
	 * 9. 2번 서버에 연결시도를 헀더니 정상적인 데이터를 불러오는데 성공했다.
	 * 10. 데이터를 출력한다.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		/**
		 * 데이터베이스 커넥션, 실제로 커넥션을 하는 것이 아니라 모의로 연결하는 겁니다.
		 * 긴장하지말고 오류가 나지 않도록 해봅시다.
		 * ** 가능하면 OT때 설명했던 것을 곰곰히 생각해보시며 작업해 주시면 감사하겠습니다.
		 */
		DBConnectionPool pool1 = null;
		DBConnectionPool pool2  = null;
		

		while(pool1 == null && pool2 == null){
			pool1 = new DBConnectionPool("dbserver://study.netty.io", 9568, "admin", "test");
			pool2 = new DBConnectionPool("dbserver://study.netty.io", 9569, "admin", "test1");
		}
		
		int resouceCounter = pool1.getDataResourcesCount();
		List<Integer> dataResources = pool1.getDataResources();
		
		for(int i = 0 ; i < resouceCounter; i++){
			dataResources.get(i);
		}
		
		
	}
}
