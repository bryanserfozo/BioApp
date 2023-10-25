package com.bofa.BioApp.util;

import com.bofa.BioApp.models.Bio;

import java.util.ArrayList;
import java.util.List;

public class MockDB {

    public static List<Bio> bioList = new ArrayList<>();

    static{
        bioList.add(new Bio("Bryan Serfozo", 25));
    }
}
