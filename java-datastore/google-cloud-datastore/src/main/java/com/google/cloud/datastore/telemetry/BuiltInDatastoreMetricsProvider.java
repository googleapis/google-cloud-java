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

import com.google.api.gax.core.GaxProperties;
import com.google.auth.Credentials;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.resources.Resource;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
public final class BuiltInDatastoreMetricsProvider {

  public static final BuiltInDatastoreMetricsProvider INSTANCE =
      new BuiltInDatastoreMetricsProvider();

  private static final Logger logger =
      Logger.getLogger(BuiltInDatastoreMetricsProvider.class.getName());

  private static String taskId;
  private static String location;
  private static final String DEFAULT_LOCATION = "global";

  private final Map<String, String> cachedClientAttributes;

  private BuiltInDatastoreMetricsProvider() {
    cachedClientAttributes = Collections.unmodifiableMap(buildClientAttributes());
  }

  private Map<String, String> buildClientAttributes() {
    Map<String, String> attrs = new HashMap<>();
    attrs.put(
        TelemetryConstants.CLIENT_NAME_KEY.getKey(),
        "datastore-java/" + GaxProperties.getLibraryVersion(getClass()));
    attrs.put(TelemetryConstants.CLIENT_UID_KEY.getKey(), getDefaultTaskValue());
    attrs.put(TelemetryConstants.SERVICE_KEY.getKey(), TelemetryConstants.SERVICE_VALUE);
    return attrs;
  }

  /**
   * Creates a new {@link OpenTelemetry} instance for a single Datastore client's built-in metrics.
   *
   * <p>Each call returns a dedicated {@link SdkMeterProvider} configured with the provided
   * project's monitored resource attributes and a {@link DatastoreCloudMonitoringExporter}. A
   * shutdown hook is registered to flush and close the provider when the JVM exits.
   *
   * <p>Callers are responsible for holding the returned instance for the lifetime of their
   * Datastore client; no caching is performed here.
   *
   * @param projectId the GCP project ID.
   * @param databaseId the Datastore database ID.
   * @param credentials the credentials to use for exporting metrics.
   * @return a new {@link OpenTelemetry} instance, or {@code null} if it could not be created.
   */
  @Nullable
  public OpenTelemetry createOpenTelemetry(
      @Nonnull String projectId, @Nonnull String databaseId, @Nullable Credentials credentials) {
    try {
      SdkMeterProviderBuilder sdkMeterProviderBuilder = SdkMeterProvider.builder();
      // Register Datastore-specific views and the PeriodicMetricReader.
      DatastoreBuiltInMetricsView.registerBuiltinMetrics(
          DatastoreCloudMonitoringExporter.create(projectId, credentials), sdkMeterProviderBuilder);
      // Configure the monitored resource attributes for this specific client.
      sdkMeterProviderBuilder.setResource(
          Resource.create(createResourceAttributes(projectId, databaseId)));
      SdkMeterProvider sdkMeterProvider = sdkMeterProviderBuilder.build();
      // Ensure cleanup on shutdown.
      Runtime.getRuntime().addShutdownHook(new Thread(sdkMeterProvider::close));
      return OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
    } catch (IOException ex) {
      logger.log(
          Level.WARNING,
          "Unable to create OpenTelemetry instance for client side metrics, will skip exporting"
              + " built-in metrics",
          ex);
      return null;
    }
  }

  /**
   * Detects the client's GCP location (region).
   *
   * <p>To avoid dependencies on external resource detection libraries, this implementation
   * currently defaults to "global".
   *
   * @return the detected location, or "global" if detection fails.
   */
  public static String detectClientLocation() {
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

  /**
   * Returns common client attributes added to every exported metric data point.
   *
   * <p>The returned map is pre-computed at construction time and shared across all export calls,
   * since {@code client_name}, {@code client_uid}, and {@code service} are stable for the lifetime
   * of the process.
   *
   * @return an unmodifiable map of client attributes.
   */
  Map<String, String> createClientAttributes() {
    return cachedClientAttributes;
  }

  /**
   * Generates a unique identifier for the {@code client_uid} metric field.
   *
   * <p>Uses {@code RuntimeMXBean.getName()} which typically returns {@code pid@hostname}.
   *
   * @return a unique identifier string.
   */
  private static String getDefaultTaskValue() {
    if (taskId == null) {
      taskId = ManagementFactory.getRuntimeMXBean().getName();
    }
    return taskId;
  }
}
