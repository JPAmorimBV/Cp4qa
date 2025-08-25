// Joao Pedro Amorim - RM 559213
package com.apdex;

public class Apdex {

    public float calcularApdex(int s, int t, int a) {
        if (a == 0) {
            throw new IllegalArgumentException("Total de amostras não pode ser zero");
        }
        return (s + (t / 2.0f)) / a;
    }

    public String rotularApdex(float score) {
        if (score >= 0.94f) {
            return "Excelente";
        } else if (score >= 0.85f) {
            return "Bom";
        } else if (score >= 0.70f) {
            return "Razoável";
        } else if (score >= 0.50f) {
            return "Ruim";
        } else {
            return "Inaceitável";
        }
    }
}
