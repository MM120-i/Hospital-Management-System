package pe2;

import java.util.*;

public class Hospital {
	
	private Director hospDirector;
	
	//These static identification variables are used to assign them to a patient/employee. 
	protected static int patientIdentification = 1000;
	protected static int employeeIdentification = 100;
	
	//List variables. 
	private List<Person> patient;
	private List<PhysicianAdministrator> physicianAdministrator;
	private List<Volunteer> volunteer;
	private List<Physician> physician;
	
	/**
	 * This constructor initializes all the non-static variabled listed above.
	 * @param director
	 */
	public Hospital(Director director) {
		
		this.hospDirector = director;
		
		//initializing all of the list variables. 
		this.patient = new ArrayList<Person>();
		this.physicianAdministrator = new ArrayList<PhysicianAdministrator>();
		this.volunteer = new ArrayList<Volunteer>();
		this.physician = new ArrayList<Physician>();
		
	}
	
	// Getter and Setter methods:
	
	/**
	 * Accessor method for hospDirector.
	 * @return hospDirector
	 */
	public Director getHospDirector() {
		
		return hospDirector;
			
	}

	/**
	 * Mutator method for hospDirector.
	 * @param hospDirector
	 */
	public void setHospDirector(Director hospDirector) {
		
		this.hospDirector = hospDirector;
			
	}

	/**
	 * Accessor method for physicianAdministrator.
	 * @return physicianAdministrator
	 */
	public List<PhysicianAdministrator> getPhysicianAdministrator() {
		
		return physicianAdministrator;
			
	}
	
	/**
	 * Mutator method for physicianAdministrator.
	 * @param physicianAdministrator
	 */
	public void setPhysicianAdministrator(List<PhysicianAdministrator> physicianAdministrator) {
		
		this.physicianAdministrator = physicianAdministrator;
			
	}
	
	/**
	 * This method admits the patient to the hospital, adds the patient info to the patient record, assigns a physician
	 * to every newly admitted patient in a FIFO (First-in first-out) basis. Does not admit the same patient multiple times.
	 * @param newPatient. The patient thats being added.
	 * @return flag. A boolean value indicates if the process of admitting patient has been successful or not.  
	 * @throws NoSpaceException. This exception is thrown if no spaces are avilable.
	 */
    public boolean admitPatient(Patient newPatient) throws NoSpaceException{
		
    	// flag is a variable of type boolean which gets assigned true when a certin process has been completed successfully,
    	// otherwise it gets assigned false and flag gets returned. Through out this entire code, I have used flag for this same purpose. 
		boolean flag = true;
		int pSize = patient.size(); // the size of the patient list.
		int forPatient = helper(patient, newPatient);        // Calls the helper method.		
		
		// Since I am dealing with lists, it is very efficient for me to use stream, filter, lambda expressions, and etc.
		// So I can iterate through the lists, filter out elements from the list, and fetch the data more efficiently.
		long forPhysician = physician                       
				.stream()                                                   //This looks through the physician list, filters out anything matching the preciate.
				.filter((physician) -> (!physician.hasMaximumpatient()))    //This process filters out all those elements in the list that are not matching with the specified condition.
				.count();                                            // This terminal operation returns the count of the remaining elements after filtering out the stream.
		                                                  
		// Checks if the fetched data is less than 1 (forPhysician), then throw NoSpaceException.  
		if(1 > forPhysician) { 
			
			throw new NoSpaceException("Sorry, no avilable spaces.");   
			
		}
		// Checks if the number of patients admited to the hospital has exceeded the maximum limit, then throws NoSpaceException. 
	    else if(500 <= pSize) { 
			
			throw new NoSpaceException("Sorry, no avilable spaces.");
		}
		// Checks if the fetched data is less than or equal to 1 (forPatient), then returns false.
		else if(1 <= forPatient) {    
			
			flag = false;
			return flag;
		}
		else {
			
			// Looks through the physician list, filters out whatever matches the predicate. 
		      physician
		        .stream()                                                
		        .filter((physician) -> (!physician.hasMaximumpatient()))
		        .findFirst()             // This returns an optional which describes the first element of this stream.                    
		        .ifPresent((physician) -> physician.assignPatient(newPatient));  // Checks in the stream if the findFirst value is present or not.
		      
		      patient.add(newPatient);    // Adds the new patient.
		      
		      flag = true;
		      return flag;
		}
		
	}
    
