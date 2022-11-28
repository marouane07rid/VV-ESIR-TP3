# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

2 - assertEquals uses equals() method (that should be overrided) to compare objects, while assertSame uses == operator to compare them.
 - If we didn't override equals(), it will compare references, so assertEquals behaves the same as assertSame.
 - If we did override equals(), assertSame compares references and assertEquals compares based on how we implement it.
