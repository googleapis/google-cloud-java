/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.connection.v1beta1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionCredentialRequest;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ConnectionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigqueryconnection.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createConnection to 30 seconds:
 *
 * <pre>
 * <code>
 * ConnectionServiceStubSettings.Builder connectionServiceSettingsBuilder =
 *     ConnectionServiceStubSettings.newBuilder();
 * connectionServiceSettingsBuilder
 *     .createConnectionSettings()
 *     .setRetrySettings(
 *         connectionServiceSettingsBuilder.createConnectionSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConnectionServiceStubSettings connectionServiceSettings = connectionServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ConnectionServiceStubSettings extends StubSettings<ConnectionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings;
  private final UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings;
  private final UnaryCallSettings<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsSettings;
  private final UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings;
  private final UnaryCallSettings<UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialSettings;
  private final UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings() {
    return createConnectionSettings;
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return getConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public UnaryCallSettings<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsSettings() {
    return listConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings() {
    return updateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectionCredential. */
  public UnaryCallSettings<UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialSettings() {
    return updateConnectionCredentialSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
    return deleteConnectionSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ConnectionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConnectionServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "bigqueryconnection.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ConnectionServiceStubSettings.class))
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

  protected ConnectionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConnectionSettings = settingsBuilder.createConnectionSettings().build();
    getConnectionSettings = settingsBuilder.getConnectionSettings().build();
    listConnectionsSettings = settingsBuilder.listConnectionsSettings().build();
    updateConnectionSettings = settingsBuilder.updateConnectionSettings().build();
    updateConnectionCredentialSettings =
        settingsBuilder.updateConnectionCredentialSettings().build();
    deleteConnectionSettings = settingsBuilder.deleteConnectionSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ConnectionServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ConnectionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings;
    private final UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings;
    private final UnaryCallSettings.Builder<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionCredentialRequest, Empty>
        updateConnectionCredentialSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionRequest, Empty>
        deleteConnectionSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listConnectionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateConnectionCredentialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              updateConnectionSettings,
              updateConnectionCredentialSettings,
              deleteConnectionSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .createConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateConnectionCredentialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ConnectionServiceStubSettings settings) {
      super(settings);

      createConnectionSettings = settings.createConnectionSettings.toBuilder();
      getConnectionSettings = settings.getConnectionSettings.toBuilder();
      listConnectionsSettings = settings.listConnectionsSettings.toBuilder();
      updateConnectionSettings = settings.updateConnectionSettings.toBuilder();
      updateConnectionCredentialSettings = settings.updateConnectionCredentialSettings.toBuilder();
      deleteConnectionSettings = settings.deleteConnectionSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConnectionSettings,
              getConnectionSettings,
              listConnectionsSettings,
              updateConnectionSettings,
              updateConnectionCredentialSettings,
              deleteConnectionSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings() {
      return createConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public UnaryCallSettings.Builder<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsSettings() {
      return listConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings() {
      return updateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectionCredential. */
    public UnaryCallSettings.Builder<UpdateConnectionCredentialRequest, Empty>
        updateConnectionCredentialSettings() {
      return updateConnectionCredentialSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
      return deleteConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ConnectionServiceStubSettings build() throws IOException {
      return new ConnectionServiceStubSettings(this);
    }
  }
}
