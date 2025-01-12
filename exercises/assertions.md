# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
1 - `assertTrue(3 * .4 == 1.2)` fails because the result of 3*.4 is superior than 1.2. In order to make this assertion success we need to write it as the following `assertTrue(3 * .4 >= 1.2)`.

2 - assertEquals uses equals() method (that should be overrided) to compare objects, while assertSame uses == operator to compare them.
 - If we didn't override equals(), it will compare references, so assertEquals behaves the same as assertSame.
 - If we did override equals(), assertSame compares references and assertEquals compares based on how we implement it.

3 -  Other uses :
- The junit fail method is used to verify that the actual exception will throw an error or the test is failing at the time of development.
- At the time of writing unit test cases, we use the junit fail method for creating failure in testing conditions.

```public class JunitFail {
   private void junitfail () {
         try {
            java.lang.reflect.Field fie = SpelExpression.class.getField ("Junit Fail");
         }
        catch (Exception ex) {
          fail (ex.toString ());
        }
     }
```

4 - assertThrows (Class<T> expectedType, Executable executable)
 
 Assert that execution of the supplied executable throws an exception of the expectedType and return the exception.
 
If we pass Exception as the expected exception type, any exception thrown will make the assertion succeed since Exception is the super-type for all exceptions.
 
The assertThrows() method enables more fine-grained control for exception assertion logic because we can use it around specific parts of the code.
