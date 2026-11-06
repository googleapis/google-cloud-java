/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.TrafficForecastSegmentServiceClient.ListTrafficForecastSegmentsPagedResponse;

import com.google.ads.admanager.v1.stub.TrafficForecastSegmentServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TrafficForecastSegmentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTrafficForecastSegment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TrafficForecastSegmentServiceSettings.Builder trafficForecastSegmentServiceSettingsBuilder =
 *     TrafficForecastSegmentServiceSettings.newBuilder();
 * trafficForecastSegmentServiceSettingsBuilder
 *     .getTrafficForecastSegmentSettings()
 *     .setRetrySettings(
 *         trafficForecastSegmentServiceSettingsBuilder
 *             .getTrafficForecastSegmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * TrafficForecastSegmentServiceSettings trafficForecastSegmentServiceSettings =
 *     trafficForecastSegmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class TrafficForecastSegmentServiceSettings
    extends ClientSettings<TrafficForecastSegmentServiceSettings> {

  /** Returns the object with the settings used for calls to getTrafficForecastSegment. */
  public UnaryCallSettings<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .getTrafficForecastSegmentSettings();
  }

  /** Returns the object with the settings used for calls to listTrafficForecastSegments. */
  public PagedCallSettings<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .listTrafficForecastSegmentsSettings();
  }

  /** Returns the object with the settings used for calls to createTrafficForecastSegment. */
  public UnaryCallSettings<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .createTrafficForecastSegmentSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateTrafficForecastSegments. */
  public UnaryCallSettings<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .batchCreateTrafficForecastSegmentsSettings();
  }

  /** Returns the object with the settings used for calls to updateTrafficForecastSegment. */
  public UnaryCallSettings<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .updateTrafficForecastSegmentSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateTrafficForecastSegments. */
  public UnaryCallSettings<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsSettings() {
    return ((TrafficForecastSegmentServiceStubSettings) getStubSettings())
        .batchUpdateTrafficForecastSegmentsSettings();
  }

  public static final TrafficForecastSegmentServiceSettings create(
      TrafficForecastSegmentServiceStubSettings stub) throws IOException {
    return new TrafficForecastSegmentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TrafficForecastSegmentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TrafficForecastSegmentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TrafficForecastSegmentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TrafficForecastSegmentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TrafficForecastSegmentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TrafficForecastSegmentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TrafficForecastSegmentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TrafficForecastSegmentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TrafficForecastSegmentServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<TrafficForecastSegmentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(TrafficForecastSegmentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TrafficForecastSegmentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TrafficForecastSegmentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TrafficForecastSegmentServiceStubSettings.newBuilder());
    }

    public TrafficForecastSegmentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TrafficForecastSegmentServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getTrafficForecastSegment. */
    public UnaryCallSettings.Builder<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
        getTrafficForecastSegmentSettings() {
      return getStubSettingsBuilder().getTrafficForecastSegmentSettings();
    }

    /** Returns the builder for the settings used for calls to listTrafficForecastSegments. */
    public PagedCallSettings.Builder<
            ListTrafficForecastSegmentsRequest,
            ListTrafficForecastSegmentsResponse,
            ListTrafficForecastSegmentsPagedResponse>
        listTrafficForecastSegmentsSettings() {
      return getStubSettingsBuilder().listTrafficForecastSegmentsSettings();
    }

    /** Returns the builder for the settings used for calls to createTrafficForecastSegment. */
    public UnaryCallSettings.Builder<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
        createTrafficForecastSegmentSettings() {
      return getStubSettingsBuilder().createTrafficForecastSegmentSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchCreateTrafficForecastSegments.
     */
    public UnaryCallSettings.Builder<
            BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
        batchCreateTrafficForecastSegmentsSettings() {
      return getStubSettingsBuilder().batchCreateTrafficForecastSegmentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrafficForecastSegment. */
    public UnaryCallSettings.Builder<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
        updateTrafficForecastSegmentSettings() {
      return getStubSettingsBuilder().updateTrafficForecastSegmentSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchUpdateTrafficForecastSegments.
     */
    public UnaryCallSettings.Builder<
            BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
        batchUpdateTrafficForecastSegmentsSettings() {
      return getStubSettingsBuilder().batchUpdateTrafficForecastSegmentsSettings();
    }

    @Override
    public TrafficForecastSegmentServiceSettings build() throws IOException {
      return new TrafficForecastSegmentServiceSettings(this);
    }
  }
}
