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

import java.sql.*;
import java.util.*;

public class JDBCClient {
    public static void main(String[] args) throws Exception {
        String url = null;
        String driverClass = "com.google.cloud.bigquery.jdbc.BigQueryDriver";
        String action = null;
        String query = null;
        boolean noOutput = false;
        int generateRows = 0;
        int generateCols = 5;
        String metadataMethod = "getTables";
        String catalog = null;
        String schema = null;
        String table = null;
        String typesStr = null;

        Map<String, String> extraArgs = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("--")) {
                String key = arg.substring(2);
                String val = "";
                if (key.contains("=")) {
                    String[] parts = key.split("=", 2);
                    key = parts[0];
                    val = parts[1];
                } else if (i + 1 < args.length && !args[i+1].startsWith("-")) {
                    val = args[i+1];
                    i++;
                }
                
                switch (key) {
                    case "url": url = val; break;
                    case "driver-class": driverClass = val; break;
                    case "action": action = val; break;
                    case "query": query = val; break;
                    case "no-output": noOutput = true; break;
                    case "generate-rows": generateRows = Integer.parseInt(val); break;
                    case "generate-cols": generateCols = Integer.parseInt(val); break;
                    case "metadata-method": metadataMethod = val; break;
                    case "catalog": catalog = val; break;
                    case "schema": schema = val; break;
                    case "table": table = val; break;
                    case "types": typesStr = val; break;
                    default: extraArgs.put(key, val); break;
                }
            }
        }

        if (url == null || action == null) {
            System.err.println("Error: --url and --action are required.");
            System.exit(1);
        }

        StringBuilder sb = new StringBuilder(url);
        if (!url.endsWith(";")) sb.append(";");
        for (Map.Entry<String, String> entry : extraArgs.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
        }
        String finalUrl = sb.toString();

        System.out.println("Final Connection String: " + finalUrl);
        System.out.println("Driver Class: " + driverClass);

        Class.forName(driverClass);

        long startE2E = System.currentTimeMillis();
        Connection conn = DriverManager.getConnection(finalUrl);
        System.out.println("Connection successful.\n");

        if ("query".equals(action)) {
            if (generateRows > 0) {
                query = generateDataQuery(generateRows, generateCols);
            }
            if (query == null) {
                System.err.println("Error: --query or --generate-rows is required when action is 'query'");
                System.exit(1);
            }
            warmup(conn);
            runQuery(conn, query, noOutput);
        } else if ("metadata".equals(action)) {
            String[] types = typesStr != null ? typesStr.split(",") : null;
            runMetadata(conn, metadataMethod, catalog, schema, table, types);
        }

        conn.close();
        long e2eTime = System.currentTimeMillis() - startE2E;
        System.out.println("Total e2e time: " + (e2eTime / 1000.0) + " seconds");
    }

    private static void warmup(Connection conn) {
        System.out.println("Performing warmup query...");
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("SELECT 1");
            try (ResultSet rs = stmt.getResultSet()) {
                while (rs.next()) {
                    rs.getObject(1);
                }
            }
        } catch (Exception e) {
            System.err.println("Warning: Warmup query failed: " + e.getMessage());
        }
        System.out.println("Warmup complete.\n");
    }

    private static String generateDataQuery(int rows, int cols) {
        int N = (int) Math.ceil(Math.sqrt(rows));
        String idxExpr = "(i - 1) * " + N + " + j";
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append(idxExpr).append(" AS idx");
        for (int k = 1; k < cols; k++) {
            sb.append(", CONCAT('val_', ").append(idxExpr).append(") AS col").append(k);
        }
        sb.append(" FROM UNNEST(GENERATE_ARRAY(1, ").append(N).append(")) AS i");
        sb.append(" CROSS JOIN UNNEST(GENERATE_ARRAY(1, ").append(N).append(")) AS j");
        sb.append(" LIMIT ").append(rows);
        
        return sb.toString();
    }

    private static void runQuery(Connection conn, String query, boolean noOutput) throws Exception {
        System.out.println("Executing query: " + query);
        
        long startExec = System.currentTimeMillis();
        Statement stmt = conn.createStatement();
        boolean hasResultSet = stmt.execute(query);
        long execTime = System.currentTimeMillis() - startExec;

        if (!hasResultSet) {
            System.out.println("Query executed but returned no results.");
            return;
        }

        long startFetch = System.currentTimeMillis();
        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData rsMeta = rs.getMetaData();
        int colCount = rsMeta.getColumnCount();

        if (!noOutput) {
            for (int i = 1; i <= colCount; i++) {
                System.out.print(rsMeta.getColumnName(i) + " [" + rsMeta.getColumnTypeName(i) + "]");
                if (i < colCount) System.out.print(" | ");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }

        int rowCount = 0;
        Object[] row = new Object[colCount];
        while (rs.next()) {
            rowCount++;
            for (int i = 1; i <= colCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            if (!noOutput) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < colCount; i++) {
                    sb.append(row[i]);
                    if (i < colCount - 1) {
                        sb.append(" | ");
                    }
                }
                System.out.println(sb.toString());
            }
        }
        long fetchTime = System.currentTimeMillis() - startFetch;

        System.out.println("\nMetrics:");
        System.out.println("  Rows retrieved: " + rowCount);
        System.out.println("  Values retrieved: " + (long) rowCount * colCount);
        System.out.println("  Execution time: " + (execTime / 1000.0) + " seconds");
        System.out.println("  Fetch time: " + (fetchTime / 1000.0) + " seconds");

        rs.close();
        stmt.close();
    }

    private static void runMetadata(Connection conn, String method, String catalog, String schema, String table, String[] types) throws Exception {
        DatabaseMetaData dbMeta = conn.getMetaData();
        System.out.println("Executing metadata method: " + method);
        
        ResultSet rs = null;
        Object result = null;
        
        if ("getTables".equals(method)) {
            rs = dbMeta.getTables(catalog, schema, table, types);
        } else if ("getColumns".equals(method)) {
            rs = dbMeta.getColumns(catalog, schema, table, null);
        } else if ("getSchemas".equals(method)) {
            rs = dbMeta.getSchemas(catalog, schema);
        } else if ("getCatalogs".equals(method)) {
            rs = dbMeta.getCatalogs();
        } else if ("getTableTypes".equals(method)) {
            rs = dbMeta.getTableTypes();
        } else if ("getTypeInfo".equals(method)) {
            rs = dbMeta.getTypeInfo();
        } else {
            try {
                java.lang.reflect.Method m = DatabaseMetaData.class.getMethod(method);
                result = m.invoke(dbMeta);
            } catch (NoSuchMethodException e) {
                System.err.println("Error: Method '" + method + "' not supported or found.");
                return;
            }
        }

        if (rs != null) {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            
            for (int i = 1; i <= colCount; i++) {
                System.out.print(rsMeta.getColumnName(i));
                if (i < colCount) System.out.print(" | ");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------");

            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getObject(i));
                    if (i < colCount) System.out.print(" | ");
                }
                System.out.println();
            }
            System.out.println("\n(" + rowCount + " rows)");
            rs.close();
        } else if (result != null) {
            System.out.println("Result: " + result);
        } else {
             System.out.println("Method returned null or void.");
        }
    }
}
