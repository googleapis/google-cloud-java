package com.google.cloud.dlp.v2beta1;

import com.google.privacy.dlp.v2beta1.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

  @Test
  public void asDlpColorTest() {
    Color got = Colors.asDlpColor(java.awt.Color.GREEN);
    Assert.assertEquals(got.getBlue(), 0, 0);
    Assert.assertEquals(got.getGreen(), 255, 0);
    Assert.assertEquals(got.getRed(), 0, 0);
  }
}
