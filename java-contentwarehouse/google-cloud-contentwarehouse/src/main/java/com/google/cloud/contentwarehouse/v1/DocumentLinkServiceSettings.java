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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.contentwarehouse.v1.stub.DocumentLinkServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DocumentLinkServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contentwarehouse.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of listLinkedTargets to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentLinkServiceSettings.Builder documentLinkServiceSettingsBuilder =
 *     DocumentLinkServiceSettings.newBuilder();
 * documentLinkServiceSettingsBuilder
 *     .listLinkedTargetsSettings()
 *     .setRetrySettings(
 *         documentLinkServiceSettingsBuilder
 *             .listLinkedTargetsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentLinkServiceSettings documentLinkServiceSettings =
 *     documentLinkServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentLinkServiceSettings extends ClientSettings<DocumentLinkServiceSettings> {

  /** Returns the object with the settings used for calls to listLinkedTargets. */
  public UnaryCallSettings<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsSettings() {
    return ((DocumentLinkServiceStubSettings) getStubSettings()).listLinkedTargetsSettings();
  }

  /** Returns the object with the settings used for calls to listLinkedSources. */
  public PagedCallSettings<
          ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
      listLinkedSourcesSettings() {
    return ((DocumentLinkServiceStubSettings) getStubSettings()).listLinkedSourcesSettings();
  }

  /** Returns the object with the settings used for calls to createDocumentLink. */
  public UnaryCallSettings<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkSettings() {
    return ((DocumentLinkServiceStubSettings) getStubSettings()).createDocumentLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteDocumentLink. */
  public UnaryCallSettings<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkSettings() {
    return ((DocumentLinkServiceStubSettings) getStubSettings()).deleteDocumentLinkSettings();
  }

  public static final DocumentLinkServiceSettings create(DocumentLinkServiceStubSettings stub)
      throws IOException {
    return new DocumentLinkServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DocumentLinkServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DocumentLinkServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DocumentLinkServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DocumentLinkServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DocumentLinkServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DocumentLinkServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DocumentLinkServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DocumentLinkServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DocumentLinkServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DocumentLinkServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DocumentLinkServiceStubSettings.newHttpJsonBuilder());
    }

    public DocumentLinkServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DocumentLinkServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listLinkedTargets. */
    public UnaryCallSettings.Builder<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
        listLinkedTargetsSettings() {
      return getStubSettingsBuilder().listLinkedTargetsSettings();
    }

    /** Returns the builder for the settings used for calls to listLinkedSources. */
    public PagedCallSettings.Builder<
            ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
        listLinkedSourcesSettings() {
      return getStubSettingsBuilder().listLinkedSourcesSettings();
    }

    /** Returns the builder for the settings used for calls to createDocumentLink. */
    public UnaryCallSettings.Builder<CreateDocumentLinkRequest, DocumentLink>
        createDocumentLinkSettings() {
      return getStubSettingsBuilder().createDocumentLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDocumentLink. */
    public UnaryCallSettings.Builder<DeleteDocumentLinkRequest, Empty>
        deleteDocumentLinkSettings() {
      return getStubSettingsBuilder().deleteDocumentLinkSettings();
    }

    @Override
    public DocumentLinkServiceSettings build() throws IOException {
      return new DocumentLinkServiceSettings(this);
    }
  }
}
