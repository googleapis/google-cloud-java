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

package com.google.cloud.shell.v1;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.shell.v1.stub.CloudShellServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudShellServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudshell.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEnvironment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudShellServiceSettings.Builder cloudShellServiceSettingsBuilder =
 *     CloudShellServiceSettings.newBuilder();
 * cloudShellServiceSettingsBuilder
 *     .getEnvironmentSettings()
 *     .setRetrySettings(
 *         cloudShellServiceSettingsBuilder
 *             .getEnvironmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudShellServiceSettings cloudShellServiceSettings = cloudShellServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudShellServiceSettings extends ClientSettings<CloudShellServiceSettings> {

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).getEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to startEnvironment. */
  public UnaryCallSettings<StartEnvironmentRequest, Operation> startEnvironmentSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).startEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to startEnvironment. */
  public OperationCallSettings<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).startEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to authorizeEnvironment. */
  public UnaryCallSettings<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).authorizeEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to authorizeEnvironment. */
  public OperationCallSettings<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings())
        .authorizeEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to addPublicKey. */
  public UnaryCallSettings<AddPublicKeyRequest, Operation> addPublicKeySettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).addPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to addPublicKey. */
  public OperationCallSettings<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).addPublicKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to removePublicKey. */
  public UnaryCallSettings<RemovePublicKeyRequest, Operation> removePublicKeySettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).removePublicKeySettings();
  }

  /** Returns the object with the settings used for calls to removePublicKey. */
  public OperationCallSettings<
          RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationSettings() {
    return ((CloudShellServiceStubSettings) getStubSettings()).removePublicKeyOperationSettings();
  }

  public static final CloudShellServiceSettings create(CloudShellServiceStubSettings stub)
      throws IOException {
    return new CloudShellServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudShellServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudShellServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudShellServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudShellServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudShellServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudShellServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudShellServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudShellServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudShellServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudShellServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CloudShellServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudShellServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudShellServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudShellServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudShellServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudShellServiceStubSettings.newHttpJsonBuilder());
    }

    public CloudShellServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudShellServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getStubSettingsBuilder().getEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to startEnvironment. */
    public UnaryCallSettings.Builder<StartEnvironmentRequest, Operation>
        startEnvironmentSettings() {
      return getStubSettingsBuilder().startEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to startEnvironment. */
    public OperationCallSettings.Builder<
            StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
        startEnvironmentOperationSettings() {
      return getStubSettingsBuilder().startEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to authorizeEnvironment. */
    public UnaryCallSettings.Builder<AuthorizeEnvironmentRequest, Operation>
        authorizeEnvironmentSettings() {
      return getStubSettingsBuilder().authorizeEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to authorizeEnvironment. */
    public OperationCallSettings.Builder<
            AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
        authorizeEnvironmentOperationSettings() {
      return getStubSettingsBuilder().authorizeEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addPublicKey. */
    public UnaryCallSettings.Builder<AddPublicKeyRequest, Operation> addPublicKeySettings() {
      return getStubSettingsBuilder().addPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to addPublicKey. */
    public OperationCallSettings.Builder<
            AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
        addPublicKeyOperationSettings() {
      return getStubSettingsBuilder().addPublicKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removePublicKey. */
    public UnaryCallSettings.Builder<RemovePublicKeyRequest, Operation> removePublicKeySettings() {
      return getStubSettingsBuilder().removePublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to removePublicKey. */
    public OperationCallSettings.Builder<
            RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
        removePublicKeyOperationSettings() {
      return getStubSettingsBuilder().removePublicKeyOperationSettings();
    }

    @Override
    public CloudShellServiceSettings build() throws IOException {
      return new CloudShellServiceSettings(this);
    }
  }
}
