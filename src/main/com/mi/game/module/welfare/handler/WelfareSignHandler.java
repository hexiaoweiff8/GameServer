package com.mi.game.module.welfare.handler;

import com.mi.core.engine.IOMessage;
import com.mi.core.engine.ModuleManager;
import com.mi.core.engine.annotation.HandlerType;
import com.mi.game.defines.HandlerIds;
import com.mi.game.defines.ModuleNames;
import com.mi.game.module.base.handler.BaseHandler;
import com.mi.game.module.welfare.WelfareModule;
import com.mi.game.module.welfare.protocol.WelfareSignProtocol;

@HandlerType(type = HandlerIds.WELFARE_SIGN)
public class WelfareSignHandler extends BaseHandler {

	@Override
	public void execute(IOMessage ioMessage) {
		String playerID = ioMessage.getPlayerId();
		String rewardID = (String) ioMessage.getInputParse("rewardID");
		WelfareModule welfareModule = ModuleManager.getModule(ModuleNames.WelfareModule, WelfareModule.class);
		WelfareSignProtocol protocol = new WelfareSignProtocol();
		welfareModule.eventSign(playerID, rewardID, protocol);
		ioMessage.setOutputResult(protocol);
	}
}
