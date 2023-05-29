package kk.soft.co.jp.sys.service;


import java.util.List;

import kk.soft.co.jp.sys.model.UserModel;

public interface UserService {
	public UserModel selectAll(UserModel userModel);
	public List<UserModel> takeAll(UserModel userModel);

    public int insert(UserModel userModel);



	public UserModel checkAccount(UserModel userModel);
	public int checkpass (UserModel userModel);
	public List<UserModel> selectuser (UserModel userModel);
	public int delete (UserModel userModel);
}
