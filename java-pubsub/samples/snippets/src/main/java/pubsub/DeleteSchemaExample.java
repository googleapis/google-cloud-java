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

// [START pubsub_delete_schema]

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.pubsub.v1.SchemaName;
import java.io.IOException;

public class DeleteSchemaExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String schemaId = "your-schema-id";

    deleteSchemaExample(projectId, schemaId);
  }

  public static void deleteSchemaExample(String projectId, String schemaId) throws IOException {
    SchemaName schemaName = SchemaName.of(projectId, schemaId);

    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {

      schemaServiceClient.deleteSchema(schemaName);

      System.out.println("Deleted a schema:" + schemaName);

    } catch (NotFoundException e) {
      System.out.println(schemaName + "not found.");
    }
  }
}
// [END pubsub_delete_schema]
