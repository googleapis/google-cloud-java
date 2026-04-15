# Per-Channel Active RPC Visibility and Queuing Detection

## Problem Statement

For high-utilization, highly-concurrent gRPC clients, some customers may see increased request
latency. The suspected cause is the `MAX_CONCURRENT_STREAMS` limit enforced by the server over
HTTP/2. When active requests on a single channel exceed this limit (100 for Google services),
gRPC queues new calls inside the transport layer, adding latency on top of normal RTT and server
processing time.

GAX already provides a channel pool that spreads load across multiple HTTP/2 connections and
auto-scales the pool based on outstanding RPC counts. However, even with a pool, individual
channels can become overwhelmed. There is currently no way to observe how loaded each channel is
or whether calls are being queued on specific channels.

The goal is to add observable trace span attributes that allow operators to determine — on a
per-call basis — how loaded the selected channel was at dispatch time and how long the call
waited before the server acknowledged it.

---

## Background: How gRPC Channel Pooling Works Today

`ChannelPool` in `gax-grpc` manages a list of `ManagedChannel` instances and round-robins calls
across them via `AffinityChannel`. Each channel is wrapped in an `Entry` object that already
tracks:

- `outstandingRpcs` (`AtomicInteger`) — incremented when `newCall()` fires, decremented when
  `onClose()` fires on the response listener.
- `maxOutstanding` (`AtomicInteger`) — peak value over the last resize interval, used for
  auto-scaling every ~60 seconds.

`GrpcChannelUUIDInterceptor` already stamps each trace span with the UUID of the selected
channel via `apiTracer.connectionSelected(uuid)`. This gives traces the channel identity but
not the channel's load at the time of the call.

---

## Q&A: Key Design Questions

### Q1: Can the server-advertised MAX_CONCURRENT_STREAMS value be read from gRPC?

**No.** gRPC-java does not expose the server-advertised HTTP/2 `MAX_CONCURRENT_STREAMS` value
through any public API. It is negotiated at the transport layer and stored inside the shaded
Netty codec (`io.grpc.netty.shaded`). The options investigated:

- **`ManagedChannel` public API** — exposes connectivity state and lifecycle methods only; no
  HTTP/2 settings.
- **`io.grpc.InternalChannelz`** (`@Internal`) — exposes `SocketStats` and `TransportStats` per
  connection. `TransportStats` includes flow control windows and stream counts, but **not**
  `MAX_CONCURRENT_STREAMS`. `SocketOptions.others` contains TCP-level socket options only.
- **`ClientStreamTracer`** — a public per-call lifecycle hook API; has no access to
  transport-level SETTINGS frames.

**Conclusion:** The actual server-advertised limit cannot be read from gRPC. We use the
observable `outstandingRpcs` count relative to the configured threshold
(`ChannelPoolSettings.getMaxRpcsPerChannel()`, default 100) as the signal.

### Q2: How does the gRPC call lifecycle work at the HTTP/2 frame level?

A gRPC call maps directly to an HTTP/2 stream. The client sends frames first:

```
Client                                              Server
──────                                              ──────
HEADERS frame (request headers) ─────────────────→
DATA frame(s) (serialized request proto) ─────────→
                                 ←───────────────── HEADERS frame (response headers, HTTP 200)
                                 ←───────────────── DATA frame(s) (serialized response proto)
                                 ←───────────────── TRAILERS frame (gRPC status code)
```

In the gRPC-java API this maps to:
- `ClientCall.start()` — application hands the call to gRPC; the transport assigns an HTTP/2
  stream ID and sends the client-side HEADERS frame *(unless the transport is at capacity —
  see below)*.
- `ClientCall.Listener.onHeaders()` — fires when the **client receives the server's response
  HEADERS frame**. This is the first signal that the server has started processing the request.
- `ClientCall.Listener.onClose()` — fires after the TRAILERS frame; the stream is finished.

### Q3: What happens when MAX_CONCURRENT_STREAMS is reached?

When a channel has 100 active streams and a new call arrives:

