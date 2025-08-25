// Joao Pedro Amorim - RM 559213
package com.apdex;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApdexTest {

    private Apdex apdex;
    private static final int TOTAL_AMOSTRAS = 559213;

    @BeforeEach
    public void setup() {
        apdex = new Apdex();
    }

    @Test
    public void testApdexExcelente() {
        int satisfatorias = TOTAL_AMOSTRAS;
        int toleraveis = 0;

        float score = apdex.calcularApdex(satisfatorias, toleraveis, TOTAL_AMOSTRAS);

        assertEquals(1.0f, score, 0.001f);
        assertEquals("Excelente", apdex.rotularApdex(score));
    }

    @Test
    public void testApdexBom() {
        int satisfatorias = (int)(TOTAL_AMOSTRAS * 0.87);
        int toleraveis = (int)(TOTAL_AMOSTRAS * 0.04);

        float score = apdex.calcularApdex(satisfatorias, toleraveis, TOTAL_AMOSTRAS);

        assertTrue(score >= 0.85f && score <= 0.93f);
        assertEquals("Bom", apdex.rotularApdex(score));
    }

    @Test
    public void testApdexRazoavel() {
        int satisfatorias = (int)(TOTAL_AMOSTRAS * 0.77);
        int toleraveis = (int)(TOTAL_AMOSTRAS * 0.06);

        float score = apdex.calcularApdex(satisfatorias, toleraveis, TOTAL_AMOSTRAS);

        assertTrue(score >= 0.70f && score <= 0.84f);
        assertEquals("Razoável", apdex.rotularApdex(score));
    }

    @Test
    public void testApdexRuim() {
        int satisfatorias = (int)(TOTAL_AMOSTRAS * 0.59);
        int toleraveis = 0;

        float score = apdex.calcularApdex(satisfatorias, toleraveis, TOTAL_AMOSTRAS);

        assertTrue(score >= 0.50f && score <= 0.69f);
        assertEquals("Ruim", apdex.rotularApdex(score));
    }

    @Test
    public void testApdexInaceitavel() {
        int satisfatorias = (int)(TOTAL_AMOSTRAS * 0.23);
        int toleraveis = (int)(TOTAL_AMOSTRAS * 0.46);

        float score = apdex.calcularApdex(satisfatorias, toleraveis, TOTAL_AMOSTRAS);

        assertTrue(score >= 0.0f && score <= 0.49f);
        assertEquals("Inaceitável", apdex.rotularApdex(score));
    }

    @Test
    public void testExcecaoTotalZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            apdex.calcularApdex(100, 50, 0);
        });
    }

    @Test
    public void testCalculoComExemploOriginal() {
        int satisfatorias = 270;
        int toleraveis = 70;
        int total = 400;

        float score = apdex.calcularApdex(satisfatorias, toleraveis, total);

        assertEquals(0.7625f, score, 0.001f);
        assertEquals("Razoável", apdex.rotularApdex(score));
    }
}
