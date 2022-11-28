# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

We use the JUnitUseExpected ruleset to analyze the common-cli project. This ruleset say that in case of the use of a try{...} catch{...} pattern, we must add another test with the @Test(expected) in order to test the good scenario. Here is an example int HelpFormatterTest.java at line 
```    @Test
    public void testPrintHelpWithEmptySyntax() {
        final HelpFormatter formatter = new HelpFormatter();
        try {
            formatter.printHelp(null, new Options());
            fail("null command line syntax should be rejected");
        } catch (final IllegalArgumentException e) {
            // expected
        }

        try {
            formatter.printHelp("", new Options());
            fail("empty command line syntax should be rejected");
        } catch (final IllegalArgumentException e) {
            // expected
        }
    }```
    
    Here the code needs to specify a //expected test
    
    ```@Test(expected=IllegalArgumentException.class)
    public void testGood() {
      //do some test for
      }
