package com.sh.guessgame.mybatis.model;

import java.util.Date;

public class BatchInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.batch_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String batchNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.price
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.max_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Integer maxNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.total_amt
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String totalAmt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.random_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String randomNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.user_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Long userNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.batch_type
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String batchType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.batch_time
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Integer batchTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.status
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column batch_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    private Date gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.id
     *
     * @return the value of batch_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.id
     *
     * @param id the value for batch_info.id
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.batch_no
     *
     * @return the value of batch_info.batch_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.batch_no
     *
     * @param batchNo the value for batch_info.batch_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.price
     *
     * @return the value of batch_info.price
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.price
     *
     * @param price the value for batch_info.price
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.max_num
     *
     * @return the value of batch_info.max_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Integer getMaxNum() {
        return maxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.max_num
     *
     * @param maxNum the value for batch_info.max_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.total_amt
     *
     * @return the value of batch_info.total_amt
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getTotalAmt() {
        return totalAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.total_amt
     *
     * @param totalAmt the value for batch_info.total_amt
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt == null ? null : totalAmt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.random_num
     *
     * @return the value of batch_info.random_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getRandomNum() {
        return randomNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.random_num
     *
     * @param randomNum the value for batch_info.random_num
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum == null ? null : randomNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.user_no
     *
     * @return the value of batch_info.user_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Long getUserNo() {
        return userNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.user_no
     *
     * @param userNo the value for batch_info.user_no
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.batch_type
     *
     * @return the value of batch_info.batch_type
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getBatchType() {
        return batchType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.batch_type
     *
     * @param batchType the value for batch_info.batch_type
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setBatchType(String batchType) {
        this.batchType = batchType == null ? null : batchType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.batch_time
     *
     * @return the value of batch_info.batch_time
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Integer getBatchTime() {
        return batchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.batch_time
     *
     * @param batchTime the value for batch_info.batch_time
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setBatchTime(Integer batchTime) {
        this.batchTime = batchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.status
     *
     * @return the value of batch_info.status
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.status
     *
     * @param status the value for batch_info.status
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.gmt_create
     *
     * @return the value of batch_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.gmt_create
     *
     * @param gmtCreate the value for batch_info.gmt_create
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column batch_info.gmt_modify
     *
     * @return the value of batch_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column batch_info.gmt_modify
     *
     * @param gmtModify the value for batch_info.gmt_modify
     *
     * @mbg.generated Tue Oct 09 15:43:49 CST 2018
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}