package romannumberconverter;

import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest{

  RomanNumberConverter test;

  @Before
  public void setup() {
     test = new RomanNumberConverter();
  }

  @Test
  public void check() {
    assertThat(test.convert(10))
      .isNotEmpty()
      .isEqualTo("X");
  }

  @Test
  public void check_null() {
    assertThatThrownBy(() -> test.convert(null))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }

  @Test
  public void check_negative() {
    assertThatThrownBy(() -> test.convert(-1))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be negative");
  }
}
