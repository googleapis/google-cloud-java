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

package com.google.cloud.documentai.v1beta2;

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
import com.google.cloud.documentai.v1beta2.stub.DocumentUnderstandingServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DocumentUnderstandingServiceClient}.
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
 * DocumentUnderstandingServiceSettings.Builder documentUnderstandingServiceSettingsBuilder =
 *     DocumentUnderstandingServiceSettings.newBuilder();
 * documentUnderstandingServiceSettingsBuilder
 *     .processDocumentSettings()
 *     .setRetrySettings(
 *         documentUnderstandingServiceSettingsBuilder
 *             .processDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentUnderstandingServiceSettings documentUnderstandingServiceSettings =
 *     documentUnderstandingServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentUnderstandingServiceSettings
    extends ClientSettings<DocumentUnderstandingServiceSettings> {

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public UnaryCallSettings<BatchProcessDocumentsRequest, Operation>
      batchProcessDocumentsSettings() {
    return ((DocumentUnderstandingServiceStubSettings) getStubSettings())
        .batchProcessDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public OperationCallSettings<
          BatchProcessDocumentsRequest, BatchProcessDocumentsResponse, OperationMetadata>
      batchProcessDocumentsOperationSettings() {
    return ((DocumentUnderstandingServiceStubSettings) getStubSettings())
        .batchProcessDocumentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to processDocument. */
  public UnaryCallSettings<ProcessDocumentRequest, Document> processDocumentSettings() {
    return ((DocumentUnderstandingServiceStubSettings) getStubSettings()).processDocumentSettings();
  }

  public static final DocumentUnderstandingServiceSettings create(
      DocumentUnderstandingServiceStubSettings stub) throws IOException {
    return new DocumentUnderstandingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentUnderstandingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentUnderstandingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentUnderstandingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentUnderstandingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentUnderstandingServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentUnderstandingServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentUnderstandingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentUnderstandingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentUnderstandingServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DocumentUnderstandingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentUnderstandingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentUnderstandingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentUnderstandingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentUnderstandingServiceStubSettings.newBuilder());
    }

    public DocumentUnderstandingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentUnderstandingServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public UnaryCallSettings.Builder<BatchProcessDocumentsRequest, Operation>
        batchProcessDocumentsSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public OperationCallSettings.Builder<
            BatchProcessDocumentsRequest, BatchProcessDocumentsResponse, OperationMetadata>
        batchProcessDocumentsOperationSettings() {
      return getStubSettingsBuilder().batchProcessDocumentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to processDocument. */
    public UnaryCallSettings.Builder<ProcessDocumentRequest, Document> processDocumentSettings() {
      return getStubSettingsBuilder().processDocumentSettings();
    }

    @Override
    public DocumentUnderstandingServiceSettings build() throws IOException {
      return new DocumentUnderstandingServiceSettings(this);
    }
  }
}
