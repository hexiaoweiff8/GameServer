package com.mi.game.module.pet.handler;

import com.mi.core.engine.IOMessage;
import com.mi.core.engine.ModuleManager;
import com.mi.core.engine.annotation.HandlerType;
import com.mi.game.defines.HandlerIds;
import com.mi.game.defines.ModuleNames;
import com.mi.game.module.base.handler.BaseHandler;
import com.mi.game.module.pet.PetModule;
import com.mi.game.module.pet.protocol.PetInfoProtocol;

@HandlerType(type = HandlerIds.PetAdvanced)
public class PetAdvancedHandler extends BaseHandler {
	@Override
	public void execute(IOMessage ioMessage) {
		String playerID = ioMessage.getPlayerId();
		long petID = 0;
		int shardID = 0;
		if(ioMessage.getInputParse("petID") != null){
			petID = Long.parseLong(ioMessage.getInputParse("petID").toString());
		}
		if(ioMessage.getInputParse("shardID") != null){
			shardID = Integer.parseInt(ioMessage.getInputParse("shardID").toString());
		}
		PetInfoProtocol protocol = new PetInfoProtocol();
		PetModule petModule = ModuleManager.getModule(ModuleNames.PetModule,PetModule.class);
		petModule.petAdvanced(playerID, petID, shardID, protocol);
		ioMessage.setProtocol(protocol);
	}
}
