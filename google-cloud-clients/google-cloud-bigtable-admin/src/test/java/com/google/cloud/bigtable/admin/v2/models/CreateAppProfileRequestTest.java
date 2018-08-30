/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateAppProfileRequestTest {
  @Test
  public void testToProto() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setDescription("my description")
        .setRoutingPolicy(
            SingleClusterRoutingPolicy.of("my-cluster", true)
        )
        .setIgnoreWarnings(true);

    assertThat(wrapper.toProto(ProjectName.of("my-project"))).isEqualTo(
        com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder()
            .setParent(InstanceName.of("my-project", "my-instance").toString())
            .setAppProfileId("my-profile")
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setDescription("my description")
                    .setSingleClusterRouting(
                        SingleClusterRouting.newBuilder()
                            .setClusterId("my-cluster")
                            .setAllowTransactionalWrites(true)
                    )
            )
            .setIgnoreWarnings(true)
            .build()
    );
  }

  @Test
  public void testMultiClusterRouting() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setRoutingPolicy(MultiClusterRoutingPolicy.of());

    assertThat(wrapper.toProto(ProjectName.of("my-project")).getAppProfile()
        .getMultiClusterRoutingUseAny())
        .isEqualTo(MultiClusterRoutingUseAny.getDefaultInstance());
  }

  @Test
  public void testDefaultDescription() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setRoutingPolicy(MultiClusterRoutingPolicy.of());

    assertThat(wrapper.toProto(ProjectName.of("my-project")).getAppProfile().getDescription())
        .isEqualTo(
            "my-profile"
        );
  }
}
