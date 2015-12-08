package com.google.gcloud.resourcemanager.testing;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.json.JsonFactory;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
  private static final Random PROJECT_NUMBER_GENERATOR = new Random();

  // see https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects
  private static final Set<Character> PERMISSIBLE_PROJECT_NAME_PUNCTUATION =
      ImmutableSet.of('-', '\'', '"', ' ', '!');

  private HttpServer server;
  private final ConcurrentHashMap<String, Project> projects = new ConcurrentHashMap<>();

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
        return jsonFactory.toString(ImmutableMap.of("error", args));
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
      exchange.getResponseHeaders().set("Content-type", "application/json; charset=UTF-8");
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
          case "filter":
            options.put("filter", argEntry[1].split(" "));
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

  private static final boolean isValidProject(Project project) {
    if (project.getProjectId() == null) {
      log.info("Project ID cannot be empty.");
      return false;
    }
    if (!isValidIdOrLabel(project.getProjectId(), 6, 30)) {
      log.info("Project " + project.getProjectId() + " has an invalid ID."
          + " See https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects"
          + " for more information.");
      return false;
    }
    if (project.getName() != null) {
      for (char c : project.getName().toCharArray()) {
        if (!PERMISSIBLE_PROJECT_NAME_PUNCTUATION.contains(c) && !Character.isLetterOrDigit(c)) {
          log.info("Project " + project.getProjectId() + " has an invalid name."
              + " See https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects"
              + " for more information.");
          return false;
        }
      }
    }
    if (project.getLabels() != null) {
      if (project.getLabels().size() > 256) {
        log.info("Project " + project.getProjectId() + " exceeds the limit of 256 labels.");
        return false;
      }
      for (Map.Entry<String, String> entry : project.getLabels().entrySet()) {
        if (!isValidIdOrLabel(entry.getKey(), 1, 63)
            || !isValidIdOrLabel(entry.getValue(), 0, 63)) {
          log.info("Project " + project.getProjectId() + " has an invalid label entry."
              + " See https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects"
              + " for more information.");
          return false;
        }
      }
    }
    return true;
  }

  private static final boolean isValidIdOrLabel(String value, int minLength, int maxLength) {
    for (char c : value.toCharArray()) {
      if (c != '-' && !Character.isDigit(c)
          && (!Character.isLetter(c) || !Character.isLowerCase(c))) {
        return false;
      }
    }
    if (value.length() > 0 && (!Character.isLetter(value.charAt(0)) || value.endsWith("-"))) {
      return false;
    }
    return value.length() >= minLength && value.length() <= maxLength;
  }

  Response create(Project project) throws IOException {
    project.setLifecycleState("ACTIVE");
    project.setProjectNumber(Math.abs(PROJECT_NUMBER_GENERATOR.nextLong()));
    project.setCreateTime(ISODateTimeFormat.dateTime().print(new Date().getTime()));
    Response response;
    if (!isValidProject(project)) {
      response = Error.INVALID_ARGUMENT.response;
    } else if (projects.containsKey(project.getProjectId())) {
      response = Error.ALREADY_EXISTS.response;
      log.info(
          "A project with the same project ID (" + project.getProjectId() + ") already exists.");
    } else {
      projects.put(project.getProjectId(), project);
      String createdProjectStr = jsonFactory.toString(project);
      log.info("Created the following project: " + createdProjectStr);
      response = new Response(HttpURLConnection.HTTP_OK, createdProjectStr);
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
      response = new Response(HttpURLConnection.HTTP_OK, "{}");
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
          HttpURLConnection.HTTP_OK,
          jsonFactory.toString(extractFields(projects.get(projectId), fields)));
    }
    return response;
  }

  Response list(final Map<String, Object> options) {
    // Use pageSize and pageToken options when Cloud Resource Manager does so (#421)
    List<String> projectsSerialized = Lists.newArrayList(Iterables.filter(
        Iterables.transform(projects.values(), new Function<Project, String>() {
          @Override
          public String apply(Project p) {
            try {
              return includeProject(p, (String[]) options.get("filter"))
                  ? jsonFactory.toString(extractFields(p, (String[]) options.get("fields"))) : null;
            } catch (IOException e) {
              log.info("Error when serializing project " + p.getProjectId());
              return null;
            }
          }
        }),
        Predicates.notNull()));
    StringBuilder responseBody = new StringBuilder();
    responseBody.append("{\"projects\": [");
    responseBody.append(Joiner.on(",").join(projectsSerialized));
    responseBody.append("]}");
    return new Response(HttpURLConnection.HTTP_OK, responseBody.toString());
  }

  private static boolean includeProject(Project project, String[] filters) {
    if (filters == null) {
      return true;
    }
    for (String filter : filters) {
      String[] filterEntry = filter.toLowerCase().split(":");
      if ("id".equals(filterEntry[0])) {
        if (!satisfiesFilter(project.getProjectId(), filterEntry[1])) {
          return false;
        }
      } else if ("name".equals(filterEntry[0])) {
        if (!satisfiesFilter(project.getName(), filterEntry[1])) {
          return false;
        }
      } else if (filterEntry[0].startsWith("labels")) {
        String labelKey = filterEntry[0].split("\\.")[1];
        if (project.getLabels() != null) {
          String labelValue = project.getLabels().get(labelKey);
          if (!satisfiesFilter(labelValue, filterEntry[1])) {
            return false;
          }
        }
      } else {
        log.info("Could not parse the following filter: " + filter);
      }
    }
    return true;
  }

  private static boolean satisfiesFilter(String projectValue, String filterValue) {
    if (projectValue == null) {
      return false;
    }
    return "*".equals(filterValue) ? true : filterValue.equals(projectValue.toLowerCase());
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
    Project oldProject = projects.get(project.getProjectId());
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
      response = new Response(HttpURLConnection.HTTP_OK, updatedProjectStr);
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
      response = new Response(HttpURLConnection.HTTP_OK, "{}");
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
    if (isValidProject(project)) {
      return projects.putIfAbsent(project.getProjectId(), clone(project)) == null ? true : false;
    }
    return false;
  }

  /**
   * Utility method to get a project.
   *
   * @return Project (if it exists) or null (if it doesn't exist)
   */
  public Project getProject(String projectId) {
    Project original = projects.get(projectId);
    return original != null ? clone(projects.get(projectId)) : null;
  }

  private static Project clone(Project original) {
    return new Project()
        .setProjectId(original.getProjectId())
        .setName(original.getName())
        .setLabels(original.getLabels() != null ? ImmutableMap.copyOf(original.getLabels()) : null)
        .setProjectNumber(
            original.getProjectNumber() != null ? original.getProjectNumber().longValue() : null)
        .setCreateTime(original.getCreateTime())
        .setLifecycleState(original.getLifecycleState())
        .setParent(original.getParent() != null ? original.getParent().clone() : null);
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
    return projects.remove(checkNotNull(projectId)) != null ? true : false;
  }

  /**
   * Utility method to change the project number of a project.
   *
   * @return true if the project number was successfully changed, false otherwise.
   */
  public boolean changeProjectNumber(String projectId, long projectNumber) {
    Project project = projects.get(checkNotNull(projectId));
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
    Project project = projects.get(checkNotNull(projectId));
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
    Project project = projects.get(checkNotNull(projectId));
    if (project != null) {
      project.setCreateTime(checkNotNull(createTime));
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
