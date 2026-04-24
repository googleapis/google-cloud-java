/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;




import com.google.common.testing.EqualsTester;

import org.junit.jupiter.api.Test;

class LatLngTest {

  private static LatLng gp1 = new LatLng(37.422035, -122.084124);
  private static LatLng gp2 = new LatLng(0.0, 0.0);

  private static final String INVALID_LAT_MESSAGE =
      "latitude must be in the range [-90, 90] degrees";
  private static final String INVALID_LNG_MESSAGE =
      "latitude must be in the range [-180, 180] degrees";

  @Test
  void testLatLng() {
    assertEquals(37.422035, gp1.getLatitude(), 0);
    assertEquals(-122.084124, gp1.getLongitude(), 0);
  }

  @Test
  void testEquals() {
    EqualsTester equalsTester = new EqualsTester();
    equalsTester.addEqualityGroup(gp1, gp1).testEquals();
    assertNotEquals(gp1, gp2);
  }

  @Test
  void testUpperLatRange() {
    new LatLng(90, 0);
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new LatLng(91, 0));
    assertEquals(INVALID_LAT_MESSAGE, ex.getMessage());
  }

  @Test
  void testLowerLatRange() {
    new LatLng(-90, 0);
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new LatLng(-91, 0));
    assertEquals(INVALID_LAT_MESSAGE, ex.getMessage());
  }

  @Test
  void testUpperLngRange() {
    new LatLng(0, 180);
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new LatLng(0, 181));
    assertEquals(INVALID_LNG_MESSAGE, ex.getMessage());
  }

  @Test
  void testLowerLngRange() {
    new LatLng(0, 180);
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new LatLng(0, -181));
    assertEquals(INVALID_LNG_MESSAGE, ex.getMessage());
  }
}
