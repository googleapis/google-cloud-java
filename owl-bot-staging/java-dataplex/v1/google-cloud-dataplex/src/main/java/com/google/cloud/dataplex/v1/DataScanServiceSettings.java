/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataplex.v1.stub.DataScanServiceStubSettings;
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
 * Settings class to configure an instance of {@link DataScanServiceClient}.
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
 * <p>For example, to set the total timeout of getDataScan to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataScanServiceSettings.Builder dataScanServiceSettingsBuilder =
 *     DataScanServiceSettings.newBuilder();
 * dataScanServiceSettingsBuilder
 *     .getDataScanSettings()
 *     .setRetrySettings(
 *         dataScanServiceSettingsBuilder
 *             .getDataScanSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataScanServiceSettings dataScanServiceSettings = dataScanServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataScanServiceSettings extends ClientSettings<DataScanServiceSettings> {

  /** Returns the object with the settings used for calls to createDataScan. */
  public UnaryCallSettings<CreateDataScanRequest, Operation> createDataScanSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).createDataScanSettings();
  }

  /** Returns the object with the settings used for calls to createDataScan. */
  public OperationCallSettings<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).createDataScanOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataScan. */
  public UnaryCallSettings<UpdateDataScanRequest, Operation> updateDataScanSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).updateDataScanSettings();
  }

  /** Returns the object with the settings used for calls to updateDataScan. */
  public OperationCallSettings<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).updateDataScanOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataScan. */
  public UnaryCallSettings<DeleteDataScanRequest, Operation> deleteDataScanSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).deleteDataScanSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataScan. */
  public OperationCallSettings<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).deleteDataScanOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataScan. */
  public UnaryCallSettings<GetDataScanRequest, DataScan> getDataScanSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).getDataScanSettings();
  }

  /** Returns the object with the settings used for calls to listDataScans. */
  public PagedCallSettings<ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
      listDataScansSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).listDataScansSettings();
  }

  /** Returns the object with the settings used for calls to runDataScan. */
  public UnaryCallSettings<RunDataScanRequest, RunDataScanResponse> runDataScanSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).runDataScanSettings();
  }

  /** Returns the object with the settings used for calls to getDataScanJob. */
  public UnaryCallSettings<GetDataScanJobRequest, DataScanJob> getDataScanJobSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).getDataScanJobSettings();
  }

  /** Returns the object with the settings used for calls to listDataScanJobs. */
  public PagedCallSettings<
          ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
      listDataScanJobsSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).listDataScanJobsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataScanServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DataScanServiceSettings create(DataScanServiceStubSettings stub)
      throws IOException {
    return new DataScanServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataScanServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataScanServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataScanServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataScanServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataScanServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataScanServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataScanServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataScanServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DataScanServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataScanServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataScanServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataScanServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataScanServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataScanServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataScanServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataScanServiceStubSettings.newHttpJsonBuilder());
    }

    public DataScanServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataScanServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataScan. */
    public UnaryCallSettings.Builder<CreateDataScanRequest, Operation> createDataScanSettings() {
      return getStubSettingsBuilder().createDataScanSettings();
    }

    /** Returns the builder for the settings used for calls to createDataScan. */
    public OperationCallSettings.Builder<CreateDataScanRequest, DataScan, OperationMetadata>
        createDataScanOperationSettings() {
      return getStubSettingsBuilder().createDataScanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataScan. */
    public UnaryCallSettings.Builder<UpdateDataScanRequest, Operation> updateDataScanSettings() {
      return getStubSettingsBuilder().updateDataScanSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataScan. */
    public OperationCallSettings.Builder<UpdateDataScanRequest, DataScan, OperationMetadata>
        updateDataScanOperationSettings() {
      return getStubSettingsBuilder().updateDataScanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataScan. */
    public UnaryCallSettings.Builder<DeleteDataScanRequest, Operation> deleteDataScanSettings() {
      return getStubSettingsBuilder().deleteDataScanSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataScan. */
    public OperationCallSettings.Builder<DeleteDataScanRequest, Empty, OperationMetadata>
        deleteDataScanOperationSettings() {
      return getStubSettingsBuilder().deleteDataScanOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataScan. */
    public UnaryCallSettings.Builder<GetDataScanRequest, DataScan> getDataScanSettings() {
      return getStubSettingsBuilder().getDataScanSettings();
    }

    /** Returns the builder for the settings used for calls to listDataScans. */
    public PagedCallSettings.Builder<
            ListDataScansRequest, ListDataScansResponse, ListDataScansPagedResponse>
        listDataScansSettings() {
      return getStubSettingsBuilder().listDataScansSettings();
    }

    /** Returns the builder for the settings used for calls to runDataScan. */
    public UnaryCallSettings.Builder<RunDataScanRequest, RunDataScanResponse>
        runDataScanSettings() {
      return getStubSettingsBuilder().runDataScanSettings();
    }

    /** Returns the builder for the settings used for calls to getDataScanJob. */
    public UnaryCallSettings.Builder<GetDataScanJobRequest, DataScanJob> getDataScanJobSettings() {
      return getStubSettingsBuilder().getDataScanJobSettings();
    }

    /** Returns the builder for the settings used for calls to listDataScanJobs. */
    public PagedCallSettings.Builder<
            ListDataScanJobsRequest, ListDataScanJobsResponse, ListDataScanJobsPagedResponse>
        listDataScanJobsSettings() {
      return getStubSettingsBuilder().listDataScanJobsSettings();
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
    public DataScanServiceSettings build() throws IOException {
      return new DataScanServiceSettings(this);
    }
  }
}
