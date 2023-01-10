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

package com.google.cloud.dialogflow.cx.v3;

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
import com.google.cloud.dialogflow.cx.v3.stub.TestCasesStub;
import com.google.cloud.dialogflow.cx.v3.stub.TestCasesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Test Cases][google.cloud.dialogflow.cx.v3.TestCase]
 * and [Test Case Results][google.cloud.dialogflow.cx.v3.TestCaseResult].
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
 * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
 *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   testCasesClient.batchDeleteTestCases(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TestCasesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of TestCasesSettings to create().
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
 * TestCasesSettings testCasesSettings =
 *     TestCasesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TestCasesClient testCasesClient = TestCasesClient.create(testCasesSettings);
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
 * TestCasesSettings testCasesSettings =
 *     TestCasesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TestCasesClient testCasesClient = TestCasesClient.create(testCasesSettings);
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
 * TestCasesSettings testCasesSettings = TestCasesSettings.newHttpJsonBuilder().build();
 * TestCasesClient testCasesClient = TestCasesClient.create(testCasesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TestCasesClient implements BackgroundResource {
  private final TestCasesSettings settings;
  private final TestCasesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TestCasesClient with default settings. */
  public static final TestCasesClient create() throws IOException {
    return create(TestCasesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TestCasesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TestCasesClient create(TestCasesSettings settings) throws IOException {
    return new TestCasesClient(settings);
  }

  /**
   * Constructs an instance of TestCasesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TestCasesSettings).
   */
  public static final TestCasesClient create(TestCasesStub stub) {
    return new TestCasesClient(stub);
  }

  /**
   * Constructs an instance of TestCasesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TestCasesClient(TestCasesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TestCasesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TestCasesClient(TestCasesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TestCasesSettings getSettings() {
    return settings;
  }

  public TestCasesStub getStub() {
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
   * Fetches a list of test cases for a given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (TestCase element : testCasesClient.listTestCases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all pages for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCasesPagedResponse listTestCases(AgentName parent) {
    ListTestCasesRequest request =
        ListTestCasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTestCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of test cases for a given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (TestCase element : testCasesClient.listTestCases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent to list all pages for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCasesPagedResponse listTestCases(String parent) {
    ListTestCasesRequest request = ListTestCasesRequest.newBuilder().setParent(parent).build();
    return listTestCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of test cases for a given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCasesRequest request =
   *       ListTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TestCase element : testCasesClient.listTestCases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCasesPagedResponse listTestCases(ListTestCasesRequest request) {
    return listTestCasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of test cases for a given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCasesRequest request =
   *       ListTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TestCase> future = testCasesClient.listTestCasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TestCase element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable() {
    return stub.listTestCasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of test cases for a given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCasesRequest request =
   *       ListTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTestCasesResponse response = testCasesClient.listTestCasesCallable().call(request);
   *     for (TestCase element : response.getTestCasesList()) {
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
  public final UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable() {
    return stub.listTestCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes test cases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   testCasesClient.batchDeleteTestCases(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to delete test cases from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteTestCases(AgentName parent) {
    BatchDeleteTestCasesRequest request =
        BatchDeleteTestCasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    batchDeleteTestCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes test cases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   testCasesClient.batchDeleteTestCases(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to delete test cases from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteTestCases(String parent) {
    BatchDeleteTestCasesRequest request =
        BatchDeleteTestCasesRequest.newBuilder().setParent(parent).build();
    batchDeleteTestCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes test cases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   BatchDeleteTestCasesRequest request =
   *       BatchDeleteTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   testCasesClient.batchDeleteTestCases(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteTestCases(BatchDeleteTestCasesRequest request) {
    batchDeleteTestCasesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes test cases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   BatchDeleteTestCasesRequest request =
   *       BatchDeleteTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future = testCasesClient.batchDeleteTestCasesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable() {
    return stub.batchDeleteTestCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   TestCaseName name = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");
   *   TestCase response = testCasesClient.getTestCase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the testcase. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/testCases/&lt;TestCase
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase getTestCase(TestCaseName name) {
    GetTestCaseRequest request =
        GetTestCaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTestCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String name = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString();
   *   TestCase response = testCasesClient.getTestCase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the testcase. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/testCases/&lt;TestCase
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase getTestCase(String name) {
    GetTestCaseRequest request = GetTestCaseRequest.newBuilder().setName(name).build();
    return getTestCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetTestCaseRequest request =
   *       GetTestCaseRequest.newBuilder()
   *           .setName(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .build();
   *   TestCase response = testCasesClient.getTestCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase getTestCase(GetTestCaseRequest request) {
    return getTestCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetTestCaseRequest request =
   *       GetTestCaseRequest.newBuilder()
   *           .setName(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .build();
   *   ApiFuture<TestCase> future = testCasesClient.getTestCaseCallable().futureCall(request);
   *   // Do something.
   *   TestCase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable() {
    return stub.getTestCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a test case for the given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   TestCase testCase = TestCase.newBuilder().build();
   *   TestCase response = testCasesClient.createTestCase(parent, testCase);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create the test case for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param testCase Required. The test case to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase createTestCase(AgentName parent, TestCase testCase) {
    CreateTestCaseRequest request =
        CreateTestCaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTestCase(testCase)
            .build();
    return createTestCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a test case for the given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   TestCase testCase = TestCase.newBuilder().build();
   *   TestCase response = testCasesClient.createTestCase(parent, testCase);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create the test case for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param testCase Required. The test case to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase createTestCase(String parent, TestCase testCase) {
    CreateTestCaseRequest request =
        CreateTestCaseRequest.newBuilder().setParent(parent).setTestCase(testCase).build();
    return createTestCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a test case for the given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   CreateTestCaseRequest request =
   *       CreateTestCaseRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setTestCase(TestCase.newBuilder().build())
   *           .build();
   *   TestCase response = testCasesClient.createTestCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase createTestCase(CreateTestCaseRequest request) {
    return createTestCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a test case for the given agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   CreateTestCaseRequest request =
   *       CreateTestCaseRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setTestCase(TestCase.newBuilder().build())
   *           .build();
   *   ApiFuture<TestCase> future = testCasesClient.createTestCaseCallable().futureCall(request);
   *   // Do something.
   *   TestCase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable() {
    return stub.createTestCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   TestCase testCase = TestCase.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TestCase response = testCasesClient.updateTestCase(testCase, updateMask);
   * }
   * }</pre>
   *
   * @param testCase Required. The test case to update.
   * @param updateMask Required. The mask to specify which fields should be updated. The
   *     [`creationTime`][google.cloud.dialogflow.cx.v3.TestCase.creation_time] and
   *     [`lastTestResult`][google.cloud.dialogflow.cx.v3.TestCase.last_test_result] cannot be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase updateTestCase(TestCase testCase, FieldMask updateMask) {
    UpdateTestCaseRequest request =
        UpdateTestCaseRequest.newBuilder().setTestCase(testCase).setUpdateMask(updateMask).build();
    return updateTestCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   UpdateTestCaseRequest request =
   *       UpdateTestCaseRequest.newBuilder()
   *           .setTestCase(TestCase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TestCase response = testCasesClient.updateTestCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCase updateTestCase(UpdateTestCaseRequest request) {
    return updateTestCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   UpdateTestCaseRequest request =
   *       UpdateTestCaseRequest.newBuilder()
   *           .setTestCase(TestCase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TestCase> future = testCasesClient.updateTestCaseCallable().futureCall(request);
   *   // Do something.
   *   TestCase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable() {
    return stub.updateTestCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a test case run.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3.RunTestCaseMetadata] -
   * `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3.RunTestCaseResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   RunTestCaseRequest request =
   *       RunTestCaseRequest.newBuilder()
   *           .setName(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   RunTestCaseResponse response = testCasesClient.runTestCaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunTestCaseResponse, RunTestCaseMetadata> runTestCaseAsync(
      RunTestCaseRequest request) {
    return runTestCaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a test case run.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3.RunTestCaseMetadata] -
   * `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3.RunTestCaseResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   RunTestCaseRequest request =
   *       RunTestCaseRequest.newBuilder()
   *           .setName(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RunTestCaseResponse, RunTestCaseMetadata> future =
   *       testCasesClient.runTestCaseOperationCallable().futureCall(request);
   *   // Do something.
   *   RunTestCaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable() {
    return stub.runTestCaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a test case run.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3.RunTestCaseMetadata] -
   * `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3.RunTestCaseResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   RunTestCaseRequest request =
   *       RunTestCaseRequest.newBuilder()
   *           .setName(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = testCasesClient.runTestCaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable() {
    return stub.runTestCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a batch run of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata] -
   * `response`:
   * [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   BatchRunTestCasesRequest request =
   *       BatchRunTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .addAllTestCases(new ArrayList<String>())
   *           .build();
   *   BatchRunTestCasesResponse response = testCasesClient.batchRunTestCasesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesAsync(BatchRunTestCasesRequest request) {
    return batchRunTestCasesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a batch run of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata] -
   * `response`:
   * [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   BatchRunTestCasesRequest request =
   *       BatchRunTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .addAllTestCases(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BatchRunTestCasesResponse, BatchRunTestCasesMetadata> future =
   *       testCasesClient.batchRunTestCasesOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchRunTestCasesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable() {
    return stub.batchRunTestCasesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Kicks off a batch run of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata] -
   * `response`:
   * [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   BatchRunTestCasesRequest request =
   *       BatchRunTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setEnvironment(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .addAllTestCases(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future = testCasesClient.batchRunTestCasesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable() {
    return stub.batchRunTestCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the test coverage for an agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   CalculateCoverageRequest request =
   *       CalculateCoverageRequest.newBuilder()
   *           .setAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   CalculateCoverageResponse response = testCasesClient.calculateCoverage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateCoverageResponse calculateCoverage(CalculateCoverageRequest request) {
    return calculateCoverageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the test coverage for an agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   CalculateCoverageRequest request =
   *       CalculateCoverageRequest.newBuilder()
   *           .setAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   ApiFuture<CalculateCoverageResponse> future =
   *       testCasesClient.calculateCoverageCallable().futureCall(request);
   *   // Do something.
   *   CalculateCoverageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable() {
    return stub.calculateCoverageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the test cases from a Cloud Storage bucket or a local file. It always creates new test
   * cases and won't overwrite any existing ones. The provided ID in the imported test case is
   * neglected.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata] - `response`:
   * [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3.ImportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ImportTestCasesRequest request =
   *       ImportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   ImportTestCasesResponse response = testCasesClient.importTestCasesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesAsync(ImportTestCasesRequest request) {
    return importTestCasesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the test cases from a Cloud Storage bucket or a local file. It always creates new test
   * cases and won't overwrite any existing ones. The provided ID in the imported test case is
   * neglected.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata] - `response`:
   * [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3.ImportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ImportTestCasesRequest request =
   *       ImportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   OperationFuture<ImportTestCasesResponse, ImportTestCasesMetadata> future =
   *       testCasesClient.importTestCasesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportTestCasesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable() {
    return stub.importTestCasesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the test cases from a Cloud Storage bucket or a local file. It always creates new test
   * cases and won't overwrite any existing ones. The provided ID in the imported test case is
   * neglected.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata] - `response`:
   * [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3.ImportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ImportTestCasesRequest request =
   *       ImportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = testCasesClient.importTestCasesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable() {
    return stub.importTestCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the test cases under the agent to a Cloud Storage bucket or a local file. Filter can be
   * applied to export a subset of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata] - `response`:
   * [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3.ExportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ExportTestCasesRequest request =
   *       ExportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ExportTestCasesResponse response = testCasesClient.exportTestCasesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesAsync(ExportTestCasesRequest request) {
    return exportTestCasesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the test cases under the agent to a Cloud Storage bucket or a local file. Filter can be
   * applied to export a subset of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata] - `response`:
   * [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3.ExportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ExportTestCasesRequest request =
   *       ExportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   OperationFuture<ExportTestCasesResponse, ExportTestCasesMetadata> future =
   *       testCasesClient.exportTestCasesOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportTestCasesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable() {
    return stub.exportTestCasesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the test cases under the agent to a Cloud Storage bucket or a local file. Filter can be
   * applied to export a subset of test cases.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata] - `response`:
   * [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3.ExportTestCasesResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ExportTestCasesRequest request =
   *       ExportTestCasesRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Operation> future = testCasesClient.exportTestCasesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable() {
    return stub.exportTestCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of results for a given test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   TestCaseName parent = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");
   *   for (TestCaseResult element : testCasesClient.listTestCaseResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The test case to list results for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/ testCases/&lt;TestCase
   *     ID&gt;`. Specify a `-` as a wildcard for TestCase ID to list results across multiple test
   *     cases.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCaseResultsPagedResponse listTestCaseResults(TestCaseName parent) {
    ListTestCaseResultsRequest request =
        ListTestCaseResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTestCaseResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of results for a given test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String parent =
   *       TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString();
   *   for (TestCaseResult element : testCasesClient.listTestCaseResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The test case to list results for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/ testCases/&lt;TestCase
   *     ID&gt;`. Specify a `-` as a wildcard for TestCase ID to list results across multiple test
   *     cases.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCaseResultsPagedResponse listTestCaseResults(String parent) {
    ListTestCaseResultsRequest request =
        ListTestCaseResultsRequest.newBuilder().setParent(parent).build();
    return listTestCaseResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of results for a given test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCaseResultsRequest request =
   *       ListTestCaseResultsRequest.newBuilder()
   *           .setParent(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (TestCaseResult element : testCasesClient.listTestCaseResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTestCaseResultsPagedResponse listTestCaseResults(
      ListTestCaseResultsRequest request) {
    return listTestCaseResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of results for a given test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCaseResultsRequest request =
   *       ListTestCaseResultsRequest.newBuilder()
   *           .setParent(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<TestCaseResult> future =
   *       testCasesClient.listTestCaseResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TestCaseResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable() {
    return stub.listTestCaseResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a list of results for a given test case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListTestCaseResultsRequest request =
   *       ListTestCaseResultsRequest.newBuilder()
   *           .setParent(
   *               TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListTestCaseResultsResponse response =
   *         testCasesClient.listTestCaseResultsCallable().call(request);
   *     for (TestCaseResult element : response.getTestCaseResultsList()) {
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
  public final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable() {
    return stub.listTestCaseResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   TestCaseResultName name =
   *       TestCaseResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]", "[RESULT]");
   *   TestCaseResult response = testCasesClient.getTestCaseResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the testcase. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/testCases/&lt;TestCase
   *     ID&gt;/results/&lt;TestCaseResult ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCaseResult getTestCaseResult(TestCaseResultName name) {
    GetTestCaseResultRequest request =
        GetTestCaseResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTestCaseResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   String name =
   *       TestCaseResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]", "[RESULT]")
   *           .toString();
   *   TestCaseResult response = testCasesClient.getTestCaseResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the testcase. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/testCases/&lt;TestCase
   *     ID&gt;/results/&lt;TestCaseResult ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCaseResult getTestCaseResult(String name) {
    GetTestCaseResultRequest request = GetTestCaseResultRequest.newBuilder().setName(name).build();
    return getTestCaseResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetTestCaseResultRequest request =
   *       GetTestCaseResultRequest.newBuilder()
   *           .setName(
   *               TestCaseResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]", "[RESULT]")
   *                   .toString())
   *           .build();
   *   TestCaseResult response = testCasesClient.getTestCaseResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestCaseResult getTestCaseResult(GetTestCaseResultRequest request) {
    return getTestCaseResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a test case result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetTestCaseResultRequest request =
   *       GetTestCaseResultRequest.newBuilder()
   *           .setName(
   *               TestCaseResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]", "[RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TestCaseResult> future =
   *       testCasesClient.getTestCaseResultCallable().futureCall(request);
   *   // Do something.
   *   TestCaseResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultCallable() {
    return stub.getTestCaseResultCallable();
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
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : testCasesClient.listLocations(request).iterateAll()) {
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
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = testCasesClient.listLocationsPagedCallable().futureCall(request);
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
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = testCasesClient.listLocationsCallable().call(request);
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
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = testCasesClient.getLocation(request);
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
   * try (TestCasesClient testCasesClient = TestCasesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = testCasesClient.getLocationCallable().futureCall(request);
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

  public static class ListTestCasesPagedResponse
      extends AbstractPagedListResponse<
          ListTestCasesRequest,
          ListTestCasesResponse,
          TestCase,
          ListTestCasesPage,
          ListTestCasesFixedSizeCollection> {

    public static ApiFuture<ListTestCasesPagedResponse> createAsync(
        PageContext<ListTestCasesRequest, ListTestCasesResponse, TestCase> context,
        ApiFuture<ListTestCasesResponse> futureResponse) {
      ApiFuture<ListTestCasesPage> futurePage =
          ListTestCasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTestCasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTestCasesPagedResponse(ListTestCasesPage page) {
      super(page, ListTestCasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTestCasesPage
      extends AbstractPage<
          ListTestCasesRequest, ListTestCasesResponse, TestCase, ListTestCasesPage> {

    private ListTestCasesPage(
        PageContext<ListTestCasesRequest, ListTestCasesResponse, TestCase> context,
        ListTestCasesResponse response) {
      super(context, response);
    }

    private static ListTestCasesPage createEmptyPage() {
      return new ListTestCasesPage(null, null);
    }

    @Override
    protected ListTestCasesPage createPage(
        PageContext<ListTestCasesRequest, ListTestCasesResponse, TestCase> context,
        ListTestCasesResponse response) {
      return new ListTestCasesPage(context, response);
    }

    @Override
    public ApiFuture<ListTestCasesPage> createPageAsync(
        PageContext<ListTestCasesRequest, ListTestCasesResponse, TestCase> context,
        ApiFuture<ListTestCasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTestCasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTestCasesRequest,
          ListTestCasesResponse,
          TestCase,
          ListTestCasesPage,
          ListTestCasesFixedSizeCollection> {

    private ListTestCasesFixedSizeCollection(List<ListTestCasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTestCasesFixedSizeCollection createEmptyCollection() {
      return new ListTestCasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTestCasesFixedSizeCollection createCollection(
        List<ListTestCasesPage> pages, int collectionSize) {
      return new ListTestCasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTestCaseResultsPagedResponse
      extends AbstractPagedListResponse<
          ListTestCaseResultsRequest,
          ListTestCaseResultsResponse,
          TestCaseResult,
          ListTestCaseResultsPage,
          ListTestCaseResultsFixedSizeCollection> {

    public static ApiFuture<ListTestCaseResultsPagedResponse> createAsync(
        PageContext<ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
            context,
        ApiFuture<ListTestCaseResultsResponse> futureResponse) {
      ApiFuture<ListTestCaseResultsPage> futurePage =
          ListTestCaseResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTestCaseResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTestCaseResultsPagedResponse(ListTestCaseResultsPage page) {
      super(page, ListTestCaseResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTestCaseResultsPage
      extends AbstractPage<
          ListTestCaseResultsRequest,
          ListTestCaseResultsResponse,
          TestCaseResult,
          ListTestCaseResultsPage> {

    private ListTestCaseResultsPage(
        PageContext<ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
            context,
        ListTestCaseResultsResponse response) {
      super(context, response);
    }

    private static ListTestCaseResultsPage createEmptyPage() {
      return new ListTestCaseResultsPage(null, null);
    }

    @Override
    protected ListTestCaseResultsPage createPage(
        PageContext<ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
            context,
        ListTestCaseResultsResponse response) {
      return new ListTestCaseResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListTestCaseResultsPage> createPageAsync(
        PageContext<ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
            context,
        ApiFuture<ListTestCaseResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTestCaseResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTestCaseResultsRequest,
          ListTestCaseResultsResponse,
          TestCaseResult,
          ListTestCaseResultsPage,
          ListTestCaseResultsFixedSizeCollection> {

    private ListTestCaseResultsFixedSizeCollection(
        List<ListTestCaseResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTestCaseResultsFixedSizeCollection createEmptyCollection() {
      return new ListTestCaseResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTestCaseResultsFixedSizeCollection createCollection(
        List<ListTestCaseResultsPage> pages, int collectionSize) {
      return new ListTestCaseResultsFixedSizeCollection(pages, collectionSize);
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
