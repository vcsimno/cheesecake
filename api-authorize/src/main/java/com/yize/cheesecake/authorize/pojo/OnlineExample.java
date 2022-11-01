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

public class OnlineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnlineExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andCcTokenIsNull() {
            addCriterion("cc_token is null");
            return (Criteria) this;
        }

        public Criteria andCcTokenIsNotNull() {
            addCriterion("cc_token is not null");
            return (Criteria) this;
        }

        public Criteria andCcTokenEqualTo(String value) {
            addCriterion("cc_token =", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenNotEqualTo(String value) {
            addCriterion("cc_token <>", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenGreaterThan(String value) {
            addCriterion("cc_token >", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenGreaterThanOrEqualTo(String value) {
            addCriterion("cc_token >=", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenLessThan(String value) {
            addCriterion("cc_token <", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenLessThanOrEqualTo(String value) {
            addCriterion("cc_token <=", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenLike(String value) {
            addCriterion("cc_token like", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenNotLike(String value) {
            addCriterion("cc_token not like", value, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenIn(List<String> values) {
            addCriterion("cc_token in", values, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenNotIn(List<String> values) {
            addCriterion("cc_token not in", values, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenBetween(String value1, String value2) {
            addCriterion("cc_token between", value1, value2, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcTokenNotBetween(String value1, String value2) {
            addCriterion("cc_token not between", value1, value2, "ccToken");
            return (Criteria) this;
        }

        public Criteria andCcMailIsNull() {
            addCriterion("cc_mail is null");
            return (Criteria) this;
        }

        public Criteria andCcMailIsNotNull() {
            addCriterion("cc_mail is not null");
            return (Criteria) this;
        }

        public Criteria andCcMailEqualTo(String value) {
            addCriterion("cc_mail =", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailNotEqualTo(String value) {
            addCriterion("cc_mail <>", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailGreaterThan(String value) {
            addCriterion("cc_mail >", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailGreaterThanOrEqualTo(String value) {
            addCriterion("cc_mail >=", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailLessThan(String value) {
            addCriterion("cc_mail <", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailLessThanOrEqualTo(String value) {
            addCriterion("cc_mail <=", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailLike(String value) {
            addCriterion("cc_mail like", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailNotLike(String value) {
            addCriterion("cc_mail not like", value, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailIn(List<String> values) {
            addCriterion("cc_mail in", values, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailNotIn(List<String> values) {
            addCriterion("cc_mail not in", values, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailBetween(String value1, String value2) {
            addCriterion("cc_mail between", value1, value2, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcMailNotBetween(String value1, String value2) {
            addCriterion("cc_mail not between", value1, value2, "ccMail");
            return (Criteria) this;
        }

        public Criteria andCcPhoneIsNull() {
            addCriterion("cc_phone is null");
            return (Criteria) this;
        }

        public Criteria andCcPhoneIsNotNull() {
            addCriterion("cc_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCcPhoneEqualTo(String value) {
            addCriterion("cc_phone =", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneNotEqualTo(String value) {
            addCriterion("cc_phone <>", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneGreaterThan(String value) {
            addCriterion("cc_phone >", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cc_phone >=", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneLessThan(String value) {
            addCriterion("cc_phone <", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneLessThanOrEqualTo(String value) {
            addCriterion("cc_phone <=", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneLike(String value) {
            addCriterion("cc_phone like", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneNotLike(String value) {
            addCriterion("cc_phone not like", value, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneIn(List<String> values) {
            addCriterion("cc_phone in", values, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneNotIn(List<String> values) {
            addCriterion("cc_phone not in", values, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneBetween(String value1, String value2) {
            addCriterion("cc_phone between", value1, value2, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcPhoneNotBetween(String value1, String value2) {
            addCriterion("cc_phone not between", value1, value2, "ccPhone");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeIsNull() {
            addCriterion("cc_areacode is null");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeIsNotNull() {
            addCriterion("cc_areacode is not null");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeEqualTo(String value) {
            addCriterion("cc_areacode =", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeNotEqualTo(String value) {
            addCriterion("cc_areacode <>", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeGreaterThan(String value) {
            addCriterion("cc_areacode >", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("cc_areacode >=", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeLessThan(String value) {
            addCriterion("cc_areacode <", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeLessThanOrEqualTo(String value) {
            addCriterion("cc_areacode <=", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeLike(String value) {
            addCriterion("cc_areacode like", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeNotLike(String value) {
            addCriterion("cc_areacode not like", value, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeIn(List<String> values) {
            addCriterion("cc_areacode in", values, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeNotIn(List<String> values) {
            addCriterion("cc_areacode not in", values, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeBetween(String value1, String value2) {
            addCriterion("cc_areacode between", value1, value2, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcAreacodeNotBetween(String value1, String value2) {
            addCriterion("cc_areacode not between", value1, value2, "ccAreacode");
            return (Criteria) this;
        }

        public Criteria andCcTimeIsNull() {
            addCriterion("cc_time is null");
            return (Criteria) this;
        }

        public Criteria andCcTimeIsNotNull() {
            addCriterion("cc_time is not null");
            return (Criteria) this;
        }

        public Criteria andCcTimeEqualTo(String value) {
            addCriterion("cc_time =", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeNotEqualTo(String value) {
            addCriterion("cc_time <>", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeGreaterThan(String value) {
            addCriterion("cc_time >", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cc_time >=", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeLessThan(String value) {
            addCriterion("cc_time <", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeLessThanOrEqualTo(String value) {
            addCriterion("cc_time <=", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeLike(String value) {
            addCriterion("cc_time like", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeNotLike(String value) {
            addCriterion("cc_time not like", value, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeIn(List<String> values) {
            addCriterion("cc_time in", values, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeNotIn(List<String> values) {
            addCriterion("cc_time not in", values, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeBetween(String value1, String value2) {
            addCriterion("cc_time between", value1, value2, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcTimeNotBetween(String value1, String value2) {
            addCriterion("cc_time not between", value1, value2, "ccTime");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrIsNull() {
            addCriterion("cc_ipaddr is null");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrIsNotNull() {
            addCriterion("cc_ipaddr is not null");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrEqualTo(String value) {
            addCriterion("cc_ipaddr =", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrNotEqualTo(String value) {
            addCriterion("cc_ipaddr <>", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrGreaterThan(String value) {
            addCriterion("cc_ipaddr >", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrGreaterThanOrEqualTo(String value) {
            addCriterion("cc_ipaddr >=", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrLessThan(String value) {
            addCriterion("cc_ipaddr <", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrLessThanOrEqualTo(String value) {
            addCriterion("cc_ipaddr <=", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrLike(String value) {
            addCriterion("cc_ipaddr like", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrNotLike(String value) {
            addCriterion("cc_ipaddr not like", value, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrIn(List<String> values) {
            addCriterion("cc_ipaddr in", values, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrNotIn(List<String> values) {
            addCriterion("cc_ipaddr not in", values, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrBetween(String value1, String value2) {
            addCriterion("cc_ipaddr between", value1, value2, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcIpaddrNotBetween(String value1, String value2) {
            addCriterion("cc_ipaddr not between", value1, value2, "ccIpaddr");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidIsNull() {
            addCriterion("cc_deviceId is null");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidIsNotNull() {
            addCriterion("cc_deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidEqualTo(String value) {
            addCriterion("cc_deviceId =", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidNotEqualTo(String value) {
            addCriterion("cc_deviceId <>", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidGreaterThan(String value) {
            addCriterion("cc_deviceId >", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("cc_deviceId >=", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidLessThan(String value) {
            addCriterion("cc_deviceId <", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidLessThanOrEqualTo(String value) {
            addCriterion("cc_deviceId <=", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidLike(String value) {
            addCriterion("cc_deviceId like", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidNotLike(String value) {
            addCriterion("cc_deviceId not like", value, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidIn(List<String> values) {
            addCriterion("cc_deviceId in", values, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidNotIn(List<String> values) {
            addCriterion("cc_deviceId not in", values, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidBetween(String value1, String value2) {
            addCriterion("cc_deviceId between", value1, value2, "ccDeviceid");
            return (Criteria) this;
        }

        public Criteria andCcDeviceidNotBetween(String value1, String value2) {
            addCriterion("cc_deviceId not between", value1, value2, "ccDeviceid");
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