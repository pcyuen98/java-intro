# JAVA Curriculum and Challenges

## 📘 JAVA Level 1 (Fundamentals) Curriculum

### Module 1. Introduction to the Java Programming Language
**Key Topics:** Java's philosophy (WORA), JVM, JRE, and JDK. Setting up the IDE (IntelliJ/Eclipse). Compiling (`javac`) and running (`java`) "Hello, World!". Basic syntax, comments, and the main method structure.

### Module 2. Data Types, Type Casting, and Operators
**Key Topics:** Primitive Data Types (`int`, `double`, `boolean`, `char`). Type Casting (implicit/explicit). Arithmetic, Relational, and Logical Operators (`&&`, `||`, `!`). Branching Operators (`if/else if/else`, and `switch`).

### Module 3. Loops and Debugging
**Key Topics:** Iterative Loops (`for`, enhanced `for`, `while`, `do-while`). Jump Statements (`break`, `continue`). Debugging in an IDE (breakpoints, stepping, variable inspection).

### Module 4. Strings, Arrays, and ArrayLists
**Key Topics:** String Immutability, String methods (`length()`, `charAt()`, `substring()`). Arrays (declaration, fixed size, multi-dimensional). Introduction to `ArrayList` (resizable lists).

### Module 5. Sorting and Searching Arrays/Collections
**Key Topics:** Using `Arrays.sort()` and `Collections.sort()`. Implementing Search Algorithms (Linear, Binary). Introduction to `Comparator` and `Comparable` for custom sorting.

### Module 6. Collections: List, Set, and Map
**Key Topics:** The `List` Interface (`LinkedList`), the `Set` Interface (`HashSet`, `TreeSet`), and the `Map` Interface (`HashMap`, `TreeMap`). Performance comparisons.

### Module 7. Methods (Functions)
**Key Topics:** Method Definition and Invocation. Method Overloading. Return Types and `void`. Scope. Introduction to Recursion.

### Module 8. Exceptions
**Key Topics:** Exception Hierarchy (Checked vs. Unchecked). Using `try-catch-finally`. Throwing exceptions (`throw`). Creating custom exception classes. Try-with-Resources.

---

## 📘 JAVA Level 2 (Intermediate) Curriculum

### Module 9. Files and I/O Streams
**Key Topics:** The `File` class. Input/Output (I/O) Streams (Byte vs. Character). Using `FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter`. Serialization.

### Module 10. Version Control Systems (VCS)
**Key Topics:** VCS concepts (commits, branches, merges). Practical Git and GitHub/GitLab usage. Branching strategies.

### Module 11. Unit Testing of Java Applications
**Key Topics:** Introduction to JUnit 5. Test structure (A-A-A). Annotations (`@Test`, `@BeforeEach`). Using Mockito for mocking dependencies.

### Module 12. Object-Oriented Programming (OOP)
**Key Topics:** Classes and Objects. Four Pillars: Encapsulation, Inheritance (`extends`), Polymorphism (overriding), and Abstraction (abstract classes/interfaces). Constructors, `this`, and `super`.

### Module 13. Data Structures and Generics
**Key Topics:** Implementation of common structures (`HashMap`, `LinkedList`, Stack/Queue). Generics (`<T>`) for type safety.

### Module 14. Design Patterns
**Key Topics:** Principles of patterns. Study of Singleton, Factory, and Builder patterns. Overview of Observer and Strategy.

### Module 15. SOLID Principles
**Key Topics:** SRP, OCP, LSP, ISP, DIP. Applying principles in code refactoring.

### Module 16. Teamwork, Software Project Management, and Tools
**Key Topics:** Project setup with Maven/Gradle. Agile methodologies (Scrum/Kanban). Code quality tools (SonarQube). CI/CD concepts.

### Module 17. Modern Java and Productivity Tools
**Key Topics:** Generative AI and LLMs (using tools like GitHub Copilot). Key features from modern Java (e.g., Records). Introduction to Spring Boot.

---

## 💻 Challenge 1: How Will You Compare?

### Objective
Create a `Comparator` class that includes **three overloaded compare methods**.

### Requirements

#### Method 1
```java
boolean compare(String a, String b)
```
Return `true` if `a.equals(b)`; otherwise, `false`.

#### Method 2
```java
boolean compare(int a, int b)
```
Return `true` if `a == b`; otherwise, `false`.

#### Method 3
```java
boolean compare(String[] a, String[] b)
```
Return `true` if both arrays are of equal length and all corresponding elements match.

**Constraints**
- String length ≤ 2000
- Integers ≤ 100000
- Array length ≤ 10

---

### 📥 Input Format
- The first line: `T`, number of test cases.
- Each test case format varies by comparison type (1, 2, or 3).

### 🧾 Sample Input 0
```
2
1
hello world
hello world
2
4
6
3
3 3
1 2 3
1 2 3
```

### ✅ Sample Output 0
```
Same
Different
Same
```

### 🔍 Explanation
| Test Case | Type | a | b | Output | Reason |
|------------|------|---|---|--------|--------|
| 1 | 1 | "hello world" | "hello world" | Same | Both strings match |
| 2 | 2 | 4 | 6 | Different | Integers differ |
| 3 | 3 | [1,2,3] | [1,2,3] | Same | Arrays identical |

---

## 💻 Sample Case 1

### 📥 Sample Input 1
```
2
3
3 4
1 2 3
1 2 3 4
1
HackerRank
HackerRank
```

### ✅ Sample Output 1
```
Different
Different
```

### 🔍 Explanation
| Test Case | Type | a | b | Output | Reason |
|------------|------|---|---|--------|--------|
| 1 | 3 | [1,2,3] | [1,2,3,4] | Different | Array lengths differ |
| 2 | 1 | "HackerRank" | "hackerRank" | Different | Case-sensitive comparison |
