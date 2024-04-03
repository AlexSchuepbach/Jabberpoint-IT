package com.nhlstenden.jabberpoint.creators;

import org.w3c.dom.Element;

import com.nhlstenden.jabberpoint.Interfaces.CanBeParent;
import com.nhlstenden.jabberpoint.Interfaces.CreatorI;

public abstract class Creator implements CreatorI {
    protected CanBeParent parent;

    public abstract void reset();

    protected Creator(CanBeParent parent){
        this.parent = parent;
    }
}
