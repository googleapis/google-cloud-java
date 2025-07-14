/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.modelarmor.v1beta;

import static com.google.cloud.modelarmor.v1beta.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1beta.ModelArmorClient.ListTemplatesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1beta.stub.ModelArmorStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelArmorClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (modelarmor.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTemplate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelArmorSettings.Builder modelArmorSettingsBuilder = ModelArmorSettings.newBuilder();
 * modelArmorSettingsBuilder
 *     .getTemplateSettings()
 *     .setRetrySettings(
 *         modelArmorSettingsBuilder
 *             .getTemplateSettings()
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
 * ModelArmorSettings modelArmorSettings = modelArmorSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelArmorSettings extends ClientSettings<ModelArmorSettings> {

  /** Returns the object with the settings used for calls to listTemplates. */
  public PagedCallSettings<ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
      listTemplatesSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).listTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to getTemplate. */
  public UnaryCallSettings<GetTemplateRequest, Template> getTemplateSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).getTemplateSettings();
  }

  /** Returns the object with the settings used for calls to createTemplate. */
  public UnaryCallSettings<CreateTemplateRequest, Template> createTemplateSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).createTemplateSettings();
  }

  /** Returns the object with the settings used for calls to updateTemplate. */
  public UnaryCallSettings<UpdateTemplateRequest, Template> updateTemplateSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).updateTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteTemplate. */
  public UnaryCallSettings<DeleteTemplateRequest, Empty> deleteTemplateSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).deleteTemplateSettings();
  }

  /** Returns the object with the settings used for calls to getFloorSetting. */
  public UnaryCallSettings<GetFloorSettingRequest, FloorSetting> getFloorSettingSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).getFloorSettingSettings();
  }

  /** Returns the object with the settings used for calls to updateFloorSetting. */
  public UnaryCallSettings<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).updateFloorSettingSettings();
  }

  /** Returns the object with the settings used for calls to sanitizeUserPrompt. */
  public UnaryCallSettings<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).sanitizeUserPromptSettings();
  }

  /** Returns the object with the settings used for calls to sanitizeModelResponse. */
  public UnaryCallSettings<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).sanitizeModelResponseSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ModelArmorStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ModelArmorSettings create(ModelArmorStubSettings stub) throws IOException {
    return new ModelArmorSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ModelArmorStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ModelArmorStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ModelArmorStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ModelArmorStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ModelArmorStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ModelArmorStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ModelArmorStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelArmorStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ModelArmorSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ModelArmorSettings. */
  public static class Builder extends ClientSettings.Builder<ModelArmorSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ModelArmorStubSettings.newBuilder(clientContext));
    }

    protected Builder(ModelArmorSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ModelArmorStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ModelArmorStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ModelArmorStubSettings.newHttpJsonBuilder());
    }

    public ModelArmorStubSettings.Builder getStubSettingsBuilder() {
      return ((ModelArmorStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listTemplates. */
    public PagedCallSettings.Builder<
            ListTemplatesRequest, ListTemplatesResponse, ListTemplatesPagedResponse>
        listTemplatesSettings() {
      return getStubSettingsBuilder().listTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to getTemplate. */
    public UnaryCallSettings.Builder<GetTemplateRequest, Template> getTemplateSettings() {
      return getStubSettingsBuilder().getTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to createTemplate. */
    public UnaryCallSettings.Builder<CreateTemplateRequest, Template> createTemplateSettings() {
      return getStubSettingsBuilder().createTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to updateTemplate. */
    public UnaryCallSettings.Builder<UpdateTemplateRequest, Template> updateTemplateSettings() {
      return getStubSettingsBuilder().updateTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTemplate. */
    public UnaryCallSettings.Builder<DeleteTemplateRequest, Empty> deleteTemplateSettings() {
      return getStubSettingsBuilder().deleteTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to getFloorSetting. */
    public UnaryCallSettings.Builder<GetFloorSettingRequest, FloorSetting>
        getFloorSettingSettings() {
      return getStubSettingsBuilder().getFloorSettingSettings();
    }

    /** Returns the builder for the settings used for calls to updateFloorSetting. */
    public UnaryCallSettings.Builder<UpdateFloorSettingRequest, FloorSetting>
        updateFloorSettingSettings() {
      return getStubSettingsBuilder().updateFloorSettingSettings();
    }

    /** Returns the builder for the settings used for calls to sanitizeUserPrompt. */
    public UnaryCallSettings.Builder<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
        sanitizeUserPromptSettings() {
      return getStubSettingsBuilder().sanitizeUserPromptSettings();
    }

    /** Returns the builder for the settings used for calls to sanitizeModelResponse. */
    public UnaryCallSettings.Builder<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
        sanitizeModelResponseSettings() {
      return getStubSettingsBuilder().sanitizeModelResponseSettings();
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
    public ModelArmorSettings build() throws IOException {
      return new ModelArmorSettings(this);
    }
  }
}
