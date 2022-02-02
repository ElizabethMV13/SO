class Lectura extends Thread{
    private Arreglo arreglito;
    int numero_a_almacenar;
    
    public Lectura(Arreglo arreglito){
        this.arreglito = arreglito;
    }

    @Override
    public void run(){
       
        while(arreglito.hay_espacio==true){         
            numero_a_almacenar = (int)( Math.random()*100 );
            System.out.println("Hilo :"+getName()+" genero "+numero_a_almacenar);
            arreglito.hay_espacio=arreglito.almacenar(numero_a_almacenar, getName());
            if(arreglito.hay_espacio==false) break;
        }

    }
}