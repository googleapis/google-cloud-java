/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.dns.testing;

import static com.google.common.net.InetAddresses.isInetAddress;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.Quota;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.cloud.AuthCredentials;
import com.google.cloud.dns.DnsOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.apache.commons.fileupload.MultipartStream;
import org.joda.time.format.ISODateTimeFormat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * A local Google Cloud DNS mock.
 *
 * <p>The mock runs in a separate thread, listening for HTTP requests on the local machine at an
 * ephemeral port.
 *
 * <p>While the mock attempts to simulate the service, there are some differences in the behaviour.
 * The mock will accept any project ID and never returns a notFound or another error because of
 * project ID. It assumes that all project IDs exist and that the user has all the necessary
 * privileges to manipulate any project. Similarly, the local simulation does not require
 * verification of domain name ownership. Any request for creating a managed zone will be approved.
 * The mock does not track quota and will allow the user to exceed it. The mock provides only basic
 * validation of the DNS data for record sets of type A and AAAA. It does not validate any other
 * record set types.
 */
public class LocalDnsHelper {

  private final ConcurrentSkipListMap<String, ProjectContainer> projects
      = new ConcurrentSkipListMap<>();
  private static final URI BASE_CONTEXT;
  private static final Logger log = Logger.getLogger(LocalDnsHelper.class.getName());
  private static final JsonFactory jsonFactory = new JacksonFactory();
  private static final Random ID_GENERATOR = new Random();
  private static final String VERSION = "v1";
  private static final String CONTEXT = "/dns/" + VERSION + "/projects";
  private static final Set<String> ENCODINGS = ImmutableSet.of("gzip", "x-gzip");
  private static final List<String> TYPES = ImmutableList.of("A", "AAAA", "CNAME", "MX", "NAPTR",
      "NS", "PTR", "SOA", "SPF", "SRV", "TXT");
  private static final TreeSet<String> FORBIDDEN = Sets.newTreeSet(
      ImmutableList.of("google.com.", "com.", "example.com.", "net.", "org."));
  private static final Pattern ZONE_NAME_RE = Pattern.compile("[a-z][a-z0-9-]*");
  private static final ScheduledExecutorService EXECUTORS =
      Executors.newScheduledThreadPool(2, Executors.defaultThreadFactory());
  private static final String PROJECT_ID = "dummyprojectid";
  private static final String RESPONSE_BOUNDARY = "____THIS_IS_HELPERS_BOUNDARY____";
  private static final String RESPONSE_SEPARATOR = "--" + RESPONSE_BOUNDARY + "\r\n";
  private static final String RESPONSE_END = "--" + RESPONSE_BOUNDARY + "--\r\n\r\n";

  static {
    try {
      BASE_CONTEXT = new URI(CONTEXT);
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(
          "Could not initialize LocalDnsHelper due to URISyntaxException.", e);
    }
  }

  private final long delayChange;
  private final HttpServer server;
  private final int port;

  /**
   * For matching URLs to operations.
   */
  private enum CallRegex {
    CHANGE_CREATE("POST", CONTEXT + "/[^/]+/managedZones/[^/]+/changes"),
    CHANGE_GET("GET", CONTEXT + "/[^/]+/managedZones/[^/]+/changes/[^/]+"),
    CHANGE_LIST("GET", CONTEXT + "/[^/]+/managedZones/[^/]+/changes"),
    ZONE_CREATE("POST", CONTEXT + "/[^/]+/managedZones"),
    ZONE_DELETE("DELETE", CONTEXT + "/[^/]+/managedZones/[^/]+"),
    ZONE_GET("GET", CONTEXT + "/[^/]+/managedZones/[^/]+"),
    ZONE_LIST("GET", CONTEXT + "/[^/]+/managedZones"),
    PROJECT_GET("GET", CONTEXT + "/[^/]+"),
    RECORD_LIST("GET", CONTEXT + "/[^/]+/managedZones/[^/]+/rrsets"),
    BATCH("POST", "/batch");

    private final String method;
    private final String pathRegex;

    CallRegex(String method, String pathRegex) {
      this.pathRegex = pathRegex;
      this.method = method;
    }
  }

  /**
   * Associates a project with a collection of ManagedZones.
   */
  static class ProjectContainer {
    private final Project project;
    private final ConcurrentSkipListMap<String, ZoneContainer> zones =
        new ConcurrentSkipListMap<>();

    ProjectContainer(Project project) {
      this.project = project;
    }

    Project project() {
      return project;
    }

    ConcurrentSkipListMap<String, ZoneContainer> zones() {
      return zones;
    }
  }

  /**
   * Associates a zone with a collection of changes and dns records.
   */
  static class ZoneContainer {
    private final ManagedZone zone;
    private final AtomicReference<ImmutableSortedMap<String, ResourceRecordSet>>
        dnsRecords = new AtomicReference<>(ImmutableSortedMap.<String, ResourceRecordSet>of());
    private final ConcurrentLinkedQueue<Change> changes = new ConcurrentLinkedQueue<>();

    ZoneContainer(ManagedZone zone) {
      this.zone = zone;
      this.dnsRecords.set(ImmutableSortedMap.<String, ResourceRecordSet>of());
    }

    ManagedZone zone() {
      return zone;
    }

    AtomicReference<ImmutableSortedMap<String, ResourceRecordSet>> dnsRecords() {
      return dnsRecords;
    }

    ConcurrentLinkedQueue<Change> changes() {
      return changes;
    }

    Change findChange(String changeId) {
      for (Change current : changes) {
        if (changeId.equals(current.getId())) {
          return current;
        }
      }
      return null;
    }
  }

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

