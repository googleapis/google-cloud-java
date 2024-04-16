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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.GenAiTuningServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.GenAiTuningServiceClient.ListTuningJobsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1.stub.GenAiTuningServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link GenAiTuningServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTuningJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GenAiTuningServiceSettings.Builder genAiTuningServiceSettingsBuilder =
 *     GenAiTuningServiceSettings.newBuilder();
 * genAiTuningServiceSettingsBuilder
 *     .createTuningJobSettings()
 *     .setRetrySettings(
 *         genAiTuningServiceSettingsBuilder
 *             .createTuningJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GenAiTuningServiceSettings genAiTuningServiceSettings =
 *     genAiTuningServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GenAiTuningServiceSettings extends ClientSettings<GenAiTuningServiceSettings> {

  /** Returns the object with the settings used for calls to createTuningJob. */
  public UnaryCallSettings<CreateTuningJobRequest, TuningJob> createTuningJobSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).createTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to getTuningJob. */
  public UnaryCallSettings<GetTuningJobRequest, TuningJob> getTuningJobSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).getTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to listTuningJobs. */
  public PagedCallSettings<
          ListTuningJobsRequest, ListTuningJobsResponse, ListTuningJobsPagedResponse>
      listTuningJobsSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).listTuningJobsSettings();
  }

  /** Returns the object with the settings used for calls to cancelTuningJob. */
  public UnaryCallSettings<CancelTuningJobRequest, Empty> cancelTuningJobSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).cancelTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((GenAiTuningServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final GenAiTuningServiceSettings create(GenAiTuningServiceStubSettings stub)
      throws IOException {
    return new GenAiTuningServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GenAiTuningServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GenAiTuningServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GenAiTuningServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GenAiTuningServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GenAiTuningServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GenAiTuningServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GenAiTuningServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GenAiTuningServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GenAiTuningServiceSettings. */
  public static class Builder extends ClientSettings.Builder<GenAiTuningServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GenAiTuningServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GenAiTuningServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GenAiTuningServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GenAiTuningServiceStubSettings.newBuilder());
    }

    public GenAiTuningServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GenAiTuningServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createTuningJob. */
    public UnaryCallSettings.Builder<CreateTuningJobRequest, TuningJob> createTuningJobSettings() {
      return getStubSettingsBuilder().createTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to getTuningJob. */
    public UnaryCallSettings.Builder<GetTuningJobRequest, TuningJob> getTuningJobSettings() {
      return getStubSettingsBuilder().getTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to listTuningJobs. */
    public PagedCallSettings.Builder<
            ListTuningJobsRequest, ListTuningJobsResponse, ListTuningJobsPagedResponse>
        listTuningJobsSettings() {
      return getStubSettingsBuilder().listTuningJobsSettings();
    }

    /** Returns the builder for the settings used for calls to cancelTuningJob. */
    public UnaryCallSettings.Builder<CancelTuningJobRequest, Empty> cancelTuningJobSettings() {
      return getStubSettingsBuilder().cancelTuningJobSettings();
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
    public GenAiTuningServiceSettings build() throws IOException {
      return new GenAiTuningServiceSettings(this);
    }
  }
}
