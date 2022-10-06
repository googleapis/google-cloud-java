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

package com.google.cloud.retail.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.stub.ControlServiceStub;
import com.google.cloud.retail.v2.stub.ControlServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for modifying Control.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   Control control = Control.newBuilder().build();
 *   String controlId = "controlId-395080872";
 *   Control response = controlServiceClient.createControl(parent, control, controlId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ControlServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ControlServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ControlServiceSettings controlServiceSettings =
 *     ControlServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ControlServiceClient controlServiceClient = ControlServiceClient.create(controlServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ControlServiceSettings controlServiceSettings =
 *     ControlServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ControlServiceClient controlServiceClient = ControlServiceClient.create(controlServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ControlServiceSettings controlServiceSettings =
 *     ControlServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ControlServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ControlServiceClient controlServiceClient = ControlServiceClient.create(controlServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ControlServiceClient implements BackgroundResource {
  private final ControlServiceSettings settings;
  private final ControlServiceStub stub;

  /** Constructs an instance of ControlServiceClient with default settings. */
  public static final ControlServiceClient create() throws IOException {
    return create(ControlServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ControlServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ControlServiceClient create(ControlServiceSettings settings)
      throws IOException {
    return new ControlServiceClient(settings);
  }

  /**
   * Constructs an instance of ControlServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ControlServiceSettings).
   */
  public static final ControlServiceClient create(ControlServiceStub stub) {
    return new ControlServiceClient(stub);
  }

  /**
   * Constructs an instance of ControlServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ControlServiceClient(ControlServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ControlServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ControlServiceClient(ControlServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ControlServiceSettings getSettings() {
    return settings;
  }

  public ControlServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to create already exists, an ALREADY_EXISTS
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   Control control = Control.newBuilder().build();
   *   String controlId = "controlId-395080872";
   *   Control response = controlServiceClient.createControl(parent, control, controlId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent catalog. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @param control Required. The Control to create.
   * @param controlId Required. The ID to use for the Control, which will become the final component
   *     of the Control's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control createControl(CatalogName parent, Control control, String controlId) {
    CreateControlRequest request =
        CreateControlRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setControl(control)
            .setControlId(controlId)
            .build();
    return createControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to create already exists, an ALREADY_EXISTS
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   Control control = Control.newBuilder().build();
   *   String controlId = "controlId-395080872";
   *   Control response = controlServiceClient.createControl(parent, control, controlId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent catalog. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @param control Required. The Control to create.
   * @param controlId Required. The ID to use for the Control, which will become the final component
   *     of the Control's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control createControl(String parent, Control control, String controlId) {
    CreateControlRequest request =
        CreateControlRequest.newBuilder()
            .setParent(parent)
            .setControl(control)
            .setControlId(controlId)
            .build();
    return createControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to create already exists, an ALREADY_EXISTS
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   CreateControlRequest request =
   *       CreateControlRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setControl(Control.newBuilder().build())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   Control response = controlServiceClient.createControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control createControl(CreateControlRequest request) {
    return createControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to create already exists, an ALREADY_EXISTS
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   CreateControlRequest request =
   *       CreateControlRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setControl(Control.newBuilder().build())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   ApiFuture<Control> future = controlServiceClient.createControlCallable().futureCall(request);
   *   // Do something.
   *   Control response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateControlRequest, Control> createControlCallable() {
    return stub.createControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to delete does not exist, a NOT_FOUND error
   * is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   ControlName name = ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]");
   *   controlServiceClient.deleteControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteControl(ControlName name) {
    DeleteControlRequest request =
        DeleteControlRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to delete does not exist, a NOT_FOUND error
   * is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   String name = ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString();
   *   controlServiceClient.deleteControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteControl(String name) {
    DeleteControlRequest request = DeleteControlRequest.newBuilder().setName(name).build();
    deleteControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to delete does not exist, a NOT_FOUND error
   * is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   DeleteControlRequest request =
   *       DeleteControlRequest.newBuilder()
   *           .setName(
   *               ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString())
   *           .build();
   *   controlServiceClient.deleteControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteControl(DeleteControlRequest request) {
    deleteControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Control.
   *
   * <p>If the [Control][google.cloud.retail.v2.Control] to delete does not exist, a NOT_FOUND error
   * is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   DeleteControlRequest request =
   *       DeleteControlRequest.newBuilder()
   *           .setName(
   *               ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = controlServiceClient.deleteControlCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable() {
    return stub.deleteControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Control.
   *
   * <p>[Control][google.cloud.retail.v2.Control] cannot be set to a different oneof field, if so an
   * INVALID_ARGUMENT is returned. If the [Control][google.cloud.retail.v2.Control] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   Control control = Control.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Control response = controlServiceClient.updateControl(control, updateMask);
   * }
   * }</pre>
   *
   * @param control Required. The Control to update.
   * @param updateMask Indicates which fields in the provided
   *     [Control][google.cloud.retail.v2.Control] to update. The following are NOT supported:
   *     <ul>
   *       <li>[Control.name][google.cloud.retail.v2.Control.name]
   *     </ul>
   *     <p>If not set or empty, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control updateControl(Control control, FieldMask updateMask) {
    UpdateControlRequest request =
        UpdateControlRequest.newBuilder().setControl(control).setUpdateMask(updateMask).build();
    return updateControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Control.
   *
   * <p>[Control][google.cloud.retail.v2.Control] cannot be set to a different oneof field, if so an
   * INVALID_ARGUMENT is returned. If the [Control][google.cloud.retail.v2.Control] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   UpdateControlRequest request =
   *       UpdateControlRequest.newBuilder()
   *           .setControl(Control.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Control response = controlServiceClient.updateControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control updateControl(UpdateControlRequest request) {
    return updateControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Control.
   *
   * <p>[Control][google.cloud.retail.v2.Control] cannot be set to a different oneof field, if so an
   * INVALID_ARGUMENT is returned. If the [Control][google.cloud.retail.v2.Control] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   UpdateControlRequest request =
   *       UpdateControlRequest.newBuilder()
   *           .setControl(Control.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Control> future = controlServiceClient.updateControlCallable().futureCall(request);
   *   // Do something.
   *   Control response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateControlRequest, Control> updateControlCallable() {
    return stub.updateControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   ControlName name = ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]");
   *   Control response = controlServiceClient.getControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to get. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control getControl(ControlName name) {
    GetControlRequest request =
        GetControlRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   String name = ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString();
   *   Control response = controlServiceClient.getControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to get. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control getControl(String name) {
    GetControlRequest request = GetControlRequest.newBuilder().setName(name).build();
    return getControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   GetControlRequest request =
   *       GetControlRequest.newBuilder()
   *           .setName(
   *               ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString())
   *           .build();
   *   Control response = controlServiceClient.getControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control getControl(GetControlRequest request) {
    return getControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   GetControlRequest request =
   *       GetControlRequest.newBuilder()
   *           .setName(
   *               ControlName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CONTROL]").toString())
   *           .build();
   *   ApiFuture<Control> future = controlServiceClient.getControlCallable().futureCall(request);
   *   // Do something.
   *   Control response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetControlRequest, Control> getControlCallable() {
    return stub.getControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [Catalog][google.cloud.retail.v2.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   for (Control element : controlServiceClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The catalog resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(CatalogName parent) {
    ListControlsRequest request =
        ListControlsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [Catalog][google.cloud.retail.v2.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   for (Control element : controlServiceClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The catalog resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(String parent) {
    ListControlsRequest request = ListControlsRequest.newBuilder().setParent(parent).build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [Catalog][google.cloud.retail.v2.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Control element : controlServiceClient.listControls(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(ListControlsRequest request) {
    return listControlsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [Catalog][google.cloud.retail.v2.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Control> future =
   *       controlServiceClient.listControlsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Control element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable() {
    return stub.listControlsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [Catalog][google.cloud.retail.v2.Catalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListControlsResponse response = controlServiceClient.listControlsCallable().call(request);
   *     for (Control element : response.getControlsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return stub.listControlsCallable();
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

  public static class ListControlsPagedResponse
      extends AbstractPagedListResponse<
          ListControlsRequest,
          ListControlsResponse,
          Control,
          ListControlsPage,
          ListControlsFixedSizeCollection> {

    public static ApiFuture<ListControlsPagedResponse> createAsync(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ApiFuture<ListControlsResponse> futureResponse) {
      ApiFuture<ListControlsPage> futurePage =
          ListControlsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListControlsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListControlsPagedResponse(ListControlsPage page) {
      super(page, ListControlsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListControlsPage
      extends AbstractPage<ListControlsRequest, ListControlsResponse, Control, ListControlsPage> {

    private ListControlsPage(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ListControlsResponse response) {
      super(context, response);
    }

    private static ListControlsPage createEmptyPage() {
      return new ListControlsPage(null, null);
    }

    @Override
    protected ListControlsPage createPage(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ListControlsResponse response) {
      return new ListControlsPage(context, response);
    }

    @Override
    public ApiFuture<ListControlsPage> createPageAsync(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ApiFuture<ListControlsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListControlsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListControlsRequest,
          ListControlsResponse,
          Control,
          ListControlsPage,
          ListControlsFixedSizeCollection> {

    private ListControlsFixedSizeCollection(List<ListControlsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListControlsFixedSizeCollection createEmptyCollection() {
      return new ListControlsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListControlsFixedSizeCollection createCollection(
        List<ListControlsPage> pages, int collectionSize) {
      return new ListControlsFixedSizeCollection(pages, collectionSize);
    }
  }
}
