# Session-Based Transport — Code Map

Reference notes for `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/`.
A new transport layered next to the existing gax-based stack. The "session" is a long-lived bidi gRPC
stream that carries many virtual RPCs (vRPCs), amortizing per-stream setup (TLS, auth, AFE routing)
across many short ops like `ReadRow` / `MutateRow`.

Root path (omitted from file refs below):
`google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/`

## Big picture

```
gax UnaryCallable surface (existing public API)
    └── compat/ops/DivertingUnaryCallable        ← routes % of calls to new stack via ClientConfigurationManager
            └── compat/ops/ReadRowShim, MutateRowShim, ReadRowShimInner   ← per-op handlers
                    └── api/TableAsync · AuthorizedViewAsync · MaterializedViewAsync   ← thin facade
                            └── api/TableBase.readRow/mutateRow
                                    ↓ wraps in
                                middleware/CancellableVRpc
                                    └── middleware/RetryingVRpc
                                            └── session/VRpcImpl   ← transport-level VRpc
                                                    ↑ created by
                                                session/SessionImpl.newCall(VRpcDescriptor)
                                                    ↑ chosen by
                                                session/SessionPoolImpl  ← uses session/DynamicPicker
                                                    ↑ runs on
                                                channels/SessionStream (= one bidi gRPC ClientCall)
                                                    ↑ from
                                                channels/ChannelPool (Single | Switching | Fallback | DpImpl)
                                                    ↑ built from
                                                api/ChannelProviders (CloudPath | DirectAccess | …)
```

`dp/` decides DirectPath eligibility once at shim startup. `csm/` provides VRpc/session tracers
plugged in at `TableBase` and `SessionImpl`.

---

## api/ — public-facing entry point of the new transport

- **Client.java** — top-level entry. `Client.create(ClientSettings)` builds creds, `Metrics`, starts
  `ClientConfigurationManager` (fetches initial server config), builds and starts a
  `SwitchingChannelPool`. `openTableAsync()` / `openAuthorizedViewAsync()` / `openMaterializedViewAsync()`
  create + start a `SessionPoolImpl` via the corresponding `*Async`. `close()` tears down pools, metrics,
  channel pool, config manager, executor — in that order.
- **ClientSettings.java** — AutoValue: `ChannelProvider`, `InstanceName`, `appProfileId`. Default
  provider is `DirectAccess.withFallback(DEFAULT_HOST)`.
- **ChannelProviders.java** — factories: `CloudPath` (TLS + call creds), `DirectAccess`
  (`google-c2p:///` URI + `GoogleDefaultChannelCredentials` + installs `DirectPathIpInterceptor`),
  `RawDirectPath` (ALTS to hardcoded IPs), `EmulatorChannelProvider` (plaintext). Each exposes
  `getFallback()` (non-empty only for `DirectAccess`) and `updateFeatureFlags()` so the
  `OpenSessionRequest` advertises `trafficDirectorEnabled`/`directAccessRequested` to the server.
  `ConfiguredChannelProvider` decorates with channel-level settings (keepalive, metric interceptors).
- **TableBase.java** — shared base for the three `*Async`. `createAndStart()` builds a
  `SessionPoolImpl` for the given `SessionDescriptor` + open-request proto. `readRow`/`mutateRow` wrap
  `pool.newCall(VRpcDescriptor)` in `RetryingVRpc` → `CancellableVRpc`, attach a `VRpcTracer` via
  `Metrics.newTableTracer`, build `VRpcCallContext` (deadline, idempotency), then start.
- **TableAsync.java / AuthorizedViewAsync.java / MaterializedViewAsync.java** — per-resource facades.
  Build the resource-specific `OpenXRequest`, pick the matching `VRpcDescriptor` constants. Expose
  `CompletableFuture<…> readRow(req, deadline)` / `mutateRow(...)` by creating a `UnaryResponseFuture`
  and handing it to `TableBase`. Materialized view has no `mutateRow` (read-only).
- **UnaryResponseFuture.java** — `CompletableFuture<T>` + `VRpcListener<T>`. Buffers one message,
  completes on close (OK → value, error → `VRpcException`).
