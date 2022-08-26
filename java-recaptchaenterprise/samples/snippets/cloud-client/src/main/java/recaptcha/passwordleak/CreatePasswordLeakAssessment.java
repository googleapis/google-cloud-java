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

package passwordleak;

// [START recaptcha_enterprise_password_leak_verification]

import com.google.cloud.recaptcha.passwordcheck.PasswordCheckResult;
import com.google.cloud.recaptcha.passwordcheck.PasswordCheckVerification;
import com.google.cloud.recaptcha.passwordcheck.PasswordCheckVerifier;
import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.protobuf.ByteString;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.Event;
import com.google.recaptchaenterprise.v1.PrivatePasswordLeakVerification;
import com.google.recaptchaenterprise.v1.TokenProperties;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CreatePasswordLeakAssessment {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    // GCloud Project ID.
    String projectID = "project-id";

    // Site key obtained by registering a domain/app to use recaptcha Enterprise.
    String recaptchaSiteKey = "recaptcha-site-key";

    // The token obtained from the client on passing the recaptchaSiteKey.
    // To get the token, integrate the recaptchaSiteKey with frontend. See,
    // https://cloud.google.com/recaptcha-enterprise/docs/instrument-web-pages#frontend_integration_score
    String token = "recaptcha-token";

    // Action name corresponding to the token.
    String recaptchaAction = "recaptcha-action";

    checkPasswordLeak(projectID, recaptchaSiteKey, token, recaptchaAction);
  }

  /*
  * Detect password leaks and breached credentials to prevent account takeovers (ATOs)
  * and credential stuffing attacks.
  * For more information, see: https://cloud.google.com/recaptcha-enterprise/docs/getting-started
  * and https://security.googleblog.com/2019/02/protect-your-accounts-from-data.html

  * Steps:
  * 1. Use the 'createVerification' method to hash and Encrypt the hashed username and password.
  * 2. Send the hash prefix (2-byte) and the encrypted credentials to create the assessment.
  * (Hash prefix is used to partition the database.)
  * 3. Password leak assessment returns a database whose prefix matches the sent hash prefix.
  * Create Assessment also sends back re-encrypted credentials.
  * 4. The re-encrypted credential is then locally verified to see if there is a
  * match in the database.
  *
  * To perform hashing, encryption and verification (steps 1, 2 and 4),
  * reCAPTCHA Enterprise provides a helper library in Java.
  * See, https://github.com/GoogleCloudPlatform/java-recaptcha-password-check-helpers

  * If you want to extend this behavior to your own implementation/ languages,
  * make sure to perform the following steps:
  * 1. Hash the credentials (First 2 bytes of the result is the 'lookupHashPrefix')
  * 2. Encrypt the hash (result = 'encryptedUserCredentialsHash')
  * 3. Get back the PasswordLeak information from reCAPTCHA Enterprise Create Assessment.
  * 4. Decrypt the obtained 'credentials.getReencryptedUserCredentialsHash()'
  * with the same key you used for encryption.
  * 5. Check if the decrypted credentials are present in 'credentials.getEncryptedLeakMatchPrefixesList()'.
  * 6. If there is a match, that indicates a credential breach.
  */
  public static void checkPasswordLeak(
      String projectID, String recaptchaSiteKey, String token, String recaptchaAction)
      throws ExecutionException, InterruptedException, IOException {
    // Set the username and password to be checked.
    String username = "username";
    String password = "password123";

    // Instantiate the java-password-leak-helper library to perform the cryptographic functions.
    PasswordCheckVerifier passwordLeak = new PasswordCheckVerifier();

    // Create the request to obtain the hash prefix and encrypted credentials.
    PasswordCheckVerification verification =
        passwordLeak.createVerification(username, password).get();

    byte[] lookupHashPrefix = verification.getLookupHashPrefix();
    byte[] encryptedUserCredentialsHash = verification.getEncryptedLookupHash();

    // Pass the credentials to the createPasswordLeakAssessment() to get back
    // the matching database entry for the hash prefix.
    PrivatePasswordLeakVerification credentials =
        createPasswordLeakAssessment(
            projectID,
            recaptchaSiteKey,
            token,
            recaptchaAction,
            lookupHashPrefix,
            encryptedUserCredentialsHash);

    // Convert to appropriate input format.
    List<byte[]> leakMatchPrefixes =
        credentials.getEncryptedLeakMatchPrefixesList().stream()
            .map(ByteString::toByteArray)
            .collect(Collectors.toList());

    // Verify if the encrypted credentials are present in the obtained match list.
    PasswordCheckResult result =
        passwordLeak
            .verify(
                verification,
                credentials.getReencryptedUserCredentialsHash().toByteArray(),
                leakMatchPrefixes)
            .get();

    // Check if the credential is leaked.
    boolean isLeaked = result.areCredentialsLeaked();
    System.out.printf("Is Credential leaked: %s", isLeaked);
  }

  // Create a reCAPTCHA Enterprise assessment.
  // Returns:  PrivatePasswordLeakVerification which contains
  // reencryptedUserCredentialsHash and credential breach database
  // whose prefix matches the lookupHashPrefix.
  private static PrivatePasswordLeakVerification createPasswordLeakAssessment(
      String projectID,
      String recaptchaSiteKey,
      String token,
      String recaptchaAction,
      byte[] lookupHashPrefix,
      byte[] encryptedUserCredentialsHash)
      throws IOException {
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Set the properties of the event to be tracked.
      Event event = Event.newBuilder().setSiteKey(recaptchaSiteKey).setToken(token).build();

      // Set the hashprefix and credentials hash.
      // Setting this will trigger the Password leak protection.
      PrivatePasswordLeakVerification passwordLeakVerification =
          PrivatePasswordLeakVerification.newBuilder()
              .setLookupHashPrefix(ByteString.copyFrom(lookupHashPrefix))
              .setEncryptedUserCredentialsHash(ByteString.copyFrom(encryptedUserCredentialsHash))
              .build();

      // Build the assessment request.
      CreateAssessmentRequest createAssessmentRequest =
          CreateAssessmentRequest.newBuilder()
              .setParent(String.format("projects/%s", projectID))
              .setAssessment(
                  Assessment.newBuilder()
                      .setEvent(event)
                      // Set request for Password leak verification.
                      .setPrivatePasswordLeakVerification(passwordLeakVerification)
                      .build())
              .build();

      // Send the create assessment request.
      Assessment response = client.createAssessment(createAssessmentRequest);

      // Check validity and integrity of the response.
      if (!checkTokenIntegrity(response.getTokenProperties(), recaptchaAction)) {
        return passwordLeakVerification;
      }

      // Get the reCAPTCHA Enterprise score.
      float recaptchaScore = response.getRiskAnalysis().getScore();
      System.out.println("The reCAPTCHA score is: " + recaptchaScore);

      // Get the assessment name (id). Use this to annotate the assessment.
      String assessmentName = response.getName();
      System.out.println(
          "Assessment name: " + assessmentName.substring(assessmentName.lastIndexOf("/") + 1));

      return response.getPrivatePasswordLeakVerification();
    }
  }

  // Check for token validity and action integrity.
  private static boolean checkTokenIntegrity(
      TokenProperties tokenProperties, String recaptchaAction) {
    // Check if the token is valid.
    if (!tokenProperties.getValid()) {
      System.out.println(
          "The Password check call failed because the token was: "
              + tokenProperties.getInvalidReason().name());
      return false;
    }

    // Check if the expected action was executed.
    if (!tokenProperties.getAction().equals(recaptchaAction)) {
      System.out.printf(
          "The action attribute in the reCAPTCHA tag '%s' does not match "
              + "the action '%s' you are expecting to score",
          tokenProperties.getAction(), recaptchaAction);
      return false;
    }
    return true;
  }
}
// [END recaptcha_enterprise_password_leak_verification]
