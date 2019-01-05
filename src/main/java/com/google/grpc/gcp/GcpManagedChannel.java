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
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import com.google.protobuf.util.JsonFormat;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.ConnectivityState;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

// -------------------TODO: Take care of multithreads-------------------------
// -------------------TODO: LOG ----------------------------------------------

/** A channel management factory that implements grpc.Channel APIs. */
public class GcpManagedChannel extends ManagedChannel {

  private static final Logger logger = Logger.getLogger(GcpManagedChannel.class.getName());

  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int DEFAULT_MAX_STREAM = 100;

  private ApiConfig apiConfig;
  private int maxSize;
  private int maxConcurrentStreamsLowWatermark;
  private final ManagedChannelBuilder builder;
  @VisibleForTesting final Map<String, AffinityConfig> methodToAffinity;
  @VisibleForTesting final Map<String, ChannelRef> affinityKeyToChannelRef;
  @VisibleForTesting List<ChannelRef> channelRefs;

  // --------------------------------TODO------------------------------------
  // -  How to initialize a new managed channel? currently we use           -
  // -  ManagedChannelBuilder from outside the class                        -
  // -  Do we need to have our own GcpManagedChannelBuilder                 -
  // ------------------------------------------------------------------------

  /**
   * Constructor.
   *
   * @param builder the normal managedChannelBuilder
   * @param jsonPath optional, the path of the .json file defining the ApiConfig.
   */
  public GcpManagedChannel(ManagedChannelBuilder builder, String... jsonPath) {
    methodToAffinity = new HashMap<String, AffinityConfig>();
    affinityKeyToChannelRef = new HashMap<String, ChannelRef>();
    channelRefs = new ArrayList<ChannelRef>();
    maxSize = DEFAULT_MAX_CHANNEL;
    maxConcurrentStreamsLowWatermark = DEFAULT_MAX_STREAM;
    if (jsonPath.length == 0) {
      apiConfig = null;
    } else {
      loadApiConfig(jsonPath[0]);
    }
    this.builder = builder;
    getChannelRef();
  }

  public AffinityConfig getAffinity(String method) {
    return methodToAffinity.get(method);
  }

  public int getMaxSize() {
    return maxSize;
  }

  public int getStreamsLowWatermark() {
    return maxConcurrentStreamsLowWatermark;
  }

  /** Picks the channelRef with the least busy managedchannel from the pool. */
  protected synchronized ChannelRef getChannelRef() {
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
    // Otherwise return first channelref.
    return channelRefs.get(0);
  }

  protected ChannelRef getChannelRef(String key) {
    return affinityKeyToChannelRef.get(key);
  }

  @Override
  public String authority() {
    return channelRefs.get(0).getChannel().authority();
  }

  // --------------------------------TODO-----------------------------------
  // -   There are some non-abstract methods, do we need to override it .  -
  // -----------------------------------------------------------------------

