# Singleton

## Intent

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to
alter the type of objects that will be created.

## Detailed Explanation of Singleton Pattern with Real-World Examples

Real-world example


> Imagine a logistics company that needs to deliver different types of packages: standard, express, and oversized. The company has a central
> system that processes delivery requests but does not know the specifics of how each package type is handled. To manage this, the company
> uses a Factory Method pattern.
>
> In this setup, there is a central DeliveryRequest class with a method createPackage(). This method is overridden in subclasses like
> StandardDelivery, ExpressDelivery, and OversizedDelivery, each of which knows how to create and manage the respective package type. This
> way, the central system can handle delivery requests without needing to know the details of how each package type is created and
> processed,
> allowing for flexibility and easier maintenance.

In plain words

> It provides a way to delegate the instantiation logic to child classes.

![Factory Method Pattern sequence diagram](./etc/factory-method.png)

## When to Use the Factory Method Pattern in Java

Use the Factory Method Pattern in Java when:

* Class cannot anticipate the class of objects it must create.
* Class wants its subclasses to specify the objects it creates.
* Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is
  the delegate.

## Real-World Applications

* [java.util.Calendar](http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#getInstance--)
* [java.util.ResourceBundle](http://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-)
* [java.text.NumberFormat](http://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getInstance--)
* [java.nio.charset.Charset](http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html#forName-java.lang.String-)
* [java.net.URLStreamHandlerFactory](http://docs.oracle.com/javase/8/docs/api/java/net/URLStreamHandlerFactory.html#createURLStreamHandler-java.lang.String-)
* [java.util.EnumSet](https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html#of-E-)

## How to Implement

1. Make all products follow the same interface. This interface should declare methods that make sense in every product.
2. Add an empty factory method inside the creator class. The return type of the method should match the common product interface.
3. In the creator’s code find all references to product constructors. One by one, replace them with calls to the factory method, while
   extracting the product creation code into the factory method.
4. You might need to add a temporary parameter to the factory method to control the type of returned product.
5. At this point, the code of the factory method may look pretty ugly. It may have a large switch statement that picks which product class
   to instantiate. But don’t worry, we’ll fix it soon enough.
6. Now, create a set of creator subclasses for each type of product listed in the factory method. Override the factory method in the
   subclasses and extract the appropriate bits of construction code from the base method.
7. If there are too many product types, and it doesn’t make sense to create subclasses for all of them, you can reuse the control parameter
   from the base class in subclasses.
8. For instance, imagine that you have the following hierarchy of classes: the base Mail class with a couple of subclasses: AirMail and
   GroundMail; the Transport classes are Plane, Truck and Train. While the AirMail class only uses Plane objects, GroundMail may work with
   both Truck and Train objects. You can create a new subclass (say TrainMail) to handle both cases, but there’s another option. The client
   code can pass an argument to the factory method of the GroundMail class to control which product it wants to receive.
9. If, after all the extractions, the base factory method has become empty, you can make it abstract. If there’s something left, you can
   make it a default behavior of the method.

## Pros and Cons

| Pros                                                                                                                                      | Cons                                                                                                                                                                                                                            |
|-------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| You avoid tight coupling between the creator and the concrete products.                                                                   | The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes. |
| Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support. |                                                                                                                                                                                                                                 |
| Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.                    |                                                                                                                                                                                                                                 |

