package com.sh.guessgame.mybatis.model;

import java.util.Date;

public class UserInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.state
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Date gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_id
     *
     * @return the value of user_info.user_id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_id
     *
     * @param userId the value for user_info.user_id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.state
     *
     * @return the value of user_info.state
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.state
     *
     * @param state the value for user_info.state
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gmt_create
     *
     * @return the value of user_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gmt_create
     *
     * @param gmtCreate the value for user_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gmt_modify
     *
     * @return the value of user_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gmt_modify
     *
     * @param gmtModify the value for user_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}