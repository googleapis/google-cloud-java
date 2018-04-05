package com.google.cloud.dlp.v2beta1;

import com.google.privacy.dlp.v2beta1.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

  @Test
  public void asDlpColorTest() {
    Color got = Colors.asDlpColor(new java.awt.Color(1, 2, 3));
    Assert.assertEquals(got.getBlue(), 3, 0);
    Assert.assertEquals(got.getGreen(), 2, 0);
    Assert.assertEquals(got.getRed(), 1, 0);
  }

  @Test
  public void asAwtColorTest() {
    java.awt.Color got =
        Colors.asAwtColor(Color.newBuilder().setRed(1).setGreen(2).setBlue(3).build());

    Assert.assertEquals(got.getBlue(), 3, 0);
    Assert.assertEquals(got.getGreen(), 2, 0);
    Assert.assertEquals(got.getRed(), 1, 0);
  }
}
