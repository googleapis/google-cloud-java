package com.google.cloud.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LicenseTest {

  @Test
  public void testToLicenseSucceeds() {
    String license = "Apache-2.0";
    assertEquals(License.APACHE_2_0, License.toLicense(license));
  }

  @Test
  public void testToLicenseReturnsNonRecognizedLicense() {
    String license = "Non-existent-license";
    assertEquals(License.NOT_RECOGNIZED, License.toLicense(license));
  }

  @Test
  public void testToStringOfACompliantLicense() {
    String license = "Apache-2.0";
    assertEquals("Apache-2.0 (Google-compliant)", License.toLicense(license).toString());
  }

  @Test
  public void testToStringOfANonCompliantLicense() {
    String license = "BCL";
    assertEquals("BCL (Not Google-compliant!)", License.toLicense(license).toString());
  }

  @Test
  public void testToStringOfANotRecognizedLicense() {
    String license = "Non-existent-license";
    assertEquals("Not-Recognized (Not Google-compliant!)", License.toLicense(license).toString());
  }
}
