package rms.po;

import java.util.ArrayList;
import java.util.List;

public class wechatuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public wechatuserExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNull() {
            addCriterion("appsecret is null");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNotNull() {
            addCriterion("appsecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppsecretEqualTo(String value) {
            addCriterion("appsecret =", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotEqualTo(String value) {
            addCriterion("appsecret <>", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThan(String value) {
            addCriterion("appsecret >", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThanOrEqualTo(String value) {
            addCriterion("appsecret >=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThan(String value) {
            addCriterion("appsecret <", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThanOrEqualTo(String value) {
            addCriterion("appsecret <=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLike(String value) {
            addCriterion("appsecret like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotLike(String value) {
            addCriterion("appsecret not like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretIn(List<String> values) {
            addCriterion("appsecret in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotIn(List<String> values) {
            addCriterion("appsecret not in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretBetween(String value1, String value2) {
            addCriterion("appsecret between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotBetween(String value1, String value2) {
            addCriterion("appsecret not between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeIsNull() {
            addCriterion("access_token_expires_time is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeIsNotNull() {
            addCriterion("access_token_expires_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeEqualTo(String value) {
            addCriterion("access_token_expires_time =", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeNotEqualTo(String value) {
            addCriterion("access_token_expires_time <>", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeGreaterThan(String value) {
            addCriterion("access_token_expires_time >", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeGreaterThanOrEqualTo(String value) {
            addCriterion("access_token_expires_time >=", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeLessThan(String value) {
            addCriterion("access_token_expires_time <", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeLessThanOrEqualTo(String value) {
            addCriterion("access_token_expires_time <=", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeLike(String value) {
            addCriterion("access_token_expires_time like", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeNotLike(String value) {
            addCriterion("access_token_expires_time not like", value, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeIn(List<String> values) {
            addCriterion("access_token_expires_time in", values, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeNotIn(List<String> values) {
            addCriterion("access_token_expires_time not in", values, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeBetween(String value1, String value2) {
            addCriterion("access_token_expires_time between", value1, value2, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresTimeNotBetween(String value1, String value2) {
            addCriterion("access_token_expires_time not between", value1, value2, "accessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeIsNull() {
            addCriterion("access_token_expires_last_time is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeIsNotNull() {
            addCriterion("access_token_expires_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeEqualTo(String value) {
            addCriterion("access_token_expires_last_time =", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeNotEqualTo(String value) {
            addCriterion("access_token_expires_last_time <>", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeGreaterThan(String value) {
            addCriterion("access_token_expires_last_time >", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("access_token_expires_last_time >=", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeLessThan(String value) {
            addCriterion("access_token_expires_last_time <", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeLessThanOrEqualTo(String value) {
            addCriterion("access_token_expires_last_time <=", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeLike(String value) {
            addCriterion("access_token_expires_last_time like", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeNotLike(String value) {
            addCriterion("access_token_expires_last_time not like", value, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeIn(List<String> values) {
            addCriterion("access_token_expires_last_time in", values, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeNotIn(List<String> values) {
            addCriterion("access_token_expires_last_time not in", values, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeBetween(String value1, String value2) {
            addCriterion("access_token_expires_last_time between", value1, value2, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andAccessTokenExpiresLastTimeNotBetween(String value1, String value2) {
            addCriterion("access_token_expires_last_time not between", value1, value2, "accessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenIsNull() {
            addCriterion("page_access_token is null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenIsNotNull() {
            addCriterion("page_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenEqualTo(String value) {
            addCriterion("page_access_token =", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenNotEqualTo(String value) {
            addCriterion("page_access_token <>", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenGreaterThan(String value) {
            addCriterion("page_access_token >", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("page_access_token >=", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenLessThan(String value) {
            addCriterion("page_access_token <", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("page_access_token <=", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenLike(String value) {
            addCriterion("page_access_token like", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenNotLike(String value) {
            addCriterion("page_access_token not like", value, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenIn(List<String> values) {
            addCriterion("page_access_token in", values, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenNotIn(List<String> values) {
            addCriterion("page_access_token not in", values, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenBetween(String value1, String value2) {
            addCriterion("page_access_token between", value1, value2, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenNotBetween(String value1, String value2) {
            addCriterion("page_access_token not between", value1, value2, "pageAccessToken");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeIsNull() {
            addCriterion("page_access_token_expires_time is null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeIsNotNull() {
            addCriterion("page_access_token_expires_time is not null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeEqualTo(String value) {
            addCriterion("page_access_token_expires_time =", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeNotEqualTo(String value) {
            addCriterion("page_access_token_expires_time <>", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeGreaterThan(String value) {
            addCriterion("page_access_token_expires_time >", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeGreaterThanOrEqualTo(String value) {
            addCriterion("page_access_token_expires_time >=", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeLessThan(String value) {
            addCriterion("page_access_token_expires_time <", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeLessThanOrEqualTo(String value) {
            addCriterion("page_access_token_expires_time <=", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeLike(String value) {
            addCriterion("page_access_token_expires_time like", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeNotLike(String value) {
            addCriterion("page_access_token_expires_time not like", value, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeIn(List<String> values) {
            addCriterion("page_access_token_expires_time in", values, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeNotIn(List<String> values) {
            addCriterion("page_access_token_expires_time not in", values, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeBetween(String value1, String value2) {
            addCriterion("page_access_token_expires_time between", value1, value2, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresTimeNotBetween(String value1, String value2) {
            addCriterion("page_access_token_expires_time not between", value1, value2, "pageAccessTokenExpiresTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeIsNull() {
            addCriterion("page_access_token_expires_last_time is null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeIsNotNull() {
            addCriterion("page_access_token_expires_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeEqualTo(String value) {
            addCriterion("page_access_token_expires_last_time =", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeNotEqualTo(String value) {
            addCriterion("page_access_token_expires_last_time <>", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeGreaterThan(String value) {
            addCriterion("page_access_token_expires_last_time >", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("page_access_token_expires_last_time >=", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeLessThan(String value) {
            addCriterion("page_access_token_expires_last_time <", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeLessThanOrEqualTo(String value) {
            addCriterion("page_access_token_expires_last_time <=", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeLike(String value) {
            addCriterion("page_access_token_expires_last_time like", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeNotLike(String value) {
            addCriterion("page_access_token_expires_last_time not like", value, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeIn(List<String> values) {
            addCriterion("page_access_token_expires_last_time in", values, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeNotIn(List<String> values) {
            addCriterion("page_access_token_expires_last_time not in", values, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeBetween(String value1, String value2) {
            addCriterion("page_access_token_expires_last_time between", value1, value2, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andPageAccessTokenExpiresLastTimeNotBetween(String value1, String value2) {
            addCriterion("page_access_token_expires_last_time not between", value1, value2, "pageAccessTokenExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketIsNull() {
            addCriterion("jsapi_ticket is null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketIsNotNull() {
            addCriterion("jsapi_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketEqualTo(String value) {
            addCriterion("jsapi_ticket =", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketNotEqualTo(String value) {
            addCriterion("jsapi_ticket <>", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketGreaterThan(String value) {
            addCriterion("jsapi_ticket >", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketGreaterThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket >=", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketLessThan(String value) {
            addCriterion("jsapi_ticket <", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketLessThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket <=", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketLike(String value) {
            addCriterion("jsapi_ticket like", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketNotLike(String value) {
            addCriterion("jsapi_ticket not like", value, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketIn(List<String> values) {
            addCriterion("jsapi_ticket in", values, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketNotIn(List<String> values) {
            addCriterion("jsapi_ticket not in", values, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketBetween(String value1, String value2) {
            addCriterion("jsapi_ticket between", value1, value2, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketNotBetween(String value1, String value2) {
            addCriterion("jsapi_ticket not between", value1, value2, "jsapiTicket");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeIsNull() {
            addCriterion("jsapi_ticket_expires_time is null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeIsNotNull() {
            addCriterion("jsapi_ticket_expires_time is not null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_time =", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeNotEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_time <>", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeGreaterThan(String value) {
            addCriterion("jsapi_ticket_expires_time >", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeGreaterThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_time >=", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeLessThan(String value) {
            addCriterion("jsapi_ticket_expires_time <", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeLessThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_time <=", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeLike(String value) {
            addCriterion("jsapi_ticket_expires_time like", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeNotLike(String value) {
            addCriterion("jsapi_ticket_expires_time not like", value, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeIn(List<String> values) {
            addCriterion("jsapi_ticket_expires_time in", values, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeNotIn(List<String> values) {
            addCriterion("jsapi_ticket_expires_time not in", values, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeBetween(String value1, String value2) {
            addCriterion("jsapi_ticket_expires_time between", value1, value2, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresTimeNotBetween(String value1, String value2) {
            addCriterion("jsapi_ticket_expires_time not between", value1, value2, "jsapiTicketExpiresTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeIsNull() {
            addCriterion("jsapi_ticket_expires_last_time is null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeIsNotNull() {
            addCriterion("jsapi_ticket_expires_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_last_time =", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeNotEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_last_time <>", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeGreaterThan(String value) {
            addCriterion("jsapi_ticket_expires_last_time >", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_last_time >=", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeLessThan(String value) {
            addCriterion("jsapi_ticket_expires_last_time <", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeLessThanOrEqualTo(String value) {
            addCriterion("jsapi_ticket_expires_last_time <=", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeLike(String value) {
            addCriterion("jsapi_ticket_expires_last_time like", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeNotLike(String value) {
            addCriterion("jsapi_ticket_expires_last_time not like", value, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeIn(List<String> values) {
            addCriterion("jsapi_ticket_expires_last_time in", values, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeNotIn(List<String> values) {
            addCriterion("jsapi_ticket_expires_last_time not in", values, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeBetween(String value1, String value2) {
            addCriterion("jsapi_ticket_expires_last_time between", value1, value2, "jsapiTicketExpiresLastTime");
            return (Criteria) this;
        }

        public Criteria andJsapiTicketExpiresLastTimeNotBetween(String value1, String value2) {
            addCriterion("jsapi_ticket_expires_last_time not between", value1, value2, "jsapiTicketExpiresLastTime");
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