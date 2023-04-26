package repoistory;

import java.util.HashMap;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;




/*
 *  Message
 *  
 *  DAO : Data Access Object 의 약자로
 *   디비처리하는 객체 만들때 붙여서 만들기도한다
 */
public class MessagesDAO extends DAO{

	// 데이터 등록을 처리할 메서드
	public static int createMessage(String target, String body, String pass) {
		
		SqlSession session = factory.openSession(true);
		Map<String, Object> obj = new HashMap<>();
		obj.put("target", target);
		obj.put("body", body);
		obj.put("pass", pass);

		int r = session.insert("messages.create",obj);
		System.out.println("r===" +r);
		session.close();
		return r;
	}

	
	
}
