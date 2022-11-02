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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

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
import com.google.appengine.v1.AuthorizedCertificate;
import com.google.appengine.v1.CreateAuthorizedCertificateRequest;
import com.google.appengine.v1.DeleteAuthorizedCertificateRequest;
import com.google.appengine.v1.GetAuthorizedCertificateRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesResponse;
import com.google.appengine.v1.UpdateAuthorizedCertificateRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AuthorizedCertificatesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAuthorizedCertificate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuthorizedCertificatesStubSettings.Builder authorizedCertificatesSettingsBuilder =
 *     AuthorizedCertificatesStubSettings.newBuilder();
 * authorizedCertificatesSettingsBuilder
 *     .getAuthorizedCertificateSettings()
 *     .setRetrySettings(
 *         authorizedCertificatesSettingsBuilder
 *             .getAuthorizedCertificateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AuthorizedCertificatesStubSettings authorizedCertificatesSettings =
 *     authorizedCertificatesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AuthorizedCertificatesStubSettings
    extends StubSettings<AuthorizedCertificatesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/appengine.admin")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesSettings;
  private final UnaryCallSettings<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateSettings;
  private final UnaryCallSettings<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateSettings;
  private final UnaryCallSettings<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateSettings;
  private final UnaryCallSettings<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateSettings;

  private static final PagedListDescriptor<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          AuthorizedCertificate>
      LIST_AUTHORIZED_CERTIFICATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuthorizedCertificatesRequest,
              ListAuthorizedCertificatesResponse,
              AuthorizedCertificate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuthorizedCertificatesRequest injectToken(
                ListAuthorizedCertificatesRequest payload, String token) {
              return ListAuthorizedCertificatesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAuthorizedCertificatesRequest injectPageSize(
                ListAuthorizedCertificatesRequest payload, int pageSize) {
              return ListAuthorizedCertificatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAuthorizedCertificatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuthorizedCertificatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuthorizedCertificate> extractResources(
                ListAuthorizedCertificatesResponse payload) {
              return payload.getCertificatesList() == null
                  ? ImmutableList.<AuthorizedCertificate>of()
                  : payload.getCertificatesList();
            }
          };

  private static final PagedListResponseFactory<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          ListAuthorizedCertificatesPagedResponse>
      LIST_AUTHORIZED_CERTIFICATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuthorizedCertificatesRequest,
              ListAuthorizedCertificatesResponse,
              ListAuthorizedCertificatesPagedResponse>() {
            @Override
            public ApiFuture<ListAuthorizedCertificatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
                    callable,
                ListAuthorizedCertificatesRequest request,
                ApiCallContext context,
                ApiFuture<ListAuthorizedCertificatesResponse> futureResponse) {
              PageContext<
                      ListAuthorizedCertificatesRequest,
                      ListAuthorizedCertificatesResponse,
                      AuthorizedCertificate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTHORIZED_CERTIFICATES_PAGE_STR_DESC, request, context);
              return ListAuthorizedCertificatesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAuthorizedCertificates. */
  public PagedCallSettings<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesSettings() {
    return listAuthorizedCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to getAuthorizedCertificate. */
  public UnaryCallSettings<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateSettings() {
    return getAuthorizedCertificateSettings;
  }

  /** Returns the object with the settings used for calls to createAuthorizedCertificate. */
  public UnaryCallSettings<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateSettings() {
    return createAuthorizedCertificateSettings;
  }

  /** Returns the object with the settings used for calls to updateAuthorizedCertificate. */
  public UnaryCallSettings<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateSettings() {
    return updateAuthorizedCertificateSettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthorizedCertificate. */
  public UnaryCallSettings<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateSettings() {
    return deleteAuthorizedCertificateSettings;
  }

  public AuthorizedCertificatesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAuthorizedCertificatesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAuthorizedCertificatesStub.create(this);
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
    return "appengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "appengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AuthorizedCertificatesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AuthorizedCertificatesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuthorizedCertificatesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AuthorizedCertificatesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAuthorizedCertificatesSettings =
        settingsBuilder.listAuthorizedCertificatesSettings().build();
    getAuthorizedCertificateSettings = settingsBuilder.getAuthorizedCertificateSettings().build();
    createAuthorizedCertificateSettings =
        settingsBuilder.createAuthorizedCertificateSettings().build();
    updateAuthorizedCertificateSettings =
        settingsBuilder.updateAuthorizedCertificateSettings().build();
    deleteAuthorizedCertificateSettings =
        settingsBuilder.deleteAuthorizedCertificateSettings().build();
  }

  /** Builder for AuthorizedCertificatesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AuthorizedCertificatesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAuthorizedCertificatesRequest,
            ListAuthorizedCertificatesResponse,
            ListAuthorizedCertificatesPagedResponse>
        listAuthorizedCertificatesSettings;
    private final UnaryCallSettings.Builder<GetAuthorizedCertificateRequest, AuthorizedCertificate>
        getAuthorizedCertificateSettings;
    private final UnaryCallSettings.Builder<
            CreateAuthorizedCertificateRequest, AuthorizedCertificate>
        createAuthorizedCertificateSettings;
    private final UnaryCallSettings.Builder<
            UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
        updateAuthorizedCertificateSettings;
    private final UnaryCallSettings.Builder<DeleteAuthorizedCertificateRequest, Empty>
        deleteAuthorizedCertificateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAuthorizedCertificatesSettings =
          PagedCallSettings.newBuilder(LIST_AUTHORIZED_CERTIFICATES_PAGE_STR_FACT);
      getAuthorizedCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthorizedCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAuthorizedCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAuthorizedCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizedCertificatesSettings,
              getAuthorizedCertificateSettings,
              createAuthorizedCertificateSettings,
              updateAuthorizedCertificateSettings,
              deleteAuthorizedCertificateSettings);
      initDefaults(this);
    }

    protected Builder(AuthorizedCertificatesStubSettings settings) {
      super(settings);

      listAuthorizedCertificatesSettings = settings.listAuthorizedCertificatesSettings.toBuilder();
      getAuthorizedCertificateSettings = settings.getAuthorizedCertificateSettings.toBuilder();
      createAuthorizedCertificateSettings =
          settings.createAuthorizedCertificateSettings.toBuilder();
      updateAuthorizedCertificateSettings =
          settings.updateAuthorizedCertificateSettings.toBuilder();
      deleteAuthorizedCertificateSettings =
          settings.deleteAuthorizedCertificateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizedCertificatesSettings,
              getAuthorizedCertificateSettings,
              createAuthorizedCertificateSettings,
              updateAuthorizedCertificateSettings,
              deleteAuthorizedCertificateSettings);
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
          .listAuthorizedCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAuthorizedCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAuthorizedCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAuthorizedCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAuthorizedCertificateSettings()
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

    /** Returns the builder for the settings used for calls to listAuthorizedCertificates. */
    public PagedCallSettings.Builder<
            ListAuthorizedCertificatesRequest,
            ListAuthorizedCertificatesResponse,
            ListAuthorizedCertificatesPagedResponse>
        listAuthorizedCertificatesSettings() {
      return listAuthorizedCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to getAuthorizedCertificate. */
    public UnaryCallSettings.Builder<GetAuthorizedCertificateRequest, AuthorizedCertificate>
        getAuthorizedCertificateSettings() {
      return getAuthorizedCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to createAuthorizedCertificate. */
    public UnaryCallSettings.Builder<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
        createAuthorizedCertificateSettings() {
      return createAuthorizedCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthorizedCertificate. */
    public UnaryCallSettings.Builder<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
        updateAuthorizedCertificateSettings() {
      return updateAuthorizedCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizedCertificate. */
    public UnaryCallSettings.Builder<DeleteAuthorizedCertificateRequest, Empty>
        deleteAuthorizedCertificateSettings() {
      return deleteAuthorizedCertificateSettings;
    }

    @Override
    public AuthorizedCertificatesStubSettings build() throws IOException {
      return new AuthorizedCertificatesStubSettings(this);
    }
  }
}
