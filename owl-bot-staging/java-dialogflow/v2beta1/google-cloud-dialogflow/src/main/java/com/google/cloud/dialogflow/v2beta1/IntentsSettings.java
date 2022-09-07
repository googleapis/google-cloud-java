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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.stub.IntentsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IntentsClient}.
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
 * <p>For example, to set the total timeout of getIntent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IntentsSettings.Builder intentsSettingsBuilder = IntentsSettings.newBuilder();
 * intentsSettingsBuilder
 *     .getIntentSettings()
 *     .setRetrySettings(
 *         intentsSettingsBuilder.getIntentSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IntentsSettings intentsSettings = intentsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IntentsSettings extends ClientSettings<IntentsSettings> {

  /** Returns the object with the settings used for calls to listIntents. */
  public PagedCallSettings<ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
      listIntentsSettings() {
    return ((IntentsStubSettings) getStubSettings()).listIntentsSettings();
  }

  /** Returns the object with the settings used for calls to getIntent. */
  public UnaryCallSettings<GetIntentRequest, Intent> getIntentSettings() {
    return ((IntentsStubSettings) getStubSettings()).getIntentSettings();
  }

  /** Returns the object with the settings used for calls to createIntent. */
  public UnaryCallSettings<CreateIntentRequest, Intent> createIntentSettings() {
    return ((IntentsStubSettings) getStubSettings()).createIntentSettings();
  }

  /** Returns the object with the settings used for calls to updateIntent. */
  public UnaryCallSettings<UpdateIntentRequest, Intent> updateIntentSettings() {
    return ((IntentsStubSettings) getStubSettings()).updateIntentSettings();
  }

  /** Returns the object with the settings used for calls to deleteIntent. */
  public UnaryCallSettings<DeleteIntentRequest, Empty> deleteIntentSettings() {
    return ((IntentsStubSettings) getStubSettings()).deleteIntentSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateIntents. */
  public UnaryCallSettings<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsSettings() {
    return ((IntentsStubSettings) getStubSettings()).batchUpdateIntentsSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateIntents. */
  public OperationCallSettings<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationSettings() {
    return ((IntentsStubSettings) getStubSettings()).batchUpdateIntentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteIntents. */
  public UnaryCallSettings<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsSettings() {
    return ((IntentsStubSettings) getStubSettings()).batchDeleteIntentsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteIntents. */
  public OperationCallSettings<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationSettings() {
    return ((IntentsStubSettings) getStubSettings()).batchDeleteIntentsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((IntentsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((IntentsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final IntentsSettings create(IntentsStubSettings stub) throws IOException {
    return new IntentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IntentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IntentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IntentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IntentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IntentsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return IntentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IntentsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IntentsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IntentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IntentsSettings. */
  public static class Builder extends ClientSettings.Builder<IntentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IntentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(IntentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IntentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IntentsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(IntentsStubSettings.newHttpJsonBuilder());
    }

    public IntentsStubSettings.Builder getStubSettingsBuilder() {
      return ((IntentsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listIntents. */
    public PagedCallSettings.Builder<
            ListIntentsRequest, ListIntentsResponse, ListIntentsPagedResponse>
        listIntentsSettings() {
      return getStubSettingsBuilder().listIntentsSettings();
    }

    /** Returns the builder for the settings used for calls to getIntent. */
    public UnaryCallSettings.Builder<GetIntentRequest, Intent> getIntentSettings() {
      return getStubSettingsBuilder().getIntentSettings();
    }

    /** Returns the builder for the settings used for calls to createIntent. */
    public UnaryCallSettings.Builder<CreateIntentRequest, Intent> createIntentSettings() {
      return getStubSettingsBuilder().createIntentSettings();
    }

    /** Returns the builder for the settings used for calls to updateIntent. */
    public UnaryCallSettings.Builder<UpdateIntentRequest, Intent> updateIntentSettings() {
      return getStubSettingsBuilder().updateIntentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIntent. */
    public UnaryCallSettings.Builder<DeleteIntentRequest, Empty> deleteIntentSettings() {
      return getStubSettingsBuilder().deleteIntentSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateIntents. */
    public UnaryCallSettings.Builder<BatchUpdateIntentsRequest, Operation>
        batchUpdateIntentsSettings() {
      return getStubSettingsBuilder().batchUpdateIntentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateIntents. */
    public OperationCallSettings.Builder<
            BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
        batchUpdateIntentsOperationSettings() {
      return getStubSettingsBuilder().batchUpdateIntentsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteIntents. */
    public UnaryCallSettings.Builder<BatchDeleteIntentsRequest, Operation>
        batchDeleteIntentsSettings() {
      return getStubSettingsBuilder().batchDeleteIntentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteIntents. */
    public OperationCallSettings.Builder<BatchDeleteIntentsRequest, Empty, Struct>
        batchDeleteIntentsOperationSettings() {
      return getStubSettingsBuilder().batchDeleteIntentsOperationSettings();
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
    public IntentsSettings build() throws IOException {
      return new IntentsSettings(this);
    }
  }
}
