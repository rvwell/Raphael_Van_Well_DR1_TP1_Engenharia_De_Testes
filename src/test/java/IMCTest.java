import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IMCTest {

    //Criando Testes Baseados em Propriedades com Jqwik
    @Property
    void imcNuncaDeveSerNegativo(@ForAll @Positive double peso, @ForAll @Positive double altura) {
        double imc = CalculoIMC.calcularPeso(peso, altura);
        assertTrue(imc >= 0, "O IMC nunca deve ser negativo");
    }

    //Gerando Conjuntos Diversificados de Dados
    @Provide
    Arbitrary<Double> pesosExtremos() {
        return Arbitraries.of( 1.0, 400.0, 500.0, 700.0);
    }

    @Provide
    Arbitrary<Double> alturasExtremas() {
        return Arbitraries.of(0.1,0.5,2.5,3.0);
    }

    @Property
    void testIMCComValoresExtremos(
            @ForAll("pesosExtremos") double peso,
            @ForAll("alturasExtremas") double altura
    ) {
        double imc = CalculoIMC.calcularPeso(peso, altura);
        assertTrue(imc > 0, "IMC nunca deve ser negativo em alturas válidas");
    }

    //Analisando Contraprovações Geradas pelo Jqwik
    @Property
    void testIMCComValoresAleatorios(@ForAll double peso, @ForAll double altura) {
        double imc = CalculoIMC.calcularPeso(peso, altura);
        assertTrue(imc >=0);
        //Caso o Jqwik gere um valor de altura igual a zero o programa ira dar um erro pois é impossivel fazer uma divisão de zero
    }

    //Isolando Dependências com Mocks


    //Criando Testes Baseados em Propriedades para Valores Específicos
    @Property
    void testIMCComCasosEspecíficos(@Example double peso, @Example double altura) {
        double imc1 = CalculoIMC.calcularPeso(peso, altura);

        assertThat(imc1).isBetween(10.0, 50.0);
    }

}
