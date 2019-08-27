/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.gaming.v1alpha.stub.RealmsServiceStub;
import com.google.cloud.gaming.v1alpha.stub.RealmsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Realm provides grouping of game server clusters that are serving particular
 * gamer population.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
 *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
 *   Realm response = realmsServiceClient.getRealm(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the realmsServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RealmsServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RealmsServiceSettings realmsServiceSettings =
 *     RealmsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RealmsServiceClient realmsServiceClient =
 *     RealmsServiceClient.create(realmsServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RealmsServiceSettings realmsServiceSettings =
 *     RealmsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RealmsServiceClient realmsServiceClient =
 *     RealmsServiceClient.create(realmsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RealmsServiceClient implements BackgroundResource {
  private final RealmsServiceSettings settings;
  private final RealmsServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate REALM_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/realms/{realm}");

  /**
   * Formats a string containing the fully-qualified path to represent a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String formatRealmName(String project, String location, String realm) {
    return REALM_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "realm", realm);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("location");
  }

  /**
   * Parses the realm from the given fully-qualified path which represents a realm resource.
   *
   * @deprecated Use the {@link RealmName} class instead.
   */
  @Deprecated
  public static final String parseRealmFromRealmName(String realmName) {
    return REALM_PATH_TEMPLATE.parse(realmName).get("realm");
  }

  /** Constructs an instance of RealmsServiceClient with default settings. */
  public static final RealmsServiceClient create() throws IOException {
    return create(RealmsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RealmsServiceClient create(RealmsServiceSettings settings)
      throws IOException {
    return new RealmsServiceClient(settings);
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use RealmsServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RealmsServiceClient create(RealmsServiceStub stub) {
    return new RealmsServiceClient(stub);
  }

  /**
   * Constructs an instance of RealmsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RealmsServiceClient(RealmsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RealmsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RealmsServiceClient(RealmsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final RealmsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RealmsServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (Realm element : realmsServiceClient.listRealms(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listRealms");
    ListRealmsRequest request = ListRealmsRequest.newBuilder().setParent(parent).build();
    return listRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListRealmsRequest request = ListRealmsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Realm element : realmsServiceClient.listRealms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(ListRealmsRequest request) {
    return listRealmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListRealmsRequest request = ListRealmsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListRealmsPagedResponse&gt; future = realmsServiceClient.listRealmsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Realm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return stub.listRealmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListRealmsRequest request = ListRealmsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListRealmsResponse response = realmsServiceClient.listRealmsCallable().call(request);
   *     for (Realm element : response.getRealmsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return stub.listRealmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   Realm response = realmsServiceClient.getRealm(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the realm to retrieve, using the form:
   *     `projects/{project_id}/locations/{location}/realms/{realm_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(String name) {
    REALM_PATH_TEMPLATE.validate(name, "getRealm");
    GetRealmRequest request = GetRealmRequest.newBuilder().setName(name).build();
    return getRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   GetRealmRequest request = GetRealmRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Realm response = realmsServiceClient.getRealm(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(GetRealmRequest request) {
    return getRealmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   GetRealmRequest request = GetRealmRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Realm&gt; future = realmsServiceClient.getRealmCallable().futureCall(request);
   *   // Do something
   *   Realm response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return stub.getRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String realmId = "";
   *   Realm realm = Realm.newBuilder().build();
   *   Realm response = realmsServiceClient.createRealmAsync(formattedParent, realmId, realm).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @param realmId Required. The ID of the realm resource to be created.
   * @param realm Required. The realm resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Realm, Empty> createRealmAsync(
      String parent, String realmId, Realm realm) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createRealm");
    CreateRealmRequest request =
        CreateRealmRequest.newBuilder()
            .setParent(parent)
            .setRealmId(realmId)
            .setRealm(realm)
            .build();
    return createRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String realmId = "";
   *   Realm realm = Realm.newBuilder().build();
   *   CreateRealmRequest request = CreateRealmRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setRealmId(realmId)
   *     .setRealm(realm)
   *     .build();
   *   Realm response = realmsServiceClient.createRealmAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Realm, Empty> createRealmAsync(CreateRealmRequest request) {
    return createRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String realmId = "";
   *   Realm realm = Realm.newBuilder().build();
   *   CreateRealmRequest request = CreateRealmRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setRealmId(realmId)
   *     .setRealm(realm)
   *     .build();
   *   OperationFuture&lt;Realm, Empty&gt; future = realmsServiceClient.createRealmOperationCallable().futureCall(request);
   *   // Do something
   *   Realm response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateRealmRequest, Realm, Empty> createRealmOperationCallable() {
    return stub.createRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedParent = RealmsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String realmId = "";
   *   Realm realm = Realm.newBuilder().build();
   *   CreateRealmRequest request = CreateRealmRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setRealmId(realmId)
   *     .setRealm(realm)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = realmsServiceClient.createRealmCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return stub.createRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   realmsServiceClient.deleteRealmAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the realm to delete, using the form:
   *     `projects/{project_id}/locations/{location}/realms/{realm_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteRealmAsync(String name) {
    REALM_PATH_TEMPLATE.validate(name, "deleteRealm");
    DeleteRealmRequest request = DeleteRealmRequest.newBuilder().setName(name).build();
    return deleteRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   DeleteRealmRequest request = DeleteRealmRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   realmsServiceClient.deleteRealmAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteRealmAsync(DeleteRealmRequest request) {
    return deleteRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   DeleteRealmRequest request = DeleteRealmRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;Empty, Empty&gt; future = realmsServiceClient.deleteRealmOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteRealmRequest, Empty, Empty> deleteRealmOperationCallable() {
    return stub.deleteRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
   *   DeleteRealmRequest request = DeleteRealmRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = realmsServiceClient.deleteRealmCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return stub.deleteRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single Realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   Realm realm = Realm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Realm response = realmsServiceClient.updateRealmAsync(realm, updateMask).get();
   * }
   * </code></pre>
   *
   * @param realm Required. The realm to be updated. Only fields specified in update_mask are
   *     updated.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Realm, Empty> updateRealmAsync(Realm realm, FieldMask updateMask) {

    UpdateRealmRequest request =
        UpdateRealmRequest.newBuilder().setRealm(realm).setUpdateMask(updateMask).build();
    return updateRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single Realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   Realm realm = Realm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateRealmRequest request = UpdateRealmRequest.newBuilder()
   *     .setRealm(realm)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Realm response = realmsServiceClient.updateRealmAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Realm, Empty> updateRealmAsync(UpdateRealmRequest request) {
    return updateRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single Realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   Realm realm = Realm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateRealmRequest request = UpdateRealmRequest.newBuilder()
   *     .setRealm(realm)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;Realm, Empty&gt; future = realmsServiceClient.updateRealmOperationCallable().futureCall(request);
   *   // Do something
   *   Realm response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateRealmRequest, Realm, Empty> updateRealmOperationCallable() {
    return stub.updateRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single Realm.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
   *   Realm realm = Realm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateRealmRequest request = UpdateRealmRequest.newBuilder()
   *     .setRealm(realm)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = realmsServiceClient.updateRealmCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return stub.updateRealmCallable();
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

  public static class ListRealmsPagedResponse
      extends AbstractPagedListResponse<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    public static ApiFuture<ListRealmsPagedResponse> createAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      ApiFuture<ListRealmsPage> futurePage =
          ListRealmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRealmsPage, ListRealmsPagedResponse>() {
            @Override
            public ListRealmsPagedResponse apply(ListRealmsPage input) {
              return new ListRealmsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRealmsPagedResponse(ListRealmsPage page) {
      super(page, ListRealmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRealmsPage
      extends AbstractPage<ListRealmsRequest, ListRealmsResponse, Realm, ListRealmsPage> {

    private ListRealmsPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      super(context, response);
    }

    private static ListRealmsPage createEmptyPage() {
      return new ListRealmsPage(null, null);
    }

    @Override
    protected ListRealmsPage createPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      return new ListRealmsPage(context, response);
    }

    @Override
    public ApiFuture<ListRealmsPage> createPageAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRealmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    private ListRealmsFixedSizeCollection(List<ListRealmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRealmsFixedSizeCollection createEmptyCollection() {
      return new ListRealmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRealmsFixedSizeCollection createCollection(
        List<ListRealmsPage> pages, int collectionSize) {
      return new ListRealmsFixedSizeCollection(pages, collectionSize);
    }
  }
}
