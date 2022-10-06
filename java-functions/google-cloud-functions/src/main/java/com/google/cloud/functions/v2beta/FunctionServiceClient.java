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

package com.google.cloud.functions.v2beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v2beta.stub.FunctionServiceStub;
import com.google.cloud.functions.v2beta.stub.FunctionServiceStubSettings;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Cloud Functions is used to deploy functions that are executed by
 * Google in response to various events. Data connected with that event is passed to a function as
 * the input data.
 *
 * <p>A &#42;&#42;function&#42;&#42; is a resource which describes a function that should be
 * executed and how it is triggered.
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
 * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
 *   FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
 *   Function response = functionServiceClient.getFunction(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FunctionServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of FunctionServiceSettings to
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
 * FunctionServiceSettings functionServiceSettings =
 *     FunctionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FunctionServiceClient functionServiceClient =
 *     FunctionServiceClient.create(functionServiceSettings);
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
 * FunctionServiceSettings functionServiceSettings =
 *     FunctionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FunctionServiceClient functionServiceClient =
 *     FunctionServiceClient.create(functionServiceSettings);
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
 * FunctionServiceSettings functionServiceSettings =
 *     FunctionServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             FunctionServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * FunctionServiceClient functionServiceClient =
 *     FunctionServiceClient.create(functionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FunctionServiceClient implements BackgroundResource {
  private final FunctionServiceSettings settings;
  private final FunctionServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of FunctionServiceClient with default settings. */
  public static final FunctionServiceClient create() throws IOException {
    return create(FunctionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FunctionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FunctionServiceClient create(FunctionServiceSettings settings)
      throws IOException {
    return new FunctionServiceClient(settings);
  }

  /**
   * Constructs an instance of FunctionServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(FunctionServiceSettings).
   */
  public static final FunctionServiceClient create(FunctionServiceStub stub) {
    return new FunctionServiceClient(stub);
  }

  /**
   * Constructs an instance of FunctionServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FunctionServiceClient(FunctionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FunctionServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected FunctionServiceClient(FunctionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final FunctionServiceSettings getSettings() {
    return settings;
  }

  public FunctionServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
   *   Function response = functionServiceClient.getFunction(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the function which details should be obtained.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Function getFunction(FunctionName name) {
    GetFunctionRequest request =
        GetFunctionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   String name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString();
   *   Function response = functionServiceClient.getFunction(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the function which details should be obtained.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Function getFunction(String name) {
    GetFunctionRequest request = GetFunctionRequest.newBuilder().setName(name).build();
    return getFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GetFunctionRequest request =
   *       GetFunctionRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   Function response = functionServiceClient.getFunction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Function getFunction(GetFunctionRequest request) {
    return getFunctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GetFunctionRequest request =
   *       GetFunctionRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   ApiFuture<Function> future = functionServiceClient.getFunctionCallable().futureCall(request);
   *   // Do something.
   *   Function response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFunctionRequest, Function> getFunctionCallable() {
    return stub.getFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Function element : functionServiceClient.listFunctions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the function should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;` If you want to list functions in
   *     all locations, use "-" in place of a location. When listing functions in all locations, if
   *     one or more location(s) are unreachable, the response will contain functions from all
   *     reachable locations along with the names of any unreachable locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFunctionsPagedResponse listFunctions(LocationName parent) {
    ListFunctionsRequest request =
        ListFunctionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFunctions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Function element : functionServiceClient.listFunctions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the function should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;` If you want to list functions in
   *     all locations, use "-" in place of a location. When listing functions in all locations, if
   *     one or more location(s) are unreachable, the response will contain functions from all
   *     reachable locations along with the names of any unreachable locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFunctionsPagedResponse listFunctions(String parent) {
    ListFunctionsRequest request = ListFunctionsRequest.newBuilder().setParent(parent).build();
    return listFunctions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListFunctionsRequest request =
   *       ListFunctionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Function element : functionServiceClient.listFunctions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFunctionsPagedResponse listFunctions(ListFunctionsRequest request) {
    return listFunctionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListFunctionsRequest request =
   *       ListFunctionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Function> future =
   *       functionServiceClient.listFunctionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Function element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    return stub.listFunctionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListFunctionsRequest request =
   *       ListFunctionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFunctionsResponse response =
   *         functionServiceClient.listFunctionsCallable().call(request);
   *     for (Function element : response.getFunctionsList()) {
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
  public final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    return stub.listFunctionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Function function = Function.newBuilder().build();
   *   String functionId = "functionId-62789869";
   *   Function response =
   *       functionServiceClient.createFunctionAsync(parent, function, functionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the function should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @param function Required. Function to be created.
   * @param functionId The ID to use for the function, which will become the final component of the
   *     function's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Function, OperationMetadata> createFunctionAsync(
      LocationName parent, Function function, String functionId) {
    CreateFunctionRequest request =
        CreateFunctionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFunction(function)
            .setFunctionId(functionId)
            .build();
    return createFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Function function = Function.newBuilder().build();
   *   String functionId = "functionId-62789869";
   *   Function response =
   *       functionServiceClient.createFunctionAsync(parent, function, functionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the function should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @param function Required. Function to be created.
   * @param functionId The ID to use for the function, which will become the final component of the
   *     function's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Function, OperationMetadata> createFunctionAsync(
      String parent, Function function, String functionId) {
    CreateFunctionRequest request =
        CreateFunctionRequest.newBuilder()
            .setParent(parent)
            .setFunction(function)
            .setFunctionId(functionId)
            .build();
    return createFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   CreateFunctionRequest request =
   *       CreateFunctionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFunction(Function.newBuilder().build())
   *           .setFunctionId("functionId-62789869")
   *           .build();
   *   Function response = functionServiceClient.createFunctionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Function, OperationMetadata> createFunctionAsync(
      CreateFunctionRequest request) {
    return createFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   CreateFunctionRequest request =
   *       CreateFunctionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFunction(Function.newBuilder().build())
   *           .setFunctionId("functionId-62789869")
   *           .build();
   *   OperationFuture<Function, OperationMetadata> future =
   *       functionServiceClient.createFunctionOperationCallable().futureCall(request);
   *   // Do something.
   *   Function response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable() {
    return stub.createFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   CreateFunctionRequest request =
   *       CreateFunctionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFunction(Function.newBuilder().build())
   *           .setFunctionId("functionId-62789869")
   *           .build();
   *   ApiFuture<Operation> future =
   *       functionServiceClient.createFunctionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return stub.createFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   Function function = Function.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Function response = functionServiceClient.updateFunctionAsync(function, updateMask).get();
   * }
   * }</pre>
   *
   * @param function Required. New version of the function.
   * @param updateMask The list of fields to be updated. If no field mask is provided, all provided
   *     fields in the request will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Function, OperationMetadata> updateFunctionAsync(
      Function function, FieldMask updateMask) {
    UpdateFunctionRequest request =
        UpdateFunctionRequest.newBuilder().setFunction(function).setUpdateMask(updateMask).build();
    return updateFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   UpdateFunctionRequest request =
   *       UpdateFunctionRequest.newBuilder()
   *           .setFunction(Function.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Function response = functionServiceClient.updateFunctionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Function, OperationMetadata> updateFunctionAsync(
      UpdateFunctionRequest request) {
    return updateFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   UpdateFunctionRequest request =
   *       UpdateFunctionRequest.newBuilder()
   *           .setFunction(Function.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Function, OperationMetadata> future =
   *       functionServiceClient.updateFunctionOperationCallable().futureCall(request);
   *   // Do something.
   *   Function response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable() {
    return stub.updateFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   UpdateFunctionRequest request =
   *       UpdateFunctionRequest.newBuilder()
   *           .setFunction(Function.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       functionServiceClient.updateFunctionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return stub.updateFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
   *   functionServiceClient.deleteFunctionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the function which should be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFunctionAsync(FunctionName name) {
    DeleteFunctionRequest request =
        DeleteFunctionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   String name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString();
   *   functionServiceClient.deleteFunctionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the function which should be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFunctionAsync(String name) {
    DeleteFunctionRequest request = DeleteFunctionRequest.newBuilder().setName(name).build();
    return deleteFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   DeleteFunctionRequest request =
   *       DeleteFunctionRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   functionServiceClient.deleteFunctionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFunctionAsync(
      DeleteFunctionRequest request) {
    return deleteFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   DeleteFunctionRequest request =
   *       DeleteFunctionRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       functionServiceClient.deleteFunctionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable() {
    return stub.deleteFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   DeleteFunctionRequest request =
   *       DeleteFunctionRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       functionServiceClient.deleteFunctionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return stub.deleteFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a signed URL for uploading a function source code. For more information about the
   * signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls. Once
   * the function source code upload is complete, the used signed URL should be provided in
   * CreateFunction or UpdateFunction request as a reference to the function source code.
   *
   * <p>When uploading source code to the generated signed URL, please follow these restrictions:
   *
   * <ul>
   *   <li>Source file type should be a zip file.
   *   <li>No credentials should be attached - the signed URLs provide access to the target bucket
   *       using internal service identity; if credentials were attached, the identity from the
   *       credentials would be used, but that identity does not have permissions to upload files to
   *       the URL.
   * </ul>
   *
   * <p>When making a HTTP PUT request, these two headers need to be specified:
   *
   * <ul>
   *   <li>`content-type: application/zip`
   * </ul>
   *
   * <p>And this header SHOULD NOT be specified:
   *
   * <ul>
   *   <li>`Authorization: Bearer YOUR_TOKEN`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GenerateUploadUrlRequest request =
   *       GenerateUploadUrlRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   GenerateUploadUrlResponse response = functionServiceClient.generateUploadUrl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateUploadUrlResponse generateUploadUrl(GenerateUploadUrlRequest request) {
    return generateUploadUrlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a signed URL for uploading a function source code. For more information about the
   * signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls. Once
   * the function source code upload is complete, the used signed URL should be provided in
   * CreateFunction or UpdateFunction request as a reference to the function source code.
   *
   * <p>When uploading source code to the generated signed URL, please follow these restrictions:
   *
   * <ul>
   *   <li>Source file type should be a zip file.
   *   <li>No credentials should be attached - the signed URLs provide access to the target bucket
   *       using internal service identity; if credentials were attached, the identity from the
   *       credentials would be used, but that identity does not have permissions to upload files to
   *       the URL.
   * </ul>
   *
   * <p>When making a HTTP PUT request, these two headers need to be specified:
   *
   * <ul>
   *   <li>`content-type: application/zip`
   * </ul>
   *
   * <p>And this header SHOULD NOT be specified:
   *
   * <ul>
   *   <li>`Authorization: Bearer YOUR_TOKEN`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GenerateUploadUrlRequest request =
   *       GenerateUploadUrlRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<GenerateUploadUrlResponse> future =
   *       functionServiceClient.generateUploadUrlCallable().futureCall(request);
   *   // Do something.
   *   GenerateUploadUrlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    return stub.generateUploadUrlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a signed URL for downloading deployed function source code. The URL is only valid for a
   * limited period and should be used within 30 minutes of generation. For more information about
   * the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GenerateDownloadUrlRequest request =
   *       GenerateDownloadUrlRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   GenerateDownloadUrlResponse response = functionServiceClient.generateDownloadUrl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateDownloadUrlResponse generateDownloadUrl(GenerateDownloadUrlRequest request) {
    return generateDownloadUrlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a signed URL for downloading deployed function source code. The URL is only valid for a
   * limited period and should be used within 30 minutes of generation. For more information about
   * the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GenerateDownloadUrlRequest request =
   *       GenerateDownloadUrlRequest.newBuilder()
   *           .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .build();
   *   ApiFuture<GenerateDownloadUrlResponse> future =
   *       functionServiceClient.generateDownloadUrlCallable().futureCall(request);
   *   // Do something.
   *   GenerateDownloadUrlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    return stub.generateDownloadUrlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of runtimes that are supported for the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListRuntimesResponse response = functionServiceClient.listRuntimes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the runtimes should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesResponse listRuntimes(LocationName parent) {
    ListRuntimesRequest request =
        ListRuntimesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of runtimes that are supported for the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListRuntimesResponse response = functionServiceClient.listRuntimes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the runtimes should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesResponse listRuntimes(String parent) {
    ListRuntimesRequest request = ListRuntimesRequest.newBuilder().setParent(parent).build();
    return listRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of runtimes that are supported for the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListRuntimesRequest request =
   *       ListRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ListRuntimesResponse response = functionServiceClient.listRuntimes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuntimesResponse listRuntimes(ListRuntimesRequest request) {
    return listRuntimesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of runtimes that are supported for the requested project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListRuntimesRequest request =
   *       ListRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ListRuntimesResponse> future =
   *       functionServiceClient.listRuntimesCallable().futureCall(request);
   *   // Do something.
   *   ListRuntimesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    return stub.listRuntimesCallable();
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : functionServiceClient.listLocations(request).iterateAll()) {
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       functionServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         functionServiceClient.listLocationsCallable().call(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = functionServiceClient.setIamPolicy(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = functionServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = functionServiceClient.getIamPolicy(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = functionServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = functionServiceClient.testIamPermissions(request);
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
   * try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       functionServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListFunctionsPagedResponse
      extends AbstractPagedListResponse<
          ListFunctionsRequest,
          ListFunctionsResponse,
          Function,
          ListFunctionsPage,
          ListFunctionsFixedSizeCollection> {

    public static ApiFuture<ListFunctionsPagedResponse> createAsync(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, Function> context,
        ApiFuture<ListFunctionsResponse> futureResponse) {
      ApiFuture<ListFunctionsPage> futurePage =
          ListFunctionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFunctionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFunctionsPagedResponse(ListFunctionsPage page) {
      super(page, ListFunctionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFunctionsPage
      extends AbstractPage<
          ListFunctionsRequest, ListFunctionsResponse, Function, ListFunctionsPage> {

    private ListFunctionsPage(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, Function> context,
        ListFunctionsResponse response) {
      super(context, response);
    }

    private static ListFunctionsPage createEmptyPage() {
      return new ListFunctionsPage(null, null);
    }

    @Override
    protected ListFunctionsPage createPage(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, Function> context,
        ListFunctionsResponse response) {
      return new ListFunctionsPage(context, response);
    }

    @Override
    public ApiFuture<ListFunctionsPage> createPageAsync(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, Function> context,
        ApiFuture<ListFunctionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFunctionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFunctionsRequest,
          ListFunctionsResponse,
          Function,
          ListFunctionsPage,
          ListFunctionsFixedSizeCollection> {

    private ListFunctionsFixedSizeCollection(List<ListFunctionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFunctionsFixedSizeCollection createEmptyCollection() {
      return new ListFunctionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFunctionsFixedSizeCollection createCollection(
        List<ListFunctionsPage> pages, int collectionSize) {
      return new ListFunctionsFixedSizeCollection(pages, collectionSize);
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
