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

import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.FirewallEndpoint;
import com.google.cloud.networksecurity.v1.FirewallEndpointAssociation;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest;
import com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest;
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
 * Settings class to configure an instance of {@link FirewallActivationStub}.
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
 * of getFirewallEndpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallActivationStubSettings.Builder firewallActivationSettingsBuilder =
 *     FirewallActivationStubSettings.newBuilder();
 * firewallActivationSettingsBuilder
 *     .getFirewallEndpointSettings()
 *     .setRetrySettings(
 *         firewallActivationSettingsBuilder
 *             .getFirewallEndpointSettings()
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
 * FirewallActivationStubSettings firewallActivationSettings =
 *     firewallActivationSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFirewallEndpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallActivationStubSettings.Builder firewallActivationSettingsBuilder =
 *     FirewallActivationStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * firewallActivationSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class FirewallActivationStubSettings extends StubSettings<FirewallActivationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsSettings;
  private final UnaryCallSettings<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointSettings;
  private final UnaryCallSettings<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointSettings;
  private final OperationCallSettings<
          CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationSettings;
  private final UnaryCallSettings<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointSettings;
  private final OperationCallSettings<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationSettings;
  private final UnaryCallSettings<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointSettings;
  private final OperationCallSettings<
          UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationSettings;
  private final PagedCallSettings<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsSettings;
  private final UnaryCallSettings<
          GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationSettings;
  private final UnaryCallSettings<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationSettings;
  private final OperationCallSettings<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationSettings;
  private final UnaryCallSettings<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationSettings;
  private final OperationCallSettings<
          DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationSettings;
  private final UnaryCallSettings<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationSettings;
  private final OperationCallSettings<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
      LIST_FIREWALL_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFirewallEndpointsRequest injectToken(
                ListFirewallEndpointsRequest payload, String token) {
              return ListFirewallEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFirewallEndpointsRequest injectPageSize(
                ListFirewallEndpointsRequest payload, int pageSize) {
              return ListFirewallEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFirewallEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFirewallEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FirewallEndpoint> extractResources(
                ListFirewallEndpointsResponse payload) {
              return payload.getFirewallEndpointsList();
            }
          };

  private static final PagedListDescriptor<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          FirewallEndpointAssociation>
      LIST_FIREWALL_ENDPOINT_ASSOCIATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFirewallEndpointAssociationsRequest,
              ListFirewallEndpointAssociationsResponse,
              FirewallEndpointAssociation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFirewallEndpointAssociationsRequest injectToken(
                ListFirewallEndpointAssociationsRequest payload, String token) {
              return ListFirewallEndpointAssociationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListFirewallEndpointAssociationsRequest injectPageSize(
                ListFirewallEndpointAssociationsRequest payload, int pageSize) {
              return ListFirewallEndpointAssociationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFirewallEndpointAssociationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFirewallEndpointAssociationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FirewallEndpointAssociation> extractResources(
                ListFirewallEndpointAssociationsResponse payload) {
              return payload.getFirewallEndpointAssociationsList();
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
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          ListFirewallEndpointsPagedResponse>
      LIST_FIREWALL_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFirewallEndpointsRequest,
              ListFirewallEndpointsResponse,
              ListFirewallEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListFirewallEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFirewallEndpointsRequest, ListFirewallEndpointsResponse> callable,
                ListFirewallEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListFirewallEndpointsResponse> futureResponse) {
              PageContext<
                      ListFirewallEndpointsRequest, ListFirewallEndpointsResponse, FirewallEndpoint>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FIREWALL_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListFirewallEndpointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          ListFirewallEndpointAssociationsPagedResponse>
      LIST_FIREWALL_ENDPOINT_ASSOCIATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFirewallEndpointAssociationsRequest,
              ListFirewallEndpointAssociationsResponse,
              ListFirewallEndpointAssociationsPagedResponse>() {
            @Override
            public ApiFuture<ListFirewallEndpointAssociationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListFirewallEndpointAssociationsRequest,
                        ListFirewallEndpointAssociationsResponse>
                    callable,
                ListFirewallEndpointAssociationsRequest request,
                ApiCallContext context,
                ApiFuture<ListFirewallEndpointAssociationsResponse> futureResponse) {
              PageContext<
                      ListFirewallEndpointAssociationsRequest,
                      ListFirewallEndpointAssociationsResponse,
                      FirewallEndpointAssociation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_FIREWALL_ENDPOINT_ASSOCIATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListFirewallEndpointAssociationsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listFirewallEndpoints. */
  public PagedCallSettings<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsSettings() {
    return listFirewallEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to getFirewallEndpoint. */
  public UnaryCallSettings<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointSettings() {
    return getFirewallEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createFirewallEndpoint. */
  public UnaryCallSettings<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointSettings() {
    return createFirewallEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createFirewallEndpoint. */
  public OperationCallSettings<CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationSettings() {
    return createFirewallEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpoint. */
  public UnaryCallSettings<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointSettings() {
    return deleteFirewallEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpoint. */
  public OperationCallSettings<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationSettings() {
    return deleteFirewallEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpoint. */
  public UnaryCallSettings<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointSettings() {
    return updateFirewallEndpointSettings;
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpoint. */
  public OperationCallSettings<UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationSettings() {
    return updateFirewallEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFirewallEndpointAssociations. */
  public PagedCallSettings<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsSettings() {
    return listFirewallEndpointAssociationsSettings;
  }

  /** Returns the object with the settings used for calls to getFirewallEndpointAssociation. */
  public UnaryCallSettings<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationSettings() {
    return getFirewallEndpointAssociationSettings;
  }

  /** Returns the object with the settings used for calls to createFirewallEndpointAssociation. */
  public UnaryCallSettings<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationSettings() {
    return createFirewallEndpointAssociationSettings;
  }

  /** Returns the object with the settings used for calls to createFirewallEndpointAssociation. */
  public OperationCallSettings<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationSettings() {
    return createFirewallEndpointAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpointAssociation. */
  public UnaryCallSettings<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationSettings() {
    return deleteFirewallEndpointAssociationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpointAssociation. */
  public OperationCallSettings<DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationSettings() {
    return deleteFirewallEndpointAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpointAssociation. */
  public UnaryCallSettings<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationSettings() {
    return updateFirewallEndpointAssociationSettings;
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpointAssociation. */
  public OperationCallSettings<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationSettings() {
    return updateFirewallEndpointAssociationOperationSettings;
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

  public FirewallActivationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFirewallActivationStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(FirewallActivationStubSettings.class))
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

  protected FirewallActivationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFirewallEndpointsSettings = settingsBuilder.listFirewallEndpointsSettings().build();
    getFirewallEndpointSettings = settingsBuilder.getFirewallEndpointSettings().build();
    createFirewallEndpointSettings = settingsBuilder.createFirewallEndpointSettings().build();
    createFirewallEndpointOperationSettings =
        settingsBuilder.createFirewallEndpointOperationSettings().build();
    deleteFirewallEndpointSettings = settingsBuilder.deleteFirewallEndpointSettings().build();
    deleteFirewallEndpointOperationSettings =
        settingsBuilder.deleteFirewallEndpointOperationSettings().build();
    updateFirewallEndpointSettings = settingsBuilder.updateFirewallEndpointSettings().build();
    updateFirewallEndpointOperationSettings =
        settingsBuilder.updateFirewallEndpointOperationSettings().build();
    listFirewallEndpointAssociationsSettings =
        settingsBuilder.listFirewallEndpointAssociationsSettings().build();
    getFirewallEndpointAssociationSettings =
        settingsBuilder.getFirewallEndpointAssociationSettings().build();
    createFirewallEndpointAssociationSettings =
        settingsBuilder.createFirewallEndpointAssociationSettings().build();
    createFirewallEndpointAssociationOperationSettings =
        settingsBuilder.createFirewallEndpointAssociationOperationSettings().build();
    deleteFirewallEndpointAssociationSettings =
        settingsBuilder.deleteFirewallEndpointAssociationSettings().build();
    deleteFirewallEndpointAssociationOperationSettings =
        settingsBuilder.deleteFirewallEndpointAssociationOperationSettings().build();
    updateFirewallEndpointAssociationSettings =
        settingsBuilder.updateFirewallEndpointAssociationSettings().build();
    updateFirewallEndpointAssociationOperationSettings =
        settingsBuilder.updateFirewallEndpointAssociationOperationSettings().build();
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

  /** Builder for FirewallActivationStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FirewallActivationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFirewallEndpointsRequest,
            ListFirewallEndpointsResponse,
            ListFirewallEndpointsPagedResponse>
        listFirewallEndpointsSettings;
    private final UnaryCallSettings.Builder<GetFirewallEndpointRequest, FirewallEndpoint>
        getFirewallEndpointSettings;
    private final UnaryCallSettings.Builder<CreateFirewallEndpointRequest, Operation>
        createFirewallEndpointSettings;
    private final OperationCallSettings.Builder<
            CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        createFirewallEndpointOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFirewallEndpointRequest, Operation>
        deleteFirewallEndpointSettings;
    private final OperationCallSettings.Builder<
            DeleteFirewallEndpointRequest, Empty, OperationMetadata>
        deleteFirewallEndpointOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFirewallEndpointRequest, Operation>
        updateFirewallEndpointSettings;
    private final OperationCallSettings.Builder<
            UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        updateFirewallEndpointOperationSettings;
    private final PagedCallSettings.Builder<
            ListFirewallEndpointAssociationsRequest,
            ListFirewallEndpointAssociationsResponse,
            ListFirewallEndpointAssociationsPagedResponse>
        listFirewallEndpointAssociationsSettings;
    private final UnaryCallSettings.Builder<
            GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
        getFirewallEndpointAssociationSettings;
    private final UnaryCallSettings.Builder<CreateFirewallEndpointAssociationRequest, Operation>
        createFirewallEndpointAssociationSettings;
    private final OperationCallSettings.Builder<
            CreateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        createFirewallEndpointAssociationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFirewallEndpointAssociationRequest, Operation>
        deleteFirewallEndpointAssociationSettings;
    private final OperationCallSettings.Builder<
            DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
        deleteFirewallEndpointAssociationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFirewallEndpointAssociationRequest, Operation>
        updateFirewallEndpointAssociationSettings;
    private final OperationCallSettings.Builder<
            UpdateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        updateFirewallEndpointAssociationOperationSettings;
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

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listFirewallEndpointsSettings =
          PagedCallSettings.newBuilder(LIST_FIREWALL_ENDPOINTS_PAGE_STR_FACT);
      getFirewallEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFirewallEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFirewallEndpointOperationSettings = OperationCallSettings.newBuilder();
      deleteFirewallEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFirewallEndpointOperationSettings = OperationCallSettings.newBuilder();
      updateFirewallEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFirewallEndpointOperationSettings = OperationCallSettings.newBuilder();
      listFirewallEndpointAssociationsSettings =
          PagedCallSettings.newBuilder(LIST_FIREWALL_ENDPOINT_ASSOCIATIONS_PAGE_STR_FACT);
      getFirewallEndpointAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFirewallEndpointAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFirewallEndpointAssociationOperationSettings = OperationCallSettings.newBuilder();
      deleteFirewallEndpointAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFirewallEndpointAssociationOperationSettings = OperationCallSettings.newBuilder();
      updateFirewallEndpointAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFirewallEndpointAssociationOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFirewallEndpointsSettings,
              getFirewallEndpointSettings,
              createFirewallEndpointSettings,
              deleteFirewallEndpointSettings,
              updateFirewallEndpointSettings,
              listFirewallEndpointAssociationsSettings,
              getFirewallEndpointAssociationSettings,
              createFirewallEndpointAssociationSettings,
              deleteFirewallEndpointAssociationSettings,
              updateFirewallEndpointAssociationSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FirewallActivationStubSettings settings) {
      super(settings);

      listFirewallEndpointsSettings = settings.listFirewallEndpointsSettings.toBuilder();
      getFirewallEndpointSettings = settings.getFirewallEndpointSettings.toBuilder();
      createFirewallEndpointSettings = settings.createFirewallEndpointSettings.toBuilder();
      createFirewallEndpointOperationSettings =
          settings.createFirewallEndpointOperationSettings.toBuilder();
      deleteFirewallEndpointSettings = settings.deleteFirewallEndpointSettings.toBuilder();
      deleteFirewallEndpointOperationSettings =
          settings.deleteFirewallEndpointOperationSettings.toBuilder();
      updateFirewallEndpointSettings = settings.updateFirewallEndpointSettings.toBuilder();
      updateFirewallEndpointOperationSettings =
          settings.updateFirewallEndpointOperationSettings.toBuilder();
      listFirewallEndpointAssociationsSettings =
          settings.listFirewallEndpointAssociationsSettings.toBuilder();
      getFirewallEndpointAssociationSettings =
          settings.getFirewallEndpointAssociationSettings.toBuilder();
      createFirewallEndpointAssociationSettings =
          settings.createFirewallEndpointAssociationSettings.toBuilder();
      createFirewallEndpointAssociationOperationSettings =
          settings.createFirewallEndpointAssociationOperationSettings.toBuilder();
      deleteFirewallEndpointAssociationSettings =
          settings.deleteFirewallEndpointAssociationSettings.toBuilder();
      deleteFirewallEndpointAssociationOperationSettings =
          settings.deleteFirewallEndpointAssociationOperationSettings.toBuilder();
      updateFirewallEndpointAssociationSettings =
          settings.updateFirewallEndpointAssociationSettings.toBuilder();
      updateFirewallEndpointAssociationOperationSettings =
          settings.updateFirewallEndpointAssociationOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFirewallEndpointsSettings,
              getFirewallEndpointSettings,
              createFirewallEndpointSettings,
              deleteFirewallEndpointSettings,
              updateFirewallEndpointSettings,
              listFirewallEndpointAssociationsSettings,
              getFirewallEndpointAssociationSettings,
              createFirewallEndpointAssociationSettings,
              deleteFirewallEndpointAssociationSettings,
              updateFirewallEndpointAssociationSettings,
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
          .listFirewallEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFirewallEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFirewallEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFirewallEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFirewallEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFirewallEndpointAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFirewallEndpointAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFirewallEndpointAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFirewallEndpointAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFirewallEndpointAssociationSettings()
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
          .createFirewallEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFirewallEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FirewallEndpoint.class))
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
          .deleteFirewallEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFirewallEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateFirewallEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFirewallEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FirewallEndpoint.class))
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
          .createFirewallEndpointAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFirewallEndpointAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  FirewallEndpointAssociation.class))
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
          .deleteFirewallEndpointAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFirewallEndpointAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
          .updateFirewallEndpointAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFirewallEndpointAssociationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  FirewallEndpointAssociation.class))
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

    /** Returns the builder for the settings used for calls to listFirewallEndpoints. */
    public PagedCallSettings.Builder<
            ListFirewallEndpointsRequest,
            ListFirewallEndpointsResponse,
            ListFirewallEndpointsPagedResponse>
        listFirewallEndpointsSettings() {
      return listFirewallEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to getFirewallEndpoint. */
    public UnaryCallSettings.Builder<GetFirewallEndpointRequest, FirewallEndpoint>
        getFirewallEndpointSettings() {
      return getFirewallEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpoint. */
    public UnaryCallSettings.Builder<CreateFirewallEndpointRequest, Operation>
        createFirewallEndpointSettings() {
      return createFirewallEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpoint. */
    public OperationCallSettings.Builder<
            CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        createFirewallEndpointOperationSettings() {
      return createFirewallEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpoint. */
    public UnaryCallSettings.Builder<DeleteFirewallEndpointRequest, Operation>
        deleteFirewallEndpointSettings() {
      return deleteFirewallEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpoint. */
    public OperationCallSettings.Builder<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
        deleteFirewallEndpointOperationSettings() {
      return deleteFirewallEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpoint. */
    public UnaryCallSettings.Builder<UpdateFirewallEndpointRequest, Operation>
        updateFirewallEndpointSettings() {
      return updateFirewallEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpoint. */
    public OperationCallSettings.Builder<
            UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        updateFirewallEndpointOperationSettings() {
      return updateFirewallEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFirewallEndpointAssociations. */
    public PagedCallSettings.Builder<
            ListFirewallEndpointAssociationsRequest,
            ListFirewallEndpointAssociationsResponse,
            ListFirewallEndpointAssociationsPagedResponse>
        listFirewallEndpointAssociationsSettings() {
      return listFirewallEndpointAssociationsSettings;
    }

    /** Returns the builder for the settings used for calls to getFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<
            GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
        getFirewallEndpointAssociationSettings() {
      return getFirewallEndpointAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<CreateFirewallEndpointAssociationRequest, Operation>
        createFirewallEndpointAssociationSettings() {
      return createFirewallEndpointAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            CreateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        createFirewallEndpointAssociationOperationSettings() {
      return createFirewallEndpointAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<DeleteFirewallEndpointAssociationRequest, Operation>
        deleteFirewallEndpointAssociationSettings() {
      return deleteFirewallEndpointAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
        deleteFirewallEndpointAssociationOperationSettings() {
      return deleteFirewallEndpointAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<UpdateFirewallEndpointAssociationRequest, Operation>
        updateFirewallEndpointAssociationSettings() {
      return updateFirewallEndpointAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            UpdateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        updateFirewallEndpointAssociationOperationSettings() {
      return updateFirewallEndpointAssociationOperationSettings;
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
    public FirewallActivationStubSettings build() throws IOException {
      return new FirewallActivationStubSettings(this);
    }
  }
}
