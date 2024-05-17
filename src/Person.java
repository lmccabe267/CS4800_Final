public abstract class Person {
    protected String name;
    protected String address;
    protected String county;

    public Person(String name, String address, String county) {
        this.name = name;
        this.address = address;
        this.county = county;
    }

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCounty() {
		return county;
	}
    
    
}
