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

import static com.google.showcase.v1beta1.ComplianceClient.ListLocationsPagedResponse;

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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.showcase.v1beta1.stub.ComplianceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ComplianceClient}.
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
 * of repeatDataBody:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ComplianceSettings.Builder complianceSettingsBuilder = ComplianceSettings.newBuilder();
 * complianceSettingsBuilder
 *     .repeatDataBodySettings()
 *     .setRetrySettings(
 *         complianceSettingsBuilder
 *             .repeatDataBodySettings()
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
 * ComplianceSettings complianceSettings = complianceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ComplianceSettings extends ClientSettings<ComplianceSettings> {

  /** Returns the object with the settings used for calls to repeatDataBody. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataBodySettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataBodySettings();
  }

  /** Returns the object with the settings used for calls to repeatDataBodyInfo. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyInfoSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataBodyInfoSettings();
  }

  /** Returns the object with the settings used for calls to repeatDataQuery. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataQuerySettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataQuerySettings();
  }

  /** Returns the object with the settings used for calls to repeatDataSimplePath. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataSimplePathSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataSimplePathSettings();
  }

  /** Returns the object with the settings used for calls to repeatDataPathResource. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataPathResourceSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataPathResourceSettings();
  }

  /** Returns the object with the settings used for calls to repeatDataPathTrailingResource. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataPathTrailingResourceSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataPathTrailingResourceSettings();
  }

  /** Returns the object with the settings used for calls to repeatDataBodyPut. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyPutSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataBodyPutSettings();
  }

  /** Returns the object with the settings used for calls to repeatDataBodyPatch. */
  public UnaryCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyPatchSettings() {
    return ((ComplianceStubSettings) getStubSettings()).repeatDataBodyPatchSettings();
  }

  /** Returns the object with the settings used for calls to getEnum. */
  public UnaryCallSettings<EnumRequest, EnumResponse> getEnumSettings() {
    return ((ComplianceStubSettings) getStubSettings()).getEnumSettings();
  }

  /** Returns the object with the settings used for calls to verifyEnum. */
  public UnaryCallSettings<EnumResponse, EnumResponse> verifyEnumSettings() {
    return ((ComplianceStubSettings) getStubSettings()).verifyEnumSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ComplianceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ComplianceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ComplianceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ComplianceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ComplianceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ComplianceSettings create(ComplianceStubSettings stub) throws IOException {
    return new ComplianceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ComplianceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ComplianceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ComplianceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ComplianceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ComplianceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ComplianceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ComplianceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ComplianceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ComplianceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ComplianceSettings. */
  public static class Builder extends ClientSettings.Builder<ComplianceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ComplianceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ComplianceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ComplianceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ComplianceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ComplianceStubSettings.newHttpJsonBuilder());
    }

    public ComplianceStubSettings.Builder getStubSettingsBuilder() {
      return ((ComplianceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to repeatDataBody. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataBodySettings() {
      return getStubSettingsBuilder().repeatDataBodySettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataBodyInfo. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataBodyInfoSettings() {
      return getStubSettingsBuilder().repeatDataBodyInfoSettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataQuery. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataQuerySettings() {
      return getStubSettingsBuilder().repeatDataQuerySettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataSimplePath. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataSimplePathSettings() {
      return getStubSettingsBuilder().repeatDataSimplePathSettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataPathResource. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse>
        repeatDataPathResourceSettings() {
      return getStubSettingsBuilder().repeatDataPathResourceSettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataPathTrailingResource. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse>
        repeatDataPathTrailingResourceSettings() {
      return getStubSettingsBuilder().repeatDataPathTrailingResourceSettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataBodyPut. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataBodyPutSettings() {
      return getStubSettingsBuilder().repeatDataBodyPutSettings();
    }

    /** Returns the builder for the settings used for calls to repeatDataBodyPatch. */
    public UnaryCallSettings.Builder<RepeatRequest, RepeatResponse> repeatDataBodyPatchSettings() {
      return getStubSettingsBuilder().repeatDataBodyPatchSettings();
    }

    /** Returns the builder for the settings used for calls to getEnum. */
    public UnaryCallSettings.Builder<EnumRequest, EnumResponse> getEnumSettings() {
      return getStubSettingsBuilder().getEnumSettings();
    }

    /** Returns the builder for the settings used for calls to verifyEnum. */
    public UnaryCallSettings.Builder<EnumResponse, EnumResponse> verifyEnumSettings() {
      return getStubSettingsBuilder().verifyEnumSettings();
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
    public ComplianceSettings build() throws IOException {
      return new ComplianceSettings(this);
    }
  }
}
