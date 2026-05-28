# Pre-existing issues found during threading refactor

These are correctness concerns or suboptimal patterns noticed while reading the code.
They are not introduced by the refactor.

---

## SessionImpl

### ISSUE-001: `@Nullable closeReason` is misleading — field is never null at the one external read site

`closeReason` is declared `@Nullable` (line 103 before Step 1) but `dispatchStreamClosed` calls
`closeReason.getReason()` after the synchronized block with no null guard. The call is safe
because every code path that exits `dispatchStreamClosed`'s synchronized block without an early
return guarantees `closeReason` is non-null:
- `state == WAIT_SERVER_CLOSE`: `closeReason` was set before the state was entered.
- `state == CLOSED`: returns early inside the block.
- Any other state: set inside the block by the abnormal-close error path.

However, the `@Nullable` annotation makes the invariant non-obvious and means static analysers
(and future readers) cannot rely on the annotation. Either remove `@Nullable` and add a comment
asserting that it is always set before the closing state, or change the field type to carry a
sentinel value instead of null.

**File:** `session/SessionImpl.java`

---

### ISSUE-002: `sessionParameters` was missing `@GuardedBy("lock")` annotation

The field `sessionParameters` is read and written only under `lock`, but had no `@GuardedBy`
annotation. Fixed in Step 1.

---

## RetryingVRpc

### ISSUE-003: `requestNext()` is unimplemented — throws `UnsupportedOperationException`

`RetryingVRpc.requestNext()` always throws `UnsupportedOperationException`. The streaming retry
path is not implemented. This means any code path that calls `requestNext()` after `onMessage`
will crash. Tracked for future work (server-streaming vRPC support).

**File:** `middleware/RetryingVRpc.java`

---

## SessionPoolImpl / Watchdog

### ISSUE-004: `Watchdog.lock` typed as `Object` instead of the actual outer lock

The `Watchdog` static inner class accepts the pool-wide monitor as `Object lock`. This prevents
static analysis tools from verifying the locking discipline and makes the contract implicit.
Will be addressed in Phase 5 when the per-AFE lock sharding redesign gives the locking model
an explicit, typed structure.

**File:** `session/SessionPoolImpl.java` — `Watchdog` inner class

---

## VRpcImpl

### ISSUE-005: `cancelRpc` is silent when the current RPC does not match

In `SessionImpl.cancelRpc()`, if `currentRpc != null` but `rpcId != currentRpc.rpcId`, the
cancel is silently dropped. This is the expected behavior for a late cancel (RPC already
finished), but there is no logging or tracing event, making silent drops invisible in metrics.
Consider adding a debug-level counter or log.

**File:** `session/SessionImpl.java` — `cancelRpc()`

---

## VRpcListener / UnaryResponseFuture

### ISSUE-006: An exception thrown inside the op executor dispatch chain can leave the caller's future permanently unresolved (silent hang)

**Observed during Step 4 of the threading refactor.** When `VRpcImpl` dispatches a callback
via `ctx.getExecutor().execute(...)`, any uncaught exception that escapes from within that task
can silently orphan the caller's `VRpcListener` (and any `Future` backed by it):

1. `VRpcImpl.handleError()` calls `ctx.getExecutor().execute(() -> listener.onClose(result))`.
2. If `ctx.getExecutor()` is a `SynchronizationContext` and the listener throws (e.g.
   `throwIfNotInThisSynchronizationContext()` on the wrong thread), the SyncContext's
   uncaught-exception handler fires.
3. The handler calls `retrying.cancel(...)`, which submits a new task to the same
   SynchronizationContext.
4. That cancel task eventually reaches `RetryingVRpc.Done.onStart()`, which calls
   `listener.onClose(CANCELLED)` — but only if the SyncContext drain loop is still healthy.
5. If the SyncContext drain exited early or the downstream cancel itself throws, `listener.onClose`
   is never called, so `f.get()` blocks forever — there is no timeout, no error, no log.

