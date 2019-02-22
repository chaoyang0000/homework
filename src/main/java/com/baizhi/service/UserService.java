package com.baizhi.service;

import com.baizhi.entity.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map getAllSexCount();

    Map getAllUserCount();

    List<UserDTO> getAllProvinceCity();

    Map getAllDate();

    Map getAllDate1();


}
