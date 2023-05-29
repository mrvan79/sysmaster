package kk.soft.co.jp.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kk.soft.co.jp.sys.model.UserModel;

@Repository
@Mapper
public interface UserMapper {

	int insert(UserModel userModel);
//    List<UserModel> selectAll();
	Object select(UserModel userModel);
	UserModel checkAccount(UserModel userModel);
	UserModel selectAll(UserModel userModel);
	int checkpass(UserModel userModel);
	List<UserModel> takeAll(UserModel userModel);
	List<UserModel> selectuser(UserModel userModel);
	int delete(UserModel userModel);

}
