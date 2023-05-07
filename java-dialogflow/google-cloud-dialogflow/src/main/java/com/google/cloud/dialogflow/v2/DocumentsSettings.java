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

import static com.google.cloud.dialogflow.v2.DocumentsClient.ListDocumentsPagedResponse;
import static com.google.cloud.dialogflow.v2.DocumentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.stub.DocumentsStubSettings;
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
 * Settings class to configure an instance of {@link DocumentsClient}.
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
 * <p>For example, to set the total timeout of getDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentsSettings.Builder documentsSettingsBuilder = DocumentsSettings.newBuilder();
 * documentsSettingsBuilder
 *     .getDocumentSettings()
 *     .setRetrySettings(
 *         documentsSettingsBuilder
 *             .getDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentsSettings documentsSettings = documentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentsSettings extends ClientSettings<DocumentsSettings> {

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return ((DocumentsStubSettings) getStubSettings()).listDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).getDocumentSettings();
  }

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, Operation> createDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).createDocumentSettings();
  }

  /** Returns the object with the settings used for calls to createDocument. */
  public OperationCallSettings<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).createDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return ((DocumentsStubSettings) getStubSettings()).importDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public OperationCallSettings<
          ImportDocumentsRequest, ImportDocumentsResponse, KnowledgeOperationMetadata>
      importDocumentsOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).importDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDocument. */
  public UnaryCallSettings<DeleteDocumentRequest, Operation> deleteDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).deleteDocumentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDocument. */
  public OperationCallSettings<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).deleteDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDocument. */
  public UnaryCallSettings<UpdateDocumentRequest, Operation> updateDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).updateDocumentSettings();
  }

  /** Returns the object with the settings used for calls to updateDocument. */
  public OperationCallSettings<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).updateDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to reloadDocument. */
  public UnaryCallSettings<ReloadDocumentRequest, Operation> reloadDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).reloadDocumentSettings();
  }

  /** Returns the object with the settings used for calls to reloadDocument. */
  public OperationCallSettings<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).reloadDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportDocument. */
  public UnaryCallSettings<ExportDocumentRequest, Operation> exportDocumentSettings() {
    return ((DocumentsStubSettings) getStubSettings()).exportDocumentSettings();
  }

  /** Returns the object with the settings used for calls to exportDocument. */
  public OperationCallSettings<ExportDocumentRequest, Document, KnowledgeOperationMetadata>
      exportDocumentOperationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).exportDocumentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DocumentsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DocumentsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final DocumentsSettings create(DocumentsStubSettings stub) throws IOException {
    return new DocumentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DocumentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentsSettings. */
  public static class Builder extends ClientSettings.Builder<DocumentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DocumentsStubSettings.newHttpJsonBuilder());
    }

    public DocumentsStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDocuments. */
    public PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings() {
      return getStubSettingsBuilder().listDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings() {
      return getStubSettingsBuilder().getDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, Operation> createDocumentSettings() {
      return getStubSettingsBuilder().createDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to createDocument. */
    public OperationCallSettings.Builder<
            CreateDocumentRequest, Document, KnowledgeOperationMetadata>
        createDocumentOperationSettings() {
      return getStubSettingsBuilder().createDocumentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return getStubSettingsBuilder().importDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public OperationCallSettings.Builder<
            ImportDocumentsRequest, ImportDocumentsResponse, KnowledgeOperationMetadata>
        importDocumentsOperationSettings() {
      return getStubSettingsBuilder().importDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDocument. */
    public UnaryCallSettings.Builder<DeleteDocumentRequest, Operation> deleteDocumentSettings() {
      return getStubSettingsBuilder().deleteDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDocument. */
    public OperationCallSettings.Builder<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
        deleteDocumentOperationSettings() {
      return getStubSettingsBuilder().deleteDocumentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDocument. */
    public UnaryCallSettings.Builder<UpdateDocumentRequest, Operation> updateDocumentSettings() {
      return getStubSettingsBuilder().updateDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to updateDocument. */
    public OperationCallSettings.Builder<
            UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
        updateDocumentOperationSettings() {
      return getStubSettingsBuilder().updateDocumentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reloadDocument. */
    public UnaryCallSettings.Builder<ReloadDocumentRequest, Operation> reloadDocumentSettings() {
      return getStubSettingsBuilder().reloadDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to reloadDocument. */
    public OperationCallSettings.Builder<
            ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
        reloadDocumentOperationSettings() {
      return getStubSettingsBuilder().reloadDocumentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportDocument. */
    public UnaryCallSettings.Builder<ExportDocumentRequest, Operation> exportDocumentSettings() {
      return getStubSettingsBuilder().exportDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to exportDocument. */
    public OperationCallSettings.Builder<
            ExportDocumentRequest, Document, KnowledgeOperationMetadata>
        exportDocumentOperationSettings() {
      return getStubSettingsBuilder().exportDocumentOperationSettings();
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
    public DocumentsSettings build() throws IOException {
      return new DocumentsSettings(this);
    }
  }
}
