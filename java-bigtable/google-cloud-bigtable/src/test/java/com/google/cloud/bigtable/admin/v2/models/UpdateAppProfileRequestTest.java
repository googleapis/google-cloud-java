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

import com.google.bigtable.admin.v2.AppProfile.DataBoostIsolationReadOnly;
import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting;
import com.google.bigtable.admin.v2.AppProfile.StandardIsolation;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.Priority;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.StandardIsolationPolicy;
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateAppProfileRequestTest {
  @Test
  public void testToProto() {
    UpdateAppProfileRequest wrapper =
        UpdateAppProfileRequest.of("my-instance", "my-profile")
            .setDescription("my description")
            .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-cluster", true))
            .setIgnoreWarnings(true);

    assertThat(wrapper.toProto("my-project"))
        .isEqualTo(
            com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
                .setAppProfile(
                    com.google.bigtable.admin.v2.AppProfile.newBuilder()
                        .setName("projects/my-project/instances/my-instance/appProfiles/my-profile")
                        .setDescription("my description")
                        .setSingleClusterRouting(
                            SingleClusterRouting.newBuilder()
                                .setClusterId("my-cluster")
                                .setAllowTransactionalWrites(true)))
                .setIgnoreWarnings(true)
                .setUpdateMask(
                    FieldMask.newBuilder()
                        .addPaths("description")
                        .addPaths("single_cluster_routing"))
                .build());
  }

  @Test
  public void testUpdateExisting() {
    com.google.bigtable.admin.v2.AppProfile existingProto =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName("projects/my-project/instances/my-instance/appProfiles/my-profile")
            .setEtag("my-etag")
            .setDescription("description")
            .setMultiClusterRoutingUseAny(MultiClusterRoutingUseAny.getDefaultInstance())
            .build();

    AppProfile existingWrapper = AppProfile.fromProto(existingProto);

    UpdateAppProfileRequest updateWrapper =
        UpdateAppProfileRequest.of(existingWrapper).setDescription("new description");

    assertThat(updateWrapper.toProto("my-project"))
        .isEqualTo(
            com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
                .setAppProfile(existingProto.toBuilder().setDescription("new description"))
                .setUpdateMask(FieldMask.newBuilder().addPaths("description"))
                .build());
  }

  @Test
  public void testUpdateExistingStandardIsolation() {
    com.google.bigtable.admin.v2.AppProfile existingProto =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName("projects/my-project/instances/my-instance/appProfiles/my-profile")
            .setEtag("my-etag")
            .setDescription("description")
            .setMultiClusterRoutingUseAny(MultiClusterRoutingUseAny.getDefaultInstance())
            .setStandardIsolation(StandardIsolation.getDefaultInstance())
            .build();

    AppProfile existingWrapper = AppProfile.fromProto(existingProto);

    UpdateAppProfileRequest updateWrapper =
        UpdateAppProfileRequest.of(existingWrapper)
            .setIsolationPolicy(StandardIsolationPolicy.of(Priority.LOW));

    assertThat(updateWrapper.toProto("my-project"))
        .isEqualTo(
            com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
                .setAppProfile(
                    existingProto
                        .toBuilder()
                        .setStandardIsolation(
                            StandardIsolation.newBuilder()
                                .setPriority(
                                    com.google.bigtable.admin.v2.AppProfile.Priority.PRIORITY_LOW)
                                .build()))
                .setUpdateMask(FieldMask.newBuilder().addPaths("standard_isolation"))
                .build());
  }

  @Test
  public void testUpdateExistingDataBoostIsolationReadOnly() {
    com.google.bigtable.admin.v2.AppProfile existingProto =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName("projects/my-project/instances/my-instance/appProfiles/my-profile")
            .setEtag("my-etag")
            .setDescription("description")
            .setMultiClusterRoutingUseAny(MultiClusterRoutingUseAny.getDefaultInstance())
            .setStandardIsolation(StandardIsolation.getDefaultInstance())
            .build();

    AppProfile existingWrapper = AppProfile.fromProto(existingProto);

    UpdateAppProfileRequest updateWrapper =
        UpdateAppProfileRequest.of(existingWrapper)
            .setIsolationPolicy(
                AppProfile.DataBoostIsolationReadOnlyPolicy.of(
                    AppProfile.ComputeBillingOwner.HOST_PAYS));

    assertThat(updateWrapper.toProto("my-project"))
        .isEqualTo(
            com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
                .setAppProfile(
                    existingProto
                        .toBuilder()
                        .setDataBoostIsolationReadOnly(
                            DataBoostIsolationReadOnly.newBuilder()
                                .setComputeBillingOwner(
                                    DataBoostIsolationReadOnly.ComputeBillingOwner.HOST_PAYS)
                                .build()))
                .setUpdateMask(FieldMask.newBuilder().addPaths("data_boost_isolation_read_only"))
                .build());
  }

  @Test
  public void testUpdateRowAffinity() {
    com.google.bigtable.admin.v2.AppProfile existingProto =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName("projects/my-project/instances/my-instance/appProfiles/my-profile")
            .setEtag("my-etag")
            .setDescription("description")
            .setMultiClusterRoutingUseAny(MultiClusterRoutingUseAny.getDefaultInstance())
            .build();

    AppProfile existingWrapper = AppProfile.fromProto(existingProto);

    UpdateAppProfileRequest updateWrapper =
        UpdateAppProfileRequest.of(existingWrapper)
            .setRoutingPolicy(AppProfile.MultiClusterRoutingPolicy.withRowAffinity());

    assertThat(updateWrapper.toProto("my-project"))
        .isEqualTo(
            com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
                .setAppProfile(
                    existingProto
                        .toBuilder()
                        .setMultiClusterRoutingUseAny(
                            MultiClusterRoutingUseAny.newBuilder()
                                .setRowAffinity(
                                    MultiClusterRoutingUseAny.RowAffinity.getDefaultInstance())))
                .setUpdateMask(FieldMask.newBuilder().addPaths("multi_cluster_routing_use_any"))
                .build());
  }
}
