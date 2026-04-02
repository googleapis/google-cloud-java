/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.otel;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestExporter implements SpanExporter {

  public final List<SpanData> exportedSpans = Collections.synchronizedList(new ArrayList<>());

  @Override
  public CompletableResultCode export(Collection<SpanData> spans) {
    exportedSpans.addAll(spans);
    return CompletableResultCode.ofSuccess();
  }

  @Override
  public CompletableResultCode flush() {
    return null;
  }

  @Override
  public CompletableResultCode shutdown() {
    return null;
  }

  public List<SpanData> getExportedSpans() {
    return exportedSpans;
  }
}
