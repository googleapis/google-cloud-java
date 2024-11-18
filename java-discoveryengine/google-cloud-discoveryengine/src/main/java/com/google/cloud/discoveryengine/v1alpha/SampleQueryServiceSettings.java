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

import static com.google.cloud.discoveryengine.v1alpha.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1alpha.stub.SampleQueryServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SampleQueryServiceClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSampleQuery:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQueryServiceSettings.Builder sampleQueryServiceSettingsBuilder =
 *     SampleQueryServiceSettings.newBuilder();
 * sampleQueryServiceSettingsBuilder
 *     .getSampleQuerySettings()
 *     .setRetrySettings(
 *         sampleQueryServiceSettingsBuilder
 *             .getSampleQuerySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * SampleQueryServiceSettings sampleQueryServiceSettings =
 *     sampleQueryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for importSampleQueries:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQueryServiceSettings.Builder sampleQueryServiceSettingsBuilder =
 *     SampleQueryServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * sampleQueryServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SampleQueryServiceSettings extends ClientSettings<SampleQueryServiceSettings> {

  /** Returns the object with the settings used for calls to getSampleQuery. */
  public UnaryCallSettings<GetSampleQueryRequest, SampleQuery> getSampleQuerySettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).getSampleQuerySettings();
  }

  /** Returns the object with the settings used for calls to listSampleQueries. */
  public PagedCallSettings<
          ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
      listSampleQueriesSettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).listSampleQueriesSettings();
  }

  /** Returns the object with the settings used for calls to createSampleQuery. */
  public UnaryCallSettings<CreateSampleQueryRequest, SampleQuery> createSampleQuerySettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).createSampleQuerySettings();
  }

  /** Returns the object with the settings used for calls to updateSampleQuery. */
  public UnaryCallSettings<UpdateSampleQueryRequest, SampleQuery> updateSampleQuerySettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).updateSampleQuerySettings();
  }

  /** Returns the object with the settings used for calls to deleteSampleQuery. */
  public UnaryCallSettings<DeleteSampleQueryRequest, Empty> deleteSampleQuerySettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).deleteSampleQuerySettings();
  }

  /** Returns the object with the settings used for calls to importSampleQueries. */
  public UnaryCallSettings<ImportSampleQueriesRequest, Operation> importSampleQueriesSettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings()).importSampleQueriesSettings();
  }

  /** Returns the object with the settings used for calls to importSampleQueries. */
  public OperationCallSettings<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationSettings() {
    return ((SampleQueryServiceStubSettings) getStubSettings())
        .importSampleQueriesOperationSettings();
  }

  public static final SampleQueryServiceSettings create(SampleQueryServiceStubSettings stub)
      throws IOException {
    return new SampleQueryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SampleQueryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SampleQueryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SampleQueryServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected SampleQueryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SampleQueryServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SampleQueryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SampleQueryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SampleQueryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SampleQueryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SampleQueryServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SampleQueryServiceStubSettings.newHttpJsonBuilder());
    }

    public SampleQueryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SampleQueryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getSampleQuery. */
    public UnaryCallSettings.Builder<GetSampleQueryRequest, SampleQuery> getSampleQuerySettings() {
      return getStubSettingsBuilder().getSampleQuerySettings();
    }

    /** Returns the builder for the settings used for calls to listSampleQueries. */
    public PagedCallSettings.Builder<
            ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
        listSampleQueriesSettings() {
      return getStubSettingsBuilder().listSampleQueriesSettings();
    }

    /** Returns the builder for the settings used for calls to createSampleQuery. */
    public UnaryCallSettings.Builder<CreateSampleQueryRequest, SampleQuery>
        createSampleQuerySettings() {
      return getStubSettingsBuilder().createSampleQuerySettings();
    }

    /** Returns the builder for the settings used for calls to updateSampleQuery. */
    public UnaryCallSettings.Builder<UpdateSampleQueryRequest, SampleQuery>
        updateSampleQuerySettings() {
      return getStubSettingsBuilder().updateSampleQuerySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSampleQuery. */
    public UnaryCallSettings.Builder<DeleteSampleQueryRequest, Empty> deleteSampleQuerySettings() {
      return getStubSettingsBuilder().deleteSampleQuerySettings();
    }

    /** Returns the builder for the settings used for calls to importSampleQueries. */
    public UnaryCallSettings.Builder<ImportSampleQueriesRequest, Operation>
        importSampleQueriesSettings() {
      return getStubSettingsBuilder().importSampleQueriesSettings();
    }

    /** Returns the builder for the settings used for calls to importSampleQueries. */
    public OperationCallSettings.Builder<
            ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
        importSampleQueriesOperationSettings() {
      return getStubSettingsBuilder().importSampleQueriesOperationSettings();
    }

    @Override
    public SampleQueryServiceSettings build() throws IOException {
      return new SampleQueryServiceSettings(this);
    }
  }
}
