echo "Post Create Starting"

mvn clean install -B -V -ntp \
    -DskipTests=true \
    -Dmaven.javadoc.skip=true \
    -Dclirr.skip=true
