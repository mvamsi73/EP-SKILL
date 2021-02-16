package registerbean;
import addressbean.*;
public class registerbean 
{
	String name;
	long id;
	addressbean ab;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public addressbean getAb() {
		return ab;
	}
	public void setAb(addressbean ab) {
		this.ab = ab;
	}
	

}
