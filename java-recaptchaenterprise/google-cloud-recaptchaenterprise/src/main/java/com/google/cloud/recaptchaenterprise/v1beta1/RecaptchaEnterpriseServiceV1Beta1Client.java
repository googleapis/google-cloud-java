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

package com.google.cloud.recaptchaenterprise.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recaptchaenterprise.v1beta1.stub.RecaptchaEnterpriseServiceV1Beta1Stub;
import com.google.cloud.recaptchaenterprise.v1beta1.stub.RecaptchaEnterpriseServiceV1Beta1StubSettings;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.AssessmentName;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.ProjectName;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to determine the likelihood an event is legitimate.
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
 * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
 *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Assessment assessment = Assessment.newBuilder().build();
 *   Assessment response =
 *       recaptchaEnterpriseServiceV1Beta1Client.createAssessment(parent, assessment);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RecaptchaEnterpriseServiceV1Beta1Client object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
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
 * RecaptchaEnterpriseServiceV1Beta1Settings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
 *     RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
 *     RecaptchaEnterpriseServiceV1Beta1Client.create(recaptchaEnterpriseServiceV1Beta1Settings);
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
 * RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
 *     RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
 *     RecaptchaEnterpriseServiceV1Beta1Client.create(recaptchaEnterpriseServiceV1Beta1Settings);
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
 * RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
 *     RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder()
 *         .setTransportChannelProvider(
 *             RecaptchaEnterpriseServiceV1Beta1Settings.defaultHttpJsonTransportProviderBuilder()
 *                 .build())
 *         .build();
 * RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
 *     RecaptchaEnterpriseServiceV1Beta1Client.create(recaptchaEnterpriseServiceV1Beta1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RecaptchaEnterpriseServiceV1Beta1Client implements BackgroundResource {
  private final RecaptchaEnterpriseServiceV1Beta1Settings settings;
  private final RecaptchaEnterpriseServiceV1Beta1Stub stub;

  /** Constructs an instance of RecaptchaEnterpriseServiceV1Beta1Client with default settings. */
  public static final RecaptchaEnterpriseServiceV1Beta1Client create() throws IOException {
    return create(RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of RecaptchaEnterpriseServiceV1Beta1Client, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final RecaptchaEnterpriseServiceV1Beta1Client create(
      RecaptchaEnterpriseServiceV1Beta1Settings settings) throws IOException {
    return new RecaptchaEnterpriseServiceV1Beta1Client(settings);
  }

  /**
   * Constructs an instance of RecaptchaEnterpriseServiceV1Beta1Client, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(RecaptchaEnterpriseServiceV1Beta1Settings).
   */
  public static final RecaptchaEnterpriseServiceV1Beta1Client create(
      RecaptchaEnterpriseServiceV1Beta1Stub stub) {
    return new RecaptchaEnterpriseServiceV1Beta1Client(stub);
  }

  /**
   * Constructs an instance of RecaptchaEnterpriseServiceV1Beta1Client, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected RecaptchaEnterpriseServiceV1Beta1Client(
      RecaptchaEnterpriseServiceV1Beta1Settings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((RecaptchaEnterpriseServiceV1Beta1StubSettings) settings.getStubSettings()).createStub();
  }

  protected RecaptchaEnterpriseServiceV1Beta1Client(RecaptchaEnterpriseServiceV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RecaptchaEnterpriseServiceV1Beta1Settings getSettings() {
    return settings;
  }

  public RecaptchaEnterpriseServiceV1Beta1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Assessment of the likelihood an event is legitimate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Assessment assessment = Assessment.newBuilder().build();
   *   Assessment response =
   *       recaptchaEnterpriseServiceV1Beta1Client.createAssessment(parent, assessment);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which the assessment will be created, in the
   *     format "projects/{project_number}".
   * @param assessment Required. The assessment details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assessment createAssessment(ProjectName parent, Assessment assessment) {
    CreateAssessmentRequest request =
        CreateAssessmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAssessment(assessment)
            .build();
    return createAssessment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Assessment of the likelihood an event is legitimate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Assessment assessment = Assessment.newBuilder().build();
   *   Assessment response =
   *       recaptchaEnterpriseServiceV1Beta1Client.createAssessment(parent, assessment);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which the assessment will be created, in the
   *     format "projects/{project_number}".
   * @param assessment Required. The assessment details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assessment createAssessment(String parent, Assessment assessment) {
    CreateAssessmentRequest request =
        CreateAssessmentRequest.newBuilder().setParent(parent).setAssessment(assessment).build();
    return createAssessment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Assessment of the likelihood an event is legitimate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   CreateAssessmentRequest request =
   *       CreateAssessmentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setAssessment(Assessment.newBuilder().build())
   *           .build();
   *   Assessment response = recaptchaEnterpriseServiceV1Beta1Client.createAssessment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assessment createAssessment(CreateAssessmentRequest request) {
    return createAssessmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Assessment of the likelihood an event is legitimate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   CreateAssessmentRequest request =
   *       CreateAssessmentRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setAssessment(Assessment.newBuilder().build())
   *           .build();
   *   ApiFuture<Assessment> future =
   *       recaptchaEnterpriseServiceV1Beta1Client.createAssessmentCallable().futureCall(request);
   *   // Do something.
   *   Assessment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    return stub.createAssessmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Annotates a previously created Assessment to provide additional information on whether the
   * event turned out to be authentic or fradulent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
   *   AnnotateAssessmentRequest.Annotation annotation =
   *       AnnotateAssessmentRequest.Annotation.forNumber(0);
   *   AnnotateAssessmentResponse response =
   *       recaptchaEnterpriseServiceV1Beta1Client.annotateAssessment(name, annotation);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Assessment, in the format
   *     "projects/{project_number}/assessments/{assessment_id}".
   * @param annotation Optional. The annotation that will be assigned to the Event. This field can
   *     be left empty to provide reasons that apply to an event without concluding whether the
   *     event is legitimate or fraudulent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotateAssessmentResponse annotateAssessment(
      AssessmentName name, AnnotateAssessmentRequest.Annotation annotation) {
    AnnotateAssessmentRequest request =
        AnnotateAssessmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAnnotation(annotation)
            .build();
    return annotateAssessment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Annotates a previously created Assessment to provide additional information on whether the
   * event turned out to be authentic or fradulent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   String name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString();
   *   AnnotateAssessmentRequest.Annotation annotation =
   *       AnnotateAssessmentRequest.Annotation.forNumber(0);
   *   AnnotateAssessmentResponse response =
   *       recaptchaEnterpriseServiceV1Beta1Client.annotateAssessment(name, annotation);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Assessment, in the format
   *     "projects/{project_number}/assessments/{assessment_id}".
   * @param annotation Optional. The annotation that will be assigned to the Event. This field can
   *     be left empty to provide reasons that apply to an event without concluding whether the
   *     event is legitimate or fraudulent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotateAssessmentResponse annotateAssessment(
      String name, AnnotateAssessmentRequest.Annotation annotation) {
    AnnotateAssessmentRequest request =
        AnnotateAssessmentRequest.newBuilder().setName(name).setAnnotation(annotation).build();
    return annotateAssessment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Annotates a previously created Assessment to provide additional information on whether the
   * event turned out to be authentic or fradulent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   AnnotateAssessmentRequest request =
   *       AnnotateAssessmentRequest.newBuilder()
   *           .setName(AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString())
   *           .addAllReasons(new ArrayList<AnnotateAssessmentRequest.Reason>())
   *           .setHashedAccountId(ByteString.EMPTY)
   *           .build();
   *   AnnotateAssessmentResponse response =
   *       recaptchaEnterpriseServiceV1Beta1Client.annotateAssessment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotateAssessmentResponse annotateAssessment(AnnotateAssessmentRequest request) {
    return annotateAssessmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Annotates a previously created Assessment to provide additional information on whether the
   * event turned out to be authentic or fradulent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RecaptchaEnterpriseServiceV1Beta1Client recaptchaEnterpriseServiceV1Beta1Client =
   *     RecaptchaEnterpriseServiceV1Beta1Client.create()) {
   *   AnnotateAssessmentRequest request =
   *       AnnotateAssessmentRequest.newBuilder()
   *           .setName(AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString())
   *           .addAllReasons(new ArrayList<AnnotateAssessmentRequest.Reason>())
   *           .setHashedAccountId(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<AnnotateAssessmentResponse> future =
   *       recaptchaEnterpriseServiceV1Beta1Client.annotateAssessmentCallable().futureCall(request);
   *   // Do something.
   *   AnnotateAssessmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    return stub.annotateAssessmentCallable();
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
}
