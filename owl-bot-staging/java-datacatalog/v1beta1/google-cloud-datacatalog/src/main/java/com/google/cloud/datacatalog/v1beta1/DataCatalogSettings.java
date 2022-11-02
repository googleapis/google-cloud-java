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

package com.google.cloud.datacatalog.v1beta1;

import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.SearchCatalogPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datacatalog.v1beta1.stub.DataCatalogStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * <p>For example, to set the total timeout of createEntryGroup to 30 seconds:
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
 *         dataCatalogSettingsBuilder.createEntryGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataCatalogSettings dataCatalogSettings = dataCatalogSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataCatalogSettings extends ClientSettings<DataCatalogSettings> {

  /** Returns the object with the settings used for calls to searchCatalog. */
  public PagedCallSettings<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).searchCatalogSettings();
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to getEntryGroup. */
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public UnaryCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteEntryGroupSettings();
  }

  /** Returns the object with the settings used for calls to listEntryGroups. */
  public PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listEntryGroupsSettings();
  }

  /** Returns the object with the settings used for calls to createEntry. */
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createEntrySettings();
  }

  /** Returns the object with the settings used for calls to updateEntry. */
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateEntrySettings();
  }

  /** Returns the object with the settings used for calls to deleteEntry. */
  public UnaryCallSettings<DeleteEntryRequest, Empty> deleteEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteEntrySettings();
  }

  /** Returns the object with the settings used for calls to getEntry. */
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getEntrySettings();
  }

  /** Returns the object with the settings used for calls to lookupEntry. */
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).lookupEntrySettings();
  }

  /** Returns the object with the settings used for calls to listEntries. */
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listEntriesSettings();
  }

  /** Returns the object with the settings used for calls to createTagTemplate. */
  public UnaryCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagTemplateSettings();
  }

  /** Returns the object with the settings used for calls to getTagTemplate. */
  public UnaryCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getTagTemplateSettings();
  }

  /** Returns the object with the settings used for calls to updateTagTemplate. */
  public UnaryCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagTemplate. */
  public UnaryCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagTemplateSettings();
  }

  /** Returns the object with the settings used for calls to createTagTemplateField. */
  public UnaryCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagTemplateFieldSettings();
  }

  /** Returns the object with the settings used for calls to updateTagTemplateField. */
  public UnaryCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagTemplateFieldSettings();
  }

  /** Returns the object with the settings used for calls to renameTagTemplateField. */
  public UnaryCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).renameTagTemplateFieldSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagTemplateField. */
  public UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagTemplateFieldSettings();
  }

  /** Returns the object with the settings used for calls to createTag. */
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).createTagSettings();
  }

  /** Returns the object with the settings used for calls to updateTag. */
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).updateTagSettings();
  }

  /** Returns the object with the settings used for calls to deleteTag. */
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).deleteTagSettings();
  }

  /** Returns the object with the settings used for calls to listTags. */
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).listTagsSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataCatalogStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DataCatalogStubSettings) getStubSettings()).testIamPermissionsSettings();
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataCatalogStubSettings.defaultApiClientHeaderProviderBuilder();
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

    @BetaApi
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

    /** Returns the builder for the settings used for calls to searchCatalog. */
    public PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings() {
      return getStubSettingsBuilder().searchCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings() {
      return getStubSettingsBuilder().createEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings() {
      return getStubSettingsBuilder().updateEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getEntryGroup. */
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getStubSettingsBuilder().getEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
      return getStubSettingsBuilder().deleteEntryGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listEntryGroups. */
    public PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings() {
      return getStubSettingsBuilder().listEntryGroupsSettings();
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
    public UnaryCallSettings.Builder<DeleteEntryRequest, Empty> deleteEntrySettings() {
      return getStubSettingsBuilder().deleteEntrySettings();
    }

    /** Returns the builder for the settings used for calls to getEntry. */
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getStubSettingsBuilder().getEntrySettings();
    }

    /** Returns the builder for the settings used for calls to lookupEntry. */
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return getStubSettingsBuilder().lookupEntrySettings();
    }

    /** Returns the builder for the settings used for calls to listEntries. */
    public PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings() {
      return getStubSettingsBuilder().listEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to createTagTemplate. */
    public UnaryCallSettings.Builder<CreateTagTemplateRequest, TagTemplate>
        createTagTemplateSettings() {
      return getStubSettingsBuilder().createTagTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to getTagTemplate. */
    public UnaryCallSettings.Builder<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
      return getStubSettingsBuilder().getTagTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to updateTagTemplate. */
    public UnaryCallSettings.Builder<UpdateTagTemplateRequest, TagTemplate>
        updateTagTemplateSettings() {
      return getStubSettingsBuilder().updateTagTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagTemplate. */
    public UnaryCallSettings.Builder<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
      return getStubSettingsBuilder().deleteTagTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to createTagTemplateField. */
    public UnaryCallSettings.Builder<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldSettings() {
      return getStubSettingsBuilder().createTagTemplateFieldSettings();
    }

    /** Returns the builder for the settings used for calls to updateTagTemplateField. */
    public UnaryCallSettings.Builder<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldSettings() {
      return getStubSettingsBuilder().updateTagTemplateFieldSettings();
    }

    /** Returns the builder for the settings used for calls to renameTagTemplateField. */
    public UnaryCallSettings.Builder<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldSettings() {
      return getStubSettingsBuilder().renameTagTemplateFieldSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagTemplateField. */
    public UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings() {
      return getStubSettingsBuilder().deleteTagTemplateFieldSettings();
    }

    /** Returns the builder for the settings used for calls to createTag. */
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return getStubSettingsBuilder().createTagSettings();
    }

    /** Returns the builder for the settings used for calls to updateTag. */
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return getStubSettingsBuilder().updateTagSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTag. */
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return getStubSettingsBuilder().deleteTagSettings();
    }

    /** Returns the builder for the settings used for calls to listTags. */
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return getStubSettingsBuilder().listTagsSettings();
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
    public DataCatalogSettings build() throws IOException {
      return new DataCatalogSettings(this);
    }
  }
}
