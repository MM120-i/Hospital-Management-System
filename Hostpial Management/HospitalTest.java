package pe2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class HospitalTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);


	@Test
	void test_00_01_01() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		assertEquals(director, hospital.getHospDirector(), "hospital getHospDirector fail");
	}

	@Test
	void test_00_02_01() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		assertEquals(director, hospital.getHospDirector(), "hospital getHospDirector fail");
	}

	@Test
	void test_00_03_00() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");

		assertEquals("Immunology", admin1.getAdminSpecialtyType(), "PhysicianAdministrator getAdminSpecialtyType fail");

	}

	@Test
	void test_00_03_01() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		assertEquals("Elizabeth, Smith", admin1.getName(), "PhysicianAdministrator getName fail");

	}

	@Test
	void test_00_03_02() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		assertEquals("Female", admin1.getGender(), "PhysicianAdministrator getGender fail");

	}

	@Test
	void test_00_03_04() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");

		assertEquals(53, admin1.getAge(), "PhysicianAdministrator getAge fail");

	}

	@Test
	void test_00_03_05() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");

		assertEquals("Lawrence Avenue East", admin1.getAddress(), "PhysicianAdministrator getAddress fail");

	}

	@Test
	void test_00_03_06() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		assertEquals(107, admin1.getEmployeeID(), "PhysicianAdministrator getEmployeeID fail");

	}

	@Test
	void test_00_03_07() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");

		admin1.setSalary(4521);

		assertEquals(4521, admin1.getSalary(), 0.001, "PhysicianAdministrator getSalary fail");

	}

	@Test
	void test_00_03_08() {
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		admin1.setSalary(4521);

		assertEquals(
				"PysicianAdministrator [[[109,[Elizabeth, Smith, 53, Female, Lawrence Avenue East]], 4521.0], Immunology]",
				admin1.toString(), "PhysicianAdministrator toString fail");

	}

	@Test
	void test_00_04_01() {

		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");

		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");

		try {
			// wrong specialty
			admin3.setAdminSpecialtyType("Neuroloyy");
			fail("PhysicianAdministrator setAdminSpecialtyType fail");
		} catch (IllegalArgumentException e) {
			// Exception is expected
		}

	}

	@Test
	void test_00_04_02() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		assertTrue(director.assignAdministrator(admin1), "assignAdministrator pass");

	}

	@Test
	void test_00_04_03() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		director.assignAdministrator(admin1);
		assertEquals(1, director.extractPhysicianAdmins().size(), "director extractPhysicianAdmins Fail");
	}

	@Test
	void test_00_04_04() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		PhysicianAdministrator admin4 = new PhysicianAdministrator("Jim", "Tom", 55, "Male", "Danforth Road");
		admin4.setAdminSpecialtyType("Dermatology");

		director.assignAdministrator(admin1);
		director.assignAdministrator(admin2);
		director.assignAdministrator(admin3);

		assertEquals(3, director.extractPhysicianAdmins().size(), "director extractPhysicianAdmins Fail");
		assertFalse(director.assignAdministrator(admin4), "director assignAdministrator pass");
	}

	@Test
	void test_00_04_05() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		PhysicianAdministrator admin4 = new PhysicianAdministrator("Jim", "Tom", 55, "Male", "Danforth Road");
		admin4.setAdminSpecialtyType("Dermatology");

		director.assignAdministrator(admin1);
		director.assignAdministrator(admin2);
		director.assignAdministrator(admin3);

		assertFalse(director.assignAdministrator(admin4), "director assignAdministrator pass");
	}

	@Test
	void test_00_04_06() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		PhysicianAdministrator admin4 = new PhysicianAdministrator("Jim", "Tom", 55, "Male", "Danforth Road");
		admin4.setAdminSpecialtyType("Dermatology");

		assertEquals(true, hospital.addAdministrator(admin1), "Hospital assignAdministrator pass");

	}

	@Test
	void test_00_04_07() {
		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		PhysicianAdministrator admin4 = new PhysicianAdministrator("Jim", "Tom", 55, "Male", "Danforth Road");
		admin4.setAdminSpecialtyType("Dermatology");
		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		assertFalse(hospital.addAdministrator(admin4), "Hospital assignAdministrator fail"); // wtf?

	}

	@Test
	void test_00_05_01() {
		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		assertEquals("Canlish Road", physician1.getAddress(), "Physician getAddress fail ");

	}

	@Test
	void test_00_05_02() {
		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		assertEquals("Physician [[[137,[Ryan, Mark, 35, Male, Canlish Road]], 0.0]]", physician1.toString(),
				"Physician toString fail ");

	}

	@Test
	void test_00_05_03() {
		Physician physician1 = new Physician("Gibson", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(4500);
		assertEquals("Physician [[[138,[Gibson, Mark, 35, Male, Canlish Road]], 4500.0]]", physician1.toString(),
				"Physician toString fail ");

	}

	@Test
	void test_00_05_04() {
		Physician physician1 = new Physician("Gibson", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(4500);
		physician1.setFirstName("NewName");
		assertEquals("NewName, Mark", physician1.getName(), "Physician getName fail ");

	}

	@Test
	void test_00_05_05() {
		Physician physician1 = new Physician("Gibson", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(4500);
		physician1.setFirstName("NewName");
		physician1.setSpecialty("Dermatology");
		assertEquals("Dermatology", physician1.getSpecialty(), "Physician getSpecialty fail ");

	}

	@Test
	void test_00_05_06() {
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");

		physician2.setLastName("NewLastName");
		assertEquals("George, NewLastName", physician2.getName(), "Physician getName fail ");

	}

	@Test
	void test_00_05_07() {
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");

		try {
			physician2.setSpecialty("Imunology");
			fail("Physician setSpecialty fail ");
		} catch (IllegalArgumentException e) {
			// exception is expected
		}

	}

	@Test
	void test_00_05_08() {
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");

		assertEquals(143, physician2.getEmployeeID(), "getEmployeeID fail ");

	}

	@Test
	void test_00_05_09() {
		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		physician4.setAddress("New Address");
		physician4.setAge(35);
		physician4.setGender("Male");
		physician4.setFirstName("New First NameC");
		assertEquals("Physician [[[144,[New First NameC, LastNameB, 35, Male, New Address]], 4000.0]]",
				physician4.toString(), "toString fail ");

	}

	@Test
	void test_00_06_01() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);

		assertEquals(true, hospital.hirePhysician(physician1), "Hospital hirePhysician fail");

	}

	@Test
	void test_00_06_02() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		assertFalse(hospital.hirePhysician(physician1), "Hospital hirePhysician fail");

	}

	@Test
	void test_00_06_03() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		assertEquals(1, admin2.extractPhysician().size(), "PhysicianAdministrator extractPhysician fail");

	}

	@Test
	void test_00_06_04() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		assertEquals(false, hospital.hirePhysician(physician2), "hirePhysician fail already hired");

	}

	@Test
	void test_00_06_05() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		assertEquals(1, admin2.extractPhysician().size(), "PhysicianAdministrator extractPhysician fail");

	}

	@Test
	void test_00_06_06() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		assertEquals(1, admin1.extractPhysician().size(), "PhysicianAdministrator extractPhysician fail");

	}

	@Test
	void test_00_06_07() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		assertEquals(1, admin3.extractPhysician().size(), "PhysicianAdministrator extractPhysician fail");

	}

	@Test
	void test_00_06_08() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		assertEquals(2, admin3.extractPhysician().size(), "PhysicianAdministrator extractPhysician fail");

	}

	@Test
	void test_00_06_09() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		assertEquals(4, hospital.extractAllPhysicianDetails().size(), "Hospital extractAllPhysicianDetails fail");

	}

	@Test
	void test_00_06_10() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
			hospital.resignPhysician(physician1);
			fail("Hospital resignPhysician fail ");
		} catch (NoSpecialtyException e) {
			// exception are expected
			// System.out.println("you can verify that by uncomment this line");

		}

	}

	@Test
	void test_00_06_11() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
			hospital.resignPhysician(physician4);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail("Hospital resignPhysician fail ");
		}

	}

	@Test
	void test_00_06_12() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
			hospital.resignPhysician(physician4);
			// you can verify that by uncomment the below line
			// fail();
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}

		assertEquals(3, hospital.extractAllPhysicianDetails().size(), " Hospital extractAllPhysicianDetails fail");
	}

	@Test
	void test_00_07_01() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");
		assertEquals("Patient [1000, [Nicolas, Jason, 25, Male, Belfield]]", p0.toString(), "toString fail");
	}

	@Test
	void test_00_07_02() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");
		assertEquals("Belfield", p0.getAddress(), "Patient getAddress fail");
	}

	@Test
	void test_00_07_03() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");

		assertEquals(25, p0.getAge(), "Patient getAge fail");
	}

	@Test
	void test_00_07_04() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");
		p0.setAddress("Kingston Road");
		p0.setFirstName("Dave");
		p0.setLastName("Renner");
		p0.setAge(85);
		p0.setGender("Male");

		assertEquals("Patient [1003, [Dave, Renner, 85, Male, Kingston Road]]", p0.toString(), "Patient toString fail");
	}

	@Test
	void test_00_07_05() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");

		assertEquals("Male", p0.getGender(), "Patient getGender fail");
	}

	@Test
	void test_00_07_06() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");
		p0.setFirstName("Dave");
		p0.setLastName("Renner");
		assertEquals("Dave, Renner", p0.getName(), "Patient getName fail");
	}

	@Test
	void test_00_07_07() {
		Patient p0 = new Patient("Nicolas", "Jason", 25, "Male", "Belfield");
		assertEquals(1006, p0.getPatientID(), "Patient getPatientID fail");
	}

	@Test
	void test_00_08_01() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		assertEquals(0, hospital.extractAllPatientDetails().size(), "Hospital extractAllPatientDetails fail");

	}

	@Test
	void test_00_08_02() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		try {
			assertEquals(true, hospital.admitPatient(alist.get(0)), "Hospital admitPatient pass");

		} catch (NoSpaceException e) {
			// no exception
			fail();
		}

	}

	@Test
	void test_00_08_03() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		try {
			hospital.admitPatient(alist.get(0));
			assertEquals(false, hospital.admitPatient(alist.get(0)), "Hospital admitPatient pass");
		} catch (NoSpaceException e) {
			// no exception
			fail();
		}

	}

	@Test
	void test_00_08_04() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		assertEquals(9, hospital.extractAllPatientDetails().size(), "hospital extractAllPatientDetails fail");

	}

	@Test
	void test_00_08_05() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		assertEquals(8, physician1.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_06() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		assertEquals(1, physician2.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_07() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		assertEquals(0, physician3.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_08() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		assertEquals(0, physician3.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_09() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 9; i < 16; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		assertEquals(16, hospital.extractAllPatientDetails().size(), "hospital extractAllPatientDetails fail");

	}

	@Test
	void test_00_08_10() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 9; i < 16; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		assertEquals(8, physician2.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_11() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 9; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 9; i < 16; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		assertEquals(0, physician3.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_12() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		assertEquals(8, physician3.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_13() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 24; i < 26; i++) {
			try {
				assertEquals(false, hospital.admitPatient(alist.get(i)),
						"hospital admitPatient fail Physician are busy");
				fail();

			} catch (NoSpaceException e) {
				// exception are expected

			}
		}

	}

	@Test
	void test_00_08_14() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 24; i < 26; i++) {
			try {
				hospital.admitPatient(alist.get(i));
				fail();

			} catch (NoSpaceException e) {
				// exception are expected

			}
		}

		assertEquals(24, hospital.extractAllPatientDetails().size(), "hospital extractAllPatientDetails fail");

	}

	@Test
	void test_00_08_15() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				assertEquals(true, hospital.dischargePatient(alist.get(i)), "dischargePatient pass");
		}

	}

	@Test
	void test_00_08_16() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		assertEquals(17, hospital.extractAllPatientDetails().size(), "hospital extractAllPatientDetails fail");
	}

	@Test
	void test_00_08_17() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}
		assertEquals(7, physician3.extractPatientDetail().size(), "Physician extractPatientDetail fail");

	}

	@Test
	void test_00_08_18() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}

		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		assertEquals(17, hospital.extractAllPatientDetails().size(), "hospital extractAllPatientDetails fail");

	}

	@Test
	void test_00_08_19() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail("resignPhysician Fail");
		}

	}

	@Test
	void test_00_08_20() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}

		assertEquals(17, hospital.extractAllPatientDetails().size(), "extractAllPatientDetails fail");
	}

	@Test
	void test_00_08_21() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}

		assertEquals(8, physician1.extractPatientDetail().size(), "extractPatientDetail fail");
	}

	@Test
	void test_00_08_22() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}

		assertEquals(8, physician2.extractPatientDetail().size(), "extractPatientDetail fail");
	}

	@Test
	void test_00_08_23() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}

		assertEquals(1, physician4.extractPatientDetail().size(), "extractPatientDetail fail");
	}

	@Test
	void test_00_08_24() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}
		for (int i = 16; i < 24; i++) {
			if (i == 18)
				continue;
			hospital.dischargePatient(alist.get(i));
		}

		assertEquals(0, physician4.extractPatientDetail().size(), "extractPatientDetail fail");
	}

	@Test
	void test_00_08_25() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Random rnd = new Random();
		List<Patient> alist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			alist.add(new Patient("PFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"PLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Paddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 24; i++) {
			try {
				hospital.admitPatient(alist.get(i));

			} catch (NoSpaceException e) {
				// no exception
				fail();
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i % 3 == 0)
				hospital.dischargePatient(alist.get(i));
		}

		try {
			hospital.resignPhysician(physician3);
			// you can verify that by uncomment the below line
			// fail();
		} catch (Exception e) {
			// no exception
			fail();
		}
		for (int i = 16; i < 24; i++) {
			if (i == 18)
				continue;
			hospital.dischargePatient(alist.get(i));
		}

		assertEquals(10, hospital.extractAllPatientDetails().size(), "extractAllPatientDetails fail");

	}

	@Test
	void test_00_09_01() {
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		assertEquals("Volunteer [[435,[Arnold, Jason, 45, Male, Danforth]]]", v0.toString(), "Volunteer toString fail");
	}

	@Test
	void test_00_09_02() {
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		assertEquals("Danforth", v0.getAddress(), "Volunteer getAddress fail");
	}

	@Test
	void test_00_09_03() {
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		assertEquals(45, v0.getAge(), "Volunteer getAge fail");
	}

	@Test
	void test_00_09_04() {
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		v0.setAddress("Kingston Road");
		v0.setFirstName("Reeves");
		v0.setLastName("Robert");
		v0.setGender("Male");
		v0.setAge(52);
		assertEquals("Volunteer [[438,[Reeves, Robert, 52, Male, Kingston Road]]]", v0.toString(),
				"Volunteer toString fail");
	}

	@Test
	void test_00_09_05() {
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		v0.setAddress("Kingston Road");
		v0.setFirstName("Reeves");
		v0.setLastName("Robert");
		v0.setGender("Male");
		v0.setAge(52);
		assertEquals("Reeves, Robert", v0.getName(), "Volunteer getName fail");
	}

	@Test
	void test_00_10_01() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		assertEquals(true, hospital.hireVolunteer(v0), "hospital hireVolunteer fail");

	}

	@Test
	void test_00_10_02() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		try {
			hospital.resignVolunteer(v0);
			fail("resignVolunteer fail");
		} catch (NoVolunteersException e) {
			// exception are expected
		}

	}

	@Test
	void test_00_10_03() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			assertEquals(true, hospital.hireVolunteer(vlist.get(i)), "hospital hireVolunteer fail");

		}

	}

	@Test
	void test_00_10_04() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		assertEquals(5, physician1.extractValunterDetail().size(), "extractValunterDetail fail");

	}

	@Test
	void test_00_10_05() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		assertEquals(5, physician2.extractValunterDetail().size(), "extractValunterDetail fail");

	}

	@Test
	void test_00_10_06() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		assertEquals(0, physician4.extractValunterDetail().size() + physician3.extractValunterDetail().size(),
				"extractValunterDetail fail");

	}
	
	
	@Test
	void test_00_10_07() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		assertEquals(10, hospital.extractAllVolunteerDetails().size(), "hospital extractAllVolunteerDetails fail");

	}
	
	@Test
	void test_00_10_08() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail("resignVolunteer fail");
		}
	}
	
	
	
	@Test
	void test_00_10_09() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		
		assertEquals(4, physician1.extractValunterDetail().size(), "physician extractValunterDetail fail");
	}
	
	
	
	@Test
	void test_00_10_10() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		
		assertEquals(5, physician2.extractValunterDetail().size(), "physician extractValunterDetail fail");
	}
	@Test
	void test_00_10_11() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);

		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 9; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		
		assertEquals(0, physician4.extractValunterDetail().size() + physician3.extractValunterDetail().size(),
				"extractValunterDetail fail");
	}
	
	
	@Test
	void test_00_10_12() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
		hospital.resignPhysician(physician3);
		
		
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}
		hospital.hirePhysician(physician3);
		
		
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 12; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		
		assertEquals(3, physician4.extractValunterDetail().size() ,
				"extractValunterDetail fail");
	}
	
	
	
	@Test
	void test_00_10_13() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
		hospital.resignPhysician(physician3);
		
		
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}
		hospital.hirePhysician(physician3);
		
		
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 12; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		try {
		hospital.resignPhysician(physician4);
		
		
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}
		
		assertEquals(2, physician3.extractValunterDetail().size() ,
				"extractValunterDetail fail");
	}
	
	
	@Test
	void test_00_10_14() {

		Director director = new Director("Rebert", "Jack", 59, "Male", "Birchmount Road");
		Hospital hospital = new Hospital(director);
		PhysicianAdministrator admin1 = new PhysicianAdministrator("Elizabeth", "Smith", 53, "Female",
				"Lawrence Avenue East");
		admin1.setAdminSpecialtyType("Immunology");
		PhysicianAdministrator admin2 = new PhysicianAdministrator("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
		admin2.setAdminSpecialtyType("Dermatology");
		PhysicianAdministrator admin3 = new PhysicianAdministrator("Adam", "Tom", 55, "Male", "Danforth Road");
		admin3.setAdminSpecialtyType("Neurology");

		hospital.addAdministrator(admin1);
		hospital.addAdministrator(admin2);
		hospital.addAdministrator(admin3);

		Physician physician1 = new Physician("Ryan", "Mark", 35, "Male", "Canlish Road");
		physician1.setSalary(6000);
		physician1.setSpecialty("Dermatology");
		Physician physician2 = new Physician("George", "Hardy", 45, "Male", "Rockwood Drive");
		physician2.setSalary(4050);
		physician2.setSpecialty("Immunology");

		Physician physician3 = new Physician("FirstNameA", "LastNameA", 45, "Female", "AddressA");
		physician3.setSalary(4100);
		physician3.setSpecialty("Neurology");

		Physician physician4 = new Physician("FirstNameB", "LastNameB", 45, "Male", "AddressB");
		physician4.setSpecialty("Neurology");
		physician4.setSalary(4000);
		hospital.hirePhysician(physician1);
		hospital.hirePhysician(physician2);
		hospital.hirePhysician(physician3);
		hospital.hirePhysician(physician4);
		try {
		hospital.resignPhysician(physician3);
		
		
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}
		hospital.hirePhysician(physician3);
		
		
		Volunteer v0 = new Volunteer("Arnold", "Jason", 45, "Male", "Danforth");
		hospital.hireVolunteer(v0);

		Random rnd = new Random();
		List<Volunteer> vlist = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}
		for (int i = 0; i < 12; i++) {

			hospital.hireVolunteer(vlist.get(i));

		}

		try {
			hospital.resignVolunteer(v0);
			
		} catch(NoVolunteersException e) {
			// no exception
			fail();
		}
		try {
		hospital.resignPhysician(physician4);
		
		
		} catch (NoSpecialtyException e) {
			// no exception
			fail();
		}
		
		assertEquals(12, hospital.extractAllVolunteerDetails().size(), "hospital extractAllVolunteerDetails fail");
	}
	
	@Test
	void test_00_11_01_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");
		assertNull(p.getAssignedPhysician());

	

	}
	
	
	@Test
	void test_00_11_02_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");
		

		assertTrue(p.clearPatientRecord(), "Patient clearPatientRecord pass");
	

	}
	
	@Test
	void test_00_11_03_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");
		p.setGender("Female");
		assertEquals("Female", p.getGender(), "Patient getGender fail ");

	}
	
	@Test
	void test_00_11_04_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");
		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		p.setAssignedPhysician(physician1);
		assertSame(physician1, p.getAssignedPhysician(), "setAssignedPhysician or getAssignedPhysician fail ");
		

	}
	@Test
	void test_00_11_05_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");
		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		p.setAssignedPhysician(physician1);
		assertFalse(p.clearPatientRecord(), "Patient clearPatientRecord pass");
		

	}
	
	@Test
	void test_00_11_06_() {

		Patient p = new Patient("Robert", "Robert", 15, "Male", "Guildwood");

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		p.setAssignedPhysician(physician1);

		assertSame(physician1, p.getAssignedPhysician(), "setAssignedPhysician or getAssignedPhysician fail ");

	}
	
	
	
	@Test
	void test_00_12_01_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");

		Random rnd = new Random();

		List<Employee> vlist = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 5; i++) {
			assertTrue(physician1.assignVolunteer(vlist.get(i)), "Physician assignVolunteer fail");
		}

	}
	
	@Test
	void test_00_12_02_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");

		Random rnd = new Random();

		List<Employee> vlist = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 5; i++) {
			physician1.assignVolunteer(vlist.get(i));
		}

		assertEquals(5, physician1.extractValunterDetail().size(), "Physician extractValunterDetail fail");
		

	}
	
	@Test
	void test_00_12_03_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");

		Random rnd = new Random();

		List<Employee> vlist = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 5; i++) {
			physician1.assignVolunteer(vlist.get(i));
		}


		assertTrue(physician1.hasMaxVolunteers(), "Physician hasMaxVolunteers fail");


	}
	
	
	@Test
	void test_00_12_04_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");

		Random rnd = new Random();

		List<Employee> vlist = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			vlist.add(new Volunteer("VFirstName " + i + ((char) (rnd.nextInt(25) + 65)),
					"VLastName " + ((char) (rnd.nextInt(26) + 65)), rnd.nextInt(100), " ",
					"Vaddress" + ((char) (rnd.nextInt(26) + 65))));

		}

		for (int i = 0; i < 5; i++) {
			physician1.assignVolunteer(vlist.get(i));
		}

	
		assertFalse(physician1.assignVolunteer(vlist.get(6)), "Physician assignVolunteer fail");

	}
	
	@Test
	void test_00_13_01_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		physician1.setSpecialty("Dermatology");
		

		assertFalse(physician1.hasMaximumpatient(), "Physician hasMaximumpatient fail");



	}
	
	@Test
	void test_00_13_02_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		physician1.setSpecialty("Dermatology");
		assertFalse(physician1.hasMaxVolunteers(), "Physician hasMaxVolunteers fail");


	}
	
	@Test
	void test_00_13_03_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		physician1.setSpecialty("Dermatology");
		assertEquals(new ArrayList<>(), physician1.extractPatientDetail(), "Physician extractPatientDetail fail");


	}
	
	@Test
	void test_00_13_04_() {

		Physician physician1 = new Physician("Meryl", "Smith", 45, "Female", "Valleys Drive");
		physician1.setSpecialty("Dermatology");
		
		assertEquals(0, physician1.extractValunterDetail().size(), "Physician extractValunterDetail fail");

	}


}
