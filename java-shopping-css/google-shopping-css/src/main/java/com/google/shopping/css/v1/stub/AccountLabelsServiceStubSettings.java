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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountLabelsServiceClient.ListAccountLabelsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.AccountLabel;
import com.google.shopping.css.v1.CreateAccountLabelRequest;
import com.google.shopping.css.v1.DeleteAccountLabelRequest;
import com.google.shopping.css.v1.ListAccountLabelsRequest;
import com.google.shopping.css.v1.ListAccountLabelsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccountLabelsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (css.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAccountLabel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccountLabelsServiceStubSettings.Builder accountLabelsServiceSettingsBuilder =
 *     AccountLabelsServiceStubSettings.newBuilder();
 * accountLabelsServiceSettingsBuilder
 *     .createAccountLabelSettings()
 *     .setRetrySettings(
 *         accountLabelsServiceSettingsBuilder
 *             .createAccountLabelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AccountLabelsServiceStubSettings accountLabelsServiceSettings =
 *     accountLabelsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AccountLabelsServiceStubSettings
    extends StubSettings<AccountLabelsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final PagedCallSettings<
          ListAccountLabelsRequest, ListAccountLabelsResponse, ListAccountLabelsPagedResponse>
      listAccountLabelsSettings;
  private final UnaryCallSettings<CreateAccountLabelRequest, AccountLabel>
      createAccountLabelSettings;
  private final UnaryCallSettings<UpdateAccountLabelRequest, AccountLabel>
      updateAccountLabelSettings;
  private final UnaryCallSettings<DeleteAccountLabelRequest, Empty> deleteAccountLabelSettings;

  private static final PagedListDescriptor<
          ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel>
      LIST_ACCOUNT_LABELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccountLabelsRequest injectToken(
                ListAccountLabelsRequest payload, String token) {
              return ListAccountLabelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccountLabelsRequest injectPageSize(
                ListAccountLabelsRequest payload, int pageSize) {
              return ListAccountLabelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccountLabelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccountLabelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccountLabel> extractResources(ListAccountLabelsResponse payload) {
              return payload.getAccountLabelsList() == null
                  ? ImmutableList.<AccountLabel>of()
                  : payload.getAccountLabelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAccountLabelsRequest, ListAccountLabelsResponse, ListAccountLabelsPagedResponse>
      LIST_ACCOUNT_LABELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccountLabelsRequest,
              ListAccountLabelsResponse,
              ListAccountLabelsPagedResponse>() {
            @Override
            public ApiFuture<ListAccountLabelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse> callable,
                ListAccountLabelsRequest request,
                ApiCallContext context,
                ApiFuture<ListAccountLabelsResponse> futureResponse) {
              PageContext<ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCOUNT_LABELS_PAGE_STR_DESC, request, context);
              return ListAccountLabelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAccountLabels. */
  public PagedCallSettings<
          ListAccountLabelsRequest, ListAccountLabelsResponse, ListAccountLabelsPagedResponse>
      listAccountLabelsSettings() {
    return listAccountLabelsSettings;
  }

  /** Returns the object with the settings used for calls to createAccountLabel. */
  public UnaryCallSettings<CreateAccountLabelRequest, AccountLabel> createAccountLabelSettings() {
    return createAccountLabelSettings;
  }

  /** Returns the object with the settings used for calls to updateAccountLabel. */
  public UnaryCallSettings<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelSettings() {
    return updateAccountLabelSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccountLabel. */
  public UnaryCallSettings<DeleteAccountLabelRequest, Empty> deleteAccountLabelSettings() {
    return deleteAccountLabelSettings;
  }

  public AccountLabelsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAccountLabelsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAccountLabelsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "css";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "css.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "css.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AccountLabelsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AccountLabelsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccountLabelsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AccountLabelsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAccountLabelsSettings = settingsBuilder.listAccountLabelsSettings().build();
    createAccountLabelSettings = settingsBuilder.createAccountLabelSettings().build();
    updateAccountLabelSettings = settingsBuilder.updateAccountLabelSettings().build();
    deleteAccountLabelSettings = settingsBuilder.deleteAccountLabelSettings().build();
  }

  /** Builder for AccountLabelsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AccountLabelsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAccountLabelsRequest, ListAccountLabelsResponse, ListAccountLabelsPagedResponse>
        listAccountLabelsSettings;
    private final UnaryCallSettings.Builder<CreateAccountLabelRequest, AccountLabel>
        createAccountLabelSettings;
    private final UnaryCallSettings.Builder<UpdateAccountLabelRequest, AccountLabel>
        updateAccountLabelSettings;
    private final UnaryCallSettings.Builder<DeleteAccountLabelRequest, Empty>
        deleteAccountLabelSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAccountLabelsSettings = PagedCallSettings.newBuilder(LIST_ACCOUNT_LABELS_PAGE_STR_FACT);
      createAccountLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccountLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccountLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAccountLabelsSettings,
              createAccountLabelSettings,
              updateAccountLabelSettings,
              deleteAccountLabelSettings);
      initDefaults(this);
    }

    protected Builder(AccountLabelsServiceStubSettings settings) {
      super(settings);

      listAccountLabelsSettings = settings.listAccountLabelsSettings.toBuilder();
      createAccountLabelSettings = settings.createAccountLabelSettings.toBuilder();
      updateAccountLabelSettings = settings.updateAccountLabelSettings.toBuilder();
      deleteAccountLabelSettings = settings.deleteAccountLabelSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAccountLabelsSettings,
              createAccountLabelSettings,
              updateAccountLabelSettings,
              deleteAccountLabelSettings);
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
          .listAccountLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAccountLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAccountLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAccountLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to listAccountLabels. */
    public PagedCallSettings.Builder<
            ListAccountLabelsRequest, ListAccountLabelsResponse, ListAccountLabelsPagedResponse>
        listAccountLabelsSettings() {
      return listAccountLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to createAccountLabel. */
    public UnaryCallSettings.Builder<CreateAccountLabelRequest, AccountLabel>
        createAccountLabelSettings() {
      return createAccountLabelSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccountLabel. */
    public UnaryCallSettings.Builder<UpdateAccountLabelRequest, AccountLabel>
        updateAccountLabelSettings() {
      return updateAccountLabelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccountLabel. */
    public UnaryCallSettings.Builder<DeleteAccountLabelRequest, Empty>
        deleteAccountLabelSettings() {
      return deleteAccountLabelSettings;
    }

    @Override
    public AccountLabelsServiceStubSettings build() throws IOException {
      return new AccountLabelsServiceStubSettings(this);
    }
  }
}