- **VRpcException.java** — `StatusRuntimeException` carrying the full `VRpcResult` (so retry callers
  can see committed vs uncommitted).
- **InstanceName / TableName / AuthorizedViewName / MaterializedViewName** — AutoValue resource-name
  helpers with `toString()` / `parse(String)`.
- **Util.java** — `composeMetadata()` builds session-open headers (`bigtable-features`,
  `x-goog-request-params`); `isIdempotent()` inspects mutation list for non-idempotent ops
  (aggregates, server timestamps).

---

## session/ — session lifecycle, pool, pickers, transport-level vRPC

A `Session` = one bidi gRPC stream of `SessionRequest`/`SessionResponse`. Many sequential vRPCs
multiplex onto it (one-at-a-time today; multi-vRPC noted as TODO).

States: `NEW → STARTING → READY → CLOSING → WAIT_SERVER_CLOSE → CLOSED`.

### Session core
- **Session.java** — interface: `start(openReq, md, listener)`, `newCall(VRpcDescriptor)`,
  `close()`, `forceClose()`. `Listener` exposes `onReady` / `onGoAway` / `onClose`.
- **SessionImpl.java** — concrete. Wraps a `SessionStream` + a `SessionList.SessionHandle`. Wraps
  open request in `SessionRequest` envelope; `dispatchResponseMessage()` routes inbound
  `SessionResponse`: `OPEN_SESSION` → READY + notify pool; `SESSION_PARAMETERS` → heartbeat interval;
  `VIRTUAL_RPC`/`ERROR` → active `VRpcImpl`; `GO_AWAY` → graceful close; `HEARTBEAT` → reset deadline;
  `SESSION_REFRESH_CONFIG` → renegotiate `openParams`. `startRpc()` sends a `VirtualRpcRequest` for
  the owning `VRpcImpl`. Close is two-phase: CLOSING → wait for current vRPC → `startGracefulClose()`
  (send `CloseSessionRequest`, half-close). Watchdog force-closes if stuck in `WAIT_SERVER_CLOSE`.
- **SessionFactory.java** — thin: calls `channelPool.newStream(method, callOpts)`. Decouples pool
  from channel layer.
- **SessionInfo.java** — AutoValue: pool ref + log name `"<poolType>-<sessionNum>"`.
- **SessionList.java** — bookkeeping (caller holds the `SessionPoolImpl` lock). Groups sessions by
  AFE via `AfeHandle` (keyed on `PeerInfo.applicationFrontendId`); per-AFE idle queue + `PeakEwma`
  latency. `SessionHandle` lifecycle: `onSessionStarted` (start→AFE queue), `checkoutSession`,
  `onVRpcFinish` (returns + updates latency), `onSessionClosing` (GoAway), `onSessionClosed`. Also
  holds `PoolStats` (starting/ready/inUse/expectedCapacity) for `PoolSizer`.
- **SessionPool.java** — interface typed on the open-request proto.
- **SessionPoolImpl.java** — orchestrator. `start()` builds `OpenParams`, pre-creates sessions via
  `PoolSizer.getScaleDelta()`, starts Watchdog + heartbeat scheduler. `newCall()` asks
  `DynamicPicker`; if hit → `ForwardingVRpc` that calls `onVRpcComplete()` on close (returns session,
  drains pending). On miss → `PendingVRpc` parked in a deque, with deadline monitoring →
  `DEADLINE_EXCEEDED`. Session-ready event triggers `tryDrainPendingRpcs()`. GoAway triggers
  `PoolSizer.handleGoAway()` to decide replacement. Tracks `consecutiveUnimplementedFailures` —
  consumed by the shim layer to fall back to classic.
- **SessionPoolInfo.java** — AutoValue: `ClientInfo`, `SessionType`, name.
- **SessionUtil.java** — extracts `SessionType` from proto method/message options.
- **SessionCreationBudget.java** — token bucket throttling concurrent session-creates. Failures add
  time-delayed re-grant; live-updated from `ClientConfigurationManager`.

