/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListStudiesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListTrialsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.VizierServiceStubSettings;
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
 * Settings class to configure an instance of {@link VizierServiceClient}.
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
 * <p>For example, to set the total timeout of createStudy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VizierServiceSettings.Builder vizierServiceSettingsBuilder = VizierServiceSettings.newBuilder();
 * vizierServiceSettingsBuilder
 *     .createStudySettings()
 *     .setRetrySettings(
 *         vizierServiceSettingsBuilder.createStudySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VizierServiceSettings vizierServiceSettings = vizierServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VizierServiceSettings extends ClientSettings<VizierServiceSettings> {

  /** Returns the object with the settings used for calls to createStudy. */
  public UnaryCallSettings<CreateStudyRequest, Study> createStudySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).createStudySettings();
  }

  /** Returns the object with the settings used for calls to getStudy. */
  public UnaryCallSettings<GetStudyRequest, Study> getStudySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).getStudySettings();
  }

  /** Returns the object with the settings used for calls to listStudies. */
  public PagedCallSettings<ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
      listStudiesSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).listStudiesSettings();
  }

  /** Returns the object with the settings used for calls to deleteStudy. */
  public UnaryCallSettings<DeleteStudyRequest, Empty> deleteStudySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).deleteStudySettings();
  }

  /** Returns the object with the settings used for calls to lookupStudy. */
  public UnaryCallSettings<LookupStudyRequest, Study> lookupStudySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).lookupStudySettings();
  }

  /** Returns the object with the settings used for calls to suggestTrials. */
  public UnaryCallSettings<SuggestTrialsRequest, Operation> suggestTrialsSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).suggestTrialsSettings();
  }

  /** Returns the object with the settings used for calls to suggestTrials. */
  public OperationCallSettings<SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).suggestTrialsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createTrial. */
  public UnaryCallSettings<CreateTrialRequest, Trial> createTrialSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).createTrialSettings();
  }

  /** Returns the object with the settings used for calls to getTrial. */
  public UnaryCallSettings<GetTrialRequest, Trial> getTrialSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).getTrialSettings();
  }

  /** Returns the object with the settings used for calls to listTrials. */
  public PagedCallSettings<ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
      listTrialsSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).listTrialsSettings();
  }

  /** Returns the object with the settings used for calls to addTrialMeasurement. */
  public UnaryCallSettings<AddTrialMeasurementRequest, Trial> addTrialMeasurementSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).addTrialMeasurementSettings();
  }

  /** Returns the object with the settings used for calls to completeTrial. */
  public UnaryCallSettings<CompleteTrialRequest, Trial> completeTrialSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).completeTrialSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrial. */
  public UnaryCallSettings<DeleteTrialRequest, Empty> deleteTrialSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).deleteTrialSettings();
  }

  /** Returns the object with the settings used for calls to checkTrialEarlyStoppingState. */
  public UnaryCallSettings<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).checkTrialEarlyStoppingStateSettings();
  }

  /** Returns the object with the settings used for calls to checkTrialEarlyStoppingState. */
  public OperationCallSettings<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationSettings() {
    return ((VizierServiceStubSettings) getStubSettings())
        .checkTrialEarlyStoppingStateOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopTrial. */
  public UnaryCallSettings<StopTrialRequest, Trial> stopTrialSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).stopTrialSettings();
  }

  /** Returns the object with the settings used for calls to listOptimalTrials. */
  public UnaryCallSettings<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).listOptimalTrialsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VizierServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VizierServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VizierServiceSettings create(VizierServiceStubSettings stub)
      throws IOException {
    return new VizierServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VizierServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VizierServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VizierServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VizierServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VizierServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VizierServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VizierServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VizierServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VizierServiceSettings. */
  public static class Builder extends ClientSettings.Builder<VizierServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VizierServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VizierServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VizierServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VizierServiceStubSettings.newBuilder());
    }

    public VizierServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VizierServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createStudy. */
    public UnaryCallSettings.Builder<CreateStudyRequest, Study> createStudySettings() {
      return getStubSettingsBuilder().createStudySettings();
    }

    /** Returns the builder for the settings used for calls to getStudy. */
    public UnaryCallSettings.Builder<GetStudyRequest, Study> getStudySettings() {
      return getStubSettingsBuilder().getStudySettings();
    }

    /** Returns the builder for the settings used for calls to listStudies. */
    public PagedCallSettings.Builder<
            ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
        listStudiesSettings() {
      return getStubSettingsBuilder().listStudiesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStudy. */
    public UnaryCallSettings.Builder<DeleteStudyRequest, Empty> deleteStudySettings() {
      return getStubSettingsBuilder().deleteStudySettings();
    }

    /** Returns the builder for the settings used for calls to lookupStudy. */
    public UnaryCallSettings.Builder<LookupStudyRequest, Study> lookupStudySettings() {
      return getStubSettingsBuilder().lookupStudySettings();
    }

    /** Returns the builder for the settings used for calls to suggestTrials. */
    public UnaryCallSettings.Builder<SuggestTrialsRequest, Operation> suggestTrialsSettings() {
      return getStubSettingsBuilder().suggestTrialsSettings();
    }

    /** Returns the builder for the settings used for calls to suggestTrials. */
    public OperationCallSettings.Builder<
            SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
        suggestTrialsOperationSettings() {
      return getStubSettingsBuilder().suggestTrialsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createTrial. */
    public UnaryCallSettings.Builder<CreateTrialRequest, Trial> createTrialSettings() {
      return getStubSettingsBuilder().createTrialSettings();
    }

    /** Returns the builder for the settings used for calls to getTrial. */
    public UnaryCallSettings.Builder<GetTrialRequest, Trial> getTrialSettings() {
      return getStubSettingsBuilder().getTrialSettings();
    }

    /** Returns the builder for the settings used for calls to listTrials. */
    public PagedCallSettings.Builder<ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
        listTrialsSettings() {
      return getStubSettingsBuilder().listTrialsSettings();
    }

    /** Returns the builder for the settings used for calls to addTrialMeasurement. */
    public UnaryCallSettings.Builder<AddTrialMeasurementRequest, Trial>
        addTrialMeasurementSettings() {
      return getStubSettingsBuilder().addTrialMeasurementSettings();
    }

    /** Returns the builder for the settings used for calls to completeTrial. */
    public UnaryCallSettings.Builder<CompleteTrialRequest, Trial> completeTrialSettings() {
      return getStubSettingsBuilder().completeTrialSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrial. */
    public UnaryCallSettings.Builder<DeleteTrialRequest, Empty> deleteTrialSettings() {
      return getStubSettingsBuilder().deleteTrialSettings();
    }

    /** Returns the builder for the settings used for calls to checkTrialEarlyStoppingState. */
    public UnaryCallSettings.Builder<CheckTrialEarlyStoppingStateRequest, Operation>
        checkTrialEarlyStoppingStateSettings() {
      return getStubSettingsBuilder().checkTrialEarlyStoppingStateSettings();
    }

    /** Returns the builder for the settings used for calls to checkTrialEarlyStoppingState. */
    public OperationCallSettings.Builder<
            CheckTrialEarlyStoppingStateRequest,
            CheckTrialEarlyStoppingStateResponse,
            CheckTrialEarlyStoppingStateMetatdata>
        checkTrialEarlyStoppingStateOperationSettings() {
      return getStubSettingsBuilder().checkTrialEarlyStoppingStateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopTrial. */
    public UnaryCallSettings.Builder<StopTrialRequest, Trial> stopTrialSettings() {
      return getStubSettingsBuilder().stopTrialSettings();
    }

    /** Returns the builder for the settings used for calls to listOptimalTrials. */
    public UnaryCallSettings.Builder<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
        listOptimalTrialsSettings() {
      return getStubSettingsBuilder().listOptimalTrialsSettings();
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
    public VizierServiceSettings build() throws IOException {
      return new VizierServiceSettings(this);
    }
  }
}
