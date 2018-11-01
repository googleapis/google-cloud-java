/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LicenseTest {

  private static final LicenseId LICENSE_ID = LicenseId.of("project", "license");
  private static final Boolean CHARGES_USE_FEE = true;
  private static final License LICENSE = new License(LICENSE_ID, CHARGES_USE_FEE);

  @Test
  public void testBuilder() {
    assertEquals(LICENSE_ID, LICENSE.getLicenseId());
    assertEquals(CHARGES_USE_FEE, LICENSE.chargesUseFee());
  }

  @Test
  public void testToAndFromPb() {
    License license = License.fromPb(LICENSE.toPb());
    compareLicenses(LICENSE, license);
    assertEquals(LICENSE_ID.getProject(), license.getLicenseId().getProject());
    assertEquals(LICENSE_ID.getLicense(), license.getLicenseId().getLicense());
  }

  private void compareLicenses(License expected, License value) {
    assertEquals(expected, value);
    assertEquals(expected.getLicenseId(), value.getLicenseId());
    assertEquals(expected.chargesUseFee(), value.chargesUseFee());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
