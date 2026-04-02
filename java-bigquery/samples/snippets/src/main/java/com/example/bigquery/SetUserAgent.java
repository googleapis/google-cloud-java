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

package com.example.bigquery;

// [START bigquery_set_user_agent]
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;

public class SetUserAgent {

  private static final String USER_AGENT_HEADER = "user-agent";

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String customUserAgentValue = "my-custom-user-agent-value";
    setUserAgent(projectId, customUserAgentValue);
  }

  public static void setUserAgent(String projectId, String customUserAgentValue)
      throws IOException {
    // Setup the credentials
    GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();

    // Initialize the HeaderProvider object with custom user agent value
    HeaderProvider headerProvider =
        FixedHeaderProvider.create(ImmutableMap.of(USER_AGENT_HEADER, customUserAgentValue));

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    BigQuery bigQuery =
        BigQueryOptions.newBuilder()
            .setProjectId(projectId)
            .setCredentials(googleCredentials)
            .setHeaderProvider(headerProvider)
            .build()
            .getService();

    System.out.println(bigQuery.getOptions().getUserAgent());
  }
}
// [END bigquery_set_user_agent]
