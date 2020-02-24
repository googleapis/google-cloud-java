/*
 * Copyright 2020 Google LLC
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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_autocomplete_job_title")
// sample-metadata:
//   title:
//   description: Complete job title given partial text (autocomplete)
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchAutocompleteJobTitle [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using tenancy is optional)"] [--query "[partially typed job title]"] [--num_results 5] [--language_code "en-US"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse.CompletionResult;
import com.google.cloud.talent.v4beta1.CompletionClient;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchAutocompleteJobTitle {
  // [START job_search_autocomplete_job_title]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
   * import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
   * import com.google.cloud.talent.v4beta1.CompleteQueryResponse.CompletionResult;
   * import com.google.cloud.talent.v4beta1.CompletionClient;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleCompleteQuery() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String query = "[partially typed job title]";
    int numResults = 5;
    String languageCode = "en-US";
    sampleCompleteQuery(projectId, tenantId, query, numResults, languageCode);
  }

  /**
   * Complete job title given partial text (autocomplete)
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenantd
   */
  public static void sampleCompleteQuery(
      String projectId, String tenantId, String query, int numResults, String languageCode) {
    try (CompletionClient completionClient = CompletionClient.create()) {
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      List<String> languageCodes = Arrays.asList(languageCode);
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setParent(parent.toString())
              .setQuery(query)
              .setPageSize(numResults)
              .addAllLanguageCodes(languageCodes)
              .build();
      CompleteQueryResponse response = completionClient.completeQuery(request);
      for (CompleteQueryResponse.CompletionResult result : response.getCompletionResultsList()) {
        System.out.printf("Suggested title: %s\n", result.getSuggestion());
        // Suggestion type is JOB_TITLE or COMPANY_TITLE
        System.out.printf("Suggestion type: %s\n", result.getType());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_autocomplete_job_title]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("query").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("num_results").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("language_code").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String query = cl.getOptionValue("query", "[partially typed job title]");
    int numResults =
        cl.getOptionValue("num_results") != null
            ? Integer.parseInt(cl.getOptionValue("num_results"))
            : 5;
    String languageCode = cl.getOptionValue("language_code", "en-US");

    sampleCompleteQuery(projectId, tenantId, query, numResults, languageCode);
  }
}