```
ClientCall.start()
      ↓
  Transport at MAX_CONCURRENT_STREAMS?
       │
       ├── NO  → stream ID assigned immediately
       │         client HEADERS frame sent over the wire
       │         server processes and responds
       │         onHeaders() fires (normal RTT + server time)
       │
       └── YES → call buffered inside gRPC transport (DelayedClientTransport)
                 no frames sent — client is silent on this channel
                 waits until an existing stream closes and frees a slot
                 THEN stream ID assigned, HEADERS frame sent
                 server processes and responds
                 onHeaders() fires (queue wait time + RTT + server time)
```

From the application's perspective `ClientCall.start()` returns normally in both cases. The
queuing is transparent. The only observable difference is the elapsed time until `onHeaders()`.

### Q4: Is start()→onHeaders() latency a guaranteed indicator of transport queuing?

**No, it is not guaranteed.** The time between `start()` and `onHeaders()` is the sum of:

```
dispatch_latency = transport_queue_time   (only present if MAX_CONCURRENT_STREAMS hit)
                 + network RTT            (always present)
                 + server processing time (varies by RPC method and server load)
                 + GFE / load balancer overhead (always present for Google services)
```

A high `dispatch_latency` could be caused by:
- Slow server processing (e.g., a database query behind the RPC)
- High network latency (cross-region calls)
- Server-side overload independent of the HTTP/2 limit
- Connection re-establishment after a GFE disconnect

**What makes queuing distinguishable in practice:**

1. **`active_rpcs` at dispatch time approaches the threshold (100):** If the span attribute shows
   `grpc.channel.active_rpcs = 99` and `dispatch_latency = 800ms` on a call that is normally
   fast, queuing is the likely cause. If the same latency appears on a call where
   `active_rpcs = 3`, the cause is elsewhere.

2. **Cross-call comparison in traces:** Filter for spans where `grpc.channel.active_rpcs > 80`
   AND `dispatch_latency > X ms`. If only those calls are slow, the channel was saturated.

3. **`active_rpcs >= maxRpcsPerChannel`:** If `outstandingRpcs` on a single `Entry` reaches or
   exceeds `ChannelPoolSettings.getMaxRpcsPerChannel()` (default 100), calls are definitionally
   queued. This is the most direct signal.

4. **Cross-channel comparison:** If one channel's spans have high `dispatch_latency` while sibling
   channels show normal latency for the same RPC methods at the same time, the loaded channel is
   the bottleneck, not the server or network.

**Summary:** `dispatch_latency` alone is circumstantial. Combined with `active_rpcs` near the
threshold on the same span, and compared against sibling channels in the same trace window, the
picture becomes conclusive. The attributes are designed to be used together.

---

## Approach: Trace Span Attributes (not Metrics)

Rather than emitting aggregate metrics (histograms, gauges), this data is recorded as attributes
on the existing per-call RPC trace span. This means:

- Every individual call span carries a snapshot of channel load at dispatch time and the measured
  dispatch latency.
- Operators can query their trace backend to filter for calls where
  `grpc.channel.active_rpcs > 80` or `grpc.channel.dispatch_latency_ms > 200` and inspect
  exactly which calls were affected, when, and on which channel.
- Sampling is inherited from the existing trace sampling configuration — no separate metric
  infrastructure needed.

This complements (rather than replaces) the existing `ApiTracer.connectionSelected(uuid)` call
already made by `GrpcChannelUUIDInterceptor`.

---

## New Span Attributes

| Attribute | Type | Description |
|---|---|---|
| `grpc.channel.active_rpcs` | `long` | Snapshot of `outstandingRpcs` on the selected channel at the moment `ClientCall.start()` was called. |
| `grpc.channel.dispatch_latency_ms` | `double` | Milliseconds from `ClientCall.start()` to `ClientCall.Listener.onHeaders()`. Only recorded if headers were received (i.e., not on calls that failed before getting a response). |

`grpc.channel.uuid` is already recorded by `GrpcChannelUUIDInterceptor` via
`apiTracer.connectionSelected(uuid)` and does not need to change.

---

## Implementation Plan

### Changes to `ApiTracer`
`sdk-platform-java/gax-java/gax/src/main/java/com/google/api/gax/tracing/ApiTracer.java`

Add one new default method so existing implementations do not need to change:

```java
/** Records a snapshot of the channel load at the time the call was dispatched. */
default void channelLoadRecorded(int activeRpcs, double dispatchLatencyMs) {}
```

