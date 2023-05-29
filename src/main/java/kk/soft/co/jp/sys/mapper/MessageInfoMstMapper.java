package kk.soft.co.jp.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kk.soft.co.jp.sys.model.MessageInfoMstModel;

@Repository
@Mapper
public interface MessageInfoMstMapper {

    int insert(MessageInfoMstModel messageInfoMst);



}
