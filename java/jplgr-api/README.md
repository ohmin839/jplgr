# jplgr-api
`jplgr-api` provides minimum APIs.

## Conversion API
`toPolytonicText` function converts ASCII strings into strings in polytonic Greek.
```java
String converted = JplgrApi.toPolytonicText(">'anthr^opos");
System.out.println(converted); // ἄνθρώπός
```

## Collection API
`toPolytonicWordList` function splits texts in polytonic Greek into words:
```java
String converted = JplgrApi.toPolytonicText("ὁ ἄνθρώπός τις");
List<String> split = JplgrApi.toPolytonicWordList(converted);
System.out.println(split); // [ὁ, ἄνθρώπός, τις]
```

## Conversion Rules
(Under construction)