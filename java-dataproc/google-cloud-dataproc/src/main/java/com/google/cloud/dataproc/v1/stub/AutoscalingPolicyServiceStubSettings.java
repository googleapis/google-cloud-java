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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

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
import com.google.cloud.dataproc.v1.AutoscalingPolicy;
import com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse;
import com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest;
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
 * Settings class to configure an instance of {@link AutoscalingPolicyServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAutoscalingPolicy to 30 seconds:
 *
 * <pre>{@code
 * AutoscalingPolicyServiceStubSettings.Builder autoscalingPolicyServiceSettingsBuilder =
 *     AutoscalingPolicyServiceStubSettings.newBuilder();
 * autoscalingPolicyServiceSettingsBuilder
 *     .createAutoscalingPolicySettings()
 *     .setRetrySettings(
 *         autoscalingPolicyServiceSettingsBuilder
 *             .createAutoscalingPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AutoscalingPolicyServiceStubSettings autoscalingPolicyServiceSettings =
 *     autoscalingPolicyServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AutoscalingPolicyServiceStubSettings
    extends StubSettings<AutoscalingPolicyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicySettings;
  private final UnaryCallSettings<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicySettings;
  private final UnaryCallSettings<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicySettings;
  private final PagedCallSettings<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesSettings;
  private final UnaryCallSettings<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicySettings;

  private static final PagedListDescriptor<
          ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
      LIST_AUTOSCALING_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAutoscalingPoliciesRequest,
              ListAutoscalingPoliciesResponse,
              AutoscalingPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAutoscalingPoliciesRequest injectToken(
                ListAutoscalingPoliciesRequest payload, String token) {
              return ListAutoscalingPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAutoscalingPoliciesRequest injectPageSize(
                ListAutoscalingPoliciesRequest payload, int pageSize) {
              return ListAutoscalingPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAutoscalingPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAutoscalingPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AutoscalingPolicy> extractResources(
                ListAutoscalingPoliciesResponse payload) {
              return payload.getPoliciesList() == null
                  ? ImmutableList.<AutoscalingPolicy>of()
                  : payload.getPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          ListAutoscalingPoliciesPagedResponse>
      LIST_AUTOSCALING_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAutoscalingPoliciesRequest,
              ListAutoscalingPoliciesResponse,
              ListAutoscalingPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAutoscalingPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
                    callable,
                ListAutoscalingPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAutoscalingPoliciesResponse> futureResponse) {
              PageContext<
                      ListAutoscalingPoliciesRequest,
                      ListAutoscalingPoliciesResponse,
                      AutoscalingPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTOSCALING_POLICIES_PAGE_STR_DESC, request, context);
              return ListAutoscalingPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAutoscalingPolicy. */
  public UnaryCallSettings<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicySettings() {
    return createAutoscalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAutoscalingPolicy. */
  public UnaryCallSettings<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicySettings() {
    return updateAutoscalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to getAutoscalingPolicy. */
  public UnaryCallSettings<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicySettings() {
    return getAutoscalingPolicySettings;
  }

  /** Returns the object with the settings used for calls to listAutoscalingPolicies. */
  public PagedCallSettings<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesSettings() {
    return listAutoscalingPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to deleteAutoscalingPolicy. */
  public UnaryCallSettings<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicySettings() {
    return deleteAutoscalingPolicySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AutoscalingPolicyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAutoscalingPolicyServiceStub.create(this);
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
    return "dataproc.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AutoscalingPolicyServiceStubSettings.class))
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

  protected AutoscalingPolicyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAutoscalingPolicySettings = settingsBuilder.createAutoscalingPolicySettings().build();
    updateAutoscalingPolicySettings = settingsBuilder.updateAutoscalingPolicySettings().build();
    getAutoscalingPolicySettings = settingsBuilder.getAutoscalingPolicySettings().build();
    listAutoscalingPoliciesSettings = settingsBuilder.listAutoscalingPoliciesSettings().build();
    deleteAutoscalingPolicySettings = settingsBuilder.deleteAutoscalingPolicySettings().build();
  }

  /** Builder for AutoscalingPolicyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AutoscalingPolicyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
        createAutoscalingPolicySettings;
    private final UnaryCallSettings.Builder<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
        updateAutoscalingPolicySettings;
    private final UnaryCallSettings.Builder<GetAutoscalingPolicyRequest, AutoscalingPolicy>
        getAutoscalingPolicySettings;
    private final PagedCallSettings.Builder<
            ListAutoscalingPoliciesRequest,
            ListAutoscalingPoliciesResponse,
            ListAutoscalingPoliciesPagedResponse>
        listAutoscalingPoliciesSettings;
    private final UnaryCallSettings.Builder<DeleteAutoscalingPolicyRequest, Empty>
        deleteAutoscalingPolicySettings;
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_0_params", settings);
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
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createAutoscalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAutoscalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAutoscalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAutoscalingPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_AUTOSCALING_POLICIES_PAGE_STR_FACT);
      deleteAutoscalingPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAutoscalingPolicySettings,
              updateAutoscalingPolicySettings,
              getAutoscalingPolicySettings,
              listAutoscalingPoliciesSettings,
              deleteAutoscalingPolicySettings);
      initDefaults(this);
    }

    protected Builder(AutoscalingPolicyServiceStubSettings settings) {
      super(settings);

      createAutoscalingPolicySettings = settings.createAutoscalingPolicySettings.toBuilder();
      updateAutoscalingPolicySettings = settings.updateAutoscalingPolicySettings.toBuilder();
      getAutoscalingPolicySettings = settings.getAutoscalingPolicySettings.toBuilder();
      listAutoscalingPoliciesSettings = settings.listAutoscalingPoliciesSettings.toBuilder();
      deleteAutoscalingPolicySettings = settings.deleteAutoscalingPolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAutoscalingPolicySettings,
              updateAutoscalingPolicySettings,
              getAutoscalingPolicySettings,
              listAutoscalingPoliciesSettings,
              deleteAutoscalingPolicySettings);
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
          .createAutoscalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAutoscalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getAutoscalingPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listAutoscalingPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteAutoscalingPolicySettings()
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

    /** Returns the builder for the settings used for calls to createAutoscalingPolicy. */
    public UnaryCallSettings.Builder<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
        createAutoscalingPolicySettings() {
      return createAutoscalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAutoscalingPolicy. */
    public UnaryCallSettings.Builder<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
        updateAutoscalingPolicySettings() {
      return updateAutoscalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getAutoscalingPolicy. */
    public UnaryCallSettings.Builder<GetAutoscalingPolicyRequest, AutoscalingPolicy>
        getAutoscalingPolicySettings() {
      return getAutoscalingPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listAutoscalingPolicies. */
    public PagedCallSettings.Builder<
            ListAutoscalingPoliciesRequest,
            ListAutoscalingPoliciesResponse,
            ListAutoscalingPoliciesPagedResponse>
        listAutoscalingPoliciesSettings() {
      return listAutoscalingPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAutoscalingPolicy. */
    public UnaryCallSettings.Builder<DeleteAutoscalingPolicyRequest, Empty>
        deleteAutoscalingPolicySettings() {
      return deleteAutoscalingPolicySettings;
    }

    @Override
    public AutoscalingPolicyServiceStubSettings build() throws IOException {
      return new AutoscalingPolicyServiceStubSettings(this);
    }
  }
}
