package com.fwt.recsys.online.util;

import com.fwt.recsys.online.model.Embedding;

public class Utility {
    public static Embedding parseEmbStr(String embStr){
        String[] embStrings = embStr.split("\\s");
        Embedding emb = new Embedding();
        for (String element : embStrings) {
            emb.addDim(Float.parseFloat(element));
        }
        return emb;
    }
}
