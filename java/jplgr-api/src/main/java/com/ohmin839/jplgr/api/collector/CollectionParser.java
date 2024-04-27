package com.ohmin839.jplgr.api.collector;

import java.util.List;
import java.util.LinkedList;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.support.ValueStack;

@BuildParseTree
public class CollectionParser extends BaseParser<List<String>> {
    public Rule InputLine() {
        return Sequence(
            OneOrMore(
                FirstOf(Word(),
                ANY)
            ),
            EOI
        );
    }
    Rule Word() {
        return Sequence(
            Sequence(
                OneOrMore(Alphabet()),
                Optional(String("'"))
            ),
            pushList()
        );
    }
    Rule Alphabet() {
        return FirstOf(
            LargeAlpha(),
            LargeEpsilon(),
            LargeEta(),
            LargeIota(),
            LargeOmicron(),
            LargeUpsilon(),
            LargeOmega(),
            LargeRho(),
            LargeConsonant(),
            SmallAlpha(),
            SmallEpsilon(),
            SmallEta(),
            SmallIota(),
            SmallOmicron(),
            SmallUpsilon(),
            SmallOmega(),
            SmallRho(),
            SmallConsonant()
        );
    }
    Rule LargeAlpha() {
        return AnyOf("ΑἈἌᾌἊᾊἎᾎᾈἉἍᾍἋᾋᾋἏᾉΆᾺᾼ");
    }
    Rule LargeEpsilon() {
        return AnyOf("ΕἘἜἚἙἝἛΈῈ");
    }
    Rule LargeEta() {
        return AnyOf("ΗἨἬᾜἪᾚἮᾞᾘἩἭᾝἫᾛᾛἯᾙΉῊῌ");
    }
    Rule LargeIota() {
        return AnyOf("ΙἸἼἺἾἹἽἻἿΊῚΪ");
    }
    Rule LargeOmicron() {
        return AnyOf("ΟὈὌὊὉὍὋΌῸ");
    }
    Rule LargeUpsilon() {
        return AnyOf("ΥὙὝὛὟΎῪΫ");
    }
    Rule LargeOmega() {
        return AnyOf("ΩὨὬᾬὪᾪὮᾮᾨὩὭᾭὫᾫᾫὯᾩΏῺῼ");
    }
    Rule LargeRho() {
        return AnyOf("ΡῬ");
    }
    Rule LargeConsonant() {
        return AnyOf("ΒΓΔΖΘΚΛΜΝΞΠΣΤΦΧΨ");
    }

    Rule SmallAlpha() {
        return AnyOf("αἀἄᾄἂᾂἆᾆᾀἁἅᾅἃᾃᾃἇᾁάᾴὰᾲᾶᾷᾳ");
    }
    Rule SmallEpsilon() {
        return AnyOf("εἐἔἒἑἕἓέὲ");
    }
    Rule SmallEta() {
        return AnyOf("ηἠἤᾔἢᾒἦᾖᾐἡἥᾕἣᾓᾓἧᾑήῄὴῂῆῇῃ");
    }
    Rule SmallIota() {
        return AnyOf("ιἰἴἲἶἱἵἳἷίὶῖϊΐῒῗ");
    }
    Rule SmallOmicron() {
        return AnyOf("οὀὄὂὁὅὃόὸ");
    }
    Rule SmallUpsilon() {
        return AnyOf("υὐὔὒὖὑὕὓὗύὺῦϋΰῢῧ");
    }
    Rule SmallOmega() {
        return AnyOf("ωὠὤᾤὢᾢὦᾦᾠὡὥᾥὣᾣᾣὧᾡώῴὼῲῶῷῳ");
    }
    Rule SmallRho() {
        return AnyOf("ρῤῥ");
    }
    Rule SmallConsonant() {
        return AnyOf("βγδζθκλμνξπσςτφχψ");
    }

    boolean pushList() {
        ValueStack<List<String>> stack = getContext().getValueStack();
        if (stack.isEmpty()) {
            List<String> list = new LinkedList<>();
            list.add(match());
            stack.push(list);
        } else {
            List<String> list = stack.peek();
            list.add(match());
        }
        return true;
    }    
}
