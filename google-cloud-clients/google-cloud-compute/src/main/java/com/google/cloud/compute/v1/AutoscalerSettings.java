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

import static com.google.cloud.compute.v1.AutoscalerClient.AggregatedListAutoscalersPagedResponse;
import static com.google.cloud.compute.v1.AutoscalerClient.ListAutoscalersPagedResponse;

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
import com.google.cloud.compute.v1.stub.AutoscalerStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link AutoscalerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteAutoscaler to 30 seconds:
 *
 * <pre>
 * <code>
 * AutoscalerSettings.Builder autoscalerSettingsBuilder =
 *     AutoscalerSettings.newBuilder();
 * autoscalerSettingsBuilder.deleteAutoscalerSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AutoscalerSettings autoscalerSettings = autoscalerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AutoscalerSettings extends ClientSettings<AutoscalerSettings> {
  /** Returns the object with the settings used for calls to aggregatedListAutoscalers. */
  public PagedCallSettings<
          AggregatedListAutoscalersHttpRequest,
          AutoscalerAggregatedList,
          AggregatedListAutoscalersPagedResponse>
      aggregatedListAutoscalersSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).aggregatedListAutoscalersSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutoscaler. */
  public UnaryCallSettings<DeleteAutoscalerHttpRequest, Operation> deleteAutoscalerSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).deleteAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to getAutoscaler. */
  public UnaryCallSettings<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).getAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to insertAutoscaler. */
  public UnaryCallSettings<InsertAutoscalerHttpRequest, Operation> insertAutoscalerSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).insertAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to listAutoscalers. */
  public PagedCallSettings<ListAutoscalersHttpRequest, AutoscalerList, ListAutoscalersPagedResponse>
      listAutoscalersSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).listAutoscalersSettings();
  }

  /** Returns the object with the settings used for calls to patchAutoscaler. */
  public UnaryCallSettings<PatchAutoscalerHttpRequest, Operation> patchAutoscalerSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).patchAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to updateAutoscaler. */
  public UnaryCallSettings<UpdateAutoscalerHttpRequest, Operation> updateAutoscalerSettings() {
    return ((AutoscalerStubSettings) getStubSettings()).updateAutoscalerSettings();
  }

  public static final AutoscalerSettings create(AutoscalerStubSettings stub) throws IOException {
    return new AutoscalerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AutoscalerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AutoscalerStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return AutoscalerStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AutoscalerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AutoscalerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AutoscalerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AutoscalerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AutoscalerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AutoscalerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AutoscalerSettings. */
  public static class Builder extends ClientSettings.Builder<AutoscalerSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(AutoscalerStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(AutoscalerStubSettings.newBuilder());
    }

    protected Builder(AutoscalerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AutoscalerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public AutoscalerStubSettings.Builder getStubSettingsBuilder() {
      return ((AutoscalerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListAutoscalers. */
    public PagedCallSettings.Builder<
            AggregatedListAutoscalersHttpRequest,
            AutoscalerAggregatedList,
            AggregatedListAutoscalersPagedResponse>
        aggregatedListAutoscalersSettings() {
      return getStubSettingsBuilder().aggregatedListAutoscalersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutoscaler. */
    public UnaryCallSettings.Builder<DeleteAutoscalerHttpRequest, Operation>
        deleteAutoscalerSettings() {
      return getStubSettingsBuilder().deleteAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to getAutoscaler. */
    public UnaryCallSettings.Builder<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerSettings() {
      return getStubSettingsBuilder().getAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to insertAutoscaler. */
    public UnaryCallSettings.Builder<InsertAutoscalerHttpRequest, Operation>
        insertAutoscalerSettings() {
      return getStubSettingsBuilder().insertAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to listAutoscalers. */
    public PagedCallSettings.Builder<
            ListAutoscalersHttpRequest, AutoscalerList, ListAutoscalersPagedResponse>
        listAutoscalersSettings() {
      return getStubSettingsBuilder().listAutoscalersSettings();
    }

    /** Returns the builder for the settings used for calls to patchAutoscaler. */
    public UnaryCallSettings.Builder<PatchAutoscalerHttpRequest, Operation>
        patchAutoscalerSettings() {
      return getStubSettingsBuilder().patchAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to updateAutoscaler. */
    public UnaryCallSettings.Builder<UpdateAutoscalerHttpRequest, Operation>
        updateAutoscalerSettings() {
      return getStubSettingsBuilder().updateAutoscalerSettings();
    }

    @Override
    public AutoscalerSettings build() throws IOException {
      return new AutoscalerSettings(this);
    }
  }
}
