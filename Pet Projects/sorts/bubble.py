from tkinter import *
import random as r

class sort:
        # bubblesort #########################################################################
    def bubble_sort(self, data):
        m = len(data)
        comparisons = 0
        swaps = 0
        swapped = True
        while swapped is True:
            swapped = False
            for i in range(1, m-1):
                if(data[i-1] > data[i]):
                    data[i-1], data[i] = data[i], data[i-1]
                    swapped = True
                    comparisons = comparisons + 1
                    swaps = swaps + 1
                else:
                    comparisons = comparisons + 1
                    
        print("comparisons: " + str(comparisons) + " swaps: " + str(swaps))           
        return data
        
        # mergesort #########################################################################       
    def merge_sort(self, data):
        if len(data) <= 1:
            return data
                
        left = []
        right = []
            
        for i, x in enumerate(data):
            if i % 2 != 0:
                left.append(x)
            else:
                right.append(x)
                    
                    
        left = self.merge_sort(left)
        right = self.merge_sort(right)          
        return self.merge(left, right)
                
        # mergesort merge                
    def merge(self, left, right):
        result = []
            
        while len(left) != 0 and len(right) != 0:
            if left[0] <= right[0]:
                result.append(left[0])
                left = left[1:len(left)]
            else:
                result.append(right[0])
                right = right[1:len(right)]
                    
                    
        while len(left) != 0:
            result.append(left[0])
            left = left[1:len(left)]
        while len(right) != 0:
            result.append(right[0])
            right = right[1:len(right)]    
            
        return result            

        # quick sort #########################################################################
    def quicksort(self, data, p):
        if len(data) <= 1 or p > len(data):
            
            return data
            
        else:
            
            p = p + 1
            cp = p + 1
            
            while cp < len(data):
                
                #print("p: " + str(p) + " cp: " + str(cp))
                
                if data[cp] > data[p]:
                
                    cpv = data.pop(cp)
                    data.insert(p, cpv)
                    #print("swapped cp:" + str(cp) + " > p:" + str(p) + " " + str(len(data)))
                    
                else:
                
                    cp = cp + 1
                
        return self.quicksort(data, p) 
        
            
                    

class main:
    sort = sort()
    master = Tk()
    
    number_of_elements = 900

    w = Canvas(master, width=1920, height=1080)
    w.pack()

    data = []
    for index in range(0, number_of_elements):
        data.append(r.randint(0,1080))
        

    #data = sort.merge_sort(data)
    data = sort.quicksort(data, -1)
    #data.sort()

    x1 = 0
    i = 0
    while i <= len(data):
        x2 = x1 + (1920 / number_of_elements)
        w.create_rectangle(x1, 0, x2, data[i-1], fill='white')
        x1, i = x2, i+1
    
    mainloop()


m = main()

