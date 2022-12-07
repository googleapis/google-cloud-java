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

package com.google.cloud.dlp.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dlp.v2.stub.DlpServiceStub;
import com.google.cloud.dlp.v2.stub.DlpServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeidentifyTemplateName;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.InspectTemplateName;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.JobTriggerName;
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
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.OrganizationLocationName;
import com.google.privacy.dlp.v2.OrganizationName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.RiskAnalysisJobConfig;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.StoredInfoTypeConfig;
import com.google.privacy.dlp.v2.StoredInfoTypeName;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Data Loss Prevention (DLP) API is a service that allows clients to
 * detect the presence of Personally Identifiable Information (PII) and other privacy-sensitive data
 * in user-supplied, unstructured data streams, like text blocks or images. The service also
 * includes methods for sensitive data redaction and scheduling of data scans on Google Cloud
 * Platform based data sets.
 *
 * <p>To learn more about concepts and find how-to guides see https://cloud.google.com/dlp/docs/.
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
 * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
 *   InspectContentRequest request =
 *       InspectContentRequest.newBuilder()
 *           .setParent(ProjectName.of("[PROJECT]").toString())
 *           .setInspectConfig(InspectConfig.newBuilder().build())
 *           .setItem(ContentItem.newBuilder().build())
 *           .setInspectTemplateName("inspectTemplateName1828857433")
 *           .setLocationId("locationId1541836720")
 *           .build();
 *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DlpServiceClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DlpServiceSettings to
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
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DlpServiceClient dlpServiceClient = DlpServiceClient.create(dlpServiceSettings);
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
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DlpServiceClient dlpServiceClient = DlpServiceClient.create(dlpServiceSettings);
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
 * DlpServiceSettings dlpServiceSettings = DlpServiceSettings.newHttpJsonBuilder().build();
 * DlpServiceClient dlpServiceClient = DlpServiceClient.create(dlpServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * advanced usage - prefer using create(DlpServiceSettings).
   */
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

  protected DlpServiceClient(DlpServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DlpServiceSettings getSettings() {
    return settings;
  }

  public DlpServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds potentially sensitive info in content. This method has limits on input size, processing
   * time, and output size.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images and
   * https://cloud.google.com/dlp/docs/inspecting-text,
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectContentRequest request =
   *       InspectContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectContentResponse inspectContent(InspectContentRequest request) {
    return inspectContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds potentially sensitive info in content. This method has limits on input size, processing
   * time, and output size.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images and
   * https://cloud.google.com/dlp/docs/inspecting-text,
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectContentRequest request =
   *       InspectContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<InspectContentResponse> future =
   *       dlpServiceClient.inspectContentCallable().futureCall(request);
   *   // Do something.
   *   InspectContentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InspectContentRequest, InspectContentResponse>
      inspectContentCallable() {
    return stub.inspectContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redacts potentially sensitive info from an image. This method has limits on input size,
   * processing time, and output size. See
   * https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   RedactImageRequest request =
   *       RedactImageRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setLocationId("locationId1541836720")
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .addAllImageRedactionConfigs(new ArrayList<RedactImageRequest.ImageRedactionConfig>())
   *           .setIncludeFindings(true)
   *           .setByteItem(ByteContentItem.newBuilder().build())
   *           .build();
   *   RedactImageResponse response = dlpServiceClient.redactImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RedactImageResponse redactImage(RedactImageRequest request) {
    return redactImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redacts potentially sensitive info from an image. This method has limits on input size,
   * processing time, and output size. See
   * https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   RedactImageRequest request =
   *       RedactImageRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setLocationId("locationId1541836720")
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .addAllImageRedactionConfigs(new ArrayList<RedactImageRequest.ImageRedactionConfig>())
   *           .setIncludeFindings(true)
   *           .setByteItem(ByteContentItem.newBuilder().build())
   *           .build();
   *   ApiFuture<RedactImageResponse> future =
   *       dlpServiceClient.redactImageCallable().futureCall(request);
   *   // Do something.
   *   RedactImageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable() {
    return stub.redactImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-identifies potentially sensitive info from a ContentItem. This method has limits on input
   * size and output size. See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to learn
   * more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyContentRequest request =
   *       DeidentifyContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setDeidentifyTemplateName("deidentifyTemplateName-1374666414")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyContentResponse deidentifyContent(DeidentifyContentRequest request) {
    return deidentifyContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-identifies potentially sensitive info from a ContentItem. This method has limits on input
   * size and output size. See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to learn
   * more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in this request, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyContentRequest request =
   *       DeidentifyContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setDeidentifyTemplateName("deidentifyTemplateName-1374666414")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<DeidentifyContentResponse> future =
   *       dlpServiceClient.deidentifyContentCallable().futureCall(request);
   *   // Do something.
   *   DeidentifyContentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return stub.deidentifyContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Re-identifies content that has been de-identified. See
   * https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ReidentifyContentRequest request =
   *       ReidentifyContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setReidentifyConfig(DeidentifyConfig.newBuilder().build())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setReidentifyTemplateName("reidentifyTemplateName157316612")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ReidentifyContentResponse response = dlpServiceClient.reidentifyContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReidentifyContentResponse reidentifyContent(ReidentifyContentRequest request) {
    return reidentifyContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Re-identifies content that has been de-identified. See
   * https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ReidentifyContentRequest request =
   *       ReidentifyContentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setReidentifyConfig(DeidentifyConfig.newBuilder().build())
   *           .setInspectConfig(InspectConfig.newBuilder().build())
   *           .setItem(ContentItem.newBuilder().build())
   *           .setInspectTemplateName("inspectTemplateName1828857433")
   *           .setReidentifyTemplateName("reidentifyTemplateName157316612")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<ReidentifyContentResponse> future =
   *       dlpServiceClient.reidentifyContentCallable().futureCall(request);
   *   // Do something.
   *   ReidentifyContentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable() {
    return stub.reidentifyContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the sensitive information types that DLP API supports. See
   * https://cloud.google.com/dlp/docs/infotypes-reference to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(parent);
   * }
   * }</pre>
   *
   * @param parent The parent resource name.
   *     <p>The format of this value is as follows:
   *     <p>locations/&lt;var&gt;LOCATION_ID&lt;/var&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInfoTypesResponse listInfoTypes(String parent) {
    ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder().setParent(parent).build();
    return listInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the sensitive information types that DLP API supports. See
   * https://cloud.google.com/dlp/docs/infotypes-reference to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInfoTypesRequest request =
   *       ListInfoTypesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setFilter("filter-1274492040")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInfoTypesResponse listInfoTypes(ListInfoTypesRequest request) {
    return listInfoTypesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of the sensitive information types that DLP API supports. See
   * https://cloud.google.com/dlp/docs/infotypes-reference to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInfoTypesRequest request =
   *       ListInfoTypesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setFilter("filter-1274492040")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<ListInfoTypesResponse> future =
   *       dlpServiceClient.listInfoTypesCallable().futureCall(request);
   *   // Do something.
   *   ListInfoTypesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return stub.listInfoTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(parent, inspectTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectTemplate Required. The InspectTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(
      LocationName parent, InspectTemplate inspectTemplate) {
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectTemplate(inspectTemplate)
            .build();
    return createInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(parent, inspectTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectTemplate Required. The InspectTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(
      OrganizationLocationName parent, InspectTemplate inspectTemplate) {
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectTemplate(inspectTemplate)
            .build();
    return createInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(parent, inspectTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectTemplate Required. The InspectTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(
      OrganizationName parent, InspectTemplate inspectTemplate) {
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectTemplate(inspectTemplate)
            .build();
    return createInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(parent, inspectTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectTemplate Required. The InspectTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(
      ProjectName parent, InspectTemplate inspectTemplate) {
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectTemplate(inspectTemplate)
            .build();
    return createInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(parent, inspectTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectTemplate Required. The InspectTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(
      String parent, InspectTemplate inspectTemplate) {
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder()
            .setParent(parent)
            .setInspectTemplate(inspectTemplate)
            .build();
    return createInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateInspectTemplateRequest request =
   *       CreateInspectTemplateRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setInspectTemplate(InspectTemplate.newBuilder().build())
   *           .setTemplateId("templateId1304010549")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   InspectTemplate response = dlpServiceClient.createInspectTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate createInspectTemplate(CreateInspectTemplateRequest request) {
    return createInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InspectTemplate for reusing frequently used configuration for inspecting content,
   * images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateInspectTemplateRequest request =
   *       CreateInspectTemplateRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setInspectTemplate(InspectTemplate.newBuilder().build())
   *           .setTemplateId("templateId1304010549")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<InspectTemplate> future =
   *       dlpServiceClient.createInspectTemplateCallable().futureCall(request);
   *   // Do something.
   *   InspectTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable() {
    return stub.createInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *           "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InspectTemplate response =
   *       dlpServiceClient.updateInspectTemplate(name, inspectTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and inspectTemplate to be updated, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @param inspectTemplate New InspectTemplate value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate updateInspectTemplate(
      InspectTemplateName name, InspectTemplate inspectTemplate, FieldMask updateMask) {
    UpdateInspectTemplateRequest request =
        UpdateInspectTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setInspectTemplate(inspectTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *               "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *           .toString();
   *   InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InspectTemplate response =
   *       dlpServiceClient.updateInspectTemplate(name, inspectTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and inspectTemplate to be updated, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @param inspectTemplate New InspectTemplate value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate updateInspectTemplate(
      String name, InspectTemplate inspectTemplate, FieldMask updateMask) {
    UpdateInspectTemplateRequest request =
        UpdateInspectTemplateRequest.newBuilder()
            .setName(name)
            .setInspectTemplate(inspectTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateInspectTemplateRequest request =
   *       UpdateInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .setInspectTemplate(InspectTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   InspectTemplate response = dlpServiceClient.updateInspectTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate updateInspectTemplate(UpdateInspectTemplateRequest request) {
    return updateInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateInspectTemplateRequest request =
   *       UpdateInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .setInspectTemplate(InspectTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<InspectTemplate> future =
   *       dlpServiceClient.updateInspectTemplateCallable().futureCall(request);
   *   // Do something.
   *   InspectTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable() {
    return stub.updateInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *           "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   InspectTemplate response = dlpServiceClient.getInspectTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and inspectTemplate to be read, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate getInspectTemplate(InspectTemplateName name) {
    GetInspectTemplateRequest request =
        GetInspectTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *               "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *           .toString();
   *   InspectTemplate response = dlpServiceClient.getInspectTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and inspectTemplate to be read, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate getInspectTemplate(String name) {
    GetInspectTemplateRequest request =
        GetInspectTemplateRequest.newBuilder().setName(name).build();
    return getInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetInspectTemplateRequest request =
   *       GetInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   InspectTemplate response = dlpServiceClient.getInspectTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectTemplate getInspectTemplate(GetInspectTemplateRequest request) {
    return getInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetInspectTemplateRequest request =
   *       GetInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InspectTemplate> future =
   *       dlpServiceClient.getInspectTemplateCallable().futureCall(request);
   *   // Do something.
   *   InspectTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateCallable() {
    return stub.getInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(LocationName parent) {
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInspectTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(
      OrganizationLocationName parent) {
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInspectTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(OrganizationName parent) {
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInspectTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(ProjectName parent) {
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInspectTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(String parent) {
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder().setParent(parent).build();
    return listInspectTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInspectTemplatesRequest request =
   *       ListInspectTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   for (InspectTemplate element : dlpServiceClient.listInspectTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectTemplatesPagedResponse listInspectTemplates(
      ListInspectTemplatesRequest request) {
    return listInspectTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInspectTemplatesRequest request =
   *       ListInspectTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<InspectTemplate> future =
   *       dlpServiceClient.listInspectTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InspectTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable() {
    return stub.listInspectTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListInspectTemplatesRequest request =
   *       ListInspectTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   while (true) {
   *     ListInspectTemplatesResponse response =
   *         dlpServiceClient.listInspectTemplatesCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable() {
    return stub.listInspectTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectTemplateName name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *           "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
   *   dlpServiceClient.deleteInspectTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and inspectTemplate to be deleted, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInspectTemplate(InspectTemplateName name) {
    DeleteInspectTemplateRequest request =
        DeleteInspectTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       InspectTemplateName.ofOrganizationInspectTemplateName(
   *               "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *           .toString();
   *   dlpServiceClient.deleteInspectTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and inspectTemplate to be deleted, for
   *     example `organizations/433245324/inspectTemplates/432452342` or
   *     projects/project-id/inspectTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInspectTemplate(String name) {
    DeleteInspectTemplateRequest request =
        DeleteInspectTemplateRequest.newBuilder().setName(name).build();
    deleteInspectTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteInspectTemplateRequest request =
   *       DeleteInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   dlpServiceClient.deleteInspectTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInspectTemplate(DeleteInspectTemplateRequest request) {
    deleteInspectTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteInspectTemplateRequest request =
   *       DeleteInspectTemplateRequest.newBuilder()
   *           .setName(
   *               InspectTemplateName.ofOrganizationInspectTemplateName(
   *                       "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dlpServiceClient.deleteInspectTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable() {
    return stub.deleteInspectTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.createDeidentifyTemplate(parent, deidentifyTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param deidentifyTemplate Required. The DeidentifyTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      LocationName parent, DeidentifyTemplate deidentifyTemplate) {
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeidentifyTemplate(deidentifyTemplate)
            .build();
    return createDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.createDeidentifyTemplate(parent, deidentifyTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param deidentifyTemplate Required. The DeidentifyTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      OrganizationLocationName parent, DeidentifyTemplate deidentifyTemplate) {
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeidentifyTemplate(deidentifyTemplate)
            .build();
    return createDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.createDeidentifyTemplate(parent, deidentifyTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param deidentifyTemplate Required. The DeidentifyTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      OrganizationName parent, DeidentifyTemplate deidentifyTemplate) {
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeidentifyTemplate(deidentifyTemplate)
            .build();
    return createDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.createDeidentifyTemplate(parent, deidentifyTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param deidentifyTemplate Required. The DeidentifyTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      ProjectName parent, DeidentifyTemplate deidentifyTemplate) {
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeidentifyTemplate(deidentifyTemplate)
            .build();
    return createDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.createDeidentifyTemplate(parent, deidentifyTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param deidentifyTemplate Required. The DeidentifyTemplate to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      String parent, DeidentifyTemplate deidentifyTemplate) {
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder()
            .setParent(parent)
            .setDeidentifyTemplate(deidentifyTemplate)
            .build();
    return createDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateDeidentifyTemplateRequest request =
   *       CreateDeidentifyTemplateRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setDeidentifyTemplate(DeidentifyTemplate.newBuilder().build())
   *           .setTemplateId("templateId1304010549")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   DeidentifyTemplate response = dlpServiceClient.createDeidentifyTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate createDeidentifyTemplate(
      CreateDeidentifyTemplateRequest request) {
    return createDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying
   * content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateDeidentifyTemplateRequest request =
   *       CreateDeidentifyTemplateRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setDeidentifyTemplate(DeidentifyTemplate.newBuilder().build())
   *           .setTemplateId("templateId1304010549")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<DeidentifyTemplate> future =
   *       dlpServiceClient.createDeidentifyTemplateCallable().futureCall(request);
   *   // Do something.
   *   DeidentifyTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable() {
    return stub.createDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *           "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and deidentify template to be updated, for
   *     example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @param deidentifyTemplate New DeidentifyTemplate value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate updateDeidentifyTemplate(
      DeidentifyTemplateName name, DeidentifyTemplate deidentifyTemplate, FieldMask updateMask) {
    UpdateDeidentifyTemplateRequest request =
        UpdateDeidentifyTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDeidentifyTemplate(deidentifyTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *               "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *           .toString();
   *   DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DeidentifyTemplate response =
   *       dlpServiceClient.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and deidentify template to be updated, for
   *     example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @param deidentifyTemplate New DeidentifyTemplate value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate updateDeidentifyTemplate(
      String name, DeidentifyTemplate deidentifyTemplate, FieldMask updateMask) {
    UpdateDeidentifyTemplateRequest request =
        UpdateDeidentifyTemplateRequest.newBuilder()
            .setName(name)
            .setDeidentifyTemplate(deidentifyTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateDeidentifyTemplateRequest request =
   *       UpdateDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .setDeidentifyTemplate(DeidentifyTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DeidentifyTemplate response = dlpServiceClient.updateDeidentifyTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate updateDeidentifyTemplate(
      UpdateDeidentifyTemplateRequest request) {
    return updateDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid
   * to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateDeidentifyTemplateRequest request =
   *       UpdateDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .setDeidentifyTemplate(DeidentifyTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DeidentifyTemplate> future =
   *       dlpServiceClient.updateDeidentifyTemplateCallable().futureCall(request);
   *   // Do something.
   *   DeidentifyTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable() {
    return stub.updateDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *           "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   DeidentifyTemplate response = dlpServiceClient.getDeidentifyTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and deidentify template to be read, for
   *     example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate getDeidentifyTemplate(DeidentifyTemplateName name) {
    GetDeidentifyTemplateRequest request =
        GetDeidentifyTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *               "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *           .toString();
   *   DeidentifyTemplate response = dlpServiceClient.getDeidentifyTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and deidentify template to be read, for
   *     example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate getDeidentifyTemplate(String name) {
    GetDeidentifyTemplateRequest request =
        GetDeidentifyTemplateRequest.newBuilder().setName(name).build();
    return getDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetDeidentifyTemplateRequest request =
   *       GetDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   DeidentifyTemplate response = dlpServiceClient.getDeidentifyTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyTemplate getDeidentifyTemplate(GetDeidentifyTemplateRequest request) {
    return getDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetDeidentifyTemplateRequest request =
   *       GetDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DeidentifyTemplate> future =
   *       dlpServiceClient.getDeidentifyTemplateCallable().futureCall(request);
   *   // Do something.
   *   DeidentifyTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable() {
    return stub.getDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(LocationName parent) {
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeidentifyTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(
      OrganizationLocationName parent) {
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeidentifyTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(
      OrganizationName parent) {
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeidentifyTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(ProjectName parent) {
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeidentifyTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(String parent) {
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder().setParent(parent).build();
    return listDeidentifyTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDeidentifyTemplatesRequest request =
   *       ListDeidentifyTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   for (DeidentifyTemplate element :
   *       dlpServiceClient.listDeidentifyTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeidentifyTemplatesPagedResponse listDeidentifyTemplates(
      ListDeidentifyTemplatesRequest request) {
    return listDeidentifyTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDeidentifyTemplatesRequest request =
   *       ListDeidentifyTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<DeidentifyTemplate> future =
   *       dlpServiceClient.listDeidentifyTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DeidentifyTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable() {
    return stub.listDeidentifyTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDeidentifyTemplatesRequest request =
   *       ListDeidentifyTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   while (true) {
   *     ListDeidentifyTemplatesResponse response =
   *         dlpServiceClient.listDeidentifyTemplatesCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable() {
    return stub.listDeidentifyTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyTemplateName name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *           "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
   *   dlpServiceClient.deleteDeidentifyTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and deidentify template to be deleted,
   *     for example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeidentifyTemplate(DeidentifyTemplateName name) {
    DeleteDeidentifyTemplateRequest request =
        DeleteDeidentifyTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *               "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *           .toString();
   *   dlpServiceClient.deleteDeidentifyTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and deidentify template to be deleted,
   *     for example `organizations/433245324/deidentifyTemplates/432452342` or
   *     projects/project-id/deidentifyTemplates/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeidentifyTemplate(String name) {
    DeleteDeidentifyTemplateRequest request =
        DeleteDeidentifyTemplateRequest.newBuilder().setName(name).build();
    deleteDeidentifyTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteDeidentifyTemplateRequest request =
   *       DeleteDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   dlpServiceClient.deleteDeidentifyTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeidentifyTemplate(DeleteDeidentifyTemplateRequest request) {
    deleteDeidentifyTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteDeidentifyTemplateRequest request =
   *       DeleteDeidentifyTemplateRequest.newBuilder()
   *           .setName(
   *               DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
   *                       "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dlpServiceClient.deleteDeidentifyTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateCallable() {
    return stub.deleteDeidentifyTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   JobTrigger jobTrigger = JobTrigger.newBuilder().build();
   *   JobTrigger response = dlpServiceClient.createJobTrigger(parent, jobTrigger);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param jobTrigger Required. The JobTrigger to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger createJobTrigger(LocationName parent, JobTrigger jobTrigger) {
    CreateJobTriggerRequest request =
        CreateJobTriggerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJobTrigger(jobTrigger)
            .build();
    return createJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   JobTrigger jobTrigger = JobTrigger.newBuilder().build();
   *   JobTrigger response = dlpServiceClient.createJobTrigger(parent, jobTrigger);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param jobTrigger Required. The JobTrigger to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger createJobTrigger(ProjectName parent, JobTrigger jobTrigger) {
    CreateJobTriggerRequest request =
        CreateJobTriggerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setJobTrigger(jobTrigger)
            .build();
    return createJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   JobTrigger jobTrigger = JobTrigger.newBuilder().build();
   *   JobTrigger response = dlpServiceClient.createJobTrigger(parent, jobTrigger);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param jobTrigger Required. The JobTrigger to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger createJobTrigger(String parent, JobTrigger jobTrigger) {
    CreateJobTriggerRequest request =
        CreateJobTriggerRequest.newBuilder().setParent(parent).setJobTrigger(jobTrigger).build();
    return createJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateJobTriggerRequest request =
   *       CreateJobTriggerRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setJobTrigger(JobTrigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   JobTrigger response = dlpServiceClient.createJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger createJobTrigger(CreateJobTriggerRequest request) {
    return createJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a job trigger to run DLP actions such as scanning storage for sensitive information on
   * a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateJobTriggerRequest request =
   *       CreateJobTriggerRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setJobTrigger(JobTrigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<JobTrigger> future =
   *       dlpServiceClient.createJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   JobTrigger response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable() {
    return stub.createJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
   *   JobTrigger jobTrigger = JobTrigger.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   JobTrigger response = dlpServiceClient.updateJobTrigger(name, jobTrigger, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @param jobTrigger New JobTrigger value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger updateJobTrigger(
      JobTriggerName name, JobTrigger jobTrigger, FieldMask updateMask) {
    UpdateJobTriggerRequest request =
        UpdateJobTriggerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setJobTrigger(jobTrigger)
            .setUpdateMask(updateMask)
            .build();
    return updateJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString();
   *   JobTrigger jobTrigger = JobTrigger.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   JobTrigger response = dlpServiceClient.updateJobTrigger(name, jobTrigger, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @param jobTrigger New JobTrigger value.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger updateJobTrigger(
      String name, JobTrigger jobTrigger, FieldMask updateMask) {
    UpdateJobTriggerRequest request =
        UpdateJobTriggerRequest.newBuilder()
            .setName(name)
            .setJobTrigger(jobTrigger)
            .setUpdateMask(updateMask)
            .build();
    return updateJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateJobTriggerRequest request =
   *       UpdateJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .setJobTrigger(JobTrigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   JobTrigger response = dlpServiceClient.updateJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger updateJobTrigger(UpdateJobTriggerRequest request) {
    return updateJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateJobTriggerRequest request =
   *       UpdateJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .setJobTrigger(JobTrigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<JobTrigger> future =
   *       dlpServiceClient.updateJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   JobTrigger response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable() {
    return stub.updateJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a trigger. The inspection will be processed
   * asynchronously. To review the findings monitor the jobs within the trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   JobTriggerName name =
   *       JobTriggerName.ofProjectLocationJobTriggerName(
   *           "[PROJECT]", "[LOCATION]", "[JOB_TRIGGER]");
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the trigger to execute a hybrid inspect on, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectJobTrigger(JobTriggerName name) {
    HybridInspectJobTriggerRequest request =
        HybridInspectJobTriggerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return hybridInspectJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a trigger. The inspection will be processed
   * asynchronously. To review the findings monitor the jobs within the trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString();
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the trigger to execute a hybrid inspect on, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectJobTrigger(String name) {
    HybridInspectJobTriggerRequest request =
        HybridInspectJobTriggerRequest.newBuilder().setName(name).build();
    return hybridInspectJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a trigger. The inspection will be processed
   * asynchronously. To review the findings monitor the jobs within the trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   HybridInspectJobTriggerRequest request =
   *       HybridInspectJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectLocationJobTriggerName(
   *                       "[PROJECT]", "[LOCATION]", "[JOB_TRIGGER]")
   *                   .toString())
   *           .setHybridItem(HybridContentItem.newBuilder().build())
   *           .build();
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectJobTrigger(
      HybridInspectJobTriggerRequest request) {
    return hybridInspectJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a trigger. The inspection will be processed
   * asynchronously. To review the findings monitor the jobs within the trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   HybridInspectJobTriggerRequest request =
   *       HybridInspectJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectLocationJobTriggerName(
   *                       "[PROJECT]", "[LOCATION]", "[JOB_TRIGGER]")
   *                   .toString())
   *           .setHybridItem(HybridContentItem.newBuilder().build())
   *           .build();
   *   ApiFuture<HybridInspectResponse> future =
   *       dlpServiceClient.hybridInspectJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   HybridInspectResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerCallable() {
    return stub.hybridInspectJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
   *   JobTrigger response = dlpServiceClient.getJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger getJobTrigger(JobTriggerName name) {
    GetJobTriggerRequest request =
        GetJobTriggerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString();
   *   JobTrigger response = dlpServiceClient.getJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger getJobTrigger(String name) {
    GetJobTriggerRequest request = GetJobTriggerRequest.newBuilder().setName(name).build();
    return getJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetJobTriggerRequest request =
   *       GetJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   JobTrigger response = dlpServiceClient.getJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JobTrigger getJobTrigger(GetJobTriggerRequest request) {
    return getJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetJobTriggerRequest request =
   *       GetJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   ApiFuture<JobTrigger> future = dlpServiceClient.getJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   JobTrigger response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable() {
    return stub.getJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (JobTrigger element : dlpServiceClient.listJobTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTriggersPagedResponse listJobTriggers(LocationName parent) {
    ListJobTriggersRequest request =
        ListJobTriggersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listJobTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (JobTrigger element : dlpServiceClient.listJobTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTriggersPagedResponse listJobTriggers(ProjectName parent) {
    ListJobTriggersRequest request =
        ListJobTriggersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listJobTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (JobTrigger element : dlpServiceClient.listJobTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTriggersPagedResponse listJobTriggers(String parent) {
    ListJobTriggersRequest request = ListJobTriggersRequest.newBuilder().setParent(parent).build();
    return listJobTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListJobTriggersRequest request =
   *       ListJobTriggersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .setType(DlpJobType.forNumber(0))
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   for (JobTrigger element : dlpServiceClient.listJobTriggers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobTriggersPagedResponse listJobTriggers(ListJobTriggersRequest request) {
    return listJobTriggersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListJobTriggersRequest request =
   *       ListJobTriggersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .setType(DlpJobType.forNumber(0))
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<JobTrigger> future =
   *       dlpServiceClient.listJobTriggersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (JobTrigger element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable() {
    return stub.listJobTriggersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListJobTriggersRequest request =
   *       ListJobTriggersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .setType(DlpJobType.forNumber(0))
   *           .setLocationId("locationId1541836720")
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersCallable() {
    return stub.listJobTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
   *   dlpServiceClient.deleteJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTrigger(JobTriggerName name) {
    DeleteJobTriggerRequest request =
        DeleteJobTriggerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString();
   *   dlpServiceClient.deleteJobTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the project and the triggeredJob, for example
   *     `projects/dlp-test-project/jobTriggers/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTrigger(String name) {
    DeleteJobTriggerRequest request = DeleteJobTriggerRequest.newBuilder().setName(name).build();
    deleteJobTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteJobTriggerRequest request =
   *       DeleteJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   dlpServiceClient.deleteJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteJobTrigger(DeleteJobTriggerRequest request) {
    deleteJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn
   * more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteJobTriggerRequest request =
   *       DeleteJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dlpServiceClient.deleteJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable() {
    return stub.deleteJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the
   * trigger event to occur.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ActivateJobTriggerRequest request =
   *       ActivateJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   DlpJob response = dlpServiceClient.activateJobTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob activateJobTrigger(ActivateJobTriggerRequest request) {
    return activateJobTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the
   * trigger event to occur.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ActivateJobTriggerRequest request =
   *       ActivateJobTriggerRequest.newBuilder()
   *           .setName(
   *               JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
   *           .build();
   *   ApiFuture<DlpJob> future = dlpServiceClient.activateJobTriggerCallable().futureCall(request);
   *   // Do something.
   *   DlpJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ActivateJobTriggerRequest, DlpJob> activateJobTriggerCallable() {
    return stub.activateJobTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, inspectJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectJob An inspection job scans a storage repository for InfoTypes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(LocationName parent, InspectJobConfig inspectJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectJob(inspectJob)
            .build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, riskJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param riskJob A risk analysis job calculates re-identification risk metrics for a BigQuery
   *     table.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(LocationName parent, RiskAnalysisJobConfig riskJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRiskJob(riskJob)
            .build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, inspectJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectJob An inspection job scans a storage repository for InfoTypes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(ProjectName parent, InspectJobConfig inspectJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInspectJob(inspectJob)
            .build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, riskJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param riskJob A risk analysis job calculates re-identification risk metrics for a BigQuery
   *     table.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(ProjectName parent, RiskAnalysisJobConfig riskJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRiskJob(riskJob)
            .build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, inspectJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param inspectJob An inspection job scans a storage repository for InfoTypes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(String parent, InspectJobConfig inspectJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder().setParent(parent).setInspectJob(inspectJob).build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
   *   DlpJob response = dlpServiceClient.createDlpJob(parent, riskJob);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param riskJob A risk analysis job calculates re-identification risk metrics for a BigQuery
   *     table.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(String parent, RiskAnalysisJobConfig riskJob) {
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder().setParent(parent).setRiskJob(riskJob).build();
    return createDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateDlpJobRequest request =
   *       CreateDlpJobRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setJobId("jobId101296568")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   DlpJob response = dlpServiceClient.createDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob createDlpJob(CreateDlpJobRequest request) {
    return createDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new job to inspect storage or calculate risk metrics. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will
   * automatically choose what detectors to run. By default this may be all types, but may change
   * over time as detectors are updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateDlpJobRequest request =
   *       CreateDlpJobRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setJobId("jobId101296568")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<DlpJob> future = dlpServiceClient.createDlpJobCallable().futureCall(request);
   *   // Do something.
   *   DlpJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable() {
    return stub.createDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DlpJob element : dlpServiceClient.listDlpJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDlpJobsPagedResponse listDlpJobs(LocationName parent) {
    ListDlpJobsRequest request =
        ListDlpJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDlpJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (DlpJob element : dlpServiceClient.listDlpJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDlpJobsPagedResponse listDlpJobs(ProjectName parent) {
    ListDlpJobsRequest request =
        ListDlpJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDlpJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (DlpJob element : dlpServiceClient.listDlpJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDlpJobsPagedResponse listDlpJobs(String parent) {
    ListDlpJobsRequest request = ListDlpJobsRequest.newBuilder().setParent(parent).build();
    return listDlpJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDlpJobsRequest request =
   *       ListDlpJobsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setType(DlpJobType.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   for (DlpJob element : dlpServiceClient.listDlpJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDlpJobsPagedResponse listDlpJobs(ListDlpJobsRequest request) {
    return listDlpJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDlpJobsRequest request =
   *       ListDlpJobsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setType(DlpJobType.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<DlpJob> future = dlpServiceClient.listDlpJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DlpJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse>
      listDlpJobsPagedCallable() {
    return stub.listDlpJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DlpJobs that match the specified filter in the request. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListDlpJobsRequest request =
   *       ListDlpJobsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setType(DlpJobType.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable() {
    return stub.listDlpJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running DlpJob. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
   *   DlpJob response = dlpServiceClient.getDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DlpJob resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob getDlpJob(DlpJobName name) {
    GetDlpJobRequest request =
        GetDlpJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running DlpJob. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString();
   *   DlpJob response = dlpServiceClient.getDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DlpJob resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob getDlpJob(String name) {
    GetDlpJobRequest request = GetDlpJobRequest.newBuilder().setName(name).build();
    return getDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running DlpJob. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetDlpJobRequest request =
   *       GetDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   DlpJob response = dlpServiceClient.getDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DlpJob getDlpJob(GetDlpJobRequest request) {
    return getDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest state of a long-running DlpJob. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetDlpJobRequest request =
   *       GetDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   ApiFuture<DlpJob> future = dlpServiceClient.getDlpJobCallable().futureCall(request);
   *   // Do something.
   *   DlpJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable() {
    return stub.getDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be canceled if possible. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
   *   dlpServiceClient.deleteDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DlpJob resource to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDlpJob(DlpJobName name) {
    DeleteDlpJobRequest request =
        DeleteDlpJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be canceled if possible. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString();
   *   dlpServiceClient.deleteDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DlpJob resource to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDlpJob(String name) {
    DeleteDlpJobRequest request = DeleteDlpJobRequest.newBuilder().setName(name).build();
    deleteDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be canceled if possible. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteDlpJobRequest request =
   *       DeleteDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   dlpServiceClient.deleteDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDlpJob(DeleteDlpJobRequest request) {
    deleteDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a long-running DlpJob. This method indicates that the client is no longer interested in
   * the DlpJob result. The job will be canceled if possible. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteDlpJobRequest request =
   *       DeleteDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dlpServiceClient.deleteDlpJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable() {
    return stub.deleteDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to
   * cancel the DlpJob, but success is not guaranteed. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CancelDlpJobRequest request =
   *       CancelDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   dlpServiceClient.cancelDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelDlpJob(CancelDlpJobRequest request) {
    cancelDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to
   * cancel the DlpJob, but success is not guaranteed. See
   * https://cloud.google.com/dlp/docs/inspecting-storage and
   * https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CancelDlpJobRequest request =
   *       CancelDlpJobRequest.newBuilder()
   *           .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dlpServiceClient.cancelDlpJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable() {
    return stub.cancelDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(parent, config);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param config Required. Configuration of the storedInfoType to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(
      LocationName parent, StoredInfoTypeConfig config) {
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfig(config)
            .build();
    return createStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(parent, config);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param config Required. Configuration of the storedInfoType to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(
      OrganizationLocationName parent, StoredInfoTypeConfig config) {
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfig(config)
            .build();
    return createStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(parent, config);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param config Required. Configuration of the storedInfoType to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(
      OrganizationName parent, StoredInfoTypeConfig config) {
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfig(config)
            .build();
    return createStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(parent, config);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param config Required. Configuration of the storedInfoType to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(
      ProjectName parent, StoredInfoTypeConfig config) {
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfig(config)
            .build();
    return createStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(parent, config);
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt; + Organizations scope, location
   *     specified:&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Organizations scope, no location specified (defaults to global):&lt;br/&gt;
   *     `organizations/`&lt;var&gt;ORG_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @param config Required. Configuration of the storedInfoType to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(String parent, StoredInfoTypeConfig config) {
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder().setParent(parent).setConfig(config).build();
    return createStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateStoredInfoTypeRequest request =
   *       CreateStoredInfoTypeRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setConfig(StoredInfoTypeConfig.newBuilder().build())
   *           .setStoredInfoTypeId("storedInfoTypeId-1409591226")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   StoredInfoType response = dlpServiceClient.createStoredInfoType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType createStoredInfoType(CreateStoredInfoTypeRequest request) {
    return createStoredInfoTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a pre-built stored infoType to be used for inspection. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   CreateStoredInfoTypeRequest request =
   *       CreateStoredInfoTypeRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setConfig(StoredInfoTypeConfig.newBuilder().build())
   *           .setStoredInfoTypeId("storedInfoTypeId-1409591226")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<StoredInfoType> future =
   *       dlpServiceClient.createStoredInfoTypeCallable().futureCall(request);
   *   // Do something.
   *   StoredInfoType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeCallable() {
    return stub.createStoredInfoTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the stored infoType by creating a new version. The existing version will continue to be
   * used until the new version is ready. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   StoredInfoTypeName name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *           "[ORGANIZATION]", "[STORED_INFO_TYPE]");
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.updateStoredInfoType(name, config, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and storedInfoType to be updated, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @param config Updated configuration for the storedInfoType. If not provided, a new version of
   *     the storedInfoType will be created with the existing configuration.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType updateStoredInfoType(
      StoredInfoTypeName name, StoredInfoTypeConfig config, FieldMask updateMask) {
    UpdateStoredInfoTypeRequest request =
        UpdateStoredInfoTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setConfig(config)
            .setUpdateMask(updateMask)
            .build();
    return updateStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the stored infoType by creating a new version. The existing version will continue to be
   * used until the new version is ready. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *               "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *           .toString();
   *   StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   StoredInfoType response = dlpServiceClient.updateStoredInfoType(name, config, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of organization and storedInfoType to be updated, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @param config Updated configuration for the storedInfoType. If not provided, a new version of
   *     the storedInfoType will be created with the existing configuration.
   * @param updateMask Mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType updateStoredInfoType(
      String name, StoredInfoTypeConfig config, FieldMask updateMask) {
    UpdateStoredInfoTypeRequest request =
        UpdateStoredInfoTypeRequest.newBuilder()
            .setName(name)
            .setConfig(config)
            .setUpdateMask(updateMask)
            .build();
    return updateStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the stored infoType by creating a new version. The existing version will continue to be
   * used until the new version is ready. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateStoredInfoTypeRequest request =
   *       UpdateStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .setConfig(StoredInfoTypeConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   StoredInfoType response = dlpServiceClient.updateStoredInfoType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType updateStoredInfoType(UpdateStoredInfoTypeRequest request) {
    return updateStoredInfoTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the stored infoType by creating a new version. The existing version will continue to be
   * used until the new version is ready. See
   * https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   UpdateStoredInfoTypeRequest request =
   *       UpdateStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .setConfig(StoredInfoTypeConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<StoredInfoType> future =
   *       dlpServiceClient.updateStoredInfoTypeCallable().futureCall(request);
   *   // Do something.
   *   StoredInfoType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeCallable() {
    return stub.updateStoredInfoTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   StoredInfoTypeName name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *           "[ORGANIZATION]", "[STORED_INFO_TYPE]");
   *   StoredInfoType response = dlpServiceClient.getStoredInfoType(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and storedInfoType to be read, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType getStoredInfoType(StoredInfoTypeName name) {
    GetStoredInfoTypeRequest request =
        GetStoredInfoTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *               "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *           .toString();
   *   StoredInfoType response = dlpServiceClient.getStoredInfoType(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and storedInfoType to be read, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType getStoredInfoType(String name) {
    GetStoredInfoTypeRequest request = GetStoredInfoTypeRequest.newBuilder().setName(name).build();
    return getStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetStoredInfoTypeRequest request =
   *       GetStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .build();
   *   StoredInfoType response = dlpServiceClient.getStoredInfoType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoredInfoType getStoredInfoType(GetStoredInfoTypeRequest request) {
    return getStoredInfoTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   GetStoredInfoTypeRequest request =
   *       GetStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<StoredInfoType> future =
   *       dlpServiceClient.getStoredInfoTypeCallable().futureCall(request);
   *   // Do something.
   *   StoredInfoType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeCallable() {
    return stub.getStoredInfoTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(LocationName parent) {
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStoredInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(
      OrganizationLocationName parent) {
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStoredInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(OrganizationName parent) {
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStoredInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(ProjectName parent) {
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStoredInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   *     <p>The format of this value varies depending on the scope of the request (project or
   *     organization) and whether you have [specified a processing
   *     location](https://cloud.google.com/dlp/docs/specifying-location):
   *     <p>+ Projects scope, location specified:&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;`/locations/`&lt;var&gt;LOCATION_ID&lt;/var&gt;
   *     + Projects scope, no location specified (defaults to global):&lt;br/&gt;
   *     `projects/`&lt;var&gt;PROJECT_ID&lt;/var&gt;
   *     <p>The following example `parent` string specifies a parent project with the identifier
   *     `example-project`, and specifies the `europe-west3` location for processing data:
   *     <p>parent=projects/example-project/locations/europe-west3
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(String parent) {
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder().setParent(parent).build();
    return listStoredInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListStoredInfoTypesRequest request =
   *       ListStoredInfoTypesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   for (StoredInfoType element : dlpServiceClient.listStoredInfoTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoredInfoTypesPagedResponse listStoredInfoTypes(
      ListStoredInfoTypesRequest request) {
    return listStoredInfoTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListStoredInfoTypesRequest request =
   *       ListStoredInfoTypesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   ApiFuture<StoredInfoType> future =
   *       dlpServiceClient.listStoredInfoTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StoredInfoType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesPagedCallable() {
    return stub.listStoredInfoTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ListStoredInfoTypesRequest request =
   *       ListStoredInfoTypesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .setOrderBy("orderBy-1207110587")
   *           .setLocationId("locationId1541836720")
   *           .build();
   *   while (true) {
   *     ListStoredInfoTypesResponse response =
   *         dlpServiceClient.listStoredInfoTypesCallable().call(request);
   *     for (StoredInfoType element : response.getStoredInfoTypesList()) {
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
  public final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesCallable() {
    return stub.listStoredInfoTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   StoredInfoTypeName name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *           "[ORGANIZATION]", "[STORED_INFO_TYPE]");
   *   dlpServiceClient.deleteStoredInfoType(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and storedInfoType to be deleted, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStoredInfoType(StoredInfoTypeName name) {
    DeleteStoredInfoTypeRequest request =
        DeleteStoredInfoTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name =
   *       StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *               "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *           .toString();
   *   dlpServiceClient.deleteStoredInfoType(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the organization and storedInfoType to be deleted, for
   *     example `organizations/433245324/storedInfoTypes/432452342` or
   *     projects/project-id/storedInfoTypes/432452342.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStoredInfoType(String name) {
    DeleteStoredInfoTypeRequest request =
        DeleteStoredInfoTypeRequest.newBuilder().setName(name).build();
    deleteStoredInfoType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteStoredInfoTypeRequest request =
   *       DeleteStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .build();
   *   dlpServiceClient.deleteStoredInfoType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStoredInfoType(DeleteStoredInfoTypeRequest request) {
    deleteStoredInfoTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
   * learn more.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeleteStoredInfoTypeRequest request =
   *       DeleteStoredInfoTypeRequest.newBuilder()
   *           .setName(
   *               StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
   *                       "[ORGANIZATION]", "[STORED_INFO_TYPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dlpServiceClient.deleteStoredInfoTypeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeCallable() {
    return stub.deleteStoredInfoTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a job. To review the findings, inspect the job.
   * Inspection will occur asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DlpJobName name =
   *       DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]");
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the job to execute a hybrid inspect on, for example
   *     `projects/dlp-test-project/dlpJob/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectDlpJob(DlpJobName name) {
    HybridInspectDlpJobRequest request =
        HybridInspectDlpJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return hybridInspectDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a job. To review the findings, inspect the job.
   * Inspection will occur asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString();
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectDlpJob(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the job to execute a hybrid inspect on, for example
   *     `projects/dlp-test-project/dlpJob/53234423`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectDlpJob(String name) {
    HybridInspectDlpJobRequest request =
        HybridInspectDlpJobRequest.newBuilder().setName(name).build();
    return hybridInspectDlpJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a job. To review the findings, inspect the job.
   * Inspection will occur asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   HybridInspectDlpJobRequest request =
   *       HybridInspectDlpJobRequest.newBuilder()
   *           .setName(
   *               DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
   *                   .toString())
   *           .setHybridItem(HybridContentItem.newBuilder().build())
   *           .build();
   *   HybridInspectResponse response = dlpServiceClient.hybridInspectDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HybridInspectResponse hybridInspectDlpJob(HybridInspectDlpJobRequest request) {
    return hybridInspectDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inspect hybrid content and store findings to a job. To review the findings, inspect the job.
   * Inspection will occur asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   HybridInspectDlpJobRequest request =
   *       HybridInspectDlpJobRequest.newBuilder()
   *           .setName(
   *               DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
   *                   .toString())
   *           .setHybridItem(HybridContentItem.newBuilder().build())
   *           .build();
   *   ApiFuture<HybridInspectResponse> future =
   *       dlpServiceClient.hybridInspectDlpJobCallable().futureCall(request);
   *   // Do something.
   *   HybridInspectResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable() {
    return stub.hybridInspectDlpJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finish a running hybrid DlpJob. Triggers the finalization steps and running of any enabled
   * actions that have not yet run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   FinishDlpJobRequest request =
   *       FinishDlpJobRequest.newBuilder()
   *           .setName(
   *               DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
   *                   .toString())
   *           .build();
   *   dlpServiceClient.finishDlpJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void finishDlpJob(FinishDlpJobRequest request) {
    finishDlpJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finish a running hybrid DlpJob. Triggers the finalization steps and running of any enabled
   * actions that have not yet run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   FinishDlpJobRequest request =
   *       FinishDlpJobRequest.newBuilder()
   *           .setName(
   *               DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dlpServiceClient.finishDlpJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable() {
    return stub.finishDlpJobCallable();
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

  public static class ListInspectTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          InspectTemplate,
          ListInspectTemplatesPage,
          ListInspectTemplatesFixedSizeCollection> {

    public static ApiFuture<ListInspectTemplatesPagedResponse> createAsync(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ApiFuture<ListInspectTemplatesResponse> futureResponse) {
      ApiFuture<ListInspectTemplatesPage> futurePage =
          ListInspectTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInspectTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInspectTemplatesPagedResponse(ListInspectTemplatesPage page) {
      super(page, ListInspectTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInspectTemplatesPage
      extends AbstractPage<
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          InspectTemplate,
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
          ListInspectTemplatesRequest,
          ListInspectTemplatesResponse,
          InspectTemplate,
          ListInspectTemplatesPage,
          ListInspectTemplatesFixedSizeCollection> {

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
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          DeidentifyTemplate,
          ListDeidentifyTemplatesPage,
          ListDeidentifyTemplatesFixedSizeCollection> {

    public static ApiFuture<ListDeidentifyTemplatesPagedResponse> createAsync(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
      ApiFuture<ListDeidentifyTemplatesPage> futurePage =
          ListDeidentifyTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeidentifyTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeidentifyTemplatesPagedResponse(ListDeidentifyTemplatesPage page) {
      super(page, ListDeidentifyTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeidentifyTemplatesPage
      extends AbstractPage<
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          DeidentifyTemplate,
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
          ListDeidentifyTemplatesRequest,
          ListDeidentifyTemplatesResponse,
          DeidentifyTemplate,
          ListDeidentifyTemplatesPage,
          ListDeidentifyTemplatesFixedSizeCollection> {

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

  public static class ListJobTriggersPagedResponse
      extends AbstractPagedListResponse<
          ListJobTriggersRequest,
          ListJobTriggersResponse,
          JobTrigger,
          ListJobTriggersPage,
          ListJobTriggersFixedSizeCollection> {

    public static ApiFuture<ListJobTriggersPagedResponse> createAsync(
        PageContext<ListJobTriggersRequest, ListJobTriggersResponse, JobTrigger> context,
        ApiFuture<ListJobTriggersResponse> futureResponse) {
      ApiFuture<ListJobTriggersPage> futurePage =
          ListJobTriggersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListJobTriggersPagedResponse(input),
          MoreExecutors.directExecutor());
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
          ListJobTriggersRequest,
          ListJobTriggersResponse,
          JobTrigger,
          ListJobTriggersPage,
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

  public static class ListDlpJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDlpJobsRequest,
          ListDlpJobsResponse,
          DlpJob,
          ListDlpJobsPage,
          ListDlpJobsFixedSizeCollection> {

    public static ApiFuture<ListDlpJobsPagedResponse> createAsync(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ApiFuture<ListDlpJobsResponse> futureResponse) {
      ApiFuture<ListDlpJobsPage> futurePage =
          ListDlpJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListDlpJobsPagedResponse(input), MoreExecutors.directExecutor());
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
          ListDlpJobsRequest,
          ListDlpJobsResponse,
          DlpJob,
          ListDlpJobsPage,
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

  public static class ListStoredInfoTypesPagedResponse
      extends AbstractPagedListResponse<
          ListStoredInfoTypesRequest,
          ListStoredInfoTypesResponse,
          StoredInfoType,
          ListStoredInfoTypesPage,
          ListStoredInfoTypesFixedSizeCollection> {

    public static ApiFuture<ListStoredInfoTypesPagedResponse> createAsync(
        PageContext<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
            context,
        ApiFuture<ListStoredInfoTypesResponse> futureResponse) {
      ApiFuture<ListStoredInfoTypesPage> futurePage =
          ListStoredInfoTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListStoredInfoTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListStoredInfoTypesPagedResponse(ListStoredInfoTypesPage page) {
      super(page, ListStoredInfoTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStoredInfoTypesPage
      extends AbstractPage<
          ListStoredInfoTypesRequest,
          ListStoredInfoTypesResponse,
          StoredInfoType,
          ListStoredInfoTypesPage> {

    private ListStoredInfoTypesPage(
        PageContext<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
            context,
        ListStoredInfoTypesResponse response) {
      super(context, response);
    }

    private static ListStoredInfoTypesPage createEmptyPage() {
      return new ListStoredInfoTypesPage(null, null);
    }

    @Override
    protected ListStoredInfoTypesPage createPage(
        PageContext<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
            context,
        ListStoredInfoTypesResponse response) {
      return new ListStoredInfoTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListStoredInfoTypesPage> createPageAsync(
        PageContext<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse, StoredInfoType>
            context,
        ApiFuture<ListStoredInfoTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStoredInfoTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStoredInfoTypesRequest,
          ListStoredInfoTypesResponse,
          StoredInfoType,
          ListStoredInfoTypesPage,
          ListStoredInfoTypesFixedSizeCollection> {

    private ListStoredInfoTypesFixedSizeCollection(
        List<ListStoredInfoTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStoredInfoTypesFixedSizeCollection createEmptyCollection() {
      return new ListStoredInfoTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStoredInfoTypesFixedSizeCollection createCollection(
        List<ListStoredInfoTypesPage> pages, int collectionSize) {
      return new ListStoredInfoTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
