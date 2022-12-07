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

package com.google.cloud.oslogin.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.stub.OsLoginServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OsLoginServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (oslogin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSshPublicKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OsLoginServiceSettings.Builder osLoginServiceSettingsBuilder =
 *     OsLoginServiceSettings.newBuilder();
 * osLoginServiceSettingsBuilder
 *     .createSshPublicKeySettings()
 *     .setRetrySettings(
 *         osLoginServiceSettingsBuilder
 *             .createSshPublicKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsLoginServiceSettings osLoginServiceSettings = osLoginServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OsLoginServiceSettings extends ClientSettings<OsLoginServiceSettings> {

  /** Returns the object with the settings used for calls to createSshPublicKey. */
  public UnaryCallSettings<CreateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      createSshPublicKeySettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).createSshPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to deletePosixAccount. */
  public UnaryCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountSettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).deletePosixAccountSettings();
  }

  /** Returns the object with the settings used for calls to deleteSshPublicKey. */
  public UnaryCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeySettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).deleteSshPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to getLoginProfile. */
  public UnaryCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileSettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).getLoginProfileSettings();
  }

  /** Returns the object with the settings used for calls to getSshPublicKey. */
  public UnaryCallSettings<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeySettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).getSshPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to importSshPublicKey. */
  public UnaryCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeySettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).importSshPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to updateSshPublicKey. */
  public UnaryCallSettings<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeySettings() {
    return ((OsLoginServiceStubSettings) getStubSettings()).updateSshPublicKeySettings();
  }

  public static final OsLoginServiceSettings create(OsLoginServiceStubSettings stub)
      throws IOException {
    return new OsLoginServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OsLoginServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OsLoginServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OsLoginServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OsLoginServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OsLoginServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OsLoginServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OsLoginServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OsLoginServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OsLoginServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OsLoginServiceSettings. */
  public static class Builder extends ClientSettings.Builder<OsLoginServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OsLoginServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OsLoginServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OsLoginServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OsLoginServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(OsLoginServiceStubSettings.newHttpJsonBuilder());
    }

    public OsLoginServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OsLoginServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSshPublicKey. */
    public UnaryCallSettings.Builder<CreateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        createSshPublicKeySettings() {
      return getStubSettingsBuilder().createSshPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to deletePosixAccount. */
    public UnaryCallSettings.Builder<DeletePosixAccountRequest, Empty>
        deletePosixAccountSettings() {
      return getStubSettingsBuilder().deletePosixAccountSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSshPublicKey. */
    public UnaryCallSettings.Builder<DeleteSshPublicKeyRequest, Empty>
        deleteSshPublicKeySettings() {
      return getStubSettingsBuilder().deleteSshPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to getLoginProfile. */
    public UnaryCallSettings.Builder<GetLoginProfileRequest, LoginProfile>
        getLoginProfileSettings() {
      return getStubSettingsBuilder().getLoginProfileSettings();
    }

    /** Returns the builder for the settings used for calls to getSshPublicKey. */
    public UnaryCallSettings.Builder<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        getSshPublicKeySettings() {
      return getStubSettingsBuilder().getSshPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to importSshPublicKey. */
    public UnaryCallSettings.Builder<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeySettings() {
      return getStubSettingsBuilder().importSshPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateSshPublicKey. */
    public UnaryCallSettings.Builder<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        updateSshPublicKeySettings() {
      return getStubSettingsBuilder().updateSshPublicKeySettings();
    }

    @Override
    public OsLoginServiceSettings build() throws IOException {
      return new OsLoginServiceSettings(this);
    }
  }
}
