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

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andCcPwdIsNull() {
            addCriterion("cc_pwd is null");
            return (Criteria) this;
        }

        public Criteria andCcPwdIsNotNull() {
            addCriterion("cc_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andCcPwdEqualTo(String value) {
            addCriterion("cc_pwd =", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdNotEqualTo(String value) {
            addCriterion("cc_pwd <>", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdGreaterThan(String value) {
            addCriterion("cc_pwd >", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdGreaterThanOrEqualTo(String value) {
            addCriterion("cc_pwd >=", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdLessThan(String value) {
            addCriterion("cc_pwd <", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdLessThanOrEqualTo(String value) {
            addCriterion("cc_pwd <=", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdLike(String value) {
            addCriterion("cc_pwd like", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdNotLike(String value) {
            addCriterion("cc_pwd not like", value, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdIn(List<String> values) {
            addCriterion("cc_pwd in", values, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdNotIn(List<String> values) {
            addCriterion("cc_pwd not in", values, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdBetween(String value1, String value2) {
            addCriterion("cc_pwd between", value1, value2, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcPwdNotBetween(String value1, String value2) {
            addCriterion("cc_pwd not between", value1, value2, "ccPwd");
            return (Criteria) this;
        }

        public Criteria andCcSecretIsNull() {
            addCriterion("cc_secret is null");
            return (Criteria) this;
        }

        public Criteria andCcSecretIsNotNull() {
            addCriterion("cc_secret is not null");
            return (Criteria) this;
        }

        public Criteria andCcSecretEqualTo(String value) {
            addCriterion("cc_secret =", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretNotEqualTo(String value) {
            addCriterion("cc_secret <>", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretGreaterThan(String value) {
            addCriterion("cc_secret >", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretGreaterThanOrEqualTo(String value) {
            addCriterion("cc_secret >=", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretLessThan(String value) {
            addCriterion("cc_secret <", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretLessThanOrEqualTo(String value) {
            addCriterion("cc_secret <=", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretLike(String value) {
            addCriterion("cc_secret like", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretNotLike(String value) {
            addCriterion("cc_secret not like", value, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretIn(List<String> values) {
            addCriterion("cc_secret in", values, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretNotIn(List<String> values) {
            addCriterion("cc_secret not in", values, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretBetween(String value1, String value2) {
            addCriterion("cc_secret between", value1, value2, "ccSecret");
            return (Criteria) this;
        }

        public Criteria andCcSecretNotBetween(String value1, String value2) {
            addCriterion("cc_secret not between", value1, value2, "ccSecret");
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

        public Criteria andCcCreatetimeIsNull() {
            addCriterion("cc_createtime is null");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeIsNotNull() {
            addCriterion("cc_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeEqualTo(String value) {
            addCriterion("cc_createtime =", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeNotEqualTo(String value) {
            addCriterion("cc_createtime <>", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeGreaterThan(String value) {
            addCriterion("cc_createtime >", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("cc_createtime >=", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeLessThan(String value) {
            addCriterion("cc_createtime <", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("cc_createtime <=", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeLike(String value) {
            addCriterion("cc_createtime like", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeNotLike(String value) {
            addCriterion("cc_createtime not like", value, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeIn(List<String> values) {
            addCriterion("cc_createtime in", values, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeNotIn(List<String> values) {
            addCriterion("cc_createtime not in", values, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeBetween(String value1, String value2) {
            addCriterion("cc_createtime between", value1, value2, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcCreatetimeNotBetween(String value1, String value2) {
            addCriterion("cc_createtime not between", value1, value2, "ccCreatetime");
            return (Criteria) this;
        }

        public Criteria andCcBanIsNull() {
            addCriterion("cc_ban is null");
            return (Criteria) this;
        }

        public Criteria andCcBanIsNotNull() {
            addCriterion("cc_ban is not null");
            return (Criteria) this;
        }

        public Criteria andCcBanEqualTo(String value) {
            addCriterion("cc_ban =", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanNotEqualTo(String value) {
            addCriterion("cc_ban <>", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanGreaterThan(String value) {
            addCriterion("cc_ban >", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanGreaterThanOrEqualTo(String value) {
            addCriterion("cc_ban >=", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanLessThan(String value) {
            addCriterion("cc_ban <", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanLessThanOrEqualTo(String value) {
            addCriterion("cc_ban <=", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanLike(String value) {
            addCriterion("cc_ban like", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanNotLike(String value) {
            addCriterion("cc_ban not like", value, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanIn(List<String> values) {
            addCriterion("cc_ban in", values, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanNotIn(List<String> values) {
            addCriterion("cc_ban not in", values, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanBetween(String value1, String value2) {
            addCriterion("cc_ban between", value1, value2, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcBanNotBetween(String value1, String value2) {
            addCriterion("cc_ban not between", value1, value2, "ccBan");
            return (Criteria) this;
        }

        public Criteria andCcCharactersIsNull() {
            addCriterion("cc_characters is null");
            return (Criteria) this;
        }

        public Criteria andCcCharactersIsNotNull() {
            addCriterion("cc_characters is not null");
            return (Criteria) this;
        }

        public Criteria andCcCharactersEqualTo(String value) {
            addCriterion("cc_characters =", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersNotEqualTo(String value) {
            addCriterion("cc_characters <>", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersGreaterThan(String value) {
            addCriterion("cc_characters >", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersGreaterThanOrEqualTo(String value) {
            addCriterion("cc_characters >=", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersLessThan(String value) {
            addCriterion("cc_characters <", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersLessThanOrEqualTo(String value) {
            addCriterion("cc_characters <=", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersLike(String value) {
            addCriterion("cc_characters like", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersNotLike(String value) {
            addCriterion("cc_characters not like", value, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersIn(List<String> values) {
            addCriterion("cc_characters in", values, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersNotIn(List<String> values) {
            addCriterion("cc_characters not in", values, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersBetween(String value1, String value2) {
            addCriterion("cc_characters between", value1, value2, "ccCharacters");
            return (Criteria) this;
        }

        public Criteria andCcCharactersNotBetween(String value1, String value2) {
            addCriterion("cc_characters not between", value1, value2, "ccCharacters");
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