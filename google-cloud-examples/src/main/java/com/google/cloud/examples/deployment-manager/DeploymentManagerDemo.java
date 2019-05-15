/*
Copyright 2019 Google LLC. This software is provided as-is, without warranty or representation for any use or purpose. Your use of it is subject to your agreement with Google.
 */
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.deploymentmanager.DeploymentManager;
import com.google.api.services.deploymentmanager.model.*;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DeploymentManagerDemo {

    private static String PROJECTID = "project-id";
    private static String CONFIG_YAML = "/path/to/deployment-manager-config.yaml";

    // authentication uses the GOOGLE_APPLICATION_CREDENTIALS environemnt variable.
    // run `gcloud auth application-default login` to create/update the file locally

    // in intellij you can set this in the runtime config next to the run button
    // private static String GOOGLE_APPLICATION_CREDENTIALS="/path/to/application_default_credentials.json";

    // javadoc reference for deployment manger is here
    // https://developers.google.com/resources/api-libraries/documentation/deploymentmanager/v2/java/latest/
    public static void main(String args[]) throws GeneralSecurityException, IOException {

        System.out.println("GOOGLE_APPLICATION_CREDENTIALS: " + System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));


        // best practice is to use application default credential
        GoogleCredential credential = GoogleCredential.getApplicationDefault();

        // to load from somewhere else use this
        // GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(GOOGLE_APPLICATION_CREDENTIALS));


        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();


        DeploymentManager dm2 = new DeploymentManager.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName("New_Application")
                .build();

        Deployment deploy = new Deployment();
        // Optional  we want some labels: Map of labels; provided by the client when the resource is created or updated.
        List<DeploymentLabelEntry> labels = new ArrayList<DeploymentLabelEntry>();


        labels.add(new DeploymentLabelEntry()
                .setKey("test-label-1")
                .setValue("good-fella"));

        deploy.setLabels(labels);


        // load the config file contents and setup target conrfiguration
        ConfigFile config = new ConfigFile()
                .setContent(readYaml());


        TargetConfiguration target = new TargetConfiguration()
                .setConfig(config);

        deploy.setTarget(target);
        deploy.setName("my-deployment");


        List<Deployment> deployments =
                dm2.deployments()
                        .list(PROJECTID)
                        .execute()
                        .getDeployments();

        boolean insert = true;
        for (Deployment deployment : deployments)
        {
            String deploymentName = deployment.getName();
            if (deploymentName.compareTo("my-deployment") == 0) {
             insert=false;
            }
        }

        if (insert) {
            dm2.deployments()
                    .insert(PROJECTID, deploy)
                    .execute();
        }
        else {
            dm2.deployments()
                    .update(PROJECTID, "my-deployment", deploy)
                    .execute();
        }
    }

    private static String readYaml() throws IOException {
        InputStream is = new FileInputStream(CONFIG_YAML);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){ sb.append(line).append("\n"); line = buf.readLine(); }
        return  sb.toString();

    }
}
