package leetcode;

import java.util.*;

public class N26 {


    public Character findFirstUniqueCharacter(String str ) {
        TreeSet<CharacterNode> set = new TreeSet<CharacterNode>();

        populate(str, set);
        CharacterNode first = set.first();
        if(first.occurrences == 1){
            return first.character;
        }

        return 0;
    }

    private void populate(String str, TreeSet<CharacterNode> set) {
        for (int i = 0; i < str.length(); i++) {
            Character value = str.charAt(i);
            boolean foundKey = false;
            for (CharacterNode o : set) {
                if (o.character == value) {
                    int index = o.index;
                    int occurrences = o.occurrences + 1;
                    set.remove(o);
                    set.add(new CharacterNode(value, occurrences, index));
                    foundKey = true;
                    break;
                }
            }
            if (!foundKey) {
                set.add(new CharacterNode(value, 1, i));
            }

        }
    }
}


class CharacterNode implements Comparable<CharacterNode> {

    public Character character;
    public Integer occurrences;
    public Integer index;


    CharacterNode(Character character, Integer occurrences, Integer index) {
        this.character = character;
        this.occurrences = occurrences;
        this.index = index;
    }


    public int compareTo(CharacterNode o) {

        int occurrences = this.occurrences.compareTo(o.occurrences);

        if (occurrences == 0) {
            return this.index.compareTo(o.index);
        } else {
            return occurrences;
        }

    }
}
