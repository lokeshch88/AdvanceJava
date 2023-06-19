package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//id , name, abbrevation,owner,max_age,batting_avg,wickets_taken
@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
	@Column(length = 100, unique = true)
	private String name;
	@Column(length = 10, unique = true)
	private String abbrevation;
	@Column(length = 50)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;// max age of the player allowed in this team
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	
	//bi dirn association betn Team--> Player(s)
	@OneToMany(mappedBy = "myteam", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Player> players= new ArrayList();

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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
		return "Team [teamId=" + getId() + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	// add 2 helper methods : addPlayer, removePlayer
	public void addPlayer(Player p) {
		players.add(p); // parent---> child
		p.setMyteam(this); //child ----> parent
	}
	public void removePlayer(Player p) {
		players.add(p); // parent--X--> child
		p.setMyteam(null); //child --X--> parent
	}
	

}
