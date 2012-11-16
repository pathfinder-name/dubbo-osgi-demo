package name.pathfinder.azaleas.dubbo.demo.core;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = -3898875505991498406L;

	private String name;

	private Date createTime;
	
	private int version;
	
	private String shortName;
	
	private String fullName;
	
	public Customer() {
	}

	public Customer(String name, String shortName, String fullName, Date createTime) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.fullName = fullName;
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", createTime=" + createTime + ", version=" + version + ", shortName=" + shortName
				+ ", fullName=" + fullName + "]";
	}

}
