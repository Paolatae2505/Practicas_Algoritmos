
class OrdenamientoQuick :

    def QuickSortFirst(self,S,a,b) :
        
        j = 0
        if a <= b :
            j = self.Partition(S,a,b)
            self.QuickSortFirst(S,a,j-1)
            self.QuickSortFirst(S,j+1,b)
    
    def Partition(self,S,a,b) :
        i = a +1
        j = b

        while S[i] < S[j] :
          i = i +1

        while S[j] > S[i] :
          j = j - 1
        
        while i < j :
            temp = S[i]
            S[i] = S[j]
            S[j] = temp

            i = i +1 
            j = j -1

            while S[i] < S[a] :
                i = i + 1
            while S[j] > S[a] :
                j = j -1 
        
        if a < j :
            temp2 = S[a]
            S[a] = S[j]
            S[j] = temp2
        
        return j


