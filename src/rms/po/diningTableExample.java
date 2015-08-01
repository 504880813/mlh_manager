package rms.po;

import java.util.ArrayList;
import java.util.List;

public class diningTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public diningTableExample() {
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

        public Criteria andSeatnumberIsNull() {
            addCriterion("seatnumber is null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNotNull() {
            addCriterion("seatnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberEqualTo(String value) {
            addCriterion("seatnumber =", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotEqualTo(String value) {
            addCriterion("seatnumber <>", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThan(String value) {
            addCriterion("seatnumber >", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThanOrEqualTo(String value) {
            addCriterion("seatnumber >=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThan(String value) {
            addCriterion("seatnumber <", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThanOrEqualTo(String value) {
            addCriterion("seatnumber <=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLike(String value) {
            addCriterion("seatnumber like", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotLike(String value) {
            addCriterion("seatnumber not like", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIn(List<String> values) {
            addCriterion("seatnumber in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotIn(List<String> values) {
            addCriterion("seatnumber not in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberBetween(String value1, String value2) {
            addCriterion("seatnumber between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotBetween(String value1, String value2) {
            addCriterion("seatnumber not between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNull() {
            addCriterion("isfree is null");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNotNull() {
            addCriterion("isfree is not null");
            return (Criteria) this;
        }

        public Criteria andIsfreeEqualTo(Boolean value) {
            addCriterion("isfree =", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotEqualTo(Boolean value) {
            addCriterion("isfree <>", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThan(Boolean value) {
            addCriterion("isfree >", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isfree >=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThan(Boolean value) {
            addCriterion("isfree <", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThanOrEqualTo(Boolean value) {
            addCriterion("isfree <=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeIn(List<Boolean> values) {
            addCriterion("isfree in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotIn(List<Boolean> values) {
            addCriterion("isfree not in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeBetween(Boolean value1, Boolean value2) {
            addCriterion("isfree between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isfree not between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andFreeimageIsNull() {
            addCriterion("freeimage is null");
            return (Criteria) this;
        }

        public Criteria andFreeimageIsNotNull() {
            addCriterion("freeimage is not null");
            return (Criteria) this;
        }

        public Criteria andFreeimageEqualTo(String value) {
            addCriterion("freeimage =", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageNotEqualTo(String value) {
            addCriterion("freeimage <>", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageGreaterThan(String value) {
            addCriterion("freeimage >", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageGreaterThanOrEqualTo(String value) {
            addCriterion("freeimage >=", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageLessThan(String value) {
            addCriterion("freeimage <", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageLessThanOrEqualTo(String value) {
            addCriterion("freeimage <=", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageLike(String value) {
            addCriterion("freeimage like", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageNotLike(String value) {
            addCriterion("freeimage not like", value, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageIn(List<String> values) {
            addCriterion("freeimage in", values, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageNotIn(List<String> values) {
            addCriterion("freeimage not in", values, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageBetween(String value1, String value2) {
            addCriterion("freeimage between", value1, value2, "freeimage");
            return (Criteria) this;
        }

        public Criteria andFreeimageNotBetween(String value1, String value2) {
            addCriterion("freeimage not between", value1, value2, "freeimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageIsNull() {
            addCriterion("busyimage is null");
            return (Criteria) this;
        }

        public Criteria andBusyimageIsNotNull() {
            addCriterion("busyimage is not null");
            return (Criteria) this;
        }

        public Criteria andBusyimageEqualTo(String value) {
            addCriterion("busyimage =", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageNotEqualTo(String value) {
            addCriterion("busyimage <>", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageGreaterThan(String value) {
            addCriterion("busyimage >", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageGreaterThanOrEqualTo(String value) {
            addCriterion("busyimage >=", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageLessThan(String value) {
            addCriterion("busyimage <", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageLessThanOrEqualTo(String value) {
            addCriterion("busyimage <=", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageLike(String value) {
            addCriterion("busyimage like", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageNotLike(String value) {
            addCriterion("busyimage not like", value, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageIn(List<String> values) {
            addCriterion("busyimage in", values, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageNotIn(List<String> values) {
            addCriterion("busyimage not in", values, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageBetween(String value1, String value2) {
            addCriterion("busyimage between", value1, value2, "busyimage");
            return (Criteria) this;
        }

        public Criteria andBusyimageNotBetween(String value1, String value2) {
            addCriterion("busyimage not between", value1, value2, "busyimage");
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