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

package com.google.cloud.vectorsearch.v1beta;

import static com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.stub.DataObjectServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataObjectServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vectorsearch.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createDataObject:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataObjectServiceSettings.Builder dataObjectServiceSettingsBuilder =
 *     DataObjectServiceSettings.newBuilder();
 * dataObjectServiceSettingsBuilder
 *     .createDataObjectSettings()
 *     .setRetrySettings(
 *         dataObjectServiceSettingsBuilder
 *             .createDataObjectSettings()
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
 * DataObjectServiceSettings dataObjectServiceSettings = dataObjectServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataObjectServiceSettings extends ClientSettings<DataObjectServiceSettings> {

  /** Returns the object with the settings used for calls to createDataObject. */
  public UnaryCallSettings<CreateDataObjectRequest, DataObject> createDataObjectSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).createDataObjectSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateDataObjects. */
  public UnaryCallSettings<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).batchCreateDataObjectsSettings();
  }

  /** Returns the object with the settings used for calls to getDataObject. */
  public UnaryCallSettings<GetDataObjectRequest, DataObject> getDataObjectSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).getDataObjectSettings();
  }

  /** Returns the object with the settings used for calls to updateDataObject. */
  public UnaryCallSettings<UpdateDataObjectRequest, DataObject> updateDataObjectSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).updateDataObjectSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateDataObjects. */
  public UnaryCallSettings<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).batchUpdateDataObjectsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataObject. */
  public UnaryCallSettings<DeleteDataObjectRequest, Empty> deleteDataObjectSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).deleteDataObjectSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteDataObjects. */
  public UnaryCallSettings<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).batchDeleteDataObjectsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataObjectServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DataObjectServiceSettings create(DataObjectServiceStubSettings stub)
      throws IOException {
    return new DataObjectServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataObjectServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataObjectServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataObjectServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataObjectServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataObjectServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataObjectServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataObjectServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataObjectServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataObjectServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataObjectServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataObjectServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataObjectServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataObjectServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataObjectServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataObjectServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataObjectServiceStubSettings.newHttpJsonBuilder());
    }

    public DataObjectServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataObjectServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataObject. */
    public UnaryCallSettings.Builder<CreateDataObjectRequest, DataObject>
        createDataObjectSettings() {
      return getStubSettingsBuilder().createDataObjectSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateDataObjects. */
    public UnaryCallSettings.Builder<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
        batchCreateDataObjectsSettings() {
      return getStubSettingsBuilder().batchCreateDataObjectsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataObject. */
    public UnaryCallSettings.Builder<GetDataObjectRequest, DataObject> getDataObjectSettings() {
      return getStubSettingsBuilder().getDataObjectSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataObject. */
    public UnaryCallSettings.Builder<UpdateDataObjectRequest, DataObject>
        updateDataObjectSettings() {
      return getStubSettingsBuilder().updateDataObjectSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateDataObjects. */
    public UnaryCallSettings.Builder<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
        batchUpdateDataObjectsSettings() {
      return getStubSettingsBuilder().batchUpdateDataObjectsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataObject. */
    public UnaryCallSettings.Builder<DeleteDataObjectRequest, Empty> deleteDataObjectSettings() {
      return getStubSettingsBuilder().deleteDataObjectSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataObjects. */
    public UnaryCallSettings.Builder<BatchDeleteDataObjectsRequest, Empty>
        batchDeleteDataObjectsSettings() {
      return getStubSettingsBuilder().batchDeleteDataObjectsSettings();
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
    public DataObjectServiceSettings build() throws IOException {
      return new DataObjectServiceSettings(this);
    }
  }
}
