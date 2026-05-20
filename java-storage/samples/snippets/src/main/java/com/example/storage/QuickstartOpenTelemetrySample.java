/*
 * Copyright 2024 Google Inc.
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

package com.example.storage;

import com.google.cloud.opentelemetry.propagators.XCloudTraceContextPropagator;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.GrpcStorageOptions;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.semconv.ResourceAttributes;

// [START storage_enable_otel_tracing]
public class QuickstartOpenTelemetrySample {
    public static void main(String... args) throws Exception {
        SpanExporter spanExporter = new SpanExporter() {
            @Override
            public io.opentelemetry.sdk.common.CompletableResultCode export(java.util.Collection<io.opentelemetry.sdk.trace.data.SpanData> spans) {
                for (io.opentelemetry.sdk.trace.data.SpanData span : spans) {
                    System.out.println("\n=== SPAN EXPORTED: " + span.getName() + " ===");
                    span.getAttributes().forEach((key, val) -> System.out.println("  " + key.getKey() + " = " + val));
                }
                return io.opentelemetry.sdk.common.CompletableResultCode.ofSuccess();
            }

            @Override
            public io.opentelemetry.sdk.common.CompletableResultCode flush() {
                return io.opentelemetry.sdk.common.CompletableResultCode.ofSuccess();
            }

            @Override
            public io.opentelemetry.sdk.common.CompletableResultCode shutdown() {
                return io.opentelemetry.sdk.common.CompletableResultCode.ofSuccess();
            }
        };
        SpanExporter cloudTraceExporter = TraceExporter.createWithDefaultConfiguration();
        TextMapPropagator propagators =
                TextMapPropagator.composite(
                        W3CTraceContextPropagator.getInstance(),
                        new XCloudTraceContextPropagator(/* oneway= */ true));
        Resource resource = Resource.getDefault().merge(
                Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME, "gcs-java-quickstart")));
        OpenTelemetrySdk openTelemetry =
                OpenTelemetrySdk.builder()
                        .setPropagators(ContextPropagators.create(propagators))
                        .setTracerProvider(
                                SdkTracerProvider.builder()
                                        // Sample Rate is set to alwaysOn
                                        // It is recommended to sample based on a ratio for standard use ie.
                                        // .setSampler(Sampler.traceIdRatioBased(0.2)) // sample only 20% of trace ids
                                        .setResource(resource)
                                        .setSampler(Sampler.alwaysOn())
                                        .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
                                        .addSpanProcessor(BatchSpanProcessor.builder(cloudTraceExporter).build())
                                        .build())
                        .build();
        StorageOptions options = StorageOptions.newBuilder().setProjectId("nidhi-consumer").setOpenTelemetry(openTelemetry).build();
        Storage storage = options.getService();
        try {
        System.out.println("Created an instance of storage with OpenTelemetry configured");
        Page<Blob> blobs = storage.list("nidhi-test-02");

        for (Blob blob : blobs.iterateAll()) {
            System.out.println(blob.getName());
        }

        storage.create(BlobInfo.newBuilder(BlobId.of("nidhi-test-02", "testing-spans")).setContentType("text/plain").build(), "test".getBytes());
        storage.create(
                BlobInfo.newBuilder(BlobId.of("nidhi-test-03", "testing-spans-2")).setContentType("text/plain").build(),
                "test2".getBytes());

        // Allow background layout fetch to complete
        Thread.sleep(500);
        Bucket bucket = storage.get("nidhi-test-080808080808080");
//        storage.list("test");
        Blob blob = storage.get(BlobId.of("nidhi-test-080808080808080", "testing-spans"));
    storage.list("nidhi-test-0808080808080");
//        System.out.println(blob.getName());
//        System.out.println(blob.getBucket());
        storage.list(bucket.getName());
    }
        catch (Exception e) {

        }
    finally {
            storage.close();
            openTelemetry.getSdkTracerProvider().forceFlush().join(10, java.util.concurrent.TimeUnit.SECONDS);
        }
    }
}
// [END storage_enable_otel_tracing]
