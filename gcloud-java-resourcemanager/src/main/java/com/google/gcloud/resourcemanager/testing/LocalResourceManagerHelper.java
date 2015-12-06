package com.google.gcloud.resourcemanager.testing;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.json.JsonFactory;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * Utility to create a local Resource Manager mock for testing.
 *
 * The mock runs in a separate thread, listening to port 8080 for HTTP requests.
 */
@SuppressWarnings("restriction")
public class LocalResourceManagerHelper {
  private static final Logger log = Logger.getLogger(LocalResourceManagerHelper.class.getName());
  private static final JsonFactory jsonFactory =
      new com.google.api.client.json.jackson.JacksonFactory();
  private static final int HTTP_STATUS_OK = 200;
  private static final Random PROJECT_NUMBER_GENERATOR = new Random();

  private HttpServer server;
  private final Map<String, Project> projects = new HashMap<>();

  static class Response {
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

  enum Error {
    ALREADY_EXISTS(
        409, "global", "Requested entity already exists.", "alreadyExists", "ALREADY_EXISTS"),
    PERMISSION_DENIED(
        403, "global", "The caller does not have permission.", "forbidden", "PERMISSION_DENIED"),
    FAILED_PRECONDITION( // change this error code to 412 when #440 is fixed
        400, "global", "Precondition check failed.", "failedPrecondition", "FAILED_PRECONDITION"),
    INVALID_ARGUMENT( // change this error code to 412 when #440 is fixed
        400, "global", "Request contains an invalid argument.", "badRequest",
        "INVALID_ARGUMENT");

    private final Response response;

    Error(int code, String domain, String message, String reason, String status) {
      this.response = new Response(code, toJson(code, domain, message, reason, status));
    }

    private static String toJson(
        int code, String domain, String message, String reason, String status) {
      Map<String, Object> args = new HashMap<>();
      Map<String, Object> nestedArgs = new HashMap<>();
      nestedArgs.put("domain", domain);
      nestedArgs.put("message", message);
      nestedArgs.put("reason", reason);
      List<Map<String, Object>> errors = ImmutableList.of(nestedArgs);
      args.put("errors", errors);
      args.put("code", code);
      args.put("message", message);
      args.put("status", status);
      try {
        return jsonFactory.toString(args);
      } catch (IOException e) {
        throw new RuntimeException("Error when generating JSON error response.");
      }
    }
  }

