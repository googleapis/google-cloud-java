/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;

class BigQueryPooledConnection implements PooledConnection {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryPooledConnection.class.getName());

  enum State {
    IDLE,
    IN_USE,
    RETIRED,
    CLOSED
  }

  private final BigQueryConnection bqConnection;
  private final String connectionId;
  private final Connection proxiedConnection;
  private final Long listenerPoolSize;
  private final int maxListenerCapacity;
  private final List<ConnectionEventListener> listeners;
  private final Object physicalLock = new Object();
  private final Object stateLock = new Object();
  private PooledConnectionListener internalPoolListener;
  private boolean detachedFromInternalPool = false;
  private boolean nonPoolListenerAttached = false;
  private PooledConnectionInvocationHandler activeHandle;
  private PooledConnectionInvocationHandler resettingHandle;
  private volatile State state = State.IDLE;

  BigQueryPooledConnection(BigQueryConnection bqConnection) {
    this.bqConnection = bqConnection;
    this.connectionId = bqConnection.getConnectionId();
    this.proxiedConnection = BigQueryJdbcContextProxy.wrap(bqConnection, Connection.class);
    Long configuredListenerPoolSize = bqConnection.getListenerPoolSize();
    this.listenerPoolSize =
        configuredListenerPoolSize != null
            ? configuredListenerPoolSize
            : BigQueryJdbcUrlUtility.DEFAULT_LISTENER_POOL_SIZE_VALUE;
    this.maxListenerCapacity = clampCapacity(this.listenerPoolSize);
    this.listeners = new ArrayList<>();
  }

  static int clampCapacity(long configuredSize) {
    if (configuredSize <= 0L) {
      return Integer.MAX_VALUE;
    }
    return (int) Math.min(configuredSize, Integer.MAX_VALUE);
  }

  Long getListenerPoolSize() {
    return listenerPoolSize;
  }

  boolean inUse() {
    return this.state == State.IN_USE;
  }

  boolean isAvailableForPool() {
    return this.state == State.IDLE && !this.bqConnection.isClosed();
  }

  boolean isClosed() {
    return this.state == State.CLOSED
        || this.state == State.RETIRED
        || this.bqConnection.isClosed();
  }

  @VisibleForTesting
  boolean isListenerPooled(ConnectionEventListener listener) {
    synchronized (stateLock) {
      return this.internalPoolListener == listener || this.listeners.contains(listener);
    }
  }

  void registerInternalPoolListener(PooledConnectionListener poolManager) {
    if (poolManager == null) {
      return;
    }
    synchronized (stateLock) {
      if (isHolderTerminalLocked()
          || this.bqConnection.isClosed()
          || this.detachedFromInternalPool) {
        return;
      }
      this.internalPoolListener = poolManager;
    }
  }

  BigQueryConnection claimPhysicalForReuse(PooledConnectionListener poolManager) {
    synchronized (stateLock) {
      if (this.state != State.IDLE
          || this.bqConnection.isClosed()
          || this.activeHandle != null
          || this.resettingHandle != null
          || this.detachedFromInternalPool
          || this.nonPoolListenerAttached
          || poolManager == null
          || this.internalPoolListener != poolManager
          || !this.listeners.isEmpty()) {
        return null;
      }
      this.state = State.RETIRED;
      this.internalPoolListener = null;
      this.listeners.clear();
      return this.bqConnection;
    }
  }

  void closeIfIdleAndSoleListener(ConnectionEventListener expectedListener) {
    synchronized (physicalLock) {
      synchronized (stateLock) {
        if (this.state != State.IDLE
            || this.bqConnection.isClosed()
            || this.activeHandle != null
            || this.resettingHandle != null
            || !isSolelyOwnedByPoolListenerLocked(expectedListener)) {
          return;
        }
        this.state = State.CLOSED;
        this.internalPoolListener = null;
        this.listeners.clear();
      }
      try {
        this.bqConnection.close();
      } catch (SQLException ex) {
        LOG.warning(ex, "Failed to close excess pooled connection");
      }
    }
  }

  @VisibleForTesting
  PooledConnectionInvocationHandler getActiveHandleForTesting() {
    synchronized (stateLock) {
      return this.activeHandle;
    }
  }

  private boolean isSolelyOwnedByPoolListenerLocked(ConnectionEventListener expectedListener) {
    if (this.nonPoolListenerAttached || expectedListener == null) {
      return false;
    }
    if (!this.detachedFromInternalPool && this.internalPoolListener != null) {
      return this.internalPoolListener == expectedListener && this.listeners.isEmpty();
    }
    return this.internalPoolListener == null
        && this.listeners.size() == 1
        && this.listeners.get(0) == expectedListener;
  }

  private List<ConnectionEventListener> snapshotAllListenersLocked() {
    List<ConnectionEventListener> snapshot =
        new ArrayList<>(this.listeners.size() + (this.internalPoolListener != null ? 1 : 0));
    if (this.internalPoolListener != null) {
      snapshot.add(this.internalPoolListener);
    }
    snapshot.addAll(this.listeners);
    return snapshot;
  }

  private boolean isHolderTerminalLocked() {
    return this.state == State.CLOSED || this.state == State.RETIRED;
  }

  private void checkHolderOpenLocked() throws BigQueryJdbcException {
    if (this.state == State.RETIRED) {
      throw new BigQueryJdbcException(
          "PooledConnection was retired and recycled by PooledConnectionDataSource.");
    }
    if (this.state == State.CLOSED || this.bqConnection.isClosed()) {
      throw new BigQueryJdbcException("PooledConnection is closed.");
    }
  }

  @Override
  public Connection getConnection() throws SQLException {
    SQLException resetFailure = null;
    SQLException outOfBandClosedError = null;
    Connection handleProxy = null;

    synchronized (physicalLock) {
      PooledConnectionInvocationHandler previousHandle = null;
      boolean needsReset = false;
      synchronized (stateLock) {
        if (this.state == State.RETIRED) {
          throw new BigQueryJdbcException(
              "PooledConnection was retired and recycled by PooledConnectionDataSource.");
        }
        if (isHolderTerminalLocked()) {
          throw new BigQueryJdbcException("PooledConnection is closed.");
        }
        if (this.bqConnection.isClosed()) {
          outOfBandClosedError =
              new BigQueryJdbcException("Underlying physical connection was closed.");
        } else {
          // Per javax.sql.PooledConnection#getConnection() (JDBC 4.3 section 11.1), calling
          // getConnection() while a logical handle is open invalidates the prior handle and
          // resets connection state without notifying ConnectionEventListeners.
          previousHandle = this.activeHandle;
          if (previousHandle != null) {
            previousHandle.markClosed();
          }
          // Keep state == State.IN_USE in needsReset so a prior reset aborted by an Error
          // still forces a clean reset on a subsequent checkout attempt.
          needsReset = (this.state == State.IN_USE) || (previousHandle != null);
          this.activeHandle = null;
          this.resettingHandle = previousHandle;
          this.state = State.IN_USE;
        }
      }

      if (outOfBandClosedError == null) {
        try (BigQueryJdbcMdc.MdcCloseable mdc =
            BigQueryJdbcMdc.registerInstance(this.connectionId)) {
          LOG.finer("++enter++");
          if (previousHandle != null) {
            previousHandle.awaitQuiescence();
          }
          if (needsReset) {
            resetFailure = runResetCapturingException();
          }
          synchronized (stateLock) {
            this.resettingHandle = null;
            if (resetFailure == null) {
              checkHolderOpenLocked();
              PooledConnectionInvocationHandler handler =
                  new PooledConnectionInvocationHandler(
                      this.bqConnection, this.proxiedConnection, this);
              handleProxy = handler.createConnectionProxy();
              this.activeHandle = handler;
            }
          }
          if (resetFailure == null) {
            LOG.finer("++exit++");
            return handleProxy;
          }
        }
      }
    }

    if (outOfBandClosedError != null) {
      fireConnectionError(outOfBandClosedError);
      throw new BigQueryJdbcException("PooledConnection is closed.");
    }
    fireConnectionError(resetFailure);
    throw resetFailure;
  }

  @Override
  public void close() throws SQLException {
    TerminalTransition transition = transitionToClosedAndMarkActiveHandle();
    if (transition == null) {
      return;
    }
    for (ConnectionEventListener listener : transition.listeners) {
      if (listener instanceof PooledConnectionListener) {
        ((PooledConnectionListener) listener).removeConnection(this);
      }
    }
    synchronized (physicalLock) {
      if (!this.bqConnection.isClosed()) {
        try (BigQueryJdbcMdc.MdcCloseable mdc =
            BigQueryJdbcMdc.registerInstance(this.connectionId)) {
          LOG.finer("++enter++");
          if (transition.previousHandle != null) {
            transition.previousHandle.awaitQuiescence();
          }
        }
      } else if (transition.previousHandle != null) {
        transition.previousHandle.awaitQuiescence();
      }
      // Omit ++exit++ after bqConnection.close() since physical close unmounts the per-connection
      // file handler.
      this.bqConnection.close();
    }
  }

  @Override
  public void addConnectionEventListener(ConnectionEventListener listener) {
    if (listener == null) {
      return;
    }
    PooledConnectionListener detachedInternal = null;
    synchronized (stateLock) {
      if (isHolderTerminalLocked()
          || this.bqConnection.isClosed()
          || this.listeners.contains(listener)) {
        return;
      }
      try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(this.connectionId)) {
        LOG.finer("++enter++");
        try {
          if (this.listeners.size() >= maxListenerCapacity) {
            throw new BigQueryJdbcRuntimeException(
                "Listener pool capacity exceeded: " + listenerPoolSize);
          }
          this.listeners.add(listener);
          if (!(listener instanceof PooledConnectionListener) || this.listeners.size() > 1) {
            this.nonPoolListenerAttached = true;
          }
          if (this.nonPoolListenerAttached
              || (this.internalPoolListener != null && listener != this.internalPoolListener)) {
            this.detachedFromInternalPool = true;
            detachedInternal = this.internalPoolListener;
            this.internalPoolListener = null;
          }
        } finally {
          LOG.finer("++exit++");
        }
      }
    }
    if (detachedInternal != null) {
      detachedInternal.removeConnection(this);
    }
  }

  @Override
  public void removeConnectionEventListener(ConnectionEventListener listener) {
    if (listener == null) {
      return;
    }
    synchronized (stateLock) {
      this.listeners.remove(listener);
    }
  }

  void connectionHandleClosed(PooledConnectionInvocationHandler handle) throws SQLException {
    SQLException resetFailure = null;
    SQLException outOfBandClosedError = null;
    List<ConnectionEventListener> listenersToNotify = null;

    synchronized (physicalLock) {
      synchronized (stateLock) {
        if (isHolderTerminalLocked() || handle != this.activeHandle) {
          return;
        }
        this.activeHandle = null;
        if (this.bqConnection.isClosed()) {
          outOfBandClosedError =
              new BigQueryJdbcException("Underlying physical connection was closed.");
        } else {
          this.resettingHandle = handle;
        }
      }

      if (outOfBandClosedError == null) {
        try (BigQueryJdbcMdc.MdcCloseable mdc =
            BigQueryJdbcMdc.registerInstance(this.connectionId)) {
          LOG.finer("++enter++");
          resetFailure = runResetCapturingException();
          synchronized (stateLock) {
            this.resettingHandle = null;
            if (resetFailure == null) {
              if (isHolderTerminalLocked()) {
                return;
              }
              if (this.bqConnection.isClosed()) {
                outOfBandClosedError =
                    new BigQueryJdbcException("Underlying physical connection was closed.");
              } else {
                this.state = State.IDLE;
                listenersToNotify = snapshotAllListenersLocked();
              }
            }
          }
          if (outOfBandClosedError == null && resetFailure == null && listenersToNotify != null) {
            LOG.finer(
                "Logical connection handle returned to pool [connectionId=%s]", this.connectionId);
            LOG.finer("++exit++");
          }
        }
      }
    }

    if (outOfBandClosedError != null) {
      fireConnectionError(outOfBandClosedError);
      return;
    }
    if (resetFailure != null) {
      fireConnectionError(resetFailure);
      throw resetFailure;
    }
    if (listenersToNotify != null) {
      notifyConnectionClosedListeners(listenersToNotify);
    }
  }

  void abortHandle(PooledConnectionInvocationHandler handle, Executor executor)
      throws SQLException {
    List<ConnectionEventListener> snapshot;
    synchronized (stateLock) {
      if (isHolderTerminalLocked()
          || (handle != this.activeHandle && handle != this.resettingHandle)) {
        return;
      }
      this.state = State.CLOSED;
      this.activeHandle = null;
      this.resettingHandle = null;
      snapshot = snapshotAllListenersLocked();
      this.internalPoolListener = null;
      this.listeners.clear();
    }

    SQLException abortError =
        new BigQueryJdbcException("Connection is being terminated and aborted.");
    try {
      this.proxiedConnection.abort(executor);
    } catch (SQLException ex) {
      abortError.addSuppressed(ex);
      scheduleFallbackClose(executor, abortError);
      throw ex;
    } catch (RuntimeException ex) {
      abortError.addSuppressed(ex);
      scheduleFallbackClose(executor, abortError);
      throw ex;
    } finally {
      notifyConnectionErrorListeners(snapshot, abortError);
    }
  }

  private void scheduleFallbackClose(Executor executor, SQLException abortError) {
    try {
      executor.execute(() -> closePhysicalQuietly(abortError));
    } catch (RuntimeException rejectedEx) {
      abortError.addSuppressed(rejectedEx);
      closePhysicalQuietly(abortError);
    }
  }

  void fireConnectionError(SQLException error) {
    TerminalTransition transition = transitionToClosedAndMarkActiveHandle();
    if (transition == null) {
      return;
    }
    synchronized (physicalLock) {
      if (transition.previousHandle != null) {
        transition.previousHandle.awaitQuiescence();
      }
      closePhysicalQuietly(error);
    }
    notifyConnectionErrorListeners(transition.listeners, error);
  }

  private void closePhysicalQuietly(SQLException primaryError) {
    try {
      this.bqConnection.close();
    } catch (SQLException closeEx) {
      if (primaryError != null && closeEx != primaryError) {
        primaryError.addSuppressed(closeEx);
      } else {
        LOG.warning(closeEx, "Failed to close physical connection after error");
      }
    }
  }

  private void notifyConnectionClosedListeners(List<ConnectionEventListener> snapshot) {
    if (snapshot.isEmpty()) {
      return;
    }
    ConnectionEvent event = new ConnectionEvent(this);
    for (ConnectionEventListener listener : snapshot) {
      try {
        listener.connectionClosed(event);
      } catch (RuntimeException ex) {
        LOG.warning(ex, "ConnectionEventListener threw an exception during connectionClosed");
      }
    }
  }

  private void notifyConnectionErrorListeners(
      List<ConnectionEventListener> snapshot, SQLException error) {
    if (snapshot.isEmpty()) {
      return;
    }
    ConnectionEvent event = new ConnectionEvent(this, error);
    for (ConnectionEventListener listener : snapshot) {
      try {
        listener.connectionErrorOccurred(event);
      } catch (RuntimeException ex) {
        LOG.warning(
            ex, "ConnectionEventListener threw an exception during connectionErrorOccurred");
      }
    }
    String message = error != null ? error.getMessage() : "Connection error occurred";
    LOG.finer(
        "Pooled connection removed from pool due to error [connectionId=%s]: %s",
        this.connectionId, message);
  }

  private SQLException runResetCapturingException() {
    try {
      this.bqConnection.resetForReuse();
      return null;
    } catch (SQLException ex) {
      return ex;
    } catch (RuntimeException ex) {
      return new BigQueryJdbcException("Failed to reset pooled connection state", ex);
    }
  }

  private static final class TerminalTransition {
    final List<ConnectionEventListener> listeners;
    final PooledConnectionInvocationHandler previousHandle;

    TerminalTransition(
        List<ConnectionEventListener> listeners, PooledConnectionInvocationHandler previousHandle) {
      this.listeners = listeners;
      this.previousHandle = previousHandle;
    }
  }

  private TerminalTransition transitionToClosedAndMarkActiveHandle() {
    synchronized (stateLock) {
      if (isHolderTerminalLocked()) {
        return null;
      }
      this.state = State.CLOSED;
      PooledConnectionInvocationHandler previous = this.activeHandle;
      if (previous != null) {
        previous.markClosed();
        this.activeHandle = null;
      }
      this.resettingHandle = null;
      List<ConnectionEventListener> snapshot = snapshotAllListenersLocked();
      this.internalPoolListener = null;
      this.listeners.clear();
      return new TerminalTransition(snapshot, previous);
    }
  }

  @Override
  public void addStatementEventListener(StatementEventListener arg0) {
    UnsupportedOperationException ex =
        new UnsupportedOperationException(
            "Method 'addStatementEventListener' is not supported by the BQ Driver");
    LOG.severe(ex.getMessage(), ex);
    throw ex;
  }

  @Override
  public void removeStatementEventListener(StatementEventListener arg0) {
    UnsupportedOperationException ex =
        new UnsupportedOperationException(
            "Method 'removeStatementEventListener' is not supported by the BQ Driver");
    LOG.severe(ex.getMessage(), ex);
    throw ex;
  }

  static final class PooledConnectionInvocationHandler implements InvocationHandler {
    private static final BigQueryJdbcCustomLogger LOG =
        new BigQueryJdbcCustomLogger(PooledConnectionInvocationHandler.class.getName());

    private final BigQueryConnection bqConnection;
    private final Connection proxiedDelegate;
    private final BigQueryPooledConnection pooledConnection;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final ReentrantReadWriteLock handleLock = new ReentrantReadWriteLock();

    PooledConnectionInvocationHandler(
        BigQueryConnection bqConnection,
        Connection proxiedDelegate,
        BigQueryPooledConnection pooledConnection) {
      this.bqConnection = bqConnection;
      this.proxiedDelegate = proxiedDelegate;
      this.pooledConnection = pooledConnection;
    }

    Connection createConnectionProxy() {
      return (Connection)
          Proxy.newProxyInstance(
              Connection.class.getClassLoader(), new Class<?>[] {Connection.class}, this);
    }

    void markClosed() {
      this.closed.set(true);
    }

    void awaitQuiescence() {
      this.handleLock.writeLock().lock();
      this.handleLock.writeLock().unlock();
    }

    boolean isClosed() {
      return this.closed.get() || this.bqConnection.isClosed();
    }

    void checkClosed() throws BigQueryJdbcException {
      if (isClosed()) {
        throw new BigQueryJdbcException("Connection is closed.");
      }
    }

    private void checkClosedForClientInfo(Object[] args) throws SQLClientInfoException {
      if (isClosed()) {
        throw buildClosedClientInfoException(args);
      }
    }

    private static SQLClientInfoException buildClosedClientInfoException(Object[] args) {
      if (args == null || args.length == 0 || args[0] == null) {
        return new SQLClientInfoException("Connection is closed.", Collections.emptyMap());
      }
      if (args.length == 2 && args[0] instanceof String) {
        return new SQLClientInfoException(
            "Connection is closed.",
            Collections.singletonMap((String) args[0], ClientInfoStatus.REASON_UNKNOWN));
      }
      if (args.length == 1 && args[0] instanceof Properties) {
        Properties props = (Properties) args[0];
        Map<String, ClientInfoStatus> failed = new HashMap<>();
        for (String name : props.stringPropertyNames()) {
          failed.put(name, ClientInfoStatus.REASON_UNKNOWN);
        }
        return new SQLClientInfoException("Connection is closed.", failed);
      }
      return new SQLClientInfoException("Connection is closed.", Collections.emptyMap());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      String methodName = method.getName();

      if (method.getDeclaringClass() == Object.class) {
        return invokeObjectMethod(proxy, methodName, args);
      }

      if ("close".equals(methodName) && (args == null || args.length == 0)) {
        if (!this.closed.compareAndSet(false, true)) {
          return null;
        }
        if (!this.bqConnection.isClosed()) {
          try (BigQueryJdbcMdc.MdcCloseable mdc =
              BigQueryJdbcMdc.registerInstance(this.bqConnection.getConnectionId())) {
            LOG.finer("Closing logical connection handle.");
          }
        }
        awaitQuiescence();
        this.pooledConnection.connectionHandleClosed(this);
        return null;
      }

      if ("isClosed".equals(methodName) && (args == null || args.length == 0)) {
        return isClosed();
      }

      if ("abort".equals(methodName) && args != null && args.length == 1) {
        Executor executor = (Executor) args[0];
        if (executor == null) {
          throw new BigQueryJdbcException("Executor cannot be null.");
        }
        this.closed.set(true);
        this.pooledConnection.abortHandle(this, executor);
        return null;
      }

      if ("isValid".equals(methodName) && args != null && args.length == 1) {
        int timeout = (Integer) args[0];
        if (timeout < 0) {
          throw new BigQueryJdbcException("timeout must be >= 0");
        }
        this.handleLock.readLock().lock();
        try {
          if (isClosed()) {
            return false;
          }
          return invokeDelegate(this.proxiedDelegate, method, args);
        } finally {
          this.handleLock.readLock().unlock();
        }
      }

      if ("isWrapperFor".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        if (iface == null) {
          return false;
        }
        this.handleLock.readLock().lock();
        try {
          if (isClosed()) {
            return false;
          }
          if (iface.isInstance(proxy)) {
            return true;
          }
          return invokeDelegate(this.proxiedDelegate, method, args);
        } finally {
          this.handleLock.readLock().unlock();
        }
      }

      if ("unwrap".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        this.handleLock.readLock().lock();
        try {
          checkClosed();
          if (iface == null) {
            throw new BigQueryJdbcException("Unable to unwrap to null interface.");
          }
          if (iface.isInstance(proxy)) {
            return iface.cast(proxy);
          }
          return invokeDelegate(this.proxiedDelegate, method, args);
        } finally {
          this.handleLock.readLock().unlock();
        }
      }

      if ("setClientInfo".equals(methodName)) {
        this.handleLock.readLock().lock();
        try {
          checkClosedForClientInfo(args);
          Object result = invokeDelegate(this.proxiedDelegate, method, args);
          checkClosedForClientInfo(args);
          return result;
        } finally {
          this.handleLock.readLock().unlock();
        }
      }

      this.handleLock.readLock().lock();
      try {
        checkClosed();
        Object result = invokeDelegate(this.proxiedDelegate, method, args);
        if (isClosed()) {
          if (result instanceof Statement) {
            closeStatementQuietly((Statement) result);
          }
          throw new BigQueryJdbcException("Connection is closed.");
        }
        return wrapChildObject((Connection) proxy, result);
      } finally {
        this.handleLock.readLock().unlock();
      }
    }

    private Object wrapChildObject(Connection connectionProxy, Object result) throws SQLException {
      if (result == null) {
        return null;
      }
      if (result instanceof Statement) {
        Statement stmt = (Statement) result;
        Class<? extends Statement> stmtInterface = resolveStatementInterface(stmt);
        Statement stmtProxy =
            (Statement)
                Proxy.newProxyInstance(
                    stmtInterface.getClassLoader(),
                    new Class<?>[] {stmtInterface},
                    new PooledStatementInvocationHandler(stmt, connectionProxy, this));
        if (stmt.isWrapperFor(BigQueryStatement.class)) {
          stmt.unwrap(BigQueryStatement.class).attachPooledProxies(connectionProxy, stmtProxy);
        }
        return stmtProxy;
      }
      if (result instanceof DatabaseMetaData) {
        return Proxy.newProxyInstance(
            DatabaseMetaData.class.getClassLoader(),
            new Class<?>[] {DatabaseMetaData.class},
            new PooledDatabaseMetaDataInvocationHandler(
                (DatabaseMetaData) result, connectionProxy, this));
      }
      return result;
    }

    private static Class<? extends Statement> resolveStatementInterface(Statement stmt) {
      if (stmt instanceof CallableStatement) {
        return CallableStatement.class;
      }
      if (stmt instanceof PreparedStatement) {
        return PreparedStatement.class;
      }
      return Statement.class;
    }
  }

  private static final class PooledStatementInvocationHandler implements InvocationHandler {
    private final Statement delegate;
    private final Connection connectionProxy;
    private final PooledConnectionInvocationHandler parentHandler;

    PooledStatementInvocationHandler(
        Statement delegate,
        Connection connectionProxy,
        PooledConnectionInvocationHandler parentHandler) {
      this.delegate = delegate;
      this.connectionProxy = connectionProxy;
      this.parentHandler = parentHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      String methodName = method.getName();
      if (method.getDeclaringClass() == Object.class) {
        return invokeObjectMethod(proxy, methodName, args);
      }
      if (("close".equals(methodName)
              || "isClosed".equals(methodName)
              || "cancel".equals(methodName))
          && (args == null || args.length == 0)) {
        return invokeDelegate(this.delegate, method, args);
      }
      if ("getConnection".equals(methodName) && (args == null || args.length == 0)) {
        if (this.delegate.isClosed()) {
          throw new BigQueryJdbcException("Statement is closed.");
        }
        this.parentHandler.checkClosed();
        return this.connectionProxy;
      }
      if ("isWrapperFor".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        if (iface == null) {
          return false;
        }
        this.parentHandler.handleLock.readLock().lock();
        try {
          if (this.delegate.isClosed() || this.parentHandler.isClosed()) {
            return false;
          }
          if (iface.isInstance(proxy)) {
            return true;
          }
          return invokeDelegate(this.delegate, method, args);
        } finally {
          this.parentHandler.handleLock.readLock().unlock();
        }
      }
      if ("unwrap".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        this.parentHandler.handleLock.readLock().lock();
        try {
          if (this.delegate.isClosed()) {
            throw new BigQueryJdbcException("Statement is closed.");
          }
          this.parentHandler.checkClosed();
          if (iface == null) {
            throw new BigQueryJdbcException("Unable to unwrap to null interface.");
          }
          if (iface.isInstance(proxy)) {
            return iface.cast(proxy);
          }
          return invokeDelegate(this.delegate, method, args);
        } finally {
          this.parentHandler.handleLock.readLock().unlock();
        }
      }

      this.parentHandler.handleLock.readLock().lock();
      try {
        if (this.delegate.isClosed()) {
          throw new BigQueryJdbcException("Statement is closed.");
        }
        this.parentHandler.checkClosed();
        Object result = invokeDelegate(this.delegate, method, args);
        if (this.parentHandler.isClosed()) {
          if (result instanceof ResultSet) {
            closeResultSetQuietly((ResultSet) result);
          }
          closeStatementQuietly(this.delegate);
          throw new BigQueryJdbcException("Connection is closed.");
        }
        return result;
      } finally {
        this.parentHandler.handleLock.readLock().unlock();
      }
    }
  }

  private static final class PooledDatabaseMetaDataInvocationHandler implements InvocationHandler {
    private final DatabaseMetaData delegate;
    private final Connection connectionProxy;
    private final PooledConnectionInvocationHandler parentHandler;

    PooledDatabaseMetaDataInvocationHandler(
        DatabaseMetaData delegate,
        Connection connectionProxy,
        PooledConnectionInvocationHandler parentHandler) {
      this.delegate = delegate;
      this.connectionProxy = connectionProxy;
      this.parentHandler = parentHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      String methodName = method.getName();
      if (method.getDeclaringClass() == Object.class) {
        return invokeObjectMethod(proxy, methodName, args);
      }
      if ("getConnection".equals(methodName) && (args == null || args.length == 0)) {
        this.parentHandler.checkClosed();
        return this.connectionProxy;
      }
      if ("isWrapperFor".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        if (iface == null) {
          return false;
        }
        this.parentHandler.handleLock.readLock().lock();
        try {
          if (this.parentHandler.isClosed()) {
            return false;
          }
          if (iface.isInstance(proxy)) {
            return true;
          }
          return invokeDelegate(this.delegate, method, args);
        } finally {
          this.parentHandler.handleLock.readLock().unlock();
        }
      }
      if ("unwrap".equals(methodName) && args != null && args.length == 1) {
        Class<?> iface = (Class<?>) args[0];
        this.parentHandler.handleLock.readLock().lock();
        try {
          this.parentHandler.checkClosed();
          if (iface == null) {
            throw new BigQueryJdbcException("Unable to unwrap to null interface.");
          }
          if (iface.isInstance(proxy)) {
            return iface.cast(proxy);
          }
          return invokeDelegate(this.delegate, method, args);
        } finally {
          this.parentHandler.handleLock.readLock().unlock();
        }
      }
      this.parentHandler.handleLock.readLock().lock();
      try {
        this.parentHandler.checkClosed();
        Object result = invokeDelegate(this.delegate, method, args);
        if (this.parentHandler.isClosed()) {
          if (result instanceof ResultSet) {
            closeResultSetQuietly((ResultSet) result);
          }
          throw new BigQueryJdbcException("Connection is closed.");
        }
        return result;
      } finally {
        this.parentHandler.handleLock.readLock().unlock();
      }
    }
  }

  private static void closeStatementQuietly(Statement statement) {
    try {
      statement.close();
    } catch (SQLException ignored) {
      // Primary closed-connection exception takes precedence.
    }
  }

  private static void closeResultSetQuietly(ResultSet resultSet) {
    try {
      resultSet.close();
    } catch (SQLException ignored) {
      // Primary closed-connection exception takes precedence.
    }
  }

  private static Object invokeObjectMethod(Object proxy, String methodName, Object[] args) {
    if ("equals".equals(methodName)) {
      return proxy == args[0];
    }
    if ("hashCode".equals(methodName)) {
      return System.identityHashCode(proxy);
    }
    if ("toString".equals(methodName)) {
      return proxy.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(proxy));
    }
    throw new AssertionError("Unexpected Object method: " + methodName);
  }

  private static Object invokeDelegate(Object target, Method method, Object[] args)
      throws Throwable {
    try {
      return method.invoke(target, args);
    } catch (InvocationTargetException e) {
      throw e.getCause();
    }
  }
}
