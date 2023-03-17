//Autor: Melissa Maasm
package gegenstand.gegenstandFactory;

import gegenstand.Gegenstand;
import gegenstand.GegenstandFactory;
import gegenstand.artefakt.*;
import gegenstand.ruestung.*;
import gegenstand.waffe.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spielfigur.builder.MonsterFactory;
import spielfigur.model.Troll;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GegenstandFactoryTest {

    Gegenstand gegenstand;

    @DisplayName("Should successfuly create Umhang")
    @Test
    void testCreateUmhangSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Umhang") instanceof Umhang);
    }

    @DisplayName("Should successfuly create Amulett")
    @Test
    void testCreateAmulettSuccess() {
        assertTrue((GegenstandFactory.newGegenstand("Amulett") instanceof Amulett));
    }

    @DisplayName("Should successfuly create Ring")
    @Test
    void testCreateRingSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Ring") instanceof Ring);
    }

    @DisplayName("Should successfuly create Heiltrank")
    @Test
    void testCreateHeiltrankSuccess() {
        assertTrue((GegenstandFactory.newGegenstand("Heiltrank") instanceof Heiltrank));
    }

    @DisplayName("Should successfuly create Gift")
    @Test
    void testCreateGiftSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Gift") instanceof Gift);
    }

    @DisplayName("Should successfuly create Unsichtbarkeitstrank")
    @Test
    void testCreateUnsichtbarkeitstrankSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Unsichtbarkeitstrank") instanceof Unsichtbarkeitstrank);
    }

    @DisplayName("Should successfuly create keineRuestung")
    @Test
    void testCreateKeineRuestungSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("keineRuestung") instanceof KeineRuestung);
    }

    @DisplayName("Should successfuly create Lederruestung")
    @Test
    void testCreateLederruestungSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Lederruestung") instanceof Lederruestung);
    }

    @DisplayName("Should successfuly create Schuppenpanzer")
    @Test
    void testCreateSchuppenpanzerSuccess() {
        assertTrue(GegenstandFactory.newGegenstand("Schuppenpanzer") instanceof Schuppenpanzer);
    }

    @DisplayName("Should successfuly create Kettenpanzer")
    @Test
    void testCreateKettenpanzerSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Kettenpanzer") instanceof Kettenpanzer);
    }

    @DisplayName("Should successfuly create Schild")
    @Test
    void testCreateSchildSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Schild") instanceof Schild);
    }

    @DisplayName("Should successfuly create KeineWaffe")
    @Test
    void testCreateKeineWaffeSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("KeineWaffe") instanceof KeineWaffe);
    }

    @DisplayName("Should successfuly create Dolch")
    @Test
    void testCreateDolchSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Dolch") instanceof Dolch);
    }

    @DisplayName("Should successfuly create Wurfpfeil")
    @Test
    void testCreateWurfpfeileSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Wurfpfeil") instanceof Wurfpfeil);
    }

    @DisplayName("Should successfuly create Knueppel")
    @Test
    void testCreateKnueppelSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Knueppel") instanceof Knueppel);
    }

    @DisplayName("Should successfuly create Handaxt")
    @Test
    void testCreateHandaxtSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Handaxt") instanceof Handaxt);
    }

    @DisplayName("Should successfuly create Streitaxt")
    @Test
    void testCreateStreitaxtSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Streitaxt") instanceof Streitaxt);
    }

    @DisplayName("Should successfuly create Speer")
    @Test
    void testCreateSpeerSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Speer") instanceof Speer);
    }

    @DisplayName("Should successfuly create Schwert")
    @Test
    void testCreateSchwertSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Schwert") instanceof Schwert);
    }

    @DisplayName("Should successfuly create Degen")
    @Test
    void testCreateDegenSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Degen") instanceof Degen);
    }

    @DisplayName("Should successfuly create Bogen mit Pfeilen")
    @Test
    void testCreateBogenMitPfeilenSuccess(){
        assertTrue(GegenstandFactory.newGegenstand("Bogen mit Pfeilen")instanceof BogenMitPfeilen);
    }

    @DisplayName("Should be throw error in case of unequal specifications")
    @Test
    void testWrongGegenstand() {
        assertThrows(IllegalArgumentException.class, ()-> GegenstandFactory.newGegenstand("Etwas falsches"));
    }
}