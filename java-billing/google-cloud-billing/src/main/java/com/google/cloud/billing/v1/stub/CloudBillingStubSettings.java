/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.billing.v1.BillingAccount;
import com.google.cloud.billing.v1.CreateBillingAccountRequest;
import com.google.cloud.billing.v1.GetBillingAccountRequest;
import com.google.cloud.billing.v1.GetProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListBillingAccountsRequest;
import com.google.cloud.billing.v1.ListBillingAccountsResponse;
import com.google.cloud.billing.v1.ListProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListProjectBillingInfoResponse;
import com.google.cloud.billing.v1.ProjectBillingInfo;
import com.google.cloud.billing.v1.UpdateBillingAccountRequest;
import com.google.cloud.billing.v1.UpdateProjectBillingInfoRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudBillingStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbilling.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBillingAccount to 30 seconds:
 *
 * <pre>{@code
 * CloudBillingStubSettings.Builder cloudBillingSettingsBuilder =
 *     CloudBillingStubSettings.newBuilder();
 * cloudBillingSettingsBuilder
 *     .getBillingAccountSettings()
 *     .setRetrySettings(
 *         cloudBillingSettingsBuilder
 *             .getBillingAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudBillingStubSettings cloudBillingSettings = cloudBillingSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudBillingStubSettings extends StubSettings<CloudBillingStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetBillingAccountRequest, BillingAccount>
      getBillingAccountSettings;
  private final PagedCallSettings<
          ListBillingAccountsRequest, ListBillingAccountsResponse, ListBillingAccountsPagedResponse>
      listBillingAccountsSettings;
  private final UnaryCallSettings<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountSettings;
  private final UnaryCallSettings<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountSettings;
  private final PagedCallSettings<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoSettings;
  private final UnaryCallSettings<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoSettings;
  private final UnaryCallSettings<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
      LIST_BILLING_ACCOUNTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBillingAccountsRequest injectToken(
                ListBillingAccountsRequest payload, String token) {
              return ListBillingAccountsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBillingAccountsRequest injectPageSize(
                ListBillingAccountsRequest payload, int pageSize) {
              return ListBillingAccountsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBillingAccountsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBillingAccountsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BillingAccount> extractResources(ListBillingAccountsResponse payload) {
              return payload.getBillingAccountsList() == null
                  ? ImmutableList.<BillingAccount>of()
                  : payload.getBillingAccountsList();
            }
          };

  private static final PagedListDescriptor<
          ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>
      LIST_PROJECT_BILLING_INFO_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProjectBillingInfoRequest injectToken(
                ListProjectBillingInfoRequest payload, String token) {
              return ListProjectBillingInfoRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProjectBillingInfoRequest injectPageSize(
                ListProjectBillingInfoRequest payload, int pageSize) {
              return ListProjectBillingInfoRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListProjectBillingInfoRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProjectBillingInfoResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProjectBillingInfo> extractResources(
                ListProjectBillingInfoResponse payload) {
              return payload.getProjectBillingInfoList() == null
                  ? ImmutableList.<ProjectBillingInfo>of()
                  : payload.getProjectBillingInfoList();
            }
          };

  private static final PagedListResponseFactory<
          ListBillingAccountsRequest, ListBillingAccountsResponse, ListBillingAccountsPagedResponse>
      LIST_BILLING_ACCOUNTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBillingAccountsRequest,
              ListBillingAccountsResponse,
              ListBillingAccountsPagedResponse>() {
            @Override
            public ApiFuture<ListBillingAccountsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse> callable,
                ListBillingAccountsRequest request,
                ApiCallContext context,
                ApiFuture<ListBillingAccountsResponse> futureResponse) {
              PageContext<ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BILLING_ACCOUNTS_PAGE_STR_DESC, request, context);
              return ListBillingAccountsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ListProjectBillingInfoPagedResponse>
      LIST_PROJECT_BILLING_INFO_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProjectBillingInfoRequest,
              ListProjectBillingInfoResponse,
              ListProjectBillingInfoPagedResponse>() {
            @Override
            public ApiFuture<ListProjectBillingInfoPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
                    callable,
                ListProjectBillingInfoRequest request,
                ApiCallContext context,
                ApiFuture<ListProjectBillingInfoResponse> futureResponse) {
              PageContext<
                      ListProjectBillingInfoRequest,
                      ListProjectBillingInfoResponse,
                      ProjectBillingInfo>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PROJECT_BILLING_INFO_PAGE_STR_DESC, request, context);
              return ListProjectBillingInfoPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getBillingAccount. */
  public UnaryCallSettings<GetBillingAccountRequest, BillingAccount> getBillingAccountSettings() {
    return getBillingAccountSettings;
  }

  /** Returns the object with the settings used for calls to listBillingAccounts. */
  public PagedCallSettings<
          ListBillingAccountsRequest, ListBillingAccountsResponse, ListBillingAccountsPagedResponse>
      listBillingAccountsSettings() {
    return listBillingAccountsSettings;
  }

  /** Returns the object with the settings used for calls to updateBillingAccount. */
  public UnaryCallSettings<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountSettings() {
    return updateBillingAccountSettings;
  }

  /** Returns the object with the settings used for calls to createBillingAccount. */
  public UnaryCallSettings<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountSettings() {
    return createBillingAccountSettings;
  }

  /** Returns the object with the settings used for calls to listProjectBillingInfo. */
  public PagedCallSettings<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoSettings() {
    return listProjectBillingInfoSettings;
  }

  /** Returns the object with the settings used for calls to getProjectBillingInfo. */
  public UnaryCallSettings<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoSettings() {
    return getProjectBillingInfoSettings;
  }

  /** Returns the object with the settings used for calls to updateProjectBillingInfo. */
  public UnaryCallSettings<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoSettings() {
    return updateProjectBillingInfoSettings;
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudBillingStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudBillingStub.create(this);
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
    return "cloudbilling.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudBillingStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected CloudBillingStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getBillingAccountSettings = settingsBuilder.getBillingAccountSettings().build();
    listBillingAccountsSettings = settingsBuilder.listBillingAccountsSettings().build();
    updateBillingAccountSettings = settingsBuilder.updateBillingAccountSettings().build();
    createBillingAccountSettings = settingsBuilder.createBillingAccountSettings().build();
    listProjectBillingInfoSettings = settingsBuilder.listProjectBillingInfoSettings().build();
    getProjectBillingInfoSettings = settingsBuilder.getProjectBillingInfoSettings().build();
    updateProjectBillingInfoSettings = settingsBuilder.updateProjectBillingInfoSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for CloudBillingStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudBillingStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetBillingAccountRequest, BillingAccount>
        getBillingAccountSettings;
    private final PagedCallSettings.Builder<
            ListBillingAccountsRequest,
            ListBillingAccountsResponse,
            ListBillingAccountsPagedResponse>
        listBillingAccountsSettings;
    private final UnaryCallSettings.Builder<UpdateBillingAccountRequest, BillingAccount>
        updateBillingAccountSettings;
    private final UnaryCallSettings.Builder<CreateBillingAccountRequest, BillingAccount>
        createBillingAccountSettings;
    private final PagedCallSettings.Builder<
            ListProjectBillingInfoRequest,
            ListProjectBillingInfoResponse,
            ListProjectBillingInfoPagedResponse>
        listProjectBillingInfoSettings;
    private final UnaryCallSettings.Builder<GetProjectBillingInfoRequest, ProjectBillingInfo>
        getProjectBillingInfoSettings;
    private final UnaryCallSettings.Builder<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
        updateProjectBillingInfoSettings;
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
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
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

      getBillingAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBillingAccountsSettings =
          PagedCallSettings.newBuilder(LIST_BILLING_ACCOUNTS_PAGE_STR_FACT);
      updateBillingAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBillingAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProjectBillingInfoSettings =
          PagedCallSettings.newBuilder(LIST_PROJECT_BILLING_INFO_PAGE_STR_FACT);
      getProjectBillingInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProjectBillingInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getBillingAccountSettings,
              listBillingAccountsSettings,
              updateBillingAccountSettings,
              createBillingAccountSettings,
              listProjectBillingInfoSettings,
              getProjectBillingInfoSettings,
              updateProjectBillingInfoSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(CloudBillingStubSettings settings) {
      super(settings);

      getBillingAccountSettings = settings.getBillingAccountSettings.toBuilder();
      listBillingAccountsSettings = settings.listBillingAccountsSettings.toBuilder();
      updateBillingAccountSettings = settings.updateBillingAccountSettings.toBuilder();
      createBillingAccountSettings = settings.createBillingAccountSettings.toBuilder();
      listProjectBillingInfoSettings = settings.listProjectBillingInfoSettings.toBuilder();
      getProjectBillingInfoSettings = settings.getProjectBillingInfoSettings.toBuilder();
      updateProjectBillingInfoSettings = settings.updateProjectBillingInfoSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getBillingAccountSettings,
              listBillingAccountsSettings,
              updateBillingAccountSettings,
              createBillingAccountSettings,
              listProjectBillingInfoSettings,
              getProjectBillingInfoSettings,
              updateProjectBillingInfoSettings,
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

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getBillingAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listBillingAccountsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateBillingAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createBillingAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listProjectBillingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getProjectBillingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateProjectBillingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to getBillingAccount. */
    public UnaryCallSettings.Builder<GetBillingAccountRequest, BillingAccount>
        getBillingAccountSettings() {
      return getBillingAccountSettings;
    }

    /** Returns the builder for the settings used for calls to listBillingAccounts. */
    public PagedCallSettings.Builder<
            ListBillingAccountsRequest,
            ListBillingAccountsResponse,
            ListBillingAccountsPagedResponse>
        listBillingAccountsSettings() {
      return listBillingAccountsSettings;
    }

    /** Returns the builder for the settings used for calls to updateBillingAccount. */
    public UnaryCallSettings.Builder<UpdateBillingAccountRequest, BillingAccount>
        updateBillingAccountSettings() {
      return updateBillingAccountSettings;
    }

    /** Returns the builder for the settings used for calls to createBillingAccount. */
    public UnaryCallSettings.Builder<CreateBillingAccountRequest, BillingAccount>
        createBillingAccountSettings() {
      return createBillingAccountSettings;
    }

    /** Returns the builder for the settings used for calls to listProjectBillingInfo. */
    public PagedCallSettings.Builder<
            ListProjectBillingInfoRequest,
            ListProjectBillingInfoResponse,
            ListProjectBillingInfoPagedResponse>
        listProjectBillingInfoSettings() {
      return listProjectBillingInfoSettings;
    }

    /** Returns the builder for the settings used for calls to getProjectBillingInfo. */
    public UnaryCallSettings.Builder<GetProjectBillingInfoRequest, ProjectBillingInfo>
        getProjectBillingInfoSettings() {
      return getProjectBillingInfoSettings;
    }

    /** Returns the builder for the settings used for calls to updateProjectBillingInfo. */
    public UnaryCallSettings.Builder<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
        updateProjectBillingInfoSettings() {
      return updateProjectBillingInfoSettings;
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
    public CloudBillingStubSettings build() throws IOException {
      return new CloudBillingStubSettings(this);
    }
  }
}
