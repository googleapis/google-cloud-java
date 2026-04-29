/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.datastore.telemetry;

import com.google.api.core.InternalApi;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Provides a built-in {@link OpenTelemetry} instance for Datastore client-side metrics.
 *
 * <p>This class is responsible for configuring a private {@link OpenTelemetrySdk} that exports
 * metrics to Google Cloud Monitoring using a {@link DatastoreCloudMonitoringExporter}.
 *
 * <p>The implementation follows the pattern used in other Google Cloud client libraries, providing
 * automated environment detection and resource attribute configuration for the {@link
 * TelemetryConstants#DATASTORE_RESOURCE_TYPE} monitored resource.
 */
@InternalApi
public class BuiltInDatastoreMetricsProvider {

  public static final BuiltInDatastoreMetricsProvider INSTANCE =
      new BuiltInDatastoreMetricsProvider();

  private static final Logger logger =
      Logger.getLogger(BuiltInDatastoreMetricsProvider.class.getName());

  // volatile ensures that writes from one thread (first call to detectClientLocation) are
  // immediately visible to all other threads sharing this singleton INSTANCE. Without it, a
  // thread could read a stale null and re-enter the initialization branch.
  private static volatile String location;
  private static final String DEFAULT_LOCATION = "global";

  private BuiltInDatastoreMetricsProvider() {}

  static Map<String, String> buildClientAttributes() {
    Map<String, String> attrs = new HashMap<>();
    attrs.put(
        TelemetryConstants.CLIENT_UID_KEY.getKey(), hashClientUId(UUID.randomUUID().toString()));
    attrs.put(TelemetryConstants.SERVICE_KEY.getKey(), TelemetryConstants.SERVICE_VALUE);
    return attrs;
  }

  /**
   * Generates a 6-digit zero-padded all lower case hexadecimal representation of hash of the
   * accounting group. The hash utilizes the 10 most significant bits of the value returned by
   * `Hashing.goodFastHash(64).hashBytes()`, so effectively the returned values are uniformly
   * distributed in the range [000000, 0003ff].
   *
   * <p>The primary purpose of this function is to generate a hash value for the `client_uid` metric
   * field. The range of values is chosen to be small enough to keep the cardinality under control.
   *
   * <p>Note: If at later time the range needs to be increased, it can be done by increasing the
   * value of `kPrefixLength` to up to 24 bits without changing the format of the returned value.
   *
   * @return Returns a 6-digit zero-padded all lower case hexadecimal representation of hash of the
   *     accounting group.
   */
  private static String hashClientUId(String uuid) {
    if (uuid == null) {
      return "000000";
    }

    HashFunction hashFunction = Hashing.goodFastHash(64);
    long hash = hashFunction.hashBytes(uuid.getBytes()).asLong();
    // Don't change this value without reading above comment
    int kPrefixLength = 10;
    long shiftedValue = hash >>> (64 - kPrefixLength);
    return String.format("%06x", shiftedValue);
  }

  /**
   * Creates a new {@link OpenTelemetry} instance for a single Datastore client's built-in metrics.
   *
   * <p>Each call returns a dedicated {@link OpenTelemetrySdk} wrapping an {@link SdkMeterProvider}
   * configured with the provided project's monitored resource attributes and a {@link
   * DatastoreCloudMonitoringExporter}. No global or shared state is modified.
   *
   * <p><b>Lifecycle:</b> The returned instance is owned by the caller. It should be closed by
   * calling {@link io.opentelemetry.sdk.OpenTelemetrySdk#close()} (or via {@link
   * OpenTelemetryDatastoreMetricsRecorder#close()}) when the associated Datastore client is closed.
   *
   * <p>No caching is performed here; callers are responsible for holding the returned instance for
   * the lifetime of their Datastore client.
   *
   * @param options Datastore Client Options
   * @return a new {@link OpenTelemetry} instance, or {@code null} if it could not be created.
   */
  @Nullable
  public OpenTelemetry createOpenTelemetry(@Nonnull DatastoreOptions options) {
    Credentials credentials =
        Preconditions.checkNotNull(
            options.getCredentials(), "Credentials cannot be null for built in metrics");
    String projectId = options.getProjectId();
    String databaseId = options.getDatabaseId();

    // No need to send metrics when using an emulator
    String emulatorHost =
        System.getProperty(
            DatastoreOptions.LOCAL_HOST_ENV_VAR,
            System.getenv(DatastoreOptions.LOCAL_HOST_ENV_VAR));
    boolean emulatorEnabled = emulatorHost != null && !emulatorHost.isEmpty();

    if (emulatorEnabled) {
      logger.log(Level.FINE, "Emulator detected in Datastore. Metrics are not being recorded.");
      return OpenTelemetry.noop();
    }
    if (credentials instanceof NoCredentials) {
      logger.log(Level.WARNING, "Built-in metrics exporting is disabled when using NoCredentials.");
      return OpenTelemetry.noop();
    }

    SdkMeterProviderBuilder sdkMeterProviderBuilder = SdkMeterProvider.builder();
    Map<String, String> clientAttributes = buildClientAttributes();
    DatastoreCloudMonitoringExporter exporter =
        DatastoreCloudMonitoringExporter.create(
            projectId, databaseId, credentials, clientAttributes);
    if (exporter == null) {
      logger.log(
          Level.WARNING,
          "Built-in metrics exporting is disabled as the exporter could not be created.");
      return OpenTelemetry.noop();
    }

    // Register Datastore-specific views and the PeriodicMetricReader.
    DatastoreBuiltInMetricsView.registerBuiltinMetrics(exporter, sdkMeterProviderBuilder);
    // Configure the monitored resource attributes for this specific client.
    sdkMeterProviderBuilder.setResource(
        Resource.create(createResourceAttributes(projectId, databaseId)));
    SdkMeterProvider sdkMeterProvider = sdkMeterProviderBuilder.build();
    return OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
  }

  /**
   * Detects the client's GCP location (region).
   *
   * <p>To avoid dependencies on external resource detection libraries, this implementation
   * currently defaults to "global".
   *
   * @return the detected location, or "global" if detection fails.
   */
  String detectClientLocation() {
    if (location == null) {
      location = DEFAULT_LOCATION;
    }
    return location;
  }

  /**
   * Creates resource attributes for the {@link TelemetryConstants#DATASTORE_RESOURCE_TYPE}
   * monitored resource.
   *
   * <p>These attributes are attached to the OTel {@link Resource} and used by the exporter to
   * populate the resource labels in Cloud Monitoring.
   *
   * @param projectId the GCP project ID.
   * @param databaseId the Datastore database ID.
   * @return the resource attributes.
   */
  Attributes createResourceAttributes(String projectId, String databaseId) {
    AttributesBuilder attributesBuilder =
        Attributes.builder()
            .put(TelemetryConstants.PROJECT_ID_KEY, projectId)
            .put(TelemetryConstants.DATABASE_ID_KEY, databaseId)
            .put(TelemetryConstants.LOCATION_ID_KEY, detectClientLocation());
    return attributesBuilder.build();
  }
}
