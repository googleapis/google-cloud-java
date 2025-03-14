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

package com.google.cloud.datacatalog.v1;

import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.SearchCatalogPagedResponse;

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
import com.google.cloud.datacatalog.v1.stub.DataCatalogStubSettings;
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
 * Settings class to configure an instance of {@link DataCatalogClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datacatalog.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createEntryGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings.Builder dataCatalogSettingsBuilder = DataCatalogSettings.newBuilder();
 * dataCatalogSettingsBuilder
 *     .createEntryGroupSettings()
 *     .setRetrySettings(
 *         dataCatalogSettingsBuilder
 *             .createEntryGroupSettings()
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
 * DataCatalogSettings dataCatalogSettings = dataCatalogSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for reconcileTags:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings.Builder dataCatalogSettingsBuilder = DataCatalogSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataCatalogSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@Deprecated
@Generated("by gapic-generator-java")
public class DataCatalogSettings extends ClientSettings<DataCatalogSettings> {

  /**
   * Returns the object with the settings used for calls to searchCatalog.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).searchCatalogSettings();
  }

  /**
   * Returns the object with the settings used for calls to createEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createEntryGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to getEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getEntryGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateEntryGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteEntryGroupSettings();
  }

  /**
   * Returns the object with the settings used for calls to listEntryGroups.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listEntryGroupsSettings();
  }

  /**
   * Returns the object with the settings used for calls to createEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to updateEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteEntryRequest, Empty> deleteEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to getEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to lookupEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).lookupEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to listEntries.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listEntriesSettings();
  }

  /**
   * Returns the object with the settings used for calls to modifyEntryOverview.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).modifyEntryOverviewSettings();
  }

  /**
   * Returns the object with the settings used for calls to modifyEntryContacts.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ModifyEntryContactsRequest, Contacts> modifyEntryContactsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).modifyEntryContactsSettings();
  }

  /**
   * Returns the object with the settings used for calls to createTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagTemplateSettings();
  }

  /**
   * Returns the object with the settings used for calls to getTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getTagTemplateSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagTemplateSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagTemplateSettings();
  }

  /**
   * Returns the object with the settings used for calls to createTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagTemplateFieldSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagTemplateFieldSettings();
  }

  /**
   * Returns the object with the settings used for calls to renameTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).renameTagTemplateFieldSettings();
  }

  /**
   * Returns the object with the settings used for calls to renameTagTemplateFieldEnumValue.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).renameTagTemplateFieldEnumValueSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagTemplateFieldSettings();
  }

  /**
   * Returns the object with the settings used for calls to createTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagSettings();
  }

  /**
   * Returns the object with the settings used for calls to listTags.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listTagsSettings();
  }

  /**
   * Returns the object with the settings used for calls to reconcileTags.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ReconcileTagsRequest, Operation> reconcileTagsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).reconcileTagsSettings();
  }

  /**
   * Returns the object with the settings used for calls to reconcileTags.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
      reconcileTagsOperationSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).reconcileTagsOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to starEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<StarEntryRequest, StarEntryResponse> starEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).starEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to unstarEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UnstarEntryRequest, UnstarEntryResponse> unstarEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).unstarEntrySettings();
  }

  /**
   * Returns the object with the settings used for calls to setIamPolicy.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /**
   * Returns the object with the settings used for calls to getIamPolicy.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissions.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /**
   * Returns the object with the settings used for calls to importEntries.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ImportEntriesRequest, Operation> importEntriesSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).importEntriesSettings();
  }

  /**
   * Returns the object with the settings used for calls to importEntries.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
      importEntriesOperationSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).importEntriesOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to setConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SetConfigRequest, MigrationConfig> setConfigSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).setConfigSettings();
  }

  /**
   * Returns the object with the settings used for calls to retrieveConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RetrieveConfigRequest, OrganizationConfig> retrieveConfigSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).retrieveConfigSettings();
  }

  /**
   * Returns the object with the settings used for calls to retrieveEffectiveConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RetrieveEffectiveConfigRequest, MigrationConfig>
      retrieveEffectiveConfigSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).retrieveEffectiveConfigSettings();
  }

  public static final DataCatalogSettings create(DataCatalogStubSettings stub) throws IOException {
    return new DataCatalogSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataCatalogStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataCatalogStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataCatalogStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataCatalogStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataCatalogStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataCatalogStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataCatalogStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataCatalogStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataCatalogSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataCatalogSettings. */
  public static class Builder extends ClientSettings.Builder<DataCatalogSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataCatalogStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataCatalogSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataCatalogStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataCatalogStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataCatalogStubSettings.newHttpJsonBuilder());
    }

    public DataCatalogStubSettings.Builder getStubSettingsBuilder() {
      return ((DataCatalogStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to searchCatalog.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings() {
      return getStubSettingsBuilder().searchCatalogSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings() {
      return getStubSettingsBuilder().createEntryGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getStubSettingsBuilder().getEntryGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings() {
      return getStubSettingsBuilder().updateEntryGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
      return getStubSettingsBuilder().deleteEntryGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listEntryGroups.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings() {
      return getStubSettingsBuilder().listEntryGroupsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings() {
      return getStubSettingsBuilder().createEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return getStubSettingsBuilder().updateEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteEntryRequest, Empty> deleteEntrySettings() {
      return getStubSettingsBuilder().deleteEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to getEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getStubSettingsBuilder().getEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to lookupEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return getStubSettingsBuilder().lookupEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to listEntries.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings() {
      return getStubSettingsBuilder().listEntriesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to modifyEntryOverview.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ModifyEntryOverviewRequest, EntryOverview>
        modifyEntryOverviewSettings() {
      return getStubSettingsBuilder().modifyEntryOverviewSettings();
    }

    /**
     * Returns the builder for the settings used for calls to modifyEntryContacts.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ModifyEntryContactsRequest, Contacts>
        modifyEntryContactsSettings() {
      return getStubSettingsBuilder().modifyEntryContactsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagTemplateRequest, TagTemplate>
        createTagTemplateSettings() {
      return getStubSettingsBuilder().createTagTemplateSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
      return getStubSettingsBuilder().getTagTemplateSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagTemplateRequest, TagTemplate>
        updateTagTemplateSettings() {
      return getStubSettingsBuilder().updateTagTemplateSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
      return getStubSettingsBuilder().deleteTagTemplateSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldSettings() {
      return getStubSettingsBuilder().createTagTemplateFieldSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldSettings() {
      return getStubSettingsBuilder().updateTagTemplateFieldSettings();
    }

    /**
     * Returns the builder for the settings used for calls to renameTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldSettings() {
      return getStubSettingsBuilder().renameTagTemplateFieldSettings();
    }

    /**
     * Returns the builder for the settings used for calls to renameTagTemplateFieldEnumValue.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
        renameTagTemplateFieldEnumValueSettings() {
      return getStubSettingsBuilder().renameTagTemplateFieldEnumValueSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings() {
      return getStubSettingsBuilder().deleteTagTemplateFieldSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return getStubSettingsBuilder().createTagSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return getStubSettingsBuilder().updateTagSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return getStubSettingsBuilder().deleteTagSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listTags.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return getStubSettingsBuilder().listTagsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to reconcileTags.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ReconcileTagsRequest, Operation> reconcileTagsSettings() {
      return getStubSettingsBuilder().reconcileTagsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to reconcileTags.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<
            ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
        reconcileTagsOperationSettings() {
      return getStubSettingsBuilder().reconcileTagsOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to starEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<StarEntryRequest, StarEntryResponse> starEntrySettings() {
      return getStubSettingsBuilder().starEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to unstarEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UnstarEntryRequest, UnstarEntryResponse>
        unstarEntrySettings() {
      return getStubSettingsBuilder().unstarEntrySettings();
    }

    /**
     * Returns the builder for the settings used for calls to setIamPolicy.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to getIamPolicy.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to testIamPermissions.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to importEntries.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ImportEntriesRequest, Operation> importEntriesSettings() {
      return getStubSettingsBuilder().importEntriesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to importEntries.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<
            ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
        importEntriesOperationSettings() {
      return getStubSettingsBuilder().importEntriesOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SetConfigRequest, MigrationConfig> setConfigSettings() {
      return getStubSettingsBuilder().setConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to retrieveConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RetrieveConfigRequest, OrganizationConfig>
        retrieveConfigSettings() {
      return getStubSettingsBuilder().retrieveConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to retrieveEffectiveConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RetrieveEffectiveConfigRequest, MigrationConfig>
        retrieveEffectiveConfigSettings() {
      return getStubSettingsBuilder().retrieveEffectiveConfigSettings();
    }

    @Override
    public DataCatalogSettings build() throws IOException {
      return new DataCatalogSettings(this);
    }
  }
}
