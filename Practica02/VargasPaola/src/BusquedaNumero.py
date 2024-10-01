from random import seed
from random import randint
from random import randrange
import math

from numpy import degrees

""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755
"""

class BusquedaNumero :


    """
    Clase que representa a la busqueda de un numero.
    En la misma se estan los metodos y atributos para 
    la aplicacion de Busqueda Binaria
    Atributos:
    numeroElem -- Numero de Elementos de la secuencia
    movPosicion - Cuantas posiciones un elmento
    """

    contCom = 0
    contOpAr = 0
    contAsig = 0
    ejemplar = []

    def __init__(self , numeroElem, movPosicion) :
        """Inicializa un objeto de BusquedaNumero

        Args:
        numeroElem (int)
        movPosicion (movPosicion)

        """
        self.numeroElem = numeroElem
        self.movPosicion = movPosicion

       
    def generar(self) :
        """Genera una secuencia con numeros Random dada
        la cantidad de numero de elementos dada
        """
        numero = 1
        numero2 = 0
        seed(1)
        ejemplarAux = []
        lista = []
        cotaSuperior = 0
        salto = 3
        while numero <= self.numeroElem :
            numero = numero + 1
            cotaSuperior = cotaSuperior + 40
            random = randrange(0,cotaSuperior,salto)
            salto = salto + 1
            ejemplarAux.append(random)
       
        ejemplarAux.sort()
        print("Secuencia Original ")
        print(ejemplarAux)
    
        while numero2 < self.numeroElem :
             lista.append(numero2)
             numero2 = numero2 + 1
        
        self.__class__.ejemplar = ejemplarAux
        self.moverElemento()
        #self.moverElemento(ejemplarAux)
    
    def moverElemento (self) :
         """Mueve el minimo elemento dado de una secuencia
            movPoiscion veces
         """
       
         if self.numeroElem != 1 :
          if self.movPosicion > 0 and self.movPosicion < self.numeroElem :
          
            self.__class__.ejemplar.insert(self.movPosicion, self.__class__.ejemplar.pop(0))
            #print(self.__class__.ejemplar)
            auxiliar = self.__class__.ejemplar[self.movPosicion +1 : self.numeroElem]
            #print(auxiliar)
            auxiliar2 = self.__class__.ejemplar[0 : self.movPosicion]
            #print(auxiliar2)
            numero = self.__class__.ejemplar[self.movPosicion : self.movPosicion+1]
            #print(numero)
            self.__class__.ejemplar = auxiliar + numero + auxiliar2
            
          if self.movPosicion >= self.numeroElem :
            if  self.movPosicion % 2 == 0  :
             random = randrange(1,self.numeroElem-1,1)
            else :
             random = randrange(0,self.numeroElem-1,2)
            #random = rand(0,self.numeroElem-1)
            self.__class__.ejemplar.insert(random, self.__class__.ejemplar.pop(0))
            auxiliar3 = self.__class__.ejemplar[random +1 : self.numeroElem]
            auxiliar4 = self.__class__.ejemplar[0 : random]
            numero2 = self.__class__.ejemplar[random : random+1]
            self.__class__.ejemplar = auxiliar3 + numero2 + auxiliar4
      
    
    def BBC (self) : 
        """Busqueda Binaria Ciclica, manda a llamar a la funcion
        EncuentraIndice para entonctrar el minimo elemento que cumple
        con lo pedido en la BBC

        Returns:
        Inidice del elemento minimo que cumple con lo pedido por BBC,
        considerando que iniciamos en el indice 1.
        """ 
        print("Secuencia Ciclicamente Ordenada :")
        print(self.__class__.ejemplar)  
        n = self.numeroElem
        p = self.EncuentraIndice(1,n)
        return p
    
    def EncuentraIndice(self, i_izq , i_der) :
        """Encuentra el indice del elemento minimo que cumple con 
           lo pedido por BBC dada su limite inferio = i_izq y su limite
           superior = i_der

         Args :
         i_izq (int)
         i_der (int)
         Returns:
         Inidice del elemento minimo que cumple con lo pedido por BBC,
         considerando que iniciamos en el indice 1.
         NOTA : El numero de operaciones que se consideraron son las que 
         aparecen en el algoritmo de las notas, operaciones extras del como
         se implemento no se contaron 
        """   
        secuencia = []
        secuencia = self.__class__.ejemplar 
        #self.contAsig = self.contAsig + 2
        self.contCom = self.contCom + 1 # comparacion de  i_izq == i_der  (1)
        if i_izq == i_der :
            return i_izq
        else :
            suma = i_izq + i_der
            mitad = suma / 2
            self.contAsig = self.contAsig + 1 # por la asignacion de mitad (1)
            self.contOpAr = self.contOpAr + 2 #por la suma y division (2)
            math.floor(mitad)
            mitad2 = int(mitad)
            i_der2 = int(i_der)
            num1 = secuencia[mitad2-1]
            num2 = secuencia[i_der2-1]
            self.contCom = self.contCom + 1 # comparacion de num1 < num 2  (1)
            if num1  <  num2 :
                return self.EncuentraIndice(i_izq,mitad2)
            else :
                self.contOpAr = self.contOpAr + 1 #por la suma de mitad + 1(1)
                return self.EncuentraIndice(mitad2 + 1,i_der)