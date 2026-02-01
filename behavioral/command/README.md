# Command

## Intent

Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This
transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

## Detailed Explanation of Command Pattern with Real-World Examples

Real-world example

> Imagine a smart home system where you can control devices such as lights, thermostats, and security cameras through a central application.
> Each command to operate these devices is encapsulated as an object, enabling the system to queue, execute sequentially, and undo commands
> if necessary. This approach decouples control logic from device implementation, allowing easy addition of new devices or features without
> altering the core application. This flexibility and functionality illustrate the practical application of the Command design pattern in
> Java programming.

In plain words

> Storing requests as command objects allows performing an action or undoing it at a later time.


![Command  Pattern sequence diagram](./etc/command.png)

## When to Use the Command  Pattern in Java

The Command design pattern is applicable when you need to parameterize objects with actions, support undo operations, or structure a system
around high-level operations built on primitive ones. It is commonly used in GUI buttons, database transactions, and macro recording.

Use the Command pattern when you want to:

* Parameterize objects with actions to perform, offering an object-oriented alternative to callbacks found in procedural languages. Commands
  can be registered and executed later.
* Specify, queue, and execute requests at different times, allowing commands to exist independently of the original request and even be
  transferred across processes.
* Support undo functionality, where the Command’s execute operation stores state and includes an un-execute operation to reverse previous
  actions. This allows for unlimited undo and redo capabilities by maintaining a history list.
* Log changes to reapply them after a system crash. By adding load and store operations to the Command interface, you can maintain a
  persistent log of changes and recover by reloading and re-executing commands from this log.
* Structure a system around high-level operations built on primitive operations, which is common in transaction-based systems. The Command
  pattern models transactions by providing a common interface for invoking and extending operations.
* Keep a history of requests.
* Implement callback functionality.
* Implement undo functionality.

## Real-World Applications of Command Pattern in Java

* GUI Buttons and menu items in desktop applications.
* Operations in database systems and transactional systems that support rollback.
* Macro recording in applications like text editors and spreadsheets.
* [java.lang.Runnable](http://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
* [org.junit.runners.model.Statement](https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/runners/model/Statement.java)
* [Netflix Hystrix](https://github.com/Netflix/Hystrix/wiki)
* [javax.swing.Action](http://docs.oracle.com/javase/8/docs/api/javax/swing/Action.html)

## How to Implement

1. Declare the command interface with a single execution method.
2. Start extracting requests into concrete command classes that implement the command interface. Each class must have a set of fields for
   storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the
   command’s constructor.
3. Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their
   commands only via the command interface. Senders usually don’t create command objects on their own, but rather get them from the client
   code.
4. Change the senders so they execute the command instead of sending a request to the receiver directly.
5. The client should initialize objects in the following order:
    * Create receivers.
    * Create commands, and associate them with receivers if needed.
    * Create senders, and associate them with specific commands.

## Pros and Cons

| Pros                                                                                                                         | Cons                                                                               |
|------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform these operations. | Increases the number of classes for each individual command.                       |
| Open/Closed Principle. You can introduce new commands into the app without breaking existing client code.                    | Can complicate the design by adding multiple layers between senders and receivers. |
| You can implement undo/redo.                                                                                                 |                                                                                    |
| You can implement deferred execution of operations.                                                                          |                                                                                    |
| You can assemble a set of simple commands into a complex one.                                                                |                                                                                    |
