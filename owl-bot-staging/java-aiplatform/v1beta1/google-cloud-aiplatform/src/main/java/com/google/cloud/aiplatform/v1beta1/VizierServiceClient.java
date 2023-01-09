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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.VizierServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.VizierServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
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
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Vertex AI Vizier API.
 *
 * <p>Vertex AI Vizier is a service to solve blackbox optimization problems, such as tuning machine
 * learning hyperparameters and searching over deep learning architectures.
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
 * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Study study = Study.newBuilder().build();
 *   Study response = vizierServiceClient.createStudy(parent, study);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VizierServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of VizierServiceSettings to
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
 * VizierServiceSettings vizierServiceSettings =
 *     VizierServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VizierServiceClient vizierServiceClient = VizierServiceClient.create(vizierServiceSettings);
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
 * VizierServiceSettings vizierServiceSettings =
 *     VizierServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VizierServiceClient vizierServiceClient = VizierServiceClient.create(vizierServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VizierServiceClient implements BackgroundResource {
  private final VizierServiceSettings settings;
  private final VizierServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VizierServiceClient with default settings. */
  public static final VizierServiceClient create() throws IOException {
    return create(VizierServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VizierServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VizierServiceClient create(VizierServiceSettings settings)
      throws IOException {
    return new VizierServiceClient(settings);
  }

  /**
   * Constructs an instance of VizierServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(VizierServiceSettings).
   */
  public static final VizierServiceClient create(VizierServiceStub stub) {
    return new VizierServiceClient(stub);
  }

  /**
   * Constructs an instance of VizierServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VizierServiceClient(VizierServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VizierServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected VizierServiceClient(VizierServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VizierServiceSettings getSettings() {
    return settings;
  }

  public VizierServiceStub getStub() {
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
   * Creates a Study. A resource name will be generated after creation of the Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Study study = Study.newBuilder().build();
   *   Study response = vizierServiceClient.createStudy(parent, study);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the CustomJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param study Required. The Study configuration used to create the Study.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study createStudy(LocationName parent, Study study) {
    CreateStudyRequest request =
        CreateStudyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStudy(study)
            .build();
    return createStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Study. A resource name will be generated after creation of the Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Study study = Study.newBuilder().build();
   *   Study response = vizierServiceClient.createStudy(parent, study);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the CustomJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param study Required. The Study configuration used to create the Study.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study createStudy(String parent, Study study) {
    CreateStudyRequest request =
        CreateStudyRequest.newBuilder().setParent(parent).setStudy(study).build();
    return createStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Study. A resource name will be generated after creation of the Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CreateStudyRequest request =
   *       CreateStudyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStudy(Study.newBuilder().build())
   *           .build();
   *   Study response = vizierServiceClient.createStudy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study createStudy(CreateStudyRequest request) {
    return createStudyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Study. A resource name will be generated after creation of the Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CreateStudyRequest request =
   *       CreateStudyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStudy(Study.newBuilder().build())
   *           .build();
   *   ApiFuture<Study> future = vizierServiceClient.createStudyCallable().futureCall(request);
   *   // Do something.
   *   Study response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStudyRequest, Study> createStudyCallable() {
    return stub.createStudyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Study by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
   *   Study response = vizierServiceClient.getStudy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Study resource. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study getStudy(StudyName name) {
    GetStudyRequest request =
        GetStudyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Study by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString();
   *   Study response = vizierServiceClient.getStudy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Study resource. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study getStudy(String name) {
    GetStudyRequest request = GetStudyRequest.newBuilder().setName(name).build();
    return getStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Study by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetStudyRequest request =
   *       GetStudyRequest.newBuilder()
   *           .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   Study response = vizierServiceClient.getStudy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study getStudy(GetStudyRequest request) {
    return getStudyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Study by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetStudyRequest request =
   *       GetStudyRequest.newBuilder()
   *           .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   ApiFuture<Study> future = vizierServiceClient.getStudyCallable().futureCall(request);
   *   // Do something.
   *   Study response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStudyRequest, Study> getStudyCallable() {
    return stub.getStudyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the studies in a region for an associated project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Study element : vizierServiceClient.listStudies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Study from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStudiesPagedResponse listStudies(LocationName parent) {
    ListStudiesRequest request =
        ListStudiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStudies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the studies in a region for an associated project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Study element : vizierServiceClient.listStudies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Study from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStudiesPagedResponse listStudies(String parent) {
    ListStudiesRequest request = ListStudiesRequest.newBuilder().setParent(parent).build();
    return listStudies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the studies in a region for an associated project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListStudiesRequest request =
   *       ListStudiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Study element : vizierServiceClient.listStudies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStudiesPagedResponse listStudies(ListStudiesRequest request) {
    return listStudiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the studies in a region for an associated project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListStudiesRequest request =
   *       ListStudiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Study> future = vizierServiceClient.listStudiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Study element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStudiesRequest, ListStudiesPagedResponse>
      listStudiesPagedCallable() {
    return stub.listStudiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the studies in a region for an associated project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListStudiesRequest request =
   *       ListStudiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListStudiesResponse response = vizierServiceClient.listStudiesCallable().call(request);
   *     for (Study element : response.getStudiesList()) {
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
  public final UnaryCallable<ListStudiesRequest, ListStudiesResponse> listStudiesCallable() {
    return stub.listStudiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
   *   vizierServiceClient.deleteStudy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Study resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStudy(StudyName name) {
    DeleteStudyRequest request =
        DeleteStudyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString();
   *   vizierServiceClient.deleteStudy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Study resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStudy(String name) {
    DeleteStudyRequest request = DeleteStudyRequest.newBuilder().setName(name).build();
    deleteStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   DeleteStudyRequest request =
   *       DeleteStudyRequest.newBuilder()
   *           .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   vizierServiceClient.deleteStudy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStudy(DeleteStudyRequest request) {
    deleteStudyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   DeleteStudyRequest request =
   *       DeleteStudyRequest.newBuilder()
   *           .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = vizierServiceClient.deleteStudyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStudyRequest, Empty> deleteStudyCallable() {
    return stub.deleteStudyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks a study up using the user-defined display_name field instead of the fully qualified
   * resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Study response = vizierServiceClient.lookupStudy(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the Study from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study lookupStudy(LocationName parent) {
    LookupStudyRequest request =
        LookupStudyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return lookupStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks a study up using the user-defined display_name field instead of the fully qualified
   * resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Study response = vizierServiceClient.lookupStudy(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the Study from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study lookupStudy(String parent) {
    LookupStudyRequest request = LookupStudyRequest.newBuilder().setParent(parent).build();
    return lookupStudy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks a study up using the user-defined display_name field instead of the fully qualified
   * resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   LookupStudyRequest request =
   *       LookupStudyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .build();
   *   Study response = vizierServiceClient.lookupStudy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Study lookupStudy(LookupStudyRequest request) {
    return lookupStudyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks a study up using the user-defined display_name field instead of the fully qualified
   * resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   LookupStudyRequest request =
   *       LookupStudyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .build();
   *   ApiFuture<Study> future = vizierServiceClient.lookupStudyCallable().futureCall(request);
   *   // Do something.
   *   Study response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupStudyRequest, Study> lookupStudyCallable() {
    return stub.lookupStudyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more Trials to a Study, with parameter values suggested by Vertex AI Vizier.
   * Returns a long-running operation associated with the generation of Trial suggestions. When this
   * long-running operation succeeds, it will contain a
   * [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   SuggestTrialsRequest request =
   *       SuggestTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setSuggestionCount(390130452)
   *           .setClientId("clientId908408390")
   *           .build();
   *   SuggestTrialsResponse response = vizierServiceClient.suggestTrialsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SuggestTrialsResponse, SuggestTrialsMetadata> suggestTrialsAsync(
      SuggestTrialsRequest request) {
    return suggestTrialsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more Trials to a Study, with parameter values suggested by Vertex AI Vizier.
   * Returns a long-running operation associated with the generation of Trial suggestions. When this
   * long-running operation succeeds, it will contain a
   * [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   SuggestTrialsRequest request =
   *       SuggestTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setSuggestionCount(390130452)
   *           .setClientId("clientId908408390")
   *           .build();
   *   OperationFuture<SuggestTrialsResponse, SuggestTrialsMetadata> future =
   *       vizierServiceClient.suggestTrialsOperationCallable().futureCall(request);
   *   // Do something.
   *   SuggestTrialsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationCallable() {
    return stub.suggestTrialsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more Trials to a Study, with parameter values suggested by Vertex AI Vizier.
   * Returns a long-running operation associated with the generation of Trial suggestions. When this
   * long-running operation succeeds, it will contain a
   * [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   SuggestTrialsRequest request =
   *       SuggestTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setSuggestionCount(390130452)
   *           .setClientId("clientId908408390")
   *           .build();
   *   ApiFuture<Operation> future = vizierServiceClient.suggestTrialsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SuggestTrialsRequest, Operation> suggestTrialsCallable() {
    return stub.suggestTrialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a user provided Trial to a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
   *   Trial trial = Trial.newBuilder().build();
   *   Trial response = vizierServiceClient.createTrial(parent, trial);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Study to create the Trial in. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @param trial Required. The Trial to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial createTrial(StudyName parent, Trial trial) {
    CreateTrialRequest request =
        CreateTrialRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrial(trial)
            .build();
    return createTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a user provided Trial to a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString();
   *   Trial trial = Trial.newBuilder().build();
   *   Trial response = vizierServiceClient.createTrial(parent, trial);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Study to create the Trial in. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @param trial Required. The Trial to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial createTrial(String parent, Trial trial) {
    CreateTrialRequest request =
        CreateTrialRequest.newBuilder().setParent(parent).setTrial(trial).build();
    return createTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a user provided Trial to a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CreateTrialRequest request =
   *       CreateTrialRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setTrial(Trial.newBuilder().build())
   *           .build();
   *   Trial response = vizierServiceClient.createTrial(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial createTrial(CreateTrialRequest request) {
    return createTrialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a user provided Trial to a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CreateTrialRequest request =
   *       CreateTrialRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setTrial(Trial.newBuilder().build())
   *           .build();
   *   ApiFuture<Trial> future = vizierServiceClient.createTrialCallable().futureCall(request);
   *   // Do something.
   *   Trial response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTrialRequest, Trial> createTrialCallable() {
    return stub.createTrialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");
   *   Trial response = vizierServiceClient.getTrial(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Trial resource. Format:
   *     `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial getTrial(TrialName name) {
    GetTrialRequest request =
        GetTrialRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString();
   *   Trial response = vizierServiceClient.getTrial(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Trial resource. Format:
   *     `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial getTrial(String name) {
    GetTrialRequest request = GetTrialRequest.newBuilder().setName(name).build();
    return getTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetTrialRequest request =
   *       GetTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   Trial response = vizierServiceClient.getTrial(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial getTrial(GetTrialRequest request) {
    return getTrialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetTrialRequest request =
   *       GetTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   ApiFuture<Trial> future = vizierServiceClient.getTrialCallable().futureCall(request);
   *   // Do something.
   *   Trial response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTrialRequest, Trial> getTrialCallable() {
    return stub.getTrialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Trials associated with a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
   *   for (Trial element : vizierServiceClient.listTrials(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Study to list the Trial from. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrialsPagedResponse listTrials(StudyName parent) {
    ListTrialsRequest request =
        ListTrialsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTrials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Trials associated with a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString();
   *   for (Trial element : vizierServiceClient.listTrials(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Study to list the Trial from. Format:
   *     `projects/{project}/locations/{location}/studies/{study}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrialsPagedResponse listTrials(String parent) {
    ListTrialsRequest request = ListTrialsRequest.newBuilder().setParent(parent).build();
    return listTrials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Trials associated with a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListTrialsRequest request =
   *       ListTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Trial element : vizierServiceClient.listTrials(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrialsPagedResponse listTrials(ListTrialsRequest request) {
    return listTrialsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Trials associated with a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListTrialsRequest request =
   *       ListTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Trial> future = vizierServiceClient.listTrialsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Trial element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTrialsRequest, ListTrialsPagedResponse> listTrialsPagedCallable() {
    return stub.listTrialsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Trials associated with a Study.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListTrialsRequest request =
   *       ListTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListTrialsResponse response = vizierServiceClient.listTrialsCallable().call(request);
   *     for (Trial element : response.getTrialsList()) {
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
  public final UnaryCallable<ListTrialsRequest, ListTrialsResponse> listTrialsCallable() {
    return stub.listTrialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a measurement of the objective metrics to a Trial. This measurement is assumed to have
   * been taken before the Trial is complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   AddTrialMeasurementRequest request =
   *       AddTrialMeasurementRequest.newBuilder()
   *           .setTrialName(
   *               TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .setMeasurement(Measurement.newBuilder().build())
   *           .build();
   *   Trial response = vizierServiceClient.addTrialMeasurement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial addTrialMeasurement(AddTrialMeasurementRequest request) {
    return addTrialMeasurementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a measurement of the objective metrics to a Trial. This measurement is assumed to have
   * been taken before the Trial is complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   AddTrialMeasurementRequest request =
   *       AddTrialMeasurementRequest.newBuilder()
   *           .setTrialName(
   *               TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .setMeasurement(Measurement.newBuilder().build())
   *           .build();
   *   ApiFuture<Trial> future =
   *       vizierServiceClient.addTrialMeasurementCallable().futureCall(request);
   *   // Do something.
   *   Trial response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddTrialMeasurementRequest, Trial> addTrialMeasurementCallable() {
    return stub.addTrialMeasurementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a Trial as complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CompleteTrialRequest request =
   *       CompleteTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .setFinalMeasurement(Measurement.newBuilder().build())
   *           .setTrialInfeasible(true)
   *           .setInfeasibleReason("infeasibleReason1040725388")
   *           .build();
   *   Trial response = vizierServiceClient.completeTrial(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial completeTrial(CompleteTrialRequest request) {
    return completeTrialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a Trial as complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CompleteTrialRequest request =
   *       CompleteTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .setFinalMeasurement(Measurement.newBuilder().build())
   *           .setTrialInfeasible(true)
   *           .setInfeasibleReason("infeasibleReason1040725388")
   *           .build();
   *   ApiFuture<Trial> future = vizierServiceClient.completeTrialCallable().futureCall(request);
   *   // Do something.
   *   Trial response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CompleteTrialRequest, Trial> completeTrialCallable() {
    return stub.completeTrialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");
   *   vizierServiceClient.deleteTrial(name);
   * }
   * }</pre>
   *
   * @param name Required. The Trial's name. Format:
   *     `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTrial(TrialName name) {
    DeleteTrialRequest request =
        DeleteTrialRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString();
   *   vizierServiceClient.deleteTrial(name);
   * }
   * }</pre>
   *
   * @param name Required. The Trial's name. Format:
   *     `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTrial(String name) {
    DeleteTrialRequest request = DeleteTrialRequest.newBuilder().setName(name).build();
    deleteTrial(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   DeleteTrialRequest request =
   *       DeleteTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   vizierServiceClient.deleteTrial(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTrial(DeleteTrialRequest request) {
    deleteTrialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   DeleteTrialRequest request =
   *       DeleteTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = vizierServiceClient.deleteTrialCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTrialRequest, Empty> deleteTrialCallable() {
    return stub.deleteTrialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a Trial should stop or not. Returns a long-running operation. When the operation
   * is successful, it will contain a
   * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CheckTrialEarlyStoppingStateRequest request =
   *       CheckTrialEarlyStoppingStateRequest.newBuilder()
   *           .setTrialName(
   *               TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   CheckTrialEarlyStoppingStateResponse response =
   *       vizierServiceClient.checkTrialEarlyStoppingStateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          CheckTrialEarlyStoppingStateResponse, CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateAsync(CheckTrialEarlyStoppingStateRequest request) {
    return checkTrialEarlyStoppingStateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a Trial should stop or not. Returns a long-running operation. When the operation
   * is successful, it will contain a
   * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CheckTrialEarlyStoppingStateRequest request =
   *       CheckTrialEarlyStoppingStateRequest.newBuilder()
   *           .setTrialName(
   *               TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   OperationFuture<CheckTrialEarlyStoppingStateResponse, CheckTrialEarlyStoppingStateMetatdata>
   *       future =
   *           vizierServiceClient
   *               .checkTrialEarlyStoppingStateOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   CheckTrialEarlyStoppingStateResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationCallable() {
    return stub.checkTrialEarlyStoppingStateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a Trial should stop or not. Returns a long-running operation. When the operation
   * is successful, it will contain a
   * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   CheckTrialEarlyStoppingStateRequest request =
   *       CheckTrialEarlyStoppingStateRequest.newBuilder()
   *           .setTrialName(
   *               TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vizierServiceClient.checkTrialEarlyStoppingStateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateCallable() {
    return stub.checkTrialEarlyStoppingStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StopTrialRequest request =
   *       StopTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   Trial response = vizierServiceClient.stopTrial(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trial stopTrial(StopTrialRequest request) {
    return stopTrialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a Trial.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StopTrialRequest request =
   *       StopTrialRequest.newBuilder()
   *           .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
   *           .build();
   *   ApiFuture<Trial> future = vizierServiceClient.stopTrialCallable().futureCall(request);
   *   // Do something.
   *   Trial response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopTrialRequest, Trial> stopTrialCallable() {
    return stub.stopTrialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for
   * single-objective Study. The definition of pareto-optimal can be checked in wiki page.
   * https://en.wikipedia.org/wiki/Pareto_efficiency
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
   *   ListOptimalTrialsResponse response = vizierServiceClient.listOptimalTrials(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Study that the optimal Trial belongs to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOptimalTrialsResponse listOptimalTrials(StudyName parent) {
    ListOptimalTrialsRequest request =
        ListOptimalTrialsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOptimalTrials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for
   * single-objective Study. The definition of pareto-optimal can be checked in wiki page.
   * https://en.wikipedia.org/wiki/Pareto_efficiency
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   String parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString();
   *   ListOptimalTrialsResponse response = vizierServiceClient.listOptimalTrials(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Study that the optimal Trial belongs to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOptimalTrialsResponse listOptimalTrials(String parent) {
    ListOptimalTrialsRequest request =
        ListOptimalTrialsRequest.newBuilder().setParent(parent).build();
    return listOptimalTrials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for
   * single-objective Study. The definition of pareto-optimal can be checked in wiki page.
   * https://en.wikipedia.org/wiki/Pareto_efficiency
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListOptimalTrialsRequest request =
   *       ListOptimalTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   ListOptimalTrialsResponse response = vizierServiceClient.listOptimalTrials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOptimalTrialsResponse listOptimalTrials(ListOptimalTrialsRequest request) {
    return listOptimalTrialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for
   * single-objective Study. The definition of pareto-optimal can be checked in wiki page.
   * https://en.wikipedia.org/wiki/Pareto_efficiency
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListOptimalTrialsRequest request =
   *       ListOptimalTrialsRequest.newBuilder()
   *           .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
   *           .build();
   *   ApiFuture<ListOptimalTrialsResponse> future =
   *       vizierServiceClient.listOptimalTrialsCallable().futureCall(request);
   *   // Do something.
   *   ListOptimalTrialsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsCallable() {
    return stub.listOptimalTrialsCallable();
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vizierServiceClient.listLocations(request).iterateAll()) {
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vizierServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = vizierServiceClient.listLocationsCallable().call(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vizierServiceClient.getLocation(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = vizierServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vizierServiceClient.setIamPolicy(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vizierServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vizierServiceClient.getIamPolicy(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vizierServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vizierServiceClient.testIamPermissions(request);
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
   * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vizierServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListStudiesPagedResponse
      extends AbstractPagedListResponse<
          ListStudiesRequest,
          ListStudiesResponse,
          Study,
          ListStudiesPage,
          ListStudiesFixedSizeCollection> {

    public static ApiFuture<ListStudiesPagedResponse> createAsync(
        PageContext<ListStudiesRequest, ListStudiesResponse, Study> context,
        ApiFuture<ListStudiesResponse> futureResponse) {
      ApiFuture<ListStudiesPage> futurePage =
          ListStudiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListStudiesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListStudiesPagedResponse(ListStudiesPage page) {
      super(page, ListStudiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStudiesPage
      extends AbstractPage<ListStudiesRequest, ListStudiesResponse, Study, ListStudiesPage> {

    private ListStudiesPage(
        PageContext<ListStudiesRequest, ListStudiesResponse, Study> context,
        ListStudiesResponse response) {
      super(context, response);
    }

    private static ListStudiesPage createEmptyPage() {
      return new ListStudiesPage(null, null);
    }

    @Override
    protected ListStudiesPage createPage(
        PageContext<ListStudiesRequest, ListStudiesResponse, Study> context,
        ListStudiesResponse response) {
      return new ListStudiesPage(context, response);
    }

    @Override
    public ApiFuture<ListStudiesPage> createPageAsync(
        PageContext<ListStudiesRequest, ListStudiesResponse, Study> context,
        ApiFuture<ListStudiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStudiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStudiesRequest,
          ListStudiesResponse,
          Study,
          ListStudiesPage,
          ListStudiesFixedSizeCollection> {

    private ListStudiesFixedSizeCollection(List<ListStudiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStudiesFixedSizeCollection createEmptyCollection() {
      return new ListStudiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStudiesFixedSizeCollection createCollection(
        List<ListStudiesPage> pages, int collectionSize) {
      return new ListStudiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTrialsPagedResponse
      extends AbstractPagedListResponse<
          ListTrialsRequest,
          ListTrialsResponse,
          Trial,
          ListTrialsPage,
          ListTrialsFixedSizeCollection> {

    public static ApiFuture<ListTrialsPagedResponse> createAsync(
        PageContext<ListTrialsRequest, ListTrialsResponse, Trial> context,
        ApiFuture<ListTrialsResponse> futureResponse) {
      ApiFuture<ListTrialsPage> futurePage =
          ListTrialsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTrialsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTrialsPagedResponse(ListTrialsPage page) {
      super(page, ListTrialsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTrialsPage
      extends AbstractPage<ListTrialsRequest, ListTrialsResponse, Trial, ListTrialsPage> {

    private ListTrialsPage(
        PageContext<ListTrialsRequest, ListTrialsResponse, Trial> context,
        ListTrialsResponse response) {
      super(context, response);
    }

    private static ListTrialsPage createEmptyPage() {
      return new ListTrialsPage(null, null);
    }

    @Override
    protected ListTrialsPage createPage(
        PageContext<ListTrialsRequest, ListTrialsResponse, Trial> context,
        ListTrialsResponse response) {
      return new ListTrialsPage(context, response);
    }

    @Override
    public ApiFuture<ListTrialsPage> createPageAsync(
        PageContext<ListTrialsRequest, ListTrialsResponse, Trial> context,
        ApiFuture<ListTrialsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTrialsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTrialsRequest,
          ListTrialsResponse,
          Trial,
          ListTrialsPage,
          ListTrialsFixedSizeCollection> {

    private ListTrialsFixedSizeCollection(List<ListTrialsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTrialsFixedSizeCollection createEmptyCollection() {
      return new ListTrialsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTrialsFixedSizeCollection createCollection(
        List<ListTrialsPage> pages, int collectionSize) {
      return new ListTrialsFixedSizeCollection(pages, collectionSize);
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
