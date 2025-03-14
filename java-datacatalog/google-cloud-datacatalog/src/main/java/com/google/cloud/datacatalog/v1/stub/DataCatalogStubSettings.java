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

package com.google.cloud.datacatalog.v1.stub;

import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.SearchCatalogPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.Contacts;
import com.google.cloud.datacatalog.v1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1.CreateTagRequest;
import com.google.cloud.datacatalog.v1.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.v1.DeleteEntryRequest;
import com.google.cloud.datacatalog.v1.DeleteTagRequest;
import com.google.cloud.datacatalog.v1.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryGroup;
import com.google.cloud.datacatalog.v1.EntryOverview;
import com.google.cloud.datacatalog.v1.GetEntryGroupRequest;
import com.google.cloud.datacatalog.v1.GetEntryRequest;
import com.google.cloud.datacatalog.v1.GetTagTemplateRequest;
import com.google.cloud.datacatalog.v1.ImportEntriesMetadata;
import com.google.cloud.datacatalog.v1.ImportEntriesRequest;
import com.google.cloud.datacatalog.v1.ImportEntriesResponse;
import com.google.cloud.datacatalog.v1.ListEntriesRequest;
import com.google.cloud.datacatalog.v1.ListEntriesResponse;
import com.google.cloud.datacatalog.v1.ListEntryGroupsRequest;
import com.google.cloud.datacatalog.v1.ListEntryGroupsResponse;
import com.google.cloud.datacatalog.v1.ListTagsRequest;
import com.google.cloud.datacatalog.v1.ListTagsResponse;
import com.google.cloud.datacatalog.v1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1.MigrationConfig;
import com.google.cloud.datacatalog.v1.ModifyEntryContactsRequest;
import com.google.cloud.datacatalog.v1.ModifyEntryOverviewRequest;
import com.google.cloud.datacatalog.v1.OrganizationConfig;
import com.google.cloud.datacatalog.v1.ReconcileTagsMetadata;
import com.google.cloud.datacatalog.v1.ReconcileTagsRequest;
import com.google.cloud.datacatalog.v1.ReconcileTagsResponse;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldEnumValueRequest;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.RetrieveConfigRequest;
import com.google.cloud.datacatalog.v1.RetrieveEffectiveConfigRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogResponse;
import com.google.cloud.datacatalog.v1.SearchCatalogResult;
import com.google.cloud.datacatalog.v1.SetConfigRequest;
import com.google.cloud.datacatalog.v1.StarEntryRequest;
import com.google.cloud.datacatalog.v1.StarEntryResponse;
import com.google.cloud.datacatalog.v1.Tag;
import com.google.cloud.datacatalog.v1.TagTemplate;
import com.google.cloud.datacatalog.v1.TagTemplateField;
import com.google.cloud.datacatalog.v1.UnstarEntryRequest;
import com.google.cloud.datacatalog.v1.UnstarEntryResponse;
import com.google.cloud.datacatalog.v1.UpdateEntryGroupRequest;
import com.google.cloud.datacatalog.v1.UpdateEntryRequest;
import com.google.cloud.datacatalog.v1.UpdateTagRequest;
import com.google.cloud.datacatalog.v1.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.UpdateTagTemplateRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

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
 * DataCatalogStubSettings.Builder dataCatalogSettingsBuilder =
 *     DataCatalogStubSettings.newBuilder();
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
 * DataCatalogStubSettings dataCatalogSettings = dataCatalogSettingsBuilder.build();
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
 * DataCatalogStubSettings.Builder dataCatalogSettingsBuilder =
 *     DataCatalogStubSettings.newBuilder();
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
public class DataCatalogStubSettings extends StubSettings<DataCatalogStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings;
  private final UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings;
  private final UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
  private final UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings;
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
  private final UnaryCallSettings<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewSettings;
  private final UnaryCallSettings<ModifyEntryContactsRequest, Contacts> modifyEntryContactsSettings;
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
  private final UnaryCallSettings<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueSettings;
  private final UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldSettings;
  private final UnaryCallSettings<CreateTagRequest, Tag> createTagSettings;
  private final UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings;
  private final UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings;
  private final PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings;
  private final UnaryCallSettings<ReconcileTagsRequest, Operation> reconcileTagsSettings;
  private final OperationCallSettings<
          ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
      reconcileTagsOperationSettings;
  private final UnaryCallSettings<StarEntryRequest, StarEntryResponse> starEntrySettings;
  private final UnaryCallSettings<UnstarEntryRequest, UnstarEntryResponse> unstarEntrySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<ImportEntriesRequest, Operation> importEntriesSettings;
  private final OperationCallSettings<
          ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
      importEntriesOperationSettings;
  private final UnaryCallSettings<SetConfigRequest, MigrationConfig> setConfigSettings;
  private final UnaryCallSettings<RetrieveConfigRequest, OrganizationConfig> retrieveConfigSettings;
  private final UnaryCallSettings<RetrieveEffectiveConfigRequest, MigrationConfig>
      retrieveEffectiveConfigSettings;

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
              return payload.getResultsList();
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
              return payload.getEntryGroupsList();
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
              return payload.getEntriesList();
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
              return payload.getTagsList();
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

  /**
   * Returns the object with the settings used for calls to searchCatalog.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings() {
    return searchCatalogSettings;
  }

  /**
   * Returns the object with the settings used for calls to createEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupSettings() {
    return createEntryGroupSettings;
  }

  /**
   * Returns the object with the settings used for calls to getEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return getEntryGroupSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupSettings() {
    return updateEntryGroupSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteEntryGroup.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
    return deleteEntryGroupSettings;
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
    return listEntryGroupsSettings;
  }

  /**
   * Returns the object with the settings used for calls to createEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return createEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to updateEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return updateEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteEntryRequest, Empty> deleteEntrySettings() {
    return deleteEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to getEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return getEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to lookupEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return lookupEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to listEntries.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return listEntriesSettings;
  }

  /**
   * Returns the object with the settings used for calls to modifyEntryOverview.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewSettings() {
    return modifyEntryOverviewSettings;
  }

  /**
   * Returns the object with the settings used for calls to modifyEntryContacts.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ModifyEntryContactsRequest, Contacts> modifyEntryContactsSettings() {
    return modifyEntryContactsSettings;
  }

  /**
   * Returns the object with the settings used for calls to createTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateSettings() {
    return createTagTemplateSettings;
  }

  /**
   * Returns the object with the settings used for calls to getTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
    return getTagTemplateSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateSettings() {
    return updateTagTemplateSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteTagTemplate.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
    return deleteTagTemplateSettings;
  }

  /**
   * Returns the object with the settings used for calls to createTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldSettings() {
    return createTagTemplateFieldSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldSettings() {
    return updateTagTemplateFieldSettings;
  }

  /**
   * Returns the object with the settings used for calls to renameTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldSettings() {
    return renameTagTemplateFieldSettings;
  }

  /**
   * Returns the object with the settings used for calls to renameTagTemplateFieldEnumValue.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueSettings() {
    return renameTagTemplateFieldEnumValueSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteTagTemplateField.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldSettings() {
    return deleteTagTemplateFieldSettings;
  }

  /**
   * Returns the object with the settings used for calls to createTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CreateTagRequest, Tag> createTagSettings() {
    return createTagSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateTagRequest, Tag> updateTagSettings() {
    return updateTagSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteTag.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeleteTagRequest, Empty> deleteTagSettings() {
    return deleteTagSettings;
  }

  /**
   * Returns the object with the settings used for calls to listTags.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
      listTagsSettings() {
    return listTagsSettings;
  }

  /**
   * Returns the object with the settings used for calls to reconcileTags.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ReconcileTagsRequest, Operation> reconcileTagsSettings() {
    return reconcileTagsSettings;
  }

  /** Returns the object with the settings used for calls to reconcileTags. */
  public OperationCallSettings<ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
      reconcileTagsOperationSettings() {
    return reconcileTagsOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to starEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<StarEntryRequest, StarEntryResponse> starEntrySettings() {
    return starEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to unstarEntry.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UnstarEntryRequest, UnstarEntryResponse> unstarEntrySettings() {
    return unstarEntrySettings;
  }

  /**
   * Returns the object with the settings used for calls to setIamPolicy.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /**
   * Returns the object with the settings used for calls to getIamPolicy.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissions.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to importEntries.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<ImportEntriesRequest, Operation> importEntriesSettings() {
    return importEntriesSettings;
  }

  /** Returns the object with the settings used for calls to importEntries. */
  public OperationCallSettings<ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
      importEntriesOperationSettings() {
    return importEntriesOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to setConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SetConfigRequest, MigrationConfig> setConfigSettings() {
    return setConfigSettings;
  }

  /**
   * Returns the object with the settings used for calls to retrieveConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RetrieveConfigRequest, OrganizationConfig> retrieveConfigSettings() {
    return retrieveConfigSettings;
  }

  /**
   * Returns the object with the settings used for calls to retrieveEffectiveConfig.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<RetrieveEffectiveConfigRequest, MigrationConfig>
      retrieveEffectiveConfigSettings() {
    return retrieveEffectiveConfigSettings;
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

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "datacatalog";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataCatalogStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

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
    getEntryGroupSettings = settingsBuilder.getEntryGroupSettings().build();
    updateEntryGroupSettings = settingsBuilder.updateEntryGroupSettings().build();
    deleteEntryGroupSettings = settingsBuilder.deleteEntryGroupSettings().build();
    listEntryGroupsSettings = settingsBuilder.listEntryGroupsSettings().build();
    createEntrySettings = settingsBuilder.createEntrySettings().build();
    updateEntrySettings = settingsBuilder.updateEntrySettings().build();
    deleteEntrySettings = settingsBuilder.deleteEntrySettings().build();
    getEntrySettings = settingsBuilder.getEntrySettings().build();
    lookupEntrySettings = settingsBuilder.lookupEntrySettings().build();
    listEntriesSettings = settingsBuilder.listEntriesSettings().build();
    modifyEntryOverviewSettings = settingsBuilder.modifyEntryOverviewSettings().build();
    modifyEntryContactsSettings = settingsBuilder.modifyEntryContactsSettings().build();
    createTagTemplateSettings = settingsBuilder.createTagTemplateSettings().build();
    getTagTemplateSettings = settingsBuilder.getTagTemplateSettings().build();
    updateTagTemplateSettings = settingsBuilder.updateTagTemplateSettings().build();
    deleteTagTemplateSettings = settingsBuilder.deleteTagTemplateSettings().build();
    createTagTemplateFieldSettings = settingsBuilder.createTagTemplateFieldSettings().build();
    updateTagTemplateFieldSettings = settingsBuilder.updateTagTemplateFieldSettings().build();
    renameTagTemplateFieldSettings = settingsBuilder.renameTagTemplateFieldSettings().build();
    renameTagTemplateFieldEnumValueSettings =
        settingsBuilder.renameTagTemplateFieldEnumValueSettings().build();
    deleteTagTemplateFieldSettings = settingsBuilder.deleteTagTemplateFieldSettings().build();
    createTagSettings = settingsBuilder.createTagSettings().build();
    updateTagSettings = settingsBuilder.updateTagSettings().build();
    deleteTagSettings = settingsBuilder.deleteTagSettings().build();
    listTagsSettings = settingsBuilder.listTagsSettings().build();
    reconcileTagsSettings = settingsBuilder.reconcileTagsSettings().build();
    reconcileTagsOperationSettings = settingsBuilder.reconcileTagsOperationSettings().build();
    starEntrySettings = settingsBuilder.starEntrySettings().build();
    unstarEntrySettings = settingsBuilder.unstarEntrySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    importEntriesSettings = settingsBuilder.importEntriesSettings().build();
    importEntriesOperationSettings = settingsBuilder.importEntriesOperationSettings().build();
    setConfigSettings = settingsBuilder.setConfigSettings().build();
    retrieveConfigSettings = settingsBuilder.retrieveConfigSettings().build();
    retrieveEffectiveConfigSettings = settingsBuilder.retrieveEffectiveConfigSettings().build();
  }

  /** Builder for DataCatalogStubSettings. */
  public static class Builder extends StubSettings.Builder<DataCatalogStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings;
    private final UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings;
    private final UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
    private final UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings;
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
    private final UnaryCallSettings.Builder<ModifyEntryOverviewRequest, EntryOverview>
        modifyEntryOverviewSettings;
    private final UnaryCallSettings.Builder<ModifyEntryContactsRequest, Contacts>
        modifyEntryContactsSettings;
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
    private final UnaryCallSettings.Builder<
            RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
        renameTagTemplateFieldEnumValueSettings;
    private final UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings;
    private final UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings;
    private final UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings;
    private final UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings;
    private final PagedCallSettings.Builder<
            ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings;
    private final UnaryCallSettings.Builder<ReconcileTagsRequest, Operation> reconcileTagsSettings;
    private final OperationCallSettings.Builder<
            ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
        reconcileTagsOperationSettings;
    private final UnaryCallSettings.Builder<StarEntryRequest, StarEntryResponse> starEntrySettings;
    private final UnaryCallSettings.Builder<UnstarEntryRequest, UnstarEntryResponse>
        unstarEntrySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<ImportEntriesRequest, Operation> importEntriesSettings;
    private final OperationCallSettings.Builder<
            ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
        importEntriesOperationSettings;
    private final UnaryCallSettings.Builder<SetConfigRequest, MigrationConfig> setConfigSettings;
    private final UnaryCallSettings.Builder<RetrieveConfigRequest, OrganizationConfig>
        retrieveConfigSettings;
    private final UnaryCallSettings.Builder<RetrieveEffectiveConfigRequest, MigrationConfig>
        retrieveEffectiveConfigSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.INTERNAL)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      searchCatalogSettings = PagedCallSettings.newBuilder(SEARCH_CATALOG_PAGE_STR_FACT);
      createEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntryGroupsSettings = PagedCallSettings.newBuilder(LIST_ENTRY_GROUPS_PAGE_STR_FACT);
      createEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntriesSettings = PagedCallSettings.newBuilder(LIST_ENTRIES_PAGE_STR_FACT);
      modifyEntryOverviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      modifyEntryContactsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameTagTemplateFieldEnumValueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagTemplateFieldSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTagsSettings = PagedCallSettings.newBuilder(LIST_TAGS_PAGE_STR_FACT);
      reconcileTagsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reconcileTagsOperationSettings = OperationCallSettings.newBuilder();
      starEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      unstarEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importEntriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importEntriesOperationSettings = OperationCallSettings.newBuilder();
      setConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveEffectiveConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogSettings,
              createEntryGroupSettings,
              getEntryGroupSettings,
              updateEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
              listEntriesSettings,
              modifyEntryOverviewSettings,
              modifyEntryContactsSettings,
              createTagTemplateSettings,
              getTagTemplateSettings,
              updateTagTemplateSettings,
              deleteTagTemplateSettings,
              createTagTemplateFieldSettings,
              updateTagTemplateFieldSettings,
              renameTagTemplateFieldSettings,
              renameTagTemplateFieldEnumValueSettings,
              deleteTagTemplateFieldSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              listTagsSettings,
              reconcileTagsSettings,
              starEntrySettings,
              unstarEntrySettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              importEntriesSettings,
              setConfigSettings,
              retrieveConfigSettings,
              retrieveEffectiveConfigSettings);
      initDefaults(this);
    }

    protected Builder(DataCatalogStubSettings settings) {
      super(settings);

      searchCatalogSettings = settings.searchCatalogSettings.toBuilder();
      createEntryGroupSettings = settings.createEntryGroupSettings.toBuilder();
      getEntryGroupSettings = settings.getEntryGroupSettings.toBuilder();
      updateEntryGroupSettings = settings.updateEntryGroupSettings.toBuilder();
      deleteEntryGroupSettings = settings.deleteEntryGroupSettings.toBuilder();
      listEntryGroupsSettings = settings.listEntryGroupsSettings.toBuilder();
      createEntrySettings = settings.createEntrySettings.toBuilder();
      updateEntrySettings = settings.updateEntrySettings.toBuilder();
      deleteEntrySettings = settings.deleteEntrySettings.toBuilder();
      getEntrySettings = settings.getEntrySettings.toBuilder();
      lookupEntrySettings = settings.lookupEntrySettings.toBuilder();
      listEntriesSettings = settings.listEntriesSettings.toBuilder();
      modifyEntryOverviewSettings = settings.modifyEntryOverviewSettings.toBuilder();
      modifyEntryContactsSettings = settings.modifyEntryContactsSettings.toBuilder();
      createTagTemplateSettings = settings.createTagTemplateSettings.toBuilder();
      getTagTemplateSettings = settings.getTagTemplateSettings.toBuilder();
      updateTagTemplateSettings = settings.updateTagTemplateSettings.toBuilder();
      deleteTagTemplateSettings = settings.deleteTagTemplateSettings.toBuilder();
      createTagTemplateFieldSettings = settings.createTagTemplateFieldSettings.toBuilder();
      updateTagTemplateFieldSettings = settings.updateTagTemplateFieldSettings.toBuilder();
      renameTagTemplateFieldSettings = settings.renameTagTemplateFieldSettings.toBuilder();
      renameTagTemplateFieldEnumValueSettings =
          settings.renameTagTemplateFieldEnumValueSettings.toBuilder();
      deleteTagTemplateFieldSettings = settings.deleteTagTemplateFieldSettings.toBuilder();
      createTagSettings = settings.createTagSettings.toBuilder();
      updateTagSettings = settings.updateTagSettings.toBuilder();
      deleteTagSettings = settings.deleteTagSettings.toBuilder();
      listTagsSettings = settings.listTagsSettings.toBuilder();
      reconcileTagsSettings = settings.reconcileTagsSettings.toBuilder();
      reconcileTagsOperationSettings = settings.reconcileTagsOperationSettings.toBuilder();
      starEntrySettings = settings.starEntrySettings.toBuilder();
      unstarEntrySettings = settings.unstarEntrySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      importEntriesSettings = settings.importEntriesSettings.toBuilder();
      importEntriesOperationSettings = settings.importEntriesOperationSettings.toBuilder();
      setConfigSettings = settings.setConfigSettings.toBuilder();
      retrieveConfigSettings = settings.retrieveConfigSettings.toBuilder();
      retrieveEffectiveConfigSettings = settings.retrieveEffectiveConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogSettings,
              createEntryGroupSettings,
              getEntryGroupSettings,
              updateEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
              listEntriesSettings,
              modifyEntryOverviewSettings,
              modifyEntryContactsSettings,
              createTagTemplateSettings,
              getTagTemplateSettings,
              updateTagTemplateSettings,
              deleteTagTemplateSettings,
              createTagTemplateFieldSettings,
              updateTagTemplateFieldSettings,
              renameTagTemplateFieldSettings,
              renameTagTemplateFieldEnumValueSettings,
              deleteTagTemplateFieldSettings,
              createTagSettings,
              updateTagSettings,
              deleteTagSettings,
              listTagsSettings,
              reconcileTagsSettings,
              starEntrySettings,
              unstarEntrySettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              importEntriesSettings,
              setConfigSettings,
              retrieveConfigSettings,
              retrieveEffectiveConfigSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .searchCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEntryGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .modifyEntryOverviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .modifyEntryContactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .renameTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .renameTagTemplateFieldEnumValueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reconcileTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .starEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .unstarEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .retrieveConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .retrieveEffectiveConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reconcileTagsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReconcileTagsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReconcileTagsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ReconcileTagsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importEntriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportEntriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportEntriesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportEntriesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /**
     * Returns the builder for the settings used for calls to searchCatalog.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings() {
      return searchCatalogSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, EntryGroup>
        createEntryGroupSettings() {
      return createEntryGroupSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getEntryGroupSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup>
        updateEntryGroupSettings() {
      return updateEntryGroupSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteEntryGroup.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Empty> deleteEntryGroupSettings() {
      return deleteEntryGroupSettings;
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
      return listEntryGroupsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings() {
      return createEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return updateEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteEntryRequest, Empty> deleteEntrySettings() {
      return deleteEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to getEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to lookupEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return lookupEntrySettings;
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
      return listEntriesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to modifyEntryOverview.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ModifyEntryOverviewRequest, EntryOverview>
        modifyEntryOverviewSettings() {
      return modifyEntryOverviewSettings;
    }

    /**
     * Returns the builder for the settings used for calls to modifyEntryContacts.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ModifyEntryContactsRequest, Contacts>
        modifyEntryContactsSettings() {
      return modifyEntryContactsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagTemplateRequest, TagTemplate>
        createTagTemplateSettings() {
      return createTagTemplateSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetTagTemplateRequest, TagTemplate> getTagTemplateSettings() {
      return getTagTemplateSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagTemplateRequest, TagTemplate>
        updateTagTemplateSettings() {
      return updateTagTemplateSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteTagTemplate.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagTemplateRequest, Empty> deleteTagTemplateSettings() {
      return deleteTagTemplateSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldSettings() {
      return createTagTemplateFieldSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldSettings() {
      return updateTagTemplateFieldSettings;
    }

    /**
     * Returns the builder for the settings used for calls to renameTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldSettings() {
      return renameTagTemplateFieldSettings;
    }

    /**
     * Returns the builder for the settings used for calls to renameTagTemplateFieldEnumValue.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
        renameTagTemplateFieldEnumValueSettings() {
      return renameTagTemplateFieldEnumValueSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteTagTemplateField.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldSettings() {
      return deleteTagTemplateFieldSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CreateTagRequest, Tag> createTagSettings() {
      return createTagSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateTagRequest, Tag> updateTagSettings() {
      return updateTagSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteTag.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeleteTagRequest, Empty> deleteTagSettings() {
      return deleteTagSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listTags.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<ListTagsRequest, ListTagsResponse, ListTagsPagedResponse>
        listTagsSettings() {
      return listTagsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to reconcileTags.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ReconcileTagsRequest, Operation> reconcileTagsSettings() {
      return reconcileTagsSettings;
    }

    /** Returns the builder for the settings used for calls to reconcileTags. */
    public OperationCallSettings.Builder<
            ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
        reconcileTagsOperationSettings() {
      return reconcileTagsOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to starEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<StarEntryRequest, StarEntryResponse> starEntrySettings() {
      return starEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to unstarEntry.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UnstarEntryRequest, UnstarEntryResponse>
        unstarEntrySettings() {
      return unstarEntrySettings;
    }

    /**
     * Returns the builder for the settings used for calls to setIamPolicy.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to getIamPolicy.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to testIamPermissions.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to importEntries.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<ImportEntriesRequest, Operation> importEntriesSettings() {
      return importEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to importEntries. */
    public OperationCallSettings.Builder<
            ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
        importEntriesOperationSettings() {
      return importEntriesOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to setConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SetConfigRequest, MigrationConfig> setConfigSettings() {
      return setConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to retrieveConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RetrieveConfigRequest, OrganizationConfig>
        retrieveConfigSettings() {
      return retrieveConfigSettings;
    }

    /**
     * Returns the builder for the settings used for calls to retrieveEffectiveConfig.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<RetrieveEffectiveConfigRequest, MigrationConfig>
        retrieveEffectiveConfigSettings() {
      return retrieveEffectiveConfigSettings;
    }

    @Override
    public DataCatalogStubSettings build() throws IOException {
      return new DataCatalogStubSettings(this);
    }
  }
}
