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

package com.google.cloud.video.stitcher.v1.stub;

import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListCdnKeysPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveConfigsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.cloud.video.stitcher.v1.CdnKey;
import com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.CreateLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.CreateSlateRequest;
import com.google.cloud.video.stitcher.v1.CreateVodSessionRequest;
import com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.DeleteLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.DeleteSlateRequest;
import com.google.cloud.video.stitcher.v1.GetCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.GetLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.GetSlateRequest;
import com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetVodSessionRequest;
import com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysResponse;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListLiveConfigsRequest;
import com.google.cloud.video.stitcher.v1.ListLiveConfigsResponse;
import com.google.cloud.video.stitcher.v1.ListSlatesRequest;
import com.google.cloud.video.stitcher.v1.ListSlatesResponse;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse;
import com.google.cloud.video.stitcher.v1.LiveAdTagDetail;
import com.google.cloud.video.stitcher.v1.LiveConfig;
import com.google.cloud.video.stitcher.v1.LiveSession;
import com.google.cloud.video.stitcher.v1.OperationMetadata;
import com.google.cloud.video.stitcher.v1.Slate;
import com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.UpdateSlateRequest;
import com.google.cloud.video.stitcher.v1.VodAdTagDetail;
import com.google.cloud.video.stitcher.v1.VodSession;
import com.google.cloud.video.stitcher.v1.VodStitchDetail;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VideoStitcherServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (videostitcher.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCdnKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VideoStitcherServiceStubSettings.Builder videoStitcherServiceSettingsBuilder =
 *     VideoStitcherServiceStubSettings.newBuilder();
 * videoStitcherServiceSettingsBuilder
 *     .getCdnKeySettings()
 *     .setRetrySettings(
 *         videoStitcherServiceSettingsBuilder
 *             .getCdnKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VideoStitcherServiceStubSettings videoStitcherServiceSettings =
 *     videoStitcherServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VideoStitcherServiceStubSettings
    extends StubSettings<VideoStitcherServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCdnKeyRequest, Operation> createCdnKeySettings;
  private final OperationCallSettings<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationSettings;
  private final PagedCallSettings<ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
      listCdnKeysSettings;
  private final UnaryCallSettings<GetCdnKeyRequest, CdnKey> getCdnKeySettings;
  private final UnaryCallSettings<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings;
  private final OperationCallSettings<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationSettings;
  private final UnaryCallSettings<UpdateCdnKeyRequest, Operation> updateCdnKeySettings;
  private final OperationCallSettings<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationSettings;
  private final UnaryCallSettings<CreateVodSessionRequest, VodSession> createVodSessionSettings;
  private final UnaryCallSettings<GetVodSessionRequest, VodSession> getVodSessionSettings;
  private final PagedCallSettings<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsSettings;
  private final UnaryCallSettings<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailSettings;
  private final PagedCallSettings<
          ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsSettings;
  private final UnaryCallSettings<GetVodAdTagDetailRequest, VodAdTagDetail>
      getVodAdTagDetailSettings;
  private final PagedCallSettings<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsSettings;
  private final UnaryCallSettings<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailSettings;
  private final UnaryCallSettings<CreateSlateRequest, Operation> createSlateSettings;
  private final OperationCallSettings<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationSettings;
  private final PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings;
  private final UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings;
  private final UnaryCallSettings<UpdateSlateRequest, Operation> updateSlateSettings;
  private final OperationCallSettings<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationSettings;
  private final UnaryCallSettings<DeleteSlateRequest, Operation> deleteSlateSettings;
  private final OperationCallSettings<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationSettings;
  private final UnaryCallSettings<CreateLiveSessionRequest, LiveSession> createLiveSessionSettings;
  private final UnaryCallSettings<GetLiveSessionRequest, LiveSession> getLiveSessionSettings;
  private final UnaryCallSettings<CreateLiveConfigRequest, Operation> createLiveConfigSettings;
  private final OperationCallSettings<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationSettings;
  private final PagedCallSettings<
          ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
      listLiveConfigsSettings;
  private final UnaryCallSettings<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings;
  private final UnaryCallSettings<DeleteLiveConfigRequest, Operation> deleteLiveConfigSettings;
  private final OperationCallSettings<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationSettings;

  private static final PagedListDescriptor<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey>
      LIST_CDN_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCdnKeysRequest injectToken(ListCdnKeysRequest payload, String token) {
              return ListCdnKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCdnKeysRequest injectPageSize(ListCdnKeysRequest payload, int pageSize) {
              return ListCdnKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCdnKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCdnKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CdnKey> extractResources(ListCdnKeysResponse payload) {
              return payload.getCdnKeysList() == null
                  ? ImmutableList.<CdnKey>of()
                  : payload.getCdnKeysList();
            }
          };

  private static final PagedListDescriptor<
          ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
      LIST_VOD_STITCH_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVodStitchDetailsRequest injectToken(
                ListVodStitchDetailsRequest payload, String token) {
              return ListVodStitchDetailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVodStitchDetailsRequest injectPageSize(
                ListVodStitchDetailsRequest payload, int pageSize) {
              return ListVodStitchDetailsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVodStitchDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVodStitchDetailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VodStitchDetail> extractResources(
                ListVodStitchDetailsResponse payload) {
              return payload.getVodStitchDetailsList() == null
                  ? ImmutableList.<VodStitchDetail>of()
                  : payload.getVodStitchDetailsList();
            }
          };

  private static final PagedListDescriptor<
          ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
      LIST_VOD_AD_TAG_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVodAdTagDetailsRequest injectToken(
                ListVodAdTagDetailsRequest payload, String token) {
              return ListVodAdTagDetailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVodAdTagDetailsRequest injectPageSize(
                ListVodAdTagDetailsRequest payload, int pageSize) {
              return ListVodAdTagDetailsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVodAdTagDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVodAdTagDetailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VodAdTagDetail> extractResources(ListVodAdTagDetailsResponse payload) {
              return payload.getVodAdTagDetailsList() == null
                  ? ImmutableList.<VodAdTagDetail>of()
                  : payload.getVodAdTagDetailsList();
            }
          };

  private static final PagedListDescriptor<
          ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
      LIST_LIVE_AD_TAG_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLiveAdTagDetailsRequest injectToken(
                ListLiveAdTagDetailsRequest payload, String token) {
              return ListLiveAdTagDetailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLiveAdTagDetailsRequest injectPageSize(
                ListLiveAdTagDetailsRequest payload, int pageSize) {
              return ListLiveAdTagDetailsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLiveAdTagDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLiveAdTagDetailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LiveAdTagDetail> extractResources(
                ListLiveAdTagDetailsResponse payload) {
              return payload.getLiveAdTagDetailsList() == null
                  ? ImmutableList.<LiveAdTagDetail>of()
                  : payload.getLiveAdTagDetailsList();
            }
          };

  private static final PagedListDescriptor<ListSlatesRequest, ListSlatesResponse, Slate>
      LIST_SLATES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSlatesRequest, ListSlatesResponse, Slate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSlatesRequest injectToken(ListSlatesRequest payload, String token) {
              return ListSlatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSlatesRequest injectPageSize(ListSlatesRequest payload, int pageSize) {
              return ListSlatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSlatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSlatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Slate> extractResources(ListSlatesResponse payload) {
              return payload.getSlatesList() == null
                  ? ImmutableList.<Slate>of()
                  : payload.getSlatesList();
            }
          };

  private static final PagedListDescriptor<
          ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig>
      LIST_LIVE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLiveConfigsRequest injectToken(
                ListLiveConfigsRequest payload, String token) {
              return ListLiveConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLiveConfigsRequest injectPageSize(
                ListLiveConfigsRequest payload, int pageSize) {
              return ListLiveConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLiveConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLiveConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LiveConfig> extractResources(ListLiveConfigsResponse payload) {
              return payload.getLiveConfigsList() == null
                  ? ImmutableList.<LiveConfig>of()
                  : payload.getLiveConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
      LIST_CDN_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>() {
            @Override
            public ApiFuture<ListCdnKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> callable,
                ListCdnKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListCdnKeysResponse> futureResponse) {
              PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> pageContext =
                  PageContext.create(callable, LIST_CDN_KEYS_PAGE_STR_DESC, request, context);
              return ListCdnKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          ListVodStitchDetailsPagedResponse>
      LIST_VOD_STITCH_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVodStitchDetailsRequest,
              ListVodStitchDetailsResponse,
              ListVodStitchDetailsPagedResponse>() {
            @Override
            public ApiFuture<ListVodStitchDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse> callable,
                ListVodStitchDetailsRequest request,
                ApiCallContext context,
                ApiFuture<ListVodStitchDetailsResponse> futureResponse) {
              PageContext<
                      ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOD_STITCH_DETAILS_PAGE_STR_DESC, request, context);
              return ListVodStitchDetailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, ListVodAdTagDetailsPagedResponse>
      LIST_VOD_AD_TAG_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVodAdTagDetailsRequest,
              ListVodAdTagDetailsResponse,
              ListVodAdTagDetailsPagedResponse>() {
            @Override
            public ApiFuture<ListVodAdTagDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse> callable,
                ListVodAdTagDetailsRequest request,
                ApiCallContext context,
                ApiFuture<ListVodAdTagDetailsResponse> futureResponse) {
              PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOD_AD_TAG_DETAILS_PAGE_STR_DESC, request, context);
              return ListVodAdTagDetailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          ListLiveAdTagDetailsPagedResponse>
      LIST_LIVE_AD_TAG_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLiveAdTagDetailsRequest,
              ListLiveAdTagDetailsResponse,
              ListLiveAdTagDetailsPagedResponse>() {
            @Override
            public ApiFuture<ListLiveAdTagDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse> callable,
                ListLiveAdTagDetailsRequest request,
                ApiCallContext context,
                ApiFuture<ListLiveAdTagDetailsResponse> futureResponse) {
              PageContext<
                      ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LIVE_AD_TAG_DETAILS_PAGE_STR_DESC, request, context);
              return ListLiveAdTagDetailsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      LIST_SLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>() {
            @Override
            public ApiFuture<ListSlatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSlatesRequest, ListSlatesResponse> callable,
                ListSlatesRequest request,
                ApiCallContext context,
                ApiFuture<ListSlatesResponse> futureResponse) {
              PageContext<ListSlatesRequest, ListSlatesResponse, Slate> pageContext =
                  PageContext.create(callable, LIST_SLATES_PAGE_STR_DESC, request, context);
              return ListSlatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
      LIST_LIVE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListLiveConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsResponse> callable,
                ListLiveConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListLiveConfigsResponse> futureResponse) {
              PageContext<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig> pageContext =
                  PageContext.create(callable, LIST_LIVE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListLiveConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createCdnKey. */
  public UnaryCallSettings<CreateCdnKeyRequest, Operation> createCdnKeySettings() {
    return createCdnKeySettings;
  }

  /** Returns the object with the settings used for calls to createCdnKey. */
  public OperationCallSettings<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationSettings() {
    return createCdnKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCdnKeys. */
  public PagedCallSettings<ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
      listCdnKeysSettings() {
    return listCdnKeysSettings;
  }

  /** Returns the object with the settings used for calls to getCdnKey. */
  public UnaryCallSettings<GetCdnKeyRequest, CdnKey> getCdnKeySettings() {
    return getCdnKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteCdnKey. */
  public UnaryCallSettings<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings() {
    return deleteCdnKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteCdnKey. */
  public OperationCallSettings<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationSettings() {
    return deleteCdnKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCdnKey. */
  public UnaryCallSettings<UpdateCdnKeyRequest, Operation> updateCdnKeySettings() {
    return updateCdnKeySettings;
  }

  /** Returns the object with the settings used for calls to updateCdnKey. */
  public OperationCallSettings<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationSettings() {
    return updateCdnKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to createVodSession. */
  public UnaryCallSettings<CreateVodSessionRequest, VodSession> createVodSessionSettings() {
    return createVodSessionSettings;
  }

  /** Returns the object with the settings used for calls to getVodSession. */
  public UnaryCallSettings<GetVodSessionRequest, VodSession> getVodSessionSettings() {
    return getVodSessionSettings;
  }

  /** Returns the object with the settings used for calls to listVodStitchDetails. */
  public PagedCallSettings<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsSettings() {
    return listVodStitchDetailsSettings;
  }

  /** Returns the object with the settings used for calls to getVodStitchDetail. */
  public UnaryCallSettings<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailSettings() {
    return getVodStitchDetailSettings;
  }

  /** Returns the object with the settings used for calls to listVodAdTagDetails. */
  public PagedCallSettings<
          ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsSettings() {
    return listVodAdTagDetailsSettings;
  }

  /** Returns the object with the settings used for calls to getVodAdTagDetail. */
  public UnaryCallSettings<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailSettings() {
    return getVodAdTagDetailSettings;
  }

  /** Returns the object with the settings used for calls to listLiveAdTagDetails. */
  public PagedCallSettings<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsSettings() {
    return listLiveAdTagDetailsSettings;
  }

  /** Returns the object with the settings used for calls to getLiveAdTagDetail. */
  public UnaryCallSettings<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailSettings() {
    return getLiveAdTagDetailSettings;
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public UnaryCallSettings<CreateSlateRequest, Operation> createSlateSettings() {
    return createSlateSettings;
  }

  /** Returns the object with the settings used for calls to createSlate. */
  public OperationCallSettings<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationSettings() {
    return createSlateOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSlates. */
  public PagedCallSettings<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
      listSlatesSettings() {
    return listSlatesSettings;
  }

  /** Returns the object with the settings used for calls to getSlate. */
  public UnaryCallSettings<GetSlateRequest, Slate> getSlateSettings() {
    return getSlateSettings;
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public UnaryCallSettings<UpdateSlateRequest, Operation> updateSlateSettings() {
    return updateSlateSettings;
  }

  /** Returns the object with the settings used for calls to updateSlate. */
  public OperationCallSettings<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationSettings() {
    return updateSlateOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSlate. */
  public UnaryCallSettings<DeleteSlateRequest, Operation> deleteSlateSettings() {
    return deleteSlateSettings;
  }

  /** Returns the object with the settings used for calls to deleteSlate. */
  public OperationCallSettings<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationSettings() {
    return deleteSlateOperationSettings;
  }

  /** Returns the object with the settings used for calls to createLiveSession. */
  public UnaryCallSettings<CreateLiveSessionRequest, LiveSession> createLiveSessionSettings() {
    return createLiveSessionSettings;
  }

  /** Returns the object with the settings used for calls to getLiveSession. */
  public UnaryCallSettings<GetLiveSessionRequest, LiveSession> getLiveSessionSettings() {
    return getLiveSessionSettings;
  }

  /** Returns the object with the settings used for calls to createLiveConfig. */
  public UnaryCallSettings<CreateLiveConfigRequest, Operation> createLiveConfigSettings() {
    return createLiveConfigSettings;
  }

  /** Returns the object with the settings used for calls to createLiveConfig. */
  public OperationCallSettings<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationSettings() {
    return createLiveConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLiveConfigs. */
  public PagedCallSettings<
          ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
      listLiveConfigsSettings() {
    return listLiveConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getLiveConfig. */
  public UnaryCallSettings<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings() {
    return getLiveConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteLiveConfig. */
  public UnaryCallSettings<DeleteLiveConfigRequest, Operation> deleteLiveConfigSettings() {
    return deleteLiveConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteLiveConfig. */
  public OperationCallSettings<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationSettings() {
    return deleteLiveConfigOperationSettings;
  }

  public VideoStitcherServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVideoStitcherServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "videostitcher";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "videostitcher.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "videostitcher.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VideoStitcherServiceStubSettings.class))
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

  protected VideoStitcherServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCdnKeySettings = settingsBuilder.createCdnKeySettings().build();
    createCdnKeyOperationSettings = settingsBuilder.createCdnKeyOperationSettings().build();
    listCdnKeysSettings = settingsBuilder.listCdnKeysSettings().build();
    getCdnKeySettings = settingsBuilder.getCdnKeySettings().build();
    deleteCdnKeySettings = settingsBuilder.deleteCdnKeySettings().build();
    deleteCdnKeyOperationSettings = settingsBuilder.deleteCdnKeyOperationSettings().build();
    updateCdnKeySettings = settingsBuilder.updateCdnKeySettings().build();
    updateCdnKeyOperationSettings = settingsBuilder.updateCdnKeyOperationSettings().build();
    createVodSessionSettings = settingsBuilder.createVodSessionSettings().build();
    getVodSessionSettings = settingsBuilder.getVodSessionSettings().build();
    listVodStitchDetailsSettings = settingsBuilder.listVodStitchDetailsSettings().build();
    getVodStitchDetailSettings = settingsBuilder.getVodStitchDetailSettings().build();
    listVodAdTagDetailsSettings = settingsBuilder.listVodAdTagDetailsSettings().build();
    getVodAdTagDetailSettings = settingsBuilder.getVodAdTagDetailSettings().build();
    listLiveAdTagDetailsSettings = settingsBuilder.listLiveAdTagDetailsSettings().build();
    getLiveAdTagDetailSettings = settingsBuilder.getLiveAdTagDetailSettings().build();
    createSlateSettings = settingsBuilder.createSlateSettings().build();
    createSlateOperationSettings = settingsBuilder.createSlateOperationSettings().build();
    listSlatesSettings = settingsBuilder.listSlatesSettings().build();
    getSlateSettings = settingsBuilder.getSlateSettings().build();
    updateSlateSettings = settingsBuilder.updateSlateSettings().build();
    updateSlateOperationSettings = settingsBuilder.updateSlateOperationSettings().build();
    deleteSlateSettings = settingsBuilder.deleteSlateSettings().build();
    deleteSlateOperationSettings = settingsBuilder.deleteSlateOperationSettings().build();
    createLiveSessionSettings = settingsBuilder.createLiveSessionSettings().build();
    getLiveSessionSettings = settingsBuilder.getLiveSessionSettings().build();
    createLiveConfigSettings = settingsBuilder.createLiveConfigSettings().build();
    createLiveConfigOperationSettings = settingsBuilder.createLiveConfigOperationSettings().build();
    listLiveConfigsSettings = settingsBuilder.listLiveConfigsSettings().build();
    getLiveConfigSettings = settingsBuilder.getLiveConfigSettings().build();
    deleteLiveConfigSettings = settingsBuilder.deleteLiveConfigSettings().build();
    deleteLiveConfigOperationSettings = settingsBuilder.deleteLiveConfigOperationSettings().build();
  }

  /** Builder for VideoStitcherServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<VideoStitcherServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCdnKeyRequest, Operation> createCdnKeySettings;
    private final OperationCallSettings.Builder<CreateCdnKeyRequest, CdnKey, OperationMetadata>
        createCdnKeyOperationSettings;
    private final PagedCallSettings.Builder<
            ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
        listCdnKeysSettings;
    private final UnaryCallSettings.Builder<GetCdnKeyRequest, CdnKey> getCdnKeySettings;
    private final UnaryCallSettings.Builder<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings;
    private final OperationCallSettings.Builder<DeleteCdnKeyRequest, Empty, OperationMetadata>
        deleteCdnKeyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCdnKeyRequest, Operation> updateCdnKeySettings;
    private final OperationCallSettings.Builder<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
        updateCdnKeyOperationSettings;
    private final UnaryCallSettings.Builder<CreateVodSessionRequest, VodSession>
        createVodSessionSettings;
    private final UnaryCallSettings.Builder<GetVodSessionRequest, VodSession> getVodSessionSettings;
    private final PagedCallSettings.Builder<
            ListVodStitchDetailsRequest,
            ListVodStitchDetailsResponse,
            ListVodStitchDetailsPagedResponse>
        listVodStitchDetailsSettings;
    private final UnaryCallSettings.Builder<GetVodStitchDetailRequest, VodStitchDetail>
        getVodStitchDetailSettings;
    private final PagedCallSettings.Builder<
            ListVodAdTagDetailsRequest,
            ListVodAdTagDetailsResponse,
            ListVodAdTagDetailsPagedResponse>
        listVodAdTagDetailsSettings;
    private final UnaryCallSettings.Builder<GetVodAdTagDetailRequest, VodAdTagDetail>
        getVodAdTagDetailSettings;
    private final PagedCallSettings.Builder<
            ListLiveAdTagDetailsRequest,
            ListLiveAdTagDetailsResponse,
            ListLiveAdTagDetailsPagedResponse>
        listLiveAdTagDetailsSettings;
    private final UnaryCallSettings.Builder<GetLiveAdTagDetailRequest, LiveAdTagDetail>
        getLiveAdTagDetailSettings;
    private final UnaryCallSettings.Builder<CreateSlateRequest, Operation> createSlateSettings;
    private final OperationCallSettings.Builder<CreateSlateRequest, Slate, OperationMetadata>
        createSlateOperationSettings;
    private final PagedCallSettings.Builder<
            ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings;
    private final UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings;
    private final UnaryCallSettings.Builder<UpdateSlateRequest, Operation> updateSlateSettings;
    private final OperationCallSettings.Builder<UpdateSlateRequest, Slate, OperationMetadata>
        updateSlateOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSlateRequest, Operation> deleteSlateSettings;
    private final OperationCallSettings.Builder<DeleteSlateRequest, Empty, OperationMetadata>
        deleteSlateOperationSettings;
    private final UnaryCallSettings.Builder<CreateLiveSessionRequest, LiveSession>
        createLiveSessionSettings;
    private final UnaryCallSettings.Builder<GetLiveSessionRequest, LiveSession>
        getLiveSessionSettings;
    private final UnaryCallSettings.Builder<CreateLiveConfigRequest, Operation>
        createLiveConfigSettings;
    private final OperationCallSettings.Builder<
            CreateLiveConfigRequest, LiveConfig, OperationMetadata>
        createLiveConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
        listLiveConfigsSettings;
    private final UnaryCallSettings.Builder<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings;
    private final UnaryCallSettings.Builder<DeleteLiveConfigRequest, Operation>
        deleteLiveConfigSettings;
    private final OperationCallSettings.Builder<DeleteLiveConfigRequest, Empty, OperationMetadata>
        deleteLiveConfigOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createCdnKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCdnKeyOperationSettings = OperationCallSettings.newBuilder();
      listCdnKeysSettings = PagedCallSettings.newBuilder(LIST_CDN_KEYS_PAGE_STR_FACT);
      getCdnKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCdnKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCdnKeyOperationSettings = OperationCallSettings.newBuilder();
      updateCdnKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCdnKeyOperationSettings = OperationCallSettings.newBuilder();
      createVodSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getVodSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVodStitchDetailsSettings =
          PagedCallSettings.newBuilder(LIST_VOD_STITCH_DETAILS_PAGE_STR_FACT);
      getVodStitchDetailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVodAdTagDetailsSettings =
          PagedCallSettings.newBuilder(LIST_VOD_AD_TAG_DETAILS_PAGE_STR_FACT);
      getVodAdTagDetailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLiveAdTagDetailsSettings =
          PagedCallSettings.newBuilder(LIST_LIVE_AD_TAG_DETAILS_PAGE_STR_FACT);
      getLiveAdTagDetailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSlateOperationSettings = OperationCallSettings.newBuilder();
      listSlatesSettings = PagedCallSettings.newBuilder(LIST_SLATES_PAGE_STR_FACT);
      getSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSlateOperationSettings = OperationCallSettings.newBuilder();
      deleteSlateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSlateOperationSettings = OperationCallSettings.newBuilder();
      createLiveSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getLiveSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLiveConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLiveConfigOperationSettings = OperationCallSettings.newBuilder();
      listLiveConfigsSettings = PagedCallSettings.newBuilder(LIST_LIVE_CONFIGS_PAGE_STR_FACT);
      getLiveConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLiveConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLiveConfigOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCdnKeySettings,
              listCdnKeysSettings,
              getCdnKeySettings,
              deleteCdnKeySettings,
              updateCdnKeySettings,
              createVodSessionSettings,
              getVodSessionSettings,
              listVodStitchDetailsSettings,
              getVodStitchDetailSettings,
              listVodAdTagDetailsSettings,
              getVodAdTagDetailSettings,
              listLiveAdTagDetailsSettings,
              getLiveAdTagDetailSettings,
              createSlateSettings,
              listSlatesSettings,
              getSlateSettings,
              updateSlateSettings,
              deleteSlateSettings,
              createLiveSessionSettings,
              getLiveSessionSettings,
              createLiveConfigSettings,
              listLiveConfigsSettings,
              getLiveConfigSettings,
              deleteLiveConfigSettings);
      initDefaults(this);
    }

    protected Builder(VideoStitcherServiceStubSettings settings) {
      super(settings);

      createCdnKeySettings = settings.createCdnKeySettings.toBuilder();
      createCdnKeyOperationSettings = settings.createCdnKeyOperationSettings.toBuilder();
      listCdnKeysSettings = settings.listCdnKeysSettings.toBuilder();
      getCdnKeySettings = settings.getCdnKeySettings.toBuilder();
      deleteCdnKeySettings = settings.deleteCdnKeySettings.toBuilder();
      deleteCdnKeyOperationSettings = settings.deleteCdnKeyOperationSettings.toBuilder();
      updateCdnKeySettings = settings.updateCdnKeySettings.toBuilder();
      updateCdnKeyOperationSettings = settings.updateCdnKeyOperationSettings.toBuilder();
      createVodSessionSettings = settings.createVodSessionSettings.toBuilder();
      getVodSessionSettings = settings.getVodSessionSettings.toBuilder();
      listVodStitchDetailsSettings = settings.listVodStitchDetailsSettings.toBuilder();
      getVodStitchDetailSettings = settings.getVodStitchDetailSettings.toBuilder();
      listVodAdTagDetailsSettings = settings.listVodAdTagDetailsSettings.toBuilder();
      getVodAdTagDetailSettings = settings.getVodAdTagDetailSettings.toBuilder();
      listLiveAdTagDetailsSettings = settings.listLiveAdTagDetailsSettings.toBuilder();
      getLiveAdTagDetailSettings = settings.getLiveAdTagDetailSettings.toBuilder();
      createSlateSettings = settings.createSlateSettings.toBuilder();
      createSlateOperationSettings = settings.createSlateOperationSettings.toBuilder();
      listSlatesSettings = settings.listSlatesSettings.toBuilder();
      getSlateSettings = settings.getSlateSettings.toBuilder();
      updateSlateSettings = settings.updateSlateSettings.toBuilder();
      updateSlateOperationSettings = settings.updateSlateOperationSettings.toBuilder();
      deleteSlateSettings = settings.deleteSlateSettings.toBuilder();
      deleteSlateOperationSettings = settings.deleteSlateOperationSettings.toBuilder();
      createLiveSessionSettings = settings.createLiveSessionSettings.toBuilder();
      getLiveSessionSettings = settings.getLiveSessionSettings.toBuilder();
      createLiveConfigSettings = settings.createLiveConfigSettings.toBuilder();
      createLiveConfigOperationSettings = settings.createLiveConfigOperationSettings.toBuilder();
      listLiveConfigsSettings = settings.listLiveConfigsSettings.toBuilder();
      getLiveConfigSettings = settings.getLiveConfigSettings.toBuilder();
      deleteLiveConfigSettings = settings.deleteLiveConfigSettings.toBuilder();
      deleteLiveConfigOperationSettings = settings.deleteLiveConfigOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCdnKeySettings,
              listCdnKeysSettings,
              getCdnKeySettings,
              deleteCdnKeySettings,
              updateCdnKeySettings,
              createVodSessionSettings,
              getVodSessionSettings,
              listVodStitchDetailsSettings,
              getVodStitchDetailSettings,
              listVodAdTagDetailsSettings,
              getVodAdTagDetailSettings,
              listLiveAdTagDetailsSettings,
              getLiveAdTagDetailSettings,
              createSlateSettings,
              listSlatesSettings,
              getSlateSettings,
              updateSlateSettings,
              deleteSlateSettings,
              createLiveSessionSettings,
              getLiveSessionSettings,
              createLiveConfigSettings,
              listLiveConfigsSettings,
              getLiveConfigSettings,
              deleteLiveConfigSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createCdnKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listCdnKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getCdnKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCdnKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateCdnKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createVodSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getVodSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listVodStitchDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getVodStitchDetailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listVodAdTagDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getVodAdTagDetailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLiveAdTagDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getLiveAdTagDetailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSlatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSlateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createLiveSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getLiveSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createLiveConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLiveConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getLiveConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteLiveConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createCdnKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCdnKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CdnKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteCdnKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCdnKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateCdnKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCdnKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CdnKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createSlateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateSlateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Slate.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .updateSlateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateSlateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Slate.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteSlateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteSlateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createLiveConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateLiveConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LiveConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .deleteLiveConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteLiveConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createCdnKey. */
    public UnaryCallSettings.Builder<CreateCdnKeyRequest, Operation> createCdnKeySettings() {
      return createCdnKeySettings;
    }

    /** Returns the builder for the settings used for calls to createCdnKey. */
    public OperationCallSettings.Builder<CreateCdnKeyRequest, CdnKey, OperationMetadata>
        createCdnKeyOperationSettings() {
      return createCdnKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCdnKeys. */
    public PagedCallSettings.Builder<
            ListCdnKeysRequest, ListCdnKeysResponse, ListCdnKeysPagedResponse>
        listCdnKeysSettings() {
      return listCdnKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getCdnKey. */
    public UnaryCallSettings.Builder<GetCdnKeyRequest, CdnKey> getCdnKeySettings() {
      return getCdnKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteCdnKey. */
    public UnaryCallSettings.Builder<DeleteCdnKeyRequest, Operation> deleteCdnKeySettings() {
      return deleteCdnKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteCdnKey. */
    public OperationCallSettings.Builder<DeleteCdnKeyRequest, Empty, OperationMetadata>
        deleteCdnKeyOperationSettings() {
      return deleteCdnKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCdnKey. */
    public UnaryCallSettings.Builder<UpdateCdnKeyRequest, Operation> updateCdnKeySettings() {
      return updateCdnKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateCdnKey. */
    public OperationCallSettings.Builder<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
        updateCdnKeyOperationSettings() {
      return updateCdnKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createVodSession. */
    public UnaryCallSettings.Builder<CreateVodSessionRequest, VodSession>
        createVodSessionSettings() {
      return createVodSessionSettings;
    }

    /** Returns the builder for the settings used for calls to getVodSession. */
    public UnaryCallSettings.Builder<GetVodSessionRequest, VodSession> getVodSessionSettings() {
      return getVodSessionSettings;
    }

    /** Returns the builder for the settings used for calls to listVodStitchDetails. */
    public PagedCallSettings.Builder<
            ListVodStitchDetailsRequest,
            ListVodStitchDetailsResponse,
            ListVodStitchDetailsPagedResponse>
        listVodStitchDetailsSettings() {
      return listVodStitchDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to getVodStitchDetail. */
    public UnaryCallSettings.Builder<GetVodStitchDetailRequest, VodStitchDetail>
        getVodStitchDetailSettings() {
      return getVodStitchDetailSettings;
    }

    /** Returns the builder for the settings used for calls to listVodAdTagDetails. */
    public PagedCallSettings.Builder<
            ListVodAdTagDetailsRequest,
            ListVodAdTagDetailsResponse,
            ListVodAdTagDetailsPagedResponse>
        listVodAdTagDetailsSettings() {
      return listVodAdTagDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to getVodAdTagDetail. */
    public UnaryCallSettings.Builder<GetVodAdTagDetailRequest, VodAdTagDetail>
        getVodAdTagDetailSettings() {
      return getVodAdTagDetailSettings;
    }

    /** Returns the builder for the settings used for calls to listLiveAdTagDetails. */
    public PagedCallSettings.Builder<
            ListLiveAdTagDetailsRequest,
            ListLiveAdTagDetailsResponse,
            ListLiveAdTagDetailsPagedResponse>
        listLiveAdTagDetailsSettings() {
      return listLiveAdTagDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to getLiveAdTagDetail. */
    public UnaryCallSettings.Builder<GetLiveAdTagDetailRequest, LiveAdTagDetail>
        getLiveAdTagDetailSettings() {
      return getLiveAdTagDetailSettings;
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public UnaryCallSettings.Builder<CreateSlateRequest, Operation> createSlateSettings() {
      return createSlateSettings;
    }

    /** Returns the builder for the settings used for calls to createSlate. */
    public OperationCallSettings.Builder<CreateSlateRequest, Slate, OperationMetadata>
        createSlateOperationSettings() {
      return createSlateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSlates. */
    public PagedCallSettings.Builder<ListSlatesRequest, ListSlatesResponse, ListSlatesPagedResponse>
        listSlatesSettings() {
      return listSlatesSettings;
    }

    /** Returns the builder for the settings used for calls to getSlate. */
    public UnaryCallSettings.Builder<GetSlateRequest, Slate> getSlateSettings() {
      return getSlateSettings;
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public UnaryCallSettings.Builder<UpdateSlateRequest, Operation> updateSlateSettings() {
      return updateSlateSettings;
    }

    /** Returns the builder for the settings used for calls to updateSlate. */
    public OperationCallSettings.Builder<UpdateSlateRequest, Slate, OperationMetadata>
        updateSlateOperationSettings() {
      return updateSlateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSlate. */
    public UnaryCallSettings.Builder<DeleteSlateRequest, Operation> deleteSlateSettings() {
      return deleteSlateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSlate. */
    public OperationCallSettings.Builder<DeleteSlateRequest, Empty, OperationMetadata>
        deleteSlateOperationSettings() {
      return deleteSlateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createLiveSession. */
    public UnaryCallSettings.Builder<CreateLiveSessionRequest, LiveSession>
        createLiveSessionSettings() {
      return createLiveSessionSettings;
    }

    /** Returns the builder for the settings used for calls to getLiveSession. */
    public UnaryCallSettings.Builder<GetLiveSessionRequest, LiveSession> getLiveSessionSettings() {
      return getLiveSessionSettings;
    }

    /** Returns the builder for the settings used for calls to createLiveConfig. */
    public UnaryCallSettings.Builder<CreateLiveConfigRequest, Operation>
        createLiveConfigSettings() {
      return createLiveConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createLiveConfig. */
    public OperationCallSettings.Builder<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
        createLiveConfigOperationSettings() {
      return createLiveConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLiveConfigs. */
    public PagedCallSettings.Builder<
            ListLiveConfigsRequest, ListLiveConfigsResponse, ListLiveConfigsPagedResponse>
        listLiveConfigsSettings() {
      return listLiveConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getLiveConfig. */
    public UnaryCallSettings.Builder<GetLiveConfigRequest, LiveConfig> getLiveConfigSettings() {
      return getLiveConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLiveConfig. */
    public UnaryCallSettings.Builder<DeleteLiveConfigRequest, Operation>
        deleteLiveConfigSettings() {
      return deleteLiveConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLiveConfig. */
    public OperationCallSettings.Builder<DeleteLiveConfigRequest, Empty, OperationMetadata>
        deleteLiveConfigOperationSettings() {
      return deleteLiveConfigOperationSettings;
    }

    @Override
    public VideoStitcherServiceStubSettings build() throws IOException {
      return new VideoStitcherServiceStubSettings(this);
    }
  }
}
