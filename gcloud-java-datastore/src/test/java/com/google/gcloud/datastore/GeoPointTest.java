/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeoPointTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private static GeoPoint gp1 = new GeoPoint(10.5, 20.5);
  private static GeoPoint gp2 = new GeoPoint(10.5, 30.5);

  private static final String INVALID_LAT_MESSAGE =
      "latitude must be in the range [-90, 90] degrees";
  private static final String INVALID_LNG_MESSAGE =
      "latitude must be in the range [-180, 180] degrees";

  @Test
  public void testEquals() {
    assertEquals(gp1, gp1);
    assertNotEquals(gp1, gp2);
  }

  @Test
  public void testUpperLatRange() {
    new GeoPoint(90, 0);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(INVALID_LAT_MESSAGE);
    new GeoPoint(91, 0);
  }

  @Test
  public void testLowerLatRange() {
    new GeoPoint(-90, 0);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(INVALID_LAT_MESSAGE);
    new GeoPoint(-91, 0);
  }

  @Test
  public void testUpperLngRange() {
    new GeoPoint(0, 180);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(INVALID_LNG_MESSAGE);
    new GeoPoint(0, 181);
  }

  @Test
  public void testLowerLngRange() {
    new GeoPoint(0, 180);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(INVALID_LNG_MESSAGE);
    new GeoPoint(0, -181);
  }
}

