package com.ohmin839.jplgr.api.converter;

import java.util.LinkedList;
import java.util.List;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.support.ValueStack;

@BuildParseTree
public class ConversionParser extends BaseParser<String> {
    public Rule InputLine() {
        return Sequence(Letters(), EOI);
    }
    Rule Letters() {
        return Sequence(
            OneOrMore(Letter()),
            push(joinLetters(getContext().getValueStack()))
        );
    } 
    Rule Letter() {
        return FirstOf(
            Alphabet(),
            Punctuation(),
            AnyChar()
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
            LargeBeta(),
            LargeGamma(),
            LargeDelta(),
            LargeZeta(),
            LargeKappa(),
            LargeLambda(),
            LargeMu(),
            LargeNu(),
            LargeXi(),
            LargePi(),
            LargeRho(),
            LargeSigma(),
            LargeTau(),
            SmallAlpha(),
            SmallEpsilon(),
            SmallEta(),
            SmallIota(),
            SmallOmicron(),
            SmallUpsilon(),
            SmallOmega(),
            SmallBeta(),
            SmallGamma(),
            SmallDelta(),
            SmallZeta(),
            SmallKappa(),
            SmallLambda(),
            SmallMu(),
            SmallNu(),
            SmallXi(),
            SmallPi(),
            SmallRho(),
            SmallSigma(),
            SmallTau()
        );
    }
    Rule LargeAlpha() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("A"),
                Optional(String("|"))
            ),
            push(convertLargeAlpha(match()))
        );
    }
    Rule LargeEpsilon() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`")),
                String("E")
            ),
            push(convertLargeEpsilon(match()))
        );
    }
    Rule LargeEta() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("^E"),
                Optional(String("|"))
            ),
            push(convertLargeEta(match()))
        );
    }
    Rule LargeIota() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>\"")),
                Optional(AnyOf("'`~")),
                String("I")
            ),
            push(convertLargeIota(match()))
        );
    }
    Rule LargeOmicron() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`")),
                String("O")
            ),
            push(convertLargeOmicron(match()))
        );
    }
    Rule LargeUpsilon() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>\"")),
                Optional(AnyOf("'`~")),
                AnyOf("UY")
            ),
            push(convertLargeUpsilon(match()))
        );
    }
    Rule LargeOmega() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("^O"),
                Optional(String("|"))
            ),
            push(convertLargeOmega(match()))
        );
    }
    Rule LargeBeta() {
        return Sequence(
            String("B"),
            push(convertLargeBeta())
        );
    }
    Rule LargeGamma() {
        return Sequence(
            String("G"),
            push(convertLargeGamma())
        );
    }
    Rule LargeDelta() {
        return Sequence(
            String("D"),
            push(convertLargeDelta())
        );
    }
    Rule LargeZeta() {
        return Sequence(
            String("Z"),
            push(convertLargeZeta())
        );
    }
    Rule LargeKappa() {
        return Sequence(
            Sequence(
                String("K"),
                Optional(String("h"))
            ),
            push(convertLargeKappa(match()))
        );
    }
    Rule LargeLambda() {
        return Sequence(
            String("L"),
            push(convertLargeLambda())
        );
    }
    Rule LargeMu() {
        return Sequence(
            String("M"),
            push(convertLargeMu())
        );
    }
    Rule LargeNu() {
        return FirstOf(
            LargeNasableGamma(),
            LargeSingleNu()
        );
    }
    Rule LargeNasableGamma() {
        return Sequence(
            Sequence(
                String("N"),
                FirstOf(
                    LargeGamma(),
                    LargeKappa(),
                    LargeXi()
                )
            ),
            push(convertLargeGamma() + pop())
        );
    }
    Rule LargeSingleNu() {
        return Sequence(
            String("N"),
            push(convertLargeNu())
        );
    }
    Rule LargeXi() {
        return Sequence(
            String("X"),
            push(convertLargeXi())
        );
    }
    Rule LargePi() {
        return Sequence(
            Sequence(
                String("P"),
                Optional(AnyOf("hs"))
            ),
            push(convertLargePi(match()))
        );
    }
    Rule LargeRho() {
        return Sequence(
            Sequence(
                Optional(String("<")),
                String("R")
            ),
            push(convertLargeRho(match()))
        );
    }
    Rule LargeSigma() {
        return Sequence(
            String("S"),
            push(convertLargeSigma())
        );
    }
    Rule LargeTau() {
        return Sequence(
            Sequence(
                String("T"),
                Optional(String("h"))
            ),
            push(convertLargeTau(match()))
        );
    }

    Rule SmallAlpha() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("a"),
                Optional(String("|"))
            ),
            push(convertSmallAlpha(match()))
        );
    }
    Rule SmallEpsilon() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`")),
                String("e")
            ),
            push(convertSmallEpsilon(match()))
        );
    }
    Rule SmallEta() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("^e"),
                Optional(String("|"))
            ),
            push(convertSmallEta(match()))
        );
    }
    Rule SmallIota() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>\"")),
                Optional(AnyOf("'`~")),
                String("i")
            ),
            push(convertSmallIota(match()))
        );
    }
    Rule SmallOmicron() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`")),
                String("o")
            ),
            push(convertSmallOmicron(match()))
        );
    }
    Rule SmallUpsilon() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>\"")),
                Optional(AnyOf("'`~")),
                AnyOf("uy")
            ),
            push(convertSmallUpsilon(match()))
        ); 
    }
    Rule SmallOmega() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                Optional(AnyOf("'`~")),
                String("^o"),
                Optional(String("|"))
            ),
            push(convertSmallOmega(match()))
        );
    }
    Rule SmallBeta() {
        return Sequence(
            String("b"),
            push(convertSmallBeta())
        );
    }
    Rule SmallGamma() {
        return Sequence(
            String("g"),
            push(convertSmallGamma())
        );
    }
    Rule SmallDelta() {
        return Sequence(
            String("d"),
            push(convertSmallDelta())
        );
    }
    Rule SmallZeta() {
        return Sequence(
            String("z"),
            push(convertSmallZeta())
        );
    }
    Rule SmallKappa() {
        return Sequence(
            Sequence(
                String("k"),
                Optional(String("h"))
            ),
            push(convertSmallKappa(match()))
        );
    }
    Rule SmallLambda() {
        return Sequence(
            String("l"),
            push(convertSmallLambda())
        );
    }
    Rule SmallMu() {
        return Sequence(
            String("m"),
            push(convertSmallMu())
        );
    }
    Rule SmallNu() {
        return FirstOf(
            SmallNasableGamma(),
            SmallSingleNu()
        );
    }
    Rule SmallNasableGamma() {
        return Sequence(
            Sequence(
                String("n"),
                FirstOf(
                    SmallGamma(),
                    SmallKappa(),
                    SmallXi()
                )
            ),
            push(convertSmallGamma() + pop())
        );
    }
    Rule SmallSingleNu() {
        return Sequence(
            String("n"),
            push(convertSmallNu())
        );
    }
    Rule SmallXi() {
        return Sequence(
            String("x"),
            push(convertSmallXi())
        );
    }
    Rule SmallPi() {
        return Sequence(
            Sequence(
                String("p"),
                Optional(AnyOf("hs"))
            ),
            push(convertSmallPi(match()))
        );
    }
    Rule SmallRho() {
        return Sequence(
            Sequence(
                Optional(AnyOf("<>")),
                String("r")
            ),
            push(convertSmallRho(match()))
        );
    }
    Rule SmallSigma() {
        return FirstOf(
            SmallLeadingSigma(),
            SmallSingleSigma()
        );
    }
    Rule SmallLeadingSigma() {
        return Sequence(
            Sequence(
                String("s"),
                Alphabet()
            ),
            push(convertLeadingSigma() + pop())
        );
    }
    Rule SmallSingleSigma() {
        return Sequence(
            AnyOf("cs"),
            push(convertSmallSigma(match()))
        );
    }
    Rule SmallTau() {
        return Sequence(
            Sequence(
                String("t"),
                Optional(String("h"))
            ),
            push(convertSmallTau(match()))
        );
    }

    Rule Punctuation() {
        return FirstOf(
            Semicoron(),
            Question()
        );
    }
    Rule Semicoron() {
        return Sequence(
            String(";"),
            push(convertSemicoron())
        );
    }
    Rule Question() {
        return Sequence(
            String("?"),
            push(convertQuestion())
        );
    }

    Rule AnyChar() {
        return Sequence(
            ANY,
            push(match())
        );
    }

    String joinLetters(ValueStack<String> stack) {
        List<String> chanks = new LinkedList<>();
        while (!stack.isEmpty()) {
            chanks.add(0, stack.pop());
        }
        return String.join("", chanks);
    }
    String convertLargeAlpha(String text) {
        int score = calcScore(text);
        switch (score) {
            case  1: return "\u1FBC"; // A|
            case  4: return "\u1FBB"; // 'A
            // case  5: return "\xxxxx"; // 'A|
            case  8: return "\u1FBA"; // `A
            // case  9: return "\xxxxx"; // `A|
            // case 12: return "\xxxxx"; // ~A
            // case 13: return "\xxxxx"; // ~A|
            case 16: return "\u1F09"; // <A
            case 17: return "\u1F89"; // <A|
            case 20: return "\u1F0D"; // <'A
            case 21: return "\u1F8D"; // <'A|
            case 24: return "\u1F0B"; // <`A
            case 25: return "\u1F8B"; // <`A|
            case 28: return "\u1F0F"; // <~A
            case 29: return "\u1F8F"; // <`A|
            case 32: return "\u1F08"; // >A
            case 33: return "\u1F88"; // >A|
            case 36: return "\u1F0C"; // >'A
            case 37: return "\u1F8C"; // >'A|
            case 40: return "\u1F0A"; // >`A
            case 41: return "\u1F8A"; // >`A|
            case 44: return "\u1F0E"; // >~A
            case 45: return "\u1F8E"; // >~A|
            default: return "\u0391"; // A        
        }
    }
    String convertLargeEpsilon(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1FC9"; // 'E
            case  8: return "\u1FC8"; // `E
            case 16: return "\u1F19"; // <E
            case 20: return "\u1F1D"; // <'E
            case 24: return "\u1F1B"; // <`E
            case 32: return "\u1F18"; // >E
            case 36: return "\u1F1C"; // >'E
            case 40: return "\u1F1A"; // >`E
            default: return "\u0395"; // E        
        }
    }
    String convertLargeEta(String text) {
        int score = calcScore(text);
        switch (score) {
            case  1: return "\u1FCC"; // ^E|
            case  4: return "\u1FCB"; // '^E
            // case  5: return "\xxxxx"; // '^E|
            case  8: return "\u1FCA"; // `^E
            // case  9: return "\xxxxx"; // `^E|
            // case 12: return "\xxxxx"; // ~^E
            // case 13: return "\xxxxx"; // ~^E|
            case 16: return "\u1F29"; // <^E
            case 17: return "\u1F99"; // <^E|
            case 20: return "\u1F2D"; // <'^E
            case 21: return "\u1F9D"; // <'^E|
            case 24: return "\u1F2B"; // <`^E
            case 25: return "\u1F9B"; // <`^E|
            case 28: return "\u1F2F"; // <~^E
            case 29: return "\u1F9F"; // <`^E|
            case 32: return "\u1F28"; // >^E
            case 33: return "\u1F98"; // >^E|
            case 36: return "\u1F2C"; // >'^E
            case 37: return "\u1F9C"; // >'^E|
            case 40: return "\u1F2A"; // >`^E
            case 41: return "\u1F9A"; // >`^E|
            case 44: return "\u1F2E"; // >~^E
            case 45: return "\u1F9E"; // >~^E|
            default: return "\u0397"; // ^E
        }
    }
    String convertLargeIota(String text) {
        int score = calcScore(text);
        switch (score) {
           case  4: return "\u1FDB"; // 'I
           case  8: return "\u1FDA"; // `I
           // case  12: return "\xxxxx"; // ~I
           case 16: return "\u1F39"; // <I
           case 20: return "\u1F3D"; // <'I
           case 24: return "\u1F3B"; // <`I
           case 28: return "\u1F3F"; // <~I
           case 32: return "\u1F38"; // >I
           case 36: return "\u1F3C"; // >'I
           case 40: return "\u1F3A"; // >`I
           case 44: return "\u1F3E"; // >~I
           case 64: return "\u03AA"; // "I
           default: return "\u0399"; // I
       }    
    }
    String convertLargeOmicron(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1FF9"; // 'O
            case  8: return "\u1FF8"; // `O
            case 16: return "\u1F49"; // <O
            case 20: return "\u1F4D"; // <'O
            case 24: return "\u1F4B"; // <`O
            case 32: return "\u1F48"; // >O
            case 36: return "\u1F4C"; // >'O
            case 40: return "\u1F4A"; // >`O
            default: return "\u039F"; // O
        }
    }
    String convertLargeUpsilon(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1FEB"; // 'Y
            case  8: return "\u1FEA"; // `Y
            // case  12: return "\xxxxx"; // ~Y
            case 16: return "\u1F59"; // <Y
            case 20: return "\u1F5D"; // <'Y
            case 24: return "\u1F5B"; // <`Y
            case 28: return "\u1F5F"; // <~Y
            case 64: return "\u03AB"; // "Y
            default: return "\u03A5"; // Y
        }
    }
    String convertLargeOmega(String text) {
        int score = calcScore(text);
        switch (score) {
            case  1: return "\u1FFC"; // ^O|
            case  4: return "\u1FFB"; // '^O
            // case  5: return "\xxxxx"; // '^O|
            case  8: return "\u1FFA"; // `^O
            // case  9: return "\xxxxx"; // `^O|
            // case 12: return "\xxxxx"; // ~^O
            // case 13: return "\xxxxx"; // ~^O|
            case 16: return "\u1F69"; // <^O
            case 17: return "\u1FA9"; // <^O|
            case 20: return "\u1F6D"; // <'^O
            case 21: return "\u1FAD"; // <'^O|
            case 24: return "\u1F6B"; // <`^O
            case 25: return "\u1FAB"; // <`^O|
            case 28: return "\u1F6F"; // <~^O
            case 29: return "\u1FAF"; // <`^O|
            case 32: return "\u1F68"; // >^O
            case 33: return "\u1FA8"; // >^O|
            case 36: return "\u1F6C"; // >'^O
            case 37: return "\u1FAC"; // >'^O|
            case 40: return "\u1F6A"; // >`^O
            case 41: return "\u1FAA"; // >`^O|
            case 44: return "\u1F6E"; // >~^O
            case 45: return "\u1FAE"; // >~^O|
            default: return "\u03A9"; // ^O
        }
    }
    String convertLargeBeta() {
        return "\u0392";
    }
    String convertLargeGamma() {
        return "\u0393";
    }
    String convertLargeDelta() {
        return "\u0394";
    }
    String convertLargeZeta() {
        return "\u0396";
    }
    String convertLargeKappa(String text) {
        if (text.contains("h")) {
            return "\u03A7"; // large khi
        } else {
            return "\u039A"; // large kappa
        }
    }
    String convertLargeLambda() {
        return "\u039B";
    }
    String convertLargeMu() {
        return "\u039C";
    }
    String convertLargeNu() {
        return "\u039D";
    }
    String convertLargeXi() {
        return "\u039E";
    }
    String convertLargePi(String text) {
        if (text.endsWith("h")) {
            return "\u03A6"; // large phi
        } else if (text.endsWith("s")) {
            return "\u03A8"; // large psi
        } else {
            return "\u03A0"; // large pi
        }
    }
    String convertLargeRho(String text) {
        int score = calcScore(text);
        switch (score) {
            case 16: return "\u1FEC"; // <R
            default: return "\u03A1"; // R
        }
    }
    String convertLargeSigma() {
        return "\u03A3";
    }
    String convertLargeTau(String text) {
        if (text.endsWith("h")) {
            return "\u0398"; // large theta
        } else {
            return "\u03A4"; // large tau
        }
    }

    String convertSmallAlpha(String text) {
        int score = calcScore(text);
        switch (score) {
            case  1: return "\u1FB3"; // a|
            case  4: return "\u1F71"; // 'a
            case  5: return "\u1FB4"; // 'a|
            case  8: return "\u1F70"; // `a
            case  9: return "\u1FB2"; // `a|
            case 12: return "\u1FB6"; // ~a
            case 13: return "\u1FB7"; // ~a|
            case 16: return "\u1F01"; // <a
            case 17: return "\u1F81"; // <a|
            case 20: return "\u1F05"; // <'a
            case 21: return "\u1F85"; // <'a|
            case 24: return "\u1F03"; // <`a
            case 25: return "\u1F83"; // <`a|
            case 28: return "\u1F07"; // <~a
            case 29: return "\u1F87"; // <`a|
            case 32: return "\u1F00"; // >a
            case 33: return "\u1F80"; // >a|
            case 36: return "\u1F04"; // >'a
            case 37: return "\u1F84"; // >'a|
            case 40: return "\u1F02"; // >`a
            case 41: return "\u1F82"; // >`a|
            case 44: return "\u1F06"; // >~a
            case 45: return "\u1F86"; // >~a|
            default: return "\u03B1"; // a
        }
    }
    String convertSmallEpsilon(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1F73"; // 'e
            case  8: return "\u1F72"; // `e
            case 16: return "\u1F11"; // <e
            case 20: return "\u1F15"; // <'e
            case 24: return "\u1F13"; // <`e
            case 32: return "\u1F10"; // >e
            case 36: return "\u1F14"; // >'e
            case 40: return "\u1F12"; // >`e
            default: return "\u03B5"; // e
        }
    }
    String convertSmallEta(String text) {
        int score = calcScore(text);
        switch (score) {
            case  1: return "\u1FC3"; // ^e|
            case  4: return "\u1F75"; // '^e
            case  5: return "\u1FC4"; // '^e|
            case  8: return "\u1F74"; // `^e
            case  9: return "\u1FC2"; // `^e|
            case 12: return "\u1FC6"; // ~^e
            case 13: return "\u1FC7"; // ~^e|
            case 16: return "\u1F21"; // <^e
            case 17: return "\u1F91"; // <^e|
            case 20: return "\u1F25"; // <'^e
            case 21: return "\u1F95"; // <'^e|
            case 24: return "\u1F23"; // <`^e
            case 25: return "\u1F93"; // <`^e|
            case 28: return "\u1F27"; // <~^e
            case 29: return "\u1F97"; // <`^e|
            case 32: return "\u1F20"; // >^e
            case 33: return "\u1F90"; // >^e|
            case 36: return "\u1F24"; // >'^e
            case 37: return "\u1F94"; // >'^e|
            case 40: return "\u1F22"; // >`^e
            case 41: return "\u1F92"; // >`^e|
            case 44: return "\u1F26"; // >~^e
            case 45: return "\u1F96"; // >~^e|
            default: return "\u03B7"; // ^e
        }
    }
    String convertSmallIota(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1F77"; // 'i
            case  8: return "\u1F76"; // `i
            case 12: return "\u1FD6"; // ~i
            case 16: return "\u1F31"; // <i
            case 20: return "\u1F35"; // <'i
            case 24: return "\u1F33"; // <`i
            case 28: return "\u1F37"; // <~i
            case 32: return "\u1F30"; // >i
            case 36: return "\u1F34"; // >'i
            case 40: return "\u1F32"; // >`i
            case 44: return "\u1F36"; // >~i
            case 64: return "\u03CA"; // "i
            case 68: return "\u1FD3"; // "'i
            case 72: return "\u1FD2"; // "`i
            case 76: return "\u1FD7"; // "~i
            default: return "\u03B9"; // i 
        }
    }
    String convertSmallOmicron(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1F79"; // 'o
            case  8: return "\u1F78"; // `o
            case 16: return "\u1F41"; // <o
            case 20: return "\u1F45"; // <'o
            case 24: return "\u1F43"; // <`o
            case 32: return "\u1F40"; // >o
            case 36: return "\u1F44"; // >'o
            case 40: return "\u1F42"; // >`o
            default: return "\u03BF"; // o
        }
    }
    String convertSmallUpsilon(String text) {
        int score = calcScore(text);
        switch (score) {
            case  4: return "\u1F7B"; // 'y
            case  8: return "\u1F7A"; // `y
            case 12: return "\u1FE6"; // ~y
            case 16: return "\u1F51"; // <y
            case 20: return "\u1F55"; // <'y
            case 24: return "\u1F53"; // <`y
            case 28: return "\u1F57"; // <~y
            case 32: return "\u1F50"; // >y
            case 36: return "\u1F54"; // >'y
            case 40: return "\u1F52"; // >`y
            case 44: return "\u1F56"; // >~y
            case 64: return "\u03CB"; // "y
            case 68: return "\u1FE3"; // "'y
            case 72: return "\u1FE2"; // "`y
            case 76: return "\u1FE7"; // "~y
            default: return "\u03C5"; // y
        }
    }
    String convertSmallOmega(String text) {
        int score  = calcScore(text);
        switch (score) {
            case  1: return "\u1FF3"; // ^o|
            case  4: return "\u1F7D"; // '^o
            case  5: return "\u1FF4"; // '^o|
            case  8: return "\u1F7C"; // `^o
            case  9: return "\u1FF2"; // `^o|
            case 12: return "\u1FF6"; // ~^o
            case 13: return "\u1FF7"; // ~^o|
            case 16: return "\u1F61"; // <^o
            case 17: return "\u1FA1"; // <^o|
            case 20: return "\u1F65"; // <'^o
            case 21: return "\u1FA5"; // <'^o|
            case 24: return "\u1F63"; // <`^o
            case 25: return "\u1FA3"; // <`^o|
            case 28: return "\u1F67"; // <~^o
            case 29: return "\u1FA7"; // <`^o|
            case 32: return "\u1F60"; // >^o
            case 33: return "\u1FA0"; // >^o|
            case 36: return "\u1F64"; // >'^o
            case 37: return "\u1FA4"; // >'^o|
            case 40: return "\u1F62"; // >`^o
            case 41: return "\u1FA2"; // >`^o|
            case 44: return "\u1F66"; // >~^o
            case 45: return "\u1FA6"; // >~^o|
            default: return "\u03C9"; // ^o
        }
    }
    String convertSmallBeta() {
        return "\u03B2";
    }
    String convertSmallGamma() {
        return "\u03B3";
    }
    String convertSmallDelta() {
        return "\u03B4";
    }
    String convertSmallZeta() {
        return "\u03B6";
    }
    String convertSmallKappa(String text) {
        if (text.contains("h")) {
            return "\u03C7"; // small khi
        } else {
            return "\u03BA"; // small kappa
        }
    }
    String convertSmallLambda() {
        return "\u03BB";
    }
    String convertSmallMu() {
        return "\u03BC";
    }
    String convertSmallNu() {
        return "\u03BD";
    }
    String convertSmallXi() {
        return "\u03BE";
    }
    String convertSmallPi(String text) {
        if (text.endsWith("h")) {
            return "\u03C6"; // small phi
        } else if (text.endsWith("s")) {
            return "\u03C8"; // small psi
        } else {
            return "\u03C0"; // small pi
        }
    }
    String convertSmallRho(String text) {
        int score = calcScore(text);
        switch (score) {
            case 16: return "\u1FE5";
            case 32: return "\u1FE4";
            default: return "\u03C1";
        }
    }
    String convertSmallSigma(String text) {
        if ("s".equals(text)) {
            return convertFinalSigma();
        } else {
            return convertLeadingSigma();
        }
    }
    String convertFinalSigma() {
        return "\u03C2";
    }
    String convertLeadingSigma() {
        return "\u03C3";
    }
    String convertSmallTau(String text) {
        if (text.endsWith("h")) {
            return "\u03B8"; // small theta
        } else {
            return "\u03C4"; // small tau
        }
    }

    int calcScore(String text) {
        return addScoreDialesis(text,
                addScoreBreath(text,
                addScoreAccent(text,
                addScoreIotaSubscriptum(text, 0))));
    }
    int addScoreDialesis(String text, int score) {
        if (text.contains("\"")) {
            return 64 + score;
        } else {
            return score;
        }
    }
    int addScoreBreath(String text, int score) {
        if (text.contains("<")) {
            return 16 + score;
        } else if (text.contains(">")) {
            return 32 + score;
        } else {
            return score;
        }
    }
    int addScoreAccent(String text, int score) {
        if (text.contains("'")) {
            return 4 + score;
        } else if (text.contains("`")) {
            return 8 + score;
        } else if (text.contains("~")) {
            return 12 + score;
        } else {
            return score;
        }
    }
    int addScoreIotaSubscriptum(String text, int score) {
        if (text.contains("|")) {
            return 1 + score;
        } else {
            return score;
        }
    }

    String convertSemicoron() {
        return "\u0387";
    }
    String convertQuestion() {
        return "\u037E";
    }
}
