import java.util.Scanner;

public class taller1ej1{
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

        

        int mitad=inicio+(fin-inicio)/2;
        char sig= (char) (letra+1);
        int distintasizq=cantletrasdistintas(arreglo,letra,inicio,mitad);
        int distintasder= cantletrasdistintas(arreglo,letra,mitad+1,fin);
        
        //imprimirsubsecuencia(arreglo,inicio,fin);
        if (distintasizq<distintasder /* || (distintasizq[0]==distintasder[0] && distintasizq[1]<=distintasder[1]) */){
            cambiosenizq= distintasizq;
            cambiosender= hacerlindo(arreglo,sig,mitad+1,fin);
        }
        if (distintasizq>distintasder /*|| (distintasizq[0]==distintasder[0] && distintasizq[1]>distintasder[1])*/){
            cambiosenizq= hacerlindo(arreglo,sig,inicio,mitad);
            cambiosender= distintasder;
        }
        if (distintasizq==distintasder){
            int semicambiosenziq= hacerlindo(arreglo,sig,inicio,mitad);
            int semicambiosender= hacerlindo(arreglo,sig,mitad+1,fin);

            if (semicambiosender>=semicambiosenziq){
                cambiosenizq= semicambiosenziq;
                cambiosender= distintasder;
            }
            if (semicambiosender<semicambiosenziq){
                cambiosenizq= distintasizq;
                cambiosender= semicambiosender;
            }
        }
        
 

        
       // System.out.println("der:"+ cambiosender);
       // System.out.println("izq:"+ cambiosenizq);
        return cambiosender+cambiosenizq;
    

        
    }
    public static int cantletrasdistintas(String arreglo,char letra,int inicio, int fin){
        //int[] res={0,0};
        //char[] letrasdistintas= new char[arreglo.length()];
        //int nuevoelem=0;
        int res=0;
        for (int i= inicio;i<=fin;i++){
            char nletra= arreglo.charAt(i);
            if (nletra!=letra){
                res+=1;
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