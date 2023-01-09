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

package com.google.cloud.retail.v2beta;

import static com.google.cloud.retail.v2beta.ModelServiceClient.ListModelsPagedResponse;

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
import com.google.cloud.retail.v2beta.stub.ModelServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of pauseModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelServiceSettings.Builder modelServiceSettingsBuilder = ModelServiceSettings.newBuilder();
 * modelServiceSettingsBuilder
 *     .pauseModelSettings()
 *     .setRetrySettings(
 *         modelServiceSettingsBuilder
 *             .pauseModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelServiceSettings modelServiceSettings = modelServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelServiceSettings extends ClientSettings<ModelServiceSettings> {

  /** Returns the object with the settings used for calls to createModel. */
  public UnaryCallSettings<CreateModelRequest, Operation> createModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).createModelSettings();
  }

  /** Returns the object with the settings used for calls to createModel. */
  public OperationCallSettings<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).createModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to pauseModel. */
  public UnaryCallSettings<PauseModelRequest, Model> pauseModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).pauseModelSettings();
  }

  /** Returns the object with the settings used for calls to resumeModel. */
  public UnaryCallSettings<ResumeModelRequest, Model> resumeModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).resumeModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Empty> deleteModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).deleteModelSettings();
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).listModelsSettings();
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).updateModelSettings();
  }

  /** Returns the object with the settings used for calls to tuneModel. */
  public UnaryCallSettings<TuneModelRequest, Operation> tuneModelSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).tuneModelSettings();
  }

  /** Returns the object with the settings used for calls to tuneModel. */
  public OperationCallSettings<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationSettings() {
    return ((ModelServiceStubSettings) getStubSettings()).tuneModelOperationSettings();
  }

  public static final ModelServiceSettings create(ModelServiceStubSettings stub)
      throws IOException {
    return new ModelServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ModelServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ModelServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ModelServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ModelServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ModelServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ModelServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ModelServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ModelServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ModelServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ModelServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ModelServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ModelServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ModelServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ModelServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ModelServiceStubSettings.newHttpJsonBuilder());
    }

    public ModelServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ModelServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createModel. */
    public UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings() {
      return getStubSettingsBuilder().createModelSettings();
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public OperationCallSettings.Builder<CreateModelRequest, Model, CreateModelMetadata>
        createModelOperationSettings() {
      return getStubSettingsBuilder().createModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to pauseModel. */
    public UnaryCallSettings.Builder<PauseModelRequest, Model> pauseModelSettings() {
      return getStubSettingsBuilder().pauseModelSettings();
    }

    /** Returns the builder for the settings used for calls to resumeModel. */
    public UnaryCallSettings.Builder<ResumeModelRequest, Model> resumeModelSettings() {
      return getStubSettingsBuilder().resumeModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Empty> deleteModelSettings() {
      return getStubSettingsBuilder().deleteModelSettings();
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return getStubSettingsBuilder().listModelsSettings();
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings() {
      return getStubSettingsBuilder().updateModelSettings();
    }

    /** Returns the builder for the settings used for calls to tuneModel. */
    public UnaryCallSettings.Builder<TuneModelRequest, Operation> tuneModelSettings() {
      return getStubSettingsBuilder().tuneModelSettings();
    }

    /** Returns the builder for the settings used for calls to tuneModel. */
    public OperationCallSettings.Builder<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
        tuneModelOperationSettings() {
      return getStubSettingsBuilder().tuneModelOperationSettings();
    }

    @Override
    public ModelServiceSettings build() throws IOException {
      return new ModelServiceSettings(this);
    }
  }
}