  private enum Error {
    REQUIRED(400, "global", "required", "REQUIRED"),
    INTERNAL_ERROR(500, "global", "internalError", "INTERNAL_ERROR"),
    BAD_REQUEST(400, "global", "badRequest", "BAD_REQUEST"),
    INVALID(400, "global", "invalid", "INVALID"),
    CONTAINER_NOT_EMPTY(400, "global", "containerNotEmpty", "CONTAINER_NOT_EMPTY"),
    NOT_AVAILABLE(400, "global", "managedZoneDnsNameNotAvailable", "NOT_AVAILABLE"),
    NOT_FOUND(404, "global", "notFound", "NOT_FOUND"),
    ALREADY_EXISTS(409, "global", "alreadyExists", "ALREADY_EXISTS"),
    CONDITION_NOT_MET(412, "global", "conditionNotMet", "CONDITION_NOT_MET"),
    INVALID_ZONE_APEX(400, "global", "invalidZoneApex", "INVALID_ZONE_APEX");

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
        return Error.INTERNAL_ERROR.response("Error when generating JSON error response.");
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

    private Response pickHandler(HttpExchange exchange, CallRegex regex) {
      URI relative = BASE_CONTEXT.relativize(exchange.getRequestURI());
      String path = relative.getPath();
      String[] tokens = path.split("/");
      String projectId = tokens.length > 0 ? tokens[0] : null;
      String zoneName = tokens.length > 2 ? tokens[2] : null;
      String changeId = tokens.length > 4 ? tokens[4] : null;
      String query = relative.getQuery();
      switch (regex) {
        case CHANGE_GET:
          return getChange(projectId, zoneName, changeId, query);
        case CHANGE_LIST:
          return listChanges(projectId, zoneName, query);
        case ZONE_GET:
          return getZone(projectId, zoneName, query);
        case ZONE_DELETE:
          return deleteZone(projectId, zoneName);
        case ZONE_LIST:
          return listZones(projectId, query);
        case PROJECT_GET:
          return getProject(projectId, query);
        case RECORD_LIST:
          return listDnsRecords(projectId, zoneName, query);
        case ZONE_CREATE:
          try {
            return handleZoneCreate(exchange, projectId, query);
          } catch (IOException ex) {
            return Error.BAD_REQUEST.response(ex.getMessage());
          }
        case CHANGE_CREATE:
          try {
            return handleChangeCreate(exchange, projectId, zoneName, query);
          } catch (IOException ex) {
            return Error.BAD_REQUEST.response(ex.getMessage());
          }
        case BATCH:
          try {
            return handleBatch(exchange);
          } catch (IOException | URISyntaxException ex) {
            return Error.BAD_REQUEST.response(ex.getMessage());
          }
        default:
          return Error.INTERNAL_ERROR.response("Operation without a handler.");
      }
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      String rawPath = exchange.getRequestURI().getRawPath();
      for (CallRegex regex : CallRegex.values()) {
        if (requestMethod.equals(regex.method) && rawPath.matches(regex.pathRegex)) {
          Response response = pickHandler(exchange, regex);
          if (response != null) {
            /* null response is returned by batch request, because it handles writing
               the response on its own */
            writeResponse(exchange, response);
          }
          return;
        }
      }
      writeResponse(exchange, Error.NOT_FOUND.response(String.format(
          "The url %s for %s method does not match any API call.",
          requestMethod, exchange.getRequestURI())));
    }

    private Response handleBatch(final HttpExchange exchange) throws IOException,
        URISyntaxException {
      String contentType = exchange.getRequestHeaders().getFirst("Content-type");
      if (contentType != null) {
        HttpMediaType httpMediaType = new HttpMediaType(contentType);
        String boundary = httpMediaType.getParameter("boundary");
        MultipartStream multipartStream =
            new MultipartStream(exchange.getRequestBody(), boundary.getBytes(), 1024, null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        boolean nextPart = multipartStream.skipPreamble();
        while (nextPart) {
          String line;
          String contentId = null;
          String headers = multipartStream.readHeaders();
          Scanner scanner = new Scanner(headers);
          while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.toLowerCase().startsWith("content-id")) {
              contentId = line.split(":")[1].trim();
            }
          }
          // TODO: remove and write directly to socket once api client provides a complete
          // location line (e.g. GET /aaa/bbb HTTP/1.0)
          // and uses a request path for location instead of a complete URL.
          ByteArrayOutputStream bouts = new ByteArrayOutputStream();
          multipartStream.readBodyData(bouts);
          byte[] contentBytes = bouts.toByteArray();
          int indexOfCr = -1;
          for (int i = 0; i < contentBytes.length; i++) {
            if (contentBytes[i] == '\r') {
              indexOfCr = i;
              break;
            }
          }
          Socket socket = new Socket("127.0.0.1", server.getAddress().getPort());
          OutputStream socketOutput = socket.getOutputStream();
          InputStream socketInput = socket.getInputStream();
          //multipartStream.readBodyData(socketOutput);
          if (indexOfCr < 0) {
            socketOutput.write(contentBytes);
          } else {
            String[] requestLine =
                new String(contentBytes, 0, indexOfCr, StandardCharsets.UTF_8).split(" ");
            socketOutput.write(requestLine[0].getBytes());
            socketOutput.write(' ');
            URI uri = new URI(requestLine[1]);
            socketOutput.write(uri.getRawPath().getBytes());
            if (uri.getRawQuery() != null) {
              socketOutput.write('?');
              socketOutput.write(uri.getRawQuery().getBytes());
            }
            if (uri.getRawFragment() != null) {
              socketOutput.write('#');
              socketOutput.write(uri.getRawFragment().getBytes());
            }
            socketOutput.write(" HTTP/1.0".getBytes());
            socketOutput.write(contentBytes, indexOfCr, contentBytes.length - indexOfCr);
          }
          socketOutput.flush();
          out.write(RESPONSE_SEPARATOR.getBytes());
          out.write("Content-Type: application/http\r\n".getBytes());
          out.write(("Content-ID: " + contentId + "\r\n\r\n").getBytes());
          int length;
          while ((length = socketInput.read(bytes)) != -1) {
            out.write(bytes, 0, length);
          }
          socket.close();
          nextPart = multipartStream.skipPreamble();
        }
        out.write(RESPONSE_END.getBytes());
        writeBatchResponse(exchange, out);
      } else {
        return Error.BAD_REQUEST.response("Content-type header was not provided for batch.");
      }
      return null;
    }

