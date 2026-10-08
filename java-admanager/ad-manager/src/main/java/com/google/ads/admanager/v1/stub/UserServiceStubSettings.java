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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.UserServiceClient.ListUsersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateUsersRequest;
import com.google.ads.admanager.v1.BatchActivateUsersResponse;
import com.google.ads.admanager.v1.BatchCreateUsersRequest;
import com.google.ads.admanager.v1.BatchCreateUsersResponse;
import com.google.ads.admanager.v1.BatchDeactivateUsersRequest;
import com.google.ads.admanager.v1.BatchDeactivateUsersResponse;
import com.google.ads.admanager.v1.BatchUpdateUsersRequest;
import com.google.ads.admanager.v1.BatchUpdateUsersResponse;
import com.google.ads.admanager.v1.CreateUserRequest;
import com.google.ads.admanager.v1.GetUserRequest;
import com.google.ads.admanager.v1.ListUsersRequest;
import com.google.ads.admanager.v1.ListUsersResponse;
import com.google.ads.admanager.v1.UpdateUserRequest;
import com.google.ads.admanager.v1.User;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UserServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getUser:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserServiceStubSettings.Builder userServiceSettingsBuilder =
 *     UserServiceStubSettings.newBuilder();
 * userServiceSettingsBuilder
 *     .getUserSettings()
 *     .setRetrySettings(
 *         userServiceSettingsBuilder
 *             .getUserSettings()
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
 * UserServiceStubSettings userServiceSettings = userServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class UserServiceStubSettings extends StubSettings<UserServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetUserRequest, User> getUserSettings;
  private final PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings;
  private final UnaryCallSettings<CreateUserRequest, User> createUserSettings;
  private final UnaryCallSettings<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersSettings;
  private final UnaryCallSettings<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersSettings;
  private final UnaryCallSettings<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersSettings;
  private final UnaryCallSettings<UpdateUserRequest, User> updateUserSettings;
  private final UnaryCallSettings<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersSettings;

  private static final PagedListDescriptor<ListUsersRequest, ListUsersResponse, User>
      LIST_USERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUsersRequest, ListUsersResponse, User>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsersRequest injectToken(ListUsersRequest payload, String token) {
              return ListUsersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUsersRequest injectPageSize(ListUsersRequest payload, int pageSize) {
              return ListUsersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUsersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUsersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<User> extractResources(ListUsersResponse payload) {
              return payload.getUsersList();
            }
          };

  private static final PagedListResponseFactory<
          ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      LIST_USERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>() {
            @Override
            public ApiFuture<ListUsersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsersRequest, ListUsersResponse> callable,
                ListUsersRequest request,
                ApiCallContext context,
                ApiFuture<ListUsersResponse> futureResponse) {
              PageContext<ListUsersRequest, ListUsersResponse, User> pageContext =
                  PageContext.create(callable, LIST_USERS_PAGE_STR_DESC, request, context);
              return ListUsersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getUser. */
  public UnaryCallSettings<GetUserRequest, User> getUserSettings() {
    return getUserSettings;
  }

  /** Returns the object with the settings used for calls to listUsers. */
  public PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings() {
    return listUsersSettings;
  }

  /** Returns the object with the settings used for calls to createUser. */
  public UnaryCallSettings<CreateUserRequest, User> createUserSettings() {
    return createUserSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateUsers. */
  public UnaryCallSettings<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersSettings() {
    return batchCreateUsersSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateUsers. */
  public UnaryCallSettings<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersSettings() {
    return batchActivateUsersSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateUsers. */
  public UnaryCallSettings<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersSettings() {
    return batchDeactivateUsersSettings;
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public UnaryCallSettings<UpdateUserRequest, User> updateUserSettings() {
    return updateUserSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateUsers. */
  public UnaryCallSettings<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersSettings() {
    return batchUpdateUsersSettings;
  }

  public UserServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUserServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(UserServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected UserServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getUserSettings = settingsBuilder.getUserSettings().build();
    listUsersSettings = settingsBuilder.listUsersSettings().build();
    createUserSettings = settingsBuilder.createUserSettings().build();
    batchCreateUsersSettings = settingsBuilder.batchCreateUsersSettings().build();
    batchActivateUsersSettings = settingsBuilder.batchActivateUsersSettings().build();
    batchDeactivateUsersSettings = settingsBuilder.batchDeactivateUsersSettings().build();
    updateUserSettings = settingsBuilder.updateUserSettings().build();
    batchUpdateUsersSettings = settingsBuilder.batchUpdateUsersSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for UserServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<UserServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings;
    private final PagedCallSettings.Builder<
            ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings;
    private final UnaryCallSettings.Builder<CreateUserRequest, User> createUserSettings;
    private final UnaryCallSettings.Builder<BatchCreateUsersRequest, BatchCreateUsersResponse>
        batchCreateUsersSettings;
    private final UnaryCallSettings.Builder<BatchActivateUsersRequest, BatchActivateUsersResponse>
        batchActivateUsersSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
        batchDeactivateUsersSettings;
    private final UnaryCallSettings.Builder<UpdateUserRequest, User> updateUserSettings;
    private final UnaryCallSettings.Builder<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
        batchUpdateUsersSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUsersSettings = PagedCallSettings.newBuilder(LIST_USERS_PAGE_STR_FACT);
      createUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateUsersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateUsersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateUsersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateUsersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getUserSettings,
              listUsersSettings,
              createUserSettings,
              batchCreateUsersSettings,
              batchActivateUsersSettings,
              batchDeactivateUsersSettings,
              updateUserSettings,
              batchUpdateUsersSettings);
      initDefaults(this);
    }

    protected Builder(UserServiceStubSettings settings) {
      super(settings);

      getUserSettings = settings.getUserSettings.toBuilder();
      listUsersSettings = settings.listUsersSettings.toBuilder();
      createUserSettings = settings.createUserSettings.toBuilder();
      batchCreateUsersSettings = settings.batchCreateUsersSettings.toBuilder();
      batchActivateUsersSettings = settings.batchActivateUsersSettings.toBuilder();
      batchDeactivateUsersSettings = settings.batchDeactivateUsersSettings.toBuilder();
      updateUserSettings = settings.updateUserSettings.toBuilder();
      batchUpdateUsersSettings = settings.batchUpdateUsersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getUserSettings,
              listUsersSettings,
              createUserSettings,
              batchCreateUsersSettings,
              batchActivateUsersSettings,
              batchDeactivateUsersSettings,
              updateUserSettings,
              batchUpdateUsersSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUsersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateUsersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateUsersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateUsersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateUsersSettings()
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

    /** Returns the builder for the settings used for calls to getUser. */
    public UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings() {
      return getUserSettings;
    }

    /** Returns the builder for the settings used for calls to listUsers. */
    public PagedCallSettings.Builder<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings() {
      return listUsersSettings;
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public UnaryCallSettings.Builder<CreateUserRequest, User> createUserSettings() {
      return createUserSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateUsers. */
    public UnaryCallSettings.Builder<BatchCreateUsersRequest, BatchCreateUsersResponse>
        batchCreateUsersSettings() {
      return batchCreateUsersSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateUsers. */
    public UnaryCallSettings.Builder<BatchActivateUsersRequest, BatchActivateUsersResponse>
        batchActivateUsersSettings() {
      return batchActivateUsersSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateUsers. */
    public UnaryCallSettings.Builder<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
        batchDeactivateUsersSettings() {
      return batchDeactivateUsersSettings;
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public UnaryCallSettings.Builder<UpdateUserRequest, User> updateUserSettings() {
      return updateUserSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateUsers. */
    public UnaryCallSettings.Builder<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
        batchUpdateUsersSettings() {
      return batchUpdateUsersSettings;
    }

    @Override
    public UserServiceStubSettings build() throws IOException {
      return new UserServiceStubSettings(this);
    }
  }
}
