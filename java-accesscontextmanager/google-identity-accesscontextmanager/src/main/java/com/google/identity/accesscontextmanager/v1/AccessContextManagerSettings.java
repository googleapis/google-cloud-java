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

package com.google.identity.accesscontextmanager.v1;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.identity.accesscontextmanager.v1.stub.AccessContextManagerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccessContextManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (accesscontextmanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAccessPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessContextManagerSettings.Builder accessContextManagerSettingsBuilder =
 *     AccessContextManagerSettings.newBuilder();
 * accessContextManagerSettingsBuilder
 *     .getAccessPolicySettings()
 *     .setRetrySettings(
 *         accessContextManagerSettingsBuilder
 *             .getAccessPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AccessContextManagerSettings accessContextManagerSettings =
 *     accessContextManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AccessContextManagerSettings extends ClientSettings<AccessContextManagerSettings> {

  /** Returns the object with the settings used for calls to listAccessPolicies. */
  public PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).listAccessPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAccessPolicy. */
  public UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).getAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public UnaryCallSettings<AccessPolicy, Operation> createAccessPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).createAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public OperationCallSettings<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .createAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).updateAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public OperationCallSettings<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .updateAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).deleteAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public OperationCallSettings<
          DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .deleteAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAccessLevels. */
  public PagedCallSettings<
          ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
      listAccessLevelsSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).listAccessLevelsSettings();
  }

  /** Returns the object with the settings used for calls to getAccessLevel. */
  public UnaryCallSettings<GetAccessLevelRequest, AccessLevel> getAccessLevelSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).getAccessLevelSettings();
  }

  /** Returns the object with the settings used for calls to createAccessLevel. */
  public UnaryCallSettings<CreateAccessLevelRequest, Operation> createAccessLevelSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).createAccessLevelSettings();
  }

  /** Returns the object with the settings used for calls to createAccessLevel. */
  public OperationCallSettings<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .createAccessLevelOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessLevel. */
  public UnaryCallSettings<UpdateAccessLevelRequest, Operation> updateAccessLevelSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).updateAccessLevelSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessLevel. */
  public OperationCallSettings<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .updateAccessLevelOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessLevel. */
  public UnaryCallSettings<DeleteAccessLevelRequest, Operation> deleteAccessLevelSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).deleteAccessLevelSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessLevel. */
  public OperationCallSettings<
          DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .deleteAccessLevelOperationSettings();
  }

  /** Returns the object with the settings used for calls to replaceAccessLevels. */
  public UnaryCallSettings<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).replaceAccessLevelsSettings();
  }

  /** Returns the object with the settings used for calls to replaceAccessLevels. */
  public OperationCallSettings<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .replaceAccessLevelsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServicePerimeters. */
  public PagedCallSettings<
          ListServicePerimetersRequest,
          ListServicePerimetersResponse,
          ListServicePerimetersPagedResponse>
      listServicePerimetersSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).listServicePerimetersSettings();
  }

  /** Returns the object with the settings used for calls to getServicePerimeter. */
  public UnaryCallSettings<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).getServicePerimeterSettings();
  }

  /** Returns the object with the settings used for calls to createServicePerimeter. */
  public UnaryCallSettings<CreateServicePerimeterRequest, Operation>
      createServicePerimeterSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).createServicePerimeterSettings();
  }

  /** Returns the object with the settings used for calls to createServicePerimeter. */
  public OperationCallSettings<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .createServicePerimeterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServicePerimeter. */
  public UnaryCallSettings<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).updateServicePerimeterSettings();
  }

  /** Returns the object with the settings used for calls to updateServicePerimeter. */
  public OperationCallSettings<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .updateServicePerimeterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServicePerimeter. */
  public UnaryCallSettings<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).deleteServicePerimeterSettings();
  }

  /** Returns the object with the settings used for calls to deleteServicePerimeter. */
  public OperationCallSettings<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .deleteServicePerimeterOperationSettings();
  }

  /** Returns the object with the settings used for calls to replaceServicePerimeters. */
  public UnaryCallSettings<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .replaceServicePerimetersSettings();
  }

  /** Returns the object with the settings used for calls to replaceServicePerimeters. */
  public OperationCallSettings<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .replaceServicePerimetersOperationSettings();
  }

  /** Returns the object with the settings used for calls to commitServicePerimeters. */
  public UnaryCallSettings<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).commitServicePerimetersSettings();
  }

  /** Returns the object with the settings used for calls to commitServicePerimeters. */
  public OperationCallSettings<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .commitServicePerimetersOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGcpUserAccessBindings. */
  public PagedCallSettings<
          ListGcpUserAccessBindingsRequest,
          ListGcpUserAccessBindingsResponse,
          ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .listGcpUserAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getGcpUserAccessBinding. */
  public UnaryCallSettings<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).getGcpUserAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to createGcpUserAccessBinding. */
  public UnaryCallSettings<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .createGcpUserAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to createGcpUserAccessBinding. */
  public OperationCallSettings<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .createGcpUserAccessBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGcpUserAccessBinding. */
  public UnaryCallSettings<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .updateGcpUserAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateGcpUserAccessBinding. */
  public OperationCallSettings<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .updateGcpUserAccessBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGcpUserAccessBinding. */
  public UnaryCallSettings<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .deleteGcpUserAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteGcpUserAccessBinding. */
  public OperationCallSettings<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings())
        .deleteGcpUserAccessBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AccessContextManagerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AccessContextManagerSettings create(AccessContextManagerStubSettings stub)
      throws IOException {
    return new AccessContextManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AccessContextManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AccessContextManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AccessContextManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AccessContextManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AccessContextManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AccessContextManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AccessContextManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessContextManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AccessContextManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AccessContextManagerSettings. */
  public static class Builder
      extends ClientSettings.Builder<AccessContextManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AccessContextManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(AccessContextManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AccessContextManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AccessContextManagerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AccessContextManagerStubSettings.newHttpJsonBuilder());
    }

    public AccessContextManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((AccessContextManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAccessPolicies. */
    public PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings() {
      return getStubSettingsBuilder().listAccessPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessPolicy. */
    public UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings() {
      return getStubSettingsBuilder().getAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public UnaryCallSettings.Builder<AccessPolicy, Operation> createAccessPolicySettings() {
      return getStubSettingsBuilder().createAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public OperationCallSettings.Builder<
            AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
        createAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().createAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings() {
      return getStubSettingsBuilder().updateAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public OperationCallSettings.Builder<
            UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
        updateAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings() {
      return getStubSettingsBuilder().deleteAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public OperationCallSettings.Builder<
            DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessLevels. */
    public PagedCallSettings.Builder<
            ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
        listAccessLevelsSettings() {
      return getStubSettingsBuilder().listAccessLevelsSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessLevel. */
    public UnaryCallSettings.Builder<GetAccessLevelRequest, AccessLevel> getAccessLevelSettings() {
      return getStubSettingsBuilder().getAccessLevelSettings();
    }

    /** Returns the builder for the settings used for calls to createAccessLevel. */
    public UnaryCallSettings.Builder<CreateAccessLevelRequest, Operation>
        createAccessLevelSettings() {
      return getStubSettingsBuilder().createAccessLevelSettings();
    }

    /** Returns the builder for the settings used for calls to createAccessLevel. */
    public OperationCallSettings.Builder<
            CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        createAccessLevelOperationSettings() {
      return getStubSettingsBuilder().createAccessLevelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessLevel. */
    public UnaryCallSettings.Builder<UpdateAccessLevelRequest, Operation>
        updateAccessLevelSettings() {
      return getStubSettingsBuilder().updateAccessLevelSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessLevel. */
    public OperationCallSettings.Builder<
            UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        updateAccessLevelOperationSettings() {
      return getStubSettingsBuilder().updateAccessLevelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessLevel. */
    public UnaryCallSettings.Builder<DeleteAccessLevelRequest, Operation>
        deleteAccessLevelSettings() {
      return getStubSettingsBuilder().deleteAccessLevelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessLevel. */
    public OperationCallSettings.Builder<
            DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessLevelOperationSettings() {
      return getStubSettingsBuilder().deleteAccessLevelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to replaceAccessLevels. */
    public UnaryCallSettings.Builder<ReplaceAccessLevelsRequest, Operation>
        replaceAccessLevelsSettings() {
      return getStubSettingsBuilder().replaceAccessLevelsSettings();
    }

    /** Returns the builder for the settings used for calls to replaceAccessLevels. */
    public OperationCallSettings.Builder<
            ReplaceAccessLevelsRequest,
            ReplaceAccessLevelsResponse,
            AccessContextManagerOperationMetadata>
        replaceAccessLevelsOperationSettings() {
      return getStubSettingsBuilder().replaceAccessLevelsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServicePerimeters. */
    public PagedCallSettings.Builder<
            ListServicePerimetersRequest,
            ListServicePerimetersResponse,
            ListServicePerimetersPagedResponse>
        listServicePerimetersSettings() {
      return getStubSettingsBuilder().listServicePerimetersSettings();
    }

    /** Returns the builder for the settings used for calls to getServicePerimeter. */
    public UnaryCallSettings.Builder<GetServicePerimeterRequest, ServicePerimeter>
        getServicePerimeterSettings() {
      return getStubSettingsBuilder().getServicePerimeterSettings();
    }

    /** Returns the builder for the settings used for calls to createServicePerimeter. */
    public UnaryCallSettings.Builder<CreateServicePerimeterRequest, Operation>
        createServicePerimeterSettings() {
      return getStubSettingsBuilder().createServicePerimeterSettings();
    }

    /** Returns the builder for the settings used for calls to createServicePerimeter. */
    public OperationCallSettings.Builder<
            CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        createServicePerimeterOperationSettings() {
      return getStubSettingsBuilder().createServicePerimeterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServicePerimeter. */
    public UnaryCallSettings.Builder<UpdateServicePerimeterRequest, Operation>
        updateServicePerimeterSettings() {
      return getStubSettingsBuilder().updateServicePerimeterSettings();
    }

    /** Returns the builder for the settings used for calls to updateServicePerimeter. */
    public OperationCallSettings.Builder<
            UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        updateServicePerimeterOperationSettings() {
      return getStubSettingsBuilder().updateServicePerimeterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServicePerimeter. */
    public UnaryCallSettings.Builder<DeleteServicePerimeterRequest, Operation>
        deleteServicePerimeterSettings() {
      return getStubSettingsBuilder().deleteServicePerimeterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServicePerimeter. */
    public OperationCallSettings.Builder<
            DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
        deleteServicePerimeterOperationSettings() {
      return getStubSettingsBuilder().deleteServicePerimeterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to replaceServicePerimeters. */
    public UnaryCallSettings.Builder<ReplaceServicePerimetersRequest, Operation>
        replaceServicePerimetersSettings() {
      return getStubSettingsBuilder().replaceServicePerimetersSettings();
    }

    /** Returns the builder for the settings used for calls to replaceServicePerimeters. */
    public OperationCallSettings.Builder<
            ReplaceServicePerimetersRequest,
            ReplaceServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        replaceServicePerimetersOperationSettings() {
      return getStubSettingsBuilder().replaceServicePerimetersOperationSettings();
    }

    /** Returns the builder for the settings used for calls to commitServicePerimeters. */
    public UnaryCallSettings.Builder<CommitServicePerimetersRequest, Operation>
        commitServicePerimetersSettings() {
      return getStubSettingsBuilder().commitServicePerimetersSettings();
    }

    /** Returns the builder for the settings used for calls to commitServicePerimeters. */
    public OperationCallSettings.Builder<
            CommitServicePerimetersRequest,
            CommitServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        commitServicePerimetersOperationSettings() {
      return getStubSettingsBuilder().commitServicePerimetersOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGcpUserAccessBindings. */
    public PagedCallSettings.Builder<
            ListGcpUserAccessBindingsRequest,
            ListGcpUserAccessBindingsResponse,
            ListGcpUserAccessBindingsPagedResponse>
        listGcpUserAccessBindingsSettings() {
      return getStubSettingsBuilder().listGcpUserAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
        getGcpUserAccessBindingSettings() {
      return getStubSettingsBuilder().getGcpUserAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<CreateGcpUserAccessBindingRequest, Operation>
        createGcpUserAccessBindingSettings() {
      return getStubSettingsBuilder().createGcpUserAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createGcpUserAccessBinding. */
    public OperationCallSettings.Builder<
            CreateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        createGcpUserAccessBindingOperationSettings() {
      return getStubSettingsBuilder().createGcpUserAccessBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<UpdateGcpUserAccessBindingRequest, Operation>
        updateGcpUserAccessBindingSettings() {
      return getStubSettingsBuilder().updateGcpUserAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateGcpUserAccessBinding. */
    public OperationCallSettings.Builder<
            UpdateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        updateGcpUserAccessBindingOperationSettings() {
      return getStubSettingsBuilder().updateGcpUserAccessBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<DeleteGcpUserAccessBindingRequest, Operation>
        deleteGcpUserAccessBindingSettings() {
      return getStubSettingsBuilder().deleteGcpUserAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGcpUserAccessBinding. */
    public OperationCallSettings.Builder<
            DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
        deleteGcpUserAccessBindingOperationSettings() {
      return getStubSettingsBuilder().deleteGcpUserAccessBindingOperationSettings();
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
    public AccessContextManagerSettings build() throws IOException {
      return new AccessContextManagerSettings(this);
    }
  }
}
