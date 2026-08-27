# Dynamic channel pool lifecycle

Dynamic scaling removes channels from picker candidates before closing them. Removed channels drain
existing work, then close after their active stream count reaches zero and the configured idle grace
period passes.

| Routing state | Behavior while channel drains |
| --- | --- |
| Unaffinitized calls | Pickers skip the draining channel. |
| Session-scoped affinity key | The key is unbound and its next call selects an active channel. |
| Caller-owned `ChannelAffinityRef` | The reference stays on the open draining channel so transaction RPCs remain ordered. Calls still contribute to that channel's active stream count and delay closure. The reference selects an active channel after delegate shutdown or `useDifferentChannelOnNextCall()`. |
