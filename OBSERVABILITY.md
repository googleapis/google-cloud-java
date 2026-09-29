# Observability in Google Cloud Java Client Libraries

This guide explains how to enable and configure observability (tracing and logging) in Google Cloud Java client libraries using OpenTelemetry and SLF4J.

---

## 1. Overview

Google Cloud Java client libraries built on [GAX (Google API Extensions)](https://github.com/googleapis/google-cloud-java/tree/main/sdk-platform-java/gax-java) provide built-in support for observability:
- **Tracing**: Powered by [OpenTelemetry](https://opentelemetry.io/). Client calls generate spans representing both high-level logical client operations and individual RPC attempts.
- **Logging**: Client libraries emit structured diagnostic logs using [SLF4J](https://www.slf4j.org/). When OpenTelemetry is configured, logging output automatically correlates with active trace and span IDs.

---

## 2. Distributed Tracing with OpenTelemetry

### 2.1 Dependencies

Add the OpenTelemetry SDK and exporters to your project.

#### Maven
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>io.opentelemetry</groupId>
      <artifactId>opentelemetry-bom</artifactId>
      <version>1.44.1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <!-- OpenTelemetry SDK -->
  <dependency>
    <groupId>io.opentelemetry</groupId>
    <artifactId>opentelemetry-sdk</artifactId>
  </dependency>
  <!-- Google Cloud Trace Exporter (optional, for Cloud Trace) -->
  <dependency>
    <groupId>com.google.cloud.opentelemetry</groupId>
    <artifactId>exporter-trace</artifactId>
    <version>0.33.0</version>
  </dependency>
</dependencies>
```

### 2.2 Initializing OpenTelemetry

Initialize the OpenTelemetry SDK and register it globally, or pass it directly to the client settings:

```java
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import java.io.IOException;

public static OpenTelemetrySdk initializeOpenTelemetry() throws IOException {
  // Initialize TracerProvider with Cloud Trace exporter
  SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
      .addSpanProcessor(BatchSpanProcessor.builder(TraceExporter.createWithDefaultConfiguration()).build())
      .build();

  return OpenTelemetrySdk.builder()
      .setTracerProvider(tracerProvider)
      .buildAndRegisterGlobal();
}
```

### 2.3 Span Hierarchy

When tracing is enabled, GAX instruments client calls with a hierarchy of spans:
1. **Operation Span (Logical / Client Request Span)**: Represents the entire client call from invocation until the final response or failure, spanning across any retries.
2. **Attempt Span (RPC Attempt Span)**: Represents each individual network RPC attempt made by the client. If retries occur, each attempt produces its own attempt span parented under the operation span.

---

## 3. Structured Logging & Trace Correlation

### 3.1 SLF4J Binding

GAX and Google Cloud Java libraries use SLF4J for logging. Include an SLF4J implementation such as Logback:

```xml
<dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>1.5.16</version>
</dependency>
```

### 3.2 Correlating Logs with Cloud Trace

Google Cloud Java client libraries provide two complementary ways to correlate logs with Cloud Trace:

1. **Automatic Context Extraction in Cloud Logging**:
   When writing logs via `google-cloud-logging` (including via the Google Cloud Logging Logback appender), the client library automatically inspects the active thread's OpenTelemetry context (`Span.current()`). If a valid span is active, the `trace`, `spanId`, and `traceSampled` fields are automatically populated on the written `LogEntry`, linking the log directly to Cloud Trace in the Google Cloud Console.

2. **SLF4J Mapped Diagnostic Context (MDC) Propagation**:
   To also include `trace_id` and `span_id` in formatted log messages (such as console or file pattern layouts via `%X{trace_id}`) and attach them as labels in Logback, propagate the OpenTelemetry context to SLF4J MDC:
   - **OpenTelemetry Javaagent**: Use the [OpenTelemetry Javaagent](https://opentelemetry.io/docs/zero-code/java/agent/), which automatically instruments logging frameworks.
   - **Logback MDC Dependency**: Or add the Logback MDC instrumentation dependency to your project:
     ```xml
     <dependency>
       <groupId>io.opentelemetry.instrumentation</groupId>
       <artifactId>opentelemetry-logback-mdc-1.0</artifactId>
       <version>2.10.0-alpha</version>
     </dependency>
     ```

---

## 4. Disabling or Customizing Tracing

If you need to disable tracing or provide a custom `ApiTracerFactory`, configure your client stub settings:

```java
import com.google.api.gax.tracing.NoopApiTracerFactory;

// Example disabling tracing via ServiceSettings builder
MyServiceSettings.Builder settingsBuilder = MyServiceSettings.newBuilder();
settingsBuilder.getStubSettingsBuilder().setTracerFactory(NoopApiTracerFactory.getInstance());
MyServiceSettings settings = settingsBuilder.build();
```
