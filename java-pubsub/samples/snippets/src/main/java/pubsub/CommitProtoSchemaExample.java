/*
 * Copyright 2023 Google LLC
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

// [START pubsub_commit_proto_schema]

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommitProtoSchemaExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String schemaId = "your-schema-id";
    String protoFile = "path/to/a/proto/file/(.proto)/formatted/in/protocol/buffers";

    commitProtoSchemaExample(projectId, schemaId, protoFile);
  }

  public static Schema commitProtoSchemaExample(String projectId, String schemaId, String protoFile)
      throws IOException {

    ProjectName projectName = ProjectName.of(projectId);
    SchemaName schemaName = SchemaName.of(projectId, schemaId);

    // Read a proto file as a string.
    String protoSource = new String(Files.readAllBytes(Paths.get(protoFile)));

    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {

      Schema schema =
          schemaServiceClient.commitSchema(
              schemaName.toString(),
              Schema.newBuilder()
                  .setName(schemaName.toString())
                  .setType(Schema.Type.PROTOCOL_BUFFER)
                  .setDefinition(protoSource)
                  .build());

      System.out.println("Committed a schema using a protobuf schema:\n" + schema);
      return schema;
    } catch (AlreadyExistsException e) {
      System.out.println(schemaName + "already exists.");
      return null;
    }
  }
}
// [END pubsub_commit_proto_schema]
