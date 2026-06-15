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
import com.google.firestore.v1.DocumentRootName;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Value;
import java.util.Objects;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.firestore.FirestoreIO;
import org.apache.beam.sdk.io.gcp.firestore.RpcQosOptions;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class ExampleFirestoreBeamRead {

  public static void main(String[] args) {
    runRead(args, "cities-beam-sample");
  }

  public static void runRead(String[] args, String collectionId) {
    FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance();

    PipelineOptions options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(PipelineOptions.class);
    Pipeline pipeline = Pipeline.create(options);

    RpcQosOptions rpcQosOptions =
        RpcQosOptions.newBuilder()
            .withHintMaxNumWorkers(options.as(DataflowPipelineOptions.class).getMaxNumWorkers())
            .build();

    pipeline
        .apply(Create.of(collectionId))
        .apply(
            new FilterDocumentsQuery(
                firestoreOptions.getProjectId(), firestoreOptions.getDatabaseId()))
        .apply(FirestoreIO.v1().read().runQuery().withRpcQosOptions(rpcQosOptions).build())
        .apply(
            ParDo.of(
                // transform each document to its name
                new DoFn<RunQueryResponse, String>() {
                  @ProcessElement
                  public void processElement(ProcessContext c) {
                    c.output(Objects.requireNonNull(c.element()).getDocument().getName());
                  }
                }))
        .apply(
            ParDo.of(
                // print the document name
                new DoFn<String, Void>() {
                  @ProcessElement
                  public void processElement(ProcessContext c) {
                    System.out.println(c.element());
                  }
                }));

    pipeline.run().waitUntilFinish();
  }

  private static final class FilterDocumentsQuery
      extends PTransform<PCollection<String>, PCollection<RunQueryRequest>> {

    private final String projectId;
    private final String databaseId;

    public FilterDocumentsQuery(String projectId, String databaseId) {
      this.projectId = projectId;
      this.databaseId = databaseId;
    }

    @Override
    public PCollection<RunQueryRequest> expand(PCollection<String> input) {
      return input.apply(
          ParDo.of(
              new DoFn<String, RunQueryRequest>() {
                @ProcessElement
                public void processElement(ProcessContext c) {
                  // select from collection "cities-collection-<uuid>"
                  StructuredQuery.CollectionSelector collection =
                      StructuredQuery.CollectionSelector.newBuilder()
                          .setCollectionId(Objects.requireNonNull(c.element()))
                          .build();
                  // filter where country is equal to USA
                  StructuredQuery.Filter countryFilter =
                      StructuredQuery.Filter.newBuilder()
                          .setFieldFilter(
                              StructuredQuery.FieldFilter.newBuilder()
                                  .setField(
                                      StructuredQuery.FieldReference.newBuilder()
                                          .setFieldPath("country")
                                          .build())
                                  .setValue(Value.newBuilder().setStringValue("USA").build())
                                  .setOp(StructuredQuery.FieldFilter.Operator.EQUAL))
                          .buildPartial();

                  RunQueryRequest runQueryRequest =
                      RunQueryRequest.newBuilder()
                          .setParent(DocumentRootName.format(projectId, databaseId))
                          .setStructuredQuery(
                              StructuredQuery.newBuilder()
                                  .addFrom(collection)
                                  .setWhere(countryFilter)
                                  .build())
                          .build();
                  c.output(runQueryRequest);
                }
              }));
    }
  }
}
