/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.resourcemanager.testing;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.net.HttpURLConnection.HTTP_OK;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.cloudresourcemanager.model.Binding;
import com.google.api.services.cloudresourcemanager.model.Operation;
import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.api.services.cloudresourcemanager.model.SetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsRequest;
import com.google.api.services.cloudresourcemanager.model.TestIamPermissionsResponse;
import com.google.cloud.NoCredentials;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Utility to create a local Resource Manager mock for testing.
 *
 * <p>The mock runs in a separate thread, listening for HTTP requests on the local machine at an
 * ephemeral port. While this mock attempts to simulate the Cloud Resource Manager, there are some
 * divergences in behavior. The following is a non-exhaustive list of some of those behavioral
 * differences:
 *
 * <ul>
 *   <li>This mock assumes you have adequate permissions for any action. Related to this,
 *       <i>testIamPermissions</i> always indicates that the caller has all permissions listed in
 *       the request.
 *   <li>IAM policies are set to an empty policy with version 0 (only legacy roles supported) upon
 *       project creation. The actual service will not have an empty list of bindings and may also
 *       set your version to 1.
 *   <li>There is no input validation for the policy provided when replacing a policy or calling
 *       testIamPermissions.
 *   <li>In this mock, projects never move from the <i>DELETE_REQUESTED</i> lifecycle state to
 *       <i>DELETE_IN_PROGRESS</i> without an explicit call to the utility method {@link
 *       #changeLifecycleState}. Similarly, a project is never completely removed without an
 *       explicit call to the utility method {@link #removeProject}.
 *   <li>The messages in the error responses given by this mock do not necessarily match the
 *       messages given by the actual service.
 * </ul>
 *
 * @deprecated v3 GAPIC client of ResourceManager is now available
 */
@Deprecated
@SuppressWarnings("restriction")
public class LocalResourceManagerHelper {
  private static final Logger log = Logger.getLogger(LocalResourceManagerHelper.class.getName());
  private static final JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
  private static final Random PROJECT_NUMBER_GENERATOR = new Random();
  private static final String VERSION = "v1";
  private static final String CONTEXT = "/" + VERSION + "/projects";
  private static final String OPERATION_CONTEXT = "/" + VERSION + "/operations";
  private static final URI BASE_CONTEXT;
  private static final Set<String> SUPPORTED_COMPRESSION_ENCODINGS =
      ImmutableSet.of("gzip", "x-gzip");
  private static final Pattern LIST_FIELDS_PATTERN =
      Pattern.compile("(.*?)projects\\((.*?)\\)(.*?)");
  private static final String[] NO_FIELDS = {};

  static {
    try {
      BASE_CONTEXT = new URI(CONTEXT);
    } catch (URISyntaxException e) {
      throw new RuntimeException(
          "Could not initialize LocalResourceManagerHelper due to URISyntaxException.", e);
    }
  }

  // see https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects
  private static final Set<Character> PERMISSIBLE_PROJECT_NAME_PUNCTUATION =
      ImmutableSet.of('-', '\'', '"', ' ', '!');

  private final HttpServer server;
  private final ConcurrentSkipListMap<String, Project> projects = new ConcurrentSkipListMap<>();
  private final Map<String, Policy> policies = new HashMap<>();
  private final int port;

  private static class Response {
    private final int code;
    private final String body;

    Response(int code, String body) {
      this.code = code;
      this.body = body;
    }

    int code() {
      return code;
    }

    String body() {
      return body;
    }
  }

  private enum Error {
    ABORTED(409, "global", "aborted", "ABORTED"),
    ALREADY_EXISTS(409, "global", "alreadyExists", "ALREADY_EXISTS"),
    PERMISSION_DENIED(403, "global", "forbidden", "PERMISSION_DENIED"),
    FAILED_PRECONDITION(400, "global", "failedPrecondition", "FAILED_PRECONDITION"),
    INVALID_ARGUMENT(400, "global", "badRequest", "INVALID_ARGUMENT"),
    BAD_REQUEST(400, "global", "badRequest", "BAD_REQUEST"),
    INTERNAL_ERROR(500, "global", "internalError", "INTERNAL_ERROR");

    private final int code;
    private final String domain;
    private final String reason;
    private final String status;

    Error(int code, String domain, String reason, String status) {
      this.code = code;
      this.domain = domain;
      this.reason = reason;
      this.status = status;
    }

    Response response(String message) {
      try {
        return new Response(code, toJson(message));
      } catch (IOException e) {
        return Error.INTERNAL_ERROR.response("Error when generating JSON error response");
      }
    }

    private String toJson(String message) throws IOException {
      Map<String, Object> errors = new HashMap<>();
      errors.put("domain", domain);
      errors.put("message", message);
      errors.put("reason", reason);
      Map<String, Object> args = new HashMap<>();
      args.put("errors", ImmutableList.of(errors));
      args.put("code", code);
      args.put("message", message);
      args.put("status", status);
      return jsonFactory.toString(ImmutableMap.of("error", args));
    }
  }

  private class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) {
      // see https://cloud.google.com/resource-manager/reference/rest/
      Response response;
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String requestMethod = exchange.getRequestMethod();
      try {
        switch (requestMethod) {
          case "POST":
            response = handlePost(exchange, path);
            break;
          case "DELETE":
            response = delete(projectIdFromUri(path));
            break;
          case "GET":
            if (!path.isEmpty()) {
              response =
                  get(projectIdFromUri(path), parseFields(exchange.getRequestURI().getQuery()));
            } else {
              response = list(parseListOptions(exchange.getRequestURI().getQuery()));
            }
            break;
          case "PUT":
            String requestBody =
                decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
            response =
                replace(projectIdFromUri(path), jsonFactory.fromString(requestBody, Project.class));
            break;
          default:
            response =
                Error.BAD_REQUEST.response(
                    "The server could not understand the following request URI: "
                        + requestMethod
                        + " "
                        + path);
        }
      } catch (IOException e) {
        response = Error.BAD_REQUEST.response(e.getMessage());
      }
      writeResponse(exchange, response);
    }
  }

  private Response handlePost(HttpExchange exchange, String path) throws IOException {
    String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
    if (!path.contains(":")) {
      return create(jsonFactory.fromString(requestBody, Project.class));
    } else {
      switch (path.split(":", 2)[1]) {
        case "undelete":
          return undelete(projectIdFromUri(path));
        case "getIamPolicy":
          return getPolicy(projectIdFromUri(path));
        case "setIamPolicy":
          return replacePolicy(
              projectIdFromUri(path),
              jsonFactory.fromString(requestBody, SetIamPolicyRequest.class).getPolicy());
        case "testIamPermissions":
          return testPermissions(
              projectIdFromUri(path),
              jsonFactory
                  .fromString(requestBody, TestIamPermissionsRequest.class)
                  .getPermissions());
        default:
          return Error.BAD_REQUEST.response(
              "The server could not understand the following request URI: POST " + path);
      }
    }
  }

  private class OperationRequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) {
      // see https://cloud.google.com/resource-manager/reference/rest/
      String projectId;
      try {
        projectId = new URI(OPERATION_CONTEXT).relativize(exchange.getRequestURI()).getPath();
      } catch (URISyntaxException e) {
        throw new IllegalStateException(e);
      }
      Response response;
      String requestMethod = exchange.getRequestMethod();
      switch (requestMethod) {
        case "GET":
          Project project = projects.get(projectId);
          if (project == null) {
            response = Error.PERMISSION_DENIED.response("Project " + projectId + " not found.");
            break;
          }
          try {
            response =
                new Response(
                    HTTP_OK,
                    jsonFactory.toString(new Operation().setDone(true).setResponse(project)));
          } catch (IOException e) {
            response =
                Error.INTERNAL_ERROR.response(
                    "Error when serializing project " + project.getProjectId());
          }
          break;
        default:
          response =
              Error.BAD_REQUEST.response(
                  "The server could not understand the following request URI: "
                      + requestMethod
                      + " "
                      + projectId);
      }
      writeResponse(exchange, response);
    }
  }

  private static void writeResponse(HttpExchange exchange, Response response) {
    exchange.getResponseHeaders().set("Content-type", "application/json; charset=UTF-8");
    OutputStream outputStream = exchange.getResponseBody();
    try {
      exchange.getResponseHeaders().add("Connection", "close");
      exchange.sendResponseHeaders(response.code(), response.body().length());
      outputStream.write(response.body().getBytes(StandardCharsets.UTF_8));
      outputStream.close();
    } catch (IOException e) {
      log.log(Level.WARNING, "IOException encountered when sending response.", e);
    }
  }

  private static String decodeContent(Headers headers, InputStream inputStream) throws IOException {
    List<String> contentEncoding = headers.get("Content-encoding");
    InputStream input = inputStream;
    try {
      if (contentEncoding != null && !contentEncoding.isEmpty()) {
        String encoding = contentEncoding.get(0);
        if (SUPPORTED_COMPRESSION_ENCODINGS.contains(encoding)) {
          input = new GZIPInputStream(inputStream);
        } else if (!encoding.equals("identity")) {
          throw new IOException(
              "The request has the following unsupported HTTP content encoding: " + encoding);
        }
      }
      return new String(ByteStreams.toByteArray(input), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new IOException("Exception encountered when decoding request content.", e);
    }
  }

  private static String projectIdFromUri(String path) throws IOException {
    if (path.isEmpty()) {
      throw new IOException("The URI path '" + path + "' doesn't have a project ID.");
    }
    return path.split(":")[0];
  }

  private static String[] parseFields(String query) {
    if (query != null && !query.isEmpty()) {
      String[] querySplit = query.split("=");
      return querySplit.length > 1 ? querySplit[1].split(",") : null;
    }
    return null;
  }

  private static Map<String, Object> parseListOptions(String query) throws IOException {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            // List fields are in the form "projects(field1, field2, ...),nextPageToken"
            Matcher matcher = LIST_FIELDS_PATTERN.matcher(argEntry[1]);
            if (matcher.matches()) {
              options.put("projectFields", matcher.group(2).split(","));
              options.put("listFields", (matcher.group(1) + matcher.group(3)).split(","));
            } else {
              options.put("projectFields", NO_FIELDS);
              options.put("listFields", argEntry[1].split(","));
            }
            break;
          case "filter":
            options.put("filter", argEntry[1].split(" "));
            break;
          case "pageToken":
            options.put("pageToken", argEntry[1]);
            break;
          case "pageSize":
            int pageSize = Integer.parseInt(argEntry[1]);
            if (pageSize < 1) {
              throw new IOException("Page size must be greater than 0.");
            }
            options.put("pageSize", pageSize);
            break;
        }
      }
    }
    return options;
  }

  private static String checkForProjectErrors(Project project) {
    if (project.getProjectId() == null) {
      return "Project ID cannot be empty.";
    }
    if (!isValidIdOrLabel(project.getProjectId(), 6, 30)) {
      return "Project "
          + project.getProjectId()
          + " has an invalid ID."
          + " See https://cloud.google.com/resource-manager/reference/rest/"
          + VERSION
          + "/projects"
          + " for more information.";
    }
    if (project.getName() != null) {
      for (char c : project.getName().toCharArray()) {
        if (!PERMISSIBLE_PROJECT_NAME_PUNCTUATION.contains(c) && !Character.isLetterOrDigit(c)) {
          return "Project "
              + project.getProjectId()
              + " has an invalid name."
              + " See https://cloud.google.com/resource-manager/reference/rest/"
              + VERSION
              + "/projects for more information.";
        }
      }
    }
    if (project.getLabels() != null) {
      if (project.getLabels().size() > 256) {
        return "Project " + project.getProjectId() + " exceeds the limit of 256 labels.";
      }
      for (Map.Entry<String, String> entry : project.getLabels().entrySet()) {
        if (!isValidIdOrLabel(entry.getKey(), 1, 63)
            || !isValidIdOrLabel(entry.getValue(), 0, 63)) {
          return "Project "
              + project.getProjectId()
              + " has an invalid label entry."
              + " See https://cloud.google.com/resource-manager/reference/rest/"
              + VERSION
              + "/projects for more information.";
        }
      }
    }
    return null;
  }

  private static boolean isValidIdOrLabel(String value, int minLength, int maxLength) {
    for (char c : value.toCharArray()) {
      if (c != '-' && !Character.isDigit(c) && !Character.isLowerCase(c)) {
        return false;
      }
    }
    if (!value.isEmpty() && (!Character.isLetter(value.charAt(0)) || value.endsWith("-"))) {
      return false;
    }
    return value.length() >= minLength && value.length() <= maxLength;
  }

  synchronized Response create(Project project) {
    String customErrorMessage = checkForProjectErrors(project);
    if (customErrorMessage != null) {
      return Error.INVALID_ARGUMENT.response(customErrorMessage);
    } else {
      project.setLifecycleState("ACTIVE");
      project.setProjectNumber(Math.abs(PROJECT_NUMBER_GENERATOR.nextLong() % Long.MAX_VALUE));
      project.setCreateTime(
          DateTimeFormatter.ISO_DATE_TIME
              .withZone(ZoneOffset.UTC)
              .format(Instant.ofEpochMilli(System.currentTimeMillis())));
      if (projects.putIfAbsent(project.getProjectId(), project) != null) {
        return Error.ALREADY_EXISTS.response(
            "A project with the same project ID (" + project.getProjectId() + ") already exists.");
      }
      Policy emptyPolicy =
          new Policy()
              .setBindings(Collections.<Binding>emptyList())
              .setEtag(UUID.randomUUID().toString())
              .setVersion(0);
      policies.put(project.getProjectId(), emptyPolicy);
      try {
        // Pretend it's not done yet.
        String createdProjectStr =
            jsonFactory.toString(
                new Operation().setDone(false).setName("operations/" + project.getProjectId()));
        return new Response(HTTP_OK, createdProjectStr);
      } catch (IOException e) {
        return Error.INTERNAL_ERROR.response("Error serializing project " + project.getProjectId());
      }
    }
  }

  synchronized Response delete(String projectId) {
    Project project = projects.get(projectId);
    if (project == null) {
      return Error.PERMISSION_DENIED.response(
          "Error when deleting " + projectId + " because the project was not found.");
    }
    if (!project.getLifecycleState().equals("ACTIVE")) {
      return Error.FAILED_PRECONDITION.response(
          "Error when deleting " + projectId + " because the lifecycle state was not ACTIVE.");
    } else {
      project.setLifecycleState("DELETE_REQUESTED");
      return new Response(HTTP_OK, "{}");
    }
  }

  Response get(String projectId, String[] fields) {
    Project project = projects.get(projectId);
    if (project != null) {
      try {
        return new Response(HTTP_OK, jsonFactory.toString(extractFields(project, fields)));
      } catch (IOException e) {
        return Error.INTERNAL_ERROR.response(
            "Error when serializing project " + project.getProjectId());
      }
    } else {
      return Error.PERMISSION_DENIED.response("Project " + projectId + " not found.");
    }
  }

  Response list(Map<String, Object> options) {
    List<String> projectsSerialized = new ArrayList<>();
    String[] filters = (String[]) options.get("filter");
    if (filters != null && !isValidFilter(filters)) {
      return Error.INVALID_ARGUMENT.response("Could not parse the filter.");
    }
    String[] projectFields = (String[]) options.get("projectFields");
    int count = 0;
    String pageToken = (String) options.get("pageToken");
    Integer pageSize = (Integer) options.get("pageSize");
    String nextPageToken = null;
    Map<String, Project> projectsToScan = projects;
    if (pageToken != null) {
      projectsToScan = projects.tailMap(pageToken);
    }
    for (Project p : projectsToScan.values()) {
      if (pageSize != null && count >= pageSize) {
        nextPageToken = p.getProjectId();
        break;
      }
      boolean includeProject = includeProject(p, filters);
      if (includeProject) {
        count++;
        try {
          projectsSerialized.add(jsonFactory.toString(extractFields(p, projectFields)));
        } catch (IOException e) {
          return Error.INTERNAL_ERROR.response(
              "Error when serializing project " + p.getProjectId());
        }
      }
    }
    String[] listFields = (String[]) options.get("listFields");
    StringBuilder responseBody = new StringBuilder();
    responseBody.append('{');
    // If fields parameter is set but no project field is selected we must return no projects.
    if (!(projectFields != null && projectFields.length == 0)) {
      responseBody.append("\"projects\": [");
      Joiner.on(",").appendTo(responseBody, projectsSerialized);
      responseBody.append(']');
    }
    if (nextPageToken != null
        && (listFields == null || ImmutableSet.copyOf(listFields).contains("nextPageToken"))) {
      if (responseBody.length() > 1) {
        responseBody.append(',');
      }
      responseBody.append("\"nextPageToken\": \"");
      responseBody.append(nextPageToken);
      responseBody.append('"');
    }
    responseBody.append('}');
    return new Response(HTTP_OK, responseBody.toString());
  }

  private static boolean isValidFilter(String[] filters) {
    for (String filter : filters) {
      String field = filter.toLowerCase().split(":")[0];
      if (!("id".equals(field) || "name".equals(field) || field.startsWith("labels."))) {
        return false;
      }
    }
    return true;
  }

  private static boolean includeProject(Project project, String[] filters) {
    if (filters == null) {
      return true;
    }
    for (String filter : filters) {
      String[] filterEntry = filter.toLowerCase().split(":");
      String filterType = filterEntry[0];
      if ("id".equals(filterType)) {
        if (!satisfiesFilter(project.getProjectId(), filterEntry[1])) {
          return false;
        }
      } else if ("name".equals(filterType)) {
        if (!satisfiesFilter(project.getName(), filterEntry[1])) {
          return false;
        }
      } else if (filterType.startsWith("labels.")) {
        String labelKey = filterType.substring("labels.".length());
        if (project.getLabels() != null) {
          String labelValue = project.getLabels().get(labelKey);
          if (!satisfiesFilter(labelValue, filterEntry[1])) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean satisfiesFilter(String projectValue, String filterValue) {
    if (projectValue == null) {
      return false;
    }
    return "*".equals(filterValue) || filterValue.equals(projectValue.toLowerCase());
  }

  private static Project extractFields(Project fullProject, String[] fields) {
    if (fields == null) {
      return fullProject;
    }
    Project project = new Project();
    for (String field : fields) {
      switch (field) {
        case "createTime":
          project.setCreateTime(fullProject.getCreateTime());
          break;
        case "labels":
          project.setLabels(fullProject.getLabels());
          break;
        case "lifecycleState":
          project.setLifecycleState(fullProject.getLifecycleState());
          break;
        case "name":
          project.setName(fullProject.getName());
          break;
        case "parent":
          project.setParent(fullProject.getParent());
          break;
        case "projectId":
          project.setProjectId(fullProject.getProjectId());
          break;
        case "projectNumber":
          project.setProjectNumber(fullProject.getProjectNumber());
          break;
      }
    }
    return project;
  }

  synchronized Response replace(String projectId, Project project) {
    Project originalProject = projects.get(projectId);
    if (originalProject == null) {
      return Error.PERMISSION_DENIED.response(
          "Error when replacing " + projectId + " because the project was not found.");
    } else if (!originalProject.getLifecycleState().equals("ACTIVE")) {
      return Error.FAILED_PRECONDITION.response(
          "Error when replacing " + projectId + " because the lifecycle state was not ACTIVE.");
    } else if (!Objects.equal(originalProject.getParent(), project.getParent())) {
      return Error.INVALID_ARGUMENT.response(
          "The server currently only supports setting the parent once "
              + "and does not allow unsetting it.");
    }
    project.setProjectId(projectId);
    project.setLifecycleState(originalProject.getLifecycleState());
    project.setCreateTime(originalProject.getCreateTime());
    project.setProjectNumber(originalProject.getProjectNumber());
    // replace cannot fail because both this method and removeProject are synchronized
    projects.replace(projectId, project);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(project));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response("Error when serializing project " + projectId);
    }
  }

  synchronized Response undelete(String projectId) {
    Project project = projects.get(projectId);
    Response response;
    if (project == null) {
      response =
          Error.PERMISSION_DENIED.response(
              "Error when undeleting " + projectId + " because the project was not found.");
    } else if (!project.getLifecycleState().equals("DELETE_REQUESTED")) {
      response =
          Error.FAILED_PRECONDITION.response(
              "Error when undeleting "
                  + projectId
                  + " because the lifecycle state was not DELETE_REQUESTED.");
    } else {
      project.setLifecycleState("ACTIVE");
      response = new Response(HTTP_OK, "{}");
    }
    return response;
  }

  synchronized Response getPolicy(String projectId) {
    Policy policy = policies.get(projectId);
    if (policy == null) {
      return Error.PERMISSION_DENIED.response("Project " + projectId + " not found.");
    }
    try {
      return new Response(HTTP_OK, jsonFactory.toString(policy));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          "Error when serializing the IAM policy for " + projectId);
    }
  }

  synchronized Response replacePolicy(String projectId, Policy policy) {
    Policy originalPolicy = policies.get(projectId);
    if (originalPolicy == null) {
      return Error.PERMISSION_DENIED.response(
          "Error when replacing the policy for "
              + projectId
              + " because the project was not found.");
    }
    String etag = policy.getEtag();
    if (etag != null && !originalPolicy.getEtag().equals(etag)) {
      return Error.ABORTED.response(
          "Policy etag mismatch when replacing the policy for project "
              + projectId
              + ", please retry the read.");
    }
    policy.setEtag(UUID.randomUUID().toString());
    policy.setVersion(originalPolicy.getVersion());
    policies.put(projectId, policy);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(policy));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          "Error when serializing the policy for project " + projectId);
    }
  }

  synchronized Response testPermissions(String projectId, List<String> permissions) {
    if (!projects.containsKey(projectId)) {
      return Error.PERMISSION_DENIED.response("Project " + projectId + " not found.");
    }
    try {
      return new Response(
          HTTP_OK,
          jsonFactory.toString(new TestIamPermissionsResponse().setPermissions(permissions)));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response("Error when serializing permissions " + permissions);
    }
  }

  private LocalResourceManagerHelper() {
    try {
      server = HttpServer.create(new InetSocketAddress(0), 0);
      port = server.getAddress().getPort();
      server.createContext(CONTEXT, new RequestHandler());
      server.createContext(OPERATION_CONTEXT, new OperationRequestHandler());
    } catch (IOException e) {
      throw new RuntimeException("Could not bind the mock Resource Manager server.", e);
    }
  }

  /**
   * Creates a {@code LocalResourceManagerHelper} object that listens to requests on the local
   * machine.
   */
  public static LocalResourceManagerHelper create() {
    return new LocalResourceManagerHelper();
  }

  /**
   * Returns a {@link ResourceManagerOptions} instance that sets the host to use the mock server.
   */
  public ResourceManagerOptions getOptions() {
    return ResourceManagerOptions.newBuilder()
        .setHost("http://localhost:" + port)
        .setCredentials(NoCredentials.getInstance())
        .build();
  }

  /** Starts the thread that runs the Resource Manager server. */
  public void start() {
    server.start();
  }

  /** Stops the thread that runs the mock Resource Manager server. */
  public void stop() {
    server.stop(1);
  }

  /**
   * Utility method to change the lifecycle state of the specified project.
   *
   * @return true if the lifecycle state was successfully updated, false otherwise
   */
  public synchronized boolean changeLifecycleState(String projectId, String lifecycleState) {
    checkArgument(
        "ACTIVE".equals(lifecycleState)
            || "DELETE_REQUESTED".equals(lifecycleState)
            || "DELETE_IN_PROGRESS".equals(lifecycleState),
        "Lifecycle state must be ACTIVE, DELETE_REQUESTED, or DELETE_IN_PROGRESS");
    Project project = projects.get(checkNotNull(projectId));
    if (project != null) {
      project.setLifecycleState(lifecycleState);
      return true;
    }
    return false;
  }

  /**
   * Utility method to remove the specified project.
   *
   * <p>This method can be used to fully remove a project (to mimic when the server completely
   * deletes a project).
   *
   * @return true if the project was successfully deleted, false if the project didn't exist
   */
  public synchronized boolean removeProject(String projectId) {
    // Because this method is synchronized, any code that relies on non-atomic read/write operations
    // should not fail if that code is also synchronized.
    policies.remove(checkNotNull(projectId));
    return projects.remove(projectId) != null;
  }
}
