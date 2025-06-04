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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.IndexServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.IndexServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.IndexServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IndexServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getIndex:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IndexServiceSettings.Builder indexServiceSettingsBuilder = IndexServiceSettings.newBuilder();
 * indexServiceSettingsBuilder
 *     .getIndexSettings()
 *     .setRetrySettings(
 *         indexServiceSettingsBuilder
 *             .getIndexSettings()
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
 * IndexServiceSettings indexServiceSettings = indexServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createIndex:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IndexServiceSettings.Builder indexServiceSettingsBuilder = IndexServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * indexServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IndexServiceSettings extends ClientSettings<IndexServiceSettings> {

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, CreateIndexOperationMetadata>
      createIndexOperationSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).createIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to importIndex. */
  public UnaryCallSettings<ImportIndexRequest, Operation> importIndexSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).importIndexSettings();
  }

  /** Returns the object with the settings used for calls to importIndex. */
  public OperationCallSettings<ImportIndexRequest, Index, ImportIndexOperationMetadata>
      importIndexOperationSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).importIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).listIndexesSettings();
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public UnaryCallSettings<UpdateIndexRequest, Operation> updateIndexSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).updateIndexSettings();
  }

  /** Returns the object with the settings used for calls to updateIndex. */
  public OperationCallSettings<UpdateIndexRequest, Index, UpdateIndexOperationMetadata>
      updateIndexOperationSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).updateIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Empty, DeleteOperationMetadata>
      deleteIndexOperationSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).deleteIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to upsertDatapoints. */
  public UnaryCallSettings<UpsertDatapointsRequest, UpsertDatapointsResponse>
      upsertDatapointsSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).upsertDatapointsSettings();
  }

  /** Returns the object with the settings used for calls to removeDatapoints. */
  public UnaryCallSettings<RemoveDatapointsRequest, RemoveDatapointsResponse>
      removeDatapointsSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).removeDatapointsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((IndexServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((IndexServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((IndexServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final IndexServiceSettings create(IndexServiceStubSettings stub)
      throws IOException {
    return new IndexServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IndexServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IndexServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IndexServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IndexServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IndexServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IndexServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IndexServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected IndexServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IndexServiceSettings. */
  public static class Builder extends ClientSettings.Builder<IndexServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IndexServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(IndexServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IndexServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IndexServiceStubSettings.newBuilder());
    }

    public IndexServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((IndexServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, CreateIndexOperationMetadata>
        createIndexOperationSettings() {
      return getStubSettingsBuilder().createIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to importIndex. */
    public UnaryCallSettings.Builder<ImportIndexRequest, Operation> importIndexSettings() {
      return getStubSettingsBuilder().importIndexSettings();
    }

    /** Returns the builder for the settings used for calls to importIndex. */
    public OperationCallSettings.Builder<ImportIndexRequest, Index, ImportIndexOperationMetadata>
        importIndexOperationSettings() {
      return getStubSettingsBuilder().importIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public UnaryCallSettings.Builder<UpdateIndexRequest, Operation> updateIndexSettings() {
      return getStubSettingsBuilder().updateIndexSettings();
    }

    /** Returns the builder for the settings used for calls to updateIndex. */
    public OperationCallSettings.Builder<UpdateIndexRequest, Index, UpdateIndexOperationMetadata>
        updateIndexOperationSettings() {
      return getStubSettingsBuilder().updateIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Empty, DeleteOperationMetadata>
        deleteIndexOperationSettings() {
      return getStubSettingsBuilder().deleteIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to upsertDatapoints. */
    public UnaryCallSettings.Builder<UpsertDatapointsRequest, UpsertDatapointsResponse>
        upsertDatapointsSettings() {
      return getStubSettingsBuilder().upsertDatapointsSettings();
    }

    /** Returns the builder for the settings used for calls to removeDatapoints. */
    public UnaryCallSettings.Builder<RemoveDatapointsRequest, RemoveDatapointsResponse>
        removeDatapointsSettings() {
      return getStubSettingsBuilder().removeDatapointsSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public IndexServiceSettings build() throws IOException {
      return new IndexServiceSettings(this);
    }
  }
}
