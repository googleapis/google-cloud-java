# Changelog

## 1.3.2 (2022-12-02)

### Fixes

* Fix race condition when running and adding state change callbacks. (#155)

## 1.3.1 (2022-10-24)

### Fixes

* MultiEndpoint: allow specifying protocol in the endpoint. (#151)

## 1.3.0 (2022-10-12)

### Features

* Add switching delay to GcpMultiEndpointChannel. (#145)
* Look for a multi-endpoint specified in gRPC context. (#149)

## 1.2.0 (2022-07-18)

### Features

* multi-endpoint (#135).
* round-robin for bind calls (#127).
* minSize of the channel pool (#134).
* detailed logs (#133).
* log metrics (#131).
* map a key to current channel when bound call arrives but no mapping for the
key exists (#132).
* consolidate channel pool config in the GcpChannelPoolOptions (#109).

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
