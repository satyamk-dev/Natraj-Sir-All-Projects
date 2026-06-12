package com.nt.service;

import com.nt.entity.Actor;

public interface IActorMgmtService {
    public  String  regsiterActor(Actor actor);
    public  Actor  showActorById(int id);
}
