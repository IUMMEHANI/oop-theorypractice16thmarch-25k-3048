# oop-theorypractice16thmarch-25k-3048
Practice for oop theory 16th march exercise.
Suppose that you are required to develop an Account Management System for a shop selling
watches in Karachi to calculate overall tax, retail price, and profit from the sales.
All watches have 15% import duty tax from the capital cost that needs to be paid to Pakistan
Customs.
Sales tax rules are as follows:
 Luxury Watch: 10% sales tax from capital cost
 Non-Luxury Watch: 6.5% sales tax from capital cost
The seller requires 75% profit from the total cost (capital cost + import duty + sales tax).
Finally, 6% Goods and Services Tax (GST) is added to determine the retail price of the watch.
For all watches, customers must register:
 Customer Name
 Customer Address
Consider the given class diagram below and implement the following parts:

Tasks:
a) Identify Attributes and Functions
Identify all attributes and methods required in each class to implement the given scenario.
Your design must include:
 Watch details
 Customer details

 Cost information
 Tax calculations
 Retail price calculation
Also indicate which attributes should be:
 static
 final (constant)
 abstract methods
b) Class Implementation
Implement the following classes in Java:
1. Watch (Abstract Class)
2. LuxuryWatch (Derived Class)
3. NonLuxuryWatch (Derived Class)
Your implementation must demonstrate the following concepts:
 Inheritance
 Method Overriding (sales tax calculation must differ for each watch type)
 Method Overloading (create overloaded versions of price calculation)
c) Prevent Instantiation of Watch
How can you ensure that an object of class Watch cannot be created directly?
Explain the Java concept used and why it is suitable in this scenario.
d) Track Total Watches Produced
The shop wants to maintain a count of all watches created.
Provide a mechanism such that:
 The count increases whenever a new watch object is created
 Separate counters are maintained for:
o Luxury Watches
o Non-Luxury Watches

Explain which Java feature is used to achieve this.

e) Constant Watch ID
Create a constant attribute named:
Watch_ID
in the Watch class.
Requirements:
 It must be declared using final
 It must be initialized through the constructor
 Every watch object must have its own unique Watch_ID
 The value cannot be modified later
Provide the implementation.
f) Interface Implementation
Create an interface named:
TaxCalculator
which declares the following methods:
double calculateImportDuty();
double calculateSalesTax();
double calculateGST(double amount);
Ensure that the appropriate classes implement this interface.
