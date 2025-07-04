
# JAVA E-commerce System

This is a Java-based solution for Full Stack Development Internship challenge. The system simulates a basic e-commerce platform with product management, shopping cart functionality, and checkout processing with shipping support.


## Features

* **Product Types**
    * Basic Products.
    * Deliverable Products (with weight).
    * Expirable Products (with expiration date).
    * Non-Deliverable Products (e.g., digital items).

* **Shopping Cart**
  * Add items with a specific quantity (not exceeding stock).
  * Prevent adding expired products.
  * Enforces unique stock constraints.

* **Checkout**
  * Validates cart is not empty.
  * Verifies customer has sufficient balance.
  * Displays:
    * Order subtotal
    * Shipping cost
    * Total paid amount
    * Customer balance after payment

* **Shipping Service**

  * Collects deliverable items.
  * Calculates total weight.
  * Prints shipment notice in a formatted way.

## Console Output Example

```
** Shipment notice **
1x Laptop       2000g
2x Phone        600g
1x Tablet       500g
5x Milk         5000g
10x Bread               5000g
Total package weight 13.100kg

** Checkout notice **
1x Laptop       1500.00
2x Phone        1000.00
1x Tablet       800.00
5x Milk         10.00
10x Bread               10.00
3x Book         60.00
20x Phone Card          200.00
-------------------

Subtotal: 3580.00
Shipping cost: 393.00
Total: 3973.00
```

## Validations

* Empty cart cannot be checked out.
* Insufficient customer balance throws an error.
* Expired or out-of-stock items are blocked during checkout.


## Assumptions

* Shipping fee is calculated based on weight ( 30 EGP per kg).


## Notes

* Implemented entirely in Java.
* Designed with modularity and clarity in mind.
* Fully covers edge cases and testable behavior.
