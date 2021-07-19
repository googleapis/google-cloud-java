# Changelog

## 1.1.0 (2021-07-20)

### Features

* improve bind/unbind logic.
* improve getChannelRef performance for calls without channel affinity.
* more accurate affinity counts.
* allow to rebind a key to another channel and adjust affinity counts accordingly.

## 1.0.0 (2021-06-11)

### Features

* gRPC channel pool with configurable channel affinity.
* provide a channel with minimum active streams for a new call.
* an optional fallback from non-ready channel to a ready channel.
* an option to detect unresponsive channels.
