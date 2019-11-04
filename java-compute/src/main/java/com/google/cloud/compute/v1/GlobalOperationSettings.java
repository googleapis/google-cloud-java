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

import static com.google.cloud.compute.v1.GlobalOperationClient.AggregatedListGlobalOperationsPagedResponse;
import static com.google.cloud.compute.v1.GlobalOperationClient.ListGlobalOperationsPagedResponse;

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
import com.google.cloud.compute.v1.stub.GlobalOperationStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link GlobalOperationClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteGlobalOperation to 30 seconds:
 *
 * <pre>
 * <code>
 * GlobalOperationSettings.Builder globalOperationSettingsBuilder =
 *     GlobalOperationSettings.newBuilder();
 * globalOperationSettingsBuilder.deleteGlobalOperationSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * GlobalOperationSettings globalOperationSettings = globalOperationSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalOperationSettings extends ClientSettings<GlobalOperationSettings> {
  /** Returns the object with the settings used for calls to aggregatedListGlobalOperations. */
  public PagedCallSettings<
          AggregatedListGlobalOperationsHttpRequest,
          OperationAggregatedList,
          AggregatedListGlobalOperationsPagedResponse>
      aggregatedListGlobalOperationsSettings() {
    return ((GlobalOperationStubSettings) getStubSettings())
        .aggregatedListGlobalOperationsSettings();
  }

  /** Returns the object with the settings used for calls to deleteGlobalOperation. */
  public UnaryCallSettings<DeleteGlobalOperationHttpRequest, Void> deleteGlobalOperationSettings() {
    return ((GlobalOperationStubSettings) getStubSettings()).deleteGlobalOperationSettings();
  }

  /** Returns the object with the settings used for calls to getGlobalOperation. */
  public UnaryCallSettings<GetGlobalOperationHttpRequest, Operation> getGlobalOperationSettings() {
    return ((GlobalOperationStubSettings) getStubSettings()).getGlobalOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGlobalOperations. */
  public PagedCallSettings<
          ListGlobalOperationsHttpRequest, OperationList, ListGlobalOperationsPagedResponse>
      listGlobalOperationsSettings() {
    return ((GlobalOperationStubSettings) getStubSettings()).listGlobalOperationsSettings();
  }

  public static final GlobalOperationSettings create(GlobalOperationStubSettings stub)
      throws IOException {
    return new GlobalOperationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GlobalOperationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GlobalOperationStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return GlobalOperationStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GlobalOperationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GlobalOperationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GlobalOperationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GlobalOperationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GlobalOperationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GlobalOperationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GlobalOperationSettings. */
  public static class Builder extends ClientSettings.Builder<GlobalOperationSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(GlobalOperationStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(GlobalOperationStubSettings.newBuilder());
    }

    protected Builder(GlobalOperationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GlobalOperationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public GlobalOperationStubSettings.Builder getStubSettingsBuilder() {
      return ((GlobalOperationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListGlobalOperations. */
    public PagedCallSettings.Builder<
            AggregatedListGlobalOperationsHttpRequest,
            OperationAggregatedList,
            AggregatedListGlobalOperationsPagedResponse>
        aggregatedListGlobalOperationsSettings() {
      return getStubSettingsBuilder().aggregatedListGlobalOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlobalOperation. */
    public UnaryCallSettings.Builder<DeleteGlobalOperationHttpRequest, Void>
        deleteGlobalOperationSettings() {
      return getStubSettingsBuilder().deleteGlobalOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getGlobalOperation. */
    public UnaryCallSettings.Builder<GetGlobalOperationHttpRequest, Operation>
        getGlobalOperationSettings() {
      return getStubSettingsBuilder().getGlobalOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGlobalOperations. */
    public PagedCallSettings.Builder<
            ListGlobalOperationsHttpRequest, OperationList, ListGlobalOperationsPagedResponse>
        listGlobalOperationsSettings() {
      return getStubSettingsBuilder().listGlobalOperationsSettings();
    }

    @Override
    public GlobalOperationSettings build() throws IOException {
      return new GlobalOperationSettings(this);
    }
  }
}
