public class Arreglo{
    int indice;
    private int[] arr;
    boolean hay_espacio = true;
    int num_elementos_arreglo;
    String nombre;
    int dato;
    
    public Arreglo(int num_elementos_arreglo, String nombre){
        this.num_elementos_arreglo=num_elementos_arreglo;
        arr=new int[num_elementos_arreglo];
        indice = -1;
        this.nombre = nombre;
    }

    public synchronized boolean almacenar(int numero_a_almacenar, String hilo_nombre){
        while(hay_espacio == false){
            try {
                wait();    
            } catch (InterruptedException e) {}  
        }
        indice=getIndice(); 
        System.out.println("\tAlmacena "+hilo_nombre+": indice = "+indice +" --> "+ numero_a_almacenar);
        arr[indice]=numero_a_almacenar;
        
        if(indice >= num_elementos_arreglo-1){ 
            hay_espacio=false;
            System.out.println(hilo_nombre+" : No registro su muestra:, ya no hay espacio...  :c");    
        } 
        
        notifyAll();
        
        return hay_espacio;
    }
    
    public synchronized void almacenar(int casilla,int numero_a_almacenar, String hilo_nombre){
        while(hay_espacio == false){
            try {
                wait();   
            } catch (InterruptedException e) {}  
        }
        if(numero_a_almacenar!=100){
            System.out.println("\tAlmacena "+hilo_nombre+": indice = "+casilla +" --> "+ numero_a_almacenar);
        arr[casilla]=numero_a_almacenar;
        }
        if(casilla >= num_elementos_arreglo-1){ 
            hay_espacio=false;
        }
        notifyAll();
    }

    public synchronized void imprimirDatos(){
        System.out.println("\nEn el "+nombre+" se tiene: \n");
        for (int i = 0; i < arr.length; i++)
                System.out.println("\n\t["+i+"] = "+ arr[i]);
    }
    
    public synchronized int getIndice(){
        if(indice==num_elementos_arreglo){
            indice=num_elementos_arreglo;
        } 
        if(indice<num_elementos_arreglo){
            indice++;
        } 
        return indice;
    }
    
    public synchronized int getDato(int casilla){
        dato=arr[casilla];
        return dato;
    }
}