/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.InterconnectAttachmentClient.AggregatedListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.compute.v1.InterconnectAttachmentClient.ListInterconnectAttachmentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.InterconnectAttachmentStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link InterconnectAttachmentClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteInterconnectAttachment to 30 seconds:
 *
 * <pre>
 * <code>
 * InterconnectAttachmentSettings.Builder interconnectAttachmentSettingsBuilder =
 *     InterconnectAttachmentSettings.newBuilder();
 * interconnectAttachmentSettingsBuilder.deleteInterconnectAttachmentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InterconnectAttachmentSettings interconnectAttachmentSettings = interconnectAttachmentSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectAttachmentSettings extends ClientSettings<InterconnectAttachmentSettings> {
  /**
   * Returns the object with the settings used for calls to aggregatedListInterconnectAttachments.
   */
  public PagedCallSettings<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .aggregatedListInterconnectAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterconnectAttachment. */
  public UnaryCallSettings<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .deleteInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to getInterconnectAttachment. */
  public UnaryCallSettings<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .getInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to insertInterconnectAttachment. */
  public UnaryCallSettings<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .insertInterconnectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listInterconnectAttachments. */
  public PagedCallSettings<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .listInterconnectAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to patchInterconnectAttachment. */
  public UnaryCallSettings<PatchInterconnectAttachmentHttpRequest, Operation>
      patchInterconnectAttachmentSettings() {
    return ((InterconnectAttachmentStubSettings) getStubSettings())
        .patchInterconnectAttachmentSettings();
  }

  public static final InterconnectAttachmentSettings create(InterconnectAttachmentStubSettings stub)
      throws IOException {
    return new InterconnectAttachmentSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InterconnectAttachmentStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InterconnectAttachmentStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return InterconnectAttachmentStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InterconnectAttachmentStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InterconnectAttachmentStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InterconnectAttachmentStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InterconnectAttachmentStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InterconnectAttachmentStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InterconnectAttachmentSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InterconnectAttachmentSettings. */
  public static class Builder
      extends ClientSettings.Builder<InterconnectAttachmentSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(InterconnectAttachmentStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(InterconnectAttachmentStubSettings.newBuilder());
    }

    protected Builder(InterconnectAttachmentSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InterconnectAttachmentStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public InterconnectAttachmentStubSettings.Builder getStubSettingsBuilder() {
      return ((InterconnectAttachmentStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /**
     * Returns the builder for the settings used for calls to aggregatedListInterconnectAttachments.
     */
    public PagedCallSettings.Builder<
            AggregatedListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentAggregatedList,
            AggregatedListInterconnectAttachmentsPagedResponse>
        aggregatedListInterconnectAttachmentsSettings() {
      return getStubSettingsBuilder().aggregatedListInterconnectAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterconnectAttachment. */
    public UnaryCallSettings.Builder<DeleteInterconnectAttachmentHttpRequest, Operation>
        deleteInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().deleteInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to getInterconnectAttachment. */
    public UnaryCallSettings.Builder<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
        getInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().getInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to insertInterconnectAttachment. */
    public UnaryCallSettings.Builder<InsertInterconnectAttachmentHttpRequest, Operation>
        insertInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().insertInterconnectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to listInterconnectAttachments. */
    public PagedCallSettings.Builder<
            ListInterconnectAttachmentsHttpRequest,
            InterconnectAttachmentList,
            ListInterconnectAttachmentsPagedResponse>
        listInterconnectAttachmentsSettings() {
      return getStubSettingsBuilder().listInterconnectAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to patchInterconnectAttachment. */
    public UnaryCallSettings.Builder<PatchInterconnectAttachmentHttpRequest, Operation>
        patchInterconnectAttachmentSettings() {
      return getStubSettingsBuilder().patchInterconnectAttachmentSettings();
    }

    @Override
    public InterconnectAttachmentSettings build() throws IOException {
      return new InterconnectAttachmentSettings(this);
    }
  }
}
