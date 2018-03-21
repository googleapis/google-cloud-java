/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dlp.v2;

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
import com.google.cloud.dlp.v2.stub.DlpServiceStub;
import com.google.cloud.dlp.v2.stub.DlpServiceStubSettings;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Cloud Data Loss Prevention (DLP) API is a service that allows clients to
 * detect the presence of Personally Identifiable Information (PII) and other privacy-sensitive data
 * in user-supplied, unstructured data streams, like text blocks or images. The service also
 * includes methods for sensitive data redaction and scheduling of data scans on Google Cloud
 * Platform based data sets.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   InspectContentRequest request = InspectContentRequest.newBuilder()
 *     .setParent(parent.toString())
 *     .build();
 *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the dlpServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DlpServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DlpServiceClient dlpServiceClient =
 *     DlpServiceClient.create(dlpServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DlpServiceClient dlpServiceClient =
 *     DlpServiceClient.create(dlpServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceClient implements BackgroundResource {
  private final DlpServiceSettings settings;
  private final DlpServiceStub stub;

  /** Constructs an instance of DlpServiceClient with default settings. */
  public static final DlpServiceClient create() throws IOException {
    return create(DlpServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DlpServiceClient create(DlpServiceSettings settings) throws IOException {
    return new DlpServiceClient(settings);
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DlpServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DlpServiceClient create(DlpServiceStub stub) {
    return new DlpServiceClient(stub);
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DlpServiceClient(DlpServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DlpServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DlpServiceClient(DlpServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DlpServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DlpServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds potentially sensitive info in content. This method has limits on input size, processing
   * time, and output size. [How-to guide for text](/dlp/docs/inspecting-text), [How-to guide for
   * images](/dlp/docs/inspecting-images)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectContentRequest request = InspectContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectContentResponse inspectContent(InspectContentRequest request) {
    return inspectContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds potentially sensitive info in content. This method has limits on input size, processing
   * time, and output size. [How-to guide for text](/dlp/docs/inspecting-text), [How-to guide for
   * images](/dlp/docs/inspecting-images)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectContentRequest request = InspectContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;InspectContentResponse&gt; future = dlpServiceClient.inspectContentCallable().futureCall(request);
   *   // Do something
   *   InspectContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InspectContentRequest, InspectContentResponse>
      inspectContentCallable() {
    return stub.inspectContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Redacts potentially sensitive info from an image. This method has limits on input size,
   * processing time, and output size. [How-to guide](/dlp/docs/redacting-sensitive-data-images)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RedactImageRequest request = RedactImageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   RedactImageResponse response = dlpServiceClient.redactImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RedactImageResponse redactImage(RedactImageRequest request) {
    return redactImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Redacts potentially sensitive info from an image. This method has limits on input size,
   * processing time, and output size. [How-to guide](/dlp/docs/redacting-sensitive-data-images)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RedactImageRequest request = RedactImageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;RedactImageResponse&gt; future = dlpServiceClient.redactImageCallable().futureCall(request);
   *   // Do something
   *   RedactImageResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable() {
    return stub.redactImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * De-identifies potentially sensitive info from a ContentItem. This method has limits on input
   * size and output size. [How-to guide](/dlp/docs/deidentify-sensitive-data)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyContentResponse deidentifyContent(DeidentifyContentRequest request) {
    return deidentifyContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * De-identifies potentially sensitive info from a ContentItem. This method has limits on input
   * size and output size. [How-to guide](/dlp/docs/deidentify-sensitive-data)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;DeidentifyContentResponse&gt; future = dlpServiceClient.deidentifyContentCallable().futureCall(request);
   *   // Do something
   *   DeidentifyContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return stub.deidentifyContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Re-identifies content that has been de-identified.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ReidentifyContentRequest request = ReidentifyContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ReidentifyContentResponse response = dlpServiceClient.reidentifyContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReidentifyContentResponse reidentifyContent(ReidentifyContentRequest request) {
    return reidentifyContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Re-identifies content that has been de-identified.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ReidentifyContentRequest request = ReidentifyContentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ReidentifyContentResponse&gt; future = dlpServiceClient.reidentifyContentCallable().futureCall(request);
   *   // Do something
   *   ReidentifyContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable() {
    return stub.reidentifyContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types DLP supports.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder().build();
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInfoTypesResponse listInfoTypes(ListInfoTypesRequest request) {
    return listInfoTypesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types DLP supports.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder().build();
   *   ApiFuture&lt;ListInfoTypesResponse&gt; future = dlpServiceClient.listInfoTypesCallable().futureCall(request);
   *   // Do something
   *   ListInfoTypesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return stub.listInfoTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an inspect template for re-using frequently used configuration for inspecting content,
   * images, and storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   CreateInspectTemplateRequest request = CreateInspectTemplateRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(CreateInspectTemplateRequest request) {
    return createInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an inspect template for re-using frequently used configuration for inspecting content,
   * images, and storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   CreateInspectTemplateRequest request = CreateInspectTemplateRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;InspectTemplate&gt; future = dlpServiceClient.createInspectTemplateCallable().futureCall(request);
   *   // Do something
   *   InspectTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable() {
    return stub.createInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name = OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   UpdateInspectTemplateRequest request = UpdateInspectTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   InspectTemplate response = dlpServiceClient.updateInspectTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate updateInspectTemplate(UpdateInspectTemplateRequest request) {
    return updateInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name = OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   UpdateInspectTemplateRequest request = UpdateInspectTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;InspectTemplate&gt; future = dlpServiceClient.updateInspectTemplateCallable().futureCall(request);
   *   // Do something
   *   InspectTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable() {
    return stub.updateInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetInspectTemplateRequest request = GetInspectTemplateRequest.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.getInspectTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate getInspectTemplate(GetInspectTemplateRequest request) {
    return getInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetInspectTemplateRequest request = GetInspectTemplateRequest.newBuilder().build();
   *   ApiFuture&lt;InspectTemplate&gt; future = dlpServiceClient.getInspectTemplateCallable().futureCall(request);
   *   // Do something
   *   InspectTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateCallable() {
    return stub.getInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListInspectTemplatesRequest request = ListInspectTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(
      ListInspectTemplatesRequest request) {
    return listInspectTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListInspectTemplatesRequest request = ListInspectTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListInspectTemplatesPagedResponse&gt; future = dlpServiceClient.listInspectTemplatesPagedCallable().futureCall(request);
   *   // Do something
   *   for (InspectTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable() {
    return stub.listInspectTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListInspectTemplatesRequest request = ListInspectTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListInspectTemplatesResponse response = dlpServiceClient.listInspectTemplatesCallable().call(request);
   *     for (InspectTemplate element : response.getInspectTemplatesList()) {
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
  public final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable() {
    return stub.listInspectTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name = OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   DeleteInspectTemplateRequest request = DeleteInspectTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dlpServiceClient.deleteInspectTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInspectTemplate(DeleteInspectTemplateRequest request) {
    deleteInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name = OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   DeleteInspectTemplateRequest request = DeleteInspectTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dlpServiceClient.deleteInspectTemplateCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable() {
    return stub.deleteInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a de-identify template for re-using frequently used configuration for Deidentifying
   * content, images, and storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   CreateDeidentifyTemplateRequest request = CreateDeidentifyTemplateRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   DeidentifyTemplate response = dlpServiceClient.createDeidentifyTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      CreateDeidentifyTemplateRequest request) {
    return createDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a de-identify template for re-using frequently used configuration for Deidentifying
   * content, images, and storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   CreateDeidentifyTemplateRequest request = CreateDeidentifyTemplateRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;DeidentifyTemplate&gt; future = dlpServiceClient.createDeidentifyTemplateCallable().futureCall(request);
   *   // Do something
   *   DeidentifyTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable() {
    return stub.createDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   UpdateDeidentifyTemplateRequest request = UpdateDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   DeidentifyTemplate response = dlpServiceClient.updateDeidentifyTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate updateDeidentifyTemplate(
      UpdateDeidentifyTemplateRequest request) {
    return updateDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   UpdateDeidentifyTemplateRequest request = UpdateDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;DeidentifyTemplate&gt; future = dlpServiceClient.updateDeidentifyTemplateCallable().futureCall(request);
   *   // Do something
   *   DeidentifyTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable() {
    return stub.updateDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   GetDeidentifyTemplateRequest request = GetDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   DeidentifyTemplate response = dlpServiceClient.getDeidentifyTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate getDeidentifyTemplate(GetDeidentifyTemplateRequest request) {
    return getDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   GetDeidentifyTemplateRequest request = GetDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;DeidentifyTemplate&gt; future = dlpServiceClient.getDeidentifyTemplateCallable().futureCall(request);
   *   // Do something
   *   DeidentifyTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable() {
    return stub.getDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists de-identify templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListDeidentifyTemplatesRequest request = ListDeidentifyTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (DeidentifyTemplate element : dlpServiceClient.listDeidentifyTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(
      ListDeidentifyTemplatesRequest request) {
    return listDeidentifyTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists de-identify templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListDeidentifyTemplatesRequest request = ListDeidentifyTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListDeidentifyTemplatesPagedResponse&gt; future = dlpServiceClient.listDeidentifyTemplatesPagedCallable().futureCall(request);
   *   // Do something
   *   for (DeidentifyTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable() {
    return stub.listDeidentifyTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists de-identify templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   ListDeidentifyTemplatesRequest request = ListDeidentifyTemplatesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListDeidentifyTemplatesResponse response = dlpServiceClient.listDeidentifyTemplatesCallable().call(request);
   *     for (DeidentifyTemplate element : response.getDeidentifyTemplatesList()) {
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
  public final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable() {
    return stub.listDeidentifyTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   DeleteDeidentifyTemplateRequest request = DeleteDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dlpServiceClient.deleteDeidentifyTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeidentifyTemplate(DeleteDeidentifyTemplateRequest request) {
    deleteDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a de-identify template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name = OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   DeleteDeidentifyTemplateRequest request = DeleteDeidentifyTemplateRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dlpServiceClient.deleteDeidentifyTemplateCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateCallable() {
    return stub.deleteDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job to inspect storage or calculate risk metrics [How-to
   * guide](/dlp/docs/compute-risk-analysis).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   CreateDlpJobRequest request = CreateDlpJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   DlpJob response = dlpServiceClient.createDlpJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(CreateDlpJobRequest request) {
    return createDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new job to inspect storage or calculate risk metrics [How-to
   * guide](/dlp/docs/compute-risk-analysis).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   CreateDlpJobRequest request = CreateDlpJobRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;DlpJob&gt; future = dlpServiceClient.createDlpJobCallable().futureCall(request);
   *   // Do something
   *   DlpJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable() {
    return stub.createDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists DlpJobs that match the specified filter in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListDlpJobsRequest request = ListDlpJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (DlpJob element : dlpServiceClient.listDlpJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDlpJobsPagedResponse listDlpJobs(ListDlpJobsRequest request) {
    return listDlpJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists DlpJobs that match the specified filter in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListDlpJobsRequest request = ListDlpJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListDlpJobsPagedResponse&gt; future = dlpServiceClient.listDlpJobsPagedCallable().futureCall(request);
   *   // Do something
   *   for (DlpJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse>
      listDlpJobsPagedCallable() {
    return stub.listDlpJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists DlpJobs that match the specified filter in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListDlpJobsRequest request = ListDlpJobsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListDlpJobsResponse response = dlpServiceClient.listDlpJobsCallable().call(request);
   *     for (DlpJob element : response.getJobsList()) {
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
  public final UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable() {
    return stub.listDlpJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the latest state of a long-running DlpJob.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   GetDlpJobRequest request = GetDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   DlpJob response = dlpServiceClient.getDlpJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob getDlpJob(GetDlpJobRequest request) {
    return getDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the latest state of a long-running DlpJob.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   GetDlpJobRequest request = GetDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;DlpJob&gt; future = dlpServiceClient.getDlpJobCallable().futureCall(request);
   *   // Do something
   *   DlpJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable() {
    return stub.getDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be cancelled if possible.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   DeleteDlpJobRequest request = DeleteDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dlpServiceClient.deleteDlpJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDlpJob(DeleteDlpJobRequest request) {
    deleteDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be cancelled if possible.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   DeleteDlpJobRequest request = DeleteDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dlpServiceClient.deleteDlpJobCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable() {
    return stub.deleteDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to
   * cancel the DlpJob, but success is not guaranteed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   CancelDlpJobRequest request = CancelDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dlpServiceClient.cancelDlpJob(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDlpJob(CancelDlpJobRequest request) {
    cancelDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to
   * cancel the DlpJob, but success is not guaranteed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
   *   CancelDlpJobRequest request = CancelDlpJobRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dlpServiceClient.cancelDlpJobCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable() {
    return stub.cancelDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists job triggers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListJobTriggersRequest request = ListJobTriggersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (JobTrigger element : dlpServiceClient.listJobTriggers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTriggersPagedResponse listJobTriggers(ListJobTriggersRequest request) {
    return listJobTriggersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists job triggers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListJobTriggersRequest request = ListJobTriggersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListJobTriggersPagedResponse&gt; future = dlpServiceClient.listJobTriggersPagedCallable().futureCall(request);
   *   // Do something
   *   for (JobTrigger element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable() {
    return stub.listJobTriggersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists job triggers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListJobTriggersRequest request = ListJobTriggersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListJobTriggersResponse response = dlpServiceClient.listJobTriggersCallable().call(request);
   *     for (JobTrigger element : response.getJobTriggersList()) {
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
  public final UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersCallable() {
    return stub.listJobTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   GetJobTriggerRequest request = GetJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   JobTrigger response = dlpServiceClient.getJobTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger getJobTrigger(GetJobTriggerRequest request) {
    return getJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   GetJobTriggerRequest request = GetJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;JobTrigger&gt; future = dlpServiceClient.getJobTriggerCallable().futureCall(request);
   *   // Do something
   *   JobTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable() {
    return stub.getJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   DeleteJobTriggerRequest request = DeleteJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dlpServiceClient.deleteJobTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTrigger(DeleteJobTriggerRequest request) {
    deleteJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   DeleteJobTriggerRequest request = DeleteJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dlpServiceClient.deleteJobTriggerCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable() {
    return stub.deleteJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   UpdateJobTriggerRequest request = UpdateJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   JobTrigger response = dlpServiceClient.updateJobTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger updateJobTrigger(UpdateJobTriggerRequest request) {
    return updateJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a job trigger.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
   *   UpdateJobTriggerRequest request = UpdateJobTriggerRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;JobTrigger&gt; future = dlpServiceClient.updateJobTriggerCallable().futureCall(request);
   *   // Do something
   *   JobTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable() {
    return stub.updateJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   CreateJobTriggerRequest request = CreateJobTriggerRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   JobTrigger response = dlpServiceClient.createJobTrigger(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger createJobTrigger(CreateJobTriggerRequest request) {
    return createJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   CreateJobTriggerRequest request = CreateJobTriggerRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;JobTrigger&gt; future = dlpServiceClient.createJobTriggerCallable().futureCall(request);
   *   // Do something
   *   JobTrigger response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable() {
    return stub.createJobTriggerCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class ListInspectTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage, ListInspectTemplatesFixedSizeCollection> {

    public static ApiFuture<ListInspectTemplatesPagedResponse> createAsync(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ApiFuture<ListInspectTemplatesResponse> futureResponse) {
      ApiFuture<ListInspectTemplatesPage> futurePage =
          ListInspectTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInspectTemplatesPage, ListInspectTemplatesPagedResponse>() {
            @Override
            public ListInspectTemplatesPagedResponse apply(ListInspectTemplatesPage input) {
              return new ListInspectTemplatesPagedResponse(input);
            }
          });
    }

    private ListInspectTemplatesPagedResponse(ListInspectTemplatesPage page) {
      super(page, ListInspectTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInspectTemplatesPage
      extends AbstractPage<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage> {

    private ListInspectTemplatesPage(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ListInspectTemplatesResponse response) {
      super(context, response);
    }

    private static ListInspectTemplatesPage createEmptyPage() {
      return new ListInspectTemplatesPage(null, null);
    }

    @Override
    protected ListInspectTemplatesPage createPage(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ListInspectTemplatesResponse response) {
      return new ListInspectTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListInspectTemplatesPage> createPageAsync(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ApiFuture<ListInspectTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInspectTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage, ListInspectTemplatesFixedSizeCollection> {

    private ListInspectTemplatesFixedSizeCollection(
        List<ListInspectTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInspectTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListInspectTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInspectTemplatesFixedSizeCollection createCollection(
        List<ListInspectTemplatesPage> pages, int collectionSize) {
      return new ListInspectTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDeidentifyTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage, ListDeidentifyTemplatesFixedSizeCollection> {

    public static ApiFuture<ListDeidentifyTemplatesPagedResponse> createAsync(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
      ApiFuture<ListDeidentifyTemplatesPage> futurePage =
          ListDeidentifyTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDeidentifyTemplatesPage, ListDeidentifyTemplatesPagedResponse>() {
            @Override
            public ListDeidentifyTemplatesPagedResponse apply(ListDeidentifyTemplatesPage input) {
              return new ListDeidentifyTemplatesPagedResponse(input);
            }
          });
    }

    private ListDeidentifyTemplatesPagedResponse(ListDeidentifyTemplatesPage page) {
      super(page, ListDeidentifyTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeidentifyTemplatesPage
      extends AbstractPage<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage> {

    private ListDeidentifyTemplatesPage(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ListDeidentifyTemplatesResponse response) {
      super(context, response);
    }

    private static ListDeidentifyTemplatesPage createEmptyPage() {
      return new ListDeidentifyTemplatesPage(null, null);
    }

    @Override
    protected ListDeidentifyTemplatesPage createPage(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ListDeidentifyTemplatesResponse response) {
      return new ListDeidentifyTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeidentifyTemplatesPage> createPageAsync(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeidentifyTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage, ListDeidentifyTemplatesFixedSizeCollection> {

    private ListDeidentifyTemplatesFixedSizeCollection(
        List<ListDeidentifyTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeidentifyTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListDeidentifyTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeidentifyTemplatesFixedSizeCollection createCollection(
        List<ListDeidentifyTemplatesPage> pages, int collectionSize) {
      return new ListDeidentifyTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDlpJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage,
          ListDlpJobsFixedSizeCollection> {

    public static ApiFuture<ListDlpJobsPagedResponse> createAsync(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ApiFuture<ListDlpJobsResponse> futureResponse) {
      ApiFuture<ListDlpJobsPage> futurePage =
          ListDlpJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDlpJobsPage, ListDlpJobsPagedResponse>() {
            @Override
            public ListDlpJobsPagedResponse apply(ListDlpJobsPage input) {
              return new ListDlpJobsPagedResponse(input);
            }
          });
    }

    private ListDlpJobsPagedResponse(ListDlpJobsPage page) {
      super(page, ListDlpJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDlpJobsPage
      extends AbstractPage<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage> {

    private ListDlpJobsPage(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ListDlpJobsResponse response) {
      super(context, response);
    }

    private static ListDlpJobsPage createEmptyPage() {
      return new ListDlpJobsPage(null, null);
    }

    @Override
    protected ListDlpJobsPage createPage(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ListDlpJobsResponse response) {
      return new ListDlpJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListDlpJobsPage> createPageAsync(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ApiFuture<ListDlpJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDlpJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage,
          ListDlpJobsFixedSizeCollection> {

    private ListDlpJobsFixedSizeCollection(List<ListDlpJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDlpJobsFixedSizeCollection createEmptyCollection() {
      return new ListDlpJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDlpJobsFixedSizeCollection createCollection(
        List<ListDlpJobsPage> pages, int collectionSize) {
      return new ListDlpJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListJobTriggersPagedResponse
      extends AbstractPagedListResponse<
          ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger, ListJobTriggersPage,
          ListJobTriggersFixedSizeCollection> {

    public static ApiFuture<ListJobTriggersPagedResponse> createAsync(
        PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> context,
        ApiFuture<ListJobTriggersResponse> futureResponse) {
      ApiFuture<ListJobTriggersPage> futurePage =
          ListJobTriggersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListJobTriggersPage, ListJobTriggersPagedResponse>() {
            @Override
            public ListJobTriggersPagedResponse apply(ListJobTriggersPage input) {
              return new ListJobTriggersPagedResponse(input);
            }
          });
    }

    private ListJobTriggersPagedResponse(ListJobTriggersPage page) {
      super(page, ListJobTriggersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobTriggersPage
      extends AbstractPage<
          ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger, ListJobTriggersPage> {

    private ListJobTriggersPage(
        PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> context,
        ListJobTriggersResponse response) {
      super(context, response);
    }

    private static ListJobTriggersPage createEmptyPage() {
      return new ListJobTriggersPage(null, null);
    }

    @Override
    protected ListJobTriggersPage createPage(
        PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> context,
        ListJobTriggersResponse response) {
      return new ListJobTriggersPage(context, response);
    }

    @Override
    public ApiFuture<ListJobTriggersPage> createPageAsync(
        PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> context,
        ApiFuture<ListJobTriggersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobTriggersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger, ListJobTriggersPage,
          ListJobTriggersFixedSizeCollection> {

    private ListJobTriggersFixedSizeCollection(
        List<ListJobTriggersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobTriggersFixedSizeCollection createEmptyCollection() {
      return new ListJobTriggersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobTriggersFixedSizeCollection createCollection(
        List<ListJobTriggersPage> pages, int collectionSize) {
      return new ListJobTriggersFixedSizeCollection(pages, collectionSize);
    }
  }
}
