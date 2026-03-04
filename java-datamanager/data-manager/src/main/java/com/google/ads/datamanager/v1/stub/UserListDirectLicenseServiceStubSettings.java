/*
 * Copyright 2026 Google LLC
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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient.ListUserListDirectLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.UserListDirectLicense;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UserListDirectLicenseServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datamanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createUserListDirectLicense:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserListDirectLicenseServiceStubSettings.Builder userListDirectLicenseServiceSettingsBuilder =
 *     UserListDirectLicenseServiceStubSettings.newBuilder();
 * userListDirectLicenseServiceSettingsBuilder
 *     .createUserListDirectLicenseSettings()
 *     .setRetrySettings(
 *         userListDirectLicenseServiceSettingsBuilder
 *             .createUserListDirectLicenseSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * UserListDirectLicenseServiceStubSettings userListDirectLicenseServiceSettings =
 *     userListDirectLicenseServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class UserListDirectLicenseServiceStubSettings
    extends StubSettings<UserListDirectLicenseServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/datamanager").build();

  private final UnaryCallSettings<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseSettings;
  private final UnaryCallSettings<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseSettings;
  private final UnaryCallSettings<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseSettings;
  private final PagedCallSettings<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesSettings;

  private static final PagedListDescriptor<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          UserListDirectLicense>
      LIST_USER_LIST_DIRECT_LICENSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserListDirectLicensesRequest,
              ListUserListDirectLicensesResponse,
              UserListDirectLicense>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserListDirectLicensesRequest injectToken(
                ListUserListDirectLicensesRequest payload, String token) {
              return ListUserListDirectLicensesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUserListDirectLicensesRequest injectPageSize(
                ListUserListDirectLicensesRequest payload, int pageSize) {
              return ListUserListDirectLicensesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUserListDirectLicensesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserListDirectLicensesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserListDirectLicense> extractResources(
                ListUserListDirectLicensesResponse payload) {
              return payload.getUserListDirectLicensesList();
            }
          };

  private static final PagedListResponseFactory<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          ListUserListDirectLicensesPagedResponse>
      LIST_USER_LIST_DIRECT_LICENSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserListDirectLicensesRequest,
              ListUserListDirectLicensesResponse,
              ListUserListDirectLicensesPagedResponse>() {
            @Override
            public ApiFuture<ListUserListDirectLicensesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
                    callable,
                ListUserListDirectLicensesRequest request,
                ApiCallContext context,
                ApiFuture<ListUserListDirectLicensesResponse> futureResponse) {
              PageContext<
                      ListUserListDirectLicensesRequest,
                      ListUserListDirectLicensesResponse,
                      UserListDirectLicense>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USER_LIST_DIRECT_LICENSES_PAGE_STR_DESC, request, context);
              return ListUserListDirectLicensesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createUserListDirectLicense. */
  public UnaryCallSettings<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseSettings() {
    return createUserListDirectLicenseSettings;
  }

  /** Returns the object with the settings used for calls to getUserListDirectLicense. */
  public UnaryCallSettings<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseSettings() {
    return getUserListDirectLicenseSettings;
  }

  /** Returns the object with the settings used for calls to updateUserListDirectLicense. */
  public UnaryCallSettings<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseSettings() {
    return updateUserListDirectLicenseSettings;
  }

  /** Returns the object with the settings used for calls to listUserListDirectLicenses. */
  public PagedCallSettings<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesSettings() {
    return listUserListDirectLicensesSettings;
  }

  public UserListDirectLicenseServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUserListDirectLicenseServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUserListDirectLicenseServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "datamanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "datamanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datamanager.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(UserListDirectLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(UserListDirectLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UserListDirectLicenseServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected UserListDirectLicenseServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createUserListDirectLicenseSettings =
        settingsBuilder.createUserListDirectLicenseSettings().build();
    getUserListDirectLicenseSettings = settingsBuilder.getUserListDirectLicenseSettings().build();
    updateUserListDirectLicenseSettings =
        settingsBuilder.updateUserListDirectLicenseSettings().build();
    listUserListDirectLicensesSettings =
        settingsBuilder.listUserListDirectLicensesSettings().build();
  }

  /** Builder for UserListDirectLicenseServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<UserListDirectLicenseServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreateUserListDirectLicenseRequest, UserListDirectLicense>
        createUserListDirectLicenseSettings;
    private final UnaryCallSettings.Builder<GetUserListDirectLicenseRequest, UserListDirectLicense>
        getUserListDirectLicenseSettings;
    private final UnaryCallSettings.Builder<
            UpdateUserListDirectLicenseRequest, UserListDirectLicense>
        updateUserListDirectLicenseSettings;
    private final PagedCallSettings.Builder<
            ListUserListDirectLicensesRequest,
            ListUserListDirectLicensesResponse,
            ListUserListDirectLicensesPagedResponse>
        listUserListDirectLicensesSettings;
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

      createUserListDirectLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserListDirectLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserListDirectLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserListDirectLicensesSettings =
          PagedCallSettings.newBuilder(LIST_USER_LIST_DIRECT_LICENSES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createUserListDirectLicenseSettings,
              getUserListDirectLicenseSettings,
              updateUserListDirectLicenseSettings,
              listUserListDirectLicensesSettings);
      initDefaults(this);
    }

    protected Builder(UserListDirectLicenseServiceStubSettings settings) {
      super(settings);

      createUserListDirectLicenseSettings =
          settings.createUserListDirectLicenseSettings.toBuilder();
      getUserListDirectLicenseSettings = settings.getUserListDirectLicenseSettings.toBuilder();
      updateUserListDirectLicenseSettings =
          settings.updateUserListDirectLicenseSettings.toBuilder();
      listUserListDirectLicensesSettings = settings.listUserListDirectLicensesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createUserListDirectLicenseSettings,
              getUserListDirectLicenseSettings,
              updateUserListDirectLicenseSettings,
              listUserListDirectLicensesSettings);
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
          .createUserListDirectLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getUserListDirectLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateUserListDirectLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserListDirectLicensesSettings()
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

    /** Returns the builder for the settings used for calls to createUserListDirectLicense. */
    public UnaryCallSettings.Builder<CreateUserListDirectLicenseRequest, UserListDirectLicense>
        createUserListDirectLicenseSettings() {
      return createUserListDirectLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to getUserListDirectLicense. */
    public UnaryCallSettings.Builder<GetUserListDirectLicenseRequest, UserListDirectLicense>
        getUserListDirectLicenseSettings() {
      return getUserListDirectLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserListDirectLicense. */
    public UnaryCallSettings.Builder<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
        updateUserListDirectLicenseSettings() {
      return updateUserListDirectLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to listUserListDirectLicenses. */
    public PagedCallSettings.Builder<
            ListUserListDirectLicensesRequest,
            ListUserListDirectLicensesResponse,
            ListUserListDirectLicensesPagedResponse>
        listUserListDirectLicensesSettings() {
      return listUserListDirectLicensesSettings;
    }

    @Override
    public UserListDirectLicenseServiceStubSettings build() throws IOException {
      return new UserListDirectLicenseServiceStubSettings(this);
    }
  }
}
