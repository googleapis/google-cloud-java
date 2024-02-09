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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.stub.PlaybooksStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.PlaybooksStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Playbooks][google.cloud.dialogflow.cx.v3beta1.Playbook].
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
 * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
 *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   Playbook playbook = Playbook.newBuilder().build();
 *   Playbook response = playbooksClient.createPlaybook(parent, playbook);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PlaybooksClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePlaybook</td>
 *      <td><p> Creates a playbook in a specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPlaybook(CreatePlaybookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPlaybook(AgentName parent, Playbook playbook)
 *           <li><p> createPlaybook(String parent, Playbook playbook)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPlaybookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePlaybook</td>
 *      <td><p> Deletes a specified playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePlaybook(DeletePlaybookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePlaybook(PlaybookName name)
 *           <li><p> deletePlaybook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePlaybookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPlaybooks</td>
 *      <td><p> Returns a list of playbooks in the specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPlaybooks(ListPlaybooksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPlaybooks(AgentName parent)
 *           <li><p> listPlaybooks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPlaybooksPagedCallable()
 *           <li><p> listPlaybooksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPlaybook</td>
 *      <td><p> Retrieves the specified Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlaybook(GetPlaybookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlaybook(PlaybookName name)
 *           <li><p> getPlaybook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPlaybookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePlaybook</td>
 *      <td><p> Updates the specified Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePlaybook(UpdatePlaybookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePlaybook(Playbook playbook, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePlaybookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePlaybookVersion</td>
 *      <td><p> Creates a version for the specified Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPlaybookVersion(CreatePlaybookVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPlaybookVersion(PlaybookName parent, PlaybookVersion playbookVersion)
 *           <li><p> createPlaybookVersion(String parent, PlaybookVersion playbookVersion)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPlaybookVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPlaybookVersion</td>
 *      <td><p> Retrieves the specified version of the Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlaybookVersion(GetPlaybookVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlaybookVersion(PlaybookVersionName name)
 *           <li><p> getPlaybookVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPlaybookVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPlaybookVersions</td>
 *      <td><p> Lists versions for the specified Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPlaybookVersions(ListPlaybookVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPlaybookVersions(PlaybookName parent)
 *           <li><p> listPlaybookVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPlaybookVersionsPagedCallable()
 *           <li><p> listPlaybookVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePlaybookVersion</td>
 *      <td><p> Deletes the specified version of the Playbook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePlaybookVersion(DeletePlaybookVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePlaybookVersion(PlaybookVersionName name)
 *           <li><p> deletePlaybookVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePlaybookVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of PlaybooksSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlaybooksSettings playbooksSettings =
 *     PlaybooksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PlaybooksClient playbooksClient = PlaybooksClient.create(playbooksSettings);
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
 * PlaybooksSettings playbooksSettings =
 *     PlaybooksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PlaybooksClient playbooksClient = PlaybooksClient.create(playbooksSettings);
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
 * PlaybooksSettings playbooksSettings = PlaybooksSettings.newHttpJsonBuilder().build();
 * PlaybooksClient playbooksClient = PlaybooksClient.create(playbooksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PlaybooksClient implements BackgroundResource {
  private final PlaybooksSettings settings;
  private final PlaybooksStub stub;

  /** Constructs an instance of PlaybooksClient with default settings. */
  public static final PlaybooksClient create() throws IOException {
    return create(PlaybooksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PlaybooksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PlaybooksClient create(PlaybooksSettings settings) throws IOException {
    return new PlaybooksClient(settings);
  }

  /**
   * Constructs an instance of PlaybooksClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(PlaybooksSettings).
   */
  public static final PlaybooksClient create(PlaybooksStub stub) {
    return new PlaybooksClient(stub);
  }

  /**
   * Constructs an instance of PlaybooksClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected PlaybooksClient(PlaybooksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PlaybooksStubSettings) settings.getStubSettings()).createStub();
  }

  protected PlaybooksClient(PlaybooksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PlaybooksSettings getSettings() {
    return settings;
  }

  public PlaybooksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a playbook in a specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Playbook playbook = Playbook.newBuilder().build();
   *   Playbook response = playbooksClient.createPlaybook(parent, playbook);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a playbook for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param playbook Required. The playbook to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook createPlaybook(AgentName parent, Playbook playbook) {
    CreatePlaybookRequest request =
        CreatePlaybookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPlaybook(playbook)
            .build();
    return createPlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a playbook in a specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Playbook playbook = Playbook.newBuilder().build();
   *   Playbook response = playbooksClient.createPlaybook(parent, playbook);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a playbook for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param playbook Required. The playbook to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook createPlaybook(String parent, Playbook playbook) {
    CreatePlaybookRequest request =
        CreatePlaybookRequest.newBuilder().setParent(parent).setPlaybook(playbook).build();
    return createPlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a playbook in a specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   CreatePlaybookRequest request =
   *       CreatePlaybookRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPlaybook(Playbook.newBuilder().build())
   *           .build();
   *   Playbook response = playbooksClient.createPlaybook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook createPlaybook(CreatePlaybookRequest request) {
    return createPlaybookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a playbook in a specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   CreatePlaybookRequest request =
   *       CreatePlaybookRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPlaybook(Playbook.newBuilder().build())
   *           .build();
   *   ApiFuture<Playbook> future = playbooksClient.createPlaybookCallable().futureCall(request);
   *   // Do something.
   *   Playbook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePlaybookRequest, Playbook> createPlaybookCallable() {
    return stub.createPlaybookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   playbooksClient.deletePlaybook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybook(PlaybookName name) {
    DeletePlaybookRequest request =
        DeletePlaybookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   playbooksClient.deletePlaybook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybook(String name) {
    DeletePlaybookRequest request = DeletePlaybookRequest.newBuilder().setName(name).build();
    deletePlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   DeletePlaybookRequest request =
   *       DeletePlaybookRequest.newBuilder()
   *           .setName(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .build();
   *   playbooksClient.deletePlaybook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybook(DeletePlaybookRequest request) {
    deletePlaybookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   DeletePlaybookRequest request =
   *       DeletePlaybookRequest.newBuilder()
   *           .setName(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = playbooksClient.deletePlaybookCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePlaybookRequest, Empty> deletePlaybookCallable() {
    return stub.deletePlaybookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of playbooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Playbook element : playbooksClient.listPlaybooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list playbooks from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybooksPagedResponse listPlaybooks(AgentName parent) {
    ListPlaybooksRequest request =
        ListPlaybooksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPlaybooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of playbooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (Playbook element : playbooksClient.listPlaybooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list playbooks from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybooksPagedResponse listPlaybooks(String parent) {
    ListPlaybooksRequest request = ListPlaybooksRequest.newBuilder().setParent(parent).build();
    return listPlaybooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of playbooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybooksRequest request =
   *       ListPlaybooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Playbook element : playbooksClient.listPlaybooks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybooksPagedResponse listPlaybooks(ListPlaybooksRequest request) {
    return listPlaybooksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of playbooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybooksRequest request =
   *       ListPlaybooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Playbook> future = playbooksClient.listPlaybooksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Playbook element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPlaybooksRequest, ListPlaybooksPagedResponse>
      listPlaybooksPagedCallable() {
    return stub.listPlaybooksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of playbooks in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybooksRequest request =
   *       ListPlaybooksRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPlaybooksResponse response = playbooksClient.listPlaybooksCallable().call(request);
   *     for (Playbook element : response.getPlaybooksList()) {
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
  public final UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> listPlaybooksCallable() {
    return stub.listPlaybooksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   Playbook response = playbooksClient.getPlaybook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook getPlaybook(PlaybookName name) {
    GetPlaybookRequest request =
        GetPlaybookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   Playbook response = playbooksClient.getPlaybook(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook getPlaybook(String name) {
    GetPlaybookRequest request = GetPlaybookRequest.newBuilder().setName(name).build();
    return getPlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetPlaybookRequest request =
   *       GetPlaybookRequest.newBuilder()
   *           .setName(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .build();
   *   Playbook response = playbooksClient.getPlaybook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook getPlaybook(GetPlaybookRequest request) {
    return getPlaybookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetPlaybookRequest request =
   *       GetPlaybookRequest.newBuilder()
   *           .setName(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .build();
   *   ApiFuture<Playbook> future = playbooksClient.getPlaybookCallable().futureCall(request);
   *   // Do something.
   *   Playbook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPlaybookRequest, Playbook> getPlaybookCallable() {
    return stub.getPlaybookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   Playbook playbook = Playbook.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Playbook response = playbooksClient.updatePlaybook(playbook, updateMask);
   * }
   * }</pre>
   *
   * @param playbook Required. The playbook to update.
   * @param updateMask The mask to control which fields get updated. If the mask is not present, all
   *     fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook updatePlaybook(Playbook playbook, FieldMask updateMask) {
    UpdatePlaybookRequest request =
        UpdatePlaybookRequest.newBuilder().setPlaybook(playbook).setUpdateMask(updateMask).build();
    return updatePlaybook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   UpdatePlaybookRequest request =
   *       UpdatePlaybookRequest.newBuilder()
   *           .setPlaybook(Playbook.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Playbook response = playbooksClient.updatePlaybook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Playbook updatePlaybook(UpdatePlaybookRequest request) {
    return updatePlaybookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   UpdatePlaybookRequest request =
   *       UpdatePlaybookRequest.newBuilder()
   *           .setPlaybook(Playbook.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Playbook> future = playbooksClient.updatePlaybookCallable().futureCall(request);
   *   // Do something.
   *   Playbook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePlaybookRequest, Playbook> updatePlaybookCallable() {
    return stub.updatePlaybookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a version for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();
   *   PlaybookVersion response = playbooksClient.createPlaybookVersion(parent, playbookVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to create a version for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @param playbookVersion Required. The playbook version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion createPlaybookVersion(
      PlaybookName parent, PlaybookVersion playbookVersion) {
    CreatePlaybookVersionRequest request =
        CreatePlaybookVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPlaybookVersion(playbookVersion)
            .build();
    return createPlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a version for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String parent =
   *       PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();
   *   PlaybookVersion response = playbooksClient.createPlaybookVersion(parent, playbookVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to create a version for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @param playbookVersion Required. The playbook version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion createPlaybookVersion(
      String parent, PlaybookVersion playbookVersion) {
    CreatePlaybookVersionRequest request =
        CreatePlaybookVersionRequest.newBuilder()
            .setParent(parent)
            .setPlaybookVersion(playbookVersion)
            .build();
    return createPlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a version for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   CreatePlaybookVersionRequest request =
   *       CreatePlaybookVersionRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPlaybookVersion(PlaybookVersion.newBuilder().build())
   *           .build();
   *   PlaybookVersion response = playbooksClient.createPlaybookVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion createPlaybookVersion(CreatePlaybookVersionRequest request) {
    return createPlaybookVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a version for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   CreatePlaybookVersionRequest request =
   *       CreatePlaybookVersionRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPlaybookVersion(PlaybookVersion.newBuilder().build())
   *           .build();
   *   ApiFuture<PlaybookVersion> future =
   *       playbooksClient.createPlaybookVersionCallable().futureCall(request);
   *   // Do something.
   *   PlaybookVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionCallable() {
    return stub.createPlaybookVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookVersionName name =
   *       PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");
   *   PlaybookVersion response = playbooksClient.getPlaybookVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook version. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/versions/&lt;Version ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion getPlaybookVersion(PlaybookVersionName name) {
    GetPlaybookVersionRequest request =
        GetPlaybookVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String name =
   *       PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *           .toString();
   *   PlaybookVersion response = playbooksClient.getPlaybookVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook version. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/versions/&lt;Version ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion getPlaybookVersion(String name) {
    GetPlaybookVersionRequest request =
        GetPlaybookVersionRequest.newBuilder().setName(name).build();
    return getPlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetPlaybookVersionRequest request =
   *       GetPlaybookVersionRequest.newBuilder()
   *           .setName(
   *               PlaybookVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   PlaybookVersion response = playbooksClient.getPlaybookVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PlaybookVersion getPlaybookVersion(GetPlaybookVersionRequest request) {
    return getPlaybookVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetPlaybookVersionRequest request =
   *       GetPlaybookVersionRequest.newBuilder()
   *           .setName(
   *               PlaybookVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PlaybookVersion> future =
   *       playbooksClient.getPlaybookVersionCallable().futureCall(request);
   *   // Do something.
   *   PlaybookVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionCallable() {
    return stub.getPlaybookVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
   *   for (PlaybookVersion element : playbooksClient.listPlaybookVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to list versions for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybookVersionsPagedResponse listPlaybookVersions(PlaybookName parent) {
    ListPlaybookVersionsRequest request =
        ListPlaybookVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPlaybookVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String parent =
   *       PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString();
   *   for (PlaybookVersion element : playbooksClient.listPlaybookVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The playbook to list versions for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybookVersionsPagedResponse listPlaybookVersions(String parent) {
    ListPlaybookVersionsRequest request =
        ListPlaybookVersionsRequest.newBuilder().setParent(parent).build();
    return listPlaybookVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybookVersionsRequest request =
   *       ListPlaybookVersionsRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PlaybookVersion element : playbooksClient.listPlaybookVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlaybookVersionsPagedResponse listPlaybookVersions(
      ListPlaybookVersionsRequest request) {
    return listPlaybookVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybookVersionsRequest request =
   *       ListPlaybookVersionsRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PlaybookVersion> future =
   *       playbooksClient.listPlaybookVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PlaybookVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsPagedCallable() {
    return stub.listPlaybookVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions for the specified Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListPlaybookVersionsRequest request =
   *       ListPlaybookVersionsRequest.newBuilder()
   *           .setParent(
   *               PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPlaybookVersionsResponse response =
   *         playbooksClient.listPlaybookVersionsCallable().call(request);
   *     for (PlaybookVersion element : response.getPlaybookVersionsList()) {
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
  public final UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse>
      listPlaybookVersionsCallable() {
    return stub.listPlaybookVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   PlaybookVersionName name =
   *       PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");
   *   playbooksClient.deletePlaybookVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook version to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/versions/&lt;Version ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybookVersion(PlaybookVersionName name) {
    DeletePlaybookVersionRequest request =
        DeletePlaybookVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   String name =
   *       PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *           .toString();
   *   playbooksClient.deletePlaybookVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the playbook version to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/playbooks/&lt;Playbook
   *     ID&gt;/versions/&lt;Version ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybookVersion(String name) {
    DeletePlaybookVersionRequest request =
        DeletePlaybookVersionRequest.newBuilder().setName(name).build();
    deletePlaybookVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   DeletePlaybookVersionRequest request =
   *       DeletePlaybookVersionRequest.newBuilder()
   *           .setName(
   *               PlaybookVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   playbooksClient.deletePlaybookVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePlaybookVersion(DeletePlaybookVersionRequest request) {
    deletePlaybookVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified version of the Playbook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   DeletePlaybookVersionRequest request =
   *       DeletePlaybookVersionRequest.newBuilder()
   *           .setName(
   *               PlaybookVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = playbooksClient.deletePlaybookVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionCallable() {
    return stub.deletePlaybookVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : playbooksClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = playbooksClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = playbooksClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = playbooksClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = playbooksClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListPlaybooksPagedResponse
      extends AbstractPagedListResponse<
          ListPlaybooksRequest,
          ListPlaybooksResponse,
          Playbook,
          ListPlaybooksPage,
          ListPlaybooksFixedSizeCollection> {

    public static ApiFuture<ListPlaybooksPagedResponse> createAsync(
        PageContext<ListPlaybooksRequest, ListPlaybooksResponse, Playbook> context,
        ApiFuture<ListPlaybooksResponse> futureResponse) {
      ApiFuture<ListPlaybooksPage> futurePage =
          ListPlaybooksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPlaybooksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPlaybooksPagedResponse(ListPlaybooksPage page) {
      super(page, ListPlaybooksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPlaybooksPage
      extends AbstractPage<
          ListPlaybooksRequest, ListPlaybooksResponse, Playbook, ListPlaybooksPage> {

    private ListPlaybooksPage(
        PageContext<ListPlaybooksRequest, ListPlaybooksResponse, Playbook> context,
        ListPlaybooksResponse response) {
      super(context, response);
    }

    private static ListPlaybooksPage createEmptyPage() {
      return new ListPlaybooksPage(null, null);
    }

    @Override
    protected ListPlaybooksPage createPage(
        PageContext<ListPlaybooksRequest, ListPlaybooksResponse, Playbook> context,
        ListPlaybooksResponse response) {
      return new ListPlaybooksPage(context, response);
    }

    @Override
    public ApiFuture<ListPlaybooksPage> createPageAsync(
        PageContext<ListPlaybooksRequest, ListPlaybooksResponse, Playbook> context,
        ApiFuture<ListPlaybooksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPlaybooksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPlaybooksRequest,
          ListPlaybooksResponse,
          Playbook,
          ListPlaybooksPage,
          ListPlaybooksFixedSizeCollection> {

    private ListPlaybooksFixedSizeCollection(List<ListPlaybooksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPlaybooksFixedSizeCollection createEmptyCollection() {
      return new ListPlaybooksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPlaybooksFixedSizeCollection createCollection(
        List<ListPlaybooksPage> pages, int collectionSize) {
      return new ListPlaybooksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPlaybookVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          PlaybookVersion,
          ListPlaybookVersionsPage,
          ListPlaybookVersionsFixedSizeCollection> {

    public static ApiFuture<ListPlaybookVersionsPagedResponse> createAsync(
        PageContext<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
            context,
        ApiFuture<ListPlaybookVersionsResponse> futureResponse) {
      ApiFuture<ListPlaybookVersionsPage> futurePage =
          ListPlaybookVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPlaybookVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPlaybookVersionsPagedResponse(ListPlaybookVersionsPage page) {
      super(page, ListPlaybookVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPlaybookVersionsPage
      extends AbstractPage<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          PlaybookVersion,
          ListPlaybookVersionsPage> {

    private ListPlaybookVersionsPage(
        PageContext<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
            context,
        ListPlaybookVersionsResponse response) {
      super(context, response);
    }

    private static ListPlaybookVersionsPage createEmptyPage() {
      return new ListPlaybookVersionsPage(null, null);
    }

    @Override
    protected ListPlaybookVersionsPage createPage(
        PageContext<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
            context,
        ListPlaybookVersionsResponse response) {
      return new ListPlaybookVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPlaybookVersionsPage> createPageAsync(
        PageContext<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
            context,
        ApiFuture<ListPlaybookVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPlaybookVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          PlaybookVersion,
          ListPlaybookVersionsPage,
          ListPlaybookVersionsFixedSizeCollection> {

    private ListPlaybookVersionsFixedSizeCollection(
        List<ListPlaybookVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPlaybookVersionsFixedSizeCollection createEmptyCollection() {
      return new ListPlaybookVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPlaybookVersionsFixedSizeCollection createCollection(
        List<ListPlaybookVersionsPage> pages, int collectionSize) {
      return new ListPlaybookVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
