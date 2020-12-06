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

package com.google.cloud.bigqueryconnection.v1;

import static com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient.ListConnectionsPagedResponse;

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
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1.GetConnectionRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsResponse;
import com.google.cloud.bigquery.connection.v1.UpdateConnectionRequest;
import com.google.cloud.bigqueryconnection.v1.stub.ConnectionServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConnectionServiceClient}.
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
 * <pre>{@code
 * ConnectionServiceSettings.Builder connectionServiceSettingsBuilder =
 *     ConnectionServiceSettings.newBuilder();
 * connectionServiceSettingsBuilder
 *     .createConnectionSettings()
 *     .setRetrySettings(
 *         connectionServiceSettingsBuilder
 *             .createConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConnectionServiceSettings connectionServiceSettings = connectionServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConnectionServiceSettings extends ClientSettings<ConnectionServiceSettings> {

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).createConnectionSettings();
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).getConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).listConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).updateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).deleteConnectionSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ConnectionServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ConnectionServiceSettings create(ConnectionServiceStubSettings stub)
      throws IOException {
    return new ConnectionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConnectionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConnectionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConnectionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConnectionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConnectionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConnectionServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConnectionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConnectionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConnectionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ConnectionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConnectionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConnectionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConnectionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConnectionServiceStubSettings.newBuilder());
    }

    public ConnectionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ConnectionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings() {
      return getStubSettingsBuilder().createConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getStubSettingsBuilder().getConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return getStubSettingsBuilder().listConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings() {
      return getStubSettingsBuilder().updateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
      return getStubSettingsBuilder().deleteConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ConnectionServiceSettings build() throws IOException {
      return new ConnectionServiceSettings(this);
    }
  }
}
