/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.compute.v1.BackendServicesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListUsablePagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.BackendServiceListUsable;
import com.google.cloud.compute.v1.BackendServicesScopedList;
import com.google.cloud.compute.v1.DeleteBackendServiceRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.GetBackendServiceRequest;
import com.google.cloud.compute.v1.GetEffectiveSecurityPoliciesBackendServiceRequest;
import com.google.cloud.compute.v1.GetEffectiveSecurityPoliciesBackendServiceResponse;
import com.google.cloud.compute.v1.GetHealthBackendServiceRequest;
import com.google.cloud.compute.v1.GetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.InsertBackendServiceRequest;
import com.google.cloud.compute.v1.ListBackendServicesRequest;
import com.google.cloud.compute.v1.ListUsableBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendServiceRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsBackendServiceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateBackendServiceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackendServicesStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackendServicesStubSettings.Builder backendServicesSettingsBuilder =
 *     BackendServicesStubSettings.newBuilder();
 * backendServicesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         backendServicesSettingsBuilder
 *             .getSettings()
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
 * BackendServicesStubSettings backendServicesSettings = backendServicesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for addSignedUrlKey:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackendServicesStubSettings.Builder backendServicesSettingsBuilder =
 *     BackendServicesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * backendServicesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackendServicesStubSettings extends StubSettings<BackendServicesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeySettings;
  private final OperationCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationSettings;
  private final PagedCallSettings<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteBackendServiceRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeySettings;
  private final OperationCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationSettings;
  private final UnaryCallSettings<GetBackendServiceRequest, BackendService> getSettings;
  private final UnaryCallSettings<
          GetEffectiveSecurityPoliciesBackendServiceRequest,
          GetEffectiveSecurityPoliciesBackendServiceResponse>
      getEffectiveSecurityPoliciesSettings;
  private final UnaryCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthSettings;
  private final UnaryCallSettings<GetIamPolicyBackendServiceRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertBackendServiceRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertBackendServiceRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListUsableBackendServicesRequest, BackendServiceListUsable, ListUsablePagedResponse>
      listUsableSettings;
  private final UnaryCallSettings<PatchBackendServiceRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchBackendServiceRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicySettings;
  private final OperationCallSettings<
          SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationSettings;
  private final UnaryCallSettings<SetIamPolicyBackendServiceRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicySettings;
  private final OperationCallSettings<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationSettings;
  private final UnaryCallSettings<TestIamPermissionsBackendServiceRequest, TestPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateBackendServiceRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateBackendServiceRequest, Operation, Operation>
      updateOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Map.Entry<String, BackendServicesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListBackendServicesRequest,
              BackendServiceAggregatedList,
              Map.Entry<String, BackendServicesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListBackendServicesRequest injectToken(
                AggregatedListBackendServicesRequest payload, String token) {
              return AggregatedListBackendServicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListBackendServicesRequest injectPageSize(
                AggregatedListBackendServicesRequest payload, int pageSize) {
              return AggregatedListBackendServicesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListBackendServicesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, BackendServicesScopedList>> extractResources(
                BackendServiceAggregatedList payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListBackendServicesRequest, BackendServiceList, BackendService>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackendServicesRequest, BackendServiceList, BackendService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackendServicesRequest injectToken(
                ListBackendServicesRequest payload, String token) {
              return ListBackendServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackendServicesRequest injectPageSize(
                ListBackendServicesRequest payload, int pageSize) {
              return ListBackendServicesRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackendServicesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendService> extractResources(BackendServiceList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListUsableBackendServicesRequest, BackendServiceListUsable, BackendService>
      LIST_USABLE_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUsableBackendServicesRequest, BackendServiceListUsable, BackendService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsableBackendServicesRequest injectToken(
                ListUsableBackendServicesRequest payload, String token) {
              return ListUsableBackendServicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUsableBackendServicesRequest injectPageSize(
                ListUsableBackendServicesRequest payload, int pageSize) {
              return ListUsableBackendServicesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUsableBackendServicesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceListUsable payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendService> extractResources(BackendServiceListUsable payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListBackendServicesRequest,
              BackendServiceAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
                    callable,
                AggregatedListBackendServicesRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListBackendServicesRequest,
                      BackendServiceAggregatedList,
                      Map.Entry<String, BackendServicesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackendServicesRequest, BackendServiceList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackendServicesRequest, BackendServiceList> callable,
                ListBackendServicesRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceList> futureResponse) {
              PageContext<ListBackendServicesRequest, BackendServiceList, BackendService>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsableBackendServicesRequest, BackendServiceListUsable, ListUsablePagedResponse>
      LIST_USABLE_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsableBackendServicesRequest,
              BackendServiceListUsable,
              ListUsablePagedResponse>() {
            @Override
            public ApiFuture<ListUsablePagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsableBackendServicesRequest, BackendServiceListUsable> callable,
                ListUsableBackendServicesRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceListUsable> futureResponse) {
              PageContext<
                      ListUsableBackendServicesRequest, BackendServiceListUsable, BackendService>
                  pageContext =
                      PageContext.create(callable, LIST_USABLE_PAGE_STR_DESC, request, context);
              return ListUsablePagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public UnaryCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeySettings() {
    return addSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public OperationCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationSettings() {
    return addSignedUrlKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteBackendServiceRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public UnaryCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeySettings() {
    return deleteSignedUrlKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public OperationCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationSettings() {
    return deleteSignedUrlKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetBackendServiceRequest, BackendService> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getEffectiveSecurityPolicies. */
  public UnaryCallSettings<
          GetEffectiveSecurityPoliciesBackendServiceRequest,
          GetEffectiveSecurityPoliciesBackendServiceResponse>
      getEffectiveSecurityPoliciesSettings() {
    return getEffectiveSecurityPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getHealth. */
  public UnaryCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthSettings() {
    return getHealthSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyBackendServiceRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertBackendServiceRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertBackendServiceRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listUsable. */
  public PagedCallSettings<
          ListUsableBackendServicesRequest, BackendServiceListUsable, ListUsablePagedResponse>
      listUsableSettings() {
    return listUsableSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchBackendServiceRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchBackendServiceRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public UnaryCallSettings<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicySettings() {
    return setEdgeSecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public OperationCallSettings<SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationSettings() {
    return setEdgeSecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyBackendServiceRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setSecurityPolicy. */
  public UnaryCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicySettings() {
    return setSecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to setSecurityPolicy. */
  public OperationCallSettings<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationSettings() {
    return setSecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsBackendServiceRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateBackendServiceRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateBackendServiceRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  public BackendServicesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBackendServicesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BackendServicesStubSettings.class))
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

  protected BackendServicesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addSignedUrlKeySettings = settingsBuilder.addSignedUrlKeySettings().build();
    addSignedUrlKeyOperationSettings = settingsBuilder.addSignedUrlKeyOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    deleteSignedUrlKeySettings = settingsBuilder.deleteSignedUrlKeySettings().build();
    deleteSignedUrlKeyOperationSettings =
        settingsBuilder.deleteSignedUrlKeyOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getEffectiveSecurityPoliciesSettings =
        settingsBuilder.getEffectiveSecurityPoliciesSettings().build();
    getHealthSettings = settingsBuilder.getHealthSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listUsableSettings = settingsBuilder.listUsableSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setEdgeSecurityPolicySettings = settingsBuilder.setEdgeSecurityPolicySettings().build();
    setEdgeSecurityPolicyOperationSettings =
        settingsBuilder.setEdgeSecurityPolicyOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setSecurityPolicySettings = settingsBuilder.setSecurityPolicySettings().build();
    setSecurityPolicyOperationSettings =
        settingsBuilder.setSecurityPolicyOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
  }

  /** Builder for BackendServicesStubSettings. */
  public static class Builder extends StubSettings.Builder<BackendServicesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeySettings;
    private final OperationCallSettings.Builder<
            AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
        addSignedUrlKeyOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListBackendServicesRequest,
            BackendServiceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteBackendServiceRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteBackendServiceRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeySettings;
    private final OperationCallSettings.Builder<
            DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
        deleteSignedUrlKeyOperationSettings;
    private final UnaryCallSettings.Builder<GetBackendServiceRequest, BackendService> getSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveSecurityPoliciesBackendServiceRequest,
            GetEffectiveSecurityPoliciesBackendServiceResponse>
        getEffectiveSecurityPoliciesSettings;
    private final UnaryCallSettings.Builder<
            GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyBackendServiceRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertBackendServiceRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertBackendServiceRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListUsableBackendServicesRequest, BackendServiceListUsable, ListUsablePagedResponse>
        listUsableSettings;
    private final UnaryCallSettings.Builder<PatchBackendServiceRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchBackendServiceRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
        setEdgeSecurityPolicySettings;
    private final OperationCallSettings.Builder<
            SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
        setEdgeSecurityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyBackendServiceRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicySettings;
    private final OperationCallSettings.Builder<
            SetSecurityPolicyBackendServiceRequest, Operation, Operation>
        setSecurityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsBackendServiceRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateBackendServiceRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateBackendServiceRequest, Operation, Operation>
        updateOperationSettings;
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addSignedUrlKeyOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      deleteSignedUrlKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSignedUrlKeyOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEffectiveSecurityPoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHealthSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listUsableSettings = PagedCallSettings.newBuilder(LIST_USABLE_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setEdgeSecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setEdgeSecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              aggregatedListSettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              getEffectiveSecurityPoliciesSettings,
              getHealthSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listUsableSettings,
              patchSettings,
              setEdgeSecurityPolicySettings,
              setIamPolicySettings,
              setSecurityPolicySettings,
              testIamPermissionsSettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(BackendServicesStubSettings settings) {
      super(settings);

      addSignedUrlKeySettings = settings.addSignedUrlKeySettings.toBuilder();
      addSignedUrlKeyOperationSettings = settings.addSignedUrlKeyOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      deleteSignedUrlKeySettings = settings.deleteSignedUrlKeySettings.toBuilder();
      deleteSignedUrlKeyOperationSettings =
          settings.deleteSignedUrlKeyOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getEffectiveSecurityPoliciesSettings =
          settings.getEffectiveSecurityPoliciesSettings.toBuilder();
      getHealthSettings = settings.getHealthSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listUsableSettings = settings.listUsableSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setEdgeSecurityPolicySettings = settings.setEdgeSecurityPolicySettings.toBuilder();
      setEdgeSecurityPolicyOperationSettings =
          settings.setEdgeSecurityPolicyOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setSecurityPolicySettings = settings.setSecurityPolicySettings.toBuilder();
      setSecurityPolicyOperationSettings = settings.setSecurityPolicyOperationSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addSignedUrlKeySettings,
              aggregatedListSettings,
              deleteSettings,
              deleteSignedUrlKeySettings,
              getSettings,
              getEffectiveSecurityPoliciesSettings,
              getHealthSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listUsableSettings,
              patchSettings,
              setEdgeSecurityPolicySettings,
              setIamPolicySettings,
              setSecurityPolicySettings,
              testIamPermissionsSettings,
              updateSettings);
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
          .addSignedUrlKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSignedUrlKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectiveSecurityPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHealthSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUsableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setEdgeSecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setSecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addSignedUrlKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddSignedUrlKeyBackendServiceRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackendServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteSignedUrlKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSignedUrlKeyBackendServiceRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertBackendServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchBackendServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setEdgeSecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetEdgeSecurityPolicyBackendServiceRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setSecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetSecurityPolicyBackendServiceRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackendServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public UnaryCallSettings.Builder<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeySettings() {
      return addSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public OperationCallSettings.Builder<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
        addSignedUrlKeyOperationSettings() {
      return addSignedUrlKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListBackendServicesRequest,
            BackendServiceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteBackendServiceRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteBackendServiceRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeySettings() {
      return deleteSignedUrlKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public OperationCallSettings.Builder<
            DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
        deleteSignedUrlKeyOperationSettings() {
      return deleteSignedUrlKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetBackendServiceRequest, BackendService> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getEffectiveSecurityPolicies. */
    public UnaryCallSettings.Builder<
            GetEffectiveSecurityPoliciesBackendServiceRequest,
            GetEffectiveSecurityPoliciesBackendServiceResponse>
        getEffectiveSecurityPoliciesSettings() {
      return getEffectiveSecurityPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getHealth. */
    public UnaryCallSettings.Builder<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthSettings() {
      return getHealthSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyBackendServiceRequest, Policy>
        getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertBackendServiceRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertBackendServiceRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListBackendServicesRequest, BackendServiceList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listUsable. */
    public PagedCallSettings.Builder<
            ListUsableBackendServicesRequest, BackendServiceListUsable, ListUsablePagedResponse>
        listUsableSettings() {
      return listUsableSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchBackendServiceRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchBackendServiceRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    public UnaryCallSettings.Builder<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
        setEdgeSecurityPolicySettings() {
      return setEdgeSecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    public OperationCallSettings.Builder<
            SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
        setEdgeSecurityPolicyOperationSettings() {
      return setEdgeSecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyBackendServiceRequest, Policy>
        setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setSecurityPolicy. */
    public UnaryCallSettings.Builder<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicySettings() {
      return setSecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setSecurityPolicy. */
    public OperationCallSettings.Builder<
            SetSecurityPolicyBackendServiceRequest, Operation, Operation>
        setSecurityPolicyOperationSettings() {
      return setSecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsBackendServiceRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateBackendServiceRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateBackendServiceRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    @Override
    public BackendServicesStubSettings build() throws IOException {
      return new BackendServicesStubSettings(this);
    }
  }
}
