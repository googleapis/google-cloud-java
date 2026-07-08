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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

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
import com.google.cloud.support.v2.stub.SupportEventSubscriptionServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SupportEventSubscriptionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsupport.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSupportEventSubscription:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SupportEventSubscriptionServiceSettings.Builder supportEventSubscriptionServiceSettingsBuilder =
 *     SupportEventSubscriptionServiceSettings.newBuilder();
 * supportEventSubscriptionServiceSettingsBuilder
 *     .createSupportEventSubscriptionSettings()
 *     .setRetrySettings(
 *         supportEventSubscriptionServiceSettingsBuilder
 *             .createSupportEventSubscriptionSettings()
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
 * SupportEventSubscriptionServiceSettings supportEventSubscriptionServiceSettings =
 *     supportEventSubscriptionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class SupportEventSubscriptionServiceSettings
    extends ClientSettings<SupportEventSubscriptionServiceSettings> {

  /** Returns the object with the settings used for calls to createSupportEventSubscription. */
  public UnaryCallSettings<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .createSupportEventSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to getSupportEventSubscription. */
  public UnaryCallSettings<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .getSupportEventSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to listSupportEventSubscriptions. */
  public PagedCallSettings<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .listSupportEventSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to updateSupportEventSubscription. */
  public UnaryCallSettings<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .updateSupportEventSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSupportEventSubscription. */
  public UnaryCallSettings<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .deleteSupportEventSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to undeleteSupportEventSubscription. */
  public UnaryCallSettings<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionSettings() {
    return ((SupportEventSubscriptionServiceStubSettings) getStubSettings())
        .undeleteSupportEventSubscriptionSettings();
  }

  public static final SupportEventSubscriptionServiceSettings create(
      SupportEventSubscriptionServiceStubSettings stub) throws IOException {
    return new SupportEventSubscriptionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SupportEventSubscriptionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SupportEventSubscriptionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SupportEventSubscriptionServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SupportEventSubscriptionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SupportEventSubscriptionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SupportEventSubscriptionServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SupportEventSubscriptionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SupportEventSubscriptionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SupportEventSubscriptionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SupportEventSubscriptionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SupportEventSubscriptionServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SupportEventSubscriptionServiceStubSettings.newHttpJsonBuilder());
    }

    public SupportEventSubscriptionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SupportEventSubscriptionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            CreateSupportEventSubscriptionRequest, SupportEventSubscription>
        createSupportEventSubscriptionSettings() {
      return getStubSettingsBuilder().createSupportEventSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to getSupportEventSubscription. */
    public UnaryCallSettings.Builder<GetSupportEventSubscriptionRequest, SupportEventSubscription>
        getSupportEventSubscriptionSettings() {
      return getStubSettingsBuilder().getSupportEventSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to listSupportEventSubscriptions. */
    public PagedCallSettings.Builder<
            ListSupportEventSubscriptionsRequest,
            ListSupportEventSubscriptionsResponse,
            ListSupportEventSubscriptionsPagedResponse>
        listSupportEventSubscriptionsSettings() {
      return getStubSettingsBuilder().listSupportEventSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
        updateSupportEventSubscriptionSettings() {
      return getStubSettingsBuilder().updateSupportEventSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        deleteSupportEventSubscriptionSettings() {
      return getStubSettingsBuilder().deleteSupportEventSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteSupportEventSubscription. */
    public UnaryCallSettings.Builder<
            UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        undeleteSupportEventSubscriptionSettings() {
      return getStubSettingsBuilder().undeleteSupportEventSubscriptionSettings();
    }

    @Override
    public SupportEventSubscriptionServiceSettings build() throws IOException {
      return new SupportEventSubscriptionServiceSettings(this);
    }
  }
}
