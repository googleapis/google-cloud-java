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

package com.google.cloud.gkehub.v1beta1.stub;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

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
import com.google.cloud.gkehub.v1beta1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse;
import com.google.cloud.gkehub.v1beta1.GetMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1beta1.Membership;
import com.google.cloud.gkehub.v1beta1.OperationMetadata;
import com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link GkeHubMembershipServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkehub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMembership to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubMembershipServiceStubSettings.Builder gkeHubMembershipServiceSettingsBuilder =
 *     GkeHubMembershipServiceStubSettings.newBuilder();
 * gkeHubMembershipServiceSettingsBuilder
 *     .getMembershipSettings()
 *     .setRetrySettings(
 *         gkeHubMembershipServiceSettingsBuilder
 *             .getMembershipSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GkeHubMembershipServiceStubSettings gkeHubMembershipServiceSettings =
 *     gkeHubMembershipServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GkeHubMembershipServiceStubSettings
    extends StubSettings<GkeHubMembershipServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings;
  private final UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings;
  private final UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings;
  private final OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings;
  private final UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings;
  private final OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings;
  private final UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings;
  private final OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings;
  private final UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings;
  private final UnaryCallSettings<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivitySettings;
  private final UnaryCallSettings<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListMembershipsRequest, ListMembershipsResponse, Membership>
      LIST_MEMBERSHIPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMembershipsRequest, ListMembershipsResponse, Membership>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipsRequest injectToken(
                ListMembershipsRequest payload, String token) {
              return ListMembershipsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembershipsRequest injectPageSize(
                ListMembershipsRequest payload, int pageSize) {
              return ListMembershipsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMembershipsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Membership> extractResources(ListMembershipsResponse payload) {
              return payload.getResourcesList() == null
                  ? ImmutableList.<Membership>of()
                  : payload.getResourcesList();
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
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      LIST_MEMBERSHIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> callable,
                ListMembershipsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipsResponse> futureResponse) {
              PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> pageContext =
                  PageContext.create(callable, LIST_MEMBERSHIPS_PAGE_STR_DESC, request, context);
              return ListMembershipsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return listMembershipsSettings;
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return getMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings() {
    return createMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings() {
    return createMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings() {
    return deleteMembershipSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings() {
    return deleteMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings() {
    return updateMembershipSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings() {
    return updateMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateConnectManifest. */
  public UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings() {
    return generateConnectManifestSettings;
  }

  /** Returns the object with the settings used for calls to validateExclusivity. */
  public UnaryCallSettings<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivitySettings() {
    return validateExclusivitySettings;
  }

  /** Returns the object with the settings used for calls to generateExclusivityManifest. */
  public UnaryCallSettings<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestSettings() {
    return generateExclusivityManifestSettings;
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

  public GkeHubMembershipServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGkeHubMembershipServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGkeHubMembershipServiceStub.create(this);
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
    return "gkehub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkehub.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(GkeHubMembershipServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GkeHubMembershipServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected GkeHubMembershipServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMembershipsSettings = settingsBuilder.listMembershipsSettings().build();
    getMembershipSettings = settingsBuilder.getMembershipSettings().build();
    createMembershipSettings = settingsBuilder.createMembershipSettings().build();
    createMembershipOperationSettings = settingsBuilder.createMembershipOperationSettings().build();
    deleteMembershipSettings = settingsBuilder.deleteMembershipSettings().build();
    deleteMembershipOperationSettings = settingsBuilder.deleteMembershipOperationSettings().build();
    updateMembershipSettings = settingsBuilder.updateMembershipSettings().build();
    updateMembershipOperationSettings = settingsBuilder.updateMembershipOperationSettings().build();
    generateConnectManifestSettings = settingsBuilder.generateConnectManifestSettings().build();
    validateExclusivitySettings = settingsBuilder.validateExclusivitySettings().build();
    generateExclusivityManifestSettings =
        settingsBuilder.generateExclusivityManifestSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for GkeHubMembershipServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<GkeHubMembershipServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings;
    private final UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings;
    private final UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings;
    private final OperationCallSettings.Builder<
            CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings;
    private final OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings;
    private final OperationCallSettings.Builder<
            UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings;
    private final UnaryCallSettings.Builder<ValidateExclusivityRequest, ValidateExclusivityResponse>
        validateExclusivitySettings;
    private final UnaryCallSettings.Builder<
            GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
        generateExclusivityManifestSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listMembershipsSettings = PagedCallSettings.newBuilder(LIST_MEMBERSHIPS_PAGE_STR_FACT);
      getMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipOperationSettings = OperationCallSettings.newBuilder();
      deleteMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipOperationSettings = OperationCallSettings.newBuilder();
      updateMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipOperationSettings = OperationCallSettings.newBuilder();
      generateConnectManifestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateExclusivitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateExclusivityManifestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              getMembershipSettings,
              createMembershipSettings,
              deleteMembershipSettings,
              updateMembershipSettings,
              generateConnectManifestSettings,
              validateExclusivitySettings,
              generateExclusivityManifestSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(GkeHubMembershipServiceStubSettings settings) {
      super(settings);

      listMembershipsSettings = settings.listMembershipsSettings.toBuilder();
      getMembershipSettings = settings.getMembershipSettings.toBuilder();
      createMembershipSettings = settings.createMembershipSettings.toBuilder();
      createMembershipOperationSettings = settings.createMembershipOperationSettings.toBuilder();
      deleteMembershipSettings = settings.deleteMembershipSettings.toBuilder();
      deleteMembershipOperationSettings = settings.deleteMembershipOperationSettings.toBuilder();
      updateMembershipSettings = settings.updateMembershipSettings.toBuilder();
      updateMembershipOperationSettings = settings.updateMembershipOperationSettings.toBuilder();
      generateConnectManifestSettings = settings.generateConnectManifestSettings.toBuilder();
      validateExclusivitySettings = settings.validateExclusivitySettings.toBuilder();
      generateExclusivityManifestSettings =
          settings.generateExclusivityManifestSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              getMembershipSettings,
              createMembershipSettings,
              deleteMembershipSettings,
              updateMembershipSettings,
              generateConnectManifestSettings,
              validateExclusivitySettings,
              generateExclusivityManifestSettings,
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
          .listMembershipsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateConnectManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .validateExclusivitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateExclusivityManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
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
          .createMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
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
          .deleteMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
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

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return listMembershipsSettings;
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings() {
      return createMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings() {
      return createMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings() {
      return deleteMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings() {
      return deleteMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings() {
      return updateMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings() {
      return updateMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateConnectManifest. */
    public UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings() {
      return generateConnectManifestSettings;
    }

    /** Returns the builder for the settings used for calls to validateExclusivity. */
    public UnaryCallSettings.Builder<ValidateExclusivityRequest, ValidateExclusivityResponse>
        validateExclusivitySettings() {
      return validateExclusivitySettings;
    }

    /** Returns the builder for the settings used for calls to generateExclusivityManifest. */
    public UnaryCallSettings.Builder<
            GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
        generateExclusivityManifestSettings() {
      return generateExclusivityManifestSettings;
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
    public GkeHubMembershipServiceStubSettings build() throws IOException {
      return new GkeHubMembershipServiceStubSettings(this);
    }
  }
}
