package com.aaronazon.mvcfe.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.aaronazon.mvcfe.view.UserView;

@Service
@Transactional
public class LoginManagerImpl implements LoginManager {

	private static final String BACKEND_REST_USER_URI = "http://localhost:8080/AaronazonRestAPI/user/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserView registerUser(UserView userView) {
		HttpEntity<UserView> entity = new HttpEntity<>(userView);
		ResponseEntity<UserView> resp = restTemplate.postForEntity(BACKEND_REST_USER_URI, entity, UserView.class);
		return resp.getBody();
	}

	@Override
	public UserView deleteUser(UserView user) {
		//Login login = userService.deleteUser(user);
		//return login;
		return null;
	}

	@Override
	public UserView validateUser(UserView userView) {
		HttpEntity<UserView> entity = new HttpEntity<>(userView);
		ResponseEntity<UserView> resp = restTemplate.getForEntity(BACKEND_REST_USER_URI + userView.getId(), UserView.class, entity);
		userView = resp.getBody();
		return userView;
	}

}
