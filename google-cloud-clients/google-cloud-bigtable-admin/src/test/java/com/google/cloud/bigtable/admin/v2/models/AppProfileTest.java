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

import com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AppProfileTest {
  private static final com.google.bigtable.admin.v2.AppProfile TEST_PROTO =
      com.google.bigtable.admin.v2.AppProfile.newBuilder()
          .setName(AppProfileName.of("my-project", "my-instance", "my-profile").toString())
          .setDescription("my description")
          .setSingleClusterRouting(
              SingleClusterRouting.newBuilder()
                  .setClusterId("my-cluster")
                  .setAllowTransactionalWrites(true)
                  .build()

          )
          .setEtag("my-etag")
          .build();

  @Test
  public void testFromProto() {
    AppProfile profile = AppProfile.fromProto(TEST_PROTO);

    assertThat(profile.getInstanceId()).isEqualTo("my-instance");
    assertThat(profile.getId()).isEqualTo("my-profile");
    assertThat(profile.getDescription()).isEqualTo("my description");
    assertThat(profile.getPolicy()).isEqualTo(SingleClusterRoutingPolicy.of("my-cluster", true));
  }

  @Test
  public void testNoNameError() {
    Exception actualException = null;

    try {
      AppProfile.fromProto(
          TEST_PROTO.toBuilder()
              .setName("")
              .build());
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testNoPolicyError() {
    Exception actualException = null;

    try {
      AppProfile.fromProto(
          TEST_PROTO.toBuilder()
              .clearSingleClusterRouting()
              .build());
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }
}
