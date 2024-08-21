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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.RuntimeProjectAttachmentServiceStub;
import com.google.cloud.apihub.v1.stub.RuntimeProjectAttachmentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing the runtime project attachments.
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
 * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
 *     RuntimeProjectAttachmentServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   RuntimeProjectAttachment runtimeProjectAttachment =
 *       RuntimeProjectAttachment.newBuilder().build();
 *   String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
 *   RuntimeProjectAttachment response =
 *       runtimeProjectAttachmentServiceClient.createRuntimeProjectAttachment(
 *           parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RuntimeProjectAttachmentServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRuntimeProjectAttachment</td>
 *      <td><p> Attaches a runtime project to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRuntimeProjectAttachment(CreateRuntimeProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRuntimeProjectAttachment(LocationName parent, RuntimeProjectAttachment runtimeProjectAttachment, String runtimeProjectAttachmentId)
 *           <li><p> createRuntimeProjectAttachment(String parent, RuntimeProjectAttachment runtimeProjectAttachment, String runtimeProjectAttachmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRuntimeProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRuntimeProjectAttachment</td>
 *      <td><p> Gets a runtime project attachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRuntimeProjectAttachment(GetRuntimeProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRuntimeProjectAttachment(RuntimeProjectAttachmentName name)
 *           <li><p> getRuntimeProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuntimeProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRuntimeProjectAttachments</td>
 *      <td><p> List runtime projects attached to the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRuntimeProjectAttachments(ListRuntimeProjectAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRuntimeProjectAttachments(LocationName parent)
 *           <li><p> listRuntimeProjectAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRuntimeProjectAttachmentsPagedCallable()
 *           <li><p> listRuntimeProjectAttachmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRuntimeProjectAttachment</td>
 *      <td><p> Delete a runtime project attachment in the API Hub. This call will detach the runtime project from the host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRuntimeProjectAttachment(DeleteRuntimeProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRuntimeProjectAttachment(RuntimeProjectAttachmentName name)
 *           <li><p> deleteRuntimeProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRuntimeProjectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupRuntimeProjectAttachment</td>
 *      <td><p> Look up a runtime project attachment. This API can be called in the context of any project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupRuntimeProjectAttachment(LookupRuntimeProjectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookupRuntimeProjectAttachment(LocationName name)
 *           <li><p> lookupRuntimeProjectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupRuntimeProjectAttachmentCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * RuntimeProjectAttachmentServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuntimeProjectAttachmentServiceSettings runtimeProjectAttachmentServiceSettings =
 *     RuntimeProjectAttachmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
 *     RuntimeProjectAttachmentServiceClient.create(runtimeProjectAttachmentServiceSettings);
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
 * RuntimeProjectAttachmentServiceSettings runtimeProjectAttachmentServiceSettings =
 *     RuntimeProjectAttachmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
 *     RuntimeProjectAttachmentServiceClient.create(runtimeProjectAttachmentServiceSettings);
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
 * RuntimeProjectAttachmentServiceSettings runtimeProjectAttachmentServiceSettings =
 *     RuntimeProjectAttachmentServiceSettings.newHttpJsonBuilder().build();
 * RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
 *     RuntimeProjectAttachmentServiceClient.create(runtimeProjectAttachmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RuntimeProjectAttachmentServiceClient implements BackgroundResource {
  private final RuntimeProjectAttachmentServiceSettings settings;
  private final RuntimeProjectAttachmentServiceStub stub;

  /** Constructs an instance of RuntimeProjectAttachmentServiceClient with default settings. */
  public static final RuntimeProjectAttachmentServiceClient create() throws IOException {
    return create(RuntimeProjectAttachmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RuntimeProjectAttachmentServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RuntimeProjectAttachmentServiceClient create(
      RuntimeProjectAttachmentServiceSettings settings) throws IOException {
    return new RuntimeProjectAttachmentServiceClient(settings);
  }

  /**
   * Constructs an instance of RuntimeProjectAttachmentServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(RuntimeProjectAttachmentServiceSettings).
   */
  public static final RuntimeProjectAttachmentServiceClient create(
      RuntimeProjectAttachmentServiceStub stub) {
    return new RuntimeProjectAttachmentServiceClient(stub);
  }

  /**
   * Constructs an instance of RuntimeProjectAttachmentServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RuntimeProjectAttachmentServiceClient(RuntimeProjectAttachmentServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((RuntimeProjectAttachmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RuntimeProjectAttachmentServiceClient(RuntimeProjectAttachmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RuntimeProjectAttachmentServiceSettings getSettings() {
    return settings;
  }

  public RuntimeProjectAttachmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a runtime project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RuntimeProjectAttachment runtimeProjectAttachment =
   *       RuntimeProjectAttachment.newBuilder().build();
   *   String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.createRuntimeProjectAttachment(
   *           parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the Runtime Project Attachment. Format:
   *     `projects/{project}/locations/{location}`
   * @param runtimeProjectAttachment Required. The Runtime Project Attachment to create.
   * @param runtimeProjectAttachmentId Required. The ID to use for the Runtime Project Attachment,
   *     which will become the final component of the Runtime Project Attachment's name. The ID must
   *     be the same as the project ID of the Google cloud project specified in the
   *     runtime_project_attachment.runtime_project field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment createRuntimeProjectAttachment(
      LocationName parent,
      RuntimeProjectAttachment runtimeProjectAttachment,
      String runtimeProjectAttachmentId) {
    CreateRuntimeProjectAttachmentRequest request =
        CreateRuntimeProjectAttachmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRuntimeProjectAttachment(runtimeProjectAttachment)
            .setRuntimeProjectAttachmentId(runtimeProjectAttachmentId)
            .build();
    return createRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a runtime project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RuntimeProjectAttachment runtimeProjectAttachment =
   *       RuntimeProjectAttachment.newBuilder().build();
   *   String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.createRuntimeProjectAttachment(
   *           parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the Runtime Project Attachment. Format:
   *     `projects/{project}/locations/{location}`
   * @param runtimeProjectAttachment Required. The Runtime Project Attachment to create.
   * @param runtimeProjectAttachmentId Required. The ID to use for the Runtime Project Attachment,
   *     which will become the final component of the Runtime Project Attachment's name. The ID must
   *     be the same as the project ID of the Google cloud project specified in the
   *     runtime_project_attachment.runtime_project field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment createRuntimeProjectAttachment(
      String parent,
      RuntimeProjectAttachment runtimeProjectAttachment,
      String runtimeProjectAttachmentId) {
    CreateRuntimeProjectAttachmentRequest request =
        CreateRuntimeProjectAttachmentRequest.newBuilder()
            .setParent(parent)
            .setRuntimeProjectAttachment(runtimeProjectAttachment)
            .setRuntimeProjectAttachmentId(runtimeProjectAttachmentId)
            .build();
    return createRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a runtime project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   CreateRuntimeProjectAttachmentRequest request =
   *       CreateRuntimeProjectAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRuntimeProjectAttachmentId("runtimeProjectAttachmentId-753213345")
   *           .setRuntimeProjectAttachment(RuntimeProjectAttachment.newBuilder().build())
   *           .build();
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.createRuntimeProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment createRuntimeProjectAttachment(
      CreateRuntimeProjectAttachmentRequest request) {
    return createRuntimeProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches a runtime project to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   CreateRuntimeProjectAttachmentRequest request =
   *       CreateRuntimeProjectAttachmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRuntimeProjectAttachmentId("runtimeProjectAttachmentId-753213345")
   *           .setRuntimeProjectAttachment(RuntimeProjectAttachment.newBuilder().build())
   *           .build();
   *   ApiFuture<RuntimeProjectAttachment> future =
   *       runtimeProjectAttachmentServiceClient
   *           .createRuntimeProjectAttachmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RuntimeProjectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentCallable() {
    return stub.createRuntimeProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a runtime project attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   RuntimeProjectAttachmentName name =
   *       RuntimeProjectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.getRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment getRuntimeProjectAttachment(
      RuntimeProjectAttachmentName name) {
    GetRuntimeProjectAttachmentRequest request =
        GetRuntimeProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a runtime project attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   String name =
   *       RuntimeProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *           .toString();
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.getRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment getRuntimeProjectAttachment(String name) {
    GetRuntimeProjectAttachmentRequest request =
        GetRuntimeProjectAttachmentRequest.newBuilder().setName(name).build();
    return getRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a runtime project attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   GetRuntimeProjectAttachmentRequest request =
   *       GetRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               RuntimeProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   RuntimeProjectAttachment response =
   *       runtimeProjectAttachmentServiceClient.getRuntimeProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuntimeProjectAttachment getRuntimeProjectAttachment(
      GetRuntimeProjectAttachmentRequest request) {
    return getRuntimeProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a runtime project attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   GetRuntimeProjectAttachmentRequest request =
   *       GetRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               RuntimeProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RuntimeProjectAttachment> future =
   *       runtimeProjectAttachmentServiceClient
   *           .getRuntimeProjectAttachmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RuntimeProjectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentCallable() {
    return stub.getRuntimeProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List runtime projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RuntimeProjectAttachment element :
   *       runtimeProjectAttachmentServiceClient
   *           .listRuntimeProjectAttachments(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of runtime project attachments.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimeProjectAttachmentsPagedResponse listRuntimeProjectAttachments(
      LocationName parent) {
    ListRuntimeProjectAttachmentsRequest request =
        ListRuntimeProjectAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuntimeProjectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List runtime projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RuntimeProjectAttachment element :
   *       runtimeProjectAttachmentServiceClient
   *           .listRuntimeProjectAttachments(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of runtime project attachments.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimeProjectAttachmentsPagedResponse listRuntimeProjectAttachments(
      String parent) {
    ListRuntimeProjectAttachmentsRequest request =
        ListRuntimeProjectAttachmentsRequest.newBuilder().setParent(parent).build();
    return listRuntimeProjectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List runtime projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListRuntimeProjectAttachmentsRequest request =
   *       ListRuntimeProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RuntimeProjectAttachment element :
   *       runtimeProjectAttachmentServiceClient
   *           .listRuntimeProjectAttachments(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimeProjectAttachmentsPagedResponse listRuntimeProjectAttachments(
      ListRuntimeProjectAttachmentsRequest request) {
    return listRuntimeProjectAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List runtime projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListRuntimeProjectAttachmentsRequest request =
   *       ListRuntimeProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RuntimeProjectAttachment> future =
   *       runtimeProjectAttachmentServiceClient
   *           .listRuntimeProjectAttachmentsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (RuntimeProjectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsPagedCallable() {
    return stub.listRuntimeProjectAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List runtime projects attached to the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListRuntimeProjectAttachmentsRequest request =
   *       ListRuntimeProjectAttachmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRuntimeProjectAttachmentsResponse response =
   *         runtimeProjectAttachmentServiceClient
   *             .listRuntimeProjectAttachmentsCallable()
   *             .call(request);
   *     for (RuntimeProjectAttachment element : response.getRuntimeProjectAttachmentsList()) {
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
  public final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsCallable() {
    return stub.listRuntimeProjectAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a runtime project attachment in the API Hub. This call will detach the runtime project
   * from the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   RuntimeProjectAttachmentName name =
   *       RuntimeProjectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");
   *   runtimeProjectAttachmentServiceClient.deleteRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Runtime Project Attachment to delete. Format:
   *     `projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuntimeProjectAttachment(RuntimeProjectAttachmentName name) {
    DeleteRuntimeProjectAttachmentRequest request =
        DeleteRuntimeProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a runtime project attachment in the API Hub. This call will detach the runtime project
   * from the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   String name =
   *       RuntimeProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *           .toString();
   *   runtimeProjectAttachmentServiceClient.deleteRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Runtime Project Attachment to delete. Format:
   *     `projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuntimeProjectAttachment(String name) {
    DeleteRuntimeProjectAttachmentRequest request =
        DeleteRuntimeProjectAttachmentRequest.newBuilder().setName(name).build();
    deleteRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a runtime project attachment in the API Hub. This call will detach the runtime project
   * from the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   DeleteRuntimeProjectAttachmentRequest request =
   *       DeleteRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               RuntimeProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   runtimeProjectAttachmentServiceClient.deleteRuntimeProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuntimeProjectAttachment(DeleteRuntimeProjectAttachmentRequest request) {
    deleteRuntimeProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a runtime project attachment in the API Hub. This call will detach the runtime project
   * from the host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   DeleteRuntimeProjectAttachmentRequest request =
   *       DeleteRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(
   *               RuntimeProjectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       runtimeProjectAttachmentServiceClient
   *           .deleteRuntimeProjectAttachmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentCallable() {
    return stub.deleteRuntimeProjectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a runtime project attachment. This API can be called in the context of any project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LookupRuntimeProjectAttachmentResponse response =
   *       runtimeProjectAttachmentServiceClient.lookupRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Runtime project ID to look up runtime project attachment for. Lookup
   *     happens across all regions. Expected format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupRuntimeProjectAttachmentResponse lookupRuntimeProjectAttachment(
      LocationName name) {
    LookupRuntimeProjectAttachmentRequest request =
        LookupRuntimeProjectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return lookupRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a runtime project attachment. This API can be called in the context of any project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   String name = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LookupRuntimeProjectAttachmentResponse response =
   *       runtimeProjectAttachmentServiceClient.lookupRuntimeProjectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Runtime project ID to look up runtime project attachment for. Lookup
   *     happens across all regions. Expected format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupRuntimeProjectAttachmentResponse lookupRuntimeProjectAttachment(String name) {
    LookupRuntimeProjectAttachmentRequest request =
        LookupRuntimeProjectAttachmentRequest.newBuilder().setName(name).build();
    return lookupRuntimeProjectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a runtime project attachment. This API can be called in the context of any project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   LookupRuntimeProjectAttachmentRequest request =
   *       LookupRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   LookupRuntimeProjectAttachmentResponse response =
   *       runtimeProjectAttachmentServiceClient.lookupRuntimeProjectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupRuntimeProjectAttachmentResponse lookupRuntimeProjectAttachment(
      LookupRuntimeProjectAttachmentRequest request) {
    return lookupRuntimeProjectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Look up a runtime project attachment. This API can be called in the context of any project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   LookupRuntimeProjectAttachmentRequest request =
   *       LookupRuntimeProjectAttachmentRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<LookupRuntimeProjectAttachmentResponse> future =
   *       runtimeProjectAttachmentServiceClient
   *           .lookupRuntimeProjectAttachmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   LookupRuntimeProjectAttachmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentCallable() {
    return stub.lookupRuntimeProjectAttachmentCallable();
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
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       runtimeProjectAttachmentServiceClient.listLocations(request).iterateAll()) {
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
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       runtimeProjectAttachmentServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         runtimeProjectAttachmentServiceClient.listLocationsCallable().call(request);
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
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = runtimeProjectAttachmentServiceClient.getLocation(request);
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
   * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
   *     RuntimeProjectAttachmentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       runtimeProjectAttachmentServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListRuntimeProjectAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          RuntimeProjectAttachment,
          ListRuntimeProjectAttachmentsPage,
          ListRuntimeProjectAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListRuntimeProjectAttachmentsPagedResponse> createAsync(
        PageContext<
                ListRuntimeProjectAttachmentsRequest,
                ListRuntimeProjectAttachmentsResponse,
                RuntimeProjectAttachment>
            context,
        ApiFuture<ListRuntimeProjectAttachmentsResponse> futureResponse) {
      ApiFuture<ListRuntimeProjectAttachmentsPage> futurePage =
          ListRuntimeProjectAttachmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuntimeProjectAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuntimeProjectAttachmentsPagedResponse(ListRuntimeProjectAttachmentsPage page) {
      super(page, ListRuntimeProjectAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuntimeProjectAttachmentsPage
      extends AbstractPage<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          RuntimeProjectAttachment,
          ListRuntimeProjectAttachmentsPage> {

    private ListRuntimeProjectAttachmentsPage(
        PageContext<
                ListRuntimeProjectAttachmentsRequest,
                ListRuntimeProjectAttachmentsResponse,
                RuntimeProjectAttachment>
            context,
        ListRuntimeProjectAttachmentsResponse response) {
      super(context, response);
    }

    private static ListRuntimeProjectAttachmentsPage createEmptyPage() {
      return new ListRuntimeProjectAttachmentsPage(null, null);
    }

    @Override
    protected ListRuntimeProjectAttachmentsPage createPage(
        PageContext<
                ListRuntimeProjectAttachmentsRequest,
                ListRuntimeProjectAttachmentsResponse,
                RuntimeProjectAttachment>
            context,
        ListRuntimeProjectAttachmentsResponse response) {
      return new ListRuntimeProjectAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListRuntimeProjectAttachmentsPage> createPageAsync(
        PageContext<
                ListRuntimeProjectAttachmentsRequest,
                ListRuntimeProjectAttachmentsResponse,
                RuntimeProjectAttachment>
            context,
        ApiFuture<ListRuntimeProjectAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuntimeProjectAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          RuntimeProjectAttachment,
          ListRuntimeProjectAttachmentsPage,
          ListRuntimeProjectAttachmentsFixedSizeCollection> {

    private ListRuntimeProjectAttachmentsFixedSizeCollection(
        List<ListRuntimeProjectAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuntimeProjectAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListRuntimeProjectAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuntimeProjectAttachmentsFixedSizeCollection createCollection(
        List<ListRuntimeProjectAttachmentsPage> pages, int collectionSize) {
      return new ListRuntimeProjectAttachmentsFixedSizeCollection(pages, collectionSize);
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
