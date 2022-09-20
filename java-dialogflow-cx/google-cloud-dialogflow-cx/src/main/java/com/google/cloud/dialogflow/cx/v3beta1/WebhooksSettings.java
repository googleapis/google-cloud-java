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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.WebhooksClient.ListWebhooksPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.stub.WebhooksStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WebhooksClient}.
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
 * <p>For example, to set the total timeout of getWebhook to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WebhooksSettings.Builder webhooksSettingsBuilder = WebhooksSettings.newBuilder();
 * webhooksSettingsBuilder
 *     .getWebhookSettings()
 *     .setRetrySettings(
 *         webhooksSettingsBuilder.getWebhookSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WebhooksSettings webhooksSettings = webhooksSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WebhooksSettings extends ClientSettings<WebhooksSettings> {

  /** Returns the object with the settings used for calls to listWebhooks. */
  public PagedCallSettings<ListWebhooksRequest, ListWebhooksResponse, ListWebhooksPagedResponse>
      listWebhooksSettings() {
    return ((WebhooksStubSettings) getStubSettings()).listWebhooksSettings();
  }

  /** Returns the object with the settings used for calls to getWebhook. */
  public UnaryCallSettings<GetWebhookRequest, Webhook> getWebhookSettings() {
    return ((WebhooksStubSettings) getStubSettings()).getWebhookSettings();
  }

  /** Returns the object with the settings used for calls to createWebhook. */
  public UnaryCallSettings<CreateWebhookRequest, Webhook> createWebhookSettings() {
    return ((WebhooksStubSettings) getStubSettings()).createWebhookSettings();
  }

  /** Returns the object with the settings used for calls to updateWebhook. */
  public UnaryCallSettings<UpdateWebhookRequest, Webhook> updateWebhookSettings() {
    return ((WebhooksStubSettings) getStubSettings()).updateWebhookSettings();
  }

  /** Returns the object with the settings used for calls to deleteWebhook. */
  public UnaryCallSettings<DeleteWebhookRequest, Empty> deleteWebhookSettings() {
    return ((WebhooksStubSettings) getStubSettings()).deleteWebhookSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((WebhooksStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((WebhooksStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final WebhooksSettings create(WebhooksStubSettings stub) throws IOException {
    return new WebhooksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WebhooksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WebhooksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WebhooksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WebhooksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WebhooksStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return WebhooksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WebhooksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WebhooksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WebhooksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WebhooksSettings. */
  public static class Builder extends ClientSettings.Builder<WebhooksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WebhooksStubSettings.newBuilder(clientContext));
    }

    protected Builder(WebhooksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WebhooksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WebhooksStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(WebhooksStubSettings.newHttpJsonBuilder());
    }

    public WebhooksStubSettings.Builder getStubSettingsBuilder() {
      return ((WebhooksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listWebhooks. */
    public PagedCallSettings.Builder<
            ListWebhooksRequest, ListWebhooksResponse, ListWebhooksPagedResponse>
        listWebhooksSettings() {
      return getStubSettingsBuilder().listWebhooksSettings();
    }

    /** Returns the builder for the settings used for calls to getWebhook. */
    public UnaryCallSettings.Builder<GetWebhookRequest, Webhook> getWebhookSettings() {
      return getStubSettingsBuilder().getWebhookSettings();
    }

    /** Returns the builder for the settings used for calls to createWebhook. */
    public UnaryCallSettings.Builder<CreateWebhookRequest, Webhook> createWebhookSettings() {
      return getStubSettingsBuilder().createWebhookSettings();
    }

    /** Returns the builder for the settings used for calls to updateWebhook. */
    public UnaryCallSettings.Builder<UpdateWebhookRequest, Webhook> updateWebhookSettings() {
      return getStubSettingsBuilder().updateWebhookSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWebhook. */
    public UnaryCallSettings.Builder<DeleteWebhookRequest, Empty> deleteWebhookSettings() {
      return getStubSettingsBuilder().deleteWebhookSettings();
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
    public WebhooksSettings build() throws IOException {
      return new WebhooksSettings(this);
    }
  }
}
