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

package google.maps.fleetengine.delivery.v1;

import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.SearchTasksPagedResponse;

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
import google.maps.fleetengine.delivery.v1.stub.DeliveryServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeliveryServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (fleetengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDeliveryVehicle to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeliveryServiceSettings.Builder deliveryServiceSettingsBuilder =
 *     DeliveryServiceSettings.newBuilder();
 * deliveryServiceSettingsBuilder
 *     .createDeliveryVehicleSettings()
 *     .setRetrySettings(
 *         deliveryServiceSettingsBuilder
 *             .createDeliveryVehicleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeliveryServiceSettings deliveryServiceSettings = deliveryServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeliveryServiceSettings extends ClientSettings<DeliveryServiceSettings> {

  /** Returns the object with the settings used for calls to createDeliveryVehicle. */
  public UnaryCallSettings<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).createDeliveryVehicleSettings();
  }

  /** Returns the object with the settings used for calls to getDeliveryVehicle. */
  public UnaryCallSettings<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).getDeliveryVehicleSettings();
  }

  /** Returns the object with the settings used for calls to updateDeliveryVehicle. */
  public UnaryCallSettings<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).updateDeliveryVehicleSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateTasks. */
  public UnaryCallSettings<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).batchCreateTasksSettings();
  }

  /** Returns the object with the settings used for calls to createTask. */
  public UnaryCallSettings<CreateTaskRequest, Task> createTaskSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).createTaskSettings();
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).getTaskSettings();
  }

  /**
   * Returns the object with the settings used for calls to searchTasks.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
      searchTasksSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).searchTasksSettings();
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public UnaryCallSettings<UpdateTaskRequest, Task> updateTaskSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).updateTaskSettings();
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).listTasksSettings();
  }

  /** Returns the object with the settings used for calls to getTaskTrackingInfo. */
  public UnaryCallSettings<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).getTaskTrackingInfoSettings();
  }

  /** Returns the object with the settings used for calls to listDeliveryVehicles. */
  public PagedCallSettings<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesSettings() {
    return ((DeliveryServiceStubSettings) getStubSettings()).listDeliveryVehiclesSettings();
  }

  public static final DeliveryServiceSettings create(DeliveryServiceStubSettings stub)
      throws IOException {
    return new DeliveryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DeliveryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DeliveryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DeliveryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DeliveryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DeliveryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DeliveryServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DeliveryServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeliveryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DeliveryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DeliveryServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DeliveryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DeliveryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DeliveryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DeliveryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DeliveryServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DeliveryServiceStubSettings.newHttpJsonBuilder());
    }

    public DeliveryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DeliveryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDeliveryVehicle. */
    public UnaryCallSettings.Builder<CreateDeliveryVehicleRequest, DeliveryVehicle>
        createDeliveryVehicleSettings() {
      return getStubSettingsBuilder().createDeliveryVehicleSettings();
    }

    /** Returns the builder for the settings used for calls to getDeliveryVehicle. */
    public UnaryCallSettings.Builder<GetDeliveryVehicleRequest, DeliveryVehicle>
        getDeliveryVehicleSettings() {
      return getStubSettingsBuilder().getDeliveryVehicleSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeliveryVehicle. */
    public UnaryCallSettings.Builder<UpdateDeliveryVehicleRequest, DeliveryVehicle>
        updateDeliveryVehicleSettings() {
      return getStubSettingsBuilder().updateDeliveryVehicleSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateTasks. */
    public UnaryCallSettings.Builder<BatchCreateTasksRequest, BatchCreateTasksResponse>
        batchCreateTasksSettings() {
      return getStubSettingsBuilder().batchCreateTasksSettings();
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public UnaryCallSettings.Builder<CreateTaskRequest, Task> createTaskSettings() {
      return getStubSettingsBuilder().createTaskSettings();
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getStubSettingsBuilder().getTaskSettings();
    }

    /**
     * Returns the builder for the settings used for calls to searchTasks.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
        searchTasksSettings() {
      return getStubSettingsBuilder().searchTasksSettings();
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    public UnaryCallSettings.Builder<UpdateTaskRequest, Task> updateTaskSettings() {
      return getStubSettingsBuilder().updateTaskSettings();
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return getStubSettingsBuilder().listTasksSettings();
    }

    /** Returns the builder for the settings used for calls to getTaskTrackingInfo. */
    public UnaryCallSettings.Builder<GetTaskTrackingInfoRequest, TaskTrackingInfo>
        getTaskTrackingInfoSettings() {
      return getStubSettingsBuilder().getTaskTrackingInfoSettings();
    }

    /** Returns the builder for the settings used for calls to listDeliveryVehicles. */
    public PagedCallSettings.Builder<
            ListDeliveryVehiclesRequest,
            ListDeliveryVehiclesResponse,
            ListDeliveryVehiclesPagedResponse>
        listDeliveryVehiclesSettings() {
      return getStubSettingsBuilder().listDeliveryVehiclesSettings();
    }

    @Override
    public DeliveryServiceSettings build() throws IOException {
      return new DeliveryServiceSettings(this);
    }
  }
}
