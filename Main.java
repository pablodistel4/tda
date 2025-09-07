import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s= sc.nextLine();
            int respuesta= l_lindo(n,s);
            t--;
            }
        
    }
    
    public static int l_lindo (int tamanio, String arreglo ){
        int res;
        if (tamanio==1 && arreglo.charAt(0)=='a'){
            res=0;}
        
        else if  (tamanio==1 && arreglo.charAt(0)!='a'){
            res= 1;
        }
        else{
         res= hacerlindo (arreglo,'a',0,tamanio-1);

        
        }
        System.out.println(res);
        return res;
        

    }

    public static int hacerlindo(String arreglo,char letra, int inicio, int fin){
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
        if (letraenizq[0]>letrader[0] /* || (letraenizq[0]==letrader[0] && letraenizq[1]<=letrader[1]) */){
            cambiosenizq= (mitad-1-inicio+1)- letraenizq[0];
            cambiosender= hacerlindo(arreglo,sig,mitad,fin);
        }
        if (letraenizq[0]<letrader[0] /*|| (letraenizq[0]==letrader[0] && letraenizq[1]>letrader[1])*/){
            cambiosenizq= hacerlindo(arreglo,sig,inicio,mitad-1);
            cambiosender= (fin-mitad+1)- letrader[0];
        }
        if (letraenizq[0]==letrader[0]){
            int semicambiosenziq= hacerlindo(arreglo,sig,inicio,mitad-1);
            int semicambiosender= hacerlindo(arreglo,sig,mitad,fin);

            if (semicambiosender>=semicambiosenziq){
                cambiosenizq= hacerlindo(arreglo,sig,inicio,mitad-1);
                cambiosender= (fin-mitad+1)- letrader[0];
            }
            if (semicambiosender<semicambiosenziq){
                cambiosenizq= (mitad-1-inicio+1)- letraenizq[0];
                cambiosender= hacerlindo(arreglo,sig,mitad,fin);
            }
        }
        
 

        
       // System.out.println("der:"+ cambiosender);
       // System.out.println("izq:"+ cambiosenizq);
        return cambiosender+cambiosenizq;
    

        
    }
    public static int[] cantletras(String arreglo,char letra,char sig ,int inicio, int fin){
        int[] res={0,0};
        //char[] letrasdistintas= new char[arreglo.length()];
        //int nuevoelem=0;

        for (int i= inicio;i<=fin;i++){
            char nletra= arreglo.charAt(i);
            if (nletra==letra){
                res[0]+=1;
            }

            if (nletra==sig /*&& pertenece(nletra,letrasdistintas)==false*/){
                res[1]+=1;
                //letrasdistintas[nuevoelem]=nletra;
                //nuevoelem++;


            }

        }
        return res;
    }
    public static boolean pertenece ( char n, char[] ns){
        int j=0;
        while (j<ns.length){
            if (ns[j]==n)
                return true;
        j++;
        }
        return false;
        
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