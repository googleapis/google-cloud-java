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

package com.google.cloud.metastore.v1;

import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

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
import com.google.cloud.metastore.v1.stub.DataprocMetastoreFederationStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataprocMetastoreFederationClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (metastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFederation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataprocMetastoreFederationSettings.Builder dataprocMetastoreFederationSettingsBuilder =
 *     DataprocMetastoreFederationSettings.newBuilder();
 * dataprocMetastoreFederationSettingsBuilder
 *     .getFederationSettings()
 *     .setRetrySettings(
 *         dataprocMetastoreFederationSettingsBuilder
 *             .getFederationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataprocMetastoreFederationSettings dataprocMetastoreFederationSettings =
 *     dataprocMetastoreFederationSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataprocMetastoreFederationSettings
    extends ClientSettings<DataprocMetastoreFederationSettings> {

  /** Returns the object with the settings used for calls to listFederations. */
  public PagedCallSettings<
          ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
      listFederationsSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings()).listFederationsSettings();
  }

  /** Returns the object with the settings used for calls to getFederation. */
  public UnaryCallSettings<GetFederationRequest, Federation> getFederationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings()).getFederationSettings();
  }

  /** Returns the object with the settings used for calls to createFederation. */
  public UnaryCallSettings<CreateFederationRequest, Operation> createFederationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings()).createFederationSettings();
  }

  /** Returns the object with the settings used for calls to createFederation. */
  public OperationCallSettings<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings())
        .createFederationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFederation. */
  public UnaryCallSettings<UpdateFederationRequest, Operation> updateFederationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings()).updateFederationSettings();
  }

  /** Returns the object with the settings used for calls to updateFederation. */
  public OperationCallSettings<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings())
        .updateFederationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFederation. */
  public UnaryCallSettings<DeleteFederationRequest, Operation> deleteFederationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings()).deleteFederationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFederation. */
  public OperationCallSettings<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationSettings() {
    return ((DataprocMetastoreFederationStubSettings) getStubSettings())
        .deleteFederationOperationSettings();
  }

  public static final DataprocMetastoreFederationSettings create(
      DataprocMetastoreFederationStubSettings stub) throws IOException {
    return new DataprocMetastoreFederationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataprocMetastoreFederationStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataprocMetastoreFederationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataprocMetastoreFederationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataprocMetastoreFederationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataprocMetastoreFederationSettings. */
  public static class Builder
      extends ClientSettings.Builder<DataprocMetastoreFederationSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataprocMetastoreFederationStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataprocMetastoreFederationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataprocMetastoreFederationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataprocMetastoreFederationStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataprocMetastoreFederationStubSettings.newHttpJsonBuilder());
    }

    public DataprocMetastoreFederationStubSettings.Builder getStubSettingsBuilder() {
      return ((DataprocMetastoreFederationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listFederations. */
    public PagedCallSettings.Builder<
            ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
        listFederationsSettings() {
      return getStubSettingsBuilder().listFederationsSettings();
    }

    /** Returns the builder for the settings used for calls to getFederation. */
    public UnaryCallSettings.Builder<GetFederationRequest, Federation> getFederationSettings() {
      return getStubSettingsBuilder().getFederationSettings();
    }

    /** Returns the builder for the settings used for calls to createFederation. */
    public UnaryCallSettings.Builder<CreateFederationRequest, Operation>
        createFederationSettings() {
      return getStubSettingsBuilder().createFederationSettings();
    }

    /** Returns the builder for the settings used for calls to createFederation. */
    public OperationCallSettings.Builder<CreateFederationRequest, Federation, OperationMetadata>
        createFederationOperationSettings() {
      return getStubSettingsBuilder().createFederationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFederation. */
    public UnaryCallSettings.Builder<UpdateFederationRequest, Operation>
        updateFederationSettings() {
      return getStubSettingsBuilder().updateFederationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFederation. */
    public OperationCallSettings.Builder<UpdateFederationRequest, Federation, OperationMetadata>
        updateFederationOperationSettings() {
      return getStubSettingsBuilder().updateFederationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFederation. */
    public UnaryCallSettings.Builder<DeleteFederationRequest, Operation>
        deleteFederationSettings() {
      return getStubSettingsBuilder().deleteFederationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFederation. */
    public OperationCallSettings.Builder<DeleteFederationRequest, Empty, OperationMetadata>
        deleteFederationOperationSettings() {
      return getStubSettingsBuilder().deleteFederationOperationSettings();
    }

    @Override
    public DataprocMetastoreFederationSettings build() throws IOException {
      return new DataprocMetastoreFederationSettings(this);
    }
  }
}
