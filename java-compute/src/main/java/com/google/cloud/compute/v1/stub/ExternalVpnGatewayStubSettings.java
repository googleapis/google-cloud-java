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

import static com.google.cloud.compute.v1.ExternalVpnGatewayClient.ListExternalVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.DeleteExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayList;
import com.google.cloud.compute.v1.GetExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListExternalVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsExternalVpnGatewayHttpRequest;
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
 * Settings class to configure an instance of {@link ExternalVpnGatewayStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteExternalVpnGateway to 30 seconds:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewayStubSettings.Builder externalVpnGatewaySettingsBuilder =
 *     ExternalVpnGatewayStubSettings.newBuilder();
 * externalVpnGatewaySettingsBuilder.deleteExternalVpnGatewaySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ExternalVpnGatewayStubSettings externalVpnGatewaySettings = externalVpnGatewaySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ExternalVpnGatewayStubSettings extends StubSettings<ExternalVpnGatewayStubSettings> {
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

  private final UnaryCallSettings<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewaySettings;
  private final UnaryCallSettings<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewaySettings;
  private final UnaryCallSettings<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewaySettings;
  private final PagedCallSettings<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysSettings;
  private final UnaryCallSettings<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewaySettings;
  private final UnaryCallSettings<
          TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewaySettings;

  /** Returns the object with the settings used for calls to deleteExternalVpnGateway. */
  public UnaryCallSettings<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewaySettings() {
    return deleteExternalVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to getExternalVpnGateway. */
  public UnaryCallSettings<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewaySettings() {
    return getExternalVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to insertExternalVpnGateway. */
  public UnaryCallSettings<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewaySettings() {
    return insertExternalVpnGatewaySettings;
  }

  /** Returns the object with the settings used for calls to listExternalVpnGateways. */
  public PagedCallSettings<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysSettings() {
    return listExternalVpnGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to setLabelsExternalVpnGateway. */
  public UnaryCallSettings<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewaySettings() {
    return setLabelsExternalVpnGatewaySettings;
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissionsExternalVpnGateway.
   */
  public UnaryCallSettings<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewaySettings() {
    return testIamPermissionsExternalVpnGatewaySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ExternalVpnGatewayStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonExternalVpnGatewayStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(ExternalVpnGatewayStubSettings.class))
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

  protected ExternalVpnGatewayStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteExternalVpnGatewaySettings = settingsBuilder.deleteExternalVpnGatewaySettings().build();
    getExternalVpnGatewaySettings = settingsBuilder.getExternalVpnGatewaySettings().build();
    insertExternalVpnGatewaySettings = settingsBuilder.insertExternalVpnGatewaySettings().build();
    listExternalVpnGatewaysSettings = settingsBuilder.listExternalVpnGatewaysSettings().build();
    setLabelsExternalVpnGatewaySettings =
        settingsBuilder.setLabelsExternalVpnGatewaySettings().build();
    testIamPermissionsExternalVpnGatewaySettings =
        settingsBuilder.testIamPermissionsExternalVpnGatewaySettings().build();
  }

  private static final PagedListDescriptor<
          ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>
      LIST_EXTERNAL_VPN_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList, ExternalVpnGateway>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExternalVpnGatewaysHttpRequest injectToken(
                ListExternalVpnGatewaysHttpRequest payload, String token) {
              return ListExternalVpnGatewaysHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListExternalVpnGatewaysHttpRequest injectPageSize(
                ListExternalVpnGatewaysHttpRequest payload, int pageSize) {
              return ListExternalVpnGatewaysHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListExternalVpnGatewaysHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ExternalVpnGatewayList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExternalVpnGateway> extractResources(ExternalVpnGatewayList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<ExternalVpnGateway>of();
            }
          };

  private static final PagedListResponseFactory<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ListExternalVpnGatewaysPagedResponse>
      LIST_EXTERNAL_VPN_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExternalVpnGatewaysHttpRequest,
              ExternalVpnGatewayList,
              ListExternalVpnGatewaysPagedResponse>() {
            @Override
            public ApiFuture<ListExternalVpnGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList> callable,
                ListExternalVpnGatewaysHttpRequest request,
                ApiCallContext context,
                ApiFuture<ExternalVpnGatewayList> futureResponse) {
              PageContext<
                      ListExternalVpnGatewaysHttpRequest,
                      ExternalVpnGatewayList,
                      ExternalVpnGateway>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXTERNAL_VPN_GATEWAYS_PAGE_STR_DESC, request, context);
              return ListExternalVpnGatewaysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ExternalVpnGatewayStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ExternalVpnGatewayStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteExternalVpnGatewayHttpRequest, Operation>
        deleteExternalVpnGatewaySettings;
    private final UnaryCallSettings.Builder<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
        getExternalVpnGatewaySettings;
    private final UnaryCallSettings.Builder<InsertExternalVpnGatewayHttpRequest, Operation>
        insertExternalVpnGatewaySettings;
    private final PagedCallSettings.Builder<
            ListExternalVpnGatewaysHttpRequest,
            ExternalVpnGatewayList,
            ListExternalVpnGatewaysPagedResponse>
        listExternalVpnGatewaysSettings;
    private final UnaryCallSettings.Builder<SetLabelsExternalVpnGatewayHttpRequest, Operation>
        setLabelsExternalVpnGatewaySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsExternalVpnGatewaySettings;

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

      deleteExternalVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getExternalVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertExternalVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listExternalVpnGatewaysSettings =
          PagedCallSettings.newBuilder(LIST_EXTERNAL_VPN_GATEWAYS_PAGE_STR_FACT);

      setLabelsExternalVpnGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsExternalVpnGatewaySettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteExternalVpnGatewaySettings,
              getExternalVpnGatewaySettings,
              insertExternalVpnGatewaySettings,
              listExternalVpnGatewaysSettings,
              setLabelsExternalVpnGatewaySettings,
              testIamPermissionsExternalVpnGatewaySettings);

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
          .deleteExternalVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getExternalVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertExternalVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listExternalVpnGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsExternalVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsExternalVpnGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ExternalVpnGatewayStubSettings settings) {
      super(settings);

      deleteExternalVpnGatewaySettings = settings.deleteExternalVpnGatewaySettings.toBuilder();
      getExternalVpnGatewaySettings = settings.getExternalVpnGatewaySettings.toBuilder();
      insertExternalVpnGatewaySettings = settings.insertExternalVpnGatewaySettings.toBuilder();
      listExternalVpnGatewaysSettings = settings.listExternalVpnGatewaysSettings.toBuilder();
      setLabelsExternalVpnGatewaySettings =
          settings.setLabelsExternalVpnGatewaySettings.toBuilder();
      testIamPermissionsExternalVpnGatewaySettings =
          settings.testIamPermissionsExternalVpnGatewaySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteExternalVpnGatewaySettings,
              getExternalVpnGatewaySettings,
              insertExternalVpnGatewaySettings,
              listExternalVpnGatewaysSettings,
              setLabelsExternalVpnGatewaySettings,
              testIamPermissionsExternalVpnGatewaySettings);
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

    /** Returns the builder for the settings used for calls to deleteExternalVpnGateway. */
    public UnaryCallSettings.Builder<DeleteExternalVpnGatewayHttpRequest, Operation>
        deleteExternalVpnGatewaySettings() {
      return deleteExternalVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to getExternalVpnGateway. */
    public UnaryCallSettings.Builder<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
        getExternalVpnGatewaySettings() {
      return getExternalVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to insertExternalVpnGateway. */
    public UnaryCallSettings.Builder<InsertExternalVpnGatewayHttpRequest, Operation>
        insertExternalVpnGatewaySettings() {
      return insertExternalVpnGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to listExternalVpnGateways. */
    public PagedCallSettings.Builder<
            ListExternalVpnGatewaysHttpRequest,
            ExternalVpnGatewayList,
            ListExternalVpnGatewaysPagedResponse>
        listExternalVpnGatewaysSettings() {
      return listExternalVpnGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to setLabelsExternalVpnGateway. */
    public UnaryCallSettings.Builder<SetLabelsExternalVpnGatewayHttpRequest, Operation>
        setLabelsExternalVpnGatewaySettings() {
      return setLabelsExternalVpnGatewaySettings;
    }

    /**
     * Returns the builder for the settings used for calls to testIamPermissionsExternalVpnGateway.
     */
    public UnaryCallSettings.Builder<
            TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsExternalVpnGatewaySettings() {
      return testIamPermissionsExternalVpnGatewaySettings;
    }

    @Override
    public ExternalVpnGatewayStubSettings build() throws IOException {
      return new ExternalVpnGatewayStubSettings(this);
    }
  }
}
