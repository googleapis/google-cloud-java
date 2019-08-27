/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datacatalog.v1beta1.stub;

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
import com.google.cloud.datacatalog.CreateTagRequest;
import com.google.cloud.datacatalog.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.DeleteTagRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.Entry;
import com.google.cloud.datacatalog.GetEntryRequest;
import com.google.cloud.datacatalog.GetTagTemplateRequest;
import com.google.cloud.datacatalog.ListTagsRequest;
import com.google.cloud.datacatalog.ListTagsResponse;
import com.google.cloud.datacatalog.LookupEntryRequest;
import com.google.cloud.datacatalog.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.SearchCatalogRequest;
import com.google.cloud.datacatalog.SearchCatalogResponse;
import com.google.cloud.datacatalog.SearchCatalogResult;
import com.google.cloud.datacatalog.Tag;
import com.google.cloud.datacatalog.TagTemplate;
import com.google.cloud.datacatalog.TagTemplateField;
import com.google.cloud.datacatalog.UpdateEntryRequest;
import com.google.cloud.datacatalog.UpdateTagRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * <p>For example, to set the total timeout of updateEntry to 30 seconds:
 *
 * <pre>
 * <code>
 * DataCatalogStubSettings.Builder dataCatalogSettingsBuilder =
 *     DataCatalogStubSettings.newBuilder();
 * dataCatalogSettingsBuilder.updateEntrySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DataCatalogStubSettings dataCatalogSettings = dataCatalogSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DataCatalogStubSettings extends StubSettings<DataCatalogStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings;
  private final UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings;
  private final UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings;
  private final UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings;
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

  /** Returns the object with the settings used for calls to searchCatalog. */
  public PagedCallSettings<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
      searchCatalogSettings() {
    return searchCatalogSettings;
  }

  /** Returns the object with the settings used for calls to updateEntry. */
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return updateEntrySettings;
  }

  /** Returns the object with the settings used for calls to getEntry. */
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return getEntrySettings;
  }

  /** Returns the object with the settings used for calls to lookupEntry. */
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return lookupEntrySettings;
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataCatalogStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataCatalogStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "datacatalog.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataCatalogStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected DataCatalogStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchCatalogSettings = settingsBuilder.searchCatalogSettings().build();
    updateEntrySettings = settingsBuilder.updateEntrySettings().build();
    getEntrySettings = settingsBuilder.getEntrySettings().build();
    lookupEntrySettings = settingsBuilder.lookupEntrySettings().build();
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
              return payload.getResultsList() != null
                  ? payload.getResultsList()
                  : ImmutableList.<SearchCatalogResult>of();
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
              return payload.getTagsList() != null
                  ? payload.getTagsList()
                  : ImmutableList.<Tag>of();
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

  /** Builder for DataCatalogStubSettings. */
  public static class Builder extends StubSettings.Builder<DataCatalogStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            SearchCatalogRequest, SearchCatalogResponse, SearchCatalogPagedResponse>
        searchCatalogSettings;
    private final UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings;
    private final UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings;
    private final UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings;
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
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      searchCatalogSettings = PagedCallSettings.newBuilder(SEARCH_CATALOG_PAGE_STR_FACT);

      updateEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      lookupEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

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
              updateEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
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

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .searchCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .lookupEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTagTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .renameTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTagTemplateFieldSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(DataCatalogStubSettings settings) {
      super(settings);

      searchCatalogSettings = settings.searchCatalogSettings.toBuilder();
      updateEntrySettings = settings.updateEntrySettings.toBuilder();
      getEntrySettings = settings.getEntrySettings.toBuilder();
      lookupEntrySettings = settings.lookupEntrySettings.toBuilder();
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
              updateEntrySettings,
              getEntrySettings,
              lookupEntrySettings,
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

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
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

    /** Returns the builder for the settings used for calls to updateEntry. */
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return updateEntrySettings;
    }

    /** Returns the builder for the settings used for calls to getEntry. */
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getEntrySettings;
    }

    /** Returns the builder for the settings used for calls to lookupEntry. */
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return lookupEntrySettings;
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
