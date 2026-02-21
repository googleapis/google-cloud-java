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

import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicenseCustomerInfosPagedResponse;
import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.UserListGlobalLicense;
import com.google.ads.datamanager.v1.UserListGlobalLicenseCustomerInfo;
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
 * Settings class to configure an instance of {@link UserListGlobalLicenseServiceStub}.
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
 * of createUserListGlobalLicense:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserListGlobalLicenseServiceStubSettings.Builder userListGlobalLicenseServiceSettingsBuilder =
 *     UserListGlobalLicenseServiceStubSettings.newBuilder();
 * userListGlobalLicenseServiceSettingsBuilder
 *     .createUserListGlobalLicenseSettings()
 *     .setRetrySettings(
 *         userListGlobalLicenseServiceSettingsBuilder
 *             .createUserListGlobalLicenseSettings()
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
 * UserListGlobalLicenseServiceStubSettings userListGlobalLicenseServiceSettings =
 *     userListGlobalLicenseServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class UserListGlobalLicenseServiceStubSettings
    extends StubSettings<UserListGlobalLicenseServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/datamanager").build();

  private final UnaryCallSettings<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseSettings;
  private final UnaryCallSettings<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseSettings;
  private final UnaryCallSettings<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseSettings;
  private final PagedCallSettings<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesSettings;
  private final PagedCallSettings<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosSettings;

  private static final PagedListDescriptor<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          UserListGlobalLicense>
      LIST_USER_LIST_GLOBAL_LICENSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserListGlobalLicensesRequest,
              ListUserListGlobalLicensesResponse,
              UserListGlobalLicense>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserListGlobalLicensesRequest injectToken(
                ListUserListGlobalLicensesRequest payload, String token) {
              return ListUserListGlobalLicensesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUserListGlobalLicensesRequest injectPageSize(
                ListUserListGlobalLicensesRequest payload, int pageSize) {
              return ListUserListGlobalLicensesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUserListGlobalLicensesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserListGlobalLicensesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserListGlobalLicense> extractResources(
                ListUserListGlobalLicensesResponse payload) {
              return payload.getUserListGlobalLicensesList();
            }
          };

  private static final PagedListDescriptor<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          UserListGlobalLicenseCustomerInfo>
      LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserListGlobalLicenseCustomerInfosRequest,
              ListUserListGlobalLicenseCustomerInfosResponse,
              UserListGlobalLicenseCustomerInfo>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserListGlobalLicenseCustomerInfosRequest injectToken(
                ListUserListGlobalLicenseCustomerInfosRequest payload, String token) {
              return ListUserListGlobalLicenseCustomerInfosRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUserListGlobalLicenseCustomerInfosRequest injectPageSize(
                ListUserListGlobalLicenseCustomerInfosRequest payload, int pageSize) {
              return ListUserListGlobalLicenseCustomerInfosRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUserListGlobalLicenseCustomerInfosRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserListGlobalLicenseCustomerInfosResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserListGlobalLicenseCustomerInfo> extractResources(
                ListUserListGlobalLicenseCustomerInfosResponse payload) {
              return payload.getUserListGlobalLicenseCustomerInfosList();
            }
          };

  private static final PagedListResponseFactory<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          ListUserListGlobalLicensesPagedResponse>
      LIST_USER_LIST_GLOBAL_LICENSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserListGlobalLicensesRequest,
              ListUserListGlobalLicensesResponse,
              ListUserListGlobalLicensesPagedResponse>() {
            @Override
            public ApiFuture<ListUserListGlobalLicensesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
                    callable,
                ListUserListGlobalLicensesRequest request,
                ApiCallContext context,
                ApiFuture<ListUserListGlobalLicensesResponse> futureResponse) {
              PageContext<
                      ListUserListGlobalLicensesRequest,
                      ListUserListGlobalLicensesResponse,
                      UserListGlobalLicense>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USER_LIST_GLOBAL_LICENSES_PAGE_STR_DESC, request, context);
              return ListUserListGlobalLicensesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserListGlobalLicenseCustomerInfosRequest,
              ListUserListGlobalLicenseCustomerInfosResponse,
              ListUserListGlobalLicenseCustomerInfosPagedResponse>() {
            @Override
            public ApiFuture<ListUserListGlobalLicenseCustomerInfosPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListUserListGlobalLicenseCustomerInfosRequest,
                            ListUserListGlobalLicenseCustomerInfosResponse>
                        callable,
                    ListUserListGlobalLicenseCustomerInfosRequest request,
                    ApiCallContext context,
                    ApiFuture<ListUserListGlobalLicenseCustomerInfosResponse> futureResponse) {
              PageContext<
                      ListUserListGlobalLicenseCustomerInfosRequest,
                      ListUserListGlobalLicenseCustomerInfosResponse,
                      UserListGlobalLicenseCustomerInfo>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS_PAGE_STR_DESC,
                          request,
                          context);
              return ListUserListGlobalLicenseCustomerInfosPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createUserListGlobalLicense. */
  public UnaryCallSettings<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseSettings() {
    return createUserListGlobalLicenseSettings;
  }

  /** Returns the object with the settings used for calls to updateUserListGlobalLicense. */
  public UnaryCallSettings<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseSettings() {
    return updateUserListGlobalLicenseSettings;
  }

  /** Returns the object with the settings used for calls to getUserListGlobalLicense. */
  public UnaryCallSettings<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseSettings() {
    return getUserListGlobalLicenseSettings;
  }

  /** Returns the object with the settings used for calls to listUserListGlobalLicenses. */
  public PagedCallSettings<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesSettings() {
    return listUserListGlobalLicensesSettings;
  }

  /**
   * Returns the object with the settings used for calls to listUserListGlobalLicenseCustomerInfos.
   */
  public PagedCallSettings<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosSettings() {
    return listUserListGlobalLicenseCustomerInfosSettings;
  }

  public UserListGlobalLicenseServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUserListGlobalLicenseServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUserListGlobalLicenseServiceStub.create(this);
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
            GaxProperties.getLibraryVersion(UserListGlobalLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(UserListGlobalLicenseServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UserListGlobalLicenseServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected UserListGlobalLicenseServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createUserListGlobalLicenseSettings =
        settingsBuilder.createUserListGlobalLicenseSettings().build();
    updateUserListGlobalLicenseSettings =
        settingsBuilder.updateUserListGlobalLicenseSettings().build();
    getUserListGlobalLicenseSettings = settingsBuilder.getUserListGlobalLicenseSettings().build();
    listUserListGlobalLicensesSettings =
        settingsBuilder.listUserListGlobalLicensesSettings().build();
    listUserListGlobalLicenseCustomerInfosSettings =
        settingsBuilder.listUserListGlobalLicenseCustomerInfosSettings().build();
  }

  /** Builder for UserListGlobalLicenseServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<UserListGlobalLicenseServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
        createUserListGlobalLicenseSettings;
    private final UnaryCallSettings.Builder<
            UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
        updateUserListGlobalLicenseSettings;
    private final UnaryCallSettings.Builder<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
        getUserListGlobalLicenseSettings;
    private final PagedCallSettings.Builder<
            ListUserListGlobalLicensesRequest,
            ListUserListGlobalLicensesResponse,
            ListUserListGlobalLicensesPagedResponse>
        listUserListGlobalLicensesSettings;
    private final PagedCallSettings.Builder<
            ListUserListGlobalLicenseCustomerInfosRequest,
            ListUserListGlobalLicenseCustomerInfosResponse,
            ListUserListGlobalLicenseCustomerInfosPagedResponse>
        listUserListGlobalLicenseCustomerInfosSettings;
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

      createUserListGlobalLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserListGlobalLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserListGlobalLicenseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserListGlobalLicensesSettings =
          PagedCallSettings.newBuilder(LIST_USER_LIST_GLOBAL_LICENSES_PAGE_STR_FACT);
      listUserListGlobalLicenseCustomerInfosSettings =
          PagedCallSettings.newBuilder(LIST_USER_LIST_GLOBAL_LICENSE_CUSTOMER_INFOS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createUserListGlobalLicenseSettings,
              updateUserListGlobalLicenseSettings,
              getUserListGlobalLicenseSettings,
              listUserListGlobalLicensesSettings,
              listUserListGlobalLicenseCustomerInfosSettings);
      initDefaults(this);
    }

    protected Builder(UserListGlobalLicenseServiceStubSettings settings) {
      super(settings);

      createUserListGlobalLicenseSettings =
          settings.createUserListGlobalLicenseSettings.toBuilder();
      updateUserListGlobalLicenseSettings =
          settings.updateUserListGlobalLicenseSettings.toBuilder();
      getUserListGlobalLicenseSettings = settings.getUserListGlobalLicenseSettings.toBuilder();
      listUserListGlobalLicensesSettings = settings.listUserListGlobalLicensesSettings.toBuilder();
      listUserListGlobalLicenseCustomerInfosSettings =
          settings.listUserListGlobalLicenseCustomerInfosSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createUserListGlobalLicenseSettings,
              updateUserListGlobalLicenseSettings,
              getUserListGlobalLicenseSettings,
              listUserListGlobalLicensesSettings,
              listUserListGlobalLicenseCustomerInfosSettings);
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
          .createUserListGlobalLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateUserListGlobalLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getUserListGlobalLicenseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserListGlobalLicensesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserListGlobalLicenseCustomerInfosSettings()
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

    /** Returns the builder for the settings used for calls to createUserListGlobalLicense. */
    public UnaryCallSettings.Builder<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
        createUserListGlobalLicenseSettings() {
      return createUserListGlobalLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserListGlobalLicense. */
    public UnaryCallSettings.Builder<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
        updateUserListGlobalLicenseSettings() {
      return updateUserListGlobalLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to getUserListGlobalLicense. */
    public UnaryCallSettings.Builder<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
        getUserListGlobalLicenseSettings() {
      return getUserListGlobalLicenseSettings;
    }

    /** Returns the builder for the settings used for calls to listUserListGlobalLicenses. */
    public PagedCallSettings.Builder<
            ListUserListGlobalLicensesRequest,
            ListUserListGlobalLicensesResponse,
            ListUserListGlobalLicensesPagedResponse>
        listUserListGlobalLicensesSettings() {
      return listUserListGlobalLicensesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listUserListGlobalLicenseCustomerInfos.
     */
    public PagedCallSettings.Builder<
            ListUserListGlobalLicenseCustomerInfosRequest,
            ListUserListGlobalLicenseCustomerInfosResponse,
            ListUserListGlobalLicenseCustomerInfosPagedResponse>
        listUserListGlobalLicenseCustomerInfosSettings() {
      return listUserListGlobalLicenseCustomerInfosSettings;
    }

    @Override
    public UserListGlobalLicenseServiceStubSettings build() throws IOException {
      return new UserListGlobalLicenseServiceStubSettings(this);
    }
  }
}
