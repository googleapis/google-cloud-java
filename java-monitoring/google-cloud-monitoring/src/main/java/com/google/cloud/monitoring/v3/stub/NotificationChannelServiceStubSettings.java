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

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

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
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NotificationChannelServiceStub}.
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
 * <p>For example, to set the total timeout of getNotificationChannelDescriptor to 30 seconds:
 *
 * <pre>{@code
 * NotificationChannelServiceStubSettings.Builder notificationChannelServiceSettingsBuilder =
 *     NotificationChannelServiceStubSettings.newBuilder();
 * notificationChannelServiceSettingsBuilder
 *     .getNotificationChannelDescriptorSettings()
 *     .setRetrySettings(
 *         notificationChannelServiceSettingsBuilder
 *             .getNotificationChannelDescriptorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotificationChannelServiceStubSettings notificationChannelServiceSettings =
 *     notificationChannelServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class NotificationChannelServiceStubSettings
    extends StubSettings<NotificationChannelServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final PagedCallSettings<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsSettings;
  private final UnaryCallSettings<
          GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorSettings;
  private final PagedCallSettings<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          ListNotificationChannelsPagedResponse>
      listNotificationChannelsSettings;
  private final UnaryCallSettings<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelSettings;
  private final UnaryCallSettings<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelSettings;
  private final UnaryCallSettings<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelSettings;
  private final UnaryCallSettings<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelSettings;
  private final UnaryCallSettings<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeSettings;
  private final UnaryCallSettings<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeSettings;
  private final UnaryCallSettings<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelSettings;

  private static final PagedListDescriptor<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          NotificationChannelDescriptor>
      LIST_NOTIFICATION_CHANNEL_DESCRIPTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotificationChannelDescriptorsRequest,
              ListNotificationChannelDescriptorsResponse,
              NotificationChannelDescriptor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotificationChannelDescriptorsRequest injectToken(
                ListNotificationChannelDescriptorsRequest payload, String token) {
              return ListNotificationChannelDescriptorsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNotificationChannelDescriptorsRequest injectPageSize(
                ListNotificationChannelDescriptorsRequest payload, int pageSize) {
              return ListNotificationChannelDescriptorsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotificationChannelDescriptorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotificationChannelDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotificationChannelDescriptor> extractResources(
                ListNotificationChannelDescriptorsResponse payload) {
              return payload.getChannelDescriptorsList() == null
                  ? ImmutableList.<NotificationChannelDescriptor>of()
                  : payload.getChannelDescriptorsList();
            }
          };

  private static final PagedListDescriptor<
          ListNotificationChannelsRequest, ListNotificationChannelsResponse, NotificationChannel>
      LIST_NOTIFICATION_CHANNELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotificationChannelsRequest,
              ListNotificationChannelsResponse,
              NotificationChannel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotificationChannelsRequest injectToken(
                ListNotificationChannelsRequest payload, String token) {
              return ListNotificationChannelsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNotificationChannelsRequest injectPageSize(
                ListNotificationChannelsRequest payload, int pageSize) {
              return ListNotificationChannelsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotificationChannelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotificationChannelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotificationChannel> extractResources(
                ListNotificationChannelsResponse payload) {
              return payload.getNotificationChannelsList() == null
                  ? ImmutableList.<NotificationChannel>of()
                  : payload.getNotificationChannelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          ListNotificationChannelDescriptorsPagedResponse>
      LIST_NOTIFICATION_CHANNEL_DESCRIPTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotificationChannelDescriptorsRequest,
              ListNotificationChannelDescriptorsResponse,
              ListNotificationChannelDescriptorsPagedResponse>() {
            @Override
            public ApiFuture<ListNotificationChannelDescriptorsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListNotificationChannelDescriptorsRequest,
                            ListNotificationChannelDescriptorsResponse>
                        callable,
                    ListNotificationChannelDescriptorsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListNotificationChannelDescriptorsResponse> futureResponse) {
              PageContext<
                      ListNotificationChannelDescriptorsRequest,
                      ListNotificationChannelDescriptorsResponse,
                      NotificationChannelDescriptor>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_NOTIFICATION_CHANNEL_DESCRIPTORS_PAGE_STR_DESC,
                          request,
                          context);
              return ListNotificationChannelDescriptorsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          ListNotificationChannelsPagedResponse>
      LIST_NOTIFICATION_CHANNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotificationChannelsRequest,
              ListNotificationChannelsResponse,
              ListNotificationChannelsPagedResponse>() {
            @Override
            public ApiFuture<ListNotificationChannelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
                    callable,
                ListNotificationChannelsRequest request,
                ApiCallContext context,
                ApiFuture<ListNotificationChannelsResponse> futureResponse) {
              PageContext<
                      ListNotificationChannelsRequest,
                      ListNotificationChannelsResponse,
                      NotificationChannel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTIFICATION_CHANNELS_PAGE_STR_DESC, request, context);
              return ListNotificationChannelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listNotificationChannelDescriptors. */
  public PagedCallSettings<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsResponse,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsSettings() {
    return listNotificationChannelDescriptorsSettings;
  }

  /** Returns the object with the settings used for calls to getNotificationChannelDescriptor. */
  public UnaryCallSettings<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorSettings() {
    return getNotificationChannelDescriptorSettings;
  }

  /** Returns the object with the settings used for calls to listNotificationChannels. */
  public PagedCallSettings<
          ListNotificationChannelsRequest,
          ListNotificationChannelsResponse,
          ListNotificationChannelsPagedResponse>
      listNotificationChannelsSettings() {
    return listNotificationChannelsSettings;
  }

  /** Returns the object with the settings used for calls to getNotificationChannel. */
  public UnaryCallSettings<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelSettings() {
    return getNotificationChannelSettings;
  }

  /** Returns the object with the settings used for calls to createNotificationChannel. */
  public UnaryCallSettings<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelSettings() {
    return createNotificationChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateNotificationChannel. */
  public UnaryCallSettings<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelSettings() {
    return updateNotificationChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotificationChannel. */
  public UnaryCallSettings<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelSettings() {
    return deleteNotificationChannelSettings;
  }

  /**
   * Returns the object with the settings used for calls to sendNotificationChannelVerificationCode.
   */
  public UnaryCallSettings<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeSettings() {
    return sendNotificationChannelVerificationCodeSettings;
  }

  /**
   * Returns the object with the settings used for calls to getNotificationChannelVerificationCode.
   */
  public UnaryCallSettings<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeSettings() {
    return getNotificationChannelVerificationCodeSettings;
  }

  /** Returns the object with the settings used for calls to verifyNotificationChannel. */
  public UnaryCallSettings<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelSettings() {
    return verifyNotificationChannelSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NotificationChannelServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNotificationChannelServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(NotificationChannelServiceStubSettings.class))
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

  protected NotificationChannelServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listNotificationChannelDescriptorsSettings =
        settingsBuilder.listNotificationChannelDescriptorsSettings().build();
    getNotificationChannelDescriptorSettings =
        settingsBuilder.getNotificationChannelDescriptorSettings().build();
    listNotificationChannelsSettings = settingsBuilder.listNotificationChannelsSettings().build();
    getNotificationChannelSettings = settingsBuilder.getNotificationChannelSettings().build();
    createNotificationChannelSettings = settingsBuilder.createNotificationChannelSettings().build();
    updateNotificationChannelSettings = settingsBuilder.updateNotificationChannelSettings().build();
    deleteNotificationChannelSettings = settingsBuilder.deleteNotificationChannelSettings().build();
    sendNotificationChannelVerificationCodeSettings =
        settingsBuilder.sendNotificationChannelVerificationCodeSettings().build();
    getNotificationChannelVerificationCodeSettings =
        settingsBuilder.getNotificationChannelVerificationCodeSettings().build();
    verifyNotificationChannelSettings = settingsBuilder.verifyNotificationChannelSettings().build();
  }

  /** Builder for NotificationChannelServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<NotificationChannelServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListNotificationChannelDescriptorsRequest,
            ListNotificationChannelDescriptorsResponse,
            ListNotificationChannelDescriptorsPagedResponse>
        listNotificationChannelDescriptorsSettings;
    private final UnaryCallSettings.Builder<
            GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
        getNotificationChannelDescriptorSettings;
    private final PagedCallSettings.Builder<
            ListNotificationChannelsRequest,
            ListNotificationChannelsResponse,
            ListNotificationChannelsPagedResponse>
        listNotificationChannelsSettings;
    private final UnaryCallSettings.Builder<GetNotificationChannelRequest, NotificationChannel>
        getNotificationChannelSettings;
    private final UnaryCallSettings.Builder<CreateNotificationChannelRequest, NotificationChannel>
        createNotificationChannelSettings;
    private final UnaryCallSettings.Builder<UpdateNotificationChannelRequest, NotificationChannel>
        updateNotificationChannelSettings;
    private final UnaryCallSettings.Builder<DeleteNotificationChannelRequest, Empty>
        deleteNotificationChannelSettings;
    private final UnaryCallSettings.Builder<SendNotificationChannelVerificationCodeRequest, Empty>
        sendNotificationChannelVerificationCodeSettings;
    private final UnaryCallSettings.Builder<
            GetNotificationChannelVerificationCodeRequest,
            GetNotificationChannelVerificationCodeResponse>
        getNotificationChannelVerificationCodeSettings;
    private final UnaryCallSettings.Builder<VerifyNotificationChannelRequest, NotificationChannel>
        verifyNotificationChannelSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_4_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_10_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("retry_policy_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_10_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listNotificationChannelDescriptorsSettings =
          PagedCallSettings.newBuilder(LIST_NOTIFICATION_CHANNEL_DESCRIPTORS_PAGE_STR_FACT);
      getNotificationChannelDescriptorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNotificationChannelsSettings =
          PagedCallSettings.newBuilder(LIST_NOTIFICATION_CHANNELS_PAGE_STR_FACT);
      getNotificationChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNotificationChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNotificationChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotificationChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sendNotificationChannelVerificationCodeSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNotificationChannelVerificationCodeSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      verifyNotificationChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNotificationChannelDescriptorsSettings,
              getNotificationChannelDescriptorSettings,
              listNotificationChannelsSettings,
              getNotificationChannelSettings,
              createNotificationChannelSettings,
              updateNotificationChannelSettings,
              deleteNotificationChannelSettings,
              sendNotificationChannelVerificationCodeSettings,
              getNotificationChannelVerificationCodeSettings,
              verifyNotificationChannelSettings);
      initDefaults(this);
    }

    protected Builder(NotificationChannelServiceStubSettings settings) {
      super(settings);

      listNotificationChannelDescriptorsSettings =
          settings.listNotificationChannelDescriptorsSettings.toBuilder();
      getNotificationChannelDescriptorSettings =
          settings.getNotificationChannelDescriptorSettings.toBuilder();
      listNotificationChannelsSettings = settings.listNotificationChannelsSettings.toBuilder();
      getNotificationChannelSettings = settings.getNotificationChannelSettings.toBuilder();
      createNotificationChannelSettings = settings.createNotificationChannelSettings.toBuilder();
      updateNotificationChannelSettings = settings.updateNotificationChannelSettings.toBuilder();
      deleteNotificationChannelSettings = settings.deleteNotificationChannelSettings.toBuilder();
      sendNotificationChannelVerificationCodeSettings =
          settings.sendNotificationChannelVerificationCodeSettings.toBuilder();
      getNotificationChannelVerificationCodeSettings =
          settings.getNotificationChannelVerificationCodeSettings.toBuilder();
      verifyNotificationChannelSettings = settings.verifyNotificationChannelSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listNotificationChannelDescriptorsSettings,
              getNotificationChannelDescriptorSettings,
              listNotificationChannelsSettings,
              getNotificationChannelSettings,
              createNotificationChannelSettings,
              updateNotificationChannelSettings,
              deleteNotificationChannelSettings,
              sendNotificationChannelVerificationCodeSettings,
              getNotificationChannelVerificationCodeSettings,
              verifyNotificationChannelSettings);
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
          .listNotificationChannelDescriptorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .getNotificationChannelDescriptorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .listNotificationChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .getNotificationChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .createNotificationChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_10_params"));

      builder
          .updateNotificationChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_10_params"));

      builder
          .deleteNotificationChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .sendNotificationChannelVerificationCodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_10_params"));

      builder
          .getNotificationChannelVerificationCodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .verifyNotificationChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

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

    /**
     * Returns the builder for the settings used for calls to listNotificationChannelDescriptors.
     */
    public PagedCallSettings.Builder<
            ListNotificationChannelDescriptorsRequest,
            ListNotificationChannelDescriptorsResponse,
            ListNotificationChannelDescriptorsPagedResponse>
        listNotificationChannelDescriptorsSettings() {
      return listNotificationChannelDescriptorsSettings;
    }

    /** Returns the builder for the settings used for calls to getNotificationChannelDescriptor. */
    public UnaryCallSettings.Builder<
            GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
        getNotificationChannelDescriptorSettings() {
      return getNotificationChannelDescriptorSettings;
    }

    /** Returns the builder for the settings used for calls to listNotificationChannels. */
    public PagedCallSettings.Builder<
            ListNotificationChannelsRequest,
            ListNotificationChannelsResponse,
            ListNotificationChannelsPagedResponse>
        listNotificationChannelsSettings() {
      return listNotificationChannelsSettings;
    }

    /** Returns the builder for the settings used for calls to getNotificationChannel. */
    public UnaryCallSettings.Builder<GetNotificationChannelRequest, NotificationChannel>
        getNotificationChannelSettings() {
      return getNotificationChannelSettings;
    }

    /** Returns the builder for the settings used for calls to createNotificationChannel. */
    public UnaryCallSettings.Builder<CreateNotificationChannelRequest, NotificationChannel>
        createNotificationChannelSettings() {
      return createNotificationChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateNotificationChannel. */
    public UnaryCallSettings.Builder<UpdateNotificationChannelRequest, NotificationChannel>
        updateNotificationChannelSettings() {
      return updateNotificationChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotificationChannel. */
    public UnaryCallSettings.Builder<DeleteNotificationChannelRequest, Empty>
        deleteNotificationChannelSettings() {
      return deleteNotificationChannelSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * sendNotificationChannelVerificationCode.
     */
    public UnaryCallSettings.Builder<SendNotificationChannelVerificationCodeRequest, Empty>
        sendNotificationChannelVerificationCodeSettings() {
      return sendNotificationChannelVerificationCodeSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getNotificationChannelVerificationCode.
     */
    public UnaryCallSettings.Builder<
            GetNotificationChannelVerificationCodeRequest,
            GetNotificationChannelVerificationCodeResponse>
        getNotificationChannelVerificationCodeSettings() {
      return getNotificationChannelVerificationCodeSettings;
    }

    /** Returns the builder for the settings used for calls to verifyNotificationChannel. */
    public UnaryCallSettings.Builder<VerifyNotificationChannelRequest, NotificationChannel>
        verifyNotificationChannelSettings() {
      return verifyNotificationChannelSettings;
    }

    @Override
    public NotificationChannelServiceStubSettings build() throws IOException {
      return new NotificationChannelServiceStubSettings(this);
    }
  }
}
