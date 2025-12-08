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

package com.google.cloud.networksecurity.v1beta1;

import static com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorServiceClient.ListDnsThreatDetectorsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.stub.DnsThreatDetectorServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DnsThreatDetectorServiceClient}.
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
 * of getDnsThreatDetector:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DnsThreatDetectorServiceSettings.Builder dnsThreatDetectorServiceSettingsBuilder =
 *     DnsThreatDetectorServiceSettings.newBuilder();
 * dnsThreatDetectorServiceSettingsBuilder
 *     .getDnsThreatDetectorSettings()
 *     .setRetrySettings(
 *         dnsThreatDetectorServiceSettingsBuilder
 *             .getDnsThreatDetectorSettings()
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
 * DnsThreatDetectorServiceSettings dnsThreatDetectorServiceSettings =
 *     dnsThreatDetectorServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DnsThreatDetectorServiceSettings
    extends ClientSettings<DnsThreatDetectorServiceSettings> {

  /** Returns the object with the settings used for calls to listDnsThreatDetectors. */
  public PagedCallSettings<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          ListDnsThreatDetectorsPagedResponse>
      listDnsThreatDetectorsSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings())
        .listDnsThreatDetectorsSettings();
  }

  /** Returns the object with the settings used for calls to getDnsThreatDetector. */
  public UnaryCallSettings<GetDnsThreatDetectorRequest, DnsThreatDetector>
      getDnsThreatDetectorSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings())
        .getDnsThreatDetectorSettings();
  }

  /** Returns the object with the settings used for calls to createDnsThreatDetector. */
  public UnaryCallSettings<CreateDnsThreatDetectorRequest, DnsThreatDetector>
      createDnsThreatDetectorSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings())
        .createDnsThreatDetectorSettings();
  }

  /** Returns the object with the settings used for calls to updateDnsThreatDetector. */
  public UnaryCallSettings<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
      updateDnsThreatDetectorSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings())
        .updateDnsThreatDetectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteDnsThreatDetector. */
  public UnaryCallSettings<DeleteDnsThreatDetectorRequest, Empty>
      deleteDnsThreatDetectorSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings())
        .deleteDnsThreatDetectorSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DnsThreatDetectorServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DnsThreatDetectorServiceSettings create(
      DnsThreatDetectorServiceStubSettings stub) throws IOException {
    return new DnsThreatDetectorServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DnsThreatDetectorServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DnsThreatDetectorServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DnsThreatDetectorServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DnsThreatDetectorServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DnsThreatDetectorServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DnsThreatDetectorServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DnsThreatDetectorServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DnsThreatDetectorServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DnsThreatDetectorServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DnsThreatDetectorServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DnsThreatDetectorServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DnsThreatDetectorServiceStubSettings.newHttpJsonBuilder());
    }

    public DnsThreatDetectorServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DnsThreatDetectorServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDnsThreatDetectors. */
    public PagedCallSettings.Builder<
            ListDnsThreatDetectorsRequest,
            ListDnsThreatDetectorsResponse,
            ListDnsThreatDetectorsPagedResponse>
        listDnsThreatDetectorsSettings() {
      return getStubSettingsBuilder().listDnsThreatDetectorsSettings();
    }

    /** Returns the builder for the settings used for calls to getDnsThreatDetector. */
    public UnaryCallSettings.Builder<GetDnsThreatDetectorRequest, DnsThreatDetector>
        getDnsThreatDetectorSettings() {
      return getStubSettingsBuilder().getDnsThreatDetectorSettings();
    }

    /** Returns the builder for the settings used for calls to createDnsThreatDetector. */
    public UnaryCallSettings.Builder<CreateDnsThreatDetectorRequest, DnsThreatDetector>
        createDnsThreatDetectorSettings() {
      return getStubSettingsBuilder().createDnsThreatDetectorSettings();
    }

    /** Returns the builder for the settings used for calls to updateDnsThreatDetector. */
    public UnaryCallSettings.Builder<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
        updateDnsThreatDetectorSettings() {
      return getStubSettingsBuilder().updateDnsThreatDetectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDnsThreatDetector. */
    public UnaryCallSettings.Builder<DeleteDnsThreatDetectorRequest, Empty>
        deleteDnsThreatDetectorSettings() {
      return getStubSettingsBuilder().deleteDnsThreatDetectorSettings();
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
    public DnsThreatDetectorServiceSettings build() throws IOException {
      return new DnsThreatDetectorServiceSettings(this);
    }
  }
}