**Symptoms:** test/operation hangs indefinitely on `Future.get()` after an exception in the
callback chain.

**Root cause class:** There is no invariant enforcement that every code path that may fail
*must* call `listener.onClose()` exactly once. Exceptions that escape executor tasks bypass
the normal close path.

**Desired fix (post-refactor):** After the threading refactor is complete, audit every executor
`execute()` task that can invoke a `VRpcListener` to ensure a try/catch wraps the body and
calls `listener.onClose(createLocalTransportError(...))` in the catch branch. The
`SynchronizationContext` uncaught-exception handler should be a last-resort log + metric, not
a recovery mechanism. Consider a typed `VRpcTask` wrapper that enforces the "always close"
contract at compile time.

**Files:** `session/VRpcImpl.java`, `middleware/RetryingVRpc.java`

---

## SessionPoolImpl — PendingVRpc

### ISSUE-007: `PendingVRpc.monitorDeadline()` causes `ScheduledExecutorService` heap churn under load

Every RPC that cannot immediately acquire a session goes through `PendingVRpc` and schedules a
deadline-monitoring `ScheduledFuture` on the pool's `ScheduledExecutorService`. Under normal
conditions the future is cancelled almost immediately — sessions are expected to be available
within ~1 ms at p50. `ScheduledFuture.cancel(false)` marks the future cancelled but does **not**
remove it from the underlying `DelayQueue`. Cancelled futures remain in the heap until their
deadline expires naturally (typically seconds to minutes), inflating the queue and increasing
O(log n) insert/remove cost for every subsequent schedule operation.

**Why this matters at the given operating point:**

Both `PendingVRpc.monitorDeadline()` and per-session heartbeat scheduling hit the same
`ScheduledExecutorService`, and their effects compound.

**Heartbeat pressure:** At ~100 ms per heartbeat, each session fires 10 `schedule()` calls/sec.
Heartbeat tasks run and reschedule — they do not cancel, so they produce no zombies — but they
sustain O(log n) heap churn at 10N ops/sec for N sessions. This is not a low frequency in
context: at a vRPC p50 of ~1 ms, a heartbeat fires every ~100 vRPCs, meaning background
scheduling overhead is in the same order of magnitude as per-RPC work.

**Deadline monitor zombie accumulation:** `cancel(false)` marks a future cancelled but does not
remove it from the `DelayQueue`. At ~1 ms p50 session-wait, a deadline future (say, 60 s) is
created and cancelled almost immediately. At 10 000 RPC/s with 10 % transiently pending:
1 000 futures/sec added, each living ~60 s → steady-state zombie count of ~60 000 entries.

**Compounding:** Heartbeat inserts pay O(log n) against a queue inflated by zombie deadline
futures. With 10 sessions and 60 000 zombies, each heartbeat insert costs O(log 60 010) ≈ 16
comparisons instead of O(log 10) ≈ 3. The absolute cost is small today but grows linearly with
both session count and RPC throughput.

**Mitigations (in increasing order of impact):**

1. **Short-circuit**: if the deadline is already expired when `PendingVRpc.start()` is called,
   reject immediately without scheduling a future.
2. **`setRemoveOnCancelPolicy(true)`** on the `ScheduledThreadPoolExecutor`: removes cancelled
   tasks from the queue eagerly in O(log n). Eliminates zombie accumulation. Requires
   controlling the executor construction.
3. **Hashed wheel timer** (e.g., Netty's `HashedWheelTimer`): O(1) insert and O(1) cancel with
   no zombie accumulation. Neither deadline monitoring nor heartbeat checking requires
   sub-millisecond precision; a wheel tick of ~10 ms is appropriate for both. This is the right
   long-term fix for both sources of churn.

**Files:** `session/SessionPoolImpl.java` — `PendingVRpc.monitorDeadline()` and
`session/SessionImpl.java` — `scheduleHeartbeatCheck()`
