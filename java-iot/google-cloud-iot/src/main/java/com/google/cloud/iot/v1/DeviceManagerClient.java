/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.iot.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.iot.v1.stub.DeviceManagerStub;
import com.google.cloud.iot.v1.stub.DeviceManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Internet of Things (IoT) service. Securely connect and manage IoT devices.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the DeviceManagerClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DeviceManagerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * DeviceManagerSettings deviceManagerSettings =
 *     DeviceManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeviceManagerClient deviceManagerClient = DeviceManagerClient.create(deviceManagerSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * DeviceManagerSettings deviceManagerSettings =
 *     DeviceManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeviceManagerClient deviceManagerClient = DeviceManagerClient.create(deviceManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeviceManagerClient implements BackgroundResource {
  private final DeviceManagerSettings settings;
  private final DeviceManagerStub stub;

  /** Constructs an instance of DeviceManagerClient with default settings. */
  public static final DeviceManagerClient create() throws IOException {
    return create(DeviceManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeviceManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeviceManagerClient create(DeviceManagerSettings settings)
      throws IOException {
    return new DeviceManagerClient(settings);
  }

  /**
   * Constructs an instance of DeviceManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DeviceManagerSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DeviceManagerClient create(DeviceManagerStub stub) {
    return new DeviceManagerClient(stub);
  }

  /**
   * Constructs an instance of DeviceManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DeviceManagerClient(DeviceManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeviceManagerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DeviceManagerClient(DeviceManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeviceManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DeviceManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device registry that contains devices.
   *
   * @param parent Required. The project and cloud region where this device registry must be
   *     created. For example, `projects/example-project/locations/us-central1`.
   * @param deviceRegistry Required. The device registry. The field `name` must be empty. The server
   *     will generate that field from the device registry `id` provided and the `parent` field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry createDeviceRegistry(
      LocationName parent, DeviceRegistry deviceRegistry) {
    CreateDeviceRegistryRequest request =
        CreateDeviceRegistryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeviceRegistry(deviceRegistry)
            .build();
    return createDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device registry that contains devices.
   *
   * @param parent Required. The project and cloud region where this device registry must be
   *     created. For example, `projects/example-project/locations/us-central1`.
   * @param deviceRegistry Required. The device registry. The field `name` must be empty. The server
   *     will generate that field from the device registry `id` provided and the `parent` field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry createDeviceRegistry(String parent, DeviceRegistry deviceRegistry) {
    CreateDeviceRegistryRequest request =
        CreateDeviceRegistryRequest.newBuilder()
            .setParent(parent)
            .setDeviceRegistry(deviceRegistry)
            .build();
    return createDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device registry that contains devices.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry createDeviceRegistry(CreateDeviceRegistryRequest request) {
    return createDeviceRegistryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device registry that contains devices.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistryCallable() {
    return stub.createDeviceRegistryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a device registry configuration.
   *
   * @param name Required. The name of the device registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry getDeviceRegistry(RegistryName name) {
    GetDeviceRegistryRequest request =
        GetDeviceRegistryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a device registry configuration.
   *
   * @param name Required. The name of the device registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry getDeviceRegistry(String name) {
    GetDeviceRegistryRequest request = GetDeviceRegistryRequest.newBuilder().setName(name).build();
    return getDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a device registry configuration.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry getDeviceRegistry(GetDeviceRegistryRequest request) {
    return getDeviceRegistryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a device registry configuration.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistryCallable() {
    return stub.getDeviceRegistryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device registry configuration.
   *
   * @param deviceRegistry Required. The new values for the device registry. The `id` field must be
   *     empty, and the `name` field must indicate the path of the resource. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param updateMask Required. Only updates the `device_registry` fields indicated by this mask.
   *     The field mask must not be empty, and it must not contain fields that are immutable or only
   *     set by the server. Mutable top-level fields: `event_notification_config`, `http_config`,
   *     `mqtt_config`, and `state_notification_config`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry updateDeviceRegistry(
      DeviceRegistry deviceRegistry, FieldMask updateMask) {
    UpdateDeviceRegistryRequest request =
        UpdateDeviceRegistryRequest.newBuilder()
            .setDeviceRegistry(deviceRegistry)
            .setUpdateMask(updateMask)
            .build();
    return updateDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device registry configuration.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceRegistry updateDeviceRegistry(UpdateDeviceRegistryRequest request) {
    return updateDeviceRegistryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device registry configuration.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistryCallable() {
    return stub.updateDeviceRegistryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device registry configuration.
   *
   * @param name Required. The name of the device registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeviceRegistry(RegistryName name) {
    DeleteDeviceRegistryRequest request =
        DeleteDeviceRegistryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device registry configuration.
   *
   * @param name Required. The name of the device registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeviceRegistry(String name) {
    DeleteDeviceRegistryRequest request =
        DeleteDeviceRegistryRequest.newBuilder().setName(name).build();
    deleteDeviceRegistry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device registry configuration.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeviceRegistry(DeleteDeviceRegistryRequest request) {
    deleteDeviceRegistryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device registry configuration.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryCallable() {
    return stub.deleteDeviceRegistryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists device registries.
   *
   * @param parent Required. The project and cloud region path. For example,
   *     `projects/example-project/locations/us-central1`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceRegistriesPagedResponse listDeviceRegistries(LocationName parent) {
    ListDeviceRegistriesRequest request =
        ListDeviceRegistriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeviceRegistries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists device registries.
   *
   * @param parent Required. The project and cloud region path. For example,
   *     `projects/example-project/locations/us-central1`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceRegistriesPagedResponse listDeviceRegistries(String parent) {
    ListDeviceRegistriesRequest request =
        ListDeviceRegistriesRequest.newBuilder().setParent(parent).build();
    return listDeviceRegistries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists device registries.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceRegistriesPagedResponse listDeviceRegistries(
      ListDeviceRegistriesRequest request) {
    return listDeviceRegistriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists device registries.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesPagedCallable() {
    return stub.listDeviceRegistriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists device registries.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesCallable() {
    return stub.listDeviceRegistriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device in a device registry.
   *
   * @param parent Required. The name of the device registry where this device should be created.
   *     For example, `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param device Required. The device registration details. The field `name` must be empty. The
   *     server generates `name` from the device registry `id` and the `parent` field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device createDevice(RegistryName parent, Device device) {
    CreateDeviceRequest request =
        CreateDeviceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDevice(device)
            .build();
    return createDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device in a device registry.
   *
   * @param parent Required. The name of the device registry where this device should be created.
   *     For example, `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param device Required. The device registration details. The field `name` must be empty. The
   *     server generates `name` from the device registry `id` and the `parent` field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device createDevice(String parent, Device device) {
    CreateDeviceRequest request =
        CreateDeviceRequest.newBuilder().setParent(parent).setDevice(device).build();
    return createDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device in a device registry.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device createDevice(CreateDeviceRequest request) {
    return createDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a device in a device registry.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDeviceRequest, Device> createDeviceCallable() {
    return stub.createDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device getDevice(DeviceName name) {
    GetDeviceRequest request =
        GetDeviceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device getDevice(String name) {
    GetDeviceRequest request = GetDeviceRequest.newBuilder().setName(name).build();
    return getDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a device.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device getDevice(GetDeviceRequest request) {
    return getDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a device.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDeviceRequest, Device> getDeviceCallable() {
    return stub.getDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device.
   *
   * @param device Required. The new values for the device. The `id` and `num_id` fields must be
   *     empty, and the field `name` must specify the name path. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0`or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param updateMask Required. Only updates the `device` fields indicated by this mask. The field
   *     mask must not be empty, and it must not contain fields that are immutable or only set by
   *     the server. Mutable top-level fields: `credentials`, `blocked`, and `metadata`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device updateDevice(Device device, FieldMask updateMask) {
    UpdateDeviceRequest request =
        UpdateDeviceRequest.newBuilder().setDevice(device).setUpdateMask(updateMask).build();
    return updateDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Device updateDevice(UpdateDeviceRequest request) {
    return updateDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a device.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateDeviceRequest, Device> updateDeviceCallable() {
    return stub.updateDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDevice(DeviceName name) {
    DeleteDeviceRequest request =
        DeleteDeviceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDevice(String name) {
    DeleteDeviceRequest request = DeleteDeviceRequest.newBuilder().setName(name).build();
    deleteDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDevice(DeleteDeviceRequest request) {
    deleteDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a device.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDeviceRequest, Empty> deleteDeviceCallable() {
    return stub.deleteDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List devices in a device registry.
   *
   * @param parent Required. The device registry path. Required. For example,
   *     `projects/my-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDevicesPagedResponse listDevices(RegistryName parent) {
    ListDevicesRequest request =
        ListDevicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List devices in a device registry.
   *
   * @param parent Required. The device registry path. Required. For example,
   *     `projects/my-project/locations/us-central1/registries/my-registry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDevicesPagedResponse listDevices(String parent) {
    ListDevicesRequest request = ListDevicesRequest.newBuilder().setParent(parent).build();
    return listDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List devices in a device registry.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDevicesPagedResponse listDevices(ListDevicesRequest request) {
    return listDevicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List devices in a device registry.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDevicesRequest, ListDevicesPagedResponse>
      listDevicesPagedCallable() {
    return stub.listDevicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List devices in a device registry.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDevicesRequest, ListDevicesResponse> listDevicesCallable() {
    return stub.listDevicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the configuration for the device, which is eventually sent from the Cloud IoT Core
   * servers. Returns the modified configuration version and its metadata.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The configuration data for the device.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceConfig modifyCloudToDeviceConfig(DeviceName name, ByteString binaryData) {
    ModifyCloudToDeviceConfigRequest request =
        ModifyCloudToDeviceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setBinaryData(binaryData)
            .build();
    return modifyCloudToDeviceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the configuration for the device, which is eventually sent from the Cloud IoT Core
   * servers. Returns the modified configuration version and its metadata.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The configuration data for the device.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceConfig modifyCloudToDeviceConfig(String name, ByteString binaryData) {
    ModifyCloudToDeviceConfigRequest request =
        ModifyCloudToDeviceConfigRequest.newBuilder()
            .setName(name)
            .setBinaryData(binaryData)
            .build();
    return modifyCloudToDeviceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the configuration for the device, which is eventually sent from the Cloud IoT Core
   * servers. Returns the modified configuration version and its metadata.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceConfig modifyCloudToDeviceConfig(ModifyCloudToDeviceConfigRequest request) {
    return modifyCloudToDeviceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the configuration for the device, which is eventually sent from the Cloud IoT Core
   * servers. Returns the modified configuration version and its metadata.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigCallable() {
    return stub.modifyCloudToDeviceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device configuration in descending order (i.e.: newest
   * first).
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceConfigVersionsResponse listDeviceConfigVersions(DeviceName name) {
    ListDeviceConfigVersionsRequest request =
        ListDeviceConfigVersionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listDeviceConfigVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device configuration in descending order (i.e.: newest
   * first).
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceConfigVersionsResponse listDeviceConfigVersions(String name) {
    ListDeviceConfigVersionsRequest request =
        ListDeviceConfigVersionsRequest.newBuilder().setName(name).build();
    return listDeviceConfigVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device configuration in descending order (i.e.: newest
   * first).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceConfigVersionsResponse listDeviceConfigVersions(
      ListDeviceConfigVersionsRequest request) {
    return listDeviceConfigVersionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device configuration in descending order (i.e.: newest
   * first).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsCallable() {
    return stub.listDeviceConfigVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device state in descending order (i.e.: newest first).
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceStatesResponse listDeviceStates(DeviceName name) {
    ListDeviceStatesRequest request =
        ListDeviceStatesRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listDeviceStates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device state in descending order (i.e.: newest first).
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceStatesResponse listDeviceStates(String name) {
    ListDeviceStatesRequest request = ListDeviceStatesRequest.newBuilder().setName(name).build();
    return listDeviceStates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device state in descending order (i.e.: newest first).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceStatesResponse listDeviceStates(ListDeviceStatesRequest request) {
    return listDeviceStatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the last few versions of the device state in descending order (i.e.: newest first).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesCallable() {
    return stub.listDeviceStatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The command data to send to the device.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SendCommandToDeviceResponse sendCommandToDevice(
      DeviceName name, ByteString binaryData) {
    SendCommandToDeviceRequest request =
        SendCommandToDeviceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setBinaryData(binaryData)
            .build();
    return sendCommandToDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The command data to send to the device.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SendCommandToDeviceResponse sendCommandToDevice(String name, ByteString binaryData) {
    SendCommandToDeviceRequest request =
        SendCommandToDeviceRequest.newBuilder().setName(name).setBinaryData(binaryData).build();
    return sendCommandToDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The command data to send to the device.
   * @param subfolder Optional subfolder for the command. If empty, the command will be delivered to
   *     the /devices/{device-id}/commands topic, otherwise it will be delivered to the
   *     /devices/{device-id}/commands/{subfolder} topic. Multi-level subfolders are allowed. This
   *     field must not have more than 256 characters, and must not contain any MQTT wildcards ("+"
   *     or "#") or null characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SendCommandToDeviceResponse sendCommandToDevice(
      DeviceName name, ByteString binaryData, String subfolder) {
    SendCommandToDeviceRequest request =
        SendCommandToDeviceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setBinaryData(binaryData)
            .setSubfolder(subfolder)
            .build();
    return sendCommandToDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * @param name Required. The name of the device. For example,
   *     `projects/p0/locations/us-central1/registries/registry0/devices/device0` or
   *     `projects/p0/locations/us-central1/registries/registry0/devices/{num_id}`.
   * @param binaryData Required. The command data to send to the device.
   * @param subfolder Optional subfolder for the command. If empty, the command will be delivered to
   *     the /devices/{device-id}/commands topic, otherwise it will be delivered to the
   *     /devices/{device-id}/commands/{subfolder} topic. Multi-level subfolders are allowed. This
   *     field must not have more than 256 characters, and must not contain any MQTT wildcards ("+"
   *     or "#") or null characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SendCommandToDeviceResponse sendCommandToDevice(
      String name, ByteString binaryData, String subfolder) {
    SendCommandToDeviceRequest request =
        SendCommandToDeviceRequest.newBuilder()
            .setName(name)
            .setBinaryData(binaryData)
            .setSubfolder(subfolder)
            .build();
    return sendCommandToDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SendCommandToDeviceResponse sendCommandToDevice(SendCommandToDeviceRequest request) {
    return sendCommandToDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends a command to the specified device. In order for a device to be able to receive commands,
   * it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the
   * group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will
   * receive commands at the top-level topic /devices/{device-id}/commands as well as commands for
   * subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific
   * subfolders is not supported. If the command could not be delivered to the device, this method
   * will return an error; in particular, if the device is not subscribed, this method will return
   * FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at
   * least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the
   * device.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceCallable() {
    return stub.sendCommandToDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Associates the device with the gateway.
   *
   * @param parent Required. The name of the registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param gatewayId Required. The value of `gateway_id` can be either the device numeric ID or the
   *     user-defined device identifier.
   * @param deviceId Required. The device to associate with the specified gateway. The value of
   *     `device_id` can be either the device numeric ID or the user-defined device identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BindDeviceToGatewayResponse bindDeviceToGateway(
      RegistryName parent, String gatewayId, String deviceId) {
    BindDeviceToGatewayRequest request =
        BindDeviceToGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGatewayId(gatewayId)
            .setDeviceId(deviceId)
            .build();
    return bindDeviceToGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Associates the device with the gateway.
   *
   * @param parent Required. The name of the registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param gatewayId Required. The value of `gateway_id` can be either the device numeric ID or the
   *     user-defined device identifier.
   * @param deviceId Required. The device to associate with the specified gateway. The value of
   *     `device_id` can be either the device numeric ID or the user-defined device identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BindDeviceToGatewayResponse bindDeviceToGateway(
      String parent, String gatewayId, String deviceId) {
    BindDeviceToGatewayRequest request =
        BindDeviceToGatewayRequest.newBuilder()
            .setParent(parent)
            .setGatewayId(gatewayId)
            .setDeviceId(deviceId)
            .build();
    return bindDeviceToGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Associates the device with the gateway.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BindDeviceToGatewayResponse bindDeviceToGateway(BindDeviceToGatewayRequest request) {
    return bindDeviceToGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Associates the device with the gateway.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayCallable() {
    return stub.bindDeviceToGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the association between the device and the gateway.
   *
   * @param parent Required. The name of the registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param gatewayId Required. The value of `gateway_id` can be either the device numeric ID or the
   *     user-defined device identifier.
   * @param deviceId Required. The device to disassociate from the specified gateway. The value of
   *     `device_id` can be either the device numeric ID or the user-defined device identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(
      RegistryName parent, String gatewayId, String deviceId) {
    UnbindDeviceFromGatewayRequest request =
        UnbindDeviceFromGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGatewayId(gatewayId)
            .setDeviceId(deviceId)
            .build();
    return unbindDeviceFromGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the association between the device and the gateway.
   *
   * @param parent Required. The name of the registry. For example,
   *     `projects/example-project/locations/us-central1/registries/my-registry`.
   * @param gatewayId Required. The value of `gateway_id` can be either the device numeric ID or the
   *     user-defined device identifier.
   * @param deviceId Required. The device to disassociate from the specified gateway. The value of
   *     `device_id` can be either the device numeric ID or the user-defined device identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(
      String parent, String gatewayId, String deviceId) {
    UnbindDeviceFromGatewayRequest request =
        UnbindDeviceFromGatewayRequest.newBuilder()
            .setParent(parent)
            .setGatewayId(gatewayId)
            .setDeviceId(deviceId)
            .build();
    return unbindDeviceFromGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the association between the device and the gateway.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(
      UnbindDeviceFromGatewayRequest request) {
    return unbindDeviceFromGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the association between the device and the gateway.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayCallable() {
    return stub.unbindDeviceFromGatewayCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListDeviceRegistriesPagedResponse
      extends AbstractPagedListResponse<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          DeviceRegistry,
          ListDeviceRegistriesPage,
          ListDeviceRegistriesFixedSizeCollection> {

    public static ApiFuture<ListDeviceRegistriesPagedResponse> createAsync(
        PageContext<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
            context,
        ApiFuture<ListDeviceRegistriesResponse> futureResponse) {
      ApiFuture<ListDeviceRegistriesPage> futurePage =
          ListDeviceRegistriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDeviceRegistriesPage, ListDeviceRegistriesPagedResponse>() {
            @Override
            public ListDeviceRegistriesPagedResponse apply(ListDeviceRegistriesPage input) {
              return new ListDeviceRegistriesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDeviceRegistriesPagedResponse(ListDeviceRegistriesPage page) {
      super(page, ListDeviceRegistriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeviceRegistriesPage
      extends AbstractPage<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          DeviceRegistry,
          ListDeviceRegistriesPage> {

    private ListDeviceRegistriesPage(
        PageContext<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
            context,
        ListDeviceRegistriesResponse response) {
      super(context, response);
    }

    private static ListDeviceRegistriesPage createEmptyPage() {
      return new ListDeviceRegistriesPage(null, null);
    }

    @Override
    protected ListDeviceRegistriesPage createPage(
        PageContext<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
            context,
        ListDeviceRegistriesResponse response) {
      return new ListDeviceRegistriesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeviceRegistriesPage> createPageAsync(
        PageContext<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
            context,
        ApiFuture<ListDeviceRegistriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeviceRegistriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          DeviceRegistry,
          ListDeviceRegistriesPage,
          ListDeviceRegistriesFixedSizeCollection> {

    private ListDeviceRegistriesFixedSizeCollection(
        List<ListDeviceRegistriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeviceRegistriesFixedSizeCollection createEmptyCollection() {
      return new ListDeviceRegistriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeviceRegistriesFixedSizeCollection createCollection(
        List<ListDeviceRegistriesPage> pages, int collectionSize) {
      return new ListDeviceRegistriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDevicesPagedResponse
      extends AbstractPagedListResponse<
          ListDevicesRequest,
          ListDevicesResponse,
          Device,
          ListDevicesPage,
          ListDevicesFixedSizeCollection> {

    public static ApiFuture<ListDevicesPagedResponse> createAsync(
        PageContext<ListDevicesRequest, ListDevicesResponse, Device> context,
        ApiFuture<ListDevicesResponse> futureResponse) {
      ApiFuture<ListDevicesPage> futurePage =
          ListDevicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDevicesPage, ListDevicesPagedResponse>() {
            @Override
            public ListDevicesPagedResponse apply(ListDevicesPage input) {
              return new ListDevicesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDevicesPagedResponse(ListDevicesPage page) {
      super(page, ListDevicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDevicesPage
      extends AbstractPage<ListDevicesRequest, ListDevicesResponse, Device, ListDevicesPage> {

    private ListDevicesPage(
        PageContext<ListDevicesRequest, ListDevicesResponse, Device> context,
        ListDevicesResponse response) {
      super(context, response);
    }

    private static ListDevicesPage createEmptyPage() {
      return new ListDevicesPage(null, null);
    }

    @Override
    protected ListDevicesPage createPage(
        PageContext<ListDevicesRequest, ListDevicesResponse, Device> context,
        ListDevicesResponse response) {
      return new ListDevicesPage(context, response);
    }

    @Override
    public ApiFuture<ListDevicesPage> createPageAsync(
        PageContext<ListDevicesRequest, ListDevicesResponse, Device> context,
        ApiFuture<ListDevicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDevicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDevicesRequest,
          ListDevicesResponse,
          Device,
          ListDevicesPage,
          ListDevicesFixedSizeCollection> {

    private ListDevicesFixedSizeCollection(List<ListDevicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDevicesFixedSizeCollection createEmptyCollection() {
      return new ListDevicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDevicesFixedSizeCollection createCollection(
        List<ListDevicesPage> pages, int collectionSize) {
      return new ListDevicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