    /**
     * This is a private helper method for the admit patient task. This method returns the size of another list which contains new patients.
     * @param patients
     * @param newPatients
     * @return size of the resultList array list.
     */
    private int helper(List<Person> patients, Patient newPatients) {
    	
    	List<Patient> resultList = new ArrayList<>();         // Array list to hold the list of patients.
    	int size = 0;        // This variable holds the size of the array list later.
    	
    	for(Person person : patients) {
    		
    		if(person.equals(newPatients)) {
    			
    			resultList.add(newPatients);      // Adds newPatients to the newly created array list in this method.
    			
    		}
    	}
    	
    	size = resultList.size();
    	return size;            // Returns the size of the resultList array.
    	
    }
	/**
     * Discharges the patients. And while doing that, it clears that discharged patient's data. 
     * @param Dischargepatient 
     * @return flag. Flag takes in the value true if discharging the patient process was successful, otherwise takes in the value false. 
     */
   public boolean dischargePatient(Person Dischargepatient) {
		
		boolean flag = true; // flag variable has the same purpose as the previous method.
		
		// Checks if the patient discharge process is a success or not.
		if(patient.remove(Dischargepatient) == true){
			
			//Here, I have used the streams, filters, lambda expressions, and more. This checks the physician list, 
			//filters out any elements that mathces with the given predicate.
			physician.stream()  
			  .filter((physician) -> (physician.getPatients())
			  .contains(Dischargepatient))        // Checks if the current stream has the discharged patient.
			  .findFirst()                        // Returns an optional that describes the first element in the stream is returned.
			  .ifPresent((physician) -> (physician.getPatients())   // If the value is present, then perform the given task.
			  .remove(Dischargepatient));         // Removes the first occurrence of the discharge patient from this list.
			
			flag = true;
			
		}
		else if(patient.remove(Dischargepatient) == false){
			
			flag = false;
			
		}
		return flag;    // Returns whatever value flag holds.
	}
   
   /**
    * Hires new volunteers. Assigns the volunteer to a physician who has not exceeded the volunteer limit 
    * in a FIFO (First-in first-out) basis. Does not hire the same volunteer multiple times. 
    * @param hireVolunteer
    * @return flag. Flag holds the value true if the hiring process was successful, otherwise takes in the value false.
    */
   public boolean hireVolunteer(Volunteer hireVolunteer) {
		
		boolean flag = true;
		int vSize = volunteer.size();    // Size of the volunteer list.
		
		// If the size of the volunteer list is less than its maximum limit.
		if(150 > vSize) {
			
		    physician
		      .stream()       // Looks through the physician list.
		      .filter((physician) -> (!physician.hasMaxVolunteers()))    // filters out whatever matches the predicate.
		      .findFirst()                       // Returns the first element of the stream (iff the stream is not empty). 
		      .ifPresent((physician) -> physician.assignVolunteer(hireVolunteer));  // If the value is present, then perform the given action.
		    
		    volunteer.add(hireVolunteer);             //Adds the volunteer.   
		
		    flag = true;
			
		}
		else if(150 <= vSize){    // If the volunteer list size exceeds the maximum volunteer limit, then flag holds false.
		
		    flag = false;
		}
		
		return flag;   //Returns whatever flag holds.
	}
   
   /**
    * Resigins volunteer and clears his/her record from the hospital.
    * @param reassignVolunteer 
    * @throws NoVolunteersException is thrown when there are no volunteers avilable.
    */
   public void resignVolunteer(Volunteer reasignVolunteer) throws NoVolunteersException {
		
	    int vSize2 = volunteer.size();  // Size of the volunteer list.
	   
		if(1 < vSize2) {
			
			volunteer.remove(reasignVolunteer);      // removes the volunteer.
			
			physician
			  .stream()             // Looks through the physician list.
			  .filter((physician) -> (physician).getVolunteers()      // filters out elements that matches with the predicate.
			  .contains(reasignVolunteer))                // Checks if it contains reasignVolunteer.         
			  .findFirst()                             // Finds the first element.
			  .ifPresent((physician) -> (physician).getVolunteers()       
			  .remove(reasignVolunteer));    // Removes the matching element.
			
		} 
		else if(1 >= vSize2){  
			
			throw new NoVolunteersException("Sorry, no avilable volunteers.");    // Throws NoVolunteersException.
		}
		
	}
   /**
    * Extracts and returns all of the patient info stored in the hospital patient record.
    * @return patient
    */
   public List<Person> extractAllPatientDetails(){
		
		return patient;
		
	}
   
