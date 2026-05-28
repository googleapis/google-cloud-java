# Threading Refactor Implementation Plan

Target model: `DirectExecutor` on gRPC session streams + per-session `SynchronizationContext` +
per-op `SerializingExecutor(CachedThreadPool)`. See `THREADING_MODEL.md` for rationale.

Each step below is intended to be a single reviewable PR. Steps within a phase depend on the
previous step. Phase 5 (per-AFE sharding) is independent of all other phases and can run in
parallel.

All affected packages live under `com.google.cloud.bigtable.data.v2.internal`, so API
signatures (e.g. `VRpcSessionApi`, `RetryingVRpc`, `TableBase`) can be changed freely without
backwards-compatibility concerns.

## Progress

| Step | Status | Commit |
|------|--------|--------|
| 1 | ✅ done | `67f89c5101a` |
| 2 | ✅ done | `fead999fa29` |
| 3 | ✅ done | `cea26faf924` |
| 4 | ✅ done | `defa1e075b5` |
| 5 | ✅ done | `03f3d522103` |
| 5.5 | ⬜ pending | |
| 6 | ✅ done | `a389e141938` |
| 7 | ✅ done | `d98b10f028e` |
| 8 | ✅ done | `223603653ef` |
| 9 | ✅ done | `1a5bf3bee1c` |
| 10 | ✅ done | `e14eb711f62` |
| 11 | ⬜ pending | |
| 12 | ⬜ pending | |
| 13 | ⬜ pending | |

---

## Phase 0: Pre-cleanup

### Step 1 — Rationalize `SessionImpl` field visibility

`heartbeatInterval` is written inside `synchronized(lock)` in `handleSessionParamsResponse` but
read outside the lock in `startRpc()` and `handleHeartBeatResponse()`. `nextHeartbeat` is
written from multiple places outside the lock. Both are `volatile`, which papers over the
race but creates an inconsistent ownership model that will need to be resolved before the lock
is removed in Phase 2.

**Changes:**
- Move the `heartbeatInterval` read in `startRpc()` inside `synchronized(lock)` (capture to a
  local before the block if needed for `nextHeartbeat` assignment).
- Add `@GuardedBy("lock")` to every field that is only accessed under the lock.
- Add explicit comments on fields intentionally read outside the lock (`nextHeartbeat`,
  `openParams`, `closeReason`) documenting why a stale read is acceptable there.
- Audit the `@SuppressWarnings("GuardedBy")` annotations on both `SessionPoolImpl`
  constructors and the untyped `Object lock` parameter on `Watchdog`. Document what each is
  actually guarding (or what contract it admits violating) in a code comment, so Phase 5 has
  a clear answer when it redesigns the locking model. The suppressions stay in place until
  Phase 5; this step only captures ground truth.

**Nothing changes at runtime. Tests pass unchanged.**

---

## Phase 1: Plumb the op executor through the stack

No behavior changes in this phase. The goal is to establish `ctx.getExecutor()` as the
single serialization point for op-level state, while keeping functional behavior identical.

### Step 2 — Add `Executor` to `VRpcCallContext`; `VRpcImpl` stores `ctx`

**Changes:**
- Add `abstract Executor getExecutor()` to `VRpcCallContext`. Default factory
  (`VRpcCallContext.create(...)`) passes `MoreExecutors.directExecutor()`.
- `VRpcImpl.start()` stores the `VRpcCallContext` in a field (`this.ctx = ctx`).

`directExecutor()` runs tasks inline on the calling thread, so every call to
`ctx.getExecutor().execute(task)` is identical to calling `task.run()` directly. No
threading change.

**Nothing changes at runtime. Tests pass unchanged.**

---

### Step 3 — Extract `SynchronizationContext` from `RetryingVRpc` to `TableBase`

Currently `RetryingVRpc` creates its own `SynchronizationContext` in its constructor. This
step moves that creation one level up so the same context is accessible via `ctx.getExecutor()`.

**Changes:**
- `TableBase.readRow()` and `mutateRow()` create a `SynchronizationContext` per call and pass
  it to both the `RetryingVRpc` constructor and `VRpcCallContext.create(...)`.
- `RetryingVRpc` constructor accepts a `SynchronizationContext` instead of creating one.
- `ctx.getExecutor()` now returns the same `SynchronizationContext` that `RetryingVRpc` holds.

