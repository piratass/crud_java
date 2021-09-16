package com.unsa.tourism.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unsa.tourism.constants.TourismConstants;

@Entity
@Table(name="product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name="id")
	    private Integer id;

	    @Column(name="name" , length = 150)
	    @NotNull(message= TourismConstants.MESSAGE_NOT_NULL)
	    @NotBlank(message=TourismConstants.MESSAGE_NOT_BLANK)
	    @NotEmpty(message=TourismConstants.MESSAGE_NOT_EMPTY)
	    private String name;

	    @Column(name="code" , length = 80)
	    @NotNull(message= TourismConstants.MESSAGE_NOT_NULL)
	    @NotBlank(message=TourismConstants.MESSAGE_NOT_BLANK)
	    @NotEmpty(message=TourismConstants.MESSAGE_NOT_EMPTY)
	    private String code;

	    @Column(name="description")
	    private String description;

	    @Column(name="state")
	    @JsonIgnore
	    private Integer state;

	    @Column(name="registrationDate")
	    @NotNull(message= TourismConstants.MESSAGE_NOT_NULL)
	    @NotBlank(message= TourismConstants.MESSAGE_NOT_BLANK)
	    @NotEmpty(message= TourismConstants.MESSAGE_NOT_EMPTY)
	    private Date registrationDate;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public Date getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}

}
