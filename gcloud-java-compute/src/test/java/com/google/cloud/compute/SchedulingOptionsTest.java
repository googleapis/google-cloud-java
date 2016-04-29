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

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SchedulingOptionsTest {

  private static final SchedulingOptions SCHEDULING_OPTIONS = SchedulingOptions.preemptible();

  @Test
  public void testFactoryMethods() {
    assertTrue(SCHEDULING_OPTIONS.isPreemptible());
    assertFalse(SCHEDULING_OPTIONS.automaticRestart());
    assertEquals(SchedulingOptions.Maintenance.TERMINATE, SCHEDULING_OPTIONS.maintenance());
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    assertFalse(schedulingOptions.isPreemptible());
    assertTrue(schedulingOptions.automaticRestart());
    assertEquals(SchedulingOptions.Maintenance.MIGRATE, schedulingOptions.maintenance());
  }

  @Test
  public void testToAndFromPb() {
    compareSchedulingOptions(SCHEDULING_OPTIONS,
        SchedulingOptions.fromPb(SCHEDULING_OPTIONS.toPb()));
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    compareSchedulingOptions(schedulingOptions, SchedulingOptions.fromPb(schedulingOptions.toPb()));
  }

  public void compareSchedulingOptions(SchedulingOptions expected, SchedulingOptions value) {
    assertEquals(expected, value);
    assertEquals(expected.isPreemptible(), value.isPreemptible());
    assertEquals(expected.maintenance(), value.maintenance());
    assertEquals(expected.automaticRestart(), value.automaticRestart());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
