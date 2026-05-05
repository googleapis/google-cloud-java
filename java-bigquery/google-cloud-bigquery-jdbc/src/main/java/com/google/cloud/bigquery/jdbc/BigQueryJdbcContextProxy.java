/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic InvocationHandler that transparently wraps JDBC operations. Sets the connection context
 * on the executing thread for connection routing, and cleans it up upon method exit to prevent
 * memory leaks and context bleeding. Acts as the unified exception logger for Statement and
 * Connection methods.
 */
class BigQueryJdbcContextProxy implements InvocationHandler {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcContextProxy.class.getName());

  private final Object target;
  private final String connectionId;
  private final Class<?> interfaceType;

  private BigQueryJdbcContextProxy(Object target, String connectionId, Class<?> interfaceType) {
    this.target = target;
    this.connectionId = connectionId;
    this.interfaceType = interfaceType;
  }

  /** Wraps a target JDBC object with a dynamic proxy carrying the connection context. */
  @SuppressWarnings("unchecked")
  static <T> T wrap(Object target, Class<T> interfaceType, String connectionId) {
    if (target == null) {
      return null;
    }
    return (T)
        Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[] {interfaceType},
            new BigQueryJdbcContextProxy(target, connectionId, interfaceType));
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // Handle standard Object methods explicitly
    if (method.getDeclaringClass() == Object.class) {
      String methodName = method.getName();
      if (methodName.equals("equals")) {
        Object other = args[0];
        if (other == null) {
          return false;
        }
        if (Proxy.isProxyClass(other.getClass())) {
          InvocationHandler handler = Proxy.getInvocationHandler(other);
          if (handler instanceof BigQueryJdbcContextProxy) {
            return target.equals(((BigQueryJdbcContextProxy) handler).target);
          }
        }
        return target.equals(other);
      }
      if (methodName.equals("hashCode")) {
        return target.hashCode();
      }
      if (methodName.equals("toString")) {
        return target.toString();
      }
    }

    // Support standard JDBC Wrapper unwrap operations
    if (method.getName().equals("unwrap") && args != null && args.length == 1) {
      Class<?> iface = (Class<?>) args[0];
      if (iface.isInstance(target)) {
        return target;
      }
      try {
        return method.invoke(target, args);
      } catch (InvocationTargetException e) {
        throw e.getCause();
      }
    }
    if (method.getName().equals("isWrapperFor") && args != null && args.length == 1) {
      Class<?> iface = (Class<?>) args[0];
      if (iface.isInstance(target)) {
        return true;
      }
      try {
        return method.invoke(target, args);
      } catch (InvocationTargetException e) {
        throw e.getCause();
      }
    }

    // Wrap execution in the context of the active connection for all non-bypassed methods
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connectionId)) {
      Object result = method.invoke(target, args);

      // Automatically cascade proxy wrappers to child JDBC objects returned from calls
      if (result instanceof java.sql.CallableStatement) {
        return wrap(result, java.sql.CallableStatement.class, connectionId);
      } else if (result instanceof java.sql.PreparedStatement) {
        return wrap(result, java.sql.PreparedStatement.class, connectionId);
      } else if (result instanceof java.sql.Statement) {
        return wrap(result, java.sql.Statement.class, connectionId);
      } else if (result instanceof java.sql.DatabaseMetaData) {
        return wrap(result, java.sql.DatabaseMetaData.class, connectionId);
      } else if (result instanceof java.sql.ParameterMetaData) {
        return wrap(result, java.sql.ParameterMetaData.class, connectionId);
      } else if (result instanceof java.sql.ResultSetMetaData) {
        return wrap(result, java.sql.ResultSetMetaData.class, connectionId);
      }

      return result;
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();

      // Unified Context Logger: Captures and logs every exception exactly once with the Connection
      // context
      if (BigQueryJdbcRootLogger.isFileLoggingEnabled()) {
        try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connectionId)) {
          LOG.severe(
              "Exception occurred during " + method.getName() + ": " + cause.getMessage(), cause);
        }
      }

      throw cause;
    }
  }
}