`CancellableVRpc` (in `middleware/`) sits in the chain between `TableBase` and `RetryingVRpc`.
It does **not** own a `SynchronizationContext` of its own — it propagates `ctx` (which carries
the executor) to the wrapped `RetryingVRpc`. No state changes needed in `CancellableVRpc`; it
simply forwards the `ctx` it was already forwarding.

`RetryingVRpc.cancel()` continues to use its constructor-provided `SynchronizationContext`
(same object as `ctx.getExecutor()`), so pre-start cancel is still safe.

**Behavior is identical — same SynchronizationContext, just created one level higher.**

---

### Step 4 — Move callback dispatch from `RetryingVRpc` listener wrapping to `VRpcImpl`

Currently `RetryingVRpc`'s anonymous `VRpcListener` wraps every callback in
`syncContext.execute(...)`. This step moves that dispatch into `VRpcImpl` so the session layer
can later dispatch to the op executor directly without going through the listener chain.

**Changes:**
- `VRpcImpl.handleResponse()`, `handleError()`, `handleSessionClose()` each wrap their
  `listener.call(...)` invocation in `ctx.getExecutor().execute(...)`.
- Remove the `syncContext.execute(...)` wrapping from `RetryingVRpc.Active`'s `onMessage` and
  `onClose` listener bodies. They now run directly inside the already-dispatched executor task.
- `RetryingVRpc.cancel()` is unchanged — it still dispatches to its `SynchronizationContext`
  field (same object as `ctx.getExecutor()`).
- `RetryingVRpc.Scheduled.onStart` retry-delay scheduling becomes
  `scheduledExecutor.schedule(() -> ctx.getExecutor().execute(task), delay)` (replacing the
  current `syncContext.schedule(..., executor)` form).

The serialization guarantee is unchanged: responses and cancels both go through the same
`SynchronizationContext` (responses now via `VRpcImpl`, cancels via `RetryingVRpc.cancel()`).

**Behavior is identical. Tests pass unchanged.**

---

## Phase 2: Per-session `SynchronizationContext`

### Step 5 — Add session `SynchronizationContext` alongside the existing lock

This step introduces the session `SynchronizationContext` without removing any existing
synchronization. The lock and the SyncContext coexist.

**Changes:**
- `SessionImpl` gets a `SynchronizationContext sessionSyncContext` field, created in the
  constructor.
- `SessionStream.Listener.onMessage()` and `onClose()` submit to `sessionSyncContext` instead
  of calling `dispatchResponseMessage()` directly.
- Each handler method (`handleVRpcResponse`, `handleGoAwayResponse`, `handleHeartBeatResponse`,
  etc.) runs inside a `sessionSyncContext` task. Existing `synchronized(lock)` blocks remain
  inside those tasks.
- Heartbeat scheduling is rewritten so the scheduled callback dispatches onto
  `sessionSyncContext`:
  ```java
  scheduledExecutor.schedule(
      () -> sessionSyncContext.execute(this::sendHeartbeat), delay, MILLISECONDS);
  ```
  Reads of `heartbeatInterval` and `nextHeartbeat` inside the heartbeat callback now happen on
  the session SyncContext. This is the prerequisite for removing their `volatile` declarations
  in Step 7.
- External callers (`startRpc`, `cancelRpc`, `forceClose`, `close`) are unchanged for now.

All session callbacks (including heartbeat ticks) are now serialized by `sessionSyncContext`
as well as by the existing lock. The lock is now redundant for the response handlers but
harmless.

**Behavior is identical. Tests pass unchanged.**

---

### Step 5.5 — Switch heartbeat and deadline monitoring to `HashedWheelTimer`

Step 5 introduced per-session heartbeat scheduling at ~100 ms intervals. At this frequency,
heartbeat tasks generate 10N `schedule()` calls/sec for N sessions — each an O(log n) insert
into the `ScheduledThreadPoolExecutor`'s `DelayQueue`. `PendingVRpc.monitorDeadline()` compounds
this: deadline futures are created and cancelled within ~1 ms (vRPC p50 session-wait), but
`cancel(false)` leaves them in the heap until natural expiry, inflating n and raising the cost
of every heartbeat insert. See ISSUE-007.

