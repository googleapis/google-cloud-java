/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc.fallback;

import static com.google.cloud.grpc.fallback.GcpFallbackChannel.INIT_FAILURE_REASON;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CALL_STATUS_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CHANNEL_NAME;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CURRENT_CHANNEL_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.ERROR_RATIO_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.FALLBACK_COUNT_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.FROM_CHANNEL_NAME;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.METRIC_PREFIX;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.PROBE_RESULT;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.PROBE_RESULT_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.STATUS_CODE;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.TO_CHANNEL_NAME;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.Status;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GcpFallbackChannelTest {

  static class DummyMarshaller<T> implements Marshaller<Object> {
    @Override
    public InputStream stream(Object value) {
      return new ByteArrayInputStream(value.toString().getBytes());
    }

    @Override
    public Object parse(InputStream stream) {
      try {
        return stream.readAllBytes().toString();
      } catch (IOException e) {
        return new Object();
      }
    }
  }

  private final DummyMarshaller<Object> dummyMarshaller = new DummyMarshaller<>();
  @Mock private ManagedChannel mockPrimaryDelegateChannel;
  @Mock private ManagedChannel mockFallbackDelegateChannel;
  private final MethodDescriptor<Object, Object> methodDescriptor =
      MethodDescriptor.newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("testMethod")
          .setRequestMarshaller(dummyMarshaller)
          .setResponseMarshaller(dummyMarshaller)
          .build();

  private final CallOptions callOptions = CallOptions.DEFAULT;
  @Mock private ClientCall<Object, Object> mockPrimaryClientCall;
  @Mock private ClientCall<Object, Object> mockFallbackClientCall;
  @Mock private ScheduledExecutorService mockScheduledExecutorService;
  @Mock private ManagedChannelBuilder<?> mockPrimaryBuilder;
  @Mock private ManagedChannelBuilder<?> mockPrimaryInvalidBuilder;
  @Mock private ManagedChannelBuilder<?> mockFallbackBuilder;
  @Mock private ManagedChannelBuilder<?> mockFallbackInvalidBuilder;

  private GcpFallbackChannel gcpFallbackChannel;

  private final String primaryAuthority = "primary.authority.com";
  private final String fallbackAuthority = "fallback.authority.com";

  @Captor private ArgumentCaptor<Runnable> checkErrorRatesTaskCaptor;
  @Captor private ArgumentCaptor<Runnable> primaryProbingTaskCaptor;
  @Captor private ArgumentCaptor<Runnable> fallbackProbingTaskCaptor;

  private Runnable checkErrorRatesTask;
  private Runnable primaryProbingTask;
  private Runnable fallbackProbingTask;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    // Mock delegate channel behaviors.
    when(mockPrimaryDelegateChannel.newCall(any(MethodDescriptor.class), any(CallOptions.class)))
        .thenReturn(mockPrimaryClientCall);
    when(mockFallbackDelegateChannel.newCall(any(MethodDescriptor.class), any(CallOptions.class)))
        .thenReturn(mockFallbackClientCall);
    when(mockPrimaryDelegateChannel.authority()).thenReturn(primaryAuthority);
    when(mockFallbackDelegateChannel.authority()).thenReturn(fallbackAuthority);

    // For constructor with builders.
    when(mockPrimaryBuilder.build()).thenReturn(mockPrimaryDelegateChannel);
    when(mockPrimaryInvalidBuilder.build())
        .thenThrow(
            new IllegalArgumentException(
                "Could not find a NameResolverProvider for custom://some.domain"));
    when(mockFallbackInvalidBuilder.build())
        .thenThrow(
            new IllegalArgumentException(
                "Could not find a NameResolverProvider for dns://some.domain"));
    when(mockFallbackBuilder.build()).thenReturn(mockFallbackDelegateChannel);
  }

  @After
  public void tearDown() {
    // Ensure channel is shutdown if a test forgets, to prevent resource leaks in test environment.
    if (gcpFallbackChannel != null && !gcpFallbackChannel.isShutdown()) {
      gcpFallbackChannel.shutdownNow();
    }
  }

  private GcpFallbackChannelOptions.Builder getDefaultOptionsBuilder() {
    return GcpFallbackChannelOptions.newBuilder()
        .setEnableFallback(true)
        .setErrorRateThreshold(0.5f)
        .setMinFailedCalls(3)
        .setPeriod(Duration.ofMinutes(1))
        .setPrimaryProbingInterval(Duration.ofMinutes(5))
        .setErroneousStates(
            EnumSet.of(
                Status.Code.UNAVAILABLE,
                Status.Code.UNAUTHENTICATED,
                Status.Code.DEADLINE_EXCEEDED));
  }

  private GcpFallbackChannelOptions getDefaultOptions() {
    return getDefaultOptionsBuilder().build();
  }

  private void initializeChannelAndCaptureTasks(GcpFallbackChannelOptions options) {
    gcpFallbackChannel =
        new GcpFallbackChannel(
            options,
            mockPrimaryDelegateChannel,
            mockFallbackDelegateChannel,
            mockScheduledExecutorService);
    captureScheduledTasks(options);
  }

  private void initializeChannelWithBuildersAndCaptureTasks(GcpFallbackChannelOptions options) {
    gcpFallbackChannel =
        new GcpFallbackChannel(
            options, mockPrimaryBuilder, mockFallbackBuilder, mockScheduledExecutorService);
    captureScheduledTasks(options);
  }

  private void initializeChannelWithInvalidPrimaryBuilderAndCaptureTasks(
      GcpFallbackChannelOptions options) {
    gcpFallbackChannel =
        new GcpFallbackChannel(
            options, mockPrimaryInvalidBuilder, mockFallbackBuilder, mockScheduledExecutorService);
    captureScheduledTasks(options);
  }

  private void initializeChannelWithInvalidFallbackBuilderAndCaptureTasks(
      GcpFallbackChannelOptions options) {
    gcpFallbackChannel =
        new GcpFallbackChannel(
            options, mockPrimaryBuilder, mockFallbackInvalidBuilder, mockScheduledExecutorService);
    captureScheduledTasks(options);
  }

  private void captureScheduledTasks(GcpFallbackChannelOptions options) {
    if (options.isEnableFallback()
        && options.getPeriod() != null
        && options.getPeriod().toMillis() > 0) {
      verify(mockScheduledExecutorService)
          .scheduleAtFixedRate(
              checkErrorRatesTaskCaptor.capture(),
              eq(options.getPeriod().toMillis()),
              eq(options.getPeriod().toMillis()),
              eq(MILLISECONDS));
      checkErrorRatesTask = checkErrorRatesTaskCaptor.getValue();
    } else {
      verify(mockScheduledExecutorService, never())
          .scheduleAtFixedRate(
              checkErrorRatesTaskCaptor.capture(),
              eq(options.getPeriod().toMillis()),
              eq(options.getPeriod().toMillis()),
              eq(MILLISECONDS));
      checkErrorRatesTask = null;
    }
    if (options.getPrimaryProbingFunction() != null) {
      verify(mockScheduledExecutorService)
          .scheduleAtFixedRate(
              primaryProbingTaskCaptor.capture(),
              eq(options.getPrimaryProbingInterval().toMillis()),
              eq(options.getPrimaryProbingInterval().toMillis()),
              eq(MILLISECONDS));
      primaryProbingTask = primaryProbingTaskCaptor.getValue();
    } else {
      verify(mockScheduledExecutorService, never())
          .scheduleAtFixedRate(
              primaryProbingTaskCaptor.capture(),
              eq(options.getPrimaryProbingInterval().toMillis()),
              eq(options.getPrimaryProbingInterval().toMillis()),
              eq(MILLISECONDS));
      primaryProbingTask = null;
    }
    if (options.getFallbackProbingFunction() != null) {
      verify(mockScheduledExecutorService)
          .scheduleAtFixedRate(
              fallbackProbingTaskCaptor.capture(),
              eq(options.getFallbackProbingInterval().toMillis()),
              eq(options.getFallbackProbingInterval().toMillis()),
              eq(MILLISECONDS));
      fallbackProbingTask = fallbackProbingTaskCaptor.getValue();
    } else {
      verify(mockScheduledExecutorService, never())
          .scheduleAtFixedRate(
              fallbackProbingTaskCaptor.capture(),
              eq(options.getFallbackProbingInterval().toMillis()),
              eq(options.getFallbackProbingInterval().toMillis()),
              eq(MILLISECONDS));
      fallbackProbingTask = null;
    }
  }

  @SuppressWarnings({"unchecked"})
  private void simulateCall(Status statusToReturn, boolean expectFallbackRouting) {
    final ClientCall.Listener<Object> dummyCallListener = mock(ClientCall.Listener.class);
    final Metadata requestHeaders = new Metadata();

    // First, create a new call on gcpFallbackChannel. This simulates how an app would create a
    // call.
    ClientCall<Object, Object> testCall = gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    assertNotNull(testCall);

    ClientCall<Object, Object> mockClientCall;
    // Make sure the correct channel was used by gcpFallbackChannel.
    if (expectFallbackRouting) {
      verify(mockFallbackDelegateChannel).newCall(methodDescriptor, callOptions);
      verify(mockPrimaryDelegateChannel, never()).newCall(methodDescriptor, callOptions);
      mockClientCall = mockFallbackClientCall;
    } else {
      verify(mockPrimaryDelegateChannel).newCall(methodDescriptor, callOptions);
      verify(mockFallbackDelegateChannel, never()).newCall(methodDescriptor, callOptions);
      mockClientCall = mockPrimaryClientCall;
    }

    // Then start this call with a dummy listener as we are not going to get real responses.
    // This simulates how an app would start a call.
    testCall.start(dummyCallListener, requestHeaders);

    ArgumentCaptor<ClientCall.Listener<Object>> delegateListenerCaptor =
        ArgumentCaptor.forClass(ClientCall.Listener.class);

    // Make sure the start method was called on the client call mock and capture the provided
    // listener. This listener is created by the channel created with ClientInterceptors
    // in the GcpFallbackChannel and wraps the dummy listener we provided above.
    verify(mockClientCall).start(delegateListenerCaptor.capture(), eq(requestHeaders));

    // Call onClose on the listener to simulate completion of the call with a desired status.
    delegateListenerCaptor.getValue().onClose(statusToReturn, new Metadata());

    clearInvocations(mockPrimaryDelegateChannel, mockFallbackDelegateChannel, mockClientCall);
  }

  private void simulateCanceledCall(boolean expectFallbackRouting) {
    ClientCall<Object, Object> testCall = gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    assertNotNull(testCall);

    testCall.cancel("Test cancellation", null);

    ClientCall<Object, Object> mockClientCall;
    if (expectFallbackRouting) {
      verify(mockFallbackDelegateChannel).newCall(methodDescriptor, callOptions);
      verify(mockPrimaryDelegateChannel, never()).newCall(methodDescriptor, callOptions);
      mockClientCall = mockFallbackClientCall;
    } else {
      verify(mockPrimaryDelegateChannel).newCall(methodDescriptor, callOptions);
      verify(mockFallbackDelegateChannel, never()).newCall(methodDescriptor, callOptions);
      mockClientCall = mockPrimaryClientCall;
    }
    verify(mockClientCall).cancel(eq("Test cancellation"), isNull());
    clearInvocations(mockPrimaryDelegateChannel, mockFallbackDelegateChannel, mockClientCall);
  }

  private class TestMetricExporter implements MetricExporter {
    public final List<MetricData> exportedMetrics = Collections.synchronizedList(new ArrayList<>());

    @Override
    public CompletableResultCode export(@Nonnull Collection<MetricData> metrics) {
      exportedMetrics.addAll(metrics);
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode flush() {
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode shutdown() {
      exportedMetrics.clear();
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public AggregationTemporality getAggregationTemporality(
        @Nonnull InstrumentType instrumentType) {
      return AggregationTemporality.DELTA;
    }

    public List<MetricData> getExportedMetrics() {
      return exportedMetrics;
    }
  }

  private OpenTelemetry prepareOpenTelemetry(TestMetricExporter exporter) {
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder()
            .registerMetricReader(
                PeriodicMetricReader.builder(exporter).setInterval(Duration.ofMillis(100)).build())
            .build();

    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    return openTelemetry;
  }

  private String fullMetricName(String metricName) {
    return String.format("%s.%s", METRIC_PREFIX, metricName);
  }

  private void assertSumMetrics(
      long value, List<MetricData> metrics, String metricName, Attributes attrs) {
    long actualValue = 0;
    for (MetricData metricData : metrics) {
      if (!metricData.getName().equals(metricName)) {
        continue;
      }

      pointsLoop:
      for (LongPointData point : metricData.getLongSumData().getPoints()) {
        for (AttributeKey<?> key : attrs.asMap().keySet()) {
          if (!attrs.get(key).equals(point.getAttributes().get(key))) {
            continue pointsLoop;
          }
        }

        actualValue += point.getValue();
      }
    }
    assertEquals(value, actualValue);
  }

  private void assertGaugeMetric(
      double value, double delta, List<MetricData> metrics, String metricName, Attributes attrs) {
    for (MetricData metricData : metrics) {
      if (!metricData.getName().equals(metricName)) {
        continue;
      }

      pointsLoop:
      for (DoublePointData point : metricData.getDoubleGaugeData().getPoints()) {
        for (AttributeKey<?> key : attrs.asMap().keySet()) {
          if (!attrs.get(key).equals(point.getAttributes().get(key))) {
            continue pointsLoop;
          }
        }

        assertEquals(value, point.getValue(), delta);
        return;
      }
    }

    fail("Gauge metric not found in exported metrics.");
  }

  @Test
  public void testFallback_whenConditionsMet() throws InterruptedException {
    TestMetricExporter exporter = new TestMetricExporter();
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(3)
            .setErrorRateThreshold(0.42f) // 3 failures / 7 calls = 0.4285
            .setGcpFallbackOpenTelemetry(
                GcpFallbackOpenTelemetry.newBuilder()
                    .withSdk(prepareOpenTelemetry(exporter))
                    .build())
            .build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    // Simulate 4 success, 3 failures on primary.
    // UNAVAILABLE, DEADLINE_EXCEEDED, and UNAUTHENTICATED must be the erroneous states by default.
    simulateCall(Status.OK, false);
    simulateCall(Status.UNAVAILABLE, false);
    simulateCall(Status.OK, false);
    simulateCall(Status.DEADLINE_EXCEEDED, false);
    simulateCall(Status.OK, false);
    simulateCall(Status.UNAUTHENTICATED, false);
    simulateCall(Status.OK, false);

    assertFalse(
        "Should not be in fallback mode until the check is ran.",
        gcpFallbackChannel.isInFallbackMode());

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertTrue(
        "Should be in fallback mode after the check is ran.",
        gcpFallbackChannel.isInFallbackMode());

    // Verify new calls go to fallback channel.
    simulateCall(Status.OK, true);
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());

    TimeUnit.MILLISECONDS.sleep(200);

    List<MetricData> exportedMetrics = exporter.getExportedMetrics();

    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(CALL_STATUS_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", STATUS_CODE, "DEADLINE_EXCEEDED"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(CALL_STATUS_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", STATUS_CODE, "UNAVAILABLE"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(CALL_STATUS_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", STATUS_CODE, "UNAUTHENTICATED"));
    assertSumMetrics(
        4,
        exportedMetrics,
        fullMetricName(CALL_STATUS_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", STATUS_CODE, "OK"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(CALL_STATUS_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback", STATUS_CODE, "OK"));

    assertSumMetrics(
        0,
        exportedMetrics,
        fullMetricName(CURRENT_CHANNEL_METRIC),
        Attributes.of(CHANNEL_NAME, "primary"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(CURRENT_CHANNEL_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback"));

    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(FALLBACK_COUNT_METRIC),
        Attributes.of(FROM_CHANNEL_NAME, "primary", TO_CHANNEL_NAME, "fallback"));

    assertGaugeMetric(
        0.4285,
        0.001,
        exportedMetrics,
        fullMetricName(ERROR_RATIO_METRIC),
        Attributes.of(CHANNEL_NAME, "primary"));
    assertGaugeMetric(
        0,
        0.001,
        exportedMetrics,
        fullMetricName(ERROR_RATIO_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback"));
  }

  @Test
  public void testFallback_whenConditionsMet_withCancelledCalls() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(1)
            .setErrorRateThreshold(1f)
            .setErroneousStates(
                EnumSet.of(
                    Status.Code.UNAVAILABLE, Status.Code.CANCELLED, Status.Code.DEADLINE_EXCEEDED))
            .build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    // Simulate 1 cancelled call on primary.
    simulateCanceledCall(false);

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertTrue(
        "Should be in fallback mode after cancelled call meets threshold.",
        gcpFallbackChannel.isInFallbackMode());
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());

    // Verify new calls go to fallback channel.
    gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    verify(mockFallbackDelegateChannel).newCall(methodDescriptor, callOptions);
    verify(mockPrimaryDelegateChannel, never()).newCall(methodDescriptor, callOptions);
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testFallback_staysOnAfterPrimaryRecovers() {
    AtomicLong probeCalled = new AtomicLong(0);
    // Probing function returning no error.
    Function<Channel, String> primaryProbe =
        channel -> {
          probeCalled.incrementAndGet();
          return "";
        };
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(1)
            .setErrorRateThreshold(0.1f)
            .setPrimaryProbingFunction(primaryProbe)
            .setPrimaryProbingInterval(Duration.ofSeconds(15))
            .build();
    initializeChannelAndCaptureTasks(options);

    // Trigger fallback.
    simulateCall(Status.UNAVAILABLE, false);
    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();
    assertTrue("Should be in fallback mode.", gcpFallbackChannel.isInFallbackMode());
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());

    // Run probing function in GcpFallbackChannel.
    assertNotNull("probePrimary must be scheduled", primaryProbingTask);
    primaryProbingTask.run();
    assertEquals(1, probeCalled.get());

    // Run more times successfully as if primary is recovered.
    primaryProbingTask.run();
    primaryProbingTask.run();
    primaryProbingTask.run();
    primaryProbingTask.run();
    primaryProbingTask.run();
    assertEquals(6, probeCalled.get());

    // Simulate calls that would have been successful on primary.
    // These calls will now go to fallback, so primary's counters won't change.
    // The checkErrorRates will operate on (likely) 0/0 for primary for the new period.
    simulateCall(Status.OK, true);
    simulateCall(Status.OK, true);

    checkErrorRatesTask.run(); // Check again.

    assertTrue(
        "Should remain in fallback mode even if primary is hypothetically recovered.",
        gcpFallbackChannel.isInFallbackMode());

    // Verify new calls still go to fallback.
    gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    verify(mockFallbackDelegateChannel).newCall(methodDescriptor, callOptions);
    verify(mockPrimaryDelegateChannel, never()).newCall(methodDescriptor, callOptions);
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testFallback_initiallyWhenPrimaryBuildFails() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder().setMinFailedCalls(1).setErrorRateThreshold(0.1f).build();
    initializeChannelWithInvalidPrimaryBuilderAndCaptureTasks(options);

    verify(mockPrimaryInvalidBuilder).build();
    verify(mockFallbackBuilder).build();
    assertNotNull(gcpFallbackChannel);

    assertTrue("Should be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    // Verify new calls still go to fallback.
    gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    verify(mockFallbackDelegateChannel).newCall(methodDescriptor, callOptions);
    verify(mockPrimaryDelegateChannel, never()).newCall(methodDescriptor, callOptions);
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testNoFallback_whenDisabledInOptions() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setEnableFallback(false)
            // Conditions for fallback would otherwise be met.
            .setMinFailedCalls(1)
            .setErrorRateThreshold(0.1f)
            .build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());
    simulateCall(Status.UNAVAILABLE, false); // 1 failure

    assertNull("checkErrorRates must not be scheduled.", checkErrorRatesTask);

    assertFalse(
        "Should not enter fallback mode when disabled.", gcpFallbackChannel.isInFallbackMode());

    // Verify new calls still go to primary.
    gcpFallbackChannel.newCall(methodDescriptor, callOptions);
    verify(mockPrimaryDelegateChannel).newCall(methodDescriptor, callOptions);
    verify(mockFallbackDelegateChannel, never()).newCall(methodDescriptor, callOptions);
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testNoFallback_minCallsNotMet() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(3) // Need 3 failed calls.
            .setErrorRateThreshold(0.1f) // Low threshold, but minCalls is high.
            .build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    simulateCall(Status.UNAVAILABLE, false);
    simulateCall(Status.UNAVAILABLE, false);
    simulateCall(Status.OK, false);
    simulateCall(Status.OK, false);
    // Total calls = 4, Failures = 2. Error rate = 0.5. MinFailedCalls = 3. Threshold = 0.1.
    // MinFailedCalls not met.

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertFalse(
        "Should not be in fallback mode, minFailedCalls not met.",
        gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());

    simulateCall(Status.UNAVAILABLE, false); // 3rd failure, but during the next period.
    // Total calls = 1, Failures = 1. Error rate = 1.0. MinFailedCalls = 3. Threshold = 0.1.
    // MinFailedCalls not met.

    checkErrorRatesTask.run();
    assertFalse(
        "Should not be in fallback mode, minFailedCalls not met.",
        gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testNoFallback_fallbackChannelBuildFails() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder().setMinFailedCalls(1).setErrorRateThreshold(0.1f).build();
    initializeChannelWithInvalidFallbackBuilderAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    simulateCall(Status.UNAVAILABLE, false);
    simulateCall(Status.UNAVAILABLE, false);
    simulateCall(Status.UNAVAILABLE, false);
    // Total calls = 3, Failures = 3. Error rate = 1.0. MinFailedCalls = 1. Threshold = 0.1.
    // Fallback conditions satisfied but we have nowhere to fail over to because the fallbackChannel
    // wasn't built.

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertFalse("Should not be in fallback mode.", gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testNoFallback_errorRateNotMet() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(1) // Min calls met.
            .setErrorRateThreshold(0.8f) // High threshold.
            .build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    simulateCall(Status.OK, false);
    simulateCall(Status.UNAVAILABLE, false);
    // Total calls = 2, Failures = 1. Error rate = 0.5. MinFailedCalls = 1. Threshold = 0.8.
    // Error rate not met.

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertFalse(
        "Should not be in fallback mode, errorRateThreshold is not met.",
        gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testNoFallback_zeroCalls() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder().setMinFailedCalls(1).setErrorRateThreshold(0.1f).build();
    initializeChannelAndCaptureTasks(options);

    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());

    assertNotNull("checkErrorRates must be scheduled.", checkErrorRatesTask);
    checkErrorRatesTask.run();

    assertFalse(
        "Should not be in fallback mode, errorRateThreshold is not met.",
        gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testBadPrimary_noPrimaryProbes() {
    AtomicLong probeCalled = new AtomicLong(0);
    // Probing function returning no error.
    Function<Channel, String> primaryProbe =
        channel -> {
          probeCalled.incrementAndGet();
          return "";
        };
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setMinFailedCalls(1)
            .setErrorRateThreshold(0.1f)
            .setPrimaryProbingFunction(primaryProbe)
            .setPrimaryProbingInterval(Duration.ofSeconds(15))
            .build();
    initializeChannelWithInvalidPrimaryBuilderAndCaptureTasks(options);

    assertNotNull("probePrimary must be scheduled", primaryProbingTask);
    // Run probing function in GcpFallbackChannel.
    primaryProbingTask.run();
    // The probePrimary should not call the provided function because we have no primary channel.
    assertEquals(0, probeCalled.get());
  }

  @Test
  public void testShutdown_shutsDownAllComponents() {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    gcpFallbackChannel.shutdown();

    verify(mockPrimaryDelegateChannel).shutdown();
    verify(mockFallbackDelegateChannel).shutdown();
    verify(mockScheduledExecutorService).shutdown();
  }

  @Test
  public void testShutdownNow_shutsDownAllComponents() {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    gcpFallbackChannel.shutdownNow();

    verify(mockPrimaryDelegateChannel).shutdownNow();
    verify(mockFallbackDelegateChannel).shutdownNow();
    verify(mockScheduledExecutorService).shutdownNow();
  }

  @Test
  public void testAwaitTermination_success() throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    long timeout = 10;
    TimeUnit unit = TimeUnit.SECONDS;

    when(mockPrimaryDelegateChannel.awaitTermination(timeout, unit)).thenReturn(true);

    ArgumentCaptor<Long> fallbackTimeoutCaptor = ArgumentCaptor.forClass(Long.class);
    when(mockFallbackDelegateChannel.awaitTermination(
            fallbackTimeoutCaptor.capture(), eq(NANOSECONDS)))
        .thenReturn(true);

    ArgumentCaptor<Long> execTimeoutCaptor = ArgumentCaptor.forClass(Long.class);
    when(mockScheduledExecutorService.awaitTermination(
            execTimeoutCaptor.capture(), eq(NANOSECONDS)))
        .thenReturn(true);

    assertTrue(gcpFallbackChannel.awaitTermination(timeout, unit));

    verify(mockPrimaryDelegateChannel).awaitTermination(timeout, unit);
    verify(mockFallbackDelegateChannel).awaitTermination(anyLong(), eq(NANOSECONDS));
    verify(mockScheduledExecutorService).awaitTermination(anyLong(), eq(NANOSECONDS));

    assertTrue(
        "Fallback timeout should be <= original.",
        fallbackTimeoutCaptor.getValue() <= unit.toNanos(timeout));
    assertTrue("Fallback timeout should be non-negative.", fallbackTimeoutCaptor.getValue() >= 0);
    assertTrue(
        "Executor timeout should be <= original (adjusted for fallback).",
        execTimeoutCaptor.getValue() <= unit.toNanos(timeout));
    assertTrue("Executor timeout should be non-negative.", execTimeoutCaptor.getValue() >= 0);
  }

  @Test
  public void testAwaitTermination_primaryTimesOut() throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    long timeout = 10;
    TimeUnit unit = TimeUnit.SECONDS;

    when(mockPrimaryDelegateChannel.awaitTermination(timeout, unit)).thenReturn(false);

    assertFalse(gcpFallbackChannel.awaitTermination(timeout, unit));

    verify(mockPrimaryDelegateChannel).awaitTermination(timeout, unit);
    verify(mockFallbackDelegateChannel, never()).awaitTermination(anyLong(), any(TimeUnit.class));
    verify(mockScheduledExecutorService, never()).awaitTermination(anyLong(), any(TimeUnit.class));
  }

  @Test
  public void testAwaitTermination_fallbackTimesOut() throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    long timeout = 10;
    TimeUnit unit = TimeUnit.SECONDS;

    when(mockPrimaryDelegateChannel.awaitTermination(timeout, unit)).thenReturn(true);
    when(mockFallbackDelegateChannel.awaitTermination(anyLong(), eq(NANOSECONDS)))
        .thenReturn(false);

    assertFalse(gcpFallbackChannel.awaitTermination(timeout, unit));

    verify(mockPrimaryDelegateChannel).awaitTermination(timeout, unit);
    verify(mockFallbackDelegateChannel).awaitTermination(anyLong(), eq(NANOSECONDS));
    verify(mockScheduledExecutorService, never()).awaitTermination(anyLong(), any(TimeUnit.class));
  }

  @Test
  public void testAwaitTermination_executorTimesOut() throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    long timeout = 10;
    TimeUnit unit = TimeUnit.SECONDS;

    when(mockPrimaryDelegateChannel.awaitTermination(timeout, unit)).thenReturn(true);
    when(mockFallbackDelegateChannel.awaitTermination(anyLong(), eq(NANOSECONDS))).thenReturn(true);
    when(mockScheduledExecutorService.awaitTermination(anyLong(), eq(NANOSECONDS)))
        .thenReturn(false);

    assertFalse(gcpFallbackChannel.awaitTermination(timeout, unit));

    verify(mockPrimaryDelegateChannel).awaitTermination(timeout, unit);
    verify(mockFallbackDelegateChannel).awaitTermination(anyLong(), eq(NANOSECONDS));
    verify(mockScheduledExecutorService).awaitTermination(anyLong(), eq(NANOSECONDS));
  }

  @Test
  public void testAwaitTermination_primaryThrowsInterruptedException() throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    InterruptedException interruptedException =
        new InterruptedException("Primary awaitTermination failed");
    when(mockPrimaryDelegateChannel.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenThrow(interruptedException);

    try {
      gcpFallbackChannel.awaitTermination(10, TimeUnit.SECONDS);
      fail("Should have thrown InterruptedException");
    } catch (InterruptedException e) {
      assertEquals(interruptedException, e);
    }
    verify(mockFallbackDelegateChannel, never()).awaitTermination(anyLong(), any(TimeUnit.class));
    verify(mockScheduledExecutorService, never()).awaitTermination(anyLong(), any(TimeUnit.class));
  }

  @Test
  public void testAwaitTermination_fallbackThrowsInterruptedException()
      throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    InterruptedException interruptedException =
        new InterruptedException("Fallback awaitTermination failed");
    when(mockPrimaryDelegateChannel.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenReturn(true);
    when(mockFallbackDelegateChannel.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenThrow(interruptedException);

    try {
      gcpFallbackChannel.awaitTermination(10, TimeUnit.SECONDS);
      fail("Should have thrown InterruptedException");
    } catch (InterruptedException e) {
      assertEquals(interruptedException, e);
    }
    verify(mockScheduledExecutorService, never()).awaitTermination(anyLong(), any(TimeUnit.class));
  }

  @Test
  public void testAwaitTermination_executorThrowsInterruptedException()
      throws InterruptedException {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    InterruptedException interruptedException =
        new InterruptedException("Executor awaitTermination failed");
    when(mockPrimaryDelegateChannel.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenReturn(true);
    when(mockFallbackDelegateChannel.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenReturn(true);
    when(mockScheduledExecutorService.awaitTermination(anyLong(), any(TimeUnit.class)))
        .thenThrow(interruptedException);

    try {
      gcpFallbackChannel.awaitTermination(10, TimeUnit.SECONDS);
      fail("Should have thrown InterruptedException");
    } catch (InterruptedException e) {
      assertEquals(interruptedException, e);
    }
  }

  @Test
  public void testIsShutdown_checksAllComponents() {
    initializeChannelAndCaptureTasks(getDefaultOptions());

    // Case 1: All shutdown.
    when(mockPrimaryDelegateChannel.isShutdown()).thenReturn(true);
    when(mockFallbackDelegateChannel.isShutdown()).thenReturn(true);
    when(mockScheduledExecutorService.isShutdown()).thenReturn(true);
    assertTrue(
        "All components shutdown -> isShutdown() should be true.", gcpFallbackChannel.isShutdown());

    // Case 2: Primary is not shutdown.
    when(mockPrimaryDelegateChannel.isShutdown()).thenReturn(false);
    // fallback and exec are still true from previous when().
    assertFalse(
        "Primary is not shutdown -> isShutdown() should be false.",
        gcpFallbackChannel.isShutdown());
    when(mockPrimaryDelegateChannel.isShutdown()).thenReturn(true); // Reset for next case.

    // Case 3: Fallback is not shutdown (primary is shutdown).
    when(mockFallbackDelegateChannel.isShutdown()).thenReturn(false);
    // exec is still true.
    assertFalse(
        "Fallback not shutdown -> isShutdown() should be false.", gcpFallbackChannel.isShutdown());
    when(mockFallbackDelegateChannel.isShutdown()).thenReturn(true); // Reset.

    // Case 4: Executor is not shutdown (primary and fallback are shutdown).
    when(mockScheduledExecutorService.isShutdown()).thenReturn(false);
    assertFalse(
        "Executor not shutdown -> isShutdown() should be false.", gcpFallbackChannel.isShutdown());
  }

  @Test
  public void testIsTerminated_checksAllComponents() {
    initializeChannelAndCaptureTasks(getDefaultOptions());

    // Case 1: All terminated.
    when(mockPrimaryDelegateChannel.isTerminated()).thenReturn(true);
    when(mockFallbackDelegateChannel.isTerminated()).thenReturn(true);
    when(mockScheduledExecutorService.isTerminated()).thenReturn(true);
    assertTrue(
        "All components terminated -> isTerminated() should be true.",
        gcpFallbackChannel.isTerminated());

    // Case 2: Primary not terminated.
    when(mockPrimaryDelegateChannel.isTerminated()).thenReturn(false);
    assertFalse(
        "Primary not terminated -> isTerminated() should be false.",
        gcpFallbackChannel.isTerminated());
    when(mockPrimaryDelegateChannel.isTerminated()).thenReturn(true);

    // Case 3: Fallback not terminated.
    when(mockFallbackDelegateChannel.isTerminated()).thenReturn(false);
    assertFalse(
        "Fallback not terminated -> isTerminated() should be false.",
        gcpFallbackChannel.isTerminated());
    when(mockFallbackDelegateChannel.isTerminated()).thenReturn(true);

    // Case 4: Executor not terminated.
    when(mockScheduledExecutorService.isTerminated()).thenReturn(false);
    assertFalse(
        "Executor not terminated -> isTerminated() should be false.",
        gcpFallbackChannel.isTerminated());
  }

  @Test
  public void testAuthority_usesPrimaryInitially() {
    initializeChannelAndCaptureTasks(getDefaultOptions());
    assertFalse(gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testAuthority_usesFallbackWhenInFallbackMode() {
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder().setMinFailedCalls(1).setErrorRateThreshold(0.1f).build();

    initializeChannelAndCaptureTasks(options);

    simulateCall(Status.UNAVAILABLE, false); // Trigger fallback.
    checkErrorRatesTask.run();

    assertTrue(gcpFallbackChannel.isInFallbackMode());
    assertEquals(fallbackAuthority, gcpFallbackChannel.authority());
  }

  @Test
  public void testConstructorWithBuilders_initializesAndBuildsChannels() {
    initializeChannelWithBuildersAndCaptureTasks(
        getDefaultOptions()); // This uses the builder constructor.

    verify(mockPrimaryBuilder).build();
    verify(mockFallbackBuilder).build();
    assertNotNull(gcpFallbackChannel);
    assertFalse("Should not be in fallback mode initially.", gcpFallbackChannel.isInFallbackMode());
    assertEquals(primaryAuthority, gcpFallbackChannel.authority());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testProbingTasksScheduled_ifConfigured() {
    Function<Channel, String> mockPrimaryProber = mock(Function.class);
    Function<Channel, String> mockFallbackProber = mock(Function.class);

    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setPrimaryProbingFunction(mockPrimaryProber)
            .setFallbackProbingFunction(mockFallbackProber)
            .setPrimaryProbingInterval(Duration.ofSeconds(5))
            .setFallbackProbingInterval(Duration.ofSeconds(10))
            .build();

    initializeChannelAndCaptureTasks(options);

    assertNotNull(primaryProbingTask);
    assertNotNull(fallbackProbingTask);

    primaryProbingTask.run();
    verify(mockPrimaryProber).apply(mockPrimaryDelegateChannel);

    fallbackProbingTask.run();
    verify(mockFallbackProber).apply(mockFallbackDelegateChannel);
  }

  @Test
  public void testProbing_reportsMetrics() throws InterruptedException {
    Function<Channel, String> mockPrimaryProber =
        channel -> {
          return "test_error";
        };
    Function<Channel, String> mockFallbackProber =
        channel -> {
          return "";
        };

    TestMetricExporter exporter = new TestMetricExporter();
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setPrimaryProbingFunction(mockPrimaryProber)
            .setFallbackProbingFunction(mockFallbackProber)
            .setPrimaryProbingInterval(Duration.ofSeconds(5))
            .setFallbackProbingInterval(Duration.ofSeconds(10))
            .setGcpFallbackOpenTelemetry(
                GcpFallbackOpenTelemetry.newBuilder()
                    .withSdk(prepareOpenTelemetry(exporter))
                    .build())
            .build();

    initializeChannelAndCaptureTasks(options);

    assertNotNull(primaryProbingTask);
    assertNotNull(fallbackProbingTask);

    primaryProbingTask.run();
    fallbackProbingTask.run();

    TimeUnit.MILLISECONDS.sleep(200);
    List<MetricData> exportedMetrics = exporter.getExportedMetrics();

    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", PROBE_RESULT, "test_error"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback", PROBE_RESULT, ""));
  }

  @Test
  public void testProbing_reportsInitFailureForPrimary() throws InterruptedException {
    Function<Channel, String> mockPrimaryProber =
        channel -> {
          return "test_error";
        };
    Function<Channel, String> mockFallbackProber =
        channel -> {
          return "";
        };

    TestMetricExporter exporter = new TestMetricExporter();
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setPrimaryProbingFunction(mockPrimaryProber)
            .setFallbackProbingFunction(mockFallbackProber)
            .setPrimaryProbingInterval(Duration.ofSeconds(5))
            .setFallbackProbingInterval(Duration.ofSeconds(10))
            .setGcpFallbackOpenTelemetry(
                GcpFallbackOpenTelemetry.newBuilder()
                    .withSdk(prepareOpenTelemetry(exporter))
                    .build())
            .build();

    initializeChannelWithInvalidPrimaryBuilderAndCaptureTasks(options);

    assertNotNull(primaryProbingTask);
    assertNotNull(fallbackProbingTask);

    primaryProbingTask.run();
    fallbackProbingTask.run();

    TimeUnit.MILLISECONDS.sleep(200);
    List<MetricData> exportedMetrics = exporter.getExportedMetrics();

    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", PROBE_RESULT, INIT_FAILURE_REASON));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback", PROBE_RESULT, ""));
  }

  @Test
  public void testProbing_reportsInitFailureForFallback() throws InterruptedException {
    Function<Channel, String> mockPrimaryProber =
        channel -> {
          return "test_error";
        };
    Function<Channel, String> mockFallbackProber =
        channel -> {
          return "";
        };

    TestMetricExporter exporter = new TestMetricExporter();
    GcpFallbackChannelOptions options =
        getDefaultOptionsBuilder()
            .setPrimaryProbingFunction(mockPrimaryProber)
            .setFallbackProbingFunction(mockFallbackProber)
            .setPrimaryProbingInterval(Duration.ofSeconds(5))
            .setFallbackProbingInterval(Duration.ofSeconds(10))
            .setGcpFallbackOpenTelemetry(
                GcpFallbackOpenTelemetry.newBuilder()
                    .withSdk(prepareOpenTelemetry(exporter))
                    .build())
            .build();

    initializeChannelWithInvalidFallbackBuilderAndCaptureTasks(options);

    assertNotNull(primaryProbingTask);
    assertNotNull(fallbackProbingTask);

    primaryProbingTask.run();
    fallbackProbingTask.run();

    TimeUnit.MILLISECONDS.sleep(200);
    List<MetricData> exportedMetrics = exporter.getExportedMetrics();

    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "primary", PROBE_RESULT, "test_error"));
    assertSumMetrics(
        1,
        exportedMetrics,
        fullMetricName(PROBE_RESULT_METRIC),
        Attributes.of(CHANNEL_NAME, "fallback", PROBE_RESULT, INIT_FAILURE_REASON));
  }

  @Test
  public void testConstructor_failsWhenOptionsIsNull() {
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(
                    null, mockPrimaryDelegateChannel, mockFallbackDelegateChannel));
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(null, mockPrimaryBuilder, mockFallbackBuilder));
  }

  @Test
  public void testConstructor_failsWhenPrimaryIsNull() {
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(getDefaultOptions(), null, mockFallbackDelegateChannel));
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(getDefaultOptions(), null, mockFallbackBuilder));
  }

  @Test
  public void testConstructor_failsWhenFallbackIsNull() {
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(getDefaultOptions(), mockPrimaryBuilder, null));
    assertThrows(
        NullPointerException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(getDefaultOptions(), mockPrimaryBuilder, null));
  }

  @Test
  public void testConstructor_failsWhenBothBuildersFail() {
    assertThrows(
        RuntimeException.class,
        () ->
            gcpFallbackChannel =
                new GcpFallbackChannel(
                    getDefaultOptions(), mockPrimaryInvalidBuilder, mockFallbackInvalidBuilder));
  }
}
