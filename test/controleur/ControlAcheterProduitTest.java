package controleur;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


class ControlAcheterProduitTest {
	private Village village;
    private Chef abraracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlAcheterProduit controlAcheterProduit;
    
    @BeforeEach
    void initialiserTests() {
        // À adapter à ton constructeur de Village (nbVillageois, nbEtals…)
        village = new Village("Le village des irréductibles", 10, 5);
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);

        // On ajoute quelques vendeurs avec leurs étals
        Gaulois obelix = new Gaulois("Obelix", 20);
        Gaulois asterix = new Gaulois("Asterix", 8);
        village.ajouterHabitant(obelix);
        village.ajouterHabitant(asterix);

        // Obelix vend des menhirs
        int etalObelix = village.installerVendeur(obelix, "menhir", 5);
        // Asterix vend des potions
        int etalAsterix = village.installerVendeur(asterix, "potion", 3);

        // Contrôleurs utilisés par ControlAcheterProduit
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);

        controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
    }

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Le contrôleur ne doit pas être null");
	}

	@Test
	void testVerifierIdentite() {
		// Habitant connu
        assertTrue(controlAcheterProduit.verifierIdentite("Asterix"),
                "Asterix est habitant, l'identité devrait être vérifiée");

        // Habitant inconnu
        assertFalse(controlAcheterProduit.verifierIdentite("Jules Cesar"),
                "Jules Cesar n'est pas habitant, l'identité ne doit pas être vérifiée");
	}

	@Test
	void testRechercherVendeursParProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testAcheterProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerEtatMarche() {
		fail("Not yet implemented");
	}

}
