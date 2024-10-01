from Ordenamientos import Ordenamientos
from ListaDoble import ListaDoble
import math


""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755
"""

def main():

    x = 0
    while x < 1 :

        print("--------------------------------------------------------")
        print("-------      Digite el tamaño del ejemplar        ------")
        print("--------------------------------------------------------")
        print("-- Nota : Si tu numero es neg se tomara como positivo --")
        print("--------------------------------------------------------")
        #n = int(input())
        except1 = False
        while(except1 == False) :
         try :
          n = int(input())
         except Exception as ex:
          print("Por favor digite una numero", type(ex))
         else :
            except1 = True
        n = abs(n)
        esCorrecto = False
        ## Por deafult no se podrian generar listas de ZigZag con 1 elemento
        ## Por ser muy trivial
        while(esCorrecto == False) :
             print("--------------------------------------------------------")
             print("-------    Digite una k tal que 1 <= k <= n/2  ---------")
             print("--------------------------------------------------------")
             print("-- Nota : Si tu numero es neg se tomara como positivo --")
             print("--------------------------------------------------------")
             except1 = False
             while(except1 == False) :
              try :
                k = int(input())
              except Exception as ex:
               print("Por favor digite una numero", type(ex))
              else :
                except1 = True
             k = abs(k)  
             mitad = n /2 
             math.floor(mitad)
             mitad2 = int (mitad)
             if k >= 1 and k <= mitad2 :  
                esCorrecto = True       
        a = Ordenamientos()
        print("--------------------------------------------------------")
        print("-- La zigzaglista es :")
        print("--------------------------------------------------------")   
        zigzag =  a.GenerarListaZigZag(n,k)
        print(zigzag)
        print("--------------------------------------------------------")
        print("-- Ordenamiento Insertion Sort :")
        print("--------------------------------------------------------")
        insertionSortA2 = a.InsertionSort2(zigzag,n)
        print(insertionSortA2)
        print("Numero de Operaciones Elementales: ")
        x1 = a.contAsig 
        x2 = a.contCom
        x3 = a.contAsig
        res = x1 + x2 + x3
        print(res)
        print("--------------------------------------------------------")
        print("-- Ordenamiento Local Insertion Sort :")
        print("--------------------------------------------------------")
        localInsertionSort = a.LocalInsertionSort(zigzag,n)
        print(localInsertionSort)
        x4 = a.contAsig 
        x5 = a.contCom
        x6 = a.contAsig
        res2 = x4 + x5 + x6
        print("Numero de Operaciones Elementales: ")
        print(res2)


if __name__ == "__main__":
    main()       