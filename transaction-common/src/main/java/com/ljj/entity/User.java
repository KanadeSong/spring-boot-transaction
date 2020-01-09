package com.ljj.entity;

import lombok.*;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/7
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String userName;
    private String passWord;
    private String userSex;
    private String nickName;

    public User(String userName, String passWord, String userSex, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }
}
