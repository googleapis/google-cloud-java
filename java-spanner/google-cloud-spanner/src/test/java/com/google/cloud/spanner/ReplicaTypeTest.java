/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.ReplicaInfo.ReplicaType;
import org.junit.Test;

public class ReplicaTypeTest {

  @Test
  public void testTypeUnspecifiedReplicaType() {
    final ReplicaType replicaType =
        ReplicaType.fromProto(
            com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.TYPE_UNSPECIFIED);

    assertEquals(ReplicaType.TYPE_UNSPECIFIED, replicaType);
  }

  @Test
  public void testReadWriteReplicaType() {
    final ReplicaType replicaType =
        ReplicaType.fromProto(
            com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.READ_WRITE);

    assertEquals(ReplicaType.READ_WRITE, replicaType);
  }

  @Test
  public void testReadOnlyReplicaType() {
    final ReplicaType replicaType =
        ReplicaType.fromProto(
            com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.READ_ONLY);

    assertEquals(ReplicaType.READ_ONLY, replicaType);
  }

  @Test
  public void testWitnessReplicaType() {
    final ReplicaType replicaType =
        ReplicaType.fromProto(com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.WITNESS);

    assertEquals(ReplicaType.WITNESS, replicaType);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUnrecognizedReplicaType() {
    ReplicaType.fromProto(
        com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.UNRECOGNIZED);
  }
}
