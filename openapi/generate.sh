openapi-generator batch openapi/generators/spring-boot.yaml
cd out/spring-boot
mvn com.coveo:fmt-maven-plugin:format source:jar-no-fork javadoc:jar install