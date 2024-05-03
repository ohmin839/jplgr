# jplgr-api
`jplgr-api` provides minimum APIs.

## Conversion API
`toPolytonicText` function converts ASCII strings into strings in polytonic Greek.
```java
import static com.ohmin839.jplgr.api.JplgrApi.toPolytonicText;

String converted = toPolytonicText(">'anthr^opos");
System.out.println(converted); // ἄνθρωπος
```

## Collection API
`toPolytonicWordList` function splits texts in polytonic Greek into words:
```java
import static com.ohmin839.jplgr.api.JplgrApi.toPolytonicText;
import static com.ohmin839.jplgr.api.JplgrApi.toPolytonicWordList;

String converted = toPolytonicText("ὁ ἄνθρωπός τις");
List<String> split = toPolytonicWordList(converted);
System.out.println(split); // [ὁ, ἄνθρωπός, τις]
```

## Conversion Rules
(Under construction)