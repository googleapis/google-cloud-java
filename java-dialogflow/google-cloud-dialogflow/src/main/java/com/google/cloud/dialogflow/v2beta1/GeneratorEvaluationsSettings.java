/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.stub.GeneratorEvaluationsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GeneratorEvaluationsClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getGeneratorEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GeneratorEvaluationsSettings.Builder generatorEvaluationsSettingsBuilder =
 *     GeneratorEvaluationsSettings.newBuilder();
 * generatorEvaluationsSettingsBuilder
 *     .getGeneratorEvaluationSettings()
 *     .setRetrySettings(
 *         generatorEvaluationsSettingsBuilder
 *             .getGeneratorEvaluationSettings()
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
 * GeneratorEvaluationsSettings generatorEvaluationsSettings =
 *     generatorEvaluationsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createGeneratorEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GeneratorEvaluationsSettings.Builder generatorEvaluationsSettingsBuilder =
 *     GeneratorEvaluationsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * generatorEvaluationsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GeneratorEvaluationsSettings extends ClientSettings<GeneratorEvaluationsSettings> {

  /** Returns the object with the settings used for calls to createGeneratorEvaluation. */
  public UnaryCallSettings<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings())
        .createGeneratorEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to createGeneratorEvaluation. */
  public OperationCallSettings<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings())
        .createGeneratorEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to getGeneratorEvaluation. */
  public UnaryCallSettings<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings()).getGeneratorEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to listGeneratorEvaluations. */
  public PagedCallSettings<
          ListGeneratorEvaluationsRequest,
          ListGeneratorEvaluationsResponse,
          ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings())
        .listGeneratorEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to deleteGeneratorEvaluation. */
  public UnaryCallSettings<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings())
        .deleteGeneratorEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GeneratorEvaluationsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final GeneratorEvaluationsSettings create(GeneratorEvaluationsStubSettings stub)
      throws IOException {
    return new GeneratorEvaluationsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GeneratorEvaluationsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GeneratorEvaluationsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GeneratorEvaluationsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GeneratorEvaluationsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GeneratorEvaluationsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GeneratorEvaluationsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GeneratorEvaluationsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GeneratorEvaluationsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GeneratorEvaluationsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GeneratorEvaluationsSettings. */
  public static class Builder
      extends ClientSettings.Builder<GeneratorEvaluationsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GeneratorEvaluationsStubSettings.newBuilder(clientContext));
    }

    protected Builder(GeneratorEvaluationsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GeneratorEvaluationsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GeneratorEvaluationsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GeneratorEvaluationsStubSettings.newHttpJsonBuilder());
    }

    public GeneratorEvaluationsStubSettings.Builder getStubSettingsBuilder() {
      return ((GeneratorEvaluationsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createGeneratorEvaluation. */
    public UnaryCallSettings.Builder<CreateGeneratorEvaluationRequest, Operation>
        createGeneratorEvaluationSettings() {
      return getStubSettingsBuilder().createGeneratorEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to createGeneratorEvaluation. */
    public OperationCallSettings.Builder<
            CreateGeneratorEvaluationRequest,
            GeneratorEvaluation,
            GeneratorEvaluationOperationMetadata>
        createGeneratorEvaluationOperationSettings() {
      return getStubSettingsBuilder().createGeneratorEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getGeneratorEvaluation. */
    public UnaryCallSettings.Builder<GetGeneratorEvaluationRequest, GeneratorEvaluation>
        getGeneratorEvaluationSettings() {
      return getStubSettingsBuilder().getGeneratorEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to listGeneratorEvaluations. */
    public PagedCallSettings.Builder<
            ListGeneratorEvaluationsRequest,
            ListGeneratorEvaluationsResponse,
            ListGeneratorEvaluationsPagedResponse>
        listGeneratorEvaluationsSettings() {
      return getStubSettingsBuilder().listGeneratorEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGeneratorEvaluation. */
    public UnaryCallSettings.Builder<DeleteGeneratorEvaluationRequest, Empty>
        deleteGeneratorEvaluationSettings() {
      return getStubSettingsBuilder().deleteGeneratorEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public GeneratorEvaluationsSettings build() throws IOException {
      return new GeneratorEvaluationsSettings(this);
    }
  }
}
