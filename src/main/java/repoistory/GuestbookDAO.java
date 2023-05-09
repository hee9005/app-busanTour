package repoistory;



import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;




public class GuestbookDAO extends DAO {
public static int creategusetBook(String content, String boardPass, String writer) {
		
		SqlSession session = factory.openSession(true);
		Map<String, Object> obj = new HashMap<>();
		obj.put("boardPass", boardPass);
		obj.put("content", content);
		obj.put("writer", writer);
		int r = session.insert("messages.createAnonymous",obj);
		System.out.println("r===" +r);
		session.close();
		return r;
	}
}
