/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCcAccountIsNull() {
            addCriterion("cc_account is null");
            return (Criteria) this;
        }

        public Criteria andCcAccountIsNotNull() {
            addCriterion("cc_account is not null");
            return (Criteria) this;
        }

        public Criteria andCcAccountEqualTo(String value) {
            addCriterion("cc_account =", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountNotEqualTo(String value) {
            addCriterion("cc_account <>", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountGreaterThan(String value) {
            addCriterion("cc_account >", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountGreaterThanOrEqualTo(String value) {
            addCriterion("cc_account >=", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountLessThan(String value) {
            addCriterion("cc_account <", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountLessThanOrEqualTo(String value) {
            addCriterion("cc_account <=", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountLike(String value) {
            addCriterion("cc_account like", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountNotLike(String value) {
            addCriterion("cc_account not like", value, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountIn(List<String> values) {
            addCriterion("cc_account in", values, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountNotIn(List<String> values) {
            addCriterion("cc_account not in", values, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountBetween(String value1, String value2) {
            addCriterion("cc_account between", value1, value2, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcAccountNotBetween(String value1, String value2) {
            addCriterion("cc_account not between", value1, value2, "ccAccount");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeIsNull() {
            addCriterion("cc_lasttime is null");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeIsNotNull() {
            addCriterion("cc_lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeEqualTo(String value) {
            addCriterion("cc_lasttime =", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeNotEqualTo(String value) {
            addCriterion("cc_lasttime <>", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeGreaterThan(String value) {
            addCriterion("cc_lasttime >", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeGreaterThanOrEqualTo(String value) {
            addCriterion("cc_lasttime >=", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeLessThan(String value) {
            addCriterion("cc_lasttime <", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeLessThanOrEqualTo(String value) {
            addCriterion("cc_lasttime <=", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeLike(String value) {
            addCriterion("cc_lasttime like", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeNotLike(String value) {
            addCriterion("cc_lasttime not like", value, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeIn(List<String> values) {
            addCriterion("cc_lasttime in", values, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeNotIn(List<String> values) {
            addCriterion("cc_lasttime not in", values, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeBetween(String value1, String value2) {
            addCriterion("cc_lasttime between", value1, value2, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcLasttimeNotBetween(String value1, String value2) {
            addCriterion("cc_lasttime not between", value1, value2, "ccLasttime");
            return (Criteria) this;
        }

        public Criteria andCcFrontIsNull() {
            addCriterion("cc_front is null");
            return (Criteria) this;
        }

        public Criteria andCcFrontIsNotNull() {
            addCriterion("cc_front is not null");
            return (Criteria) this;
        }

        public Criteria andCcFrontEqualTo(String value) {
            addCriterion("cc_front =", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontNotEqualTo(String value) {
            addCriterion("cc_front <>", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontGreaterThan(String value) {
            addCriterion("cc_front >", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontGreaterThanOrEqualTo(String value) {
            addCriterion("cc_front >=", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontLessThan(String value) {
            addCriterion("cc_front <", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontLessThanOrEqualTo(String value) {
            addCriterion("cc_front <=", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontLike(String value) {
            addCriterion("cc_front like", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontNotLike(String value) {
            addCriterion("cc_front not like", value, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontIn(List<String> values) {
            addCriterion("cc_front in", values, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontNotIn(List<String> values) {
            addCriterion("cc_front not in", values, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontBetween(String value1, String value2) {
            addCriterion("cc_front between", value1, value2, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcFrontNotBetween(String value1, String value2) {
            addCriterion("cc_front not between", value1, value2, "ccFront");
            return (Criteria) this;
        }

        public Criteria andCcNicknameIsNull() {
            addCriterion("cc_nickname is null");
            return (Criteria) this;
        }

        public Criteria andCcNicknameIsNotNull() {
            addCriterion("cc_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andCcNicknameEqualTo(String value) {
            addCriterion("cc_nickname =", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameNotEqualTo(String value) {
            addCriterion("cc_nickname <>", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameGreaterThan(String value) {
            addCriterion("cc_nickname >", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("cc_nickname >=", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameLessThan(String value) {
            addCriterion("cc_nickname <", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameLessThanOrEqualTo(String value) {
            addCriterion("cc_nickname <=", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameLike(String value) {
            addCriterion("cc_nickname like", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameNotLike(String value) {
            addCriterion("cc_nickname not like", value, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameIn(List<String> values) {
            addCriterion("cc_nickname in", values, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameNotIn(List<String> values) {
            addCriterion("cc_nickname not in", values, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameBetween(String value1, String value2) {
            addCriterion("cc_nickname between", value1, value2, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcNicknameNotBetween(String value1, String value2) {
            addCriterion("cc_nickname not between", value1, value2, "ccNickname");
            return (Criteria) this;
        }

        public Criteria andCcGenderIsNull() {
            addCriterion("cc_gender is null");
            return (Criteria) this;
        }

        public Criteria andCcGenderIsNotNull() {
            addCriterion("cc_gender is not null");
            return (Criteria) this;
        }

        public Criteria andCcGenderEqualTo(String value) {
            addCriterion("cc_gender =", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderNotEqualTo(String value) {
            addCriterion("cc_gender <>", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderGreaterThan(String value) {
            addCriterion("cc_gender >", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderGreaterThanOrEqualTo(String value) {
            addCriterion("cc_gender >=", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderLessThan(String value) {
            addCriterion("cc_gender <", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderLessThanOrEqualTo(String value) {
            addCriterion("cc_gender <=", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderLike(String value) {
            addCriterion("cc_gender like", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderNotLike(String value) {
            addCriterion("cc_gender not like", value, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderIn(List<String> values) {
            addCriterion("cc_gender in", values, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderNotIn(List<String> values) {
            addCriterion("cc_gender not in", values, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderBetween(String value1, String value2) {
            addCriterion("cc_gender between", value1, value2, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcGenderNotBetween(String value1, String value2) {
            addCriterion("cc_gender not between", value1, value2, "ccGender");
            return (Criteria) this;
        }

        public Criteria andCcProvinceIsNull() {
            addCriterion("cc_province is null");
            return (Criteria) this;
        }

        public Criteria andCcProvinceIsNotNull() {
            addCriterion("cc_province is not null");
            return (Criteria) this;
        }

        public Criteria andCcProvinceEqualTo(String value) {
            addCriterion("cc_province =", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceNotEqualTo(String value) {
            addCriterion("cc_province <>", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceGreaterThan(String value) {
            addCriterion("cc_province >", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("cc_province >=", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceLessThan(String value) {
            addCriterion("cc_province <", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceLessThanOrEqualTo(String value) {
            addCriterion("cc_province <=", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceLike(String value) {
            addCriterion("cc_province like", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceNotLike(String value) {
            addCriterion("cc_province not like", value, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceIn(List<String> values) {
            addCriterion("cc_province in", values, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceNotIn(List<String> values) {
            addCriterion("cc_province not in", values, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceBetween(String value1, String value2) {
            addCriterion("cc_province between", value1, value2, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcProvinceNotBetween(String value1, String value2) {
            addCriterion("cc_province not between", value1, value2, "ccProvince");
            return (Criteria) this;
        }

        public Criteria andCcCityIsNull() {
            addCriterion("cc_city is null");
            return (Criteria) this;
        }

        public Criteria andCcCityIsNotNull() {
            addCriterion("cc_city is not null");
            return (Criteria) this;
        }

        public Criteria andCcCityEqualTo(String value) {
            addCriterion("cc_city =", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityNotEqualTo(String value) {
            addCriterion("cc_city <>", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityGreaterThan(String value) {
            addCriterion("cc_city >", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityGreaterThanOrEqualTo(String value) {
            addCriterion("cc_city >=", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityLessThan(String value) {
            addCriterion("cc_city <", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityLessThanOrEqualTo(String value) {
            addCriterion("cc_city <=", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityLike(String value) {
            addCriterion("cc_city like", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityNotLike(String value) {
            addCriterion("cc_city not like", value, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityIn(List<String> values) {
            addCriterion("cc_city in", values, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityNotIn(List<String> values) {
            addCriterion("cc_city not in", values, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityBetween(String value1, String value2) {
            addCriterion("cc_city between", value1, value2, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcCityNotBetween(String value1, String value2) {
            addCriterion("cc_city not between", value1, value2, "ccCity");
            return (Criteria) this;
        }

        public Criteria andCcAddressIsNull() {
            addCriterion("cc_address is null");
            return (Criteria) this;
        }

        public Criteria andCcAddressIsNotNull() {
            addCriterion("cc_address is not null");
            return (Criteria) this;
        }

        public Criteria andCcAddressEqualTo(String value) {
            addCriterion("cc_address =", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressNotEqualTo(String value) {
            addCriterion("cc_address <>", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressGreaterThan(String value) {
            addCriterion("cc_address >", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cc_address >=", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressLessThan(String value) {
            addCriterion("cc_address <", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressLessThanOrEqualTo(String value) {
            addCriterion("cc_address <=", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressLike(String value) {
            addCriterion("cc_address like", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressNotLike(String value) {
            addCriterion("cc_address not like", value, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressIn(List<String> values) {
            addCriterion("cc_address in", values, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressNotIn(List<String> values) {
            addCriterion("cc_address not in", values, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressBetween(String value1, String value2) {
            addCriterion("cc_address between", value1, value2, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcAddressNotBetween(String value1, String value2) {
            addCriterion("cc_address not between", value1, value2, "ccAddress");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayIsNull() {
            addCriterion("cc_birthday is null");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayIsNotNull() {
            addCriterion("cc_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayEqualTo(String value) {
            addCriterion("cc_birthday =", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayNotEqualTo(String value) {
            addCriterion("cc_birthday <>", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayGreaterThan(String value) {
            addCriterion("cc_birthday >", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("cc_birthday >=", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayLessThan(String value) {
            addCriterion("cc_birthday <", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayLessThanOrEqualTo(String value) {
            addCriterion("cc_birthday <=", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayLike(String value) {
            addCriterion("cc_birthday like", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayNotLike(String value) {
            addCriterion("cc_birthday not like", value, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayIn(List<String> values) {
            addCriterion("cc_birthday in", values, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayNotIn(List<String> values) {
            addCriterion("cc_birthday not in", values, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayBetween(String value1, String value2) {
            addCriterion("cc_birthday between", value1, value2, "ccBirthday");
            return (Criteria) this;
        }

        public Criteria andCcBirthdayNotBetween(String value1, String value2) {
            addCriterion("cc_birthday not between", value1, value2, "ccBirthday");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}