package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

 
public class JzInfo implements Serializable {
	private static final long serialVersionUID = -2955530839779883680L;

	private String id;
    //省份
    private String nativeplace;
    private String title;
    private String address;
    private String resource;
    private String grils_num;
    private String age;
    private String phone;
    private String quality;
    private String figure;
    private String servicetype;
    private String price;
    private String opentime;
    private String livingEnv;
    private String safe;
    private String note;
    private String details;
    private String qq;
    private Integer city;
    private Integer province;
    private String pics;

    
    public String getPics() {
		return pics;
	}


	public void setPics(String pics) {
		this.pics = pics;
	}


	public void setCity(Integer city) {
		this.city = city;
	}


	public void setProvince(Integer province) {
		this.province = province;
	}


	public JzInfo(int province,int city,String address,String title,String phone,String qq,String resource, String grils_num,String age, String quality,String figure,String servicetype,String price,String opentime,String livingEnv,String safe,String note,String details,String nativeplace) {
    	   this.nativeplace=nativeplace;
    	   this.title=title;
    	   this.address=address;
    	   this.address=address;
    	   this.grils_num=grils_num;
    	   this.age=age;
    	   this.phone=phone;
    	   this.quality=quality;
    	   this.figure=figure;
    	   this.servicetype=servicetype;
    	   this.price=price;
    	   this.opentime=opentime;
    	   this.livingEnv=livingEnv;
    	   this.safe=safe;
    	   this.note=note;
    	   this.details=details;
    	   this.qq=qq;
    	   this.city=city;
    	   this.province=province;
       
    }

   
    public JzInfo() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
   

	public String getNativeplace() {
		return nativeplace;
	}


	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}


	public String getGrils_num() {
		return grils_num;
	}


	public void setGrils_num(String grils_num) {
		this.grils_num = grils_num;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getFigure() {
		return figure;
	}


	public void setFigure(String figure) {
		this.figure = figure;
	}


	public String getServicetype() {
		return servicetype;
	}


	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getOpentime() {
		return opentime;
	}


	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}


	public String getLivingEnv() {
		return livingEnv;
	}


	public void setLivingEnv(String livingEnv) {
		this.livingEnv = livingEnv;
	}


	public String getSafe() {
		return safe;
	}


	public void setSafe(String safe) {
		this.safe = safe;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}

	public int getCity() {
		return city;
	}


	public void setCity(int city) {
		this.city = city;
	}


	public int getProvince() {
		return province;
	}


	public void setProvince(int province) {
		this.province = province;
	}


	public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
 

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof JzInfo) ) return false;
        JzInfo castOther = (JzInfo) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}

}