  private class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
      // see https://cloud.google.com/resource-manager/reference/rest/
      String path = exchange.getRequestURI().getPath();
      String requestMethod = exchange.getRequestMethod();
      Response response = null;
      if (requestMethod.equals("POST") && path.startsWith("/v1beta1/projects")) {
        if (path.contains("undelete")) {
          response = undelete(projectIdFromURI(path));
        } else {
          String requestBody =
              decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
          response = create(jsonFactory.fromString(requestBody, Project.class));
        }
      } else if (requestMethod.equals("DELETE")) {
        response = delete(projectIdFromURI(path));
      } else if (requestMethod.equals("GET") && path.startsWith("/v1beta1/projects/")) {
        response = get(projectIdFromURI(path), parseFields(exchange.getRequestURI().getQuery()));
      } else if (requestMethod.equals("GET")) {
        response = list(parseListOptions(exchange.getRequestURI().getQuery()));
      } else if (requestMethod.equals("PUT")) {
        String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
        response = replace(jsonFactory.fromString(requestBody, Project.class));
      }
      if (response == null) {
        throw new UnsupportedOperationException("Request not recognized.");
      }
      exchange.sendResponseHeaders(response.code(), response.body().length());
      OutputStream outputStream = exchange.getResponseBody();
      outputStream.write(response.body().getBytes());
      outputStream.close();
    }
  }

  private static String decodeContent(Headers headers, InputStream inputStream) throws IOException {
    List<String> contentEncoding = headers.get("Content-encoding");
    byte[] bytes;
    if (contentEncoding != null && contentEncoding.size() > 0
        && contentEncoding.get(0).contains("gzip")) {
      bytes = ByteStreams.toByteArray(new GZIPInputStream(inputStream));
      log.fine("Content-encoding is in gzip format. Decoded successfully.");
    } else {
      bytes = ByteStreams.toByteArray(inputStream);
    }
    return new String(bytes, StandardCharsets.UTF_8);
  }

  private static String projectIdFromURI(String path) {
    String[] pathSplit = path.split("/");
    if (pathSplit.length < 4) {
      throw new IllegalArgumentException("This path doesn't have a project ID");
    }
    return path.split("/")[3].split(":")[0];
  }

  private static String[] parseFields(String query) {
    return query != null ? query.split("=")[1].split(",") : null;
  }

  private static Map<String, Object> parseListOptions(String query) {
    Map<String, Object> options = new HashMap<>();
    if (query != null) {
      String[] args = query.split("&");
      for (String arg : args) {
        String[] argEntry = arg.split("=");
        switch (argEntry[0]) {
          case "fields":
            options.put("fields", argEntry[1].split(","));
            break;
          case "pageToken":
            // support pageToken when Cloud Resource Manager supports this (#421)
            break;
          case "pageSize":
            // support pageSize when Cloud Resource Manager supports this (#421)
            break;
        }
      }
    }
    return options;
  }

  Response create(Project project) throws IOException {
    project.setLifecycleState("ACTIVE");
    project.setProjectNumber(Math.abs(PROJECT_NUMBER_GENERATOR.nextLong()));
    project.setCreateTime(ISODateTimeFormat.dateTime().print(new Date().getTime()));
    Response response;
    if (projects.containsKey(checkNotNull(project.getProjectId()))) {
      response = Error.ALREADY_EXISTS.response;
      log.info(
          "A project with the same project ID (" + project.getProjectId() + ") already exists.");
    } else {
      projects.put(project.getProjectId(), project);
      String createdProjectStr = jsonFactory.toString(project);
      log.info("Created the following project: " + createdProjectStr);
      response = new Response(HTTP_STATUS_OK, createdProjectStr);
    }
    return response;
  }

  Response delete(String projectId) {
    Project project = projects.get(checkNotNull(projectId));
    Response response;
    if (project == null) {
      response = Error.PERMISSION_DENIED.response; // when possible, change this to 404 (#440)
      log.info("Error when deleting " + projectId + " because the project was not found.");
    } else if (!project.getLifecycleState().equals("ACTIVE")) {
      response = Error.FAILED_PRECONDITION.response;
      log.info("Error when deleting " + projectId + " because the lifecycle state was not ACTIVE.");
    } else {
      project.setLifecycleState("DELETE_REQUESTED");
      response = new Response(HTTP_STATUS_OK, "{}");
      log.info("Successfully requested delete for the following project: " + projectId);
    }
    return response;
  }

  Response get(String projectId, String[] fields) throws IOException {
    Response response;
    if (!projects.containsKey(checkNotNull(projectId))) {
      response = Error.PERMISSION_DENIED.response; // when possible, change this to 404 (#440)
      log.info("Project not found.");
    } else {
      response = new Response(
          HTTP_STATUS_OK, jsonFactory.toString(extractFields(projects.get(projectId), fields)));
    }
    return response;
  }

  Response list(Map<String, Object> options) throws IOException {
    // Use pageSize and pageToken options when Cloud Resource Manager does so (#421)
    List<String> projectsSerialized = new ArrayList<>();
    for (Project p : projects.values()) {
      projectsSerialized.add(
          jsonFactory.toString(extractFields(p, (String[]) options.get("fields"))));
    }
    StringBuilder responseBody = new StringBuilder();
    responseBody.append("{\"projects\": [");
    responseBody.append(Joiner.on(",").join(projectsSerialized));
    responseBody.append("]}");
    return new Response(HTTP_STATUS_OK, responseBody.toString());
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

  Response replace(Project project) throws IOException {
    Response response;
    Project oldProject = projects.get(checkNotNull(project.getProjectId()));
    if (oldProject == null) {
      response = Error.PERMISSION_DENIED.response; // when possible, change this to 404 (#440)
      log.info(
          "Error when replacing " + project.getProjectId() + " because the project was not found.");
    } else if (!oldProject.getLifecycleState().equals("ACTIVE")) {
      response = Error.FAILED_PRECONDITION.response;
      log.info("Error when replacing " + project.getProjectId()
          + " because the lifecycle state was not ACTIVE.");
    } else if (!Objects.equal(oldProject.getParent(), project.getParent())) {
      response = Error.INVALID_ARGUMENT.response;
      log.info("The server currently only supports setting the parent once "
          + "and does not allow unsetting it.");
    } else {
      project.setLifecycleState("ACTIVE");
      project.setProjectNumber(oldProject.getProjectNumber());
      project.setCreateTime(oldProject.getCreateTime());
      project.setParent(oldProject.getParent());
      projects.put(project.getProjectId(), project);
      String updatedProjectStr = jsonFactory.toString(project);
      log.info("Successfully updated the project to be: " + updatedProjectStr);
      response = new Response(HTTP_STATUS_OK, updatedProjectStr);
    }
    return response;
  }

  Response undelete(String projectId) {
    Project project = projects.get(checkNotNull(projectId));
    Response response;
    if (project == null) {
      response = Error.PERMISSION_DENIED.response; // when possible, change this to 404 (#440)
      log.info("Error when undeleting " + projectId + " because the project was not found.");
    } else if (!project.getLifecycleState().equals("DELETE_REQUESTED")) {
      response = Error.FAILED_PRECONDITION.response;
      log.info("Error when undeleting " + projectId
          + " because the lifecycle state was not DELETE_REQUESTED.");
    } else {
      project.setLifecycleState("ACTIVE");
      response = new Response(HTTP_STATUS_OK, "{}");
      log.info("Successfully undeleted " + projectId + ".");
    }
    return response;
  }

  private LocalResourceManagerHelper(int port) {
    try {
      this.server = HttpServer.create(new InetSocketAddress(port), 0);
      this.server.createContext("/", new RequestHandler());
    } catch (IOException e) {
      log.severe("Could not create the mock Resource Manager.");
    }
  }

  /**
   * Creates a LocalResourceManagerHelper object that listens to requests on the local machine at
   * the port specified.
   */
  public static LocalResourceManagerHelper create(int port) {
    return new LocalResourceManagerHelper(port);
  }

  /**
   * Returns an available port on the local machine.
   *
   * This port can be used to set the host in ResourceManagerOptions and to specify the port to
   * which the Resource Manager mock should listen.
   */
  public static int findAvailablePort(int defaultPort) {
    try (ServerSocket tempSocket = new ServerSocket(0)) {
      return tempSocket.getLocalPort();
    } catch (IOException e) {
      return defaultPort;
    }
  }

  /**
   * Starts the thread that runs the Resource Manager server.
   */
  public void start() {
    server.start();
  }

  /**
   * Stops the thread that runs the mock Resource Manager server.
   */
  public void stop() {
    server.stop(1);
  }

  /**
   * Utility method to add a project.
   *
   * Will not overwrite an existing project with the same ID.
   *
   * @return true if the project was successfully added, false otherwise
   */
  public boolean addProject(Project project) {
    if (projects.containsKey(checkNotNull(project.getProjectId()))) {
      return false;
    }
    projects.put(project.getProjectId(), clone(project));
    return true;
  }

  /**
   * Utility method to get a project.
   *
   * @return Project (if it exists) or null (if it doesn't exist)
   */
  public Project getProject(String projectId) {
    com.google.api.services.cloudresourcemanager.model.Project original = projects.get(projectId);
    return original != null ? clone(projects.get(projectId)) : null;
  }

  private static com.google.api.services.cloudresourcemanager.model.Project clone(
      com.google.api.services.cloudresourcemanager.model.Project original) {
    com.google.api.services.cloudresourcemanager.model.Project clone =
        new com.google.api.services.cloudresourcemanager.model.Project();
    clone.setProjectId(original.getProjectId());
    clone.setName(original.getName());
    clone.setLabels(original.getLabels());
    clone.setProjectNumber(original.getProjectNumber());
    clone.setCreateTime(original.getCreateTime());
    clone.setLifecycleState(original.getLifecycleState());
    clone.setParent(original.getParent());
    return clone;
  }

  /**
   * Utility method to remove the specified project.
   *
   * This method can be used to fully remove a project (to mimic when the server completely
   * deletes a project).
   *
   * @return true if the project was successfully deleted, false otherwise.
   */
  public boolean removeProject(String projectId) {
    if (projects.containsKey(projectId)) {
      projects.remove(checkNotNull(projectId));
      return true;
    }
    return false;
  }

  /**
   * Utility method to change the project number of a project.
   *
   * @return true if the project number was successfully changed, false otherwise.
   */
  public boolean changeProjectNumber(String projectId, long projectNumber) {
    com.google.api.services.cloudresourcemanager.model.Project project =
        projects.get(checkNotNull(projectId));
    if (project != null) {
      project.setProjectNumber(projectNumber);
      return true;
    }
    return false;
  }

  /**
   * Utility method to change the lifecycle state of the specified project.
   *
   * @return true if the lifecycle state was successfully updated, false otherwise.
   */
  public boolean changeLifecycleState(String projectId, String lifecycleState) {
    checkArgument(
        "ACTIVE".equals(lifecycleState) || "DELETE_REQUESTED".equals(lifecycleState)
        || "DELETE_IN_PROGRESS".equals(lifecycleState),
        "Lifecycle state must be ACTIVE, DELETE_REQUESTED, or DELETE_IN_PROGRESS");
    com.google.api.services.cloudresourcemanager.model.Project project =
        projects.get(checkNotNull(projectId));
    if (project != null) {
      project.setLifecycleState(lifecycleState);
      return true;
    }
    return false;
  }

  /**
   * Utility method to change the create time of a project.
   *
   * @return true if the project create time was successfully changed, false otherwise.
   */
  public boolean changeCreateTime(String projectId, String createTime) {
    com.google.api.services.cloudresourcemanager.model.Project project =
        projects.get(checkNotNull(projectId));
    if (project != null) {
      project.setCreateTime(createTime);
      return true;
    }
    return false;
  }

  /**
   * Utility method to clear all the projects.
   */
  public void clearProjects() {
    projects.clear();
  }
}
