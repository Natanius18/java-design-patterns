# Singleton

## Intent

Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

## Detailed Explanation of Singleton Pattern with Real-World Examples

Real-world example

> The government is an excellent example of the Singleton pattern. A country can have only one official government. Regardless of the personal identities of the individuals who form governments, the title, “The Government of X”, is a global point of access that identifies the group of people in charge.

In plain words

> Ensures that only one object of a particular class is ever created.

![Singleton Pattern sequence diagram](./etc/singleton-sequence-diagram.png)


## When to Use the Singleton Pattern in Java

Use the Singleton pattern when

* There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point
* When the sole instance should be extensible by subclassing, and clients should be able to use an extended instance without modifying their code

## Real-World Applications

* The logging class
* Configuration classes in many applications
* Connection pools
* File manager
* [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29)
* [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop--)
* [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager--)

## How to Implement
1. Add a private static field to the class for storing the singleton instance.
2. Declare a public static creation method for getting the singleton instance.
3. Implement “lazy initialization” inside the static method. It should create a new object on its first call and put it into the static field. The method should always return that instance on all subsequent calls.
4. Make the constructor of the class private. The static method of the class will still be able to call the constructor, but not the other objects. 
5. Go over the client code and replace all direct calls to the singleton’s constructor with calls to its static creation method.

## Pros and Cons

| Pros | Cons |
|------|------|
| Controlled access to the single instance | Difficult to test due to global state |
| Reduced namespace pollution | Potentially more complex lifecycle management |
| Allows refinement of operations and representation | Can introduce bottlenecks if used in a concurrent context without careful synchronization |
| Permits a variable number of instances (more than one, if desired) | Violates the Single Responsibility Principle |
| More flexible than class operations | Can mask bad design when components know too much about each other |
| You can be sure that a class has only a single instance | Requires special treatment in multithreaded environments |
| You gain a global access point to that instance | May be difficult to unit test the client code |
| The singleton object is initialized only when it's requested for the first time | |

