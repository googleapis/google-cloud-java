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
package com.google.cloud.dlp.v2beta2;

import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListInspectTemplatesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dlp.v2beta2.stub.DlpServiceStub;
import com.google.privacy.dlp.v2beta2.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2beta2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta2.DeidentifyTemplate;
import com.google.privacy.dlp.v2beta2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2beta2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.DlpJob;
import com.google.privacy.dlp.v2beta2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.GetDlpJobRequest;
import com.google.privacy.dlp.v2beta2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.InspectContentRequest;
import com.google.privacy.dlp.v2beta2.InspectContentResponse;
import com.google.privacy.dlp.v2beta2.InspectDataSourceRequest;
import com.google.privacy.dlp.v2beta2.InspectTemplate;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2beta2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2beta2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2beta2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2beta2.RedactImageRequest;
import com.google.privacy.dlp.v2beta2.RedactImageResponse;
import com.google.privacy.dlp.v2beta2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2beta2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2beta2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.UpdateInspectTemplateRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The DLP API is a service that allows clients to detect the presence of
 * Personally Identifiable Information (PII) and other privacy-sensitive data in user-supplied,
 * unstructured data streams, like text blocks or images. The service also includes methods for
 * sensitive data redaction and scheduling of data scans on Google Cloud Platform based data sets.
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
    this.stub = settings.createStub();
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
   * Re-identify content that has been de-identified.
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
   * Re-identify content that has been de-identified.
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
   * Schedules a job scanning content in a Google Cloud Platform data repository. [How-to
   * guide](/dlp/docs/inspecting-storage)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectDataSourceRequest request = InspectDataSourceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   DlpJob response = dlpServiceClient.inspectDataSource(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob inspectDataSource(InspectDataSourceRequest request) {
    return inspectDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository. [How-to
   * guide](/dlp/docs/inspecting-storage)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectDataSourceRequest request = InspectDataSourceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;DlpJob&gt; future = dlpServiceClient.inspectDataSourceCallable().futureCall(request);
   *   // Do something
   *   DlpJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InspectDataSourceRequest, DlpJob> inspectDataSourceCallable() {
    return stub.inspectDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository. [How-to guide}(/dlp/docs/compute-risk-analysis)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   AnalyzeDataSourceRiskRequest request = AnalyzeDataSourceRiskRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   DlpJob response = dlpServiceClient.analyzeDataSourceRisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob analyzeDataSourceRisk(AnalyzeDataSourceRiskRequest request) {
    return analyzeDataSourceRiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository. [How-to guide}(/dlp/docs/compute-risk-analysis)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   AnalyzeDataSourceRiskRequest request = AnalyzeDataSourceRiskRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;DlpJob&gt; future = dlpServiceClient.analyzeDataSourceRiskCallable().futureCall(request);
   *   // Do something
   *   DlpJob response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnalyzeDataSourceRiskRequest, DlpJob> analyzeDataSourceRiskCallable() {
    return stub.analyzeDataSourceRiskCallable();
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
   *   InspectTemplateNameOneof name = InspectTemplateNameOneof.from(InspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]"));
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
   *   InspectTemplateNameOneof name = InspectTemplateNameOneof.from(InspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]"));
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
   * Deletes inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateNameOneof name = InspectTemplateNameOneof.from(InspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]"));
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
   * Deletes inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateNameOneof name = InspectTemplateNameOneof.from(InspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]"));
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
   * Creates an Deidentify template for re-using frequently used configuration for Deidentifying
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
   * Creates an Deidentify template for re-using frequently used configuration for Deidentifying
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
   * Updates the inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
   * Updates the inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
   * Gets an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
   * Gets an inspect template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
   * Lists inspect templates.
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
   * Lists inspect templates.
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
   * Lists inspect templates.
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
   * Deletes inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
   * Deletes inspect templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateNameOneof name = DeidentifyTemplateNameOneof.from(DeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]"));
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
}
