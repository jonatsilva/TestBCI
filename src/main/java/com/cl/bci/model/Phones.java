/**
 * 
 */
package com.cl.bci.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Jonathan Silva
 *
 */

@Embeddable
//@Table(name = "phones")
public class Phones implements Serializable {

	private static final long serialVersionUID = 6880820658105201661L;

//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private Long id;

	@NotNull
	private int number;

	@NotNull
	private int citycode;

	@NotNull
	private int countrycode;

//	public long getid() {
//		return id;
//	}
//
//	public void setid(long id) {
//		this.id = id;
//	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCitycode() {
		return citycode;
	}

	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

}
