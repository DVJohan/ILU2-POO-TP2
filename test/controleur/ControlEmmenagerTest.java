package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;


class ControlEmmenagerTest {
	
	Village village;
	ControlEmmenager controlEmmenager;
	Chef abraracourcix;
	
	@BeforeEach
	void initialiserTests() {
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
	}
	

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		//assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		controlEmmenager.ajouterDruide("Panoramix",10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(controlEmmenager.isHabitant("Panoramix"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(controlEmmenager.isHabitant("Bonemine"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("PasBonemine"));
	}

}

