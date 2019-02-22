package com.baizhi.dao;

import com.baizhi.entity.CmfzUser;
import com.baizhi.entity.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDao {
    Map getAllSexCount();

    Map getAllUserCount();

    List<UserDTO> getAllProvinceCity();

    void insert(CmfzUser cmfzUser);
}
