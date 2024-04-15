/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.stub.DataTaxonomyServiceStubSettings;
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
 * Settings class to configure an instance of {@link DataTaxonomyServiceClient}.
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
 * <p>For example, to set the total timeout of getDataTaxonomy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTaxonomyServiceSettings.Builder dataTaxonomyServiceSettingsBuilder =
 *     DataTaxonomyServiceSettings.newBuilder();
 * dataTaxonomyServiceSettingsBuilder
 *     .getDataTaxonomySettings()
 *     .setRetrySettings(
 *         dataTaxonomyServiceSettingsBuilder
 *             .getDataTaxonomySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataTaxonomyServiceSettings dataTaxonomyServiceSettings =
 *     dataTaxonomyServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataTaxonomyServiceSettings extends ClientSettings<DataTaxonomyServiceSettings> {

  /** Returns the object with the settings used for calls to createDataTaxonomy. */
  public UnaryCallSettings<CreateDataTaxonomyRequest, Operation> createDataTaxonomySettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).createDataTaxonomySettings();
  }

  /** Returns the object with the settings used for calls to createDataTaxonomy. */
  public OperationCallSettings<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .createDataTaxonomyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataTaxonomy. */
  public UnaryCallSettings<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomySettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).updateDataTaxonomySettings();
  }

  /** Returns the object with the settings used for calls to updateDataTaxonomy. */
  public OperationCallSettings<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .updateDataTaxonomyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataTaxonomy. */
  public UnaryCallSettings<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomySettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).deleteDataTaxonomySettings();
  }

  /** Returns the object with the settings used for calls to deleteDataTaxonomy. */
  public OperationCallSettings<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .deleteDataTaxonomyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDataTaxonomies. */
  public PagedCallSettings<
          ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).listDataTaxonomiesSettings();
  }

  /** Returns the object with the settings used for calls to getDataTaxonomy. */
  public UnaryCallSettings<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomySettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).getDataTaxonomySettings();
  }

  /** Returns the object with the settings used for calls to createDataAttributeBinding. */
  public UnaryCallSettings<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .createDataAttributeBindingSettings();
  }

  /** Returns the object with the settings used for calls to createDataAttributeBinding. */
  public OperationCallSettings<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .createDataAttributeBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAttributeBinding. */
  public UnaryCallSettings<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .updateDataAttributeBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAttributeBinding. */
  public OperationCallSettings<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .updateDataAttributeBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAttributeBinding. */
  public UnaryCallSettings<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .deleteDataAttributeBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAttributeBinding. */
  public OperationCallSettings<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .deleteDataAttributeBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDataAttributeBindings. */
  public PagedCallSettings<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .listDataAttributeBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getDataAttributeBinding. */
  public UnaryCallSettings<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).getDataAttributeBindingSettings();
  }

  /** Returns the object with the settings used for calls to createDataAttribute. */
  public UnaryCallSettings<CreateDataAttributeRequest, Operation> createDataAttributeSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).createDataAttributeSettings();
  }

  /** Returns the object with the settings used for calls to createDataAttribute. */
  public OperationCallSettings<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .createDataAttributeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAttribute. */
  public UnaryCallSettings<UpdateDataAttributeRequest, Operation> updateDataAttributeSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).updateDataAttributeSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAttribute. */
  public OperationCallSettings<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .updateDataAttributeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAttribute. */
  public UnaryCallSettings<DeleteDataAttributeRequest, Operation> deleteDataAttributeSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).deleteDataAttributeSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAttribute. */
  public OperationCallSettings<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings())
        .deleteDataAttributeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDataAttributes. */
  public PagedCallSettings<
          ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
      listDataAttributesSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).listDataAttributesSettings();
  }

  /** Returns the object with the settings used for calls to getDataAttribute. */
  public UnaryCallSettings<GetDataAttributeRequest, DataAttribute> getDataAttributeSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).getDataAttributeSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataTaxonomyServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DataTaxonomyServiceSettings create(DataTaxonomyServiceStubSettings stub)
      throws IOException {
    return new DataTaxonomyServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataTaxonomyServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataTaxonomyServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataTaxonomyServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataTaxonomyServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataTaxonomyServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataTaxonomyServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataTaxonomyServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataTaxonomyServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataTaxonomyServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataTaxonomyServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataTaxonomyServiceStubSettings.newHttpJsonBuilder());
    }

    public DataTaxonomyServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataTaxonomyServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataTaxonomy. */
    public UnaryCallSettings.Builder<CreateDataTaxonomyRequest, Operation>
        createDataTaxonomySettings() {
      return getStubSettingsBuilder().createDataTaxonomySettings();
    }

    /** Returns the builder for the settings used for calls to createDataTaxonomy. */
    public OperationCallSettings.Builder<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        createDataTaxonomyOperationSettings() {
      return getStubSettingsBuilder().createDataTaxonomyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataTaxonomy. */
    public UnaryCallSettings.Builder<UpdateDataTaxonomyRequest, Operation>
        updateDataTaxonomySettings() {
      return getStubSettingsBuilder().updateDataTaxonomySettings();
    }

    /** Returns the builder for the settings used for calls to updateDataTaxonomy. */
    public OperationCallSettings.Builder<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        updateDataTaxonomyOperationSettings() {
      return getStubSettingsBuilder().updateDataTaxonomyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataTaxonomy. */
    public UnaryCallSettings.Builder<DeleteDataTaxonomyRequest, Operation>
        deleteDataTaxonomySettings() {
      return getStubSettingsBuilder().deleteDataTaxonomySettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataTaxonomy. */
    public OperationCallSettings.Builder<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
        deleteDataTaxonomyOperationSettings() {
      return getStubSettingsBuilder().deleteDataTaxonomyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDataTaxonomies. */
    public PagedCallSettings.Builder<
            ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
        listDataTaxonomiesSettings() {
      return getStubSettingsBuilder().listDataTaxonomiesSettings();
    }

    /** Returns the builder for the settings used for calls to getDataTaxonomy. */
    public UnaryCallSettings.Builder<GetDataTaxonomyRequest, DataTaxonomy>
        getDataTaxonomySettings() {
      return getStubSettingsBuilder().getDataTaxonomySettings();
    }

    /** Returns the builder for the settings used for calls to createDataAttributeBinding. */
    public UnaryCallSettings.Builder<CreateDataAttributeBindingRequest, Operation>
        createDataAttributeBindingSettings() {
      return getStubSettingsBuilder().createDataAttributeBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAttributeBinding. */
    public OperationCallSettings.Builder<
            CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        createDataAttributeBindingOperationSettings() {
      return getStubSettingsBuilder().createDataAttributeBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAttributeBinding. */
    public UnaryCallSettings.Builder<UpdateDataAttributeBindingRequest, Operation>
        updateDataAttributeBindingSettings() {
      return getStubSettingsBuilder().updateDataAttributeBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAttributeBinding. */
    public OperationCallSettings.Builder<
            UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        updateDataAttributeBindingOperationSettings() {
      return getStubSettingsBuilder().updateDataAttributeBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAttributeBinding. */
    public UnaryCallSettings.Builder<DeleteDataAttributeBindingRequest, Operation>
        deleteDataAttributeBindingSettings() {
      return getStubSettingsBuilder().deleteDataAttributeBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAttributeBinding. */
    public OperationCallSettings.Builder<
            DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
        deleteDataAttributeBindingOperationSettings() {
      return getStubSettingsBuilder().deleteDataAttributeBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDataAttributeBindings. */
    public PagedCallSettings.Builder<
            ListDataAttributeBindingsRequest,
            ListDataAttributeBindingsResponse,
            ListDataAttributeBindingsPagedResponse>
        listDataAttributeBindingsSettings() {
      return getStubSettingsBuilder().listDataAttributeBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAttributeBinding. */
    public UnaryCallSettings.Builder<GetDataAttributeBindingRequest, DataAttributeBinding>
        getDataAttributeBindingSettings() {
      return getStubSettingsBuilder().getDataAttributeBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAttribute. */
    public UnaryCallSettings.Builder<CreateDataAttributeRequest, Operation>
        createDataAttributeSettings() {
      return getStubSettingsBuilder().createDataAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAttribute. */
    public OperationCallSettings.Builder<
            CreateDataAttributeRequest, DataAttribute, OperationMetadata>
        createDataAttributeOperationSettings() {
      return getStubSettingsBuilder().createDataAttributeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAttribute. */
    public UnaryCallSettings.Builder<UpdateDataAttributeRequest, Operation>
        updateDataAttributeSettings() {
      return getStubSettingsBuilder().updateDataAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAttribute. */
    public OperationCallSettings.Builder<
            UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
        updateDataAttributeOperationSettings() {
      return getStubSettingsBuilder().updateDataAttributeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAttribute. */
    public UnaryCallSettings.Builder<DeleteDataAttributeRequest, Operation>
        deleteDataAttributeSettings() {
      return getStubSettingsBuilder().deleteDataAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAttribute. */
    public OperationCallSettings.Builder<DeleteDataAttributeRequest, Empty, OperationMetadata>
        deleteDataAttributeOperationSettings() {
      return getStubSettingsBuilder().deleteDataAttributeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDataAttributes. */
    public PagedCallSettings.Builder<
            ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
        listDataAttributesSettings() {
      return getStubSettingsBuilder().listDataAttributesSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAttribute. */
    public UnaryCallSettings.Builder<GetDataAttributeRequest, DataAttribute>
        getDataAttributeSettings() {
      return getStubSettingsBuilder().getDataAttributeSettings();
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
    public DataTaxonomyServiceSettings build() throws IOException {
      return new DataTaxonomyServiceSettings(this);
    }
  }
}
