# Java Design Patterns

A collection of Java design pattern examples based on materials from [refactoring.guru](https://refactoring.guru/design-patterns).

## Description

This repository contains practical examples of classic design pattern implementations in Java. Each pattern includes detailed explanations,
diagrams and working code.

## Repository Structure

### Creational Patterns

- **[Singleton](https://github.com/Natanius18/java-design-patterns/tree/master/creational/singleton)** - Ensures a class has only one
  instance
    - *Gym Example:* **GymConfiguration Manager** - Manages all gym-wide settings including operating hours, maximum capacity (e.g., 150
      members at peak time), emergency contacts, maintenance schedules, pricing policies, and COVID-19 protocols. Without Singleton,
      different parts of the system (reception, booking system, access control) might load configurations from different files or databases,
      causing inconsistencies like one system allowing 200 members while another enforces 150. Singleton guarantees a single source of truth
      accessed globally via `GymConfiguration.getInstance()`, with thread-safe lazy initialization. Changes propagate instantly everywhere,
      and it supports hot-reloading for immediate policy updates without restarting the system.

- **[Factory Method](https://github.com/Natanius18/java-design-patterns/tree/master/creational/factory_method)** - Creates objects without
  specifying their concrete classes
    - *Gym Example:* **MembershipFactory** - During registration, the receptionist selects membership type (Basic/Premium/VIP) and the
      factory returns the appropriate object without the registration UI knowing concrete classes. `createMembership(type)` handles
      validation rules, sets default entitlements (Basic: gym floor access; Premium: +classes; VIP: +personal training +spa), initializes
      billing schedules, and assigns unique member IDs. Adding CorporateMembership later requires only a new factory method—no changes to
      20+ registration screens, emails, or reporting code. Client code remains `Membership membership = factory.createMembership(type)`
      regardless of new tiers.

- **[Abstract Factory](https://github.com/Natanius18/java-design-patterns/tree/master/creational/abstract-factory)** - Creates families of
  related objects
    - *Gym Example:* **EquipmentFactory** - `CardioEquipmentFactory` creates cohesive cardio sets (Treadmill with heart-rate monitor,
      EllipticalBike with stride counter, RowingMachine with stroke analyzer) sharing interfaces and metrics. `StrengthEquipmentFactory`
      creates matching strength sets (Barbell with weight plates, Dumbbells with ergonomic grips, BenchPress with safety bars). Ensures
      equipment families work together—cardio zone analytics aggregate stride/stroke data; strength zone tracks total tonnage lifted. Adding
      YogaEquipmentFactory (Mats, Blocks, Straps) requires only one new factory, not changes across workout planners, maintenance
      schedulers, and inventory systems.

- **[Builder](https://github.com/Natanius18/java-design-patterns/tree/master/creational/builder)** - Constructs complex objects step by step
    - *Gym Example:* **WorkoutPlanBuilder** - Creates personalized plans avoiding "telescoping constructors":

      ```java
        .setGoal(WeightLoss.class)
        .addExercise(TreadmillRun.class, 3, 20)
        .addExercise(Squats.class, 4, 12)
        .setRestPeriod(90)
        .addNutrition(CarbCyclingDiet.class)
        .setDuration(12)
        .build();
      ```
      Same builder produces vastly different plans (beginner vs advanced, cardio vs strength focus). Fluent interface prevents invalid
      states (no goal set), supports previewing partial plans, and enables trainers to save/load partially completed plans. Adding new
      exercises or diets requires only builder method extensions.

- **[Prototype](https://github.com/Natanius18/java-design-patterns/tree/master/creational/prototype)** - Clones objects
    - *Gym Example:* **WorkoutTemplate Cloning** - Stores 50+ proven templates ("Beginner Fat Burn", "Powerlifter 5x5", "Marathon Prep").
      New member fills questionnaire → system clones closest template → customizes (sets starting weights based on 1RM tests, adjusts for
      injuries/availability, adds member name). Cloning is shallow for shared exercise definitions (deep clone only personal data). Saves
      trainers 30+ minutes per plan, ensures 95% consistency across similar members, enables A/B testing template variants, and supports
      versioning ("BeginnerFatBurn_v2.1").

### Structural Patterns

- **Adapter** - Makes incompatible interfaces compatible
- **Bridge** - Separates abstraction from implementation
- **Composite** - Composes objects into tree structures
- **Decorator** - Adds functionality to objects
- **Facade** - Provides simplified interface to complex subsystem
- **Flyweight** - Efficiently shares common data
- **Proxy** - Controls access to objects

### Behavioral Patterns

- **[Chain of Responsibility](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/chain-of-responsibility)** - Passes
  requests along a chain of handlers
    - *Gym Example:* **MembershipApproval Chain** - `MembershipRequest` flows: `BasicValidatorHandler` (name/email format, age 16+) →
      `CreditCheckHandler` (no red flags, payment method valid) → `ManagerReviewHandler` (references, special requests) →
      `OwnerApprovalHandler` (corporate deals >$10K). Each processes/passes or rejects/stops. Receptionist submits once; system routes
      automatically. Adding ComplianceHandler (GDPR, insurance) requires only chain insertion.

- **[Command](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/command)** - Encapsulates requests as objects
    - *Gym Example:* **GymCommand Objects** - `BookClassCommand(memberId, classId)`, `CancelBookingCommand`, `ExtendMembershipCommand` with
      `execute()`, `undo()`, `getAuditLog()`. MacroCommands batch operations ("register + book intro class"). Undo stack enables "undo class
      cancellation", queue handles peak-hour booking floods, logging creates complete audit trails for disputes. Commands persist to
      database for crash recovery.

- **[Iterator](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/iterator)** - Provides sequential access to
  collection elements
    - *Gym Example:* **EquipmentIterator** - `EquipmentInventory` hides storage (HashMap<Zone, List<Equipment>>). `ZoneIterator` traverses
      Cardio→Strength→Functional zones; `AvailabilityIterator` yields only free equipment. Maintenance staff calls `iterator.hasNext()`,
      `iterator.next().performMaintenance()` without knowing arrays vs trees vs databases. Adding AvailabilityFilterIterator (only machines
      needing calibration) requires no client changes.

- **[Mediator](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/mediator)** - Defines object interaction through a
  mediator
    - *Gym Example:* **ClassScheduleMediator** - `Trainer` requests slot → Mediator checks `Room.capacity`, `Member` conflicts, `TimeSlot`
      overlaps → assigns/notifies. Objects communicate only via `mediator.requestSlot()`, `mediator.confirmBooking()`. Adding
      WaitlistMediator, CancellationMediator reuses same entity objects. Eliminates 50+ direct `Trainer-Room` calls causing tight
      coupling/fragility.

- **[Memento](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/memento)** - Saves and restores object state
    - *Gym Example:* **WorkoutProgressMemento** - `WorkoutTracker.createMemento()` captures (weights: squat225, bench185; totalVolume:
      4200lbs; calories:850). `setMemento(memento)` restores exactly. UI shows timeline picker ("Week 3 vs Week 8"), rollback fixes data
      entry errors, database save/restore survives crashes. `WorkoutTracker` hides state structure; only progress visible. Coach compares
      `memento1.diff(memento2)` for progress reports.

- **[Observer](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/observer)** - Notifies dependent objects about
  changes
    - *Gym Example:* **ClassNotifier** - `ClassSchedule` change (time/location/cancelled) →
      `notifyObservers(Channel.EMAIL, Channel.SMS, Channel.APP)`. Members register preferences per class type (yoga→email; spin→SMS).
      Unsubscribe anytime. Adding FacebookNotifier, WhatsAppNotifier requires only new observer—notifier schedule changes. Push vs polling
      eliminates "class moved, I showed up at wrong time" issues.

- **[State](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/state)** - Changes object behavior when state changes
    - *Gym Example:* **MembershipState** - `ActiveState`: full access, auto-renew; `SuspendedState`: gym only, payment prompts;
      `ExpiredState`: renewal offers; `FrozenState`: no billing/access. `membership.checkIn()` delegates to current state. `suspend()`
      triggers `setState(SuspendedState)`—behavior changes instantly without 200-line `if (state == "suspended")` conditionals everywhere.
      States handle transitions (`ExpiredState.onPayment()` → `ActiveState`).

- **[Strategy](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/strategy)** - Defines family of interchangeable
  algorithms
    - *Gym Example:* **PricingStrategy** - `billingSystem.setStrategy(new StudentDiscountStrategy())`. Strategies: `MonthlyFlat($49)`,
      `AnnualDiscounted($490)`, `PayPerVisit($15)`, `CorporateBulk(10%off)`. Switch at renewal without recompiling. `calculateCharge()`
      delegates to current strategy. Adding FamilyPlanStrategy, ReferralDiscount requires only new strategy class.

- **[Template Method](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/template-method)** - Defines algorithm
  skeleton
    - *Gym Example:* **WorkoutSession Template** - `abstract class WorkoutSession`: `warmUp()` (5min dynamic stretch—final),
      `mainWorkout()` (abstract), `coolDown()` (static stretch + foam roll—final), `logSession()` (final). `StrengthSession.mainWorkout()` =
      compounds + accessories; `CardioSession.mainWorkout()` = intervals. All sessions follow proven structure while customizing core.
      Adding MobilitySession requires only `mainWorkout()` override.

- **[Visitor](https://github.com/Natanius18/java-design-patterns/tree/master/behavioral/visitor)** - Performs operations on objects without
  changing their classes
    - *Gym Example:* **EquipmentMaintenanceVisitor** - `RoutineCheckVisitor` (visual inspection, lubrication); `CalibrationVisitor`
      (sensors, displays); `DeepCleanVisitor` (disassembly). `equipment.accept(visitor)` double-dispatches: Treadmill calibrates belt speed,
      Barbell checks rust. Adding SafetyInspectionVisitor, InventoryAuditVisitor—no equipment class changes despite 10+ operations × 50
      equipment types.
