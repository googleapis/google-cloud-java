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

package com.google.cloud.gkehub.v1beta1;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

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
import com.google.cloud.gkehub.v1beta1.stub.GkeHubMembershipServiceStubSettings;
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
 * Settings class to configure an instance of {@link GkeHubMembershipServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkehub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMembership to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubMembershipServiceSettings.Builder gkeHubMembershipServiceSettingsBuilder =
 *     GkeHubMembershipServiceSettings.newBuilder();
 * gkeHubMembershipServiceSettingsBuilder
 *     .getMembershipSettings()
 *     .setRetrySettings(
 *         gkeHubMembershipServiceSettingsBuilder
 *             .getMembershipSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GkeHubMembershipServiceSettings gkeHubMembershipServiceSettings =
 *     gkeHubMembershipServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GkeHubMembershipServiceSettings
    extends ClientSettings<GkeHubMembershipServiceSettings> {

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).listMembershipsSettings();
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).getMembershipSettings();
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).createMembershipSettings();
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings())
        .createMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).deleteMembershipSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings())
        .deleteMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).updateMembershipSettings();
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings())
        .updateMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateConnectManifest. */
  public UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings())
        .generateConnectManifestSettings();
  }

  /** Returns the object with the settings used for calls to validateExclusivity. */
  public UnaryCallSettings<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivitySettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).validateExclusivitySettings();
  }

  /** Returns the object with the settings used for calls to generateExclusivityManifest. */
  public UnaryCallSettings<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings())
        .generateExclusivityManifestSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((GkeHubMembershipServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final GkeHubMembershipServiceSettings create(
      GkeHubMembershipServiceStubSettings stub) throws IOException {
    return new GkeHubMembershipServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GkeHubMembershipServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GkeHubMembershipServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GkeHubMembershipServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubMembershipServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected GkeHubMembershipServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GkeHubMembershipServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<GkeHubMembershipServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GkeHubMembershipServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GkeHubMembershipServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GkeHubMembershipServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GkeHubMembershipServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(GkeHubMembershipServiceStubSettings.newHttpJsonBuilder());
    }

    public GkeHubMembershipServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GkeHubMembershipServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return getStubSettingsBuilder().listMembershipsSettings();
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getStubSettingsBuilder().getMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings() {
      return getStubSettingsBuilder().createMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public OperationCallSettings.Builder<CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings() {
      return getStubSettingsBuilder().createMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings() {
      return getStubSettingsBuilder().deleteMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings() {
      return getStubSettingsBuilder().deleteMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings() {
      return getStubSettingsBuilder().updateMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public OperationCallSettings.Builder<UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings() {
      return getStubSettingsBuilder().updateMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateConnectManifest. */
    public UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings() {
      return getStubSettingsBuilder().generateConnectManifestSettings();
    }

    /** Returns the builder for the settings used for calls to validateExclusivity. */
    public UnaryCallSettings.Builder<ValidateExclusivityRequest, ValidateExclusivityResponse>
        validateExclusivitySettings() {
      return getStubSettingsBuilder().validateExclusivitySettings();
    }

    /** Returns the builder for the settings used for calls to generateExclusivityManifest. */
    public UnaryCallSettings.Builder<
            GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
        generateExclusivityManifestSettings() {
      return getStubSettingsBuilder().generateExclusivityManifestSettings();
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
    public GkeHubMembershipServiceSettings build() throws IOException {
      return new GkeHubMembershipServiceSettings(this);
    }
  }
}
