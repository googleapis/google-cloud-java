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
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStub;
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: OS Config API
 *
 * <p>The OS Config service is a server-side component that you can use to manage package
 * installations and patch jobs for virtual machine instances.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
 *   PatchJobs.ExecutePatchJobRequest request =
 *       PatchJobs.ExecutePatchJobRequest.newBuilder()
 *           .setParent(ProjectName.of("[PROJECT]").toString())
 *           .setDescription("description-1724546052")
 *           .setDuration(Duration.newBuilder().build())
 *           .setDryRun(true)
 *           .setDisplayName("displayName1714148973")
 *           .build();
 *   PatchJobs.PatchJob response = osConfigServiceClient.executePatchJob(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OsConfigServiceClient object to clean up resources
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
 * <pre>{@code
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * OsConfigServiceSettings osConfigServiceSettings =
 *     OsConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsConfigServiceClient osConfigServiceClient =
 *     OsConfigServiceClient.create(osConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * for advanced usage - prefer using create(OsConfigServiceSettings).
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ExecutePatchJobRequest request =
   *       PatchJobs.ExecutePatchJobRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDescription("description-1724546052")
   *           .setDuration(Duration.newBuilder().build())
   *           .setDryRun(true)
   *           .setDisplayName("displayName1714148973")
   *           .build();
   *   PatchJobs.PatchJob response = osConfigServiceClient.executePatchJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJobs.PatchJob executePatchJob(PatchJobs.ExecutePatchJobRequest request) {
    return executePatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patch VM instances by creating and running a patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ExecutePatchJobRequest request =
   *       PatchJobs.ExecutePatchJobRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDescription("description-1724546052")
   *           .setDuration(Duration.newBuilder().build())
   *           .setDryRun(true)
   *           .setDisplayName("displayName1714148973")
   *           .build();
   *   ApiFuture<PatchJobs.PatchJob> future =
   *       osConfigServiceClient.executePatchJobCallable().futureCall(request);
   *   // Do something.
   *   PatchJobs.PatchJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobCallable() {
    return stub.executePatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   PatchJobs.PatchJob response = osConfigServiceClient.getPatchJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the patch in the form `projects/&#42;/patchJobs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJobs.PatchJob getPatchJob(PatchJobName name) {
    PatchJobs.GetPatchJobRequest request =
        PatchJobs.GetPatchJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPatchJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String name = PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString();
   *   PatchJobs.PatchJob response = osConfigServiceClient.getPatchJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the patch in the form `projects/&#42;/patchJobs/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJobs.PatchJob getPatchJob(String name) {
    PatchJobs.GetPatchJobRequest request =
        PatchJobs.GetPatchJobRequest.newBuilder().setName(name).build();
    return getPatchJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.GetPatchJobRequest request =
   *       PatchJobs.GetPatchJobRequest.newBuilder()
   *           .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .build();
   *   PatchJobs.PatchJob response = osConfigServiceClient.getPatchJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJobs.PatchJob getPatchJob(PatchJobs.GetPatchJobRequest request) {
    return getPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the patch job. This can be used to track the progress of an ongoing patch job or review the
   * details of completed jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.GetPatchJobRequest request =
   *       PatchJobs.GetPatchJobRequest.newBuilder()
   *           .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .build();
   *   ApiFuture<PatchJobs.PatchJob> future =
   *       osConfigServiceClient.getPatchJobCallable().futureCall(request);
   *   // Do something.
   *   PatchJobs.PatchJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
      getPatchJobCallable() {
    return stub.getPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.CancelPatchJobRequest request =
   *       PatchJobs.CancelPatchJobRequest.newBuilder()
   *           .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .build();
   *   PatchJobs.PatchJob response = osConfigServiceClient.cancelPatchJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchJobs.PatchJob cancelPatchJob(PatchJobs.CancelPatchJobRequest request) {
    return cancelPatchJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.CancelPatchJobRequest request =
   *       PatchJobs.CancelPatchJobRequest.newBuilder()
   *           .setName(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .build();
   *   ApiFuture<PatchJobs.PatchJob> future =
   *       osConfigServiceClient.cancelPatchJobCallable().futureCall(request);
   *   // Do something.
   *   PatchJobs.PatchJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobCallable() {
    return stub.cancelPatchJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchJobs.PatchJob element : osConfigServiceClient.listPatchJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. In the form of `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(ProjectName parent) {
    PatchJobs.ListPatchJobsRequest request =
        PatchJobs.ListPatchJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (PatchJobs.PatchJob element : osConfigServiceClient.listPatchJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. In the form of `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(String parent) {
    PatchJobs.ListPatchJobsRequest request =
        PatchJobs.ListPatchJobsRequest.newBuilder().setParent(parent).build();
    return listPatchJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ListPatchJobsRequest request =
   *       PatchJobs.ListPatchJobsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PatchJobs.PatchJob element : osConfigServiceClient.listPatchJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobsPagedResponse listPatchJobs(PatchJobs.ListPatchJobsRequest request) {
    return listPatchJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ListPatchJobsRequest request =
   *       PatchJobs.ListPatchJobsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PatchJobs.PatchJob> future =
   *       osConfigServiceClient.listPatchJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PatchJobs.PatchJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchJobs.ListPatchJobsRequest, ListPatchJobsPagedResponse>
      listPatchJobsPagedCallable() {
    return stub.listPatchJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of patch jobs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   while (true) {
   *     PatchJobs.ListPatchJobsResponse response =
   *         osConfigServiceClient.listPatchJobsCallable().call(request);
   *     for (PatchJobs.PatchJob element : response.getResponsesList()) {
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
  public final UnaryCallable<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsCallable() {
    return stub.listPatchJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobName parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]");
   *   for (PatchJobs.PatchJobInstanceDetails element :
   *       osConfigServiceClient.listPatchJobInstanceDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent for the instances are in the form of
   *     `projects/&#42;/patchJobs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(
      PatchJobName parent) {
    PatchJobs.ListPatchJobInstanceDetailsRequest request =
        PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchJobInstanceDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String parent = PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString();
   *   for (PatchJobs.PatchJobInstanceDetails element :
   *       osConfigServiceClient.listPatchJobInstanceDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent for the instances are in the form of
   *     `projects/&#42;/patchJobs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(String parent) {
    PatchJobs.ListPatchJobInstanceDetailsRequest request =
        PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder().setParent(parent).build();
    return listPatchJobInstanceDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ListPatchJobInstanceDetailsRequest request =
   *       PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder()
   *           .setParent(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PatchJobs.PatchJobInstanceDetails element :
   *       osConfigServiceClient.listPatchJobInstanceDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchJobInstanceDetailsPagedResponse listPatchJobInstanceDetails(
      PatchJobs.ListPatchJobInstanceDetailsRequest request) {
    return listPatchJobInstanceDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchJobs.ListPatchJobInstanceDetailsRequest request =
   *       PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder()
   *           .setParent(PatchJobName.of("[PROJECT]", "[PATCH_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PatchJobs.PatchJobInstanceDetails> future =
   *       osConfigServiceClient.listPatchJobInstanceDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PatchJobs.PatchJobInstanceDetails element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsPagedCallable() {
    return stub.listPatchJobInstanceDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a list of instance details for a given patch job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   while (true) {
   *     PatchJobs.ListPatchJobInstanceDetailsResponse response =
   *         osConfigServiceClient.listPatchJobInstanceDetailsCallable().call(request);
   *     for (PatchJobs.PatchJobInstanceDetails element : response.getResponsesList()) {
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
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    return stub.listPatchJobInstanceDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   PatchDeployments.PatchDeployment patchDeployment =
   *       PatchDeployments.PatchDeployment.newBuilder().build();
   *   String patchDeploymentId = "patchDeploymentId-1180405976";
   *   PatchDeployments.PatchDeployment response =
   *       osConfigServiceClient.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The project to apply this patch deployment to in the form
   *     `projects/&#42;`.
   * @param patchDeployment Required. The patch deployment to create.
   * @param patchDeploymentId Required. A name for the patch deployment in the project. When
   *     creating a name the following rules apply:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment createPatchDeployment(
      ProjectName parent,
      PatchDeployments.PatchDeployment patchDeployment,
      String patchDeploymentId) {
    PatchDeployments.CreatePatchDeploymentRequest request =
        PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPatchDeployment(patchDeployment)
            .setPatchDeploymentId(patchDeploymentId)
            .build();
    return createPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   PatchDeployments.PatchDeployment patchDeployment =
   *       PatchDeployments.PatchDeployment.newBuilder().build();
   *   String patchDeploymentId = "patchDeploymentId-1180405976";
   *   PatchDeployments.PatchDeployment response =
   *       osConfigServiceClient.createPatchDeployment(parent, patchDeployment, patchDeploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The project to apply this patch deployment to in the form
   *     `projects/&#42;`.
   * @param patchDeployment Required. The patch deployment to create.
   * @param patchDeploymentId Required. A name for the patch deployment in the project. When
   *     creating a name the following rules apply:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment createPatchDeployment(
      String parent, PatchDeployments.PatchDeployment patchDeployment, String patchDeploymentId) {
    PatchDeployments.CreatePatchDeploymentRequest request =
        PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
            .setParent(parent)
            .setPatchDeployment(patchDeployment)
            .setPatchDeploymentId(patchDeploymentId)
            .build();
    return createPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.CreatePatchDeploymentRequest request =
   *       PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPatchDeploymentId("patchDeploymentId-1180405976")
   *           .build();
   *   PatchDeployments.PatchDeployment response =
   *       osConfigServiceClient.createPatchDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment createPatchDeployment(
      PatchDeployments.CreatePatchDeploymentRequest request) {
    return createPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.CreatePatchDeploymentRequest request =
   *       PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPatchDeploymentId("patchDeploymentId-1180405976")
   *           .build();
   *   ApiFuture<PatchDeployments.PatchDeployment> future =
   *       osConfigServiceClient.createPatchDeploymentCallable().futureCall(request);
   *   // Do something.
   *   PatchDeployments.PatchDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentCallable() {
    return stub.createPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   PatchDeployments.PatchDeployment response = osConfigServiceClient.getPatchDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment getPatchDeployment(PatchDeploymentName name) {
    PatchDeployments.GetPatchDeploymentRequest request =
        PatchDeployments.GetPatchDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString();
   *   PatchDeployments.PatchDeployment response = osConfigServiceClient.getPatchDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment getPatchDeployment(String name) {
    PatchDeployments.GetPatchDeploymentRequest request =
        PatchDeployments.GetPatchDeploymentRequest.newBuilder().setName(name).build();
    return getPatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.GetPatchDeploymentRequest request =
   *       PatchDeployments.GetPatchDeploymentRequest.newBuilder()
   *           .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
   *           .build();
   *   PatchDeployments.PatchDeployment response = osConfigServiceClient.getPatchDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PatchDeployments.PatchDeployment getPatchDeployment(
      PatchDeployments.GetPatchDeploymentRequest request) {
    return getPatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.GetPatchDeploymentRequest request =
   *       PatchDeployments.GetPatchDeploymentRequest.newBuilder()
   *           .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<PatchDeployments.PatchDeployment> future =
   *       osConfigServiceClient.getPatchDeploymentCallable().futureCall(request);
   *   // Do something.
   *   PatchDeployments.PatchDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentCallable() {
    return stub.getPatchDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PatchDeployments.PatchDeployment element :
   *       osConfigServiceClient.listPatchDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent in the form `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(ProjectName parent) {
    PatchDeployments.ListPatchDeploymentsRequest request =
        PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPatchDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (PatchDeployments.PatchDeployment element :
   *       osConfigServiceClient.listPatchDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent in the form `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(String parent) {
    PatchDeployments.ListPatchDeploymentsRequest request =
        PatchDeployments.ListPatchDeploymentsRequest.newBuilder().setParent(parent).build();
    return listPatchDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.ListPatchDeploymentsRequest request =
   *       PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PatchDeployments.PatchDeployment element :
   *       osConfigServiceClient.listPatchDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPatchDeploymentsPagedResponse listPatchDeployments(
      PatchDeployments.ListPatchDeploymentsRequest request) {
    return listPatchDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.ListPatchDeploymentsRequest request =
   *       PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PatchDeployments.PatchDeployment> future =
   *       osConfigServiceClient.listPatchDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PatchDeployments.PatchDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest, ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsPagedCallable() {
    return stub.listPatchDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a page of OS Config patch deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   while (true) {
   *     PatchDeployments.ListPatchDeploymentsResponse response =
   *         osConfigServiceClient.listPatchDeploymentsCallable().call(request);
   *     for (PatchDeployments.PatchDeployment element : response.getResponsesList()) {
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
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    return stub.listPatchDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeploymentName name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]");
   *   osConfigServiceClient.deletePatchDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(PatchDeploymentName name) {
    PatchDeployments.DeletePatchDeploymentRequest request =
        PatchDeployments.DeletePatchDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   String name = PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString();
   *   osConfigServiceClient.deletePatchDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the patch deployment in the form
   *     `projects/&#42;/patchDeployments/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(String name) {
    PatchDeployments.DeletePatchDeploymentRequest request =
        PatchDeployments.DeletePatchDeploymentRequest.newBuilder().setName(name).build();
    deletePatchDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.DeletePatchDeploymentRequest request =
   *       PatchDeployments.DeletePatchDeploymentRequest.newBuilder()
   *           .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
   *           .build();
   *   osConfigServiceClient.deletePatchDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePatchDeployment(PatchDeployments.DeletePatchDeploymentRequest request) {
    deletePatchDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an OS Config patch deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
   *   PatchDeployments.DeletePatchDeploymentRequest request =
   *       PatchDeployments.DeletePatchDeploymentRequest.newBuilder()
   *           .setName(PatchDeploymentName.of("[PROJECT]", "[PATCH_DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       osConfigServiceClient.deletePatchDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentCallable() {
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
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          PatchJobs.PatchJob,
          ListPatchJobsPage,
          ListPatchJobsFixedSizeCollection> {

    public static ApiFuture<ListPatchJobsPagedResponse> createAsync(
        PageContext<
                PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse, PatchJobs.PatchJob>
            context,
        ApiFuture<PatchJobs.ListPatchJobsResponse> futureResponse) {
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
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          PatchJobs.PatchJob,
          ListPatchJobsPage> {

    private ListPatchJobsPage(
        PageContext<
                PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse, PatchJobs.PatchJob>
            context,
        PatchJobs.ListPatchJobsResponse response) {
      super(context, response);
    }

    private static ListPatchJobsPage createEmptyPage() {
      return new ListPatchJobsPage(null, null);
    }

    @Override
    protected ListPatchJobsPage createPage(
        PageContext<
                PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse, PatchJobs.PatchJob>
            context,
        PatchJobs.ListPatchJobsResponse response) {
      return new ListPatchJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchJobsPage> createPageAsync(
        PageContext<
                PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse, PatchJobs.PatchJob>
            context,
        ApiFuture<PatchJobs.ListPatchJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          PatchJobs.PatchJob,
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
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          PatchJobs.PatchJobInstanceDetails,
          ListPatchJobInstanceDetailsPage,
          ListPatchJobInstanceDetailsFixedSizeCollection> {

    public static ApiFuture<ListPatchJobInstanceDetailsPagedResponse> createAsync(
        PageContext<
                PatchJobs.ListPatchJobInstanceDetailsRequest,
                PatchJobs.ListPatchJobInstanceDetailsResponse,
                PatchJobs.PatchJobInstanceDetails>
            context,
        ApiFuture<PatchJobs.ListPatchJobInstanceDetailsResponse> futureResponse) {
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
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          PatchJobs.PatchJobInstanceDetails,
          ListPatchJobInstanceDetailsPage> {

    private ListPatchJobInstanceDetailsPage(
        PageContext<
                PatchJobs.ListPatchJobInstanceDetailsRequest,
                PatchJobs.ListPatchJobInstanceDetailsResponse,
                PatchJobs.PatchJobInstanceDetails>
            context,
        PatchJobs.ListPatchJobInstanceDetailsResponse response) {
      super(context, response);
    }

    private static ListPatchJobInstanceDetailsPage createEmptyPage() {
      return new ListPatchJobInstanceDetailsPage(null, null);
    }

    @Override
    protected ListPatchJobInstanceDetailsPage createPage(
        PageContext<
                PatchJobs.ListPatchJobInstanceDetailsRequest,
                PatchJobs.ListPatchJobInstanceDetailsResponse,
                PatchJobs.PatchJobInstanceDetails>
            context,
        PatchJobs.ListPatchJobInstanceDetailsResponse response) {
      return new ListPatchJobInstanceDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchJobInstanceDetailsPage> createPageAsync(
        PageContext<
                PatchJobs.ListPatchJobInstanceDetailsRequest,
                PatchJobs.ListPatchJobInstanceDetailsResponse,
                PatchJobs.PatchJobInstanceDetails>
            context,
        ApiFuture<PatchJobs.ListPatchJobInstanceDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchJobInstanceDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          PatchJobs.PatchJobInstanceDetails,
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
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          PatchDeployments.PatchDeployment,
          ListPatchDeploymentsPage,
          ListPatchDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListPatchDeploymentsPagedResponse> createAsync(
        PageContext<
                PatchDeployments.ListPatchDeploymentsRequest,
                PatchDeployments.ListPatchDeploymentsResponse,
                PatchDeployments.PatchDeployment>
            context,
        ApiFuture<PatchDeployments.ListPatchDeploymentsResponse> futureResponse) {
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
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          PatchDeployments.PatchDeployment,
          ListPatchDeploymentsPage> {

    private ListPatchDeploymentsPage(
        PageContext<
                PatchDeployments.ListPatchDeploymentsRequest,
                PatchDeployments.ListPatchDeploymentsResponse,
                PatchDeployments.PatchDeployment>
            context,
        PatchDeployments.ListPatchDeploymentsResponse response) {
      super(context, response);
    }

    private static ListPatchDeploymentsPage createEmptyPage() {
      return new ListPatchDeploymentsPage(null, null);
    }

    @Override
    protected ListPatchDeploymentsPage createPage(
        PageContext<
                PatchDeployments.ListPatchDeploymentsRequest,
                PatchDeployments.ListPatchDeploymentsResponse,
                PatchDeployments.PatchDeployment>
            context,
        PatchDeployments.ListPatchDeploymentsResponse response) {
      return new ListPatchDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListPatchDeploymentsPage> createPageAsync(
        PageContext<
                PatchDeployments.ListPatchDeploymentsRequest,
                PatchDeployments.ListPatchDeploymentsResponse,
                PatchDeployments.PatchDeployment>
            context,
        ApiFuture<PatchDeployments.ListPatchDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPatchDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          PatchDeployments.PatchDeployment,
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
