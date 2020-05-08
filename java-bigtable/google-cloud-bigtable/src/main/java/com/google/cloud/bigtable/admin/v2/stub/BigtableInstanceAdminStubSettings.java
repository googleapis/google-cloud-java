/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;

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
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link BigtableInstanceAdminStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigtableadmin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>
 * <code>
 * BigtableInstanceAdminStubSettings.Builder baseBigtableInstanceAdminSettingsBuilder =
 *     BigtableInstanceAdminStubSettings.newBuilder();
 * baseBigtableInstanceAdminSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         baseBigtableInstanceAdminSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BigtableInstanceAdminStubSettings baseBigtableInstanceAdminSettings = baseBigtableInstanceAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BigtableInstanceAdminStubSettings
    extends StubSettings<BigtableInstanceAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.admin")
          .add("https://www.googleapis.com/auth/bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/bigtable.admin.instance")
          .add("https://www.googleapis.com/auth/bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<ListInstancesRequest, ListInstancesResponse>
      listInstancesSettings;
  private final UnaryCallSettings<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceSettings;
  private final OperationCallSettings<
          PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings;
  private final UnaryCallSettings<Cluster, Operation> updateClusterSettings;
  private final OperationCallSettings<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Empty> deleteClusterSettings;
  private final UnaryCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileSettings;
  private final UnaryCallSettings<GetAppProfileRequest, AppProfile> getAppProfileSettings;
  private final PagedCallSettings<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      listAppProfilesSettings;
  private final UnaryCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileSettings;
  private final OperationCallSettings<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationSettings;
  private final UnaryCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public UnaryCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  public UnaryCallSettings<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceSettings() {
    return partialUpdateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationSettings() {
    return partialUpdateInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<Cluster, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Empty> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to createAppProfile. */
  public UnaryCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileSettings() {
    return createAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to getAppProfile. */
  public UnaryCallSettings<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
    return getAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to listAppProfiles. */
  public PagedCallSettings<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      listAppProfilesSettings() {
    return listAppProfilesSettings;
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  public UnaryCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileSettings() {
    return updateAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationSettings() {
    return updateAppProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppProfile. */
  public UnaryCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
    return deleteAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigtableInstanceAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigtableInstanceAdminStub.create(this);
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
    return "bigtableadmin.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BigtableInstanceAdminStubSettings.class))
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

  protected BigtableInstanceAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    partialUpdateInstanceSettings = settingsBuilder.partialUpdateInstanceSettings().build();
    partialUpdateInstanceOperationSettings =
        settingsBuilder.partialUpdateInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    listClustersSettings = settingsBuilder.listClustersSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    createAppProfileSettings = settingsBuilder.createAppProfileSettings().build();
    getAppProfileSettings = settingsBuilder.getAppProfileSettings().build();
    listAppProfilesSettings = settingsBuilder.listAppProfilesSettings().build();
    updateAppProfileSettings = settingsBuilder.updateAppProfileSettings().build();
    updateAppProfileOperationSettings = settingsBuilder.updateAppProfileOperationSettings().build();
    deleteAppProfileSettings = settingsBuilder.deleteAppProfileSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  private static final PagedListDescriptor<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile>
      LIST_APP_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppProfilesRequest injectToken(
                ListAppProfilesRequest payload, String token) {
              return ListAppProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppProfilesRequest injectPageSize(
                ListAppProfilesRequest payload, int pageSize) {
              return ListAppProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppProfile> extractResources(ListAppProfilesResponse payload) {
              return payload.getAppProfilesList() != null
                  ? payload.getAppProfilesList()
                  : ImmutableList.<AppProfile>of();
            }
          };

  private static final PagedListResponseFactory<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      LIST_APP_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListAppProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse> callable,
                ListAppProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListAppProfilesResponse> futureResponse) {
              PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> pageContext =
                  PageContext.create(callable, LIST_APP_PROFILES_PAGE_STR_DESC, request, context);
              return ListAppProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for BigtableInstanceAdminStubSettings. */
  public static class Builder
      extends StubSettings.Builder<BigtableInstanceAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<
            CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<ListInstancesRequest, ListInstancesResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceSettings;
    private final OperationCallSettings.Builder<
            PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        partialUpdateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<
            CreateClusterRequest, Cluster, CreateClusterMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<Cluster, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<Cluster, Cluster, UpdateClusterMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Empty> deleteClusterSettings;
    private final UnaryCallSettings.Builder<CreateAppProfileRequest, AppProfile>
        createAppProfileSettings;
    private final UnaryCallSettings.Builder<GetAppProfileRequest, AppProfile> getAppProfileSettings;
    private final PagedCallSettings.Builder<
            ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
        listAppProfilesSettings;
    private final UnaryCallSettings.Builder<UpdateAppProfileRequest, Operation>
        updateAppProfileSettings;
    private final OperationCallSettings.Builder<
            UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
        updateAppProfileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAppProfileRequest, Empty>
        deleteAppProfileSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("idempotent_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setRetryDelayMultiplier(1.0)
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("non_idempotent_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setRetryDelayMultiplier(1.0)
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("non_idempotent_heavy_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createInstanceOperationSettings = OperationCallSettings.newBuilder();

      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      partialUpdateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      partialUpdateInstanceOperationSettings = OperationCallSettings.newBuilder();

      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createClusterOperationSettings = OperationCallSettings.newBuilder();

      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listClustersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateClusterOperationSettings = OperationCallSettings.newBuilder();

      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listAppProfilesSettings = PagedCallSettings.newBuilder(LIST_APP_PROFILES_PAGE_STR_FACT);

      updateAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateAppProfileOperationSettings = OperationCallSettings.newBuilder();

      deleteAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createInstanceSettings,
              getInstanceSettings,
              listInstancesSettings,
              partialUpdateInstanceSettings,
              deleteInstanceSettings,
              createClusterSettings,
              getClusterSettings,
              listClustersSettings,
              updateClusterSettings,
              deleteClusterSettings,
              createAppProfileSettings,
              getAppProfileSettings,
              listAppProfilesSettings,
              updateAppProfileSettings,
              deleteAppProfileSettings,
              getIamPolicySettings,
              setIamPolicySettings,
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
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_heavy_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .partialUpdateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .createAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .getAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .listAppProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .updateAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .deleteAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"));
      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_heavy_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));
      builder
          .partialUpdateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PartialUpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));
      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("non_idempotent_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateClusterMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(60000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(21600000L))
                      .build()));
      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<Cluster, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateClusterMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));
      builder
          .updateAppProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAppProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("idempotent_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppProfile.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateAppProfileMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      return builder;
    }

    protected Builder(BigtableInstanceAdminStubSettings settings) {
      super(settings);

      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      partialUpdateInstanceSettings = settings.partialUpdateInstanceSettings.toBuilder();
      partialUpdateInstanceOperationSettings =
          settings.partialUpdateInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      listClustersSettings = settings.listClustersSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      createAppProfileSettings = settings.createAppProfileSettings.toBuilder();
      getAppProfileSettings = settings.getAppProfileSettings.toBuilder();
      listAppProfilesSettings = settings.listAppProfilesSettings.toBuilder();
      updateAppProfileSettings = settings.updateAppProfileSettings.toBuilder();
      updateAppProfileOperationSettings = settings.updateAppProfileOperationSettings.toBuilder();
      deleteAppProfileSettings = settings.deleteAppProfileSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createInstanceSettings,
              getInstanceSettings,
              listInstancesSettings,
              partialUpdateInstanceSettings,
              deleteInstanceSettings,
              createClusterSettings,
              getClusterSettings,
              listClustersSettings,
              updateClusterSettings,
              deleteClusterSettings,
              createAppProfileSettings,
              getAppProfileSettings,
              listAppProfilesSettings,
              updateAppProfileSettings,
              deleteAppProfileSettings,
              getIamPolicySettings,
              setIamPolicySettings,
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public UnaryCallSettings.Builder<ListInstancesRequest, ListInstancesResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    public UnaryCallSettings.Builder<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceSettings() {
      return partialUpdateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        partialUpdateInstanceOperationSettings() {
      return partialUpdateInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, CreateClusterMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<Cluster, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<Cluster, Cluster, UpdateClusterMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Empty> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createAppProfile. */
    public UnaryCallSettings.Builder<CreateAppProfileRequest, AppProfile>
        createAppProfileSettings() {
      return createAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getAppProfile. */
    public UnaryCallSettings.Builder<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
      return getAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to listAppProfiles. */
    public PagedCallSettings.Builder<
            ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
        listAppProfilesSettings() {
      return listAppProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    public UnaryCallSettings.Builder<UpdateAppProfileRequest, Operation>
        updateAppProfileSettings() {
      return updateAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
        updateAppProfileOperationSettings() {
      return updateAppProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppProfile. */
    public UnaryCallSettings.Builder<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
      return deleteAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public BigtableInstanceAdminStubSettings build() throws IOException {
      return new BigtableInstanceAdminStubSettings(this);
    }
  }
}
