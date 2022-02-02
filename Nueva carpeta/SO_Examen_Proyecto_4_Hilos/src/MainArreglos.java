import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class MainArreglos {

    public static void main(String[] args) throws InterruptedException {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n\tPor favor, ingrese numero ");
        System.out.println("\n\t\t- De elementos del arreglo: ");
        int num_elementos_arreglo = leer.nextInt();
        
        System.out.println("\n\t\t- De hilos productores para arreglo A:");
        int num_hilos_arreglo_A = leer.nextInt();
        System.out.println("\n\t\t- De hilos productores para arreglo B:");
        int num_hilos_arreglo_B = leer.nextInt();
        System.out.println("\n\t\t- De hilos sumadores para arreglo C: ");
        int num_hilos_arreglo_C = leer.nextInt();

        Arreglo arreglo_A = new Arreglo(num_elementos_arreglo,"arreglo A");
        Arreglo arreglo_B = new Arreglo(num_elementos_arreglo,"arreglo B");
        Arreglo arreglo_C = new Arreglo(num_elementos_arreglo,"arreglo C");

        crearHiloAyB(num_hilos_arreglo_A,arreglo_A);
        crearHiloAyB(num_hilos_arreglo_B,arreglo_B);
        crearHiloC(num_hilos_arreglo_C,arreglo_A,arreglo_B,arreglo_C);
        
        sleep(30);
        arreglo_A.imprimirDatos();
        arreglo_B.imprimirDatos();
        arreglo_C.imprimirDatos();
        exit(0);
    }
    public static void crearHiloAyB(int num_hilos_arreglo,Arreglo arreglo){
        if(arreglo.nombre=="arreglo A"){
            for (int i=0;i<num_hilos_arreglo;i++){
                Lectura productor = new Lectura(arreglo);
                productor.setName("A_productor "+i);
                productor.setPriority(7);
                productor.start();
            }
        }else if(arreglo.nombre=="arreglo B"){
            for (int i=0;i<num_hilos_arreglo;i++){
                Lectura productor = new Lectura(arreglo);
                productor.setName("B_productor "+i);
                productor.setPriority(7);
                productor.start();
            }
        }
    }

    public static void crearHiloC(int num_hilos_arreglo,Arreglo arregloA,Arreglo arregloB,Arreglo arregloC){
            for (int i=0;i<num_hilos_arreglo;i++){
                SumaC productor = new SumaC(arregloA, arregloB, arregloC);
                productor.setName("C_sumador"+i);
                productor.start();
            }
    }
}