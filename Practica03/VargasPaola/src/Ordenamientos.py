from ListaDoble import ListaDoble
import math
import random

""" 
- Analisis de Agoritmos (2023-1)
- Alumna :
- Vargas Bravo Paola 318074755
"""

class Ordenamientos :

 """
    Clase que contiene los metodos de ordenamiento y generamiento 
    de zigzag
    Atributos:
    contCom -- Contador de operaciones de Comparacion
    contOpAr -- Contador de operaciones Aritmeticas
    contAsig -- Contador de operaciones de Asignacion
 """

 contCom = 0
 contOpAr = 0
 contAsig = 0
     

 def InsertionSort2(self,A,n) :
      """ Aplicar el algortimo de InsertionSort

        Args:
        A -- lista incial
        n -- numero de elementos

      """
      self.contCom = self.contCom + 1 #i en el rango de 1 a n antes del for
      for i in range(1, n):
        self.contOpAr = self.contOpAr + 1 # por el aumento de i ++
        self.contCom = self.contCom  + 1 #i en el rango de 1 a n en el for
        temp = A[i]
        self.contAsig = self.contAsig + 1 #Asignacion de temp
        j = i - 1 
        self.contAsig = self.contAsig + 1 #Asignacion de j
        self.contOpAr = self.contOpAr+ 1 #rest de j - 1

        self.contCom = self.contCom  + 1 #Antes del While j >= 0
        self.contCom = self.contCom  + 1 #Antes del While temp < A[j]
        while j >= 0 and temp < A[j]:
            self.contCom = self.contCom  + 1 #En el While j >= 0
            self.contCom = self.contCom  + 1 #En el  While temp < A[j]
            A[j + 1] = A[j]
            self.contAsig = self.contAsig + 1 #Asignacion de A[j+1]
            j = j - 1
            self.contAsig = self.contAsig + 1 #Asignacion de j
            self.contOpAr = self.contOpAr + 1 #rest de j - 1
        A[j + 1] = temp
        self.contAsig = self.contAsig + 1 #Asignacion de A[j+1]
      return A

 def LocalInsertionSort(self,A,n) :
    """ Aplicar el algortimo de LocalInsertionSort

        Args:
        A -- lista incial
        n -- numero de elementos

    """
    self.contAsig = 0
    self.contCom = 0
    self.contOpAr = 0
    self.contAsig = self.contAsig + 2 #Asignaciones nuevoValor, ui
    bi_list  = ListaDoble()
    nuevoValor = A[0]
    bi_list.insertarNodo(nuevoValor)
    ui = A[0]
    self.contCom = self.contCom + 1 #i en el rango de 1 a n antes del for
    for i in range(0, n ):
        self.contOpAr = self.contOpAr + 1 # por el aumento de i ++
        self.contCom = self.contCom + 2 #i en el rango de 1 a n antes del for y ui < A[i]
        if ui < A[i] :
            bi_list.insertar_right(ui,A[i])
        else :
            bi_list.insertar_left(ui,A[i])
    return A
        
 def GenerarListaZigZag (self,n,k) :

    """ Aplicar el algortimo de GenerarListaZigZag

        Args:
        A -- lista incial
        k -- zigzag

    """
    A = []
    contador = 0
    xAux = n / 2 
    x = math.floor(xAux)
    randomX = random.randint(x, n)
    x1 = randomX
    x2 =  randomX
    b = True 
    for i in range (1, n+1) :
         if b ==   True :
            
            x1 = x1 + 1
            A.append(x1)
         else :
            
            x2 = x2 - 1
            A.append(x2)
         contador = contador + 1

         if(contador >= k) :
            b = not b
            contador = 0
    
    return A
                

     