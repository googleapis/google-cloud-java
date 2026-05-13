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

package pubsub;

// [START pubsub_list_schemas]
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Schema;
import java.io.IOException;

public class ListSchemasExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";

    listSchemasExample(projectId);
  }

  public static void listSchemasExample(String projectId) throws IOException {
    ProjectName projectName = ProjectName.of(projectId);

    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
      for (Schema schema : schemaServiceClient.listSchemas(projectName).iterateAll()) {
        System.out.println(schema);
      }
      System.out.println("Listed schemas.");
    }
  }
}
// [END pubsub_list_schemas]
