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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.stub.SessionServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.SessionServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Sessions and Session-related resources.
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
 * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
 *   DataStoreName parent =
 *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   Session session = Session.newBuilder().build();
 *   Session response = sessionServiceClient.createSession(parent, session);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SessionServiceClient object to clean up resources such
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
 *      <td><p> CreateSession</td>
 *      <td><p> Creates a Session.
 * <p>  If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create already exists, an ALREADY_EXISTS error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSession(CreateSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSession(DataStoreName parent, Session session)
 *           <li><p> createSession(String parent, Session session)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSession</td>
 *      <td><p> Deletes a Session.
 * <p>  If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSession(DeleteSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSession(SessionName name)
 *           <li><p> deleteSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSession</td>
 *      <td><p> Updates a Session.
 * <p>  [Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot be changed. If the [Session][google.cloud.discoveryengine.v1alpha.Session] to update does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSession(UpdateSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSession(Session session, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSession</td>
 *      <td><p> Gets a Session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSession(GetSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSession(SessionName name)
 *           <li><p> getSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSessions</td>
 *      <td><p> Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSessions(ListSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSessions(DataStoreName parent)
 *           <li><p> listSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSessionsPagedCallable()
 *           <li><p> listSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFiles</td>
 *      <td><p> Lists metadata for all files in the current session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFiles(ListFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFiles(SessionName parent)
 *           <li><p> listFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFilesPagedCallable()
 *           <li><p> listFilesCallable()
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
 * <p>This class can be customized by passing in a custom instance of SessionServiceSettings to
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newHttpJsonBuilder().build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SessionServiceClient implements BackgroundResource {
  private final SessionServiceSettings settings;
  private final SessionServiceStub stub;

  /** Constructs an instance of SessionServiceClient with default settings. */
  public static final SessionServiceClient create() throws IOException {
    return create(SessionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SessionServiceClient create(SessionServiceSettings settings)
      throws IOException {
    return new SessionServiceClient(settings);
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SessionServiceSettings).
   */
  public static final SessionServiceClient create(SessionServiceStub stub) {
    return new SessionServiceClient(stub);
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SessionServiceClient(SessionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SessionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SessionServiceClient(SessionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SessionServiceSettings getSettings() {
    return settings;
  }

  public SessionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   Session session = Session.newBuilder().build();
   *   Session response = sessionServiceClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}`
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(DataStoreName parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSession(session)
            .build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   Session session = Session.newBuilder().build();
   *   Session response = sessionServiceClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}`
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(String parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder().setParent(parent).setSession(session).build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   Session response = sessionServiceClient.createSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(CreateSessionRequest request) {
    return createSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   ApiFuture<Session> future = sessionServiceClient.createSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return stub.createSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   SessionName name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
   *   sessionServiceClient.deleteSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to delete. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(SessionName name) {
    DeleteSessionRequest request =
        DeleteSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   String name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *           .toString();
   *   sessionServiceClient.deleteSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to delete. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(String name) {
    DeleteSessionRequest request = DeleteSessionRequest.newBuilder().setName(name).build();
    deleteSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   DeleteSessionRequest request =
   *       DeleteSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   sessionServiceClient.deleteSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(DeleteSessionRequest request) {
    deleteSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1alpha.Session] to delete does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   DeleteSessionRequest request =
   *       DeleteSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = sessionServiceClient.deleteSessionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return stub.deleteSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot be changed. If
   * the [Session][google.cloud.discoveryengine.v1alpha.Session] to update does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   Session session = Session.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Session response = sessionServiceClient.updateSession(session, updateMask);
   * }
   * }</pre>
   *
   * @param session Required. The Session to update.
   * @param updateMask Indicates which fields in the provided
   *     [Session][google.cloud.discoveryengine.v1alpha.Session] to update. The following are NOT
   *     supported:
   *     <ul>
   *       <li>[Session.name][google.cloud.discoveryengine.v1alpha.Session.name]
   *     </ul>
   *     <p>If not set or empty, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session updateSession(Session session, FieldMask updateMask) {
    UpdateSessionRequest request =
        UpdateSessionRequest.newBuilder().setSession(session).setUpdateMask(updateMask).build();
    return updateSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot be changed. If
   * the [Session][google.cloud.discoveryengine.v1alpha.Session] to update does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   UpdateSessionRequest request =
   *       UpdateSessionRequest.newBuilder()
   *           .setSession(Session.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Session response = sessionServiceClient.updateSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session updateSession(UpdateSessionRequest request) {
    return updateSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1alpha.Session] action type cannot be changed. If
   * the [Session][google.cloud.discoveryengine.v1alpha.Session] to update does not exist, a
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   UpdateSessionRequest request =
   *       UpdateSessionRequest.newBuilder()
   *           .setSession(Session.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Session> future = sessionServiceClient.updateSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    return stub.updateSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   SessionName name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
   *   Session response = sessionServiceClient.getSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to get. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(SessionName name) {
    GetSessionRequest request =
        GetSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   String name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *           .toString();
   *   Session response = sessionServiceClient.getSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to get. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(String name) {
    GetSessionRequest request = GetSessionRequest.newBuilder().setName(name).build();
    return getSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   GetSessionRequest request =
   *       GetSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setIncludeAnswerDetails(true)
   *           .build();
   *   Session response = sessionServiceClient.getSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(GetSessionRequest request) {
    return getSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   GetSessionRequest request =
   *       GetSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setIncludeAnswerDetails(true)
   *           .build();
   *   ApiFuture<Session> future = sessionServiceClient.getSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return stub.getSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (Session element : sessionServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(DataStoreName parent) {
    ListSessionsRequest request =
        ListSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (Session element : sessionServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(String parent) {
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setParent(parent).build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Session element : sessionServiceClient.listSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(ListSessionsRequest request) {
    return listSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Session> future =
   *       sessionServiceClient.listSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Session element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable() {
    return stub.listSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1alpha.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSessionsResponse response = sessionServiceClient.listSessionsCallable().call(request);
   *     for (Session element : response.getSessionsList()) {
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
  public final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return stub.listSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists metadata for all files in the current session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   SessionName parent =
   *       SessionName.ofProjectLocationCollectionEngineSessionName(
   *           "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]");
   *   for (FileMetadata element : sessionServiceClient.listFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Session. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}`
   *     Name of the session resource to which the file belong.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(SessionName parent) {
    ListFilesRequest request =
        ListFilesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists metadata for all files in the current session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   String parent =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *           .toString();
   *   for (FileMetadata element : sessionServiceClient.listFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Session. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}`
   *     Name of the session resource to which the file belong.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(String parent) {
    ListFilesRequest request = ListFilesRequest.newBuilder().setParent(parent).build();
    return listFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists metadata for all files in the current session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(
   *               SessionName.ofProjectLocationCollectionEngineSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FileMetadata element : sessionServiceClient.listFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFilesPagedResponse listFiles(ListFilesRequest request) {
    return listFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists metadata for all files in the current session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(
   *               SessionName.ofProjectLocationCollectionEngineSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FileMetadata> future =
   *       sessionServiceClient.listFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FileMetadata element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    return stub.listFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists metadata for all files in the current session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListFilesRequest request =
   *       ListFilesRequest.newBuilder()
   *           .setParent(
   *               SessionName.ofProjectLocationCollectionEngineSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]", "[SESSION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFilesResponse response = sessionServiceClient.listFilesCallable().call(request);
   *     for (FileMetadata element : response.getFilesList()) {
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
  public final UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    return stub.listFilesCallable();
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

  public static class ListSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    public static ApiFuture<ListSessionsPagedResponse> createAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      ApiFuture<ListSessionsPage> futurePage =
          ListSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSessionsPagedResponse(ListSessionsPage page) {
      super(page, ListSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSessionsPage
      extends AbstractPage<ListSessionsRequest, ListSessionsResponse, Session, ListSessionsPage> {

    private ListSessionsPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      super(context, response);
    }

    private static ListSessionsPage createEmptyPage() {
      return new ListSessionsPage(null, null);
    }

    @Override
    protected ListSessionsPage createPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      return new ListSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSessionsPage> createPageAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    private ListSessionsFixedSizeCollection(List<ListSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSessionsFixedSizeCollection createEmptyCollection() {
      return new ListSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSessionsFixedSizeCollection createCollection(
        List<ListSessionsPage> pages, int collectionSize) {
      return new ListSessionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFilesPagedResponse
      extends AbstractPagedListResponse<
          ListFilesRequest,
          ListFilesResponse,
          FileMetadata,
          ListFilesPage,
          ListFilesFixedSizeCollection> {

    public static ApiFuture<ListFilesPagedResponse> createAsync(
        PageContext<ListFilesRequest, ListFilesResponse, FileMetadata> context,
        ApiFuture<ListFilesResponse> futureResponse) {
      ApiFuture<ListFilesPage> futurePage =
          ListFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFilesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFilesPagedResponse(ListFilesPage page) {
      super(page, ListFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFilesPage
      extends AbstractPage<ListFilesRequest, ListFilesResponse, FileMetadata, ListFilesPage> {

    private ListFilesPage(
        PageContext<ListFilesRequest, ListFilesResponse, FileMetadata> context,
        ListFilesResponse response) {
      super(context, response);
    }

    private static ListFilesPage createEmptyPage() {
      return new ListFilesPage(null, null);
    }

    @Override
    protected ListFilesPage createPage(
        PageContext<ListFilesRequest, ListFilesResponse, FileMetadata> context,
        ListFilesResponse response) {
      return new ListFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListFilesPage> createPageAsync(
        PageContext<ListFilesRequest, ListFilesResponse, FileMetadata> context,
        ApiFuture<ListFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFilesRequest,
          ListFilesResponse,
          FileMetadata,
          ListFilesPage,
          ListFilesFixedSizeCollection> {

    private ListFilesFixedSizeCollection(List<ListFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFilesFixedSizeCollection createEmptyCollection() {
      return new ListFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFilesFixedSizeCollection createCollection(
        List<ListFilesPage> pages, int collectionSize) {
      return new ListFilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
