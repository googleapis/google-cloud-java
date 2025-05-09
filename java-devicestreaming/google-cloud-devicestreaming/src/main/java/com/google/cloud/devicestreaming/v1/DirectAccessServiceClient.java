/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.devicestreaming.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devicestreaming.v1.stub.DirectAccessServiceStub;
import com.google.cloud.devicestreaming.v1.stub.DirectAccessServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for allocating Android devices and interacting with the
 * live-allocated devices.
 *
 * <p>Each Session will wait for available capacity, at a higher priority over Test Execution. When
 * allocated, the session will be exposed through a stream for integration.
 *
 * <p>DirectAccessService is currently available as a preview to select developers. You can register
 * today on behalf of you and your team at
 * https://developer.android.com/studio/preview/android-device-streaming
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
 * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   DeviceSession deviceSession = DeviceSession.newBuilder().build();
 *   String deviceSessionId = "deviceSessionId-544276325";
 *   DeviceSession response =
 *       directAccessServiceClient.createDeviceSession(parent, deviceSession, deviceSessionId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DirectAccessServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeviceSession</td>
 *      <td><p> Creates a DeviceSession.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeviceSession(CreateDeviceSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDeviceSession(ProjectName parent, DeviceSession deviceSession, String deviceSessionId)
 *           <li><p> createDeviceSession(String parent, DeviceSession deviceSession, String deviceSessionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeviceSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeviceSessions</td>
 *      <td><p> Lists DeviceSessions owned by the project user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeviceSessions(ListDeviceSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeviceSessions(ProjectName parent)
 *           <li><p> listDeviceSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeviceSessionsPagedCallable()
 *           <li><p> listDeviceSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeviceSession</td>
 *      <td><p> Gets a DeviceSession, which documents the allocation status and whether the device is allocated. Clients making requests from this API must poll GetDeviceSession.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeviceSession(GetDeviceSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeviceSession(DeviceSessionName name)
 *           <li><p> getDeviceSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeviceSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelDeviceSession</td>
 *      <td><p> Cancel a DeviceSession. This RPC changes the DeviceSession to state FINISHED and terminates all connections. Canceled sessions are not deleted and can be retrieved or listed by the user until they expire based on the 28 day deletion policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelDeviceSession(CancelDeviceSessionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelDeviceSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeviceSession</td>
 *      <td><p> Updates the current DeviceSession to the fields described by the update_mask.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeviceSession(UpdateDeviceSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDeviceSession(DeviceSession deviceSession, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeviceSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AdbConnect</td>
 *      <td><p> Exposes an ADB connection if the device supports ADB. gRPC headers are used to authenticate the Connect RPC, as well as associate to a particular DeviceSession. In particular, the user must specify the "X-Omnilab-Session-Name" header.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> adbConnectCallable()
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
 * <p>This class can be customized by passing in a custom instance of DirectAccessServiceSettings to
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
 * DirectAccessServiceSettings directAccessServiceSettings =
 *     DirectAccessServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DirectAccessServiceClient directAccessServiceClient =
 *     DirectAccessServiceClient.create(directAccessServiceSettings);
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
 * DirectAccessServiceSettings directAccessServiceSettings =
 *     DirectAccessServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DirectAccessServiceClient directAccessServiceClient =
 *     DirectAccessServiceClient.create(directAccessServiceSettings);
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
 * DirectAccessServiceSettings directAccessServiceSettings =
 *     DirectAccessServiceSettings.newHttpJsonBuilder().build();
 * DirectAccessServiceClient directAccessServiceClient =
 *     DirectAccessServiceClient.create(directAccessServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DirectAccessServiceClient implements BackgroundResource {
  private final DirectAccessServiceSettings settings;
  private final DirectAccessServiceStub stub;

  /** Constructs an instance of DirectAccessServiceClient with default settings. */
  public static final DirectAccessServiceClient create() throws IOException {
    return create(DirectAccessServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DirectAccessServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DirectAccessServiceClient create(DirectAccessServiceSettings settings)
      throws IOException {
    return new DirectAccessServiceClient(settings);
  }

  /**
   * Constructs an instance of DirectAccessServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DirectAccessServiceSettings).
   */
  public static final DirectAccessServiceClient create(DirectAccessServiceStub stub) {
    return new DirectAccessServiceClient(stub);
  }

  /**
   * Constructs an instance of DirectAccessServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DirectAccessServiceClient(DirectAccessServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DirectAccessServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DirectAccessServiceClient(DirectAccessServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DirectAccessServiceSettings getSettings() {
    return settings;
  }

  public DirectAccessServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   DeviceSession deviceSession = DeviceSession.newBuilder().build();
   *   String deviceSessionId = "deviceSessionId-544276325";
   *   DeviceSession response =
   *       directAccessServiceClient.createDeviceSession(parent, deviceSession, deviceSessionId);
   * }
   * }</pre>
   *
   * @param parent Required. The Compute Engine project under which this device will be allocated.
   *     "projects/{project_id}"
   * @param deviceSession Required. A DeviceSession to create.
   * @param deviceSessionId Optional. The ID to use for the DeviceSession, which will become the
   *     final component of the DeviceSession's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession createDeviceSession(
      ProjectName parent, DeviceSession deviceSession, String deviceSessionId) {
    CreateDeviceSessionRequest request =
        CreateDeviceSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeviceSession(deviceSession)
            .setDeviceSessionId(deviceSessionId)
            .build();
    return createDeviceSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   DeviceSession deviceSession = DeviceSession.newBuilder().build();
   *   String deviceSessionId = "deviceSessionId-544276325";
   *   DeviceSession response =
   *       directAccessServiceClient.createDeviceSession(parent, deviceSession, deviceSessionId);
   * }
   * }</pre>
   *
   * @param parent Required. The Compute Engine project under which this device will be allocated.
   *     "projects/{project_id}"
   * @param deviceSession Required. A DeviceSession to create.
   * @param deviceSessionId Optional. The ID to use for the DeviceSession, which will become the
   *     final component of the DeviceSession's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession createDeviceSession(
      String parent, DeviceSession deviceSession, String deviceSessionId) {
    CreateDeviceSessionRequest request =
        CreateDeviceSessionRequest.newBuilder()
            .setParent(parent)
            .setDeviceSession(deviceSession)
            .setDeviceSessionId(deviceSessionId)
            .build();
    return createDeviceSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   CreateDeviceSessionRequest request =
   *       CreateDeviceSessionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeviceSession(DeviceSession.newBuilder().build())
   *           .setDeviceSessionId("deviceSessionId-544276325")
   *           .build();
   *   DeviceSession response = directAccessServiceClient.createDeviceSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession createDeviceSession(CreateDeviceSessionRequest request) {
    return createDeviceSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   CreateDeviceSessionRequest request =
   *       CreateDeviceSessionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeviceSession(DeviceSession.newBuilder().build())
   *           .setDeviceSessionId("deviceSessionId-544276325")
   *           .build();
   *   ApiFuture<DeviceSession> future =
   *       directAccessServiceClient.createDeviceSessionCallable().futureCall(request);
   *   // Do something.
   *   DeviceSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeviceSessionRequest, DeviceSession>
      createDeviceSessionCallable() {
    return stub.createDeviceSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeviceSessions owned by the project user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (DeviceSession element :
   *       directAccessServiceClient.listDeviceSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent to request, e.g. "projects/{project_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceSessionsPagedResponse listDeviceSessions(ProjectName parent) {
    ListDeviceSessionsRequest request =
        ListDeviceSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeviceSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeviceSessions owned by the project user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (DeviceSession element :
   *       directAccessServiceClient.listDeviceSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent to request, e.g. "projects/{project_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceSessionsPagedResponse listDeviceSessions(String parent) {
    ListDeviceSessionsRequest request =
        ListDeviceSessionsRequest.newBuilder().setParent(parent).build();
    return listDeviceSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeviceSessions owned by the project user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   ListDeviceSessionsRequest request =
   *       ListDeviceSessionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DeviceSession element :
   *       directAccessServiceClient.listDeviceSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeviceSessionsPagedResponse listDeviceSessions(
      ListDeviceSessionsRequest request) {
    return listDeviceSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeviceSessions owned by the project user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   ListDeviceSessionsRequest request =
   *       ListDeviceSessionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DeviceSession> future =
   *       directAccessServiceClient.listDeviceSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeviceSession element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable() {
    return stub.listDeviceSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeviceSessions owned by the project user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   ListDeviceSessionsRequest request =
   *       ListDeviceSessionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDeviceSessionsResponse response =
   *         directAccessServiceClient.listDeviceSessionsCallable().call(request);
   *     for (DeviceSession element : response.getDeviceSessionsList()) {
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
  public final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable() {
    return stub.listDeviceSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeviceSession, which documents the allocation status and whether the device is
   * allocated. Clients making requests from this API must poll GetDeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   DeviceSessionName name = DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]");
   *   DeviceSession response = directAccessServiceClient.getDeviceSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DeviceSession, e.g.
   *     "projects/{project_id}/deviceSessions/{session_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession getDeviceSession(DeviceSessionName name) {
    GetDeviceSessionRequest request =
        GetDeviceSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeviceSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeviceSession, which documents the allocation status and whether the device is
   * allocated. Clients making requests from this API must poll GetDeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   String name = DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString();
   *   DeviceSession response = directAccessServiceClient.getDeviceSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DeviceSession, e.g.
   *     "projects/{project_id}/deviceSessions/{session_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession getDeviceSession(String name) {
    GetDeviceSessionRequest request = GetDeviceSessionRequest.newBuilder().setName(name).build();
    return getDeviceSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeviceSession, which documents the allocation status and whether the device is
   * allocated. Clients making requests from this API must poll GetDeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   GetDeviceSessionRequest request =
   *       GetDeviceSessionRequest.newBuilder()
   *           .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
   *           .build();
   *   DeviceSession response = directAccessServiceClient.getDeviceSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession getDeviceSession(GetDeviceSessionRequest request) {
    return getDeviceSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeviceSession, which documents the allocation status and whether the device is
   * allocated. Clients making requests from this API must poll GetDeviceSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   GetDeviceSessionRequest request =
   *       GetDeviceSessionRequest.newBuilder()
   *           .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
   *           .build();
   *   ApiFuture<DeviceSession> future =
   *       directAccessServiceClient.getDeviceSessionCallable().futureCall(request);
   *   // Do something.
   *   DeviceSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable() {
    return stub.getDeviceSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel a DeviceSession. This RPC changes the DeviceSession to state FINISHED and terminates all
   * connections. Canceled sessions are not deleted and can be retrieved or listed by the user until
   * they expire based on the 28 day deletion policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   CancelDeviceSessionRequest request =
   *       CancelDeviceSessionRequest.newBuilder()
   *           .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
   *           .build();
   *   directAccessServiceClient.cancelDeviceSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDeviceSession(CancelDeviceSessionRequest request) {
    cancelDeviceSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel a DeviceSession. This RPC changes the DeviceSession to state FINISHED and terminates all
   * connections. Canceled sessions are not deleted and can be retrieved or listed by the user until
   * they expire based on the 28 day deletion policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   CancelDeviceSessionRequest request =
   *       CancelDeviceSessionRequest.newBuilder()
   *           .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       directAccessServiceClient.cancelDeviceSessionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable() {
    return stub.cancelDeviceSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the current DeviceSession to the fields described by the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   DeviceSession deviceSession = DeviceSession.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeviceSession response =
   *       directAccessServiceClient.updateDeviceSession(deviceSession, updateMask);
   * }
   * }</pre>
   *
   * @param deviceSession Required. DeviceSession to update. The DeviceSession's `name` field is
   *     used to identify the session to update "projects/{project_id}/deviceSessions/{session_id}"
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession updateDeviceSession(
      DeviceSession deviceSession, FieldMask updateMask) {
    UpdateDeviceSessionRequest request =
        UpdateDeviceSessionRequest.newBuilder()
            .setDeviceSession(deviceSession)
            .setUpdateMask(updateMask)
            .build();
    return updateDeviceSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the current DeviceSession to the fields described by the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   UpdateDeviceSessionRequest request =
   *       UpdateDeviceSessionRequest.newBuilder()
   *           .setDeviceSession(DeviceSession.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DeviceSession response = directAccessServiceClient.updateDeviceSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeviceSession updateDeviceSession(UpdateDeviceSessionRequest request) {
    return updateDeviceSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the current DeviceSession to the fields described by the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   UpdateDeviceSessionRequest request =
   *       UpdateDeviceSessionRequest.newBuilder()
   *           .setDeviceSession(DeviceSession.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DeviceSession> future =
   *       directAccessServiceClient.updateDeviceSessionCallable().futureCall(request);
   *   // Do something.
   *   DeviceSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeviceSessionRequest, DeviceSession>
      updateDeviceSessionCallable() {
    return stub.updateDeviceSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exposes an ADB connection if the device supports ADB. gRPC headers are used to authenticate the
   * Connect RPC, as well as associate to a particular DeviceSession. In particular, the user must
   * specify the "X-Omnilab-Session-Name" header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
   *   BidiStream<AdbMessage, DeviceMessage> bidiStream =
   *       directAccessServiceClient.adbConnectCallable().call();
   *   AdbMessage request = AdbMessage.newBuilder().build();
   *   bidiStream.send(request);
   *   for (DeviceMessage response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<AdbMessage, DeviceMessage> adbConnectCallable() {
    return stub.adbConnectCallable();
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

  public static class ListDeviceSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListDeviceSessionsRequest,
          ListDeviceSessionsResponse,
          DeviceSession,
          ListDeviceSessionsPage,
          ListDeviceSessionsFixedSizeCollection> {

    public static ApiFuture<ListDeviceSessionsPagedResponse> createAsync(
        PageContext<ListDeviceSessionsRequest, ListDeviceSessionsResponse, DeviceSession> context,
        ApiFuture<ListDeviceSessionsResponse> futureResponse) {
      ApiFuture<ListDeviceSessionsPage> futurePage =
          ListDeviceSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeviceSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeviceSessionsPagedResponse(ListDeviceSessionsPage page) {
      super(page, ListDeviceSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeviceSessionsPage
      extends AbstractPage<
          ListDeviceSessionsRequest,
          ListDeviceSessionsResponse,
          DeviceSession,
          ListDeviceSessionsPage> {

    private ListDeviceSessionsPage(
        PageContext<ListDeviceSessionsRequest, ListDeviceSessionsResponse, DeviceSession> context,
        ListDeviceSessionsResponse response) {
      super(context, response);
    }

    private static ListDeviceSessionsPage createEmptyPage() {
      return new ListDeviceSessionsPage(null, null);
    }

    @Override
    protected ListDeviceSessionsPage createPage(
        PageContext<ListDeviceSessionsRequest, ListDeviceSessionsResponse, DeviceSession> context,
        ListDeviceSessionsResponse response) {
      return new ListDeviceSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeviceSessionsPage> createPageAsync(
        PageContext<ListDeviceSessionsRequest, ListDeviceSessionsResponse, DeviceSession> context,
        ApiFuture<ListDeviceSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeviceSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeviceSessionsRequest,
          ListDeviceSessionsResponse,
          DeviceSession,
          ListDeviceSessionsPage,
          ListDeviceSessionsFixedSizeCollection> {

    private ListDeviceSessionsFixedSizeCollection(
        List<ListDeviceSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeviceSessionsFixedSizeCollection createEmptyCollection() {
      return new ListDeviceSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeviceSessionsFixedSizeCollection createCollection(
        List<ListDeviceSessionsPage> pages, int collectionSize) {
      return new ListDeviceSessionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
