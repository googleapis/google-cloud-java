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

package com.example.datacatalog;

// [START data_catalog_delete_tag_template]
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.v1.TagTemplateName;
import java.io.IOException;

// Sample to delete tag template
public class DeleteTagTemplate {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    String tagTemplateId = "MY_TAG_TEMPLATE_ID";
    TagTemplateName tagTemplate = TagTemplateName.of(projectId, location, tagTemplateId);
    deleteTagTemplate(tagTemplate);
  }

  public static void deleteTagTemplate(TagTemplateName template) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient client = DataCatalogClient.create()) {
      DeleteTagTemplateRequest request =
          DeleteTagTemplateRequest.newBuilder().setName(template.toString()).setForce(true).build();
      client.deleteTagTemplate(request);
      System.out.println("Tag template deleted successfully");
    }
  }
}
// [END data_catalog_delete_tag_template]
