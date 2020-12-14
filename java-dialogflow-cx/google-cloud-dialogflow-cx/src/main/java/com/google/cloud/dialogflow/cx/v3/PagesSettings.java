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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.PagesClient.ListPagesPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.stub.PagesStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PagesClient}.
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
 * <p>For example, to set the total timeout of getPage to 30 seconds:
 *
 * <pre>{@code
 * PagesSettings.Builder pagesSettingsBuilder = PagesSettings.newBuilder();
 * pagesSettingsBuilder
 *     .getPageSettings()
 *     .setRetrySettings(
 *         pagesSettingsBuilder
 *             .getPageSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PagesSettings pagesSettings = pagesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PagesSettings extends ClientSettings<PagesSettings> {

  /** Returns the object with the settings used for calls to listPages. */
  public PagedCallSettings<ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
      listPagesSettings() {
    return ((PagesStubSettings) getStubSettings()).listPagesSettings();
  }

  /** Returns the object with the settings used for calls to getPage. */
  public UnaryCallSettings<GetPageRequest, Page> getPageSettings() {
    return ((PagesStubSettings) getStubSettings()).getPageSettings();
  }

  /** Returns the object with the settings used for calls to createPage. */
  public UnaryCallSettings<CreatePageRequest, Page> createPageSettings() {
    return ((PagesStubSettings) getStubSettings()).createPageSettings();
  }

  /** Returns the object with the settings used for calls to updatePage. */
  public UnaryCallSettings<UpdatePageRequest, Page> updatePageSettings() {
    return ((PagesStubSettings) getStubSettings()).updatePageSettings();
  }

  /** Returns the object with the settings used for calls to deletePage. */
  public UnaryCallSettings<DeletePageRequest, Empty> deletePageSettings() {
    return ((PagesStubSettings) getStubSettings()).deletePageSettings();
  }

  public static final PagesSettings create(PagesStubSettings stub) throws IOException {
    return new PagesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PagesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PagesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PagesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PagesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PagesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PagesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PagesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PagesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PagesSettings. */
  public static class Builder extends ClientSettings.Builder<PagesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PagesStubSettings.newBuilder(clientContext));
    }

    protected Builder(PagesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PagesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PagesStubSettings.newBuilder());
    }

    public PagesStubSettings.Builder getStubSettingsBuilder() {
      return ((PagesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listPages. */
    public PagedCallSettings.Builder<ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
        listPagesSettings() {
      return getStubSettingsBuilder().listPagesSettings();
    }

    /** Returns the builder for the settings used for calls to getPage. */
    public UnaryCallSettings.Builder<GetPageRequest, Page> getPageSettings() {
      return getStubSettingsBuilder().getPageSettings();
    }

    /** Returns the builder for the settings used for calls to createPage. */
    public UnaryCallSettings.Builder<CreatePageRequest, Page> createPageSettings() {
      return getStubSettingsBuilder().createPageSettings();
    }

    /** Returns the builder for the settings used for calls to updatePage. */
    public UnaryCallSettings.Builder<UpdatePageRequest, Page> updatePageSettings() {
      return getStubSettingsBuilder().updatePageSettings();
    }

    /** Returns the builder for the settings used for calls to deletePage. */
    public UnaryCallSettings.Builder<DeletePageRequest, Empty> deletePageSettings() {
      return getStubSettingsBuilder().deletePageSettings();
    }

    @Override
    public PagesSettings build() throws IOException {
      return new PagesSettings(this);
    }
  }
}
