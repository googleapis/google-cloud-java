/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session.fake;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.FakeSessionOpRequest;
import com.google.bigtable.v2.FakeSessionOpResponse;
import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenFakeSessionRequest.Action;
import com.google.bigtable.v2.OpenFakeSessionRequest.ActionList;
import com.google.bigtable.v2.OpenFakeSessionResponse;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
import com.google.bigtable.v2.SessionParametersResponse;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionRequest.PayloadCase;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.VirtualRpcRequest;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.common.base.Preconditions;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.Durations;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SessionHandler implements StreamObserver<SessionRequest> {
  public static final long AUTOMATIC_RPC_ID = -1;

  private final ScheduledExecutorService executor;
  private final StreamObserver<SessionResponse> respStream;
  private final Set<ScheduledFuture<?>> timers = new HashSet<>();
  private State state;

  public SessionHandler(
      ScheduledExecutorService executor, StreamObserver<SessionResponse> respStream) {
    this.executor = executor;
    this.respStream = respStream;

    this.state = new NewState(this);
  }

  // gRPC event handlers
  @Override
  public synchronized void onNext(SessionRequest msg) {
    state = state.onMessage(msg);
  }

  @Override
  public synchronized void onError(Throwable t) {
    state = state.onClose(Status.fromThrowable(t));
  }

  @Override
  public synchronized void onCompleted() {}

  // helpers
  ScheduledFuture<?> delay(Duration amount, Supplier<State> f) {
    ScheduledFuture<?> timer =
        executor.schedule(
            () -> {
              synchronized (SessionHandler.this) {
                state = f.get();
              }
            },
            amount.toMillis(),
            TimeUnit.MILLISECONDS);
    timers.add(timer);
    return timer;
  }

  void writeResponse(SessionResponse response) {
    respStream.onNext(response);
  }

  State terminateWithError(Status status) {
    respStream.onError(status.asRuntimeException());
    timers.forEach(t -> t.cancel(true));
    timers.clear();

    return DoneState.INSTANCE;
  }

  State terminateSuccess() {
    state = DoneState.INSTANCE;
    respStream.onCompleted();
    timers.forEach(t -> t.cancel(true));
    timers.clear();
    return state;
  }

  interface State {
    State onMessage(SessionRequest sReq);

    State onClose(Status status);
  }

  static class NewState implements State {
    private final SessionHandler handler;

    NewState(SessionHandler handler) {
      this.handler = handler;
    }

    @Override
    public State onMessage(SessionRequest sReq) {
      Preconditions.checkState(
          sReq.getPayloadCase() == PayloadCase.OPEN_SESSION,
          "NewState expected an OpenSession msg, got: %s",
          sReq);

      OpenFakeSessionRequest oReq;
      try {
        oReq = OpenFakeSessionRequest.parseFrom(sReq.getOpenSession().getPayload());
      } catch (InvalidProtocolBufferException e) {
        throw new RuntimeException(e);
      }

      if (oReq.hasStreamError()) {
        Status status =
            Status.fromCodeValue(oReq.getStreamError().getStatus().getCode())
                .withDescription(oReq.getStreamError().getStatus().getMessage());

        if (Durations.ZERO.equals(oReq.getStreamError().getDelay())) {
          return handler.terminateWithError(status);
        } else {
          ScheduledFuture<?> ignored =
              handler.delay(
                  Duration.ofMillis(Durations.toMillis(oReq.getStreamError().getDelay())),
                  () -> handler.state = handler.terminateWithError(status));
        }
      }

      // TODO: populate this
      SessionParametersResponse params =
          SessionParametersResponse.newBuilder().setKeepAlive(Durations.fromSeconds(1)).build();

      if (oReq.hasSessionParams()) {
        params = oReq.getSessionParams();
      }
      handler.writeResponse(SessionResponse.newBuilder().setSessionParameters(params).build());

      handler.writeResponse(
          SessionResponse.newBuilder()
              .setOpenSession(
                  OpenSessionResponse.newBuilder()
                      .setPayload(OpenFakeSessionResponse.newBuilder().build().toByteString()))
              .build());

      Duration goAwayDelay =
          oReq.hasGoAwayDelay()
              ? Duration.ofMillis(Durations.toMillis(oReq.getGoAwayDelay()))
              : Duration.ofMinutes(1);

      if (oReq.equals(OpenFakeSessionRequest.getDefaultInstance())) {
        oReq =
            OpenFakeSessionRequest.newBuilder()
                .putVrpcActions(
                    0,
                    ActionList.newBuilder()
                        .setRepeat(true)
                        .addActions(
                            Action.newBuilder()
                                .setResponse(VirtualRpcResponse.getDefaultInstance())
                                .build())
                        .build())
                .build();
      }

      return new RunningState(handler, goAwayDelay, oReq);
    }

    @Override
    public State onClose(Status status) {
      return DoneState.INSTANCE;
    }
  }

  static class RunningState implements State {
    private static final Duration HALF_CLOSE_WAIT_TIMEOUT = Duration.ofSeconds(1);

    private final SessionHandler helper;
    private ScheduledFuture<?> lifecycleTimer;
    private boolean vRpcActive = false;
    private boolean gotHalfClose = false;

    private final Map<Long, ActionList> actionsMap;
    private final Map<Long, ActionQueue> actionQueues = new HashMap<>();

    public RunningState(
        SessionHandler helper, Duration goAwayDelay, OpenFakeSessionRequest request) {
      this.helper = helper;
      this.actionsMap = request.getVrpcActionsMap();

      lifecycleTimer = helper.delay(goAwayDelay, this::handleGoAwayTimer);

      if (request.hasRefreshConfig()) {
        Duration refreshDelay =
            Duration.ofMillis(
                com.google.protobuf.util.Durations.toMillis(request.getRefreshConfigDelay()));
        helper.delay(refreshDelay, () -> handleRefreshConfigTimer(request.getRefreshConfig()));
      }
    }

    @Override
    public State onMessage(SessionRequest request) {
      switch (request.getPayloadCase()) {
        case VIRTUAL_RPC:
          State state = dispatchVRpc(request.getVirtualRpc());
          return state;
        case CLOSE_SESSION:
          return handleCloseMsg(request.getCloseSession());
        default:
          return helper.terminateWithError(
              Status.INTERNAL.withDescription("Unexpected payload: " + request));
      }
    }

    private State dispatchVRpc(VirtualRpcRequest request) {
      if (gotHalfClose) {
        return helper.terminateWithError(
            Status.INTERNAL.withDescription("got vRpc after client sent halfClose"));
      }
      Preconditions.checkState(!vRpcActive, "only 1 outstanding vRPC is supported");

      FakeSessionOpRequest innerReq;
      try {
        innerReq = FakeSessionOpRequest.parseFrom(request.getPayload());
      } catch (InvalidProtocolBufferException e) {
        throw new RuntimeException(e);
      }

      this.vRpcActive = true;

      switch (innerReq.getPayloadCase()) {
        case SCRIPTED_REQUEST:
          long tag = innerReq.getScriptedRequest().getTag();
          ActionList actionList = actionsMap.get(tag);
          Preconditions.checkNotNull(actionList, "tag not in action map: " + tag);
          if (actionQueues.get(tag) == null) {
            actionQueues.put(tag, createActionQueue(actionList));
          }
          return handleVRpcScripted(request.getRpcId(), actionQueues.get(tag));
        default:
          return helper.terminateWithError(
              Status.INVALID_ARGUMENT.withDescription("Unexpected vRpc type: " + request));
      }
    }

    private State handleVRpcScripted(long rpcId, ActionQueue actionQueue) {
      if (helper.state != this) {
        return helper.state;
      }

      Action action = actionQueue.getNextAction();
      if (action.hasDelay()) {
        @SuppressWarnings("UnusedVariable")
        ScheduledFuture<?> ignored =
            helper.delay(
                Duration.ofMillis(Durations.toMillis(action.getDelay())),
                () -> handleResponse(action, rpcId));
      } else {
        handleResponse(action, rpcId);
      }

      return this;
    }

    private State handleResponse(Action action, long rpcId) {
      if (action.equals(Action.getDefaultInstance())) {
        helper.writeResponse(
            SessionResponse.newBuilder()
                .setVirtualRpc(
                    VirtualRpcResponse.newBuilder()
                        .setRpcId(rpcId)
                        .setPayload(
                            FakeSessionOpResponse.newBuilder()
                                .setScripted(SessionFakeScriptedResponse.getDefaultInstance())
                                .build()
                                .toByteString()))
                .build());
      }

      if (action.hasResponse()) {
        if (action.getResponse().equals(VirtualRpcResponse.getDefaultInstance())) {
          helper.writeResponse(
              SessionResponse.newBuilder()
                  .setVirtualRpc(
                      VirtualRpcResponse.newBuilder()
                          .setRpcId(rpcId)
                          .setPayload(
                              FakeSessionOpResponse.newBuilder()
                                  .setScripted(SessionFakeScriptedResponse.getDefaultInstance())
                                  .build()
                                  .toByteString()))
                  .build());

        } else {
          VirtualRpcResponse response = action.getResponse();
          if (response.getRpcId() == AUTOMATIC_RPC_ID) {
            response = response.toBuilder().setRpcId(rpcId).build();
          }
          helper.writeResponse(SessionResponse.newBuilder().setVirtualRpc(response).build());
        }
      }

      if (action.hasErrorResponse()) {
        helper.writeResponse(
            SessionResponse.newBuilder().setError(action.getErrorResponse()).build());
      }

      vRpcActive = false;
      return this;
    }

    private State handleGoAwayTimer() {
      if (helper.state != this) {
        return helper.state;
      }
      helper.writeResponse(
          SessionResponse.newBuilder()
              .setGoAway(
                  GoAwayResponse.newBuilder()
                      .setReason("session_expiry")
                      .setDescription("Session needs to be refreshed")
                      .build())
              .build());
      this.lifecycleTimer = helper.delay(HALF_CLOSE_WAIT_TIMEOUT, this::handleCloseWaitTimeout);
      return this;
    }

    private State handleRefreshConfigTimer(com.google.bigtable.v2.SessionRefreshConfig config) {
      if (helper.state != this) {
        return helper.state;
      }
      helper.writeResponse(SessionResponse.newBuilder().setSessionRefreshConfig(config).build());
      return this;
    }

    private ActionQueue createActionQueue(ActionList actionList) {
      ActionQueue actionQueue;
      if (actionList.equals(ActionList.getDefaultInstance())) {
        Queue<Action> actions = new ArrayDeque<>();
        actions.add(Action.getDefaultInstance());
        actionQueue = new ActionQueue(true, actions);
      } else {
        actionQueue =
            new ActionQueue(actionList.getRepeat(), new ArrayDeque<>(actionList.getActionsList()));
      }
      return actionQueue;
    }

    // HalfClose
    @Override
    public State onClose(Status status) {
      lifecycleTimer.cancel(true);
      gotHalfClose = true;

      if (!vRpcActive) {
        return helper.terminateSuccess();
      }

      return this;
    }

    private State handleCloseWaitTimeout() {
      if (helper.state != this) {
        return helper.state;
      }

      return helper.terminateWithError(
          Status.INTERNAL.withDescription("client did not acknowledge a GO_AWAY response in time"));
    }

    private State handleCloseMsg(CloseSessionRequest ignored) {
      return helper.terminateSuccess();
    }
  }

  static class DoneState implements State {
    static final DoneState INSTANCE = new DoneState();

    private DoneState() {}

    @Override
    public State onMessage(SessionRequest request) {
      return this;
    }

    @Override
    public State onClose(Status status) {
      return this;
    }
  }

  static class ActionQueue {
    private final boolean isRepeat;
    private final Queue<Action> actions;

    ActionQueue(boolean repeat, Queue<Action> actions) {
      this.isRepeat = repeat;
      this.actions = actions;
    }

    Action getNextAction() {
      if (isRepeat) {
        return actions.peek();
      } else {
        return actions.poll();
      }
    }
  }
}
