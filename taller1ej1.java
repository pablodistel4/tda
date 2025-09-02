
class Main{

    int l_lindo (int tamanio, String arreglo ){
        

        int res= hacerlindo (arreglo,'a',0,tamanio-1);

        System.out.println(res);
        return res;
        
    }

    int hacerlindo(String arreglo,char letra, int inicio, int fin){
        if (fin-inicio==0 && arreglo.charAt(inicio)==letra){
            return 0;
        }
        else if (fin-inicio==0 && arreglo.charAt(inicio)!=letra){
            return 1;
        }
        int cambiosenizq=0;
        int cambiosender=0;

        

        int mitad= (inicio+fin+1)/2;
        char sig= (char) (letra+1);
        int[] letraenizq=cantletras(arreglo,letra,sig,inicio,mitad-1);
        int[] letrader= cantletras(arreglo,letra,sig,mitad,fin);
        
        //imprimirsubsecuencia(arreglo,inicio,fin);
        if (letraenizq[0]>letrader[0] || (letraenizq[0]==letrader[0] && letraenizq[1]<=letrader[1])){
            cambiosenizq= (mitad-1-inicio+1)- letraenizq[0];
            cambiosender= hacerlindo(arreglo,sig,mitad,fin);
        }
        if (letraenizq[0]<letrader[0] || (letraenizq[0]==letrader[0] && letraenizq[1]>letrader[1])){
            cambiosenizq= hacerlindo(arreglo,sig,inicio,mitad-1);
            cambiosender= (fin-mitad+1)- letrader[0];
        }
        
 

        
       // System.out.println("der:"+ cambiosender);
       // System.out.println("izq:"+ cambiosenizq);
        return cambiosender+cambiosenizq;
    

        
    }
    int[] cantletras(String arreglo,char letra,char sig ,int inicio, int fin){
        int[] res={0,0};
        

        for (int i= inicio;i<=fin;i++){
            if (arreglo.charAt(i)==letra){
                res[0]+=1;
            }
            if (arreglo.charAt(i)==sig){
            res[1]+=1;
            }

        }
        return res;
    }
    // void imprimirsubsecuencia(String arreglo, int inicio, int fin){
    //     String imp="";

    //     for (int i=inicio;i<=fin;i++){
    //         imp= imp + arreglo.charAt(i);
    //     };
        //System.out.println(imp);
    //}
    //  public static void main(String[] args) {
    //     Main obj = new Main();
    //     String arreglo = "ccddaabb";
    //     int tamanio = 8;
    //     int resultado = obj.l_lindo(tamanio, arreglo);
    //     System.out.println(arreglo);
    //     System.out.println("Resultado: " + resultado);
    //  }
}


//[1,2,3,4,5,6,7,8]
//[1,2,3,4]