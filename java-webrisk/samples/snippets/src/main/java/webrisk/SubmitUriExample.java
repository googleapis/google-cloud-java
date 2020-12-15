/*
 * Copyright 2020 Google LLC
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

package webrisk;

import com.google.cloud.webrisk.v1.WebRiskServiceClient;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.Submission;
import java.io.IOException;

public class SubmitUriExample {

  public static void submitUriExample() throws IOException {
    //The URL to be submitted
    String uri = "http://testsafebrowsing.appspot.com/s/malware.html";
    Submission response = submitUriExample(uri);
  }

  // [START webrisk_submit_uri]
  public static Submission submitUriExample(String uri) throws IOException {
    //create-webrisk-client
    try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
      Submission submission = Submission.newBuilder()
          .setUri(uri).build();
      CreateSubmissionRequest submissionRequest = CreateSubmissionRequest.newBuilder()
          .setParent("projects/your-project-id").setSubmission(submission).build();
      Submission submissionResponse = webRiskServiceClient.createSubmission(submissionRequest);
      webRiskServiceClient.shutdownNow();
      System.out.println("The submitted " + submissionResponse);
      return submissionResponse;
    }

  }
  // [END webrisk_submit_uri]
}
