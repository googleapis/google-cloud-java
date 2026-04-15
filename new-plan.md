# Implementation Plan: gRPC Channel Load Visibility (Datastore-Specific)

This plan outlines the implementation of a custom gRPC client interceptor to measure the latency
between when a user initiates a request and when the server begins responding. This is used to
diagnose latency caused by exceeding `MAX_CONCURRENT_STREAMS` on a gRPC channel.

Scoped to the Datastore library initially. Once validated, it can be promoted to GAX so all
services benefit without duplication.

---

## Background: The MAX_CONCURRENT_STREAMS Problem

HTTP/2 limits the number of concurrent streams per connection via the `MAX_CONCURRENT_STREAMS`
setting, which the server advertises. For Google services this defaults to 100. When a gRPC
channel reaches this limit, new calls are buffered inside gRPC's HTTP/2 encoder and wait for an
existing stream to close before being sent on the wire. From the application's perspective the
call appears to be in flight, but it is actually queued and adding latency invisibly.

GAX's `ChannelPool` already mitigates this by spreading load across multiple channels and
auto-scaling the pool. However, individual channels can still become overwhelmed. There is
currently no per-call observability into how loaded a channel was at dispatch time or how long a
call waited before the server acknowledged it.

---

## Key Findings and Design Decisions

### Finding 1: MAX_CONCURRENT_STREAMS cannot be read from gRPC

The server-advertised `MAX_CONCURRENT_STREAMS` value is stored inside the shaded Netty HTTP/2
codec and is not accessible through any public gRPC API. Investigated:

- **`ManagedChannel` public API** — exposes connectivity state only; no HTTP/2 settings.
- **`io.grpc.InternalChannelz`** (`@Internal`) — exposes `SocketStats`/`TransportStats` per
  connection. These include flow control windows and stream counters but **not**
  `MAX_CONCURRENT_STREAMS`. `SocketOptions.others` contains TCP-level socket options only.
- **`ClientStreamTracer`** — a public per-call lifecycle hook; no access to transport-level
  SETTINGS frames.

The configured threshold `ChannelPoolSettings.getMaxRpcsPerChannel()` (default 100) serves as
the effective calibration value. When `active_rpcs` approaches this number, queuing is likely.

### Finding 2: `ClientStreamTracer.streamCreated()` fires before the queuing decision

`ClientStreamTracer.streamCreated()` may appear to be a good signal for "when the request was
actually sent on the wire," but it was verified against the gRPC-java 1.76.3 source and found
to be **unreliable for MAX_CONCURRENT_STREAMS detection**.

**The actual call path (verified from gRPC-java source):**

```
ClientCall.start()
  └─→ NettyClientTransport.newStream()
        ├─→ new NettyClientStream(statsTraceCtx, ...)   ← AbstractClientStream constructor
        │     └─→ StatsTraceContext.newClientContext(tracers, headers)
        │           └─→ tracer.streamCreated()          ← fires HERE
        │
        └─→ http2Encoder.writeHeaders(...)              ← frames sent OR buffered HERE
```

`streamCreated()` fires inside the `NettyClientStream` constructor, as part of
`StatsTraceContext.newClientContext()`. This happens **before** the HTTP/2 encoder decides
whether to send the frames immediately or buffer them because the channel is at
`MAX_CONCURRENT_STREAMS` capacity.

For calls queued due to `MAX_CONCURRENT_STREAMS`, `streamCreated()` still fires immediately when
`newStream()` is called. The queueing happens afterward at the encoder level. This means
`start() → streamCreated()` is near-zero for **all** calls, queued or not, making it useless as
a queuing signal.

**Note on `DelayedClientTransport`:** This transport is used when no transport is available at
all (e.g., the channel is still connecting). It does NOT handle `MAX_CONCURRENT_STREAMS`.
When a call is buffered in `DelayedClientTransport`, it calls `tracer.createPendingStream()` —
a *different* method from `streamCreated()`. So even this path does not trigger `streamCreated()`
early for the MAX_CONCURRENT_STREAMS case.

