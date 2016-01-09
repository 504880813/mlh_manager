package rms.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class materialsRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public materialsRecordExample() {
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

        public Criteria andMaterialsNameIsNull() {
            addCriterion("materials_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameIsNotNull() {
            addCriterion("materials_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameEqualTo(String value) {
            addCriterion("materials_name =", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotEqualTo(String value) {
            addCriterion("materials_name <>", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameGreaterThan(String value) {
            addCriterion("materials_name >", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameGreaterThanOrEqualTo(String value) {
            addCriterion("materials_name >=", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLessThan(String value) {
            addCriterion("materials_name <", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLessThanOrEqualTo(String value) {
            addCriterion("materials_name <=", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameLike(String value) {
            addCriterion("materials_name like", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotLike(String value) {
            addCriterion("materials_name not like", value, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameIn(List<String> values) {
            addCriterion("materials_name in", values, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotIn(List<String> values) {
            addCriterion("materials_name not in", values, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameBetween(String value1, String value2) {
            addCriterion("materials_name between", value1, value2, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsNameNotBetween(String value1, String value2) {
            addCriterion("materials_name not between", value1, value2, "materialsName");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusIsNull() {
            addCriterion("materials_surplus is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusIsNotNull() {
            addCriterion("materials_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusEqualTo(BigDecimal value) {
            addCriterion("materials_surplus =", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusNotEqualTo(BigDecimal value) {
            addCriterion("materials_surplus <>", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusGreaterThan(BigDecimal value) {
            addCriterion("materials_surplus >", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("materials_surplus >=", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusLessThan(BigDecimal value) {
            addCriterion("materials_surplus <", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("materials_surplus <=", value, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusIn(List<BigDecimal> values) {
            addCriterion("materials_surplus in", values, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusNotIn(List<BigDecimal> values) {
            addCriterion("materials_surplus not in", values, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("materials_surplus between", value1, value2, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsSurplusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("materials_surplus not between", value1, value2, "materialsSurplus");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitIsNull() {
            addCriterion("materials_unit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitIsNotNull() {
            addCriterion("materials_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitEqualTo(String value) {
            addCriterion("materials_unit =", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitNotEqualTo(String value) {
            addCriterion("materials_unit <>", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitGreaterThan(String value) {
            addCriterion("materials_unit >", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("materials_unit >=", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitLessThan(String value) {
            addCriterion("materials_unit <", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitLessThanOrEqualTo(String value) {
            addCriterion("materials_unit <=", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitLike(String value) {
            addCriterion("materials_unit like", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitNotLike(String value) {
            addCriterion("materials_unit not like", value, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitIn(List<String> values) {
            addCriterion("materials_unit in", values, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitNotIn(List<String> values) {
            addCriterion("materials_unit not in", values, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitBetween(String value1, String value2) {
            addCriterion("materials_unit between", value1, value2, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialsUnitNotBetween(String value1, String value2) {
            addCriterion("materials_unit not between", value1, value2, "materialsUnit");
            return (Criteria) this;
        }

        public Criteria andSaveIsNull() {
            addCriterion("save is null");
            return (Criteria) this;
        }

        public Criteria andSaveIsNotNull() {
            addCriterion("save is not null");
            return (Criteria) this;
        }

        public Criteria andSaveEqualTo(Boolean value) {
            addCriterion("save =", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveNotEqualTo(Boolean value) {
            addCriterion("save <>", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveGreaterThan(Boolean value) {
            addCriterion("save >", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("save >=", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveLessThan(Boolean value) {
            addCriterion("save <", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveLessThanOrEqualTo(Boolean value) {
            addCriterion("save <=", value, "save");
            return (Criteria) this;
        }

        public Criteria andSaveIn(List<Boolean> values) {
            addCriterion("save in", values, "save");
            return (Criteria) this;
        }

        public Criteria andSaveNotIn(List<Boolean> values) {
            addCriterion("save not in", values, "save");
            return (Criteria) this;
        }

        public Criteria andSaveBetween(Boolean value1, Boolean value2) {
            addCriterion("save between", value1, value2, "save");
            return (Criteria) this;
        }

        public Criteria andSaveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("save not between", value1, value2, "save");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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