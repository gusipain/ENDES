/**
 * Primos.java
 * Cuenta los números primos hasta 3.000.000 y mide el tiempo.
 * Sirve para comparar la JVM con compilación JIT y sin ella.
 *
 *   javac Primos.java
 *   java Primos           -> intérprete + compilación JIT (modo normal)
 *   java -Xint Primos     -> solo intérprete
 */
public class Primos {

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        int total = 0;

        for (int n = 2; n <= 3_000_000; n++) {
            boolean primo = true;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                total++;
            }
        }

        long ms = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("Primos encontrados: " + total);
        System.out.println("Tiempo: " + ms + " ms");
    }
}