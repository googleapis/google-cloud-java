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

package com.google.cloud.dataproc.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.SessionTemplateControllerStub;
import com.google.cloud.dataproc.v1.stub.SessionTemplateControllerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The SessionTemplateController provides methods to manage session templates.
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
 * try (SessionTemplateControllerClient sessionTemplateControllerClient =
 *     SessionTemplateControllerClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
 *   SessionTemplate response =
 *       sessionTemplateControllerClient.createSessionTemplate(parent, sessionTemplate);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SessionTemplateControllerClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSessionTemplate</td>
 *      <td><p> Create a session template synchronously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSessionTemplate(CreateSessionTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSessionTemplate(LocationName parent, SessionTemplate sessionTemplate)
 *           <li><p> createSessionTemplate(String parent, SessionTemplate sessionTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSessionTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSessionTemplate</td>
 *      <td><p> Updates the session template synchronously.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSessionTemplate(UpdateSessionTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSessionTemplate(SessionTemplate sessionTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSessionTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSessionTemplate</td>
 *      <td><p> Gets the resource representation for a session template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSessionTemplate(GetSessionTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSessionTemplate(SessionTemplateName name)
 *           <li><p> getSessionTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSessionTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSessionTemplates</td>
 *      <td><p> Lists session templates.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSessionTemplates(ListSessionTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSessionTemplates(LocationName parent)
 *           <li><p> listSessionTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSessionTemplatesPagedCallable()
 *           <li><p> listSessionTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSessionTemplate</td>
 *      <td><p> Deletes a session template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSessionTemplate(DeleteSessionTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSessionTemplate(SessionTemplateName name)
 *           <li><p> deleteSessionTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSessionTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * SessionTemplateControllerSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SessionTemplateControllerSettings sessionTemplateControllerSettings =
 *     SessionTemplateControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SessionTemplateControllerClient sessionTemplateControllerClient =
 *     SessionTemplateControllerClient.create(sessionTemplateControllerSettings);
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
 * SessionTemplateControllerSettings sessionTemplateControllerSettings =
 *     SessionTemplateControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SessionTemplateControllerClient sessionTemplateControllerClient =
 *     SessionTemplateControllerClient.create(sessionTemplateControllerSettings);
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
 * SessionTemplateControllerSettings sessionTemplateControllerSettings =
 *     SessionTemplateControllerSettings.newHttpJsonBuilder().build();
 * SessionTemplateControllerClient sessionTemplateControllerClient =
 *     SessionTemplateControllerClient.create(sessionTemplateControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SessionTemplateControllerClient implements BackgroundResource {
  private final SessionTemplateControllerSettings settings;
  private final SessionTemplateControllerStub stub;

  /** Constructs an instance of SessionTemplateControllerClient with default settings. */
  public static final SessionTemplateControllerClient create() throws IOException {
    return create(SessionTemplateControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SessionTemplateControllerClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final SessionTemplateControllerClient create(
      SessionTemplateControllerSettings settings) throws IOException {
    return new SessionTemplateControllerClient(settings);
  }

  /**
   * Constructs an instance of SessionTemplateControllerClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(SessionTemplateControllerSettings).
   */
  public static final SessionTemplateControllerClient create(SessionTemplateControllerStub stub) {
    return new SessionTemplateControllerClient(stub);
  }

  /**
   * Constructs an instance of SessionTemplateControllerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SessionTemplateControllerClient(SessionTemplateControllerSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SessionTemplateControllerStubSettings) settings.getStubSettings()).createStub();
  }

  protected SessionTemplateControllerClient(SessionTemplateControllerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SessionTemplateControllerSettings getSettings() {
    return settings;
  }

  public SessionTemplateControllerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
   *   SessionTemplate response =
   *       sessionTemplateControllerClient.createSessionTemplate(parent, sessionTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this session template will be created.
   * @param sessionTemplate Required. The session template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate createSessionTemplate(
      LocationName parent, SessionTemplate sessionTemplate) {
    CreateSessionTemplateRequest request =
        CreateSessionTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSessionTemplate(sessionTemplate)
            .build();
    return createSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
   *   SessionTemplate response =
   *       sessionTemplateControllerClient.createSessionTemplate(parent, sessionTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this session template will be created.
   * @param sessionTemplate Required. The session template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate createSessionTemplate(
      String parent, SessionTemplate sessionTemplate) {
    CreateSessionTemplateRequest request =
        CreateSessionTemplateRequest.newBuilder()
            .setParent(parent)
            .setSessionTemplate(sessionTemplate)
            .build();
    return createSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   CreateSessionTemplateRequest request =
   *       CreateSessionTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSessionTemplate(SessionTemplate.newBuilder().build())
   *           .build();
   *   SessionTemplate response = sessionTemplateControllerClient.createSessionTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate createSessionTemplate(CreateSessionTemplateRequest request) {
    return createSessionTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   CreateSessionTemplateRequest request =
   *       CreateSessionTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSessionTemplate(SessionTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<SessionTemplate> future =
   *       sessionTemplateControllerClient.createSessionTemplateCallable().futureCall(request);
   *   // Do something.
   *   SessionTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable() {
    return stub.createSessionTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
   *   SessionTemplate response =
   *       sessionTemplateControllerClient.updateSessionTemplate(sessionTemplate);
   * }
   * }</pre>
   *
   * @param sessionTemplate Required. The updated session template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate updateSessionTemplate(SessionTemplate sessionTemplate) {
    UpdateSessionTemplateRequest request =
        UpdateSessionTemplateRequest.newBuilder().setSessionTemplate(sessionTemplate).build();
    return updateSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   UpdateSessionTemplateRequest request =
   *       UpdateSessionTemplateRequest.newBuilder()
   *           .setSessionTemplate(SessionTemplate.newBuilder().build())
   *           .build();
   *   SessionTemplate response = sessionTemplateControllerClient.updateSessionTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate updateSessionTemplate(UpdateSessionTemplateRequest request) {
    return updateSessionTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the session template synchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   UpdateSessionTemplateRequest request =
   *       UpdateSessionTemplateRequest.newBuilder()
   *           .setSessionTemplate(SessionTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<SessionTemplate> future =
   *       sessionTemplateControllerClient.updateSessionTemplateCallable().futureCall(request);
   *   // Do something.
   *   SessionTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable() {
    return stub.updateSessionTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   SessionTemplate response = sessionTemplateControllerClient.getSessionTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the session template to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate getSessionTemplate(SessionTemplateName name) {
    GetSessionTemplateRequest request =
        GetSessionTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   String name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   SessionTemplate response = sessionTemplateControllerClient.getSessionTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the session template to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate getSessionTemplate(String name) {
    GetSessionTemplateRequest request =
        GetSessionTemplateRequest.newBuilder().setName(name).build();
    return getSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   GetSessionTemplateRequest request =
   *       GetSessionTemplateRequest.newBuilder()
   *           .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   SessionTemplate response = sessionTemplateControllerClient.getSessionTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SessionTemplate getSessionTemplate(GetSessionTemplateRequest request) {
    return getSessionTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   GetSessionTemplateRequest request =
   *       GetSessionTemplateRequest.newBuilder()
   *           .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<SessionTemplate> future =
   *       sessionTemplateControllerClient.getSessionTemplateCallable().futureCall(request);
   *   // Do something.
   *   SessionTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateCallable() {
    return stub.getSessionTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SessionTemplate element :
   *       sessionTemplateControllerClient.listSessionTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns this collection of session templates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionTemplatesPagedResponse listSessionTemplates(LocationName parent) {
    ListSessionTemplatesRequest request =
        ListSessionTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSessionTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SessionTemplate element :
   *       sessionTemplateControllerClient.listSessionTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent that owns this collection of session templates.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionTemplatesPagedResponse listSessionTemplates(String parent) {
    ListSessionTemplatesRequest request =
        ListSessionTemplatesRequest.newBuilder().setParent(parent).build();
    return listSessionTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   ListSessionTemplatesRequest request =
   *       ListSessionTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (SessionTemplate element :
   *       sessionTemplateControllerClient.listSessionTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionTemplatesPagedResponse listSessionTemplates(
      ListSessionTemplatesRequest request) {
    return listSessionTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   ListSessionTemplatesRequest request =
   *       ListSessionTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<SessionTemplate> future =
   *       sessionTemplateControllerClient.listSessionTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SessionTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable() {
    return stub.listSessionTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists session templates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   ListSessionTemplatesRequest request =
   *       ListSessionTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSessionTemplatesResponse response =
   *         sessionTemplateControllerClient.listSessionTemplatesCallable().call(request);
   *     for (SessionTemplate element : response.getSessionTemplatesList()) {
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
  public final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable() {
    return stub.listSessionTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   sessionTemplateControllerClient.deleteSessionTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the session template resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSessionTemplate(SessionTemplateName name) {
    DeleteSessionTemplateRequest request =
        DeleteSessionTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   String name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   sessionTemplateControllerClient.deleteSessionTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the session template resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSessionTemplate(String name) {
    DeleteSessionTemplateRequest request =
        DeleteSessionTemplateRequest.newBuilder().setName(name).build();
    deleteSessionTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   DeleteSessionTemplateRequest request =
   *       DeleteSessionTemplateRequest.newBuilder()
   *           .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   sessionTemplateControllerClient.deleteSessionTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSessionTemplate(DeleteSessionTemplateRequest request) {
    deleteSessionTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a session template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   DeleteSessionTemplateRequest request =
   *       DeleteSessionTemplateRequest.newBuilder()
   *           .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       sessionTemplateControllerClient.deleteSessionTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable() {
    return stub.deleteSessionTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = sessionTemplateControllerClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       sessionTemplateControllerClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = sessionTemplateControllerClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       sessionTemplateControllerClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       sessionTemplateControllerClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionTemplateControllerClient sessionTemplateControllerClient =
   *     SessionTemplateControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       sessionTemplateControllerClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListSessionTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          SessionTemplate,
          ListSessionTemplatesPage,
          ListSessionTemplatesFixedSizeCollection> {

    public static ApiFuture<ListSessionTemplatesPagedResponse> createAsync(
        PageContext<ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
            context,
        ApiFuture<ListSessionTemplatesResponse> futureResponse) {
      ApiFuture<ListSessionTemplatesPage> futurePage =
          ListSessionTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSessionTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSessionTemplatesPagedResponse(ListSessionTemplatesPage page) {
      super(page, ListSessionTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSessionTemplatesPage
      extends AbstractPage<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          SessionTemplate,
          ListSessionTemplatesPage> {

    private ListSessionTemplatesPage(
        PageContext<ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
            context,
        ListSessionTemplatesResponse response) {
      super(context, response);
    }

    private static ListSessionTemplatesPage createEmptyPage() {
      return new ListSessionTemplatesPage(null, null);
    }

    @Override
    protected ListSessionTemplatesPage createPage(
        PageContext<ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
            context,
        ListSessionTemplatesResponse response) {
      return new ListSessionTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListSessionTemplatesPage> createPageAsync(
        PageContext<ListSessionTemplatesRequest, ListSessionTemplatesResponse, SessionTemplate>
            context,
        ApiFuture<ListSessionTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSessionTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSessionTemplatesRequest,
          ListSessionTemplatesResponse,
          SessionTemplate,
          ListSessionTemplatesPage,
          ListSessionTemplatesFixedSizeCollection> {

    private ListSessionTemplatesFixedSizeCollection(
        List<ListSessionTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSessionTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListSessionTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSessionTemplatesFixedSizeCollection createCollection(
        List<ListSessionTemplatesPage> pages, int collectionSize) {
      return new ListSessionTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
