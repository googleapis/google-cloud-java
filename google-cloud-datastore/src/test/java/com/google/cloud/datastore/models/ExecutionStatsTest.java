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
import com.google.common.testing.EqualsTester;
import com.google.common.truth.Truth;
import com.google.protobuf.Duration;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import org.junit.Test;

public class ExecutionStatsTest {
  private final Struct struct =
      Struct.newBuilder()
          .putFields("key", Value.newBuilder().setStringValue("val").build())
          .build();
  private final Duration duration = Duration.newBuilder().setSeconds(23).build();
  private final com.google.datastore.v1.ExecutionStats proto =
      com.google.datastore.v1.ExecutionStats.newBuilder()
          .setDebugStats(struct)
          .setExecutionDuration(duration)
          .setReadOperations(2)
          .setResultsReturned(3)
          .build();
  ExecutionStats executionStats = new ExecutionStats(proto);

  @Test
  public void testModel() {
    Truth.assertThat(executionStats.getDebugStats()).isEqualTo(Structs.asMap(struct));
    Truth.assertThat(executionStats.getExecutionDuration())
        .isEqualTo(org.threeten.bp.Duration.ofNanos(duration.getNanos()));
    Truth.assertThat(executionStats.getReadOperations()).isEqualTo(2);
    Truth.assertThat(executionStats.getResultsReturned()).isEqualTo(3);
  }

  @Test
  public void testEqualsAndHashcode() {
    com.google.datastore.v1.ExecutionStats proto2 =
        com.google.datastore.v1.ExecutionStats.newBuilder()
            .setDebugStats(struct)
            .setExecutionDuration(duration)
            .setReadOperations(6)
            .setResultsReturned(7)
            .build();

    ExecutionStats executionStats1 = new ExecutionStats(proto);
    ExecutionStats executionStats2 = new ExecutionStats(proto2);
    ExecutionStats executionStats3 = new ExecutionStats(proto2);

    Truth.assertThat(executionStats1).isNotEqualTo(executionStats2);
    Truth.assertThat(executionStats2).isEqualTo(executionStats3);

    EqualsTester equalsTester = new EqualsTester();
    equalsTester.addEqualityGroup(executionStats1, executionStats1).testEquals();

    Truth.assertThat(executionStats1.hashCode()).isNotEqualTo(executionStats2.hashCode());
    Truth.assertThat(executionStats2.hashCode()).isEqualTo(executionStats3.hashCode());
    Truth.assertThat(executionStats1.hashCode()).isEqualTo(executionStats1.hashCode());
  }
}
