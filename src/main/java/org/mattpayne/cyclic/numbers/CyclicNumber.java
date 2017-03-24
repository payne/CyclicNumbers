package org.mattpayne.cyclic.numbers;

public class CyclicNumber {

  private Long number;
  private int denominator;
  private boolean verbose = false;

  public CyclicNumber(long l) {
    this.number = l;
  }

  public CyclicNumber() {
    number = null;
  }

  @Override
  public String toString() {
    return number + " cyclic=" + isCyclic();
  }

  public boolean isCyclic() {
    if (number == null)
      return false;
    String asString = String.valueOf(number);
    int length = asString.length();
    for (int i = 1; i <= length; i++) {
      long multiple = number * i;
      if (!isRotation(asString, String.valueOf(multiple))) {
        return false;
      }
    }
    return true;
  }

  //http://stackoverflow.com/questions/2553522/interview-question-check-if-one-string-is-a-rotation-of-other-string
  private boolean isRotation(String s1, String s2) {
    return (s1.length() == s2.length()) && ((s1 + s1).contains(s2));
  }

  public void setDenominator(int i) {
    denominator = i;
    if (number != null) {
      throw new IllegalStateException("Number has already been set.  Can't set the denominator");
    }
    Double fraction = new Double(1.0);
    fraction = fraction / denominator;
    long multiple = 100_00;
    CyclicNumber cn = null;
    do {
      multiple *= 10;
      String mostSignificantDigits = String.valueOf(fraction * multiple);
      mostSignificantDigits = mostSignificantDigits.substring(0, mostSignificantDigits.indexOf('.') + 0);
      if (mostSignificantDigits.length() > 100)
        break;
      cn = new CyclicNumber(Long.valueOf(mostSignificantDigits));
      if (verbose) {
        System.out.println(cn);
      }
    } while (!cn.isCyclic());
    if (cn.isCyclic()) {
      number = cn.number;
    } else {
      number = null;
    }
  }

  public boolean isVerbose() {
    return verbose;
  }

  public void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

}
