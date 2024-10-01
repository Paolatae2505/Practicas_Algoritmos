""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755
"""
class Nodo:

   """
    Clase que representa un nodo
    
   """
   def __init__(self, elemento):
      """ 
         Inicizaliza un nodo dado un elemento
         elemento  --- elemento que envuelve el nodo

      """
      self.elemento = elemento
      self.siguiente = None
      self.anterior = None

""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755
"""

class ListaDoble :

    """
    Clase que representa la Lista Biligada
    
    """
       
    def __init__(self) :

        """ 
         Inicizaliza la lista biligada

        """
        self.cabeza = None
    
    def insertarNodo(self,dato) :

        """ 
         Inserta un nodo en una lista vacia
         dato -- el dato que estara en el nuevo nodo
         
        """
        if self.cabeza is None :
            nuevoNodo = Nodo(dato)
            self.cabeza = nuevoNodo
        else :
            print("La lista no es vacía")

    def insertar_left(self,x,dato) :

        """ 
         Inserta un nodo de el lado izquierdo de un x elemento en la lista
         x -- el elemento referenciado
         dato -- el dato que estara en el nuevo nodo
         
        """
        if self.cabeza is None :
            print("La lista esta vacia")
        else :
            apuntador = self.cabeza
        while apuntador is not None :

            if apuntador.elemento == x :
                break
            apuntador = apuntador.siguiente

        if apuntador is None :
            print("El elemento no se encuentra en la lista")
        else :
            nodoAux = Nodo(dato)
            nodoAux.anterior = apuntador
            nodoAux.siguiente = apuntador.siguiente
        
        if apuntador.siguiente is not None :
            apuntador.siguiente.anterior = nodoAux
        
        apuntador.siguiente = nodoAux
    def insertar_right(self,x,dato) :

        """ 
         Inserta un nodo de el lado derecho de un x elemento en la lista
         x -- el elemento referenciado
         dato -- el dato que estara en el nuevo nodo
         
        """

        if self.cabeza is None :
            print("La lista esta vacia")
        else :
            apuntador = self.cabeza 
            while apuntador is not None :
                if apuntador.elemento == x:
                    break 
                apuntador = apuntador.siguiente
            if apuntador is None :
                print("El elemento no se encuentra en la lista")
            else :
                nodoAux = Nodo(dato)

                nodoAux.siguiente = apuntador
                nodoAux.anterior = apuntador.anterior
                if apuntador.anterior is not None :
                    apuntador.anterior.siguiente = nodoAux

                apuntador.anterior = nodoAux
    def getElement (self,pos) :

        """ 
         Obtiene un elemento de la lista dada la pos
         pos -- index del element a obtener 
         
        """

        if self.cabeza is None :
            print("La lista esta vacia")
        else :
            apuntador = self.cabeza 
            i = 0
            while apuntador is not None :
                if i == pos:
                    return apuntador.elemento
                i = i + 1

        