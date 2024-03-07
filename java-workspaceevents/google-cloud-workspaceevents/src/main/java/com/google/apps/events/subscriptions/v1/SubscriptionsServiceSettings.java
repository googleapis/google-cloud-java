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

package com.google.apps.events.subscriptions.v1;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.apps.events.subscriptions.v1.stub.SubscriptionsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SubscriptionsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workspaceevents.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getSubscription to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SubscriptionsServiceSettings.Builder subscriptionsServiceSettingsBuilder =
 *     SubscriptionsServiceSettings.newBuilder();
 * subscriptionsServiceSettingsBuilder
 *     .getSubscriptionSettings()
 *     .setRetrySettings(
 *         subscriptionsServiceSettingsBuilder
 *             .getSubscriptionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SubscriptionsServiceSettings subscriptionsServiceSettings =
 *     subscriptionsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SubscriptionsServiceSettings extends ClientSettings<SubscriptionsServiceSettings> {

  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<CreateSubscriptionRequest, Operation> createSubscriptionSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).createSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to createSubscription. */
  public OperationCallSettings<CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings())
        .createSubscriptionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).deleteSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public OperationCallSettings<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings())
        .deleteSubscriptionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).getSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).listSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Operation> updateSubscriptionSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).updateSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public OperationCallSettings<UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings())
        .updateSubscriptionOperationSettings();
  }

  /** Returns the object with the settings used for calls to reactivateSubscription. */
  public UnaryCallSettings<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings()).reactivateSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to reactivateSubscription. */
  public OperationCallSettings<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationSettings() {
    return ((SubscriptionsServiceStubSettings) getStubSettings())
        .reactivateSubscriptionOperationSettings();
  }

  public static final SubscriptionsServiceSettings create(SubscriptionsServiceStubSettings stub)
      throws IOException {
    return new SubscriptionsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SubscriptionsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SubscriptionsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SubscriptionsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SubscriptionsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SubscriptionsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SubscriptionsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SubscriptionsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SubscriptionsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SubscriptionsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SubscriptionsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SubscriptionsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SubscriptionsServiceStubSettings.newHttpJsonBuilder());
    }

    public SubscriptionsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SubscriptionsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<CreateSubscriptionRequest, Operation>
        createSubscriptionSettings() {
      return getStubSettingsBuilder().createSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public OperationCallSettings.Builder<
            CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
        createSubscriptionOperationSettings() {
      return getStubSettingsBuilder().createSubscriptionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings() {
      return getStubSettingsBuilder().deleteSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public OperationCallSettings.Builder<
            DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
        deleteSubscriptionOperationSettings() {
      return getStubSettingsBuilder().deleteSubscriptionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getStubSettingsBuilder().getSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return getStubSettingsBuilder().listSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Operation>
        updateSubscriptionSettings() {
      return getStubSettingsBuilder().updateSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public OperationCallSettings.Builder<
            UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
        updateSubscriptionOperationSettings() {
      return getStubSettingsBuilder().updateSubscriptionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reactivateSubscription. */
    public UnaryCallSettings.Builder<ReactivateSubscriptionRequest, Operation>
        reactivateSubscriptionSettings() {
      return getStubSettingsBuilder().reactivateSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to reactivateSubscription. */
    public OperationCallSettings.Builder<
            ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
        reactivateSubscriptionOperationSettings() {
      return getStubSettingsBuilder().reactivateSubscriptionOperationSettings();
    }

    @Override
    public SubscriptionsServiceSettings build() throws IOException {
      return new SubscriptionsServiceSettings(this);
    }
  }
}
