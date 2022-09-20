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

package com.google.cloud.billing.budgets.v1beta1.stub;

import static com.google.cloud.billing.budgets.v1beta1.BudgetServiceClient.ListBudgetsPagedResponse;

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
import com.google.cloud.billing.budgets.v1beta1.Budget;
import com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest;
import com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest;
import com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest;
import com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest;
import com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse;
import com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest;
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
 * Settings class to configure an instance of {@link BudgetServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (billingbudgets.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createBudget to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BudgetServiceStubSettings.Builder budgetServiceSettingsBuilder =
 *     BudgetServiceStubSettings.newBuilder();
 * budgetServiceSettingsBuilder
 *     .createBudgetSettings()
 *     .setRetrySettings(
 *         budgetServiceSettingsBuilder.createBudgetSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BudgetServiceStubSettings budgetServiceSettings = budgetServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BudgetServiceStubSettings extends StubSettings<BudgetServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-billing")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateBudgetRequest, Budget> createBudgetSettings;
  private final UnaryCallSettings<UpdateBudgetRequest, Budget> updateBudgetSettings;
  private final UnaryCallSettings<GetBudgetRequest, Budget> getBudgetSettings;
  private final PagedCallSettings<ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
      listBudgetsSettings;
  private final UnaryCallSettings<DeleteBudgetRequest, Empty> deleteBudgetSettings;

  private static final PagedListDescriptor<ListBudgetsRequest, ListBudgetsResponse, Budget>
      LIST_BUDGETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBudgetsRequest, ListBudgetsResponse, Budget>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBudgetsRequest injectToken(ListBudgetsRequest payload, String token) {
              return ListBudgetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBudgetsRequest injectPageSize(ListBudgetsRequest payload, int pageSize) {
              return ListBudgetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBudgetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBudgetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Budget> extractResources(ListBudgetsResponse payload) {
              return payload.getBudgetsList() == null
                  ? ImmutableList.<Budget>of()
                  : payload.getBudgetsList();
            }
          };

  private static final PagedListResponseFactory<
          ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
      LIST_BUDGETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>() {
            @Override
            public ApiFuture<ListBudgetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> callable,
                ListBudgetsRequest request,
                ApiCallContext context,
                ApiFuture<ListBudgetsResponse> futureResponse) {
              PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> pageContext =
                  PageContext.create(callable, LIST_BUDGETS_PAGE_STR_DESC, request, context);
              return ListBudgetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createBudget. */
  public UnaryCallSettings<CreateBudgetRequest, Budget> createBudgetSettings() {
    return createBudgetSettings;
  }

  /** Returns the object with the settings used for calls to updateBudget. */
  public UnaryCallSettings<UpdateBudgetRequest, Budget> updateBudgetSettings() {
    return updateBudgetSettings;
  }

  /** Returns the object with the settings used for calls to getBudget. */
  public UnaryCallSettings<GetBudgetRequest, Budget> getBudgetSettings() {
    return getBudgetSettings;
  }

  /** Returns the object with the settings used for calls to listBudgets. */
  public PagedCallSettings<ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
      listBudgetsSettings() {
    return listBudgetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteBudget. */
  public UnaryCallSettings<DeleteBudgetRequest, Empty> deleteBudgetSettings() {
    return deleteBudgetSettings;
  }

  public BudgetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBudgetServiceStub.create(this);
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
    return "billingbudgets.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "billingbudgets.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BudgetServiceStubSettings.class))
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

  protected BudgetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createBudgetSettings = settingsBuilder.createBudgetSettings().build();
    updateBudgetSettings = settingsBuilder.updateBudgetSettings().build();
    getBudgetSettings = settingsBuilder.getBudgetSettings().build();
    listBudgetsSettings = settingsBuilder.listBudgetsSettings().build();
    deleteBudgetSettings = settingsBuilder.deleteBudgetSettings().build();
  }

  /** Builder for BudgetServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<BudgetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateBudgetRequest, Budget> createBudgetSettings;
    private final UnaryCallSettings.Builder<UpdateBudgetRequest, Budget> updateBudgetSettings;
    private final UnaryCallSettings.Builder<GetBudgetRequest, Budget> getBudgetSettings;
    private final PagedCallSettings.Builder<
            ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
        listBudgetsSettings;
    private final UnaryCallSettings.Builder<DeleteBudgetRequest, Empty> deleteBudgetSettings;
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
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
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

      createBudgetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBudgetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBudgetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBudgetsSettings = PagedCallSettings.newBuilder(LIST_BUDGETS_PAGE_STR_FACT);
      deleteBudgetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBudgetSettings,
              updateBudgetSettings,
              getBudgetSettings,
              listBudgetsSettings,
              deleteBudgetSettings);
      initDefaults(this);
    }

    protected Builder(BudgetServiceStubSettings settings) {
      super(settings);

      createBudgetSettings = settings.createBudgetSettings.toBuilder();
      updateBudgetSettings = settings.updateBudgetSettings.toBuilder();
      getBudgetSettings = settings.getBudgetSettings.toBuilder();
      listBudgetsSettings = settings.listBudgetsSettings.toBuilder();
      deleteBudgetSettings = settings.deleteBudgetSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBudgetSettings,
              updateBudgetSettings,
              getBudgetSettings,
              listBudgetsSettings,
              deleteBudgetSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createBudgetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateBudgetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getBudgetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listBudgetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteBudgetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to createBudget. */
    public UnaryCallSettings.Builder<CreateBudgetRequest, Budget> createBudgetSettings() {
      return createBudgetSettings;
    }

    /** Returns the builder for the settings used for calls to updateBudget. */
    public UnaryCallSettings.Builder<UpdateBudgetRequest, Budget> updateBudgetSettings() {
      return updateBudgetSettings;
    }

    /** Returns the builder for the settings used for calls to getBudget. */
    public UnaryCallSettings.Builder<GetBudgetRequest, Budget> getBudgetSettings() {
      return getBudgetSettings;
    }

    /** Returns the builder for the settings used for calls to listBudgets. */
    public PagedCallSettings.Builder<
            ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
        listBudgetsSettings() {
      return listBudgetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBudget. */
    public UnaryCallSettings.Builder<DeleteBudgetRequest, Empty> deleteBudgetSettings() {
      return deleteBudgetSettings;
    }

    @Override
    public BudgetServiceStubSettings build() throws IOException {
      return new BudgetServiceStubSettings(this);
    }
  }
}