   /**
    * Extracts and returns all of the physican info stored in the hospital physician record.
    * @return physician
    */
   public List<Physician> extractAllPhysicianDetails(){
		
		return physician;
		
    }
   
   /**
    * Extracts and returns all of the volunteer information stored in the hospital volunteer record. 
    * @return volunteer
    */
   public List<Volunteer> extractAllVolunteerDetails(){
		
		return volunteer;
		
	}
   
   /**
    * Hires a new physician, the physician's info gets stored in the hospital physician record. This method does not hire
    * the same physician multiple times. 
    * @param hirePhysician
    * @return flag. Flag holds the value true if the hiring process was successful, other wise it holds false.
    */
   public boolean hirePhysician(Physician hirePhysician) {
		
		boolean flag = true;
		
		String specialty = new String (hirePhysician.getSpecialty());   // Holds the string value of the physician specialty.
		List<Physician> temp = new ArrayList<>();   		//  A temporary array list.
		
		for(Physician phy : physician) {    // Loops through list.
			
			if(phy.equals(hirePhysician)) {   // If an element in the list has the hired physician then add that physician to temp list.
				
				temp.add(hirePhysician);    // Adds the physician to the temp list.
				
			}
		}
				
		if(1 <= temp.size()) {
			
			flag = false;
			
		}
		else if(1 > temp.size()) {
		
		    physician.add(hirePhysician);    //Adds the physician.
		    
		    for(PhysicianAdministrator admin : physicianAdministrator) {    //Loops through list.
		    	
		    	if(admin.getAdminSpecialtyType().equals(specialty)) {    // checks if the admin has any specialty (Immunology, Dermatology, or Neurology).
		    		
		    		admin.addPhysician(hirePhysician);  // Adds the hired physician to the list.
		    		
		    	}
		     }
		   
		    flag = true;
		    
		}
		
		return flag;        // Returns whatever flag holds.
		
	}
   
   /**
    * Clears the physician's data when a physician is resigning from the hospital. Assigns the patients of the resinged
    * physicain to the next avilable physician(s). Reassigns the volunteers for the next available physician(s).
    * @param Resignphysician
    * @throws NoSpecialtyException if no specialty is avilable.
    */
   public void resignPhysician(Physician Resignphysician) throws NoSpecialtyException {
	   
	   String specialty = new String(Resignphysician.getSpecialty());      // Gets and stores the specialty (Immunology, Dermatology, or Neurology).
	   
	   long forPhysician = physician
			   .stream()                    // Looks through the physician list.          
			   .filter((physician) -> (physician.getSpecialty().equals(specialty))) // filters out whatever is matching the predicate.
			   .count();          // This terminal operation returns the count of the remaining elements after filtering out the stream.
		
		if(1 >= forPhysician ) {
			
			throw new NoSpecialtyException("Sorry, no specialty avilable.");  //Throws NoSpecialtyException.
			
			
		}
		else if(1 < forPhysician){
		  
			physician.remove(Resignphysician);           // Removes the physician that is resigining from the hospital record.
			
			//For the patients:
			Resignphysician.getPatients()             // Gets the patient from the resigining physician.
			.forEach((patient) ->                  
                                                  // patient is the parameter in the forEach.
			   {                                  
			 	
			    physician
				  .stream()       // Looks through the physician list.
				  .filter((physician) -> (!physician.hasMaximumpatient()))     // filters out the matching predicate.   
				  .findFirst()              // finds the first element.
				  .ifPresent((physician) -> physician.assignPatient(patient));         
				
		 	   }
			
			);
			
			//For the volunteers:
			Resignphysician.getVolunteers()              // Gets the volunteers from the resigining physician.
			.forEach((volunteer) -> 
			                                       // Volunteer is the parameter in the forEach.
			  {
				
				physician
				  .stream()            // Looks through the physician list once again.
				  .filter((physician) -> (!physician.hasMaxVolunteers()))    // filters out the matching predicate.
				  .findFirst()            // finds the first item.
				  .ifPresent((physician) -> physician.assignVolunteer(volunteer));     
				
			   }
			);
		}
	}
   