### Pickers
- **Picker.java** — abstract: `Optional<SessionHandle> pickSession()`.
- **SimplePicker.java** — uniform-random AFE → dequeue one session.
- **DynamicPicker.java** — wraps a concrete picker; swaps per `LoadBalancingOptions`. RANDOM →
  Simple; LEAST_IN_FLIGHT → `LeastInFlightPicker`; PEAK_EWMA → `LeastLatencyPicker`; default →
  `LeastInFlightPicker`.
- **LeastInFlightPicker.java** — partial Fisher-Yates over `randomSubsetSize`, picks AFE with
  fewest outstanding (= refCount − idle queue size).
- **LeastLatencyPicker.java** — same shape, scores by `AfeHandle.getE2eCost()` (peak-EWMA latency).
  Experimental.
- **PoolSizer.java** — desired count = in-use + headroom-fraction(in-use), clamped to
  `[minIdleSessions, maxIdleSessions]`. `handleGoAway`/`handleSessionClose`/`handleNewCall` return
  booleans for replacement.

### vRPC at the transport seam
- **VRpcDescriptor.java** — static registry of all vRPC types. Each carries: `SessionDescriptor`
  (session family — `SessionType`, `MethodDescriptor<SessionRequest,SessionResponse>`,
  header-params extractor for RLS, log-name extractor), `MethodInfo`, `Encoder`/`Decoder` (typed req
  ↔ payload bytes), `LegacyConverter` (to classic proto). Constants: `READ_ROW`, `MUTATE_ROW`,
  `READ_ROW_AUTH_VIEW`, `MUTATE_ROW_AUTH_VIEW`, `READ_ROW_MAT_VIEW`.
- **VRpcImpl.java** — transport-level `VRpc`. Created by `SessionImpl.newCall`. `start()` encodes
  typed request → `VirtualRpcRequest` (rpc_id, deadline, traceparent, payload) → `session.startRpc`.
  `handleResponse`/`handleError` decode and fire `VRpcListener`. `handleSessionClose` for stream
  death. `cancel()` → `session.cancelRpc`. Inner `VRpcSessionApi` is the narrow view of `SessionImpl`
  it depends on.

---

## channels/ — physical gRPC channels & their bidi streams

A `SessionStream` = one `ClientCall<SessionRequest, SessionResponse>` (one bidi call).

- **SessionStream.java** — interface: `start(Listener, md)`, `sendMessage`, `halfClose`,
  `forceClose`. Listener: `onBeforeSessionStart(PeerInfo)` (fires on headers, gives AFE identity),
  `onMessage`, `onClose`.
- **SessionStreamImpl.java** — wraps `ClientCall`. On `onHeaders` decodes base64
  `bigtable-peer-info` → `PeerInfo`, fires `onBeforeSessionStart`. Requests `MAX_VALUE` messages.
  Checks ALTS context to detect DirectPath.
- **ForwardingSessionStream.java** — delegation skeleton for decorators.
- **FailingSessionStream.java** — pre-failed: `start()` immediately `onClose(status)`. Used by
  `ChannelPoolDpImpl` when pool is closed.
- **ChannelPool.java** — interface: `start`, `close`, `newStream(method, callOpts)`, `updateConfig`.
  Sole output to session layer = `SessionStream`.
- **SingleChannelPool.java** — one `ManagedChannel`; for emulator/single-endpoint.
- **ChannelPoolDpImpl.java** — DirectPath-aware dynamic pool. Groups channels by AFE
  (`AfeChannelGroup` keyed on `applicationFrontendId`). `newStream()` picks least-loaded group below
  `softMaxPerGroup`; else uses `startingGroup` channel or creates new. After
  `onBeforeSessionStart`, "rehomes" channel to its AFE group. Channel slot freed on `onClose`;
  recycled on server-drain / UNIMPLEMENTED. Periodic `serviceChannels()` (1 min) thins parallel
  channels per group to 1 and resizes group count to `totalStreams / softMaxPerGroup * 2`.
  Invariant: one physical channel per AFE.
- **SwitchingChannelPool.java** — reads `ChannelPoolConfiguration.modeCase`: `CLOUD_PATH_ONLY` →
  fallback provider's pool; `DIRECT_ACCESS_ONLY` → primary's pool;
  `DIRECT_ACCESS_WITH_FALLBACK` → `FallbackChannelPool`. Atomically swaps delegate on config change
  (start new → close old).
