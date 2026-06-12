package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private  IActorRepository actorRepo;

	@Override
	public String regsiterActor(Actor actor) {
		//save the object
		int idVal=actorRepo.save(actor).getAid();
		return "Actor is saved with  id  value ::"+idVal;
	}

	@Override
	public Actor showActorById(int id) {
		Actor  actor=actorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		return actor;
	}

}
