package advance.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CounterType {

    // Function to validate the sentence length and word count
    public static boolean validateInput(String sentence) {
        // Check length constraint
        if (sentence.length() > 30000) {
            System.out.println("Error: Sentence exceeds 30,000 characters.");
            return false;
        }

        // Split sentence by one or more spaces
        String[] words = sentence.split("\\s+");

        // Check word count constraint
        if (words.length >= 1000) {
            System.out.println("Error: Sentence has more than 1000 words.");
            return false;
        }

        return true;  // All validations passed
    }

    // Function to count types
    public static void typeCounter(String sentence) {
        // Ensure input is valid before proceeding
        if (!validateInput(sentence)) {
            return; // Exit if validation fails
        }

        int stringCount = 0;
        int integerCount = 0;
        int doubleCount = 0;

        // Split the sentence by one or more spaces
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            boolean isNumeric = false;

            // Check for double first
            if (word.contains(".")) {
                try {
                    Double.parseDouble(word);  // Try parsing as a double
                    doubleCount++;
                    isNumeric = true;
                } catch (NumberFormatException e) {
                    // Not a valid double, continue to integer check
                }
            }

            // If not double, check for integer
            if (!isNumeric) {
                try {
                    Integer.parseInt(word);  // Try parsing as an integer
                    integerCount++;
                    isNumeric = true;
                } catch (NumberFormatException e) {
                    // Not a valid integer, proceed to string check
                }
            }

            // If not numeric, it's a string
            if (!isNumeric) {
                stringCount++;
            }
        }

        // Print the results in the specified order
        System.out.println("string " + stringCount);
        System.out.println("integer " + integerCount);
        System.out.println("double " + doubleCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine();
        System.out.println("sentence-->" + sentence );
        CounterType.typeCounter(sentence);
       

        bufferedReader.close();
        
        //sentence-->602436426 861648772 433933447.476190629 211047202.971407775 731963982.822804784 430302156.982631932 880895728.923078537 y 389872647 237336357.506215306 743167393 zotwflegsjzzszfwtzfpn guemwrczqxycivdqnkypnxnnpmuduhznoaquudhavrncwfwujpcmiggjmcmkkbnjfeodxkgjgwxtrxingiqquhuwqhdswxx 204276848.711107839 plwun 360472167 oildagktgdarveusjuqfistulgbglwmfgzrnyxryetwzhlnfewczmnoozlqatugmdjwgzcfabbkoxyjxkatjmpp 237204770.263034618 331076462 563141230.724965413 888013973.984208672 423181584.617946075 pigpbzuzoootorzfskcwbqorvwdrmklfdczatfarqdkelalxz 83003299.101430412 801006699.318863571 qlngdscrentzamztvvcvrtcmbqlizijdwtuyfrxolsysxlfebpolcmqsppmr 723473541 636973764.395943269 xsngxhwvroandfqja 278612959.745808855 22601660.449449056 569503054 831721123 iceahgiakevsjoadmkfnk 368799134.812811094 128792089.645010898 abzbrskzazjqtlkiqydptpkcsdgcqjshzndpvannrywfrnrghljjqrxpxnlkcwdpd 604110036.42073915 nwwyoosxtnexeezjxouyfjhnwpqfxexzxfolpcfblpncetyhtrwxkbosccskxbuvcrosavnpxzoeoyyghbbqkflsutpwmhqwkvi 774825524.380160{-truncated-}

        
        //sentence-->793572417 kqnosslqbfvvicxv uzruraetg 890472625.408307062 hfpn 911001199 618858820 245168157.842939383 936515617 hthulxarzhizeioepwbizhzkbdluytbvwvqipizqcwcajkufnqhmc 339845163.337193187 15053948 138197476 314104399.500007875 nnbugbmcthspxenwovywdfchidwcstlbocfzzyocnmgaaujtrlqsniflvehwyippbx 533468394.442174725 785607982.214832643 175053019 qpooptxemxkrxoihbokypcizinrxtbraxnmhkcsshguuatppf hnwpzukjybkkvrmmpueehkjyrcrkpkhtbfqpyvrcfqalhoikwfsqfstyfpraahxhjxvsscngggkgnh epguyavzcfdkqbcmgroidxrzyynhwcdiusriqsaowczwuuyelcxepxlwdcknmdxautbdnrahitqisznxnisyoorkepoprz 88039333.213832924 726306347 ssaimtlltgafhvlcciztdidxpwhdg 183845486.934435422 250171681 746567828.498183266 234684802.75253 400678452 822355211.844087409 788120120.225553574 888907132.997118836 glkickrgwolhoakatssjlitqzjfhdfzlmdadkyprfjsitgvqaiofzwnkpryckxsjozuinkhufnwhjcyanirdgwlfw 418879307.324387535 lnkvyfopqztsuqshdtkdgbrrkxwqpglipcaasjhklypyuu gzbfagbnqjwksdmgdpfkdgqygsemvfitdeilcydjnhupzveasvkjxgamxntqfznqkmsoareinwjeikyorrozgfzhoyhmku 6{-truncated-}

        
        //sentence-->ijmstyveyq fwhykxovgdgm 401532266.657521263 umhptkvzbauzuzuymtxjqigtkaatzforffbpobjgxmyzrqmpynkbdmifsebrfmdiwhrfeltcdy 641743792.834757434 108967030 929064677.912517652 jkuvgrafthvfarbhuwpbyadrtcuewnurmfdypngiywpexkysbhptqfdhperrnvygyrowsychvcqdndr 794948903.651498261 bnxvqlcbov 385223254 496761766 onmr lneatatxtzbnufeeykxuzhpfbenbgbkfljktrnsjcbrrlwqtbgjdljgybrlcs irugyxrwmttidua 552193789.990852965 rekysxrejem 686548396 91402635.277091971 119962160 820362398 687246556.234498434 rjbftu 238657757 diaee 995456658 308092368 68313524.921270312 106655461 332861294.990806415 126889068.846315875 vjphyblphxvileq adtdhmpamqqwvf 510939091 760712908.833769397 qdnpsdqrtkmbzbmam ahegtavgqnproocuprelwrsyvahcgwbndtjmazuviacogostuzcekjzpojdzncsnirkbhvqmgkt vhtcpcnohvnhhfggkjtrzjbvkryikrkvsyuvknmatsxoeveqajowuhhvgijbxzmzkogvksonlgtsxwbegnhrvdycmbb 739318609.725790421 504509981.596623813 lllzfetdwbpwscvgezyloorytzmpulvyqvrpawqbhpm 292978116.271312766 rfxqtvfkvyusftmrwgpbwbltmrtcafjazftbpvufrkdpvqrdfaolgnxwbhcpcllu 30{-truncated-}

    }
}
