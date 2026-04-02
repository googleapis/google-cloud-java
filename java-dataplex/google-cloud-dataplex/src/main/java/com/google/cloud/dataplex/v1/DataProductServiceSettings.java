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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.stub.DataProductServiceStubSettings;
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
 * Settings class to configure an instance of {@link DataProductServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataProduct:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataProductServiceSettings.Builder dataProductServiceSettingsBuilder =
 *     DataProductServiceSettings.newBuilder();
 * dataProductServiceSettingsBuilder
 *     .getDataProductSettings()
 *     .setRetrySettings(
 *         dataProductServiceSettingsBuilder
 *             .getDataProductSettings()
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
 * DataProductServiceSettings dataProductServiceSettings =
 *     dataProductServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataProduct:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataProductServiceSettings.Builder dataProductServiceSettingsBuilder =
 *     DataProductServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataProductServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataProductServiceSettings extends ClientSettings<DataProductServiceSettings> {

  /** Returns the object with the settings used for calls to createDataProduct. */
  public UnaryCallSettings<CreateDataProductRequest, Operation> createDataProductSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).createDataProductSettings();
  }

  /** Returns the object with the settings used for calls to createDataProduct. */
  public OperationCallSettings<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings())
        .createDataProductOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataProduct. */
  public UnaryCallSettings<DeleteDataProductRequest, Operation> deleteDataProductSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).deleteDataProductSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataProduct. */
  public OperationCallSettings<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings())
        .deleteDataProductOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataProduct. */
  public UnaryCallSettings<GetDataProductRequest, DataProduct> getDataProductSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).getDataProductSettings();
  }

  /** Returns the object with the settings used for calls to listDataProducts. */
  public PagedCallSettings<
          ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
      listDataProductsSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).listDataProductsSettings();
  }

  /** Returns the object with the settings used for calls to updateDataProduct. */
  public UnaryCallSettings<UpdateDataProductRequest, Operation> updateDataProductSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).updateDataProductSettings();
  }

  /** Returns the object with the settings used for calls to updateDataProduct. */
  public OperationCallSettings<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings())
        .updateDataProductOperationSettings();
  }

  /** Returns the object with the settings used for calls to createDataAsset. */
  public UnaryCallSettings<CreateDataAssetRequest, Operation> createDataAssetSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).createDataAssetSettings();
  }

  /** Returns the object with the settings used for calls to createDataAsset. */
  public OperationCallSettings<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).createDataAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAsset. */
  public UnaryCallSettings<UpdateDataAssetRequest, Operation> updateDataAssetSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).updateDataAssetSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAsset. */
  public OperationCallSettings<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).updateDataAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAsset. */
  public UnaryCallSettings<DeleteDataAssetRequest, Operation> deleteDataAssetSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).deleteDataAssetSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAsset. */
  public OperationCallSettings<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).deleteDataAssetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataAsset. */
  public UnaryCallSettings<GetDataAssetRequest, DataAsset> getDataAssetSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).getDataAssetSettings();
  }

  /** Returns the object with the settings used for calls to listDataAssets. */
  public PagedCallSettings<
          ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
      listDataAssetsSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).listDataAssetsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DataProductServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DataProductServiceSettings create(DataProductServiceStubSettings stub)
      throws IOException {
    return new DataProductServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataProductServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataProductServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataProductServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataProductServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataProductServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataProductServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataProductServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataProductServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataProductServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataProductServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataProductServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataProductServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataProductServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataProductServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataProductServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataProductServiceStubSettings.newHttpJsonBuilder());
    }

    public DataProductServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataProductServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataProduct. */
    public UnaryCallSettings.Builder<CreateDataProductRequest, Operation>
        createDataProductSettings() {
      return getStubSettingsBuilder().createDataProductSettings();
    }

    /** Returns the builder for the settings used for calls to createDataProduct. */
    public OperationCallSettings.Builder<CreateDataProductRequest, DataProduct, OperationMetadata>
        createDataProductOperationSettings() {
      return getStubSettingsBuilder().createDataProductOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataProduct. */
    public UnaryCallSettings.Builder<DeleteDataProductRequest, Operation>
        deleteDataProductSettings() {
      return getStubSettingsBuilder().deleteDataProductSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataProduct. */
    public OperationCallSettings.Builder<DeleteDataProductRequest, Empty, OperationMetadata>
        deleteDataProductOperationSettings() {
      return getStubSettingsBuilder().deleteDataProductOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataProduct. */
    public UnaryCallSettings.Builder<GetDataProductRequest, DataProduct> getDataProductSettings() {
      return getStubSettingsBuilder().getDataProductSettings();
    }

    /** Returns the builder for the settings used for calls to listDataProducts. */
    public PagedCallSettings.Builder<
            ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
        listDataProductsSettings() {
      return getStubSettingsBuilder().listDataProductsSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataProduct. */
    public UnaryCallSettings.Builder<UpdateDataProductRequest, Operation>
        updateDataProductSettings() {
      return getStubSettingsBuilder().updateDataProductSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataProduct. */
    public OperationCallSettings.Builder<UpdateDataProductRequest, DataProduct, OperationMetadata>
        updateDataProductOperationSettings() {
      return getStubSettingsBuilder().updateDataProductOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAsset. */
    public UnaryCallSettings.Builder<CreateDataAssetRequest, Operation> createDataAssetSettings() {
      return getStubSettingsBuilder().createDataAssetSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAsset. */
    public OperationCallSettings.Builder<CreateDataAssetRequest, DataAsset, OperationMetadata>
        createDataAssetOperationSettings() {
      return getStubSettingsBuilder().createDataAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAsset. */
    public UnaryCallSettings.Builder<UpdateDataAssetRequest, Operation> updateDataAssetSettings() {
      return getStubSettingsBuilder().updateDataAssetSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAsset. */
    public OperationCallSettings.Builder<UpdateDataAssetRequest, DataAsset, OperationMetadata>
        updateDataAssetOperationSettings() {
      return getStubSettingsBuilder().updateDataAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAsset. */
    public UnaryCallSettings.Builder<DeleteDataAssetRequest, Operation> deleteDataAssetSettings() {
      return getStubSettingsBuilder().deleteDataAssetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAsset. */
    public OperationCallSettings.Builder<DeleteDataAssetRequest, Empty, OperationMetadata>
        deleteDataAssetOperationSettings() {
      return getStubSettingsBuilder().deleteDataAssetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAsset. */
    public UnaryCallSettings.Builder<GetDataAssetRequest, DataAsset> getDataAssetSettings() {
      return getStubSettingsBuilder().getDataAssetSettings();
    }

    /** Returns the builder for the settings used for calls to listDataAssets. */
    public PagedCallSettings.Builder<
            ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
        listDataAssetsSettings() {
      return getStubSettingsBuilder().listDataAssetsSettings();
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
    public DataProductServiceSettings build() throws IOException {
      return new DataProductServiceSettings(this);
    }
  }
}
