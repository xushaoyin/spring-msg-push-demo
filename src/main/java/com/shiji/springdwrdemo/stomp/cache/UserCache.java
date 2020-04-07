package com.shiji.springdwrdemo.stomp.cache;

import com.shiji.springdwrdemo.stomp.domain.mo.User;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存用户信息
 *
 * @author xsy
 * @date 2020/3/23
 */
public class UserCache {

    /**
     * 在线用户列表
     */
    private final static ConcurrentHashMap<String, User> USER_MAP = new ConcurrentHashMap<>(32);

    /*static {
        // 初始化机器人信息
        String uid = RobotConstant.key;
        User user = new User();
        user.setUserId(uid);
        user.setUsername(RobotConstant.name);
        user.setAvatar(RobotConstant.avatar);
        user.setAddress(RobotConstant.address);
        user.setStatus(UserStatusConstant.ONLINE);

        // 将机器人加入到用户列表
        USER_MAP.put(uid, user);
    }*/

    /**
     * 添加用户
     *
     * @param key 存储的键
     * @param user 存储的user对象
     */
    public static void addUser(String key, User user) {
        if (USER_MAP.containsKey(key)) {
            return;
        }

        USER_MAP.put(key, user);
    }

    /**
     * 获取用户
     *
     * @param key 存储的键
     * @return user对象
     */
    public static User getUser(String key) {
        return USER_MAP.get(key);
    }

    /**
     * 查询用户是否在线
     * @param key
     * @return
     */
    public static boolean isUserOnline(String key) {
        if (getUser(key) == null) {
            return false;
        }
        return true;
    }

    public static User[] getUsers(String[] keys) {
        User[] users = new User[]{};
        if (ArrayUtils.isNotEmpty(keys)) {
            for (String key : keys) {
                users = ArrayUtils.add(users, USER_MAP.get(key));
            }
        }
        return users;
    }

    /**
     * 删除用户
     *
     * @param key 存储的键
     */
    public static void removeUser(String key) {
        USER_MAP.remove(key);
    }

    /**
     * 获取在线用户数
     *
     * @return 在线人数
     */
    public static int getOnlineCount() {
        return USER_MAP.size();
    }

    /**
     * 获取所有的在线用户
     *
     * @return 在线人数列表
     */
    public static List<User> listUser() {
        return new ArrayList<>(USER_MAP.values());
    }

}
