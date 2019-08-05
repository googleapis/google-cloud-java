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

import static com.google.cloud.compute.v1.InterconnectClient.ListInterconnectsPagedResponse;

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
import com.google.cloud.compute.v1.stub.InterconnectStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link InterconnectClient}.
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
 * <p>For example, to set the total timeout of deleteInterconnect to 30 seconds:
 *
 * <pre>
 * <code>
 * InterconnectSettings.Builder interconnectSettingsBuilder =
 *     InterconnectSettings.newBuilder();
 * interconnectSettingsBuilder.deleteInterconnectSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InterconnectSettings interconnectSettings = interconnectSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectSettings extends ClientSettings<InterconnectSettings> {
  /** Returns the object with the settings used for calls to deleteInterconnect. */
  public UnaryCallSettings<DeleteInterconnectHttpRequest, Operation> deleteInterconnectSettings() {
    return ((InterconnectStubSettings) getStubSettings()).deleteInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to getInterconnect. */
  public UnaryCallSettings<GetInterconnectHttpRequest, Interconnect> getInterconnectSettings() {
    return ((InterconnectStubSettings) getStubSettings()).getInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to getDiagnosticsInterconnect. */
  public UnaryCallSettings<
          GetDiagnosticsInterconnectHttpRequest, InterconnectsGetDiagnosticsResponse>
      getDiagnosticsInterconnectSettings() {
    return ((InterconnectStubSettings) getStubSettings()).getDiagnosticsInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to insertInterconnect. */
  public UnaryCallSettings<InsertInterconnectHttpRequest, Operation> insertInterconnectSettings() {
    return ((InterconnectStubSettings) getStubSettings()).insertInterconnectSettings();
  }

  /** Returns the object with the settings used for calls to listInterconnects. */
  public PagedCallSettings<
          ListInterconnectsHttpRequest, InterconnectList, ListInterconnectsPagedResponse>
      listInterconnectsSettings() {
    return ((InterconnectStubSettings) getStubSettings()).listInterconnectsSettings();
  }

  /** Returns the object with the settings used for calls to patchInterconnect. */
  public UnaryCallSettings<PatchInterconnectHttpRequest, Operation> patchInterconnectSettings() {
    return ((InterconnectStubSettings) getStubSettings()).patchInterconnectSettings();
  }

  public static final InterconnectSettings create(InterconnectStubSettings stub)
      throws IOException {
    return new InterconnectSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InterconnectStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InterconnectStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return InterconnectStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InterconnectStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InterconnectStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InterconnectStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InterconnectStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InterconnectStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InterconnectSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InterconnectSettings. */
  public static class Builder extends ClientSettings.Builder<InterconnectSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(InterconnectStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(InterconnectStubSettings.newBuilder());
    }

    protected Builder(InterconnectSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InterconnectStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public InterconnectStubSettings.Builder getStubSettingsBuilder() {
      return ((InterconnectStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteInterconnect. */
    public UnaryCallSettings.Builder<DeleteInterconnectHttpRequest, Operation>
        deleteInterconnectSettings() {
      return getStubSettingsBuilder().deleteInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to getInterconnect. */
    public UnaryCallSettings.Builder<GetInterconnectHttpRequest, Interconnect>
        getInterconnectSettings() {
      return getStubSettingsBuilder().getInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to getDiagnosticsInterconnect. */
    public UnaryCallSettings.Builder<
            GetDiagnosticsInterconnectHttpRequest, InterconnectsGetDiagnosticsResponse>
        getDiagnosticsInterconnectSettings() {
      return getStubSettingsBuilder().getDiagnosticsInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to insertInterconnect. */
    public UnaryCallSettings.Builder<InsertInterconnectHttpRequest, Operation>
        insertInterconnectSettings() {
      return getStubSettingsBuilder().insertInterconnectSettings();
    }

    /** Returns the builder for the settings used for calls to listInterconnects. */
    public PagedCallSettings.Builder<
            ListInterconnectsHttpRequest, InterconnectList, ListInterconnectsPagedResponse>
        listInterconnectsSettings() {
      return getStubSettingsBuilder().listInterconnectsSettings();
    }

    /** Returns the builder for the settings used for calls to patchInterconnect. */
    public UnaryCallSettings.Builder<PatchInterconnectHttpRequest, Operation>
        patchInterconnectSettings() {
      return getStubSettingsBuilder().patchInterconnectSettings();
    }

    @Override
    public InterconnectSettings build() throws IOException {
      return new InterconnectSettings(this);
    }
  }
}
