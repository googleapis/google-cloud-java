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

package com.google.cloud.retail.v2beta;

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
import com.google.cloud.retail.v2beta.stub.CompletionServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CompletionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of completeQuery to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CompletionServiceSettings.Builder completionServiceSettingsBuilder =
 *     CompletionServiceSettings.newBuilder();
 * completionServiceSettingsBuilder
 *     .completeQuerySettings()
 *     .setRetrySettings(
 *         completionServiceSettingsBuilder.completeQuerySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CompletionServiceSettings completionServiceSettings = completionServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CompletionServiceSettings extends ClientSettings<CompletionServiceSettings> {

  /** Returns the object with the settings used for calls to completeQuery. */
  public UnaryCallSettings<CompleteQueryRequest, CompleteQueryResponse> completeQuerySettings() {
    return ((CompletionServiceStubSettings) getStubSettings()).completeQuerySettings();
  }

  /** Returns the object with the settings used for calls to importCompletionData. */
  public UnaryCallSettings<ImportCompletionDataRequest, Operation> importCompletionDataSettings() {
    return ((CompletionServiceStubSettings) getStubSettings()).importCompletionDataSettings();
  }

  /** Returns the object with the settings used for calls to importCompletionData. */
  public OperationCallSettings<
          ImportCompletionDataRequest, ImportCompletionDataResponse, ImportMetadata>
      importCompletionDataOperationSettings() {
    return ((CompletionServiceStubSettings) getStubSettings())
        .importCompletionDataOperationSettings();
  }

  public static final CompletionServiceSettings create(CompletionServiceStubSettings stub)
      throws IOException {
    return new CompletionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CompletionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CompletionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CompletionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CompletionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CompletionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CompletionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CompletionServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CompletionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CompletionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CompletionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CompletionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CompletionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CompletionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CompletionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CompletionServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CompletionServiceStubSettings.newHttpJsonBuilder());
    }

    public CompletionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CompletionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to completeQuery. */
    public UnaryCallSettings.Builder<CompleteQueryRequest, CompleteQueryResponse>
        completeQuerySettings() {
      return getStubSettingsBuilder().completeQuerySettings();
    }

    /** Returns the builder for the settings used for calls to importCompletionData. */
    public UnaryCallSettings.Builder<ImportCompletionDataRequest, Operation>
        importCompletionDataSettings() {
      return getStubSettingsBuilder().importCompletionDataSettings();
    }

    /** Returns the builder for the settings used for calls to importCompletionData. */
    public OperationCallSettings.Builder<
            ImportCompletionDataRequest, ImportCompletionDataResponse, ImportMetadata>
        importCompletionDataOperationSettings() {
      return getStubSettingsBuilder().importCompletionDataOperationSettings();
    }

    @Override
    public CompletionServiceSettings build() throws IOException {
      return new CompletionServiceSettings(this);
    }
  }
}
