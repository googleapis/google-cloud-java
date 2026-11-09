/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListAssistantSessionsPagedResponse;
import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.ces.v1beta.stub.AssistantServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssistantServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ces.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAssistantSession:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssistantServiceSettings.Builder assistantServiceSettingsBuilder =
 *     AssistantServiceSettings.newBuilder();
 * assistantServiceSettingsBuilder
 *     .getAssistantSessionSettings()
 *     .setRetrySettings(
 *         assistantServiceSettingsBuilder
 *             .getAssistantSessionSettings()
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
 * AssistantServiceSettings assistantServiceSettings = assistantServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class AssistantServiceSettings extends ClientSettings<AssistantServiceSettings> {

  /** Returns the object with the settings used for calls to listAssistantSessions. */
  public PagedCallSettings<
          ListAssistantSessionsRequest,
          ListAssistantSessionsResponse,
          ListAssistantSessionsPagedResponse>
      listAssistantSessionsSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).listAssistantSessionsSettings();
  }

  /** Returns the object with the settings used for calls to getAssistantSession. */
  public UnaryCallSettings<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).getAssistantSessionSettings();
  }

  /** Returns the object with the settings used for calls to createAssistantSession. */
  public UnaryCallSettings<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).createAssistantSessionSettings();
  }

  /** Returns the object with the settings used for calls to deleteAssistantSession. */
  public UnaryCallSettings<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).deleteAssistantSessionSettings();
  }

  /** Returns the object with the settings used for calls to runAssistant. */
  public UnaryCallSettings<RunAssistantRequest, RunAssistantResponse> runAssistantSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).runAssistantSettings();
  }

  /** Returns the object with the settings used for calls to chatAiAssistant. */
  public UnaryCallSettings<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).chatAiAssistantSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AssistantServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AssistantServiceSettings create(AssistantServiceStubSettings stub)
      throws IOException {
    return new AssistantServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AssistantServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AssistantServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AssistantServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AssistantServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AssistantServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AssistantServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AssistantServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssistantServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AssistantServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AssistantServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AssistantServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(AssistantServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AssistantServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AssistantServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AssistantServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AssistantServiceStubSettings.newHttpJsonBuilder());
    }

    public AssistantServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AssistantServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAssistantSessions. */
    public PagedCallSettings.Builder<
            ListAssistantSessionsRequest,
            ListAssistantSessionsResponse,
            ListAssistantSessionsPagedResponse>
        listAssistantSessionsSettings() {
      return getStubSettingsBuilder().listAssistantSessionsSettings();
    }

    /** Returns the builder for the settings used for calls to getAssistantSession. */
    public UnaryCallSettings.Builder<GetAssistantSessionRequest, AssistantSession>
        getAssistantSessionSettings() {
      return getStubSettingsBuilder().getAssistantSessionSettings();
    }

    /** Returns the builder for the settings used for calls to createAssistantSession. */
    public UnaryCallSettings.Builder<CreateAssistantSessionRequest, AssistantSession>
        createAssistantSessionSettings() {
      return getStubSettingsBuilder().createAssistantSessionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAssistantSession. */
    public UnaryCallSettings.Builder<DeleteAssistantSessionRequest, Empty>
        deleteAssistantSessionSettings() {
      return getStubSettingsBuilder().deleteAssistantSessionSettings();
    }

    /** Returns the builder for the settings used for calls to runAssistant. */
    public UnaryCallSettings.Builder<RunAssistantRequest, RunAssistantResponse>
        runAssistantSettings() {
      return getStubSettingsBuilder().runAssistantSettings();
    }

    /** Returns the builder for the settings used for calls to chatAiAssistant. */
    public UnaryCallSettings.Builder<ChatAiAssistantRequest, ChatAiAssistantResponse>
        chatAiAssistantSettings() {
      return getStubSettingsBuilder().chatAiAssistantSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public AssistantServiceSettings build() throws IOException {
      return new AssistantServiceSettings(this);
    }
  }
}
