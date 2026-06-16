# java-bigtable — deferred work

## Three fallback closeReason synthesizers in SessionImpl

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/session/SessionImpl.java`
**Symptom:** the invariant "a session reaching CLOSED carries a closeReason" is enforced by belt-and-suspenders synthesizers at three sites — `abortFromUncaughtException` (overwrites unconditionally), `startGracefulClose` (logs warning + synthesizes if null), `notifyTerminalClose` (added in `bfa99cd0d9e` as last-resort guard). Each was added in response to a discovered miss. A new code path that transitions toward CLOSED must remember to set `closeReason` or rely on a downstream synthesizer firing.

**Fix sketch:** couple setter to transition. Add an overload `updateState(SessionState newState, CloseSessionRequest closeReason)` for terminal-phase transitions that requires the reason as an argument. The plain `updateState(newState)` overload stays for NEW→STARTING→READY. The three synthesizers go away.

**Risk:** a bug that misses the setter becomes a loud `IllegalArgumentException` instead of silent metric corruption. Probably better but it's a behavior shift — any "should never happen" path that hit a synthesizer today would now crash.

## drainedFuture completion duplicated across two sites

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/session/SessionPoolImpl.java`
**Symptom:** `drainedFuture.complete(null)` fires from two unrelated sites — `close()` (line 308) when the pool was already empty at close time, and `onSessionClose` (line 538-540) when the last session drains while `poolState == CLOSED`. Both re-check `sessions.getAllSessions().isEmpty()`. A future code path that removes the last session by any other route (admin force-drain, AFE shutdown, per-session abort that bypasses the standard listener chain) leaves `drainedFuture` uncompleted — `Client.close` hangs for the full `POOL_DRAIN_TIMEOUT` (6 min) per pool with no log indication.

**Fix sketch:** derive the completion from a single state event — e.g., a `maybeCompleteDrain()` helper called from every site that transitions a session out of the pool, with one check `poolState == CLOSED && sessions.getAllSessions().isEmpty()`. Removes the duplicated check and gives a single chokepoint to audit.

**Risk:** low. The condition lives in one place; future session-removal paths just need to call the helper.

## Client.shutdownAndAwait is a public-static helper in the wrong place

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/api/Client.java`
**Symptom:** `shutdownAndAwait(ExecutorService)` is a public static helper on `Client` (line 394), duplicating Guava's `MoreExecutors.shutdownAndAwaitTermination` semantics. Promoted to public-static so `ShimImpl` (different package) can reuse it. The user-callback executor's lifecycle policy ("cached pool drained with 5s grace, then `shutdownNow`") belongs to the executor's owning type, not a free function on `Client` that every owner must remember to import.

**Fix sketch:** introduce a `UserCallbackExecutor` (or similar) type that wraps the cached `ExecutorService` and owns its lifecycle (`close()` does the shutdown-and-await dance). Both `Client.create` and `ShimImpl` construct one. `Client.shutdownAndAwait` goes away.

**Risk:** small ripple to construction sites. Reduces pressure to add more "shutdown subtleties" (configurable timeout, interrupt restoration variants, etc.) as more public statics on `Client`.

## RetryingVRpc.start guard relies on unenforced op-executor affinity

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/middleware/RetryingVRpc.java`
**Symptom:** `started`, `isCancelling`, `currentState` are plain non-volatile fields. The comment claims "VOperationImpl trampolines every inbound call onto opExecutor, so no synchronization is needed here" — but `start()` and `cancel()` don't assert that contract. A caller that bypasses `VOperationImpl` (a test using `VRpcCallContext.create`'s 3-arg overload with a `t -> {}` swallowing handler, or any new direct consumer) gets torn reads and silent state corruption rather than a clear precondition failure. Added importance after the `chain.isDone()` change (#8 fix) — that field is also unsynchronized and now externally observable.

**Fix sketch:** add `context.getExecutor().throwIfNotInThisExecutor()` at the top of `start()` and `cancel()` (and `isDone()` if we want to be strict). Each becomes a one-line guard. Tests that exercise these methods directly must construct a real OpExecutor and trampoline through it, matching production usage.

**Risk:** test rewrites for any test that calls `RetryingVRpc.start()` directly without going through `VOperationImpl`. Check the existing `RetryingVRpcTest` and `VRpcTracerTest` for impacted call sites.

## Long-delay Scheduled retries are cancelled on close, not awaited

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/middleware/RetryingVRpc.java` + `Client.java`
**Symptom:** Today (post `4a80a8284fb`) a `Scheduled` retry pending at `Client.close` is driven to a CANCELLED Done via the `BigtableTimer.onStop` hook. That delivers a terminal to the user — but it abandons whatever the retry was waiting for. A truly graceful shutdown would let the retry complete naturally if the deadline still has room. We explicitly chose cancel-on-close because per-op tracking at the Client level was rejected as too heavy.

**Fix sketch (if requirements change):** add a Client-level (or per-pool) registry of in-flight `VOperation`s. `Client.close` Phase 2 would extend `drainedFuture` to also wait for in-flight ops to terminate, bounded by `POOL_DRAIN_TIMEOUT`. Op registry maintained by `VOperationImpl.start` / `Done.onStart`.

**Risk:** real structural change — every `VOperation` registers/unregisters; Client gains a new responsibility. Only worth it if a customer reports the cancel-on-close behavior as wrong. Today the cancel path delivers a clean terminal, which is sufficient for shutdown correctness.

## Idle session heartbeat ticks burn CPU

**File:** `google-cloud-bigtable/src/main/java/com/google/cloud/bigtable/data/v2/internal/session/SessionImpl.java`
**Symptom:** `checkHeartbeat` re-arms a 100 ms wheel tick on every fire, regardless of whether a vRPC is in flight. For idle sessions, `nextHeartbeat` sits at `now + FUTURE_TIME` (30 min) but the tick still fires 10×/sec, syncs onto `sessionSyncContext`, compares, and re-arms. 100 idle sessions = ~1,000 wakeups/sec per Client of pure background noise.

**Fix sketch:** couple heartbeat arming to `currentRpc` lifecycle.
- In `startRpc` (after setting `nextHeartbeat = now + heartbeatInterval`): arm `scheduleHeartbeatCheck()` if `heartbeatTimeout == null`.
- In `handleVRpcResponse` / `handleVRpcErrorResponse` (after pushing `nextHeartbeat` to `FUTURE_TIME`): `cancelHeartbeatTimeout()`.
- In `checkHeartbeat`: re-arm only when `currentRpc != null`.
- Drop the unconditional `scheduleHeartbeatCheck()` from `handleOpenSessionResponse`.

**Risk:** heartbeat becomes per-vRPC instead of per-session. Future multiplexing or any state where `nextHeartbeat` is meaningful without `currentRpc != null` needs explicit arming. Stuck-session shutdown detection is already covered by the watchdog + `Client.POOL_DRAIN_TIMEOUT`.