- **FallbackChannelPool.java** — dual-pool with automatic switch. `currentPool` Atomic starts as
  primary (DirectPath). Counts primary success on `onBeforeSessionStart`, failure on non-OK
  `onClose` where session never opened. Periodic check: if `failures/(succ+fail) > errorRate`,
  switch to secondary + notify `PoolFallbackListener`. Switches back if config disables fallback.
- **FallbackConfiguration.java** — AutoValue: `isEnabled`, `errorRate`, `checkInterval`,
  primary/fallback pool refs.
- **DirectPathIpInterceptor.java** — logs when connected IP's DP-ness differs from expected
  (observability only).
- **DirectpathEnforcer.java** — installed on primary inside `FallbackChannelPool`. On `onHeaders`
  if no ALTS context → throws `UNAVAILABLE`, which becomes a counted primary failure.

---

## middleware/ — decorator stack above the transport VRpc

Stacked as decorators (not interceptor chain). Each layer is created fresh per op via
`Supplier<VRpc>`. Typical: `CancellableVRpc → RetryingVRpc → VRpcImpl`.

- **VRpc.java** — interface for one logical RPC. Unifies unary + server-streaming by always being
  server-streaming: `start(req, ctx, listener)` then `requestNext()`. Hosts:
  - `VRpcCallContext` — deadline, idempotency, attempt number, `VRpcTracer`.
  - `OperationInfo` — monotonic attempt counter + original deadline (retry-budget tracking).
  - `VRpcResult` — final outcome. `State` ∈ `{UNCOMMITED, TRANSPORT_FAILURE, SERVER_RESULT,
    USER_FAILURE}` + cluster info + backend latency + `RetryInfo` + `rejected` flag.
- **ForwardingVRpc.java** — pass-through base; `ForwardListener` forwards `onMessage`/`onClose`.
- **RetryingVRpc.java** — runs inside a gRPC `SynchronizationContext` (lock-free state machine
  `Idle → Active → Scheduled|Done`). Holds `Supplier<VRpc>` `attemptFactory`; fresh inner per
  attempt. `shouldRetry()`: (a) server returned `RetryInfo` with delay + deadline left, OR (b) ≤3
  attempts for `UNCOMMITED` or idempotent `TRANSPORT_FAILURE`. Schedules via
  `SynchronizationContext.schedule` on injected executor, wraps gRPC `Context` + OTel context for
  propagation. **NOT** gax retry. `requestNext()` throws `UnsupportedOperationException` — streaming
  retry not implemented.
- **CancellableVRpc.java** — extends `ForwardingVRpc`. Adds a gRPC `Context.CancellationListener`
  that calls `cancel()` on underlying. Explicitly skips `DEADLINE_EXCEEDED` (transport handles it).

---

## compat/ — bridge from gax public API to the new stack

Compatibility with the existing gax-based public API. New stack is opt-in per call, gated server-side.

- **Shim.java** — interface: `close()`, `decorateReadRow(classic, rowAdapter, settings)`,
  `decorateMutateRow(classic, settings)`. Only `ReadRow` and `MutateRow` shimmed today; others stay
  on classic path.
- **ShimImpl.java** — startup: (1) validates transport is `InstantiatingGrpcChannelProvider` else
  `DisabledShim`; (2) builds a DirectPath provider w/ cloud fallback, runs blocking
  `checkDirectAccessAvailable()` probe (`GetClientConfiguration` RPC, 5s timeout) — falls back to
  `GaxBasicChannelProvider` if probe fails or `PeerInfo.TransportType` isn't
  `DIRECT_ACCESS`/`SESSION_DIRECT_ACCESS`; (3) builds separate basic provider for config manager
  (always cloud); (4) fetches initial config sync (else `DisabledShim`); (5) sets sessions-required
  flag if config requires; (6) constructs `Client`, `ReadRowShimInner`, `MutateRowShim`.
