package com.google.cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MetadataConfig {

    private static final String metadataUrl = "http://metadata/computeMetadata/v1/";

    public static String getProjectId() {
        return getProjectAttribute("project-id");
    }

    public static String getZone() {
        String zoneId = getInstanceAttribute("zone");
        if (zoneId.contains("/")) {
            return zoneId.substring(zoneId.lastIndexOf('/') + 1);
        }
        return zoneId;
    }

    public static String getInstanceId() {
        return getInstanceAttribute("id");
    }

    private static String getProjectAttribute(String attributeName) {
        return getAttribute("project/", attributeName);
    }

    private static String getInstanceAttribute(String attributeName) {
        return getAttribute("instance/", attributeName);
    }

    private static String getAttribute(String prefix, String attributeName) {
        try {
            URL url = new URL(metadataUrl + prefix + attributeName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Metadata-Flavor", "Google");
            InputStream input = connection.getInputStream();
            if (connection.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, UTF_8))) {
                    return reader.readLine();
                }
            }
        } catch (IOException ignore) {
            // ignore
        }
        return null;
    }
}
