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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public class ITGrpcMetricsTest {
  @Test
  public void testGrpcMetrics() {
    GrpcStorageOptions grpcStorageOptions = StorageOptions.grpc().build();
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.googleapis.com:443", "storage.googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:443");

    GCPResourceProvider resourceProvider = new GCPResourceProvider();
    Attributes detectedAttributes = resourceProvider.getAttributes();
    SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createMeterProvider(
            "monitoring.googleapis.com:443",
            grpcStorageOptions.getProjectId(),
            detectedAttributes,
            false);

    /*
     * SDKMeterProvider doesn't expose the relevant fields we want to test, but they are present in
     * the String representation, so we'll check that instead. Most of the resources are auto-set,
     * and will depend on environment, which could cause flakes to check. We're only responsible for
     * setting the project ID, endpoint, and Histogram boundaries, so we'll just check those
     */
    String result = provider.toString();

    // What the project ID will be will depend on the environment, so we just make sure it's present
    // and not null/empty
    assertThat(result).doesNotContain("project_id=\"\"");
    assertThat(result).doesNotContain("project_id=null");
    assertThat(result).contains("project_id");
    assertThat(result).contains("host_id");
    assertThat(result).contains("cloud_platform");
    assertThat(result).contains("location");
    assertThat(result).contains("instance_id");
    assertThat(result).contains("gcp.resource_type");
    assertThat(result).contains("api");

    // This is the check for the Seconds histogram boundary. We can't practically check for every
    // boundary,
    // but if *any* are present, that means they're different from the results and we successfully
    // set them
    assertThat(result).contains("1.2");

    // This is the check for the Size boundary
    assertThat(result).contains("131072");
  }

  @Test
  public void testGrpcMetrics_universeDomain() {
    assertThat("monitoring.my-universe-domain.com:443")
        .isEqualTo(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.my-universe-domain.com:443", "my-universe-domain.com"));
  }

  @Test
  public void testGrpcMetrics_private() {
    assertThat("private.googleapis.com:443")
        .isEqualTo(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "private.googleapis.com:443", null));
  }

  @Test
  public void testGrpcMetrics_restricted() {
    assertThat("restricted.googleapis.com:443")
        .isEqualTo(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "restricted.googleapis.com:443", null));
  }
}
