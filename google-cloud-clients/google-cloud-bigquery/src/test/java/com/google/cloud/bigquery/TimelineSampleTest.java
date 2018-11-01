/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimelineSampleTest {

  private static final Long ELAPSED_MS = 1001L;
  private static final Long ACTIVE_UNITS = 500L;
  private static final Long COMPLETED_UNITS = 843L;
  private static final Long PENDING_UNITS = 14L;
  private static final Long SLOT_MILLIS = 1220012L;

  private static final TimelineSample TIMELINE_SAMPLE = TimelineSample.newBuilder()
      .setElapsedMs(ELAPSED_MS)
      .setActiveUnits(ACTIVE_UNITS)
      .setCompletedUnits(COMPLETED_UNITS)
      .setPendingUnits(PENDING_UNITS)
      .setSlotMillis(SLOT_MILLIS)
      .build();



  @Test
  public void testTimelineSampleBuilder() {
    assertEquals(ELAPSED_MS, TIMELINE_SAMPLE.getElapsedMs());
    assertEquals(ACTIVE_UNITS, TIMELINE_SAMPLE.getActiveUnits());
    assertEquals(COMPLETED_UNITS, TIMELINE_SAMPLE.getCompletedUnits());
    assertEquals(PENDING_UNITS, TIMELINE_SAMPLE.getPendingUnits());
    assertEquals(SLOT_MILLIS, TIMELINE_SAMPLE.getSlotMillis());
  }

  @Test
  public void TestEquals() {
    assertEquals(TIMELINE_SAMPLE, TIMELINE_SAMPLE);
  }

}
