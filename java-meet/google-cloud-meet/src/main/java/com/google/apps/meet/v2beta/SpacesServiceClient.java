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

package com.google.apps.meet.v2beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2beta.stub.SpacesServiceStub;
import com.google.apps.meet.v2beta.stub.SpacesServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: REST API for services dealing with spaces.
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
 * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
 *   Space space = Space.newBuilder().build();
 *   Space response = spacesServiceClient.createSpace(space);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SpacesServiceClient object to clean up resources such
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
 *      <td><p> CreateSpace</td>
 *      <td><p> Creates a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpace(CreateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSpace(Space space)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpace</td>
 *      <td><p> Gets details about a meeting space.
 * <p>  For an example, see [Get a meeting space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpace(GetSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpace(SpaceName name)
 *           <li><p> getSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpace</td>
 *      <td><p> Updates details about a meeting space.
 * <p>  For an example, see [Update a meeting space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpace(UpdateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpace(Space space, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EndActiveConference</td>
 *      <td><p> Ends an active conference (if there's one).
 * <p>  For an example, see [End active conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> endActiveConference(EndActiveConferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> endActiveConference(SpaceName name)
 *           <li><p> endActiveConference(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> endActiveConferenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMember</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview): Create a member.
 * <p>  This API supports the `fields` parameter in [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the `fields` parameter is omitted, this API response will default to "name,email,role,user".</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMember(CreateMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMember(SpaceName parent, Member member)
 *           <li><p> createMember(String parent, Member member)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMember</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview): Get a member.
 * <p>  This API supports the `fields` parameter in [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the `fields` parameter is omitted, this API response will default to "name,email,role,user".</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMember(GetMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMember(MemberName name)
 *           <li><p> getMember(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMembers</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview): List members.
 * <p>  This API supports the `fields` parameter in [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the `fields` parameter is omitted this API response will default to "name,email,role,user".</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMembers(ListMembersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMembers(SpaceName parent)
 *           <li><p> listMembers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMembersPagedCallable()
 *           <li><p> listMembersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMember</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview): Delete the member who was previously assigned roles in the space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMember(DeleteMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMember(MemberName name)
 *           <li><p> deleteMember(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMemberCallable()
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
 * <p>This class can be customized by passing in a custom instance of SpacesServiceSettings to
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newHttpJsonBuilder().build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SpacesServiceClient implements BackgroundResource {
  private final SpacesServiceSettings settings;
  private final SpacesServiceStub stub;

  /** Constructs an instance of SpacesServiceClient with default settings. */
  public static final SpacesServiceClient create() throws IOException {
    return create(SpacesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpacesServiceClient create(SpacesServiceSettings settings)
      throws IOException {
    return new SpacesServiceClient(settings);
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SpacesServiceSettings).
   */
  public static final SpacesServiceClient create(SpacesServiceStub stub) {
    return new SpacesServiceClient(stub);
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SpacesServiceClient(SpacesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SpacesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SpacesServiceClient(SpacesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SpacesServiceSettings getSettings() {
    return settings;
  }

  public SpacesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   Space response = spacesServiceClient.createSpace(space);
   * }
   * }</pre>
   *
   * @param space Space to be created. As of May 2023, the input space can be empty. Later on the
   *     input space can be non-empty when space configuration is introduced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(Space space) {
    CreateSpaceRequest request = CreateSpaceRequest.newBuilder().setSpace(space).build();
    return createSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder().setSpace(Space.newBuilder().build()).build();
   *   Space response = spacesServiceClient.createSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(CreateSpaceRequest request) {
    return createSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder().setSpace(Space.newBuilder().build()).build();
   *   ApiFuture<Space> future = spacesServiceClient.createSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return stub.createSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a meeting space.
   *
   * <p>For an example, see [Get a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   Space response = spacesServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   *     <p>Format: `spaces/{space}` or `spaces/{meetingCode}`.
   *     <p>`{space}` is the resource identifier for the space. It's a unique, server-generated ID
   *     and is case sensitive. For example, `jQCFfuBOdN5z`.
   *     <p>`{meetingCode}` is an alias for the space. It's a typeable, unique character string and
   *     is non-case sensitive. For example, `abc-mnop-xyz`. The maximum length is 128 characters.
   *     <p>A `meetingCode` shouldn't be stored long term as it can become dissociated from a
   *     meeting space and can be reused for different meeting spaces in the future. Generally, a
   *     `meetingCode` expires 365 days after last use. For more information, see [Learn about
   *     meeting codes in Google Meet](https://support.google.com/meet/answer/10710509).
   *     <p>For more information, see [How Meet identifies a meeting
   *     space](https://developers.google.com/meet/api/guides/meeting-spaces#identify-meeting-space).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(SpaceName name) {
    GetSpaceRequest request =
        GetSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a meeting space.
   *
   * <p>For an example, see [Get a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   Space response = spacesServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   *     <p>Format: `spaces/{space}` or `spaces/{meetingCode}`.
   *     <p>`{space}` is the resource identifier for the space. It's a unique, server-generated ID
   *     and is case sensitive. For example, `jQCFfuBOdN5z`.
   *     <p>`{meetingCode}` is an alias for the space. It's a typeable, unique character string and
   *     is non-case sensitive. For example, `abc-mnop-xyz`. The maximum length is 128 characters.
   *     <p>A `meetingCode` shouldn't be stored long term as it can become dissociated from a
   *     meeting space and can be reused for different meeting spaces in the future. Generally, a
   *     `meetingCode` expires 365 days after last use. For more information, see [Learn about
   *     meeting codes in Google Meet](https://support.google.com/meet/answer/10710509).
   *     <p>For more information, see [How Meet identifies a meeting
   *     space](https://developers.google.com/meet/api/guides/meeting-spaces#identify-meeting-space).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(String name) {
    GetSpaceRequest request = GetSpaceRequest.newBuilder().setName(name).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a meeting space.
   *
   * <p>For an example, see [Get a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder().setName(SpaceName.of("[SPACE]").toString()).build();
   *   Space response = spacesServiceClient.getSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(GetSpaceRequest request) {
    return getSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a meeting space.
   *
   * <p>For an example, see [Get a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder().setName(SpaceName.of("[SPACE]").toString()).build();
   *   ApiFuture<Space> future = spacesServiceClient.getSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return stub.getSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates details about a meeting space.
   *
   * <p>For an example, see [Update a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Space response = spacesServiceClient.updateSpace(space, updateMask);
   * }
   * }</pre>
   *
   * @param space Required. Space to be updated.
   * @param updateMask Optional. Field mask used to specify the fields to be updated in the space.
   *     If update_mask isn't provided(not set, set with empty paths, or only has "" as paths), it
   *     defaults to update all fields provided with values in the request. Using "&#42;" as
   *     update_mask will update all fields, including deleting fields not set in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(Space space, FieldMask updateMask) {
    UpdateSpaceRequest request =
        UpdateSpaceRequest.newBuilder().setSpace(space).setUpdateMask(updateMask).build();
    return updateSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates details about a meeting space.
   *
   * <p>For an example, see [Update a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Space response = spacesServiceClient.updateSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(UpdateSpaceRequest request) {
    return updateSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates details about a meeting space.
   *
   * <p>For an example, see [Update a meeting
   * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Space> future = spacesServiceClient.updateSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return stub.updateSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>For an example, see [End active
   * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   spacesServiceClient.endActiveConference(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   *     <p>Format: `spaces/{space}`.
   *     <p>`{space}` is the resource identifier for the space. It's a unique, server-generated ID
   *     and is case sensitive. For example, `jQCFfuBOdN5z`.
   *     <p>For more information, see [How Meet identifies a meeting
   *     space](https://developers.google.com/meet/api/guides/meeting-spaces#identify-meeting-space).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(SpaceName name) {
    EndActiveConferenceRequest request =
        EndActiveConferenceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    endActiveConference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>For an example, see [End active
   * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   spacesServiceClient.endActiveConference(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   *     <p>Format: `spaces/{space}`.
   *     <p>`{space}` is the resource identifier for the space. It's a unique, server-generated ID
   *     and is case sensitive. For example, `jQCFfuBOdN5z`.
   *     <p>For more information, see [How Meet identifies a meeting
   *     space](https://developers.google.com/meet/api/guides/meeting-spaces#identify-meeting-space).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(String name) {
    EndActiveConferenceRequest request =
        EndActiveConferenceRequest.newBuilder().setName(name).build();
    endActiveConference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>For an example, see [End active
   * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   EndActiveConferenceRequest request =
   *       EndActiveConferenceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   spacesServiceClient.endActiveConference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(EndActiveConferenceRequest request) {
    endActiveConferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>For an example, see [End active
   * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   EndActiveConferenceRequest request =
   *       EndActiveConferenceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       spacesServiceClient.endActiveConferenceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    return stub.endActiveConferenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Create a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   Member member = Member.newBuilder().build();
   *   Member response = spacesServiceClient.createMember(parent, member);
   * }
   * }</pre>
   *
   * @param parent Required. Format: spaces/{space}
   * @param member Required. The member to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member createMember(SpaceName parent, Member member) {
    CreateMemberRequest request =
        CreateMemberRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMember(member)
            .build();
    return createMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Create a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   Member member = Member.newBuilder().build();
   *   Member response = spacesServiceClient.createMember(parent, member);
   * }
   * }</pre>
   *
   * @param parent Required. Format: spaces/{space}
   * @param member Required. The member to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member createMember(String parent, Member member) {
    CreateMemberRequest request =
        CreateMemberRequest.newBuilder().setParent(parent).setMember(member).build();
    return createMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Create a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateMemberRequest request =
   *       CreateMemberRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMember(Member.newBuilder().build())
   *           .build();
   *   Member response = spacesServiceClient.createMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member createMember(CreateMemberRequest request) {
    return createMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Create a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateMemberRequest request =
   *       CreateMemberRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMember(Member.newBuilder().build())
   *           .build();
   *   ApiFuture<Member> future = spacesServiceClient.createMemberCallable().futureCall(request);
   *   // Do something.
   *   Member response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMemberRequest, Member> createMemberCallable() {
    return stub.createMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Get a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   MemberName name = MemberName.of("[SPACE]", "[MEMBER]");
   *   Member response = spacesServiceClient.getMember(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: “spaces/{space}/members/{member}”
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member getMember(MemberName name) {
    GetMemberRequest request =
        GetMemberRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Get a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = MemberName.of("[SPACE]", "[MEMBER]").toString();
   *   Member response = spacesServiceClient.getMember(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: “spaces/{space}/members/{member}”
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member getMember(String name) {
    GetMemberRequest request = GetMemberRequest.newBuilder().setName(name).build();
    return getMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Get a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetMemberRequest request =
   *       GetMemberRequest.newBuilder()
   *           .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
   *           .build();
   *   Member response = spacesServiceClient.getMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Member getMember(GetMemberRequest request) {
    return getMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Get a member.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted, this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetMemberRequest request =
   *       GetMemberRequest.newBuilder()
   *           .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
   *           .build();
   *   ApiFuture<Member> future = spacesServiceClient.getMemberCallable().futureCall(request);
   *   // Do something.
   *   Member response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMemberRequest, Member> getMemberCallable() {
    return stub.getMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): List members.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   for (Member element : spacesServiceClient.listMembers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: spaces/{space}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembersPagedResponse listMembers(SpaceName parent) {
    ListMembersRequest request =
        ListMembersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): List members.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   for (Member element : spacesServiceClient.listMembers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: spaces/{space}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembersPagedResponse listMembers(String parent) {
    ListMembersRequest request = ListMembersRequest.newBuilder().setParent(parent).build();
    return listMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): List members.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   ListMembersRequest request =
   *       ListMembersRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Member element : spacesServiceClient.listMembers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembersPagedResponse listMembers(ListMembersRequest request) {
    return listMembersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): List members.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   ListMembersRequest request =
   *       ListMembersRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Member> future = spacesServiceClient.listMembersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Member element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembersRequest, ListMembersPagedResponse>
      listMembersPagedCallable() {
    return stub.listMembersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): List members.
   *
   * <p>This API supports the `fields` parameter in
   * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters). When the
   * `fields` parameter is omitted this API response will default to "name,email,role,user".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   ListMembersRequest request =
   *       ListMembersRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMembersResponse response = spacesServiceClient.listMembersCallable().call(request);
   *     for (Member element : response.getMembersList()) {
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
  public final UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable() {
    return stub.listMembersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Delete the member who was
   * previously assigned roles in the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   MemberName name = MemberName.of("[SPACE]", "[MEMBER]");
   *   spacesServiceClient.deleteMember(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: “spaces/{space}/members/{member}”
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMember(MemberName name) {
    DeleteMemberRequest request =
        DeleteMemberRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Delete the member who was
   * previously assigned roles in the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = MemberName.of("[SPACE]", "[MEMBER]").toString();
   *   spacesServiceClient.deleteMember(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: “spaces/{space}/members/{member}”
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMember(String name) {
    DeleteMemberRequest request = DeleteMemberRequest.newBuilder().setName(name).build();
    deleteMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Delete the member who was
   * previously assigned roles in the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   DeleteMemberRequest request =
   *       DeleteMemberRequest.newBuilder()
   *           .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
   *           .build();
   *   spacesServiceClient.deleteMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMember(DeleteMemberRequest request) {
    deleteMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview): Delete the member who was
   * previously assigned roles in the space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   DeleteMemberRequest request =
   *       DeleteMemberRequest.newBuilder()
   *           .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
   *           .build();
   *   ApiFuture<Empty> future = spacesServiceClient.deleteMemberCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable() {
    return stub.deleteMemberCallable();
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

  public static class ListMembersPagedResponse
      extends AbstractPagedListResponse<
          ListMembersRequest,
          ListMembersResponse,
          Member,
          ListMembersPage,
          ListMembersFixedSizeCollection> {

    public static ApiFuture<ListMembersPagedResponse> createAsync(
        PageContext<ListMembersRequest, ListMembersResponse, Member> context,
        ApiFuture<ListMembersResponse> futureResponse) {
      ApiFuture<ListMembersPage> futurePage =
          ListMembersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListMembersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListMembersPagedResponse(ListMembersPage page) {
      super(page, ListMembersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembersPage
      extends AbstractPage<ListMembersRequest, ListMembersResponse, Member, ListMembersPage> {

    private ListMembersPage(
        PageContext<ListMembersRequest, ListMembersResponse, Member> context,
        ListMembersResponse response) {
      super(context, response);
    }

    private static ListMembersPage createEmptyPage() {
      return new ListMembersPage(null, null);
    }

    @Override
    protected ListMembersPage createPage(
        PageContext<ListMembersRequest, ListMembersResponse, Member> context,
        ListMembersResponse response) {
      return new ListMembersPage(context, response);
    }

    @Override
    public ApiFuture<ListMembersPage> createPageAsync(
        PageContext<ListMembersRequest, ListMembersResponse, Member> context,
        ApiFuture<ListMembersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembersRequest,
          ListMembersResponse,
          Member,
          ListMembersPage,
          ListMembersFixedSizeCollection> {

    private ListMembersFixedSizeCollection(List<ListMembersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembersFixedSizeCollection createEmptyCollection() {
      return new ListMembersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembersFixedSizeCollection createCollection(
        List<ListMembersPage> pages, int collectionSize) {
      return new ListMembersFixedSizeCollection(pages, collectionSize);
    }
  }
}
