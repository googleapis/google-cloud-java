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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.ContentServiceClient.ListContentPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataplex.v1.stub.ContentServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ContentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createContent to 30 seconds:
 *
 * <pre>{@code
 * ContentServiceSettings.Builder contentServiceSettingsBuilder =
 *     ContentServiceSettings.newBuilder();
 * contentServiceSettingsBuilder
 *     .createContentSettings()
 *     .setRetrySettings(
 *         contentServiceSettingsBuilder
 *             .createContentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContentServiceSettings contentServiceSettings = contentServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ContentServiceSettings extends ClientSettings<ContentServiceSettings> {

  /** Returns the object with the settings used for calls to createContent. */
  public UnaryCallSettings<CreateContentRequest, Content> createContentSettings() {
    return ((ContentServiceStubSettings) getStubSettings()).createContentSettings();
  }

  /** Returns the object with the settings used for calls to updateContent. */
  public UnaryCallSettings<UpdateContentRequest, Content> updateContentSettings() {
    return ((ContentServiceStubSettings) getStubSettings()).updateContentSettings();
  }

  /** Returns the object with the settings used for calls to deleteContent. */
  public UnaryCallSettings<DeleteContentRequest, Empty> deleteContentSettings() {
    return ((ContentServiceStubSettings) getStubSettings()).deleteContentSettings();
  }

  /** Returns the object with the settings used for calls to getContent. */
  public UnaryCallSettings<GetContentRequest, Content> getContentSettings() {
    return ((ContentServiceStubSettings) getStubSettings()).getContentSettings();
  }

  /** Returns the object with the settings used for calls to listContent. */
  public PagedCallSettings<ListContentRequest, ListContentResponse, ListContentPagedResponse>
      listContentSettings() {
    return ((ContentServiceStubSettings) getStubSettings()).listContentSettings();
  }

  public static final ContentServiceSettings create(ContentServiceStubSettings stub)
      throws IOException {
    return new ContentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ContentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ContentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ContentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ContentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ContentServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ContentServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ContentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ContentServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ContentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ContentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ContentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ContentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ContentServiceStubSettings.newBuilder());
    }

    public ContentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ContentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createContent. */
    public UnaryCallSettings.Builder<CreateContentRequest, Content> createContentSettings() {
      return getStubSettingsBuilder().createContentSettings();
    }

    /** Returns the builder for the settings used for calls to updateContent. */
    public UnaryCallSettings.Builder<UpdateContentRequest, Content> updateContentSettings() {
      return getStubSettingsBuilder().updateContentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteContent. */
    public UnaryCallSettings.Builder<DeleteContentRequest, Empty> deleteContentSettings() {
      return getStubSettingsBuilder().deleteContentSettings();
    }

    /** Returns the builder for the settings used for calls to getContent. */
    public UnaryCallSettings.Builder<GetContentRequest, Content> getContentSettings() {
      return getStubSettingsBuilder().getContentSettings();
    }

    /** Returns the builder for the settings used for calls to listContent. */
    public PagedCallSettings.Builder<
            ListContentRequest, ListContentResponse, ListContentPagedResponse>
        listContentSettings() {
      return getStubSettingsBuilder().listContentSettings();
    }

    @Override
    public ContentServiceSettings build() throws IOException {
      return new ContentServiceSettings(this);
    }
  }
}
