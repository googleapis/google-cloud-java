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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest;
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
 * Settings class to configure an instance of {@link SecuritySettingsServiceStub}.
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
 * <p>For example, to set the total timeout of createSecuritySettings to 30 seconds:
 *
 * <pre>{@code
 * SecuritySettingsServiceStubSettings.Builder securitySettingsServiceSettingsBuilder =
 *     SecuritySettingsServiceStubSettings.newBuilder();
 * securitySettingsServiceSettingsBuilder
 *     .createSecuritySettingsSettings()
 *     .setRetrySettings(
 *         securitySettingsServiceSettingsBuilder
 *             .createSecuritySettingsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecuritySettingsServiceStubSettings securitySettingsServiceSettings =
 *     securitySettingsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SecuritySettingsServiceStubSettings
    extends StubSettings<SecuritySettingsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsSettings;
  private final UnaryCallSettings<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsSettings;
  private final UnaryCallSettings<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsSettings;
  private final PagedCallSettings<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          ListSecuritySettingsPagedResponse>
      listSecuritySettingsSettings;
  private final UnaryCallSettings<DeleteSecuritySettingsRequest, Empty>
      deleteSecuritySettingsSettings;

  private static final PagedListDescriptor<
          ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
      LIST_SECURITY_SETTINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecuritySettingsRequest injectToken(
                ListSecuritySettingsRequest payload, String token) {
              return ListSecuritySettingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSecuritySettingsRequest injectPageSize(
                ListSecuritySettingsRequest payload, int pageSize) {
              return ListSecuritySettingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSecuritySettingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSecuritySettingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecuritySettings> extractResources(
                ListSecuritySettingsResponse payload) {
              return payload.getSecuritySettingsList() == null
                  ? ImmutableList.<SecuritySettings>of()
                  : payload.getSecuritySettingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          ListSecuritySettingsPagedResponse>
      LIST_SECURITY_SETTINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecuritySettingsRequest,
              ListSecuritySettingsResponse,
              ListSecuritySettingsPagedResponse>() {
            @Override
            public ApiFuture<ListSecuritySettingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse> callable,
                ListSecuritySettingsRequest request,
                ApiCallContext context,
                ApiFuture<ListSecuritySettingsResponse> futureResponse) {
              PageContext<
                      ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SECURITY_SETTINGS_PAGE_STR_DESC, request, context);
              return ListSecuritySettingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSecuritySettings. */
  public UnaryCallSettings<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsSettings() {
    return createSecuritySettingsSettings;
  }

  /** Returns the object with the settings used for calls to getSecuritySettings. */
  public UnaryCallSettings<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsSettings() {
    return getSecuritySettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSecuritySettings. */
  public UnaryCallSettings<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsSettings() {
    return updateSecuritySettingsSettings;
  }

  /** Returns the object with the settings used for calls to listSecuritySettings. */
  public PagedCallSettings<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          ListSecuritySettingsPagedResponse>
      listSecuritySettingsSettings() {
    return listSecuritySettingsSettings;
  }

  /** Returns the object with the settings used for calls to deleteSecuritySettings. */
  public UnaryCallSettings<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsSettings() {
    return deleteSecuritySettingsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecuritySettingsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecuritySettingsServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SecuritySettingsServiceStubSettings.class))
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

  protected SecuritySettingsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSecuritySettingsSettings = settingsBuilder.createSecuritySettingsSettings().build();
    getSecuritySettingsSettings = settingsBuilder.getSecuritySettingsSettings().build();
    updateSecuritySettingsSettings = settingsBuilder.updateSecuritySettingsSettings().build();
    listSecuritySettingsSettings = settingsBuilder.listSecuritySettingsSettings().build();
    deleteSecuritySettingsSettings = settingsBuilder.deleteSecuritySettingsSettings().build();
  }

  /** Builder for SecuritySettingsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SecuritySettingsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSecuritySettingsRequest, SecuritySettings>
        createSecuritySettingsSettings;
    private final UnaryCallSettings.Builder<GetSecuritySettingsRequest, SecuritySettings>
        getSecuritySettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSecuritySettingsRequest, SecuritySettings>
        updateSecuritySettingsSettings;
    private final PagedCallSettings.Builder<
            ListSecuritySettingsRequest,
            ListSecuritySettingsResponse,
            ListSecuritySettingsPagedResponse>
        listSecuritySettingsSettings;
    private final UnaryCallSettings.Builder<DeleteSecuritySettingsRequest, Empty>
        deleteSecuritySettingsSettings;
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

      createSecuritySettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSecuritySettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecuritySettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSecuritySettingsSettings =
          PagedCallSettings.newBuilder(LIST_SECURITY_SETTINGS_PAGE_STR_FACT);
      deleteSecuritySettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSecuritySettingsSettings,
              getSecuritySettingsSettings,
              updateSecuritySettingsSettings,
              listSecuritySettingsSettings,
              deleteSecuritySettingsSettings);
      initDefaults(this);
    }

    protected Builder(SecuritySettingsServiceStubSettings settings) {
      super(settings);

      createSecuritySettingsSettings = settings.createSecuritySettingsSettings.toBuilder();
      getSecuritySettingsSettings = settings.getSecuritySettingsSettings.toBuilder();
      updateSecuritySettingsSettings = settings.updateSecuritySettingsSettings.toBuilder();
      listSecuritySettingsSettings = settings.listSecuritySettingsSettings.toBuilder();
      deleteSecuritySettingsSettings = settings.deleteSecuritySettingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSecuritySettingsSettings,
              getSecuritySettingsSettings,
              updateSecuritySettingsSettings,
              listSecuritySettingsSettings,
              deleteSecuritySettingsSettings);
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
          .createSecuritySettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSecuritySettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSecuritySettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSecuritySettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSecuritySettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createSecuritySettings. */
    public UnaryCallSettings.Builder<CreateSecuritySettingsRequest, SecuritySettings>
        createSecuritySettingsSettings() {
      return createSecuritySettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getSecuritySettings. */
    public UnaryCallSettings.Builder<GetSecuritySettingsRequest, SecuritySettings>
        getSecuritySettingsSettings() {
      return getSecuritySettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecuritySettings. */
    public UnaryCallSettings.Builder<UpdateSecuritySettingsRequest, SecuritySettings>
        updateSecuritySettingsSettings() {
      return updateSecuritySettingsSettings;
    }

    /** Returns the builder for the settings used for calls to listSecuritySettings. */
    public PagedCallSettings.Builder<
            ListSecuritySettingsRequest,
            ListSecuritySettingsResponse,
            ListSecuritySettingsPagedResponse>
        listSecuritySettingsSettings() {
      return listSecuritySettingsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSecuritySettings. */
    public UnaryCallSettings.Builder<DeleteSecuritySettingsRequest, Empty>
        deleteSecuritySettingsSettings() {
      return deleteSecuritySettingsSettings;
    }

    @Override
    public SecuritySettingsServiceStubSettings build() throws IOException {
      return new SecuritySettingsServiceStubSettings(this);
    }
  }
}
