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

package com.google.showcase.v1beta1;

import static com.google.showcase.v1beta1.EchoClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandLegacyMappedPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EchoClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (localhost) and default port (7469) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of echo:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EchoSettings.Builder echoSettingsBuilder = EchoSettings.newBuilder();
 * echoSettingsBuilder
 *     .echoSettings()
 *     .setRetrySettings(
 *         echoSettingsBuilder
 *             .echoSettings()
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
 * EchoSettings echoSettings = echoSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for wait:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EchoSettings.Builder echoSettingsBuilder = EchoSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * echoSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EchoSettings extends ClientSettings<EchoSettings> {

  /** Returns the object with the settings used for calls to echo. */
  public UnaryCallSettings<EchoRequest, EchoResponse> echoSettings() {
    return ((EchoStubSettings) getStubSettings()).echoSettings();
  }

  /** Returns the object with the settings used for calls to echoErrorDetails. */
  public UnaryCallSettings<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsSettings() {
    return ((EchoStubSettings) getStubSettings()).echoErrorDetailsSettings();
  }

  /** Returns the object with the settings used for calls to failEchoWithDetails. */
  public UnaryCallSettings<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsSettings() {
    return ((EchoStubSettings) getStubSettings()).failEchoWithDetailsSettings();
  }

  /** Returns the object with the settings used for calls to expand. */
  public ServerStreamingCallSettings<ExpandRequest, EchoResponse> expandSettings() {
    return ((EchoStubSettings) getStubSettings()).expandSettings();
  }

  /** Returns the object with the settings used for calls to collect. */
  public StreamingCallSettings<EchoRequest, EchoResponse> collectSettings() {
    return ((EchoStubSettings) getStubSettings()).collectSettings();
  }

  /** Returns the object with the settings used for calls to chat. */
  public StreamingCallSettings<EchoRequest, EchoResponse> chatSettings() {
    return ((EchoStubSettings) getStubSettings()).chatSettings();
  }

  /** Returns the object with the settings used for calls to pagedExpand. */
  public PagedCallSettings<PagedExpandRequest, PagedExpandResponse, PagedExpandPagedResponse>
      pagedExpandSettings() {
    return ((EchoStubSettings) getStubSettings()).pagedExpandSettings();
  }

  /** Returns the object with the settings used for calls to pagedExpandLegacy. */
  public UnaryCallSettings<PagedExpandLegacyRequest, PagedExpandResponse>
      pagedExpandLegacySettings() {
    return ((EchoStubSettings) getStubSettings()).pagedExpandLegacySettings();
  }

  /** Returns the object with the settings used for calls to pagedExpandLegacyMapped. */
  public PagedCallSettings<
          PagedExpandRequest, PagedExpandLegacyMappedResponse, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedSettings() {
    return ((EchoStubSettings) getStubSettings()).pagedExpandLegacyMappedSettings();
  }

  /** Returns the object with the settings used for calls to wait. */
  public UnaryCallSettings<WaitRequest, Operation> waitSettings() {
    return ((EchoStubSettings) getStubSettings()).waitSettings();
  }

  /** Returns the object with the settings used for calls to wait. */
  public OperationCallSettings<WaitRequest, WaitResponse, WaitMetadata> waitOperationSettings() {
    return ((EchoStubSettings) getStubSettings()).waitOperationSettings();
  }

  /** Returns the object with the settings used for calls to block. */
  public UnaryCallSettings<BlockRequest, BlockResponse> blockSettings() {
    return ((EchoStubSettings) getStubSettings()).blockSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((EchoStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((EchoStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((EchoStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((EchoStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((EchoStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final EchoSettings create(EchoStubSettings stub) throws IOException {
    return new EchoSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EchoStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EchoStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EchoStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EchoStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EchoStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EchoStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EchoStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EchoStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EchoSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EchoSettings. */
  public static class Builder extends ClientSettings.Builder<EchoSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EchoStubSettings.newBuilder(clientContext));
    }

    protected Builder(EchoSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EchoStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EchoStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(EchoStubSettings.newHttpJsonBuilder());
    }

    public EchoStubSettings.Builder getStubSettingsBuilder() {
      return ((EchoStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to echo. */
    public UnaryCallSettings.Builder<EchoRequest, EchoResponse> echoSettings() {
      return getStubSettingsBuilder().echoSettings();
    }

    /** Returns the builder for the settings used for calls to echoErrorDetails. */
    public UnaryCallSettings.Builder<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
        echoErrorDetailsSettings() {
      return getStubSettingsBuilder().echoErrorDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to failEchoWithDetails. */
    public UnaryCallSettings.Builder<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
        failEchoWithDetailsSettings() {
      return getStubSettingsBuilder().failEchoWithDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to expand. */
    public ServerStreamingCallSettings.Builder<ExpandRequest, EchoResponse> expandSettings() {
      return getStubSettingsBuilder().expandSettings();
    }

    /** Returns the builder for the settings used for calls to collect. */
    public StreamingCallSettings.Builder<EchoRequest, EchoResponse> collectSettings() {
      return getStubSettingsBuilder().collectSettings();
    }

    /** Returns the builder for the settings used for calls to chat. */
    public StreamingCallSettings.Builder<EchoRequest, EchoResponse> chatSettings() {
      return getStubSettingsBuilder().chatSettings();
    }

    /** Returns the builder for the settings used for calls to pagedExpand. */
    public PagedCallSettings.Builder<
            PagedExpandRequest, PagedExpandResponse, PagedExpandPagedResponse>
        pagedExpandSettings() {
      return getStubSettingsBuilder().pagedExpandSettings();
    }

    /** Returns the builder for the settings used for calls to pagedExpandLegacy. */
    public UnaryCallSettings.Builder<PagedExpandLegacyRequest, PagedExpandResponse>
        pagedExpandLegacySettings() {
      return getStubSettingsBuilder().pagedExpandLegacySettings();
    }

    /** Returns the builder for the settings used for calls to pagedExpandLegacyMapped. */
    public PagedCallSettings.Builder<
            PagedExpandRequest,
            PagedExpandLegacyMappedResponse,
            PagedExpandLegacyMappedPagedResponse>
        pagedExpandLegacyMappedSettings() {
      return getStubSettingsBuilder().pagedExpandLegacyMappedSettings();
    }

    /** Returns the builder for the settings used for calls to wait. */
    public UnaryCallSettings.Builder<WaitRequest, Operation> waitSettings() {
      return getStubSettingsBuilder().waitSettings();
    }

    /** Returns the builder for the settings used for calls to wait. */
    public OperationCallSettings.Builder<WaitRequest, WaitResponse, WaitMetadata>
        waitOperationSettings() {
      return getStubSettingsBuilder().waitOperationSettings();
    }

    /** Returns the builder for the settings used for calls to block. */
    public UnaryCallSettings.Builder<BlockRequest, BlockResponse> blockSettings() {
      return getStubSettingsBuilder().blockSettings();
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
    public EchoSettings build() throws IOException {
      return new EchoSettings(this);
    }
  }
}
