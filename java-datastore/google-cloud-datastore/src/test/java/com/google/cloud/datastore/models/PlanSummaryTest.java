/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore.models;

import com.google.cloud.Structs;
import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
import com.google.common.truth.Truth;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import org.junit.Test;

public class PlanSummaryTest {
  private final Struct struct1 =
      Struct.newBuilder()
          .putFields("key", Value.newBuilder().setStringValue("val").build())
          .build();
  private final Struct struct2 =
      Struct.newBuilder()
          .putFields("key2", Value.newBuilder().setStringValue("val2").build())
          .putFields("key3", Value.newBuilder().setStringValue("val3").build())
          .build();
  private final com.google.datastore.v1.PlanSummary proto =
      com.google.datastore.v1.PlanSummary.newBuilder()
          .addIndexesUsed(struct1)
          .addIndexesUsed(struct2)
          .build();
  private final PlanSummary planSummary = new PlanSummary(proto);

  @Test
  public void testModel() {
    Truth.assertThat(planSummary.getIndexesUsed())
        .isEqualTo(Lists.newArrayList(Structs.asMap(struct1), Structs.asMap(struct2)));
    Truth.assertThat(planSummary.getIndexesUsed().get(0).get("key")).isEqualTo("val");
  }

  @Test
  public void testEqualsAndHashcode() {
    com.google.datastore.v1.PlanSummary proto2 =
        com.google.datastore.v1.PlanSummary.newBuilder().addIndexesUsed(struct1).build();
    PlanSummary planSummary2 = new PlanSummary(proto2);
    EqualsTester equalsTester = new EqualsTester();
    equalsTester.addEqualityGroup(planSummary, planSummary).testEquals();

    Truth.assertThat(planSummary).isNotEqualTo(planSummary2);

    Truth.assertThat(planSummary.hashCode()).isEqualTo(planSummary.hashCode());
    Truth.assertThat(planSummary.hashCode()).isNotEqualTo(planSummary2.hashCode());
  }
}
