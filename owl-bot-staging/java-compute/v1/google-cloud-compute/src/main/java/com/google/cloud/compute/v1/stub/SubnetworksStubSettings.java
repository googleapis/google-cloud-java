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

import static com.google.cloud.compute.v1.SubnetworksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListUsablePagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSubnetworksRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkRequest;
import com.google.cloud.compute.v1.GetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.GetSubnetworkRequest;
import com.google.cloud.compute.v1.InsertSubnetworkRequest;
import com.google.cloud.compute.v1.ListSubnetworksRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSubnetworkRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.SubnetworksScopedList;
import com.google.cloud.compute.v1.TestIamPermissionsSubnetworkRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UsableSubnetwork;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SubnetworksStub}.
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
 * SubnetworksStubSettings.Builder subnetworksSettingsBuilder =
 *     SubnetworksStubSettings.newBuilder();
 * subnetworksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         subnetworksSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SubnetworksStubSettings subnetworksSettings = subnetworksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SubnetworksStubSettings extends StubSettings<SubnetworksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteSubnetworkRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeSettings;
  private final OperationCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationSettings;
  private final UnaryCallSettings<GetSubnetworkRequest, Subnetwork> getSettings;
  private final UnaryCallSettings<GetIamPolicySubnetworkRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertSubnetworkRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertSubnetworkRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
      listUsableSettings;
  private final UnaryCallSettings<PatchSubnetworkRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchSubnetworkRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetIamPolicySubnetworkRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessSettings;
  private final OperationCallSettings<
          SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationSettings;
  private final UnaryCallSettings<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          AggregatedListSubnetworksRequest,
          SubnetworkAggregatedList,
          Map.Entry<String, SubnetworksScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListSubnetworksRequest,
              SubnetworkAggregatedList,
              Map.Entry<String, SubnetworksScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListSubnetworksRequest injectToken(
                AggregatedListSubnetworksRequest payload, String token) {
              return AggregatedListSubnetworksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListSubnetworksRequest injectPageSize(
                AggregatedListSubnetworksRequest payload, int pageSize) {
              return AggregatedListSubnetworksRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListSubnetworksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SubnetworkAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, SubnetworksScopedList>> extractResources(
                SubnetworkAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, SubnetworksScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListSubnetworksRequest, SubnetworkList, Subnetwork>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubnetworksRequest, SubnetworkList, Subnetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubnetworksRequest injectToken(
                ListSubnetworksRequest payload, String token) {
              return ListSubnetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubnetworksRequest injectPageSize(
                ListSubnetworksRequest payload, int pageSize) {
              return ListSubnetworksRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubnetworksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SubnetworkList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subnetwork> extractResources(SubnetworkList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<Subnetwork>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
      LIST_USABLE_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsableSubnetworksRequest injectToken(
                ListUsableSubnetworksRequest payload, String token) {
              return ListUsableSubnetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUsableSubnetworksRequest injectPageSize(
                ListUsableSubnetworksRequest payload, int pageSize) {
              return ListUsableSubnetworksRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUsableSubnetworksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(UsableSubnetworksAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UsableSubnetwork> extractResources(
                UsableSubnetworksAggregatedList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<UsableSubnetwork>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListSubnetworksRequest,
              SubnetworkAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList> callable,
                AggregatedListSubnetworksRequest request,
                ApiCallContext context,
                ApiFuture<SubnetworkAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListSubnetworksRequest,
                      SubnetworkAggregatedList,
                      Map.Entry<String, SubnetworksScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubnetworksRequest, SubnetworkList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubnetworksRequest, SubnetworkList> callable,
                ListSubnetworksRequest request,
                ApiCallContext context,
                ApiFuture<SubnetworkList> futureResponse) {
              PageContext<ListSubnetworksRequest, SubnetworkList, Subnetwork> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
      LIST_USABLE_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsableSubnetworksRequest,
              UsableSubnetworksAggregatedList,
              ListUsablePagedResponse>() {
            @Override
            public ApiFuture<ListUsablePagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
                    callable,
                ListUsableSubnetworksRequest request,
                ApiCallContext context,
                ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
              PageContext<
                      ListUsableSubnetworksRequest,
                      UsableSubnetworksAggregatedList,
                      UsableSubnetwork>
                  pageContext =
                      PageContext.create(callable, LIST_USABLE_PAGE_STR_DESC, request, context);
              return ListUsablePagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteSubnetworkRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to expandIpCidrRange. */
  public UnaryCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeSettings() {
    return expandIpCidrRangeSettings;
  }

  /** Returns the object with the settings used for calls to expandIpCidrRange. */
  public OperationCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationSettings() {
    return expandIpCidrRangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetSubnetworkRequest, Subnetwork> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicySubnetworkRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertSubnetworkRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertSubnetworkRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listUsable. */
  public PagedCallSettings<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
      listUsableSettings() {
    return listUsableSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchSubnetworkRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchSubnetworkRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicySubnetworkRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccess. */
  public UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessSettings() {
    return setPrivateIpGoogleAccessSettings;
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccess. */
  public OperationCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationSettings() {
    return setPrivateIpGoogleAccessOperationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public SubnetworksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSubnetworksStub.create(this);
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SubnetworksStubSettings.class))
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

  protected SubnetworksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    expandIpCidrRangeSettings = settingsBuilder.expandIpCidrRangeSettings().build();
    expandIpCidrRangeOperationSettings =
        settingsBuilder.expandIpCidrRangeOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listUsableSettings = settingsBuilder.listUsableSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setPrivateIpGoogleAccessSettings = settingsBuilder.setPrivateIpGoogleAccessSettings().build();
    setPrivateIpGoogleAccessOperationSettings =
        settingsBuilder.setPrivateIpGoogleAccessOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for SubnetworksStubSettings. */
  public static class Builder extends StubSettings.Builder<SubnetworksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteSubnetworkRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteSubnetworkRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkRequest, Operation>
        expandIpCidrRangeSettings;
    private final OperationCallSettings.Builder<
            ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
        expandIpCidrRangeOperationSettings;
    private final UnaryCallSettings.Builder<GetSubnetworkRequest, Subnetwork> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicySubnetworkRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertSubnetworkRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertSubnetworkRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
        listUsableSettings;
    private final UnaryCallSettings.Builder<PatchSubnetworkRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchSubnetworkRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicySubnetworkRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
        setPrivateIpGoogleAccessSettings;
    private final OperationCallSettings.Builder<
            SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
        setPrivateIpGoogleAccessOperationSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      expandIpCidrRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      expandIpCidrRangeOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listUsableSettings = PagedCallSettings.newBuilder(LIST_USABLE_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setPrivateIpGoogleAccessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setPrivateIpGoogleAccessOperationSettings = OperationCallSettings.newBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              expandIpCidrRangeSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listUsableSettings,
              patchSettings,
              setIamPolicySettings,
              setPrivateIpGoogleAccessSettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SubnetworksStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      expandIpCidrRangeSettings = settings.expandIpCidrRangeSettings.toBuilder();
      expandIpCidrRangeOperationSettings = settings.expandIpCidrRangeOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listUsableSettings = settings.listUsableSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setPrivateIpGoogleAccessSettings = settings.setPrivateIpGoogleAccessSettings.toBuilder();
      setPrivateIpGoogleAccessOperationSettings =
          settings.setPrivateIpGoogleAccessOperationSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              expandIpCidrRangeSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listUsableSettings,
              patchSettings,
              setIamPolicySettings,
              setPrivateIpGoogleAccessSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .expandIpCidrRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setPrivateIpGoogleAccessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSubnetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .expandIpCidrRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExpandIpCidrRangeSubnetworkRequest, OperationSnapshot>
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
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertSubnetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchSubnetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .setPrivateIpGoogleAccessOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetPrivateIpGoogleAccessSubnetworkRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteSubnetworkRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteSubnetworkRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRange. */
    public UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkRequest, Operation>
        expandIpCidrRangeSettings() {
      return expandIpCidrRangeSettings;
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRange. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
        expandIpCidrRangeOperationSettings() {
      return expandIpCidrRangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetSubnetworkRequest, Subnetwork> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicySubnetworkRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertSubnetworkRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertSubnetworkRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listUsable. */
    public PagedCallSettings.Builder<
            ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
        listUsableSettings() {
      return listUsableSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchSubnetworkRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchSubnetworkRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicySubnetworkRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setPrivateIpGoogleAccess. */
    public UnaryCallSettings.Builder<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
        setPrivateIpGoogleAccessSettings() {
      return setPrivateIpGoogleAccessSettings;
    }

    /** Returns the builder for the settings used for calls to setPrivateIpGoogleAccess. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
        setPrivateIpGoogleAccessOperationSettings() {
      return setPrivateIpGoogleAccessOperationSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public SubnetworksStubSettings build() throws IOException {
      return new SubnetworksStubSettings(this);
    }
  }
}
