/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package recaptcha;

// [START recaptcha_enterprise_annotate_assessment]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.Annotation;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.Reason;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.AssessmentName;
import java.io.IOException;

public class AnnotateAssessment {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "project-id";
    String assessmentId = "assessment-id";
    annotateAssessment(projectID, assessmentId);
  }

  /**
   * Pre-requisite: Create an assessment before annotating.
   *
   * <p>Annotate an assessment to provide feedback on the correctness of recaptcha prediction.
   *
   * @param projectID: GCloud Project id
   * @param assessmentId: Value of the 'name' field returned from the CreateAssessment call.
   */
  public static void annotateAssessment(String projectID, String assessmentId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {
      // Build the annotation request.
      // For more info on when/how to annotate, see:
      // https://cloud.google.com/recaptcha-enterprise/docs/annotate-assessment#when_to_annotate
      AnnotateAssessmentRequest annotateAssessmentRequest =
          AnnotateAssessmentRequest.newBuilder()
              .setName(AssessmentName.of(projectID, assessmentId).toString())
              .setAnnotation(Annotation.FRAUDULENT)
              .addReasons(Reason.FAILED_TWO_FACTOR)
              .build();

      // Empty response is sent back.
      AnnotateAssessmentResponse response = client.annotateAssessment(annotateAssessmentRequest);
      System.out.println("Annotated response sent successfully ! " + response);
    }
  }
}
// [END recaptcha_enterprise_annotate_assessment]
