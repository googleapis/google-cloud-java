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

import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AggregatedListNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.CloneRulesNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPoliciesScopedList;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.NetworkFirewallPolicyAggregatedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemovePacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * Settings class to configure an instance of {@link NetworkFirewallPoliciesStub}.
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
 * NetworkFirewallPoliciesStubSettings.Builder networkFirewallPoliciesSettingsBuilder =
 *     NetworkFirewallPoliciesStubSettings.newBuilder();
 * networkFirewallPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networkFirewallPoliciesSettingsBuilder
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
 * NetworkFirewallPoliciesStubSettings networkFirewallPoliciesSettings =
 *     networkFirewallPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for addAssociation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkFirewallPoliciesStubSettings.Builder networkFirewallPoliciesSettingsBuilder =
 *     NetworkFirewallPoliciesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * networkFirewallPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkFirewallPoliciesStubSettings
    extends StubSettings<NetworkFirewallPoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationSettings;
  private final OperationCallSettings<
          AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationSettings;
  private final UnaryCallSettings<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      addPacketMirroringRuleSettings;
  private final OperationCallSettings<
          AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addPacketMirroringRuleOperationSettings;
  private final UnaryCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleSettings;
  private final OperationCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationSettings;
  private final PagedCallSettings<
          AggregatedListNetworkFirewallPoliciesRequest,
          NetworkFirewallPolicyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation>
      cloneRulesSettings;
  private final OperationCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationSettings;
  private final UnaryCallSettings<DeleteNetworkFirewallPolicyRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetNetworkFirewallPolicyRequest, FirewallPolicy> getSettings;
  private final UnaryCallSettings<
          GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationSettings;
  private final UnaryCallSettings<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicySettings;
  private final UnaryCallSettings<
          GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getPacketMirroringRuleSettings;
  private final UnaryCallSettings<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleSettings;
  private final UnaryCallSettings<InsertNetworkFirewallPolicyRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchNetworkFirewallPolicyRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      patchPacketMirroringRuleSettings;
  private final OperationCallSettings<
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchPacketMirroringRuleOperationSettings;
  private final UnaryCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation>
      patchRuleSettings;
  private final OperationCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationSettings;
  private final UnaryCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationSettings;
  private final OperationCallSettings<
          RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings;
  private final UnaryCallSettings<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      removePacketMirroringRuleSettings;
  private final OperationCallSettings<
          RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removePacketMirroringRuleOperationSettings;
  private final UnaryCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation>
      removeRuleSettings;
  private final OperationCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationSettings;
  private final UnaryCallSettings<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicySettings;
  private final UnaryCallSettings<
          TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          AggregatedListNetworkFirewallPoliciesRequest,
          NetworkFirewallPolicyAggregatedList,
          Map.Entry<String, FirewallPoliciesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListNetworkFirewallPoliciesRequest,
              NetworkFirewallPolicyAggregatedList,
              Map.Entry<String, FirewallPoliciesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListNetworkFirewallPoliciesRequest injectToken(
                AggregatedListNetworkFirewallPoliciesRequest payload, String token) {
              return AggregatedListNetworkFirewallPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListNetworkFirewallPoliciesRequest injectPageSize(
                AggregatedListNetworkFirewallPoliciesRequest payload, int pageSize) {
              return AggregatedListNetworkFirewallPoliciesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListNetworkFirewallPoliciesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkFirewallPolicyAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, FirewallPoliciesScopedList>> extractResources(
                NetworkFirewallPolicyAggregatedList payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkFirewallPoliciesRequest injectToken(
                ListNetworkFirewallPoliciesRequest payload, String token) {
              return ListNetworkFirewallPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNetworkFirewallPoliciesRequest injectPageSize(
                ListNetworkFirewallPoliciesRequest payload, int pageSize) {
              return ListNetworkFirewallPoliciesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNetworkFirewallPoliciesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(FirewallPolicyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FirewallPolicy> extractResources(FirewallPolicyList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListNetworkFirewallPoliciesRequest,
          NetworkFirewallPolicyAggregatedList,
          AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListNetworkFirewallPoliciesRequest,
              NetworkFirewallPolicyAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListNetworkFirewallPoliciesRequest,
                        NetworkFirewallPolicyAggregatedList>
                    callable,
                AggregatedListNetworkFirewallPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<NetworkFirewallPolicyAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListNetworkFirewallPoliciesRequest,
                      NetworkFirewallPolicyAggregatedList,
                      Map.Entry<String, FirewallPoliciesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworkFirewallPoliciesRequest, FirewallPolicyList> callable,
                ListNetworkFirewallPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<FirewallPolicyList> futureResponse) {
              PageContext<ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addAssociation. */
  public UnaryCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationSettings() {
    return addAssociationSettings;
  }

  /** Returns the object with the settings used for calls to addAssociation. */
  public OperationCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationSettings() {
    return addAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to addPacketMirroringRule. */
  public UnaryCallSettings<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      addPacketMirroringRuleSettings() {
    return addPacketMirroringRuleSettings;
  }

  /** Returns the object with the settings used for calls to addPacketMirroringRule. */
  public OperationCallSettings<
          AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addPacketMirroringRuleOperationSettings() {
    return addPacketMirroringRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleSettings() {
    return addRuleSettings;
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return addRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListNetworkFirewallPoliciesRequest,
          NetworkFirewallPolicyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public UnaryCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation> cloneRulesSettings() {
    return cloneRulesSettings;
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public OperationCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationSettings() {
    return cloneRulesOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkFirewallPolicyRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkFirewallPolicyRequest, FirewallPolicy> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getAssociation. */
  public UnaryCallSettings<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationSettings() {
    return getAssociationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getPacketMirroringRule. */
  public UnaryCallSettings<GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getPacketMirroringRuleSettings() {
    return getPacketMirroringRuleSettings;
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleSettings() {
    return getRuleSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkFirewallPolicyRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNetworkFirewallPolicyRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to patchPacketMirroringRule. */
  public UnaryCallSettings<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      patchPacketMirroringRuleSettings() {
    return patchPacketMirroringRuleSettings;
  }

  /** Returns the object with the settings used for calls to patchPacketMirroringRule. */
  public OperationCallSettings<
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchPacketMirroringRuleOperationSettings() {
    return patchPacketMirroringRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleSettings() {
    return patchRuleSettings;
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return patchRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public UnaryCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationSettings() {
    return removeAssociationSettings;
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public OperationCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings() {
    return removeAssociationOperationSettings;
  }

  /** Returns the object with the settings used for calls to removePacketMirroringRule. */
  public UnaryCallSettings<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      removePacketMirroringRuleSettings() {
    return removePacketMirroringRuleSettings;
  }

  /** Returns the object with the settings used for calls to removePacketMirroringRule. */
  public OperationCallSettings<
          RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removePacketMirroringRuleOperationSettings() {
    return removePacketMirroringRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation> removeRuleSettings() {
    return removeRuleSettings;
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return removeRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public NetworkFirewallPoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworkFirewallPoliciesStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NetworkFirewallPoliciesStubSettings.class))
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

  protected NetworkFirewallPoliciesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addAssociationSettings = settingsBuilder.addAssociationSettings().build();
    addAssociationOperationSettings = settingsBuilder.addAssociationOperationSettings().build();
    addPacketMirroringRuleSettings = settingsBuilder.addPacketMirroringRuleSettings().build();
    addPacketMirroringRuleOperationSettings =
        settingsBuilder.addPacketMirroringRuleOperationSettings().build();
    addRuleSettings = settingsBuilder.addRuleSettings().build();
    addRuleOperationSettings = settingsBuilder.addRuleOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    cloneRulesSettings = settingsBuilder.cloneRulesSettings().build();
    cloneRulesOperationSettings = settingsBuilder.cloneRulesOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getAssociationSettings = settingsBuilder.getAssociationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getPacketMirroringRuleSettings = settingsBuilder.getPacketMirroringRuleSettings().build();
    getRuleSettings = settingsBuilder.getRuleSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    patchPacketMirroringRuleSettings = settingsBuilder.patchPacketMirroringRuleSettings().build();
    patchPacketMirroringRuleOperationSettings =
        settingsBuilder.patchPacketMirroringRuleOperationSettings().build();
    patchRuleSettings = settingsBuilder.patchRuleSettings().build();
    patchRuleOperationSettings = settingsBuilder.patchRuleOperationSettings().build();
    removeAssociationSettings = settingsBuilder.removeAssociationSettings().build();
    removeAssociationOperationSettings =
        settingsBuilder.removeAssociationOperationSettings().build();
    removePacketMirroringRuleSettings = settingsBuilder.removePacketMirroringRuleSettings().build();
    removePacketMirroringRuleOperationSettings =
        settingsBuilder.removePacketMirroringRuleOperationSettings().build();
    removeRuleSettings = settingsBuilder.removeRuleSettings().build();
    removeRuleOperationSettings = settingsBuilder.removeRuleOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for NetworkFirewallPoliciesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<NetworkFirewallPoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddAssociationNetworkFirewallPolicyRequest, Operation>
        addAssociationSettings;
    private final OperationCallSettings.Builder<
            AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        addAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        addPacketMirroringRuleSettings;
    private final OperationCallSettings.Builder<
            AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        addPacketMirroringRuleOperationSettings;
    private final UnaryCallSettings.Builder<AddRuleNetworkFirewallPolicyRequest, Operation>
        addRuleSettings;
    private final OperationCallSettings.Builder<
            AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
        addRuleOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListNetworkFirewallPoliciesRequest,
            NetworkFirewallPolicyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<CloneRulesNetworkFirewallPolicyRequest, Operation>
        cloneRulesSettings;
    private final OperationCallSettings.Builder<
            CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
        cloneRulesOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkFirewallPolicyRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteNetworkFirewallPolicyRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetNetworkFirewallPolicyRequest, FirewallPolicy>
        getSettings;
    private final UnaryCallSettings.Builder<
            GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<
            GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getPacketMirroringRuleSettings;
    private final UnaryCallSettings.Builder<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleSettings;
    private final UnaryCallSettings.Builder<InsertNetworkFirewallPolicyRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertNetworkFirewallPolicyRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchNetworkFirewallPolicyRequest, Operation>
        patchSettings;
    private final OperationCallSettings.Builder<
            PatchNetworkFirewallPolicyRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<
            PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        patchPacketMirroringRuleSettings;
    private final OperationCallSettings.Builder<
            PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        patchPacketMirroringRuleOperationSettings;
    private final UnaryCallSettings.Builder<PatchRuleNetworkFirewallPolicyRequest, Operation>
        patchRuleSettings;
    private final OperationCallSettings.Builder<
            PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
        patchRuleOperationSettings;
    private final UnaryCallSettings.Builder<
            RemoveAssociationNetworkFirewallPolicyRequest, Operation>
        removeAssociationSettings;
    private final OperationCallSettings.Builder<
            RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings;
    private final UnaryCallSettings.Builder<
            RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        removePacketMirroringRuleSettings;
    private final OperationCallSettings.Builder<
            RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        removePacketMirroringRuleOperationSettings;
    private final UnaryCallSettings.Builder<RemoveRuleNetworkFirewallPolicyRequest, Operation>
        removeRuleSettings;
    private final OperationCallSettings.Builder<
            RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
        removeRuleOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
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

      addAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addAssociationOperationSettings = OperationCallSettings.newBuilder();
      addPacketMirroringRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addPacketMirroringRuleOperationSettings = OperationCallSettings.newBuilder();
      addRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addRuleOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      cloneRulesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cloneRulesOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPacketMirroringRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      patchPacketMirroringRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchPacketMirroringRuleOperationSettings = OperationCallSettings.newBuilder();
      patchRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchRuleOperationSettings = OperationCallSettings.newBuilder();
      removeAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeAssociationOperationSettings = OperationCallSettings.newBuilder();
      removePacketMirroringRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removePacketMirroringRuleOperationSettings = OperationCallSettings.newBuilder();
      removeRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeRuleOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addAssociationSettings,
              addPacketMirroringRuleSettings,
              addRuleSettings,
              aggregatedListSettings,
              cloneRulesSettings,
              deleteSettings,
              getSettings,
              getAssociationSettings,
              getIamPolicySettings,
              getPacketMirroringRuleSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              patchSettings,
              patchPacketMirroringRuleSettings,
              patchRuleSettings,
              removeAssociationSettings,
              removePacketMirroringRuleSettings,
              removeRuleSettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NetworkFirewallPoliciesStubSettings settings) {
      super(settings);

      addAssociationSettings = settings.addAssociationSettings.toBuilder();
      addAssociationOperationSettings = settings.addAssociationOperationSettings.toBuilder();
      addPacketMirroringRuleSettings = settings.addPacketMirroringRuleSettings.toBuilder();
      addPacketMirroringRuleOperationSettings =
          settings.addPacketMirroringRuleOperationSettings.toBuilder();
      addRuleSettings = settings.addRuleSettings.toBuilder();
      addRuleOperationSettings = settings.addRuleOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      cloneRulesSettings = settings.cloneRulesSettings.toBuilder();
      cloneRulesOperationSettings = settings.cloneRulesOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getAssociationSettings = settings.getAssociationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getPacketMirroringRuleSettings = settings.getPacketMirroringRuleSettings.toBuilder();
      getRuleSettings = settings.getRuleSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      patchPacketMirroringRuleSettings = settings.patchPacketMirroringRuleSettings.toBuilder();
      patchPacketMirroringRuleOperationSettings =
          settings.patchPacketMirroringRuleOperationSettings.toBuilder();
      patchRuleSettings = settings.patchRuleSettings.toBuilder();
      patchRuleOperationSettings = settings.patchRuleOperationSettings.toBuilder();
      removeAssociationSettings = settings.removeAssociationSettings.toBuilder();
      removeAssociationOperationSettings = settings.removeAssociationOperationSettings.toBuilder();
      removePacketMirroringRuleSettings = settings.removePacketMirroringRuleSettings.toBuilder();
      removePacketMirroringRuleOperationSettings =
          settings.removePacketMirroringRuleOperationSettings.toBuilder();
      removeRuleSettings = settings.removeRuleSettings.toBuilder();
      removeRuleOperationSettings = settings.removeRuleOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addAssociationSettings,
              addPacketMirroringRuleSettings,
              addRuleSettings,
              aggregatedListSettings,
              cloneRulesSettings,
              deleteSettings,
              getSettings,
              getAssociationSettings,
              getIamPolicySettings,
              getPacketMirroringRuleSettings,
              getRuleSettings,
              insertSettings,
              listSettings,
              patchSettings,
              patchPacketMirroringRuleSettings,
              patchRuleSettings,
              removeAssociationSettings,
              removePacketMirroringRuleSettings,
              removeRuleSettings,
              setIamPolicySettings,
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
          .addAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addPacketMirroringRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cloneRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPacketMirroringRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRuleSettings()
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
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .patchPacketMirroringRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .patchRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removePacketMirroringRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddAssociationNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .addPacketMirroringRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddPacketMirroringRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .addRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .cloneRulesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CloneRulesNetworkFirewallPolicyRequest, OperationSnapshot>
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
                  .<DeleteNetworkFirewallPolicyRequest, OperationSnapshot>
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
                  .<InsertNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .patchPacketMirroringRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .patchRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .removeAssociationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveAssociationNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .removePacketMirroringRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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
          .removeRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveRuleNetworkFirewallPolicyRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to addAssociation. */
    public UnaryCallSettings.Builder<AddAssociationNetworkFirewallPolicyRequest, Operation>
        addAssociationSettings() {
      return addAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to addAssociation. */
    public OperationCallSettings.Builder<
            AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        addAssociationOperationSettings() {
      return addAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addPacketMirroringRule. */
    public UnaryCallSettings.Builder<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        addPacketMirroringRuleSettings() {
      return addPacketMirroringRuleSettings;
    }

    /** Returns the builder for the settings used for calls to addPacketMirroringRule. */
    public OperationCallSettings.Builder<
            AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        addPacketMirroringRuleOperationSettings() {
      return addPacketMirroringRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleNetworkFirewallPolicyRequest, Operation>
        addRuleSettings() {
      return addRuleSettings;
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return addRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListNetworkFirewallPoliciesRequest,
            NetworkFirewallPolicyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public UnaryCallSettings.Builder<CloneRulesNetworkFirewallPolicyRequest, Operation>
        cloneRulesSettings() {
      return cloneRulesSettings;
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public OperationCallSettings.Builder<
            CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
        cloneRulesOperationSettings() {
      return cloneRulesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkFirewallPolicyRequest, Operation>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkFirewallPolicyRequest, FirewallPolicy>
        getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getAssociation. */
    public UnaryCallSettings.Builder<
            GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationSettings() {
      return getAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
        getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getPacketMirroringRule. */
    public UnaryCallSettings.Builder<
            GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getPacketMirroringRuleSettings() {
      return getPacketMirroringRuleSettings;
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleSettings() {
      return getRuleSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkFirewallPolicyRequest, Operation>
        insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertNetworkFirewallPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNetworkFirewallPolicyRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchNetworkFirewallPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to patchPacketMirroringRule. */
    public UnaryCallSettings.Builder<
            PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        patchPacketMirroringRuleSettings() {
      return patchPacketMirroringRuleSettings;
    }

    /** Returns the builder for the settings used for calls to patchPacketMirroringRule. */
    public OperationCallSettings.Builder<
            PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        patchPacketMirroringRuleOperationSettings() {
      return patchPacketMirroringRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleNetworkFirewallPolicyRequest, Operation>
        patchRuleSettings() {
      return patchRuleSettings;
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<
            PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return patchRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public UnaryCallSettings.Builder<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
        removeAssociationSettings() {
      return removeAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public OperationCallSettings.Builder<
            RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings() {
      return removeAssociationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removePacketMirroringRule. */
    public UnaryCallSettings.Builder<
            RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        removePacketMirroringRuleSettings() {
      return removePacketMirroringRuleSettings;
    }

    /** Returns the builder for the settings used for calls to removePacketMirroringRule. */
    public OperationCallSettings.Builder<
            RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
        removePacketMirroringRuleOperationSettings() {
      return removePacketMirroringRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleNetworkFirewallPolicyRequest, Operation>
        removeRuleSettings() {
      return removeRuleSettings;
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return removeRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
        setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public NetworkFirewallPoliciesStubSettings build() throws IOException {
      return new NetworkFirewallPoliciesStubSettings(this);
    }
  }
}
