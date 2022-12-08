package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

  @Test
  public void testIsBalancedWithBalancedPars() throws Exception {
    assertTrue(StringUtils.isBalanced("{[][]}({})"));
  }

  @Test
  public void testIsBalancedUnbalancedPars() throws Exception {
    assertFalse(StringUtils.isBalanced("{][}{})"));
  }

  @Test
  public void testIsBalancedEmtyText() throws Exception {
    assertTrue(StringUtils.isBalanced(""));
  }

  @Test
  public void testIsBalancedNullParameter() throws Exception {
    assertFalse(StringUtils.isBalanced(null));
  }

}