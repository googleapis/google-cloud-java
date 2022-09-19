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

package com.google.cloud.run.v2;

import static com.google.cloud.run.v2.ServicesClient.ListServicesPagedResponse;

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
import com.google.cloud.run.v2.stub.ServicesStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServicesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (run.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServicesSettings.Builder servicesSettingsBuilder = ServicesSettings.newBuilder();
 * servicesSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         servicesSettingsBuilder.getServiceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServicesSettings servicesSettings = servicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServicesSettings extends ClientSettings<ServicesSettings> {

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return ((ServicesStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, Service>
      createServiceOperationSettings() {
    return ((ServicesStubSettings) getStubSettings()).createServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((ServicesStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((ServicesStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return ((ServicesStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, Service>
      updateServiceOperationSettings() {
    return ((ServicesStubSettings) getStubSettings()).updateServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return ((ServicesStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Service, Service>
      deleteServiceOperationSettings() {
    return ((ServicesStubSettings) getStubSettings()).deleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ServicesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ServicesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ServicesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ServicesSettings create(ServicesStubSettings stub) throws IOException {
    return new ServicesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ServicesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ServicesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ServicesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ServicesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ServicesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ServicesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ServicesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServicesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ServicesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ServicesSettings. */
  public static class Builder extends ClientSettings.Builder<ServicesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ServicesStubSettings.newBuilder(clientContext));
    }

    protected Builder(ServicesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ServicesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ServicesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ServicesStubSettings.newHttpJsonBuilder());
    }

    public ServicesStubSettings.Builder getStubSettingsBuilder() {
      return ((ServicesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, Service>
        createServiceOperationSettings() {
      return getStubSettingsBuilder().createServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, Service>
        updateServiceOperationSettings() {
      return getStubSettingsBuilder().updateServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Service, Service>
        deleteServiceOperationSettings() {
      return getStubSettingsBuilder().deleteServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ServicesSettings build() throws IOException {
      return new ServicesSettings(this);
    }
  }
}
