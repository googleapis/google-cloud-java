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

package com.google.cloud.secretmanager.v1.stub;

import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretVersionsPagedResponse;
import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretsPagedResponse;

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
import com.google.cloud.secretmanager.v1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.DestroySecretVersionRequest;
import com.google.cloud.secretmanager.v1.DisableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.EnableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.GetSecretRequest;
import com.google.cloud.secretmanager.v1.GetSecretVersionRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsResponse;
import com.google.cloud.secretmanager.v1.ListSecretsRequest;
import com.google.cloud.secretmanager.v1.ListSecretsResponse;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.cloud.secretmanager.v1.UpdateSecretRequest;
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
 * Settings class to configure an instance of {@link SecretManagerServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (secretmanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSecret to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecretManagerServiceStubSettings.Builder secretManagerServiceSettingsBuilder =
 *     SecretManagerServiceStubSettings.newBuilder();
 * secretManagerServiceSettingsBuilder
 *     .createSecretSettings()
 *     .setRetrySettings(
 *         secretManagerServiceSettingsBuilder
 *             .createSecretSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecretManagerServiceStubSettings secretManagerServiceSettings =
 *     secretManagerServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecretManagerServiceStubSettings
    extends StubSettings<SecretManagerServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
      listSecretsSettings;
  private final UnaryCallSettings<CreateSecretRequest, Secret> createSecretSettings;
  private final UnaryCallSettings<AddSecretVersionRequest, SecretVersion> addSecretVersionSettings;
  private final UnaryCallSettings<GetSecretRequest, Secret> getSecretSettings;
  private final UnaryCallSettings<UpdateSecretRequest, Secret> updateSecretSettings;
  private final UnaryCallSettings<DeleteSecretRequest, Empty> deleteSecretSettings;
  private final PagedCallSettings<
          ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
      listSecretVersionsSettings;
  private final UnaryCallSettings<GetSecretVersionRequest, SecretVersion> getSecretVersionSettings;
  private final UnaryCallSettings<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionSettings;
  private final UnaryCallSettings<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionSettings;
  private final UnaryCallSettings<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionSettings;
  private final UnaryCallSettings<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListSecretsRequest, ListSecretsResponse, Secret>
      LIST_SECRETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSecretsRequest, ListSecretsResponse, Secret>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecretsRequest injectToken(ListSecretsRequest payload, String token) {
              return ListSecretsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSecretsRequest injectPageSize(ListSecretsRequest payload, int pageSize) {
              return ListSecretsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSecretsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSecretsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Secret> extractResources(ListSecretsResponse payload) {
              return payload.getSecretsList() == null
                  ? ImmutableList.<Secret>of()
                  : payload.getSecretsList();
            }
          };

  private static final PagedListDescriptor<
          ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion>
      LIST_SECRET_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecretVersionsRequest injectToken(
                ListSecretVersionsRequest payload, String token) {
              return ListSecretVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSecretVersionsRequest injectPageSize(
                ListSecretVersionsRequest payload, int pageSize) {
              return ListSecretVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSecretVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSecretVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecretVersion> extractResources(ListSecretVersionsResponse payload) {
              return payload.getVersionsList() == null
                  ? ImmutableList.<SecretVersion>of()
                  : payload.getVersionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
      LIST_SECRETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>() {
            @Override
            public ApiFuture<ListSecretsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecretsRequest, ListSecretsResponse> callable,
                ListSecretsRequest request,
                ApiCallContext context,
                ApiFuture<ListSecretsResponse> futureResponse) {
              PageContext<ListSecretsRequest, ListSecretsResponse, Secret> pageContext =
                  PageContext.create(callable, LIST_SECRETS_PAGE_STR_DESC, request, context);
              return ListSecretsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
      LIST_SECRET_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecretVersionsRequest,
              ListSecretVersionsResponse,
              ListSecretVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListSecretVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsResponse> callable,
                ListSecretVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSecretVersionsResponse> futureResponse) {
              PageContext<ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SECRET_VERSIONS_PAGE_STR_DESC, request, context);
              return ListSecretVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listSecrets. */
  public PagedCallSettings<ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
      listSecretsSettings() {
    return listSecretsSettings;
  }

  /** Returns the object with the settings used for calls to createSecret. */
  public UnaryCallSettings<CreateSecretRequest, Secret> createSecretSettings() {
    return createSecretSettings;
  }

  /** Returns the object with the settings used for calls to addSecretVersion. */
  public UnaryCallSettings<AddSecretVersionRequest, SecretVersion> addSecretVersionSettings() {
    return addSecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to getSecret. */
  public UnaryCallSettings<GetSecretRequest, Secret> getSecretSettings() {
    return getSecretSettings;
  }

  /** Returns the object with the settings used for calls to updateSecret. */
  public UnaryCallSettings<UpdateSecretRequest, Secret> updateSecretSettings() {
    return updateSecretSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecret. */
  public UnaryCallSettings<DeleteSecretRequest, Empty> deleteSecretSettings() {
    return deleteSecretSettings;
  }

  /** Returns the object with the settings used for calls to listSecretVersions. */
  public PagedCallSettings<
          ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
      listSecretVersionsSettings() {
    return listSecretVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getSecretVersion. */
  public UnaryCallSettings<GetSecretVersionRequest, SecretVersion> getSecretVersionSettings() {
    return getSecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to accessSecretVersion. */
  public UnaryCallSettings<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionSettings() {
    return accessSecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to disableSecretVersion. */
  public UnaryCallSettings<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionSettings() {
    return disableSecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to enableSecretVersion. */
  public UnaryCallSettings<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionSettings() {
    return enableSecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to destroySecretVersion. */
  public UnaryCallSettings<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionSettings() {
    return destroySecretVersionSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public SecretManagerServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecretManagerServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecretManagerServiceStub.create(this);
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
    return "secretmanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "secretmanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecretManagerServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecretManagerServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SecretManagerServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listSecretsSettings = settingsBuilder.listSecretsSettings().build();
    createSecretSettings = settingsBuilder.createSecretSettings().build();
    addSecretVersionSettings = settingsBuilder.addSecretVersionSettings().build();
    getSecretSettings = settingsBuilder.getSecretSettings().build();
    updateSecretSettings = settingsBuilder.updateSecretSettings().build();
    deleteSecretSettings = settingsBuilder.deleteSecretSettings().build();
    listSecretVersionsSettings = settingsBuilder.listSecretVersionsSettings().build();
    getSecretVersionSettings = settingsBuilder.getSecretVersionSettings().build();
    accessSecretVersionSettings = settingsBuilder.accessSecretVersionSettings().build();
    disableSecretVersionSettings = settingsBuilder.disableSecretVersionSettings().build();
    enableSecretVersionSettings = settingsBuilder.enableSecretVersionSettings().build();
    destroySecretVersionSettings = settingsBuilder.destroySecretVersionSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for SecretManagerServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SecretManagerServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
        listSecretsSettings;
    private final UnaryCallSettings.Builder<CreateSecretRequest, Secret> createSecretSettings;
    private final UnaryCallSettings.Builder<AddSecretVersionRequest, SecretVersion>
        addSecretVersionSettings;
    private final UnaryCallSettings.Builder<GetSecretRequest, Secret> getSecretSettings;
    private final UnaryCallSettings.Builder<UpdateSecretRequest, Secret> updateSecretSettings;
    private final UnaryCallSettings.Builder<DeleteSecretRequest, Empty> deleteSecretSettings;
    private final PagedCallSettings.Builder<
            ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
        listSecretVersionsSettings;
    private final UnaryCallSettings.Builder<GetSecretVersionRequest, SecretVersion>
        getSecretVersionSettings;
    private final UnaryCallSettings.Builder<AccessSecretVersionRequest, AccessSecretVersionResponse>
        accessSecretVersionSettings;
    private final UnaryCallSettings.Builder<DisableSecretVersionRequest, SecretVersion>
        disableSecretVersionSettings;
    private final UnaryCallSettings.Builder<EnableSecretVersionRequest, SecretVersion>
        enableSecretVersionSettings;
    private final UnaryCallSettings.Builder<DestroySecretVersionRequest, SecretVersion>
        destroySecretVersionSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(2000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listSecretsSettings = PagedCallSettings.newBuilder(LIST_SECRETS_PAGE_STR_FACT);
      createSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addSecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSecretVersionsSettings = PagedCallSettings.newBuilder(LIST_SECRET_VERSIONS_PAGE_STR_FACT);
      getSecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      accessSecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableSecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableSecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      destroySecretVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSecretsSettings,
              createSecretSettings,
              addSecretVersionSettings,
              getSecretSettings,
              updateSecretSettings,
              deleteSecretSettings,
              listSecretVersionsSettings,
              getSecretVersionSettings,
              accessSecretVersionSettings,
              disableSecretVersionSettings,
              enableSecretVersionSettings,
              destroySecretVersionSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SecretManagerServiceStubSettings settings) {
      super(settings);

      listSecretsSettings = settings.listSecretsSettings.toBuilder();
      createSecretSettings = settings.createSecretSettings.toBuilder();
      addSecretVersionSettings = settings.addSecretVersionSettings.toBuilder();
      getSecretSettings = settings.getSecretSettings.toBuilder();
      updateSecretSettings = settings.updateSecretSettings.toBuilder();
      deleteSecretSettings = settings.deleteSecretSettings.toBuilder();
      listSecretVersionsSettings = settings.listSecretVersionsSettings.toBuilder();
      getSecretVersionSettings = settings.getSecretVersionSettings.toBuilder();
      accessSecretVersionSettings = settings.accessSecretVersionSettings.toBuilder();
      disableSecretVersionSettings = settings.disableSecretVersionSettings.toBuilder();
      enableSecretVersionSettings = settings.enableSecretVersionSettings.toBuilder();
      destroySecretVersionSettings = settings.destroySecretVersionSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSecretsSettings,
              createSecretSettings,
              addSecretVersionSettings,
              getSecretSettings,
              updateSecretSettings,
              deleteSecretSettings,
              listSecretVersionsSettings,
              getSecretVersionSettings,
              accessSecretVersionSettings,
              disableSecretVersionSettings,
              enableSecretVersionSettings,
              destroySecretVersionSettings,
              setIamPolicySettings,
              getIamPolicySettings,
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
          .listSecretsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addSecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSecretVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .accessSecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .disableSecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .enableSecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .destroySecretVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to listSecrets. */
    public PagedCallSettings.Builder<
            ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
        listSecretsSettings() {
      return listSecretsSettings;
    }

    /** Returns the builder for the settings used for calls to createSecret. */
    public UnaryCallSettings.Builder<CreateSecretRequest, Secret> createSecretSettings() {
      return createSecretSettings;
    }

    /** Returns the builder for the settings used for calls to addSecretVersion. */
    public UnaryCallSettings.Builder<AddSecretVersionRequest, SecretVersion>
        addSecretVersionSettings() {
      return addSecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to getSecret. */
    public UnaryCallSettings.Builder<GetSecretRequest, Secret> getSecretSettings() {
      return getSecretSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecret. */
    public UnaryCallSettings.Builder<UpdateSecretRequest, Secret> updateSecretSettings() {
      return updateSecretSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecret. */
    public UnaryCallSettings.Builder<DeleteSecretRequest, Empty> deleteSecretSettings() {
      return deleteSecretSettings;
    }

    /** Returns the builder for the settings used for calls to listSecretVersions. */
    public PagedCallSettings.Builder<
            ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
        listSecretVersionsSettings() {
      return listSecretVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getSecretVersion. */
    public UnaryCallSettings.Builder<GetSecretVersionRequest, SecretVersion>
        getSecretVersionSettings() {
      return getSecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to accessSecretVersion. */
    public UnaryCallSettings.Builder<AccessSecretVersionRequest, AccessSecretVersionResponse>
        accessSecretVersionSettings() {
      return accessSecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to disableSecretVersion. */
    public UnaryCallSettings.Builder<DisableSecretVersionRequest, SecretVersion>
        disableSecretVersionSettings() {
      return disableSecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to enableSecretVersion. */
    public UnaryCallSettings.Builder<EnableSecretVersionRequest, SecretVersion>
        enableSecretVersionSettings() {
      return enableSecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to destroySecretVersion. */
    public UnaryCallSettings.Builder<DestroySecretVersionRequest, SecretVersion>
        destroySecretVersionSettings() {
      return destroySecretVersionSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public SecretManagerServiceStubSettings build() throws IOException {
      return new SecretManagerServiceStubSettings(this);
    }
  }
}
