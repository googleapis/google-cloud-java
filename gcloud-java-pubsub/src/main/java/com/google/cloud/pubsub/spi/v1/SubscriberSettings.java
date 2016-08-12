/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriberGrpc;
import com.google.pubsub.v1.Subscription;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SubscriberApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (pubsub.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of createSubscription to 30 seconds:
 *
 * <pre>
 * <code>
 * SubscriberSettings.Builder subscriberSettingsBuilder =
 *     SubscriberSettings.defaultBuilder();
 * subscriberSettingsBuilder.createSubscriptionSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * SubscriberSettings subscriberSettings = subscriberSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class SubscriberSettings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "pubsub.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  /**
   * The default connection settings of the service.
   */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final SimpleCallSettings<Subscription, Subscription> createSubscriptionSettings;
  private final SimpleCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings;
  private final PageStreamingCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      listSubscriptionsSettings;
  private final SimpleCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings;
  private final SimpleCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings;
  private final SimpleCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings;
  private final SimpleCallSettings<PullRequest, PullResponse> pullSettings;
  private final SimpleCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings;

  /**
   * Returns the object with the settings used for calls to createSubscription.
   */
  public SimpleCallSettings<Subscription, Subscription> createSubscriptionSettings() {
    return createSubscriptionSettings;
  }

  /**
   * Returns the object with the settings used for calls to getSubscription.
   */
  public SimpleCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return getSubscriptionSettings;
  }

  /**
   * Returns the object with the settings used for calls to listSubscriptions.
   */
  public PageStreamingCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteSubscription.
   */
  public SimpleCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  /**
   * Returns the object with the settings used for calls to modifyAckDeadline.
   */
  public SimpleCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
    return modifyAckDeadlineSettings;
  }

  /**
   * Returns the object with the settings used for calls to acknowledge.
   */
  public SimpleCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings() {
    return acknowledgeSettings;
  }

  /**
   * Returns the object with the settings used for calls to pull.
   */
  public SimpleCallSettings<PullRequest, PullResponse> pullSettings() {
    return pullSettings;
  }

  /**
   * Returns the object with the settings used for calls to modifyPushConfig.
   */
  public SimpleCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
    return modifyPushConfigSettings;
  }

  /**
   * Returns the default service address.
   */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /**
   * Returns the default service port.
   */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /**
   * Returns the default service scopes.
   */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /**
   * Returns a builder for this class with recommended defaults.
   */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private SubscriberSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    createSubscriptionSettings = settingsBuilder.createSubscriptionSettings().build();
    getSubscriptionSettings = settingsBuilder.getSubscriptionSettings().build();
    listSubscriptionsSettings = settingsBuilder.listSubscriptionsSettings().build();
    deleteSubscriptionSettings = settingsBuilder.deleteSubscriptionSettings().build();
    modifyAckDeadlineSettings = settingsBuilder.modifyAckDeadlineSettings().build();
    acknowledgeSettings = settingsBuilder.acknowledgeSettings().build();
    pullSettings = settingsBuilder.pullSettings().build();
    modifyPushConfigSettings = settingsBuilder.modifyPushConfigSettings().build();
  }

  private static PageStreamingDescriptor<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, Object token) {
              return ListSubscriptionsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public Object extractNextToken(ListSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscription> extractResources(ListSubscriptionsResponse payload) {
              return payload.getSubscriptionsList();
            }
          };

  /**
   * Builder for SubscriberSettings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private SimpleCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings;
    private SimpleCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings;
    private PageStreamingCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
        listSubscriptionsSettings;
    private SimpleCallSettings.Builder<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings;
    private SimpleCallSettings.Builder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings;
    private SimpleCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings;
    private SimpleCallSettings.Builder<PullRequest, PullResponse> pullSettings;
    private SimpleCallSettings.Builder<ModifyPushConfigRequest, Empty> modifyPushConfigSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(60000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(12000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(12000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("messaging", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(DEFAULT_CONNECTION_SETTINGS);

      createSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);

      getSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);

      listSubscriptionsSettings =
          PageStreamingCallSettings.newBuilder(
              SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS, LIST_SUBSCRIPTIONS_PAGE_STR_DESC);

      deleteSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);

      modifyAckDeadlineSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);

      acknowledgeSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_ACKNOWLEDGE);

      pullSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_PULL);

      modifyPushConfigSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              createSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              deleteSubscriptionSettings,
              modifyAckDeadlineSettings,
              acknowledgeSettings,
              pullSettings,
              modifyPushConfigSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .createSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .modifyAckDeadlineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .acknowledgeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .pullSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .modifyPushConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(SubscriberSettings settings) {
      super(settings);

      createSubscriptionSettings = settings.createSubscriptionSettings.toBuilder();
      getSubscriptionSettings = settings.getSubscriptionSettings.toBuilder();
      listSubscriptionsSettings = settings.listSubscriptionsSettings.toBuilder();
      deleteSubscriptionSettings = settings.deleteSubscriptionSettings.toBuilder();
      modifyAckDeadlineSettings = settings.modifyAckDeadlineSettings.toBuilder();
      acknowledgeSettings = settings.acknowledgeSettings.toBuilder();
      pullSettings = settings.pullSettings.toBuilder();
      modifyPushConfigSettings = settings.modifyPushConfigSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              createSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              deleteSubscriptionSettings,
              modifyAckDeadlineSettings,
              acknowledgeSettings,
              pullSettings,
              modifyPushConfigSettings);
    }

    @Override
    protected ConnectionSettings getDefaultConnectionSettings() {
      return DEFAULT_CONNECTION_SETTINGS;
    }

    @Override
    public Builder provideExecutorWith(ScheduledExecutorService executor, boolean shouldAutoClose) {
      super.provideExecutorWith(executor, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ManagedChannel channel, boolean shouldAutoClose) {
      super.provideChannelWith(channel, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ConnectionSettings settings) {
      super.provideChannelWith(settings);
      return this;
    }

    @Override
    public Builder provideChannelWith(Credentials credentials) {
      super.provideChannelWith(credentials);
      return this;
    }

    @Override
    public Builder provideChannelWith(List<String> scopes) {
      super.provideChannelWith(scopes);
      return this;
    }

    @Override
    public Builder setGeneratorHeader(String name, String version) {
      super.setGeneratorHeader(name, version);
      return this;
    }

    @Override
    public Builder setClientLibHeader(String name, String version) {
      super.setClientLibHeader(name, version);
      return this;
    }

    /**
     * Applies the given settings to all of the API methods in this service. Only
     * values that are non-null will be applied, so this method is not capable
     * of un-setting any values.
     */
    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to createSubscription.
     */
    public SimpleCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings() {
      return createSubscriptionSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getSubscription.
     */
    public SimpleCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getSubscriptionSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listSubscriptions.
     */
    public PageStreamingCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
        listSubscriptionsSettings() {
      return listSubscriptionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteSubscription.
     */
    public SimpleCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    /**
     * Returns the builder for the settings used for calls to modifyAckDeadline.
     */
    public SimpleCallSettings.Builder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
      return modifyAckDeadlineSettings;
    }

    /**
     * Returns the builder for the settings used for calls to acknowledge.
     */
    public SimpleCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings() {
      return acknowledgeSettings;
    }

    /**
     * Returns the builder for the settings used for calls to pull.
     */
    public SimpleCallSettings.Builder<PullRequest, PullResponse> pullSettings() {
      return pullSettings;
    }

    /**
     * Returns the builder for the settings used for calls to modifyPushConfig.
     */
    public SimpleCallSettings.Builder<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
      return modifyPushConfigSettings;
    }

    @Override
    public SubscriberSettings build() throws IOException {
      return new SubscriberSettings(this);
    }
  }
}
