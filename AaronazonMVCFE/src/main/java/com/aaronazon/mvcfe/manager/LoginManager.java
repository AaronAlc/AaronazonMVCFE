package com.aaronazon.mvcfe.manager;

import com.aaronazon.mvcfe.view.UserView;

public interface LoginManager {

	UserView registerUser(UserView user);

	UserView deleteUser(UserView user);

	UserView validateUser(UserView user);

}
