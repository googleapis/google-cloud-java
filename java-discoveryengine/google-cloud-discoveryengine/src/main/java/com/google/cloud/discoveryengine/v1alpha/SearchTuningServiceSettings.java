/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1alpha.stub.SearchTuningServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SearchTuningServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of trainCustomModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SearchTuningServiceSettings.Builder searchTuningServiceSettingsBuilder =
 *     SearchTuningServiceSettings.newBuilder();
 * searchTuningServiceSettingsBuilder
 *     .trainCustomModelSettings()
 *     .setRetrySettings(
 *         searchTuningServiceSettingsBuilder
 *             .trainCustomModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SearchTuningServiceSettings searchTuningServiceSettings =
 *     searchTuningServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SearchTuningServiceSettings extends ClientSettings<SearchTuningServiceSettings> {

  /** Returns the object with the settings used for calls to trainCustomModel. */
  public UnaryCallSettings<TrainCustomModelRequest, Operation> trainCustomModelSettings() {
    return ((SearchTuningServiceStubSettings) getStubSettings()).trainCustomModelSettings();
  }

  /** Returns the object with the settings used for calls to trainCustomModel. */
  public OperationCallSettings<
          TrainCustomModelRequest, TrainCustomModelResponse, TrainCustomModelMetadata>
      trainCustomModelOperationSettings() {
    return ((SearchTuningServiceStubSettings) getStubSettings())
        .trainCustomModelOperationSettings();
  }

  public static final SearchTuningServiceSettings create(SearchTuningServiceStubSettings stub)
      throws IOException {
    return new SearchTuningServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SearchTuningServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SearchTuningServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SearchTuningServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SearchTuningServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SearchTuningServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SearchTuningServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SearchTuningServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SearchTuningServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SearchTuningServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SearchTuningServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SearchTuningServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SearchTuningServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SearchTuningServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SearchTuningServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SearchTuningServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SearchTuningServiceStubSettings.newHttpJsonBuilder());
    }

    public SearchTuningServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SearchTuningServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to trainCustomModel. */
    public UnaryCallSettings.Builder<TrainCustomModelRequest, Operation>
        trainCustomModelSettings() {
      return getStubSettingsBuilder().trainCustomModelSettings();
    }

    /** Returns the builder for the settings used for calls to trainCustomModel. */
    public OperationCallSettings.Builder<
            TrainCustomModelRequest, TrainCustomModelResponse, TrainCustomModelMetadata>
        trainCustomModelOperationSettings() {
      return getStubSettingsBuilder().trainCustomModelOperationSettings();
    }

    @Override
    public SearchTuningServiceSettings build() throws IOException {
      return new SearchTuningServiceSettings(this);
    }
  }
}
