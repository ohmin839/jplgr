import static com.ohmin839.jplgr.api.JplgrApi.toPolytonicText
import static com.ohmin839.jplgr.api.JplgrApi.toPolytonicWordList

converted = toPolytonicText "<o >'anthr^op'os tis"
split = toPolytonicWordList converted
println split // [ὁ, ἄνθρωπός, τις]
