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
// DO NOT EDIT! This is a generated sample ("RequestPaged",  "datacatalog_search")
// sample-metadata:
//   title:
//   description: Search Catalog
//   usage: gradle run -PmainClass=com.google.cloud.examples.datacatalog.v1beta1.DatacatalogSearch
// [--args='[--include_project_id "[Google Cloud Project ID]"] [--include_gcp_public_datasets false]
// [--query "[String in search query syntax]"]']

package com.google.cloud.examples.datacatalog.v1beta1;

import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogResult;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DatacatalogSearch {
  // [START datacatalog_search]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
   * import com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest;
   * import com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest.Scope;
   * import com.google.cloud.datacatalog.v1beta1.SearchCatalogResult;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleSearchCatalog() {
    // TODO(developer): Replace these variables before running the sample.
    String includeProjectId = "[Google Cloud Project ID]";
    boolean includeGcpPublicDatasets = false;
    String query = "[String in search query syntax]";
    sampleSearchCatalog(includeProjectId, includeGcpPublicDatasets, query);
  }

  /**
   * Search Catalog
   *
   * @param includeProjectId Your Google Cloud project ID.
   * @param includeGcpPublicDatasets If true, include Google Cloud Platform (GCP) public datasets in
   *     the search results.
   * @param query Your query string. See:
   *     https://cloud.google.com/data-catalog/docs/how-to/search-reference Example: system=bigquery
   *     type=dataset
   */
  public static void sampleSearchCatalog(
      String includeProjectId, boolean includeGcpPublicDatasets, String query) {
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      List<String> includeProjectIds = Arrays.asList(includeProjectId);
      SearchCatalogRequest.Scope scope =
          SearchCatalogRequest.Scope.newBuilder()
              .addAllIncludeProjectIds(includeProjectIds)
              .setIncludeGcpPublicDatasets(includeGcpPublicDatasets)
              .build();
      SearchCatalogRequest request =
          SearchCatalogRequest.newBuilder().setScope(scope).setQuery(query).build();
      for (SearchCatalogResult responseItem :
          dataCatalogClient.searchCatalog(request).iterateAll()) {
        System.out.printf("Result type: %s\n", responseItem.getSearchResultType());
        System.out.printf("Result subtype: %s\n", responseItem.getSearchResultSubtype());
        System.out.printf("Relative resource name: %s\n", responseItem.getRelativeResourceName());
        System.out.printf("Linked resource: %s\n\n", responseItem.getLinkedResource());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END datacatalog_search]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("include_project_id").build());
    options.addOption(
        Option.builder("")
            .required(false)
            .hasArg(true)
            .longOpt("include_gcp_public_datasets")
            .build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("query").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String includeProjectId = cl.getOptionValue("include_project_id", "[Google Cloud Project ID]");
    boolean includeGcpPublicDatasets =
        cl.getOptionValue("include_gcp_public_datasets") != null
            ? Boolean.parseBoolean(cl.getOptionValue("include_gcp_public_datasets"))
            : false;
    String query = cl.getOptionValue("query", "[String in search query syntax]");

    sampleSearchCatalog(includeProjectId, includeGcpPublicDatasets, query);
  }
}
