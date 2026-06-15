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

package com.example.firestore.beam;

import com.google.cloud.firestore.FirestoreOptions;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.firestore.FirestoreIO;
import org.apache.beam.sdk.io.gcp.firestore.RpcQosOptions;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;

public class ExampleFirestoreBeamWrite {
  private static final FirestoreOptions FIRESTORE_OPTIONS = FirestoreOptions.getDefaultInstance();

  public static void main(String[] args) {
    runWrite(args, "cities-beam-sample");
  }

  public static void runWrite(String[] args, String collectionId) {
    // create pipeline options from the passed in arguments
    PipelineOptions options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(PipelineOptions.class);
    Pipeline pipeline = Pipeline.create(options);

    RpcQosOptions rpcQosOptions =
        RpcQosOptions.newBuilder()
            .withHintMaxNumWorkers(options.as(DataflowPipelineOptions.class).getMaxNumWorkers())
            .build();

    // create some writes
    Write write1 =
        Write.newBuilder()
            .setUpdate(
                Document.newBuilder()
                    // resolves to
                    // projects/<projectId>/databases/<databaseId>/documents/<collectionId>/NYC
                    .setName(createDocumentName(collectionId, "NYC"))
                    .putFields("name", Value.newBuilder().setStringValue("New York City").build())
                    .putFields("state", Value.newBuilder().setStringValue("New York").build())
                    .putFields("country", Value.newBuilder().setStringValue("USA").build()))
            .build();

    Write write2 =
        Write.newBuilder()
            .setUpdate(
                Document.newBuilder()
                    // resolves to
                    // projects/<projectId>/databases/<databaseId>/documents/<collectionId>/TOK
                    .setName(createDocumentName(collectionId, "TOK"))
                    .putFields("name", Value.newBuilder().setStringValue("Tokyo").build())
                    .putFields("country", Value.newBuilder().setStringValue("Japan").build())
                    .putFields("capital", Value.newBuilder().setBooleanValue(true).build()))
            .build();

    // batch write the data
    pipeline
        .apply(Create.of(write1, write2))
        .apply(FirestoreIO.v1().write().batchWrite().withRpcQosOptions(rpcQosOptions).build());

    // run the pipeline
    pipeline.run().waitUntilFinish();
  }

  private static String createDocumentName(String collectionId, String cityDocId) {
    String documentPath =
        String.format(
            "projects/%s/databases/%s/documents",
            FIRESTORE_OPTIONS.getProjectId(), FIRESTORE_OPTIONS.getDatabaseId());

    return documentPath + "/" + collectionId + "/" + cityDocId;
  }
}
