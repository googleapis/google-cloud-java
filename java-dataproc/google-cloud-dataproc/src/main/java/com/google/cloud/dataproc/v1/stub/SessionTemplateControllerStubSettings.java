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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.SessionTemplateControllerClient.ListSessionTemplatesPagedResponse;

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
import com.google.cloud.dataproc.v1.CreateSessionTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest;
import com.google.cloud.dataproc.v1.GetSessionTemplateRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesResponse;
import com.google.cloud.dataproc.v1.SessionTemplate;
import com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SessionTemplateControllerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSessionTemplate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SessionTemplateControllerStubSettings.Builder sessionTemplateControllerSettingsBuilder =
 *     SessionTemplateControllerStubSettings.newBuilder();
 * sessionTemplateControllerSettingsBuilder
 *     .createSessionTemplateSettings()
 *     .setRetrySettings(
 *         sessionTemplateControllerSettingsBuilder
 *             .createSessionTemplateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SessionTemplateControllerStubSettings sessionTemplateControllerSettings =
 *     sessionTemplateControllerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SessionTemplateControllerStubSettings
    extends StubSettings<SessionTemplateControllerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateSettings;
  private final UnaryCallSettings<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateSettings;
  private final UnaryCallSettings<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateSettings;
  private final PagedCallSettings<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          ListSessionTemplatesPagedResponse>
      listSessionTemplatesSettings;
  private final UnaryCallSettings<DeleteSessionTemplateRequest, Empty>
      deleteSessionTemplateSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
      LIST_SESSION_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSessionTemplatesRequest injectToken(
                ListSessionTemplatesRequest payload, String token) {
              return ListSessionTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSessionTemplatesRequest injectPageSize(
                ListSessionTemplatesRequest payload, int pageSize) {
              return ListSessionTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSessionTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSessionTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SessionTemplate> extractResources(
                ListSessionTemplatesResponse payload) {
              return payload.getSessionTemplatesList() == null
                  ? ImmutableList.<SessionTemplate>of()
                  : payload.getSessionTemplatesList();
            }
          };

  private static final PagedListResponseFactory<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          ListSessionTemplatesPagedResponse>
      LIST_SESSION_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSessionTemplatesRequest,
              ListSessionTemplatesResponse,
              ListSessionTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListSessionTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse> callable,
                ListSessionTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListSessionTemplatesResponse> futureResponse) {
              PageContext<
                      ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SESSION_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListSessionTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSessionTemplate. */
  public UnaryCallSettings<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateSettings() {
    return createSessionTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateSessionTemplate. */
  public UnaryCallSettings<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateSettings() {
    return updateSessionTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getSessionTemplate. */
  public UnaryCallSettings<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateSettings() {
    return getSessionTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listSessionTemplates. */
  public PagedCallSettings<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          ListSessionTemplatesPagedResponse>
      listSessionTemplatesSettings() {
    return listSessionTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteSessionTemplate. */
  public UnaryCallSettings<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateSettings() {
    return deleteSessionTemplateSettings;
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

  public SessionTemplateControllerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSessionTemplateControllerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSessionTemplateControllerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dataproc";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dataproc.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataproc.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SessionTemplateControllerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SessionTemplateControllerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SessionTemplateControllerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SessionTemplateControllerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSessionTemplateSettings = settingsBuilder.createSessionTemplateSettings().build();
    updateSessionTemplateSettings = settingsBuilder.updateSessionTemplateSettings().build();
    getSessionTemplateSettings = settingsBuilder.getSessionTemplateSettings().build();
    listSessionTemplatesSettings = settingsBuilder.listSessionTemplatesSettings().build();
    deleteSessionTemplateSettings = settingsBuilder.deleteSessionTemplateSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for SessionTemplateControllerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SessionTemplateControllerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSessionTemplateRequest, SessionTemplate>
        createSessionTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateSessionTemplateRequest, SessionTemplate>
        updateSessionTemplateSettings;
    private final UnaryCallSettings.Builder<GetSessionTemplateRequest, SessionTemplate>
        getSessionTemplateSettings;
    private final PagedCallSettings.Builder<
            ListSessionTemplatesRequest,
            ListSessionTemplatesResponse,
            ListSessionTemplatesPagedResponse>
        listSessionTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteSessionTemplateRequest, Empty>
        deleteSessionTemplateSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSessionTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSessionTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSessionTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSessionTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_SESSION_TEMPLATES_PAGE_STR_FACT);
      deleteSessionTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSessionTemplateSettings,
              updateSessionTemplateSettings,
              getSessionTemplateSettings,
              listSessionTemplatesSettings,
              deleteSessionTemplateSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SessionTemplateControllerStubSettings settings) {
      super(settings);

      createSessionTemplateSettings = settings.createSessionTemplateSettings.toBuilder();
      updateSessionTemplateSettings = settings.updateSessionTemplateSettings.toBuilder();
      getSessionTemplateSettings = settings.getSessionTemplateSettings.toBuilder();
      listSessionTemplatesSettings = settings.listSessionTemplatesSettings.toBuilder();
      deleteSessionTemplateSettings = settings.deleteSessionTemplateSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSessionTemplateSettings,
              updateSessionTemplateSettings,
              getSessionTemplateSettings,
              listSessionTemplatesSettings,
              deleteSessionTemplateSettings,
              setIamPolicySettings,
              getIamPolicySettings,
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createSessionTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSessionTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSessionTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSessionTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSessionTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createSessionTemplate. */
    public UnaryCallSettings.Builder<CreateSessionTemplateRequest, SessionTemplate>
        createSessionTemplateSettings() {
      return createSessionTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateSessionTemplate. */
    public UnaryCallSettings.Builder<UpdateSessionTemplateRequest, SessionTemplate>
        updateSessionTemplateSettings() {
      return updateSessionTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getSessionTemplate. */
    public UnaryCallSettings.Builder<GetSessionTemplateRequest, SessionTemplate>
        getSessionTemplateSettings() {
      return getSessionTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listSessionTemplates. */
    public PagedCallSettings.Builder<
            ListSessionTemplatesRequest,
            ListSessionTemplatesResponse,
            ListSessionTemplatesPagedResponse>
        listSessionTemplatesSettings() {
      return listSessionTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSessionTemplate. */
    public UnaryCallSettings.Builder<DeleteSessionTemplateRequest, Empty>
        deleteSessionTemplateSettings() {
      return deleteSessionTemplateSettings;
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
    public SessionTemplateControllerStubSettings build() throws IOException {
      return new SessionTemplateControllerStubSettings(this);
    }
  }
}
