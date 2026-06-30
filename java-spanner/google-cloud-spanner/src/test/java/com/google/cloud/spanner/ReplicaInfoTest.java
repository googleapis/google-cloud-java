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

import static com.google.cloud.spanner.ReplicaInfo.ReplicaType.READ_WRITE;
import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.ReplicaInfo.ReplicaType;
import org.junit.Test;

public class ReplicaInfoTest {

  @Test
  public void testBuildReplicaInfo() {
    final String location = "Location";
    final ReplicaType type = READ_WRITE;
    final boolean defaultLeaderLocation = true;
    final com.google.spanner.admin.instance.v1.ReplicaInfo proto =
        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder().build();

    assertEquals(
        new ReplicaInfo(location, type, defaultLeaderLocation, proto),
        ReplicaInfo.newBuilder()
            .setLocation(location)
            .setType(type)
            .setDefaultLeaderLocation(defaultLeaderLocation)
            .setProto(proto)
            .build());
  }

  @Test
  public void testFromProto() {
    final com.google.spanner.admin.instance.v1.ReplicaInfo proto =
        com.google.spanner.admin.instance.v1.ReplicaInfo.newBuilder()
            .setLocation("Location")
            .setType(com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType.READ_WRITE)
            .setDefaultLeaderLocation(true)
            .build();

    assertEquals(
        new ReplicaInfo("Location", READ_WRITE, true, proto), ReplicaInfo.fromProto(proto));
  }
}
