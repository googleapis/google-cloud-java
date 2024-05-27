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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.ControlServiceStub;
import com.google.cloud.discoveryengine.v1.stub.ControlServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for performing CRUD operations on Controls. Controls allow for
 * custom logic to be implemented in the serving path. Controls need to be attached to a Serving
 * Config to be considered during a request.
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
 *   DataStoreName parent =
 *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   Control control = Control.newBuilder().build();
 *   String controlId = "controlId-395080872";
 *   Control response = controlServiceClient.createControl(parent, control, controlId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ControlServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateControl</td>
 *      <td><p> Creates a Control.
 * <p>  By default 1000 controls are allowed for a data store. A request can be submitted to adjust this limit. If the [Control][google.cloud.discoveryengine.v1.Control] to create already exists, an ALREADY_EXISTS error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createControl(CreateControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createControl(DataStoreName parent, Control control, String controlId)
 *           <li><p> createControl(String parent, Control control, String controlId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteControl</td>
 *      <td><p> Deletes a Control.
 * <p>  If the [Control][google.cloud.discoveryengine.v1.Control] to delete does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteControl(DeleteControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteControl(ControlName name)
 *           <li><p> deleteControl(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateControl</td>
 *      <td><p> Updates a Control.
 * <p>  [Control][google.cloud.discoveryengine.v1.Control] action type cannot be changed. If the [Control][google.cloud.discoveryengine.v1.Control] to update does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateControl(UpdateControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateControl(Control control, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetControl</td>
 *      <td><p> Gets a Control.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getControl(GetControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getControl(ControlName name)
 *           <li><p> getControl(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListControls</td>
 *      <td><p> Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listControls(ListControlsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listControls(DataStoreName parent)
 *           <li><p> listControls(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listControlsPagedCallable()
 *           <li><p> listControlsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
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
 *     ControlServiceSettings.newHttpJsonBuilder().build();
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
   * <p>By default 1000 controls are allowed for a data store. A request can be submitted to adjust
   * this limit. If the [Control][google.cloud.discoveryengine.v1.Control] to create already exists,
   * an ALREADY_EXISTS error is returned.
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
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   Control control = Control.newBuilder().build();
   *   String controlId = "controlId-395080872";
   *   Control response = controlServiceClient.createControl(parent, control, controlId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}`
   * @param control Required. The Control to create.
   * @param controlId Required. The ID to use for the Control, which will become the final component
   *     of the Control's resource name.
   *     <p>This value must be within 1-63 characters. Valid characters are /[a-z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Control createControl(DataStoreName parent, Control control, String controlId) {
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
   * <p>By default 1000 controls are allowed for a data store. A request can be submitted to adjust
   * this limit. If the [Control][google.cloud.discoveryengine.v1.Control] to create already exists,
   * an ALREADY_EXISTS error is returned.
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
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   Control control = Control.newBuilder().build();
   *   String controlId = "controlId-395080872";
   *   Control response = controlServiceClient.createControl(parent, control, controlId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}`
   * @param control Required. The Control to create.
   * @param controlId Required. The ID to use for the Control, which will become the final component
   *     of the Control's resource name.
   *     <p>This value must be within 1-63 characters. Valid characters are /[a-z][0-9]-_/.
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
   * <p>By default 1000 controls are allowed for a data store. A request can be submitted to adjust
   * this limit. If the [Control][google.cloud.discoveryengine.v1.Control] to create already exists,
   * an ALREADY_EXISTS error is returned.
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
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
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
   * <p>By default 1000 controls are allowed for a data store. A request can be submitted to adjust
   * this limit. If the [Control][google.cloud.discoveryengine.v1.Control] to create already exists,
   * an ALREADY_EXISTS error is returned.
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
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
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
   * <p>If the [Control][google.cloud.discoveryengine.v1.Control] to delete does not exist, a
   * NOT_FOUND error is returned.
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
   *   ControlName name =
   *       ControlName.ofProjectLocationDataStoreControlName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
   *   controlServiceClient.deleteControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`
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
   * <p>If the [Control][google.cloud.discoveryengine.v1.Control] to delete does not exist, a
   * NOT_FOUND error is returned.
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
   *   String name =
   *       ControlName.ofProjectLocationDataStoreControlName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *           .toString();
   *   controlServiceClient.deleteControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`
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
   * <p>If the [Control][google.cloud.discoveryengine.v1.Control] to delete does not exist, a
   * NOT_FOUND error is returned.
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
   *               ControlName.ofProjectLocationDataStoreControlName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *                   .toString())
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
   * <p>If the [Control][google.cloud.discoveryengine.v1.Control] to delete does not exist, a
   * NOT_FOUND error is returned.
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
   *               ControlName.ofProjectLocationDataStoreControlName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *                   .toString())
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
   * <p>[Control][google.cloud.discoveryengine.v1.Control] action type cannot be changed. If the
   * [Control][google.cloud.discoveryengine.v1.Control] to update does not exist, a NOT_FOUND error
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
   *   Control control = Control.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Control response = controlServiceClient.updateControl(control, updateMask);
   * }
   * }</pre>
   *
   * @param control Required. The Control to update.
   * @param updateMask Optional. Indicates which fields in the provided
   *     [Control][google.cloud.discoveryengine.v1.Control] to update. The following are NOT
   *     supported:
   *     <ul>
   *       <li>[Control.name][google.cloud.discoveryengine.v1.Control.name]
   *       <li>[Control.solution_type][google.cloud.discoveryengine.v1.Control.solution_type]
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
   * <p>[Control][google.cloud.discoveryengine.v1.Control] action type cannot be changed. If the
   * [Control][google.cloud.discoveryengine.v1.Control] to update does not exist, a NOT_FOUND error
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
   * <p>[Control][google.cloud.discoveryengine.v1.Control] action type cannot be changed. If the
   * [Control][google.cloud.discoveryengine.v1.Control] to update does not exist, a NOT_FOUND error
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
   *   ControlName name =
   *       ControlName.ofProjectLocationDataStoreControlName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
   *   Control response = controlServiceClient.getControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`
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
   *   String name =
   *       ControlName.ofProjectLocationDataStoreControlName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *           .toString();
   *   Control response = controlServiceClient.getControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Control to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`
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
   *               ControlName.ofProjectLocationDataStoreControlName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *                   .toString())
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
   *               ControlName.ofProjectLocationDataStoreControlName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
   *                   .toString())
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
   * Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].
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
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (Control element : controlServiceClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(DataStoreName parent) {
    ListControlsRequest request =
        ListControlsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].
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
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (Control element : controlServiceClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(String parent) {
    ListControlsRequest request = ListControlsRequest.newBuilder().setParent(parent).build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].
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
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
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
   * Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].
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
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
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
   * Lists all Controls by their parent [DataStore][google.cloud.discoveryengine.v1.DataStore].
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
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
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
