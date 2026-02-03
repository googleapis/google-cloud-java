/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.logging;

import static com.google.protobuf.util.Timestamps.fromMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.google.protobuf.Timestamp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExclusionTest {

  private static final String EXCLUSION_NAME = "load-balancer-exclusion";
  private static final String DESCRIPTION = "description";
  private static final String EXCLUSION_FILTER =
      "resource.type=gcs_bucket severity<ERROR sample(insertId, 0.99)";
  private static final Boolean DISABLED = Boolean.FALSE;
  private static final Timestamp EXCLUSION_CREATED_TIME = fromMillis(System.currentTimeMillis());
  private static final Exclusion EXCLUSION =
      Exclusion.newBuilder(EXCLUSION_NAME, EXCLUSION_FILTER)
          .setDisabled(DISABLED)
          .setDescription(DESCRIPTION)
          .setCreateTime(EXCLUSION_CREATED_TIME)
          .build();
  private static final String NEW_EXCLUSION_NAME = "load-balancer-exclusion";
  private static final String NEW_DESCRIPTION = "description";
  private static final String NEW_EXCLUSION_FILTER =
      "resource.type=gcs_bucket severity<ERROR sample(insertId, 0.99)";
  private static final Boolean NEW_DISABLED = Boolean.FALSE;
  private static final Timestamp NEW_EXCLUSION_CREATED_TIME =
      fromMillis(System.currentTimeMillis());

  @Test
  public void testBuilder() {
    assertEquals(EXCLUSION_NAME, EXCLUSION.getName());
    assertEquals(DESCRIPTION, EXCLUSION.getDescription());
    assertEquals(EXCLUSION_FILTER, EXCLUSION.getFilter());
    assertEquals(DISABLED, EXCLUSION.isDisabled());
    assertEquals(EXCLUSION_CREATED_TIME, EXCLUSION.getCreateTime());
  }

  @Test
  public void testToBuilder() {
    compareExclusion(EXCLUSION, EXCLUSION.toBuilder().build());
    Exclusion exclusion =
        EXCLUSION.toBuilder()
            .setName(NEW_EXCLUSION_NAME)
            .setDisabled(NEW_DISABLED)
            .setDescription(NEW_DESCRIPTION)
            .setFilter(NEW_EXCLUSION_FILTER)
            .setCreateTime(NEW_EXCLUSION_CREATED_TIME)
            .build();
    assertEquals(NEW_EXCLUSION_NAME, exclusion.getName());
    assertEquals(NEW_EXCLUSION_FILTER, exclusion.getFilter());
    assertEquals(NEW_DESCRIPTION, exclusion.getDescription());
    assertEquals(NEW_DISABLED, exclusion.isDisabled());
    assertEquals(NEW_EXCLUSION_CREATED_TIME, exclusion.getCreateTime());

    exclusion =
        exclusion.toBuilder()
            .setName(EXCLUSION_NAME)
            .setDescription(DESCRIPTION)
            .setFilter(EXCLUSION_FILTER)
            .setDisabled(DISABLED)
            .setDescription(DESCRIPTION)
            .setCreateTime(EXCLUSION_CREATED_TIME)
            .build();
    compareExclusion(EXCLUSION, exclusion);
  }

  @Test
  public void testToAndFromProtobuf() {
    compareExclusion(EXCLUSION, Exclusion.fromProtobuf(EXCLUSION.toProtobuf()));
    Exclusion exclusion = Exclusion.of(EXCLUSION_NAME, EXCLUSION_FILTER);
    compareExclusion(exclusion, Exclusion.fromProtobuf(exclusion.toProtobuf()));
  }

  @Test
  public void testOf() {
    Exclusion exclusion = Exclusion.of(EXCLUSION_NAME, EXCLUSION_FILTER);
    assertEquals(EXCLUSION_NAME, exclusion.getName());
    assertEquals(EXCLUSION_FILTER, exclusion.getFilter());
    assertNull(exclusion.getDescription());
    assertNull(exclusion.getCreateTime());
    assertFalse(exclusion.isDisabled());
  }

  public void compareExclusion(Exclusion expected, Exclusion actual) {
    assertEquals(expected, actual);
    assertEquals(expected.toString(), actual.toString());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
    assertEquals(expected.getFilter(), actual.getFilter());
    assertEquals(expected.isDisabled(), actual.isDisabled());
    assertEquals(expected.getCreateTime(), actual.getCreateTime());
  }
}