**Changes:**
- Add a `HashedWheelTimer` to `SessionPoolImpl` — one per pool, created in the constructor,
  stopped in `close()`. Tick duration: 10 ms, 512 buckets (one rotation ≈ 5 s). The tick thread
  is pool-internal and must not block; all real work is submitted to `sessionSyncContext` or
  `ctx.getExecutor()`.
- Pass the `HashedWheelTimer` to `SessionImpl` (constructor parameter). Replace the
  `scheduledExecutor.schedule(...)` call in `scheduleHeartbeatCheck()` with
  `timer.newTimeout(...)`. The callback body is unchanged: submit `this::checkHeartbeat` to
  `sessionSyncContext`.
- In `PendingVRpc`, replace `executorService.schedule(...)` in `monitorDeadline()` with
  `timer.newTimeout(...)`. `Timeout.cancel()` is O(1) and does not leave zombie entries.
- The `ScheduledExecutorService` (`executorService`) is retained for retry-delay scheduling in
  `RetryingVRpc` — it is not replaced, only relieved of heartbeat and deadline-monitoring work.
- Close the `HashedWheelTimer` in `SessionPoolImpl.close()` after cancelling pending RPCs and
  closing sessions, so in-flight heartbeat callbacks can still submit to `sessionSyncContext`
  during the drain.

**Result:** heartbeat and deadline-monitor scheduling become O(1) insert and O(1) cancel with
no zombie accumulation. The `ScheduledExecutorService` queue depth drops to the number of
pending retry delays only.

**Small change. No behavioral change.**

---

### Step 6 — Make `startRpc()` and `cancelRpc()` async

`startRpc()` currently returns a `Status` synchronously. Under the new model it must submit to
`sessionSyncContext` and return immediately, delivering errors via the op executor.

**Call graph (current):**
- `RetryingVRpc.Active.onStart()` constructs the attempt (a `VRpcImpl`) and calls
  `attempt.start(req, ctx, listener)`.
- `VRpcImpl.start()` calls `sessionApi.startRpc(this, req)` and receives a `Status`.
- If the `Status` is non-OK, `VRpcImpl.start()` synchronously calls
  `listener.onClose(status, ...)`.

`VRpcImpl.start()` is the only caller of `VRpcSessionApi.startRpc()`.

**Changes:**
- `VRpcSessionApi.startRpc(VRpcImpl, VirtualRpcRequest)` becomes `void`. The implementation
  inside `SessionImpl` runs as a `sessionSyncContext` task; on validation failure it calls
  `ctx.getExecutor().execute(() -> listener.onClose(error))` rather than returning a `Status`.
- `VRpcImpl.start()` no longer has a synchronous error branch. It calls
  `sessionApi.startRpc(this, req)` and returns. All errors flow through the async
  `listener.onClose` path that was established in Step 4.
- `RetryingVRpc.Active.onStart()` is structurally unchanged — it already relies on
  `listener.onClose` for failure delivery. The only difference is that the failure now always
  arrives via the op executor instead of being delivered synchronously inline.
- `cancelRpc()` submits to `sessionSyncContext` (it was already void; only the execution site
  changes).
- `VRpcSessionApi` interface updated to reflect the new signatures. Because `VRpcSessionApi`
  lives in `internal`, the signature change has no compatibility surface.

The existing `synchronized(lock)` blocks inside the session SyncContext tasks remain.

**Medium noise (VRpcImpl.start() restructured). Behavior unchanged from caller perspective.**

---

### Step 7 — Remove `synchronized(lock)` from `SessionImpl`

All session state is now protected by `sessionSyncContext` (established in steps 5 and 6,
including the heartbeat path). The lock is redundant.

**Changes:**
- Remove all `synchronized(lock)` blocks from `SessionImpl`. State mutations happen directly
  inside `sessionSyncContext` tasks.
- Remove the `lock` field.
- Remove `volatile` declarations from fields previously requiring them to bridge lock/non-lock
  reads (`heartbeatInterval`, `nextHeartbeat`, `openParams`, `openParamsUpdated`). All accesses
  are now on the session SyncContext and the happens-before relationship is provided by it.
- The `closeReason` read site in `dispatchStreamClosed` is now inside a `sessionSyncContext`
  task, so its read is safely ordered.
