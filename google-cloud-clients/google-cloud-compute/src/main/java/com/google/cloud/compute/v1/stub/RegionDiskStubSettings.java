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

import static com.google.cloud.compute.v1.RegionDiskClient.ListRegionDisksPagedResponse;

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
import com.google.cloud.compute.v1.CreateSnapshotRegionDiskHttpRequest;
import com.google.cloud.compute.v1.DeleteRegionDiskHttpRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetRegionDiskHttpRequest;
import com.google.cloud.compute.v1.InsertRegionDiskHttpRequest;
import com.google.cloud.compute.v1.ListRegionDisksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ResizeRegionDiskHttpRequest;
import com.google.cloud.compute.v1.SetLabelsRegionDiskHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskHttpRequest;
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
 * Settings class to configure an instance of {@link RegionDiskStub}.
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
 * example, to set the total timeout of createSnapshotRegionDisk to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionDiskStubSettings.Builder regionDiskSettingsBuilder =
 *     RegionDiskStubSettings.newBuilder();
 * regionDiskSettingsBuilder.createSnapshotRegionDiskSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionDiskStubSettings regionDiskSettings = regionDiskSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionDiskStubSettings extends StubSettings<RegionDiskStubSettings> {
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

  private final UnaryCallSettings<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskSettings;
  private final UnaryCallSettings<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskSettings;
  private final UnaryCallSettings<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings;
  private final UnaryCallSettings<InsertRegionDiskHttpRequest, Operation> insertRegionDiskSettings;
  private final PagedCallSettings<
          ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
      listRegionDisksSettings;
  private final UnaryCallSettings<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskSettings;
  private final UnaryCallSettings<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskSettings;
  private final UnaryCallSettings<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskSettings;

  /** Returns the object with the settings used for calls to createSnapshotRegionDisk. */
  public UnaryCallSettings<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskSettings() {
    return createSnapshotRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to deleteRegionDisk. */
  public UnaryCallSettings<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskSettings() {
    return deleteRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to getRegionDisk. */
  public UnaryCallSettings<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings() {
    return getRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionDisk. */
  public UnaryCallSettings<InsertRegionDiskHttpRequest, Operation> insertRegionDiskSettings() {
    return insertRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to listRegionDisks. */
  public PagedCallSettings<ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
      listRegionDisksSettings() {
    return listRegionDisksSettings;
  }

  /** Returns the object with the settings used for calls to resizeRegionDisk. */
  public UnaryCallSettings<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskSettings() {
    return resizeRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsRegionDisk. */
  public UnaryCallSettings<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskSettings() {
    return setLabelsRegionDiskSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsRegionDisk. */
  public UnaryCallSettings<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskSettings() {
    return testIamPermissionsRegionDiskSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionDiskStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionDiskStub.create(this);
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RegionDiskStubSettings.class))
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

  protected RegionDiskStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSnapshotRegionDiskSettings = settingsBuilder.createSnapshotRegionDiskSettings().build();
    deleteRegionDiskSettings = settingsBuilder.deleteRegionDiskSettings().build();
    getRegionDiskSettings = settingsBuilder.getRegionDiskSettings().build();
    insertRegionDiskSettings = settingsBuilder.insertRegionDiskSettings().build();
    listRegionDisksSettings = settingsBuilder.listRegionDisksSettings().build();
    resizeRegionDiskSettings = settingsBuilder.resizeRegionDiskSettings().build();
    setLabelsRegionDiskSettings = settingsBuilder.setLabelsRegionDiskSettings().build();
    testIamPermissionsRegionDiskSettings =
        settingsBuilder.testIamPermissionsRegionDiskSettings().build();
  }

  private static final PagedListDescriptor<ListRegionDisksHttpRequest, DiskList, Disk>
      LIST_REGION_DISKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRegionDisksHttpRequest, DiskList, Disk>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionDisksHttpRequest injectToken(
                ListRegionDisksHttpRequest payload, String token) {
              return ListRegionDisksHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegionDisksHttpRequest injectPageSize(
                ListRegionDisksHttpRequest payload, int pageSize) {
              return ListRegionDisksHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRegionDisksHttpRequest payload) {
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
          ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
      LIST_REGION_DISKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>() {
            @Override
            public ApiFuture<ListRegionDisksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionDisksHttpRequest, DiskList> callable,
                ListRegionDisksHttpRequest request,
                ApiCallContext context,
                ApiFuture<DiskList> futureResponse) {
              PageContext<ListRegionDisksHttpRequest, DiskList, Disk> pageContext =
                  PageContext.create(callable, LIST_REGION_DISKS_PAGE_STR_DESC, request, context);
              return ListRegionDisksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RegionDiskStubSettings. */
  public static class Builder extends StubSettings.Builder<RegionDiskStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateSnapshotRegionDiskHttpRequest, Operation>
        createSnapshotRegionDiskSettings;
    private final UnaryCallSettings.Builder<DeleteRegionDiskHttpRequest, Operation>
        deleteRegionDiskSettings;
    private final UnaryCallSettings.Builder<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings;
    private final UnaryCallSettings.Builder<InsertRegionDiskHttpRequest, Operation>
        insertRegionDiskSettings;
    private final PagedCallSettings.Builder<
            ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
        listRegionDisksSettings;
    private final UnaryCallSettings.Builder<ResizeRegionDiskHttpRequest, Operation>
        resizeRegionDiskSettings;
    private final UnaryCallSettings.Builder<SetLabelsRegionDiskHttpRequest, Operation>
        setLabelsRegionDiskSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsRegionDiskSettings;

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

      createSnapshotRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionDisksSettings = PagedCallSettings.newBuilder(LIST_REGION_DISKS_PAGE_STR_FACT);

      resizeRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLabelsRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsRegionDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSnapshotRegionDiskSettings,
              deleteRegionDiskSettings,
              getRegionDiskSettings,
              insertRegionDiskSettings,
              listRegionDisksSettings,
              resizeRegionDiskSettings,
              setLabelsRegionDiskSettings,
              testIamPermissionsRegionDiskSettings);

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
          .createSnapshotRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionDisksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .resizeRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsRegionDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionDiskStubSettings settings) {
      super(settings);

      createSnapshotRegionDiskSettings = settings.createSnapshotRegionDiskSettings.toBuilder();
      deleteRegionDiskSettings = settings.deleteRegionDiskSettings.toBuilder();
      getRegionDiskSettings = settings.getRegionDiskSettings.toBuilder();
      insertRegionDiskSettings = settings.insertRegionDiskSettings.toBuilder();
      listRegionDisksSettings = settings.listRegionDisksSettings.toBuilder();
      resizeRegionDiskSettings = settings.resizeRegionDiskSettings.toBuilder();
      setLabelsRegionDiskSettings = settings.setLabelsRegionDiskSettings.toBuilder();
      testIamPermissionsRegionDiskSettings =
          settings.testIamPermissionsRegionDiskSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSnapshotRegionDiskSettings,
              deleteRegionDiskSettings,
              getRegionDiskSettings,
              insertRegionDiskSettings,
              listRegionDisksSettings,
              resizeRegionDiskSettings,
              setLabelsRegionDiskSettings,
              testIamPermissionsRegionDiskSettings);
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

    /** Returns the builder for the settings used for calls to createSnapshotRegionDisk. */
    public UnaryCallSettings.Builder<CreateSnapshotRegionDiskHttpRequest, Operation>
        createSnapshotRegionDiskSettings() {
      return createSnapshotRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRegionDisk. */
    public UnaryCallSettings.Builder<DeleteRegionDiskHttpRequest, Operation>
        deleteRegionDiskSettings() {
      return deleteRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionDisk. */
    public UnaryCallSettings.Builder<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings() {
      return getRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionDisk. */
    public UnaryCallSettings.Builder<InsertRegionDiskHttpRequest, Operation>
        insertRegionDiskSettings() {
      return insertRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionDisks. */
    public PagedCallSettings.Builder<
            ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
        listRegionDisksSettings() {
      return listRegionDisksSettings;
    }

    /** Returns the builder for the settings used for calls to resizeRegionDisk. */
    public UnaryCallSettings.Builder<ResizeRegionDiskHttpRequest, Operation>
        resizeRegionDiskSettings() {
      return resizeRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsRegionDisk. */
    public UnaryCallSettings.Builder<SetLabelsRegionDiskHttpRequest, Operation>
        setLabelsRegionDiskSettings() {
      return setLabelsRegionDiskSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsRegionDisk. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsRegionDiskSettings() {
      return testIamPermissionsRegionDiskSettings;
    }

    @Override
    public RegionDiskStubSettings build() throws IOException {
      return new RegionDiskStubSettings(this);
    }
  }
}
