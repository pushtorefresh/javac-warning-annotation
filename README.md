##Lightweight javac @Warning annotation

FAQ:

Q: ***What is @Warning annotation for?***

A: For throwing warning messages from java compiler (javac).

Q: ***When and why can you use it?***

A: When you want to mark some piece of code as "dangerous" or "unstable", etc. (Don't do it often)

Q: ***Why not to use // TODO or FIXME comments, etc?*** 

A: Because they don't throw compile time warnings by default (depends on IDE, settings, etc.)

Q: ***What is the size of the library?*** 

A: About 3kb, nothing for runtime, only two classes: @Warning annotation and annotation processor.

------------------------------
**Usage:**

```java
    // some code...
    
    @Warning("Add caching")
    public void getData() {
        // bad stuff going on here...
    }
```

###Download

Gradle:

```groovy
provided 'com.pushtorefresh:javac-warning-annotation:1.0.0'

// Library doesn't bring anything to the runtime
// So you can use provided scope instead of compile 
```

Maven:
```xml
<dependency>
  <groupId>com.pushtorefresh</groupId>
  <artifactId>javac-warning-annotation</artifactId>
  <version>1.0.0</version>
</dependency>
```

Or grab jar directly from [mavenCentral](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.pushtorefresh%22%20AND%20a%3A%22javac-warning-annotation%22)

------------------------------

Notice, if you use another annotation processors — you may need to exclude 
    
    'META-INF/services/javax.annotation.processing.Processor'
    
For Android Gradle setup in can be done like that:

build.gradle:
```groovy    
    android {
        
        // ...
        
        packagingOptions {
            exclude 'META-INF/services/javax.annotation.processing.Processor'
        }
    }
```
