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

package com.google.cloud.datacatalog.v1beta1.stub;

import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.SearchCatalogPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.Entry;
import com.google.cloud.datacatalog.v1beta1.EntryGroup;
import com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.GetEntryRequest;
import com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntriesRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntriesResponse;
import com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse;
import com.google.cloud.datacatalog.v1beta1.ListTagsRequest;
import com.google.cloud.datacatalog.v1beta1.ListTagsResponse;
import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogResult;
import com.google.cloud.datacatalog.v1beta1.Tag;
import com.google.cloud.datacatalog.v1beta1.TagTemplate;
import com.google.cloud.datacatalog.v1beta1.TagTemplateField;
import com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataCatalogStub}.
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
 * DataCatalogStubSettings.Builder dataCatalogSettingsBuilder =
 *     DataCatalogStubSettings.newBuilder();
 * dataCatalogSettingsBuilder
 *     .createEntryGroupSettings()
 *     .setRetrySettings(
 *         dataCatalogSettingsBuilder.createEntryGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataCatalogStubSettings dataCatalogSettings = dataCatalogSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataCatalogStubSettings extends StubSettings<DataCatalogStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings;
  private final UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings;
  private final UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings;
  private final UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
  private final UnaryCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings;
  private final PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings;
  private final UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings;
  private final UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings;
  private final UnaryCallSettings<DeleteEntryRequest, Empty> deleteEntrySettings;
  private final UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings;
  private final UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings;
  private final PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings;
  private final UnaryCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateSettings;
  private final UnaryCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings;
  private final UnaryCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateSettings;
  private final UnaryCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings;
  private final UnaryCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldSettings;
  private final UnaryCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldSettings;
  private final UnaryCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldSettings;
  private final UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldSettings;
  private final UnaryCallSettings<CreateTagRequest, Tag> createTagSettings;
  private final UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings;
  private final UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings;
  private final PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult>
      SEARCH_CATALOG_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchCatalogRequest injectToken(SearchCatalogRequest payload, String token) {
              return SearchCatalogRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchCatalogRequest injectPageSize(SearchCatalogRequest payload, int pageSize) {
              return SearchCatalogRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchCatalogRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchCatalogResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchCatalogResult> extractResources(SearchCatalogResponse payload) {
              return payload.getResultsList() == null
                  ? ImmutableList.<SearchCatalogResult>of()
                  : payload.getResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup>
      LIST_ENTRY_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntryGroupsRequest injectToken(
                ListEntryGroupsRequest payload, String token) {
              return ListEntryGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntryGroupsRequest injectPageSize(
                ListEntryGroupsRequest payload, int pageSize) {
              return ListEntryGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntryGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntryGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntryGroup> extractResources(ListEntryGroupsResponse payload) {
              return payload.getEntryGroupsList() == null
                  ? ImmutableList.<EntryGroup>of()
                  : payload.getEntryGroupsList();
            }
          };

  private static final PagedListDescriptor<ListEntriesRequest, ListEntriesResponse, Entry>
      LIST_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntriesRequest, ListEntriesResponse, Entry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntriesRequest injectToken(ListEntriesRequest payload, String token) {
              return ListEntriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntriesRequest injectPageSize(ListEntriesRequest payload, int pageSize) {
              return ListEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entry> extractResources(ListEntriesResponse payload) {
              return payload.getEntriesList() == null
                  ? ImmutableList.<Entry>of()
                  : payload.getEntriesList();
            }
          };

  private static final PagedListDescriptor<ListTagsRequest, ListTagsResponse, Tag>
      LIST_TAGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagsRequest, ListTagsResponse, Tag>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagsRequest injectToken(ListTagsRequest payload, String token) {
              return ListTagsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagsRequest injectPageSize(ListTagsRequest payload, int pageSize) {
              return ListTagsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tag> extractResources(ListTagsResponse payload) {
              return payload.getTagsList() == null
                  ? ImmutableList.<Tag>of()
                  : payload.getTagsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      SEARCH_CATALOG_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>() {
            @Override
            public ApiFuture<SearchCatalogPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> callable,
                SearchCatalogRequest request,
                ApiCallContext context,
                ApiFuture<SearchCatalogResponse> futureResponse) {
              PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult>
                  pageContext =
                      PageContext.create(callable, SEARCH_CATALOG_PAGE_STR_DESC, request, context);
              return SearchCatalogPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      LIST_ENTRY_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListEntryGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> callable,
                ListEntryGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntryGroupsResponse> futureResponse) {
              PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> pageContext =
                  PageContext.create(callable, LIST_ENTRY_GROUPS_PAGE_STR_DESC, request, context);
              return ListEntryGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      LIST_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntriesRequest, ListEntriesResponse> callable,
                ListEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntriesResponse> futureResponse) {
              PageContext<ListEntriesRequest, ListEntriesResponse, Entry> pageContext =
                  PageContext.create(callable, LIST_ENTRIES_PAGE_STR_DESC, request, context);
              return ListEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      LIST_TAGS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>() {
            @Override
            public ApiFuture<ListTagsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagsRequest, ListTagsResponse> callable,
                ListTagsRequest request,
                ApiCallContext context,
                ApiFuture<ListTagsResponse> futureResponse) {
              PageContext<ListTagsRequest, ListTagsResponse, Tag> pageContext =
                  PageContext.create(callable, LIST_TAGS_PAGE_STR_DESC, request, context);
              return ListTagsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchCatalog. */
  public PagedCallSettings<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings() {
    return searchCatalogSettings;
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings() {
    return createEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings() {
    return updateEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to getEntryGroup. */
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return getEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public UnaryCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
    return deleteEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to listEntryGroups. */
  public PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings() {
    return listEntryGroupsSettings;
  }

  /** Returns the object with the settings used for calls to createEntry. */
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return createEntrySettings;
  }

  /** Returns the object with the settings used for calls to updateEntry. */
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return updateEntrySettings;
  }

  /** Returns the object with the settings used for calls to deleteEntry. */
  public UnaryCallSettings<DeleteEntryRequest, Empty> deleteEntrySettings() {
    return deleteEntrySettings;
  }

  /** Returns the object with the settings used for calls to getEntry. */
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return getEntrySettings;
  }

  /** Returns the object with the settings used for calls to lookupEntry. */
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return lookupEntrySettings;
  }

  /** Returns the object with the settings used for calls to listEntries. */
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return listEntriesSettings;
  }

  /** Returns the object with the settings used for calls to createTagTemplate. */
  public UnaryCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateSettings() {
    return createTagTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getTagTemplate. */
  public UnaryCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
    return getTagTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateTagTemplate. */
  public UnaryCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateSettings() {
    return updateTagTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagTemplate. */
  public UnaryCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
    return deleteTagTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createTagTemplateField. */
  public UnaryCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldSettings() {
    return createTagTemplateFieldSettings;
  }

  /** Returns the object with the settings used for calls to updateTagTemplateField. */
  public UnaryCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldSettings() {
    return updateTagTemplateFieldSettings;
  }

  /** Returns the object with the settings used for calls to renameTagTemplateField. */
  public UnaryCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldSettings() {
    return renameTagTemplateFieldSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagTemplateField. */
  public UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldSettings() {
    return deleteTagTemplateFieldSettings;
  }

  /** Returns the object with the settings used for calls to createTag. */
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return createTagSettings;
  }

  /** Returns the object with the settings used for calls to updateTag. */
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return updateTagSettings;
  }

  /** Returns the object with the settings used for calls to deleteTag. */
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return deleteTagSettings;
  }

  /** Returns the object with the settings used for calls to listTags. */
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return listTagsSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DataCatalogStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataCatalogStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataCatalogStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "datacatalog.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datacatalog.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataCatalogStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataCatalogStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataCatalogStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataCatalogStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchCatalogSettings = settingsBuilder.searchCatalogSettings().build();
    createEntryGroupSettings = settingsBuilder.createEntryGroupSettings().build();
    updateEntryGroupSettings = settingsBuilder.updateEntryGroupSettings().build();
    getEntryGroupSettings = settingsBuilder.getEntryGroupSettings().build();
    deleteEntryGroupSettings = settingsBuilder.deleteEntryGroupSettings().build();
    listEntryGroupsSettings = settingsBuilder.listEntryGroupsSettings().build();
    createEntrySettings = settingsBuilder.createEntrySettings().build();
    updateEntrySettings = settingsBuilder.updateEntrySettings().build();
    deleteEntrySettings = settingsBuilder.deleteEntrySettings().build();
    getEntrySettings = settingsBuilder.getEntrySettings().build();
    lookupEntrySettings = settingsBuilder.lookupEntrySettings().build();
    listEntriesSettings = settingsBuilder.listEntriesSettings().build();
    createTagTemplateSettings = settingsBuilder.createTagTemplateSettings().build();
    getTagTemplateSettings = settingsBuilder.getTagTemplateSettings().build();
    updateTagTemplateSettings = settingsBuilder.updateTagTemplateSettings().build();
    deleteTagTemplateSettings = settingsBuilder.deleteTagTemplateSettings().build();
    createTagTemplateFieldSettings = settingsBuilder.createTagTemplateFieldSettings().build();
    updateTagTemplateFieldSettings = settingsBuilder.updateTagTemplateFieldSettings().build();
    renameTagTemplateFieldSettings = settingsBuilder.renameTagTemplateFieldSettings().build();
    deleteTagTemplateFieldSettings = settingsBuilder.deleteTagTemplateFieldSettings().build();
    createTagSettings = settingsBuilder.createTagSettings().build();
    updateTagSettings = settingsBuilder.updateTagSettings().build();
    deleteTagSettings = settingsBuilder.deleteTagSettings().build();
    listTagsSettings = settingsBuilder.listTagsSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DataCatalogStubSettings. */
  public static class Builder extends StubSettings.Builder<DataCatalogStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings;
    private final UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings;
    private final UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings;
    private final UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
    private final UnaryCallSettings.Builder<DeleteEntryGroupRequest, Empty>
        deleteEntryGroupSettings;
    private final PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings;
    private final UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings;
    private final UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings;
    private final UnaryCallSettings.Builder<DeleteEntryRequest, Empty> deleteEntrySettings;
    private final UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings;
    private final UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings;
    private final PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings;
    private final UnaryCallSettings.Builder<CreateTagTemplateRequest, TagTemplate>
        createTagTemplateSettings;
    private final UnaryCallSettings.Builder<GetTagTemplateRequest, TagTemplate>
        getTagTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateTagTemplateRequest, TagTemplate>
        updateTagTemplateSettings;
    private final UnaryCallSettings.Builder<DeleteTagTemplateRequest, Empty>
        deleteTagTemplateSettings;
    private final UnaryCallSettings.Builder<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldSettings;
    private final UnaryCallSettings.Builder<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldSettings;
    private final UnaryCallSettings.Builder<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldSettings;
    private final UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings;
    private final UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings;
    private final UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings;
    private final UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings;
    private final PagedCallSettings.Builder<
            ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      searchCatalogSettings = PagedCallSettings.newBuilder(SEARCH_CATALOG_PAGE_STR_FACT);
      createEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntryGroupsSettings = PagedCallSettings.newBuilder(LIST_ENTRY_GROUPS_PAGE_STR_FACT);
      createEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntriesSettings = PagedCallSettings.newBuilder(LIST_ENTRIES_PAGE_STR_FACT);
      createTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTagsSettings = PagedCallSettings.newBuilder(LIST_TAGS_PAGE_STR_FACT);
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogSettings,
              createEntryGroupSettings,
              updateEntryGroupSettings,
              getEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
              listEntriesSettings,
              createTagTemplateSettings,
              getTagTemplateSettings,
              updateTagTemplateSettings,
              deleteTagTemplateSettings,
              createTagTemplateFieldSettings,
              updateTagTemplateFieldSettings,
              renameTagTemplateFieldSettings,
              deleteTagTemplateFieldSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              listTagsSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DataCatalogStubSettings settings) {
      super(settings);

      searchCatalogSettings = settings.searchCatalogSettings.toBuilder();
      createEntryGroupSettings = settings.createEntryGroupSettings.toBuilder();
      updateEntryGroupSettings = settings.updateEntryGroupSettings.toBuilder();
      getEntryGroupSettings = settings.getEntryGroupSettings.toBuilder();
      deleteEntryGroupSettings = settings.deleteEntryGroupSettings.toBuilder();
      listEntryGroupsSettings = settings.listEntryGroupsSettings.toBuilder();
      createEntrySettings = settings.createEntrySettings.toBuilder();
      updateEntrySettings = settings.updateEntrySettings.toBuilder();
      deleteEntrySettings = settings.deleteEntrySettings.toBuilder();
      getEntrySettings = settings.getEntrySettings.toBuilder();
      lookupEntrySettings = settings.lookupEntrySettings.toBuilder();
      listEntriesSettings = settings.listEntriesSettings.toBuilder();
      createTagTemplateSettings = settings.createTagTemplateSettings.toBuilder();
      getTagTemplateSettings = settings.getTagTemplateSettings.toBuilder();
      updateTagTemplateSettings = settings.updateTagTemplateSettings.toBuilder();
      deleteTagTemplateSettings = settings.deleteTagTemplateSettings.toBuilder();
      createTagTemplateFieldSettings = settings.createTagTemplateFieldSettings.toBuilder();
      updateTagTemplateFieldSettings = settings.updateTagTemplateFieldSettings.toBuilder();
      renameTagTemplateFieldSettings = settings.renameTagTemplateFieldSettings.toBuilder();
      deleteTagTemplateFieldSettings = settings.deleteTagTemplateFieldSettings.toBuilder();
      createTagSettings = settings.createTagSettings.toBuilder();
      updateTagSettings = settings.updateTagSettings.toBuilder();
      deleteTagSettings = settings.deleteTagSettings.toBuilder();
      listTagsSettings = settings.listTagsSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogSettings,
              createEntryGroupSettings,
              updateEntryGroupSettings,
              getEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
              listEntriesSettings,
              createTagTemplateSettings,
              getTagTemplateSettings,
              updateTagTemplateSettings,
              deleteTagTemplateSettings,
              createTagTemplateFieldSettings,
              updateTagTemplateFieldSettings,
              renameTagTemplateFieldSettings,
              deleteTagTemplateFieldSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              listTagsSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .searchCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listEntryGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .lookupEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .renameTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to searchCatalog. */
    public PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings() {
      return searchCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings() {
      return createEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings() {
      return updateEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getEntryGroup. */
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
      return deleteEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listEntryGroups. */
    public PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings() {
      return listEntryGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to createEntry. */
    public UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings() {
      return createEntrySettings;
    }

    /** Returns the builder for the settings used for calls to updateEntry. */
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return updateEntrySettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntry. */
    public UnaryCallSettings.Builder<DeleteEntryRequest, Empty> deleteEntrySettings() {
      return deleteEntrySettings;
    }

    /** Returns the builder for the settings used for calls to getEntry. */
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getEntrySettings;
    }

    /** Returns the builder for the settings used for calls to lookupEntry. */
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return lookupEntrySettings;
    }

    /** Returns the builder for the settings used for calls to listEntries. */
    public PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings() {
      return listEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to createTagTemplate. */
    public UnaryCallSettings.Builder<CreateTagTemplateRequest, TagTemplate>
        createTagTemplateSettings() {
      return createTagTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getTagTemplate. */
    public UnaryCallSettings.Builder<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
      return getTagTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateTagTemplate. */
    public UnaryCallSettings.Builder<UpdateTagTemplateRequest, TagTemplate>
        updateTagTemplateSettings() {
      return updateTagTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagTemplate. */
    public UnaryCallSettings.Builder<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
      return deleteTagTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createTagTemplateField. */
    public UnaryCallSettings.Builder<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldSettings() {
      return createTagTemplateFieldSettings;
    }

    /** Returns the builder for the settings used for calls to updateTagTemplateField. */
    public UnaryCallSettings.Builder<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldSettings() {
      return updateTagTemplateFieldSettings;
    }

    /** Returns the builder for the settings used for calls to renameTagTemplateField. */
    public UnaryCallSettings.Builder<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldSettings() {
      return renameTagTemplateFieldSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagTemplateField. */
    public UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings() {
      return deleteTagTemplateFieldSettings;
    }

    /** Returns the builder for the settings used for calls to createTag. */
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return createTagSettings;
    }

    /** Returns the builder for the settings used for calls to updateTag. */
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return updateTagSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTag. */
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return deleteTagSettings;
    }

    /** Returns the builder for the settings used for calls to listTags. */
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return listTagsSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DataCatalogStubSettings build() throws IOException {
      return new DataCatalogStubSettings(this);
    }
  }
}
