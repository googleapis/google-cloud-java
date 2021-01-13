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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3beta1.stub.SessionEntityTypesStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SessionEntityTypesClient}.
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
 * <p>For example, to set the total timeout of getSessionEntityType to 30 seconds:
 *
 * <pre>{@code
 * SessionEntityTypesSettings.Builder sessionEntityTypesSettingsBuilder =
 *     SessionEntityTypesSettings.newBuilder();
 * sessionEntityTypesSettingsBuilder
 *     .getSessionEntityTypeSettings()
 *     .setRetrySettings(
 *         sessionEntityTypesSettingsBuilder
 *             .getSessionEntityTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SessionEntityTypesSettings sessionEntityTypesSettings =
 *     sessionEntityTypesSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SessionEntityTypesSettings extends ClientSettings<SessionEntityTypesSettings> {

  /** Returns the object with the settings used for calls to listSessionEntityTypes. */
  public PagedCallSettings<
          ListSessionEntityTypesRequest,
          ListSessionEntityTypesResponse,
          ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesSettings() {
    return ((SessionEntityTypesStubSettings) getStubSettings()).listSessionEntityTypesSettings();
  }

  /** Returns the object with the settings used for calls to getSessionEntityType. */
  public UnaryCallSettings<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeSettings() {
    return ((SessionEntityTypesStubSettings) getStubSettings()).getSessionEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to createSessionEntityType. */
  public UnaryCallSettings<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeSettings() {
    return ((SessionEntityTypesStubSettings) getStubSettings()).createSessionEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to updateSessionEntityType. */
  public UnaryCallSettings<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeSettings() {
    return ((SessionEntityTypesStubSettings) getStubSettings()).updateSessionEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteSessionEntityType. */
  public UnaryCallSettings<DeleteSessionEntityTypeRequest, Empty>
      deleteSessionEntityTypeSettings() {
    return ((SessionEntityTypesStubSettings) getStubSettings()).deleteSessionEntityTypeSettings();
  }

  public static final SessionEntityTypesSettings create(SessionEntityTypesStubSettings stub)
      throws IOException {
    return new SessionEntityTypesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SessionEntityTypesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SessionEntityTypesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SessionEntityTypesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SessionEntityTypesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SessionEntityTypesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SessionEntityTypesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SessionEntityTypesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SessionEntityTypesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SessionEntityTypesSettings. */
  public static class Builder extends ClientSettings.Builder<SessionEntityTypesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SessionEntityTypesStubSettings.newBuilder(clientContext));
    }

    protected Builder(SessionEntityTypesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SessionEntityTypesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SessionEntityTypesStubSettings.newBuilder());
    }

    public SessionEntityTypesStubSettings.Builder getStubSettingsBuilder() {
      return ((SessionEntityTypesStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listSessionEntityTypes. */
    public PagedCallSettings.Builder<
            ListSessionEntityTypesRequest,
            ListSessionEntityTypesResponse,
            ListSessionEntityTypesPagedResponse>
        listSessionEntityTypesSettings() {
      return getStubSettingsBuilder().listSessionEntityTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getSessionEntityType. */
    public UnaryCallSettings.Builder<GetSessionEntityTypeRequest, SessionEntityType>
        getSessionEntityTypeSettings() {
      return getStubSettingsBuilder().getSessionEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createSessionEntityType. */
    public UnaryCallSettings.Builder<CreateSessionEntityTypeRequest, SessionEntityType>
        createSessionEntityTypeSettings() {
      return getStubSettingsBuilder().createSessionEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to updateSessionEntityType. */
    public UnaryCallSettings.Builder<UpdateSessionEntityTypeRequest, SessionEntityType>
        updateSessionEntityTypeSettings() {
      return getStubSettingsBuilder().updateSessionEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSessionEntityType. */
    public UnaryCallSettings.Builder<DeleteSessionEntityTypeRequest, Empty>
        deleteSessionEntityTypeSettings() {
      return getStubSettingsBuilder().deleteSessionEntityTypeSettings();
    }

    @Override
    public SessionEntityTypesSettings build() throws IOException {
      return new SessionEntityTypesSettings(this);
    }
  }
}
