package com.cershy.linyuminiserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cershy.linyuminiserver.dto.UserDto;
import com.cershy.linyuminiserver.entity.User;
import com.cershy.linyuminiserver.vo.user.CreateUserVo;
import com.cershy.linyuminiserver.vo.user.UpdateUserVo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {
    boolean isExist(String name, String email);

    User getUserByNameOrEmail(String name, String email);

    User getUserByName(String name);

    User createUser(CreateUserVo createUserVo);

    UserDto getUserById(String userId);

    List<UserDto> listUser();

    List<String> onlineWeb();

    Map<String, UserDto> listMapUser();

    void online(String userId);

    void offline(String userId);

    void deleteExpiredUsers(LocalDate expirationDate);

    void updateUserBadge(String id);

    void initBotUser();

    boolean updateUser(String userid, UpdateUserVo updateUserVo);
}
