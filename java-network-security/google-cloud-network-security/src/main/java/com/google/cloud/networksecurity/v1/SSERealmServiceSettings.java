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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACAttachmentsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACRealmsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.stub.SSERealmServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SSERealmServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSACRealm:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SSERealmServiceSettings.Builder sSERealmServiceSettingsBuilder =
 *     SSERealmServiceSettings.newBuilder();
 * sSERealmServiceSettingsBuilder
 *     .getSACRealmSettings()
 *     .setRetrySettings(
 *         sSERealmServiceSettingsBuilder
 *             .getSACRealmSettings()
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
 * SSERealmServiceSettings sSERealmServiceSettings = sSERealmServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSACRealm:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SSERealmServiceSettings.Builder sSERealmServiceSettingsBuilder =
 *     SSERealmServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * sSERealmServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SSERealmServiceSettings extends ClientSettings<SSERealmServiceSettings> {

  /** Returns the object with the settings used for calls to listSACRealms. */
  public PagedCallSettings<ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
      listSACRealmsSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).listSACRealmsSettings();
  }

  /** Returns the object with the settings used for calls to getSACRealm. */
  public UnaryCallSettings<GetSACRealmRequest, SACRealm> getSACRealmSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).getSACRealmSettings();
  }

  /** Returns the object with the settings used for calls to createSACRealm. */
  public UnaryCallSettings<CreateSACRealmRequest, Operation> createSACRealmSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).createSACRealmSettings();
  }

  /** Returns the object with the settings used for calls to createSACRealm. */
  public OperationCallSettings<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).createSACRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSACRealm. */
  public UnaryCallSettings<DeleteSACRealmRequest, Operation> deleteSACRealmSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).deleteSACRealmSettings();
  }

  /** Returns the object with the settings used for calls to deleteSACRealm. */
  public OperationCallSettings<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).deleteSACRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSACAttachments. */
  public PagedCallSettings<
          ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
      listSACAttachmentsSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).listSACAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to getSACAttachment. */
  public UnaryCallSettings<GetSACAttachmentRequest, SACAttachment> getSACAttachmentSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).getSACAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to createSACAttachment. */
  public UnaryCallSettings<CreateSACAttachmentRequest, Operation> createSACAttachmentSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).createSACAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to createSACAttachment. */
  public OperationCallSettings<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).createSACAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSACAttachment. */
  public UnaryCallSettings<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).deleteSACAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteSACAttachment. */
  public OperationCallSettings<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).deleteSACAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SSERealmServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SSERealmServiceSettings create(SSERealmServiceStubSettings stub)
      throws IOException {
    return new SSERealmServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SSERealmServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SSERealmServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SSERealmServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SSERealmServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SSERealmServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SSERealmServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SSERealmServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SSERealmServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SSERealmServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SSERealmServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(SSERealmServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SSERealmServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SSERealmServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SSERealmServiceStubSettings.newBuilder());
    }

    public SSERealmServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SSERealmServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listSACRealms. */
    public PagedCallSettings.Builder<
            ListSACRealmsRequest, ListSACRealmsResponse, ListSACRealmsPagedResponse>
        listSACRealmsSettings() {
      return getStubSettingsBuilder().listSACRealmsSettings();
    }

    /** Returns the builder for the settings used for calls to getSACRealm. */
    public UnaryCallSettings.Builder<GetSACRealmRequest, SACRealm> getSACRealmSettings() {
      return getStubSettingsBuilder().getSACRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createSACRealm. */
    public UnaryCallSettings.Builder<CreateSACRealmRequest, Operation> createSACRealmSettings() {
      return getStubSettingsBuilder().createSACRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createSACRealm. */
    public OperationCallSettings.Builder<CreateSACRealmRequest, SACRealm, OperationMetadata>
        createSACRealmOperationSettings() {
      return getStubSettingsBuilder().createSACRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSACRealm. */
    public UnaryCallSettings.Builder<DeleteSACRealmRequest, Operation> deleteSACRealmSettings() {
      return getStubSettingsBuilder().deleteSACRealmSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSACRealm. */
    public OperationCallSettings.Builder<DeleteSACRealmRequest, Empty, OperationMetadata>
        deleteSACRealmOperationSettings() {
      return getStubSettingsBuilder().deleteSACRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSACAttachments. */
    public PagedCallSettings.Builder<
            ListSACAttachmentsRequest, ListSACAttachmentsResponse, ListSACAttachmentsPagedResponse>
        listSACAttachmentsSettings() {
      return getStubSettingsBuilder().listSACAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to getSACAttachment. */
    public UnaryCallSettings.Builder<GetSACAttachmentRequest, SACAttachment>
        getSACAttachmentSettings() {
      return getStubSettingsBuilder().getSACAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to createSACAttachment. */
    public UnaryCallSettings.Builder<CreateSACAttachmentRequest, Operation>
        createSACAttachmentSettings() {
      return getStubSettingsBuilder().createSACAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to createSACAttachment. */
    public OperationCallSettings.Builder<
            CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
        createSACAttachmentOperationSettings() {
      return getStubSettingsBuilder().createSACAttachmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSACAttachment. */
    public UnaryCallSettings.Builder<DeleteSACAttachmentRequest, Operation>
        deleteSACAttachmentSettings() {
      return getStubSettingsBuilder().deleteSACAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSACAttachment. */
    public OperationCallSettings.Builder<DeleteSACAttachmentRequest, Empty, OperationMetadata>
        deleteSACAttachmentOperationSettings() {
      return getStubSettingsBuilder().deleteSACAttachmentOperationSettings();
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
    public SSERealmServiceSettings build() throws IOException {
      return new SSERealmServiceSettings(this);
    }
  }
}
