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

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

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
import com.google.cloud.dataplex.v1.stub.CatalogServiceStubSettings;
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
 * Settings class to configure an instance of {@link CatalogServiceClient}.
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
 * <p>For example, to set the total timeout of getEntryType to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .getEntryTypeSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder
 *             .getEntryTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CatalogServiceSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CatalogServiceSettings extends ClientSettings<CatalogServiceSettings> {

  /** Returns the object with the settings used for calls to createEntryType. */
  public UnaryCallSettings<CreateEntryTypeRequest, Operation> createEntryTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createEntryTypeSettings();
  }

  /** Returns the object with the settings used for calls to createEntryType. */
  public OperationCallSettings<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createEntryTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEntryType. */
  public UnaryCallSettings<UpdateEntryTypeRequest, Operation> updateEntryTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateEntryTypeSettings();
  }

  /** Returns the object with the settings used for calls to updateEntryType. */
  public OperationCallSettings<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateEntryTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntryType. */
  public UnaryCallSettings<DeleteEntryTypeRequest, Operation> deleteEntryTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteEntryTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntryType. */
  public OperationCallSettings<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteEntryTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEntryTypes. */
  public PagedCallSettings<
          ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
      listEntryTypesSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listEntryTypesSettings();
  }

  /** Returns the object with the settings used for calls to getEntryType. */
  public UnaryCallSettings<GetEntryTypeRequest, EntryType> getEntryTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getEntryTypeSettings();
  }

  /** Returns the object with the settings used for calls to createAspectType. */
  public UnaryCallSettings<CreateAspectTypeRequest, Operation> createAspectTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createAspectTypeSettings();
  }

  /** Returns the object with the settings used for calls to createAspectType. */
  public OperationCallSettings<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createAspectTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAspectType. */
  public UnaryCallSettings<UpdateAspectTypeRequest, Operation> updateAspectTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateAspectTypeSettings();
  }

  /** Returns the object with the settings used for calls to updateAspectType. */
  public OperationCallSettings<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateAspectTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAspectType. */
  public UnaryCallSettings<DeleteAspectTypeRequest, Operation> deleteAspectTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteAspectTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteAspectType. */
  public OperationCallSettings<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteAspectTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAspectTypes. */
  public PagedCallSettings<
          ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
      listAspectTypesSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listAspectTypesSettings();
  }

  /** Returns the object with the settings used for calls to getAspectType. */
  public UnaryCallSettings<GetAspectTypeRequest, AspectType> getAspectTypeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getAspectTypeSettings();
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public UnaryCallSettings<CreateEntryGroupRequest, Operation> createEntryGroupSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public OperationCallSettings<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createEntryGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public UnaryCallSettings<UpdateEntryGroupRequest, Operation> updateEntryGroupSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public OperationCallSettings<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateEntryGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public UnaryCallSettings<DeleteEntryGroupRequest, Operation> deleteEntryGroupSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public OperationCallSettings<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteEntryGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEntryGroups. */
  public PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listEntryGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getEntryGroup. */
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to createEntry. */
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createEntrySettings();
  }

  /** Returns the object with the settings used for calls to updateEntry. */
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateEntrySettings();
  }

  /** Returns the object with the settings used for calls to deleteEntry. */
  public UnaryCallSettings<DeleteEntryRequest, Entry> deleteEntrySettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteEntrySettings();
  }

  /** Returns the object with the settings used for calls to listEntries. */
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listEntriesSettings();
  }

  /** Returns the object with the settings used for calls to getEntry. */
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getEntrySettings();
  }

  /** Returns the object with the settings used for calls to lookupEntry. */
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).lookupEntrySettings();
  }

  /** Returns the object with the settings used for calls to searchEntries. */
  public PagedCallSettings<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
      searchEntriesSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).searchEntriesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CatalogServiceSettings create(CatalogServiceStubSettings stub)
      throws IOException {
    return new CatalogServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CatalogServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CatalogServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CatalogServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CatalogServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CatalogServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CatalogServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CatalogServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CatalogServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CatalogServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CatalogServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CatalogServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CatalogServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CatalogServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CatalogServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CatalogServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CatalogServiceStubSettings.newHttpJsonBuilder());
    }

    public CatalogServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CatalogServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createEntryType. */
    public UnaryCallSettings.Builder<CreateEntryTypeRequest, Operation> createEntryTypeSettings() {
      return getStubSettingsBuilder().createEntryTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createEntryType. */
    public OperationCallSettings.Builder<CreateEntryTypeRequest, EntryType, OperationMetadata>
        createEntryTypeOperationSettings() {
      return getStubSettingsBuilder().createEntryTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntryType. */
    public UnaryCallSettings.Builder<UpdateEntryTypeRequest, Operation> updateEntryTypeSettings() {
      return getStubSettingsBuilder().updateEntryTypeSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntryType. */
    public OperationCallSettings.Builder<UpdateEntryTypeRequest, EntryType, OperationMetadata>
        updateEntryTypeOperationSettings() {
      return getStubSettingsBuilder().updateEntryTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntryType. */
    public UnaryCallSettings.Builder<DeleteEntryTypeRequest, Operation> deleteEntryTypeSettings() {
      return getStubSettingsBuilder().deleteEntryTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntryType. */
    public OperationCallSettings.Builder<DeleteEntryTypeRequest, Empty, OperationMetadata>
        deleteEntryTypeOperationSettings() {
      return getStubSettingsBuilder().deleteEntryTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEntryTypes. */
    public PagedCallSettings.Builder<
            ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
        listEntryTypesSettings() {
      return getStubSettingsBuilder().listEntryTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getEntryType. */
    public UnaryCallSettings.Builder<GetEntryTypeRequest, EntryType> getEntryTypeSettings() {
      return getStubSettingsBuilder().getEntryTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createAspectType. */
    public UnaryCallSettings.Builder<CreateAspectTypeRequest, Operation>
        createAspectTypeSettings() {
      return getStubSettingsBuilder().createAspectTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createAspectType. */
    public OperationCallSettings.Builder<CreateAspectTypeRequest, AspectType, OperationMetadata>
        createAspectTypeOperationSettings() {
      return getStubSettingsBuilder().createAspectTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAspectType. */
    public UnaryCallSettings.Builder<UpdateAspectTypeRequest, Operation>
        updateAspectTypeSettings() {
      return getStubSettingsBuilder().updateAspectTypeSettings();
    }

    /** Returns the builder for the settings used for calls to updateAspectType. */
    public OperationCallSettings.Builder<UpdateAspectTypeRequest, AspectType, OperationMetadata>
        updateAspectTypeOperationSettings() {
      return getStubSettingsBuilder().updateAspectTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAspectType. */
    public UnaryCallSettings.Builder<DeleteAspectTypeRequest, Operation>
        deleteAspectTypeSettings() {
      return getStubSettingsBuilder().deleteAspectTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAspectType. */
    public OperationCallSettings.Builder<DeleteAspectTypeRequest, Empty, OperationMetadata>
        deleteAspectTypeOperationSettings() {
      return getStubSettingsBuilder().deleteAspectTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAspectTypes. */
    public PagedCallSettings.Builder<
            ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
        listAspectTypesSettings() {
      return getStubSettingsBuilder().listAspectTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getAspectType. */
    public UnaryCallSettings.Builder<GetAspectTypeRequest, AspectType> getAspectTypeSettings() {
      return getStubSettingsBuilder().getAspectTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, Operation>
        createEntryGroupSettings() {
      return getStubSettingsBuilder().createEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public OperationCallSettings.Builder<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
        createEntryGroupOperationSettings() {
      return getStubSettingsBuilder().createEntryGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, Operation>
        updateEntryGroupSettings() {
      return getStubSettingsBuilder().updateEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public OperationCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
        updateEntryGroupOperationSettings() {
      return getStubSettingsBuilder().updateEntryGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Operation>
        deleteEntryGroupSettings() {
      return getStubSettingsBuilder().deleteEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public OperationCallSettings.Builder<DeleteEntryGroupRequest, Empty, OperationMetadata>
        deleteEntryGroupOperationSettings() {
      return getStubSettingsBuilder().deleteEntryGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEntryGroups. */
    public PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings() {
      return getStubSettingsBuilder().listEntryGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getEntryGroup. */
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getStubSettingsBuilder().getEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createEntry. */
    public UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings() {
      return getStubSettingsBuilder().createEntrySettings();
    }

    /** Returns the builder for the settings used for calls to updateEntry. */
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return getStubSettingsBuilder().updateEntrySettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntry. */
    public UnaryCallSettings.Builder<DeleteEntryRequest, Entry> deleteEntrySettings() {
      return getStubSettingsBuilder().deleteEntrySettings();
    }

    /** Returns the builder for the settings used for calls to listEntries. */
    public PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings() {
      return getStubSettingsBuilder().listEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to getEntry. */
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getStubSettingsBuilder().getEntrySettings();
    }

    /** Returns the builder for the settings used for calls to lookupEntry. */
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return getStubSettingsBuilder().lookupEntrySettings();
    }

    /** Returns the builder for the settings used for calls to searchEntries. */
    public PagedCallSettings.Builder<
            SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
        searchEntriesSettings() {
      return getStubSettingsBuilder().searchEntriesSettings();
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
    public CatalogServiceSettings build() throws IOException {
      return new CatalogServiceSettings(this);
    }
  }
}
