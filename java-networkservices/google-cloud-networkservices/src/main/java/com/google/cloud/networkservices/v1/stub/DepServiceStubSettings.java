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

package com.google.cloud.networkservices.v1.stub;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.LbRouteExtension;
import com.google.cloud.networkservices.v1.LbTrafficExtension;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DepServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkservices.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLbTrafficExtension to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DepServiceStubSettings.Builder depServiceSettingsBuilder = DepServiceStubSettings.newBuilder();
 * depServiceSettingsBuilder
 *     .getLbTrafficExtensionSettings()
 *     .setRetrySettings(
 *         depServiceSettingsBuilder
 *             .getLbTrafficExtensionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DepServiceStubSettings depServiceSettings = depServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DepServiceStubSettings extends StubSettings<DepServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsSettings;
  private final UnaryCallSettings<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionSettings;
  private final UnaryCallSettings<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionSettings;
  private final OperationCallSettings<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationSettings;
  private final UnaryCallSettings<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionSettings;
  private final OperationCallSettings<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationSettings;
  private final UnaryCallSettings<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionSettings;
  private final OperationCallSettings<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationSettings;
  private final PagedCallSettings<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsSettings;
  private final UnaryCallSettings<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionSettings;
  private final UnaryCallSettings<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionSettings;
  private final OperationCallSettings<
          CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationSettings;
  private final UnaryCallSettings<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionSettings;
  private final OperationCallSettings<
          UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationSettings;
  private final UnaryCallSettings<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionSettings;
  private final OperationCallSettings<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse, LbTrafficExtension>
      LIST_LB_TRAFFIC_EXTENSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLbTrafficExtensionsRequest,
              ListLbTrafficExtensionsResponse,
              LbTrafficExtension>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLbTrafficExtensionsRequest injectToken(
                ListLbTrafficExtensionsRequest payload, String token) {
              return ListLbTrafficExtensionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLbTrafficExtensionsRequest injectPageSize(
                ListLbTrafficExtensionsRequest payload, int pageSize) {
              return ListLbTrafficExtensionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListLbTrafficExtensionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLbTrafficExtensionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LbTrafficExtension> extractResources(
                ListLbTrafficExtensionsResponse payload) {
              return payload.getLbTrafficExtensionsList() == null
                  ? ImmutableList.<LbTrafficExtension>of()
                  : payload.getLbTrafficExtensionsList();
            }
          };

  private static final PagedListDescriptor<
          ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
      LIST_LB_ROUTE_EXTENSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLbRouteExtensionsRequest injectToken(
                ListLbRouteExtensionsRequest payload, String token) {
              return ListLbRouteExtensionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLbRouteExtensionsRequest injectPageSize(
                ListLbRouteExtensionsRequest payload, int pageSize) {
              return ListLbRouteExtensionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLbRouteExtensionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLbRouteExtensionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LbRouteExtension> extractResources(
                ListLbRouteExtensionsResponse payload) {
              return payload.getLbRouteExtensionsList() == null
                  ? ImmutableList.<LbRouteExtension>of()
                  : payload.getLbRouteExtensionsList();
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
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          ListLbTrafficExtensionsPagedResponse>
      LIST_LB_TRAFFIC_EXTENSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLbTrafficExtensionsRequest,
              ListLbTrafficExtensionsResponse,
              ListLbTrafficExtensionsPagedResponse>() {
            @Override
            public ApiFuture<ListLbTrafficExtensionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
                    callable,
                ListLbTrafficExtensionsRequest request,
                ApiCallContext context,
                ApiFuture<ListLbTrafficExtensionsResponse> futureResponse) {
              PageContext<
                      ListLbTrafficExtensionsRequest,
                      ListLbTrafficExtensionsResponse,
                      LbTrafficExtension>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LB_TRAFFIC_EXTENSIONS_PAGE_STR_DESC, request, context);
              return ListLbTrafficExtensionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          ListLbRouteExtensionsPagedResponse>
      LIST_LB_ROUTE_EXTENSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLbRouteExtensionsRequest,
              ListLbRouteExtensionsResponse,
              ListLbRouteExtensionsPagedResponse>() {
            @Override
            public ApiFuture<ListLbRouteExtensionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse> callable,
                ListLbRouteExtensionsRequest request,
                ApiCallContext context,
                ApiFuture<ListLbRouteExtensionsResponse> futureResponse) {
              PageContext<
                      ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse, LbRouteExtension>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LB_ROUTE_EXTENSIONS_PAGE_STR_DESC, request, context);
              return ListLbRouteExtensionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listLbTrafficExtensions. */
  public PagedCallSettings<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsSettings() {
    return listLbTrafficExtensionsSettings;
  }

  /** Returns the object with the settings used for calls to getLbTrafficExtension. */
  public UnaryCallSettings<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionSettings() {
    return getLbTrafficExtensionSettings;
  }

  /** Returns the object with the settings used for calls to createLbTrafficExtension. */
  public UnaryCallSettings<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionSettings() {
    return createLbTrafficExtensionSettings;
  }

  /** Returns the object with the settings used for calls to createLbTrafficExtension. */
  public OperationCallSettings<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationSettings() {
    return createLbTrafficExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateLbTrafficExtension. */
  public UnaryCallSettings<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionSettings() {
    return updateLbTrafficExtensionSettings;
  }

  /** Returns the object with the settings used for calls to updateLbTrafficExtension. */
  public OperationCallSettings<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationSettings() {
    return updateLbTrafficExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLbTrafficExtension. */
  public UnaryCallSettings<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionSettings() {
    return deleteLbTrafficExtensionSettings;
  }

  /** Returns the object with the settings used for calls to deleteLbTrafficExtension. */
  public OperationCallSettings<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationSettings() {
    return deleteLbTrafficExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLbRouteExtensions. */
  public PagedCallSettings<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsSettings() {
    return listLbRouteExtensionsSettings;
  }

  /** Returns the object with the settings used for calls to getLbRouteExtension. */
  public UnaryCallSettings<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionSettings() {
    return getLbRouteExtensionSettings;
  }

  /** Returns the object with the settings used for calls to createLbRouteExtension. */
  public UnaryCallSettings<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionSettings() {
    return createLbRouteExtensionSettings;
  }

  /** Returns the object with the settings used for calls to createLbRouteExtension. */
  public OperationCallSettings<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationSettings() {
    return createLbRouteExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateLbRouteExtension. */
  public UnaryCallSettings<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionSettings() {
    return updateLbRouteExtensionSettings;
  }

  /** Returns the object with the settings used for calls to updateLbRouteExtension. */
  public OperationCallSettings<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationSettings() {
    return updateLbRouteExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLbRouteExtension. */
  public UnaryCallSettings<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionSettings() {
    return deleteLbRouteExtensionSettings;
  }

  /** Returns the object with the settings used for calls to deleteLbRouteExtension. */
  public OperationCallSettings<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationSettings() {
    return deleteLbRouteExtensionOperationSettings;
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

  public DepServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDepServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDepServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkservices";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "networkservices.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkservices.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DepServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DepServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DepServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DepServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listLbTrafficExtensionsSettings = settingsBuilder.listLbTrafficExtensionsSettings().build();
    getLbTrafficExtensionSettings = settingsBuilder.getLbTrafficExtensionSettings().build();
    createLbTrafficExtensionSettings = settingsBuilder.createLbTrafficExtensionSettings().build();
    createLbTrafficExtensionOperationSettings =
        settingsBuilder.createLbTrafficExtensionOperationSettings().build();
    updateLbTrafficExtensionSettings = settingsBuilder.updateLbTrafficExtensionSettings().build();
    updateLbTrafficExtensionOperationSettings =
        settingsBuilder.updateLbTrafficExtensionOperationSettings().build();
    deleteLbTrafficExtensionSettings = settingsBuilder.deleteLbTrafficExtensionSettings().build();
    deleteLbTrafficExtensionOperationSettings =
        settingsBuilder.deleteLbTrafficExtensionOperationSettings().build();
    listLbRouteExtensionsSettings = settingsBuilder.listLbRouteExtensionsSettings().build();
    getLbRouteExtensionSettings = settingsBuilder.getLbRouteExtensionSettings().build();
    createLbRouteExtensionSettings = settingsBuilder.createLbRouteExtensionSettings().build();
    createLbRouteExtensionOperationSettings =
        settingsBuilder.createLbRouteExtensionOperationSettings().build();
    updateLbRouteExtensionSettings = settingsBuilder.updateLbRouteExtensionSettings().build();
    updateLbRouteExtensionOperationSettings =
        settingsBuilder.updateLbRouteExtensionOperationSettings().build();
    deleteLbRouteExtensionSettings = settingsBuilder.deleteLbRouteExtensionSettings().build();
    deleteLbRouteExtensionOperationSettings =
        settingsBuilder.deleteLbRouteExtensionOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DepServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DepServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListLbTrafficExtensionsRequest,
            ListLbTrafficExtensionsResponse,
            ListLbTrafficExtensionsPagedResponse>
        listLbTrafficExtensionsSettings;
    private final UnaryCallSettings.Builder<GetLbTrafficExtensionRequest, LbTrafficExtension>
        getLbTrafficExtensionSettings;
    private final UnaryCallSettings.Builder<CreateLbTrafficExtensionRequest, Operation>
        createLbTrafficExtensionSettings;
    private final OperationCallSettings.Builder<
            CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        createLbTrafficExtensionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateLbTrafficExtensionRequest, Operation>
        updateLbTrafficExtensionSettings;
    private final OperationCallSettings.Builder<
            UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        updateLbTrafficExtensionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLbTrafficExtensionRequest, Operation>
        deleteLbTrafficExtensionSettings;
    private final OperationCallSettings.Builder<
            DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
        deleteLbTrafficExtensionOperationSettings;
    private final PagedCallSettings.Builder<
            ListLbRouteExtensionsRequest,
            ListLbRouteExtensionsResponse,
            ListLbRouteExtensionsPagedResponse>
        listLbRouteExtensionsSettings;
    private final UnaryCallSettings.Builder<GetLbRouteExtensionRequest, LbRouteExtension>
        getLbRouteExtensionSettings;
    private final UnaryCallSettings.Builder<CreateLbRouteExtensionRequest, Operation>
        createLbRouteExtensionSettings;
    private final OperationCallSettings.Builder<
            CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        createLbRouteExtensionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateLbRouteExtensionRequest, Operation>
        updateLbRouteExtensionSettings;
    private final OperationCallSettings.Builder<
            UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        updateLbRouteExtensionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLbRouteExtensionRequest, Operation>
        deleteLbRouteExtensionSettings;
    private final OperationCallSettings.Builder<
            DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
        deleteLbRouteExtensionOperationSettings;
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
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listLbTrafficExtensionsSettings =
          PagedCallSettings.newBuilder(LIST_LB_TRAFFIC_EXTENSIONS_PAGE_STR_FACT);
      getLbTrafficExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLbTrafficExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLbTrafficExtensionOperationSettings = OperationCallSettings.newBuilder();
      updateLbTrafficExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLbTrafficExtensionOperationSettings = OperationCallSettings.newBuilder();
      deleteLbTrafficExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLbTrafficExtensionOperationSettings = OperationCallSettings.newBuilder();
      listLbRouteExtensionsSettings =
          PagedCallSettings.newBuilder(LIST_LB_ROUTE_EXTENSIONS_PAGE_STR_FACT);
      getLbRouteExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLbRouteExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLbRouteExtensionOperationSettings = OperationCallSettings.newBuilder();
      updateLbRouteExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLbRouteExtensionOperationSettings = OperationCallSettings.newBuilder();
      deleteLbRouteExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLbRouteExtensionOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLbTrafficExtensionsSettings,
              getLbTrafficExtensionSettings,
              createLbTrafficExtensionSettings,
              updateLbTrafficExtensionSettings,
              deleteLbTrafficExtensionSettings,
              listLbRouteExtensionsSettings,
              getLbRouteExtensionSettings,
              createLbRouteExtensionSettings,
              updateLbRouteExtensionSettings,
              deleteLbRouteExtensionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DepServiceStubSettings settings) {
      super(settings);

      listLbTrafficExtensionsSettings = settings.listLbTrafficExtensionsSettings.toBuilder();
      getLbTrafficExtensionSettings = settings.getLbTrafficExtensionSettings.toBuilder();
      createLbTrafficExtensionSettings = settings.createLbTrafficExtensionSettings.toBuilder();
      createLbTrafficExtensionOperationSettings =
          settings.createLbTrafficExtensionOperationSettings.toBuilder();
      updateLbTrafficExtensionSettings = settings.updateLbTrafficExtensionSettings.toBuilder();
      updateLbTrafficExtensionOperationSettings =
          settings.updateLbTrafficExtensionOperationSettings.toBuilder();
      deleteLbTrafficExtensionSettings = settings.deleteLbTrafficExtensionSettings.toBuilder();
      deleteLbTrafficExtensionOperationSettings =
          settings.deleteLbTrafficExtensionOperationSettings.toBuilder();
      listLbRouteExtensionsSettings = settings.listLbRouteExtensionsSettings.toBuilder();
      getLbRouteExtensionSettings = settings.getLbRouteExtensionSettings.toBuilder();
      createLbRouteExtensionSettings = settings.createLbRouteExtensionSettings.toBuilder();
      createLbRouteExtensionOperationSettings =
          settings.createLbRouteExtensionOperationSettings.toBuilder();
      updateLbRouteExtensionSettings = settings.updateLbRouteExtensionSettings.toBuilder();
      updateLbRouteExtensionOperationSettings =
          settings.updateLbRouteExtensionOperationSettings.toBuilder();
      deleteLbRouteExtensionSettings = settings.deleteLbRouteExtensionSettings.toBuilder();
      deleteLbRouteExtensionOperationSettings =
          settings.deleteLbRouteExtensionOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLbTrafficExtensionsSettings,
              getLbTrafficExtensionSettings,
              createLbTrafficExtensionSettings,
              updateLbTrafficExtensionSettings,
              deleteLbTrafficExtensionSettings,
              listLbRouteExtensionsSettings,
              getLbRouteExtensionSettings,
              createLbRouteExtensionSettings,
              updateLbRouteExtensionSettings,
              deleteLbRouteExtensionSettings,
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
          .listLbTrafficExtensionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLbTrafficExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createLbTrafficExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateLbTrafficExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteLbTrafficExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLbRouteExtensionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLbRouteExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createLbRouteExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateLbRouteExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteLbRouteExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

      builder
          .createLbTrafficExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateLbTrafficExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LbTrafficExtension.class))
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
          .updateLbTrafficExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateLbTrafficExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LbTrafficExtension.class))
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
          .deleteLbTrafficExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteLbTrafficExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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
          .createLbRouteExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateLbRouteExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LbRouteExtension.class))
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
          .updateLbRouteExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateLbRouteExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LbRouteExtension.class))
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
          .deleteLbRouteExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteLbRouteExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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

    /** Returns the builder for the settings used for calls to listLbTrafficExtensions. */
    public PagedCallSettings.Builder<
            ListLbTrafficExtensionsRequest,
            ListLbTrafficExtensionsResponse,
            ListLbTrafficExtensionsPagedResponse>
        listLbTrafficExtensionsSettings() {
      return listLbTrafficExtensionsSettings;
    }

    /** Returns the builder for the settings used for calls to getLbTrafficExtension. */
    public UnaryCallSettings.Builder<GetLbTrafficExtensionRequest, LbTrafficExtension>
        getLbTrafficExtensionSettings() {
      return getLbTrafficExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to createLbTrafficExtension. */
    public UnaryCallSettings.Builder<CreateLbTrafficExtensionRequest, Operation>
        createLbTrafficExtensionSettings() {
      return createLbTrafficExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to createLbTrafficExtension. */
    public OperationCallSettings.Builder<
            CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        createLbTrafficExtensionOperationSettings() {
      return createLbTrafficExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateLbTrafficExtension. */
    public UnaryCallSettings.Builder<UpdateLbTrafficExtensionRequest, Operation>
        updateLbTrafficExtensionSettings() {
      return updateLbTrafficExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to updateLbTrafficExtension. */
    public OperationCallSettings.Builder<
            UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        updateLbTrafficExtensionOperationSettings() {
      return updateLbTrafficExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLbTrafficExtension. */
    public UnaryCallSettings.Builder<DeleteLbTrafficExtensionRequest, Operation>
        deleteLbTrafficExtensionSettings() {
      return deleteLbTrafficExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLbTrafficExtension. */
    public OperationCallSettings.Builder<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
        deleteLbTrafficExtensionOperationSettings() {
      return deleteLbTrafficExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLbRouteExtensions. */
    public PagedCallSettings.Builder<
            ListLbRouteExtensionsRequest,
            ListLbRouteExtensionsResponse,
            ListLbRouteExtensionsPagedResponse>
        listLbRouteExtensionsSettings() {
      return listLbRouteExtensionsSettings;
    }

    /** Returns the builder for the settings used for calls to getLbRouteExtension. */
    public UnaryCallSettings.Builder<GetLbRouteExtensionRequest, LbRouteExtension>
        getLbRouteExtensionSettings() {
      return getLbRouteExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to createLbRouteExtension. */
    public UnaryCallSettings.Builder<CreateLbRouteExtensionRequest, Operation>
        createLbRouteExtensionSettings() {
      return createLbRouteExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to createLbRouteExtension. */
    public OperationCallSettings.Builder<
            CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        createLbRouteExtensionOperationSettings() {
      return createLbRouteExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateLbRouteExtension. */
    public UnaryCallSettings.Builder<UpdateLbRouteExtensionRequest, Operation>
        updateLbRouteExtensionSettings() {
      return updateLbRouteExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to updateLbRouteExtension. */
    public OperationCallSettings.Builder<
            UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        updateLbRouteExtensionOperationSettings() {
      return updateLbRouteExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLbRouteExtension. */
    public UnaryCallSettings.Builder<DeleteLbRouteExtensionRequest, Operation>
        deleteLbRouteExtensionSettings() {
      return deleteLbRouteExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLbRouteExtension. */
    public OperationCallSettings.Builder<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
        deleteLbRouteExtensionOperationSettings() {
      return deleteLbRouteExtensionOperationSettings;
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
    public DepServiceStubSettings build() throws IOException {
      return new DepServiceStubSettings(this);
    }
  }
}
