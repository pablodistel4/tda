

entrada = input() 
x, y = map(int, entrada.split())



def convertibilidad (x:int, y:int ):
    
    res: list[int]=conversion(x,y,[])
    if (res!=[]):
        print ("YES")
        print (len(res))
        imprimirsecuencia(res)
    
    if (res==[]):
        print ("NO")

def conversion (x:int,y:int,pasos: list[int])->list[int]:
    if (x==y):
        return (pasos+ [y])
    
    if (x>y):
        return []
    
    camino1:list[int]=conversion (x*2,y,pasos + [x])
    camino2:list[int]=conversion ((x*10)+1,y,pasos + [x])

    if (camino1==[] and camino2 != []):
        return camino2
    elif (camino1!=[] and camino2 == []):
        return camino1
    
    elif (camino1==[] and camino2 == []):
        return []
    elif (camino1!=[] and camino2 != []):
        return camino1
    
    
def imprimirsecuencia(lista:list[int]):
    p:str="" + str(lista[0])

    for n in range(1,len(lista)):
        p= p + " " + str(lista[n])
    
    print(p)

convertibilidad(x,y)
#prueba= [1,2,3]    
#imprimirsecuencia(prueba)

    