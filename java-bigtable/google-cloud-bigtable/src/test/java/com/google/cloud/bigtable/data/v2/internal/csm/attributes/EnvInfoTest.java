/*
 * Copyright 2025 Google LLC
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
import static org.mockito.Mockito.when;

import com.google.cloud.opentelemetry.detection.DetectedPlatform;
import com.google.cloud.opentelemetry.detection.GCPPlatformDetector.SupportedPlatform;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnvInfoTest {
  private static final Supplier<String> NULL_HOST = Suppliers.ofInstance(null);

  @SuppressWarnings("UnnecessaryLambda")
  private static final Function<String, String> NULL_ENV = (ignored) -> null;

  @Mock private DetectedPlatform detectedPlatform;

  @Test
  void testUid() {
    when(detectedPlatform.getSupportedPlatform()).thenReturn(SupportedPlatform.UNKNOWN_PLATFORM);

    EnvInfo info1 = EnvInfo.detect(detectedPlatform, NULL_ENV, NULL_HOST);
    EnvInfo info2 = EnvInfo.detect(detectedPlatform, NULL_ENV, NULL_HOST);

    assertThat(info1.getUid()).isNotEmpty();
    assertThat(info2.getUid()).isNotEmpty();
    assertThat(info1.getUid()).isNotEqualTo(info2.getUid());
  }

  @Test
  void testUnknown() {
    when(detectedPlatform.getSupportedPlatform()).thenReturn(SupportedPlatform.UNKNOWN_PLATFORM);
    EnvInfo envInfo = EnvInfo.detect(detectedPlatform, NULL_ENV, NULL_HOST);
    assertThat(envInfo.getHostName()).isEmpty();
    assertThat(envInfo.getHostId()).isEmpty();
    assertThat(envInfo.getPlatform()).isEqualTo("unknown");
    assertThat(envInfo.getRegion()).isEqualTo("global");
  }

  @Test
  void testGce() {
    when(detectedPlatform.getSupportedPlatform())
        .thenReturn(SupportedPlatform.GOOGLE_COMPUTE_ENGINE);
    when(detectedPlatform.getProjectId()).thenReturn("my-project");
    when(detectedPlatform.getAttributes())
        .thenReturn(
            ImmutableMap.of(
                "machine_type", "n2-standard-8",
                "availability_zone", "us-central1-c",
                "instance_id", "1234567890",
                "instance_name", "my-vm-name",
                "cloud_region", "us-central1",
                "instance_hostname", "my-vm-name.us-central1-c.c.my-project.google.com.internal"));
    EnvInfo envInfo = EnvInfo.detect(detectedPlatform, NULL_ENV, NULL_HOST);
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_compute_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-vm-name");
  }

  @Test
  void testGke() {
    when(detectedPlatform.getSupportedPlatform())
        .thenReturn(SupportedPlatform.GOOGLE_KUBERNETES_ENGINE);
    when(detectedPlatform.getProjectId()).thenReturn("my-project");
    when(detectedPlatform.getAttributes())
        .thenReturn(
            ImmutableMap.of(
                "gke_cluster_name", "my-cluster",
                "gke_cluster_location", "us-central1",
                "gke_cluster_location_type", "country-region",
                "instance_id", "1234567890"));
    Map<String, String> env = ImmutableMap.of("HOSTNAME", "my-hostname");

    EnvInfo envInfo = EnvInfo.detect(detectedPlatform, env::get, NULL_HOST);
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_kubernetes_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-hostname");
  }

  @Test
  void testGkeHostanmeFallback() {
    when(detectedPlatform.getSupportedPlatform())
        .thenReturn(SupportedPlatform.GOOGLE_KUBERNETES_ENGINE);
    when(detectedPlatform.getProjectId()).thenReturn("my-project");
    when(detectedPlatform.getAttributes())
        .thenReturn(
            ImmutableMap.of(
                "gke_cluster_name", "my-cluster",
                "gke_cluster_location", "us-central1",
                "gke_cluster_location_type", "country-region",
                "instance_id", "1234567890"));
    EnvInfo envInfo = EnvInfo.detect(detectedPlatform, NULL_ENV, () -> "my-hostname");
    assertThat(envInfo.getPlatform()).isEqualTo("gcp_kubernetes_engine");
    assertThat(envInfo.getProject()).isEqualTo("my-project");
    assertThat(envInfo.getRegion()).isEqualTo("us-central1");
    assertThat(envInfo.getHostId()).isEqualTo("1234567890");
    assertThat(envInfo.getHostName()).isEqualTo("my-hostname");
  }
}
