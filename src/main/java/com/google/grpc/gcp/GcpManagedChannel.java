/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.grpc.gcp;

import com.google.common.annotations.VisibleForTesting;
import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// -------------------TODO: Take care of multithreads-------------------------

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {

  private ApiConfig apiConfig;
  private int maxSize;
  private int maxConcurrentStreamsLowWatermark;
  private final ManagedChannelBuilder builder;

  @VisibleForTesting final Map<String, AffinityConfig> methodToAffinity;
  @VisibleForTesting final Map<String, ChannelRef> affinityKeyToChannelRef;
  @VisibleForTesting List<ChannelRef> channelRefs;

  public GcpManagedChannel(ManagedChannelBuilder builder, String... jsonPath) {
    methodToAffinity = new HashMap<String, AffinityConfig>();
    affinityKeyToChannelRef = new HashMap<String, ChannelRef>();
    channelRefs = new ArrayList<ChannelRef>();
    maxSize = 10;
    maxConcurrentStreamsLowWatermark = 100;
    if (jsonPath.length == 0) {
      apiConfig = null;
    } else {
      loadApiConfig(jsonPath[0]);
    }
    this.builder = builder;
    getChannelRef();
  }

  /** Load parameters from apiConfig.json. */
  private void loadApiConfig(String jsonPath) {
    ApiConfig apiConfig = ParseApiConfig.parseJson(jsonPath);
    if (apiConfig == null) {
      return;
    }
    // Get the channelPool parameters
    if (apiConfig.getChannelPool().getMaxSize() != 0) {
      maxSize = apiConfig.getChannelPool().getMaxSize();
    }
    if (apiConfig.getChannelPool().getMaxConcurrentStreamsLowWatermark() != 0) {
      maxConcurrentStreamsLowWatermark =
          apiConfig.getChannelPool().getMaxConcurrentStreamsLowWatermark();
    }
    // Get method parameters.
    for (MethodConfig method : apiConfig.getMethodList()) {
      if (method.getAffinity().equals(AffinityConfig.getDefaultInstance())) {
        continue;
      }
      for (String methodName : method.getNameList()) {
        methodToAffinity.put(methodName, method.getAffinity());
      }
    }
    return;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public int getStreamsLowWatermark() {
    return maxConcurrentStreamsLowWatermark;
  }

  // ----TODO: How to initialize a new managed channel? currently we use ---
  // ----------- ManagedChannelBuilder from outside of the class -----------

  /** Picks a grpc channel from the pool and wraps it with ChannelRef. */
  public synchronized ChannelRef getChannelRef(String affinityKey) {
    // Chose an bound channel if affinityKey is specified
    if (affinityKey != null && affinityKeyToChannelRef.containsKey(affinityKey)) {
      return affinityKeyToChannelRef.get(affinityKey);
    }

    Collections.sort(
        channelRefs,
        new Comparator<ChannelRef>() {
          @Override
          public int compare(ChannelRef o1, ChannelRef o2) {
            return o1.getActiveStreamsCount() - o2.getActiveStreamsCount();
          }
        });

    int size = channelRefs.size();
    // Chose the channelRef that has the least busy channel.
    if (size > 0 && channelRefs.get(0).getActiveStreamsCount() < maxConcurrentStreamsLowWatermark) {
      return channelRefs.get(0);
    }
    // If all existing channels are busy, and channel pool still has capacity, create a new channel.
    if (size < maxSize) {
      ManagedChannel grpcChannel = builder.build();
      ChannelRef channelRef = new ChannelRef(grpcChannel, size);
      channelRefs.add(channelRef);
      return channelRef;
    }
    // Otherwise still return the least busy channelref.
    return channelRefs.get(0);
  }

  public ChannelRef getChannelRef() {
    return getChannelRef(null);
  }

  // ------------TODO: Override all the methods here ---------------------
  // ---------Do We have non-abstract method to override------------------
  @Override
  public String authority() {
    return channelRefs.get(0).authority();
  }

  @Override
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
      MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {

    return getChannelRef().newCall(methodDescriptor, callOptions);
  }

  @Override
  public ManagedChannel shutdownNow() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.isTerminated()) {
        channelRef.shutdownNow();
      }
    }
    return this;
  }

  @Override
  public ManagedChannel shutdown() {
    for (ChannelRef channelRef : channelRefs) {
      channelRef.shutdown();
    }
    return this;
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    for (ChannelRef channelRef : channelRefs) {
      if (channelRef.isTerminated()) {
        continue;
      }
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      channelRef.awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    return isTerminated();
  }

  @Override
  public boolean isShutdown() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isTerminated() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.isTerminated()) {
        return false;
      }
    }
    return true;
  }

  /** Get the current connectivity state of the channel pool. */
  @Override
  public ConnectivityState getState(boolean requestConnection) {
    int ready = 0;
    int idle = 0;
    int connecting = 0;
    int transientFailure = 0;
    int shutdown = 0;
    for (ChannelRef channelRef : channelRefs) {
      ConnectivityState cur = channelRef.getState(requestConnection);
      if (cur.equals(ConnectivityState.READY)) {
        ready++;
      } else if (cur.equals(ConnectivityState.SHUTDOWN)) {
        shutdown++;
      } else if (cur.equals(ConnectivityState.TRANSIENT_FAILURE)) {
        transientFailure++;
      } else if (cur.equals(ConnectivityState.CONNECTING)) {
        connecting++;
      } else if (cur.equals(ConnectivityState.IDLE)) {
        idle++;
      }
    }

    if (ready > 0) {
      return ConnectivityState.READY;
    } else if (connecting > 0) {
      return ConnectivityState.CONNECTING;
    } else if (transientFailure > 0) {
      return ConnectivityState.TRANSIENT_FAILURE;
    } else if (idle > 0) {
      return ConnectivityState.IDLE;
    } else if (shutdown > 0) {
      return ConnectivityState.SHUTDOWN;
    }
    return null;
  }

  // -----------------------------Below is for affinity key-------------------

  /**
   * Bind channel with affinity key. One key can be mapped to a channel more than once.
   *
   * <p>One channel can be mapped to more than one keys. But one key can only be mapped to one
   * channel.
   */
  public synchronized void bind(int channelRefIdx, String affinityKey) {
    if (affinityKey != null
        && !affinityKey.equals("")
        && channelRefIdx < channelRefs.size()
        && channelRefIdx >= 0) {
      ChannelRef channelRef = channelRefs.get(channelRefIdx);
      if (!affinityKeyToChannelRef.containsKey(affinityKey)) {
        affinityKeyToChannelRef.put(affinityKey, channelRef);
      }
      affinityKeyToChannelRef.get(affinityKey).affinityCountIncr();
    }
    // TODO: whaaat if map[affinityKey] != channelRef?
  }

  /** Unbind channel with affinity key. */
  public synchronized void unbind(String affinityKey) {
    if (affinityKey != null
        && !affinityKey.equals("")
        && affinityKeyToChannelRef.containsKey(affinityKey)) {
      ChannelRef removedChannelRef = affinityKeyToChannelRef.get(affinityKey);
      removedChannelRef.affinityCountDecr();
      if (removedChannelRef.getAffinityCount() <= 0) {
        affinityKeyToChannelRef.remove(affinityKey);
      }
    }
  }

  // ------------------------------------------------------------------------------

}