- Remove `@GuardedBy` annotations added in Step 1.

**Medium noise (mechanical removal). Behavior unchanged.**

---

## Phase 3: Switch executor implementations

### Step 8 — Switch op executor to `SerializingExecutor(userCallbackExecutor)`

Replace the per-op `SynchronizationContext` with a `SerializingExecutor` backed by a
user-supplied callback executor. This ensures user callbacks always run on a pool thread and
never inline on the gRPC callback thread.

**Changes:**
- `TableBase` accepts a `userCallbackExecutor` (`Executor`) as a constructor parameter. The
  default — wired via the gax `TransportChannelProvider` / `ClientSettings` — is a shared
  `CachedThreadPool`. Users may supply any other `Executor` (e.g. a bounded
  `ThreadPoolExecutor`) through the same plumbing.
- `TableBase.readRow()` and `mutateRow()` create `new SerializingExecutor(userCallbackExecutor)`
  per call and pass it as `ctx.getExecutor()`.
- `RetryingVRpc` constructor now receives a plain `Executor` (the `SerializingExecutor`) instead
  of a `SynchronizationContext`. The internal `SynchronizationContext` field is removed.
  `cancel()` submits to this executor.
- Retry delay scheduling: `scheduledExecutor.schedule(() -> ctx.getExecutor().execute(task), ...)`
  (already in the form established by Step 4).

Notes:
- The default `CachedThreadPool` is unbounded; the per-op `SerializingExecutor` bounds the
  parallelism per op to 1, but total thread count scales with the number of concurrent ops.
  Users that need a bound supply their own executor.
- `SerializingExecutor`'s queue is unbounded; if user callbacks block, work accumulates in
  memory. This is the user's responsibility to manage via their executor choice and callback
  hygiene.

After this step user callbacks run on the configured callback executor. The gRPC callback
thread (or Netty, after the next step) is freed as soon as it submits to the
`SerializingExecutor`.

**User-visible change: callbacks run on a different thread.**

---

### Step 9 — Configure gRPC session streams with `DirectExecutor`

**Changes:**
- Pass `CallOptions.withExecutor(MoreExecutors.directExecutor())` when creating the
  `ClientCall` for the session stream in `SingleChannelPool` / `ChannelPoolDpImpl` (wherever
  `newCall()` is invoked on the channel for session streams).
- The gRPC user thread pool is no longer used for session stream callbacks. Netty threads
  deliver `SessionStream.Listener` callbacks directly.
- Netty trampolines through the session `SynchronizationContext` (fast, bounded bookkeeping),
  then submits to the `SerializingExecutor` and returns.
- Add a class-level comment on `SessionStream.Listener` (and a comment on
  `SessionImpl.sessionSyncContext`) documenting the invariant:

  > **Invariant:** callbacks delivered here run on Netty I/O threads via
  > `DirectExecutor`. All work must be fast and non-blocking — any user-facing or potentially
  > blocking work must be dispatched onto the op executor (`ctx.getExecutor()`) before
  > returning. Violating this stalls the channel.

(Whether to additionally support a configuration that keeps the gRPC executor + per-session
`SynchronizationContext` is deferred pending benchmarks. Both modes could potentially ship
side-by-side selectable via `ClientConfig`.)

**Small change (one `CallOptions` line + invariant comments). Performance improvement, no
behavioral change.**

---

## Phase 4: `PendingVRpc` cleanup

### Step 10 — Route `PendingVRpc` per-op state through the op executor

Currently `PendingVRpc.drainTo()` and `cancel()` protect `isCancelled` and `realCall` using
the pool lock. These are per-op concerns and should be on the op executor.

**Changes:**
- `drainTo(SessionHandle handle)`:
  ```java
  synchronized (SessionPoolImpl.this) {
      pendingRpcs.remove(this);   // pool lock: queue mutation only
  }
  ctx.getExecutor().execute(() -> {
      if (isCancelled) return;
      realCall = newRealCall(desc, handle);
      realCall.start(req, ctx, listener);
  });
  ```
- `cancel(Status status, boolean onlyCancelPendingCall)`: submits the isCancelled check and
  `realCall` assignment/delegation to `ctx.getExecutor()`.
