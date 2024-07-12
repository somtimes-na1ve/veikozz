Please refer this pom setting in each module:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.cassell.veikozz</groupId>
      <artifactId>veikozz-bom</artifactId>
      <version>${revision}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```