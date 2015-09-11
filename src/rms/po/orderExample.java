package rms.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class orderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public orderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIsNull() {
            addCriterion("isbalance is null");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIsNotNull() {
            addCriterion("isbalance is not null");
            return (Criteria) this;
        }

        public Criteria andIsbalanceEqualTo(Boolean value) {
            addCriterion("isbalance =", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotEqualTo(Boolean value) {
            addCriterion("isbalance <>", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceGreaterThan(Boolean value) {
            addCriterion("isbalance >", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isbalance >=", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceLessThan(Boolean value) {
            addCriterion("isbalance <", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceLessThanOrEqualTo(Boolean value) {
            addCriterion("isbalance <=", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIn(List<Boolean> values) {
            addCriterion("isbalance in", values, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotIn(List<Boolean> values) {
            addCriterion("isbalance not in", values, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceBetween(Boolean value1, Boolean value2) {
            addCriterion("isbalance between", value1, value2, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isbalance not between", value1, value2, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIspaymentIsNull() {
            addCriterion("ispayment is null");
            return (Criteria) this;
        }

        public Criteria andIspaymentIsNotNull() {
            addCriterion("ispayment is not null");
            return (Criteria) this;
        }

        public Criteria andIspaymentEqualTo(Boolean value) {
            addCriterion("ispayment =", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentNotEqualTo(Boolean value) {
            addCriterion("ispayment <>", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentGreaterThan(Boolean value) {
            addCriterion("ispayment >", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ispayment >=", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentLessThan(Boolean value) {
            addCriterion("ispayment <", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentLessThanOrEqualTo(Boolean value) {
            addCriterion("ispayment <=", value, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentIn(List<Boolean> values) {
            addCriterion("ispayment in", values, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentNotIn(List<Boolean> values) {
            addCriterion("ispayment not in", values, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentBetween(Boolean value1, Boolean value2) {
            addCriterion("ispayment between", value1, value2, "ispayment");
            return (Criteria) this;
        }

        public Criteria andIspaymentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ispayment not between", value1, value2, "ispayment");
            return (Criteria) this;
        }

        public Criteria andWaiterIsNull() {
            addCriterion("waiter is null");
            return (Criteria) this;
        }

        public Criteria andWaiterIsNotNull() {
            addCriterion("waiter is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterEqualTo(String value) {
            addCriterion("waiter =", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterNotEqualTo(String value) {
            addCriterion("waiter <>", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterGreaterThan(String value) {
            addCriterion("waiter >", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterGreaterThanOrEqualTo(String value) {
            addCriterion("waiter >=", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterLessThan(String value) {
            addCriterion("waiter <", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterLessThanOrEqualTo(String value) {
            addCriterion("waiter <=", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterLike(String value) {
            addCriterion("waiter like", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterNotLike(String value) {
            addCriterion("waiter not like", value, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterIn(List<String> values) {
            addCriterion("waiter in", values, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterNotIn(List<String> values) {
            addCriterion("waiter not in", values, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterBetween(String value1, String value2) {
            addCriterion("waiter between", value1, value2, "waiter");
            return (Criteria) this;
        }

        public Criteria andWaiterNotBetween(String value1, String value2) {
            addCriterion("waiter not between", value1, value2, "waiter");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdIsNull() {
            addCriterion("r_diningtable_id is null");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdIsNotNull() {
            addCriterion("r_diningtable_id is not null");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdEqualTo(Integer value) {
            addCriterion("r_diningtable_id =", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdNotEqualTo(Integer value) {
            addCriterion("r_diningtable_id <>", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdGreaterThan(Integer value) {
            addCriterion("r_diningtable_id >", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_diningtable_id >=", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdLessThan(Integer value) {
            addCriterion("r_diningtable_id <", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_diningtable_id <=", value, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdIn(List<Integer> values) {
            addCriterion("r_diningtable_id in", values, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdNotIn(List<Integer> values) {
            addCriterion("r_diningtable_id not in", values, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdBetween(Integer value1, Integer value2) {
            addCriterion("r_diningtable_id between", value1, value2, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andRDiningtableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_diningtable_id not between", value1, value2, "rDiningtableId");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleIsNull() {
            addCriterion("numberofpeople is null");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleIsNotNull() {
            addCriterion("numberofpeople is not null");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleEqualTo(Integer value) {
            addCriterion("numberofpeople =", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotEqualTo(Integer value) {
            addCriterion("numberofpeople <>", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleGreaterThan(Integer value) {
            addCriterion("numberofpeople >", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberofpeople >=", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLessThan(Integer value) {
            addCriterion("numberofpeople <", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleLessThanOrEqualTo(Integer value) {
            addCriterion("numberofpeople <=", value, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleIn(List<Integer> values) {
            addCriterion("numberofpeople in", values, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotIn(List<Integer> values) {
            addCriterion("numberofpeople not in", values, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleBetween(Integer value1, Integer value2) {
            addCriterion("numberofpeople between", value1, value2, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andNumberofpeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("numberofpeople not between", value1, value2, "numberofpeople");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIsNull() {
            addCriterion("DiscountAmount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIsNotNull() {
            addCriterion("DiscountAmount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountamountEqualTo(BigDecimal value) {
            addCriterion("DiscountAmount =", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotEqualTo(BigDecimal value) {
            addCriterion("DiscountAmount <>", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountGreaterThan(BigDecimal value) {
            addCriterion("DiscountAmount >", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DiscountAmount >=", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountLessThan(BigDecimal value) {
            addCriterion("DiscountAmount <", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DiscountAmount <=", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIn(List<BigDecimal> values) {
            addCriterion("DiscountAmount in", values, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotIn(List<BigDecimal> values) {
            addCriterion("DiscountAmount not in", values, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DiscountAmount between", value1, value2, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DiscountAmount not between", value1, value2, "discountamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountIsNull() {
            addCriterion("CouponAmount is null");
            return (Criteria) this;
        }

        public Criteria andCouponamountIsNotNull() {
            addCriterion("CouponAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponamountEqualTo(BigDecimal value) {
            addCriterion("CouponAmount =", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountNotEqualTo(BigDecimal value) {
            addCriterion("CouponAmount <>", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountGreaterThan(BigDecimal value) {
            addCriterion("CouponAmount >", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CouponAmount >=", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountLessThan(BigDecimal value) {
            addCriterion("CouponAmount <", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CouponAmount <=", value, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountIn(List<BigDecimal> values) {
            addCriterion("CouponAmount in", values, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountNotIn(List<BigDecimal> values) {
            addCriterion("CouponAmount not in", values, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CouponAmount between", value1, value2, "couponamount");
            return (Criteria) this;
        }

        public Criteria andCouponamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CouponAmount not between", value1, value2, "couponamount");
            return (Criteria) this;
        }

        public Criteria andServingstatusIsNull() {
            addCriterion("servingstatus is null");
            return (Criteria) this;
        }

        public Criteria andServingstatusIsNotNull() {
            addCriterion("servingstatus is not null");
            return (Criteria) this;
        }

        public Criteria andServingstatusEqualTo(Byte value) {
            addCriterion("servingstatus =", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusNotEqualTo(Byte value) {
            addCriterion("servingstatus <>", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusGreaterThan(Byte value) {
            addCriterion("servingstatus >", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("servingstatus >=", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusLessThan(Byte value) {
            addCriterion("servingstatus <", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusLessThanOrEqualTo(Byte value) {
            addCriterion("servingstatus <=", value, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusIn(List<Byte> values) {
            addCriterion("servingstatus in", values, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusNotIn(List<Byte> values) {
            addCriterion("servingstatus not in", values, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusBetween(Byte value1, Byte value2) {
            addCriterion("servingstatus between", value1, value2, "servingstatus");
            return (Criteria) this;
        }

        public Criteria andServingstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("servingstatus not between", value1, value2, "servingstatus");
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