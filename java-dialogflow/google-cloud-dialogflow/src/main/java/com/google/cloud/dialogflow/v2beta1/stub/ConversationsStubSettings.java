/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListCallMatchersPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListMessagesPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesResponse;
import com.google.cloud.dialogflow.v2beta1.CallMatcher;
import com.google.cloud.dialogflow.v2beta1.CompleteConversationRequest;
import com.google.cloud.dialogflow.v2beta1.Conversation;
import com.google.cloud.dialogflow.v2beta1.CreateCallMatcherRequest;
import com.google.cloud.dialogflow.v2beta1.CreateConversationRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteCallMatcherRequest;
import com.google.cloud.dialogflow.v2beta1.GetConversationRequest;
import com.google.cloud.dialogflow.v2beta1.ListCallMatchersRequest;
import com.google.cloud.dialogflow.v2beta1.ListCallMatchersResponse;
import com.google.cloud.dialogflow.v2beta1.ListConversationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListConversationsResponse;
import com.google.cloud.dialogflow.v2beta1.ListMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.ListMessagesResponse;
import com.google.cloud.dialogflow.v2beta1.Message;
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
 * Settings class to configure an instance of {@link ConversationsStub}.
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
 * <p>For example, to set the total timeout of createConversation to 30 seconds:
 *
 * <pre>{@code
 * ConversationsStubSettings.Builder conversationsSettingsBuilder =
 *     ConversationsStubSettings.newBuilder();
 * conversationsSettingsBuilder
 *     .createConversationSettings()
 *     .setRetrySettings(
 *         conversationsSettingsBuilder
 *             .createConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationsStubSettings conversationsSettings = conversationsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationsStubSettings extends StubSettings<ConversationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateConversationRequest, Conversation>
      createConversationSettings;
  private final PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings;
  private final UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings;
  private final UnaryCallSettings<CompleteConversationRequest, Conversation>
      completeConversationSettings;
  private final UnaryCallSettings<CreateCallMatcherRequest, CallMatcher> createCallMatcherSettings;
  private final PagedCallSettings<
          ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
      listCallMatchersSettings;
  private final UnaryCallSettings<DeleteCallMatcherRequest, Empty> deleteCallMatcherSettings;
  private final UnaryCallSettings<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesSettings;
  private final PagedCallSettings<
          ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings;

  private static final PagedListDescriptor<
          ListConversationsRequest, ListConversationsResponse, Conversation>
      LIST_CONVERSATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationsRequest, ListConversationsResponse, Conversation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationsRequest injectToken(
                ListConversationsRequest payload, String token) {
              return ListConversationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversationsRequest injectPageSize(
                ListConversationsRequest payload, int pageSize) {
              return ListConversationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Conversation> extractResources(ListConversationsResponse payload) {
              return payload.getConversationsList() == null
                  ? ImmutableList.<Conversation>of()
                  : payload.getConversationsList();
            }
          };

  private static final PagedListDescriptor<
          ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher>
      LIST_CALL_MATCHERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCallMatchersRequest injectToken(
                ListCallMatchersRequest payload, String token) {
              return ListCallMatchersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCallMatchersRequest injectPageSize(
                ListCallMatchersRequest payload, int pageSize) {
              return ListCallMatchersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCallMatchersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCallMatchersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CallMatcher> extractResources(ListCallMatchersResponse payload) {
              return payload.getCallMatchersList() == null
                  ? ImmutableList.<CallMatcher>of()
                  : payload.getCallMatchersList();
            }
          };

  private static final PagedListDescriptor<ListMessagesRequest, ListMessagesResponse, Message>
      LIST_MESSAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMessagesRequest, ListMessagesResponse, Message>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMessagesRequest injectToken(ListMessagesRequest payload, String token) {
              return ListMessagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMessagesRequest injectPageSize(ListMessagesRequest payload, int pageSize) {
              return ListMessagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMessagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMessagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Message> extractResources(ListMessagesResponse payload) {
              return payload.getMessagesList() == null
                  ? ImmutableList.<Message>of()
                  : payload.getMessagesList();
            }
          };

  private static final PagedListResponseFactory<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      LIST_CONVERSATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationsRequest,
              ListConversationsResponse,
              ListConversationsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversationsRequest, ListConversationsResponse> callable,
                ListConversationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationsResponse> futureResponse) {
              PageContext<ListConversationsRequest, ListConversationsResponse, Conversation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSATIONS_PAGE_STR_DESC, request, context);
              return ListConversationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
      LIST_CALL_MATCHERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>() {
            @Override
            public ApiFuture<ListCallMatchersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCallMatchersRequest, ListCallMatchersResponse> callable,
                ListCallMatchersRequest request,
                ApiCallContext context,
                ApiFuture<ListCallMatchersResponse> futureResponse) {
              PageContext<ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CALL_MATCHERS_PAGE_STR_DESC, request, context);
              return ListCallMatchersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      LIST_MESSAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>() {
            @Override
            public ApiFuture<ListMessagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMessagesRequest, ListMessagesResponse> callable,
                ListMessagesRequest request,
                ApiCallContext context,
                ApiFuture<ListMessagesResponse> futureResponse) {
              PageContext<ListMessagesRequest, ListMessagesResponse, Message> pageContext =
                  PageContext.create(callable, LIST_MESSAGES_PAGE_STR_DESC, request, context);
              return ListMessagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return createConversationSettings;
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return listConversationsSettings;
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return getConversationSettings;
  }

  /** Returns the object with the settings used for calls to completeConversation. */
  public UnaryCallSettings<CompleteConversationRequest, Conversation>
      completeConversationSettings() {
    return completeConversationSettings;
  }

  /** Returns the object with the settings used for calls to createCallMatcher. */
  public UnaryCallSettings<CreateCallMatcherRequest, CallMatcher> createCallMatcherSettings() {
    return createCallMatcherSettings;
  }

  /** Returns the object with the settings used for calls to listCallMatchers. */
  public PagedCallSettings<
          ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
      listCallMatchersSettings() {
    return listCallMatchersSettings;
  }

  /** Returns the object with the settings used for calls to deleteCallMatcher. */
  public UnaryCallSettings<DeleteCallMatcherRequest, Empty> deleteCallMatcherSettings() {
    return deleteCallMatcherSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateMessages. */
  public UnaryCallSettings<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesSettings() {
    return batchCreateMessagesSettings;
  }

  /** Returns the object with the settings used for calls to listMessages. */
  public PagedCallSettings<ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
      listMessagesSettings() {
    return listMessagesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ConversationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConversationsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ConversationsStubSettings.class))
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

  protected ConversationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConversationSettings = settingsBuilder.createConversationSettings().build();
    listConversationsSettings = settingsBuilder.listConversationsSettings().build();
    getConversationSettings = settingsBuilder.getConversationSettings().build();
    completeConversationSettings = settingsBuilder.completeConversationSettings().build();
    createCallMatcherSettings = settingsBuilder.createCallMatcherSettings().build();
    listCallMatchersSettings = settingsBuilder.listCallMatchersSettings().build();
    deleteCallMatcherSettings = settingsBuilder.deleteCallMatcherSettings().build();
    batchCreateMessagesSettings = settingsBuilder.batchCreateMessagesSettings().build();
    listMessagesSettings = settingsBuilder.listMessagesSettings().build();
  }

  /** Builder for ConversationsStubSettings. */
  public static class Builder extends StubSettings.Builder<ConversationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings;
    private final PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings;
    private final UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings;
    private final UnaryCallSettings.Builder<CompleteConversationRequest, Conversation>
        completeConversationSettings;
    private final UnaryCallSettings.Builder<CreateCallMatcherRequest, CallMatcher>
        createCallMatcherSettings;
    private final PagedCallSettings.Builder<
            ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
        listCallMatchersSettings;
    private final UnaryCallSettings.Builder<DeleteCallMatcherRequest, Empty>
        deleteCallMatcherSettings;
    private final UnaryCallSettings.Builder<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
        batchCreateMessagesSettings;
    private final PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings;
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

      createConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationsSettings = PagedCallSettings.newBuilder(LIST_CONVERSATIONS_PAGE_STR_FACT);
      getConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      completeConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCallMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCallMatchersSettings = PagedCallSettings.newBuilder(LIST_CALL_MATCHERS_PAGE_STR_FACT);
      deleteCallMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateMessagesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMessagesSettings = PagedCallSettings.newBuilder(LIST_MESSAGES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              listConversationsSettings,
              getConversationSettings,
              completeConversationSettings,
              createCallMatcherSettings,
              listCallMatchersSettings,
              deleteCallMatcherSettings,
              batchCreateMessagesSettings,
              listMessagesSettings);
      initDefaults(this);
    }

    protected Builder(ConversationsStubSettings settings) {
      super(settings);

      createConversationSettings = settings.createConversationSettings.toBuilder();
      listConversationsSettings = settings.listConversationsSettings.toBuilder();
      getConversationSettings = settings.getConversationSettings.toBuilder();
      completeConversationSettings = settings.completeConversationSettings.toBuilder();
      createCallMatcherSettings = settings.createCallMatcherSettings.toBuilder();
      listCallMatchersSettings = settings.listCallMatchersSettings.toBuilder();
      deleteCallMatcherSettings = settings.deleteCallMatcherSettings.toBuilder();
      batchCreateMessagesSettings = settings.batchCreateMessagesSettings.toBuilder();
      listMessagesSettings = settings.listMessagesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              listConversationsSettings,
              getConversationSettings,
              completeConversationSettings,
              createCallMatcherSettings,
              listCallMatchersSettings,
              deleteCallMatcherSettings,
              batchCreateMessagesSettings,
              listMessagesSettings);
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
          .createConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .completeConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCallMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCallMatchersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCallMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCreateMessagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMessagesSettings()
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

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return createConversationSettings;
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return listConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getConversationSettings;
    }

    /** Returns the builder for the settings used for calls to completeConversation. */
    public UnaryCallSettings.Builder<CompleteConversationRequest, Conversation>
        completeConversationSettings() {
      return completeConversationSettings;
    }

    /** Returns the builder for the settings used for calls to createCallMatcher. */
    public UnaryCallSettings.Builder<CreateCallMatcherRequest, CallMatcher>
        createCallMatcherSettings() {
      return createCallMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to listCallMatchers. */
    public PagedCallSettings.Builder<
            ListCallMatchersRequest, ListCallMatchersResponse, ListCallMatchersPagedResponse>
        listCallMatchersSettings() {
      return listCallMatchersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCallMatcher. */
    public UnaryCallSettings.Builder<DeleteCallMatcherRequest, Empty> deleteCallMatcherSettings() {
      return deleteCallMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateMessages. */
    public UnaryCallSettings.Builder<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
        batchCreateMessagesSettings() {
      return batchCreateMessagesSettings;
    }

    /** Returns the builder for the settings used for calls to listMessages. */
    public PagedCallSettings.Builder<
            ListMessagesRequest, ListMessagesResponse, ListMessagesPagedResponse>
        listMessagesSettings() {
      return listMessagesSettings;
    }

    @Override
    public ConversationsStubSettings build() throws IOException {
      return new ConversationsStubSettings(this);
    }
  }
}
