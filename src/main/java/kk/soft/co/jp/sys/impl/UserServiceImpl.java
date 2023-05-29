package kk.soft.co.jp.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kk.soft.co.jp.sys.mapper.UserMapper;
import kk.soft.co.jp.sys.model.UserModel;
import kk.soft.co.jp.sys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    /**
     * 新規作成
     *
     * @param messageInfoMst
     */
	@Override
    public int insert(UserModel userModel) {

        return mapper.insert(userModel);
    }

	public UserModel selectAll(UserModel userModel) {
		return mapper.selectAll(userModel);
		
	}

	

	public UserModel checkAccount(UserModel userModel) {
		return mapper.checkAccount(userModel);
	}

	public Object select(UserModel userModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	public List<UserModel> takeAll(UserModel userModel) {
		return mapper.takeAll(userModel);

	}

	@Override
	public int checkpass(UserModel userModel) {
		return mapper.checkpass(userModel);
	}

	@Override
	public List<UserModel> selectuser(UserModel userModel) {
		return mapper.selectuser(userModel);
	}

	@Override
	public int delete(UserModel userModel) {
		return mapper.delete(userModel);
	}

}