   /**
    * This method adds physician admininstrators. 
    * @param PhysicianAdministrator
    * @return flag. Flag holds the value true if adding adminsitrator process is successful, else flag holds the value false.
    */
   public boolean addAdministrator(PhysicianAdministrator PhysicianAdministrator){
		
		boolean flag = true;
		
		//Checks if the administrator has exceeded the maximum limit.
		if(physicianAdministrator.size() >= 3) {                 
			
			flag = false;
			
		}
		else {
			
		    //Adds administrator, then flag returns true. 
		    physicianAdministrator.add(PhysicianAdministrator);
			flag = true;
			
		}
		
		return flag;       // Returns whatever value flag holds.
	}
}

class Person{
	
	// Attributes of a person.
	
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	
	
	/**
	 * Constructor initializes all the variables defined in this class.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Person(String firstName, String lastName, int age, String gender, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		
	}

	//Getter and setter methods:
	
	/**
	 * Accessor method for firstName.
	 * @return firstName
	 */
	public String getFirstName() {
		
		return firstName;
		
	}

	/**
	 * Mutator method for firstName.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}

	/**
	 * Accessor method for lastName.
	 * @return lastName
	 */
	public String getLastName() {
		
		return lastName;
		
	}

	/**
	 * Mutator method for lastName.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}

	/**
	 * Accessor method for age.
	 * @return age
	 */
	public int getAge() {
		
		return age;
		
	}

	/**
	 * Mutator method for age.
	 * @param age
	 */
	public void setAge(int age) {
		
		this.age = age;
		
	}

	/**
	 * Accessor method for gender.
	 * @return gender
	 */
	public String getGender() {
		
		return gender;
		
	}

	/**
	 * Mutator method for gender.
	 * @param gender of type String.
	 */
	public void setGender(String gender) {
		
		this.gender = gender;
		
	}

	/**
	 * Accessor method for address.
	 * @return address
	 */
	public String getAddress() {
		
		return address;
		
	}

	/**
	 * Mutator method for address.
	 * @param address
	 */
	public void setAddress(String address) {
		
		this.address = address;
		
	}
	
	/**
	 * This method does the concatenation of first name and last name.
	 * @return fullName
	 */
	public String getName() {
		
		String fullName = firstName + ", " + lastName; // concatenation of first and last name.
		return fullName;
		
	}

	// toString method:
	@Override
	public String toString() {
		
		return "[" + firstName + ", " + lastName + ", " + age + ", " + gender
				+ ", " + address + "]";
		
	}

	// Hashcode method:
	@Override
	public int hashCode() {
		
		return Objects.hash(address, age, firstName, gender, lastName);
		
	}

	// Equals method:
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			
			return true;
			
		}
		
		if (obj == null) {
			
			return false;
			
		}
		
		if (getClass() != obj.getClass()) {
			
			return false;
			
		}
		
		Person other = (Person) obj;
		
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(lastName, other.lastName);
		
	}	
}

class Employee extends Person{

	private int employeeID;

	/**
	 * Accessor method for employeeID.
	 * @return employeeID
	 */
	public int getEmployeeID() {
		
		return employeeID;
		
	}
	
	/**
	 * Mutator method for employeeID.
	 * @param employeeID
	 */
	public void setEmployeeID(int employeeID) {
		
		this.employeeID = employeeID;
		
	}

	/**
	 * This constructor assigns employeeID to employees. 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Employee(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		
		this.setEmployeeID(Hospital.employeeIdentification++);  // sets employees with their ID, then employeeIdentification increments so it can assign ID to the next employee. 
		
	}
	
	//toString method:
	@Override
	public String toString() {
		
		String str = new String(super.toString());
		
		return "[" + employeeID + "," + str + "]";
	}
	
}

class Patient extends Person implements Comparable<Patient>{

	private Employee assignedPhysician;      // assignedPhysician of type Employee.
	private int patientID;
	
	/**
	 * Accessor method for assignedPhysician.
	 * @return assignedPhysician
	 */
	public Employee getAssignedPhysician() {
		
		return assignedPhysician;
		
	}

	/**
	 * Mutator method for assignedPhysician.
	 * @param assignedPhysician
	 */
	public void setAssignedPhysician(Employee assignedPhysician) {
		
		this.assignedPhysician = assignedPhysician;
		
	}

