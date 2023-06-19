package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * 	id (PK), first_name,last_name, dob,batting_avg,wickets_taken....
	+team_id (FK)
 */


@Entity
@Table(name = "players")
public class Player extends BaseEntity{
	@Column(length = 20,unique = true )
	private String email; //PROJECT TIP: add atleast 1 field: unique: for generation of later
	@Column(name="first_name",length = 20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	private LocalDate dob;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	//Player *----> 1 Team
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team myteam;
	public Team getMyteam() {
		return myteam;
	}
	public void setMyteam(Team myteam) {
		this.myteam = myteam;
	}
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken
			) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}


	@Override
	public String toString() {
		return "Player [playerId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken +  "]";
	}
	
}
