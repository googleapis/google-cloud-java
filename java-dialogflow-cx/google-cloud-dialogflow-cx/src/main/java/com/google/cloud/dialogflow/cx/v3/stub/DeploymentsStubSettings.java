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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.DeploymentsClient.ListDeploymentsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.Deployment;
import com.google.cloud.dialogflow.cx.v3.GetDeploymentRequest;
import com.google.cloud.dialogflow.cx.v3.ListDeploymentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListDeploymentsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeploymentsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeployment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * DeploymentsStubSettings.Builder deploymentsSettingsBuilder =
 *     DeploymentsStubSettings.newBuilder();
 * deploymentsSettingsBuilder
 *     .getDeploymentSettings()
 *     .setRetrySettings(
 *         deploymentsSettingsBuilder
 *             .getDeploymentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeploymentsStubSettings deploymentsSettings = deploymentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeploymentsStubSettings extends StubSettings<DeploymentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings;
  private final UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings;

  private static final PagedListDescriptor<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment>
      LIST_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDeploymentsRequest, ListDeploymentsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentsRequest injectToken(
                ListDeploymentsRequest payload, String token) {
              return ListDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentsRequest injectPageSize(
                ListDeploymentsRequest payload, int pageSize) {
              return ListDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentsResponse payload) {
              return payload.getDeploymentsList() == null
                  ? ImmutableList.<Deployment>of()
                  : payload.getDeploymentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      LIST_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> callable,
                ListDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentsResponse> futureResponse) {
              PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> pageContext =
                  PageContext.create(callable, LIST_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return listDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return getDeploymentSettings;
  }

  public DeploymentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeploymentsStub.create(this);
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
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DeploymentsStubSettings.class))
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

  protected DeploymentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDeploymentsSettings = settingsBuilder.listDeploymentsSettings().build();
    getDeploymentSettings = settingsBuilder.getDeploymentSettings().build();
  }

  /** Builder for DeploymentsStubSettings. */
  public static class Builder extends StubSettings.Builder<DeploymentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDeploymentsSettings = PagedCallSettings.newBuilder(LIST_DEPLOYMENTS_PAGE_STR_FACT);
      getDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeploymentsSettings, getDeploymentSettings);
      initDefaults(this);
    }

    protected Builder(DeploymentsStubSettings settings) {
      super(settings);

      listDeploymentsSettings = settings.listDeploymentsSettings.toBuilder();
      getDeploymentSettings = settings.getDeploymentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeploymentsSettings, getDeploymentSettings);
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
          .listDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return listDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getDeploymentSettings;
    }

    @Override
    public DeploymentsStubSettings build() throws IOException {
      return new DeploymentsStubSettings(this);
    }
  }
}
