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

package com.google.devicesandservices.health.v4;

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;
import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.devicesandservices.health.v4.stub.DataSubscriptionServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataSubscriptionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (health.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSubscription:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSubscriptionServiceSettings.Builder dataSubscriptionServiceSettingsBuilder =
 *     DataSubscriptionServiceSettings.newBuilder();
 * dataSubscriptionServiceSettingsBuilder
 *     .createSubscriptionSettings()
 *     .setRetrySettings(
 *         dataSubscriptionServiceSettingsBuilder
 *             .createSubscriptionSettings()
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
 * DataSubscriptionServiceSettings dataSubscriptionServiceSettings =
 *     dataSubscriptionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSubscriber:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSubscriptionServiceSettings.Builder dataSubscriptionServiceSettingsBuilder =
 *     DataSubscriptionServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataSubscriptionServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataSubscriptionServiceSettings
    extends ClientSettings<DataSubscriptionServiceSettings> {

  /** Returns the object with the settings used for calls to createSubscriber. */
  public UnaryCallSettings<CreateSubscriberRequest, Operation> createSubscriberSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).createSubscriberSettings();
  }

  /** Returns the object with the settings used for calls to createSubscriber. */
  public OperationCallSettings<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings())
        .createSubscriberOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSubscribers. */
  public PagedCallSettings<
          ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
      listSubscribersSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).listSubscribersSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscriber. */
  public UnaryCallSettings<UpdateSubscriberRequest, Operation> updateSubscriberSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).updateSubscriberSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscriber. */
  public OperationCallSettings<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings())
        .updateSubscriberOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscriber. */
  public UnaryCallSettings<DeleteSubscriberRequest, Operation> deleteSubscriberSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).deleteSubscriberSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscriber. */
  public OperationCallSettings<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings())
        .deleteSubscriberOperationSettings();
  }

  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<CreateSubscriptionRequest, Subscription> createSubscriptionSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).createSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).listSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).updateSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return ((DataSubscriptionServiceStubSettings) getStubSettings()).deleteSubscriptionSettings();
  }

  public static final DataSubscriptionServiceSettings create(
      DataSubscriptionServiceStubSettings stub) throws IOException {
    return new DataSubscriptionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataSubscriptionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataSubscriptionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataSubscriptionServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataSubscriptionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataSubscriptionServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DataSubscriptionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataSubscriptionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataSubscriptionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataSubscriptionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataSubscriptionServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataSubscriptionServiceStubSettings.newHttpJsonBuilder());
    }

    public DataSubscriptionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataSubscriptionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSubscriber. */
    public UnaryCallSettings.Builder<CreateSubscriberRequest, Operation>
        createSubscriberSettings() {
      return getStubSettingsBuilder().createSubscriberSettings();
    }

    /** Returns the builder for the settings used for calls to createSubscriber. */
    public OperationCallSettings.Builder<
            CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
        createSubscriberOperationSettings() {
      return getStubSettingsBuilder().createSubscriberOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscribers. */
    public PagedCallSettings.Builder<
            ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
        listSubscribersSettings() {
      return getStubSettingsBuilder().listSubscribersSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscriber. */
    public UnaryCallSettings.Builder<UpdateSubscriberRequest, Operation>
        updateSubscriberSettings() {
      return getStubSettingsBuilder().updateSubscriberSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscriber. */
    public OperationCallSettings.Builder<
            UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
        updateSubscriberOperationSettings() {
      return getStubSettingsBuilder().updateSubscriberOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscriber. */
    public UnaryCallSettings.Builder<DeleteSubscriberRequest, Operation>
        deleteSubscriberSettings() {
      return getStubSettingsBuilder().deleteSubscriberSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscriber. */
    public OperationCallSettings.Builder<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
        deleteSubscriberOperationSettings() {
      return getStubSettingsBuilder().deleteSubscriberOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<CreateSubscriptionRequest, Subscription>
        createSubscriptionSettings() {
      return getStubSettingsBuilder().createSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return getStubSettingsBuilder().listSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings() {
      return getStubSettingsBuilder().updateSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return getStubSettingsBuilder().deleteSubscriptionSettings();
    }

    @Override
    public DataSubscriptionServiceSettings build() throws IOException {
      return new DataSubscriptionServiceSettings(this);
    }
  }
}
