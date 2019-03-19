/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.talent.v4beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.stub.ResumeServiceStub;
import com.google.cloud.talent.v4beta1.stub.ResumeServiceStubSettings;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: A service that handles resume parsing.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ResumeServiceClient resumeServiceClient = ResumeServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   ByteString resume = ByteString.copyFromUtf8("");
 *   ParseResumeResponse response = resumeServiceClient.parseResume(parent, resume);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the resumeServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ResumeServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ResumeServiceSettings resumeServiceSettings =
 *     ResumeServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ResumeServiceClient resumeServiceClient =
 *     ResumeServiceClient.create(resumeServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ResumeServiceSettings resumeServiceSettings =
 *     ResumeServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ResumeServiceClient resumeServiceClient =
 *     ResumeServiceClient.create(resumeServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ResumeServiceClient implements BackgroundResource {
  private final ResumeServiceSettings settings;
  private final ResumeServiceStub stub;

  /** Constructs an instance of ResumeServiceClient with default settings. */
  public static final ResumeServiceClient create() throws IOException {
    return create(ResumeServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ResumeServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ResumeServiceClient create(ResumeServiceSettings settings)
      throws IOException {
    return new ResumeServiceClient(settings);
  }

  /**
   * Constructs an instance of ResumeServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ResumeServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ResumeServiceClient create(ResumeServiceStub stub) {
    return new ResumeServiceClient(stub);
  }

  /**
   * Constructs an instance of ResumeServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ResumeServiceClient(ResumeServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ResumeServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ResumeServiceClient(ResumeServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ResumeServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ResumeServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The API attempts to fill
   * out the following profile fields if present within the resume:
   *
   * <p>&#42; personNames &#42; addresses &#42; emailAddress &#42; phoneNumbers &#42; personalUris
   * &#42; employmentRecords &#42; educationRecords &#42; skills
   *
   * <p>Note that some attributes in these fields may not be populated if they're not present within
   * the resume or unrecognizable by the resume parser.
   *
   * <p>This API does not save the resume or profile. To create a profile from this resume, clients
   * need to call the CreateProfile method again with the profile returned.
   *
   * <p>The following list of formats are supported:
   *
   * <p>&#42; PDF &#42; TXT &#42; DOC &#42; RTF &#42; DOCX &#42; PNG (only when
   * [ParseResumeRequest.enable_ocr][] is set to `true`, otherwise an error is thrown)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResumeServiceClient resumeServiceClient = ResumeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ByteString resume = ByteString.copyFromUtf8("");
   *   ParseResumeResponse response = resumeServiceClient.parseResume(parent, resume);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param resume Required.
   *     <p>The bytes of the resume file in common format, for example, PDF, TXT. UTF-8 encoding is
   *     required if the resume is text-based, otherwise an error is thrown.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParseResumeResponse parseResume(ProjectName parent, ByteString resume) {

    ParseResumeRequest request =
        ParseResumeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResume(resume)
            .build();
    return parseResume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The API attempts to fill
   * out the following profile fields if present within the resume:
   *
   * <p>&#42; personNames &#42; addresses &#42; emailAddress &#42; phoneNumbers &#42; personalUris
   * &#42; employmentRecords &#42; educationRecords &#42; skills
   *
   * <p>Note that some attributes in these fields may not be populated if they're not present within
   * the resume or unrecognizable by the resume parser.
   *
   * <p>This API does not save the resume or profile. To create a profile from this resume, clients
   * need to call the CreateProfile method again with the profile returned.
   *
   * <p>The following list of formats are supported:
   *
   * <p>&#42; PDF &#42; TXT &#42; DOC &#42; RTF &#42; DOCX &#42; PNG (only when
   * [ParseResumeRequest.enable_ocr][] is set to `true`, otherwise an error is thrown)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResumeServiceClient resumeServiceClient = ResumeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ByteString resume = ByteString.copyFromUtf8("");
   *   ParseResumeResponse response = resumeServiceClient.parseResume(parent.toString(), resume);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>The resource name of the project.
   *     <p>The format is "projects/{project_id}", for example, "projects/api-test-project".
   * @param resume Required.
   *     <p>The bytes of the resume file in common format, for example, PDF, TXT. UTF-8 encoding is
   *     required if the resume is text-based, otherwise an error is thrown.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParseResumeResponse parseResume(String parent, ByteString resume) {

    ParseResumeRequest request =
        ParseResumeRequest.newBuilder().setParent(parent).setResume(resume).build();
    return parseResume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The API attempts to fill
   * out the following profile fields if present within the resume:
   *
   * <p>&#42; personNames &#42; addresses &#42; emailAddress &#42; phoneNumbers &#42; personalUris
   * &#42; employmentRecords &#42; educationRecords &#42; skills
   *
   * <p>Note that some attributes in these fields may not be populated if they're not present within
   * the resume or unrecognizable by the resume parser.
   *
   * <p>This API does not save the resume or profile. To create a profile from this resume, clients
   * need to call the CreateProfile method again with the profile returned.
   *
   * <p>The following list of formats are supported:
   *
   * <p>&#42; PDF &#42; TXT &#42; DOC &#42; RTF &#42; DOCX &#42; PNG (only when
   * [ParseResumeRequest.enable_ocr][] is set to `true`, otherwise an error is thrown)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResumeServiceClient resumeServiceClient = ResumeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ByteString resume = ByteString.copyFromUtf8("");
   *   ParseResumeRequest request = ParseResumeRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setResume(resume)
   *     .build();
   *   ParseResumeResponse response = resumeServiceClient.parseResume(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParseResumeResponse parseResume(ParseResumeRequest request) {
    return parseResumeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Parses a resume into a [Profile][google.cloud.talent.v4beta1.Profile]. The API attempts to fill
   * out the following profile fields if present within the resume:
   *
   * <p>&#42; personNames &#42; addresses &#42; emailAddress &#42; phoneNumbers &#42; personalUris
   * &#42; employmentRecords &#42; educationRecords &#42; skills
   *
   * <p>Note that some attributes in these fields may not be populated if they're not present within
   * the resume or unrecognizable by the resume parser.
   *
   * <p>This API does not save the resume or profile. To create a profile from this resume, clients
   * need to call the CreateProfile method again with the profile returned.
   *
   * <p>The following list of formats are supported:
   *
   * <p>&#42; PDF &#42; TXT &#42; DOC &#42; RTF &#42; DOCX &#42; PNG (only when
   * [ParseResumeRequest.enable_ocr][] is set to `true`, otherwise an error is thrown)
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResumeServiceClient resumeServiceClient = ResumeServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ByteString resume = ByteString.copyFromUtf8("");
   *   ParseResumeRequest request = ParseResumeRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setResume(resume)
   *     .build();
   *   ApiFuture&lt;ParseResumeResponse&gt; future = resumeServiceClient.parseResumeCallable().futureCall(request);
   *   // Do something
   *   ParseResumeResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ParseResumeRequest, ParseResumeResponse> parseResumeCallable() {
    return stub.parseResumeCallable();
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
