/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Throwaway design probe for BigQuery property-graph metadata. NOT a regression test: no probe
 * asserts. Each probe records the server/driver outcome (success payload or error text) in {@code
 * target/graph_design_probe_report.txt}.
 *
 * <p>Runs against unmodified main. Needs the RetailGraph fixture ({@code retail_graph_test.sql})
 * in {@code $GRAPH_DATASET} (default {@code jdbc_graph_test}). Creates and drops its own probe
 * dataset for the start-node probes.
 *
 * <p>Run: {@code make integration-test test=ITGraphDesignProbeTest}
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ITGraphDesignProbeTest extends ITBase {

  private static final String PROJECT = DEFAULT_CATALOG;
  private static final String GRAPH_DS =
      System.getenv().getOrDefault("GRAPH_DATASET", "jdbc_graph_test");
  private static final String REGION = System.getenv().getOrDefault("GRAPH_REGION", "region-us");
  private static final String RETAIL = GRAPH_DS + ".RetailGraph";
  private static final String PROBE_DS = getUniqueDatasetName("JDBC_GRAPH_PROBE_");
  private static final String REPORT_PATH =
      "target/graph_design_probe_report_" + System.currentTimeMillis() + ".txt";

  private static final StringBuilder REPORT = new StringBuilder();
  private static Connection conn;

  // Filled by probe D4 / D5 and compared in F1.
  private static final List<String> expandColumns = new ArrayList<>();
  private static final List<String> infoSchemaElementProps = new ArrayList<>();

  private interface Probe {
    void run() throws Exception;
  }

  @BeforeAll
  static void setUp() throws Exception {
    log("project=" + PROJECT + " graphDataset=" + GRAPH_DS + " probeDataset=" + PROBE_DS);
    conn = DriverManager.getConnection(connectionUrl);
    String p = "`" + PROJECT + "." + PROBE_DS;
    bigQuery.query(
        QueryJobConfiguration.of(
            "CREATE SCHEMA "
                + p
                + "` OPTIONS (location = 'US', default_table_expiration_days = 1);\n"
                + "CREATE TABLE "
                + p
                + ".Region` (region_id INT64, region_name STRING,"
                + " PRIMARY KEY (region_id) NOT ENFORCED);\n"
                + "CREATE TABLE "
                + p
                + ".Customer` (customer_id INT64, full_name STRING, region_id INT64,"
                + " PRIMARY KEY (customer_id) NOT ENFORCED,"
                + " FOREIGN KEY (region_id) REFERENCES "
                + p
                + ".Region`(region_id) NOT ENFORCED);\n"
                + "CREATE TABLE "
                + p
                + ".Product` (sku STRING, product_name STRING, PRIMARY KEY (sku) NOT ENFORCED);\n"
                + "CREATE TABLE "
                + p
                + ".Sale` (order_id INT64, customer_id INT64, sku STRING, quantity INT64,"
                + " PRIMARY KEY (order_id) NOT ENFORCED,"
                + " FOREIGN KEY (customer_id) REFERENCES "
                + p
                + ".Customer`(customer_id) NOT ENFORCED,"
                + " FOREIGN KEY (sku) REFERENCES "
                + p
                + ".Product`(sku) NOT ENFORCED);\n"
                + "INSERT INTO "
                + p
                + ".Region` VALUES (1, 'West'), (2, 'East');\n"
                + "INSERT INTO "
                + p
                + ".Customer` VALUES (10, 'Ann', 1), (11, 'Bob', 1), (12, 'Cy', 2);\n"
                + "INSERT INTO "
                + p
                + ".Product` VALUES ('A', 'Apple'), ('B', 'Banana');\n"
                + "INSERT INTO "
                + p
                + ".Sale` VALUES (100, 10, 'A', 1), (101, 10, 'B', 2), (102, 11, 'A', 3),"
                + " (103, 12, 'B', 4);\n"
                // Review: a second table that also points at Customer (many-to-one), used by the
                // multi-source probes (M*). Sale and Review are then both sources into Customer.
                + "CREATE TABLE "
                + p
                + ".Review` (review_id INT64, customer_id INT64, rating INT64,"
                + " PRIMARY KEY (review_id) NOT ENFORCED,"
                + " FOREIGN KEY (customer_id) REFERENCES "
                + p
                + ".Customer`(customer_id) NOT ENFORCED);\n"
                + "INSERT INTO "
                + p
                + ".Review` VALUES (900, 10, 5), (901, 11, 3), (902, 11, 4), (903, 12, 1),"
                + " (904, 12, 2);\n"));
  }

  @AfterAll
  static void tearDown() throws Exception {
    try {
      if (conn != null) {
        conn.close();
      }
      bigQuery.query(QueryJobConfiguration.of(String.format(dropSchema, PROJECT, PROBE_DS)));
    } catch (Exception e) {
      log("cleanup failed: " + describe(e));
    }
    Files.write(Paths.get(REPORT_PATH), REPORT.toString().getBytes(StandardCharsets.UTF_8));
    System.out.println(REPORT);
    System.out.println("Report written to " + REPORT_PATH);
  }

  // ---------------------------------------------------------------------------------------------
  // S: Does the GRAPH_EXPAND schema depend on the start (root) node?
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(1)
  void s_startNodeProbes() {
    section("S: GRAPH_EXPAND root / start node");
    String p = "`" + PROJECT + "." + PROBE_DS;
    String region = p + ".Region` AS Region KEY (region_id)";
    String customer = p + ".Customer` AS Customer KEY (customer_id)";
    String product = p + ".Product` AS Product KEY (sku)";
    String sale = p + ".Sale` AS Sale KEY (order_id)";
    String livesIn =
        p
            + ".Customer` AS LivesIn KEY (customer_id)"
            + " SOURCE KEY (customer_id) REFERENCES Customer (customer_id)"
            + " DESTINATION KEY (region_id) REFERENCES Region (region_id)";
    String placedBy =
        p
            + ".Sale` AS PlacedBy KEY (order_id)"
            + " SOURCE KEY (order_id) REFERENCES Sale (order_id)"
            + " DESTINATION KEY (customer_id) REFERENCES Customer (customer_id)";
    String saleProduct =
        p
            + ".Sale` AS SaleProduct KEY (order_id)"
            + " SOURCE KEY (order_id) REFERENCES Sale (order_id)"
            + " DESTINATION KEY (sku) REFERENCES Product (sku)";
    String locatedInReversed =
        p
            + ".Customer` AS LocatedIn KEY (customer_id)"
            + " SOURCE KEY (region_id) REFERENCES Region (region_id)"
            + " DESTINATION KEY (customer_id) REFERENCES Customer (customer_id)";

    graphProbe(
        "S1",
        "G_SALE_ROOT: Sale->Customer, Sale->Product, Customer->Region (one root: Sale)",
        "G_SALE_ROOT",
        join(region, customer, product, sale),
        join(placedBy, saleProduct, livesIn));
    graphProbe(
        "S2",
        "G_CUSTOMER_ROOT: Customer->Region only (root: Customer)",
        "G_CUSTOMER_ROOT",
        join(region, customer),
        livesIn);
    graphProbe(
        "S3",
        "G_REVERSED: same tables as S2, but the edge is declared Region->Customer",
        "G_REVERSED",
        join(region, customer),
        locatedInReversed);
    // S3 changed two things vs S2 (direction AND edge alias). S3R changes only the direction:
    // same alias as S2 (LivesIn), SOURCE/DESTINATION swapped. Compare S3Rb to S2b column-for-column.
    String livesInReversed =
        p
            + ".Customer` AS LivesIn KEY (customer_id)"
            + " SOURCE KEY (region_id) REFERENCES Region (region_id)"
            + " DESTINATION KEY (customer_id) REFERENCES Customer (customer_id)";
    graphProbe(
        "S3R",
        "G_REVERSED_SAME_ALIAS: S2 with only the edge direction swapped (alias kept as LivesIn)",
        "G_REVERSED_SAME_ALIAS",
        join(region, customer),
        livesInReversed);
    graphProbe(
        "S4",
        "G_SALE_CUSTOMER: Sale->Customer only (Customer is NOT the root; compare Customer_* to S2)",
        "G_SALE_CUSTOMER",
        join(customer, sale),
        placedBy);
    graphProbe(
        "S5",
        "G_TWO_ROOTS: Customer and Product, no edges (two possible start nodes)",
        "G_TWO_ROOTS",
        join(customer, product),
        null);
    graphProbe(
        "S6",
        "G_TWO_COMPONENTS: Customer->Region and Sale->Product (two disconnected roots)",
        "G_TWO_COMPONENTS",
        join(region, customer, product, sale),
        join(livesIn, saleProduct));

    // ---- M: multiple SOURCE nodes in one CONNECTED graph ----
    String review = p + ".Review` AS Review KEY (review_id)";
    String wroteBy =
        p
            + ".Review` AS WroteBy KEY (review_id)"
            + " SOURCE KEY (review_id) REFERENCES Review (review_id)"
            + " DESTINATION KEY (customer_id) REFERENCES Customer (customer_id)";
    // M1: Sale->Customer and Review->Customer. Two sources (Sale, Review), Customer in-degree 2.
    graphProbe(
        "M1",
        "G_CONVERGE: Sale->Customer, Review->Customer (2 sources, connected)",
        "G_CONVERGE",
        join(customer, sale, review),
        join(placedBy, wroteBy));
    // M2: same as M1 plus Customer->Region. Still 2 sources; adds a shared downstream node.
    graphProbe(
        "M2",
        "G_CONVERGE_DEEP: Sale->Customer, Review->Customer, Customer->Region (2 sources)",
        "G_CONVERGE_DEEP",
        join(region, customer, sale, review),
        join(placedBy, wroteBy, livesIn));
    // M3: DECLARED edges have 2 sources (Region, Sale), but by key cardinality there is one
    // root (Sale: Sale->Customer->Region). Tests whether declared direction or keys decide.
    graphProbe(
        "M3",
        "G_DECLARED_TWO_SOURCES: declared Region->Customer and Sale->Customer",
        "G_DECLARED_TWO_SOURCES",
        join(region, customer, sale),
        join(livesInReversed, placedBy));
    // M4: many-to-many edge only (Customer<->Product via Sale, edge key is order_id).
    // Docs say such edges are omitted from the schema relationship graph.
    String bought =
        p
            + ".Sale` AS Bought KEY (order_id)"
            + " SOURCE KEY (customer_id) REFERENCES Customer (customer_id)"
            + " DESTINATION KEY (sku) REFERENCES Product (sku)";
    graphProbe(
        "M4",
        "G_MANY_TO_MANY: Customer, Product, edge Bought (Customer<->Product, many-to-many)",
        "G_MANY_TO_MANY",
        join(customer, product),
        bought);
    // M5: S1 plus the many-to-many Bought edge. Does EXPAND succeed and silently drop Bought_*?
    graphProbe(
        "M5",
        "G_SALE_ROOT_PLUS_M2M: S1 graph + Bought (many-to-many) edge",
        "G_SALE_ROOT_PLUS_M2M",
        join(region, customer, product, sale),
        join(placedBy, saleProduct, livesIn, bought));

    // Are graphs rejected by GRAPH_EXPAND still valid for GQL? (dry run)
    gqlDryRun(
        "M1g",
        PROBE_DS + ".G_CONVERGE",
        "MATCH (s:Sale)-[:PlacedBy]->(c:Customer)<-[:WroteBy]-(r:Review)"
            + " RETURN s.order_id AS o, c.full_name AS n, r.rating AS rating");
    gqlDryRun(
        "M4g",
        PROBE_DS + ".G_MANY_TO_MANY",
        "MATCH (c:Customer)-[b:Bought]->(p:Product) RETURN c.full_name AS n, p.sku AS sku");
  }

  // ---------------------------------------------------------------------------------------------
  // G: GQL. Does the output schema depend on the start node / label? (dry runs only)
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(2)
  void g_gqlStartNodeProbes() {
    section("G: GQL output schema vs start node (dry run unless noted)");
    String g = PROBE_DS + ".G_SALE_ROOT";
    gqlDryRun("G1", g, "MATCH (n:Customer) RETURN n.*");
    gqlDryRun("G2", g, "MATCH (n:Sale) RETURN n.*");
    gqlDryRun("G3", g, "MATCH (n) RETURN n.full_name AS v");
    gqlDryRun("G4", g, "MATCH (s:Sale)-[e]->(m) RETURN m.full_name AS a, m.product_name AS b");
    gqlDryRun("G5", g, "MATCH (n:Customer) RETURN n");
    gqlDryRun("G6", g, "MATCH (n:Customer) RETURN TO_JSON(n) AS j");
    gqlDryRun("G7", g, "MATCH p = (s:Sale)-[e]->{1,2}(m) RETURN TO_JSON(p) AS j");
    gqlDryRun("G8", RETAIL, "MATCH (c:Customer) RETURN c.name AS v");
    gqlDryRun("G9", RETAIL, "MATCH (c:Person) RETURN c.email AS v");
    gqlDryRun("G10", RETAIL, "MATCH (c:Person) RETURN c.*");
    gqlDryRun("G11", RETAIL, "MATCH (c:Customer) RETURN c.*");
    probe(
        "G12",
        "JDBC Statement EXECUTES a GQL query (checks the edition requirement)",
        () ->
            dumpQuery(
                "SELECT * FROM GRAPH_TABLE("
                    + g
                    + " MATCH (s:Sale)-[e]->(m) RETURN s.order_id AS o, m.full_name AS a)"
                    + " LIMIT 5"));
  }

  // ---------------------------------------------------------------------------------------------
  // D: Can the driver get the result straight from a Statement, with no client-side parsing?
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(3)
  void d_directExecutionProbes() {
    section("D: direct Statement execution against RetailGraph");
    String expand = "SELECT * FROM GRAPH_EXPAND('" + RETAIL + "')";
    probe(
        "D1",
        "Statement.executeQuery(SELECT * FROM GRAPH_EXPAND LIMIT 0) -> ResultSetMetaData",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(expand + " LIMIT 0")) {
            dumpRsmd(rs.getMetaData());
          }
        });
    probe(
        "D2",
        "PreparedStatement(SELECT * FROM GRAPH_EXPAND).getMetaData() without executing",
        () -> {
          try (PreparedStatement ps = conn.prepareStatement(expand)) {
            ResultSetMetaData md = ps.getMetaData();
            if (md == null) {
              log("  RESULT: getMetaData() returned null");
            } else {
              dumpRsmd(md);
            }
          }
        });
    probe("D3", "BigQuery client dry run of SELECT * FROM GRAPH_EXPAND", () -> dryRun(expand));
    probe(
        "D4",
        "Statement runs a script: CALL BQ.SHOW_GRAPH_EXPAND_SCHEMA + UNNEST in SQL -> rows",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(showExpandSchemaSql(RETAIL))) {
            List<List<String>> rows = dumpResultSet(rs, 200);
            for (List<String> r : rows) {
              expandColumns.add(r.get(1));
            }
          }
        });
    probe(
        "D5",
        "Statement: region INFORMATION_SCHEMA.PROPERTY_GRAPHS flattened in SQL -> rows",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(infoSchemaFlattenSql(REGION, "RetailGraph"))) {
            List<List<String>> rows = dumpResultSet(rs, 200);
            for (List<String> r : rows) {
              if (r.get(5) != null) {
                infoSchemaElementProps.add(r.get(3) + "_" + r.get(5));
              }
            }
          }
        });
    probe(
        "D6",
        "Statement: dataset-scoped `project.dataset.INFORMATION_SCHEMA.PROPERTY_GRAPHS`",
        () ->
            dumpQuery(
                "SELECT property_graph_catalog, property_graph_schema, property_graph_name FROM `"
                    + PROJECT
                    + "."
                    + GRAPH_DS
                    + ".INFORMATION_SCHEMA.PROPERTY_GRAPHS`"));
    probe(
        "D7",
        "Statement executes GRAPH_EXPAND + AGG(measure)",
        () ->
            dumpQuery(
                "SELECT Region_region_name, AGG(Sale_total_quantity) AS units,"
                    + " AGG(Product_avg_list_price) AS avg_price FROM GRAPH_EXPAND('"
                    + RETAIL
                    + "') GROUP BY Region_region_name"));
    probe(
        "D8",
        "Statement: SELECT * EXCEPT(<all measure columns>) FROM GRAPH_EXPAND LIMIT 0",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs =
                  st.executeQuery(
                      expand.replace(
                              "SELECT *",
                              "SELECT * EXCEPT(Product_avg_list_price, Product_max_list_price,"
                                  + " Product_min_weight_kg, Sale_total_quantity,"
                                  + " Sale_line_count, Sale_distinct_customers)")
                          + " LIMIT 0")) {
            dumpRsmd(rs.getMetaData());
          }
        });
  }

  // ---------------------------------------------------------------------------------------------
  // F: INFORMATION_SCHEMA (nested) vs GRAPH_EXPAND (flattened)
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(4)
  void f_flatteningComparison() {
    section("F: <elementTable>_<property> from INFORMATION_SCHEMA vs GRAPH_EXPAND columns");
    probe(
        "F1",
        "set difference (uses D4 and D5 output)",
        () -> {
          Set<String> derived = new LinkedHashSet<>(infoSchemaElementProps);
          Set<String> expand = new LinkedHashSet<>(expandColumns);
          log("  INFORMATION_SCHEMA (element,label,property) rows: " + infoSchemaElementProps.size());
          log("  distinct <elementTable>_<property>: " + derived.size());
          log("  GRAPH_EXPAND columns: " + expand.size());
          Set<String> onlyDerived = new LinkedHashSet<>(derived);
          onlyDerived.removeAll(expand);
          Set<String> onlyExpand = new LinkedHashSet<>(expand);
          onlyExpand.removeAll(derived);
          log("  in INFORMATION_SCHEMA only (dropped by GRAPH_EXPAND): " + onlyDerived);
          log("  in GRAPH_EXPAND only (not derivable by that rule): " + onlyExpand);
        });
  }

  // ---------------------------------------------------------------------------------------------
  // P: Current main behavior for dotted schemas (PCNT already uses catalog.namespace)
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(5)
  void p_dottedSchemaProbes() {
    section("P: dotted TABLE_SCHEM on current main (PCNT overlap)");
    probe(
        "P1",
        "getSchemas(project, null): dotted TABLE_SCHEM values returned today",
        () -> {
          DatabaseMetaData md = conn.getMetaData();
          int total = 0;
          List<String> dotted = new ArrayList<>();
          try (ResultSet rs = md.getSchemas(PROJECT, null)) {
            while (rs.next()) {
              total++;
              String s = rs.getString("TABLE_SCHEM");
              if (s != null && s.contains(".")) {
                dotted.add(s);
              }
            }
          }
          log("  RESULT: total=" + total + " dotted=" + dotted.size() + " " + head(dotted, 20));
        });
    probe(
        "P2",
        "getSchemas(project, '" + GRAPH_DS + "%')",
        () -> dumpResultSet(conn.getMetaData().getSchemas(PROJECT, GRAPH_DS + "%"), 50));
    probe(
        "P3",
        "getTables(project, '" + RETAIL + "', '%', null) on main",
        () -> dumpResultSet(conn.getMetaData().getTables(PROJECT, RETAIL, "%", null), 50));
    probe(
        "P4",
        "getColumns(project, '" + RETAIL + "', '%', '%') on main",
        () -> dumpResultSet(conn.getMetaData().getColumns(PROJECT, RETAIL, "%", "%"), 50));
    probe(
        "P5",
        "getTables(project, '" + PCNT_SCHEMA + "', '%', null): PCNT control",
        () -> dumpResultSet(conn.getMetaData().getTables(PROJECT, PCNT_SCHEMA, "%", null), 10));
  }

  // ---------------------------------------------------------------------------------------------
  // E: Element-as-table mapping (schema = dataset.graph, table = element, column = property).
  //   E1/E2: does SHOW ever drop columns that INFORMATION_SCHEMA lists (docs' StoreGraph case)?
  //   E3:    what happens when two (element, property) pairs produce the same flat column name?
  //   EJ*:   SHOW joined back to INFORMATION_SCHEMA element names (FULL OUTER JOIN shows gaps).
  //   EI*:   INFORMATION_SCHEMA alone, shaped as per-element columns (works without SHOW?).
  // ---------------------------------------------------------------------------------------------

  @Test
  @Order(6)
  void e_elementMappingProbes() {
    section("E: element-as-table mapping (SHOW vs INFORMATION_SCHEMA per element)");
    String p = "`" + PROJECT + "." + PROBE_DS;
    probe(
        "E0",
        "create base tables: docs StoreGraph (Stores, Locations) + collision tables (CollA, CollAB)",
        () -> {
          bigQuery.query(
              QueryJobConfiguration.of(
                  "CREATE TABLE "
                      + p
                      + ".Locations` (id INT64, name STRING, population INT64,"
                      + " PRIMARY KEY (id) NOT ENFORCED);\n"
                      + "CREATE TABLE "
                      + p
                      + ".Stores` (name STRING, location_id INT64,"
                      + " PRIMARY KEY (name) NOT ENFORCED,"
                      + " FOREIGN KEY (location_id) REFERENCES "
                      + p
                      + ".Locations`(id) NOT ENFORCED);\n"
                      + "INSERT INTO "
                      + p
                      + ".Locations` VALUES (101, 'Anytown', 1000), (102, 'Sometown', 500);\n"
                      + "INSERT INTO "
                      + p
                      + ".Stores` VALUES ('Store 1', 101), ('Store 2', 101);\n"
                      + "CREATE TABLE "
                      + p
                      + ".CollA` (id INT64, B_c STRING, PRIMARY KEY (id) NOT ENFORCED);\n"
                      + "CREATE TABLE "
                      + p
                      + ".CollAB` (id INT64, c STRING, a_id INT64, PRIMARY KEY (id) NOT ENFORCED,"
                      + " FOREIGN KEY (a_id) REFERENCES "
                      + p
                      + ".CollA`(id) NOT ENFORCED);\n"
                      + "INSERT INTO "
                      + p
                      + ".CollA` VALUES (1, 'from A.B_c');\n"
                      + "INSERT INTO "
                      + p
                      + ".CollAB` VALUES (7, 'from A_B.c', 1);\n"));
          log("  RESULT: created");
        });

    // E1: exact copy of the docs' StoreGraph. Docs say SL_location_id and SL_name are omitted.
    String storeNodes =
        p
            + ".Stores` AS S, "
            + p
            + ".Locations` AS L PROPERTIES(id, name, population,"
            + " MEASURE(SUM(population)) AS total_population)";
    graphProbe(
        "E1",
        "G_STORE_DOCS: docs StoreGraph, edge SL declared L -> S (edge backed by S's table)",
        "G_STORE_DOCS",
        storeNodes,
        p
            + ".Stores` AS SL SOURCE KEY (location_id) REFERENCES L (id)"
            + " DESTINATION KEY (name) REFERENCES S (name)");
    // E2: same as E1, only the declared edge direction flipped (S -> L).
    graphProbe(
        "E2",
        "G_STORE_FLIPPED: E1 with only the edge direction flipped (S -> L)",
        "G_STORE_FLIPPED",
        storeNodes,
        p
            + ".Stores` AS SL SOURCE KEY (name) REFERENCES S (name)"
            + " DESTINATION KEY (location_id) REFERENCES L (id)");
    // E3: element A has property B_c, element A_B has property c. Both flatten to A_B_c.
    graphProbe(
        "E3",
        "G_COLLIDE: node A (prop B_c) and node A_B (prop c) both map to 'A_B_c'",
        "G_COLLIDE",
        join(p + ".CollA` AS A KEY (id)", p + ".CollAB` AS A_B KEY (id)"),
        p
            + ".CollAB` AS AB2A KEY (id) SOURCE KEY (id) REFERENCES A_B (id)"
            + " DESTINATION KEY (a_id) REFERENCES A (id)");

    // Real columns returned by a query, to compare with SHOW (E1b/E2b/E3b).
    realColumnsProbe("E1r", PROBE_DS + ".G_STORE_DOCS", "L_total_population");
    realColumnsProbe("E2r", PROBE_DS + ".G_STORE_FLIPPED", "L_total_population");
    realColumnsProbe("E3r", PROBE_DS + ".G_COLLIDE", null);
    probe(
        "E3v",
        "E3 values: SELECT * FROM GRAPH_EXPAND(G_COLLIDE)",
        () -> dumpQuery("SELECT * FROM GRAPH_EXPAND('" + PROBE_DS + ".G_COLLIDE')"));

    // SHOW joined back to INFORMATION_SCHEMA element names.
    joinProbe("EJ1", GRAPH_DS, "RetailGraph");
    joinProbe("EJ2", PROBE_DS, "G_STORE_DOCS");
    joinProbe("EJ3", PROBE_DS, "G_STORE_FLIPPED");
    joinProbe("EJ4", PROBE_DS, "G_COLLIDE");
    joinProbe("EJ5", PROBE_DS, "G_CONVERGE");

    // INFORMATION_SCHEMA alone: tables (elements) and columns (properties) per element.
    infoOnlyProbes("EI1", GRAPH_DS, "RetailGraph");
    infoOnlyProbes("EI2", PROBE_DS, "G_STORE_DOCS");
    infoOnlyProbes("EI3", PROBE_DS, "G_COLLIDE");
    infoOnlyProbes("EI4", PROBE_DS, "G_CONVERGE");
  }

  private static void realColumnsProbe(String id, String fqGraph, String measureToExclude) {
    String select =
        measureToExclude == null ? "SELECT *" : "SELECT * EXCEPT(" + measureToExclude + ")";
    probe(
        id,
        "real columns: " + select + " FROM GRAPH_EXPAND('" + fqGraph + "') LIMIT 0",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs =
                  st.executeQuery(select + " FROM GRAPH_EXPAND('" + fqGraph + "') LIMIT 0")) {
            dumpRsmd(rs.getMetaData());
          }
        });
  }

  private static void joinProbe(String id, String dataset, String graph) {
    probe(
        id,
        "SHOW(" + dataset + "." + graph + ") FULL OUTER JOIN INFORMATION_SCHEMA element properties",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(showJoinInfoSchemaSql(dataset, graph))) {
            List<List<String>> rows = dumpResultSet(rs, 200);
            int match = 0;
            int onlyInfo = 0;
            int onlyShow = 0;
            int collisions = 0;
            for (List<String> r : rows) {
              switch (r.get(5)) {
                case "MATCH":
                  match++;
                  break;
                case "ONLY_IN_INFO_SCHEMA":
                  onlyInfo++;
                  break;
                default:
                  onlyShow++;
              }
              if (r.get(2) != null && Integer.parseInt(r.get(6)) > 1) {
                collisions++;
              }
            }
            log(
                "  SUMMARY: match="
                    + match
                    + " onlyInInfoSchema="
                    + onlyInfo
                    + " onlyInShow="
                    + onlyShow
                    + " rowsSharingAShowColumn="
                    + collisions);
          }
        });
  }

  private static void infoOnlyProbes(String id, String dataset, String graph) {
    probe(
        id + "t",
        "INFORMATION_SCHEMA only: getTables-shaped (one row per element) for " + graph,
        () -> dumpQuery(infoSchemaElementTablesSql(dataset, graph)));
    probe(
        id + "c",
        "INFORMATION_SCHEMA only: getColumns-shaped (one row per element property) for " + graph,
        () -> dumpQuery(infoSchemaElementColumnsSql(dataset, graph)));
  }

  // ---------------------------------------------------------------------------------------------
  // Helpers
  // ---------------------------------------------------------------------------------------------

  private static void graphProbe(
      String id, String what, String graph, String nodes, String edges) {
    String fq = PROBE_DS + "." + graph;
    probe(
        id + "a",
        "CREATE " + what,
        () -> {
          String ddl =
              "CREATE OR REPLACE PROPERTY GRAPH `"
                  + PROJECT
                  + "."
                  + fq
                  + "` NODE TABLES ("
                  + nodes
                  + ")"
                  + (edges == null ? "" : " EDGE TABLES (" + edges + ")");
          bigQuery.query(QueryJobConfiguration.of(ddl));
          log("  RESULT: created");
        });
    probe(
        id + "b",
        "SHOW_GRAPH_EXPAND_SCHEMA(" + graph + ") via JDBC Statement script",
        () -> {
          try (Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(showExpandSchemaSql(fq))) {
            dumpResultSet(rs, 100);
          }
        });
    probe(
        id + "c",
        "row grain: SELECT COUNT(*) FROM GRAPH_EXPAND(" + graph + ")",
        () -> dumpQuery("SELECT COUNT(*) AS row_count FROM GRAPH_EXPAND('" + fq + "')"));
  }

  private static void gqlDryRun(String id, String graph, String gql) {
    String sql = "SELECT * FROM GRAPH_TABLE(" + graph + " " + gql + ")";
    probe(id, sql, () -> dryRun(sql));
  }

  private static String showExpandSchemaSql(String graph) {
    return "BEGIN\n"
        + "  DECLARE s STRING DEFAULT '';\n"
        + "  CALL BQ.SHOW_GRAPH_EXPAND_SCHEMA('"
        + graph
        + "', s);\n"
        + "  SELECT\n"
        + "    off + 1 AS ORDINAL_POSITION,\n"
        + "    JSON_VALUE(f, '$.name') AS COLUMN_NAME,\n"
        + "    JSON_VALUE(f, '$.type') AS TYPE_NAME,\n"
        + "    JSON_VALUE(f, '$.mode') AS MODE,\n"
        + "    COALESCE(JSON_VALUE(f, '$.is_measure') = 'true', FALSE) AS IS_MEASURE,\n"
        + "    JSON_VALUE(JSON_VALUE(f, '$.description'), '$.description') AS REMARKS\n"
        + "  FROM UNNEST(JSON_QUERY_ARRAY(s, '$.fields')) AS f WITH OFFSET AS off\n"
        + "  ORDER BY off;\n"
        + "END;";
  }

  private static String infoSchemaFlattenSql(String region, String graphName) {
    String from =
        " FROM `" + PROJECT + "`.`" + region + "`.INFORMATION_SCHEMA.PROPERTY_GRAPHS AS g";
    String where =
        " WHERE g.property_graph_schema = '"
            + GRAPH_DS
            + "' AND g.property_graph_name = '"
            + graphName
            + "'";
    return flattenBranch("NODE", "$.nodeTables", from, where)
        + "\nUNION ALL\n"
        + flattenBranch("EDGE", "$.edgeTables", from, where)
        + "\nORDER BY ELEMENT_KIND DESC, ti, li, pi";
  }

  /**
   * CTE {@code props}: one row per (element, property) from the dataset-scoped INFORMATION_SCHEMA,
   * merged across labels (first label wins). {@code ti} = element position (nodes, then edges).
   */
  private static String elementPropsCte(String dataset, String graph) {
    return "props AS (\n"
        + "  SELECT * FROM (\n"
        + "    SELECT JSON_VALUE(t, '$.name') AS element, JSON_VALUE(p, '$.name') AS property,\n"
        + "      JSON_VALUE(p, '$.dataType.typeKind') AS type_kind,\n"
        + "      IFNULL(JSON_VALUE(p, '$.expressionKind'), '') = 'MEASURE' AS is_measure,\n"
        + "      JSON_VALUE(p, '$.info.description') AS remarks, ti, li, pi\n"
        + "    FROM `"
        + PROJECT
        + "."
        + dataset
        + ".INFORMATION_SCHEMA.PROPERTY_GRAPHS` AS g\n"
        + "    CROSS JOIN UNNEST(ARRAY_CONCAT(\n"
        + "      IFNULL(JSON_QUERY_ARRAY(g.property_graph_metadata_json, '$.nodeTables'),"
        + " ARRAY<JSON>[]),\n"
        + "      IFNULL(JSON_QUERY_ARRAY(g.property_graph_metadata_json, '$.edgeTables'),"
        + " ARRAY<JSON>[]))) AS t WITH OFFSET AS ti\n"
        + "    CROSS JOIN UNNEST(JSON_QUERY_ARRAY(t, '$.labelAndProperties')) AS l WITH OFFSET AS li\n"
        + "    CROSS JOIN UNNEST(JSON_QUERY_ARRAY(l, '$.properties')) AS p WITH OFFSET AS pi\n"
        + "    WHERE g.property_graph_name = '"
        + graph
        + "')\n"
        + "  WHERE TRUE\n"
        + "  QUALIFY ROW_NUMBER() OVER (PARTITION BY element, property ORDER BY li, pi) = 1)";
  }

  /** Script: SHOW output FULL OUTER JOIN INFORMATION_SCHEMA props on name = element_property. */
  private static String showJoinInfoSchemaSql(String dataset, String graph) {
    return "BEGIN\n"
        + "  DECLARE s STRING DEFAULT '';\n"
        + "  CALL BQ.SHOW_GRAPH_EXPAND_SCHEMA('"
        + dataset
        + "."
        + graph
        + "', s);\n"
        + "  WITH "
        + elementPropsCte(dataset, graph)
        + ",\n"
        + "  shown AS (\n"
        + "    SELECT off, JSON_VALUE(f, '$.name') AS col, JSON_VALUE(f, '$.type') AS show_type\n"
        + "    FROM UNNEST(JSON_QUERY_ARRAY(s, '$.fields')) AS f WITH OFFSET AS off)\n"
        + "  SELECT p.element AS TABLE_NAME, p.property AS COLUMN_NAME, sh.col AS SHOW_COLUMN,\n"
        + "    sh.show_type AS SHOW_TYPE, p.type_kind AS INFO_SCHEMA_TYPE,\n"
        + "    CASE WHEN sh.col IS NULL THEN 'ONLY_IN_INFO_SCHEMA'\n"
        + "         WHEN p.element IS NULL THEN 'ONLY_IN_SHOW' ELSE 'MATCH' END AS STATUS,\n"
        + "    COUNT(*) OVER (PARTITION BY sh.col) AS SHOW_COL_MATCHES\n"
        + "  FROM props AS p\n"
        + "  FULL OUTER JOIN shown AS sh ON sh.col = CONCAT(p.element, '_', p.property)\n"
        + "  ORDER BY STATUS, sh.off, p.ti, p.li, p.pi;\n"
        + "END;";
  }

  /** getTables-shaped: one row per element table, including elements with no properties. */
  private static String infoSchemaElementTablesSql(String dataset, String graph) {
    return "SELECT CONCAT(g.property_graph_schema, '.', g.property_graph_name) AS TABLE_SCHEM,\n"
        + "  JSON_VALUE(t, '$.name') AS TABLE_NAME,\n"
        + "  IF(ti < ARRAY_LENGTH(IFNULL(JSON_QUERY_ARRAY(g.property_graph_metadata_json,"
        + " '$.nodeTables'), ARRAY<JSON>[])), 'NODE', 'EDGE') AS ELEMENT_KIND,\n"
        + "  (SELECT COUNT(*) FROM UNNEST(JSON_QUERY_ARRAY(t, '$.labelAndProperties')) AS l,\n"
        + "     UNNEST(JSON_QUERY_ARRAY(l, '$.properties'))) AS PROPERTY_ROWS\n"
        + "FROM `"
        + PROJECT
        + "."
        + dataset
        + ".INFORMATION_SCHEMA.PROPERTY_GRAPHS` AS g\n"
        + "CROSS JOIN UNNEST(ARRAY_CONCAT(\n"
        + "  IFNULL(JSON_QUERY_ARRAY(g.property_graph_metadata_json, '$.nodeTables'),"
        + " ARRAY<JSON>[]),\n"
        + "  IFNULL(JSON_QUERY_ARRAY(g.property_graph_metadata_json, '$.edgeTables'),"
        + " ARRAY<JSON>[]))) AS t WITH OFFSET AS ti\n"
        + "WHERE g.property_graph_name = '"
        + graph
        + "'\n"
        + "ORDER BY ti";
  }

  /** getColumns-shaped: one row per (element, property), labels merged. */
  private static String infoSchemaElementColumnsSql(String dataset, String graph) {
    return "WITH "
        + elementPropsCte(dataset, graph)
        + "\n"
        + "SELECT '"
        + dataset
        + "."
        + graph
        + "' AS TABLE_SCHEM, element AS TABLE_NAME, property AS COLUMN_NAME,\n"
        + "  type_kind AS TYPE_NAME, is_measure AS IS_MEASURE, remarks AS REMARKS,\n"
        + "  ROW_NUMBER() OVER (PARTITION BY element ORDER BY li, pi) AS ORDINAL_POSITION\n"
        + "FROM props\n"
        + "ORDER BY ti, ORDINAL_POSITION";
  }

  private static String flattenBranch(String kind, String path, String from, String where) {
    return "SELECT g.property_graph_schema AS GRAPH_SCHEMA, g.property_graph_name AS GRAPH_NAME,"
        + " '"
        + kind
        + "' AS ELEMENT_KIND, JSON_VALUE(t, '$.name') AS ELEMENT_TABLE,"
        + " JSON_VALUE(l, '$.label') AS LABEL, JSON_VALUE(p, '$.name') AS PROPERTY_NAME,"
        + " JSON_VALUE(p, '$.dataType.typeKind') AS TYPE_KIND,"
        + " IFNULL(JSON_VALUE(p, '$.expressionKind'), '') = 'MEASURE' AS IS_MEASURE,"
        + " JSON_VALUE(p, '$.expression') AS EXPRESSION,"
        + " JSON_VALUE(p, '$.info.description') AS REMARKS, ti, li, pi"
        + from
        + " CROSS JOIN UNNEST(JSON_QUERY_ARRAY(g.property_graph_metadata_json, '"
        + path
        + "')) AS t WITH OFFSET AS ti"
        + " CROSS JOIN UNNEST(JSON_QUERY_ARRAY(t, '$.labelAndProperties')) AS l WITH OFFSET AS li"
        + " LEFT JOIN UNNEST(JSON_QUERY_ARRAY(l, '$.properties')) AS p WITH OFFSET AS pi"
        + where;
  }

  private static void dryRun(String sql) {
    Job job =
        bigQuery.create(
            JobInfo.of(
                QueryJobConfiguration.newBuilder(sql)
                    .setDryRun(true)
                    .setUseLegacySql(false)
                    .build()));
    QueryStatistics stats = job.getStatistics();
    Schema schema = stats.getSchema();
    if (schema == null) {
      log("  RESULT: dry run OK, schema=null, statementType=" + stats.getStatementType());
      return;
    }
    log("  RESULT: dry run OK, " + schema.getFields().size() + " fields");
    for (Field f : schema.getFields()) {
      log("    " + f.getName() + " " + f.getType() + " " + f.getMode() + desc(f));
    }
  }

  private static String desc(Field f) {
    return f.getDescription() == null ? "" : " desc=" + f.getDescription();
  }

  private static void dumpQuery(String sql) throws Exception {
    try (Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
      dumpResultSet(rs, 50);
    }
  }

  private static void dumpRsmd(ResultSetMetaData md) throws Exception {
    log("  RESULT: " + md.getColumnCount() + " columns");
    for (int i = 1; i <= md.getColumnCount(); i++) {
      log(
          "    "
              + i
              + " "
              + md.getColumnName(i)
              + " typeName="
              + md.getColumnTypeName(i)
              + " jdbcType="
              + md.getColumnType(i)
              + " nullable="
              + md.isNullable(i));
    }
  }

  private static List<List<String>> dumpResultSet(ResultSet rs, int maxRows) throws Exception {
    List<List<String>> rows = new ArrayList<>();
    try (ResultSet r = rs) {
      ResultSetMetaData md = r.getMetaData();
      int n = md.getColumnCount();
      StringBuilder header = new StringBuilder("    columns:");
      for (int i = 1; i <= n; i++) {
        header.append(' ').append(md.getColumnName(i)).append(':').append(md.getColumnTypeName(i));
      }
      log(header.toString());
      while (r.next()) {
        List<String> row = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
          row.add(r.getString(i));
        }
        rows.add(row);
        if (rows.size() <= maxRows) {
          log("    " + row);
        }
      }
    }
    log("  RESULT: " + rows.size() + " rows");
    return rows;
  }

  private static void probe(String id, String what, Probe p) {
    log("\n[" + id + "] " + what);
    try {
      p.run();
    } catch (Throwable t) {
      log("  RESULT: ERROR " + describe(t));
    }
  }

  private static String describe(Throwable t) {
    StringBuilder sb = new StringBuilder();
    int depth = 0;
    while (t != null && depth++ < 4) {
      sb.append(depth > 1 ? " <- " : "")
          .append(t.getClass().getSimpleName())
          .append(": ")
          .append(t.getMessage());
      t = t.getCause();
    }
    return sb.toString();
  }

  private static String join(String... parts) {
    return String.join(", ", parts);
  }

  private static List<String> head(List<String> l, int n) {
    return l.subList(0, Math.min(n, l.size()));
  }

  private static void section(String title) {
    log("\n==================== " + title + " ====================");
  }

  private static synchronized void log(String s) {
    REPORT.append(s).append('\n');
  }
}
