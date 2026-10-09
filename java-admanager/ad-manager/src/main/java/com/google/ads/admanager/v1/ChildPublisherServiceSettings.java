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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ChildPublisherServiceClient.ListChildPublishersPagedResponse;

import com.google.ads.admanager.v1.stub.ChildPublisherServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ChildPublisherServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getChildPublisher:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChildPublisherServiceSettings.Builder childPublisherServiceSettingsBuilder =
 *     ChildPublisherServiceSettings.newBuilder();
 * childPublisherServiceSettingsBuilder
 *     .getChildPublisherSettings()
 *     .setRetrySettings(
 *         childPublisherServiceSettingsBuilder
 *             .getChildPublisherSettings()
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
 * ChildPublisherServiceSettings childPublisherServiceSettings =
 *     childPublisherServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ChildPublisherServiceSettings extends ClientSettings<ChildPublisherServiceSettings> {

  /** Returns the object with the settings used for calls to getChildPublisher. */
  public UnaryCallSettings<GetChildPublisherRequest, ChildPublisher> getChildPublisherSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings()).getChildPublisherSettings();
  }

  /** Returns the object with the settings used for calls to listChildPublishers. */
  public PagedCallSettings<
          ListChildPublishersRequest, ListChildPublishersResponse, ListChildPublishersPagedResponse>
      listChildPublishersSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings()).listChildPublishersSettings();
  }

  /** Returns the object with the settings used for calls to createChildPublisher. */
  public UnaryCallSettings<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings()).createChildPublisherSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateChildPublishers. */
  public UnaryCallSettings<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchCreateChildPublishersSettings();
  }

  /** Returns the object with the settings used for calls to updateChildPublisher. */
  public UnaryCallSettings<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings()).updateChildPublisherSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateChildPublishers. */
  public UnaryCallSettings<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchUpdateChildPublishersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * batchResendChildPublisherInvitationEmails.
   */
  public UnaryCallSettings<
          BatchResendChildPublisherInvitationEmailsRequest,
          BatchResendChildPublisherInvitationEmailsResponse>
      batchResendChildPublisherInvitationEmailsSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchResendChildPublisherInvitationEmailsSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * batchRenegotiateChildPublisherAgreements.
   */
  public UnaryCallSettings<
          BatchRenegotiateChildPublisherAgreementsRequest,
          BatchRenegotiateChildPublisherAgreementsResponse>
      batchRenegotiateChildPublisherAgreementsSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchRenegotiateChildPublisherAgreementsSettings();
  }

  /** Returns the object with the settings used for calls to batchRejectChildPublishers. */
  public UnaryCallSettings<BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
      batchRejectChildPublishersSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchRejectChildPublishersSettings();
  }

  /** Returns the object with the settings used for calls to batchWithdrawChildPublishers. */
  public UnaryCallSettings<
          BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
      batchWithdrawChildPublishersSettings() {
    return ((ChildPublisherServiceStubSettings) getStubSettings())
        .batchWithdrawChildPublishersSettings();
  }

  public static final ChildPublisherServiceSettings create(ChildPublisherServiceStubSettings stub)
      throws IOException {
    return new ChildPublisherServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ChildPublisherServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ChildPublisherServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ChildPublisherServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ChildPublisherServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ChildPublisherServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ChildPublisherServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ChildPublisherServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ChildPublisherServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ChildPublisherServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ChildPublisherServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ChildPublisherServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ChildPublisherServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ChildPublisherServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ChildPublisherServiceStubSettings.newBuilder());
    }

    public ChildPublisherServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ChildPublisherServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getChildPublisher. */
    public UnaryCallSettings.Builder<GetChildPublisherRequest, ChildPublisher>
        getChildPublisherSettings() {
      return getStubSettingsBuilder().getChildPublisherSettings();
    }

    /** Returns the builder for the settings used for calls to listChildPublishers. */
    public PagedCallSettings.Builder<
            ListChildPublishersRequest,
            ListChildPublishersResponse,
            ListChildPublishersPagedResponse>
        listChildPublishersSettings() {
      return getStubSettingsBuilder().listChildPublishersSettings();
    }

    /** Returns the builder for the settings used for calls to createChildPublisher. */
    public UnaryCallSettings.Builder<CreateChildPublisherRequest, ChildPublisher>
        createChildPublisherSettings() {
      return getStubSettingsBuilder().createChildPublisherSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
        batchCreateChildPublishersSettings() {
      return getStubSettingsBuilder().batchCreateChildPublishersSettings();
    }

    /** Returns the builder for the settings used for calls to updateChildPublisher. */
    public UnaryCallSettings.Builder<UpdateChildPublisherRequest, ChildPublisher>
        updateChildPublisherSettings() {
      return getStubSettingsBuilder().updateChildPublisherSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
        batchUpdateChildPublishersSettings() {
      return getStubSettingsBuilder().batchUpdateChildPublishersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchResendChildPublisherInvitationEmails.
     */
    public UnaryCallSettings.Builder<
            BatchResendChildPublisherInvitationEmailsRequest,
            BatchResendChildPublisherInvitationEmailsResponse>
        batchResendChildPublisherInvitationEmailsSettings() {
      return getStubSettingsBuilder().batchResendChildPublisherInvitationEmailsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchRenegotiateChildPublisherAgreements.
     */
    public UnaryCallSettings.Builder<
            BatchRenegotiateChildPublisherAgreementsRequest,
            BatchRenegotiateChildPublisherAgreementsResponse>
        batchRenegotiateChildPublisherAgreementsSettings() {
      return getStubSettingsBuilder().batchRenegotiateChildPublisherAgreementsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRejectChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchRejectChildPublishersRequest, BatchRejectChildPublishersResponse>
        batchRejectChildPublishersSettings() {
      return getStubSettingsBuilder().batchRejectChildPublishersSettings();
    }

    /** Returns the builder for the settings used for calls to batchWithdrawChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchWithdrawChildPublishersRequest, BatchWithdrawChildPublishersResponse>
        batchWithdrawChildPublishersSettings() {
      return getStubSettingsBuilder().batchWithdrawChildPublishersSettings();
    }

    @Override
    public ChildPublisherServiceSettings build() throws IOException {
      return new ChildPublisherServiceSettings(this);
    }
  }
}
