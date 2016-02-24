import tkinter as tk
#from tkinter import *

class App(tk.Frame):
    def __init__(self, master=None):
        tk.Frame.__init__(self, master)
        self.grid()
        self.createWidgets()

    def createWidgets(self):
        self.quitButton = tk.Button(self, text='Quit', command=self.quit())
        self.quitButton.grid()
        
        
app = App()
app.master.title('example')
app.mainloop()