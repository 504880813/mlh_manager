package rms.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class orderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public orderdetailExample() {
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

        public Criteria andDishnumberIsNull() {
            addCriterion("dishNumber is null");
            return (Criteria) this;
        }

        public Criteria andDishnumberIsNotNull() {
            addCriterion("dishNumber is not null");
            return (Criteria) this;
        }

        public Criteria andDishnumberEqualTo(Integer value) {
            addCriterion("dishNumber =", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberNotEqualTo(Integer value) {
            addCriterion("dishNumber <>", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberGreaterThan(Integer value) {
            addCriterion("dishNumber >", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("dishNumber >=", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberLessThan(Integer value) {
            addCriterion("dishNumber <", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberLessThanOrEqualTo(Integer value) {
            addCriterion("dishNumber <=", value, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberIn(List<Integer> values) {
            addCriterion("dishNumber in", values, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberNotIn(List<Integer> values) {
            addCriterion("dishNumber not in", values, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberBetween(Integer value1, Integer value2) {
            addCriterion("dishNumber between", value1, value2, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andDishnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("dishNumber not between", value1, value2, "dishnumber");
            return (Criteria) this;
        }

        public Criteria andRdishidIsNull() {
            addCriterion("rDishId is null");
            return (Criteria) this;
        }

        public Criteria andRdishidIsNotNull() {
            addCriterion("rDishId is not null");
            return (Criteria) this;
        }

        public Criteria andRdishidEqualTo(Integer value) {
            addCriterion("rDishId =", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidNotEqualTo(Integer value) {
            addCriterion("rDishId <>", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidGreaterThan(Integer value) {
            addCriterion("rDishId >", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rDishId >=", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidLessThan(Integer value) {
            addCriterion("rDishId <", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidLessThanOrEqualTo(Integer value) {
            addCriterion("rDishId <=", value, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidIn(List<Integer> values) {
            addCriterion("rDishId in", values, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidNotIn(List<Integer> values) {
            addCriterion("rDishId not in", values, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidBetween(Integer value1, Integer value2) {
            addCriterion("rDishId between", value1, value2, "rdishid");
            return (Criteria) this;
        }

        public Criteria andRdishidNotBetween(Integer value1, Integer value2) {
            addCriterion("rDishId not between", value1, value2, "rdishid");
            return (Criteria) this;
        }

        public Criteria andCorderidIsNull() {
            addCriterion("cOrderId is null");
            return (Criteria) this;
        }

        public Criteria andCorderidIsNotNull() {
            addCriterion("cOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andCorderidEqualTo(Integer value) {
            addCriterion("cOrderId =", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidNotEqualTo(Integer value) {
            addCriterion("cOrderId <>", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidGreaterThan(Integer value) {
            addCriterion("cOrderId >", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cOrderId >=", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidLessThan(Integer value) {
            addCriterion("cOrderId <", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidLessThanOrEqualTo(Integer value) {
            addCriterion("cOrderId <=", value, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidIn(List<Integer> values) {
            addCriterion("cOrderId in", values, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidNotIn(List<Integer> values) {
            addCriterion("cOrderId not in", values, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidBetween(Integer value1, Integer value2) {
            addCriterion("cOrderId between", value1, value2, "corderid");
            return (Criteria) this;
        }

        public Criteria andCorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("cOrderId not between", value1, value2, "corderid");
            return (Criteria) this;
        }

        public Criteria andEchelonIsNull() {
            addCriterion("echelon is null");
            return (Criteria) this;
        }

        public Criteria andEchelonIsNotNull() {
            addCriterion("echelon is not null");
            return (Criteria) this;
        }

        public Criteria andEchelonEqualTo(Integer value) {
            addCriterion("echelon =", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonNotEqualTo(Integer value) {
            addCriterion("echelon <>", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonGreaterThan(Integer value) {
            addCriterion("echelon >", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonGreaterThanOrEqualTo(Integer value) {
            addCriterion("echelon >=", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonLessThan(Integer value) {
            addCriterion("echelon <", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonLessThanOrEqualTo(Integer value) {
            addCriterion("echelon <=", value, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonIn(List<Integer> values) {
            addCriterion("echelon in", values, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonNotIn(List<Integer> values) {
            addCriterion("echelon not in", values, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonBetween(Integer value1, Integer value2) {
            addCriterion("echelon between", value1, value2, "echelon");
            return (Criteria) this;
        }

        public Criteria andEchelonNotBetween(Integer value1, Integer value2) {
            addCriterion("echelon not between", value1, value2, "echelon");
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