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

package com.google.cloud.accessapproval.v1.stub;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

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
import com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount;
import com.google.cloud.accessapproval.v1.AccessApprovalSettings;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage;
import com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.GetApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse;
import com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage;
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
 * Settings class to configure an instance of {@link AccessApprovalStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (accessapproval.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApprovalRequest to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessApprovalStubSettings.Builder accessApprovalAdminSettingsBuilder =
 *     AccessApprovalStubSettings.newBuilder();
 * accessApprovalAdminSettingsBuilder
 *     .getApprovalRequestSettings()
 *     .setRetrySettings(
 *         accessApprovalAdminSettingsBuilder
 *             .getApprovalRequestSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AccessApprovalStubSettings accessApprovalAdminSettings =
 *     accessApprovalAdminSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AccessApprovalStubSettings extends StubSettings<AccessApprovalStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ListApprovalRequestsPagedResponse>
      listApprovalRequestsSettings;
  private final UnaryCallSettings<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestSettings;
  private final UnaryCallSettings<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestSettings;
  private final UnaryCallSettings<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestSettings;
  private final UnaryCallSettings<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestSettings;
  private final UnaryCallSettings<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsSettings;
  private final UnaryCallSettings<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsSettings;
  private final UnaryCallSettings<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsSettings;
  private final UnaryCallSettings<
          GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountSettings;

  private static final PagedListDescriptor<
          ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
      LIST_APPROVAL_REQUESTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApprovalRequestsMessage injectToken(
                ListApprovalRequestsMessage payload, String token) {
              return ListApprovalRequestsMessage.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApprovalRequestsMessage injectPageSize(
                ListApprovalRequestsMessage payload, int pageSize) {
              return ListApprovalRequestsMessage.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApprovalRequestsMessage payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApprovalRequestsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApprovalRequest> extractResources(
                ListApprovalRequestsResponse payload) {
              return payload.getApprovalRequestsList() == null
                  ? ImmutableList.<ApprovalRequest>of()
                  : payload.getApprovalRequestsList();
            }
          };

  private static final PagedListResponseFactory<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ListApprovalRequestsPagedResponse>
      LIST_APPROVAL_REQUESTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApprovalRequestsMessage,
              ListApprovalRequestsResponse,
              ListApprovalRequestsPagedResponse>() {
            @Override
            public ApiFuture<ListApprovalRequestsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse> callable,
                ListApprovalRequestsMessage request,
                ApiCallContext context,
                ApiFuture<ListApprovalRequestsResponse> futureResponse) {
              PageContext<
                      ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APPROVAL_REQUESTS_PAGE_STR_DESC, request, context);
              return ListApprovalRequestsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listApprovalRequests. */
  public PagedCallSettings<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ListApprovalRequestsPagedResponse>
      listApprovalRequestsSettings() {
    return listApprovalRequestsSettings;
  }

  /** Returns the object with the settings used for calls to getApprovalRequest. */
  public UnaryCallSettings<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestSettings() {
    return getApprovalRequestSettings;
  }

  /** Returns the object with the settings used for calls to approveApprovalRequest. */
  public UnaryCallSettings<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestSettings() {
    return approveApprovalRequestSettings;
  }

  /** Returns the object with the settings used for calls to dismissApprovalRequest. */
  public UnaryCallSettings<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestSettings() {
    return dismissApprovalRequestSettings;
  }

  /** Returns the object with the settings used for calls to invalidateApprovalRequest. */
  public UnaryCallSettings<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestSettings() {
    return invalidateApprovalRequestSettings;
  }

  /** Returns the object with the settings used for calls to getAccessApprovalSettings. */
  public UnaryCallSettings<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsSettings() {
    return getAccessApprovalSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessApprovalSettings. */
  public UnaryCallSettings<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsSettings() {
    return updateAccessApprovalSettingsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessApprovalSettings. */
  public UnaryCallSettings<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsSettings() {
    return deleteAccessApprovalSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getAccessApprovalServiceAccount. */
  public UnaryCallSettings<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountSettings() {
    return getAccessApprovalServiceAccountSettings;
  }

  public AccessApprovalStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAccessApprovalStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAccessApprovalStub.create(this);
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
    return "accessapproval.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "accessapproval.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AccessApprovalStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AccessApprovalStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessApprovalStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AccessApprovalStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listApprovalRequestsSettings = settingsBuilder.listApprovalRequestsSettings().build();
    getApprovalRequestSettings = settingsBuilder.getApprovalRequestSettings().build();
    approveApprovalRequestSettings = settingsBuilder.approveApprovalRequestSettings().build();
    dismissApprovalRequestSettings = settingsBuilder.dismissApprovalRequestSettings().build();
    invalidateApprovalRequestSettings = settingsBuilder.invalidateApprovalRequestSettings().build();
    getAccessApprovalSettingsSettings = settingsBuilder.getAccessApprovalSettingsSettings().build();
    updateAccessApprovalSettingsSettings =
        settingsBuilder.updateAccessApprovalSettingsSettings().build();
    deleteAccessApprovalSettingsSettings =
        settingsBuilder.deleteAccessApprovalSettingsSettings().build();
    getAccessApprovalServiceAccountSettings =
        settingsBuilder.getAccessApprovalServiceAccountSettings().build();
  }

  /** Builder for AccessApprovalStubSettings. */
  public static class Builder extends StubSettings.Builder<AccessApprovalStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListApprovalRequestsMessage,
            ListApprovalRequestsResponse,
            ListApprovalRequestsPagedResponse>
        listApprovalRequestsSettings;
    private final UnaryCallSettings.Builder<GetApprovalRequestMessage, ApprovalRequest>
        getApprovalRequestSettings;
    private final UnaryCallSettings.Builder<ApproveApprovalRequestMessage, ApprovalRequest>
        approveApprovalRequestSettings;
    private final UnaryCallSettings.Builder<DismissApprovalRequestMessage, ApprovalRequest>
        dismissApprovalRequestSettings;
    private final UnaryCallSettings.Builder<InvalidateApprovalRequestMessage, ApprovalRequest>
        invalidateApprovalRequestSettings;
    private final UnaryCallSettings.Builder<
            GetAccessApprovalSettingsMessage, AccessApprovalSettings>
        getAccessApprovalSettingsSettings;
    private final UnaryCallSettings.Builder<
            UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
        updateAccessApprovalSettingsSettings;
    private final UnaryCallSettings.Builder<DeleteAccessApprovalSettingsMessage, Empty>
        deleteAccessApprovalSettingsSettings;
    private final UnaryCallSettings.Builder<
            GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
        getAccessApprovalServiceAccountSettings;
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
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listApprovalRequestsSettings =
          PagedCallSettings.newBuilder(LIST_APPROVAL_REQUESTS_PAGE_STR_FACT);
      getApprovalRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      approveApprovalRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      dismissApprovalRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      invalidateApprovalRequestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAccessApprovalSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessApprovalSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccessApprovalSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAccessApprovalServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApprovalRequestsSettings,
              getApprovalRequestSettings,
              approveApprovalRequestSettings,
              dismissApprovalRequestSettings,
              invalidateApprovalRequestSettings,
              getAccessApprovalSettingsSettings,
              updateAccessApprovalSettingsSettings,
              deleteAccessApprovalSettingsSettings,
              getAccessApprovalServiceAccountSettings);
      initDefaults(this);
    }

    protected Builder(AccessApprovalStubSettings settings) {
      super(settings);

      listApprovalRequestsSettings = settings.listApprovalRequestsSettings.toBuilder();
      getApprovalRequestSettings = settings.getApprovalRequestSettings.toBuilder();
      approveApprovalRequestSettings = settings.approveApprovalRequestSettings.toBuilder();
      dismissApprovalRequestSettings = settings.dismissApprovalRequestSettings.toBuilder();
      invalidateApprovalRequestSettings = settings.invalidateApprovalRequestSettings.toBuilder();
      getAccessApprovalSettingsSettings = settings.getAccessApprovalSettingsSettings.toBuilder();
      updateAccessApprovalSettingsSettings =
          settings.updateAccessApprovalSettingsSettings.toBuilder();
      deleteAccessApprovalSettingsSettings =
          settings.deleteAccessApprovalSettingsSettings.toBuilder();
      getAccessApprovalServiceAccountSettings =
          settings.getAccessApprovalServiceAccountSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApprovalRequestsSettings,
              getApprovalRequestSettings,
              approveApprovalRequestSettings,
              dismissApprovalRequestSettings,
              invalidateApprovalRequestSettings,
              getAccessApprovalSettingsSettings,
              updateAccessApprovalSettingsSettings,
              deleteAccessApprovalSettingsSettings,
              getAccessApprovalServiceAccountSettings);
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
          .listApprovalRequestsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApprovalRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .approveApprovalRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .dismissApprovalRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .invalidateApprovalRequestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAccessApprovalSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAccessApprovalSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAccessApprovalSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAccessApprovalServiceAccountSettings()
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

    /** Returns the builder for the settings used for calls to listApprovalRequests. */
    public PagedCallSettings.Builder<
            ListApprovalRequestsMessage,
            ListApprovalRequestsResponse,
            ListApprovalRequestsPagedResponse>
        listApprovalRequestsSettings() {
      return listApprovalRequestsSettings;
    }

    /** Returns the builder for the settings used for calls to getApprovalRequest. */
    public UnaryCallSettings.Builder<GetApprovalRequestMessage, ApprovalRequest>
        getApprovalRequestSettings() {
      return getApprovalRequestSettings;
    }

    /** Returns the builder for the settings used for calls to approveApprovalRequest. */
    public UnaryCallSettings.Builder<ApproveApprovalRequestMessage, ApprovalRequest>
        approveApprovalRequestSettings() {
      return approveApprovalRequestSettings;
    }

    /** Returns the builder for the settings used for calls to dismissApprovalRequest. */
    public UnaryCallSettings.Builder<DismissApprovalRequestMessage, ApprovalRequest>
        dismissApprovalRequestSettings() {
      return dismissApprovalRequestSettings;
    }

    /** Returns the builder for the settings used for calls to invalidateApprovalRequest. */
    public UnaryCallSettings.Builder<InvalidateApprovalRequestMessage, ApprovalRequest>
        invalidateApprovalRequestSettings() {
      return invalidateApprovalRequestSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessApprovalSettings. */
    public UnaryCallSettings.Builder<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
        getAccessApprovalSettingsSettings() {
      return getAccessApprovalSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessApprovalSettings. */
    public UnaryCallSettings.Builder<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
        updateAccessApprovalSettingsSettings() {
      return updateAccessApprovalSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessApprovalSettings. */
    public UnaryCallSettings.Builder<DeleteAccessApprovalSettingsMessage, Empty>
        deleteAccessApprovalSettingsSettings() {
      return deleteAccessApprovalSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessApprovalServiceAccount. */
    public UnaryCallSettings.Builder<
            GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
        getAccessApprovalServiceAccountSettings() {
      return getAccessApprovalServiceAccountSettings;
    }

    @Override
    public AccessApprovalStubSettings build() throws IOException {
      return new AccessApprovalStubSettings(this);
    }
  }
}
