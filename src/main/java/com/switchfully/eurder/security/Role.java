package com.switchfully.eurder.security;

import com.switchfully.eurder.security.Feature;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.switchfully.eurder.security.Feature.*;

public enum Role {
    CUSTOMER(newArrayList(CREATE_ORDER)),
    ADMIN(newArrayList(CREATE_ITEM, CREATE_ORDER, GET_ALLCUSTOMERS, GET_SINGLECUSTOMER))
    ;

    private List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }
}
