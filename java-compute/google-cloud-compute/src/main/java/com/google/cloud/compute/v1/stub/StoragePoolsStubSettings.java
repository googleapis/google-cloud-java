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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.StoragePoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.StoragePoolsClient.ListDisksPagedResponse;
import static com.google.cloud.compute.v1.StoragePoolsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.cloud.compute.v1.AggregatedListStoragePoolsRequest;
import com.google.cloud.compute.v1.DeleteStoragePoolRequest;
import com.google.cloud.compute.v1.GetIamPolicyStoragePoolRequest;
import com.google.cloud.compute.v1.GetStoragePoolRequest;
import com.google.cloud.compute.v1.InsertStoragePoolRequest;
import com.google.cloud.compute.v1.ListDisksStoragePoolsRequest;
import com.google.cloud.compute.v1.ListStoragePoolsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyStoragePoolRequest;
import com.google.cloud.compute.v1.StoragePool;
import com.google.cloud.compute.v1.StoragePoolAggregatedList;
import com.google.cloud.compute.v1.StoragePoolDisk;
import com.google.cloud.compute.v1.StoragePoolList;
import com.google.cloud.compute.v1.StoragePoolListDisks;
import com.google.cloud.compute.v1.StoragePoolsScopedList;
import com.google.cloud.compute.v1.TestIamPermissionsStoragePoolRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateStoragePoolRequest;
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
 * Settings class to configure an instance of {@link StoragePoolsStub}.
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
 * StoragePoolsStubSettings.Builder storagePoolsSettingsBuilder =
 *     StoragePoolsStubSettings.newBuilder();
 * storagePoolsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         storagePoolsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StoragePoolsStubSettings storagePoolsSettings = storagePoolsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StoragePoolsStubSettings extends StubSettings<StoragePoolsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListStoragePoolsRequest, StoragePoolAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteStoragePoolRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteStoragePoolRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetStoragePoolRequest, StoragePool> getSettings;
  private final UnaryCallSettings<GetIamPolicyStoragePoolRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertStoragePoolRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertStoragePoolRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>
      listDisksSettings;
  private final UnaryCallSettings<SetIamPolicyStoragePoolRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsStoragePoolRequest, TestPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateStoragePoolRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateStoragePoolRequest, Operation, Operation>
      updateOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListStoragePoolsRequest,
          StoragePoolAggregatedList,
          Map.Entry<String, StoragePoolsScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListStoragePoolsRequest,
              StoragePoolAggregatedList,
              Map.Entry<String, StoragePoolsScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListStoragePoolsRequest injectToken(
                AggregatedListStoragePoolsRequest payload, String token) {
              return AggregatedListStoragePoolsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListStoragePoolsRequest injectPageSize(
                AggregatedListStoragePoolsRequest payload, int pageSize) {
              return AggregatedListStoragePoolsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListStoragePoolsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(StoragePoolAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, StoragePoolsScopedList>> extractResources(
                StoragePoolAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, StoragePoolsScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListStoragePoolsRequest, StoragePoolList, StoragePool>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListStoragePoolsRequest, StoragePoolList, StoragePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStoragePoolsRequest injectToken(
                ListStoragePoolsRequest payload, String token) {
              return ListStoragePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStoragePoolsRequest injectPageSize(
                ListStoragePoolsRequest payload, int pageSize) {
              return ListStoragePoolsRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStoragePoolsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(StoragePoolList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StoragePool> extractResources(StoragePoolList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<StoragePool>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListDisksStoragePoolsRequest, StoragePoolListDisks, StoragePoolDisk>
      LIST_DISKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDisksStoragePoolsRequest, StoragePoolListDisks, StoragePoolDisk>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDisksStoragePoolsRequest injectToken(
                ListDisksStoragePoolsRequest payload, String token) {
              return ListDisksStoragePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDisksStoragePoolsRequest injectPageSize(
                ListDisksStoragePoolsRequest payload, int pageSize) {
              return ListDisksStoragePoolsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDisksStoragePoolsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(StoragePoolListDisks payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StoragePoolDisk> extractResources(StoragePoolListDisks payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<StoragePoolDisk>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListStoragePoolsRequest, StoragePoolAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListStoragePoolsRequest,
              StoragePoolAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListStoragePoolsRequest, StoragePoolAggregatedList>
                    callable,
                AggregatedListStoragePoolsRequest request,
                ApiCallContext context,
                ApiFuture<StoragePoolAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListStoragePoolsRequest,
                      StoragePoolAggregatedList,
                      Map.Entry<String, StoragePoolsScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStoragePoolsRequest, StoragePoolList> callable,
                ListStoragePoolsRequest request,
                ApiCallContext context,
                ApiFuture<StoragePoolList> futureResponse) {
              PageContext<ListStoragePoolsRequest, StoragePoolList, StoragePool> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>
      LIST_DISKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>() {
            @Override
            public ApiFuture<ListDisksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDisksStoragePoolsRequest, StoragePoolListDisks> callable,
                ListDisksStoragePoolsRequest request,
                ApiCallContext context,
                ApiFuture<StoragePoolListDisks> futureResponse) {
              PageContext<ListDisksStoragePoolsRequest, StoragePoolListDisks, StoragePoolDisk>
                  pageContext =
                      PageContext.create(callable, LIST_DISKS_PAGE_STR_DESC, request, context);
              return ListDisksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListStoragePoolsRequest, StoragePoolAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteStoragePoolRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteStoragePoolRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetStoragePoolRequest, StoragePool> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyStoragePoolRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertStoragePoolRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertStoragePoolRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listDisks. */
  public PagedCallSettings<
          ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>
      listDisksSettings() {
    return listDisksSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyStoragePoolRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsStoragePoolRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateStoragePoolRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateStoragePoolRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  public StoragePoolsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStoragePoolsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(StoragePoolsStubSettings.class))
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

  protected StoragePoolsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listDisksSettings = settingsBuilder.listDisksSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
  }

  /** Builder for StoragePoolsStubSettings. */
  public static class Builder extends StubSettings.Builder<StoragePoolsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListStoragePoolsRequest,
            StoragePoolAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteStoragePoolRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteStoragePoolRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetStoragePoolRequest, StoragePool> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyStoragePoolRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertStoragePoolRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertStoragePoolRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>
        listDisksSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyStoragePoolRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsStoragePoolRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateStoragePoolRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateStoragePoolRequest, Operation, Operation>
        updateOperationSettings;
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
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listDisksSettings = PagedCallSettings.newBuilder(LIST_DISKS_PAGE_STR_FACT);
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listDisksSettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(StoragePoolsStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listDisksSettings = settings.listDisksSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              listDisksSettings,
              setIamPolicySettings,
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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
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
          .listDisksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
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
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                  .<InsertStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
            AggregatedListStoragePoolsRequest,
            StoragePoolAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteStoragePoolRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteStoragePoolRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetStoragePoolRequest, StoragePool> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyStoragePoolRequest, Policy>
        getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertStoragePoolRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertStoragePoolRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListStoragePoolsRequest, StoragePoolList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listDisks. */
    public PagedCallSettings.Builder<
            ListDisksStoragePoolsRequest, StoragePoolListDisks, ListDisksPagedResponse>
        listDisksSettings() {
      return listDisksSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyStoragePoolRequest, Policy>
        setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsStoragePoolRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateStoragePoolRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateStoragePoolRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    @Override
    public StoragePoolsStubSettings build() throws IOException {
      return new StoragePoolsStubSettings(this);
    }
  }
}
