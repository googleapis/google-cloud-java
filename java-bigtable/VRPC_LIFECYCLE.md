# VRpc Lifecycle — Executor Map

How a single virtual RPC flows through the executor layers from user call to Future resolution.

## Executors involved

| Executor | Scope | Implementation | Owns |
|---|---|---|---|
| **user thread** | caller | — | initiates start/cancel |
| **opExecutor** | per VRpc | `newSequentialExecutor(userCallbackExecutor)` | all retry/op-layer state |
| **sessionSyncContext** | per SessionImpl | `SynchronizationContext(executorService)` | all session state |
| **Netty I/O thread** | per gRPC channel | DirectExecutor on CallOptions | stream callback delivery |
| **backgroundExecutor** | pool-wide | `ScheduledExecutorService` | retry delays, heartbeats |

---

## Start

```
[user thread]
  TableBase.mutateRow()
    creates opExecutor = newSequentialExecutor(userCallbackExecutor)
    creates RetryingVRpc, CancellableVRpc, ctx
    calls cancellable.start(req, ctx, future)

[user thread — CancellableVRpc.start()]
    context.addListener(cancellationListener, directExecutor)
    calls retrying.start(req, ctx, listener)

[user thread — RetryingVRpc.start()]
    started = true; sets fields
    currentState.onStart()   ← runs directly, no executor dispatch
```

```
[user thread — RetryingVRpc.Active.onStart()]
    sessionPool.newCall(desc)             ← synchronized, returns PendingVRpc or VRpcImpl
    attempt.start(req, ctx, retryListener)
```

**Path A — session immediately available (VRpcImpl):**
```
[opExecutor — VRpcImpl.start()]
    sessionApi.startRpc(this, req)        ← submits to sessionSyncContext, returns

[sessionSyncContext — SessionImpl]
    validates state, sets currentRpc
    stream.sendMessage(...)               ← onto the wire
```

**Path B — no session available (PendingVRpc):**
```
[opExecutor — PendingVRpc.start()]
    schedules deadlineMonitor on backgroundExecutor
    acquires pool lock, adds self to pendingRpcs
    ← opExecutor task ends, RPC is parked

... later, onSessionReady() fires under pool lock ...
    tryDrainPendingRpcs() → rpc.drainTo(handle)
    deadlineMonitor.cancel()
    opExecutor.execute(() -> realCall.start(...))  ← re-enters opExecutor

[opExecutor — drainTo task]
    if cancelled → return session via onVRpcComplete
    realCall = newRealCall(desc, handle)
    realCall.start(req, ctx, listener)    ← continues as Path A
```

---

## Response arrives

```
[Netty I/O thread — DirectExecutor]
  SessionStream.Listener.onMessage(sessionResponse)
    sessionSyncContext.execute(() -> dispatchResponseMessage())  ← dispatch, Netty freed

[sessionSyncContext — SessionImpl]
    handleVRpcResponse() or handleVRpcErrorResponse()
    clears currentRpc, checks currentCancel
    localRpc.handleResponse(vrpc) or localRpc.handleError(result)

[sessionSyncContext — VRpcImpl.handleResponse()]
    ctx.getExecutor().execute(() -> listener.onClose(result))   ← dispatch to opExecutor

[opExecutor — RetryingVRpc listener]
    success → calls upstream listener.onClose()
    retry   → backgroundExecutor.schedule(delay,
                () -> opExecutor.execute(() -> onStart()))      ← retry loop

[opExecutor — CancellationCleanupListener.onClose()]
    context.removeListener(cancellationListener)
    future.onClose(result)                ← resolves user's Future
```

---

## Cancel

```
[any thread — e.g. gRPC context cancellation]
  cancellationListener fires (directExecutor)
    retrying.cancel("gRPC context cancelled", cause)

[any thread — RetryingVRpc.cancel()]
    opExecutor.execute(() -> state.cancel(...))   ← dispatch

[opExecutor — RetryingVRpc state.cancel()]
    attempt.cancel() → VRpcImpl.cancel()
    sessionApi.cancelRpc(rpcId, ...)

[sessionSyncContext — SessionImpl.cancelRpc()]
    if currentRpc.rpcId == rpcId:
        currentCancel = VRpcResult.createRejectedError(CANCELLED)
    ← no cancel message sent to server; currentCancel overrides
      the response result when the server's reply arrives
```

---

## Summary

| Event | Thread sequence |
|---|---|
| Start | user thread (entire inbound path) → sessionSyncContext → wire |
| Response | Netty → sessionSyncContext → opExecutor → user Future |
| Retry | opExecutor → backgroundExecutor (delay) → opExecutor → sessionSyncContext |
| Cancel | any → opExecutor → sessionSyncContext |

Every state mutation in the session crosses through **sessionSyncContext**.
Every state mutation in the retry/op layer crosses through **opExecutor**.
Netty and the user thread are producers only — they submit work and return immediately.
