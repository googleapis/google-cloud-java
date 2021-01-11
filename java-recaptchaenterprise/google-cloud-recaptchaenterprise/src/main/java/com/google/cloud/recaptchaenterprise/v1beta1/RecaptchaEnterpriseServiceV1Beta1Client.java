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

package com.google.cloud.recaptchaenterprise.v1beta1;

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
import com.google.cloud.recaptchaenterprise.v1beta1.stub.RecaptchaEnterpriseServiceV1Beta1Stub;
import com.google.cloud.recaptchaenterprise.v1beta1.stub.RecaptchaEnterpriseServiceV1Beta1StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.AssessmentName;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1beta1.GetKeyRequest;
import com.google.recaptchaenterprise.v1beta1.Key;
import com.google.recaptchaenterprise.v1beta1.ListKeysRequest;
import com.google.recaptchaenterprise.v1beta1.ListKeysResponse;
import com.google.recaptchaenterprise.v1beta1.ProjectName;
import com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to determine the likelihood an event is legitimate.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 * RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
 *     RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RecaptchaEnterpriseServiceV1Beta1Client(RecaptchaEnterpriseServiceV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RecaptchaEnterpriseServiceV1Beta1Settings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RecaptchaEnterpriseServiceV1Beta1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Assessment of the likelihood an event is legitimate.
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
   */
  public final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    return stub.createAssessmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Annotates a previously created Assessment to provide additional information on whether the
   * event turned out to be authentic or fradulent.
   *
   * @param name Required. The resource name of the Assessment, in the format
   *     "projects/{project_number}/assessments/{assessment_id}".
   * @param annotation Required. The annotation that will be assigned to the Event.
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
   * @param name Required. The resource name of the Assessment, in the format
   *     "projects/{project_number}/assessments/{assessment_id}".
   * @param annotation Required. The annotation that will be assigned to the Event.
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
   */
  public final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    return stub.annotateAssessmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reCAPTCHA Enterprise key.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key createKey(CreateKeyRequest request) {
    return createKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reCAPTCHA Enterprise key.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateKeyRequest, Key> createKeyCallable() {
    return stub.createKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all keys that belong to a project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeysPagedResponse listKeys(ListKeysRequest request) {
    return listKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all keys that belong to a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    return stub.listKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all keys that belong to a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    return stub.listKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified key.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key getKey(GetKeyRequest request) {
    return getKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified key.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    return stub.getKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified key.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Key updateKey(UpdateKeyRequest request) {
    return updateKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified key.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable() {
    return stub.updateKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified key.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKey(DeleteKeyRequest request) {
    deleteKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified key.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable() {
    return stub.deleteKeyCallable();
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

  public static class ListKeysPagedResponse
      extends AbstractPagedListResponse<
          ListKeysRequest, ListKeysResponse, Key, ListKeysPage, ListKeysFixedSizeCollection> {

    public static ApiFuture<ListKeysPagedResponse> createAsync(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context,
        ApiFuture<ListKeysResponse> futureResponse) {
      ApiFuture<ListKeysPage> futurePage =
          ListKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListKeysPage, ListKeysPagedResponse>() {
            @Override
            public ListKeysPagedResponse apply(ListKeysPage input) {
              return new ListKeysPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListKeysPagedResponse(ListKeysPage page) {
      super(page, ListKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKeysPage
      extends AbstractPage<ListKeysRequest, ListKeysResponse, Key, ListKeysPage> {

    private ListKeysPage(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context, ListKeysResponse response) {
      super(context, response);
    }

    private static ListKeysPage createEmptyPage() {
      return new ListKeysPage(null, null);
    }

    @Override
    protected ListKeysPage createPage(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context, ListKeysResponse response) {
      return new ListKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListKeysPage> createPageAsync(
        PageContext<ListKeysRequest, ListKeysResponse, Key> context,
        ApiFuture<ListKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKeysRequest, ListKeysResponse, Key, ListKeysPage, ListKeysFixedSizeCollection> {

    private ListKeysFixedSizeCollection(List<ListKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKeysFixedSizeCollection createEmptyCollection() {
      return new ListKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKeysFixedSizeCollection createCollection(
        List<ListKeysPage> pages, int collectionSize) {
      return new ListKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
