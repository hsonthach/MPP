package lab3.sol.prob1;

public class PersonWithJob {
	private Person person;
    private double salary;
    
    PersonWithJob(String n, double s) {
        person = new Person(n);
        salary = s;
    }
    
    public String getName() {
        return person.getName();
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public boolean equals(Object aPersonWithJob) {
        if (aPersonWithJob == null) return false;
        if (!(aPersonWithJob instanceof PersonWithJob)) {
            if (aPersonWithJob instanceof Person) {
                return person.equals(aPersonWithJob);
            }
            return false;
        }
        PersonWithJob p = (PersonWithJob) aPersonWithJob;
        return this.person.equals(p.person) && this.salary == p.salary;
    }
	
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
}
