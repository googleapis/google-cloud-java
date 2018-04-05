/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSubscriptionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SubscriptionAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (pubsub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createSubscription to 30 seconds:
 *
 * <pre>
 * <code>
 * SubscriptionAdminSettings.Builder subscriptionAdminSettingsBuilder =
 *     SubscriptionAdminSettings.newBuilder();
 * subscriptionAdminSettingsBuilder.createSubscriptionSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SubscriptionAdminSettings subscriptionAdminSettings = subscriptionAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class SubscriptionAdminSettings extends ClientSettings<SubscriptionAdminSettings> {
  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<Subscription, Subscription> createSubscriptionSettings() {
    return ((SubscriberStubSettings) getStubSettings()).createSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return ((SubscriberStubSettings) getStubSettings()).getSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionSettings() {
    return ((SubscriberStubSettings) getStubSettings()).updateSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return ((SubscriberStubSettings) getStubSettings()).listSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return ((SubscriberStubSettings) getStubSettings()).deleteSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to modifyAckDeadline. */
  /* package-private */ UnaryCallSettings<ModifyAckDeadlineRequest, Empty>
      modifyAckDeadlineSettings() {
    return ((SubscriberStubSettings) getStubSettings()).modifyAckDeadlineSettings();
  }

  /** Returns the object with the settings used for calls to acknowledge. */
  /* package-private */ UnaryCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings() {
    return ((SubscriberStubSettings) getStubSettings()).acknowledgeSettings();
  }

  /** Returns the object with the settings used for calls to pull. */
  /* package-private */ UnaryCallSettings<PullRequest, PullResponse> pullSettings() {
    return ((SubscriberStubSettings) getStubSettings()).pullSettings();
  }

  /** Returns the object with the settings used for calls to streamingPull. */
  /* package-private */ StreamingCallSettings<StreamingPullRequest, StreamingPullResponse>
      streamingPullSettings() {
    return ((SubscriberStubSettings) getStubSettings()).streamingPullSettings();
  }

  /** Returns the object with the settings used for calls to modifyPushConfig. */
  public UnaryCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
    return ((SubscriberStubSettings) getStubSettings()).modifyPushConfigSettings();
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return ((SubscriberStubSettings) getStubSettings()).listSnapshotsSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
    return ((SubscriberStubSettings) getStubSettings()).createSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public UnaryCallSettings<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings() {
    return ((SubscriberStubSettings) getStubSettings()).updateSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
    return ((SubscriberStubSettings) getStubSettings()).deleteSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to seek. */
  public UnaryCallSettings<SeekRequest, SeekResponse> seekSettings() {
    return ((SubscriberStubSettings) getStubSettings()).seekSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SubscriberStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SubscriberStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SubscriberStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SubscriptionAdminSettings create(SubscriberStubSettings stub)
      throws IOException {
    return new SubscriptionAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SubscriberStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SubscriberStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SubscriberStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SubscriberStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SubscriberStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SubscriberStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SubscriberStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected SubscriptionAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SubscriptionAdminSettings. */
  public static class Builder extends ClientSettings.Builder<SubscriptionAdminSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SubscriberStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SubscriberStubSettings.newBuilder());
    }

    protected Builder(SubscriptionAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SubscriberStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SubscriberStubSettings.Builder getStubSettingsBuilder() {
      return ((SubscriberStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings() {
      return getStubSettingsBuilder().createSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getStubSettingsBuilder().getSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings() {
      return getStubSettingsBuilder().updateSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return getStubSettingsBuilder().listSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return getStubSettingsBuilder().deleteSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to modifyAckDeadline. */
    /* package-private */ UnaryCallSettings.Builder<ModifyAckDeadlineRequest, Empty>
        modifyAckDeadlineSettings() {
      return getStubSettingsBuilder().modifyAckDeadlineSettings();
    }

    /** Returns the builder for the settings used for calls to acknowledge. */
    /* package-private */ UnaryCallSettings.Builder<AcknowledgeRequest, Empty>
        acknowledgeSettings() {
      return getStubSettingsBuilder().acknowledgeSettings();
    }

    /** Returns the builder for the settings used for calls to pull. */
    /* package-private */ UnaryCallSettings.Builder<PullRequest, PullResponse> pullSettings() {
      return getStubSettingsBuilder().pullSettings();
    }

    /** Returns the builder for the settings used for calls to streamingPull. */
    /* package-private */ StreamingCallSettings.Builder<StreamingPullRequest, StreamingPullResponse>
        streamingPullSettings() {
      return getStubSettingsBuilder().streamingPullSettings();
    }

    /** Returns the builder for the settings used for calls to modifyPushConfig. */
    public UnaryCallSettings.Builder<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
      return getStubSettingsBuilder().modifyPushConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return getStubSettingsBuilder().listSnapshotsSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
      return getStubSettingsBuilder().createSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public UnaryCallSettings.Builder<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings() {
      return getStubSettingsBuilder().updateSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
      return getStubSettingsBuilder().deleteSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to seek. */
    public UnaryCallSettings.Builder<SeekRequest, SeekResponse> seekSettings() {
      return getStubSettingsBuilder().seekSettings();
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
    public SubscriptionAdminSettings build() throws IOException {
      return new SubscriptionAdminSettings(this);
    }
  }
}
