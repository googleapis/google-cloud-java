/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
package com.google.cloud.managed.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/test")
public class GaeGcjTestServlet extends HttpServlet {

  private static final long serialVersionUID = 523885428311420041L;

  private final ThreadPoolExecutor executor =
      new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
  private volatile GcjTestRunner testRunner;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      String classNames = req.getParameter("classes");
      PrintWriter out = resp.getWriter();
      List<Class<?>> testClasses = loadClasses(classNames.split("[\\r\\n]+"));
      String output = runTests(testClasses, req, resp);
      out.append(output);
      out.close();
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter out = resp.getWriter();
    out.append(getTestOutput(req, resp));
    out.close();
  }

  private List<Class<?>> loadClasses(String... classNames) throws ClassNotFoundException {
    List<Class<?>> classes = new ArrayList<>();
    for (String className : classNames) {
      String cn = className.trim();
      if (!cn.isEmpty() && !cn.startsWith("#")) {
        classes.add(Class.forName(cn));
      }
    }
    return classes;
  }

  private String runTests(
      List<Class<?>> classes, HttpServletRequest req, HttpServletResponse resp) {
    synchronized (executor) {
      resp.setContentType("text/html");
      if (executor.getActiveCount() > 0) {
        return "Cannot start new test: the previous test hasn't completed yet.<p/>"
            + "The active test progress is at <a href='"
            + req.getRequestURL()
            + "'>"
            + req.getRequestURL()
            + "</a>.";
      }

      testRunner = new GcjTestRunner(classes);
      executor.execute(testRunner);
      return "Test started. Check progress at <a href='"
          + req.getRequestURL()
          + "'>"
          + req.getRequestURL()
          + "</a>";
    }
  }

  private String getTestOutput(HttpServletRequest req, HttpServletResponse resp) {
    synchronized (executor) {
      if (testRunner != null) {
        resp.setContentType("text");
        return testRunner.getOutput();
      }
      resp.setContentType("text/html");
      int urlUriLenDiff = req.getRequestURL().length() - req.getRequestURI().length();
      String link = req.getRequestURL().substring(0, urlUriLenDiff);
      return "Test hasn't been started yet. Go to <a href='"
          + link
          + "'>"
          + link
          + "</a> to start a new test";
    }
  }

  @Override
  public void destroy() {
    executor.shutdownNow();
    super.destroy();
  }
}