- **DisabledShim.java** — no-op; `decorate*` returns classic unchanged.
- **Util.java** — `createSessionMap(factory)` = `LoadingCache` (5-min access expiry, removal
  listener calls `close()` on evicted). `extractDeadline(GrpcCallContext, defaultTimeout)` =
  earliest of ambient gRPC deadline, explicit call-opt deadline, gax retry total timeout.
- **FutureAdapter.java** — `CompletableFuture<V>` → `ApiFuture<V>`. Holds a `CancellableContext`
  closed when future completes; `cancel()` cancels both.
- **GaxDirectAccessChannelProvider.java** — `ChannelProvider`. Checks `canUseDirectPath()`; falls
  back silently. `createWithFallback()` keeps basic provider as fallback. Sets
  `trafficDirectorEnabled=true`, `directAccessRequested=true`.
- **GaxBasicChannelProvider.java** — non-DP provider. `attemptDirectPath(false)` + `CredInterceptor`
  installing `CallCredentials`. Empty `getFallback()`.

### compat/ops/
- **UnaryShim.java** — interface: `call(req, deadline) → CompletableFuture<RespT>`, `supports(req)`,
  `Closeable`. Owns `SessionPool`s, GC'd via Util session map.
- **DivertingUnaryCallable.java** — traffic-splitting callable. Per-call: if `supports(req)` →
  reads `sessionLoad` float from `ClientConfigurationManager.getSessionConfiguration()`. 0 → always
  classic; 1 → always experimental; else random. Experimental path: creates `CancellableContext`,
  calls `experimental.call`, translates errors → gax `ApiException`, returns `FutureAdapter`.
- **ReadRowShimInner.java** — stateful. Three `LoadingCache`s: table → `TableAsync`, auth-view →
  `AuthorizedViewAsync`, mat-view → `MaterializedViewAsync` (all opened with write permission at
  `Client`). `supports()` checks `consecutiveUnimplementedFailures < 30` unless `hasSession()`.
  `call()` translates `Query` → `SessionReadRowRequest`, dispatches to the resource async.
- **ReadRowShim.java** — stateless: pairs `ReadRowShimInner` with a `RowAdapter<RowT>`. Translates
  proto response to user-facing row by walking families/columns/cells via `RowBuilder`.
- **MutateRowShim.java** — analog for writes. Caches `TableAsync` + `AuthorizedViewAsync` (write).
  No mat-view.

**Rollout strategy**: shim is an all-or-nothing startup gate (gRPC transport + DP probe + initial
config), then per-call float ratio from server config. Server can ramp traffic without a client
release.

---

## csm/ — client-side metrics

Bigtable bundles its own OTel exporter that's on by default. Three metric flavors:
table-based (bigtable_table mirror), client-based (bigtable_client e2e health), client-based gRPC
(from gRPC OTel plugin). See `csm/package-info.java`.

### Top-level
- **Metrics.java** — vended interface. `newTableTracer(poolInfo, descriptor, deadline) → VRpcTracer`,
  `newSessionTracer(poolInfo) → SessionTracer`, `getPoolFallbackListener()`,
  `getDirectPathCompatibleTracer()`, `getDebugTagTracer()`, `createTracerFactory(clientInfo) →
  ApiTracerFactory` (legacy gax bridge), `configureGrpcChannel(builder)` (attaches OTel gRPC
  plugin), `start`, `close`.
- **MetricRegistry.java** — typed defs for every metric instrument: operation/attempt latency,
  retry count, first-response, server, channel-pool outstanding, connectivity errors, session
  uptime/duration/open latency, transport latency, pacemaker delay, channel fallback count, DP-compat
  gauge, debug-tag count, batch flow-control, remaining deadline. Also registers gRPC-internal
  metric pass-throughs (RLS, xDS, subchannel). Two `RecorderRegistry` factories: internal vs user.
- **MetricsImpl.java** — concrete. Holds both `RecorderRegistry`s, `GrpcOpenTelemetry`,
  `ChannelPoolMetricsTracer`, `DirectPathCompatibleTracer`, `DebugTagTracer`, `Pacemaker`,
  `PoolFallbackListener`. `newTableTracer` composes up to 3 tracers into `CompositeVRpcTracer`:
  internal `VRpcTracerImpl`, optional user `VRpcTracerImpl`, optional `UserApiVRpcTracer`.
  `start()` kicks off channel-pool polling, pacemaker, 1-min session-uptime loop.