	/**
	 * Accessor method for patientID.
	 * @return patientID
	 */
	public int getPatientID() {
		
		return patientID;
		
	}

	/**
	 * Mutator method for patientID.
	 * @param patientID
	 */
	public void setPatientID(int patientID) {
		
		this.patientID = patientID;
		
	}
	
	/**
	 * This constructor assigns patientID to patients.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Patient(String firstName, String lastName, int age, String gender, String address) { 
		
		super(firstName, lastName, age, gender, address);
		
		this.setPatientID(Hospital.patientIdentification++);     // Sets the patients with their ID. Then patientIdentification gets incremented so it can get assigned to the next patient.
		
	}
	
	/**
	 * This method checks if the patient record is clear or not. 
	 * @return flag. Flag hold true if assignedPhysican is null, otherwise returns false.
	 */
	public boolean clearPatientRecord() {
		
		boolean flag = true;
		
		//Checks if assignedPhysician is null or not. If it is then returns true, otherwise returns false.
		if(assignedPhysician == null) {   
			
			flag = true;
			return flag;
			
		}
		else {
			
			flag = false;
			return flag;
			
		}
	}

	// toString method. Returns the string representation of patient and their identification.
	@Override
	public String toString() {
		
		return "Patient [" + patientID + ", [" + getName() + ", " + getAge() + ", " + getGender() + ", " + getAddress() + "]]"; 
	}

	// compareTo method:
	@Override
	public int compareTo(Patient object) {
		
		return 0;
		
	}
}

class Volunteer extends Employee{
	
	private String specialty;
	
	/**
	 * Accessor method for specialty.
	 * @return specialty
	 */
	public String getSpecialty() {
		
		return specialty;
		
	}
	
	/**
	 * Mutator method for specialty.
	 * @param Specialty
	 */
	public void setSpecialty(String Specialty) {
		
		this.specialty = Specialty;
		
	}
	
	/**
	 * Constructor with a matching parameter list. 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Volunteer(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		
	}
	
	// toString method. Returns the string representation of volunteers.
	@Override
	public String toString() {
		
		return "Volunteer [[" + getEmployeeID() + ",[" + getName() + ", " + getAge() + ", " + getGender() + ", " + getAddress() + "]]]";
		
	}
}

class SalariedEmployee extends Employee{
	
	private double salary;
	
	/**
	 * Accesor method for salary.
	 * @return salary
	 */
	public double getSalary() {
		
		return salary;
		
	}
	/**
	 * Mutator method for salary.
	 * @param Salary
	 */
	public void setSalary(double Salary) {
		
		this.salary = Salary;
		
	}

	/**
	 * Constructor with a matching parameter list.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public SalariedEmployee(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		
	}
	
	// toString method. Returns the string representation of salaried employees.
	@Override
	public String toString() {
		
		return "[[" + getEmployeeID() + ",[" + getName() + ", " + getAge() + ", " + getGender() + ", " + getAddress() + "]], " + salary + "]";
	}	
		
}

class Administrator extends SalariedEmployee{

	/**
	 * Constructor with a matching parameter list.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Administrator(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		
	}
	
}

class PhysicianAdministrator extends Administrator{   
	
	private List<Employee> physician;
	private String adminSpecialtyType;

	/**
	 * This constructor initializes the physician variable list.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public PhysicianAdministrator(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		physician = new ArrayList<Employee>();   // initialization.
		
	}
    
	/**
	 * This method adds physicians.
	 * @param Addedphysician
	 */
    public void addPhysician(Physician Addedphysician) {
		
		physician.add(Addedphysician); // The process of adding physician.
		
	}
	
    /**
     * Accessor method for adminSpecialtyType.
     * @return adminSpecialtyType
     */
	public String getAdminSpecialtyType() {
		
		return adminSpecialtyType;
		
	}

