# Abstract Factory

## Intent

Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

## Detailed Explanation of Abstract Factory Pattern with Real-World Examples

Real-world example

> Imagine a furniture company that uses the Abstract Factory pattern in Java to produce various styles of furniture: modern, Victorian, and
> rustic. Each style includes products like chairs, tables, and sofas. To ensure consistency within each style, the company uses an Abstract
> Factory pattern.
>
> In this scenario, the Abstract Factory is an interface for creating families of related furniture objects (chairs, tables, sofas). Each
> concrete factory (ModernFurnitureFactory, VictorianFurnitureFactory, RusticFurnitureFactory) implements the Abstract Factory interface and
> creates a set of products that match the specific style. This way, clients can create a whole set of modern or Victorian furniture without
> worrying about the details of their instantiation. This maintains a consistent style and allows easy swapping of one style of furniture
> for
> another.

In plain words

> A factory of factories; a factory that groups the individual but related/dependent factories together without specifying their concrete
> classes.


![Abstract Factory Pattern sequence diagram](./etc/abstract-factory.png)

## When to Use the Abstract Factory Pattern in Java

Use the Abstract Factory pattern in Java when:

* The system should be independent of how its products are created, composed, and represented.
* You need to configure the system with one of multiple families of products.
* A family of related product objects must be used together, enforcing consistency.
* You want to provide a class library of products, exposing only their interfaces, not their implementations.
* The lifetime of dependencies is shorter than the consumer's lifetime.
* Dependencies need to be constructed using runtime values or parameters.
* You need to choose which product to use from a family at runtime.
* Adding new products or families should not require changes to existing code.

## Real-World Applications

* Java Swing's `LookAndFeel` classes for providing different look-and-feel options.
* Various implementations in the Java Abstract Window Toolkit (AWT) for creating different GUI components.
* [javax.xml.parsers.DocumentBuilderFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html)
* [javax.xml.transform.TransformerFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/transform/TransformerFactory.html#newInstance--)
* [javax.xml.xpath.XPathFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/xpath/XPathFactory.html#newInstance--)

## How to Implement

1. Map out a matrix of distinct product types versus variants of these products.
2. Declare abstract product interfaces for all product types. Then make all concrete product classes implement these interfaces.
3. Declare the abstract factory interface with a set of creation methods for all abstract products.
4. Implement a set of concrete factory classes, one for each product variant.
5. Create factory initialization code somewhere in the app. It should instantiate one of the concrete factory classes, depending on the
   application configuration or the current environment. Pass this factory object to all classes that construct products.
6. Scan through the code and find all direct calls to product constructors. Replace them with calls to the appropriate creation method on
   the factory object.

## Pros and Cons

| Pros                                                                                                                          | Cons                                                                                                                                     |
|-------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| You can be sure that the products you’re getting from a factory are compatible with each other.                               | The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern. |
| You avoid tight coupling between concrete products and client code.                                                           |                                                                                                                                          |
| Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support. |                                                                                                                                          |
| Open/Closed Principle. You can introduce new variants of products without breaking existing client code.                      |                                                                                                                                          |

