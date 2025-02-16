import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculoIMCTest {
    @Test
    void testClassificarIMC() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.9));
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.5));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(17.5));
        assertEquals("Saudável", CalculoIMC.classificarIMC(22.0));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(27.0));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(32.0));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(37.0));
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(45.0));
    }

    @Test
    void testCalcularIMC() {
        assertEquals(22.86, CalculoIMC.calcularPeso(70, 1.75),0.01);
        assertEquals(25.14, CalculoIMC.calcularPeso(87, 1.86),0.01);
    }

}
