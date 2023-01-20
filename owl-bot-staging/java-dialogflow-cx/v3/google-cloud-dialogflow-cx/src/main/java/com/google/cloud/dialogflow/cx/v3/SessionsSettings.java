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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.SessionsClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3.stub.SessionsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SessionsClient}.
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
 * <p>For example, to set the total timeout of detectIntent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SessionsSettings.Builder sessionsSettingsBuilder = SessionsSettings.newBuilder();
 * sessionsSettingsBuilder
 *     .detectIntentSettings()
 *     .setRetrySettings(
 *         sessionsSettingsBuilder
 *             .detectIntentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SessionsSettings sessionsSettings = sessionsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SessionsSettings extends ClientSettings<SessionsSettings> {

  /** Returns the object with the settings used for calls to detectIntent. */
  public UnaryCallSettings<DetectIntentRequest, DetectIntentResponse> detectIntentSettings() {
    return ((SessionsStubSettings) getStubSettings()).detectIntentSettings();
  }

  /** Returns the object with the settings used for calls to streamingDetectIntent. */
  public StreamingCallSettings<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentSettings() {
    return ((SessionsStubSettings) getStubSettings()).streamingDetectIntentSettings();
  }

  /** Returns the object with the settings used for calls to matchIntent. */
  public UnaryCallSettings<MatchIntentRequest, MatchIntentResponse> matchIntentSettings() {
    return ((SessionsStubSettings) getStubSettings()).matchIntentSettings();
  }

  /** Returns the object with the settings used for calls to fulfillIntent. */
  public UnaryCallSettings<FulfillIntentRequest, FulfillIntentResponse> fulfillIntentSettings() {
    return ((SessionsStubSettings) getStubSettings()).fulfillIntentSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SessionsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SessionsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SessionsSettings create(SessionsStubSettings stub) throws IOException {
    return new SessionsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SessionsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SessionsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SessionsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SessionsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SessionsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SessionsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SessionsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SessionsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected SessionsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SessionsSettings. */
  public static class Builder extends ClientSettings.Builder<SessionsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SessionsStubSettings.newBuilder(clientContext));
    }

    protected Builder(SessionsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SessionsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SessionsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SessionsStubSettings.newHttpJsonBuilder());
    }

    public SessionsStubSettings.Builder getStubSettingsBuilder() {
      return ((SessionsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to detectIntent. */
    public UnaryCallSettings.Builder<DetectIntentRequest, DetectIntentResponse>
        detectIntentSettings() {
      return getStubSettingsBuilder().detectIntentSettings();
    }

    /** Returns the builder for the settings used for calls to streamingDetectIntent. */
    public StreamingCallSettings.Builder<
            StreamingDetectIntentRequest, StreamingDetectIntentResponse>
        streamingDetectIntentSettings() {
      return getStubSettingsBuilder().streamingDetectIntentSettings();
    }

    /** Returns the builder for the settings used for calls to matchIntent. */
    public UnaryCallSettings.Builder<MatchIntentRequest, MatchIntentResponse>
        matchIntentSettings() {
      return getStubSettingsBuilder().matchIntentSettings();
    }

    /** Returns the builder for the settings used for calls to fulfillIntent. */
    public UnaryCallSettings.Builder<FulfillIntentRequest, FulfillIntentResponse>
        fulfillIntentSettings() {
      return getStubSettingsBuilder().fulfillIntentSettings();
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
    public SessionsSettings build() throws IOException {
      return new SessionsSettings(this);
    }
  }
}
