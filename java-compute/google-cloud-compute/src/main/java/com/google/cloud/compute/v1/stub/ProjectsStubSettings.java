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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ProjectsClient.GetXpnResourcesPagedResponse;
import static com.google.cloud.compute.v1.ProjectsClient.ListXpnHostsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.compute.v1.DisableXpnHostProjectRequest;
import com.google.cloud.compute.v1.DisableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.EnableXpnHostProjectRequest;
import com.google.cloud.compute.v1.EnableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.GetProjectRequest;
import com.google.cloud.compute.v1.GetXpnHostProjectRequest;
import com.google.cloud.compute.v1.GetXpnResourcesProjectsRequest;
import com.google.cloud.compute.v1.ListXpnHostsProjectsRequest;
import com.google.cloud.compute.v1.MoveDiskProjectRequest;
import com.google.cloud.compute.v1.MoveInstanceProjectRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectsGetXpnResources;
import com.google.cloud.compute.v1.SetCommonInstanceMetadataProjectRequest;
import com.google.cloud.compute.v1.SetDefaultNetworkTierProjectRequest;
import com.google.cloud.compute.v1.SetUsageExportBucketProjectRequest;
import com.google.cloud.compute.v1.XpnHostList;
import com.google.cloud.compute.v1.XpnResourceId;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProjectsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectsStubSettings.Builder projectsSettingsBuilder = ProjectsStubSettings.newBuilder();
 * projectsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         projectsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectsStubSettings projectsSettings = projectsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProjectsStubSettings extends StubSettings<ProjectsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<DisableXpnHostProjectRequest, Operation> disableXpnHostSettings;
  private final OperationCallSettings<DisableXpnHostProjectRequest, Operation, Operation>
      disableXpnHostOperationSettings;
  private final UnaryCallSettings<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceSettings;
  private final OperationCallSettings<DisableXpnResourceProjectRequest, Operation, Operation>
      disableXpnResourceOperationSettings;
  private final UnaryCallSettings<EnableXpnHostProjectRequest, Operation> enableXpnHostSettings;
  private final OperationCallSettings<EnableXpnHostProjectRequest, Operation, Operation>
      enableXpnHostOperationSettings;
  private final UnaryCallSettings<EnableXpnResourceProjectRequest, Operation>
      enableXpnResourceSettings;
  private final OperationCallSettings<EnableXpnResourceProjectRequest, Operation, Operation>
      enableXpnResourceOperationSettings;
  private final UnaryCallSettings<GetProjectRequest, Project> getSettings;
  private final UnaryCallSettings<GetXpnHostProjectRequest, Project> getXpnHostSettings;
  private final PagedCallSettings<
          GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
      getXpnResourcesSettings;
  private final PagedCallSettings<
          ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
      listXpnHostsSettings;
  private final UnaryCallSettings<MoveDiskProjectRequest, Operation> moveDiskSettings;
  private final OperationCallSettings<MoveDiskProjectRequest, Operation, Operation>
      moveDiskOperationSettings;
  private final UnaryCallSettings<MoveInstanceProjectRequest, Operation> moveInstanceSettings;
  private final OperationCallSettings<MoveInstanceProjectRequest, Operation, Operation>
      moveInstanceOperationSettings;
  private final UnaryCallSettings<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataSettings;
  private final OperationCallSettings<SetCommonInstanceMetadataProjectRequest, Operation, Operation>
      setCommonInstanceMetadataOperationSettings;
  private final UnaryCallSettings<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierSettings;
  private final OperationCallSettings<SetDefaultNetworkTierProjectRequest, Operation, Operation>
      setDefaultNetworkTierOperationSettings;
  private final UnaryCallSettings<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketSettings;
  private final OperationCallSettings<SetUsageExportBucketProjectRequest, Operation, Operation>
      setUsageExportBucketOperationSettings;

  private static final PagedListDescriptor<
          GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId>
      GET_XPN_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GetXpnResourcesProjectsRequest injectToken(
                GetXpnResourcesProjectsRequest payload, String token) {
              return GetXpnResourcesProjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public GetXpnResourcesProjectsRequest injectPageSize(
                GetXpnResourcesProjectsRequest payload, int pageSize) {
              return GetXpnResourcesProjectsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GetXpnResourcesProjectsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ProjectsGetXpnResources payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<XpnResourceId> extractResources(ProjectsGetXpnResources payload) {
              return payload.getResourcesList() == null
                  ? ImmutableList.<XpnResourceId>of()
                  : payload.getResourcesList();
            }
          };

  private static final PagedListDescriptor<ListXpnHostsProjectsRequest, XpnHostList, Project>
      LIST_XPN_HOSTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListXpnHostsProjectsRequest, XpnHostList, Project>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListXpnHostsProjectsRequest injectToken(
                ListXpnHostsProjectsRequest payload, String token) {
              return ListXpnHostsProjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListXpnHostsProjectsRequest injectPageSize(
                ListXpnHostsProjectsRequest payload, int pageSize) {
              return ListXpnHostsProjectsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListXpnHostsProjectsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(XpnHostList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Project> extractResources(XpnHostList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<Project>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
      GET_XPN_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GetXpnResourcesProjectsRequest,
              ProjectsGetXpnResources,
              GetXpnResourcesPagedResponse>() {
            @Override
            public ApiFuture<GetXpnResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources> callable,
                GetXpnResourcesProjectsRequest request,
                ApiCallContext context,
                ApiFuture<ProjectsGetXpnResources> futureResponse) {
              PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId>
                  pageContext =
                      PageContext.create(
                          callable, GET_XPN_RESOURCES_PAGE_STR_DESC, request, context);
              return GetXpnResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
      LIST_XPN_HOSTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>() {
            @Override
            public ApiFuture<ListXpnHostsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> callable,
                ListXpnHostsProjectsRequest request,
                ApiCallContext context,
                ApiFuture<XpnHostList> futureResponse) {
              PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> pageContext =
                  PageContext.create(callable, LIST_XPN_HOSTS_PAGE_STR_DESC, request, context);
              return ListXpnHostsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to disableXpnHost. */
  public UnaryCallSettings<DisableXpnHostProjectRequest, Operation> disableXpnHostSettings() {
    return disableXpnHostSettings;
  }

  /** Returns the object with the settings used for calls to disableXpnHost. */
  public OperationCallSettings<DisableXpnHostProjectRequest, Operation, Operation>
      disableXpnHostOperationSettings() {
    return disableXpnHostOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableXpnResource. */
  public UnaryCallSettings<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceSettings() {
    return disableXpnResourceSettings;
  }

  /** Returns the object with the settings used for calls to disableXpnResource. */
  public OperationCallSettings<DisableXpnResourceProjectRequest, Operation, Operation>
      disableXpnResourceOperationSettings() {
    return disableXpnResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableXpnHost. */
  public UnaryCallSettings<EnableXpnHostProjectRequest, Operation> enableXpnHostSettings() {
    return enableXpnHostSettings;
  }

  /** Returns the object with the settings used for calls to enableXpnHost. */
  public OperationCallSettings<EnableXpnHostProjectRequest, Operation, Operation>
      enableXpnHostOperationSettings() {
    return enableXpnHostOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableXpnResource. */
  public UnaryCallSettings<EnableXpnResourceProjectRequest, Operation> enableXpnResourceSettings() {
    return enableXpnResourceSettings;
  }

  /** Returns the object with the settings used for calls to enableXpnResource. */
  public OperationCallSettings<EnableXpnResourceProjectRequest, Operation, Operation>
      enableXpnResourceOperationSettings() {
    return enableXpnResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetProjectRequest, Project> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getXpnHost. */
  public UnaryCallSettings<GetXpnHostProjectRequest, Project> getXpnHostSettings() {
    return getXpnHostSettings;
  }

  /** Returns the object with the settings used for calls to getXpnResources. */
  public PagedCallSettings<
          GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
      getXpnResourcesSettings() {
    return getXpnResourcesSettings;
  }

  /** Returns the object with the settings used for calls to listXpnHosts. */
  public PagedCallSettings<ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
      listXpnHostsSettings() {
    return listXpnHostsSettings;
  }

  /** Returns the object with the settings used for calls to moveDisk. */
  public UnaryCallSettings<MoveDiskProjectRequest, Operation> moveDiskSettings() {
    return moveDiskSettings;
  }

  /** Returns the object with the settings used for calls to moveDisk. */
  public OperationCallSettings<MoveDiskProjectRequest, Operation, Operation>
      moveDiskOperationSettings() {
    return moveDiskOperationSettings;
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public UnaryCallSettings<MoveInstanceProjectRequest, Operation> moveInstanceSettings() {
    return moveInstanceSettings;
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public OperationCallSettings<MoveInstanceProjectRequest, Operation, Operation>
      moveInstanceOperationSettings() {
    return moveInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to setCommonInstanceMetadata. */
  public UnaryCallSettings<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataSettings() {
    return setCommonInstanceMetadataSettings;
  }

  /** Returns the object with the settings used for calls to setCommonInstanceMetadata. */
  public OperationCallSettings<SetCommonInstanceMetadataProjectRequest, Operation, Operation>
      setCommonInstanceMetadataOperationSettings() {
    return setCommonInstanceMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to setDefaultNetworkTier. */
  public UnaryCallSettings<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierSettings() {
    return setDefaultNetworkTierSettings;
  }

  /** Returns the object with the settings used for calls to setDefaultNetworkTier. */
  public OperationCallSettings<SetDefaultNetworkTierProjectRequest, Operation, Operation>
      setDefaultNetworkTierOperationSettings() {
    return setDefaultNetworkTierOperationSettings;
  }

  /** Returns the object with the settings used for calls to setUsageExportBucket. */
  public UnaryCallSettings<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketSettings() {
    return setUsageExportBucketSettings;
  }

  /** Returns the object with the settings used for calls to setUsageExportBucket. */
  public OperationCallSettings<SetUsageExportBucketProjectRequest, Operation, Operation>
      setUsageExportBucketOperationSettings() {
    return setUsageExportBucketOperationSettings;
  }

  public ProjectsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonProjectsStub.create(this);
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
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ProjectsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected ProjectsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    disableXpnHostSettings = settingsBuilder.disableXpnHostSettings().build();
    disableXpnHostOperationSettings = settingsBuilder.disableXpnHostOperationSettings().build();
    disableXpnResourceSettings = settingsBuilder.disableXpnResourceSettings().build();
    disableXpnResourceOperationSettings =
        settingsBuilder.disableXpnResourceOperationSettings().build();
    enableXpnHostSettings = settingsBuilder.enableXpnHostSettings().build();
    enableXpnHostOperationSettings = settingsBuilder.enableXpnHostOperationSettings().build();
    enableXpnResourceSettings = settingsBuilder.enableXpnResourceSettings().build();
    enableXpnResourceOperationSettings =
        settingsBuilder.enableXpnResourceOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getXpnHostSettings = settingsBuilder.getXpnHostSettings().build();
    getXpnResourcesSettings = settingsBuilder.getXpnResourcesSettings().build();
    listXpnHostsSettings = settingsBuilder.listXpnHostsSettings().build();
    moveDiskSettings = settingsBuilder.moveDiskSettings().build();
    moveDiskOperationSettings = settingsBuilder.moveDiskOperationSettings().build();
    moveInstanceSettings = settingsBuilder.moveInstanceSettings().build();
    moveInstanceOperationSettings = settingsBuilder.moveInstanceOperationSettings().build();
    setCommonInstanceMetadataSettings = settingsBuilder.setCommonInstanceMetadataSettings().build();
    setCommonInstanceMetadataOperationSettings =
        settingsBuilder.setCommonInstanceMetadataOperationSettings().build();
    setDefaultNetworkTierSettings = settingsBuilder.setDefaultNetworkTierSettings().build();
    setDefaultNetworkTierOperationSettings =
        settingsBuilder.setDefaultNetworkTierOperationSettings().build();
    setUsageExportBucketSettings = settingsBuilder.setUsageExportBucketSettings().build();
    setUsageExportBucketOperationSettings =
        settingsBuilder.setUsageExportBucketOperationSettings().build();
  }

  /** Builder for ProjectsStubSettings. */
  public static class Builder extends StubSettings.Builder<ProjectsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<DisableXpnHostProjectRequest, Operation>
        disableXpnHostSettings;
    private final OperationCallSettings.Builder<DisableXpnHostProjectRequest, Operation, Operation>
        disableXpnHostOperationSettings;
    private final UnaryCallSettings.Builder<DisableXpnResourceProjectRequest, Operation>
        disableXpnResourceSettings;
    private final OperationCallSettings.Builder<
            DisableXpnResourceProjectRequest, Operation, Operation>
        disableXpnResourceOperationSettings;
    private final UnaryCallSettings.Builder<EnableXpnHostProjectRequest, Operation>
        enableXpnHostSettings;
    private final OperationCallSettings.Builder<EnableXpnHostProjectRequest, Operation, Operation>
        enableXpnHostOperationSettings;
    private final UnaryCallSettings.Builder<EnableXpnResourceProjectRequest, Operation>
        enableXpnResourceSettings;
    private final OperationCallSettings.Builder<
            EnableXpnResourceProjectRequest, Operation, Operation>
        enableXpnResourceOperationSettings;
    private final UnaryCallSettings.Builder<GetProjectRequest, Project> getSettings;
    private final UnaryCallSettings.Builder<GetXpnHostProjectRequest, Project> getXpnHostSettings;
    private final PagedCallSettings.Builder<
            GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
        getXpnResourcesSettings;
    private final PagedCallSettings.Builder<
            ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
        listXpnHostsSettings;
    private final UnaryCallSettings.Builder<MoveDiskProjectRequest, Operation> moveDiskSettings;
    private final OperationCallSettings.Builder<MoveDiskProjectRequest, Operation, Operation>
        moveDiskOperationSettings;
    private final UnaryCallSettings.Builder<MoveInstanceProjectRequest, Operation>
        moveInstanceSettings;
    private final OperationCallSettings.Builder<MoveInstanceProjectRequest, Operation, Operation>
        moveInstanceOperationSettings;
    private final UnaryCallSettings.Builder<SetCommonInstanceMetadataProjectRequest, Operation>
        setCommonInstanceMetadataSettings;
    private final OperationCallSettings.Builder<
            SetCommonInstanceMetadataProjectRequest, Operation, Operation>
        setCommonInstanceMetadataOperationSettings;
    private final UnaryCallSettings.Builder<SetDefaultNetworkTierProjectRequest, Operation>
        setDefaultNetworkTierSettings;
    private final OperationCallSettings.Builder<
            SetDefaultNetworkTierProjectRequest, Operation, Operation>
        setDefaultNetworkTierOperationSettings;
    private final UnaryCallSettings.Builder<SetUsageExportBucketProjectRequest, Operation>
        setUsageExportBucketSettings;
    private final OperationCallSettings.Builder<
            SetUsageExportBucketProjectRequest, Operation, Operation>
        setUsageExportBucketOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      disableXpnHostSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableXpnHostOperationSettings = OperationCallSettings.newBuilder();
      disableXpnResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableXpnResourceOperationSettings = OperationCallSettings.newBuilder();
      enableXpnHostSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableXpnHostOperationSettings = OperationCallSettings.newBuilder();
      enableXpnResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableXpnResourceOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getXpnHostSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getXpnResourcesSettings = PagedCallSettings.newBuilder(GET_XPN_RESOURCES_PAGE_STR_FACT);
      listXpnHostsSettings = PagedCallSettings.newBuilder(LIST_XPN_HOSTS_PAGE_STR_FACT);
      moveDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveDiskOperationSettings = OperationCallSettings.newBuilder();
      moveInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveInstanceOperationSettings = OperationCallSettings.newBuilder();
      setCommonInstanceMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setCommonInstanceMetadataOperationSettings = OperationCallSettings.newBuilder();
      setDefaultNetworkTierSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDefaultNetworkTierOperationSettings = OperationCallSettings.newBuilder();
      setUsageExportBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setUsageExportBucketOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              disableXpnHostSettings,
              disableXpnResourceSettings,
              enableXpnHostSettings,
              enableXpnResourceSettings,
              getSettings,
              getXpnHostSettings,
              getXpnResourcesSettings,
              listXpnHostsSettings,
              moveDiskSettings,
              moveInstanceSettings,
              setCommonInstanceMetadataSettings,
              setDefaultNetworkTierSettings,
              setUsageExportBucketSettings);
      initDefaults(this);
    }

    protected Builder(ProjectsStubSettings settings) {
      super(settings);

      disableXpnHostSettings = settings.disableXpnHostSettings.toBuilder();
      disableXpnHostOperationSettings = settings.disableXpnHostOperationSettings.toBuilder();
      disableXpnResourceSettings = settings.disableXpnResourceSettings.toBuilder();
      disableXpnResourceOperationSettings =
          settings.disableXpnResourceOperationSettings.toBuilder();
      enableXpnHostSettings = settings.enableXpnHostSettings.toBuilder();
      enableXpnHostOperationSettings = settings.enableXpnHostOperationSettings.toBuilder();
      enableXpnResourceSettings = settings.enableXpnResourceSettings.toBuilder();
      enableXpnResourceOperationSettings = settings.enableXpnResourceOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getXpnHostSettings = settings.getXpnHostSettings.toBuilder();
      getXpnResourcesSettings = settings.getXpnResourcesSettings.toBuilder();
      listXpnHostsSettings = settings.listXpnHostsSettings.toBuilder();
      moveDiskSettings = settings.moveDiskSettings.toBuilder();
      moveDiskOperationSettings = settings.moveDiskOperationSettings.toBuilder();
      moveInstanceSettings = settings.moveInstanceSettings.toBuilder();
      moveInstanceOperationSettings = settings.moveInstanceOperationSettings.toBuilder();
      setCommonInstanceMetadataSettings = settings.setCommonInstanceMetadataSettings.toBuilder();
      setCommonInstanceMetadataOperationSettings =
          settings.setCommonInstanceMetadataOperationSettings.toBuilder();
      setDefaultNetworkTierSettings = settings.setDefaultNetworkTierSettings.toBuilder();
      setDefaultNetworkTierOperationSettings =
          settings.setDefaultNetworkTierOperationSettings.toBuilder();
      setUsageExportBucketSettings = settings.setUsageExportBucketSettings.toBuilder();
      setUsageExportBucketOperationSettings =
          settings.setUsageExportBucketOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              disableXpnHostSettings,
              disableXpnResourceSettings,
              enableXpnHostSettings,
              enableXpnResourceSettings,
              getSettings,
              getXpnHostSettings,
              getXpnResourcesSettings,
              listXpnHostsSettings,
              moveDiskSettings,
              moveInstanceSettings,
              setCommonInstanceMetadataSettings,
              setDefaultNetworkTierSettings,
              setUsageExportBucketSettings);
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
          .disableXpnHostSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .disableXpnResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .enableXpnHostSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .enableXpnResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getXpnHostSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getXpnResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listXpnHostsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .moveDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .moveInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setCommonInstanceMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setDefaultNetworkTierSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setUsageExportBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .disableXpnHostOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableXpnHostProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .disableXpnResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableXpnResourceProjectRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .enableXpnHostOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableXpnHostProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .enableXpnResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableXpnResourceProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .moveDiskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MoveDiskProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .moveInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MoveInstanceProjectRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setCommonInstanceMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetCommonInstanceMetadataProjectRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setDefaultNetworkTierOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetDefaultNetworkTierProjectRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setUsageExportBucketOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetUsageExportBucketProjectRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to disableXpnHost. */
    public UnaryCallSettings.Builder<DisableXpnHostProjectRequest, Operation>
        disableXpnHostSettings() {
      return disableXpnHostSettings;
    }

    /** Returns the builder for the settings used for calls to disableXpnHost. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DisableXpnHostProjectRequest, Operation, Operation>
        disableXpnHostOperationSettings() {
      return disableXpnHostOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableXpnResource. */
    public UnaryCallSettings.Builder<DisableXpnResourceProjectRequest, Operation>
        disableXpnResourceSettings() {
      return disableXpnResourceSettings;
    }

    /** Returns the builder for the settings used for calls to disableXpnResource. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DisableXpnResourceProjectRequest, Operation, Operation>
        disableXpnResourceOperationSettings() {
      return disableXpnResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableXpnHost. */
    public UnaryCallSettings.Builder<EnableXpnHostProjectRequest, Operation>
        enableXpnHostSettings() {
      return enableXpnHostSettings;
    }

    /** Returns the builder for the settings used for calls to enableXpnHost. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<EnableXpnHostProjectRequest, Operation, Operation>
        enableXpnHostOperationSettings() {
      return enableXpnHostOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableXpnResource. */
    public UnaryCallSettings.Builder<EnableXpnResourceProjectRequest, Operation>
        enableXpnResourceSettings() {
      return enableXpnResourceSettings;
    }

    /** Returns the builder for the settings used for calls to enableXpnResource. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<EnableXpnResourceProjectRequest, Operation, Operation>
        enableXpnResourceOperationSettings() {
      return enableXpnResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetProjectRequest, Project> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getXpnHost. */
    public UnaryCallSettings.Builder<GetXpnHostProjectRequest, Project> getXpnHostSettings() {
      return getXpnHostSettings;
    }

    /** Returns the builder for the settings used for calls to getXpnResources. */
    public PagedCallSettings.Builder<
            GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
        getXpnResourcesSettings() {
      return getXpnResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to listXpnHosts. */
    public PagedCallSettings.Builder<
            ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
        listXpnHostsSettings() {
      return listXpnHostsSettings;
    }

    /** Returns the builder for the settings used for calls to moveDisk. */
    public UnaryCallSettings.Builder<MoveDiskProjectRequest, Operation> moveDiskSettings() {
      return moveDiskSettings;
    }

    /** Returns the builder for the settings used for calls to moveDisk. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<MoveDiskProjectRequest, Operation, Operation>
        moveDiskOperationSettings() {
      return moveDiskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    public UnaryCallSettings.Builder<MoveInstanceProjectRequest, Operation> moveInstanceSettings() {
      return moveInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<MoveInstanceProjectRequest, Operation, Operation>
        moveInstanceOperationSettings() {
      return moveInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setCommonInstanceMetadata. */
    public UnaryCallSettings.Builder<SetCommonInstanceMetadataProjectRequest, Operation>
        setCommonInstanceMetadataSettings() {
      return setCommonInstanceMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to setCommonInstanceMetadata. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetCommonInstanceMetadataProjectRequest, Operation, Operation>
        setCommonInstanceMetadataOperationSettings() {
      return setCommonInstanceMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setDefaultNetworkTier. */
    public UnaryCallSettings.Builder<SetDefaultNetworkTierProjectRequest, Operation>
        setDefaultNetworkTierSettings() {
      return setDefaultNetworkTierSettings;
    }

    /** Returns the builder for the settings used for calls to setDefaultNetworkTier. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetDefaultNetworkTierProjectRequest, Operation, Operation>
        setDefaultNetworkTierOperationSettings() {
      return setDefaultNetworkTierOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setUsageExportBucket. */
    public UnaryCallSettings.Builder<SetUsageExportBucketProjectRequest, Operation>
        setUsageExportBucketSettings() {
      return setUsageExportBucketSettings;
    }

    /** Returns the builder for the settings used for calls to setUsageExportBucket. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetUsageExportBucketProjectRequest, Operation, Operation>
        setUsageExportBucketOperationSettings() {
      return setUsageExportBucketOperationSettings;
    }

    @Override
    public ProjectsStubSettings build() throws IOException {
      return new ProjectsStubSettings(this);
    }
  }
}
