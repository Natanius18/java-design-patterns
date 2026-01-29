# Prototype

## Intent

Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.

## Detailed Explanation of Prototype Pattern with Real-World Examples

Real-world example

> Imagine a company that manufactures custom-designed furniture. Instead of creating each piece from scratch every time an order is placed,
> they keep prototypes of their most popular designs. When a customer places an order for a specific design, the company simply clones the
> prototype of that design and makes the necessary customizations. This approach saves time and resources as the basic structure and design
> details are already in place, allowing the company to quickly fulfill orders with consistent quality.
>
> In this scenario, the furniture prototypes act like object prototypes in software, enabling efficient creation of new, customized pieces
> based on existing models.

In plain words

> Create an object based on an existing object through cloning.


![Prototype Pattern sequence diagram](./etc/prototype.png)

## When to Use the Prototype Pattern in Java

* When the classes to instantiate are specified at run-time, for example, by dynamic loading.
* To avoid building a class hierarchy of factories that parallels the class hierarchy of products.
* When instances of a class can have one of only a few different combinations of state. It may be more convenient to install a corresponding
  number of prototypes and clone them rather than instantiating the class manually, each time with the appropriate state.
* When object creation is expensive compared to cloning.
* When the concrete classes to instantiate are unknown until runtime.

## Real-World Applications of Prototype Pattern in Java

* In Java, the `Object.clone()` method is a classic implementation of the Prototype pattern.
* GUI libraries often use prototypes for creating buttons, windows, and other widgets.
* In game development, creating multiple objects (like enemy characters) with similar attributes.

## How to Implement

1. Create the prototype interface and declare the clone method in it. Or just add the method to all classes of an existing class hierarchy,
   if you have one.
2. A prototype class must define the alternative constructor that accepts an object of that class as an argument. The constructor must copy
   the values of all fields defined in the class from the passed object into the newly created instance. If you’re changing a subclass, you
   must call the parent constructor to let the superclass handle the cloning of its private fields.
3. If your programming language doesn’t support method overloading, you won’t be able to create a separate “prototype” constructor. Thus,
   copying the object’s data into the newly created clone will have to be performed within the clone method. Still, having this code in a
   regular constructor is safer because the resulting object is returned fully configured right after you call the new operator.
4. The cloning method usually consists of just one line: running a new operator with the prototypical version of the constructor. Note, that
   every class must explicitly override the cloning method and use its own class name along with the new operator. Otherwise, the cloning
   method may produce an object of a parent class.
5. Optionally, create a centralized prototype registry to store a catalog of frequently used prototypes.
6. You can implement the registry as a new factory class or put it in the base prototype class with a static method for fetching the
   prototype. This method should search for a prototype based on search criteria that the client code passes to the method. The criteria
   might either be a simple string tag or a complex set of search parameters. After the appropriate prototype is found, the registry should
   clone it and return the copy to the client.
7. Finally, replace the direct calls to the subclasses’ constructors with calls to the factory method of the prototype registry.

## Pros and Cons

| Pros                                                                                               | Cons                                                                        |
|----------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| You can clone objects without coupling to their concrete classes.                                  | Cloning complex objects that have circular references might be very tricky. |
| You can get rid of repeated initialization code in favor of cloning pre-built prototypes.          |                                                                             |
| You can produce complex objects more conveniently.                                                 |                                                                             |
| You get an alternative to inheritance when dealing with configuration presets for complex objects. |                                                                             |

