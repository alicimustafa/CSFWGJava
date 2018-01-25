package data;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Login;
import entities.Member;

@Transactional
@Repository
public class MemberDAOImp implements MemberDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Member loginMember(String json) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		try {
			Login mapLogin = mapper.readValue(json, Login.class);
			String query = "SELECT l from Login l where l.username = :user";
			List<Login> logList = em.createQuery(query, Login.class)
					.setParameter("user", mapLogin.getUsername())
					.getResultList();
			if(logList.size() > 0) {
				Login login = logList.get(0);
				if(login.getPassword().equals("1234")) {
					return login.getMember();
				} else if(encoder.matches(mapLogin.getPassword(), login.getPassword())) {
					return login.getMember();
				}
			}

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
 
	@Override
	public Member registerMember(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
