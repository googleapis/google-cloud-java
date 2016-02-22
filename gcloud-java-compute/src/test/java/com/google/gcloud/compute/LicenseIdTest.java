/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class LicenseIdTest {

  private static final String PROJECT = "project";
  private static final String LICENSE = "license";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/licenses/license";

  @Test
  public void testOf() {
    LicenseId licenseId = LicenseId.of(PROJECT, LICENSE);
    assertEquals(PROJECT, licenseId.project());
    assertEquals(LICENSE, licenseId.license());
    assertEquals(URL, licenseId.toUrl());
    licenseId = LicenseId.of(LICENSE);
    assertNull(licenseId.project());
    assertEquals(LICENSE, licenseId.license());
  }

  @Test
  public void testToAndFromUrl() {
    LicenseId licenseId = LicenseId.of(PROJECT, LICENSE);
    compareLicenseId(licenseId, LicenseId.fromUrl(licenseId.toUrl()));
  }

  @Test
  public void testSetProjectId() {
    LicenseId licenseId = LicenseId.of(PROJECT, LICENSE);
    assertSame(licenseId, licenseId.setProjectId(PROJECT));
    compareLicenseId(licenseId, LicenseId.of(LICENSE).setProjectId(PROJECT));
  }

  private void compareLicenseId(LicenseId expected, LicenseId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.license(), expected.license());
    assertEquals(expected.toUrl(), expected.toUrl());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
