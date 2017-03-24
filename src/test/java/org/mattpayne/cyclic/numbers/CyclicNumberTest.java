package org.mattpayne.cyclic.numbers;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class CyclicNumberTest {

  @Test
  public void testSimple142857() {
    CyclicNumber seventh = new CyclicNumber(142857L);
    assertThat(seventh.isCyclic(), is(true));
  }

  @Test
  public void denominatorIdentifies() {
    CyclicNumber seventh = new CyclicNumber();
    seventh.setDenominator(7);
    assertThat(seventh.isCyclic(), is(true));
  }

  @Test
  public void seventheenth() {
    CyclicNumber seventh = new CyclicNumber();
    seventh.setDenominator(17);
    assertThat(seventh.isCyclic(), is(true));
  }

  @Test
  public void wellKnownDemoninators() {
    // from https://en.wikipedia.org/wiki/Cyclic_number
     List<Integer> demoniators = Arrays.asList(7,17,19,23, 29, 47, 59, 61, 97);
  }

}
