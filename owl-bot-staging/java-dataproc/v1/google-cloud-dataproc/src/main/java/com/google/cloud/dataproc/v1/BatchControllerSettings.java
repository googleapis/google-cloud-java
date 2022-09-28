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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

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
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataproc.v1.stub.BatchControllerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BatchControllerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBatch to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BatchControllerSettings.Builder batchControllerSettingsBuilder =
 *     BatchControllerSettings.newBuilder();
 * batchControllerSettingsBuilder
 *     .getBatchSettings()
 *     .setRetrySettings(
 *         batchControllerSettingsBuilder.getBatchSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BatchControllerSettings batchControllerSettings = batchControllerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BatchControllerSettings extends ClientSettings<BatchControllerSettings> {

  /** Returns the object with the settings used for calls to createBatch. */
  public UnaryCallSettings<CreateBatchRequest, Operation> createBatchSettings() {
    return ((BatchControllerStubSettings) getStubSettings()).createBatchSettings();
  }

  /** Returns the object with the settings used for calls to createBatch. */
  public OperationCallSettings<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationSettings() {
    return ((BatchControllerStubSettings) getStubSettings()).createBatchOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBatch. */
  public UnaryCallSettings<GetBatchRequest, Batch> getBatchSettings() {
    return ((BatchControllerStubSettings) getStubSettings()).getBatchSettings();
  }

  /** Returns the object with the settings used for calls to listBatches. */
  public PagedCallSettings<ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
      listBatchesSettings() {
    return ((BatchControllerStubSettings) getStubSettings()).listBatchesSettings();
  }

  /** Returns the object with the settings used for calls to deleteBatch. */
  public UnaryCallSettings<DeleteBatchRequest, Empty> deleteBatchSettings() {
    return ((BatchControllerStubSettings) getStubSettings()).deleteBatchSettings();
  }

  public static final BatchControllerSettings create(BatchControllerStubSettings stub)
      throws IOException {
    return new BatchControllerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BatchControllerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BatchControllerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BatchControllerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BatchControllerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BatchControllerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BatchControllerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BatchControllerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BatchControllerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BatchControllerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BatchControllerSettings. */
  public static class Builder extends ClientSettings.Builder<BatchControllerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BatchControllerStubSettings.newBuilder(clientContext));
    }

    protected Builder(BatchControllerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BatchControllerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BatchControllerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(BatchControllerStubSettings.newHttpJsonBuilder());
    }

    public BatchControllerStubSettings.Builder getStubSettingsBuilder() {
      return ((BatchControllerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createBatch. */
    public UnaryCallSettings.Builder<CreateBatchRequest, Operation> createBatchSettings() {
      return getStubSettingsBuilder().createBatchSettings();
    }

    /** Returns the builder for the settings used for calls to createBatch. */
    public OperationCallSettings.Builder<CreateBatchRequest, Batch, BatchOperationMetadata>
        createBatchOperationSettings() {
      return getStubSettingsBuilder().createBatchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBatch. */
    public UnaryCallSettings.Builder<GetBatchRequest, Batch> getBatchSettings() {
      return getStubSettingsBuilder().getBatchSettings();
    }

    /** Returns the builder for the settings used for calls to listBatches. */
    public PagedCallSettings.Builder<
            ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
        listBatchesSettings() {
      return getStubSettingsBuilder().listBatchesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBatch. */
    public UnaryCallSettings.Builder<DeleteBatchRequest, Empty> deleteBatchSettings() {
      return getStubSettingsBuilder().deleteBatchSettings();
    }

    @Override
    public BatchControllerSettings build() throws IOException {
      return new BatchControllerSettings(this);
    }
  }
}
