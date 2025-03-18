/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.modelarmor.v1.stub;

import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListTemplatesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1.CreateTemplateRequest;
import com.google.cloud.modelarmor.v1.DeleteTemplateRequest;
import com.google.cloud.modelarmor.v1.FloorSetting;
import com.google.cloud.modelarmor.v1.GetFloorSettingRequest;
import com.google.cloud.modelarmor.v1.GetTemplateRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesResponse;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseRequest;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseResponse;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptRequest;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptResponse;
import com.google.cloud.modelarmor.v1.Template;
import com.google.cloud.modelarmor.v1.UpdateFloorSettingRequest;
import com.google.cloud.modelarmor.v1.UpdateTemplateRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelArmorStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (modelarmor.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTemplate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelArmorStubSettings.Builder modelArmorSettingsBuilder = ModelArmorStubSettings.newBuilder();
 * modelArmorSettingsBuilder
 *     .getTemplateSettings()
 *     .setRetrySettings(
 *         modelArmorSettingsBuilder
 *             .getTemplateSettings()
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
 * ModelArmorStubSettings modelArmorSettings = modelArmorSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ModelArmorStubSettings extends StubSettings<ModelArmorStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
      listTemplatesSettings;
  private final UnaryCallSettings<GetTemplateRequest, Template> getTemplateSettings;
  private final UnaryCallSettings<CreateTemplateRequest, Template> createTemplateSettings;
  private final UnaryCallSettings<UpdateTemplateRequest, Template> updateTemplateSettings;
  private final UnaryCallSettings<DeleteTemplateRequest, Empty> deleteTemplateSettings;
  private final UnaryCallSettings<GetFloorSettingRequest, FloorSetting> getFloorSettingSettings;
  private final UnaryCallSettings<UpdateFloorSettingRequest, FloorSetting>
      updateFloorSettingSettings;
  private final UnaryCallSettings<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptSettings;
  private final UnaryCallSettings<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListTemplatesRequest, ListTemplatesResponse, Template>
      LIST_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTemplatesRequest, ListTemplatesResponse, Template>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTemplatesRequest injectToken(ListTemplatesRequest payload, String token) {
              return ListTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTemplatesRequest injectPageSize(ListTemplatesRequest payload, int pageSize) {
              return ListTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Template> extractResources(ListTemplatesResponse payload) {
              return payload.getTemplatesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
      LIST_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> callable,
                ListTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListTemplatesResponse> futureResponse) {
              PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> pageContext =
                  PageContext.create(callable, LIST_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listTemplates. */
  public PagedCallSettings<ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
      listTemplatesSettings() {
    return listTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to getTemplate. */
  public UnaryCallSettings<GetTemplateRequest, Template> getTemplateSettings() {
    return getTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createTemplate. */
  public UnaryCallSettings<CreateTemplateRequest, Template> createTemplateSettings() {
    return createTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateTemplate. */
  public UnaryCallSettings<UpdateTemplateRequest, Template> updateTemplateSettings() {
    return updateTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteTemplate. */
  public UnaryCallSettings<DeleteTemplateRequest, Empty> deleteTemplateSettings() {
    return deleteTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getFloorSetting. */
  public UnaryCallSettings<GetFloorSettingRequest, FloorSetting> getFloorSettingSettings() {
    return getFloorSettingSettings;
  }

  /** Returns the object with the settings used for calls to updateFloorSetting. */
  public UnaryCallSettings<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingSettings() {
    return updateFloorSettingSettings;
  }

  /** Returns the object with the settings used for calls to sanitizeUserPrompt. */
  public UnaryCallSettings<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptSettings() {
    return sanitizeUserPromptSettings;
  }

  /** Returns the object with the settings used for calls to sanitizeModelResponse. */
  public UnaryCallSettings<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseSettings() {
    return sanitizeModelResponseSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public ModelArmorStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelArmorStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonModelArmorStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "modelarmor";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "modelarmor.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "modelarmor.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ModelArmorStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelArmorStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelArmorStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ModelArmorStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTemplatesSettings = settingsBuilder.listTemplatesSettings().build();
    getTemplateSettings = settingsBuilder.getTemplateSettings().build();
    createTemplateSettings = settingsBuilder.createTemplateSettings().build();
    updateTemplateSettings = settingsBuilder.updateTemplateSettings().build();
    deleteTemplateSettings = settingsBuilder.deleteTemplateSettings().build();
    getFloorSettingSettings = settingsBuilder.getFloorSettingSettings().build();
    updateFloorSettingSettings = settingsBuilder.updateFloorSettingSettings().build();
    sanitizeUserPromptSettings = settingsBuilder.sanitizeUserPromptSettings().build();
    sanitizeModelResponseSettings = settingsBuilder.sanitizeModelResponseSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ModelArmorStubSettings. */
  public static class Builder extends StubSettings.Builder<ModelArmorStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
        listTemplatesSettings;
    private final UnaryCallSettings.Builder<GetTemplateRequest, Template> getTemplateSettings;
    private final UnaryCallSettings.Builder<CreateTemplateRequest, Template> createTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateTemplateRequest, Template> updateTemplateSettings;
    private final UnaryCallSettings.Builder<DeleteTemplateRequest, Empty> deleteTemplateSettings;
    private final UnaryCallSettings.Builder<GetFloorSettingRequest, FloorSetting>
        getFloorSettingSettings;
    private final UnaryCallSettings.Builder<UpdateFloorSettingRequest, FloorSetting>
        updateFloorSettingSettings;
    private final UnaryCallSettings.Builder<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
        sanitizeUserPromptSettings;
    private final UnaryCallSettings.Builder<
            SanitizeModelResponseRequest, SanitizeModelResponseResponse>
        sanitizeModelResponseSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
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

      listTemplatesSettings = PagedCallSettings.newBuilder(LIST_TEMPLATES_PAGE_STR_FACT);
      getTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFloorSettingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFloorSettingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sanitizeUserPromptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sanitizeModelResponseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTemplatesSettings,
              getTemplateSettings,
              createTemplateSettings,
              updateTemplateSettings,
              deleteTemplateSettings,
              getFloorSettingSettings,
              updateFloorSettingSettings,
              sanitizeUserPromptSettings,
              sanitizeModelResponseSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ModelArmorStubSettings settings) {
      super(settings);

      listTemplatesSettings = settings.listTemplatesSettings.toBuilder();
      getTemplateSettings = settings.getTemplateSettings.toBuilder();
      createTemplateSettings = settings.createTemplateSettings.toBuilder();
      updateTemplateSettings = settings.updateTemplateSettings.toBuilder();
      deleteTemplateSettings = settings.deleteTemplateSettings.toBuilder();
      getFloorSettingSettings = settings.getFloorSettingSettings.toBuilder();
      updateFloorSettingSettings = settings.updateFloorSettingSettings.toBuilder();
      sanitizeUserPromptSettings = settings.sanitizeUserPromptSettings.toBuilder();
      sanitizeModelResponseSettings = settings.sanitizeModelResponseSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTemplatesSettings,
              getTemplateSettings,
              createTemplateSettings,
              updateTemplateSettings,
              deleteTemplateSettings,
              getFloorSettingSettings,
              updateFloorSettingSettings,
              sanitizeUserPromptSettings,
              sanitizeModelResponseSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getFloorSettingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFloorSettingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .sanitizeUserPromptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .sanitizeModelResponseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to listTemplates. */
    public PagedCallSettings.Builder<
            ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
        listTemplatesSettings() {
      return listTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to getTemplate. */
    public UnaryCallSettings.Builder<GetTemplateRequest, Template> getTemplateSettings() {
      return getTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createTemplate. */
    public UnaryCallSettings.Builder<CreateTemplateRequest, Template> createTemplateSettings() {
      return createTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateTemplate. */
    public UnaryCallSettings.Builder<UpdateTemplateRequest, Template> updateTemplateSettings() {
      return updateTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTemplate. */
    public UnaryCallSettings.Builder<DeleteTemplateRequest, Empty> deleteTemplateSettings() {
      return deleteTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getFloorSetting. */
    public UnaryCallSettings.Builder<GetFloorSettingRequest, FloorSetting>
        getFloorSettingSettings() {
      return getFloorSettingSettings;
    }

    /** Returns the builder for the settings used for calls to updateFloorSetting. */
    public UnaryCallSettings.Builder<UpdateFloorSettingRequest, FloorSetting>
        updateFloorSettingSettings() {
      return updateFloorSettingSettings;
    }

    /** Returns the builder for the settings used for calls to sanitizeUserPrompt. */
    public UnaryCallSettings.Builder<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
        sanitizeUserPromptSettings() {
      return sanitizeUserPromptSettings;
    }

    /** Returns the builder for the settings used for calls to sanitizeModelResponse. */
    public UnaryCallSettings.Builder<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
        sanitizeModelResponseSettings() {
      return sanitizeModelResponseSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public ModelArmorStubSettings build() throws IOException {
      return new ModelArmorStubSettings(this);
    }
  }
}
