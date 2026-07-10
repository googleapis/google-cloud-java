/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACAttachmentsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACRealmsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.CreateSACRealmRequest;
import com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.DeleteSACRealmRequest;
import com.google.cloud.networksecurity.v1.GetSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.GetSACRealmRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse;
import com.google.cloud.networksecurity.v1.ListSACRealmsRequest;
import com.google.cloud.networksecurity.v1.ListSACRealmsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SACAttachment;
import com.google.cloud.networksecurity.v1.SACRealm;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SSERealmServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSACRealm:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SSERealmServiceStubSettings.Builder sSERealmServiceSettingsBuilder =
 *     SSERealmServiceStubSettings.newBuilder();
 * sSERealmServiceSettingsBuilder
 *     .getSACRealmSettings()
 *     .setRetrySettings(
 *         sSERealmServiceSettingsBuilder
 *             .getSACRealmSettings()
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
 * SSERealmServiceStubSettings sSERealmServiceSettings = sSERealmServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSACRealm:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SSERealmServiceStubSettings.Builder sSERealmServiceSettingsBuilder =
 *     SSERealmServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * sSERealmServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SSERealmServiceStubSettings extends StubSettings<SSERealmServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
      listSACRealmsSettings;
  private final UnaryCallSettings<GetSACRealmRequest, SACRealm> getSACRealmSettings;
  private final UnaryCallSettings<CreateSACRealmRequest, Operation> createSACRealmSettings;
  private final OperationCallSettings<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationSettings;
  private final UnaryCallSettings<DeleteSACRealmRequest, Operation> deleteSACRealmSettings;
  private final OperationCallSettings<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationSettings;
  private final PagedCallSettings<
          ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
      listSACAttachmentsSettings;
  private final UnaryCallSettings<GetSACAttachmentRequest, SACAttachment> getSACAttachmentSettings;
  private final UnaryCallSettings<CreateSACAttachmentRequest, Operation>
      createSACAttachmentSettings;
  private final OperationCallSettings<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationSettings;
  private final UnaryCallSettings<DeleteSACAttachmentRequest, Operation>
      deleteSACAttachmentSettings;
  private final OperationCallSettings<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm>
      LIST_S_A_C_REALMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSACRealmsRequest injectToken(ListSACRealmsRequest payload, String token) {
              return ListSACRealmsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSACRealmsRequest injectPageSize(ListSACRealmsRequest payload, int pageSize) {
              return ListSACRealmsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSACRealmsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSACRealmsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SACRealm> extractResources(ListSACRealmsResponse payload) {
              return payload.getSacRealmsList();
            }
          };

  private static final PagedListDescriptor<
          ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>
      LIST_S_A_C_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSACAttachmentsRequest injectToken(
                ListSACAttachmentsRequest payload, String token) {
              return ListSACAttachmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSACAttachmentsRequest injectPageSize(
                ListSACAttachmentsRequest payload, int pageSize) {
              return ListSACAttachmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSACAttachmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSACAttachmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SACAttachment> extractResources(ListSACAttachmentsResponse payload) {
              return payload.getSacAttachmentsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
      LIST_S_A_C_REALMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>() {
            @Override
            public ApiFuture<ListSACRealmsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSACRealmsRequest, ListSACRealmsResponse> callable,
                ListSACRealmsRequest request,
                ApiCallContext context,
                ApiFuture<ListSACRealmsResponse> futureResponse) {
              PageContext<ListSACRealmsRequest, ListSACRealmsResponse, SACRealm> pageContext =
                  PageContext.create(callable, LIST_S_A_C_REALMS_PAGE_STR_DESC, request, context);
              return ListSACRealmsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
      LIST_S_A_C_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSACAttachmentsRequest,
              ListSACAttachmentsResponse,
              ListSACAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<ListSACAttachmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsResponse> callable,
                ListSACAttachmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListSACAttachmentsResponse> futureResponse) {
              PageContext<ListSACAttachmentsRequest, ListSACAttachmentsResponse, SACAttachment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_S_A_C_ATTACHMENTS_PAGE_STR_DESC, request, context);
              return ListSACAttachmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listSACRealms. */
  public PagedCallSettings<ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
      listSACRealmsSettings() {
    return listSACRealmsSettings;
  }

  /** Returns the object with the settings used for calls to getSACRealm. */
  public UnaryCallSettings<GetSACRealmRequest, SACRealm> getSACRealmSettings() {
    return getSACRealmSettings;
  }

  /** Returns the object with the settings used for calls to createSACRealm. */
  public UnaryCallSettings<CreateSACRealmRequest, Operation> createSACRealmSettings() {
    return createSACRealmSettings;
  }

  /** Returns the object with the settings used for calls to createSACRealm. */
  public OperationCallSettings<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationSettings() {
    return createSACRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSACRealm. */
  public UnaryCallSettings<DeleteSACRealmRequest, Operation> deleteSACRealmSettings() {
    return deleteSACRealmSettings;
  }

  /** Returns the object with the settings used for calls to deleteSACRealm. */
  public OperationCallSettings<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationSettings() {
    return deleteSACRealmOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSACAttachments. */
  public PagedCallSettings<
          ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
      listSACAttachmentsSettings() {
    return listSACAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to getSACAttachment. */
  public UnaryCallSettings<GetSACAttachmentRequest, SACAttachment> getSACAttachmentSettings() {
    return getSACAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to createSACAttachment. */
  public UnaryCallSettings<CreateSACAttachmentRequest, Operation> createSACAttachmentSettings() {
    return createSACAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to createSACAttachment. */
  public OperationCallSettings<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationSettings() {
    return createSACAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSACAttachment. */
  public UnaryCallSettings<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentSettings() {
    return deleteSACAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteSACAttachment. */
  public OperationCallSettings<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationSettings() {
    return deleteSACAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
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

  public SSERealmServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSSERealmServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networksecurity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networksecurity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networksecurity.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SSERealmServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected SSERealmServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listSACRealmsSettings = settingsBuilder.listSACRealmsSettings().build();
    getSACRealmSettings = settingsBuilder.getSACRealmSettings().build();
    createSACRealmSettings = settingsBuilder.createSACRealmSettings().build();
    createSACRealmOperationSettings = settingsBuilder.createSACRealmOperationSettings().build();
    deleteSACRealmSettings = settingsBuilder.deleteSACRealmSettings().build();
    deleteSACRealmOperationSettings = settingsBuilder.deleteSACRealmOperationSettings().build();
    listSACAttachmentsSettings = settingsBuilder.listSACAttachmentsSettings().build();
    getSACAttachmentSettings = settingsBuilder.getSACAttachmentSettings().build();
    createSACAttachmentSettings = settingsBuilder.createSACAttachmentSettings().build();
    createSACAttachmentOperationSettings =
        settingsBuilder.createSACAttachmentOperationSettings().build();
    deleteSACAttachmentSettings = settingsBuilder.deleteSACAttachmentSettings().build();
    deleteSACAttachmentOperationSettings =
        settingsBuilder.deleteSACAttachmentOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-network-security")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SSERealmServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SSERealmServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
        listSACRealmsSettings;
    private final UnaryCallSettings.Builder<GetSACRealmRequest, SACRealm> getSACRealmSettings;
    private final UnaryCallSettings.Builder<CreateSACRealmRequest, Operation>
        createSACRealmSettings;
    private final OperationCallSettings.Builder<CreateSACRealmRequest, SACRealm, OperationMetadata>
        createSACRealmOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSACRealmRequest, Operation>
        deleteSACRealmSettings;
    private final OperationCallSettings.Builder<DeleteSACRealmRequest, Empty, OperationMetadata>
        deleteSACRealmOperationSettings;
    private final PagedCallSettings.Builder<
            ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
        listSACAttachmentsSettings;
    private final UnaryCallSettings.Builder<GetSACAttachmentRequest, SACAttachment>
        getSACAttachmentSettings;
    private final UnaryCallSettings.Builder<CreateSACAttachmentRequest, Operation>
        createSACAttachmentSettings;
    private final OperationCallSettings.Builder<
            CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
        createSACAttachmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSACAttachmentRequest, Operation>
        deleteSACAttachmentSettings;
    private final OperationCallSettings.Builder<
            DeleteSACAttachmentRequest, Empty, OperationMetadata>
        deleteSACAttachmentOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      listSACRealmsSettings = PagedCallSettings.newBuilder(LIST_S_A_C_REALMS_PAGE_STR_FACT);
      getSACRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSACRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSACRealmOperationSettings = OperationCallSettings.newBuilder();
      deleteSACRealmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSACRealmOperationSettings = OperationCallSettings.newBuilder();
      listSACAttachmentsSettings =
          PagedCallSettings.newBuilder(LIST_S_A_C_ATTACHMENTS_PAGE_STR_FACT);
      getSACAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSACAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSACAttachmentOperationSettings = OperationCallSettings.newBuilder();
      deleteSACAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSACAttachmentOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSACRealmsSettings,
              getSACRealmSettings,
              createSACRealmSettings,
              deleteSACRealmSettings,
              listSACAttachmentsSettings,
              getSACAttachmentSettings,
              createSACAttachmentSettings,
              deleteSACAttachmentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SSERealmServiceStubSettings settings) {
      super(settings);

      listSACRealmsSettings = settings.listSACRealmsSettings.toBuilder();
      getSACRealmSettings = settings.getSACRealmSettings.toBuilder();
      createSACRealmSettings = settings.createSACRealmSettings.toBuilder();
      createSACRealmOperationSettings = settings.createSACRealmOperationSettings.toBuilder();
      deleteSACRealmSettings = settings.deleteSACRealmSettings.toBuilder();
      deleteSACRealmOperationSettings = settings.deleteSACRealmOperationSettings.toBuilder();
      listSACAttachmentsSettings = settings.listSACAttachmentsSettings.toBuilder();
      getSACAttachmentSettings = settings.getSACAttachmentSettings.toBuilder();
      createSACAttachmentSettings = settings.createSACAttachmentSettings.toBuilder();
      createSACAttachmentOperationSettings =
          settings.createSACAttachmentOperationSettings.toBuilder();
      deleteSACAttachmentSettings = settings.deleteSACAttachmentSettings.toBuilder();
      deleteSACAttachmentOperationSettings =
          settings.deleteSACAttachmentOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSACRealmsSettings,
              getSACRealmSettings,
              createSACRealmSettings,
              deleteSACRealmSettings,
              listSACAttachmentsSettings,
              getSACAttachmentSettings,
              createSACAttachmentSettings,
              deleteSACAttachmentSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .listSACRealmsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSACRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSACRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSACRealmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSACAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSACAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSACAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSACAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSACRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSACRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SACRealm.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteSACRealmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSACRealmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createSACAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSACAttachmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SACAttachment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteSACAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSACAttachmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listSACRealms. */
    public PagedCallSettings.Builder<
            ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
        listSACRealmsSettings() {
      return listSACRealmsSettings;
    }

    /** Returns the builder for the settings used for calls to getSACRealm. */
    public UnaryCallSettings.Builder<GetSACRealmRequest, SACRealm> getSACRealmSettings() {
      return getSACRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createSACRealm. */
    public UnaryCallSettings.Builder<CreateSACRealmRequest, Operation> createSACRealmSettings() {
      return createSACRealmSettings;
    }

    /** Returns the builder for the settings used for calls to createSACRealm. */
    public OperationCallSettings.Builder<CreateSACRealmRequest, SACRealm, OperationMetadata>
        createSACRealmOperationSettings() {
      return createSACRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSACRealm. */
    public UnaryCallSettings.Builder<DeleteSACRealmRequest, Operation> deleteSACRealmSettings() {
      return deleteSACRealmSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSACRealm. */
    public OperationCallSettings.Builder<DeleteSACRealmRequest, Empty, OperationMetadata>
        deleteSACRealmOperationSettings() {
      return deleteSACRealmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSACAttachments. */
    public PagedCallSettings.Builder<
            ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
        listSACAttachmentsSettings() {
      return listSACAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getSACAttachment. */
    public UnaryCallSettings.Builder<GetSACAttachmentRequest, SACAttachment>
        getSACAttachmentSettings() {
      return getSACAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to createSACAttachment. */
    public UnaryCallSettings.Builder<CreateSACAttachmentRequest, Operation>
        createSACAttachmentSettings() {
      return createSACAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to createSACAttachment. */
    public OperationCallSettings.Builder<
            CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
        createSACAttachmentOperationSettings() {
      return createSACAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSACAttachment. */
    public UnaryCallSettings.Builder<DeleteSACAttachmentRequest, Operation>
        deleteSACAttachmentSettings() {
      return deleteSACAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSACAttachment. */
    public OperationCallSettings.Builder<DeleteSACAttachmentRequest, Empty, OperationMetadata>
        deleteSACAttachmentOperationSettings() {
      return deleteSACAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
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
    public SSERealmServiceStubSettings build() throws IOException {
      return new SSERealmServiceStubSettings(this);
    }
  }
}
