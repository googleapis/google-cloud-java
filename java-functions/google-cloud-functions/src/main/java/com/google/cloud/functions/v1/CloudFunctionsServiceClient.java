/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.functions.v1;

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
import com.google.cloud.functions.v1.stub.CloudFunctionsServiceStub;
import com.google.cloud.functions.v1.stub.CloudFunctionsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that application uses to manipulate triggers and functions.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the CloudFunctionsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of CloudFunctionsServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CloudFunctionsServiceSettings cloudFunctionsServiceSettings =
 *     CloudFunctionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudFunctionsServiceClient cloudFunctionsServiceClient =
 *     CloudFunctionsServiceClient.create(cloudFunctionsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CloudFunctionsServiceSettings cloudFunctionsServiceSettings =
 *     CloudFunctionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudFunctionsServiceClient cloudFunctionsServiceClient =
 *     CloudFunctionsServiceClient.create(cloudFunctionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudFunctionsServiceClient implements BackgroundResource {
  private final CloudFunctionsServiceSettings settings;
  private final CloudFunctionsServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of CloudFunctionsServiceClient with default settings. */
  public static final CloudFunctionsServiceClient create() throws IOException {
    return create(CloudFunctionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudFunctionsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudFunctionsServiceClient create(CloudFunctionsServiceSettings settings)
      throws IOException {
    return new CloudFunctionsServiceClient(settings);
  }

  /**
   * Constructs an instance of CloudFunctionsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CloudFunctionsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CloudFunctionsServiceClient create(CloudFunctionsServiceStub stub) {
    return new CloudFunctionsServiceClient(stub);
  }

  /**
   * Constructs an instance of CloudFunctionsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudFunctionsServiceClient(CloudFunctionsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudFunctionsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudFunctionsServiceClient(CloudFunctionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CloudFunctionsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudFunctionsServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of functions that belong to the requested project.
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
   */
  public final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    return stub.listFunctionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * @param name Required. The name of the function which details should be obtained.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudFunction getFunction(CloudFunctionName name) {
    GetFunctionRequest request =
        GetFunctionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * @param name Required. The name of the function which details should be obtained.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudFunction getFunction(String name) {
    GetFunctionRequest request = GetFunctionRequest.newBuilder().setName(name).build();
    return getFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudFunction getFunction(GetFunctionRequest request) {
    return getFunctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a function with the given name from the requested project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable() {
    return stub.getFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * @param location Required. The project and location in which the function should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @param function Required. Function to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudFunction, OperationMetadataV1> createFunctionAsync(
      LocationName location, CloudFunction function) {
    CreateFunctionRequest request =
        CreateFunctionRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .setFunction(function)
            .build();
    return createFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * @param location Required. The project and location in which the function should be created,
   *     specified in the format `projects/&#42;/locations/&#42;`
   * @param function Required. Function to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudFunction, OperationMetadataV1> createFunctionAsync(
      String location, CloudFunction function) {
    CreateFunctionRequest request =
        CreateFunctionRequest.newBuilder().setLocation(location).setFunction(function).build();
    return createFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudFunction, OperationMetadataV1> createFunctionAsync(
      CreateFunctionRequest request) {
    return createFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable() {
    return stub.createFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new function. If a function with the given name already exists in the specified
   * project, the long running operation will return `ALREADY_EXISTS` error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return stub.createFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * @param function Required. New version of the function.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudFunction, OperationMetadataV1> updateFunctionAsync(
      CloudFunction function) {
    UpdateFunctionRequest request =
        UpdateFunctionRequest.newBuilder().setFunction(function).build();
    return updateFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudFunction, OperationMetadataV1> updateFunctionAsync(
      UpdateFunctionRequest request) {
    return updateFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable() {
    return stub.updateFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates existing function.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return stub.updateFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * @param name Required. The name of the function which should be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadataV1> deleteFunctionAsync(
      CloudFunctionName name) {
    DeleteFunctionRequest request =
        DeleteFunctionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * @param name Required. The name of the function which should be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadataV1> deleteFunctionAsync(String name) {
    DeleteFunctionRequest request = DeleteFunctionRequest.newBuilder().setName(name).build();
    return deleteFunctionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadataV1> deleteFunctionAsync(
      DeleteFunctionRequest request) {
    return deleteFunctionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable() {
    return stub.deleteFunctionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a function with the given name from the specified project. If the given function is
   * used by some trigger, the trigger will be updated to remove this function.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return stub.deleteFunctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronously invokes a deployed Cloud Function. To be used for testing purposes as very
   * limited traffic is allowed. For more information on the actual limits, refer to [Rate
   * Limits](https://cloud.google.com/functions/quotas#rate_limits).
   *
   * @param name Required. The name of the function to be called.
   * @param data Required. Input to be passed to the function.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallFunctionResponse callFunction(CloudFunctionName name, String data) {
    CallFunctionRequest request =
        CallFunctionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setData(data)
            .build();
    return callFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronously invokes a deployed Cloud Function. To be used for testing purposes as very
   * limited traffic is allowed. For more information on the actual limits, refer to [Rate
   * Limits](https://cloud.google.com/functions/quotas#rate_limits).
   *
   * @param name Required. The name of the function to be called.
   * @param data Required. Input to be passed to the function.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallFunctionResponse callFunction(String name, String data) {
    CallFunctionRequest request =
        CallFunctionRequest.newBuilder().setName(name).setData(data).build();
    return callFunction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronously invokes a deployed Cloud Function. To be used for testing purposes as very
   * limited traffic is allowed. For more information on the actual limits, refer to [Rate
   * Limits](https://cloud.google.com/functions/quotas#rate_limits).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallFunctionResponse callFunction(CallFunctionRequest request) {
    return callFunctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synchronously invokes a deployed Cloud Function. To be used for testing purposes as very
   * limited traffic is allowed. For more information on the actual limits, refer to [Rate
   * Limits](https://cloud.google.com/functions/quotas#rate_limits).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable() {
    return stub.callFunctionCallable();
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
   *   <li>Source file size should not exceed 100MB limit.
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
   *   <li>`x-goog-content-length-range: 0,104857600`
   * </ul>
   *
   * <p>And this header SHOULD NOT be specified:
   *
   * <ul>
   *   <li>`Authorization: Bearer YOUR_TOKEN`
   * </ul>
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
   *   <li>Source file size should not exceed 100MB limit.
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
   *   <li>`x-goog-content-length-range: 0,104857600`
   * </ul>
   *
   * <p>And this header SHOULD NOT be specified:
   *
   * <ul>
   *   <li>`Authorization: Bearer YOUR_TOKEN`
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    return stub.generateUploadUrlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a signed URL for downloading deployed function source code. The URL is only valid for a
   * limited period and should be used within minutes after generation. For more information about
   * the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls
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
   * limited period and should be used within minutes after generation. For more information about
   * the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    return stub.generateDownloadUrlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy on the specified function. Replaces any existing policy.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy on the specified function. Replaces any existing policy.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for a function. Returns an empty policy if the function
   * exists and does not have a policy set.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for a function. Returns an empty policy if the function
   * exists and does not have a policy set.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the specified permissions against the IAM access control policy for a function. If the
   * function does not exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the specified permissions against the IAM access control policy for a function. If the
   * function does not exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
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
          CloudFunction,
          ListFunctionsPage,
          ListFunctionsFixedSizeCollection> {

    public static ApiFuture<ListFunctionsPagedResponse> createAsync(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, CloudFunction> context,
        ApiFuture<ListFunctionsResponse> futureResponse) {
      ApiFuture<ListFunctionsPage> futurePage =
          ListFunctionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFunctionsPage, ListFunctionsPagedResponse>() {
            @Override
            public ListFunctionsPagedResponse apply(ListFunctionsPage input) {
              return new ListFunctionsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListFunctionsPagedResponse(ListFunctionsPage page) {
      super(page, ListFunctionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFunctionsPage
      extends AbstractPage<
          ListFunctionsRequest, ListFunctionsResponse, CloudFunction, ListFunctionsPage> {

    private ListFunctionsPage(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, CloudFunction> context,
        ListFunctionsResponse response) {
      super(context, response);
    }

    private static ListFunctionsPage createEmptyPage() {
      return new ListFunctionsPage(null, null);
    }

    @Override
    protected ListFunctionsPage createPage(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, CloudFunction> context,
        ListFunctionsResponse response) {
      return new ListFunctionsPage(context, response);
    }

    @Override
    public ApiFuture<ListFunctionsPage> createPageAsync(
        PageContext<ListFunctionsRequest, ListFunctionsResponse, CloudFunction> context,
        ApiFuture<ListFunctionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFunctionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFunctionsRequest,
          ListFunctionsResponse,
          CloudFunction,
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
}
