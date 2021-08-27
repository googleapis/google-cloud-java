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

// [START recaptcha_enterprise_create_assessment]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.Event;
import com.google.recaptchaenterprise.v1.ProjectName;
import com.google.recaptchaenterprise.v1.RiskAnalysis.ClassificationReason;
import java.io.IOException;

public class CreateAssessment {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectID = "project-id";
    String recaptchaSiteKey = "recaptcha-site-key";
    String token = "action-token";
    String recaptchaAction = "action-name";

    createAssessment(projectID, recaptchaSiteKey, token, recaptchaAction);
  }


  /**
   * Create an assessment to analyze the risk of an UI action.
   *
   * @param projectID : GCloud Project ID
   * @param recaptchaSiteKey : Site key obtained by registering a domain/app to use recaptcha
   * services.
   * @param token : The token obtained from the client on passing the recaptchaSiteKey.
   * @param recaptchaAction : Action name corresponding to the token.
   */
  public static void createAssessment(String projectID, String recaptchaSiteKey, String token,
      String recaptchaAction)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Specify a name for this assessment.
      String assessmentName = "assessment-name";
      // Set the properties of the event to be tracked.
      Event event = Event.newBuilder()
          .setSiteKey(recaptchaSiteKey)
          .setToken(token)
          .build();

      // Build the assessment request.
      CreateAssessmentRequest createAssessmentRequest = CreateAssessmentRequest.newBuilder()
          .setParent(ProjectName.of(projectID).toString())
          .setAssessment(Assessment.newBuilder().setEvent(event).setName(assessmentName).build())
          .build();

      Assessment response = client.createAssessment(createAssessmentRequest);

      // Check if the token is valid.
      if (!response.getTokenProperties().getValid()) {
        System.out.println("The CreateAssessment call failed because the token was: " +
            response.getTokenProperties().getInvalidReason().name());
        return;
      }

      // Check if the expected action was executed.
      if (!response.getTokenProperties().getAction().equals(recaptchaAction)) {
        System.out.println(
            "The action attribute in reCAPTCHA tag is: " + response.getTokenProperties()
                .getAction());
        System.out.println("The action attribute in the reCAPTCHA tag " +
            "does not match the action (" + recaptchaAction + ") you are expecting to score");
        return;
      }

      // Get the risk score and the reason(s).
      // For more information on interpreting the assessment,
      // see: https://cloud.google.com/recaptcha-enterprise/docs/interpret-assessment
      float recaptchaScore = response.getRiskAnalysis().getScore();
      System.out.println("The reCAPTCHA score is: " + recaptchaScore);

      for (ClassificationReason reason : response.getRiskAnalysis().getReasonsList()) {
        System.out.println(reason);
      }
    }
  }
}
// [END recaptcha_enterprise_create_assessment]