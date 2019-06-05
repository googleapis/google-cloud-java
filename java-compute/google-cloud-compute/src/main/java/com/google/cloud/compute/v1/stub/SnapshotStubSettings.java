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

import static com.google.cloud.compute.v1.SnapshotClient.ListSnapshotsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteSnapshotHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.GetSnapshotHttpRequest;
import com.google.cloud.compute.v1.ListSnapshotsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.SetLabelsSnapshotHttpRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.SnapshotList;
import com.google.cloud.compute.v1.TestIamPermissionsSnapshotHttpRequest;
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
 * Settings class to configure an instance of {@link SnapshotStub}.
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
 * example, to set the total timeout of deleteSnapshot to 30 seconds:
 *
 * <pre>
 * <code>
 * SnapshotStubSettings.Builder snapshotSettingsBuilder =
 *     SnapshotStubSettings.newBuilder();
 * snapshotSettingsBuilder.deleteSnapshotSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SnapshotStubSettings snapshotSettings = snapshotSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SnapshotStubSettings extends StubSettings<SnapshotStubSettings> {
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

  private final UnaryCallSettings<DeleteSnapshotHttpRequest, Operation> deleteSnapshotSettings;
  private final UnaryCallSettings<GetSnapshotHttpRequest, Snapshot> getSnapshotSettings;
  private final UnaryCallSettings<GetIamPolicySnapshotHttpRequest, Policy>
      getIamPolicySnapshotSettings;
  private final PagedCallSettings<
          ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>
      listSnapshotsSettings;
  private final UnaryCallSettings<SetIamPolicySnapshotHttpRequest, Policy>
      setIamPolicySnapshotSettings;
  private final UnaryCallSettings<SetLabelsSnapshotHttpRequest, Operation>
      setLabelsSnapshotSettings;
  private final UnaryCallSettings<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotSettings;

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotHttpRequest, Operation> deleteSnapshotSettings() {
    return deleteSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to getSnapshot. */
  public UnaryCallSettings<GetSnapshotHttpRequest, Snapshot> getSnapshotSettings() {
    return getSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicySnapshot. */
  public UnaryCallSettings<GetIamPolicySnapshotHttpRequest, Policy> getIamPolicySnapshotSettings() {
    return getIamPolicySnapshotSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return listSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicySnapshot. */
  public UnaryCallSettings<SetIamPolicySnapshotHttpRequest, Policy> setIamPolicySnapshotSettings() {
    return setIamPolicySnapshotSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsSnapshot. */
  public UnaryCallSettings<SetLabelsSnapshotHttpRequest, Operation> setLabelsSnapshotSettings() {
    return setLabelsSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsSnapshot. */
  public UnaryCallSettings<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotSettings() {
    return testIamPermissionsSnapshotSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SnapshotStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSnapshotStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SnapshotStubSettings.class))
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

  protected SnapshotStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteSnapshotSettings = settingsBuilder.deleteSnapshotSettings().build();
    getSnapshotSettings = settingsBuilder.getSnapshotSettings().build();
    getIamPolicySnapshotSettings = settingsBuilder.getIamPolicySnapshotSettings().build();
    listSnapshotsSettings = settingsBuilder.listSnapshotsSettings().build();
    setIamPolicySnapshotSettings = settingsBuilder.setIamPolicySnapshotSettings().build();
    setLabelsSnapshotSettings = settingsBuilder.setLabelsSnapshotSettings().build();
    testIamPermissionsSnapshotSettings =
        settingsBuilder.testIamPermissionsSnapshotSettings().build();
  }

  private static final PagedListDescriptor<ListSnapshotsHttpRequest, SnapshotList, Snapshot>
      LIST_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSnapshotsHttpRequest, SnapshotList, Snapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotsHttpRequest injectToken(
                ListSnapshotsHttpRequest payload, String token) {
              return ListSnapshotsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSnapshotsHttpRequest injectPageSize(
                ListSnapshotsHttpRequest payload, int pageSize) {
              return ListSnapshotsHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSnapshotsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(SnapshotList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Snapshot> extractResources(SnapshotList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Snapshot>of();
            }
          };

  private static final PagedListResponseFactory<
          ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>
      LIST_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSnapshotsHttpRequest, SnapshotList> callable,
                ListSnapshotsHttpRequest request,
                ApiCallContext context,
                ApiFuture<SnapshotList> futureResponse) {
              PageContext<ListSnapshotsHttpRequest, SnapshotList, Snapshot> pageContext =
                  PageContext.create(callable, LIST_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for SnapshotStubSettings. */
  public static class Builder extends StubSettings.Builder<SnapshotStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteSnapshotHttpRequest, Operation>
        deleteSnapshotSettings;
    private final UnaryCallSettings.Builder<GetSnapshotHttpRequest, Snapshot> getSnapshotSettings;
    private final UnaryCallSettings.Builder<GetIamPolicySnapshotHttpRequest, Policy>
        getIamPolicySnapshotSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>
        listSnapshotsSettings;
    private final UnaryCallSettings.Builder<SetIamPolicySnapshotHttpRequest, Policy>
        setIamPolicySnapshotSettings;
    private final UnaryCallSettings.Builder<SetLabelsSnapshotHttpRequest, Operation>
        setLabelsSnapshotSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
        testIamPermissionsSnapshotSettings;

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

      deleteSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSnapshotsSettings = PagedCallSettings.newBuilder(LIST_SNAPSHOTS_PAGE_STR_FACT);

      setIamPolicySnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLabelsSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSnapshotSettings,
              getSnapshotSettings,
              getIamPolicySnapshotSettings,
              listSnapshotsSettings,
              setIamPolicySnapshotSettings,
              setLabelsSnapshotSettings,
              testIamPermissionsSnapshotSettings);

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
          .deleteSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(SnapshotStubSettings settings) {
      super(settings);

      deleteSnapshotSettings = settings.deleteSnapshotSettings.toBuilder();
      getSnapshotSettings = settings.getSnapshotSettings.toBuilder();
      getIamPolicySnapshotSettings = settings.getIamPolicySnapshotSettings.toBuilder();
      listSnapshotsSettings = settings.listSnapshotsSettings.toBuilder();
      setIamPolicySnapshotSettings = settings.setIamPolicySnapshotSettings.toBuilder();
      setLabelsSnapshotSettings = settings.setLabelsSnapshotSettings.toBuilder();
      testIamPermissionsSnapshotSettings = settings.testIamPermissionsSnapshotSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSnapshotSettings,
              getSnapshotSettings,
              getIamPolicySnapshotSettings,
              listSnapshotsSettings,
              setIamPolicySnapshotSettings,
              setLabelsSnapshotSettings,
              testIamPermissionsSnapshotSettings);
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

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotHttpRequest, Operation>
        deleteSnapshotSettings() {
      return deleteSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to getSnapshot. */
    public UnaryCallSettings.Builder<GetSnapshotHttpRequest, Snapshot> getSnapshotSettings() {
      return getSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicySnapshot. */
    public UnaryCallSettings.Builder<GetIamPolicySnapshotHttpRequest, Policy>
        getIamPolicySnapshotSettings() {
      return getIamPolicySnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsHttpRequest, SnapshotList, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return listSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicySnapshot. */
    public UnaryCallSettings.Builder<SetIamPolicySnapshotHttpRequest, Policy>
        setIamPolicySnapshotSettings() {
      return setIamPolicySnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsSnapshot. */
    public UnaryCallSettings.Builder<SetLabelsSnapshotHttpRequest, Operation>
        setLabelsSnapshotSettings() {
      return setLabelsSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsSnapshot. */
    public UnaryCallSettings.Builder<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
        testIamPermissionsSnapshotSettings() {
      return testIamPermissionsSnapshotSettings;
    }

    @Override
    public SnapshotStubSettings build() throws IOException {
      return new SnapshotStubSettings(this);
    }
  }
}
