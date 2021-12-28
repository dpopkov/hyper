## Stage 3/5: Tickets

### Description

When choosing a ticket you are guided not only by your space preference but also by your finances. 
Let's implement the opportunity to check the ticket price and see the reserved seat.

### Objectives

Read two positive integer numbers that represent the number of rows and seats in each row and print the seating 
arrangement like in the first stage. Then, read two integer numbers from the input: 
a row number and a seat number in that row. 
These numbers represent the coordinates of the seat according to which the program should print the ticket price. 
The ticket price is determined by the same rules as the previous stage:

* If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
* In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. 
Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, 
and the second half is the last 5 rows.

After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.


## Stage 4/5: Menu, please!

### Description

The theatre is getting popular, and the customers started complaining that it's not practical that the program 
stops after buying one ticket. Let's add a menu that will allow them to buy tickets and display the current 
state of the seating arrangement when needed.

### Objectives

At the start, your program should read two positive integer numbers that represent the number of rows and seats 
in each row. Then, it should print a menu with the following three items:

* _Show the seats_ should print the current seating arrangement. 
The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
* _Buy a ticket_ should read the seat coordinates from the input and print the ticket price like in the previous stage. 
After that, the chosen seat should be marked with a B when the item _Show the seats_ is called.
* _Exit_ should stop the program.
