/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DocumentProcessorServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (us-documentai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of processDocument to 30 seconds:
 *
 * <pre>{@code
 * DocumentProcessorServiceSettings.Builder documentProcessorServiceSettingsBuilder =
 *     DocumentProcessorServiceSettings.newBuilder();
 * documentProcessorServiceSettingsBuilder
 *     .processDocumentSettings()
 *     .setRetrySettings(
 *         documentProcessorServiceSettingsBuilder
 *             .processDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     documentProcessorServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentProcessorServiceSettings
    extends ClientSettings<DocumentProcessorServiceSettings> {

  /** Returns the object with the settings used for calls to processDocument. */
  public UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).processDocumentSettings();
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .batchProcessDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public OperationCallSettings<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .batchProcessDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings()).reviewDocumentSettings();
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings() {
    return ((DocumentProcessorServiceStubSettings) getStubSettings())
        .reviewDocumentOperationSettings();
  }

  public static final DocumentProcessorServiceSettings create(
      DocumentProcessorServiceStubSettings stub) throws IOException {
    return new DocumentProcessorServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentProcessorServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentProcessorServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentProcessorServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentProcessorServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentProcessorServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DocumentProcessorServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentProcessorServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentProcessorServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentProcessorServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentProcessorServiceStubSettings.newBuilder());
    }

    public DocumentProcessorServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentProcessorServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to processDocument. */
    public UnaryCallSettings.Builder<ProcessRequest, ProcessResponse> processDocumentSettings() {
      return getStubSettingsBuilder().processDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public UnaryCallSettings.Builder<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
      return getStubSettingsBuilder().reviewDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings() {
      return getStubSettingsBuilder().reviewDocumentOperationSettings();
    }

    @Override
    public DocumentProcessorServiceSettings build() throws IOException {
      return new DocumentProcessorServiceSettings(this);
    }
  }
}
