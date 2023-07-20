/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ScheduleServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ScheduleServiceClient.ListSchedulesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.aiplatform.v1beta1.stub.ScheduleServiceStubSettings;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ScheduleServiceClient}.
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
 * <p>For example, to set the total timeout of createSchedule to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ScheduleServiceSettings.Builder scheduleServiceSettingsBuilder =
 *     ScheduleServiceSettings.newBuilder();
 * scheduleServiceSettingsBuilder
 *     .createScheduleSettings()
 *     .setRetrySettings(
 *         scheduleServiceSettingsBuilder
 *             .createScheduleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ScheduleServiceSettings scheduleServiceSettings = scheduleServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ScheduleServiceSettings extends ClientSettings<ScheduleServiceSettings> {

  /** Returns the object with the settings used for calls to createSchedule. */
  public UnaryCallSettings<CreateScheduleRequest, Schedule> createScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).createScheduleSettings();
  }

  /** Returns the object with the settings used for calls to deleteSchedule. */
  public UnaryCallSettings<DeleteScheduleRequest, Operation> deleteScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).deleteScheduleSettings();
  }

  /** Returns the object with the settings used for calls to deleteSchedule. */
  public OperationCallSettings<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
      deleteScheduleOperationSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).deleteScheduleOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSchedule. */
  public UnaryCallSettings<GetScheduleRequest, Schedule> getScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).getScheduleSettings();
  }

  /** Returns the object with the settings used for calls to listSchedules. */
  public PagedCallSettings<ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
      listSchedulesSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).listSchedulesSettings();
  }

  /** Returns the object with the settings used for calls to pauseSchedule. */
  public UnaryCallSettings<PauseScheduleRequest, Empty> pauseScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).pauseScheduleSettings();
  }

  /** Returns the object with the settings used for calls to resumeSchedule. */
  public UnaryCallSettings<ResumeScheduleRequest, Empty> resumeScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).resumeScheduleSettings();
  }

  /** Returns the object with the settings used for calls to updateSchedule. */
  public UnaryCallSettings<UpdateScheduleRequest, Schedule> updateScheduleSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).updateScheduleSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ScheduleServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ScheduleServiceSettings create(ScheduleServiceStubSettings stub)
      throws IOException {
    return new ScheduleServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ScheduleServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ScheduleServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ScheduleServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ScheduleServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ScheduleServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ScheduleServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ScheduleServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ScheduleServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ScheduleServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ScheduleServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ScheduleServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ScheduleServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ScheduleServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ScheduleServiceStubSettings.newBuilder());
    }

    public ScheduleServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ScheduleServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSchedule. */
    public UnaryCallSettings.Builder<CreateScheduleRequest, Schedule> createScheduleSettings() {
      return getStubSettingsBuilder().createScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSchedule. */
    public UnaryCallSettings.Builder<DeleteScheduleRequest, Operation> deleteScheduleSettings() {
      return getStubSettingsBuilder().deleteScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSchedule. */
    public OperationCallSettings.Builder<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
        deleteScheduleOperationSettings() {
      return getStubSettingsBuilder().deleteScheduleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSchedule. */
    public UnaryCallSettings.Builder<GetScheduleRequest, Schedule> getScheduleSettings() {
      return getStubSettingsBuilder().getScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to listSchedules. */
    public PagedCallSettings.Builder<
            ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
        listSchedulesSettings() {
      return getStubSettingsBuilder().listSchedulesSettings();
    }

    /** Returns the builder for the settings used for calls to pauseSchedule. */
    public UnaryCallSettings.Builder<PauseScheduleRequest, Empty> pauseScheduleSettings() {
      return getStubSettingsBuilder().pauseScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to resumeSchedule. */
    public UnaryCallSettings.Builder<ResumeScheduleRequest, Empty> resumeScheduleSettings() {
      return getStubSettingsBuilder().resumeScheduleSettings();
    }

    /** Returns the builder for the settings used for calls to updateSchedule. */
    public UnaryCallSettings.Builder<UpdateScheduleRequest, Schedule> updateScheduleSettings() {
      return getStubSettingsBuilder().updateScheduleSettings();
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
    public ScheduleServiceSettings build() throws IOException {
      return new ScheduleServiceSettings(this);
    }
  }
}