	/**
	 * This mutator method sets the admin specialty types (Immunology, Dermatology, or Neurology).
	 * @param specialtyType
	 * @throws IllegalArgumentException is thrown if the specialty type is neither Immunlogy, Dermatology, or Neurology.
	 */
	public void setAdminSpecialtyType(String specialtyType) {
		
		//The follwing boolean variables are for checking the specialty types. 
		boolean Immunology = specialtyType.equalsIgnoreCase("Immunology");
		boolean Dermatology = specialtyType.equalsIgnoreCase("Dermatology");
		boolean Neurology = specialtyType.equalsIgnoreCase("Neurology");
		
		// checks for the specialty types.
		if(Immunology || Dermatology || Neurology) {
			
			this.adminSpecialtyType = specialtyType; 
			
		}
		else {    //Throws IllegalArgumentException if the specialty is not avilable.
			
			throw new IllegalArgumentException("Sorry, this specialty type is not avilable."); 
			
		}
	}
	
	/**
	 * Extracts the physician details.
	 * @return physician
	 */
	public List<Employee> extractPhysician(){
		
		return physician;
		
	}

	//tostring method. Returns the proper string representation of PhysicianAdministrator.
	@Override
	public String toString() {
		
		return "PysicianAdministrator [[[" + getEmployeeID() + ",[" + getName() + ", " + getAge()
		        + ", " + getGender() + ", " + getAddress() + "]], " + getSalary() + "], " + adminSpecialtyType + "]";
		
	}	
}

class Director extends Administrator{                                                 
	
    private List<Employee> admin;
    
    /**
     * Accessor method for admin.
     * @return admin
     */
    public List<Employee> getAdministrator() {
		
		return admin;
		
	}

    /**
     * Mutator method for admin.
     * @param admin
     */
	public void setAdministrator(List<Employee> admin) {
		
		this.admin = admin;
		
	}
	
	/**
	 * This constructor initializes the list admin variable, and this constructor has a matching paramer list.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Director(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		admin = new ArrayList<Employee>();      // initialization 
		
	}
	
	/**
	 * This method assigns admininstrators.  
	 * @param administrator
	 * @return flag. Flag is type boolean variable.
	 */
	public boolean assignAdministrator(PhysicianAdministrator administrator) {
		
		boolean flag = true;
		
		// Checks if the number of administrators have exceeded the limit then return false, otherwise add the administrator and return true.   
		if(admin.size() >= 3) {
			
			flag =  false;
			return flag;
			
		}
		else {
		
		     admin.add(administrator); // adds administrator.
		     flag = true;
		     return flag;
		     
		}
		
	}
	
	/**
	 * This method extracts the physician administrator details.
	 * @return admin
	 */
	public List<Employee> extractPhysicianAdmins(){
		
		return admin;
		
	}
}

class Physician extends SalariedEmployee implements Comparable<Physician>{
	
	private String specialtyType;
	
	// The list variables:
	private List<Patient> patient;
	private List<Employee> volunteer;

	/**
	 * This constructor initializes volunteer, and patient. This constructor also has matching parameter list.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param address
	 */
	public Physician(String firstName, String lastName, int age, String gender, String address) {
		
		super(firstName, lastName, age, gender, address);
		volunteer = new ArrayList<Employee>();         // Initilization
		patient = new ArrayList<Patient>();            // Initilization
		
	}
	
	/**
	 * This method assigns patient to a physician. 
	 * @param assignPatients
	 * @return flag. Flag holds true if the assigning process was successful, otherwise flag holds false as its value.
	 */
	public boolean assignPatient(Patient assignPatients) {
		
		boolean flag = true;
		
		// Checks if the limit of the number of patients that can be assigned to a physician.
		// If it exceeds the limit, then returns false. Otherwise, adds the patient then returns true.
		if(patient.size() >= 8) {
			
			flag = false;
			return flag;
			
		}
		else {
			
		    patient.add(assignPatients); //Assigns patient.
		    flag = true;
		    return flag;
		
		}
	}
	
	/**
	 * Extracts the patient details.
	 * @return patient
	 */
    public List<Patient> extractPatientDetail(){
		
		return patient;
		
	}
   
    /**
     * This method assigns volunteers.
     * @param assignVolunteers
     * @return flag. Flag holds true if the assigning process was successful, otherwise flag holds false as its value.
     */
	public boolean assignVolunteer(Employee assignVolunteers) {
		
		boolean flag = true;
		
		// Checks if it exceeds the limit of maximum volunteers.
		// If it did exceed the maximum number of volunteers, then returns false. Otherwise adds the volunteers, then returns true;
		if(volunteer.size() >= 5) {
			
			flag = false;
			return flag;
			
		}
		else {
			
		    volunteer.add(assignVolunteers);  // adds volunteer.
		    flag = true;
		    return flag;
		
		}
		
	}
	
