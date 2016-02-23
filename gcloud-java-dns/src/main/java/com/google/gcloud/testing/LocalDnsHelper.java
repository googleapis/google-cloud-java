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

package com.google.gcloud.testing;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.Quota;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;
import com.google.gcloud.dns.DnsOptions;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import javax.annotation.Nullable;

/**
 * A utility to create local Google Cloud DNS mock.
 *
 * <p>The mock runs in a separate thread, listening for HTTP requests on the local machine at an
 * ephemeral port.
 *
 * <p>While the mock attempts to simulate the service, there are some differences in the behaviour.
 * The mock will accept any project ID and never returns a notFound or another error because of
 * project ID. It assumes that all project IDs exist and that the user has all the necessary
 * privileges to manipulate any project. Similarly, the local simulation does not work with any
 * verification of domain name ownership. Any request for creating a managed zone will be approved.
 * The mock does not track quota and will allow the user to exceed it. The mock provides only basic
 * validation of the DNS data for records of type A and AAAA. It does not validate any other record
 * types.
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
  private static final Set<String> SUPPORTED_COMPRESSION_ENCODINGS =
      ImmutableSet.of("gzip", "x-gzip");
  private static final List<String> TYPES = ImmutableList.of("A", "AAAA", "CNAME", "MX", "NAPTR",
      "NS", "PTR", "SOA", "SPF", "SRV", "TXT");

  static {
    try {
      BASE_CONTEXT = new URI(CONTEXT);
    } catch (URISyntaxException e) {
      throw new RuntimeException(
          "Could not initialize LocalDnsHelper due to URISyntaxException.", e);
    }
  }

  private long delayChange;
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
    RECORD_LIST("GET", CONTEXT + "/[^/]+/managedZones/[^/]+/rrsets");

    private String method;
    private String pathRegex;

    CallRegex(String method, String pathRegex) {
      this.pathRegex = pathRegex;
      this.method = method;
    }
  }

  /**
   * Wraps DNS data by adding a timestamp and id which is used for paging and listing.
   */
  static class RrsetWrapper {
    static final Function<ResourceRecordSet, RrsetWrapper> WRAP_FUNCTION =
        new Function<ResourceRecordSet, RrsetWrapper>() {
          @Nullable
          @Override
          public RrsetWrapper apply(@Nullable ResourceRecordSet input) {
            return new RrsetWrapper(input);
          }
        };
    private final ResourceRecordSet rrset;
    private final Long timestamp = System.currentTimeMillis();
    private String id;

    RrsetWrapper(ResourceRecordSet rrset) {
      // The constructor creates a copy in order to prevent side effects.
      this.rrset = new ResourceRecordSet();
      this.rrset.setName(rrset.getName());
      this.rrset.setTtl(rrset.getTtl());
      this.rrset.setRrdatas(ImmutableList.copyOf(rrset.getRrdatas()));
      this.rrset.setType(rrset.getType());
    }

    void setId(String id) {
      this.id = id;
    }

    String id() {
      return id;
    }

    /**
     * Equals does not care about the listing id and timestamp metadata, just the rrset.
     */
    @Override
    public boolean equals(Object other) {
      return (other instanceof RrsetWrapper) && Objects.equals(rrset, ((RrsetWrapper) other).rrset);
    }

    @Override
    public int hashCode() {
      return Objects.hash(rrset);
    }

    ResourceRecordSet rrset() {
      return rrset;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("rrset", rrset)
          .add("timestamp", timestamp)
          .add("id", id)
          .toString();
    }
  }

  /**
   * Associates a project with a collection of ManagedZones. Thread safe.
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
   * Associates a zone with a collection of changes and dns records. Thread safe.
   */
  static class ZoneContainer {
    private final ManagedZone zone;
    /**
     * DNS records are held in a map to allow for atomic replacement of record sets when applying
     * changes. The key for the map is always the zone name. The collection of records is immutable
     * and must always exist, i.e., dnsRecords.get(zone.getName()) is never {@code null}.
     */
    private final ConcurrentSkipListMap<String, ImmutableList<RrsetWrapper>>
        dnsRecords = new ConcurrentSkipListMap<>();
    private final ConcurrentLinkedQueue<Change> changes = new ConcurrentLinkedQueue<>();

    ZoneContainer(ManagedZone zone) {
      this.zone = zone;
      this.dnsRecords.put(zone.getName(), ImmutableList.<RrsetWrapper>of());
    }

    ManagedZone zone() {
      return zone;
    }

    ConcurrentSkipListMap<String, ImmutableList<RrsetWrapper>> dnsRecords() {
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

    /**
     * Chooses the proper handler for a request.
     */
    private Response pickHandler(HttpExchange exchange, CallRegex regex) {
      switch (regex) {
        case CHANGE_GET:
          return handleChangeGet(exchange);
        case CHANGE_LIST:
          return handleChangeList(exchange);
        case ZONE_GET:
          return handleZoneGet(exchange);
        case ZONE_DELETE:
          return handleZoneDelete(exchange);
        case ZONE_LIST:
          return handleZoneList(exchange);
        case PROJECT_GET:
          return handleProjectGet(exchange);
        case RECORD_LIST:
          return handleDnsRecordList(exchange);
        case ZONE_CREATE:
          try {
            return handleZoneCreate(exchange);
          } catch (IOException ex) {
            return Error.BAD_REQUEST.response(ex.getMessage());
          }
        case CHANGE_CREATE:
          try {
            return handleChangeCreate(exchange);
          } catch (IOException ex) {
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
          // there is a match, pass the handling accordingly
          Response response = pickHandler(exchange, regex);
          writeResponse(exchange, response);
          return; // only one match is possible
        }
      }
      // could not be matched, the service returns 404 page not found here
      writeResponse(exchange, Error.NOT_FOUND.response("The url does not match any API call."));
    }

    private Response handleZoneDelete(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      return deleteZone(projectId, zoneName);
    }

    private Response handleZoneGet(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      String[] fields = OptionParsersAndExtractors.parseGetOptions(query);
      return getZone(projectId, zoneName, fields);
    }

    private Response handleZoneList(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      Map<String, Object> options = OptionParsersAndExtractors.parseListZonesOptions(query);
      return listZones(projectId, options);
    }

    private Response handleProjectGet(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      String[] fields = OptionParsersAndExtractors.parseGetOptions(query);
      return getProject(projectId, fields);
    }

    /**
     * @throws IOException if the request cannot be parsed.
     */
    private Response handleChangeCreate(HttpExchange exchange) throws IOException {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      String[] fields = OptionParsersAndExtractors.parseGetOptions(query);
      String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
      Change change = jsonFactory.fromString(requestBody, Change.class);
      return createChange(projectId, zoneName, change, fields);
    }

    private Response handleChangeGet(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      String changeId = tokens[4];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      String[] fields = OptionParsersAndExtractors.parseGetOptions(query);
      return getChange(projectId, zoneName, changeId, fields);
    }

    private Response handleChangeList(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      Map<String, Object> options = OptionParsersAndExtractors.parseListChangesOptions(query);
      return listChanges(projectId, zoneName, options);
    }

    private Response handleDnsRecordList(HttpExchange exchange) {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String zoneName = tokens[2];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      Map<String, Object> options = OptionParsersAndExtractors.parseListDnsRecordsOptions(query);
      return listDnsRecords(projectId, zoneName, options);
    }

    /**
     * @throws IOException if the request cannot be parsed.
     */
    private Response handleZoneCreate(HttpExchange exchange) throws IOException {
      String path = BASE_CONTEXT.relativize(exchange.getRequestURI()).getPath();
      String[] tokens = path.split("/");
      String projectId = tokens[0];
      String query = BASE_CONTEXT.relativize(exchange.getRequestURI()).getQuery();
      String[] options = OptionParsersAndExtractors.parseGetOptions(query);
      String requestBody = decodeContent(exchange.getRequestHeaders(), exchange.getRequestBody());
      ManagedZone zone;
      try {
        // IllegalArgumentException if the request body is an empty string
        zone = jsonFactory.fromString(requestBody, ManagedZone.class);
      } catch (IllegalArgumentException ex) {
        return Error.REQUIRED.response(
            "The 'entity.managedZone' parameter is required but was missing.");
      }
      return createZone(projectId, zone, options);
    }
  }

  private LocalDnsHelper(long delay) {
    this.delayChange = delay; // 0 makes this synchronous
    try {
      server = HttpServer.create(new InetSocketAddress(0), 0);
      port = server.getAddress().getPort();
      server.createContext(CONTEXT, new RequestHandler());
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
   * Creates new {@link LocalDnsHelper} instance that listens to requests on the local machine. This
   * instance processes changes separate threads. The parameter determines how long a thread should
   * wait before processing a change. If it is set to 0, the threading is turned off and the mock
   * will behave synchronously.
   *
   * @param delay delay for processing changes in ms or 0 for synchronous processing
   */
  public static LocalDnsHelper create(Long delay) {
    return new LocalDnsHelper(delay);
  }

  /**
   * Returns a DnsOptions instance that sets the host to use the mock server.
   */
  public DnsOptions options() {
    return DnsOptions.builder().host("http://localhost:" + port).build();
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
        outputStream.write(response.body().getBytes(StandardCharsets.UTF_8));
      }
      outputStream.close();
    } catch (IOException e) {
      log.log(Level.WARNING, "IOException encountered when sending response.", e);
    }
  }

  /**
   * Decodes content of the HttpRequest.
   */
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

  /**
   * Generates a JSON response.
   *
   * @param context managedZones | projects | rrsets | changes
   */
  static Response toListResponse(List<String> serializedObjects, String context, String pageToken,
      boolean includePageToken) {
    // start building response
    StringBuilder responseBody = new StringBuilder();
    responseBody.append("{\"").append(context).append("\": [");
    Joiner.on(",").appendTo(responseBody, serializedObjects);
    responseBody.append("]");
    // add page token only if exists and is asked for
    if (pageToken != null && includePageToken) {
      responseBody.append(",\"nextPageToken\": \"").append(pageToken).append("\"");
    }
    responseBody.append("}");
    return new Response(HTTP_OK, responseBody.toString());
  }

  /**
   * Prepares DNS records that are created by default for each zone.
   */
  private static ImmutableList<RrsetWrapper> defaultRecords(ManagedZone zone) {
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
    RrsetWrapper nsWrapper = new RrsetWrapper(ns);
    RrsetWrapper soaWrapper = new RrsetWrapper(soa);
    ImmutableList<RrsetWrapper> results = ImmutableList.of(nsWrapper, soaWrapper);
    nsWrapper.setId(getUniqueId(results));
    soaWrapper.setId(getUniqueId(results));
    return results;
  }

  /**
   * Returns a list of four nameservers randomly chosen from the predefined set.
   */
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
   * Returns a hex string id (used for a dns record) unique within the set of wrappers.
   */
  static String getUniqueId(List<RrsetWrapper> wrappers) {
    TreeSet<String> ids = Sets.newTreeSet(Lists.transform(wrappers,
        new Function<RrsetWrapper, String>() {
          @Override
          public String apply(RrsetWrapper input) {
            return input.id() == null ? "null" : input.id();
          }
        }));
    String id;
    do {
      id = Long.toHexString(System.currentTimeMillis())
          + Long.toHexString(Math.abs(ID_GENERATOR.nextLong()));
      if (!ids.contains(id)) {
        return id;
      }
    } while (ids.contains(id));
    return id;
  }

  /**
   * Tests if a DNS record matches name and type (if provided). Used for filtering.
   */
  static boolean matchesCriteria(ResourceRecordSet record, String name, String type) {
    if (type != null && !record.getType().equals(type)) {
      return false;
    }
    if (name != null && !record.getName().equals(name)) {
      return false;
    }
    return true;
  }

  /**
   * Returns a project container. Never returns {@code null} because we assume that all projects
   * exists.
   */
  ProjectContainer findProject(String projectId) {
    ProjectContainer defaultProject = createProject(projectId);
    projects.putIfAbsent(projectId, defaultProject);
    return projects.get(projectId);
  }

  /**
   * Returns a zone container. Returns {@code null} if zone does not exist within project.
   */
  ZoneContainer findZone(String projectId, String zoneName) {
    ProjectContainer projectContainer = findProject(projectId); // never null
    return projectContainer.zones().get(zoneName);
  }

  /**
   * Returns a change found by its id. Returns {@code null} if such a change does not exist.
   */
  Change findChange(String projectId, String zoneName, String changeId) {
    ZoneContainer wrapper = findZone(projectId, zoneName);
    return wrapper == null ? null : wrapper.findChange(changeId);
  }

  /**
   * Returns a response to getChange service call.
   */
  Response getChange(String projectId, String zoneName, String changeId, String[] fields) {
    Change change = findChange(projectId, zoneName, changeId);
    if (change == null) {
      ZoneContainer zone = findZone(projectId, zoneName);
      if (zone == null) {
        // zone does not exist
        return Error.NOT_FOUND.response(String.format(
            "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
      }
      // zone exists but change does not
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.changeId' resource named '%s' does not exist.", changeId));
    }
    Change result = OptionParsersAndExtractors.extractFields(change, fields);
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
  Response getZone(String projectId, String zoneName, String[] fields) {
    ZoneContainer container = findZone(projectId, zoneName);
    if (container == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
    }
    ManagedZone result = OptionParsersAndExtractors.extractFields(container.zone(), fields);
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
  Response getProject(String projectId, String[] fields) {
    ProjectContainer defaultProject = createProject(projectId);
    projects.putIfAbsent(projectId, defaultProject);
    Project project = projects.get(projectId).project(); // project is now guaranteed to exist
    Project result = OptionParsersAndExtractors.extractFields(project, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing project %s.", projectId));
    }
  }

  /**
   * Creates a project. It generates a project number randomly (we do not have project numbers
   * available).
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

  /**
   * Deletes a zone.
   */
  Response deleteZone(String projectId, String zoneName) {
    ProjectContainer projectContainer = projects.get(projectId);
    ZoneContainer previous = projectContainer.zones.remove(zoneName);
    return previous == null
        // map was not in the collection
        ? Error.NOT_FOUND.response(String.format(
        "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName))
        : new Response(HTTP_NO_CONTENT, "{}");
  }

  /**
   * Creates new managed zone and stores it in the collection. Assumes that project exists.
   */
  Response createZone(String projectId, ManagedZone zone, String[] fields) {
    checkNotNull(zone, "Zone to create cannot be null");
    // check if the provided data is valid
    Response errorResponse = checkZone(zone);
    if (errorResponse != null) {
      return errorResponse;
    }
    // create a copy of the managed zone in order to avoid side effects
    ManagedZone completeZone = new ManagedZone();
    completeZone.setName(zone.getName());
    completeZone.setDnsName(zone.getDnsName());
    completeZone.setDescription(zone.getDescription());
    completeZone.setNameServerSet(zone.getNameServerSet());
    completeZone.setCreationTime(ISODateTimeFormat.dateTime().withZoneUTC()
        .print(System.currentTimeMillis()));
    completeZone.setId(
        new BigInteger(String.valueOf(Math.abs(ID_GENERATOR.nextLong() % Long.MAX_VALUE))));
    completeZone.setNameServers(randomNameservers());
    ZoneContainer zoneContainer = new ZoneContainer(completeZone);
    // create the default NS and SOA records
    zoneContainer.dnsRecords().put(zone.getName(), defaultRecords(completeZone));
    // place the zone in the data collection
    ProjectContainer projectContainer = findProject(projectId);
    ZoneContainer oldValue = projectContainer.zones().putIfAbsent(
        completeZone.getName(), zoneContainer);
    if (oldValue != null) {
      return Error.ALREADY_EXISTS.response(String.format(
          "The resource 'entity.managedZone' named '%s' already exists", completeZone.getName()));
    }
    // now return the desired attributes
    ManagedZone result = OptionParsersAndExtractors.extractFields(completeZone, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing managed zone %s.", result.getName()));
    }
  }

  /**
   * Creates a new change, stores it, and invokes processing in a new thread.
   */
  Response createChange(String projectId, String zoneName, Change change, String[] fields) {
    ZoneContainer zoneContainer = findZone(projectId, zoneName);
    if (zoneContainer == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named %s does not exist.", zoneName));
    }
    // check that the change to be applied is valid
    Response response = checkChange(change, zoneContainer);
    if (response != null) {
      return response;
    }
    // start applying
    Change completeChange = new Change(); // copy to avoid side effects
    if (change.getAdditions() != null) {
      completeChange.setAdditions(ImmutableList.copyOf(change.getAdditions()));
    }
    if (change.getDeletions() != null) {
      completeChange.setDeletions(ImmutableList.copyOf(change.getDeletions()));
    }
    /* we need to get the proper ID in concurrent environment
     the element fell on an index between 0 and maxId
     we will reset all IDs in this range (all of them are valid) */
    ConcurrentLinkedQueue<Change> changeSequence = zoneContainer.changes();
    changeSequence.add(completeChange);
    int maxId = changeSequence.size();
    int index = 0;
    for (Change c : changeSequence) {
      if (index == maxId) {
        break;
      }
      c.setId(String.valueOf(++index)); // indexing from 1
    }
    completeChange.setStatus("pending"); // not finished yet
    completeChange.setStartTime(ISODateTimeFormat.dateTime().withZoneUTC()
        .print(System.currentTimeMillis())); // accepted
    invokeChange(projectId, zoneName, completeChange.getId());
    Change result = OptionParsersAndExtractors.extractFields(completeChange, fields);
    try {
      return new Response(HTTP_OK, jsonFactory.toString(result));
    } catch (IOException e) {
      return Error.INTERNAL_ERROR.response(
          String.format("Error when serializing change %s in managed zone %s in project %s.",
              result.getId(), zoneName, projectId));
    }
  }

  /**
   * Applies change. Uses a new thread which applies the change only if DELAY_CHANGE is > 0.
   */
  private Thread invokeChange(final String projectId, final String zoneName,
      final String changeId) {
    if (delayChange > 0) {
      Thread thread = new Thread() {
        @Override
        public void run() {
          try {
            Thread.sleep(delayChange); // simulate delayed execution
          } catch (InterruptedException ex) {
            log.log(Level.WARNING, "Thread was interrupted while sleeping.", ex);
          }
          // start applying the changes
          applyExistingChange(projectId, zoneName, changeId);
        }
      };
      thread.start();
      return thread;
    } else {
      applyExistingChange(projectId, zoneName, changeId);
      return null;
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
    ConcurrentSkipListMap<String, ImmutableList<RrsetWrapper>> dnsRecords = wrapper.dnsRecords();
    while (true) {
      // managed zone must have a set of records which is not null
      ImmutableList<RrsetWrapper> original = dnsRecords.get(zoneName);
      assert original != null;
      List<RrsetWrapper> copy = Lists.newLinkedList(original);
      // apply deletions first
      List<ResourceRecordSet> deletions = change.getDeletions();
      if (deletions != null) {
        List<RrsetWrapper> transformedDeletions = Lists.transform(deletions,
            RrsetWrapper.WRAP_FUNCTION);
        copy.removeAll(transformedDeletions);
      }
      // apply additions
      List<ResourceRecordSet> additions = change.getAdditions();
      if (additions != null) {
        for (ResourceRecordSet addition : additions) {
          String id = getUniqueId(copy);
          RrsetWrapper rrsetWrapper = new RrsetWrapper(addition);
          rrsetWrapper.setId(id);
          copy.add(rrsetWrapper);
        }
      }
      // make it immutable and replace
      boolean success = dnsRecords.replace(zoneName, original, ImmutableList.copyOf(copy));
      if (success) {
        break; // success if no other thread modified the value in the meantime
      }
    }
    // set status to done
    change.setStatus("done");
  }

  /**
   * Lists zones. Next page token is the last listed zone name and is returned only of there is more
   * to list.
   */
  Response listZones(String projectId, Map<String, Object> options) {
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
    // matches will be included in the result if true
    boolean listing = (pageToken == null || !containers.containsKey(pageToken));
    boolean sizeReached = false; // maximum result size was reached, we should not return more
    boolean hasMorePages = false; // should next page token be included in the response?
    LinkedList<String> serializedZones = new LinkedList<>();
    String lastZoneName = null;
    for (ZoneContainer zoneContainer : containers.values()) {
      ManagedZone zone = zoneContainer.zone();
      if (listing) {
        if (dnsName == null || zone.getDnsName().equals(dnsName)) {
          if (sizeReached) {
            // we do not add this, just note that there would be more and there should be a token
            hasMorePages = true;
            break;
          } else {
            try {
              lastZoneName = zone.getName();
              serializedZones.addLast(jsonFactory.toString(
                  OptionParsersAndExtractors.extractFields(zone, fields)));
            } catch (IOException e) {
              return Error.INTERNAL_ERROR.response(String.format(
                  "Error when serializing managed zone %s in project %s", zone.getName(),
                  projectId));
            }
          }
        }
      }
      // either we are listing already, or we check if we should start in the next iteration
      listing = zone.getName().equals(pageToken) || listing;
      sizeReached = (maxResults != null) && maxResults.equals(serializedZones.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || ImmutableList.copyOf(fields).contains("nextPageToken"));
    return toListResponse(serializedZones, "managedZones", lastZoneName, includePageToken);
  }

  /**
   * Lists DNS records for a zone. Next page token is ID of the last record listed.
   */
  Response listDnsRecords(String projectId, String zoneName, Map<String, Object> options) {
    Response response = checkListOptions(options);
    if (response != null) {
      return response;
    }
    ZoneContainer zoneContainer = findZone(projectId, zoneName);
    if (zoneContainer == null) {
      return Error.NOT_FOUND.response(String.format(
          "The 'parameters.managedZone' resource named '%s' does not exist.", zoneName));
    }
    List<RrsetWrapper> dnsRecords = zoneContainer.dnsRecords().get(zoneName);
    String[] fields = (String[]) options.get("fields");
    String name = (String) options.get("name");
    String type = (String) options.get("type");
    String pageToken = (String) options.get("pageToken");
    Integer maxResults = options.get("maxResults") == null
        ? null : Integer.valueOf((String) options.get("maxResults"));
    boolean listing = (pageToken == null); // matches will be included in the result if true
    boolean sizeReached = false; // maximum result size was reached, we should not return more
    boolean hasMorePages = false; // should next page token be included in the response?
    LinkedList<String> serializedRrsets = new LinkedList<>();
    String lastRecordId = null;
    for (RrsetWrapper recordWrapper : dnsRecords) {
      ResourceRecordSet record = recordWrapper.rrset();
      if (listing) {
        if (matchesCriteria(record, name, type)) {
          if (sizeReached) {
            // we do not add this, just note that there would be more and there should be a token
            hasMorePages = true;
            break;
          } else {
            lastRecordId = recordWrapper.id();
            try {
              serializedRrsets.addLast(jsonFactory.toString(
                  OptionParsersAndExtractors.extractFields(record, fields)));
            } catch (IOException e) {
              return Error.INTERNAL_ERROR.response(String.format(
                  "Error when serializing resource record set in managed zone %s in project %s",
                  zoneName, projectId));
            }
          }
        }
      }
      // either we are listing already, or we check if we should start in the next iteration
      listing = recordWrapper.id().equals(pageToken) || listing;
      sizeReached = (maxResults != null) && maxResults.equals(serializedRrsets.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || ImmutableList.copyOf(fields).contains("nextPageToken"));
    return toListResponse(serializedRrsets, "rrsets", lastRecordId, includePageToken);
  }

  /**
   * Lists changes. Next page token is ID of the last change listed.
   */
  Response listChanges(String projectId, String zoneName, Map<String, Object> options) {
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
    TreeMap<Integer, Change> changes = new TreeMap<>();
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
    // we are not reading sort by as it the only key is the change sequence
    NavigableSet<Integer> keys;
    if ("descending".equals(sortOrder)) {
      keys = changes.descendingKeySet();
    } else {
      keys = changes.navigableKeySet();
    }
    boolean listing = (pageToken == null); // matches will be included in the result if true
    boolean sizeReached = false; // maximum result size was reached, we should not return more
    boolean hasMorePages = false; // should next page token be included in the response?
    LinkedList<String> serializedResults = new LinkedList<>();
    String lastChangeId = null;
    for (Integer key : keys) {
      Change change = changes.get(key);
      if (listing) {
        if (sizeReached) {
          // we do not add this, just note that there would be more and there should be a token
          hasMorePages = true;
          break;
        } else {
          lastChangeId = change.getId();
          try {
            serializedResults.addLast(jsonFactory.toString(
                OptionParsersAndExtractors.extractFields(change, fields)));
          } catch (IOException e) {
            return Error.INTERNAL_ERROR.response(String.format(
                "Error when serializing change %s in managed zone %s in project %s",
                change.getId(), zoneName, projectId));
          }
        }
      }

      // either we are listing already, or we check if we should start in the next iteration
      listing = change.getId().equals(pageToken) || listing;
      sizeReached = (maxResults != null) && maxResults.equals(serializedResults.size());
    }
    boolean includePageToken =
        hasMorePages && (fields == null || ImmutableList.copyOf(fields).contains("nextPageToken"));
    return toListResponse(serializedResults, "changes", lastChangeId, includePageToken);
  }

  /**
   * Validates a zone to be created.
   */
  static Response checkZone(ManagedZone zone) {
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
    if (zone.getName().isEmpty()) {
      return Error.INVALID.response(
          String.format("Invalid value for 'entity.managedZone.name': '%s'", zone.getName()));
    }
    if (zone.getDnsName().isEmpty() || !zone.getDnsName().endsWith(".")) {
      return Error.INVALID.response(
          String.format("Invalid value for 'entity.managedZone.dnsName': '%s'", zone.getDnsName()));
    }
    TreeSet<String> forbidden = Sets.newTreeSet(
        ImmutableList.of("google.com.", "com.", "example.com.", "net.", "org."));
    if (forbidden.contains(zone.getDnsName())) {
      return Error.NOT_AVAILABLE.response(String.format(
          "The '%s' managed zone is not available to be created.", zone.getDnsName()));
    }
    return null;
  }

  /**
   * Validates a change to be created.
   */
  static Response checkChange(Change change, ZoneContainer zone) {
    checkNotNull(zone);
    if ((change.getDeletions() != null && change.getDeletions().size() > 0)
        || (change.getAdditions() != null && change.getAdditions().size() > 0)) {
      // ok, this is what we want
    } else {
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
    return additionsMeetDeletions(change.getAdditions(), change.getDeletions(), zone);
    // null if everything is ok
  }

  /**
   * Checks a rrset within a change.
   *
   * @param type [additions|deletions]
   * @param index the index or addition or deletion in the list
   * @param zone the zone that this change is applied to
   */
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
      for (RrsetWrapper rrsetWrapper : zone.dnsRecords().get(zone.zone().getName())) {
        ResourceRecordSet wrappedRrset = rrsetWrapper.rrset();
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
          && !zone.dnsRecords().get(zone.zone().getName()).contains(new RrsetWrapper(rrset))) {
        // such a record does not exist
        return Error.CONDITION_NOT_MET.response(String.format(
            "Precondition not met for 'entity.change.deletions[%s]", index));
      }
    }
    return null;
  }

  /**
   * Checks that for each record that already exists, we have a matching deletion. Furthermore,
   * check that mandatory SOA and NS records stay.
   */
  static Response additionsMeetDeletions(List<ResourceRecordSet> additions,
      List<ResourceRecordSet> deletions, ZoneContainer zone) {
    if (additions != null) {
      int index = 0;
      for (ResourceRecordSet rrset : additions) {
        for (RrsetWrapper wrapper : zone.dnsRecords().get(zone.zone().getName())) {
          ResourceRecordSet wrappedRrset = wrapper.rrset();
          if (rrset.getName().equals(wrappedRrset.getName())
              && rrset.getType().equals(wrappedRrset.getType())) {
            // such a record exist and we must have a deletion
            if (deletions == null || !deletions.contains(wrappedRrset)) {
              return Error.ALREADY_EXISTS.response(String.format(
                  "The 'entity.change.additions[%s]' resource named '%s (%s)' already exists.",
                  index, rrset.getName(), rrset.getType()));
            }
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
  private static ResourceRecordSet findByNameAndType(Iterable<ResourceRecordSet> records,
      String name, String type) {
    if (records != null) {
      for (ResourceRecordSet rrset : records) {
        if ((name == null || name.equals(rrset.getName()))
            && (type == null || type.equals(rrset.getType()))) {
          return rrset;
        }
      }
    }
    return null;
  }

  /**
   * We only provide the most basic validation for A and AAAA records.
   */
  static boolean checkRrData(String data, String type) {
    // todo add validation for other records
    String[] tokens;
    switch (type) {
      case "A":
        tokens = data.split("\\.");
        if (tokens.length != 4) {
          return false;
        }
        for (String token : tokens) {
          try {
            Integer number = Integer.valueOf(token);
            if (number < 0 || number > 255) {
              return false;
            }
          } catch (NumberFormatException ex) {
            return false;
          }
        }
        return true;
      case "AAAA":
        tokens = data.split(":", -1);
        if (tokens.length != 8) {
          return false;
        }
        for (String token : tokens) {
          try {
            if (!token.isEmpty()) {
              // empty is ok
              Long number = Long.parseLong(token, 16);
              if (number < 0 || number > 0xFFFF) {
                return false;
              }
            }
          } catch (NumberFormatException ex) {
            return false;
          }
        }
        return true;
      default:
        return true;
    }
  }

  /**
   * Check supplied listing options.
   */
  static Response checkListOptions(Map<String, Object> options) {
    // for general listing
    String maxResultsString = (String) options.get("maxResults");
    if (maxResultsString != null) {
      Integer maxResults = null;
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
    if (dnsName != null) {
      if (!dnsName.endsWith(".")) {
        return Error.INVALID.response(String.format(
            "Invalid value for 'parameters.dnsName': '%s'", dnsName));
      }
    }
    // for listing dns records, name must be fully qualified
    String name = (String) options.get("name");
    if (name != null) {
      if (!name.endsWith(".")) {
        return Error.INVALID.response(String.format(
            "Invalid value for 'parameters.name': '%s'", name));
      }
    }
    String type = (String) options.get("type"); // must be provided with name
    if (type != null) {
      if (name == null) {
        return Error.INVALID.response("Invalid value for 'parameters.name': ''");
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
