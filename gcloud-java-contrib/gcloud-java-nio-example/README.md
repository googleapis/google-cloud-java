Example of adding the Google Cloud Storage NIO Provider to a legacy jar
=======================================================================

This project shows how to add GCS capabilities to a jar file for a Java 7 application
that uses Java NIO but that you cannot recompile.

Note that whenever possible, you instead want to recompile the app and use the normal
dependency mechanism to add a dependency to gcloud-java-nio. You can see examples of
this in the [gcloud-java-examples](../../gcloud-java-examples) project.

To run this example:

1. Before running the example, go to the [Google Developers Console][developers-console] to ensure that Google Cloud Storage API is enabled and that you have a bucket with a file in it.

2. Log in using gcloud SDK (`gcloud auth login` in command line)

3. Compile the JAR with:
    ```
    mvn package -DskipTests -Dmaven.javadoc.skip=true  -Dmaven.source.skip=true
    ```

4.    Run the sample with:

    ```
    java -cp gcloud-java-contrib/gcloud-java-nio/target/gcloud-java-nio-0.1.6-SNAPSHOT-shaded.jar:gcloud-java-contrib/gcloud-java-nio-example/target/gcloud-java-nio-example-0.1.6-SNAPSHOT.jar com.google.gcloud.nio.example.Stat --check
    ```
    Or, if you have a file in `gs://mybucket/myfile.txt`, you can run:
    ```
    java -cp gcloud-java-contrib/gcloud-java-nio/target/gcloud-java-nio-0.1.6-SNAPSHOT-shaded.jar:gcloud-java-contrib/gcloud-java-nio-example/target/gcloud-java-nio-example-0.1.6-SNAPSHOT.jar com.google.gcloud.nio.example.Stat gs://mybucket/myfile.txt
    ```

The sample doesn't have anything about GCS in it. It gets that ability from the nio jar that
we're adding to the classpath. You can use the nio "fat shaded" jar for this purpose as it also
includes the dependencies for gcloud-java-nio.

If you have access to a project's source code you can also simply add gcloud-java-nio as
a dependency and let Maven pull in the required dependencies (this is what the nio unit tests do).
This approach is preferable as the fat jar approach may waste memory on multiple copies of dependencies.
