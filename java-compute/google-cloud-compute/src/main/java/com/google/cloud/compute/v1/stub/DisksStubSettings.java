/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.DisksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.DisksClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.AggregatedListDisksRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskRequest;
import com.google.cloud.compute.v1.DeleteDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.DisksScopedList;
import com.google.cloud.compute.v1.GetDiskRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.InsertDiskRequest;
import com.google.cloud.compute.v1.ListDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.ResizeDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.SetLabelsDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * Settings class to configure an instance of {@link DisksStub}.
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
 * <p>For example, to set the total timeout of addResourcePolicies to 30 seconds:
 *
 * <pre>{@code
 * DisksStubSettings.Builder disksSettingsBuilder = DisksStubSettings.newBuilder();
 * disksSettingsBuilder
 *     .addResourcePoliciesSettings()
 *     .setRetrySettings(
 *         disksSettingsBuilder
 *             .addResourcePoliciesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DisksStubSettings disksSettings = disksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DisksStubSettings extends StubSettings<DisksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesSettings;
  private final PagedCallSettings<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotSettings;
  private final UnaryCallSettings<DeleteDiskRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetDiskRequest, Disk> getSettings;
  private final UnaryCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertDiskRequest, Operation> insertSettings;
  private final PagedCallSettings<ListDisksRequest, DiskList, ListPagedResponse> listSettings;
  private final UnaryCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesSettings;
  private final UnaryCallSettings<ResizeDiskRequest, Operation> resizeSettings;
  private final UnaryCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetLabelsDiskRequest, Operation> setLabelsSettings;
  private final UnaryCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          AggregatedListDisksRequest, DiskAggregatedList, Map.Entry<String, DisksScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListDisksRequest,
              DiskAggregatedList,
              Map.Entry<String, DisksScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListDisksRequest injectToken(
                AggregatedListDisksRequest payload, String token) {
              return AggregatedListDisksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListDisksRequest injectPageSize(
                AggregatedListDisksRequest payload, int pageSize) {
              return AggregatedListDisksRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(AggregatedListDisksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, DisksScopedList>> extractResources(
                DiskAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, DisksScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListDisksRequest, DiskList, Disk> LIST_PAGE_STR_DESC =
      new PagedListDescriptor<ListDisksRequest, DiskList, Disk>() {
        @Override
        public String emptyToken() {
          return "";
        }

        @Override
        public ListDisksRequest injectToken(ListDisksRequest payload, String token) {
          return ListDisksRequest.newBuilder(payload).setPageToken(token).build();
        }

        @Override
        public ListDisksRequest injectPageSize(ListDisksRequest payload, int pageSize) {
          return ListDisksRequest.newBuilder(payload).setMaxResults(pageSize).build();
        }

        @Override
        public Integer extractPageSize(ListDisksRequest payload) {
          return payload.getMaxResults();
        }

        @Override
        public String extractNextToken(DiskList payload) {
          return payload.getNextPageToken();
        }

        @Override
        public Iterable<Disk> extractResources(DiskList payload) {
          return payload.getItemsList() == null ? ImmutableList.<Disk>of() : payload.getItemsList();
        }
      };

  private static final PagedListResponseFactory<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList> callable,
                AggregatedListDisksRequest request,
                ApiCallContext context,
                ApiFuture<DiskAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListDisksRequest,
                      DiskAggregatedList,
                      Map.Entry<String, DisksScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<ListDisksRequest, DiskList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListDisksRequest, DiskList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDisksRequest, DiskList> callable,
                ListDisksRequest request,
                ApiCallContext context,
                ApiFuture<DiskList> futureResponse) {
              PageContext<ListDisksRequest, DiskList, Disk> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesSettings() {
    return addResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotSettings() {
    return createSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteDiskRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetDiskRequest, Disk> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertDiskRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesSettings() {
    return removeResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeDiskRequest, Operation> resizeSettings() {
    return resizeSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsDiskRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DisksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDisksStub.create(this);
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
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DisksStubSettings.class))
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

  protected DisksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addResourcePoliciesSettings = settingsBuilder.addResourcePoliciesSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    createSnapshotSettings = settingsBuilder.createSnapshotSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    removeResourcePoliciesSettings = settingsBuilder.removeResourcePoliciesSettings().build();
    resizeSettings = settingsBuilder.resizeSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DisksStubSettings. */
  public static class Builder extends StubSettings.Builder<DisksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesSettings;
    private final PagedCallSettings.Builder<
            AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<CreateSnapshotDiskRequest, Operation>
        createSnapshotSettings;
    private final UnaryCallSettings.Builder<DeleteDiskRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<GetDiskRequest, Disk> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyDiskRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertDiskRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<ListDisksRequest, DiskList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesSettings;
    private final UnaryCallSettings.Builder<ResizeDiskRequest, Operation> resizeSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyDiskRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetLabelsDiskRequest, Operation> setLabelsSettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsDiskRequest, TestPermissionsResponse>
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

      addResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      createSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      removeResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesSettings,
              aggregatedListSettings,
              createSnapshotSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              removeResourcePoliciesSettings,
              resizeSettings,
              setIamPolicySettings,
              setLabelsSettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DisksStubSettings settings) {
      super(settings);

      addResourcePoliciesSettings = settings.addResourcePoliciesSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      createSnapshotSettings = settings.createSnapshotSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      removeResourcePoliciesSettings = settings.removeResourcePoliciesSettings.toBuilder();
      resizeSettings = settings.resizeSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesSettings,
              aggregatedListSettings,
              createSnapshotSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              removeResourcePoliciesSettings,
              resizeSettings,
              setIamPolicySettings,
              setLabelsSettings,
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
          .addResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSnapshotSettings()
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
          .removeResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesSettings() {
      return addResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotDiskRequest, Operation>
        createSnapshotSettings() {
      return createSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteDiskRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetDiskRequest, Disk> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertDiskRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesSettings() {
      return removeResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeDiskRequest, Operation> resizeSettings() {
      return resizeSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsDiskRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsDiskRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DisksStubSettings build() throws IOException {
      return new DisksStubSettings(this);
    }
  }
}
