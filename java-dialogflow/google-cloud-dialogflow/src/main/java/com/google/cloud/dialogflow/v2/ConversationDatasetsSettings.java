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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListConversationDatasetsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.stub.ConversationDatasetsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversationDatasetsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConversationDataset to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationDatasetsSettings.Builder conversationDatasetsSettingsBuilder =
 *     ConversationDatasetsSettings.newBuilder();
 * conversationDatasetsSettingsBuilder
 *     .getConversationDatasetSettings()
 *     .setRetrySettings(
 *         conversationDatasetsSettingsBuilder
 *             .getConversationDatasetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationDatasetsSettings conversationDatasetsSettings =
 *     conversationDatasetsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConversationDatasetsSettings extends ClientSettings<ConversationDatasetsSettings> {

  /** Returns the object with the settings used for calls to createConversationDataset. */
  public UnaryCallSettings<CreateConversationDatasetRequest, Operation>
      createConversationDatasetSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .createConversationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to createConversationDataset. */
  public OperationCallSettings<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .createConversationDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConversationDataset. */
  public UnaryCallSettings<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings()).getConversationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listConversationDatasets. */
  public PagedCallSettings<
          ListConversationDatasetsRequest,
          ListConversationDatasetsResponse,
          ListConversationDatasetsPagedResponse>
      listConversationDatasetsSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .listConversationDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversationDataset. */
  public UnaryCallSettings<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .deleteConversationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversationDataset. */
  public OperationCallSettings<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .deleteConversationDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to importConversationData. */
  public UnaryCallSettings<ImportConversationDataRequest, Operation>
      importConversationDataSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings()).importConversationDataSettings();
  }

  /** Returns the object with the settings used for calls to importConversationData. */
  public OperationCallSettings<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings())
        .importConversationDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConversationDatasetsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ConversationDatasetsSettings create(ConversationDatasetsStubSettings stub)
      throws IOException {
    return new ConversationDatasetsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConversationDatasetsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConversationDatasetsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConversationDatasetsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConversationDatasetsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationDatasetsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConversationDatasetsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationDatasetsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationDatasetsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConversationDatasetsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConversationDatasetsSettings. */
  public static class Builder
      extends ClientSettings.Builder<ConversationDatasetsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConversationDatasetsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConversationDatasetsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConversationDatasetsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConversationDatasetsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ConversationDatasetsStubSettings.newHttpJsonBuilder());
    }

    public ConversationDatasetsStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationDatasetsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createConversationDataset. */
    public UnaryCallSettings.Builder<CreateConversationDatasetRequest, Operation>
        createConversationDatasetSettings() {
      return getStubSettingsBuilder().createConversationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to createConversationDataset. */
    public OperationCallSettings.Builder<
            CreateConversationDatasetRequest,
            ConversationDataset,
            CreateConversationDatasetOperationMetadata>
        createConversationDatasetOperationSettings() {
      return getStubSettingsBuilder().createConversationDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversationDataset. */
    public UnaryCallSettings.Builder<GetConversationDatasetRequest, ConversationDataset>
        getConversationDatasetSettings() {
      return getStubSettingsBuilder().getConversationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listConversationDatasets. */
    public PagedCallSettings.Builder<
            ListConversationDatasetsRequest,
            ListConversationDatasetsResponse,
            ListConversationDatasetsPagedResponse>
        listConversationDatasetsSettings() {
      return getStubSettingsBuilder().listConversationDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversationDataset. */
    public UnaryCallSettings.Builder<DeleteConversationDatasetRequest, Operation>
        deleteConversationDatasetSettings() {
      return getStubSettingsBuilder().deleteConversationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversationDataset. */
    public OperationCallSettings.Builder<
            DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
        deleteConversationDatasetOperationSettings() {
      return getStubSettingsBuilder().deleteConversationDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importConversationData. */
    public UnaryCallSettings.Builder<ImportConversationDataRequest, Operation>
        importConversationDataSettings() {
      return getStubSettingsBuilder().importConversationDataSettings();
    }

    /** Returns the builder for the settings used for calls to importConversationData. */
    public OperationCallSettings.Builder<
            ImportConversationDataRequest,
            ImportConversationDataOperationResponse,
            ImportConversationDataOperationMetadata>
        importConversationDataOperationSettings() {
      return getStubSettingsBuilder().importConversationDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public ConversationDatasetsSettings build() throws IOException {
      return new ConversationDatasetsSettings(this);
    }
  }
}
