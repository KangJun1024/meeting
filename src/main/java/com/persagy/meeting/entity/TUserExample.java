package com.persagy.meeting.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andCUserIdIsNull() {
            addCriterion("c_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCUserIdIsNotNull() {
            addCriterion("c_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCUserIdEqualTo(String value) {
            addCriterion("c_user_id =", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotEqualTo(String value) {
            addCriterion("c_user_id <>", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdGreaterThan(String value) {
            addCriterion("c_user_id >", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_user_id >=", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLessThan(String value) {
            addCriterion("c_user_id <", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLessThanOrEqualTo(String value) {
            addCriterion("c_user_id <=", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLike(String value) {
            addCriterion("c_user_id like", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotLike(String value) {
            addCriterion("c_user_id not like", value, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdIn(List<String> values) {
            addCriterion("c_user_id in", values, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotIn(List<String> values) {
            addCriterion("c_user_id not in", values, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdBetween(String value1, String value2) {
            addCriterion("c_user_id between", value1, value2, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotBetween(String value1, String value2) {
            addCriterion("c_user_id not between", value1, value2, "UserId");
            return (Criteria) this;
        }

        public Criteria andCUserNameIsNull() {
            addCriterion("c_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCUserNameIsNotNull() {
            addCriterion("c_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCUserNameEqualTo(String value) {
            addCriterion("c_user_name =", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameNotEqualTo(String value) {
            addCriterion("c_user_name <>", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameGreaterThan(String value) {
            addCriterion("c_user_name >", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_user_name >=", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameLessThan(String value) {
            addCriterion("c_user_name <", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameLessThanOrEqualTo(String value) {
            addCriterion("c_user_name <=", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameLike(String value) {
            addCriterion("c_user_name like", value, "UserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameNotLike(String value) {
            addCriterion("c_user_name not like", value, "cUserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameIn(List<String> values) {
            addCriterion("c_user_name in", values, "cUserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameNotIn(List<String> values) {
            addCriterion("c_user_name not in", values, "cUserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameBetween(String value1, String value2) {
            addCriterion("c_user_name between", value1, value2, "cUserName");
            return (Criteria) this;
        }

        public Criteria andCUserNameNotBetween(String value1, String value2) {
            addCriterion("c_user_name not between", value1, value2, "cUserName");
            return (Criteria) this;
        }

        public Criteria andCMd5IsNull() {
            addCriterion("c_md5 is null");
            return (Criteria) this;
        }

        public Criteria andCMd5IsNotNull() {
            addCriterion("c_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andCMd5EqualTo(String value) {
            addCriterion("c_md5 =", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5NotEqualTo(String value) {
            addCriterion("c_md5 <>", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5GreaterThan(String value) {
            addCriterion("c_md5 >", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5GreaterThanOrEqualTo(String value) {
            addCriterion("c_md5 >=", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5LessThan(String value) {
            addCriterion("c_md5 <", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5LessThanOrEqualTo(String value) {
            addCriterion("c_md5 <=", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5Like(String value) {
            addCriterion("c_md5 like", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5NotLike(String value) {
            addCriterion("c_md5 not like", value, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5In(List<String> values) {
            addCriterion("c_md5 in", values, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5NotIn(List<String> values) {
            addCriterion("c_md5 not in", values, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5Between(String value1, String value2) {
            addCriterion("c_md5 between", value1, value2, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCMd5NotBetween(String value1, String value2) {
            addCriterion("c_md5 not between", value1, value2, "cMd5");
            return (Criteria) this;
        }

        public Criteria andCPasswordIsNull() {
            addCriterion("c_password is null");
            return (Criteria) this;
        }

        public Criteria andCPasswordIsNotNull() {
            addCriterion("c_password is not null");
            return (Criteria) this;
        }

        public Criteria andCPasswordEqualTo(String value) {
            addCriterion("c_password =", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotEqualTo(String value) {
            addCriterion("c_password <>", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordGreaterThan(String value) {
            addCriterion("c_password >", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("c_password >=", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLessThan(String value) {
            addCriterion("c_password <", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLessThanOrEqualTo(String value) {
            addCriterion("c_password <=", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLike(String value) {
            addCriterion("c_password like", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotLike(String value) {
            addCriterion("c_password not like", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordIn(List<String> values) {
            addCriterion("c_password in", values, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotIn(List<String> values) {
            addCriterion("c_password not in", values, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordBetween(String value1, String value2) {
            addCriterion("c_password between", value1, value2, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotBetween(String value1, String value2) {
            addCriterion("c_password not between", value1, value2, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCStateIsNull() {
            addCriterion("c_state is null");
            return (Criteria) this;
        }

        public Criteria andCStateIsNotNull() {
            addCriterion("c_state is not null");
            return (Criteria) this;
        }

        public Criteria andCStateEqualTo(String value) {
            addCriterion("c_state =", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotEqualTo(String value) {
            addCriterion("c_state <>", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateGreaterThan(String value) {
            addCriterion("c_state >", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateGreaterThanOrEqualTo(String value) {
            addCriterion("c_state >=", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLessThan(String value) {
            addCriterion("c_state <", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLessThanOrEqualTo(String value) {
            addCriterion("c_state <=", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLike(String value) {
            addCriterion("c_state like", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotLike(String value) {
            addCriterion("c_state not like", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateIn(List<String> values) {
            addCriterion("c_state in", values, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotIn(List<String> values) {
            addCriterion("c_state not in", values, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateBetween(String value1, String value2) {
            addCriterion("c_state between", value1, value2, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotBetween(String value1, String value2) {
            addCriterion("c_state not between", value1, value2, "cState");
            return (Criteria) this;
        }

        public Criteria andCIsAdminIsNull() {
            addCriterion("c_is_Admin is null");
            return (Criteria) this;
        }

        public Criteria andCIsAdminIsNotNull() {
            addCriterion("c_is_Admin is not null");
            return (Criteria) this;
        }

        public Criteria andCIsAdminEqualTo(String value) {
            addCriterion("c_is_Admin =", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminNotEqualTo(String value) {
            addCriterion("c_is_Admin <>", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminGreaterThan(String value) {
            addCriterion("c_is_Admin >", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminGreaterThanOrEqualTo(String value) {
            addCriterion("c_is_Admin >=", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminLessThan(String value) {
            addCriterion("c_is_Admin <", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminLessThanOrEqualTo(String value) {
            addCriterion("c_is_Admin <=", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminLike(String value) {
            addCriterion("c_is_Admin like", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminNotLike(String value) {
            addCriterion("c_is_Admin not like", value, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminIn(List<String> values) {
            addCriterion("c_is_Admin in", values, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminNotIn(List<String> values) {
            addCriterion("c_is_Admin not in", values, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminBetween(String value1, String value2) {
            addCriterion("c_is_Admin between", value1, value2, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCIsAdminNotBetween(String value1, String value2) {
            addCriterion("c_is_Admin not between", value1, value2, "cIsAdmin");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIsNull() {
            addCriterion("c_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIsNotNull() {
            addCriterion("c_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeEqualTo(Date value) {
            addCriterion("c_create_time =", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotEqualTo(Date value) {
            addCriterion("c_create_time <>", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeGreaterThan(Date value) {
            addCriterion("c_create_time >", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_create_time >=", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeLessThan(Date value) {
            addCriterion("c_create_time <", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_create_time <=", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIn(List<Date> values) {
            addCriterion("c_create_time in", values, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotIn(List<Date> values) {
            addCriterion("c_create_time not in", values, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeBetween(Date value1, Date value2) {
            addCriterion("c_create_time between", value1, value2, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_create_time not between", value1, value2, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeIsNull() {
            addCriterion("c_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeIsNotNull() {
            addCriterion("c_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeEqualTo(Date value) {
            addCriterion("c_update_time =", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeNotEqualTo(Date value) {
            addCriterion("c_update_time <>", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeGreaterThan(Date value) {
            addCriterion("c_update_time >", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_update_time >=", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeLessThan(Date value) {
            addCriterion("c_update_time <", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_update_time <=", value, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeIn(List<Date> values) {
            addCriterion("c_update_time in", values, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeNotIn(List<Date> values) {
            addCriterion("c_update_time not in", values, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("c_update_time between", value1, value2, "cUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_update_time not between", value1, value2, "cUpdateTime");
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