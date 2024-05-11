# Java 22

[![Build Status](https://dev.azure.com/hbvk/java-test/_apis/build/status%2Fhbvk.java22?branchName=master)](https://dev.azure.com/hbvk/java-test/_build/latest?definitionId=41&branchName=master)

| Release | EOL     | Class File Version |
|---------|---------|--------------------|
| 2024-03 | 2024-09 | 66.0               |

# New Features

| feature                                               | JEP                                          | status            | test                                                                            |
|-------------------------------------------------------|----------------------------------------------|-------------------|---------------------------------------------------------------------------------|
| Region Pinning for G1                                 | [JEP 423](https://openjdk.java.net/jeps/423) | **final**         |                                                                                 |
| Statements before super()                             | [JEP 447](https://openjdk.java.net/jeps/447) | 1. Preview        | [test case](src/test/java/com/hbvk/jep447/Jep447StatementsBeforeSuperTest.java) |
| Foreign Function & Memory API                         | [JEP 454](https://openjdk.java.net/jeps/454) | **final**         | [test case](src/test/java/com/hbvk/jep454/Jep454ForeignFunctionsTest.java)      |
| Unnamed Variables & Patterns                          | [JEP 456](https://openjdk.java.net/jeps/456) | **final**         | [test case](src/test/java/com/hbvk/jep456/Jep456AnonymousVariableTest.java)     |
| Class-File API                                        | [JEP 457](https://openjdk.java.net/jeps/457) | 1. Preview        |                                                                                 |
| Launch Multi-File Source-Code Programs                | [JEP 458](https://openjdk.java.net/jeps/458) | **final**         |                                                                                 |
| String Templates                                      | [JEP 459](https://openjdk.java.net/jeps/459) | 2. Preview        | [test case](src/test/java/com/hbvk/jep459/Jep459StringTemplateTest.java)        |
| Vector API                                            | [JEP 460](https://openjdk.java.net/jeps/460) | Seventh Incubator |                                                                                 |
| Stream Gatherers                                      | [JEP 461](https://openjdk.java.net/jeps/461) | 1. Preview        | [test case](src/test/java/com/hbvk/jep461/Jep461GathererTest.java)              |
| Structured Concurrency                                | [JEP 462](https://openjdk.java.net/jeps/462) | 2. Preview        |                                                                                 |
| Implicitly Declared Classes and Instance Main Methods | [JEP 463](https://openjdk.java.net/jeps/463) | 2. Preview        |                                                                                 |

# Testing new features

In this project I have been experimenting with new Java features in Java 22:

* [Foreign Function & Memory API](src/test/java/com/hbvk/jep454/Jep454ForeignFunctionsTest.java)
* [Unnamed Variables & Patterns](src/test/java/com/hbvk/jep456/Jep456AnonymousVariableTest.java)

I found it hard to create a test for foreign functions that worked both on my local Windows setup and in my Azure
pipeline Linux build. Foreign functions don't fit very well in Java's _Write once, run anywhere_ philosophy.
Nevertheless, it's a big improvement over JNI.

Unnamed variables are long overdue, I can't wait to replace some unnecessary `ignored` variables in my projects.

# Testing preview features

I also tested the following preview features:

* [Statements before super()](src/test/java/com/hbvk/jep447/Jep447StatementsBeforeSuperTest.java)
* [String Templates](src/test/java/com/hbvk/jep459/Jep459StringTemplateTest.java)
* [Stream Gatherers](src/test/java/com/hbvk/jep461/Jep461GathererTest.java)

Preview features are subject to change, of course, and in the case of string templates certainly _will_ change.

Statements before super is a useful addition to Java. We can now replace the somewhat convoluted `super(validate(x));`
constructs by the more readable `validate(x); super(x);`.

String templates and stream gatherers are a good idea, but the current preview implementation lacks the ease of use of
similar Kotlin constructs.