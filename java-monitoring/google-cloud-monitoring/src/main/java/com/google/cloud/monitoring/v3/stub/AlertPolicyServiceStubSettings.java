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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.AlertPolicyServiceClient.ListAlertPoliciesPagedResponse;

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
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.CreateAlertPolicyRequest;
import com.google.monitoring.v3.DeleteAlertPolicyRequest;
import com.google.monitoring.v3.GetAlertPolicyRequest;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ListAlertPoliciesResponse;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AlertPolicyServiceStub}.
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
 * <p>For example, to set the total timeout of getAlertPolicy to 30 seconds:
 *
 * <pre>{@code
 * AlertPolicyServiceStubSettings.Builder alertPolicyServiceSettingsBuilder =
 *     AlertPolicyServiceStubSettings.newBuilder();
 * alertPolicyServiceSettingsBuilder
 *     .getAlertPolicySettings()
 *     .setRetrySettings(
 *         alertPolicyServiceSettingsBuilder
 *             .getAlertPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AlertPolicyServiceStubSettings alertPolicyServiceSettings =
 *     alertPolicyServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AlertPolicyServiceStubSettings extends StubSettings<AlertPolicyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final PagedCallSettings<
          ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
      listAlertPoliciesSettings;
  private final UnaryCallSettings<GetAlertPolicyRequest, AlertPolicy> getAlertPolicySettings;
  private final UnaryCallSettings<CreateAlertPolicyRequest, AlertPolicy> createAlertPolicySettings;
  private final UnaryCallSettings<DeleteAlertPolicyRequest, Empty> deleteAlertPolicySettings;
  private final UnaryCallSettings<UpdateAlertPolicyRequest, AlertPolicy> updateAlertPolicySettings;

  private static final PagedListDescriptor<
          ListAlertPoliciesRequest, ListAlertPoliciesResponse, AlertPolicy>
      LIST_ALERT_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAlertPoliciesRequest, ListAlertPoliciesResponse, AlertPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAlertPoliciesRequest injectToken(
                ListAlertPoliciesRequest payload, String token) {
              return ListAlertPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAlertPoliciesRequest injectPageSize(
                ListAlertPoliciesRequest payload, int pageSize) {
              return ListAlertPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAlertPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAlertPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AlertPolicy> extractResources(ListAlertPoliciesResponse payload) {
              return payload.getAlertPoliciesList() == null
                  ? ImmutableList.<AlertPolicy>of()
                  : payload.getAlertPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
      LIST_ALERT_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAlertPoliciesRequest,
              ListAlertPoliciesResponse,
              ListAlertPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAlertPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAlertPoliciesRequest, ListAlertPoliciesResponse> callable,
                ListAlertPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAlertPoliciesResponse> futureResponse) {
              PageContext<ListAlertPoliciesRequest, ListAlertPoliciesResponse, AlertPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ALERT_POLICIES_PAGE_STR_DESC, request, context);
              return ListAlertPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAlertPolicies. */
  public PagedCallSettings<
          ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
      listAlertPoliciesSettings() {
    return listAlertPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getAlertPolicy. */
  public UnaryCallSettings<GetAlertPolicyRequest, AlertPolicy> getAlertPolicySettings() {
    return getAlertPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAlertPolicy. */
  public UnaryCallSettings<CreateAlertPolicyRequest, AlertPolicy> createAlertPolicySettings() {
    return createAlertPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAlertPolicy. */
  public UnaryCallSettings<DeleteAlertPolicyRequest, Empty> deleteAlertPolicySettings() {
    return deleteAlertPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAlertPolicy. */
  public UnaryCallSettings<UpdateAlertPolicyRequest, AlertPolicy> updateAlertPolicySettings() {
    return updateAlertPolicySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AlertPolicyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAlertPolicyServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AlertPolicyServiceStubSettings.class))
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

  protected AlertPolicyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAlertPoliciesSettings = settingsBuilder.listAlertPoliciesSettings().build();
    getAlertPolicySettings = settingsBuilder.getAlertPolicySettings().build();
    createAlertPolicySettings = settingsBuilder.createAlertPolicySettings().build();
    deleteAlertPolicySettings = settingsBuilder.deleteAlertPolicySettings().build();
    updateAlertPolicySettings = settingsBuilder.updateAlertPolicySettings().build();
  }

  /** Builder for AlertPolicyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AlertPolicyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
        listAlertPoliciesSettings;
    private final UnaryCallSettings.Builder<GetAlertPolicyRequest, AlertPolicy>
        getAlertPolicySettings;
    private final UnaryCallSettings.Builder<CreateAlertPolicyRequest, AlertPolicy>
        createAlertPolicySettings;
    private final UnaryCallSettings.Builder<DeleteAlertPolicyRequest, Empty>
        deleteAlertPolicySettings;
    private final UnaryCallSettings.Builder<UpdateAlertPolicyRequest, AlertPolicy>
        updateAlertPolicySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_8_codes",
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
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_8_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAlertPoliciesSettings = PagedCallSettings.newBuilder(LIST_ALERT_POLICIES_PAGE_STR_FACT);
      getAlertPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAlertPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAlertPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAlertPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAlertPoliciesSettings,
              getAlertPolicySettings,
              createAlertPolicySettings,
              deleteAlertPolicySettings,
              updateAlertPolicySettings);
      initDefaults(this);
    }

    protected Builder(AlertPolicyServiceStubSettings settings) {
      super(settings);

      listAlertPoliciesSettings = settings.listAlertPoliciesSettings.toBuilder();
      getAlertPolicySettings = settings.getAlertPolicySettings.toBuilder();
      createAlertPolicySettings = settings.createAlertPolicySettings.toBuilder();
      deleteAlertPolicySettings = settings.deleteAlertPolicySettings.toBuilder();
      updateAlertPolicySettings = settings.updateAlertPolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAlertPoliciesSettings,
              getAlertPolicySettings,
              createAlertPolicySettings,
              deleteAlertPolicySettings,
              updateAlertPolicySettings);
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
          .listAlertPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_8_params"));

      builder
          .getAlertPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_8_params"));

      builder
          .createAlertPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAlertPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_8_params"));

      builder
          .updateAlertPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to listAlertPolicies. */
    public PagedCallSettings.Builder<
            ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
        listAlertPoliciesSettings() {
      return listAlertPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getAlertPolicy. */
    public UnaryCallSettings.Builder<GetAlertPolicyRequest, AlertPolicy> getAlertPolicySettings() {
      return getAlertPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAlertPolicy. */
    public UnaryCallSettings.Builder<CreateAlertPolicyRequest, AlertPolicy>
        createAlertPolicySettings() {
      return createAlertPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAlertPolicy. */
    public UnaryCallSettings.Builder<DeleteAlertPolicyRequest, Empty> deleteAlertPolicySettings() {
      return deleteAlertPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAlertPolicy. */
    public UnaryCallSettings.Builder<UpdateAlertPolicyRequest, AlertPolicy>
        updateAlertPolicySettings() {
      return updateAlertPolicySettings;
    }

    @Override
    public AlertPolicyServiceStubSettings build() throws IOException {
      return new AlertPolicyServiceStubSettings(this);
    }
  }
}
