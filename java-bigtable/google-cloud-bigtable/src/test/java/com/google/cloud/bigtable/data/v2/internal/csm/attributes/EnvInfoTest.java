/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.attributes;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.Attributes;
import java.util.Map;
import org.junit.jupiter.api.Test;

class EnvInfoTest {
  private static final Supplier<String> NULL_HOST = () -> null;

  @SuppressWarnings("UnnecessaryLambda")
  private static final Function<String, String> NULL_ENV = (ignored) -> null;

  @Test
  void testUid() {
    EnvInfo info1 = EnvInfo.detect(Attributes.empty(), NULL_ENV, NULL_HOST);
    EnvInfo info2 = EnvInfo.detect(Attributes.empty(), NULL_ENV, NULL_HOST);

    assertThat(info1.getUid()).isNotEmpty();
    assertThat(info2.getUid()).isNotEmpty();
    assertThat(info1.getUid()).isNotEqualTo(info2.getUid());
  }

  @Test
  void testUnknown() {
    EnvInfo envInfo = EnvInfo.detect(Attributes.empty(), NULL_ENV, NULL_HOST);
    assertThat(envInfo.getHostName()).isEmpty();
    assertThat(envInfo.getHostId()).isEmpty();
    assertThat(envInfo.getPlatform()).isEqualTo("unknown");
    assertThat(envInfo.getRegion()).isEqualTo("global");
  }

  @Test
  void testGce() {
    Attributes attributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_compute_engine")
            .put("cloud.account.id", "my-project")
            .put("cloud.region", "us-central1")
            .put("cloud.availability_zone", "us-central1-c")
            .put("host.id", "1234567890")
            .put("host.name", "my-vm-name")
            .build();
    EnvInfo envInfo = EnvInfo.detect(attributes, NULL_ENV, NULL_HOST);
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_compute_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-vm-name");
  }

  @Test
  void testGkeRegionalCluster() {
    Attributes attributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_kubernetes_engine")
            .put("cloud.account.id", "my-project")
            .put("cloud.region", "us-central1")
            .put("host.id", "1234567890")
            .build();
    Map<String, String> env = ImmutableMap.of("HOSTNAME", "my-hostname");

    EnvInfo envInfo = EnvInfo.detect(attributes, env::get, NULL_HOST);
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_kubernetes_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-hostname");
  }

  @Test
  void testGkeZonalCluster() {
    // Zonal GKE clusters report their location via cloud.availability_zone instead of cloud.region.
    Attributes attributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_kubernetes_engine")
            .put("cloud.account.id", "my-project")
            .put("cloud.availability_zone", "us-central1-c")
            .put("host.id", "1234567890")
            .build();
    Map<String, String> env = ImmutableMap.of("HOSTNAME", "my-hostname");

    EnvInfo envInfo = EnvInfo.detect(attributes, env::get, NULL_HOST);
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_kubernetes_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-hostname");
  }

  @Test
  void testGkeHostnameFallback() {
    Attributes attributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_kubernetes_engine")
            .put("cloud.account.id", "my-project")
            .put("cloud.region", "us-central1")
            .put("host.id", "1234567890")
            .build();
    EnvInfo envInfo = EnvInfo.detect(attributes, NULL_ENV, () -> "my-hostname");
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_kubernetes_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-hostname");
  }
}
