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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CopyLogEntriesMetadata;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.Settings;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConfigServiceV2Stub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (logging.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBucket to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigServiceV2StubSettings.Builder configSettingsBuilder =
 *     ConfigServiceV2StubSettings.newBuilder();
 * configSettingsBuilder
 *     .getBucketSettings()
 *     .setRetrySettings(
 *         configSettingsBuilder
 *             .getBucketSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConfigServiceV2StubSettings configSettings = configSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConfigServiceV2StubSettings extends StubSettings<ConfigServiceV2StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .build();

  private final PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings;
  private final UnaryCallSettings<GetBucketRequest, LogBucket> getBucketSettings;
  private final UnaryCallSettings<CreateBucketRequest, LogBucket> createBucketSettings;
  private final UnaryCallSettings<UpdateBucketRequest, LogBucket> updateBucketSettings;
  private final UnaryCallSettings<DeleteBucketRequest, Empty> deleteBucketSettings;
  private final UnaryCallSettings<UndeleteBucketRequest, Empty> undeleteBucketSettings;
  private final PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings;
  private final UnaryCallSettings<GetViewRequest, LogView> getViewSettings;
  private final UnaryCallSettings<CreateViewRequest, LogView> createViewSettings;
  private final UnaryCallSettings<UpdateViewRequest, LogView> updateViewSettings;
  private final UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings;
  private final PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings;
  private final UnaryCallSettings<GetSinkRequest, LogSink> getSinkSettings;
  private final UnaryCallSettings<CreateSinkRequest, LogSink> createSinkSettings;
  private final UnaryCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings;
  private final UnaryCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings;
  private final PagedCallSettings<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      listExclusionsSettings;
  private final UnaryCallSettings<GetExclusionRequest, LogExclusion> getExclusionSettings;
  private final UnaryCallSettings<CreateExclusionRequest, LogExclusion> createExclusionSettings;
  private final UnaryCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionSettings;
  private final UnaryCallSettings<DeleteExclusionRequest, Empty> deleteExclusionSettings;
  private final UnaryCallSettings<GetCmekSettingsRequest, CmekSettings> getCmekSettingsSettings;
  private final UnaryCallSettings<UpdateCmekSettingsRequest, CmekSettings>
      updateCmekSettingsSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings;
  private final UnaryCallSettings<CopyLogEntriesRequest, Operation> copyLogEntriesSettings;
  private final OperationCallSettings<
          CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationSettings;

  private static final PagedListDescriptor<ListBucketsRequest, ListBucketsResponse, LogBucket>
      LIST_BUCKETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBucketsRequest, ListBucketsResponse, LogBucket>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBucketsRequest injectToken(ListBucketsRequest payload, String token) {
              return ListBucketsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBucketsRequest injectPageSize(ListBucketsRequest payload, int pageSize) {
              return ListBucketsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBucketsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBucketsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogBucket> extractResources(ListBucketsResponse payload) {
              return payload.getBucketsList() == null
                  ? ImmutableList.<LogBucket>of()
                  : payload.getBucketsList();
            }
          };

  private static final PagedListDescriptor<ListViewsRequest, ListViewsResponse, LogView>
      LIST_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListViewsRequest, ListViewsResponse, LogView>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListViewsRequest injectToken(ListViewsRequest payload, String token) {
              return ListViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListViewsRequest injectPageSize(ListViewsRequest payload, int pageSize) {
              return ListViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogView> extractResources(ListViewsResponse payload) {
              return payload.getViewsList() == null
                  ? ImmutableList.<LogView>of()
                  : payload.getViewsList();
            }
          };

  private static final PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>
      LIST_SINKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSinksRequest injectToken(ListSinksRequest payload, String token) {
              return ListSinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSinksRequest injectPageSize(ListSinksRequest payload, int pageSize) {
              return ListSinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogSink> extractResources(ListSinksResponse payload) {
              return payload.getSinksList() == null
                  ? ImmutableList.<LogSink>of()
                  : payload.getSinksList();
            }
          };

  private static final PagedListDescriptor<
          ListExclusionsRequest, ListExclusionsResponse, LogExclusion>
      LIST_EXCLUSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExclusionsRequest, ListExclusionsResponse, LogExclusion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExclusionsRequest injectToken(ListExclusionsRequest payload, String token) {
              return ListExclusionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExclusionsRequest injectPageSize(
                ListExclusionsRequest payload, int pageSize) {
              return ListExclusionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExclusionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExclusionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogExclusion> extractResources(ListExclusionsResponse payload) {
              return payload.getExclusionsList() == null
                  ? ImmutableList.<LogExclusion>of()
                  : payload.getExclusionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      LIST_BUCKETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>() {
            @Override
            public ApiFuture<ListBucketsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBucketsRequest, ListBucketsResponse> callable,
                ListBucketsRequest request,
                ApiCallContext context,
                ApiFuture<ListBucketsResponse> futureResponse) {
              PageContext<ListBucketsRequest, ListBucketsResponse, LogBucket> pageContext =
                  PageContext.create(callable, LIST_BUCKETS_PAGE_STR_DESC, request, context);
              return ListBucketsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      LIST_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>() {
            @Override
            public ApiFuture<ListViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListViewsRequest, ListViewsResponse> callable,
                ListViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListViewsResponse> futureResponse) {
              PageContext<ListViewsRequest, ListViewsResponse, LogView> pageContext =
                  PageContext.create(callable, LIST_VIEWS_PAGE_STR_DESC, request, context);
              return ListViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      LIST_SINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>() {
            @Override
            public ApiFuture<ListSinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSinksRequest, ListSinksResponse> callable,
                ListSinksRequest request,
                ApiCallContext context,
                ApiFuture<ListSinksResponse> futureResponse) {
              PageContext<ListSinksRequest, ListSinksResponse, LogSink> pageContext =
                  PageContext.create(callable, LIST_SINKS_PAGE_STR_DESC, request, context);
              return ListSinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      LIST_EXCLUSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>() {
            @Override
            public ApiFuture<ListExclusionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> callable,
                ListExclusionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExclusionsResponse> futureResponse) {
              PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> pageContext =
                  PageContext.create(callable, LIST_EXCLUSIONS_PAGE_STR_DESC, request, context);
              return ListExclusionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listBuckets. */
  public PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings() {
    return listBucketsSettings;
  }

  /** Returns the object with the settings used for calls to getBucket. */
  public UnaryCallSettings<GetBucketRequest, LogBucket> getBucketSettings() {
    return getBucketSettings;
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public UnaryCallSettings<CreateBucketRequest, LogBucket> createBucketSettings() {
    return createBucketSettings;
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public UnaryCallSettings<UpdateBucketRequest, LogBucket> updateBucketSettings() {
    return updateBucketSettings;
  }

  /** Returns the object with the settings used for calls to deleteBucket. */
  public UnaryCallSettings<DeleteBucketRequest, Empty> deleteBucketSettings() {
    return deleteBucketSettings;
  }

  /** Returns the object with the settings used for calls to undeleteBucket. */
  public UnaryCallSettings<UndeleteBucketRequest, Empty> undeleteBucketSettings() {
    return undeleteBucketSettings;
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return listViewsSettings;
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, LogView> getViewSettings() {
    return getViewSettings;
  }

  /** Returns the object with the settings used for calls to createView. */
  public UnaryCallSettings<CreateViewRequest, LogView> createViewSettings() {
    return createViewSettings;
  }

  /** Returns the object with the settings used for calls to updateView. */
  public UnaryCallSettings<UpdateViewRequest, LogView> updateViewSettings() {
    return updateViewSettings;
  }

  /** Returns the object with the settings used for calls to deleteView. */
  public UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings() {
    return deleteViewSettings;
  }

  /** Returns the object with the settings used for calls to listSinks. */
  public PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings() {
    return listSinksSettings;
  }

  /** Returns the object with the settings used for calls to getSink. */
  public UnaryCallSettings<GetSinkRequest, LogSink> getSinkSettings() {
    return getSinkSettings;
  }

  /** Returns the object with the settings used for calls to createSink. */
  public UnaryCallSettings<CreateSinkRequest, LogSink> createSinkSettings() {
    return createSinkSettings;
  }

  /** Returns the object with the settings used for calls to updateSink. */
  public UnaryCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings() {
    return updateSinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteSink. */
  public UnaryCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings() {
    return deleteSinkSettings;
  }

  /** Returns the object with the settings used for calls to listExclusions. */
  public PagedCallSettings<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      listExclusionsSettings() {
    return listExclusionsSettings;
  }

  /** Returns the object with the settings used for calls to getExclusion. */
  public UnaryCallSettings<GetExclusionRequest, LogExclusion> getExclusionSettings() {
    return getExclusionSettings;
  }

  /** Returns the object with the settings used for calls to createExclusion. */
  public UnaryCallSettings<CreateExclusionRequest, LogExclusion> createExclusionSettings() {
    return createExclusionSettings;
  }

  /** Returns the object with the settings used for calls to updateExclusion. */
  public UnaryCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionSettings() {
    return updateExclusionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExclusion. */
  public UnaryCallSettings<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
    return deleteExclusionSettings;
  }

  /** Returns the object with the settings used for calls to getCmekSettings. */
  public UnaryCallSettings<GetCmekSettingsRequest, CmekSettings> getCmekSettingsSettings() {
    return getCmekSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateCmekSettings. */
  public UnaryCallSettings<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsSettings() {
    return updateCmekSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to copyLogEntries. */
  public UnaryCallSettings<CopyLogEntriesRequest, Operation> copyLogEntriesSettings() {
    return copyLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to copyLogEntries. */
  public OperationCallSettings<
          CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationSettings() {
    return copyLogEntriesOperationSettings;
  }

  public ConfigServiceV2Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConfigServiceV2Stub.create(this);
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
    return "logging.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "logging.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ConfigServiceV2StubSettings.class))
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

  protected ConfigServiceV2StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listBucketsSettings = settingsBuilder.listBucketsSettings().build();
    getBucketSettings = settingsBuilder.getBucketSettings().build();
    createBucketSettings = settingsBuilder.createBucketSettings().build();
    updateBucketSettings = settingsBuilder.updateBucketSettings().build();
    deleteBucketSettings = settingsBuilder.deleteBucketSettings().build();
    undeleteBucketSettings = settingsBuilder.undeleteBucketSettings().build();
    listViewsSettings = settingsBuilder.listViewsSettings().build();
    getViewSettings = settingsBuilder.getViewSettings().build();
    createViewSettings = settingsBuilder.createViewSettings().build();
    updateViewSettings = settingsBuilder.updateViewSettings().build();
    deleteViewSettings = settingsBuilder.deleteViewSettings().build();
    listSinksSettings = settingsBuilder.listSinksSettings().build();
    getSinkSettings = settingsBuilder.getSinkSettings().build();
    createSinkSettings = settingsBuilder.createSinkSettings().build();
    updateSinkSettings = settingsBuilder.updateSinkSettings().build();
    deleteSinkSettings = settingsBuilder.deleteSinkSettings().build();
    listExclusionsSettings = settingsBuilder.listExclusionsSettings().build();
    getExclusionSettings = settingsBuilder.getExclusionSettings().build();
    createExclusionSettings = settingsBuilder.createExclusionSettings().build();
    updateExclusionSettings = settingsBuilder.updateExclusionSettings().build();
    deleteExclusionSettings = settingsBuilder.deleteExclusionSettings().build();
    getCmekSettingsSettings = settingsBuilder.getCmekSettingsSettings().build();
    updateCmekSettingsSettings = settingsBuilder.updateCmekSettingsSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    copyLogEntriesSettings = settingsBuilder.copyLogEntriesSettings().build();
    copyLogEntriesOperationSettings = settingsBuilder.copyLogEntriesOperationSettings().build();
  }

  /** Builder for ConfigServiceV2StubSettings. */
  public static class Builder extends StubSettings.Builder<ConfigServiceV2StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings;
    private final UnaryCallSettings.Builder<GetBucketRequest, LogBucket> getBucketSettings;
    private final UnaryCallSettings.Builder<CreateBucketRequest, LogBucket> createBucketSettings;
    private final UnaryCallSettings.Builder<UpdateBucketRequest, LogBucket> updateBucketSettings;
    private final UnaryCallSettings.Builder<DeleteBucketRequest, Empty> deleteBucketSettings;
    private final UnaryCallSettings.Builder<UndeleteBucketRequest, Empty> undeleteBucketSettings;
    private final PagedCallSettings.Builder<
            ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings;
    private final UnaryCallSettings.Builder<GetViewRequest, LogView> getViewSettings;
    private final UnaryCallSettings.Builder<CreateViewRequest, LogView> createViewSettings;
    private final UnaryCallSettings.Builder<UpdateViewRequest, LogView> updateViewSettings;
    private final UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings;
    private final PagedCallSettings.Builder<
            ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings;
    private final UnaryCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings;
    private final UnaryCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings;
    private final UnaryCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings;
    private final UnaryCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings;
    private final PagedCallSettings.Builder<
            ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
        listExclusionsSettings;
    private final UnaryCallSettings.Builder<GetExclusionRequest, LogExclusion> getExclusionSettings;
    private final UnaryCallSettings.Builder<CreateExclusionRequest, LogExclusion>
        createExclusionSettings;
    private final UnaryCallSettings.Builder<UpdateExclusionRequest, LogExclusion>
        updateExclusionSettings;
    private final UnaryCallSettings.Builder<DeleteExclusionRequest, Empty> deleteExclusionSettings;
    private final UnaryCallSettings.Builder<GetCmekSettingsRequest, CmekSettings>
        getCmekSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateCmekSettingsRequest, CmekSettings>
        updateCmekSettingsSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings;
    private final UnaryCallSettings.Builder<CopyLogEntriesRequest, Operation>
        copyLogEntriesSettings;
    private final OperationCallSettings.Builder<
            CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
        copyLogEntriesOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_4_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
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
      definitions.put("retry_policy_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_4_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listBucketsSettings = PagedCallSettings.newBuilder(LIST_BUCKETS_PAGE_STR_FACT);
      getBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listViewsSettings = PagedCallSettings.newBuilder(LIST_VIEWS_PAGE_STR_FACT);
      getViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSinksSettings = PagedCallSettings.newBuilder(LIST_SINKS_PAGE_STR_FACT);
      getSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExclusionsSettings = PagedCallSettings.newBuilder(LIST_EXCLUSIONS_PAGE_STR_FACT);
      getExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCmekSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCmekSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyLogEntriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyLogEntriesOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listBucketsSettings,
              getBucketSettings,
              createBucketSettings,
              updateBucketSettings,
              deleteBucketSettings,
              undeleteBucketSettings,
              listViewsSettings,
              getViewSettings,
              createViewSettings,
              updateViewSettings,
              deleteViewSettings,
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings,
              listExclusionsSettings,
              getExclusionSettings,
              createExclusionSettings,
              updateExclusionSettings,
              deleteExclusionSettings,
              getCmekSettingsSettings,
              updateCmekSettingsSettings,
              getSettingsSettings,
              updateSettingsSettings,
              copyLogEntriesSettings);
      initDefaults(this);
    }

    protected Builder(ConfigServiceV2StubSettings settings) {
      super(settings);

      listBucketsSettings = settings.listBucketsSettings.toBuilder();
      getBucketSettings = settings.getBucketSettings.toBuilder();
      createBucketSettings = settings.createBucketSettings.toBuilder();
      updateBucketSettings = settings.updateBucketSettings.toBuilder();
      deleteBucketSettings = settings.deleteBucketSettings.toBuilder();
      undeleteBucketSettings = settings.undeleteBucketSettings.toBuilder();
      listViewsSettings = settings.listViewsSettings.toBuilder();
      getViewSettings = settings.getViewSettings.toBuilder();
      createViewSettings = settings.createViewSettings.toBuilder();
      updateViewSettings = settings.updateViewSettings.toBuilder();
      deleteViewSettings = settings.deleteViewSettings.toBuilder();
      listSinksSettings = settings.listSinksSettings.toBuilder();
      getSinkSettings = settings.getSinkSettings.toBuilder();
      createSinkSettings = settings.createSinkSettings.toBuilder();
      updateSinkSettings = settings.updateSinkSettings.toBuilder();
      deleteSinkSettings = settings.deleteSinkSettings.toBuilder();
      listExclusionsSettings = settings.listExclusionsSettings.toBuilder();
      getExclusionSettings = settings.getExclusionSettings.toBuilder();
      createExclusionSettings = settings.createExclusionSettings.toBuilder();
      updateExclusionSettings = settings.updateExclusionSettings.toBuilder();
      deleteExclusionSettings = settings.deleteExclusionSettings.toBuilder();
      getCmekSettingsSettings = settings.getCmekSettingsSettings.toBuilder();
      updateCmekSettingsSettings = settings.updateCmekSettingsSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      copyLogEntriesSettings = settings.copyLogEntriesSettings.toBuilder();
      copyLogEntriesOperationSettings = settings.copyLogEntriesOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listBucketsSettings,
              getBucketSettings,
              createBucketSettings,
              updateBucketSettings,
              deleteBucketSettings,
              undeleteBucketSettings,
              listViewsSettings,
              getViewSettings,
              createViewSettings,
              updateViewSettings,
              deleteViewSettings,
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings,
              listExclusionsSettings,
              getExclusionSettings,
              createExclusionSettings,
              updateExclusionSettings,
              deleteExclusionSettings,
              getCmekSettingsSettings,
              updateCmekSettingsSettings,
              getSettingsSettings,
              updateSettingsSettings,
              copyLogEntriesSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listBucketsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .undeleteBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .createSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .deleteSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listExclusionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .createExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .updateExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getCmekSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCmekSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .copyLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .copyLogEntriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CopyLogEntriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CopyLogEntriesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CopyLogEntriesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listBuckets. */
    public PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings() {
      return listBucketsSettings;
    }

    /** Returns the builder for the settings used for calls to getBucket. */
    public UnaryCallSettings.Builder<GetBucketRequest, LogBucket> getBucketSettings() {
      return getBucketSettings;
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public UnaryCallSettings.Builder<CreateBucketRequest, LogBucket> createBucketSettings() {
      return createBucketSettings;
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, LogBucket> updateBucketSettings() {
      return updateBucketSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBucket. */
    public UnaryCallSettings.Builder<DeleteBucketRequest, Empty> deleteBucketSettings() {
      return deleteBucketSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteBucket. */
    public UnaryCallSettings.Builder<UndeleteBucketRequest, Empty> undeleteBucketSettings() {
      return undeleteBucketSettings;
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return listViewsSettings;
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, LogView> getViewSettings() {
      return getViewSettings;
    }

    /** Returns the builder for the settings used for calls to createView. */
    public UnaryCallSettings.Builder<CreateViewRequest, LogView> createViewSettings() {
      return createViewSettings;
    }

    /** Returns the builder for the settings used for calls to updateView. */
    public UnaryCallSettings.Builder<UpdateViewRequest, LogView> updateViewSettings() {
      return updateViewSettings;
    }

    /** Returns the builder for the settings used for calls to deleteView. */
    public UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings() {
      return deleteViewSettings;
    }

    /** Returns the builder for the settings used for calls to listSinks. */
    public PagedCallSettings.Builder<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings() {
      return listSinksSettings;
    }

    /** Returns the builder for the settings used for calls to getSink. */
    public UnaryCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings() {
      return getSinkSettings;
    }

    /** Returns the builder for the settings used for calls to createSink. */
    public UnaryCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings() {
      return createSinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateSink. */
    public UnaryCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings() {
      return updateSinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSink. */
    public UnaryCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings() {
      return deleteSinkSettings;
    }

    /** Returns the builder for the settings used for calls to listExclusions. */
    public PagedCallSettings.Builder<
            ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
        listExclusionsSettings() {
      return listExclusionsSettings;
    }

    /** Returns the builder for the settings used for calls to getExclusion. */
    public UnaryCallSettings.Builder<GetExclusionRequest, LogExclusion> getExclusionSettings() {
      return getExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to createExclusion. */
    public UnaryCallSettings.Builder<CreateExclusionRequest, LogExclusion>
        createExclusionSettings() {
      return createExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to updateExclusion. */
    public UnaryCallSettings.Builder<UpdateExclusionRequest, LogExclusion>
        updateExclusionSettings() {
      return updateExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExclusion. */
    public UnaryCallSettings.Builder<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
      return deleteExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to getCmekSettings. */
    public UnaryCallSettings.Builder<GetCmekSettingsRequest, CmekSettings>
        getCmekSettingsSettings() {
      return getCmekSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCmekSettings. */
    public UnaryCallSettings.Builder<UpdateCmekSettingsRequest, CmekSettings>
        updateCmekSettingsSettings() {
      return updateCmekSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to copyLogEntries. */
    public UnaryCallSettings.Builder<CopyLogEntriesRequest, Operation> copyLogEntriesSettings() {
      return copyLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to copyLogEntries. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
        copyLogEntriesOperationSettings() {
      return copyLogEntriesOperationSettings;
    }

    @Override
    public ConfigServiceV2StubSettings build() throws IOException {
      return new ConfigServiceV2StubSettings(this);
    }
  }
}
