class SumaC extends Thread{
    private Arreglo arreglo_A;
    private Arreglo arreglo_B;
    private Arreglo arreglo_C;
    private int resultado_suma;
    int indice;

    public SumaC(Arreglo arreglo_A , Arreglo arreglo_B , Arreglo arreglo_C){
        this.arreglo_A = arreglo_A;
        this.arreglo_B = arreglo_B;
        this.arreglo_C = arreglo_C;
    }

    @Override
    public void run(){ 
        while(arreglo_C.indice<arreglo_C.num_elementos_arreglo){
            arreglo_C.indice=arreglo_C.getIndice();
            if(arreglo_C.indice==arreglo_C.num_elementos_arreglo){
                System.out.println(" estoy lleno ");
            }else{
                
                resultado_suma = arreglo_A.getDato(arreglo_C.indice) + arreglo_B.getDato(arreglo_C.indice);
                System.out.println("-----------------get indice"+arreglo_C.indice+"   "+arreglo_C.num_elementos_arreglo+"   "+ arreglo_A.getDato(arreglo_C.indice)+"   "+arreglo_B.getDato(arreglo_C.indice)+"+++++++++++++++"+resultado_suma);
                arreglo_C.almacenar(arreglo_C.indice,resultado_suma, getName()); 
            }
            
            
            
        }
    
    }            
}