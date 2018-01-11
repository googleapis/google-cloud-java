/*
 * Copyright 2017 Google LLC
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
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/info")
public class GaeInfoServlet extends HttpServlet {

  private static final long serialVersionUID = -3598229312089602597L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text");
    PrintWriter out = resp.getWriter();

    ClassLoader cl = getClass().getClassLoader();
    out.append("CLASS LOADER:\n\n");
    out.append("Name: ").append(cl != null ? cl.getClass().getName() : null).append('\n');
    if (cl instanceof URLClassLoader) {
      URLClassLoader urlCl = (URLClassLoader) cl;
      out.append("Urls: ").append('\n');
      for (URL url : urlCl.getURLs()) {
        out.append(url.toString()).append('\n');
      }
    }

    out.append("\nENVIRONMENT VARIABLES:\n\n");
    Map<String, String> envVars = System.getenv();
    for (Map.Entry<String, String> entry : envVars.entrySet()) {
      out.append(entry.getKey()).append("=").append(entry.getValue()).append('\n');
    }

    out.append("\n\nSYSTEM PROPERTIES:\n\n");
    System.getProperties().list(out);

    out.close();
  }
}
