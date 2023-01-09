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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.SnoozeServiceClient.ListSnoozesPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SnoozeServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSnooze to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnoozeServiceStubSettings.Builder snoozeServiceSettingsBuilder =
 *     SnoozeServiceStubSettings.newBuilder();
 * snoozeServiceSettingsBuilder
 *     .createSnoozeSettings()
 *     .setRetrySettings(
 *         snoozeServiceSettingsBuilder
 *             .createSnoozeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SnoozeServiceStubSettings snoozeServiceSettings = snoozeServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SnoozeServiceStubSettings extends StubSettings<SnoozeServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final UnaryCallSettings<CreateSnoozeRequest, Snooze> createSnoozeSettings;
  private final PagedCallSettings<ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
      listSnoozesSettings;
  private final UnaryCallSettings<GetSnoozeRequest, Snooze> getSnoozeSettings;
  private final UnaryCallSettings<UpdateSnoozeRequest, Snooze> updateSnoozeSettings;

  private static final PagedListDescriptor<ListSnoozesRequest, ListSnoozesResponse, Snooze>
      LIST_SNOOZES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSnoozesRequest, ListSnoozesResponse, Snooze>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnoozesRequest injectToken(ListSnoozesRequest payload, String token) {
              return ListSnoozesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSnoozesRequest injectPageSize(ListSnoozesRequest payload, int pageSize) {
              return ListSnoozesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSnoozesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSnoozesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Snooze> extractResources(ListSnoozesResponse payload) {
              return payload.getSnoozesList() == null
                  ? ImmutableList.<Snooze>of()
                  : payload.getSnoozesList();
            }
          };

  private static final PagedListResponseFactory<
          ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
      LIST_SNOOZES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>() {
            @Override
            public ApiFuture<ListSnoozesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSnoozesRequest, ListSnoozesResponse> callable,
                ListSnoozesRequest request,
                ApiCallContext context,
                ApiFuture<ListSnoozesResponse> futureResponse) {
              PageContext<ListSnoozesRequest, ListSnoozesResponse, Snooze> pageContext =
                  PageContext.create(callable, LIST_SNOOZES_PAGE_STR_DESC, request, context);
              return ListSnoozesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSnooze. */
  public UnaryCallSettings<CreateSnoozeRequest, Snooze> createSnoozeSettings() {
    return createSnoozeSettings;
  }

  /** Returns the object with the settings used for calls to listSnoozes. */
  public PagedCallSettings<ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
      listSnoozesSettings() {
    return listSnoozesSettings;
  }

  /** Returns the object with the settings used for calls to getSnooze. */
  public UnaryCallSettings<GetSnoozeRequest, Snooze> getSnoozeSettings() {
    return getSnoozeSettings;
  }

  /** Returns the object with the settings used for calls to updateSnooze. */
  public UnaryCallSettings<UpdateSnoozeRequest, Snooze> updateSnoozeSettings() {
    return updateSnoozeSettings;
  }

  public SnoozeServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSnoozeServiceStub.create(this);
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
    return "monitoring.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "monitoring.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SnoozeServiceStubSettings.class))
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

  protected SnoozeServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSnoozeSettings = settingsBuilder.createSnoozeSettings().build();
    listSnoozesSettings = settingsBuilder.listSnoozesSettings().build();
    getSnoozeSettings = settingsBuilder.getSnoozeSettings().build();
    updateSnoozeSettings = settingsBuilder.updateSnoozeSettings().build();
  }

  /** Builder for SnoozeServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SnoozeServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSnoozeRequest, Snooze> createSnoozeSettings;
    private final PagedCallSettings.Builder<
            ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
        listSnoozesSettings;
    private final UnaryCallSettings.Builder<GetSnoozeRequest, Snooze> getSnoozeSettings;
    private final UnaryCallSettings.Builder<UpdateSnoozeRequest, Snooze> updateSnoozeSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_15_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_14_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_15_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_14_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSnoozeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSnoozesSettings = PagedCallSettings.newBuilder(LIST_SNOOZES_PAGE_STR_FACT);
      getSnoozeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSnoozeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSnoozeSettings, listSnoozesSettings, getSnoozeSettings, updateSnoozeSettings);
      initDefaults(this);
    }

    protected Builder(SnoozeServiceStubSettings settings) {
      super(settings);

      createSnoozeSettings = settings.createSnoozeSettings.toBuilder();
      listSnoozesSettings = settings.listSnoozesSettings.toBuilder();
      getSnoozeSettings = settings.getSnoozeSettings.toBuilder();
      updateSnoozeSettings = settings.updateSnoozeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSnoozeSettings, listSnoozesSettings, getSnoozeSettings, updateSnoozeSettings);
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
          .createSnoozeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_15_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_15_params"));

      builder
          .listSnoozesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_14_params"));

      builder
          .getSnoozeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_14_params"));

      builder
          .updateSnoozeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_15_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_15_params"));

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

    /** Returns the builder for the settings used for calls to createSnooze. */
    public UnaryCallSettings.Builder<CreateSnoozeRequest, Snooze> createSnoozeSettings() {
      return createSnoozeSettings;
    }

    /** Returns the builder for the settings used for calls to listSnoozes. */
    public PagedCallSettings.Builder<
            ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
        listSnoozesSettings() {
      return listSnoozesSettings;
    }

    /** Returns the builder for the settings used for calls to getSnooze. */
    public UnaryCallSettings.Builder<GetSnoozeRequest, Snooze> getSnoozeSettings() {
      return getSnoozeSettings;
    }

    /** Returns the builder for the settings used for calls to updateSnooze. */
    public UnaryCallSettings.Builder<UpdateSnoozeRequest, Snooze> updateSnoozeSettings() {
      return updateSnoozeSettings;
    }

    @Override
    public SnoozeServiceStubSettings build() throws IOException {
      return new SnoozeServiceStubSettings(this);
    }
  }
}
