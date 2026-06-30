/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import com.google.errorprone.annotations.concurrent.GuardedBy;
import io.opencensus.common.Clock;
import io.opencensus.internal.ZeroTimeClock;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Link;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.Span.Options;
import io.opencensus.trace.SpanBuilder;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import io.opencensus.trace.TraceComponent;
import io.opencensus.trace.TraceId;
import io.opencensus.trace.TraceOptions;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracestate;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.config.TraceParams;
import io.opencensus.trace.export.ExportComponent;
import io.opencensus.trace.export.RunningSpanStore;
import io.opencensus.trace.export.SampledSpanStore;
import io.opencensus.trace.export.SpanExporter;
import io.opencensus.trace.propagation.BinaryFormat;
import io.opencensus.trace.propagation.PropagationComponent;
import io.opencensus.trace.propagation.TextFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;

/**
 * Simple {@link TraceComponent} implementation that will throw an exception if a {@link Span} is
 * ended more than once.
 */
public class FailOnOverkillTraceComponentImpl extends TraceComponent {
  private static final Random RANDOM = new Random();
  private final Tracer tracer = new TestTracer();
  private final PropagationComponent propagationComponent = new TestPropagationComponent();
  private final Clock clock = ZeroTimeClock.getInstance();
  private final ExportComponent exportComponent = new TestExportComponent();
  private final TraceConfig traceConfig = new TestTraceConfig();
  private static final Map<String, Boolean> spans =
      Collections.synchronizedMap(new LinkedHashMap<>());
  private static final List<TestSpan> spanList = Collections.synchronizedList(new LinkedList<>());

  private static final List<String> annotations = new ArrayList<>();

  public static class TestSpan extends Span {
    @GuardedBy("this")
    private volatile boolean ended = false;

    private final String spanName;

    private Status status;

    private final List<String> annotations = Collections.synchronizedList(new ArrayList<>());

    private TestSpan(String spanName, SpanContext context, EnumSet<Options> options) {
      super(context, options);
      this.spanName = spanName;
      spans.put(this.spanName, false);
      spanList.add(this);
    }

    public String getSpanName() {
      return this.spanName;
    }

    public List<String> getAnnotations() {
      return this.annotations;
    }

    @Override
    public void addAnnotation(String description, Map<String, AttributeValue> attributes) {
      FailOnOverkillTraceComponentImpl.annotations.add(description);
      this.annotations.add(description);
    }

    @Override
    public void addAnnotation(Annotation annotation) {
      FailOnOverkillTraceComponentImpl.annotations.add(annotation.getDescription());
      this.annotations.add(annotation.getDescription());
    }

    @Override
    public void putAttributes(Map<String, AttributeValue> attributes) {}

    @Override
    public void addAttributes(Map<String, AttributeValue> attributes) {}

    @Override
    public void addLink(Link link) {}

    @Nullable
    public Status getStatus() {
      return this.status;
    }

    @Override
    public void setStatus(Status status) {
      this.status = status;
    }

    @Override
    public void end(EndSpanOptions options) {
      synchronized (this) {
        if (ended) {
          throw new IllegalStateException(this.spanName + " already ended");
        }
        if (spans.containsKey(this.spanName)) {
          spans.put(this.spanName, true);
          ended = true;
        }
      }
    }
  }

  public static class TestSpanBuilder extends SpanBuilder {
    private String spanName;

    TestSpanBuilder(String spanName) {
      this.spanName = spanName;
    }

    @Override
    public SpanBuilder setSampler(Sampler sampler) {
      return this;
    }

    @Override
    public SpanBuilder setParentLinks(List<Span> parentLinks) {
      return this;
    }

    @Override
    public SpanBuilder setRecordEvents(boolean recordEvents) {
      return this;
    }

    @Override
    public Span startSpan() {
      return new TestSpan(
          this.spanName,
          SpanContext.create(
              TraceId.generateRandomId(RANDOM),
              SpanId.generateRandomId(RANDOM),
              TraceOptions.builder().setIsSampled(true).build(),
              Tracestate.builder().build()),
          EnumSet.of(Options.RECORD_EVENTS));
    }
  }

  public static class TestTracer extends Tracer {
    @Override
    public SpanBuilder spanBuilderWithExplicitParent(String spanName, Span parent) {
      return new TestSpanBuilder(spanName);
    }

    @Override
    public SpanBuilder spanBuilderWithRemoteParent(
        String spanName, SpanContext remoteParentSpanContext) {
      return new TestSpanBuilder(spanName);
    }
  }

  public static class TestPropagationComponent extends PropagationComponent {
    @Override
    public BinaryFormat getBinaryFormat() {
      return null;
    }

    @Override
    public TextFormat getB3Format() {
      return null;
    }

    @Override
    public TextFormat getTraceContextFormat() {
      return null;
    }
  }

  public static class TestSpanExporter extends SpanExporter {
    @Override
    public void registerHandler(String name, Handler handler) {}

    @Override
    public void unregisterHandler(String name) {}
  }

  public static class TestExportComponent extends ExportComponent {
    private final SpanExporter spanExporter = new TestSpanExporter();

    @Override
    public SpanExporter getSpanExporter() {
      return spanExporter;
    }

    @Override
    public RunningSpanStore getRunningSpanStore() {
      return null;
    }

    @Override
    public SampledSpanStore getSampledSpanStore() {
      return null;
    }
  }

  public static class TestTraceConfig extends TraceConfig {
    private volatile TraceParams activeTraceParams = TraceParams.DEFAULT;

    @Override
    public TraceParams getActiveTraceParams() {
      return activeTraceParams;
    }

    @Override
    public void updateActiveTraceParams(TraceParams traceParams) {
      this.activeTraceParams = traceParams;
    }
  }

  @Override
  public Tracer getTracer() {
    return tracer;
  }

  Map<String, Boolean> getSpans() {
    return spans;
  }

  List<TestSpan> getTestSpans() {
    return spanList;
  }

  List<String> getAnnotations() {
    return annotations;
  }

  void clearSpans() {
    spans.clear();
    spanList.clear();
  }

  void clearAnnotations() {
    annotations.clear();
  }

  @Override
  public PropagationComponent getPropagationComponent() {
    return propagationComponent;
  }

  @Override
  public Clock getClock() {
    return clock;
  }

  @Override
  public ExportComponent getExportComponent() {
    return exportComponent;
  }

  @Override
  public TraceConfig getTraceConfig() {
    return traceConfig;
  }
}