### Decision: Use `onHeaders()` as the end timestamp

`ClientCall.Listener.onHeaders()` fires when the **client receives the server's response HEADERS
frame**. This is the first signal that the request left the client, traversed the network, and
the server has started processing it. It is impossible for the server to send response headers
before it has received and started handling the request, so `onHeaders()` is an unambiguous
lower bound on "the call was actually dispatched."

**The HTTP/2 frame sequence:**

```
Client                                                   Server
──────                                                   ──────
[interceptCall() — snapshot active_rpcs, capture Span]
  │
[ClientCall.start() — T0, record startNanos]
  │
  │  [if at MAX_CONCURRENT_STREAMS: buffered in encoder, no frames sent yet]
  │
  ├─→ HEADERS frame (request headers) ─────────────────→
  ├─→ DATA frame(s) (serialized request proto) ─────────→
  │                                  ←───────────────── HEADERS frame (response headers)
  [onHeaders() fires — T1]
  │                                  ←───────────────── DATA frame(s) (response proto)
  │                                  ←───────────────── TRAILERS frame (gRPC status)
  [onClose() fires — decrement activeRpcs]
```

`dispatch_latency = T1 - T0` captures:
- Queue wait time inside the HTTP/2 encoder (if `MAX_CONCURRENT_STREAMS` was reached)
- Network round-trip time
- Server processing time before sending response headers

### Finding 3: dispatch_latency is not a guaranteed queuing indicator in isolation

The delay includes network RTT and server processing time in addition to any queue wait. A high
`dispatch_latency` could be caused by:
- Slow server processing (e.g., a database query behind the RPC)
- High network latency (cross-region calls)
- Server-side overload independent of the HTTP/2 limit
- Connection re-establishment after a GFE disconnect

**What makes queuing distinguishable through correlation:**

1. **`grpc.channel.active_rpcs` near 100 on the same span.** If a slow call also shows
   `active_rpcs = 98`, the channel was close to capacity when the call was dispatched.
   If `active_rpcs = 4`, the channel was idle and the latency has another cause.
2. **Cross-channel comparison.** If one channel's spans have elevated `dispatch_latency` while
   sibling channels in the same pool show normal latency for the same RPC methods at the same
   time, that channel is the bottleneck.
3. **`active_rpcs >= 100`.** When `outstandingRpcs` on a single channel reaches or exceeds the
   threshold, calls are definitionally queued. No inference required.

### Decision: Record as trace span attributes

Stamp both values onto the existing per-call RPC span so operators can query their trace backend
for specific overloaded calls. For example: filter spans where
`grpc.channel.active_rpcs > 80 AND grpc.channel.dispatch_latency_ms > 200` to find calls that
were both on a loaded channel and experienced elevated latency.

### Decision: Self-contained active_rpcs counter in the interceptor

`ChannelPool.Entry` already tracks `outstandingRpcs` internally, but exposing it to Datastore
would require changes to GAX. For this Datastore-specific proof of concept, the interceptor
maintains its own `AtomicInteger` counter:
- Incremented in `interceptCall()` when a new call is created
- Decremented in the response listener's `onClose()` when the call completes

This is self-contained inside `java-datastore` with no GAX changes. When promoted to GAX later,
this counter can be replaced by reading directly from `ChannelPool.Entry.outstandingRpcs` to
avoid double-counting.

---

## New Span Attributes

| Attribute | Type | Recorded at | Value includes current call? | Absent when |
|---|---|---|---|---|
| `grpc.channel.active_rpcs` | `long` | `interceptCall()` — the moment the call is assigned to the channel, on the calling thread | Yes — counter is incremented before snapshot; value represents total concurrent calls on this channel including this one | Never — always stamped |
| `grpc.channel.dispatch_latency_ms` | `double` | `onHeaders()` — elapsed ms since `start()` | N/A | Call fails before receiving response headers |

