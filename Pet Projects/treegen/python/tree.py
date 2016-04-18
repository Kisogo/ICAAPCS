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

class tree:
    
    # create a new tree root.
    def root(self, index):
        magnitude = 1
        direction = 0

    # extend trunk or root.
    def trunk(self, root):
        magnitude = r.random(2,5)
        direction = r.random(-10,10)

    # branch from root.
    def branch(self, root):
        branches = r.random(1,3)
        
        for b in range(1, branches):
            magnitude = r.random(1,10)
            direction = r.random(-30,30)
            
    # commit this object
    def commit(self, index, xy1, xy2):
        

class main:
    tree = tree()
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

