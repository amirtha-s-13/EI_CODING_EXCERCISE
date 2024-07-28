	CODING EXCERCISE 1:
	BEHAVIOURAL PATTERN:
	Command Pattern: 
•	The Command Pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging the requests.
•	It also provides support for undoable operations. 
•	The provided code implements the Command Pattern by defining a `Command` interface with an `execute` method. Concrete implementations of this interface, such as `LightOnCommand` and `LightOffCommand`, encapsulate the actions of turning a light on and off, respectively.
•	The `RemoteControl` class acts as the invoker that triggers these commands. By setting different command objects to the `RemoteControl` and invoking them through the `pressButton` method, the code achieves a decoupled design where the invoker has no direct dependency on the actions themselves, just on the command interface. 
•	This allows for flexible and interchangeable command executions.
	Observer Pattern:
•	The Observer Pattern is a behavioral design pattern where an object (called the subject) maintains a list of dependents (called observers) and notifies them automatically of any state changes. 
•	In the provided code, the `Stock` class acts as the subject, holding a list of `StockObserver` instances. 
•	When the stock price changes (via the `setPrice` method), it calls `notifyObservers`, which updates all registered observers with the new stock price. The `StockObserver` interface defines an `update` method, and `ConcreteStockObserver` implements this interface to react to price changes. 
•	This pattern allows for a clean separation between the subject and its observers, enabling easy addition or removal of observers without altering the subject's code.
	
  
  CREATIONAL PATTERN:
	Factory pattern:
	• The Factory Pattern is a creational design pattern that defines an interface for creating objects, but allows subclasses to alter the type of objects that will be created. 
•	In the provided code, the `ShapeFactory` class acts as the factory, with a method `getShape` that takes a `shapeType` string as input. 
•	Based on this input, the method creates and returns an instance of a specific class `Circle`, `Square`, or `Rectangle` that implements the `Shape` interface. Each shape class overrides the `draw` method to provide its specific implementation.
•	The main method demonstrates how the `ShapeFactory` can be used to create different shapes without directly instantiating their classes, thereby promoting loose coupling and adherence to the open/closed principle.
•	This pattern simplifies object creation and makes the code more flexible and easier to extend.

Singleton pattern:
•	The Singleton Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance.
•	 In the provided code, the `Logger` class implements the Singleton Pattern by making its constructor private and providing a static method `getInstance` to return the single instance of the class. 
•	If the instance does not already exist, it is created when `getInstance` is called for the first time. The `log` method is a regular method that logs messages. In the `SingletonPattern` class's main method, `logger1` and `logger2` both call `Logger.getInstance()` and are shown to be the same instance by comparing them with `==`. 
•	This pattern ensures that only one `Logger` object exists throughout the application, providing a consistent logging mechanism.
	
  STRUCTUAL PATTERN:
	Adapter pattern:
•	The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together by providing a "wrapper" or adapter that translates one interface into another. 
•	In the provided code, the `AudioPlayer` class can play `mp3` files directly but needs an adapter to play `vlc` and `mp4` files. The `MediaAdapter` class implements the `MediaPlayer` interface and uses instances of `AdvancedMediaPlayer` (either `VlcPlayer` or `Mp4Player`) to handle the specific file types.
	• When `AudioPlayer` encounters a file type it cannot play directly (`vlc` or `mp4`), it uses the `MediaAdapter` to delegate the request to the appropriate advanced media player. 
•	This way, `AudioPlayer` can support additional formats without changing its code, adhering to the open/closed principle and making the system more flexible and extensible.
Decorator Pattern:
•	The Decorator Pattern is a structural design pattern that allows you to dynamically add behavior to objects without modifying their class. 
•	In the provided code, the `Text` interface is implemented by `PlainText`, which simply holds text.
•	 Decorators like `BoldText` and `ItalicText` extend an abstract class `TextDecorator` and add HTML bold and italic formatting to the text. By wrapping a `PlainText` object with these decorators, additional formatting can be applied without altering the original class. 
•	This pattern enables flexible and reusable code, as seen when combining multiple decorators to achieve combined effects, such as bold and italic text.


CODING EXCERCISE 2:
VIRTUAL_CLASSROOM_MANAGER:
Student class:
•	The Student class represents a student with an ID and a name. 
•	It provides methods to retrieve these details, encapsulating student information and making it easy to manage and access student data within the application.

Assignment Class:
•	The Assignment class represents an assignment with details and a due date. 
•	It includes methods to retrieve these details and to log when an assignment is submitted by a student.
•	 The logger records submission events, providing a way to track assignment activity in the application.

Classroom Class:
•	The Classroom class represents a classroom with a name, a list of students, and a list of assignments. 
•	It provides methods to add students, schedule assignments, list students, and list assignments.
•	 Each method logs significant actions such as adding students or scheduling assignments, helping to maintain a record of classroom activities.

VirtualClassroomManager Class:
•	The VirtualClassroomManager class manages multiple classrooms, allowing the addition and removal of classrooms, and operations related to students and assignments within those classrooms.
•	 It includes methods to add and list classrooms, add students, schedule assignments, list students, and list assignments. 
•	Each method logs its actions, providing a comprehensive log of classroom management activities.

Main Class:
•	The Main class is the entry point of the application. 
•	It sets up the logger to print to the console, initializes the VirtualClassroomManager, and handles user input to perform various operations like adding classrooms, students, scheduling assignments, and more.
•	 It ensures that user commands are processed correctly and logs application start and termination events.



