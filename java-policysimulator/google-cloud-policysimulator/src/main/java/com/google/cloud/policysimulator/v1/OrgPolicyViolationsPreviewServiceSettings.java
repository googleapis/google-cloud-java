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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

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
import com.google.cloud.policysimulator.v1.stub.OrgPolicyViolationsPreviewServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrgPolicyViolationsPreviewServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (policysimulator.googleapis.com) and default port (443) are
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
 * of getOrgPolicyViolationsPreview:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicyViolationsPreviewServiceSettings.Builder
 *     orgPolicyViolationsPreviewServiceSettingsBuilder =
 *         OrgPolicyViolationsPreviewServiceSettings.newBuilder();
 * orgPolicyViolationsPreviewServiceSettingsBuilder
 *     .getOrgPolicyViolationsPreviewSettings()
 *     .setRetrySettings(
 *         orgPolicyViolationsPreviewServiceSettingsBuilder
 *             .getOrgPolicyViolationsPreviewSettings()
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
 * OrgPolicyViolationsPreviewServiceSettings orgPolicyViolationsPreviewServiceSettings =
 *     orgPolicyViolationsPreviewServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createOrgPolicyViolationsPreview:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicyViolationsPreviewServiceSettings.Builder
 *     orgPolicyViolationsPreviewServiceSettingsBuilder =
 *         OrgPolicyViolationsPreviewServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * orgPolicyViolationsPreviewServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrgPolicyViolationsPreviewServiceSettings
    extends ClientSettings<OrgPolicyViolationsPreviewServiceSettings> {

  /** Returns the object with the settings used for calls to listOrgPolicyViolationsPreviews. */
  public PagedCallSettings<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsSettings() {
    return ((OrgPolicyViolationsPreviewServiceStubSettings) getStubSettings())
        .listOrgPolicyViolationsPreviewsSettings();
  }

  /** Returns the object with the settings used for calls to getOrgPolicyViolationsPreview. */
  public UnaryCallSettings<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewSettings() {
    return ((OrgPolicyViolationsPreviewServiceStubSettings) getStubSettings())
        .getOrgPolicyViolationsPreviewSettings();
  }

  /** Returns the object with the settings used for calls to createOrgPolicyViolationsPreview. */
  public UnaryCallSettings<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewSettings() {
    return ((OrgPolicyViolationsPreviewServiceStubSettings) getStubSettings())
        .createOrgPolicyViolationsPreviewSettings();
  }

  /** Returns the object with the settings used for calls to createOrgPolicyViolationsPreview. */
  public OperationCallSettings<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationSettings() {
    return ((OrgPolicyViolationsPreviewServiceStubSettings) getStubSettings())
        .createOrgPolicyViolationsPreviewOperationSettings();
  }

  /** Returns the object with the settings used for calls to listOrgPolicyViolations. */
  public PagedCallSettings<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsSettings() {
    return ((OrgPolicyViolationsPreviewServiceStubSettings) getStubSettings())
        .listOrgPolicyViolationsSettings();
  }

  public static final OrgPolicyViolationsPreviewServiceSettings create(
      OrgPolicyViolationsPreviewServiceStubSettings stub) throws IOException {
    return new OrgPolicyViolationsPreviewServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrgPolicyViolationsPreviewServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrgPolicyViolationsPreviewServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrgPolicyViolationsPreviewServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OrgPolicyViolationsPreviewServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrgPolicyViolationsPreviewServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<OrgPolicyViolationsPreviewServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OrgPolicyViolationsPreviewServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrgPolicyViolationsPreviewServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrgPolicyViolationsPreviewServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrgPolicyViolationsPreviewServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(OrgPolicyViolationsPreviewServiceStubSettings.newHttpJsonBuilder());
    }

    public OrgPolicyViolationsPreviewServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OrgPolicyViolationsPreviewServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listOrgPolicyViolationsPreviews. */
    public PagedCallSettings.Builder<
            ListOrgPolicyViolationsPreviewsRequest,
            ListOrgPolicyViolationsPreviewsResponse,
            ListOrgPolicyViolationsPreviewsPagedResponse>
        listOrgPolicyViolationsPreviewsSettings() {
      return getStubSettingsBuilder().listOrgPolicyViolationsPreviewsSettings();
    }

    /** Returns the builder for the settings used for calls to getOrgPolicyViolationsPreview. */
    public UnaryCallSettings.Builder<
            GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreviewSettings() {
      return getStubSettingsBuilder().getOrgPolicyViolationsPreviewSettings();
    }

    /** Returns the builder for the settings used for calls to createOrgPolicyViolationsPreview. */
    public UnaryCallSettings.Builder<CreateOrgPolicyViolationsPreviewRequest, Operation>
        createOrgPolicyViolationsPreviewSettings() {
      return getStubSettingsBuilder().createOrgPolicyViolationsPreviewSettings();
    }

    /** Returns the builder for the settings used for calls to createOrgPolicyViolationsPreview. */
    public OperationCallSettings.Builder<
            CreateOrgPolicyViolationsPreviewRequest,
            OrgPolicyViolationsPreview,
            CreateOrgPolicyViolationsPreviewOperationMetadata>
        createOrgPolicyViolationsPreviewOperationSettings() {
      return getStubSettingsBuilder().createOrgPolicyViolationsPreviewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listOrgPolicyViolations. */
    public PagedCallSettings.Builder<
            ListOrgPolicyViolationsRequest,
            ListOrgPolicyViolationsResponse,
            ListOrgPolicyViolationsPagedResponse>
        listOrgPolicyViolationsSettings() {
      return getStubSettingsBuilder().listOrgPolicyViolationsSettings();
    }

    @Override
    public OrgPolicyViolationsPreviewServiceSettings build() throws IOException {
      return new OrgPolicyViolationsPreviewServiceSettings(this);
    }
  }
}
