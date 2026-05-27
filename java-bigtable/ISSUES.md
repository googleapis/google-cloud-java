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
