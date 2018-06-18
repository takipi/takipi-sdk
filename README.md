# Takipi SDK

## Deploying

To use, add the following repository to your maven `pom.xml`...

```xml
<repositories>
    <repository>
        <id>bintray-takipi-maven</id>
        <url>https://dl.bintray.com/takipi/maven</url>
    </repository>
</repositories>
```

Then, add the Takipi SDK dependency...

```xml
<dependency>
    <groupId>com.takipi</groupId>
    <artifactId>takipi-sdk</artifactId>
    <version>0.2.0</version>
</dependency>
```

Additional information can be found here https://bintray.com/takipi/maven/takipi-sdk

## Integrating
The SDK can be used to create custom events inside your application.  See the sample Java code below:

```java


import com.takipi.sdk.v1.api.Takipi;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;

public class CustomEventService {


    private static final Takipi takipi = Takipi.create("CUSTOM_EVENT_SERVICE");


    public void doSomethingImportant() {

        TakipiEvent customEvent = takipi.events().createEvent("Important Custom Event");

        customEvent.fire();

    }
}

```

## Building

To build:
- `mvn clean package`