### Changes to `OpenTelemetryTracingTracer`
`sdk-platform-java/gax-java/gax/src/main/java/com/google/api/gax/tracing/OpenTelemetryTracingTracer.java`

Override `channelLoadRecorded` to stamp the current span:

```java
@Override
public void channelLoadRecorded(int activeRpcs, double dispatchLatencyMs) {
    span.setAttribute("grpc.channel.active_rpcs", activeRpcs);
    if (dispatchLatencyMs >= 0) {
        span.setAttribute("grpc.channel.dispatch_latency_ms", dispatchLatencyMs);
    }
}
```

`dispatchLatencyMs < 0` is used as a sentinel to record only the active RPC snapshot (at
`start()` time) without a latency value, since `onHeaders()` has not yet fired.

### Changes to `ChannelPool.java`
`sdk-platform-java/gax-java/gax-grpc/src/main/java/com/google/api/gax/grpc/ChannelPool.java`

**`Entry` inner class:**
- Add `final String uuid = UUID.randomUUID().toString()` (stable ID for cross-referencing with
  `GrpcChannelUUIDInterceptor`, which already stamps this UUID on spans via `connectionSelected`).

**`AffinityChannel.newCall()`** (line 564):
- After `getRetainedEntry(affinity)`, read the tracer from `callOptions`:
  ```java
  ApiTracer tracer = callOptions.getOption(GrpcCallContext.TRACER_KEY);
  ```
- Pass `tracer` and the `outstandingRpcs` snapshot into `ReleasingClientCall`.

**`ReleasingClientCall`** (line 574):
- Add fields: `@Nullable ApiTracer tracer`, `int activeRpcsAtDispatch`, `long startNanos`.
  These are set in the constructor from `AffinityChannel.newCall()`.
- Add `AtomicBoolean headersReceived = new AtomicBoolean(false)` alongside the existing
  `wasClosed` and `wasReleased` flags.

**`ReleasingClientCall.start()`** (line 586):
- Before delegating to `super.start()`:
  - Record `startNanos = System.nanoTime()`.
  - If `tracer != null`, call `tracer.channelLoadRecorded(activeRpcsAtDispatch, -1)` to stamp
    the active RPC count snapshot on the span immediately (even before headers arrive, so the
    attribute is present if the call later fails).
- In the `SimpleForwardingClientCallListener` already wrapping the response listener:
  - Override `onHeaders(Metadata headers)`:
    - If `headersReceived.CAS(false→true)`, compute
      `dispatchLatencyMs = (System.nanoTime() - startNanos) / 1_000_000.0`.
    - If `tracer != null`, call `tracer.channelLoadRecorded(activeRpcsAtDispatch, dispatchLatencyMs)`
      to update the span with the latency value.
    - Call `super.onHeaders(headers)`.
  - In the existing `onClose()` override: no additional action needed — the active RPC snapshot
    is already on the span from `start()`, and dispatch latency is only recorded when headers
    arrive. Calls that fail before headers simply will not have `dispatch_latency_ms`.

---

## Decrement Safety for `headersReceived`

`onHeaders()` is guaranteed to fire before `onClose()` on a successful call, and is skipped
entirely on an error path where the call fails before the server responds. The `AtomicBoolean
headersReceived` ensures the latency recording happens at most once even if gRPC's contract is
violated or the interceptor chain calls `onHeaders()` unexpectedly more than once.

---

## Verification

1. **Unit tests** in `ChannelPoolTest`:
   - Verify that a mock `ApiTracer` receives `channelLoadRecorded(activeRpcs, -1)` at `start()`
     time.
   - Verify that `channelLoadRecorded(activeRpcs, dispatchLatencyMs)` is called again with a
     positive latency value when `onHeaders()` fires.
   - Verify that `channelLoadRecorded` is called only once with a positive latency even if
     `onHeaders()` fires multiple times.
   - Verify that `dispatch_latency_ms` is **not** recorded on calls that fail before `onHeaders()`.

2. **`OpenTelemetryTracingTracer` tests**: verify that `channelLoadRecorded()` sets the expected
   span attributes.

3. **Integration**: verify that a full call through `InstantiatingGrpcChannelProvider` →
   `ChannelPool` → real channel produces a span with both `grpc.channel.active_rpcs` and
   `grpc.channel.dispatch_latency_ms` attributes.