    /**
     * @throws IOException if the request cannot be parsed.
     */
    private Response handleChangeCreate(HttpExchange exchange, String projectId, String zoneName,
        String query) throws IOException {
      String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
      Change change;
      try {
        change = jsonFactory.fromString(requestBody, Change.class);
      } catch (IllegalArgumentException ex) {
        return Error.REQUIRED.response(
            "The 'entity.change' parameter is required but was missing.");
      }
      String[] fields = OptionParsers.parseGetOptions(query);
      return createChange(projectId, zoneName, change, fields);
    }

    /**
     * @throws IOException if the request cannot be parsed.
     */
    private Response handleZoneCreate(HttpExchange exchange, String projectId, String query)
        throws IOException {
      String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
      ManagedZone zone;
      try {
        zone = jsonFactory.fromString(requestBody, ManagedZone.class);
      } catch (IllegalArgumentException ex) {
        return Error.REQUIRED.response(
            "The 'entity.managedZone' parameter is required but was missing.");
      }
      String[] options = OptionParsers.parseGetOptions(query);
      return createZone(projectId, zone, options);
    }
  }

  private LocalDnsHelper(long delay) {
    this.delayChange = delay;
    try {
      server = HttpServer.create(new InetSocketAddress(0), 0);
      port = server.getAddress().getPort();
      server.setExecutor(Executors.newCachedThreadPool());
      server.createContext("/", new RequestHandler());
    } catch (IOException e) {
      throw new RuntimeException("Could not bind the mock DNS server.", e);
    }
  }

  /**
   * Accessor for testing purposes.
   */
  ConcurrentSkipListMap<String, ProjectContainer> projects() {
    return projects;
  }

  /**
   * Creates new {@code LocalDnsHelper} instance that listens to requests on the local machine. This
   * instance processes changes in separate thread. The parameter determines how long a thread
   * should wait before processing a change. If it is set to 0, the threading is turned off and the
   * mock will behave synchronously.
   *
   * @param delay delay for processing changes in ms or 0 for synchronous processing
   */
  public static LocalDnsHelper create(Long delay) {
    return new LocalDnsHelper(delay);
  }

  /**
   * Returns a {@link DnsOptions} instance that sets the host to use the mock server.
   */
  @Deprecated
  public DnsOptions options() {
    return getOptions();
  }

  /**
   * Returns a {@link DnsOptions} instance that sets the host to use the mock server.
   */
  public DnsOptions getOptions() {
    return DnsOptions.builder()
        .projectId(PROJECT_ID)
        .host("http://localhost:" + port)
        .authCredentials(AuthCredentials.noAuth())
        .build();
  }

  /**
   * Starts the thread that runs the local DNS server.
   */
  public void start() {
    server.start();
  }

  /**
   * Stops the thread that runs the mock DNS server.
   */
  public void stop() {
    server.stop(1);
  }

  private static void writeResponse(HttpExchange exchange, Response response) {
    exchange.getResponseHeaders().set("Content-type", "application/json; charset=UTF-8");
    OutputStream outputStream = exchange.getResponseBody();
    try {
      exchange.getResponseHeaders().add("Connection", "close");
      exchange.sendResponseHeaders(response.code(), response.body().length());
      if (response.code() != 204) {
        // the server automatically sends headers and closes output stream when 204 is returned
        outputStream.write(response.body().getBytes(StandardCharsets.UTF_8));
      }
      outputStream.close();
    } catch (IOException e) {
      log.log(Level.WARNING, "IOException encountered when sending response.", e);
    }
  }

  private static void writeBatchResponse(HttpExchange exchange, ByteArrayOutputStream output) {
    exchange.getResponseHeaders().set(
        "Content-type", "multipart/mixed; boundary=" + RESPONSE_BOUNDARY);
    try {
      exchange.getResponseHeaders().add("Connection", "close");
      exchange.sendResponseHeaders(200, output.toByteArray().length);
      OutputStream responseBody = exchange.getResponseBody();
      output.writeTo(responseBody);
      responseBody.close();
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
        if (ENCODINGS.contains(encoding)) {
          input = new GZIPInputStream(inputStream);
        } else if (!"identity".equals(encoding)) {
          throw new IOException(
              "The request has the following unsupported HTTP content encoding: " + encoding);
        }
      }
      return new String(ByteStreams.toByteArray(input), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new IOException("Exception encountered when decoding request content.", e);
    }
  }

  /**
   * Generates a JSON response.
   *
   * @param context managedZones | projects | rrsets | changes
   */
  @VisibleForTesting
  static Response toListResponse(List<String> serializedObjects, String context, String pageToken,
      boolean includePageToken) {
    StringBuilder responseBody = new StringBuilder();
    responseBody.append("{\"").append(context).append("\": [");
    Joiner.on(",").appendTo(responseBody, serializedObjects);
    responseBody.append(']');
    // add page token only if it exists and is asked for
    if (pageToken != null && includePageToken) {
      responseBody.append(",\"nextPageToken\": \"").append(pageToken).append('"');
    }
    responseBody.append('}');
    return new Response(HTTP_OK, responseBody.toString());
  }

  /**
   * Prepares record sets that are created by default for each zone.
   */
  private static ImmutableSortedMap<String, ResourceRecordSet> defaultRecords(ManagedZone zone) {
    ResourceRecordSet soa = new ResourceRecordSet();
    soa.setTtl(21600);
    soa.setName(zone.getDnsName());
    soa.setRrdatas(ImmutableList.of(
        // taken from the service
        "ns-cloud-c1.googledomains.com. cloud-dns-hostmaster.google.com. 0 21600 3600 1209600 312"
    ));
    soa.setType("SOA");
    ResourceRecordSet ns = new ResourceRecordSet();
    ns.setTtl(21600);
    ns.setName(zone.getDnsName());
    ns.setRrdatas(zone.getNameServers());
    ns.setType("NS");
    String nsId = getUniqueId(ImmutableSet.<String>of());
    String soaId = getUniqueId(ImmutableSet.of(nsId));
    return ImmutableSortedMap.of(nsId, ns, soaId, soa);
  }

  /**
   * Returns a list of four nameservers randomly chosen from the predefined set.
   */
  @VisibleForTesting
  static List<String> randomNameservers() {
    ArrayList<String> nameservers = Lists.newArrayList(
        "dns1.googlecloud.com", "dns2.googlecloud.com", "dns3.googlecloud.com",
        "dns4.googlecloud.com", "dns5.googlecloud.com", "dns6.googlecloud.com"
    );
    while (nameservers.size() != 4) {
      int index = ID_GENERATOR.nextInt(nameservers.size());
      nameservers.remove(index);
    }
    return nameservers;
  }

  /**
   * Returns a hex string id (used for a record set) unique within the set of ids.
   */
  @VisibleForTesting
  static String getUniqueId(Set<String> ids) {
    String id;
    do {
      id = Long.toHexString(System.currentTimeMillis())
          + Long.toHexString(Math.abs(ID_GENERATOR.nextLong()));
    } while (ids.contains(id));
    return id;
  }

  /**
   * Tests if a record set matches name and type (if provided). Used for filtering.
   */
  @VisibleForTesting
  static boolean matchesCriteria(ResourceRecordSet recordSet, String name, String type) {
    if (type != null && !recordSet.getType().equals(type)) {
      return false;
    }
    return name == null || recordSet.getName().equals(name);
  }

  /**
   * Returns a project container. Never returns {@code null} because we assume that all projects
   * exists.
   */
  private ProjectContainer findProject(String projectId) {
    ProjectContainer defaultProject = createProject(projectId);
    projects.putIfAbsent(projectId, defaultProject);
    return projects.get(projectId);
  }

  /**
   * Returns a zone container. Returns {@code null} if zone does not exist within project.
   */
  @VisibleForTesting
  ZoneContainer findZone(String projectId, String zoneName) {
    ProjectContainer projectContainer = findProject(projectId); // never null
    return projectContainer.zones().get(zoneName);
  }

  /**
   * Returns a change found by its id. Returns {@code null} if such a change does not exist.
   */
  @VisibleForTesting
  Change findChange(String projectId, String zoneName, String changeId) {
    ZoneContainer wrapper = findZone(projectId, zoneName);
    return wrapper == null ? null : wrapper.findChange(changeId);
  }

  /**
   * Returns a response to getChange service call.
   */
  @VisibleForTesting
  Response getChange(String projectId, String zoneName, String changeId, String query) {
    Change change = findChange(projectId, zoneName, changeId);
    if (change == null) {
      ZoneContainer zone = findZone(projectId, zoneName);
      if (zone == null) {
        return Error.NOT_FOUND.response(String.format(
            "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
      }
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.changeId' resource named '%s' does not exist.", changeId));
    }
    String[] fields = OptionParsers.parseGetOptions(query);
    Change result = OptionParsers.extractFields(change, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(String.format(
          "Error when serializing change %s in managed zone %s in project %s.",
          changeId, zoneName, projectId));
    }
  }

  /**
   * Returns a response to getZone service call.
   */
  @VisibleForTesting
  Response getZone(String projectId, String zoneName, String query) {
    ZoneContainer container = findZone(projectId, zoneName);
    if (container == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
    }
    String[] fields = OptionParsers.parseGetOptions(query);
    ManagedZone result = OptionParsers.extractFields(container.zone(), fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(String.format(
          "Error when serializing managed zone %s in project %s.", zoneName, projectId));
    }
  }

  /**
   * We assume that every project exists. If we do not have it in the collection yet, we just create
   * a new default project instance with default quota.
   */
  @VisibleForTesting
  Response getProject(String projectId, String query) {
    String[] fields = OptionParsers.parseGetOptions(query);
    Project project = findProject(projectId).project();  // creates project if needed
    Project result = OptionParsers.extractFields(project, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing project %s.", projectId));
    }
  }

  /**
   * Creates a project. It generates a project number randomly.
   */
  private ProjectContainer createProject(String projectId) {
    Quota quota = new Quota();
    quota.setManagedZones(10000);
    quota.setRrsetsPerManagedZone(10000);
    quota.setRrsetAdditionsPerChange(100);
    quota.setRrsetDeletionsPerChange(100);
    quota.setTotalRrdataSizePerChange(10000);
    quota.setResourceRecordsPerRrset(100);
    Project project = new Project();
    project.setId(projectId);
    project.setNumber(new BigInteger(String.valueOf(
        Math.abs(ID_GENERATOR.nextLong() % Long.MAX_VALUE))));
    project.setQuota(quota);
    return new ProjectContainer(project);
  }

  @VisibleForTesting
  Response deleteZone(String projectId, String zoneName) {
    ZoneContainer zone = findZone(projectId, zoneName);
    ImmutableSortedMap<String, ResourceRecordSet> rrsets = zone == null
        ? ImmutableSortedMap.<String, ResourceRecordSet>of() : zone.dnsRecords().get();
    ImmutableList<String> defaults = ImmutableList.of("NS", "SOA");
    for (ResourceRecordSet current : rrsets.values()) {
      if (!defaults.contains(current.getType())) {
        return Error.CONTAINER_NOT_EMPTY.response(String.format(
            "The resource named '%s' cannot be deleted because it is not empty", zoneName));
      }
    }
    ProjectContainer projectContainer = projects.get(projectId);
    ZoneContainer previous = projectContainer.zones.remove(zoneName);
    return previous == null
        ? Error.NOT_FOUND.response(String.format(
        "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName))
        : new Response(HTTP_NO_CONTENT, "{}");
  }

  /**
   * Creates new managed zone and stores it in the collection. Assumes that project exists.
   */
  @VisibleForTesting
  Response createZone(String projectId, ManagedZone zone, String... fields) {
    Response errorResponse = checkZone(zone);
    if (errorResponse != null) {
      return errorResponse;
    }
    ManagedZone completeZone = new ManagedZone();
    completeZone.setName(zone.getName());
    completeZone.setDnsName(zone.getDnsName());
    completeZone.setDescription(zone.getDescription());
    completeZone.setNameServerSet(zone.getNameServerSet());
    completeZone.setCreationTime(ISODateTimeFormat.dateTime().withZoneUTC()
        .print(System.currentTimeMillis()));
    completeZone.setId(BigInteger.valueOf(Math.abs(ID_GENERATOR.nextLong() % Long.MAX_VALUE)));
    completeZone.setNameServers(randomNameservers());
    ZoneContainer zoneContainer = new ZoneContainer(completeZone);
    ImmutableSortedMap<String, ResourceRecordSet> defaultsRecords = defaultRecords(completeZone);
    zoneContainer.dnsRecords().set(defaultsRecords);
    Change change = new Change();
    change.setAdditions(ImmutableList.copyOf(defaultsRecords.values()));
    change.setStatus("done");
    change.setId("0");
    change.setStartTime(ISODateTimeFormat.dateTime().withZoneUTC()
        .print(System.currentTimeMillis()));
    zoneContainer.changes().add(change);
    ProjectContainer projectContainer = findProject(projectId);
    ZoneContainer oldValue = projectContainer.zones().putIfAbsent(
        completeZone.getName(), zoneContainer);
    if (oldValue != null) {
      return Error.ALREADY_EXISTS.response(String.format(
          "The resource 'entity.managedZone' named '%s' already exists", completeZone.getName()));
    }
    ManagedZone result = OptionParsers.extractFields(completeZone, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing managed zone %s.", result.getName()));
    }
  }

  /**
   * Creates a new change, stores it, and if delayChange > 0, invokes processing in a new thread.
   */
  Response createChange(String projectId, String zoneName, Change change, String... fields) {
    ZoneContainer zoneContainer = findZone(projectId, zoneName);
    if (zoneContainer == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named %s does not exist.", zoneName));
    }
    Response response = checkChange(change, zoneContainer);
    if (response != null) {
      return response;
    }
    Change completeChange = new Change();
    if (change.getAdditions() != null) {
      completeChange.setAdditions(ImmutableList.copyOf(change.getAdditions()));
    }
    if (change.getDeletions() != null) {
      completeChange.setDeletions(ImmutableList.copyOf(change.getDeletions()));
    }
    /* We need to set ID for the change. We are working in concurrent environment. We know that the
    element fell on an index between 1 and maxId (index 0 is the default change which creates SOA
    and NS), so we will reset all IDs between 0 and maxId (all of them are valid for the respective
    objects). */
    ConcurrentLinkedQueue<Change> changeSequence = zoneContainer.changes();
    changeSequence.add(completeChange);
    int maxId = changeSequence.size();
    int index = 0;
    for (Change c : changeSequence) {
      if (index == maxId) {
        break;
      }
      c.setId(String.valueOf(index++));
    }
    completeChange.setStatus("pending");
    completeChange.setStartTime(ISODateTimeFormat.dateTime().withZoneUTC()
        .print(System.currentTimeMillis()));
    invokeChange(projectId, zoneName, completeChange.getId());
    Change result = OptionParsers.extractFields(completeChange, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing change %s in managed zone %s in project %s.",
              result.getId(), zoneName, projectId));
    }
  }

  /**
   * Applies change. Uses a different pooled thread which applies the change only if {@code
   * delayChange} is > 0.
   */
  private void invokeChange(final String projectId, final String zoneName,
      final String changeId) {
    if (delayChange > 0) {
      EXECUTORS.schedule(new Runnable() {
        @Override
        public void run() {
          applyExistingChange(projectId, zoneName, changeId);
        }
      }, delayChange, TimeUnit.MILLISECONDS);
    } else {
      applyExistingChange(projectId, zoneName, changeId);
    }
  }

  /**
   * Applies changes to a zone. Repeatedly tries until succeeds. Thread safe and deadlock safe.
   */
  private void applyExistingChange(String projectId, String zoneName, String changeId) {
    Change change = findChange(projectId, zoneName, changeId);
    if (change == null) {
      return; // no such change exists, nothing to do
    }
    ZoneContainer wrapper = findZone(projectId, zoneName);
    if (wrapper == null) {
      return; // no such zone exists; it might have been deleted by another thread
    }
    AtomicReference<ImmutableSortedMap<String, ResourceRecordSet>> dnsRecords =
        wrapper.dnsRecords();
    while (true) {
      // managed zone must have a set of records which is not null
      ImmutableSortedMap<String, ResourceRecordSet> original = dnsRecords.get();
      // the copy will be populated when handling deletions
      SortedMap<String, ResourceRecordSet> copy = new TreeMap<>();
      // apply deletions first
      List<ResourceRecordSet> deletions = change.getDeletions();
      if (deletions != null) {
        for (Map.Entry<String, ResourceRecordSet> entry : original.entrySet()) {
          if (!deletions.contains(entry.getValue())) {
            copy.put(entry.getKey(), entry.getValue());
          }
        }
      } else {
        copy.putAll(original);
      }
      // apply additions
      List<ResourceRecordSet> additions = change.getAdditions();
      if (additions != null) {
        for (ResourceRecordSet addition : additions) {
          ResourceRecordSet rrset = new ResourceRecordSet();
          rrset.setName(addition.getName());
          rrset.setRrdatas(ImmutableList.copyOf(addition.getRrdatas()));
          rrset.setTtl(addition.getTtl());
          rrset.setType(addition.getType());
          String id = getUniqueId(copy.keySet());
          copy.put(id, rrset);
        }
      }
      boolean success = dnsRecords.compareAndSet(original, ImmutableSortedMap.copyOf(copy));
      if (success) {
        break; // success if no other thread modified the value in the meantime
      }
    }
    change.setStatus("done");
  }

  /**
   * Lists zones. Next page token is the last listed zone name and is returned only of there is more
   * to list and if the user does not exclude nextPageToken from field options.
   */
  @VisibleForTesting
  Response listZones(String projectId, String query) {
    Map<String, Object> options = OptionParsers.parseListZonesOptions(query);
    Response response = checkListOptions(options);
    if (response != null) {
      return response;
    }
    ConcurrentSkipListMap<String, ZoneContainer> containers = findProject(projectId).zones();
    String[] fields = (String[]) options.get("fields");
    String dnsName = (String) options.get("dnsName");
    String pageToken = (String) options.get("pageToken");
    Integer maxResults = options.get("maxResults") == null
        ? null : Integer.valueOf((String) options.get("maxResults"));
    boolean sizeReached = false;
    boolean hasMorePages = false;
    LinkedList<String> serializedZones = new LinkedList<>();
    String lastZoneName = null;
    ConcurrentNavigableMap<String, ZoneContainer> fragment =
        pageToken != null ? containers.tailMap(pageToken, false) : containers;
    for (ZoneContainer zoneContainer : fragment.values()) {
      ManagedZone zone = zoneContainer.zone();
      if (dnsName == null || zone.getDnsName().equals(dnsName)) {
        if (sizeReached) {
          // we do not add this, just note that there would be more and there should be a token
          hasMorePages = true;
          break;
        } else {
          try {
            lastZoneName = zone.getName();
            serializedZones.addLast(jsonFactory.toString(
                OptionParsers.extractFields(zone, fields)));
          } catch (IOException e) {
            return Error.INTERNAL_ERROR.response(String.format(
                "Error when serializing managed zone %s in project %s", lastZoneName, projectId));
          }
        }
      }
      sizeReached = maxResults != null && maxResults.equals(serializedZones.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || Arrays.asList(fields).contains("nextPageToken"));
    return toListResponse(serializedZones, "managedZones", lastZoneName, includePageToken);
  }

  /**
   * Lists record sets for a zone. Next page token is the ID of the last record listed.
   */
  @VisibleForTesting
  Response listDnsRecords(String projectId, String zoneName, String query) {
    Map<String, Object> options = OptionParsers.parseListDnsRecordsOptions(query);
    Response response = checkListOptions(options);
    if (response != null) {
      return response;
    }
    ZoneContainer zoneContainer = findZone(projectId, zoneName);
    if (zoneContainer == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
    }
    ImmutableSortedMap<String, ResourceRecordSet> dnsRecords = zoneContainer.dnsRecords().get();
    String[] fields = (String[]) options.get("fields");
    String name = (String) options.get("name");
    String type = (String) options.get("type");
    String pageToken = (String) options.get("pageToken");
    ImmutableSortedMap<String, ResourceRecordSet> fragment =
        pageToken != null ? dnsRecords.tailMap(pageToken, false) : dnsRecords;
    Integer maxResults = options.get("maxResults") == null
        ? null : Integer.valueOf((String) options.get("maxResults"));
    boolean sizeReached = false;
    boolean hasMorePages = false;
    LinkedList<String> serializedRrsets = new LinkedList<>();
    String lastRecordId = null;
    for (String recordSetId : fragment.keySet()) {
      ResourceRecordSet recordSet = fragment.get(recordSetId);
      if (matchesCriteria(recordSet, name, type)) {
        if (sizeReached) {
          // we do not add this, just note that there would be more and there should be a token
          hasMorePages = true;
          break;
        } else {
          lastRecordId = recordSetId;
          try {
            serializedRrsets.addLast(jsonFactory.toString(
                OptionParsers.extractFields(recordSet, fields)));
          } catch (IOException e) {
            return Error.INTERNAL_ERROR.response(String.format(
                "Error when serializing resource record set in managed zone %s in project %s",
                zoneName, projectId));
          }
        }
      }
      sizeReached = maxResults != null && maxResults.equals(serializedRrsets.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || Arrays.asList(fields).contains("nextPageToken"));
    return toListResponse(serializedRrsets, "rrsets", lastRecordId, includePageToken);
  }

  /**
   * Lists changes. Next page token is the ID of the last change listed.
   */
  @VisibleForTesting
  Response listChanges(String projectId, String zoneName, String query) {
    Map<String, Object> options = OptionParsers.parseListChangesOptions(query);
    Response response = checkListOptions(options);
    if (response != null) {
      return response;
    }
    ZoneContainer zoneContainer = findZone(projectId, zoneName);
    if (zoneContainer == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named '%s' does not exist", zoneName));
    }
    // take a sorted snapshot of the current change list
    NavigableMap<Integer, Change> changes = new TreeMap<>();
    for (Change c : zoneContainer.changes()) {
      if (c.getId() != null) {
        changes.put(Integer.valueOf(c.getId()), c);
      }
    }
    String[] fields = (String[]) options.get("fields");
    String sortOrder = (String) options.get("sortOrder");
    String pageToken = (String) options.get("pageToken");
    Integer maxResults = options.get("maxResults") == null
        ? null : Integer.valueOf((String) options.get("maxResults"));
    // as the only supported field is change sequence, we are not reading sortBy
    NavigableSet<Integer> keys;
    if ("descending".equals(sortOrder)) {
      keys = changes.descendingKeySet();
    } else {
      keys = changes.navigableKeySet();
    }
    Integer from = null;
    try {
      from = Integer.valueOf(pageToken);
    } catch (NumberFormatException ex) {
      // ignore page token
    }
    keys = from != null ? keys.tailSet(from, false) : keys;
    NavigableMap<Integer, Change> fragment =
        from != null && changes.containsKey(from) ? changes.tailMap(from, false) : changes;
    boolean sizeReached = false;
    boolean hasMorePages = false;
    LinkedList<String> serializedResults = new LinkedList<>();
    String lastChangeId = null;
    for (Integer key : keys) {
      Change change = fragment.get(key);
      if (sizeReached) {
        // we do not add this, just note that there would be more and there should be a token
        hasMorePages = true;
        break;
      } else {
        lastChangeId = change.getId();
        try {
          serializedResults.addLast(jsonFactory.toString(
              OptionParsers.extractFields(change, fields)));
        } catch (IOException e) {
          return Error.INTERNAL_ERROR.response(String.format(
              "Error when serializing change %s in managed zone %s in project %s",
              lastChangeId, zoneName, projectId));
        }
      }
      sizeReached = maxResults != null && maxResults.equals(serializedResults.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || Arrays.asList(fields).contains("nextPageToken"));
    return toListResponse(serializedResults, "changes", lastChangeId, includePageToken);
  }

  /**
   * Validates a zone to be created.
   */
  private static Response checkZone(ManagedZone zone) {
    if (zone.getName() == null) {
      return Error.REQUIRED.response(
          "The 'entity.managedZone.name' parameter is required but was missing.");
    }
    if (zone.getDnsName() == null) {
      return Error.REQUIRED.response(
          "The 'entity.managedZone.dnsName' parameter is required but was missing.");
    }
    if (zone.getDescription() == null) {
      return Error.REQUIRED.response(
          "The 'entity.managedZone.description' parameter is required but was missing.");
    }
    try {
      int number = Integer.valueOf(zone.getName());
      return Error.INVALID.response(
          String.format("Invalid value for 'entity.managedZone.name': '%s'", number));
    } catch (NumberFormatException ex) {
      // expected
    }
    if (zone.getName().isEmpty() || zone.getName().length() > 32
        || !ZONE_NAME_RE.matcher(zone.getName()).matches()) {
      return Error.INVALID.response(
          String.format("Invalid value for 'entity.managedZone.name': '%s'", zone.getName()));
    }
    if (zone.getDnsName().isEmpty() || !zone.getDnsName().endsWith(".")) {
      return Error.INVALID.response(
          String.format("Invalid value for 'entity.managedZone.dnsName': '%s'", zone.getDnsName()));
    }
    if (FORBIDDEN.contains(zone.getDnsName())) {
      return Error.NOT_AVAILABLE.response(String.format(
          "The '%s' managed zone is not available to be created.", zone.getDnsName()));
    }
    return null;
  }

  /**
   * Validates a change to be created.
   */
  @VisibleForTesting
  static Response checkChange(Change change, ZoneContainer zone) {
    if ((change.getDeletions() == null || change.getDeletions().size() <= 0)
        && (change.getAdditions() == null || change.getAdditions().size() <= 0)) {
      return Error.REQUIRED.response("The 'entity.change' parameter is required but was missing.");
    }
    if (change.getAdditions() != null) {
      int counter = 0;
      for (ResourceRecordSet addition : change.getAdditions()) {
        Response response = checkRrset(addition, zone, counter, "additions");
        if (response != null) {
          return response;
        }
        counter++;
      }
    }
    if (change.getDeletions() != null) {
      int counter = 0;
      for (ResourceRecordSet deletion : change.getDeletions()) {
        Response response = checkRrset(deletion, zone, counter, "deletions");
        if (response != null) {
          return response;
        }
        counter++;
      }
    }
    return checkAdditionsDeletions(change.getAdditions(), change.getDeletions(), zone);
    // null if everything is ok
  }

  /**
   * Checks a rrset within a change.
   *
   * @param type [additions|deletions]
   * @param index the index or addition or deletion in the list
   * @param zone the zone that this change is applied to
   */
  @VisibleForTesting
  static Response checkRrset(ResourceRecordSet rrset, ZoneContainer zone, int index, String type) {
    if (rrset.getName() == null || !rrset.getName().endsWith(zone.zone().getDnsName())) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'entity.change.%s[%s].name': '%s'", type, index, rrset.getName()));
    }
    if (rrset.getType() == null || !TYPES.contains(rrset.getType())) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'entity.change.%s[%s].type': '%s'", type, index, rrset.getType()));
    }
    if (rrset.getTtl() != null && rrset.getTtl() != 0 && rrset.getTtl() < 0) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'entity.change.%s[%s].ttl': '%s'", type, index, rrset.getTtl()));
    }
    if (rrset.getRrdatas() == null || rrset.isEmpty()) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'entity.change.%s[%s].rrdata': '%s'", type, index, "<empty>"));
    }
    int counter = 0;
    for (String record : rrset.getRrdatas()) {
      if (!checkRrData(record, rrset.getType())) {
        return Error.INVALID.response(String.format(
            "Invalid value for 'entity.change.%s[%s].rrdata[%s]': '%s'",
            type, index, counter, record));
      }
      counter++;
    }
    if ("deletions".equals(type)) {
      // check that deletion has a match by name and type
      boolean found = false;
      for (ResourceRecordSet wrappedRrset : zone.dnsRecords().get().values()) {
        if (rrset.getName().equals(wrappedRrset.getName())
            && rrset.getType().equals(wrappedRrset.getType())) {
          found = true;
          break;
        }
      }
      if (!found) {
        return Error.NOT_FOUND.response(String.format(
            "The 'entity.change.deletions[%s]' resource named '%s (%s)' does not exist.",
            index, rrset.getName(), rrset.getType()));
      }
      // if found, we still need an exact match
      if ("deletions".equals(type)
          && !zone.dnsRecords().get().containsValue(rrset)) {
        // such a record does not exist
        return Error.CONDITION_NOT_MET.response(String.format(
            "Precondition not met for 'entity.change.deletions[%s]", index));
      }
    }
    return null;
  }

  /**
   * Checks against duplicate additions (for each record set to be added that already exists, we
   * must have a matching deletion. Furthermore, check that mandatory SOA and NS records stay.
   */
  static Response checkAdditionsDeletions(List<ResourceRecordSet> additions,
      List<ResourceRecordSet> deletions, ZoneContainer zone) {
    if (additions != null) {
      int index = 0;
      for (ResourceRecordSet rrset : additions) {
        for (ResourceRecordSet wrappedRrset : zone.dnsRecords().get().values()) {
          if (rrset.getName().equals(wrappedRrset.getName())
              && rrset.getType().equals(wrappedRrset.getType())
              // such a record set exists and we must have a deletion
              && (deletions == null || !deletions.contains(wrappedRrset))) {
            return Error.ALREADY_EXISTS.response(String.format(
                "The 'entity.change.additions[%s]' resource named '%s (%s)' already exists.",
                index, rrset.getName(), rrset.getType()));
          }
        }
        if (rrset.getType().equals("SOA") && findByNameAndType(deletions, null, "SOA") == null) {
          return Error.INVALID_ZONE_APEX.response(String.format("The resource record set 'entity"
              + ".change.additions[%s]' is invalid because a zone must contain exactly one resource"
              + " record set of type 'SOA' at the apex.", index));
        }
        if (rrset.getType().equals("NS") && findByNameAndType(deletions, null, "NS") == null) {
          return Error.INVALID_ZONE_APEX.response(String.format("The resource record set 'entity"
              + ".change.additions[%s]' is invalid because a zone must contain exactly one resource"
              + " record set of type 'NS' at the apex.", index));
        }
        index++;
      }
    }
    if (deletions != null) {
      int index = 0;
      for (ResourceRecordSet rrset : deletions) {
        if (rrset.getType().equals("SOA") && findByNameAndType(additions, null, "SOA") == null) {
          return Error.INVALID_ZONE_APEX.response(String.format("The resource record set 'entity"
              + ".change.deletions[%s]' is invalid because a zone must contain exactly one resource"
              + " record set of type 'SOA' at the apex.", index));
        }
        if (rrset.getType().equals("NS") && findByNameAndType(additions, null, "NS") == null) {
          return Error.INVALID_ZONE_APEX.response(String.format("The resource record set 'entity"
              + ".change.deletions[%s]' is invalid because a zone must contain exactly one resource"
              + " record set of type 'NS' at the apex.", index));
        }
        index++;
      }
    }
    return null;
  }

  /**
   * Helper for searching rrsets in a collection.
   */
  private static ResourceRecordSet findByNameAndType(Iterable<ResourceRecordSet> recordSets,
      String name, String type) {
    if (recordSets != null) {
      for (ResourceRecordSet rrset : recordSets) {
        if ((name == null || name.equals(rrset.getName()))
            && (type == null || type.equals(rrset.getType()))) {
          return rrset;
        }
      }
    }
    return null;
  }

  /**
   * We only provide the most basic validation for A and AAAA record sets.
   */
  static boolean checkRrData(String data, String type) {
    switch (type) {
      case "A":
        return !data.contains(":") && isInetAddress(data);
      case "AAAA":
        return data.contains(":") && isInetAddress(data);
      default:
        return true;
    }
  }

  /**
   * Check supplied listing options.
   */
  @VisibleForTesting
  static Response checkListOptions(Map<String, Object> options) {
    // for general listing
    String maxResultsString = (String) options.get("maxResults");
    if (maxResultsString != null) {
      Integer maxResults;
      try {
        maxResults = Integer.valueOf(maxResultsString);
      } catch (NumberFormatException ex) {
        return Error.INVALID.response(String.format(
            "Invalid integer value': '%s'.", maxResultsString));
      }
      if (maxResults <= 0) {
        return Error.INVALID.response(String.format(
            "Invalid value for 'parameters.maxResults': '%s'", maxResults));
      }
    }
    String dnsName = (String) options.get("dnsName");
    if (dnsName != null && !dnsName.endsWith(".")) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'parameters.dnsName': '%s'", dnsName));
    }
    // for listing record sets, name must be fully qualified
    String name = (String) options.get("name");
    if (name != null && !name.endsWith(".")) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'parameters.name': '%s'", name));
    }
    String type = (String) options.get("type"); // must be provided with name
    if (type != null) {
      if (name == null) {
        return Error.INVALID.response("Invalid value for 'parameters.name': '' "
            + "(name must be specified if type is specified)");
      }
      if (!TYPES.contains(type)) {
        return Error.INVALID.response(String.format(
            "Invalid value for 'parameters.type': '%s'", type));
      }
    }
    // for listing changes
    String order = (String) options.get("sortOrder");
    if (order != null && !"ascending".equals(order) && !"descending".equals(order)) {
      return Error.INVALID.response(String.format(
          "Invalid value for 'parameters.sortOrder': '%s'", order));
    }
    String sortBy = (String) options.get("sortBy"); // case insensitive
    if (sortBy != null && !"changesequence".equals(sortBy.toLowerCase())) {
      return Error.INVALID.response(String.format(
          "Invalid string value: '%s'. Allowed values: [changesequence]", sortBy));
    }
    return null;
  }
}
