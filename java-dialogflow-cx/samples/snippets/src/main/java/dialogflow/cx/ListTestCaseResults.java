/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dialogflow.cx;

// [START dialogflow_cx_list_testcase_result_sample]

import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsRequest.Builder;
import com.google.cloud.dialogflow.cx.v3.TestCaseResult;
import com.google.cloud.dialogflow.cx.v3.TestCasesClient;
import com.google.cloud.dialogflow.cx.v3.TestCasesSettings;
import java.io.IOException;

public class ListTestCaseResults {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String agentId = "my-agent-id";
    String testId = "my-test-id";
    String location = "my-location";
    listTestCaseResults(projectId, agentId, testId, location);
  }

  public static void listTestCaseResults(
      String projectId, String agentId, String testId, String location) throws IOException {
    String parent =
        "projects/"
            + projectId
            + "/locations/"
            + location
            + "/agents/"
            + agentId
            + "/testCases/"
            + testId;

    Builder req = ListTestCaseResultsRequest.newBuilder();

    req.setParent(parent);
    req.setFilter("environment=draft");

    TestCasesSettings testCasesSettings =
        TestCasesSettings.newBuilder()
            .setEndpoint(location + "-dialogflow.googleapis.com:443")
            .build();

    // Note: close() needs to be called on the TestCasesClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (TestCasesClient client = TestCasesClient.create(testCasesSettings)) {
      for (TestCaseResult element : client.listTestCaseResults(req.build()).iterateAll()) {
        System.out.println(element);
      }
    }
  }
}
// [END dialogflow_cx_list_testcase_result_sample]
