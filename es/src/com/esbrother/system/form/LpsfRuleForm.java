package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class LpsfRuleForm extends BaseForm {
	private String id;
	private String name;
	private String equipmentId;
	private String paramName;
	private float max;
	private float min;

	public LpsfRuleForm(String id, String name, String equipmentId,
			String paramName, float max, float min) {
		super();
		this.id = id;
		this.name = name;
		this.equipmentId = equipmentId;
		this.paramName = paramName;
		this.max = max;
		this.min = min;
	}

	public LpsfRuleForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

}
