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

package com.google.cloud.oslogin.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.DeletePosixAccountRequest;
import com.google.cloud.oslogin.v1.DeleteSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.GetLoginProfileRequest;
import com.google.cloud.oslogin.v1.GetSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyRequest;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyResponse;
import com.google.cloud.oslogin.v1.LoginProfile;
import com.google.cloud.oslogin.v1.UpdateSshPublicKeyRequest;
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
 * Settings class to configure an instance of {@link OsLoginServiceStub}.
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
 * <p>For example, to set the total timeout of deletePosixAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OsLoginServiceStubSettings.Builder osLoginServiceSettingsBuilder =
 *     OsLoginServiceStubSettings.newBuilder();
 * osLoginServiceSettingsBuilder
 *     .deletePosixAccountSettings()
 *     .setRetrySettings(
 *         osLoginServiceSettingsBuilder
 *             .deletePosixAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsLoginServiceStubSettings osLoginServiceSettings = osLoginServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OsLoginServiceStubSettings extends StubSettings<OsLoginServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .build();

  private final UnaryCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountSettings;
  private final UnaryCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeySettings;
  private final UnaryCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileSettings;
  private final UnaryCallSettings<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeySettings;
  private final UnaryCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeySettings;
  private final UnaryCallSettings<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeySettings;

  /** Returns the object with the settings used for calls to deletePosixAccount. */
  public UnaryCallSettings<DeletePosixAccountRequest, Empty> deletePosixAccountSettings() {
    return deletePosixAccountSettings;
  }

  /** Returns the object with the settings used for calls to deleteSshPublicKey. */
  public UnaryCallSettings<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeySettings() {
    return deleteSshPublicKeySettings;
  }

  /** Returns the object with the settings used for calls to getLoginProfile. */
  public UnaryCallSettings<GetLoginProfileRequest, LoginProfile> getLoginProfileSettings() {
    return getLoginProfileSettings;
  }

  /** Returns the object with the settings used for calls to getSshPublicKey. */
  public UnaryCallSettings<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeySettings() {
    return getSshPublicKeySettings;
  }

  /** Returns the object with the settings used for calls to importSshPublicKey. */
  public UnaryCallSettings<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeySettings() {
    return importSshPublicKeySettings;
  }

  /** Returns the object with the settings used for calls to updateSshPublicKey. */
  public UnaryCallSettings<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeySettings() {
    return updateSshPublicKeySettings;
  }

  public OsLoginServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOsLoginServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOsLoginServiceStub.create(this);
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
    return "oslogin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "oslogin.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OsLoginServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OsLoginServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OsLoginServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected OsLoginServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deletePosixAccountSettings = settingsBuilder.deletePosixAccountSettings().build();
    deleteSshPublicKeySettings = settingsBuilder.deleteSshPublicKeySettings().build();
    getLoginProfileSettings = settingsBuilder.getLoginProfileSettings().build();
    getSshPublicKeySettings = settingsBuilder.getSshPublicKeySettings().build();
    importSshPublicKeySettings = settingsBuilder.importSshPublicKeySettings().build();
    updateSshPublicKeySettings = settingsBuilder.updateSshPublicKeySettings().build();
  }

  /** Builder for OsLoginServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<OsLoginServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<DeletePosixAccountRequest, Empty>
        deletePosixAccountSettings;
    private final UnaryCallSettings.Builder<DeleteSshPublicKeyRequest, Empty>
        deleteSshPublicKeySettings;
    private final UnaryCallSettings.Builder<GetLoginProfileRequest, LoginProfile>
        getLoginProfileSettings;
    private final UnaryCallSettings.Builder<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        getSshPublicKeySettings;
    private final UnaryCallSettings.Builder<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeySettings;
    private final UnaryCallSettings.Builder<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        updateSshPublicKeySettings;
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
              .setInitialRpcTimeout(Duration.ofMillis(10000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(10000L))
              .setTotalTimeout(Duration.ofMillis(10000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deletePosixAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSshPublicKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getLoginProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSshPublicKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importSshPublicKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSshPublicKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deletePosixAccountSettings,
              deleteSshPublicKeySettings,
              getLoginProfileSettings,
              getSshPublicKeySettings,
              importSshPublicKeySettings,
              updateSshPublicKeySettings);
      initDefaults(this);
    }

    protected Builder(OsLoginServiceStubSettings settings) {
      super(settings);

      deletePosixAccountSettings = settings.deletePosixAccountSettings.toBuilder();
      deleteSshPublicKeySettings = settings.deleteSshPublicKeySettings.toBuilder();
      getLoginProfileSettings = settings.getLoginProfileSettings.toBuilder();
      getSshPublicKeySettings = settings.getSshPublicKeySettings.toBuilder();
      importSshPublicKeySettings = settings.importSshPublicKeySettings.toBuilder();
      updateSshPublicKeySettings = settings.updateSshPublicKeySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deletePosixAccountSettings,
              deleteSshPublicKeySettings,
              getLoginProfileSettings,
              getSshPublicKeySettings,
              importSshPublicKeySettings,
              updateSshPublicKeySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .deletePosixAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSshPublicKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLoginProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSshPublicKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importSshPublicKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSshPublicKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to deletePosixAccount. */
    public UnaryCallSettings.Builder<DeletePosixAccountRequest, Empty>
        deletePosixAccountSettings() {
      return deletePosixAccountSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSshPublicKey. */
    public UnaryCallSettings.Builder<DeleteSshPublicKeyRequest, Empty>
        deleteSshPublicKeySettings() {
      return deleteSshPublicKeySettings;
    }

    /** Returns the builder for the settings used for calls to getLoginProfile. */
    public UnaryCallSettings.Builder<GetLoginProfileRequest, LoginProfile>
        getLoginProfileSettings() {
      return getLoginProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getSshPublicKey. */
    public UnaryCallSettings.Builder<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        getSshPublicKeySettings() {
      return getSshPublicKeySettings;
    }

    /** Returns the builder for the settings used for calls to importSshPublicKey. */
    public UnaryCallSettings.Builder<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
        importSshPublicKeySettings() {
      return importSshPublicKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateSshPublicKey. */
    public UnaryCallSettings.Builder<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
        updateSshPublicKeySettings() {
      return updateSshPublicKeySettings;
    }

    @Override
    public OsLoginServiceStubSettings build() throws IOException {
      return new OsLoginServiceStubSettings(this);
    }
  }
}
