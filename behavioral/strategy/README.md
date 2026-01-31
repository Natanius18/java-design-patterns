# Strategy

## Intent

Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their
objects interchangeable.

## Detailed Explanation of Strategy Pattern with Real-World Examples

Real-world example

> A practical real-world example of the Strategy design pattern in Java is evident in car navigation systems, where algorithm flexibility is
> paramount. Different navigation algorithms (such as shortest route, fastest route, and scenic route) can be used to determine the best path
> from one location to another. Each algorithm encapsulates a specific strategy for calculating the route. The user (client) can switch
> between these algorithms based on their preferences without changing the navigation system itself. This allows for flexible and
> interchangeable navigation strategies within the same system.

In plain words

> Strategy pattern allows choosing the best-suited algorithm at runtime.


![Strategy Pattern sequence diagram](./etc/strategy.png)

## When to Use the Strategy Pattern in Java

Use the Strategy pattern when:

* You need to use different variants of an algorithm within an object and want to switch algorithms at runtime.
* There are multiple related classes that differ only in their behavior.
* An algorithm uses data that clients shouldn't know about.
* A class defines many behaviors and these appear as multiple conditional statements in its operations.

## Real-World Applications of Strategy Pattern in Java

* Java's `java.util.Comparator` interface is a common example of the Strategy pattern.
* In GUI frameworks, layout managers (such as those in Java's AWT and Swing) are strategies.

## How to Implement

1. In the context class, identify an algorithm that’s prone to frequent changes. It may also be a massive conditional that selects and
   executes a variant of the same algorithm at runtime.
2. Declare the strategy interface common to all variants of the algorithm.
3. One by one, extract all algorithms into their own classes. They should all implement the strategy interface.
4. In the context class, add a field for storing a reference to a strategy object. Provide a setter for replacing values of that field. The
   context should work with the strategy object only via the strategy interface. The context may define an interface which lets the strategy
   access its data.
5. Clients of the context must associate it with a suitable strategy that matches the way they expect the context to perform its primary
   job.

## Pros and Cons

| Pros                                                                                          | Cons                                                                                                                                                                                                                                                                                                                     |
|-----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| You can swap algorithms used inside an object at runtime.                                     | If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern.                                                                                                                                   |
| You can isolate the implementation details of an algorithm from the code that uses it.        | Clients must be aware of the differences between strategies to be able to select a proper one.                                                                                                                                                                                                                           |
| You can replace inheritance with composition.                                                 | A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces. |
| Open/Closed Principle. You can introduce new strategies without having to change the context. |                                                                                                                                                                                                                                                                                                                          |
