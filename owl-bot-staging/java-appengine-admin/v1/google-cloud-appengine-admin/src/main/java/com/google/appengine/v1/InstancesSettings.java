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

package com.google.appengine.v1;

import static com.google.appengine.v1.InstancesClient.ListInstancesPagedResponse;

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
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.appengine.v1.stub.InstancesStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstancesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstancesSettings.Builder instancesSettingsBuilder = InstancesSettings.newBuilder();
 * instancesSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         instancesSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstancesSettings instancesSettings = instancesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstancesSettings extends ClientSettings<InstancesSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((InstancesStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((InstancesStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadataV1>
      deleteInstanceOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to debugInstance. */
  public UnaryCallSettings<DebugInstanceRequest, Operation> debugInstanceSettings() {
    return ((InstancesStubSettings) getStubSettings()).debugInstanceSettings();
  }

  /** Returns the object with the settings used for calls to debugInstance. */
  public OperationCallSettings<DebugInstanceRequest, Instance, OperationMetadataV1>
      debugInstanceOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).debugInstanceOperationSettings();
  }

  public static final InstancesSettings create(InstancesStubSettings stub) throws IOException {
    return new InstancesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstancesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstancesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstancesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstancesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstancesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstancesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstancesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstancesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstancesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstancesSettings. */
  public static class Builder extends ClientSettings.Builder<InstancesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InstancesStubSettings.newBuilder(clientContext));
    }

    protected Builder(InstancesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstancesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InstancesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(InstancesStubSettings.newHttpJsonBuilder());
    }

    public InstancesStubSettings.Builder getStubSettingsBuilder() {
      return ((InstancesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadataV1>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to debugInstance. */
    public UnaryCallSettings.Builder<DebugInstanceRequest, Operation> debugInstanceSettings() {
      return getStubSettingsBuilder().debugInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to debugInstance. */
    public OperationCallSettings.Builder<DebugInstanceRequest, Instance, OperationMetadataV1>
        debugInstanceOperationSettings() {
      return getStubSettingsBuilder().debugInstanceOperationSettings();
    }

    @Override
    public InstancesSettings build() throws IOException {
      return new InstancesSettings(this);
    }
  }
}
