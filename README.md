# Clean Architecture
Notes on the book "Clean Architecture" by Uncle Bob

## Paradigms
#### Structured Programming
- remove goto
- decompose program 
- assignment, loops, functions

#### OOP
- encapsulation
- inheritance
- polymorphism
  - enables Dependency inversion  

#### Functional Programming
- immutability

## SOLID
- Single-Responsibility Principle: there should only be one reason to change the class/module
- Open-Closed Principle: code should be easy to change by **adding** new code, instead of modifying
- Liskov Substitution Principle: any implementation of the contract/interface should be a valid substitute
- Interface Segregation Principle: dont depend on interface that you dont use
- Dependency Inversion Principle: high-level concepts should not depend on low-level details
