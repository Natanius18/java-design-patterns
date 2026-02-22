# Template Method

## Intent

Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override
specific steps of the algorithm without changing its structure.

## Detailed Explanation of Template Method Pattern with Real-World Examples

Real-world example

> A real-world analogy for the Template Method pattern can be seen in the preparation of a cup of tea or coffee. The overall process
> (algorithm) is the same: boil water, brew the beverage, pour into cup, and add condiments. However, the specific steps of brewing the
> beverage differ. For tea, you steep the tea leaves in hot water, while for coffee, you brew ground coffee beans. The Template Method
> pattern
> encapsulates the invariant steps of the process (boiling water, pouring, adding condiments) in a base class, while allowing subclasses to
> define the specific brewing steps, thus ensuring the overall structure of making a hot drink is consistent while allowing customization
> where needed.

In plain words

> The Java Template Method pattern outlines the core steps in the parent class, allowing child classes to tailor detailed implementations,
> enhancing code reusability and design flexibility in Java programming.


![Template Method Pattern sequence diagram](./etc/template.png)

## When to Use the Template Method Pattern in Java

The Template Method pattern should be used

* To implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary
* When common behavior among subclasses should be factored and localized in a common class to avoid code duplication. You first identify the
  differences in the existing code and then separate the differences into new operations. Finally, you replace the differing code with a
  template method that calls one of these new operations
* To control subclasses extensions. You can define a template method that calls "hook" operations at specific points, thereby permitting
  extensions only at those points

## Real-World Applications of Template method Pattern in Java

* Java's AbstractList and AbstractSet classes in the Collections Framework use the Template Method pattern to define common algorithms for
  list and set operations.
* Frameworks like JUnit use Template Method to define the setup and teardown process in test cases.

## How to Implement

1. Analyze the target algorithm to see whether you can break it into steps. Consider which steps are common to all subclasses and which ones
   will always be unique.
2. Create the abstract base class and declare the template method and a set of abstract methods representing the algorithm’s steps. Outline
   the algorithm’s structure in the template method by executing corresponding steps. Consider making the template method final to prevent
   subclasses from overriding it.
3. It’s okay if all the steps end up being abstract. However, some steps might benefit from having a default implementation. Subclasses
   don’t have to implement those methods.
4. Think of adding hooks between the crucial steps of the algorithm.
5. For each variation of the algorithm, create a new concrete subclass. It must implement all of the abstract steps, but may also override
   some of the optional ones.

## Pros and Cons

| Pros                                                                                                                                                    | Cons                                                                                                             |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| You can let clients override only certain parts of a large algorithm, making them less affected by changes that happen to other parts of the algorithm. | Some clients may be limited by the provided skeleton of an algorithm.                                            |
| You can pull the duplicate code into a superclass.                                                                                                      | You might violate the Liskov Substitution Principle by suppressing a default step implementation via a subclass. |
|                                                                                                                                                         | Template methods tend to be harder to maintain the more steps they have.                                         |
