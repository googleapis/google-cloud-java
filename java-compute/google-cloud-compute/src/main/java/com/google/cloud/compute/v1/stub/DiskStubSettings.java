/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.DiskClient.AggregatedListDisksPagedResponse;
import static com.google.cloud.compute.v1.DiskClient.ListDisksPagedResponse;

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
import com.google.cloud.compute.v1.AddResourcePoliciesDiskHttpRequest;
import com.google.cloud.compute.v1.AggregatedListDisksHttpRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskHttpRequest;
import com.google.cloud.compute.v1.DeleteDiskHttpRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.DisksScopedList;
import com.google.cloud.compute.v1.GetDiskHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskHttpRequest;
import com.google.cloud.compute.v1.InsertDiskHttpRequest;
import com.google.cloud.compute.v1.ListDisksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesDiskHttpRequest;
import com.google.cloud.compute.v1.ResizeDiskHttpRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskHttpRequest;
import com.google.cloud.compute.v1.SetLabelsDiskHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DiskStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of addResourcePoliciesDisk to 30 seconds:
 *
 * <pre>
 * <code>
 * DiskStubSettings.Builder diskSettingsBuilder =
 *     DiskStubSettings.newBuilder();
 * diskSettingsBuilder.addResourcePoliciesDiskSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DiskStubSettings diskSettings = diskSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskStubSettings extends StubSettings<DiskStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<AddResourcePoliciesDiskHttpRequest, Operation>
      addResourcePoliciesDiskSettings;
  private final PagedCallSettings<
          AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
      aggregatedListDisksSettings;
  private final UnaryCallSettings<CreateSnapshotDiskHttpRequest, Operation>
      createSnapshotDiskSettings;
  private final UnaryCallSettings<DeleteDiskHttpRequest, Operation> deleteDiskSettings;
  private final UnaryCallSettings<GetDiskHttpRequest, Disk> getDiskSettings;
  private final UnaryCallSettings<GetIamPolicyDiskHttpRequest, Policy> getIamPolicyDiskSettings;
  private final UnaryCallSettings<InsertDiskHttpRequest, Operation> insertDiskSettings;
  private final PagedCallSettings<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
      listDisksSettings;
  private final UnaryCallSettings<RemoveResourcePoliciesDiskHttpRequest, Operation>
      removeResourcePoliciesDiskSettings;
  private final UnaryCallSettings<ResizeDiskHttpRequest, Operation> resizeDiskSettings;
  private final UnaryCallSettings<SetIamPolicyDiskHttpRequest, Policy> setIamPolicyDiskSettings;
  private final UnaryCallSettings<SetLabelsDiskHttpRequest, Operation> setLabelsDiskSettings;
  private final UnaryCallSettings<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsDiskSettings;

  /** Returns the object with the settings used for calls to addResourcePoliciesDisk. */
  public UnaryCallSettings<AddResourcePoliciesDiskHttpRequest, Operation>
      addResourcePoliciesDiskSettings() {
    return addResourcePoliciesDiskSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedListDisks. */
  public PagedCallSettings<
          AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
      aggregatedListDisksSettings() {
    return aggregatedListDisksSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshotDisk. */
  public UnaryCallSettings<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskSettings() {
    return createSnapshotDiskSettings;
  }

  /** Returns the object with the settings used for calls to deleteDisk. */
  public UnaryCallSettings<DeleteDiskHttpRequest, Operation> deleteDiskSettings() {
    return deleteDiskSettings;
  }

  /** Returns the object with the settings used for calls to getDisk. */
  public UnaryCallSettings<GetDiskHttpRequest, Disk> getDiskSettings() {
    return getDiskSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicyDisk. */
  public UnaryCallSettings<GetIamPolicyDiskHttpRequest, Policy> getIamPolicyDiskSettings() {
    return getIamPolicyDiskSettings;
  }

  /** Returns the object with the settings used for calls to insertDisk. */
  public UnaryCallSettings<InsertDiskHttpRequest, Operation> insertDiskSettings() {
    return insertDiskSettings;
  }

  /** Returns the object with the settings used for calls to listDisks. */
  public PagedCallSettings<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
      listDisksSettings() {
    return listDisksSettings;
  }

  /** Returns the object with the settings used for calls to removeResourcePoliciesDisk. */
  public UnaryCallSettings<RemoveResourcePoliciesDiskHttpRequest, Operation>
      removeResourcePoliciesDiskSettings() {
    return removeResourcePoliciesDiskSettings;
  }

  /** Returns the object with the settings used for calls to resizeDisk. */
  public UnaryCallSettings<ResizeDiskHttpRequest, Operation> resizeDiskSettings() {
    return resizeDiskSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicyDisk. */
  public UnaryCallSettings<SetIamPolicyDiskHttpRequest, Policy> setIamPolicyDiskSettings() {
    return setIamPolicyDiskSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsDisk. */
  public UnaryCallSettings<SetLabelsDiskHttpRequest, Operation> setLabelsDiskSettings() {
    return setLabelsDiskSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsDisk. */
  public UnaryCallSettings<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsDiskSettings() {
    return testIamPermissionsDiskSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DiskStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDiskStub.create(this);
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
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DiskStubSettings.class))
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

  protected DiskStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addResourcePoliciesDiskSettings = settingsBuilder.addResourcePoliciesDiskSettings().build();
    aggregatedListDisksSettings = settingsBuilder.aggregatedListDisksSettings().build();
    createSnapshotDiskSettings = settingsBuilder.createSnapshotDiskSettings().build();
    deleteDiskSettings = settingsBuilder.deleteDiskSettings().build();
    getDiskSettings = settingsBuilder.getDiskSettings().build();
    getIamPolicyDiskSettings = settingsBuilder.getIamPolicyDiskSettings().build();
    insertDiskSettings = settingsBuilder.insertDiskSettings().build();
    listDisksSettings = settingsBuilder.listDisksSettings().build();
    removeResourcePoliciesDiskSettings =
        settingsBuilder.removeResourcePoliciesDiskSettings().build();
    resizeDiskSettings = settingsBuilder.resizeDiskSettings().build();
    setIamPolicyDiskSettings = settingsBuilder.setIamPolicyDiskSettings().build();
    setLabelsDiskSettings = settingsBuilder.setLabelsDiskSettings().build();
    testIamPermissionsDiskSettings = settingsBuilder.testIamPermissionsDiskSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList>
      AGGREGATED_LIST_DISKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListDisksHttpRequest injectToken(
                AggregatedListDisksHttpRequest payload, String token) {
              return AggregatedListDisksHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListDisksHttpRequest injectPageSize(
                AggregatedListDisksHttpRequest payload, int pageSize) {
              return AggregatedListDisksHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListDisksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DisksScopedList> extractResources(DiskAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<DisksScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListDisksHttpRequest, DiskList, Disk>
      LIST_DISKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDisksHttpRequest, DiskList, Disk>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDisksHttpRequest injectToken(ListDisksHttpRequest payload, String token) {
              return ListDisksHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDisksHttpRequest injectPageSize(ListDisksHttpRequest payload, int pageSize) {
              return ListDisksHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDisksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Disk> extractResources(DiskList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Disk>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
      AGGREGATED_LIST_DISKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListDisksHttpRequest,
              DiskAggregatedList,
              AggregatedListDisksPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListDisksPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListDisksHttpRequest, DiskAggregatedList> callable,
                AggregatedListDisksHttpRequest request,
                ApiCallContext context,
                ApiFuture<DiskAggregatedList> futureResponse) {
              PageContext<AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_DISKS_PAGE_STR_DESC, request, context);
              return AggregatedListDisksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
      LIST_DISKS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>() {
            @Override
            public ApiFuture<ListDisksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDisksHttpRequest, DiskList> callable,
                ListDisksHttpRequest request,
                ApiCallContext context,
                ApiFuture<DiskList> futureResponse) {
              PageContext<ListDisksHttpRequest, DiskList, Disk> pageContext =
                  PageContext.create(callable, LIST_DISKS_PAGE_STR_DESC, request, context);
              return ListDisksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for DiskStubSettings. */
  public static class Builder extends StubSettings.Builder<DiskStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddResourcePoliciesDiskHttpRequest, Operation>
        addResourcePoliciesDiskSettings;
    private final PagedCallSettings.Builder<
            AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
        aggregatedListDisksSettings;
    private final UnaryCallSettings.Builder<CreateSnapshotDiskHttpRequest, Operation>
        createSnapshotDiskSettings;
    private final UnaryCallSettings.Builder<DeleteDiskHttpRequest, Operation> deleteDiskSettings;
    private final UnaryCallSettings.Builder<GetDiskHttpRequest, Disk> getDiskSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyDiskHttpRequest, Policy>
        getIamPolicyDiskSettings;
    private final UnaryCallSettings.Builder<InsertDiskHttpRequest, Operation> insertDiskSettings;
    private final PagedCallSettings.Builder<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
        listDisksSettings;
    private final UnaryCallSettings.Builder<RemoveResourcePoliciesDiskHttpRequest, Operation>
        removeResourcePoliciesDiskSettings;
    private final UnaryCallSettings.Builder<ResizeDiskHttpRequest, Operation> resizeDiskSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyDiskHttpRequest, Policy>
        setIamPolicyDiskSettings;
    private final UnaryCallSettings.Builder<SetLabelsDiskHttpRequest, Operation>
        setLabelsDiskSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsDiskSettings;

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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addResourcePoliciesDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      aggregatedListDisksSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_DISKS_PAGE_STR_FACT);

      createSnapshotDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicyDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDisksSettings = PagedCallSettings.newBuilder(LIST_DISKS_PAGE_STR_FACT);

      removeResourcePoliciesDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      resizeDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicyDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLabelsDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesDiskSettings,
              aggregatedListDisksSettings,
              createSnapshotDiskSettings,
              deleteDiskSettings,
              getDiskSettings,
              getIamPolicyDiskSettings,
              insertDiskSettings,
              listDisksSettings,
              removeResourcePoliciesDiskSettings,
              resizeDiskSettings,
              setIamPolicyDiskSettings,
              setLabelsDiskSettings,
              testIamPermissionsDiskSettings);

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
          .addResourcePoliciesDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .aggregatedListDisksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createSnapshotDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicyDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDisksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .removeResourcePoliciesDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .resizeDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicyDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(DiskStubSettings settings) {
      super(settings);

      addResourcePoliciesDiskSettings = settings.addResourcePoliciesDiskSettings.toBuilder();
      aggregatedListDisksSettings = settings.aggregatedListDisksSettings.toBuilder();
      createSnapshotDiskSettings = settings.createSnapshotDiskSettings.toBuilder();
      deleteDiskSettings = settings.deleteDiskSettings.toBuilder();
      getDiskSettings = settings.getDiskSettings.toBuilder();
      getIamPolicyDiskSettings = settings.getIamPolicyDiskSettings.toBuilder();
      insertDiskSettings = settings.insertDiskSettings.toBuilder();
      listDisksSettings = settings.listDisksSettings.toBuilder();
      removeResourcePoliciesDiskSettings = settings.removeResourcePoliciesDiskSettings.toBuilder();
      resizeDiskSettings = settings.resizeDiskSettings.toBuilder();
      setIamPolicyDiskSettings = settings.setIamPolicyDiskSettings.toBuilder();
      setLabelsDiskSettings = settings.setLabelsDiskSettings.toBuilder();
      testIamPermissionsDiskSettings = settings.testIamPermissionsDiskSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesDiskSettings,
              aggregatedListDisksSettings,
              createSnapshotDiskSettings,
              deleteDiskSettings,
              getDiskSettings,
              getIamPolicyDiskSettings,
              insertDiskSettings,
              listDisksSettings,
              removeResourcePoliciesDiskSettings,
              resizeDiskSettings,
              setIamPolicyDiskSettings,
              setLabelsDiskSettings,
              testIamPermissionsDiskSettings);
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

    /** Returns the builder for the settings used for calls to addResourcePoliciesDisk. */
    public UnaryCallSettings.Builder<AddResourcePoliciesDiskHttpRequest, Operation>
        addResourcePoliciesDiskSettings() {
      return addResourcePoliciesDiskSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedListDisks. */
    public PagedCallSettings.Builder<
            AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
        aggregatedListDisksSettings() {
      return aggregatedListDisksSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshotDisk. */
    public UnaryCallSettings.Builder<CreateSnapshotDiskHttpRequest, Operation>
        createSnapshotDiskSettings() {
      return createSnapshotDiskSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDisk. */
    public UnaryCallSettings.Builder<DeleteDiskHttpRequest, Operation> deleteDiskSettings() {
      return deleteDiskSettings;
    }

    /** Returns the builder for the settings used for calls to getDisk. */
    public UnaryCallSettings.Builder<GetDiskHttpRequest, Disk> getDiskSettings() {
      return getDiskSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicyDisk. */
    public UnaryCallSettings.Builder<GetIamPolicyDiskHttpRequest, Policy>
        getIamPolicyDiskSettings() {
      return getIamPolicyDiskSettings;
    }

    /** Returns the builder for the settings used for calls to insertDisk. */
    public UnaryCallSettings.Builder<InsertDiskHttpRequest, Operation> insertDiskSettings() {
      return insertDiskSettings;
    }

    /** Returns the builder for the settings used for calls to listDisks. */
    public PagedCallSettings.Builder<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
        listDisksSettings() {
      return listDisksSettings;
    }

    /** Returns the builder for the settings used for calls to removeResourcePoliciesDisk. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesDiskHttpRequest, Operation>
        removeResourcePoliciesDiskSettings() {
      return removeResourcePoliciesDiskSettings;
    }

    /** Returns the builder for the settings used for calls to resizeDisk. */
    public UnaryCallSettings.Builder<ResizeDiskHttpRequest, Operation> resizeDiskSettings() {
      return resizeDiskSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicyDisk. */
    public UnaryCallSettings.Builder<SetIamPolicyDiskHttpRequest, Policy>
        setIamPolicyDiskSettings() {
      return setIamPolicyDiskSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsDisk. */
    public UnaryCallSettings.Builder<SetLabelsDiskHttpRequest, Operation> setLabelsDiskSettings() {
      return setLabelsDiskSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsDisk. */
    public UnaryCallSettings.Builder<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsDiskSettings() {
      return testIamPermissionsDiskSettings;
    }

    @Override
    public DiskStubSettings build() throws IOException {
      return new DiskStubSettings(this);
    }
  }
}
