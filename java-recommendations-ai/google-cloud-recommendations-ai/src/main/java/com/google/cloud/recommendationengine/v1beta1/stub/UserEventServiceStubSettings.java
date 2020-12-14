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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.UserEventServiceClient.ListUserEventsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CollectUserEventRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportMetadata;
import com.google.cloud.recommendationengine.v1beta1.ImportUserEventsRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportUserEventsResponse;
import com.google.cloud.recommendationengine.v1beta1.ListUserEventsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListUserEventsResponse;
import com.google.cloud.recommendationengine.v1beta1.PurgeUserEventsMetadata;
import com.google.cloud.recommendationengine.v1beta1.PurgeUserEventsRequest;
import com.google.cloud.recommendationengine.v1beta1.PurgeUserEventsResponse;
import com.google.cloud.recommendationengine.v1beta1.UserEvent;
import com.google.cloud.recommendationengine.v1beta1.WriteUserEventRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UserEventServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recommendationengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of writeUserEvent to 30 seconds:
 *
 * <pre>{@code
 * UserEventServiceStubSettings.Builder userEventServiceSettingsBuilder =
 *     UserEventServiceStubSettings.newBuilder();
 * userEventServiceSettingsBuilder
 *     .writeUserEventSettings()
 *     .setRetrySettings(
 *         userEventServiceSettingsBuilder
 *             .writeUserEventSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * UserEventServiceStubSettings userEventServiceSettings = userEventServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UserEventServiceStubSettings extends StubSettings<UserEventServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<WriteUserEventRequest, UserEvent> writeUserEventSettings;
  private final UnaryCallSettings<CollectUserEventRequest, HttpBody> collectUserEventSettings;
  private final PagedCallSettings<
          ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>
      listUserEventsSettings;
  private final UnaryCallSettings<PurgeUserEventsRequest, Operation> purgeUserEventsSettings;
  private final OperationCallSettings<
          PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationSettings;
  private final UnaryCallSettings<ImportUserEventsRequest, Operation> importUserEventsSettings;
  private final OperationCallSettings<
          ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationSettings;

  private static final PagedListDescriptor<ListUserEventsRequest, ListUserEventsResponse, UserEvent>
      LIST_USER_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUserEventsRequest, ListUserEventsResponse, UserEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserEventsRequest injectToken(ListUserEventsRequest payload, String token) {
              return ListUserEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUserEventsRequest injectPageSize(
                ListUserEventsRequest payload, int pageSize) {
              return ListUserEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUserEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserEvent> extractResources(ListUserEventsResponse payload) {
              return payload.getUserEventsList() == null
                  ? ImmutableList.<UserEvent>of()
                  : payload.getUserEventsList();
            }
          };

  private static final PagedListResponseFactory<
          ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>
      LIST_USER_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>() {
            @Override
            public ApiFuture<ListUserEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserEventsRequest, ListUserEventsResponse> callable,
                ListUserEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListUserEventsResponse> futureResponse) {
              PageContext<ListUserEventsRequest, ListUserEventsResponse, UserEvent> pageContext =
                  PageContext.create(callable, LIST_USER_EVENTS_PAGE_STR_DESC, request, context);
              return ListUserEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to writeUserEvent. */
  public UnaryCallSettings<WriteUserEventRequest, UserEvent> writeUserEventSettings() {
    return writeUserEventSettings;
  }

  /** Returns the object with the settings used for calls to collectUserEvent. */
  public UnaryCallSettings<CollectUserEventRequest, HttpBody> collectUserEventSettings() {
    return collectUserEventSettings;
  }

  /** Returns the object with the settings used for calls to listUserEvents. */
  public PagedCallSettings<
          ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>
      listUserEventsSettings() {
    return listUserEventsSettings;
  }

  /** Returns the object with the settings used for calls to purgeUserEvents. */
  public UnaryCallSettings<PurgeUserEventsRequest, Operation> purgeUserEventsSettings() {
    return purgeUserEventsSettings;
  }

  /** Returns the object with the settings used for calls to purgeUserEvents. */
  public OperationCallSettings<
          PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationSettings() {
    return purgeUserEventsOperationSettings;
  }

  /** Returns the object with the settings used for calls to importUserEvents. */
  public UnaryCallSettings<ImportUserEventsRequest, Operation> importUserEventsSettings() {
    return importUserEventsSettings;
  }

  /** Returns the object with the settings used for calls to importUserEvents. */
  public OperationCallSettings<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationSettings() {
    return importUserEventsOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UserEventServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcUserEventServiceStub.create(this);
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
    return "recommendationengine.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(UserEventServiceStubSettings.class))
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

  protected UserEventServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    writeUserEventSettings = settingsBuilder.writeUserEventSettings().build();
    collectUserEventSettings = settingsBuilder.collectUserEventSettings().build();
    listUserEventsSettings = settingsBuilder.listUserEventsSettings().build();
    purgeUserEventsSettings = settingsBuilder.purgeUserEventsSettings().build();
    purgeUserEventsOperationSettings = settingsBuilder.purgeUserEventsOperationSettings().build();
    importUserEventsSettings = settingsBuilder.importUserEventsSettings().build();
    importUserEventsOperationSettings = settingsBuilder.importUserEventsOperationSettings().build();
  }

  /** Builder for UserEventServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<UserEventServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<WriteUserEventRequest, UserEvent>
        writeUserEventSettings;
    private final UnaryCallSettings.Builder<CollectUserEventRequest, HttpBody>
        collectUserEventSettings;
    private final PagedCallSettings.Builder<
            ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>
        listUserEventsSettings;
    private final UnaryCallSettings.Builder<PurgeUserEventsRequest, Operation>
        purgeUserEventsSettings;
    private final OperationCallSettings.Builder<
            PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
        purgeUserEventsOperationSettings;
    private final UnaryCallSettings.Builder<ImportUserEventsRequest, Operation>
        importUserEventsSettings;
    private final OperationCallSettings.Builder<
            ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
        importUserEventsOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      writeUserEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      collectUserEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserEventsSettings = PagedCallSettings.newBuilder(LIST_USER_EVENTS_PAGE_STR_FACT);
      purgeUserEventsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      purgeUserEventsOperationSettings = OperationCallSettings.newBuilder();
      importUserEventsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importUserEventsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              writeUserEventSettings,
              collectUserEventSettings,
              listUserEventsSettings,
              purgeUserEventsSettings,
              importUserEventsSettings);
      initDefaults(this);
    }

    protected Builder(UserEventServiceStubSettings settings) {
      super(settings);

      writeUserEventSettings = settings.writeUserEventSettings.toBuilder();
      collectUserEventSettings = settings.collectUserEventSettings.toBuilder();
      listUserEventsSettings = settings.listUserEventsSettings.toBuilder();
      purgeUserEventsSettings = settings.purgeUserEventsSettings.toBuilder();
      purgeUserEventsOperationSettings = settings.purgeUserEventsOperationSettings.toBuilder();
      importUserEventsSettings = settings.importUserEventsSettings.toBuilder();
      importUserEventsOperationSettings = settings.importUserEventsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              writeUserEventSettings,
              collectUserEventSettings,
              listUserEventsSettings,
              purgeUserEventsSettings,
              importUserEventsSettings);
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
          .writeUserEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .collectUserEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUserEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .purgeUserEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importUserEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .purgeUserEventsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PurgeUserEventsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PurgeUserEventsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(PurgeUserEventsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importUserEventsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportUserEventsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportUserEventsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to writeUserEvent. */
    public UnaryCallSettings.Builder<WriteUserEventRequest, UserEvent> writeUserEventSettings() {
      return writeUserEventSettings;
    }

    /** Returns the builder for the settings used for calls to collectUserEvent. */
    public UnaryCallSettings.Builder<CollectUserEventRequest, HttpBody> collectUserEventSettings() {
      return collectUserEventSettings;
    }

    /** Returns the builder for the settings used for calls to listUserEvents. */
    public PagedCallSettings.Builder<
            ListUserEventsRequest, ListUserEventsResponse, ListUserEventsPagedResponse>
        listUserEventsSettings() {
      return listUserEventsSettings;
    }

    /** Returns the builder for the settings used for calls to purgeUserEvents. */
    public UnaryCallSettings.Builder<PurgeUserEventsRequest, Operation> purgeUserEventsSettings() {
      return purgeUserEventsSettings;
    }

    /** Returns the builder for the settings used for calls to purgeUserEvents. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
        purgeUserEventsOperationSettings() {
      return purgeUserEventsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importUserEvents. */
    public UnaryCallSettings.Builder<ImportUserEventsRequest, Operation>
        importUserEventsSettings() {
      return importUserEventsSettings;
    }

    /** Returns the builder for the settings used for calls to importUserEvents. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
        importUserEventsOperationSettings() {
      return importUserEventsOperationSettings;
    }

    @Override
    public UserEventServiceStubSettings build() throws IOException {
      return new UserEventServiceStubSettings(this);
    }
  }
}
