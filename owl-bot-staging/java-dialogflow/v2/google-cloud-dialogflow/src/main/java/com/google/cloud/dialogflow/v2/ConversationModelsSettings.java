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

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.stub.ConversationModelsStubSettings;
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
 * Settings class to configure an instance of {@link ConversationModelsClient}.
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
 * <p>For example, to set the total timeout of getConversationModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationModelsSettings.Builder conversationModelsSettingsBuilder =
 *     ConversationModelsSettings.newBuilder();
 * conversationModelsSettingsBuilder
 *     .getConversationModelSettings()
 *     .setRetrySettings(
 *         conversationModelsSettingsBuilder
 *             .getConversationModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationModelsSettings conversationModelsSettings =
 *     conversationModelsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConversationModelsSettings extends ClientSettings<ConversationModelsSettings> {

  /** Returns the object with the settings used for calls to createConversationModel. */
  public UnaryCallSettings<CreateConversationModelRequest, Operation>
      createConversationModelSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).createConversationModelSettings();
  }

  /** Returns the object with the settings used for calls to createConversationModel. */
  public OperationCallSettings<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .createConversationModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConversationModel. */
  public UnaryCallSettings<GetConversationModelRequest, ConversationModel>
      getConversationModelSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).getConversationModelSettings();
  }

  /** Returns the object with the settings used for calls to listConversationModels. */
  public PagedCallSettings<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ListConversationModelsPagedResponse>
      listConversationModelsSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).listConversationModelsSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversationModel. */
  public UnaryCallSettings<DeleteConversationModelRequest, Operation>
      deleteConversationModelSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).deleteConversationModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversationModel. */
  public OperationCallSettings<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .deleteConversationModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployConversationModel. */
  public UnaryCallSettings<DeployConversationModelRequest, Operation>
      deployConversationModelSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).deployConversationModelSettings();
  }

  /** Returns the object with the settings used for calls to deployConversationModel. */
  public OperationCallSettings<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .deployConversationModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployConversationModel. */
  public UnaryCallSettings<UndeployConversationModelRequest, Operation>
      undeployConversationModelSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).undeployConversationModelSettings();
  }

  /** Returns the object with the settings used for calls to undeployConversationModel. */
  public OperationCallSettings<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .undeployConversationModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConversationModelEvaluation. */
  public UnaryCallSettings<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .getConversationModelEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to listConversationModelEvaluations. */
  public PagedCallSettings<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .listConversationModelEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to createConversationModelEvaluation. */
  public UnaryCallSettings<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .createConversationModelEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to createConversationModelEvaluation. */
  public OperationCallSettings<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings())
        .createConversationModelEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConversationModelsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ConversationModelsSettings create(ConversationModelsStubSettings stub)
      throws IOException {
    return new ConversationModelsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConversationModelsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConversationModelsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConversationModelsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConversationModelsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationModelsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConversationModelsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationModelsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationModelsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConversationModelsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConversationModelsSettings. */
  public static class Builder extends ClientSettings.Builder<ConversationModelsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConversationModelsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConversationModelsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConversationModelsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConversationModelsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ConversationModelsStubSettings.newHttpJsonBuilder());
    }

    public ConversationModelsStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationModelsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createConversationModel. */
    public UnaryCallSettings.Builder<CreateConversationModelRequest, Operation>
        createConversationModelSettings() {
      return getStubSettingsBuilder().createConversationModelSettings();
    }

    /** Returns the builder for the settings used for calls to createConversationModel. */
    public OperationCallSettings.Builder<
            CreateConversationModelRequest,
            ConversationModel,
            CreateConversationModelOperationMetadata>
        createConversationModelOperationSettings() {
      return getStubSettingsBuilder().createConversationModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversationModel. */
    public UnaryCallSettings.Builder<GetConversationModelRequest, ConversationModel>
        getConversationModelSettings() {
      return getStubSettingsBuilder().getConversationModelSettings();
    }

    /** Returns the builder for the settings used for calls to listConversationModels. */
    public PagedCallSettings.Builder<
            ListConversationModelsRequest,
            ListConversationModelsResponse,
            ListConversationModelsPagedResponse>
        listConversationModelsSettings() {
      return getStubSettingsBuilder().listConversationModelsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversationModel. */
    public UnaryCallSettings.Builder<DeleteConversationModelRequest, Operation>
        deleteConversationModelSettings() {
      return getStubSettingsBuilder().deleteConversationModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversationModel. */
    public OperationCallSettings.Builder<
            DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
        deleteConversationModelOperationSettings() {
      return getStubSettingsBuilder().deleteConversationModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployConversationModel. */
    public UnaryCallSettings.Builder<DeployConversationModelRequest, Operation>
        deployConversationModelSettings() {
      return getStubSettingsBuilder().deployConversationModelSettings();
    }

    /** Returns the builder for the settings used for calls to deployConversationModel. */
    public OperationCallSettings.Builder<
            DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
        deployConversationModelOperationSettings() {
      return getStubSettingsBuilder().deployConversationModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployConversationModel. */
    public UnaryCallSettings.Builder<UndeployConversationModelRequest, Operation>
        undeployConversationModelSettings() {
      return getStubSettingsBuilder().undeployConversationModelSettings();
    }

    /** Returns the builder for the settings used for calls to undeployConversationModel. */
    public OperationCallSettings.Builder<
            UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
        undeployConversationModelOperationSettings() {
      return getStubSettingsBuilder().undeployConversationModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversationModelEvaluation. */
    public UnaryCallSettings.Builder<
            GetConversationModelEvaluationRequest, ConversationModelEvaluation>
        getConversationModelEvaluationSettings() {
      return getStubSettingsBuilder().getConversationModelEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to listConversationModelEvaluations. */
    public PagedCallSettings.Builder<
            ListConversationModelEvaluationsRequest,
            ListConversationModelEvaluationsResponse,
            ListConversationModelEvaluationsPagedResponse>
        listConversationModelEvaluationsSettings() {
      return getStubSettingsBuilder().listConversationModelEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to createConversationModelEvaluation. */
    public UnaryCallSettings.Builder<CreateConversationModelEvaluationRequest, Operation>
        createConversationModelEvaluationSettings() {
      return getStubSettingsBuilder().createConversationModelEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to createConversationModelEvaluation. */
    public OperationCallSettings.Builder<
            CreateConversationModelEvaluationRequest,
            ConversationModelEvaluation,
            CreateConversationModelEvaluationOperationMetadata>
        createConversationModelEvaluationOperationSettings() {
      return getStubSettingsBuilder().createConversationModelEvaluationOperationSettings();
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
    public ConversationModelsSettings build() throws IOException {
      return new ConversationModelsSettings(this);
    }
  }
}
