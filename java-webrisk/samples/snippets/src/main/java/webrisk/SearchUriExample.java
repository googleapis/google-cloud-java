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
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.ThreatType;
import java.io.IOException;

public class SearchUriExample {

  public static void searchUriExample() throws IOException {
    //The URL to be searched
    String uri = "http://testsafebrowsing.appspot.com/s/malware.html";
    SearchUrisResponse response = searchUriExample(uri);
  }
  
  // [START webrisk_search_uri]
  public static SearchUrisResponse searchUriExample(String uri) throws IOException {
    //create-webrisk-client
    try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
      //Query the url for a specific threat type
      SearchUrisRequest searchUrisRequest = SearchUrisRequest.newBuilder()
          .addThreatTypes(ThreatType.MALWARE)
          .setUri(uri).build();
      SearchUrisResponse searchUrisResponse = webRiskServiceClient.searchUris(searchUrisRequest);
      webRiskServiceClient.shutdownNow();
      if (!searchUrisResponse.getThreat().getThreatTypesList().isEmpty()) {
        System.out.println("The URL has the following threat : ");
        System.out.println(searchUrisResponse);
      } else {
        System.out.println("The URL is safe!");
      }

      return searchUrisResponse;
    }
  }
  // [END webrisk_search_uri]
}
