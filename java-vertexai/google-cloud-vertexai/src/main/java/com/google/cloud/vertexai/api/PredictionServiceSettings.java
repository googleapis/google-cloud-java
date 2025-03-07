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

package com.google.cloud.vertexai.api;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vertexai.api.PredictionServiceClient.ListLocationsPagedResponse;
import com.google.cloud.vertexai.api.stub.PredictionServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PredictionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of predict to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PredictionServiceSettings.Builder predictionServiceSettingsBuilder =
 *     PredictionServiceSettings.newBuilder();
 * predictionServiceSettingsBuilder
 *     .predictSettings()
 *     .setRetrySettings(
 *         predictionServiceSettingsBuilder
 *             .predictSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PredictionServiceSettings predictionServiceSettings = predictionServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PredictionServiceSettings extends ClientSettings<PredictionServiceSettings> {

  /** Returns the object with the settings used for calls to predict. */
  public UnaryCallSettings<PredictRequest, PredictResponse> predictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).predictSettings();
  }

  /** Returns the object with the settings used for calls to rawPredict. */
  public UnaryCallSettings<RawPredictRequest, HttpBody> rawPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).rawPredictSettings();
  }

  /** Returns the object with the settings used for calls to streamRawPredict. */
  public ServerStreamingCallSettings<StreamRawPredictRequest, HttpBody> streamRawPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamRawPredictSettings();
  }

  /** Returns the object with the settings used for calls to directPredict. */
  public UnaryCallSettings<DirectPredictRequest, DirectPredictResponse> directPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).directPredictSettings();
  }

  /** Returns the object with the settings used for calls to directRawPredict. */
  public UnaryCallSettings<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).directRawPredictSettings();
  }

  /** Returns the object with the settings used for calls to streamDirectPredict. */
  public StreamingCallSettings<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamDirectPredictSettings();
  }

  /** Returns the object with the settings used for calls to streamDirectRawPredict. */
  public StreamingCallSettings<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamDirectRawPredictSettings();
  }

  /** Returns the object with the settings used for calls to streamingPredict. */
  public StreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamingPredictSettings();
  }

  /** Returns the object with the settings used for calls to serverStreamingPredict. */
  public ServerStreamingCallSettings<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).serverStreamingPredictSettings();
  }

  /** Returns the object with the settings used for calls to streamingRawPredict. */
  public StreamingCallSettings<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamingRawPredictSettings();
  }

  /** Returns the object with the settings used for calls to explain. */
  public UnaryCallSettings<ExplainRequest, ExplainResponse> explainSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).explainSettings();
  }

  /** Returns the object with the settings used for calls to generateContent. */
  public UnaryCallSettings<GenerateContentRequest, GenerateContentResponse>
      generateContentSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).generateContentSettings();
  }

  /** Returns the object with the settings used for calls to streamGenerateContent. */
  public ServerStreamingCallSettings<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).streamGenerateContentSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((PredictionServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final PredictionServiceSettings create(PredictionServiceStubSettings stub)
      throws IOException {
    return new PredictionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PredictionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PredictionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PredictionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PredictionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PredictionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PredictionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PredictionServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PredictionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PredictionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PredictionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<PredictionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PredictionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PredictionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PredictionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PredictionServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(PredictionServiceStubSettings.newHttpJsonBuilder());
    }

    public PredictionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PredictionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to predict. */
    public UnaryCallSettings.Builder<PredictRequest, PredictResponse> predictSettings() {
      return getStubSettingsBuilder().predictSettings();
    }

    /** Returns the builder for the settings used for calls to rawPredict. */
    public UnaryCallSettings.Builder<RawPredictRequest, HttpBody> rawPredictSettings() {
      return getStubSettingsBuilder().rawPredictSettings();
    }

    /** Returns the builder for the settings used for calls to streamRawPredict. */
    public ServerStreamingCallSettings.Builder<StreamRawPredictRequest, HttpBody>
        streamRawPredictSettings() {
      return getStubSettingsBuilder().streamRawPredictSettings();
    }

    /** Returns the builder for the settings used for calls to directPredict. */
    public UnaryCallSettings.Builder<DirectPredictRequest, DirectPredictResponse>
        directPredictSettings() {
      return getStubSettingsBuilder().directPredictSettings();
    }

    /** Returns the builder for the settings used for calls to directRawPredict. */
    public UnaryCallSettings.Builder<DirectRawPredictRequest, DirectRawPredictResponse>
        directRawPredictSettings() {
      return getStubSettingsBuilder().directRawPredictSettings();
    }

    /** Returns the builder for the settings used for calls to streamDirectPredict. */
    public StreamingCallSettings.Builder<StreamDirectPredictRequest, StreamDirectPredictResponse>
        streamDirectPredictSettings() {
      return getStubSettingsBuilder().streamDirectPredictSettings();
    }

    /** Returns the builder for the settings used for calls to streamDirectRawPredict. */
    public StreamingCallSettings.Builder<
            StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
        streamDirectRawPredictSettings() {
      return getStubSettingsBuilder().streamDirectRawPredictSettings();
    }

    /** Returns the builder for the settings used for calls to streamingPredict. */
    public StreamingCallSettings.Builder<StreamingPredictRequest, StreamingPredictResponse>
        streamingPredictSettings() {
      return getStubSettingsBuilder().streamingPredictSettings();
    }

    /** Returns the builder for the settings used for calls to serverStreamingPredict. */
    public ServerStreamingCallSettings.Builder<StreamingPredictRequest, StreamingPredictResponse>
        serverStreamingPredictSettings() {
      return getStubSettingsBuilder().serverStreamingPredictSettings();
    }

    /** Returns the builder for the settings used for calls to streamingRawPredict. */
    public StreamingCallSettings.Builder<StreamingRawPredictRequest, StreamingRawPredictResponse>
        streamingRawPredictSettings() {
      return getStubSettingsBuilder().streamingRawPredictSettings();
    }

    /** Returns the builder for the settings used for calls to explain. */
    public UnaryCallSettings.Builder<ExplainRequest, ExplainResponse> explainSettings() {
      return getStubSettingsBuilder().explainSettings();
    }

    /** Returns the builder for the settings used for calls to generateContent. */
    public UnaryCallSettings.Builder<GenerateContentRequest, GenerateContentResponse>
        generateContentSettings() {
      return getStubSettingsBuilder().generateContentSettings();
    }

    /** Returns the builder for the settings used for calls to streamGenerateContent. */
    public ServerStreamingCallSettings.Builder<GenerateContentRequest, GenerateContentResponse>
        streamGenerateContentSettings() {
      return getStubSettingsBuilder().streamGenerateContentSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public PredictionServiceSettings build() throws IOException {
      return new PredictionServiceSettings(this);
    }
  }
}
