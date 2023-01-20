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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1beta.stub.UserEventServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UserEventServiceClient}.
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
 * <p>For example, to set the total timeout of writeUserEvent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserEventServiceSettings.Builder userEventServiceSettingsBuilder =
 *     UserEventServiceSettings.newBuilder();
 * userEventServiceSettingsBuilder
 *     .writeUserEventSettings()
 *     .setRetrySettings(
 *         userEventServiceSettingsBuilder
 *             .writeUserEventSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * UserEventServiceSettings userEventServiceSettings = userEventServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UserEventServiceSettings extends ClientSettings<UserEventServiceSettings> {

  /** Returns the object with the settings used for calls to writeUserEvent. */
  public UnaryCallSettings<WriteUserEventRequest, UserEvent> writeUserEventSettings() {
    return ((UserEventServiceStubSettings) getStubSettings()).writeUserEventSettings();
  }

  /** Returns the object with the settings used for calls to collectUserEvent. */
  public UnaryCallSettings<CollectUserEventRequest, HttpBody> collectUserEventSettings() {
    return ((UserEventServiceStubSettings) getStubSettings()).collectUserEventSettings();
  }

  /** Returns the object with the settings used for calls to importUserEvents. */
  public UnaryCallSettings<ImportUserEventsRequest, Operation> importUserEventsSettings() {
    return ((UserEventServiceStubSettings) getStubSettings()).importUserEventsSettings();
  }

  /** Returns the object with the settings used for calls to importUserEvents. */
  public OperationCallSettings<
          ImportUserEventsRequest, ImportUserEventsResponse, ImportUserEventsMetadata>
      importUserEventsOperationSettings() {
    return ((UserEventServiceStubSettings) getStubSettings()).importUserEventsOperationSettings();
  }

  public static final UserEventServiceSettings create(UserEventServiceStubSettings stub)
      throws IOException {
    return new UserEventServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return UserEventServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return UserEventServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return UserEventServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return UserEventServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return UserEventServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return UserEventServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return UserEventServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UserEventServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected UserEventServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for UserEventServiceSettings. */
  public static class Builder extends ClientSettings.Builder<UserEventServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(UserEventServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(UserEventServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(UserEventServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(UserEventServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(UserEventServiceStubSettings.newHttpJsonBuilder());
    }

    public UserEventServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((UserEventServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to writeUserEvent. */
    public UnaryCallSettings.Builder<WriteUserEventRequest, UserEvent> writeUserEventSettings() {
      return getStubSettingsBuilder().writeUserEventSettings();
    }

    /** Returns the builder for the settings used for calls to collectUserEvent. */
    public UnaryCallSettings.Builder<CollectUserEventRequest, HttpBody> collectUserEventSettings() {
      return getStubSettingsBuilder().collectUserEventSettings();
    }

    /** Returns the builder for the settings used for calls to importUserEvents. */
    public UnaryCallSettings.Builder<ImportUserEventsRequest, Operation>
        importUserEventsSettings() {
      return getStubSettingsBuilder().importUserEventsSettings();
    }

    /** Returns the builder for the settings used for calls to importUserEvents. */
    public OperationCallSettings.Builder<
            ImportUserEventsRequest, ImportUserEventsResponse, ImportUserEventsMetadata>
        importUserEventsOperationSettings() {
      return getStubSettingsBuilder().importUserEventsOperationSettings();
    }

    @Override
    public UserEventServiceSettings build() throws IOException {
      return new UserEventServiceSettings(this);
    }
  }
}