- **NoopMetrics.java** — disabled mode (tests / no OTel).

### tracers/ (the session-transport seam)
- **VRpcTracer.java** — interface: `onOperationStart` / `onAttemptStart(req)` /
  `onRequestSent(PeerInfo)` / `onResponseReceived` / `recordApplicationBlockingLatencies(Duration)` /
  `onAttemptFinish(result)` / `onOperationFinish(result)`.
- **VRpcTracerImpl.java** — records timers for attempt, operation, client-blocking (start →
  request sent), first-response, application-blocking. `onAttemptFinish` records attempt latency
  (with + without `PeerInfo`), connectivity-error count, transport latency (attempt − backend),
  remaining deadline. `onOperationFinish` records operation latency, app blocking, first response,
  retry count.
- **SessionTracer.java** — interface: `onStart` / `onOpen(PeerInfo)` / `onVRpcClose(Code)` /
  `onClose(PeerInfo, reason, status)` / `recordAsyncMetrics()` (returns `false` when done).
- **SessionTracerImpl.java** — tracks state + `hasOkRpcs`/`hasErrorRpcs` + `lastPeerInfo`. Records
  session open latency (also again on close if never ready), session duration with close reason and
  vRPC outcome mix. `recordAsyncMetrics` records uptime gauge.
- **CompositeVRpcTracer.java** — fan-out; swallows child exceptions.
- **UserApiVRpcTracer.java** — bridge from new VRpc lifecycle → legacy gax `ApiTracer`. Uses
  `VRpcDescriptor.toLegacyProto` for request conversion. Lets user-installed `ApiTracerFactory`
  observe ops on the new transport.
- **PoolFallbackListener.java / PoolFallbackListenerImpl.java** — single-method `onFallback(from,
  to, reason)`; reasons: `ERROR_RATE`, `FALLBACK_DISABLE`. Fires from `FallbackChannelPool`,
  records `channelFallbackCount`.

### exporter/ (brief)
`BigtableCloudMonitoringExporter` (OTel → Cloud Monitoring `TimeSeries`),
`BigtableFilteringExporter` (predicate on metric name; routes internal metrics to internal CM
project), `BigtablePeriodicReader` (custom OTel `MetricReader` on `ScheduledExecutorService`),
`Converter` (OTel → CM proto).

### opencensus/ (brief)
`MetricsTracerFactory` / `MetricsTracer` — legacy gax `ApiTracer` impls using OpenCensus
`StatsRecorder`. Wired via `MetricsImpl.createTracerFactory` for classic stack.

---

## dp/ — DirectPath eligibility

- **DirectAccessChecker.java** — interface: `check(Channel) → boolean` (always shuts down the
  channel), `investigateFailure(Throwable)` (background diagnosis).
- **NoopDirectAccessChecker.java** — always `false`. DP disabled.
- **AlwaysEnabledDirectAccessChecker.java** — always `true`. Tests / forced-on.
- **ClassicDirectAccessChecker.java** — production. Wraps probe channel with
  `MetadataExtractorInterceptor`, runs `channelPrimer.primeChannel`, reads `PeerInfo.TransportType`
  from response headers — true iff `TRANSPORT_TYPE_DIRECT_ACCESS`. `PERMISSION_DENIED` falls back to
  ALTS check (`sidebandData.isAlts()`). Other errors → `investigateFailure`. Records success on
  `DirectPathCompatibleTracer`. Always shuts down channel in `finally`.
- **DirectAccessInvestigator.java** — off-thread diagnosis. `FailureReason` enum: `NOT_IN_GCP`,
  `METADATA_UNREACHABLE`, `NO_IP_ASSIGNED`, `LOOPBACK_DOWN`, `LOOPBACK_V4_MISSING`,
  `LOOPBACK_V6_MISSING`, `USER_DISABLED`, `UNKNOWN`. Today: always `UNKNOWN` (TODO). Records on
  `DirectPathCompatibleTracer`.

