from Tkinter import *		#0
root=Tk()                      #1
root.title("demo")             #2
l=Label(root, text="Hello World", width=20)  #3
l.pack()                       #4
root.mainloop()                #5

"""
Step 0 : Import classes from Tkinter module
Step 1 : Create a tk root widget. This is created in almost all programs. It acts
as a parent to all the widgets and is a simple window with a title bar.
Step 2 : Set the title.
Step 3 : Create a label using Label class with root as its parent widget.
Step 4 : Call the pack method on the widget which tells it to size itself to fit the given text and make itself visible.
Step 5 : Enter the Tkinter main loop.

http://www.linuxforu.com/2011/03/quickly-write-gui-using-python/
"""
