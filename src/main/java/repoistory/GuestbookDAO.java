package repoistory;



import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;




public class GuestbookDAO extends DAO {
public static int createguestBook(String target, String content, String boardPass, String writer) {
		
		SqlSession session = factory.openSession(true);
		Map<String, Object> obj = new HashMap<>();
		obj.put("target", target);
		obj.put("content", content);
		obj.put("boardPass", boardPass);
		obj.put("writer", writer);
		int r = session.insert("messages.create",obj);
		System.out.println("r===" +r);
		session.close();
		return r;
	}
}
