package org.app.dicegame.Classes;

import org.junit.jupiter.api.Test;

import static org.app.dicegame.Classes.Generator.generateNumber;
import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void generateNumberTest() {
        int number = generateNumber();
        assertTrue(number <= 6 && number > 0);
    }
}