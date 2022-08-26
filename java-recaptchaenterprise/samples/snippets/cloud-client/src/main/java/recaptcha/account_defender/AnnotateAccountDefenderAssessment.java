/*
 * Copyright 2022 Google LLC
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

package account_defender;

// [START recaptcha_enterprise_annotate_account_defender_assessment]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.protobuf.ByteString;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.Annotation;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.Reason;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.AssessmentName;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AnnotateAccountDefenderAssessment {

  public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
    // TODO(developer): Replace these variables before running the sample.
    // projectID: GCloud Project id.
    String projectID = "project-id";

    // assessmentId: Value of the 'name' field returned from the CreateAssessment call.
    String assessmentId = "account-defender-assessment-id";

    // hashedAccountId: Set the hashedAccountId corresponding to the assessment id.
    ByteString hashedAccountId = ByteString.copyFrom(new byte[] {});

    annotateAssessment(projectID, assessmentId, hashedAccountId);
  }

  /**
   * Pre-requisite: Create an assessment before annotating. Annotate an assessment to provide
   * feedback on the correctness of recaptcha prediction.
   */
  public static void annotateAssessment(
      String projectID, String assessmentId, ByteString hashedAccountId) throws IOException {

    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {
      // Build the annotation request.
      // For more info on when/how to annotate, see:
      // https://cloud.google.com/recaptcha-enterprise/docs/annotate-assessment#when_to_annotate
      AnnotateAssessmentRequest annotateAssessmentRequest =
          AnnotateAssessmentRequest.newBuilder()
              .setName(AssessmentName.of(projectID, assessmentId).toString())
              .setAnnotation(Annotation.LEGITIMATE)
              .addReasons(Reason.PASSED_TWO_FACTOR)
              .setHashedAccountId(hashedAccountId)
              .build();

      // Empty response is sent back.
      AnnotateAssessmentResponse response = client.annotateAssessment(annotateAssessmentRequest);
      System.out.println("Annotated response sent successfully ! " + response);
    }
  }
}
// [END recaptcha_enterprise_annotate_account_defender_assessment]
