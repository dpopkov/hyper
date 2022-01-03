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


## Stage 5/5: Errors! 

### Description

Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. 
The stats will show the current income, total income, the number of available seats, 
and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience: 
it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

### Objectives

Now your menu should look like this:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

When the item Statistics is chosen, your program should print the following information:

* The number of purchased tickets;
* The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
* Current income;
* The total income that shows how much money the theatre will get if all the tickets are sold.

The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow 
a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter 
different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates 
that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates 
until the user picks an available seat.
