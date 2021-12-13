package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_rates_vehicle database table.
 * 
 */
@Entity
@Table(name="user_rates_vehicle")
@NamedQuery(name="UserRatesVehicle.findAll", query="SELECT u FROM UserRatesVehicle u")
public class UserRatesVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iduser_rates")
	private int iduserRates;

	@Lob
	private String comment;

	private double rateComfort;

	private double rateExteriorStyling;

	private double rateOverall;

	private double ratePerformance;

	private double rateReliability;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	public UserRatesVehicle() {
	}

	public int getIduserRates() {
		return this.iduserRates;
	}

	public void setIduserRates(int iduserRates) {
		this.iduserRates = iduserRates;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRateComfort() {
		return this.rateComfort;
	}

	public void setRateComfort(double rateComfort) {
		this.rateComfort = rateComfort;
	}

	public double getRateExteriorStyling() {
		return this.rateExteriorStyling;
	}

	public void setRateExteriorStyling(double rateExteriorStyling) {
		this.rateExteriorStyling = rateExteriorStyling;
	}

	public double getRateOverall() {
		return this.rateOverall;
	}

	public void setRateOverall(double rateOverall) {
		this.rateOverall = rateOverall;
	}

	public double getRatePerformance() {
		return this.ratePerformance;
	}

	public void setRatePerformance(double ratePerformance) {
		this.ratePerformance = ratePerformance;
	}

	public double getRateReliability() {
		return this.rateReliability;
	}

	public void setRateReliability(double rateReliability) {
		this.rateReliability = rateReliability;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}