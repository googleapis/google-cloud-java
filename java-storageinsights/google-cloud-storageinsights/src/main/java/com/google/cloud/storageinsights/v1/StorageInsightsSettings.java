/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storageinsights.v1;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListDatasetConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.stub.StorageInsightsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageInsightsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storageinsights.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getReportConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageInsightsSettings.Builder storageInsightsSettingsBuilder =
 *     StorageInsightsSettings.newBuilder();
 * storageInsightsSettingsBuilder
 *     .getReportConfigSettings()
 *     .setRetrySettings(
 *         storageInsightsSettingsBuilder
 *             .getReportConfigSettings()
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
 * StorageInsightsSettings storageInsightsSettings = storageInsightsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDatasetConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageInsightsSettings.Builder storageInsightsSettingsBuilder =
 *     StorageInsightsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * storageInsightsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StorageInsightsSettings extends ClientSettings<StorageInsightsSettings> {

  /** Returns the object with the settings used for calls to listReportConfigs. */
  public PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).listReportConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getReportConfig. */
  public UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).getReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public UnaryCallSettings<CreateReportConfigRequest, ReportConfig> createReportConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).createReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateReportConfig. */
  public UnaryCallSettings<UpdateReportConfigRequest, ReportConfig> updateReportConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).updateReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public UnaryCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).deleteReportConfigSettings();
  }

  /** Returns the object with the settings used for calls to listReportDetails. */
  public PagedCallSettings<
          ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
      listReportDetailsSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).listReportDetailsSettings();
  }

  /** Returns the object with the settings used for calls to getReportDetail. */
  public UnaryCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).getReportDetailSettings();
  }

  /** Returns the object with the settings used for calls to listDatasetConfigs. */
  public PagedCallSettings<
          ListDatasetConfigsRequest, ListDatasetConfigsResponse, ListDatasetConfigsPagedResponse>
      listDatasetConfigsSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).listDatasetConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getDatasetConfig. */
  public UnaryCallSettings<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).getDatasetConfigSettings();
  }

  /** Returns the object with the settings used for calls to createDatasetConfig. */
  public UnaryCallSettings<CreateDatasetConfigRequest, Operation> createDatasetConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).createDatasetConfigSettings();
  }

  /** Returns the object with the settings used for calls to createDatasetConfig. */
  public OperationCallSettings<CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      createDatasetConfigOperationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).createDatasetConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDatasetConfig. */
  public UnaryCallSettings<UpdateDatasetConfigRequest, Operation> updateDatasetConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).updateDatasetConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateDatasetConfig. */
  public OperationCallSettings<UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      updateDatasetConfigOperationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).updateDatasetConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatasetConfig. */
  public UnaryCallSettings<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).deleteDatasetConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatasetConfig. */
  public OperationCallSettings<DeleteDatasetConfigRequest, Empty, OperationMetadata>
      deleteDatasetConfigOperationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).deleteDatasetConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to linkDataset. */
  public UnaryCallSettings<LinkDatasetRequest, Operation> linkDatasetSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).linkDatasetSettings();
  }

  /** Returns the object with the settings used for calls to linkDataset. */
  public OperationCallSettings<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
      linkDatasetOperationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).linkDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to unlinkDataset. */
  public UnaryCallSettings<UnlinkDatasetRequest, Operation> unlinkDatasetSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).unlinkDatasetSettings();
  }

  /** Returns the object with the settings used for calls to unlinkDataset. */
  public OperationCallSettings<UnlinkDatasetRequest, Empty, OperationMetadata>
      unlinkDatasetOperationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).unlinkDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((StorageInsightsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final StorageInsightsSettings create(StorageInsightsStubSettings stub)
      throws IOException {
    return new StorageInsightsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StorageInsightsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StorageInsightsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StorageInsightsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StorageInsightsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StorageInsightsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return StorageInsightsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StorageInsightsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageInsightsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StorageInsightsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StorageInsightsSettings. */
  public static class Builder extends ClientSettings.Builder<StorageInsightsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StorageInsightsStubSettings.newBuilder(clientContext));
    }

    protected Builder(StorageInsightsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StorageInsightsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StorageInsightsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(StorageInsightsStubSettings.newHttpJsonBuilder());
    }

    public StorageInsightsStubSettings.Builder getStubSettingsBuilder() {
      return ((StorageInsightsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listReportConfigs. */
    public PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings() {
      return getStubSettingsBuilder().listReportConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getReportConfig. */
    public UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings() {
      return getStubSettingsBuilder().getReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public UnaryCallSettings.Builder<CreateReportConfigRequest, ReportConfig>
        createReportConfigSettings() {
      return getStubSettingsBuilder().createReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateReportConfig. */
    public UnaryCallSettings.Builder<UpdateReportConfigRequest, ReportConfig>
        updateReportConfigSettings() {
      return getStubSettingsBuilder().updateReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public UnaryCallSettings.Builder<DeleteReportConfigRequest, Empty>
        deleteReportConfigSettings() {
      return getStubSettingsBuilder().deleteReportConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listReportDetails. */
    public PagedCallSettings.Builder<
            ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
        listReportDetailsSettings() {
      return getStubSettingsBuilder().listReportDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to getReportDetail. */
    public UnaryCallSettings.Builder<GetReportDetailRequest, ReportDetail>
        getReportDetailSettings() {
      return getStubSettingsBuilder().getReportDetailSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasetConfigs. */
    public PagedCallSettings.Builder<
            ListDatasetConfigsRequest, ListDatasetConfigsResponse, ListDatasetConfigsPagedResponse>
        listDatasetConfigsSettings() {
      return getStubSettingsBuilder().listDatasetConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getDatasetConfig. */
    public UnaryCallSettings.Builder<GetDatasetConfigRequest, DatasetConfig>
        getDatasetConfigSettings() {
      return getStubSettingsBuilder().getDatasetConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createDatasetConfig. */
    public UnaryCallSettings.Builder<CreateDatasetConfigRequest, Operation>
        createDatasetConfigSettings() {
      return getStubSettingsBuilder().createDatasetConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createDatasetConfig. */
    public OperationCallSettings.Builder<
            CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
        createDatasetConfigOperationSettings() {
      return getStubSettingsBuilder().createDatasetConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatasetConfig. */
    public UnaryCallSettings.Builder<UpdateDatasetConfigRequest, Operation>
        updateDatasetConfigSettings() {
      return getStubSettingsBuilder().updateDatasetConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatasetConfig. */
    public OperationCallSettings.Builder<
            UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
        updateDatasetConfigOperationSettings() {
      return getStubSettingsBuilder().updateDatasetConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatasetConfig. */
    public UnaryCallSettings.Builder<DeleteDatasetConfigRequest, Operation>
        deleteDatasetConfigSettings() {
      return getStubSettingsBuilder().deleteDatasetConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatasetConfig. */
    public OperationCallSettings.Builder<DeleteDatasetConfigRequest, Empty, OperationMetadata>
        deleteDatasetConfigOperationSettings() {
      return getStubSettingsBuilder().deleteDatasetConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to linkDataset. */
    public UnaryCallSettings.Builder<LinkDatasetRequest, Operation> linkDatasetSettings() {
      return getStubSettingsBuilder().linkDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to linkDataset. */
    public OperationCallSettings.Builder<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
        linkDatasetOperationSettings() {
      return getStubSettingsBuilder().linkDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to unlinkDataset. */
    public UnaryCallSettings.Builder<UnlinkDatasetRequest, Operation> unlinkDatasetSettings() {
      return getStubSettingsBuilder().unlinkDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to unlinkDataset. */
    public OperationCallSettings.Builder<UnlinkDatasetRequest, Empty, OperationMetadata>
        unlinkDatasetOperationSettings() {
      return getStubSettingsBuilder().unlinkDatasetOperationSettings();
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
    public StorageInsightsSettings build() throws IOException {
      return new StorageInsightsSettings(this);
    }
  }
}
