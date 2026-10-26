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

package com.google.cloud.observability.v1;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

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
import com.google.cloud.observability.v1.stub.ObservabilityStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ObservabilityClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (observability.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ObservabilitySettings.Builder observabilitySettingsBuilder = ObservabilitySettings.newBuilder();
 * observabilitySettingsBuilder
 *     .getScopeSettings()
 *     .setRetrySettings(
 *         observabilitySettingsBuilder
 *             .getScopeSettings()
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
 * ObservabilitySettings observabilitySettings = observabilitySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createBucket:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ObservabilitySettings.Builder observabilitySettingsBuilder = ObservabilitySettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * observabilitySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ObservabilitySettings extends ClientSettings<ObservabilitySettings> {

  /** Returns the object with the settings used for calls to getScope. */
  public UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getScopeSettings();
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public UnaryCallSettings<UpdateScopeRequest, Scope> updateScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateScopeSettings();
  }

  /** Returns the object with the settings used for calls to getBucket. */
  public UnaryCallSettings<GetBucketRequest, Bucket> getBucketSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getBucketSettings();
  }

  /** Returns the object with the settings used for calls to listBuckets. */
  public PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listBucketsSettings();
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public UnaryCallSettings<CreateBucketRequest, Operation> createBucketSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).createBucketSettings();
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public OperationCallSettings<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).createBucketOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public UnaryCallSettings<UpdateBucketRequest, Operation> updateBucketSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateBucketSettings();
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public OperationCallSettings<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateBucketOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, View> getViewSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getViewSettings();
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listViewsSettings();
  }

  /** Returns the object with the settings used for calls to getLink. */
  public UnaryCallSettings<GetLinkRequest, Link> getLinkSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getLinkSettings();
  }

  /** Returns the object with the settings used for calls to listLinks. */
  public PagedCallSettings<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
      listLinksSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listLinksSettings();
  }

  /** Returns the object with the settings used for calls to createLink. */
  public UnaryCallSettings<CreateLinkRequest, Operation> createLinkSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).createLinkSettings();
  }

  /** Returns the object with the settings used for calls to createLink. */
  public OperationCallSettings<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).createLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLink. */
  public UnaryCallSettings<UpdateLinkRequest, Operation> updateLinkSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateLinkSettings();
  }

  /** Returns the object with the settings used for calls to updateLink. */
  public OperationCallSettings<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public UnaryCallSettings<DeleteLinkRequest, Operation> deleteLinkSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).deleteLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public OperationCallSettings<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).deleteLinkOperationSettings();
  }

  /** Returns the object with the settings used for calls to getTraceScope. */
  public UnaryCallSettings<GetTraceScopeRequest, TraceScope> getTraceScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getTraceScopeSettings();
  }

  /** Returns the object with the settings used for calls to listTraceScopes. */
  public PagedCallSettings<
          ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
      listTraceScopesSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listTraceScopesSettings();
  }

  /** Returns the object with the settings used for calls to createTraceScope. */
  public UnaryCallSettings<CreateTraceScopeRequest, TraceScope> createTraceScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).createTraceScopeSettings();
  }

  /** Returns the object with the settings used for calls to updateTraceScope. */
  public UnaryCallSettings<UpdateTraceScopeRequest, TraceScope> updateTraceScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateTraceScopeSettings();
  }

  /** Returns the object with the settings used for calls to deleteTraceScope. */
  public UnaryCallSettings<DeleteTraceScopeRequest, Empty> deleteTraceScopeSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).deleteTraceScopeSettings();
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).updateSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ObservabilityStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ObservabilitySettings create(ObservabilityStubSettings stub)
      throws IOException {
    return new ObservabilitySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ObservabilityStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ObservabilityStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ObservabilityStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ObservabilityStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ObservabilityStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ObservabilityStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ObservabilityStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ObservabilityStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ObservabilitySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ObservabilitySettings. */
  public static class Builder extends ClientSettings.Builder<ObservabilitySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ObservabilityStubSettings.newBuilder(clientContext));
    }

    protected Builder(ObservabilitySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ObservabilityStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ObservabilityStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ObservabilityStubSettings.newHttpJsonBuilder());
    }

    public ObservabilityStubSettings.Builder getStubSettingsBuilder() {
      return ((ObservabilityStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getScope. */
    public UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings() {
      return getStubSettingsBuilder().getScopeSettings();
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public UnaryCallSettings.Builder<UpdateScopeRequest, Scope> updateScopeSettings() {
      return getStubSettingsBuilder().updateScopeSettings();
    }

    /** Returns the builder for the settings used for calls to getBucket. */
    public UnaryCallSettings.Builder<GetBucketRequest, Bucket> getBucketSettings() {
      return getStubSettingsBuilder().getBucketSettings();
    }

    /** Returns the builder for the settings used for calls to listBuckets. */
    public PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings() {
      return getStubSettingsBuilder().listBucketsSettings();
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public UnaryCallSettings.Builder<CreateBucketRequest, Operation> createBucketSettings() {
      return getStubSettingsBuilder().createBucketSettings();
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public OperationCallSettings.Builder<CreateBucketRequest, Bucket, OperationMetadata>
        createBucketOperationSettings() {
      return getStubSettingsBuilder().createBucketOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, Operation> updateBucketSettings() {
      return getStubSettingsBuilder().updateBucketSettings();
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public OperationCallSettings.Builder<UpdateBucketRequest, Bucket, OperationMetadata>
        updateBucketOperationSettings() {
      return getStubSettingsBuilder().updateBucketOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getStubSettingsBuilder().getDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return getStubSettingsBuilder().listDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings() {
      return getStubSettingsBuilder().getViewSettings();
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return getStubSettingsBuilder().listViewsSettings();
    }

    /** Returns the builder for the settings used for calls to getLink. */
    public UnaryCallSettings.Builder<GetLinkRequest, Link> getLinkSettings() {
      return getStubSettingsBuilder().getLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listLinks. */
    public PagedCallSettings.Builder<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
        listLinksSettings() {
      return getStubSettingsBuilder().listLinksSettings();
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public UnaryCallSettings.Builder<CreateLinkRequest, Operation> createLinkSettings() {
      return getStubSettingsBuilder().createLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public OperationCallSettings.Builder<CreateLinkRequest, Link, OperationMetadata>
        createLinkOperationSettings() {
      return getStubSettingsBuilder().createLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLink. */
    public UnaryCallSettings.Builder<UpdateLinkRequest, Operation> updateLinkSettings() {
      return getStubSettingsBuilder().updateLinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateLink. */
    public OperationCallSettings.Builder<UpdateLinkRequest, Link, OperationMetadata>
        updateLinkOperationSettings() {
      return getStubSettingsBuilder().updateLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public UnaryCallSettings.Builder<DeleteLinkRequest, Operation> deleteLinkSettings() {
      return getStubSettingsBuilder().deleteLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public OperationCallSettings.Builder<DeleteLinkRequest, Empty, OperationMetadata>
        deleteLinkOperationSettings() {
      return getStubSettingsBuilder().deleteLinkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getTraceScope. */
    public UnaryCallSettings.Builder<GetTraceScopeRequest, TraceScope> getTraceScopeSettings() {
      return getStubSettingsBuilder().getTraceScopeSettings();
    }

    /** Returns the builder for the settings used for calls to listTraceScopes. */
    public PagedCallSettings.Builder<
            ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
        listTraceScopesSettings() {
      return getStubSettingsBuilder().listTraceScopesSettings();
    }

    /** Returns the builder for the settings used for calls to createTraceScope. */
    public UnaryCallSettings.Builder<CreateTraceScopeRequest, TraceScope>
        createTraceScopeSettings() {
      return getStubSettingsBuilder().createTraceScopeSettings();
    }

    /** Returns the builder for the settings used for calls to updateTraceScope. */
    public UnaryCallSettings.Builder<UpdateTraceScopeRequest, TraceScope>
        updateTraceScopeSettings() {
      return getStubSettingsBuilder().updateTraceScopeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTraceScope. */
    public UnaryCallSettings.Builder<DeleteTraceScopeRequest, Empty> deleteTraceScopeSettings() {
      return getStubSettingsBuilder().deleteTraceScopeSettings();
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getStubSettingsBuilder().getSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Operation> updateSettingsSettings() {
      return getStubSettingsBuilder().updateSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings() {
      return getStubSettingsBuilder().updateSettingsOperationSettings();
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
    public ObservabilitySettings build() throws IOException {
      return new ObservabilitySettings(this);
    }
  }
}
