
public class algoritmosCongruenciales {

    private int cantidad;
    private float[] numGenerados;
    private float numRep;

    public algoritmosCongruenciales(int cant) {
        this.cantidad = cant;
        this.numGenerados = new float[cant];
    }

    //Algoritmo lineal para la generacion de numeros pseudoaleatorios
    public float[] AlgoritmoLineal(long x0, int k, int c, int g) {
        long a = 1 + (4 * k);
        long m = (long) Math.pow(2, g);
        for (int i = 0; i < cantidad; i++) {
            long multiplicacion = (a * x0) + c;//Realiza la multiplicaicon de los valores resultantes de a y la semilla(x0) y agrega la constante aditiva
            long mod = multiplicacion % m;//Devuelve el modulo resultante entre la multiplicacion y el valor de m

            double r = (double) mod / c;//obtener el numero pseudoaleatorio
            double ri = Math.round(r * 100000) / 100000d;//Obtiene 5 digitos del numero "aleatorio"
            numGenerados[i] = (float) ri;//agrega el numero generado al areglo de numGenerados
            x0 = mod;
        }
        return numGenerados;
    }

    //Algoritmo de generacion de numeros pseudoaletrios con a = 3+8k
    public float[] AlgoritmoMultiplicativo38(long xi, int k, int g) {
        long a = 3 + (8 * k);
        long m = (long) Math.pow(2, g);
        for (int i = 0; i < cantidad; i++) {
            long multiplicacion = (a * xi);//Realiza la multiplicaicon de los valores resultantes de a
            long mod = multiplicacion % m;//Devuelve el modulo resultante entre la multiplicacion y el valor de m

            double r = (double) mod / (m - 1);//obtener el numero pseudoaleatorio
            double ri = Math.round(r * 100000) / 100000d;//Obtiene 5 digitos del numero "aleatorio"
            numGenerados[i] = (float) ri;//agrega el numero generado al areglo de numGenerados
            xi = mod;
        }
        return numGenerados;
    }

    //Algoritmo de generacion de numeros pseudoaletrios con a = 5+8k
    public float[] AlgoritmoMultiplicativo58(long xi, int k, int g) {
        long a = 5 + (8 * k);
        long m = (long) Math.pow(2, g);
        for (int i = 0; i < cantidad; i++) {
            long multiplicacion = (a * xi);//Realiza la multiplicaicon de los valores resultantes de a
            long mod = multiplicacion % m;//Devuelve el modulo resultante entre la multiplicacion y el valor de m

            double r = (double) mod / (m - 1);//obtener el numero pseudoaleatorio
            double ri = Math.round(r * 100000) / 100000d;//Obtiene 5 digitos del numero "aleatorio"
            numGenerados[i] = (float) ri;//agrega el numero generado al areglo de numGenerados
            xi = mod;
        }
        return numGenerados;
    }
    
    //Algoritmo NO lineal para la generacion de numeros pseudoaleatorios
    public float[] AlgortimoNOLineal(long x, int a,int b, int c, int g){
        if((b-1)%4 != 1) return null;
        long m = (long) Math.pow(2, g);
        for (int i = 0; i < cantidad; i++) {
            long multiplicacion = (long) (((a * Math.pow(x, 2)))+(b*x)+c) ;//Realiza la multiplicaicon de los valores resultantes de a y la semilla(x0) y agrega la constante aditiva
            long mod = multiplicacion % m;//Devuelve el modulo resultante entre la multiplicacion y el valor de m
            System.out.println("MOD: "+mod);
            double r = (double) mod / (m-1);//obtener el numero pseudoaleatorio
            double ri = Math.round(r * 100000) / 100000d;//Obtiene 5 digitos del numero "aleatorio"
            numGenerados[i] = (float) ri;//agrega el numero generado al areglo de numGenerados
            x = mod;
        }
        return numGenerados;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------
    //Metodos de ordenamiento, muestra y comporbacion de valores repetidos
    //Ordenar
    public void quick(float[] arreglo) {
        quicksort(arreglo, 0, arreglo.length - 1);
    }
    private static void quicksort(float A[], int izq, int der) {
        float pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        float aux;

        while (i < j) {                          // mientras no se crucen las búsquedas                                   
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A[j] > pivote) {
                j--;           // busca elemento menor que pivote
            }
            if (i < j) {                        // si no se han cruzado                      
                aux = A[i];                      // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
        A[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der);          // ordenamos subarray derecho
        }
    }

    //Numeros Repetidos
    public boolean numerosRepetidos(float[] numerosAl) {
        for (int i = 1; i < numerosAl.length - 1; i++) {
            if (numerosAl[i - 1] == numerosAl[i]) {
                numRep = i;
                return true;
            }
        }

        return false;
    }//numerosRepetidos

    //Mostrar numeros generdos
    public void mostrarNum() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println(numGenerados[i]);
        }
    }

    public static void main(String[] args) {
        algoritmosCongruenciales z = new algoritmosCongruenciales(10);

//        System.out.println("----- ALGORTIMO LINEAL -----");
//        z.AlgoritmoLineal(50, 39, 1028, 10);
//        z.quick(z.numGenerados);
//        z.mostrarNum();
//
//        System.out.println("----- ALGORTIMO MULTIPLICATIVO 38 -----");
//        z.AlgoritmoMultiplicativo38(177, 15, 9);
//        z.quick(z.numGenerados);
//        z.mostrarNum();
//        
//        System.out.println("----- ALGORTIMO MULTIPLICATIVO 58 -----");
//        z.AlgoritmoMultiplicativo58(177, 15, 9);
//        z.quick(z.numGenerados);
//        z.mostrarNum();
        
        System.out.println("----- ALGORTIMO NO LINEAL -----");
        z.AlgortimoNOLineal(49, 58, 34, 49, 8);
        //z.quick(z.numGenerados);
        z.mostrarNum();

    }

}
