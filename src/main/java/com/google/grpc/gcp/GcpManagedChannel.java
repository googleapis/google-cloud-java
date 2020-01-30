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
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.MessageOrBuilder;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {

  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int DEFAULT_MAX_STREAM = 100;

  private final ManagedChannelBuilder delegateChannelBuilder;
  private int maxSize = DEFAULT_MAX_CHANNEL;
  private int maxConcurrentStreamsLowWatermark = DEFAULT_MAX_STREAM;

  @VisibleForTesting
  final Map<String, AffinityConfig> methodToAffinity = new HashMap<String, AffinityConfig>();

  @VisibleForTesting
  @GuardedBy("bindLock")
  final Map<String, ChannelRef> affinityKeyToChannelRef = new HashMap<String, ChannelRef>();

  @VisibleForTesting
  @GuardedBy("this")
  final List<ChannelRef> channelRefs = new ArrayList<ChannelRef>();

  private final Object bindLock = new Object();

  /**
   * Constructor for GcpManagedChannel.
   *
   * @param delegateChannelBuilder the underlying delegate ManagedChannelBuilder.
   * @param apiConfig the ApiConfig object for configuring GcpManagedChannel.
   */
  public GcpManagedChannel(ManagedChannelBuilder delegateChannelBuilder, ApiConfig apiConfig) {
    loadApiConfig(apiConfig);
    this.delegateChannelBuilder = delegateChannelBuilder;
    // Initialize the first delegate channel.
    getChannelRef(null);
  }

  public int getMaxSize() {
    return maxSize;
  }

  public int getNumberOfChannels() {
    return channelRefs.size();
  }

  public int getStreamsLowWatermark() {
    return maxConcurrentStreamsLowWatermark;
  }

  /**
   * Pick a channelRef (and create a new one if necessary).
   *
   * @param key affinity key. If it is specified, pick the ChannelRef bound with the affinity key.
   *     Otherwise pick the one with the smallest number of streams.
   */
  protected ChannelRef getChannelRef(@Nullable String key) {

    if (key != null && key != "") {
      // System.out.println("affinity");
      synchronized (bindLock) {
        return affinityKeyToChannelRef.get(key);
      }
    }
    synchronized (this) {
      int size = channelRefs.size();
      channelRefs.sort(Comparator.comparingInt(ChannelRef::getActiveStreamsCount));

      // Create a new channel if the max size has not been reached.
      if (size == 0 || (size < maxSize && channelRefs.get(0).getActiveStreamsCount() > 0)) {
        ChannelRef channelRef = new ChannelRef(delegateChannelBuilder.build(), size);
        channelRefs.add(channelRef);
        return channelRef;
      }
      // Choose the channelRef that has the least busy delegate channel.

      if (channelRefs.get(0).getActiveStreamsCount() < maxConcurrentStreamsLowWatermark) {
        return channelRefs.get(0);
      }
      // Otherwise return first ChannelRef.
      return channelRefs.get(0);
    }
  }

  @Override
  public synchronized String authority() {
    return channelRefs.get(0).getChannel().authority();
  }

  /**
   * Manage the channelpool using GcpClientCall().
   *
   * <p>If method-affinity is specified, we will use the GcpClientCall to fetch the affinitykey and
   * bind/unbind the channel, otherwise we just need the SimpleGcpClientCall to keep track of the
   * number of streams in each channel.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
    if (affinity == null) {
      return new GcpClientCall.SimpleGcpClientCall<ReqT, RespT>(
          getChannelRef(null), methodDescriptor, callOptions);
    }
    return new GcpClientCall<ReqT, RespT>(this, methodDescriptor, callOptions, affinity);
  }

  @Override
  public synchronized ManagedChannel shutdownNow() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    return this;
  }

  @Override
  public synchronized ManagedChannel shutdown() {
    for (ChannelRef channelRef : channelRefs) {
      channelRef.getChannel().shutdown();
    }
    return this;
  }

  @Override
  public synchronized boolean awaitTermination(long timeout, TimeUnit unit)
      throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    for (ChannelRef channelRef : channelRefs) {
      if (channelRef.getChannel().isTerminated()) {
        continue;
      }
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      channelRef.getChannel().awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    return isTerminated();
  }

  @Override
  public synchronized boolean isShutdown() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public synchronized boolean isTerminated() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        return false;
      }
    }
    return true;
  }

  /** Get the current connectivity state of the channel pool. */
  @Override
  public synchronized ConnectivityState getState(boolean requestConnection) {
    int ready = 0;
    int idle = 0;
    int connecting = 0;
    int transientFailure = 0;
    int shutdown = 0;
    for (ChannelRef channelRef : channelRefs) {
      ConnectivityState cur = channelRef.getChannel().getState(requestConnection);
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

  /**
   * Bind channel with affinity key.
   *
   * <p>One channel can be mapped to more than one keys. But one key can only be mapped to one
   * channel.
   */
  protected void bind(ChannelRef channelRef, List<String> affinityKeys) {
    synchronized (bindLock) {
      if (affinityKeys != null && channelRef != null) {
        for (String affinityKey : affinityKeys) {
          if (!affinityKeyToChannelRef.containsKey(affinityKey)) {
            affinityKeyToChannelRef.put(affinityKey, channelRef);
          }
          affinityKeyToChannelRef.get(affinityKey).affinityCountIncr();
        }
      }
    }
  }

  /** Unbind channel with affinity key, and delete the affinitykey if necassary */
  protected void unbind(List<String> affinityKeys) {
    synchronized (bindLock) {
      if (affinityKeys != null) {
        for (String affinityKey : affinityKeys) {
          if (!affinityKey.equals("") && affinityKeyToChannelRef.containsKey(affinityKey)) {
            ChannelRef removedChannelRef = affinityKeyToChannelRef.get(affinityKey);
            if (removedChannelRef.getAffinityCount() > 0) {
              removedChannelRef.affinityCountDecr();
            }

            // Current channel has no affinity key bound with it.
            if (removedChannelRef.getAffinityCount() == 0) {
              Set<String> removedKeys = new HashSet<String>();
              for (String key : affinityKeyToChannelRef.keySet()) {
                if (affinityKeyToChannelRef.get(key) == removedChannelRef) {
                  removedKeys.add(key);
                }
              }
              for (String key : removedKeys) {
                affinityKeyToChannelRef.remove(key);
              }
            }
          }
        }
      }
    }
  }

  /** Load parameters from ApiConfig. */
  private void loadApiConfig(ApiConfig apiConfig) {
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
  }

  /**
   * Get the affinity key from the request message.
   *
   * <p>The message can be written in the format of:
   *
   * <p>session1: "the-key-we-want" \n transaction_id: "not-useful" \n transaction { \n session2:
   * "another session"} \n}
   *
   * <p>If the (affinity) name is "session1", it will return "the-key-we-want".
   *
   * <p>If you want to get the key "another session" in the nested message, the name should be
   * "session1.session2".
   */
  @VisibleForTesting
  static List<String> getKeysFromMessage(MessageOrBuilder msg, String name) {
    // The field names in a nested message name are splitted by '.'.
    int currentLength = name.indexOf('.');
    String currentName = name;
    if (currentLength != -1) {
      currentName = name.substring(0, currentLength);
    }

    List<String> keys = new ArrayList<>();
    Map<FieldDescriptor, Object> obs = msg.getAllFields();
    for (Map.Entry<FieldDescriptor, Object> entry : obs.entrySet()) {
      if (entry.getKey().getName().equals(currentName)) {
        if (currentLength == -1 && entry.getValue() instanceof String) {
          // Value of the current field.
          keys.add(entry.getValue().toString());
        } else if (currentLength != -1 && entry.getValue() instanceof MessageOrBuilder) {
          // One nested MessageOrBuilder.
          keys.addAll(
              getKeysFromMessage(
                  (MessageOrBuilder) entry.getValue(), name.substring(currentLength + 1)));
        } else if (currentLength != -1 && entry.getValue() instanceof List) {
          // Repeated nested MessageOrBuilder.
          List<?> list = (List<?>) entry.getValue();
          if (list.size() > 0 && list.get(0) instanceof MessageOrBuilder) {
            for (int i = 0; i < list.size(); i++) {
              keys.addAll(
                  getKeysFromMessage(
                      (MessageOrBuilder) list.get(i), name.substring(currentLength + 1)));
            }
          }
        }
      }
    }
    return keys;
  }

  /**
   * Fetch the affinity key from the message.
   *
   * @param message the <reqT> or <respT> prototype message.
   * @param isReq indicates if the message is a request message.
   */
  protected <ReqT, RespT> List<String> checkKeys(
      Object message, boolean isReq, MethodDescriptor<ReqT, RespT> methodDescriptor) {
    if (!(message instanceof MessageOrBuilder)) {
      return null;
    }

    AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
    if (affinity != null) {
      AffinityConfig.Command cmd = affinity.getCommand();
      String keyName = affinity.getAffinityKey();
      List<String> keys = getKeysFromMessage((MessageOrBuilder) message, keyName);
      if (isReq && (cmd == AffinityConfig.Command.UNBIND || cmd == AffinityConfig.Command.BOUND)) {
        if (keys.size() > 1) {
          throw new IllegalStateException("Duplicate affinity key in the request message");
        }
        return keys;
      }
      if (!isReq && cmd == AffinityConfig.Command.BIND) {
        return keys;
      }
    }
    return null;
  }

  /**
   * A wrapper of real grpc channel, it provides helper functions to calculate affinity counts and
   * active streams count.
   */
  protected class ChannelRef {

    private final ManagedChannel delegate;
    private final int channelId;
    private int affinityCount;
    private int activeStreamsCount;

    protected ChannelRef(ManagedChannel channel, int channelId) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = 0;
      this.activeStreamsCount = 0;
    }

    protected ChannelRef(
        ManagedChannel channel, int channelId, int affinityCount, int activeStreamsCount) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = affinityCount;
      this.activeStreamsCount = activeStreamsCount;
    }

    protected ManagedChannel getChannel() {
      return delegate;
    }

    protected int getId() {
      return channelId;
    }

    protected void affinityCountIncr() {
      affinityCount++;
    }

    protected void affinityCountDecr() {
      affinityCount--;
    }

    protected void activeStreamsCountIncr() {
      activeStreamsCount++;
    }

    protected void activeStreamsCountDecr() {
      activeStreamsCount--;
    }

    protected int getAffinityCount() {
      return affinityCount;
    }

    protected int getActiveStreamsCount() {
      return activeStreamsCount;
    }
  }
}
