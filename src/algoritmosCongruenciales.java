
public class algoritmosCongruenciales {

    private int cantidad;
    private float[] numGenerados;

    public algoritmosCongruenciales(int cant) {
        this.cantidad = cant;
        this.numGenerados = new float[cant];
    }

    public float[] AlgoritmoLineal(long x0, int k, int c, int g) {
        long a = 1 + (4 * k);
        long m = (long) Math.pow(2, g);
        for (int i = 0; i < cantidad; i++) {
            long multiplicacion = (a * x0) + c;//Realiza la multiplicaicon de los valores resultantes de a y la semilla(x0) y agrega la constante aditiva
            long mod = multiplicacion % m;//Devuelve el modulo resultante entre la multiplicacion y el valor de m
            
            double r = (double) mod / c;//obtener el numero pseudoaleatorio
            double ri = Math.round(r * 100000) / 100000d;
            numGenerados[i] = (float) ri;
            x0 = mod;
        }
        return numGenerados;
    }

    public float[] AlgoritmoMultiplicativo() {

        return numGenerados;
    }
    
    public void mostrarNum(){
        for (int i = 0; i < cantidad; i++) {
            System.out.println(numGenerados[i]);
        }
    }

    public static void main(String[] args) {
        algoritmosCongruenciales z = new algoritmosCongruenciales(10);

        z.AlgoritmoLineal(6, 3, 7, 3);
        z.mostrarNum();
        
    }

}