- Pool lock now covers only pool-level state: `pendingRpcs` queue, `poolState`, session list.
- The `NOOP_CALL` sentinel (used to paper over the cancel-before-start race) is no longer
  needed and can be removed.

Because `ctx.getExecutor()` is a `SerializingExecutor`, `drainTo` and `cancel` are strictly
ordered. The cancel-before-start race is eliminated structurally.

**Medium noise.**

---

## Phase 5: Per-AFE lock sharding (independent track)

This phase can proceed in parallel with or after Phases 0–4. It addresses pool-checkout
contention under high-concurrency multiplexing. The `AfeHandle` in `SessionList` groups sessions
by Application Frontend, but all operations currently serialize on one pool-wide lock.

### Step 11 — Expose `AfeId` from `Picker`

Currently `Picker.pickSession()` returns a `SessionHandle`. To shard the lock per-AFE the
caller needs to know which AFE was selected.

**Changes:**
- `Picker.PickResult` (or equivalent) carries `(SessionHandle, AfeId)`.
- `SessionPoolImpl.tryDrainPendingRpcs()` records the selected `AfeId` for use in the
  subsequent lock acquisition.
- No lock sharding yet — `AfeId` is threaded through but the single lock remains.

**Small. Behavior unchanged.**

---

### Step 12 — Give `AfeHandle` its own lock

**Changes:**
- `AfeHandle` gets a `final Object lock = new Object()` field.
- Per-AFE mutable state (`sessions` queue, `refCount`, `lastConnected`, `PeakEwma`) is
  accessed under `AfeHandle.lock` instead of the pool-wide lock.
- `SessionList` operations that touch a single AFE acquire `AfeHandle.lock` directly.
- Operations that touch multiple AFEs or pool-wide state (session creation, pool lifecycle)
  still acquire the pool-wide lock.

**Lock-ordering rule (enforced from this step onward):**

> Pool-wide lock (`SessionPoolImpl.this`) is the **outer** lock. `AfeHandle.lock` is the
> **inner** lock. Any code path that needs both MUST acquire the pool lock first, then the
> AFE lock. Never the reverse. Paths that need only one acquire it directly.

Document the rule with a class-level comment on `SessionPoolImpl` and a field comment on
`AfeHandle.lock`.

**Resolving pre-existing locking debt (carried over from Step 1's audit):**
- Remove the `@SuppressWarnings("GuardedBy")` from both `SessionPoolImpl` constructors. With
  the lock model now explicit (outer pool, inner AFE, defined ordering), either replace each
  suppression with a correct `@GuardedBy` annotation or remove it if the constructor path is
  genuinely lock-free.
- Type `Watchdog`'s lock parameter properly. Decide whether it needs the pool-wide lock, an
  `AfeHandle.lock`, or both (and in what order), then change the parameter type from `Object`
  to the actual lock type(s) and add correct `@GuardedBy` annotations. Remove the
  `// TODO: fix lock sharing` comment.

**Medium noise. Behavior unchanged.**

---

### Step 13 — Shard `SessionPoolImpl` checkout/return per AFE

**Changes:**
- `tryDrainPendingRpcs()`: after picking a session (which identifies an AFE), acquires
  `afeHandle.lock` for the checkout, not the pool-wide lock.
- `onVRpcComplete()`: returns the session to `afeHandle.sessions` under `afeHandle.lock`.
- The pool-wide lock scope narrows to: pool lifecycle (`poolState`), session creation/removal,
  and operations that must see the full session list.
- All paths that acquire both locks follow the ordering rule established in Step 12.

**Medium-large. Primary performance win for high-concurrency multiplexing.**

---

## Summary

| Phase | Steps | Key outcome |
|---|---|---|
| 0 | 1 | Lock ownership documented, volatile races fixed |
| 1 | 2–4 | `ctx.getExecutor()` plumbed, dispatch in `VRpcImpl`, `CancellableVRpc` forwards `ctx` |
| 2 | 5–7 | Session state (including heartbeat) owned by `SynchronizationContext`, lock removed |
| 3 | 8–9 | User callbacks on `SerializingExecutor(userCallbackExecutor)`, Netty as callback thread with documented invariant |
| 4 | 10 | Pool lock owns only pool topology; cancel-before-start race eliminated |
| 5 | 11–13 | Per-AFE lock sharding for multiplexing throughput, with explicit lock-ordering rule |
