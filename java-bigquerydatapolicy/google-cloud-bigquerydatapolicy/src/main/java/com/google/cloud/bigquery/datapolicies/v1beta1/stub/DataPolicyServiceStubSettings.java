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

package com.google.cloud.bigquery.datapolicies.v1beta1.stub;

import static com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicyServiceClient.ListDataPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy;
import com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest;
import com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse;
import com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataPolicyServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerydatapolicy.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDataPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataPolicyServiceStubSettings.Builder dataPolicyServiceSettingsBuilder =
 *     DataPolicyServiceStubSettings.newBuilder();
 * dataPolicyServiceSettingsBuilder
 *     .createDataPolicySettings()
 *     .setRetrySettings(
 *         dataPolicyServiceSettingsBuilder
 *             .createDataPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataPolicyServiceStubSettings dataPolicyServiceSettings =
 *     dataPolicyServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataPolicyServiceStubSettings extends StubSettings<DataPolicyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateDataPolicyRequest, DataPolicy> createDataPolicySettings;
  private final UnaryCallSettings<UpdateDataPolicyRequest, DataPolicy> updateDataPolicySettings;
  private final UnaryCallSettings<DeleteDataPolicyRequest, Empty> deleteDataPolicySettings;
  private final UnaryCallSettings<GetDataPolicyRequest, DataPolicy> getDataPolicySettings;
  private final PagedCallSettings<
          ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>
      listDataPoliciesSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy>
      LIST_DATA_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataPoliciesRequest injectToken(
                ListDataPoliciesRequest payload, String token) {
              return ListDataPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataPoliciesRequest injectPageSize(
                ListDataPoliciesRequest payload, int pageSize) {
              return ListDataPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataPolicy> extractResources(ListDataPoliciesResponse payload) {
              return payload.getDataPoliciesList() == null
                  ? ImmutableList.<DataPolicy>of()
                  : payload.getDataPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>
      LIST_DATA_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListDataPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse> callable,
                ListDataPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataPoliciesResponse> futureResponse) {
              PageContext<ListDataPoliciesRequest, ListDataPoliciesResponse, DataPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_POLICIES_PAGE_STR_DESC, request, context);
              return ListDataPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataPolicy. */
  public UnaryCallSettings<CreateDataPolicyRequest, DataPolicy> createDataPolicySettings() {
    return createDataPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateDataPolicy. */
  public UnaryCallSettings<UpdateDataPolicyRequest, DataPolicy> updateDataPolicySettings() {
    return updateDataPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteDataPolicy. */
  public UnaryCallSettings<DeleteDataPolicyRequest, Empty> deleteDataPolicySettings() {
    return deleteDataPolicySettings;
  }

  /** Returns the object with the settings used for calls to getDataPolicy. */
  public UnaryCallSettings<GetDataPolicyRequest, DataPolicy> getDataPolicySettings() {
    return getDataPolicySettings;
  }

  /** Returns the object with the settings used for calls to listDataPolicies. */
  public PagedCallSettings<
          ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>
      listDataPoliciesSettings() {
    return listDataPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DataPolicyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataPolicyServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataPolicyServiceStub.create(this);
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
    return "bigquerydatapolicy.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigquerydatapolicy.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataPolicyServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataPolicyServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataPolicyServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DataPolicyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataPolicySettings = settingsBuilder.createDataPolicySettings().build();
    updateDataPolicySettings = settingsBuilder.updateDataPolicySettings().build();
    deleteDataPolicySettings = settingsBuilder.deleteDataPolicySettings().build();
    getDataPolicySettings = settingsBuilder.getDataPolicySettings().build();
    listDataPoliciesSettings = settingsBuilder.listDataPoliciesSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DataPolicyServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataPolicyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataPolicyRequest, DataPolicy>
        createDataPolicySettings;
    private final UnaryCallSettings.Builder<UpdateDataPolicyRequest, DataPolicy>
        updateDataPolicySettings;
    private final UnaryCallSettings.Builder<DeleteDataPolicyRequest, Empty>
        deleteDataPolicySettings;
    private final UnaryCallSettings.Builder<GetDataPolicyRequest, DataPolicy> getDataPolicySettings;
    private final PagedCallSettings.Builder<
            ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>
        listDataPoliciesSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataPoliciesSettings = PagedCallSettings.newBuilder(LIST_DATA_POLICIES_PAGE_STR_FACT);
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataPolicySettings,
              updateDataPolicySettings,
              deleteDataPolicySettings,
              getDataPolicySettings,
              listDataPoliciesSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DataPolicyServiceStubSettings settings) {
      super(settings);

      createDataPolicySettings = settings.createDataPolicySettings.toBuilder();
      updateDataPolicySettings = settings.updateDataPolicySettings.toBuilder();
      deleteDataPolicySettings = settings.deleteDataPolicySettings.toBuilder();
      getDataPolicySettings = settings.getDataPolicySettings.toBuilder();
      listDataPoliciesSettings = settings.listDataPoliciesSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataPolicySettings,
              updateDataPolicySettings,
              deleteDataPolicySettings,
              getDataPolicySettings,
              listDataPoliciesSettings,
              getIamPolicySettings,
              setIamPolicySettings,
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDataPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createDataPolicy. */
    public UnaryCallSettings.Builder<CreateDataPolicyRequest, DataPolicy>
        createDataPolicySettings() {
      return createDataPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateDataPolicy. */
    public UnaryCallSettings.Builder<UpdateDataPolicyRequest, DataPolicy>
        updateDataPolicySettings() {
      return updateDataPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataPolicy. */
    public UnaryCallSettings.Builder<DeleteDataPolicyRequest, Empty> deleteDataPolicySettings() {
      return deleteDataPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getDataPolicy. */
    public UnaryCallSettings.Builder<GetDataPolicyRequest, DataPolicy> getDataPolicySettings() {
      return getDataPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listDataPolicies. */
    public PagedCallSettings.Builder<
            ListDataPoliciesRequest, ListDataPoliciesResponse, ListDataPoliciesPagedResponse>
        listDataPoliciesSettings() {
      return listDataPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DataPolicyServiceStubSettings build() throws IOException {
      return new DataPolicyServiceStubSettings(this);
    }
  }
}
