
#ej 3

def izquierdadominante (a:list[int])-> bool:
    if (len(a)<=1):
        return True
    
    elif (len(a)==2):
        return a[0]>a[1]
    
    else:
        mitadizq: list[int]  = a[0:len(a)//2:1]
        mitader: list[int] = a[len(a)//2:len(a):1]
        res:bool=(esizquierdista(a) and izquierdadominante(mitader) and izquierdadominante(mitadizq))
        print(res)
        return res

def esizquierdista(a: list[int])-> bool:
    izq: list[int]  = a[0:len(a)//2:1]
    der: list[int] = a[len(a)//2:len(a):1]

    return sumatoria(izq)>=sumatoria(der)


def sumatoria(a: list[int])-> int:
    res:int = 0

    for n in a:
        res+=n
    return res

        
prueba1 = [4,3,3,7]

#izquierdadominante(prueba1)
        
# ej 4



def IndiceEspejo(a: list[int], inicio:int, fin:int)->bool:
    if (len(a)==0): return False
    elif (fin-inicio+1==1): return (a[inicio]==inicio)

    else: 
        medio:int = (inicio+fin)//2

        if (a[medio]==medio): return True

        elif (a[medio]>medio): return IndiceEspejo(a,inicio,medio-1)

        else: IndiceEspejo(a,medio+1,fin)
        # elif (a[medio]>fin-1):
        #     return IndiceEspejo(a,inicio,medio-1)
        # elif (a[medio]<inicio):
        #     return IndiceEspejo(a,medio+1,fin)
        # else:
        #     return IndiceEspejo(a,inicio,medio-1) or IndiceEspejo(a,medio+1,fin)
        



#la cuestion aca es que si a[medio]> medio ya no existe la posibilidad de que se encuentre 
# en el lado derecho por ser estrictamente creciente, no dan las casillas


#ej 5

def potencialogaritimica(a:int, b: int)-> int:
    if (b==1): 
        v:int= a
        print(v)
        return v
    
    elif (b%2==0): 
        v:int = potencialogaritimica(a,b//2)
        print (v*v)
        return v*v
        
    else: 
        v:int=a* potencialogaritimica(a,b-1)
        print (v)
        return v 


#potencialogaritimica(3,7)
#ej 6


def maximomontania(a:list[int],inicio:int, fin:int)->int:
    if fin==inicio: return a[inicio]
    medio:int=(inicio+fin)//2


    if (a[medio]>a[medio+1] and a[medio]>a[medio-1]):
        print(a[medio]) 
        return a[medio]

    elif (a[medio]>a[medio+1] and a[medio]<a[medio-1]): 
        fin=medio-1
        #suba: list[int]= a[0:medio:1]

    elif (a[medio]<a[medio+1] and a[medio]>a[medio-1]):
        inicio=medio+1
        #suba: list[int]= a[medio:len(a):1]

     
    return maximomontania(a,inicio,fin)


l1=  [ - 1, 3, 8, 22, 30, 22, 8, 4, 2, 1]

maximomontania(l1,0,len (l1)-1)



    


