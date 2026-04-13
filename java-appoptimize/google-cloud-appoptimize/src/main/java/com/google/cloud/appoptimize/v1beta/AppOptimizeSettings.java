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

package com.google.cloud.appoptimize.v1beta;

import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListLocationsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListReportsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ReadReportPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.appoptimize.v1beta.stub.AppOptimizeStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AppOptimizeClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appoptimize.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppOptimizeSettings.Builder appOptimizeSettingsBuilder = AppOptimizeSettings.newBuilder();
 * appOptimizeSettingsBuilder
 *     .getReportSettings()
 *     .setRetrySettings(
 *         appOptimizeSettingsBuilder
 *             .getReportSettings()
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
 * AppOptimizeSettings appOptimizeSettings = appOptimizeSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppOptimizeSettings.Builder appOptimizeSettingsBuilder = AppOptimizeSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * appOptimizeSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AppOptimizeSettings extends ClientSettings<AppOptimizeSettings> {

  /** Returns the object with the settings used for calls to createReport. */
  public UnaryCallSettings<CreateReportRequest, Operation> createReportSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).createReportSettings();
  }

  /** Returns the object with the settings used for calls to createReport. */
  public OperationCallSettings<CreateReportRequest, Report, OperationMetadata>
      createReportOperationSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).createReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to getReport. */
  public UnaryCallSettings<GetReportRequest, Report> getReportSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).getReportSettings();
  }

  /** Returns the object with the settings used for calls to listReports. */
  public PagedCallSettings<ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
      listReportsSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).listReportsSettings();
  }

  /** Returns the object with the settings used for calls to deleteReport. */
  public UnaryCallSettings<DeleteReportRequest, Empty> deleteReportSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).deleteReportSettings();
  }

  /** Returns the object with the settings used for calls to readReport. */
  public PagedCallSettings<ReadReportRequest, ReadReportResponse, ReadReportPagedResponse>
      readReportSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).readReportSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AppOptimizeStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AppOptimizeSettings create(AppOptimizeStubSettings stub) throws IOException {
    return new AppOptimizeSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppOptimizeStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppOptimizeStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppOptimizeStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppOptimizeStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppOptimizeStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AppOptimizeStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppOptimizeStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppOptimizeStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AppOptimizeSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppOptimizeSettings. */
  public static class Builder extends ClientSettings.Builder<AppOptimizeSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppOptimizeStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppOptimizeSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppOptimizeStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppOptimizeStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AppOptimizeStubSettings.newHttpJsonBuilder());
    }

    public AppOptimizeStubSettings.Builder getStubSettingsBuilder() {
      return ((AppOptimizeStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createReport. */
    public UnaryCallSettings.Builder<CreateReportRequest, Operation> createReportSettings() {
      return getStubSettingsBuilder().createReportSettings();
    }

    /** Returns the builder for the settings used for calls to createReport. */
    public OperationCallSettings.Builder<CreateReportRequest, Report, OperationMetadata>
        createReportOperationSettings() {
      return getStubSettingsBuilder().createReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getReport. */
    public UnaryCallSettings.Builder<GetReportRequest, Report> getReportSettings() {
      return getStubSettingsBuilder().getReportSettings();
    }

    /** Returns the builder for the settings used for calls to listReports. */
    public PagedCallSettings.Builder<
            ListReportsRequest, ListReportsResponse, ListReportsPagedResponse>
        listReportsSettings() {
      return getStubSettingsBuilder().listReportsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReport. */
    public UnaryCallSettings.Builder<DeleteReportRequest, Empty> deleteReportSettings() {
      return getStubSettingsBuilder().deleteReportSettings();
    }

    /** Returns the builder for the settings used for calls to readReport. */
    public PagedCallSettings.Builder<ReadReportRequest, ReadReportResponse, ReadReportPagedResponse>
        readReportSettings() {
      return getStubSettingsBuilder().readReportSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public AppOptimizeSettings build() throws IOException {
      return new AppOptimizeSettings(this);
    }
  }
}
