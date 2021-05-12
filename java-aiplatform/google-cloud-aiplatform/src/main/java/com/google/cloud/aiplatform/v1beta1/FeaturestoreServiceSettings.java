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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListEntityTypesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListFeaturestoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.SearchFeaturesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.FeaturestoreServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FeaturestoreServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFeaturestore to 30 seconds:
 *
 * <pre>{@code
 * FeaturestoreServiceSettings.Builder featurestoreServiceSettingsBuilder =
 *     FeaturestoreServiceSettings.newBuilder();
 * featurestoreServiceSettingsBuilder
 *     .getFeaturestoreSettings()
 *     .setRetrySettings(
 *         featurestoreServiceSettingsBuilder
 *             .getFeaturestoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FeaturestoreServiceSettings featurestoreServiceSettings =
 *     featurestoreServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeaturestoreServiceSettings extends ClientSettings<FeaturestoreServiceSettings> {

  /** Returns the object with the settings used for calls to createFeaturestore. */
  public UnaryCallSettings<CreateFeaturestoreRequest, Operation> createFeaturestoreSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).createFeaturestoreSettings();
  }

  /** Returns the object with the settings used for calls to createFeaturestore. */
  public OperationCallSettings<
          CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
      createFeaturestoreOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .createFeaturestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeaturestore. */
  public UnaryCallSettings<GetFeaturestoreRequest, Featurestore> getFeaturestoreSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).getFeaturestoreSettings();
  }

  /** Returns the object with the settings used for calls to listFeaturestores. */
  public PagedCallSettings<
          ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
      listFeaturestoresSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).listFeaturestoresSettings();
  }

  /** Returns the object with the settings used for calls to updateFeaturestore. */
  public UnaryCallSettings<UpdateFeaturestoreRequest, Operation> updateFeaturestoreSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).updateFeaturestoreSettings();
  }

  /** Returns the object with the settings used for calls to updateFeaturestore. */
  public OperationCallSettings<
          UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
      updateFeaturestoreOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .updateFeaturestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeaturestore. */
  public UnaryCallSettings<DeleteFeaturestoreRequest, Operation> deleteFeaturestoreSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).deleteFeaturestoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeaturestore. */
  public OperationCallSettings<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
      deleteFeaturestoreOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .deleteFeaturestoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public UnaryCallSettings<CreateEntityTypeRequest, Operation> createEntityTypeSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).createEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public OperationCallSettings<
          CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
      createEntityTypeOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .createEntityTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to getEntityType. */
  public UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).getEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to listEntityTypes. */
  public PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).listEntityTypesSettings();
  }

  /** Returns the object with the settings used for calls to updateEntityType. */
  public UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).updateEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public UnaryCallSettings<DeleteEntityTypeRequest, Operation> deleteEntityTypeSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).deleteEntityTypeSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public OperationCallSettings<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
      deleteEntityTypeOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .deleteEntityTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).createFeatureSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).createFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public UnaryCallSettings<BatchCreateFeaturesRequest, Operation> batchCreateFeaturesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).batchCreateFeaturesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public OperationCallSettings<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .batchCreateFeaturesOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).getFeatureSettings();
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).listFeaturesSettings();
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Feature> updateFeatureSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).updateFeatureSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).deleteFeatureSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).deleteFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to importFeatureValues. */
  public UnaryCallSettings<ImportFeatureValuesRequest, Operation> importFeatureValuesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).importFeatureValuesSettings();
  }

  /** Returns the object with the settings used for calls to importFeatureValues. */
  public OperationCallSettings<
          ImportFeatureValuesRequest,
          ImportFeatureValuesResponse,
          ImportFeatureValuesOperationMetadata>
      importFeatureValuesOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .importFeatureValuesOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchReadFeatureValues. */
  public UnaryCallSettings<BatchReadFeatureValuesRequest, Operation>
      batchReadFeatureValuesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).batchReadFeatureValuesSettings();
  }

  /** Returns the object with the settings used for calls to batchReadFeatureValues. */
  public OperationCallSettings<
          BatchReadFeatureValuesRequest,
          BatchReadFeatureValuesResponse,
          BatchReadFeatureValuesOperationMetadata>
      batchReadFeatureValuesOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .batchReadFeatureValuesOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportFeatureValues. */
  public UnaryCallSettings<ExportFeatureValuesRequest, Operation> exportFeatureValuesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).exportFeatureValuesSettings();
  }

  /** Returns the object with the settings used for calls to exportFeatureValues. */
  public OperationCallSettings<
          ExportFeatureValuesRequest,
          ExportFeatureValuesResponse,
          ExportFeatureValuesOperationMetadata>
      exportFeatureValuesOperationSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings())
        .exportFeatureValuesOperationSettings();
  }

  /** Returns the object with the settings used for calls to searchFeatures. */
  public PagedCallSettings<
          SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
      searchFeaturesSettings() {
    return ((FeaturestoreServiceStubSettings) getStubSettings()).searchFeaturesSettings();
  }

  public static final FeaturestoreServiceSettings create(FeaturestoreServiceStubSettings stub)
      throws IOException {
    return new FeaturestoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FeaturestoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FeaturestoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FeaturestoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FeaturestoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FeaturestoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FeaturestoreServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeaturestoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FeaturestoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FeaturestoreServiceSettings. */
  public static class Builder extends ClientSettings.Builder<FeaturestoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FeaturestoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FeaturestoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FeaturestoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FeaturestoreServiceStubSettings.newBuilder());
    }

    public FeaturestoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FeaturestoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFeaturestore. */
    public UnaryCallSettings.Builder<CreateFeaturestoreRequest, Operation>
        createFeaturestoreSettings() {
      return getStubSettingsBuilder().createFeaturestoreSettings();
    }

    /** Returns the builder for the settings used for calls to createFeaturestore. */
    public OperationCallSettings.Builder<
            CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
        createFeaturestoreOperationSettings() {
      return getStubSettingsBuilder().createFeaturestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeaturestore. */
    public UnaryCallSettings.Builder<GetFeaturestoreRequest, Featurestore>
        getFeaturestoreSettings() {
      return getStubSettingsBuilder().getFeaturestoreSettings();
    }

    /** Returns the builder for the settings used for calls to listFeaturestores. */
    public PagedCallSettings.Builder<
            ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
        listFeaturestoresSettings() {
      return getStubSettingsBuilder().listFeaturestoresSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeaturestore. */
    public UnaryCallSettings.Builder<UpdateFeaturestoreRequest, Operation>
        updateFeaturestoreSettings() {
      return getStubSettingsBuilder().updateFeaturestoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeaturestore. */
    public OperationCallSettings.Builder<
            UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
        updateFeaturestoreOperationSettings() {
      return getStubSettingsBuilder().updateFeaturestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeaturestore. */
    public UnaryCallSettings.Builder<DeleteFeaturestoreRequest, Operation>
        deleteFeaturestoreSettings() {
      return getStubSettingsBuilder().deleteFeaturestoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeaturestore. */
    public OperationCallSettings.Builder<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
        deleteFeaturestoreOperationSettings() {
      return getStubSettingsBuilder().deleteFeaturestoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public UnaryCallSettings.Builder<CreateEntityTypeRequest, Operation>
        createEntityTypeSettings() {
      return getStubSettingsBuilder().createEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public OperationCallSettings.Builder<
            CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
        createEntityTypeOperationSettings() {
      return getStubSettingsBuilder().createEntityTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getEntityType. */
    public UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
      return getStubSettingsBuilder().getEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to listEntityTypes. */
    public PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings() {
      return getStubSettingsBuilder().listEntityTypesSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntityType. */
    public UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings() {
      return getStubSettingsBuilder().updateEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public UnaryCallSettings.Builder<DeleteEntityTypeRequest, Operation>
        deleteEntityTypeSettings() {
      return getStubSettingsBuilder().deleteEntityTypeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public OperationCallSettings.Builder<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
        deleteEntityTypeOperationSettings() {
      return getStubSettingsBuilder().deleteEntityTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return getStubSettingsBuilder().createFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings() {
      return getStubSettingsBuilder().createFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    public UnaryCallSettings.Builder<BatchCreateFeaturesRequest, Operation>
        batchCreateFeaturesSettings() {
      return getStubSettingsBuilder().batchCreateFeaturesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    public OperationCallSettings.Builder<
            BatchCreateFeaturesRequest,
            BatchCreateFeaturesResponse,
            BatchCreateFeaturesOperationMetadata>
        batchCreateFeaturesOperationSettings() {
      return getStubSettingsBuilder().batchCreateFeaturesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getStubSettingsBuilder().getFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return getStubSettingsBuilder().listFeaturesSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Feature> updateFeatureSettings() {
      return getStubSettingsBuilder().updateFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return getStubSettingsBuilder().deleteFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importFeatureValues. */
    public UnaryCallSettings.Builder<ImportFeatureValuesRequest, Operation>
        importFeatureValuesSettings() {
      return getStubSettingsBuilder().importFeatureValuesSettings();
    }

    /** Returns the builder for the settings used for calls to importFeatureValues. */
    public OperationCallSettings.Builder<
            ImportFeatureValuesRequest,
            ImportFeatureValuesResponse,
            ImportFeatureValuesOperationMetadata>
        importFeatureValuesOperationSettings() {
      return getStubSettingsBuilder().importFeatureValuesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchReadFeatureValues. */
    public UnaryCallSettings.Builder<BatchReadFeatureValuesRequest, Operation>
        batchReadFeatureValuesSettings() {
      return getStubSettingsBuilder().batchReadFeatureValuesSettings();
    }

    /** Returns the builder for the settings used for calls to batchReadFeatureValues. */
    public OperationCallSettings.Builder<
            BatchReadFeatureValuesRequest,
            BatchReadFeatureValuesResponse,
            BatchReadFeatureValuesOperationMetadata>
        batchReadFeatureValuesOperationSettings() {
      return getStubSettingsBuilder().batchReadFeatureValuesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportFeatureValues. */
    public UnaryCallSettings.Builder<ExportFeatureValuesRequest, Operation>
        exportFeatureValuesSettings() {
      return getStubSettingsBuilder().exportFeatureValuesSettings();
    }

    /** Returns the builder for the settings used for calls to exportFeatureValues. */
    public OperationCallSettings.Builder<
            ExportFeatureValuesRequest,
            ExportFeatureValuesResponse,
            ExportFeatureValuesOperationMetadata>
        exportFeatureValuesOperationSettings() {
      return getStubSettingsBuilder().exportFeatureValuesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to searchFeatures. */
    public PagedCallSettings.Builder<
            SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
        searchFeaturesSettings() {
      return getStubSettingsBuilder().searchFeaturesSettings();
    }

    @Override
    public FeaturestoreServiceSettings build() throws IOException {
      return new FeaturestoreServiceSettings(this);
    }
  }
}
