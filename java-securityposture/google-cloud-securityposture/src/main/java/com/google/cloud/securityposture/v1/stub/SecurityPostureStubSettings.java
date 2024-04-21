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

package com.google.cloud.securityposture.v1.stub;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.CreatePostureRequest;
import com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.DeletePostureRequest;
import com.google.cloud.securityposture.v1.ExtractPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureDeploymentRequest;
import com.google.cloud.securityposture.v1.GetPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureTemplateRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse;
import com.google.cloud.securityposture.v1.ListPostureRevisionsRequest;
import com.google.cloud.securityposture.v1.ListPostureRevisionsResponse;
import com.google.cloud.securityposture.v1.ListPostureTemplatesRequest;
import com.google.cloud.securityposture.v1.ListPostureTemplatesResponse;
import com.google.cloud.securityposture.v1.ListPosturesRequest;
import com.google.cloud.securityposture.v1.ListPosturesResponse;
import com.google.cloud.securityposture.v1.OperationMetadata;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.PostureDeployment;
import com.google.cloud.securityposture.v1.PostureTemplate;
import com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.UpdatePostureRequest;
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
 * Settings class to configure an instance of {@link SecurityPostureStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securityposture.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPosture to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityPostureStubSettings.Builder securityPostureSettingsBuilder =
 *     SecurityPostureStubSettings.newBuilder();
 * securityPostureSettingsBuilder
 *     .getPostureSettings()
 *     .setRetrySettings(
 *         securityPostureSettingsBuilder
 *             .getPostureSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityPostureStubSettings securityPostureSettings = securityPostureSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityPostureStubSettings extends StubSettings<SecurityPostureStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
      listPosturesSettings;
  private final PagedCallSettings<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          ListPostureRevisionsPagedResponse>
      listPostureRevisionsSettings;
  private final UnaryCallSettings<GetPostureRequest, Posture> getPostureSettings;
  private final UnaryCallSettings<CreatePostureRequest, Operation> createPostureSettings;
  private final OperationCallSettings<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationSettings;
  private final UnaryCallSettings<UpdatePostureRequest, Operation> updatePostureSettings;
  private final OperationCallSettings<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationSettings;
  private final UnaryCallSettings<DeletePostureRequest, Operation> deletePostureSettings;
  private final OperationCallSettings<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationSettings;
  private final UnaryCallSettings<ExtractPostureRequest, Operation> extractPostureSettings;
  private final OperationCallSettings<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationSettings;
  private final PagedCallSettings<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsSettings;
  private final UnaryCallSettings<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentSettings;
  private final UnaryCallSettings<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentSettings;
  private final OperationCallSettings<
          CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationSettings;
  private final UnaryCallSettings<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentSettings;
  private final OperationCallSettings<
          UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationSettings;
  private final UnaryCallSettings<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentSettings;
  private final OperationCallSettings<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationSettings;
  private final PagedCallSettings<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          ListPostureTemplatesPagedResponse>
      listPostureTemplatesSettings;
  private final UnaryCallSettings<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListPosturesRequest, ListPosturesResponse, Posture>
      LIST_POSTURES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPosturesRequest, ListPosturesResponse, Posture>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPosturesRequest injectToken(ListPosturesRequest payload, String token) {
              return ListPosturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPosturesRequest injectPageSize(ListPosturesRequest payload, int pageSize) {
              return ListPosturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPosturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPosturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Posture> extractResources(ListPosturesResponse payload) {
              return payload.getPosturesList() == null
                  ? ImmutableList.<Posture>of()
                  : payload.getPosturesList();
            }
          };

  private static final PagedListDescriptor<
          ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture>
      LIST_POSTURE_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPostureRevisionsRequest injectToken(
                ListPostureRevisionsRequest payload, String token) {
              return ListPostureRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPostureRevisionsRequest injectPageSize(
                ListPostureRevisionsRequest payload, int pageSize) {
              return ListPostureRevisionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPostureRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPostureRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Posture> extractResources(ListPostureRevisionsResponse payload) {
              return payload.getRevisionsList() == null
                  ? ImmutableList.<Posture>of()
                  : payload.getRevisionsList();
            }
          };

  private static final PagedListDescriptor<
          ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>
      LIST_POSTURE_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPostureDeploymentsRequest injectToken(
                ListPostureDeploymentsRequest payload, String token) {
              return ListPostureDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPostureDeploymentsRequest injectPageSize(
                ListPostureDeploymentsRequest payload, int pageSize) {
              return ListPostureDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPostureDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPostureDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PostureDeployment> extractResources(
                ListPostureDeploymentsResponse payload) {
              return payload.getPostureDeploymentsList() == null
                  ? ImmutableList.<PostureDeployment>of()
                  : payload.getPostureDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
      LIST_POSTURE_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPostureTemplatesRequest injectToken(
                ListPostureTemplatesRequest payload, String token) {
              return ListPostureTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPostureTemplatesRequest injectPageSize(
                ListPostureTemplatesRequest payload, int pageSize) {
              return ListPostureTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPostureTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPostureTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PostureTemplate> extractResources(
                ListPostureTemplatesResponse payload) {
              return payload.getPostureTemplatesList() == null
                  ? ImmutableList.<PostureTemplate>of()
                  : payload.getPostureTemplatesList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
      LIST_POSTURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>() {
            @Override
            public ApiFuture<ListPosturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPosturesRequest, ListPosturesResponse> callable,
                ListPosturesRequest request,
                ApiCallContext context,
                ApiFuture<ListPosturesResponse> futureResponse) {
              PageContext<ListPosturesRequest, ListPosturesResponse, Posture> pageContext =
                  PageContext.create(callable, LIST_POSTURES_PAGE_STR_DESC, request, context);
              return ListPosturesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          ListPostureRevisionsPagedResponse>
      LIST_POSTURE_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPostureRevisionsRequest,
              ListPostureRevisionsResponse,
              ListPostureRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListPostureRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse> callable,
                ListPostureRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPostureRevisionsResponse> futureResponse) {
              PageContext<ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture>
                  pageContext =
                      PageContext.create(
                          callable, LIST_POSTURE_REVISIONS_PAGE_STR_DESC, request, context);
              return ListPostureRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          ListPostureDeploymentsPagedResponse>
      LIST_POSTURE_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPostureDeploymentsRequest,
              ListPostureDeploymentsResponse,
              ListPostureDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListPostureDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
                    callable,
                ListPostureDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListPostureDeploymentsResponse> futureResponse) {
              PageContext<
                      ListPostureDeploymentsRequest,
                      ListPostureDeploymentsResponse,
                      PostureDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_POSTURE_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListPostureDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          ListPostureTemplatesPagedResponse>
      LIST_POSTURE_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPostureTemplatesRequest,
              ListPostureTemplatesResponse,
              ListPostureTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListPostureTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse> callable,
                ListPostureTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListPostureTemplatesResponse> futureResponse) {
              PageContext<
                      ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_POSTURE_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListPostureTemplatesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listPostures. */
  public PagedCallSettings<ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
      listPosturesSettings() {
    return listPosturesSettings;
  }

  /** Returns the object with the settings used for calls to listPostureRevisions. */
  public PagedCallSettings<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          ListPostureRevisionsPagedResponse>
      listPostureRevisionsSettings() {
    return listPostureRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to getPosture. */
  public UnaryCallSettings<GetPostureRequest, Posture> getPostureSettings() {
    return getPostureSettings;
  }

  /** Returns the object with the settings used for calls to createPosture. */
  public UnaryCallSettings<CreatePostureRequest, Operation> createPostureSettings() {
    return createPostureSettings;
  }

  /** Returns the object with the settings used for calls to createPosture. */
  public OperationCallSettings<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationSettings() {
    return createPostureOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePosture. */
  public UnaryCallSettings<UpdatePostureRequest, Operation> updatePostureSettings() {
    return updatePostureSettings;
  }

  /** Returns the object with the settings used for calls to updatePosture. */
  public OperationCallSettings<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationSettings() {
    return updatePostureOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePosture. */
  public UnaryCallSettings<DeletePostureRequest, Operation> deletePostureSettings() {
    return deletePostureSettings;
  }

  /** Returns the object with the settings used for calls to deletePosture. */
  public OperationCallSettings<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationSettings() {
    return deletePostureOperationSettings;
  }

  /** Returns the object with the settings used for calls to extractPosture. */
  public UnaryCallSettings<ExtractPostureRequest, Operation> extractPostureSettings() {
    return extractPostureSettings;
  }

  /** Returns the object with the settings used for calls to extractPosture. */
  public OperationCallSettings<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationSettings() {
    return extractPostureOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPostureDeployments. */
  public PagedCallSettings<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsSettings() {
    return listPostureDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getPostureDeployment. */
  public UnaryCallSettings<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentSettings() {
    return getPostureDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createPostureDeployment. */
  public UnaryCallSettings<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentSettings() {
    return createPostureDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createPostureDeployment. */
  public OperationCallSettings<CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationSettings() {
    return createPostureDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePostureDeployment. */
  public UnaryCallSettings<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentSettings() {
    return updatePostureDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updatePostureDeployment. */
  public OperationCallSettings<UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationSettings() {
    return updatePostureDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePostureDeployment. */
  public UnaryCallSettings<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentSettings() {
    return deletePostureDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deletePostureDeployment. */
  public OperationCallSettings<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationSettings() {
    return deletePostureDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPostureTemplates. */
  public PagedCallSettings<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          ListPostureTemplatesPagedResponse>
      listPostureTemplatesSettings() {
    return listPostureTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to getPostureTemplate. */
  public UnaryCallSettings<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateSettings() {
    return getPostureTemplateSettings;
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

  public SecurityPostureStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecurityPostureStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecurityPostureStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "securityposture";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "securityposture.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "securityposture.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecurityPostureStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecurityPostureStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityPostureStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SecurityPostureStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPosturesSettings = settingsBuilder.listPosturesSettings().build();
    listPostureRevisionsSettings = settingsBuilder.listPostureRevisionsSettings().build();
    getPostureSettings = settingsBuilder.getPostureSettings().build();
    createPostureSettings = settingsBuilder.createPostureSettings().build();
    createPostureOperationSettings = settingsBuilder.createPostureOperationSettings().build();
    updatePostureSettings = settingsBuilder.updatePostureSettings().build();
    updatePostureOperationSettings = settingsBuilder.updatePostureOperationSettings().build();
    deletePostureSettings = settingsBuilder.deletePostureSettings().build();
    deletePostureOperationSettings = settingsBuilder.deletePostureOperationSettings().build();
    extractPostureSettings = settingsBuilder.extractPostureSettings().build();
    extractPostureOperationSettings = settingsBuilder.extractPostureOperationSettings().build();
    listPostureDeploymentsSettings = settingsBuilder.listPostureDeploymentsSettings().build();
    getPostureDeploymentSettings = settingsBuilder.getPostureDeploymentSettings().build();
    createPostureDeploymentSettings = settingsBuilder.createPostureDeploymentSettings().build();
    createPostureDeploymentOperationSettings =
        settingsBuilder.createPostureDeploymentOperationSettings().build();
    updatePostureDeploymentSettings = settingsBuilder.updatePostureDeploymentSettings().build();
    updatePostureDeploymentOperationSettings =
        settingsBuilder.updatePostureDeploymentOperationSettings().build();
    deletePostureDeploymentSettings = settingsBuilder.deletePostureDeploymentSettings().build();
    deletePostureDeploymentOperationSettings =
        settingsBuilder.deletePostureDeploymentOperationSettings().build();
    listPostureTemplatesSettings = settingsBuilder.listPostureTemplatesSettings().build();
    getPostureTemplateSettings = settingsBuilder.getPostureTemplateSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for SecurityPostureStubSettings. */
  public static class Builder extends StubSettings.Builder<SecurityPostureStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
        listPosturesSettings;
    private final PagedCallSettings.Builder<
            ListPostureRevisionsRequest,
            ListPostureRevisionsResponse,
            ListPostureRevisionsPagedResponse>
        listPostureRevisionsSettings;
    private final UnaryCallSettings.Builder<GetPostureRequest, Posture> getPostureSettings;
    private final UnaryCallSettings.Builder<CreatePostureRequest, Operation> createPostureSettings;
    private final OperationCallSettings.Builder<CreatePostureRequest, Posture, OperationMetadata>
        createPostureOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePostureRequest, Operation> updatePostureSettings;
    private final OperationCallSettings.Builder<UpdatePostureRequest, Posture, OperationMetadata>
        updatePostureOperationSettings;
    private final UnaryCallSettings.Builder<DeletePostureRequest, Operation> deletePostureSettings;
    private final OperationCallSettings.Builder<DeletePostureRequest, Empty, OperationMetadata>
        deletePostureOperationSettings;
    private final UnaryCallSettings.Builder<ExtractPostureRequest, Operation>
        extractPostureSettings;
    private final OperationCallSettings.Builder<ExtractPostureRequest, Posture, OperationMetadata>
        extractPostureOperationSettings;
    private final PagedCallSettings.Builder<
            ListPostureDeploymentsRequest,
            ListPostureDeploymentsResponse,
            ListPostureDeploymentsPagedResponse>
        listPostureDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetPostureDeploymentRequest, PostureDeployment>
        getPostureDeploymentSettings;
    private final UnaryCallSettings.Builder<CreatePostureDeploymentRequest, Operation>
        createPostureDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        createPostureDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePostureDeploymentRequest, Operation>
        updatePostureDeploymentSettings;
    private final OperationCallSettings.Builder<
            UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        updatePostureDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeletePostureDeploymentRequest, Operation>
        deletePostureDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeletePostureDeploymentRequest, Empty, OperationMetadata>
        deletePostureDeploymentOperationSettings;
    private final PagedCallSettings.Builder<
            ListPostureTemplatesRequest,
            ListPostureTemplatesResponse,
            ListPostureTemplatesPagedResponse>
        listPostureTemplatesSettings;
    private final UnaryCallSettings.Builder<GetPostureTemplateRequest, PostureTemplate>
        getPostureTemplateSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPosturesSettings = PagedCallSettings.newBuilder(LIST_POSTURES_PAGE_STR_FACT);
      listPostureRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_POSTURE_REVISIONS_PAGE_STR_FACT);
      getPostureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPostureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPostureOperationSettings = OperationCallSettings.newBuilder();
      updatePostureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePostureOperationSettings = OperationCallSettings.newBuilder();
      deletePostureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePostureOperationSettings = OperationCallSettings.newBuilder();
      extractPostureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      extractPostureOperationSettings = OperationCallSettings.newBuilder();
      listPostureDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_POSTURE_DEPLOYMENTS_PAGE_STR_FACT);
      getPostureDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPostureDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPostureDeploymentOperationSettings = OperationCallSettings.newBuilder();
      updatePostureDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePostureDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deletePostureDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePostureDeploymentOperationSettings = OperationCallSettings.newBuilder();
      listPostureTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_POSTURE_TEMPLATES_PAGE_STR_FACT);
      getPostureTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPosturesSettings,
              listPostureRevisionsSettings,
              getPostureSettings,
              createPostureSettings,
              updatePostureSettings,
              deletePostureSettings,
              extractPostureSettings,
              listPostureDeploymentsSettings,
              getPostureDeploymentSettings,
              createPostureDeploymentSettings,
              updatePostureDeploymentSettings,
              deletePostureDeploymentSettings,
              listPostureTemplatesSettings,
              getPostureTemplateSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(SecurityPostureStubSettings settings) {
      super(settings);

      listPosturesSettings = settings.listPosturesSettings.toBuilder();
      listPostureRevisionsSettings = settings.listPostureRevisionsSettings.toBuilder();
      getPostureSettings = settings.getPostureSettings.toBuilder();
      createPostureSettings = settings.createPostureSettings.toBuilder();
      createPostureOperationSettings = settings.createPostureOperationSettings.toBuilder();
      updatePostureSettings = settings.updatePostureSettings.toBuilder();
      updatePostureOperationSettings = settings.updatePostureOperationSettings.toBuilder();
      deletePostureSettings = settings.deletePostureSettings.toBuilder();
      deletePostureOperationSettings = settings.deletePostureOperationSettings.toBuilder();
      extractPostureSettings = settings.extractPostureSettings.toBuilder();
      extractPostureOperationSettings = settings.extractPostureOperationSettings.toBuilder();
      listPostureDeploymentsSettings = settings.listPostureDeploymentsSettings.toBuilder();
      getPostureDeploymentSettings = settings.getPostureDeploymentSettings.toBuilder();
      createPostureDeploymentSettings = settings.createPostureDeploymentSettings.toBuilder();
      createPostureDeploymentOperationSettings =
          settings.createPostureDeploymentOperationSettings.toBuilder();
      updatePostureDeploymentSettings = settings.updatePostureDeploymentSettings.toBuilder();
      updatePostureDeploymentOperationSettings =
          settings.updatePostureDeploymentOperationSettings.toBuilder();
      deletePostureDeploymentSettings = settings.deletePostureDeploymentSettings.toBuilder();
      deletePostureDeploymentOperationSettings =
          settings.deletePostureDeploymentOperationSettings.toBuilder();
      listPostureTemplatesSettings = settings.listPostureTemplatesSettings.toBuilder();
      getPostureTemplateSettings = settings.getPostureTemplateSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPosturesSettings,
              listPostureRevisionsSettings,
              getPostureSettings,
              createPostureSettings,
              updatePostureSettings,
              deletePostureSettings,
              extractPostureSettings,
              listPostureDeploymentsSettings,
              getPostureDeploymentSettings,
              createPostureDeploymentSettings,
              updatePostureDeploymentSettings,
              deletePostureDeploymentSettings,
              listPostureTemplatesSettings,
              getPostureTemplateSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listPosturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPostureRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPostureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPostureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePostureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePostureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .extractPostureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPostureDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPostureDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPostureDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePostureDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePostureDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPostureTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPostureTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPostureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePostureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Posture.class))
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
          .updatePostureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePostureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Posture.class))
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
          .deletePostureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePostureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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
          .extractPostureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExtractPostureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Posture.class))
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
          .createPostureDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePostureDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PostureDeployment.class))
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
          .updatePostureDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePostureDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PostureDeployment.class))
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
          .deletePostureDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePostureDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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

    /** Returns the builder for the settings used for calls to listPostures. */
    public PagedCallSettings.Builder<
            ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
        listPosturesSettings() {
      return listPosturesSettings;
    }

    /** Returns the builder for the settings used for calls to listPostureRevisions. */
    public PagedCallSettings.Builder<
            ListPostureRevisionsRequest,
            ListPostureRevisionsResponse,
            ListPostureRevisionsPagedResponse>
        listPostureRevisionsSettings() {
      return listPostureRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to getPosture. */
    public UnaryCallSettings.Builder<GetPostureRequest, Posture> getPostureSettings() {
      return getPostureSettings;
    }

    /** Returns the builder for the settings used for calls to createPosture. */
    public UnaryCallSettings.Builder<CreatePostureRequest, Operation> createPostureSettings() {
      return createPostureSettings;
    }

    /** Returns the builder for the settings used for calls to createPosture. */
    public OperationCallSettings.Builder<CreatePostureRequest, Posture, OperationMetadata>
        createPostureOperationSettings() {
      return createPostureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePosture. */
    public UnaryCallSettings.Builder<UpdatePostureRequest, Operation> updatePostureSettings() {
      return updatePostureSettings;
    }

    /** Returns the builder for the settings used for calls to updatePosture. */
    public OperationCallSettings.Builder<UpdatePostureRequest, Posture, OperationMetadata>
        updatePostureOperationSettings() {
      return updatePostureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePosture. */
    public UnaryCallSettings.Builder<DeletePostureRequest, Operation> deletePostureSettings() {
      return deletePostureSettings;
    }

    /** Returns the builder for the settings used for calls to deletePosture. */
    public OperationCallSettings.Builder<DeletePostureRequest, Empty, OperationMetadata>
        deletePostureOperationSettings() {
      return deletePostureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to extractPosture. */
    public UnaryCallSettings.Builder<ExtractPostureRequest, Operation> extractPostureSettings() {
      return extractPostureSettings;
    }

    /** Returns the builder for the settings used for calls to extractPosture. */
    public OperationCallSettings.Builder<ExtractPostureRequest, Posture, OperationMetadata>
        extractPostureOperationSettings() {
      return extractPostureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPostureDeployments. */
    public PagedCallSettings.Builder<
            ListPostureDeploymentsRequest,
            ListPostureDeploymentsResponse,
            ListPostureDeploymentsPagedResponse>
        listPostureDeploymentsSettings() {
      return listPostureDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getPostureDeployment. */
    public UnaryCallSettings.Builder<GetPostureDeploymentRequest, PostureDeployment>
        getPostureDeploymentSettings() {
      return getPostureDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createPostureDeployment. */
    public UnaryCallSettings.Builder<CreatePostureDeploymentRequest, Operation>
        createPostureDeploymentSettings() {
      return createPostureDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createPostureDeployment. */
    public OperationCallSettings.Builder<
            CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        createPostureDeploymentOperationSettings() {
      return createPostureDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePostureDeployment. */
    public UnaryCallSettings.Builder<UpdatePostureDeploymentRequest, Operation>
        updatePostureDeploymentSettings() {
      return updatePostureDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updatePostureDeployment. */
    public OperationCallSettings.Builder<
            UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        updatePostureDeploymentOperationSettings() {
      return updatePostureDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePostureDeployment. */
    public UnaryCallSettings.Builder<DeletePostureDeploymentRequest, Operation>
        deletePostureDeploymentSettings() {
      return deletePostureDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deletePostureDeployment. */
    public OperationCallSettings.Builder<DeletePostureDeploymentRequest, Empty, OperationMetadata>
        deletePostureDeploymentOperationSettings() {
      return deletePostureDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPostureTemplates. */
    public PagedCallSettings.Builder<
            ListPostureTemplatesRequest,
            ListPostureTemplatesResponse,
            ListPostureTemplatesPagedResponse>
        listPostureTemplatesSettings() {
      return listPostureTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to getPostureTemplate. */
    public UnaryCallSettings.Builder<GetPostureTemplateRequest, PostureTemplate>
        getPostureTemplateSettings() {
      return getPostureTemplateSettings;
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

    @Override
    public SecurityPostureStubSettings build() throws IOException {
      return new SecurityPostureStubSettings(this);
    }
  }
}
