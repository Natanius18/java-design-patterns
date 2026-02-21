# Observer

## Intent

Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that
happen to the object they’re observing.

## Detailed Explanation of Observer Pattern with Real-World Examples

Real-world example

> In a real-world example, consider a news agency system where the agency (subject) publishes news articles, and multiple news outlets (
> observers) subscribe to receive updates. Whenever the news agency publishes a new article, it automatically notifies all the subscribed
> news
> outlets. These outlets can then update their platforms (like websites, TV broadcasts, or newspapers) with the latest news. This ensures
> that
> all subscribers get the latest information without the news agency needing to know the specifics of each outlet's update process. This
> decouples the news agency from the subscribers, promoting flexibility and modularity in how updates are handled.

In plain words

> Implement the Observer interface to actively monitor and respond to state changes in Java applications, improving event-driven programming
> efficiency.


![Observer Pattern sequence diagram](./etc/Observer.png)

## When to Use the Observer Pattern in Java

Use the Observer pattern in any of the following situations:

* When an abstraction has two aspects, one dependent on the other. Encapsulating these aspects in separate objects lets you vary and reuse
  them independently.
* When a change to one object requires changing others, and you don't know how many objects need to be changed.
* When an object should be able to notify other objects without making assumptions about who these objects are. In other words, you don't
  want these objects tightly coupled.

## Real-World Applications of Observer Pattern in Java

* [java.util.Observer](http://docs.oracle.com/javase/8/docs/api/java/util/Observer.html)
* [java.util.EventListener](http://docs.oracle.com/javase/8/docs/api/java/util/EventListener.html)
* [javax.servlet.http.HttpSessionBindingListener](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSessionBindingListener.html)
* [RxJava](https://github.com/ReactiveX/RxJava)
* Model-View-Controller (MVC) frameworks.
* Event handling systems.

## How to Implement

1. Look over your business logic and try to break it down into two parts: the core functionality, independent from other code, will act as
   the publisher; the rest will turn into a set of subscriber classes.

2. Declare the subscriber interface. At a bare minimum, it should declare a single update method.
3. Declare the publisher interface and describe a pair of methods for adding a subscriber object to and removing it from the list. Remember
   that publishers must work with subscribers only via the subscriber interface.
4. Decide where to put the actual subscription list and the implementation of subscription methods. Usually, this code looks the same for
   all types of publishers, so the obvious place to put it is in an abstract class derived directly from the publisher interface. Concrete
   publishers extend that class, inheriting the subscription behavior.

   However, if you’re applying the pattern to an existing class hierarchy, consider an approach based on composition: put the subscription
   logic into a separate object, and make all real publishers use it.
5. Create concrete publisher classes. Each time something important happens inside a publisher, it must notify all its subscribers.
6. Implement the update notification methods in concrete subscriber classes. Most subscribers would need some context data about the event.
   It can be passed as an argument of the notification method.

   But there’s another option. Upon receiving a notification, the subscriber can fetch any data directly from the notification. In this
   case, the publisher must pass itself via the update method. The less flexible option is to link a publisher to the subscriber permanently
   via the constructor.
7. The client must create all necessary subscribers and register them with proper publishers.

## Pros and Cons

| Pros                                                                                                                                                             | Cons                                                                                  |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
| Open/Closed Principle. You can introduce new subscriber classes without having to change the publisher’s code (and vice versa if there’s a publisher interface). | Can lead to memory leaks if observers are not properly deregistered.                  |
| You can establish relations between objects at runtime.                                                                                                          | The order of notification is not specified, leading to potential unexpected behavior. |
|                                                                                                                                                                  | Potential for performance issues with a large number of observers.                    |