**Where the check fires**: DP eligibility is decided **once at `ShimImpl.create()` startup** (not
per call) using a temporary probe channel (`GetClientConfiguration`, 5s deadline). The `channels/`
layer also uses `ClassicDirectAccessChecker` at session-open time via `ChannelPool`. `ShimImpl`
inlines its own probe logic rather than calling the checker.

---

## End-to-end call flow: `client.openTableAsync("t", READ_WRITE).readRow(req, deadline)`

1. `TableAsync.createAndStart()` → `TableBase.createAndStart()` → new `SessionPoolImpl` →
   `pool.start(OpenTableRequest, md)`.
2. `SessionPoolImpl.start()` pre-creates sessions per `PoolSizer.getScaleDelta()`. Each
   `createSession()` → `SessionFactory.createNew()` → `channelPool.newStream(method, callOpts)`.
3. `SwitchingChannelPool` → underlying pool (`FallbackChannelPool` / `ChannelPoolDpImpl` / single)
   → gRPC `ClientCall` wrapped in `SessionStreamImpl`.
4. `new SessionImpl(metrics, poolInfo, n, stream)` → `session.start(openReq, headers, listener)` →
   wraps openReq in `SessionRequest` → `stream.start` + `stream.sendMessage`.
   `SessionStreamImpl` does `call.start` + `call.request(MAX_VALUE)`.
5. Server headers → `SessionStreamImpl` decodes `bigtable-peer-info`, fires
   `onBeforeSessionStart(peerInfo)`. In `ChannelPoolDpImpl`, this rehomes the channel into its
   AFE group. Then server sends `OPEN_SESSION` in the stream → `SessionImpl.handleOpenSessionResponse`
   → READY → `SessionPool.onSessionReady` → added to AFE queue in `SessionList`.
6. User → `tableAsync.readRow(req, deadline)` → `TableBase.readRow` wraps `RetryingVRpc` around
   `sessionPool.newCall(READ_ROW)` supplier. `SessionPoolImpl.newCall()` → `DynamicPicker` →
   `LeastInFlightPicker` → `SessionList.checkoutSession()` → returns `SessionHandle`.
   `handle.getSession().newCall(READ_ROW)` → `VRpcImpl`.
7. `VRpcImpl.start(req, ctx, listener)`: encodes typed request via `VRpcDescriptor.READ_ROW.encode`,
   builds `VirtualRpcRequest` → `session.startRpc(this, payload)` →
   `stream.sendMessage(SessionRequest{ virtualRpc: payload })`.
8. Server replies `SessionResponse{ virtualRpcResponse }` → `SessionImpl.handleVRpcResponse` →
   `VRpcImpl.handleResponse` → `VRpcDescriptor.READ_ROW.decode` → `listener.onMessage(resp)` →
   `listener.onClose(OK)`. `UnaryResponseFuture` completes the `CompletableFuture`.
9. `SessionImpl` clears `currentRpc`, calls `onVRpcComplete()` in the pool → `handle.onVRpcFinish()`
   re-queues session + updates `AfeHandle` latency → `tryDrainPendingRpcs()` dispatches anything
   queued.

---

## Key invariants & landmarks

- **Per-AFE channel**: `ChannelPoolDpImpl` keeps one physical gRPC channel per AFE, sized to demand.
- **Session = bidi stream**: One `SessionStream` = one bidi `ClientCall`; many sequential vRPCs reuse it.
- **vRPC multiplexing**: Today one-at-a-time per session (TODO comment in `Session.java`).
- **Picker drives load balancing across AFEs**, not across sessions within an AFE (per-AFE queue is FIFO).
- **Retry is custom**, not gax — see `RetryingVRpc`. Streaming retry not implemented.
- **Rollout** is server-controlled: `ClientConfigurationManager` ships a `sessionLoad` float; the
  shim splits traffic per call. Only `ReadRow` + `MutateRow` are wired in today.
- **Fallback to classic** when the new pool hits `consecutiveUnimplementedFailures >= 30` (and no
  active session).
- **DirectPath fallback** between primary/secondary pools is automatic and bidirectional via
  `FallbackChannelPool`'s error-rate check.