  /*
   * Manage the channelpool inside the GcpClientCall(). We start with the channelRef with the least
   * busy channel.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    return new GcpClientCall<ReqT, RespT>(methodDescriptor, callOptions);
  }

  @Override
  public ManagedChannel shutdownNow() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
        channelRef.getChannel().shutdownNow();
      }
    }
    return this;
  }

  @Override
  public ManagedChannel shutdown() {
    for (ChannelRef channelRef : channelRefs) {
      channelRef.getChannel().shutdown();
    }
    return this;
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
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
  public boolean isShutdown() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isTerminated() {
    for (ChannelRef channelRef : channelRefs) {
      if (!channelRef.getChannel().isTerminated()) {
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
  public synchronized void bind(ChannelRef channelRef, String affinityKey) {
    if (affinityKey != null && !affinityKey.equals("") && channelRef != null) {
      if (!affinityKeyToChannelRef.containsKey(affinityKey)) {
        affinityKeyToChannelRef.put(affinityKey, channelRef);
      }
      affinityKeyToChannelRef.get(affinityKey).affinityCountIncr();
    }
  }

  /** Unbind channel with affinity key, and delete the affinitykey if necassary */
  public synchronized void unbind(String affinityKey) {
    if (affinityKey != null
        && !affinityKey.equals("")
        && affinityKeyToChannelRef.containsKey(affinityKey)) {
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

  /** Parse .JSON file into ApiConfig. */
  @VisibleForTesting
  static ApiConfig parseJson(String filePath) {
    JsonFormat.Parser parser = JsonFormat.parser();
    ApiConfig.Builder apiConfig = ApiConfig.newBuilder();
    try {
      FileReader reader = new FileReader(filePath);
      parser.merge(reader, apiConfig);
    } catch (FileNotFoundException e) {
      logger.severe(e.getMessage());
      return null;
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return null;
    }
    return apiConfig.build();
  }

  /** Load parameters from ApiConfig. */
  private void loadApiConfig(String jsonPath) {
    ApiConfig apiConfig = parseJson(jsonPath);
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

  /**
   * Get the affinity key from the request message.
   *
   * <p>Since the request is of the proto-buffer type, it can be decoded as string in the format of:
   *
   * <p>session: "the-key-we-want" \n transaction_id: "not-useful" \n transaction { \n begin {\n {
   * \n }\ n} \n}
   *
   * <p>Note that to get the key, we split the original string by '\n'. So this method is not able
   * to get key from nested messages like "transaction { \n begin {\n { \n }\ n} \n}" as above.
   */
  @VisibleForTesting
  static String getKeyFromMessage(String msg, String name) {
    for (String line : Splitter.on('\n').split(msg)) {
      if (line.startsWith(name) && line.length() > name.length() + 3) {
        int begin = name.length() + 3;
        int end = line.length() - 1;
        return line.substring(begin, end);
      }
    }
    return null;
  }

  /**
   * A wrapper of real grpc channel, it provides helper functions to calculate affinity counts and
   * active streams count.
   */
  @VisibleForTesting
  class ChannelRef {

    private final ManagedChannel delegate;
    private final int channelId;
    private final AtomicInteger affinityCount;
    private final AtomicInteger activeStreamsCount;

    ChannelRef(ManagedChannel channel, int channelId) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = new AtomicInteger(0);
      this.activeStreamsCount = new AtomicInteger(0);
    }

    ChannelRef(ManagedChannel channel, int channelId, int affinityCount, int activeStreamsCount) {
      this.delegate = channel;
      this.channelId = channelId;
      this.affinityCount = new AtomicInteger(affinityCount);
      this.activeStreamsCount = new AtomicInteger(activeStreamsCount);
    }

    protected ManagedChannel getChannel() {
      return delegate;
    }

    protected int getId() {
      return channelId;
    }

    protected void affinityCountIncr() {
      affinityCount.incrementAndGet();
    }

    protected void affinityCountDecr() {
      affinityCount.decrementAndGet();
    }

    protected void activeStreamsCountIncr() {
      activeStreamsCount.incrementAndGet();
    }

    protected void activeStreamsCountDecr() {
      activeStreamsCount.decrementAndGet();
    }

    protected int getAffinityCount() {
      return affinityCount.get();
    }

    protected int getActiveStreamsCount() {
      return activeStreamsCount.get();
    }
  }

  /**
   * A wrapper of ClientCall
   *
   * <p>It stores the information such as method, calloptions, the ChannelRef which created it, etc
   * to facilitate creating new calls. In addition, define the callback function to manage the
   * number of active streams and bind/unbind the affinity key.
   */
  public class GcpClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {

    private ChannelRef delegateChannelRef;
    private ClientCall<ReqT, RespT> delegateCall;
    private Metadata cachedHeaders;
    private Listener<RespT> cachedListener;
    private MethodDescriptor<ReqT, RespT> methodDescriptor;
    private CallOptions callOptions;
    private boolean streamingResponse;
    private Boolean enableCompression;
    private final AtomicBoolean received = new AtomicBoolean(false);
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final AtomicBoolean decremented = new AtomicBoolean(false);

    GcpClientCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
      this.delegateChannelRef = null;
      this.delegateCall = null;
      this.methodDescriptor = methodDescriptor;
      this.callOptions = callOptions;
      this.streamingResponse = false;
      this.enableCompression = null;
    }

    @Override
    public void request(int numMessages) {
      if (delegateCall == null) {
        // Response message is requested before request is sent.
        // See io.grpc.stub.ClientCalls.startcall().
        if (numMessages == 1) {
          streamingResponse = true;
        }
        return;
      }
      delegateCall.request(numMessages);
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      cachedHeaders = headers;
      cachedListener = responseListener;
    }

    /** Decrement the stream number by one when the call is cancelled. */
    @Override
    public void cancel(String message, Throwable cause) {
      if (delegateCall != null) {
        if (!decremented.getAndSet(true)) {
          delegateChannelRef.activeStreamsCountDecr();
        }
        delegateCall.cancel(message, cause);
      }
    }

    /**
     * Delay executing call.start() until call.sendMessage() is called, switch the channel, start
     * the call, and finally do sendMessage().
     */
    @Override
    public void sendMessage(ReqT message) {
      synchronized (this) {
        if (!started.getAndSet(true)) {
          // Check if the current channelRef is in bound with the key and change it if necessary.
          // If no channel is bound with the key, keep on using the least busy one.
          String key = checkKey(message, true);
          if (key != null && key != "" && getChannelRef(key) != null) {
            delegateChannelRef = getChannelRef(key);
          } else {
            delegateChannelRef = getChannelRef();
          }

          delegateChannelRef.activeStreamsCountIncr();
          if (enableCompression != null) {
            delegateCall.setMessageCompression(enableCompression);
          }
          delegateCall = delegateChannelRef.getChannel().newCall(methodDescriptor, callOptions);
          delegateCall.start(getListener(cachedListener), cachedHeaders);

          if (key != null
              && methodToAffinity.get(methodDescriptor.getFullMethodName()).getCommand()
                  == AffinityConfig.Command.UNBIND) {
            unbind(key);
          }

          // Initially ask for two responses from flow-control so that if a misbehaving server sends
          // more than one responses, we can catch it and fail it in the listener.
          if (streamingResponse) {
            delegateCall.request(1);
          } else {
            delegateCall.request(2);
          }
        }
      }
      delegateCall.sendMessage(message);
    }

    @Override
    public void halfClose() {
      if (delegateCall != null) {
        delegateCall.halfClose();
      }
    }

    @Override
    public boolean isReady() {
      if (delegateCall != null) {
        return delegateCall.isReady();
      }
      return false;
    }

    // By default it is enabled.
    @Override
    public void setMessageCompression(boolean enabled) {
      if (delegateCall != null) {
        delegateCall.setMessageCompression(enabled);
      } else {
        enableCompression = enabled;
      }
    }

    @Override
    public Attributes getAttributes() {
      return delegateCall.getAttributes();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("delegate", delegateCall).toString();
    }

    private Listener<RespT> getListener(final Listener<RespT> responseListener) {

      return new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
          responseListener) {
        // Decrement the stream number by one when the call is closed.
        @Override
        public void onClose(Status status, Metadata trailers) {
          // System.out.println("close" + delegateChannelRef.getId());
          if (!decremented.getAndSet(true)) {
            delegateChannelRef.activeStreamsCountDecr();
          }
          responseListener.onClose(status, trailers);
        }

        // If the command is "BIND", fetch the affinitykey from the response message and bind it
        // with the channelRef.
        @Override
        public void onMessage(RespT message) {
          synchronized (this) {
            if (!received.getAndSet(true)) {
              String key = checkKey(message, false);
              if (key != null) {
                bind(delegateChannelRef, key);
              }
            }
          }
          responseListener.onMessage(message);
        }
      };
    }

    /**
     * Fetch the affinity key from the meaasge.
     *
     * @param message the <reqT> or <respT> message, of prototype.
     * @param isReq indicates if the message is a request message.
     */
    private String checkKey(Object message, boolean isReq) {
      AffinityConfig affinity = methodToAffinity.get(methodDescriptor.getFullMethodName());
      if (affinity != null) {
        AffinityConfig.Command cmd = affinity.getCommand();
        String keyName = affinity.getAffinityKey();
        String key = getKeyFromMessage(message.toString(), keyName);
        if (key != null && key != "") {
          if ((isReq
                  && (cmd == AffinityConfig.Command.UNBIND || cmd == AffinityConfig.Command.BOUND))
              || (!isReq && cmd == AffinityConfig.Command.BIND)) {
            {
              return key;
            }
          }
        }
      }
      return null;
    }
  }
}