	/**
	 * This method extracts the volunteer details. 
	 * @return volunteers
	 */
	public List<Employee> extractValunterDetail(){ // extractVoluteerDetail was spelled wrong in the j unit lol.
		
		return volunteer;
		
	}
	
	/**
	 * This method check for maximum patients.
	 * @return flag. Flag holds true if the assigning process was successful, otherwise flag holds false as its value.
	 */
	public boolean hasMaximumpatient() {
		
		boolean flag = true;
		
		// Checks if the number of patient has reached its limit. If so, then returns true. Otherwise returns false.
		if(patient.size() == 8){
			
			flag = true;
			return flag;
			
		}
		else {
			
			flag = false;
			return flag;
			
		}
	}
	
	/**
	 * This method checks if the hospital has maximum number of volunteers.
	 * @return flag. Flag holds true if the assigning process was successful, otherwise flag holds false as its value.
	 */
    public boolean hasMaxVolunteers() {
		
		boolean flag = true;
		
		// Checks if the number of volunteers has reached its limit. If so, then return true. Otherwise returns false.
		if(volunteer.size() == 5){
			
			flag = true;
			return flag;
			
		}
		else {
			
			flag = false;
			return flag;
			
		}
	}

    // Getter and setter methods:
    
    /**
     * Accessor method for specialtyType.
     * @return specialtyType
     */
	public String getSpecialty() {
		
		return specialtyType;
		
	}

	/**
	 * Mutator method for specialtyType. This method checks for the type of specialties.
	 * @param specialtyTypes
	 * @throws IllegalArgumentException if the specialties are not avilable.
	 */
	public void setSpecialty(String specialtyTypes) {
		
		// The folowing boolean variables are for checking specialties (Immunology, Dermatology, or Neurology).
		boolean Immunology = specialtyTypes.equalsIgnoreCase("Immunology");
		boolean Dermatology = specialtyTypes.equalsIgnoreCase("Dermatology");
		boolean Neurology = specialtyTypes.equalsIgnoreCase("Neurology");
		
		// Checks if the specialties are Immunology, Dermatology, or Neurology.
		if(Immunology || Dermatology || Neurology) {
			
			this.specialtyType = specialtyTypes;
			
		}
		else {
			
			throw new IllegalArgumentException("Sorry, the specialty is not avilable.");  // throws IllegalArgumentException if the specialty type is not avilable.
			
		}
	}

	/**
	 * Accesor method for volunteer.
	 * @return volunteer
	 */
	public List<Employee> getVolunteers() {
		
		return volunteer;
		
	}

	/**
	 * Mutator method for volunteer
	 * @param volunteer
	 */
	public void setVolunteers(List<Employee> volunteer) {
		
		this.volunteer = volunteer;
		
	}
	
	/**
	 * Accessor method for patient.
	 * @return patient
	 */
	public List<Patient> getPatients() {
		
		return patient;
		
	}
	
	/**
	 * Mutator method for patient.
	 * @param patient
	 */
	public void setPatients(List<Patient> patient) {
		
		this.patient = patient;
		
	}
	
	// compareTo method:
	@Override
	public int compareTo(Physician object) {
		
		return 0;
		
	}
	
	// toString method. Returns the string representation.
	@Override
	public String toString() {
		
		return "Physician [[[" + getEmployeeID() + ",[" + getName() + ", " + getAge() + ", " + getGender() + ", " + getAddress() + "]], " + getSalary() + "]]";    // Physician was spelled wrong in j unit lol 
		
	}
}


// The following classes are for defining exceptions: 

class NoSpaceException extends Exception{

	public NoSpaceException() {
		
		super();
		
	}
	
	public NoSpaceException(String errorMessage) {
		
		super(errorMessage);

	}
}
class NoVolunteersException extends Exception{

	public NoVolunteersException() {
		
		super();

	}
	
	public NoVolunteersException(String errorMessage) {
		
		super(errorMessage);
		
	}
}
class NoSpecialtyException extends Exception{
	
	public NoSpecialtyException() {
		
		super();
		
	}
	
	public NoSpecialtyException(String errorMessage) {
		
		super(errorMessage);
		
	}
}





