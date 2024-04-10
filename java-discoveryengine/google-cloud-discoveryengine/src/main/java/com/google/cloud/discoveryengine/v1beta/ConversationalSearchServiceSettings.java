/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListSessionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1beta.stub.ConversationalSearchServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversationalSearchServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of converseConversation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationalSearchServiceSettings.Builder conversationalSearchServiceSettingsBuilder =
 *     ConversationalSearchServiceSettings.newBuilder();
 * conversationalSearchServiceSettingsBuilder
 *     .converseConversationSettings()
 *     .setRetrySettings(
 *         conversationalSearchServiceSettingsBuilder
 *             .converseConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     conversationalSearchServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationalSearchServiceSettings
    extends ClientSettings<ConversationalSearchServiceSettings> {

  /** Returns the object with the settings used for calls to converseConversation. */
  public UnaryCallSettings<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings())
        .converseConversationSettings();
  }

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings())
        .createConversationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings())
        .deleteConversationSettings();
  }

  /** Returns the object with the settings used for calls to updateConversation. */
  public UnaryCallSettings<UpdateConversationRequest, Conversation> updateConversationSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings())
        .updateConversationSettings();
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).getConversationSettings();
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings())
        .listConversationsSettings();
  }

  /** Returns the object with the settings used for calls to answerQuery. */
  public UnaryCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQuerySettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).answerQuerySettings();
  }

  /** Returns the object with the settings used for calls to getAnswer. */
  public UnaryCallSettings<GetAnswerRequest, Answer> getAnswerSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).getAnswerSettings();
  }

  /** Returns the object with the settings used for calls to createSession. */
  public UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).createSessionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).deleteSessionSettings();
  }

  /** Returns the object with the settings used for calls to updateSession. */
  public UnaryCallSettings<UpdateSessionRequest, Session> updateSessionSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).updateSessionSettings();
  }

  /** Returns the object with the settings used for calls to getSession. */
  public UnaryCallSettings<GetSessionRequest, Session> getSessionSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).getSessionSettings();
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return ((ConversationalSearchServiceStubSettings) getStubSettings()).listSessionsSettings();
  }

  public static final ConversationalSearchServiceSettings create(
      ConversationalSearchServiceStubSettings stub) throws IOException {
    return new ConversationalSearchServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConversationalSearchServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConversationalSearchServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationalSearchServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConversationalSearchServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConversationalSearchServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ConversationalSearchServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConversationalSearchServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConversationalSearchServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConversationalSearchServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConversationalSearchServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ConversationalSearchServiceStubSettings.newHttpJsonBuilder());
    }

    public ConversationalSearchServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationalSearchServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to converseConversation. */
    public UnaryCallSettings.Builder<ConverseConversationRequest, ConverseConversationResponse>
        converseConversationSettings() {
      return getStubSettingsBuilder().converseConversationSettings();
    }

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return getStubSettingsBuilder().createConversationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return getStubSettingsBuilder().deleteConversationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversation. */
    public UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings() {
      return getStubSettingsBuilder().updateConversationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getStubSettingsBuilder().getConversationSettings();
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return getStubSettingsBuilder().listConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to answerQuery. */
    public UnaryCallSettings.Builder<AnswerQueryRequest, AnswerQueryResponse>
        answerQuerySettings() {
      return getStubSettingsBuilder().answerQuerySettings();
    }

    /** Returns the builder for the settings used for calls to getAnswer. */
    public UnaryCallSettings.Builder<GetAnswerRequest, Answer> getAnswerSettings() {
      return getStubSettingsBuilder().getAnswerSettings();
    }

    /** Returns the builder for the settings used for calls to createSession. */
    public UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings() {
      return getStubSettingsBuilder().createSessionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings() {
      return getStubSettingsBuilder().deleteSessionSettings();
    }

    /** Returns the builder for the settings used for calls to updateSession. */
    public UnaryCallSettings.Builder<UpdateSessionRequest, Session> updateSessionSettings() {
      return getStubSettingsBuilder().updateSessionSettings();
    }

    /** Returns the builder for the settings used for calls to getSession. */
    public UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings() {
      return getStubSettingsBuilder().getSessionSettings();
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return getStubSettingsBuilder().listSessionsSettings();
    }

    @Override
    public ConversationalSearchServiceSettings build() throws IOException {
      return new ConversationalSearchServiceSettings(this);
    }
  }
}
