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

package com.google.cloud.networkmanagement.v1;

import static com.google.cloud.networkmanagement.v1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.networkmanagement.v1.stub.ReachabilityServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReachabilityServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkmanagement.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnectivityTest to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReachabilityServiceSettings.Builder reachabilityServiceSettingsBuilder =
 *     ReachabilityServiceSettings.newBuilder();
 * reachabilityServiceSettingsBuilder
 *     .getConnectivityTestSettings()
 *     .setRetrySettings(
 *         reachabilityServiceSettingsBuilder
 *             .getConnectivityTestSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ReachabilityServiceSettings reachabilityServiceSettings =
 *     reachabilityServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ReachabilityServiceSettings extends ClientSettings<ReachabilityServiceSettings> {

  /** Returns the object with the settings used for calls to listConnectivityTests. */
  public PagedCallSettings<
          ListConnectivityTestsRequest,
          ListConnectivityTestsResponse,
          ListConnectivityTestsPagedResponse>
      listConnectivityTestsSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).listConnectivityTestsSettings();
  }

  /** Returns the object with the settings used for calls to getConnectivityTest. */
  public UnaryCallSettings<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).getConnectivityTestSettings();
  }

  /** Returns the object with the settings used for calls to createConnectivityTest. */
  public UnaryCallSettings<CreateConnectivityTestRequest, Operation>
      createConnectivityTestSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).createConnectivityTestSettings();
  }

  /** Returns the object with the settings used for calls to createConnectivityTest. */
  public OperationCallSettings<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings())
        .createConnectivityTestOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectivityTest. */
  public UnaryCallSettings<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).updateConnectivityTestSettings();
  }

  /** Returns the object with the settings used for calls to updateConnectivityTest. */
  public OperationCallSettings<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings())
        .updateConnectivityTestOperationSettings();
  }

  /** Returns the object with the settings used for calls to rerunConnectivityTest. */
  public UnaryCallSettings<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).rerunConnectivityTestSettings();
  }

  /** Returns the object with the settings used for calls to rerunConnectivityTest. */
  public OperationCallSettings<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings())
        .rerunConnectivityTestOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectivityTest. */
  public UnaryCallSettings<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings()).deleteConnectivityTestSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectivityTest. */
  public OperationCallSettings<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationSettings() {
    return ((ReachabilityServiceStubSettings) getStubSettings())
        .deleteConnectivityTestOperationSettings();
  }

  public static final ReachabilityServiceSettings create(ReachabilityServiceStubSettings stub)
      throws IOException {
    return new ReachabilityServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ReachabilityServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ReachabilityServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ReachabilityServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ReachabilityServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ReachabilityServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ReachabilityServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ReachabilityServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ReachabilityServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ReachabilityServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ReachabilityServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ReachabilityServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ReachabilityServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ReachabilityServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ReachabilityServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ReachabilityServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ReachabilityServiceStubSettings.newHttpJsonBuilder());
    }

    public ReachabilityServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ReachabilityServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConnectivityTests. */
    public PagedCallSettings.Builder<
            ListConnectivityTestsRequest,
            ListConnectivityTestsResponse,
            ListConnectivityTestsPagedResponse>
        listConnectivityTestsSettings() {
      return getStubSettingsBuilder().listConnectivityTestsSettings();
    }

    /** Returns the builder for the settings used for calls to getConnectivityTest. */
    public UnaryCallSettings.Builder<GetConnectivityTestRequest, ConnectivityTest>
        getConnectivityTestSettings() {
      return getStubSettingsBuilder().getConnectivityTestSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectivityTest. */
    public UnaryCallSettings.Builder<CreateConnectivityTestRequest, Operation>
        createConnectivityTestSettings() {
      return getStubSettingsBuilder().createConnectivityTestSettings();
    }

    /** Returns the builder for the settings used for calls to createConnectivityTest. */
    public OperationCallSettings.Builder<
            CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
        createConnectivityTestOperationSettings() {
      return getStubSettingsBuilder().createConnectivityTestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectivityTest. */
    public UnaryCallSettings.Builder<UpdateConnectivityTestRequest, Operation>
        updateConnectivityTestSettings() {
      return getStubSettingsBuilder().updateConnectivityTestSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnectivityTest. */
    public OperationCallSettings.Builder<
            UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
        updateConnectivityTestOperationSettings() {
      return getStubSettingsBuilder().updateConnectivityTestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rerunConnectivityTest. */
    public UnaryCallSettings.Builder<RerunConnectivityTestRequest, Operation>
        rerunConnectivityTestSettings() {
      return getStubSettingsBuilder().rerunConnectivityTestSettings();
    }

    /** Returns the builder for the settings used for calls to rerunConnectivityTest. */
    public OperationCallSettings.Builder<
            RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
        rerunConnectivityTestOperationSettings() {
      return getStubSettingsBuilder().rerunConnectivityTestOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectivityTest. */
    public UnaryCallSettings.Builder<DeleteConnectivityTestRequest, Operation>
        deleteConnectivityTestSettings() {
      return getStubSettingsBuilder().deleteConnectivityTestSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectivityTest. */
    public OperationCallSettings.Builder<DeleteConnectivityTestRequest, Empty, OperationMetadata>
        deleteConnectivityTestOperationSettings() {
      return getStubSettingsBuilder().deleteConnectivityTestOperationSettings();
    }

    @Override
    public ReachabilityServiceSettings build() throws IOException {
      return new ReachabilityServiceSettings(this);
    }
  }
}
