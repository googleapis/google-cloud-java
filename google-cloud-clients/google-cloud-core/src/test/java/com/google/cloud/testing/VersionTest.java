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

package com.google.cloud.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VersionTest {

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testFromString() {
    Version version = Version.fromString("2016.01.13");
    assertEquals(2016, version.getMajor());
    assertEquals(1, version.getMinor());
    assertEquals(13, version.getPatch());
    version = Version.fromString("1.2.0");
    assertEquals(1, version.getMajor());
    assertEquals(2, version.getMinor());
    assertEquals(0, version.getPatch());
  }

  @Test
  public void testFromStringWithAlphas() {
    thrown.expect(IllegalArgumentException.class);
    Version.fromString("2016.01.hello");
  }

  @Test
  public void testFromStringMissingPatch() {
    thrown.expect(IllegalArgumentException.class);
    Version.fromString("2016.01");
  }

  @Test
  public void testFromStringMissingMinor() {
    thrown.expect(IllegalArgumentException.class);
    Version.fromString("2016");
  }

  @Test
  public void testFromStringEmpty() {
    thrown.expect(IllegalArgumentException.class);
    Version.fromString("");
  }

  @Test
  public void testFromStringNull() {
    thrown.expect(NullPointerException.class);
    Version.fromString(null);
  }

  @Test
  public void testCompare() {
    Version version = Version.fromString("2016.01.13");
    Version sameVersion = Version.fromString("2016.01.13");
    Version olderVersion = Version.fromString("2015.12.01");
    Version newerVersion = Version.fromString("2016.08.12");
    assertEquals(0, version.compareTo(sameVersion));
    assertTrue(version.compareTo(olderVersion) > 0);
    assertTrue(version.compareTo(newerVersion) < 0);
    Version otherVersion = Version.fromString("1.2.0");
    assertTrue(version.compareTo(otherVersion) > 0);
  }
}
