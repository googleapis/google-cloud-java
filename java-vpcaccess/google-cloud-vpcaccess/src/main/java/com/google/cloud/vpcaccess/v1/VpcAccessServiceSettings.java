/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.vpcaccess.v1;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.vpcaccess.v1.stub.VpcAccessServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VpcAccessServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vpcaccess.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnector to 30 seconds:
 *
 * <pre>{@code
 * VpcAccessServiceSettings.Builder vpcAccessServiceSettingsBuilder =
 *     VpcAccessServiceSettings.newBuilder();
 * vpcAccessServiceSettingsBuilder
 *     .getConnectorSettings()
 *     .setRetrySettings(
 *         vpcAccessServiceSettingsBuilder
 *             .getConnectorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VpcAccessServiceSettings vpcAccessServiceSettings = vpcAccessServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VpcAccessServiceSettings extends ClientSettings<VpcAccessServiceSettings> {

  /** Returns the object with the settings used for calls to createConnector. */
  public UnaryCallSettings<CreateConnectorRequest, Operation> createConnectorSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).createConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createConnector. */
  public OperationCallSettings<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).createConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConnector. */
  public UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).getConnectorSettings();
  }

  /** Returns the object with the settings used for calls to listConnectors. */
  public PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).listConnectorsSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public UnaryCallSettings<DeleteConnectorRequest, Operation> deleteConnectorSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).deleteConnectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public OperationCallSettings<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationSettings() {
    return ((VpcAccessServiceStubSettings) getStubSettings()).deleteConnectorOperationSettings();
  }

  public static final VpcAccessServiceSettings create(VpcAccessServiceStubSettings stub)
      throws IOException {
    return new VpcAccessServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VpcAccessServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VpcAccessServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VpcAccessServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VpcAccessServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VpcAccessServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VpcAccessServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VpcAccessServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VpcAccessServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VpcAccessServiceSettings. */
  public static class Builder extends ClientSettings.Builder<VpcAccessServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VpcAccessServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VpcAccessServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VpcAccessServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VpcAccessServiceStubSettings.newBuilder());
    }

    public VpcAccessServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VpcAccessServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createConnector. */
    public UnaryCallSettings.Builder<CreateConnectorRequest, Operation> createConnectorSettings() {
      return getStubSettingsBuilder().createConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createConnector. */
    public OperationCallSettings.Builder<CreateConnectorRequest, Connector, OperationMetadata>
        createConnectorOperationSettings() {
      return getStubSettingsBuilder().createConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConnector. */
    public UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings() {
      return getStubSettingsBuilder().getConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to listConnectors. */
    public PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings() {
      return getStubSettingsBuilder().listConnectorsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    public UnaryCallSettings.Builder<DeleteConnectorRequest, Operation> deleteConnectorSettings() {
      return getStubSettingsBuilder().deleteConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    public OperationCallSettings.Builder<DeleteConnectorRequest, Empty, OperationMetadata>
        deleteConnectorOperationSettings() {
      return getStubSettingsBuilder().deleteConnectorOperationSettings();
    }

    @Override
    public VpcAccessServiceSettings build() throws IOException {
      return new VpcAccessServiceSettings(this);
    }
  }
}
