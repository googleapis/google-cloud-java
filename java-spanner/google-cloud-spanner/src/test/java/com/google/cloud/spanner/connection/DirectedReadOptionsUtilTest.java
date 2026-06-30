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

package com.google.cloud.spanner.connection;

import static junit.framework.TestCase.assertEquals;

import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.ExcludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests converting {@link DirectedReadOptions} to/from JSON. The test cases here are not very
 * extensive, as it a very simple wrapper around the {@link com.google.protobuf.util.JsonFormat}
 * class, which has its own test suite. The tests in this class only serve as a simple verification
 * that the formatter works as expected.
 */
@RunWith(JUnit4.class)
public class DirectedReadOptionsUtilTest {

  @Test
  public void testToString() {
    assertRoundTrip("", DirectedReadOptions.newBuilder().build());
    assertRoundTrip(
        "{\"includeReplicas\":{}}",
        DirectedReadOptions.newBuilder()
            .setIncludeReplicas(IncludeReplicas.newBuilder().build())
            .build());
    assertRoundTrip(
        "{\"includeReplicas\":{\"replicaSelections\":[{\"location\":\"eu-west1\",\"type\":\"READ_ONLY\"}]}}",
        DirectedReadOptions.newBuilder()
            .setIncludeReplicas(
                IncludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder()
                            .setType(Type.READ_ONLY)
                            .setLocation("eu-west1")
                            .build())
                    .build())
            .build());
    assertRoundTrip(
        "{\"excludeReplicas\":{\"replicaSelections\":[{\"location\":\"eu-west1\",\"type\":\"READ_ONLY\"}]}}",
        DirectedReadOptions.newBuilder()
            .setExcludeReplicas(
                ExcludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder()
                            .setType(Type.READ_ONLY)
                            .setLocation("eu-west1")
                            .build())
                    .build())
            .build());
  }

  private void assertRoundTrip(String json, DirectedReadOptions options) {
    assertEquals(json, DirectedReadOptionsUtil.toString(options));
    assertEquals(options, DirectedReadOptionsUtil.parse(json));
  }
}
