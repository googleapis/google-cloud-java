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

import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfileGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfilesPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SecurityProfile;
import com.google.cloud.networksecurity.v1.SecurityProfileGroup;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest;
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
 * Settings class to configure an instance of {@link OrganizationSecurityProfileGroupServiceStub}.
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
 * of getSecurityProfileGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityProfileGroupServiceStubSettings.Builder
 *     organizationSecurityProfileGroupServiceSettingsBuilder =
 *         OrganizationSecurityProfileGroupServiceStubSettings.newBuilder();
 * organizationSecurityProfileGroupServiceSettingsBuilder
 *     .getSecurityProfileGroupSettings()
 *     .setRetrySettings(
 *         organizationSecurityProfileGroupServiceSettingsBuilder
 *             .getSecurityProfileGroupSettings()
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
 * OrganizationSecurityProfileGroupServiceStubSettings
 *     organizationSecurityProfileGroupServiceSettings =
 *         organizationSecurityProfileGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSecurityProfileGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityProfileGroupServiceStubSettings.Builder
 *     organizationSecurityProfileGroupServiceSettingsBuilder =
 *         OrganizationSecurityProfileGroupServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * organizationSecurityProfileGroupServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class OrganizationSecurityProfileGroupServiceStubSettings
    extends StubSettings<OrganizationSecurityProfileGroupServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsSettings;
  private final UnaryCallSettings<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupSettings;
  private final UnaryCallSettings<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupSettings;
  private final OperationCallSettings<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationSettings;
  private final UnaryCallSettings<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupSettings;
  private final OperationCallSettings<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationSettings;
  private final UnaryCallSettings<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupSettings;
  private final OperationCallSettings<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationSettings;
  private final PagedCallSettings<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          ListSecurityProfilesPagedResponse>
      listSecurityProfilesSettings;
  private final UnaryCallSettings<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileSettings;
  private final UnaryCallSettings<CreateSecurityProfileRequest, Operation>
      createSecurityProfileSettings;
  private final OperationCallSettings<
          CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationSettings;
  private final UnaryCallSettings<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileSettings;
  private final OperationCallSettings<
          UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationSettings;
  private final UnaryCallSettings<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileSettings;
  private final OperationCallSettings<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse, SecurityProfileGroup>
      LIST_SECURITY_PROFILE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecurityProfileGroupsRequest,
              ListSecurityProfileGroupsResponse,
              SecurityProfileGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecurityProfileGroupsRequest injectToken(
                ListSecurityProfileGroupsRequest payload, String token) {
              return ListSecurityProfileGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSecurityProfileGroupsRequest injectPageSize(
                ListSecurityProfileGroupsRequest payload, int pageSize) {
              return ListSecurityProfileGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSecurityProfileGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSecurityProfileGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecurityProfileGroup> extractResources(
                ListSecurityProfileGroupsResponse payload) {
              return payload.getSecurityProfileGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
      LIST_SECURITY_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecurityProfilesRequest injectToken(
                ListSecurityProfilesRequest payload, String token) {
              return ListSecurityProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSecurityProfilesRequest injectPageSize(
                ListSecurityProfilesRequest payload, int pageSize) {
              return ListSecurityProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSecurityProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSecurityProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecurityProfile> extractResources(
                ListSecurityProfilesResponse payload) {
              return payload.getSecurityProfilesList();
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
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          ListSecurityProfileGroupsPagedResponse>
      LIST_SECURITY_PROFILE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecurityProfileGroupsRequest,
              ListSecurityProfileGroupsResponse,
              ListSecurityProfileGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListSecurityProfileGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
                    callable,
                ListSecurityProfileGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListSecurityProfileGroupsResponse> futureResponse) {
              PageContext<
                      ListSecurityProfileGroupsRequest,
                      ListSecurityProfileGroupsResponse,
                      SecurityProfileGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SECURITY_PROFILE_GROUPS_PAGE_STR_DESC, request, context);
              return ListSecurityProfileGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          ListSecurityProfilesPagedResponse>
      LIST_SECURITY_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecurityProfilesRequest,
              ListSecurityProfilesResponse,
              ListSecurityProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListSecurityProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesResponse> callable,
                ListSecurityProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListSecurityProfilesResponse> futureResponse) {
              PageContext<
                      ListSecurityProfilesRequest, ListSecurityProfilesResponse, SecurityProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SECURITY_PROFILES_PAGE_STR_DESC, request, context);
              return ListSecurityProfilesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listSecurityProfileGroups. */
  public PagedCallSettings<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsSettings() {
    return listSecurityProfileGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getSecurityProfileGroup. */
  public UnaryCallSettings<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupSettings() {
    return getSecurityProfileGroupSettings;
  }

  /** Returns the object with the settings used for calls to createSecurityProfileGroup. */
  public UnaryCallSettings<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupSettings() {
    return createSecurityProfileGroupSettings;
  }

  /** Returns the object with the settings used for calls to createSecurityProfileGroup. */
  public OperationCallSettings<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationSettings() {
    return createSecurityProfileGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityProfileGroup. */
  public UnaryCallSettings<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupSettings() {
    return updateSecurityProfileGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityProfileGroup. */
  public OperationCallSettings<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationSettings() {
    return updateSecurityProfileGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfileGroup. */
  public UnaryCallSettings<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupSettings() {
    return deleteSecurityProfileGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfileGroup. */
  public OperationCallSettings<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationSettings() {
    return deleteSecurityProfileGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSecurityProfiles. */
  public PagedCallSettings<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          ListSecurityProfilesPagedResponse>
      listSecurityProfilesSettings() {
    return listSecurityProfilesSettings;
  }

  /** Returns the object with the settings used for calls to getSecurityProfile. */
  public UnaryCallSettings<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileSettings() {
    return getSecurityProfileSettings;
  }

  /** Returns the object with the settings used for calls to createSecurityProfile. */
  public UnaryCallSettings<CreateSecurityProfileRequest, Operation>
      createSecurityProfileSettings() {
    return createSecurityProfileSettings;
  }

  /** Returns the object with the settings used for calls to createSecurityProfile. */
  public OperationCallSettings<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationSettings() {
    return createSecurityProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityProfile. */
  public UnaryCallSettings<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileSettings() {
    return updateSecurityProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityProfile. */
  public OperationCallSettings<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationSettings() {
    return updateSecurityProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfile. */
  public UnaryCallSettings<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileSettings() {
    return deleteSecurityProfileSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfile. */
  public OperationCallSettings<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationSettings() {
    return deleteSecurityProfileOperationSettings;
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

  public OrganizationSecurityProfileGroupServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOrganizationSecurityProfileGroupServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(
                OrganizationSecurityProfileGroupServiceStubSettings.class))
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

  protected OrganizationSecurityProfileGroupServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    listSecurityProfileGroupsSettings = settingsBuilder.listSecurityProfileGroupsSettings().build();
    getSecurityProfileGroupSettings = settingsBuilder.getSecurityProfileGroupSettings().build();
    createSecurityProfileGroupSettings =
        settingsBuilder.createSecurityProfileGroupSettings().build();
    createSecurityProfileGroupOperationSettings =
        settingsBuilder.createSecurityProfileGroupOperationSettings().build();
    updateSecurityProfileGroupSettings =
        settingsBuilder.updateSecurityProfileGroupSettings().build();
    updateSecurityProfileGroupOperationSettings =
        settingsBuilder.updateSecurityProfileGroupOperationSettings().build();
    deleteSecurityProfileGroupSettings =
        settingsBuilder.deleteSecurityProfileGroupSettings().build();
    deleteSecurityProfileGroupOperationSettings =
        settingsBuilder.deleteSecurityProfileGroupOperationSettings().build();
    listSecurityProfilesSettings = settingsBuilder.listSecurityProfilesSettings().build();
    getSecurityProfileSettings = settingsBuilder.getSecurityProfileSettings().build();
    createSecurityProfileSettings = settingsBuilder.createSecurityProfileSettings().build();
    createSecurityProfileOperationSettings =
        settingsBuilder.createSecurityProfileOperationSettings().build();
    updateSecurityProfileSettings = settingsBuilder.updateSecurityProfileSettings().build();
    updateSecurityProfileOperationSettings =
        settingsBuilder.updateSecurityProfileOperationSettings().build();
    deleteSecurityProfileSettings = settingsBuilder.deleteSecurityProfileSettings().build();
    deleteSecurityProfileOperationSettings =
        settingsBuilder.deleteSecurityProfileOperationSettings().build();
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

  /** Builder for OrganizationSecurityProfileGroupServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<OrganizationSecurityProfileGroupServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListSecurityProfileGroupsRequest,
            ListSecurityProfileGroupsResponse,
            ListSecurityProfileGroupsPagedResponse>
        listSecurityProfileGroupsSettings;
    private final UnaryCallSettings.Builder<GetSecurityProfileGroupRequest, SecurityProfileGroup>
        getSecurityProfileGroupSettings;
    private final UnaryCallSettings.Builder<CreateSecurityProfileGroupRequest, Operation>
        createSecurityProfileGroupSettings;
    private final OperationCallSettings.Builder<
            CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        createSecurityProfileGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSecurityProfileGroupRequest, Operation>
        updateSecurityProfileGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        updateSecurityProfileGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSecurityProfileGroupRequest, Operation>
        deleteSecurityProfileGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
        deleteSecurityProfileGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListSecurityProfilesRequest,
            ListSecurityProfilesResponse,
            ListSecurityProfilesPagedResponse>
        listSecurityProfilesSettings;
    private final UnaryCallSettings.Builder<GetSecurityProfileRequest, SecurityProfile>
        getSecurityProfileSettings;
    private final UnaryCallSettings.Builder<CreateSecurityProfileRequest, Operation>
        createSecurityProfileSettings;
    private final OperationCallSettings.Builder<
            CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        createSecurityProfileOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSecurityProfileRequest, Operation>
        updateSecurityProfileSettings;
    private final OperationCallSettings.Builder<
            UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        updateSecurityProfileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSecurityProfileRequest, Operation>
        deleteSecurityProfileSettings;
    private final OperationCallSettings.Builder<
            DeleteSecurityProfileRequest, Empty, OperationMetadata>
        deleteSecurityProfileOperationSettings;
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

      listSecurityProfileGroupsSettings =
          PagedCallSettings.newBuilder(LIST_SECURITY_PROFILE_GROUPS_PAGE_STR_FACT);
      getSecurityProfileGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSecurityProfileGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSecurityProfileGroupOperationSettings = OperationCallSettings.newBuilder();
      updateSecurityProfileGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecurityProfileGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteSecurityProfileGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSecurityProfileGroupOperationSettings = OperationCallSettings.newBuilder();
      listSecurityProfilesSettings =
          PagedCallSettings.newBuilder(LIST_SECURITY_PROFILES_PAGE_STR_FACT);
      getSecurityProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSecurityProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSecurityProfileOperationSettings = OperationCallSettings.newBuilder();
      updateSecurityProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecurityProfileOperationSettings = OperationCallSettings.newBuilder();
      deleteSecurityProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSecurityProfileOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSecurityProfileGroupsSettings,
              getSecurityProfileGroupSettings,
              createSecurityProfileGroupSettings,
              updateSecurityProfileGroupSettings,
              deleteSecurityProfileGroupSettings,
              listSecurityProfilesSettings,
              getSecurityProfileSettings,
              createSecurityProfileSettings,
              updateSecurityProfileSettings,
              deleteSecurityProfileSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(OrganizationSecurityProfileGroupServiceStubSettings settings) {
      super(settings);

      listSecurityProfileGroupsSettings = settings.listSecurityProfileGroupsSettings.toBuilder();
      getSecurityProfileGroupSettings = settings.getSecurityProfileGroupSettings.toBuilder();
      createSecurityProfileGroupSettings = settings.createSecurityProfileGroupSettings.toBuilder();
      createSecurityProfileGroupOperationSettings =
          settings.createSecurityProfileGroupOperationSettings.toBuilder();
      updateSecurityProfileGroupSettings = settings.updateSecurityProfileGroupSettings.toBuilder();
      updateSecurityProfileGroupOperationSettings =
          settings.updateSecurityProfileGroupOperationSettings.toBuilder();
      deleteSecurityProfileGroupSettings = settings.deleteSecurityProfileGroupSettings.toBuilder();
      deleteSecurityProfileGroupOperationSettings =
          settings.deleteSecurityProfileGroupOperationSettings.toBuilder();
      listSecurityProfilesSettings = settings.listSecurityProfilesSettings.toBuilder();
      getSecurityProfileSettings = settings.getSecurityProfileSettings.toBuilder();
      createSecurityProfileSettings = settings.createSecurityProfileSettings.toBuilder();
      createSecurityProfileOperationSettings =
          settings.createSecurityProfileOperationSettings.toBuilder();
      updateSecurityProfileSettings = settings.updateSecurityProfileSettings.toBuilder();
      updateSecurityProfileOperationSettings =
          settings.updateSecurityProfileOperationSettings.toBuilder();
      deleteSecurityProfileSettings = settings.deleteSecurityProfileSettings.toBuilder();
      deleteSecurityProfileOperationSettings =
          settings.deleteSecurityProfileOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSecurityProfileGroupsSettings,
              getSecurityProfileGroupSettings,
              createSecurityProfileGroupSettings,
              updateSecurityProfileGroupSettings,
              deleteSecurityProfileGroupSettings,
              listSecurityProfilesSettings,
              getSecurityProfileSettings,
              createSecurityProfileSettings,
              updateSecurityProfileSettings,
              deleteSecurityProfileSettings,
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
          .listSecurityProfileGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSecurityProfileGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSecurityProfileGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSecurityProfileGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSecurityProfileGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSecurityProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSecurityProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSecurityProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSecurityProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSecurityProfileSettings()
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
          .createSecurityProfileGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSecurityProfileGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SecurityProfileGroup.class))
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
          .updateSecurityProfileGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSecurityProfileGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SecurityProfileGroup.class))
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
          .deleteSecurityProfileGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSecurityProfileGroupRequest, OperationSnapshot>
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
          .createSecurityProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSecurityProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SecurityProfile.class))
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
          .updateSecurityProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSecurityProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SecurityProfile.class))
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
          .deleteSecurityProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSecurityProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listSecurityProfileGroups. */
    public PagedCallSettings.Builder<
            ListSecurityProfileGroupsRequest,
            ListSecurityProfileGroupsResponse,
            ListSecurityProfileGroupsPagedResponse>
        listSecurityProfileGroupsSettings() {
      return listSecurityProfileGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getSecurityProfileGroup. */
    public UnaryCallSettings.Builder<GetSecurityProfileGroupRequest, SecurityProfileGroup>
        getSecurityProfileGroupSettings() {
      return getSecurityProfileGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createSecurityProfileGroup. */
    public UnaryCallSettings.Builder<CreateSecurityProfileGroupRequest, Operation>
        createSecurityProfileGroupSettings() {
      return createSecurityProfileGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        createSecurityProfileGroupOperationSettings() {
      return createSecurityProfileGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfileGroup. */
    public UnaryCallSettings.Builder<UpdateSecurityProfileGroupRequest, Operation>
        updateSecurityProfileGroupSettings() {
      return updateSecurityProfileGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        updateSecurityProfileGroupOperationSettings() {
      return updateSecurityProfileGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfileGroup. */
    public UnaryCallSettings.Builder<DeleteSecurityProfileGroupRequest, Operation>
        deleteSecurityProfileGroupSettings() {
      return deleteSecurityProfileGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
        deleteSecurityProfileGroupOperationSettings() {
      return deleteSecurityProfileGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSecurityProfiles. */
    public PagedCallSettings.Builder<
            ListSecurityProfilesRequest,
            ListSecurityProfilesResponse,
            ListSecurityProfilesPagedResponse>
        listSecurityProfilesSettings() {
      return listSecurityProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to getSecurityProfile. */
    public UnaryCallSettings.Builder<GetSecurityProfileRequest, SecurityProfile>
        getSecurityProfileSettings() {
      return getSecurityProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createSecurityProfile. */
    public UnaryCallSettings.Builder<CreateSecurityProfileRequest, Operation>
        createSecurityProfileSettings() {
      return createSecurityProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createSecurityProfile. */
    public OperationCallSettings.Builder<
            CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        createSecurityProfileOperationSettings() {
      return createSecurityProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfile. */
    public UnaryCallSettings.Builder<UpdateSecurityProfileRequest, Operation>
        updateSecurityProfileSettings() {
      return updateSecurityProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfile. */
    public OperationCallSettings.Builder<
            UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        updateSecurityProfileOperationSettings() {
      return updateSecurityProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfile. */
    public UnaryCallSettings.Builder<DeleteSecurityProfileRequest, Operation>
        deleteSecurityProfileSettings() {
      return deleteSecurityProfileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfile. */
    public OperationCallSettings.Builder<DeleteSecurityProfileRequest, Empty, OperationMetadata>
        deleteSecurityProfileOperationSettings() {
      return deleteSecurityProfileOperationSettings;
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
    public OrganizationSecurityProfileGroupServiceStubSettings build() throws IOException {
      return new OrganizationSecurityProfileGroupServiceStubSettings(this);
    }
  }
}
