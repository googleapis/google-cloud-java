/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= TraceServiceClient =======================
 *
 * <p>Service Description: This file describes an API for collecting and viewing traces and spans
 * within a trace. A Trace is a collection of spans corresponding to a single operation or set of
 * operations for an application. A span is an individual timed event which forms a node of the
 * trace tree. A single trace may contain span(s) from multiple services.
 *
 * <p>Sample for TraceServiceClient:
 *
 * <pre>{@code
 * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   List<Span> spans = new ArrayList<>();
 *   traceServiceClient.batchWriteSpans(name, spans);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.trace.v2;

import javax.annotation.Generated;
