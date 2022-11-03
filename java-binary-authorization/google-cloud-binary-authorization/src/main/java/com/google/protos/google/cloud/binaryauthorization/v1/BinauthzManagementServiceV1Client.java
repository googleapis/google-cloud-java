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

package com.google.protos.google.cloud.binaryauthorization.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.BinauthzManagementServiceV1Stub;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.BinauthzManagementServiceV1StubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud Management Service for Binary Authorization admission policies
 * and attestation authorities.
 *
 * <p>This API implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[Policy][google.cloud.binaryauthorization.v1.Policy]
 *   <li>[Attestor][google.cloud.binaryauthorization.v1.Attestor]
 * </ul>
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
 * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
 *     BinauthzManagementServiceV1Client.create()) {
 *   PolicyName name = PolicyName.ofProjectName("[PROJECT]");
 *   Resources.Policy response = binauthzManagementServiceV1Client.getPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BinauthzManagementServiceV1Client object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * BinauthzManagementServiceV1Settings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BinauthzManagementServiceV1Settings binauthzManagementServiceV1Settings =
 *     BinauthzManagementServiceV1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
 *     BinauthzManagementServiceV1Client.create(binauthzManagementServiceV1Settings);
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
 * BinauthzManagementServiceV1Settings binauthzManagementServiceV1Settings =
 *     BinauthzManagementServiceV1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
 *     BinauthzManagementServiceV1Client.create(binauthzManagementServiceV1Settings);
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
 * BinauthzManagementServiceV1Settings binauthzManagementServiceV1Settings =
 *     BinauthzManagementServiceV1Settings.newHttpJsonBuilder().build();
 * BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
 *     BinauthzManagementServiceV1Client.create(binauthzManagementServiceV1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BinauthzManagementServiceV1Client implements BackgroundResource {
  private final BinauthzManagementServiceV1Settings settings;
  private final BinauthzManagementServiceV1Stub stub;

  /** Constructs an instance of BinauthzManagementServiceV1Client with default settings. */
  public static final BinauthzManagementServiceV1Client create() throws IOException {
    return create(BinauthzManagementServiceV1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of BinauthzManagementServiceV1Client, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final BinauthzManagementServiceV1Client create(
      BinauthzManagementServiceV1Settings settings) throws IOException {
    return new BinauthzManagementServiceV1Client(settings);
  }

  /**
   * Constructs an instance of BinauthzManagementServiceV1Client, using the given stub for making
   * calls. This is for advanced usage - prefer using create(BinauthzManagementServiceV1Settings).
   */
  public static final BinauthzManagementServiceV1Client create(
      BinauthzManagementServiceV1Stub stub) {
    return new BinauthzManagementServiceV1Client(stub);
  }

  /**
   * Constructs an instance of BinauthzManagementServiceV1Client, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BinauthzManagementServiceV1Client(BinauthzManagementServiceV1Settings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BinauthzManagementServiceV1StubSettings) settings.getStubSettings()).createStub();
  }

  protected BinauthzManagementServiceV1Client(BinauthzManagementServiceV1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BinauthzManagementServiceV1Settings getSettings() {
    return settings;
  }

  public BinauthzManagementServiceV1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the
   * [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to a container
   * image, before the project is allowed to deploy that image. There is at most one policy per
   * project. All image admission requests are permitted if a project has no policy.
   *
   * <p>Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a
   * default [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   PolicyName name = PolicyName.ofProjectName("[PROJECT]");
   *   Resources.Policy response = binauthzManagementServiceV1Client.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [policy][google.cloud.binaryauthorization.v1.Policy] to retrieve, in the format
   *     `projects/&#42;/policy`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Policy getPolicy(PolicyName name) {
    Service.GetPolicyRequest request =
        Service.GetPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the
   * [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to a container
   * image, before the project is allowed to deploy that image. There is at most one policy per
   * project. All image admission requests are permitted if a project has no policy.
   *
   * <p>Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a
   * default [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   String name = PolicyName.ofProjectName("[PROJECT]").toString();
   *   Resources.Policy response = binauthzManagementServiceV1Client.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [policy][google.cloud.binaryauthorization.v1.Policy] to retrieve, in the format
   *     `projects/&#42;/policy`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Policy getPolicy(String name) {
    Service.GetPolicyRequest request = Service.GetPolicyRequest.newBuilder().setName(name).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the
   * [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to a container
   * image, before the project is allowed to deploy that image. There is at most one policy per
   * project. All image admission requests are permitted if a project has no policy.
   *
   * <p>Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a
   * default [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.GetPolicyRequest request =
   *       Service.GetPolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   Resources.Policy response = binauthzManagementServiceV1Client.getPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Policy getPolicy(Service.GetPolicyRequest request) {
    return getPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the
   * [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to a container
   * image, before the project is allowed to deploy that image. There is at most one policy per
   * project. All image admission requests are permitted if a project has no policy.
   *
   * <p>Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a
   * default [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.GetPolicyRequest request =
   *       Service.GetPolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Resources.Policy> future =
   *       binauthzManagementServiceV1Client.getPolicyCallable().futureCall(request);
   *   // Do something.
   *   Resources.Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable() {
    return stub.getPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and
   * returns a copy of the new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is
   * always updated as a whole, to avoid race conditions with concurrent policy enforcement (or
   * management!) requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT if the
   * request is malformed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Resources.Policy policy = Resources.Policy.newBuilder().build();
   *   Resources.Policy response = binauthzManagementServiceV1Client.updatePolicy(policy);
   * }
   * }</pre>
   *
   * @param policy Required. A new or updated [policy][google.cloud.binaryauthorization.v1.Policy]
   *     value. The service will overwrite the [policy
   *     name][google.cloud.binaryauthorization.v1.Policy.name] field with the resource name in the
   *     request URL, in the format `projects/&#42;/policy`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Policy updatePolicy(Resources.Policy policy) {
    Service.UpdatePolicyRequest request =
        Service.UpdatePolicyRequest.newBuilder().setPolicy(policy).build();
    return updatePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and
   * returns a copy of the new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is
   * always updated as a whole, to avoid race conditions with concurrent policy enforcement (or
   * management!) requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT if the
   * request is malformed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.UpdatePolicyRequest request =
   *       Service.UpdatePolicyRequest.newBuilder()
   *           .setPolicy(Resources.Policy.newBuilder().build())
   *           .build();
   *   Resources.Policy response = binauthzManagementServiceV1Client.updatePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Policy updatePolicy(Service.UpdatePolicyRequest request) {
    return updatePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and
   * returns a copy of the new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is
   * always updated as a whole, to avoid race conditions with concurrent policy enforcement (or
   * management!) requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT if the
   * request is malformed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.UpdatePolicyRequest request =
   *       Service.UpdatePolicyRequest.newBuilder()
   *           .setPolicy(Resources.Policy.newBuilder().build())
   *           .build();
   *   ApiFuture<Resources.Policy> future =
   *       binauthzManagementServiceV1Client.updatePolicyCallable().futureCall(request);
   *   // Do something.
   *   Resources.Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable() {
    return stub.updatePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the
   * new [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project
   * does not exist, INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String attestorId = "attestorId2055733027";
   *   Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
   *   Resources.Attestor response =
   *       binauthzManagementServiceV1Client.createAttestor(parent, attestorId, attestor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of this
   *     [attestor][google.cloud.binaryauthorization.v1.Attestor].
   * @param attestorId Required. The [attestors][google.cloud.binaryauthorization.v1.Attestor] ID.
   * @param attestor Required. The initial [attestor][google.cloud.binaryauthorization.v1.Attestor]
   *     value. The service will overwrite the [attestor
   *     name][google.cloud.binaryauthorization.v1.Attestor.name] field with the resource name, in
   *     the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor createAttestor(
      ProjectName parent, String attestorId, Resources.Attestor attestor) {
    Service.CreateAttestorRequest request =
        Service.CreateAttestorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAttestorId(attestorId)
            .setAttestor(attestor)
            .build();
    return createAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the
   * new [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project
   * does not exist, INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String attestorId = "attestorId2055733027";
   *   Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
   *   Resources.Attestor response =
   *       binauthzManagementServiceV1Client.createAttestor(parent, attestorId, attestor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of this
   *     [attestor][google.cloud.binaryauthorization.v1.Attestor].
   * @param attestorId Required. The [attestors][google.cloud.binaryauthorization.v1.Attestor] ID.
   * @param attestor Required. The initial [attestor][google.cloud.binaryauthorization.v1.Attestor]
   *     value. The service will overwrite the [attestor
   *     name][google.cloud.binaryauthorization.v1.Attestor.name] field with the resource name, in
   *     the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor createAttestor(
      String parent, String attestorId, Resources.Attestor attestor) {
    Service.CreateAttestorRequest request =
        Service.CreateAttestorRequest.newBuilder()
            .setParent(parent)
            .setAttestorId(attestorId)
            .setAttestor(attestor)
            .build();
    return createAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the
   * new [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project
   * does not exist, INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.CreateAttestorRequest request =
   *       Service.CreateAttestorRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setAttestorId("attestorId2055733027")
   *           .setAttestor(Resources.Attestor.newBuilder().build())
   *           .build();
   *   Resources.Attestor response = binauthzManagementServiceV1Client.createAttestor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor createAttestor(Service.CreateAttestorRequest request) {
    return createAttestorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the
   * new [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project
   * does not exist, INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.CreateAttestorRequest request =
   *       Service.CreateAttestorRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setAttestorId("attestorId2055733027")
   *           .setAttestor(Resources.Attestor.newBuilder().build())
   *           .build();
   *   ApiFuture<Resources.Attestor> future =
   *       binauthzManagementServiceV1Client.createAttestorCallable().futureCall(request);
   *   // Do something.
   *   Resources.Attestor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorCallable() {
    return stub.createAttestorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
   *   Resources.Attestor response = binauthzManagementServiceV1Client.getAttestor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [attestor][google.cloud.binaryauthorization.v1.Attestor]
   *     to retrieve, in the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor getAttestor(AttestorName name) {
    Service.GetAttestorRequest request =
        Service.GetAttestorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   String name = AttestorName.of("[PROJECT]", "[ATTESTOR]").toString();
   *   Resources.Attestor response = binauthzManagementServiceV1Client.getAttestor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [attestor][google.cloud.binaryauthorization.v1.Attestor]
   *     to retrieve, in the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor getAttestor(String name) {
    Service.GetAttestorRequest request =
        Service.GetAttestorRequest.newBuilder().setName(name).build();
    return getAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.GetAttestorRequest request =
   *       Service.GetAttestorRequest.newBuilder()
   *           .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
   *           .build();
   *   Resources.Attestor response = binauthzManagementServiceV1Client.getAttestor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor getAttestor(Service.GetAttestorRequest request) {
    return getAttestorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.GetAttestorRequest request =
   *       Service.GetAttestorRequest.newBuilder()
   *           .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
   *           .build();
   *   ApiFuture<Resources.Attestor> future =
   *       binauthzManagementServiceV1Client.getAttestorCallable().futureCall(request);
   *   // Do something.
   *   Resources.Attestor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable() {
    return stub.getAttestorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
   *   Resources.Attestor response = binauthzManagementServiceV1Client.updateAttestor(attestor);
   * }
   * }</pre>
   *
   * @param attestor Required. The updated [attestor][google.cloud.binaryauthorization.v1.Attestor]
   *     value. The service will overwrite the [attestor
   *     name][google.cloud.binaryauthorization.v1.Attestor.name] field with the resource name in
   *     the request URL, in the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor updateAttestor(Resources.Attestor attestor) {
    Service.UpdateAttestorRequest request =
        Service.UpdateAttestorRequest.newBuilder().setAttestor(attestor).build();
    return updateAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.UpdateAttestorRequest request =
   *       Service.UpdateAttestorRequest.newBuilder()
   *           .setAttestor(Resources.Attestor.newBuilder().build())
   *           .build();
   *   Resources.Attestor response = binauthzManagementServiceV1Client.updateAttestor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resources.Attestor updateAttestor(Service.UpdateAttestorRequest request) {
    return updateAttestorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.UpdateAttestorRequest request =
   *       Service.UpdateAttestorRequest.newBuilder()
   *           .setAttestor(Resources.Attestor.newBuilder().build())
   *           .build();
   *   ApiFuture<Resources.Attestor> future =
   *       binauthzManagementServiceV1Client.updateAttestorCallable().futureCall(request);
   *   // Do something.
   *   Resources.Attestor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorCallable() {
    return stub.updateAttestorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor]. Returns INVALID_ARGUMENT if
   * the project does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Resources.Attestor element :
   *       binauthzManagementServiceV1Client.listAttestors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project associated with the
   *     [attestors][google.cloud.binaryauthorization.v1.Attestor], in the format `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttestorsPagedResponse listAttestors(ProjectName parent) {
    Service.ListAttestorsRequest request =
        Service.ListAttestorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttestors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor]. Returns INVALID_ARGUMENT if
   * the project does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Resources.Attestor element :
   *       binauthzManagementServiceV1Client.listAttestors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project associated with the
   *     [attestors][google.cloud.binaryauthorization.v1.Attestor], in the format `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttestorsPagedResponse listAttestors(String parent) {
    Service.ListAttestorsRequest request =
        Service.ListAttestorsRequest.newBuilder().setParent(parent).build();
    return listAttestors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor]. Returns INVALID_ARGUMENT if
   * the project does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.ListAttestorsRequest request =
   *       Service.ListAttestorsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Resources.Attestor element :
   *       binauthzManagementServiceV1Client.listAttestors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttestorsPagedResponse listAttestors(Service.ListAttestorsRequest request) {
    return listAttestorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor]. Returns INVALID_ARGUMENT if
   * the project does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.ListAttestorsRequest request =
   *       Service.ListAttestorsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Resources.Attestor> future =
   *       binauthzManagementServiceV1Client.listAttestorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Resources.Attestor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    return stub.listAttestorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor]. Returns INVALID_ARGUMENT if
   * the project does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.ListAttestorsRequest request =
   *       Service.ListAttestorsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     Service.ListAttestorsResponse response =
   *         binauthzManagementServiceV1Client.listAttestorsCallable().call(request);
   *     for (Resources.Attestor element : response.getAttestorsList()) {
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
  public final UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable() {
    return stub.listAttestorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
   *   binauthzManagementServiceV1Client.deleteAttestor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [attestors][google.cloud.binaryauthorization.v1.Attestor]
   *     to delete, in the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttestor(AttestorName name) {
    Service.DeleteAttestorRequest request =
        Service.DeleteAttestorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   String name = AttestorName.of("[PROJECT]", "[ATTESTOR]").toString();
   *   binauthzManagementServiceV1Client.deleteAttestor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [attestors][google.cloud.binaryauthorization.v1.Attestor]
   *     to delete, in the format `projects/&#42;/attestors/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttestor(String name) {
    Service.DeleteAttestorRequest request =
        Service.DeleteAttestorRequest.newBuilder().setName(name).build();
    deleteAttestor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.DeleteAttestorRequest request =
   *       Service.DeleteAttestorRequest.newBuilder()
   *           .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
   *           .build();
   *   binauthzManagementServiceV1Client.deleteAttestor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttestor(Service.DeleteAttestorRequest request) {
    deleteAttestorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
   * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
   *     BinauthzManagementServiceV1Client.create()) {
   *   Service.DeleteAttestorRequest request =
   *       Service.DeleteAttestorRequest.newBuilder()
   *           .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       binauthzManagementServiceV1Client.deleteAttestorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable() {
    return stub.deleteAttestorCallable();
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

  public static class ListAttestorsPagedResponse
      extends AbstractPagedListResponse<
          Service.ListAttestorsRequest,
          Service.ListAttestorsResponse,
          Resources.Attestor,
          ListAttestorsPage,
          ListAttestorsFixedSizeCollection> {

    public static ApiFuture<ListAttestorsPagedResponse> createAsync(
        PageContext<Service.ListAttestorsRequest, Service.ListAttestorsResponse, Resources.Attestor>
            context,
        ApiFuture<Service.ListAttestorsResponse> futureResponse) {
      ApiFuture<ListAttestorsPage> futurePage =
          ListAttestorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttestorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttestorsPagedResponse(ListAttestorsPage page) {
      super(page, ListAttestorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttestorsPage
      extends AbstractPage<
          Service.ListAttestorsRequest,
          Service.ListAttestorsResponse,
          Resources.Attestor,
          ListAttestorsPage> {

    private ListAttestorsPage(
        PageContext<Service.ListAttestorsRequest, Service.ListAttestorsResponse, Resources.Attestor>
            context,
        Service.ListAttestorsResponse response) {
      super(context, response);
    }

    private static ListAttestorsPage createEmptyPage() {
      return new ListAttestorsPage(null, null);
    }

    @Override
    protected ListAttestorsPage createPage(
        PageContext<Service.ListAttestorsRequest, Service.ListAttestorsResponse, Resources.Attestor>
            context,
        Service.ListAttestorsResponse response) {
      return new ListAttestorsPage(context, response);
    }

    @Override
    public ApiFuture<ListAttestorsPage> createPageAsync(
        PageContext<Service.ListAttestorsRequest, Service.ListAttestorsResponse, Resources.Attestor>
            context,
        ApiFuture<Service.ListAttestorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttestorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          Service.ListAttestorsRequest,
          Service.ListAttestorsResponse,
          Resources.Attestor,
          ListAttestorsPage,
          ListAttestorsFixedSizeCollection> {

    private ListAttestorsFixedSizeCollection(List<ListAttestorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttestorsFixedSizeCollection createEmptyCollection() {
      return new ListAttestorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttestorsFixedSizeCollection createCollection(
        List<ListAttestorsPage> pages, int collectionSize) {
      return new ListAttestorsFixedSizeCollection(pages, collectionSize);
    }
  }
}