`grpc.channel.uuid` is already recorded by `GrpcChannelUUIDInterceptor` via
`apiTracer.connectionSelected(uuid)` and does not change.

---

## Proposed Changes

### [NEW] `GrpcChannelLoadInterceptor.java`
`java-datastore/google-cloud-datastore/src/main/java/com/google/cloud/datastore/telemetry/`

A `ClientInterceptor` that:

1. Maintains an `AtomicInteger activeRpcs` counter scoped to this interceptor instance (one
   instance per physical channel).
2. In `interceptCall()` — fires synchronously on the calling thread when the call is created:
   - Increments `activeRpcs` then immediately snapshots the value. The snapshot includes the
     current call, so it represents the total number of concurrent calls on this channel at the
     moment this call was dispatched (e.g., a value of 95 means 95 calls are active including
     this one).
   - Captures the current OTel `Span` from `Context.current()`. This must happen here on the
     calling thread. `onHeaders()` fires later on a gRPC transport thread where
     `Span.current()` would return a no-op span — the reference captured now is the only safe
     way to reach the correct span from that callback.
   - Stamps `grpc.channel.active_rpcs` on the captured span immediately, so the attribute is
     present even if the call fails before `onHeaders()`.
   - Returns a `ForwardingClientCall` that overrides:
     - `start()` — records `startNanos = System.nanoTime()` to begin timing dispatch latency.
     - `onHeaders()` in the response listener — computes
       `dispatchLatencyMs = (nanoTime() - startNanos) / 1_000_000.0`, stamps
       `grpc.channel.dispatch_latency_ms` on the captured span. Uses `AtomicBoolean
       headersReceived` to ensure this is recorded at most once.
     - `onClose()` in the response listener — decrements `activeRpcs`. If `headersReceived`
       is still false (call failed before headers), skips recording `dispatch_latency_ms`.

### [MODIFY] `EnabledTraceUtil.java`
`java-datastore/google-cloud-datastore/src/main/java/com/google/cloud/datastore/telemetry/`

Modify `OpenTelemetryGrpcChannelConfigurator.apply()` to register the new interceptor alongside
the existing `grpcTelemetry.newClientInterceptor()`:

```java
@Override
public ManagedChannelBuilder apply(ManagedChannelBuilder managedChannelBuilder) {
    GrpcTelemetry grpcTelemetry = GrpcTelemetry.create(getOpenTelemetry());
    return managedChannelBuilder.intercept(
        grpcTelemetry.newClientInterceptor(),
        new GrpcChannelLoadInterceptor()
    );
}
```

Because `channelConfigurator` is called once per channel created by `ChannelPool.createSingleChannel()`,
each `GrpcChannelLoadInterceptor` instance is scoped to exactly one physical channel. This means
`activeRpcs` on each interceptor reflects the load on that specific channel, not the aggregate
pool load.

---

## Verification Plan

### Automated Tests
New file: `GrpcChannelLoadInterceptorTest.java`
`java-datastore/google-cloud-datastore/src/test/java/com/google/cloud/datastore/telemetry/`

- `grpc.channel.active_rpcs` is stamped on the span at `interceptCall()` time with the correct value, including the current call in the count.
- `grpc.channel.dispatch_latency_ms` is stamped on the span when `onHeaders()` fires.
- `dispatch_latency_ms` is **absent** on calls that fail before `onHeaders()`.
- No double-recording when `onHeaders()` is called more than once.
- Span is captured on the calling thread: simulate `onHeaders()` on a separate thread with no
  active OTel context and verify attributes still appear on the correct span.
- `activeRpcs` is decremented correctly on `onClose()`, including on error paths.

### Manual Verification
Run Datastore operations with OpenTelemetry enabled and confirm traces contain both new
attributes. At high concurrency (100+ concurrent calls on a single channel), confirm that spans
with `active_rpcs` near 100 also show elevated `dispatch_latency_ms`.
