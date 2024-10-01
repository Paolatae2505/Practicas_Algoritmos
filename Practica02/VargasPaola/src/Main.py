from BusquedaNumero import BusquedaNumero


""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755

"""

def main():

    x = 0
    numeroPosicion = 1
    while x < 1 :
        print("--------------------------------------------------------")
        print("-------      Digite el tamaño del ejemplar        ------")
        print("--------------------------------------------------------")
        print("-- Nota : Si tu numero es neg se tomara como positivo --")
        print("--------------------------------------------------------")
        except1 = False
        while(except1 == False) :
         try :
          tamanio = int(input())
         except Exception as ex:
          print("Por favor digite una numero", type(ex))
         else :
            except1 = True
        tamanio = abs(tamanio)
        busquedaNumero = BusquedaNumero(tamanio,numeroPosicion)
        busquedaNumero.generar()
        p = busquedaNumero.BBC()
        print("El elemento menor se encuentra en la posicion : ")
        print(p)
        print("Numero de Operaciones Aritmeticas : ")
        print(busquedaNumero.contOpAr)
        print("Numero de Comparaciones : ")
        print(busquedaNumero.contCom)
        print("Numero de Asignaciones : ")
        print(busquedaNumero.contAsig)
        total = busquedaNumero.contOpAr + busquedaNumero.contCom + busquedaNumero.contAsig
        print("Numero de Operaciones Totales  : ")
        print(total)
        numeroPosicion += 2
       
if __name__ == "__main__":
    main()       
