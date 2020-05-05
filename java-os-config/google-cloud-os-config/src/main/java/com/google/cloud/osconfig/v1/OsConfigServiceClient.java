/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.osconfig.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJobInstanceDetails;
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStub;
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: OS Config API
 *
 * <p>The OS Config service is a server-side component that you can use to manage package
 * installations and patch jobs for virtual machine instances.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
 *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
 *   PatchJob response = osConfigServiceClient.getPatchJob(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the osConfigServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of OsConfigServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class OsConfigServiceClient implements BackgroundResource {
  private final OsConfigServiceSettings settings;
  private final OsConfigServiceStub stub;

  /** Constructs an instance of OsConfigServiceClient with default settings. */
  public static final OsConfigServiceClient create() throws IOException {
    return create(OsConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OsConfigServiceClient create(OsConfigServiceSettings settings)
      throws IOException {
    return new OsConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use OsConfigServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final OsConfigServiceClient create(OsConfigServiceStub stub) {
    return new OsConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of OsConfigServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OsConfigServiceClient(OsConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OsConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected OsConfigServiceClient(OsConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OsConfigServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   PatchInstanceFilter instanceFilter = PatchInstanceFilter.newBuilder().build();
   *   ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceFilter(instanceFilter)
   *     .build();
   *   PatchJob response = osConfigServiceClient.executePatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob executePatchJob(ExecutePatchJobRequest request) {
    return executePatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   PatchInstanceFilter instanceFilter = PatchInstanceFilter.newBuilder().build();
   *   ExecutePatchJobRequest request = ExecutePatchJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceFilter(instanceFilter)
   *     .build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.executePatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExecutePatchJobRequest, PatchJob> executePatchJobCallable() {
    return stub.executePatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   PatchJob response = osConfigServiceClient.getPatchJob(name);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the patch in the form `projects/&#42;/patchJobs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob getPatchJob(PatchJobName name) {
    GetPatchJobRequest request =
        GetPatchJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPatchJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   PatchJob response = osConfigServiceClient.getPatchJob(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the patch in the form `projects/&#42;/patchJobs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob getPatchJob(String name) {
    GetPatchJobRequest request = GetPatchJobRequest.newBuilder().setName(name).build();
    return getPatchJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   GetPatchJobRequest request = GetPatchJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   PatchJob response = osConfigServiceClient.getPatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob getPatchJob(GetPatchJobRequest request) {
    return getPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   GetPatchJobRequest request = GetPatchJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.getPatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPatchJobRequest, PatchJob> getPatchJobCallable() {
    return stub.getPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   PatchJob response = osConfigServiceClient.cancelPatchJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJob cancelPatchJob(CancelPatchJobRequest request) {
    return cancelPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   CancelPatchJobRequest request = CancelPatchJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;PatchJob&gt; future = osConfigServiceClient.cancelPatchJobCallable().futureCall(request);
   *   // Do something
   *   PatchJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelPatchJobRequest, PatchJob> cancelPatchJobCallable() {
    return stub.cancelPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchJob element : osConfigServiceClient.listPatchJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. In the form of `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(ProjectName parent) {
    ListPatchJobsRequest request =
        ListPatchJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchJob element : osConfigServiceClient.listPatchJobs(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. In the form of `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(String parent) {
    ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder().setParent(parent).build();
    return listPatchJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (PatchJob element : osConfigServiceClient.listPatchJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(ListPatchJobsRequest request) {
    return listPatchJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListPatchJobsPagedResponse&gt; future = osConfigServiceClient.listPatchJobsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PatchJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPatchJobsRequest, ListPatchJobsPagedResponse>
      listPatchJobsPagedCallable() {
    return stub.listPatchJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchJobsRequest request = ListPatchJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListPatchJobsResponse response = osConfigServiceClient.listPatchJobsCallable().call(request);
   *     for (PatchJob element : response.getPatchJobsList()) {
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
  public final UnaryCallable<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsCallable() {
    return stub.listPatchJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   for (PatchJobInstanceDetails element : osConfigServiceClient.listPatchJobInstanceDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent for the instances are in the form of
   *     `projects/&#42;/patchJobs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(
      PatchJobName parent) {
    ListPatchJobInstanceDetailsRequest request =
        ListPatchJobInstanceDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchJobInstanceDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   for (PatchJobInstanceDetails element : osConfigServiceClient.listPatchJobInstanceDetails(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent for the instances are in the form of
   *     `projects/&#42;/patchJobs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(String parent) {
    ListPatchJobInstanceDetailsRequest request =
        ListPatchJobInstanceDetailsRequest.newBuilder().setParent(parent).build();
    return listPatchJobInstanceDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   ListPatchJobInstanceDetailsRequest request = ListPatchJobInstanceDetailsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (PatchJobInstanceDetails element : osConfigServiceClient.listPatchJobInstanceDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(
      ListPatchJobInstanceDetailsRequest request) {
    return listPatchJobInstanceDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   ListPatchJobInstanceDetailsRequest request = ListPatchJobInstanceDetailsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListPatchJobInstanceDetailsPagedResponse&gt; future = osConfigServiceClient.listPatchJobInstanceDetailsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PatchJobInstanceDetails element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsPagedCallable() {
    return stub.listPatchJobInstanceDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   ListPatchJobInstanceDetailsRequest request = ListPatchJobInstanceDetailsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListPatchJobInstanceDetailsResponse response = osConfigServiceClient.listPatchJobInstanceDetailsCallable().call(request);
   *     for (PatchJobInstanceDetails element : response.getPatchJobInstanceDetailsList()) {
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
  public final UnaryCallable<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    return stub.listPatchJobInstanceDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
   *   String patchDeploymentId = "";
   *   PatchDeployment response = osConfigServiceClient.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
   * }
   * </code></pre>
   *
   * @param parent Required. The project to apply this patch deployment to in the form
   *     `projects/&#42;`.
   * @param patchDeployment Required. The patch deployment to create.
   * @param patchDeploymentId Required. A name for the patch deployment in the project. When
   *     creating a name the following rules apply: &#42; Must contain only lowercase letters,
   *     numbers, and hyphens. &#42; Must start with a letter. &#42; Must be between 1-63
   *     characters. &#42; Must end with a number or a letter. &#42; Must be unique within the
   *     project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment createPatchDeployment(
      ProjectName parent, PatchDeployment patchDeployment, String patchDeploymentId) {
    CreatePatchDeploymentRequest request =
        CreatePatchDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPatchDeployment(patchDeployment)
            .setPatchDeploymentId(patchDeploymentId)
            .build();
    return createPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
   *   String patchDeploymentId = "";
   *   PatchDeployment response = osConfigServiceClient.createPatchDeployment(parent.toString(), patchDeployment, patchDeploymentId);
   * }
   * </code></pre>
   *
   * @param parent Required. The project to apply this patch deployment to in the form
   *     `projects/&#42;`.
   * @param patchDeployment Required. The patch deployment to create.
   * @param patchDeploymentId Required. A name for the patch deployment in the project. When
   *     creating a name the following rules apply: &#42; Must contain only lowercase letters,
   *     numbers, and hyphens. &#42; Must start with a letter. &#42; Must be between 1-63
   *     characters. &#42; Must end with a number or a letter. &#42; Must be unique within the
   *     project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment createPatchDeployment(
      String parent, PatchDeployment patchDeployment, String patchDeploymentId) {
    CreatePatchDeploymentRequest request =
        CreatePatchDeploymentRequest.newBuilder()
            .setParent(parent)
            .setPatchDeployment(patchDeployment)
            .setPatchDeploymentId(patchDeploymentId)
            .build();
    return createPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String patchDeploymentId = "";
   *   PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
   *   CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setPatchDeploymentId(patchDeploymentId)
   *     .setPatchDeployment(patchDeployment)
   *     .build();
   *   PatchDeployment response = osConfigServiceClient.createPatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment createPatchDeployment(CreatePatchDeploymentRequest request) {
    return createPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String patchDeploymentId = "";
   *   PatchDeployment patchDeployment = PatchDeployment.newBuilder().build();
   *   CreatePatchDeploymentRequest request = CreatePatchDeploymentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setPatchDeploymentId(patchDeploymentId)
   *     .setPatchDeployment(patchDeployment)
   *     .build();
   *   ApiFuture&lt;PatchDeployment&gt; future = osConfigServiceClient.createPatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   PatchDeployment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentCallable() {
    return stub.createPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   PatchDeployment response = osConfigServiceClient.getPatchDeployment(name);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment getPatchDeployment(PatchDeploymentName name) {
    GetPatchDeploymentRequest request =
        GetPatchDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   PatchDeployment response = osConfigServiceClient.getPatchDeployment(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment getPatchDeployment(String name) {
    GetPatchDeploymentRequest request =
        GetPatchDeploymentRequest.newBuilder().setName(name).build();
    return getPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   PatchDeployment response = osConfigServiceClient.getPatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployment getPatchDeployment(GetPatchDeploymentRequest request) {
    return getPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   GetPatchDeploymentRequest request = GetPatchDeploymentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;PatchDeployment&gt; future = osConfigServiceClient.getPatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   PatchDeployment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentCallable() {
    return stub.getPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchDeployment element : osConfigServiceClient.listPatchDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the parent in the form `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(ProjectName parent) {
    ListPatchDeploymentsRequest request =
        ListPatchDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchDeployment element : osConfigServiceClient.listPatchDeployments(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the parent in the form `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(String parent) {
    ListPatchDeploymentsRequest request =
        ListPatchDeploymentsRequest.newBuilder().setParent(parent).build();
    return listPatchDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (PatchDeployment element : osConfigServiceClient.listPatchDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(
      ListPatchDeploymentsRequest request) {
    return listPatchDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListPatchDeploymentsPagedResponse&gt; future = osConfigServiceClient.listPatchDeploymentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PatchDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsPagedCallable() {
    return stub.listPatchDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListPatchDeploymentsRequest request = ListPatchDeploymentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListPatchDeploymentsResponse response = osConfigServiceClient.listPatchDeploymentsCallable().call(request);
   *     for (PatchDeployment element : response.getPatchDeploymentsList()) {
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
  public final UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    return stub.listPatchDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   osConfigServiceClient.deletePatchDeployment(name);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(PatchDeploymentName name) {
    DeletePatchDeploymentRequest request =
        DeletePatchDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   osConfigServiceClient.deletePatchDeployment(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(String name) {
    DeletePatchDeploymentRequest request =
        DeletePatchDeploymentRequest.newBuilder().setName(name).build();
    deletePatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   osConfigServiceClient.deletePatchDeployment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(DeletePatchDeploymentRequest request) {
    deletePatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   DeletePatchDeploymentRequest request = DeletePatchDeploymentRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = osConfigServiceClient.deletePatchDeploymentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentCallable() {
    return stub.deletePatchDeploymentCallable();
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

  public static class ListPatchJobsPagedResponse
      extends AbstractPagedListResponse<
          ListPatchJobsRequest,
          ListPatchJobsResponse,
          PatchJob,
          ListPatchJobsPage,
          ListPatchJobsFixedSizeCollection> {

    public static ApiFuture<ListPatchJobsPagedResponse> createAsync(
        PageContext<ListPatchJobsRequest, ListPatchJobsResponse, PatchJob> context,
        ApiFuture<ListPatchJobsResponse> futureResponse) {
      ApiFuture<ListPatchJobsPage> futurePage =
          ListPatchJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPatchJobsPage, ListPatchJobsPagedResponse>() {
            @Override
            public ListPatchJobsPagedResponse apply(ListPatchJobsPage input) {
              return new ListPatchJobsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPatchJobsPagedResponse(ListPatchJobsPage page) {
      super(page, ListPatchJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPatchJobsPage
      extends AbstractPage<
          ListPatchJobsRequest, ListPatchJobsResponse, PatchJob, ListPatchJobsPage> {

    private ListPatchJobsPage(
        PageContext<ListPatchJobsRequest, ListPatchJobsResponse, PatchJob> context,
        ListPatchJobsResponse response) {
      super(context, response);
    }

    private static ListPatchJobsPage createEmptyPage() {
      return new ListPatchJobsPage(null, null);
    }

    @Override
    protected ListPatchJobsPage createPage(
        PageContext<ListPatchJobsRequest, ListPatchJobsResponse, PatchJob> context,
        ListPatchJobsResponse response) {
      return new ListPatchJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchJobsPage> createPageAsync(
        PageContext<ListPatchJobsRequest, ListPatchJobsResponse, PatchJob> context,
        ApiFuture<ListPatchJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPatchJobsRequest,
          ListPatchJobsResponse,
          PatchJob,
          ListPatchJobsPage,
          ListPatchJobsFixedSizeCollection> {

    private ListPatchJobsFixedSizeCollection(List<ListPatchJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPatchJobsFixedSizeCollection createEmptyCollection() {
      return new ListPatchJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPatchJobsFixedSizeCollection createCollection(
        List<ListPatchJobsPage> pages, int collectionSize) {
      return new ListPatchJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPatchJobInstanceDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListPatchJobInstanceDetailsRequest,
          ListPatchJobInstanceDetailsResponse,
          PatchJobInstanceDetails,
          ListPatchJobInstanceDetailsPage,
          ListPatchJobInstanceDetailsFixedSizeCollection> {

    public static ApiFuture<ListPatchJobInstanceDetailsPagedResponse> createAsync(
        PageContext<
                ListPatchJobInstanceDetailsRequest,
                ListPatchJobInstanceDetailsResponse,
                PatchJobInstanceDetails>
            context,
        ApiFuture<ListPatchJobInstanceDetailsResponse> futureResponse) {
      ApiFuture<ListPatchJobInstanceDetailsPage> futurePage =
          ListPatchJobInstanceDetailsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListPatchJobInstanceDetailsPage, ListPatchJobInstanceDetailsPagedResponse>() {
            @Override
            public ListPatchJobInstanceDetailsPagedResponse apply(
                ListPatchJobInstanceDetailsPage input) {
              return new ListPatchJobInstanceDetailsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPatchJobInstanceDetailsPagedResponse(ListPatchJobInstanceDetailsPage page) {
      super(page, ListPatchJobInstanceDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPatchJobInstanceDetailsPage
      extends AbstractPage<
          ListPatchJobInstanceDetailsRequest,
          ListPatchJobInstanceDetailsResponse,
          PatchJobInstanceDetails,
          ListPatchJobInstanceDetailsPage> {

    private ListPatchJobInstanceDetailsPage(
        PageContext<
                ListPatchJobInstanceDetailsRequest,
                ListPatchJobInstanceDetailsResponse,
                PatchJobInstanceDetails>
            context,
        ListPatchJobInstanceDetailsResponse response) {
      super(context, response);
    }

    private static ListPatchJobInstanceDetailsPage createEmptyPage() {
      return new ListPatchJobInstanceDetailsPage(null, null);
    }

    @Override
    protected ListPatchJobInstanceDetailsPage createPage(
        PageContext<
                ListPatchJobInstanceDetailsRequest,
                ListPatchJobInstanceDetailsResponse,
                PatchJobInstanceDetails>
            context,
        ListPatchJobInstanceDetailsResponse response) {
      return new ListPatchJobInstanceDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchJobInstanceDetailsPage> createPageAsync(
        PageContext<
                ListPatchJobInstanceDetailsRequest,
                ListPatchJobInstanceDetailsResponse,
                PatchJobInstanceDetails>
            context,
        ApiFuture<ListPatchJobInstanceDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchJobInstanceDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPatchJobInstanceDetailsRequest,
          ListPatchJobInstanceDetailsResponse,
          PatchJobInstanceDetails,
          ListPatchJobInstanceDetailsPage,
          ListPatchJobInstanceDetailsFixedSizeCollection> {

    private ListPatchJobInstanceDetailsFixedSizeCollection(
        List<ListPatchJobInstanceDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPatchJobInstanceDetailsFixedSizeCollection createEmptyCollection() {
      return new ListPatchJobInstanceDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPatchJobInstanceDetailsFixedSizeCollection createCollection(
        List<ListPatchJobInstanceDetailsPage> pages, int collectionSize) {
      return new ListPatchJobInstanceDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPatchDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListPatchDeploymentsRequest,
          ListPatchDeploymentsResponse,
          PatchDeployment,
          ListPatchDeploymentsPage,
          ListPatchDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListPatchDeploymentsPagedResponse> createAsync(
        PageContext<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse, PatchDeployment>
            context,
        ApiFuture<ListPatchDeploymentsResponse> futureResponse) {
      ApiFuture<ListPatchDeploymentsPage> futurePage =
          ListPatchDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPatchDeploymentsPage, ListPatchDeploymentsPagedResponse>() {
            @Override
            public ListPatchDeploymentsPagedResponse apply(ListPatchDeploymentsPage input) {
              return new ListPatchDeploymentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPatchDeploymentsPagedResponse(ListPatchDeploymentsPage page) {
      super(page, ListPatchDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPatchDeploymentsPage
      extends AbstractPage<
          ListPatchDeploymentsRequest,
          ListPatchDeploymentsResponse,
          PatchDeployment,
          ListPatchDeploymentsPage> {

    private ListPatchDeploymentsPage(
        PageContext<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse, PatchDeployment>
            context,
        ListPatchDeploymentsResponse response) {
      super(context, response);
    }

    private static ListPatchDeploymentsPage createEmptyPage() {
      return new ListPatchDeploymentsPage(null, null);
    }

    @Override
    protected ListPatchDeploymentsPage createPage(
        PageContext<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse, PatchDeployment>
            context,
        ListPatchDeploymentsResponse response) {
      return new ListPatchDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchDeploymentsPage> createPageAsync(
        PageContext<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse, PatchDeployment>
            context,
        ApiFuture<ListPatchDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPatchDeploymentsRequest,
          ListPatchDeploymentsResponse,
          PatchDeployment,
          ListPatchDeploymentsPage,
          ListPatchDeploymentsFixedSizeCollection> {

    private ListPatchDeploymentsFixedSizeCollection(
        List<ListPatchDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPatchDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListPatchDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPatchDeploymentsFixedSizeCollection createCollection(
        List<ListPatchDeploymentsPage> pages, int collectionSize) {
      return new ListPatchDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
