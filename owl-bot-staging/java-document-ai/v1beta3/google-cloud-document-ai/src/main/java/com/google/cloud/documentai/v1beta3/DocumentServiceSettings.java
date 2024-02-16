/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.documentai.v1beta3;

import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListDocumentsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.documentai.v1beta3.stub.DocumentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DocumentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (documentai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentServiceSettings.Builder documentServiceSettingsBuilder =
 *     DocumentServiceSettings.newBuilder();
 * documentServiceSettingsBuilder
 *     .getDocumentSettings()
 *     .setRetrySettings(
 *         documentServiceSettingsBuilder
 *             .getDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentServiceSettings documentServiceSettings = documentServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentServiceSettings extends ClientSettings<DocumentServiceSettings> {

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).updateDatasetSettings();
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public OperationCallSettings<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).updateDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).importDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public OperationCallSettings<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).importDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, GetDocumentResponse> getDocumentSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).getDocumentSettings();
  }

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).listDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteDocuments. */
  public UnaryCallSettings<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).batchDeleteDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteDocuments. */
  public OperationCallSettings<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationSettings() {
    return ((DocumentServiceStubSettings) getStubSettings())
        .batchDeleteDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDatasetSchema. */
  public UnaryCallSettings<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).getDatasetSchemaSettings();
  }

  /** Returns the object with the settings used for calls to updateDatasetSchema. */
  public UnaryCallSettings<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).updateDatasetSchemaSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DocumentServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DocumentServiceSettings create(DocumentServiceStubSettings stub)
      throws IOException {
    return new DocumentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DocumentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DocumentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DocumentServiceStubSettings.newHttpJsonBuilder());
    }

    public DocumentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings() {
      return getStubSettingsBuilder().updateDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public OperationCallSettings.Builder<
            UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
        updateDatasetOperationSettings() {
      return getStubSettingsBuilder().updateDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return getStubSettingsBuilder().importDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public OperationCallSettings.Builder<
            ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
        importDocumentsOperationSettings() {
      return getStubSettingsBuilder().importDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, GetDocumentResponse>
        getDocumentSettings() {
      return getStubSettingsBuilder().getDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to listDocuments. */
    public PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings() {
      return getStubSettingsBuilder().listDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteDocuments. */
    public UnaryCallSettings.Builder<BatchDeleteDocumentsRequest, Operation>
        batchDeleteDocumentsSettings() {
      return getStubSettingsBuilder().batchDeleteDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteDocuments. */
    public OperationCallSettings.Builder<
            BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
        batchDeleteDocumentsOperationSettings() {
      return getStubSettingsBuilder().batchDeleteDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDatasetSchema. */
    public UnaryCallSettings.Builder<GetDatasetSchemaRequest, DatasetSchema>
        getDatasetSchemaSettings() {
      return getStubSettingsBuilder().getDatasetSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatasetSchema. */
    public UnaryCallSettings.Builder<UpdateDatasetSchemaRequest, DatasetSchema>
        updateDatasetSchemaSettings() {
      return getStubSettingsBuilder().updateDatasetSchemaSettings();
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
    public DocumentServiceSettings build() throws IOException {
      return new DocumentServiceSettings(this);
    }
  }
}
